/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter$MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;

public class ListMenuPresenter
implements MenuPresenter,
AdapterView.OnItemClickListener {
    private static final String TAG = "ListMenuPresenter";
    public static final String VIEWS_TAG = "android:menu:list";
    public ListMenuPresenter$MenuAdapter mAdapter;
    private MenuPresenter$Callback mCallback;
    public Context mContext;
    private int mId;
    public LayoutInflater mInflater;
    public int mItemIndexOffset;
    public int mItemLayoutRes;
    public MenuBuilder mMenu;
    public ExpandedMenuView mMenuView;
    public int mThemeRes;

    public ListMenuPresenter(int n10, int n11) {
        this.mItemLayoutRes = n10;
        this.mThemeRes = n11;
    }

    public ListMenuPresenter(Context context, int n10) {
        this(n10, 0);
        this.mContext = context;
        context = LayoutInflater.from((Context)context);
        this.mInflater = context;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public ListAdapter getAdapter() {
        ListMenuPresenter$MenuAdapter listMenuPresenter$MenuAdapter = this.mAdapter;
        if (listMenuPresenter$MenuAdapter == null) {
            this.mAdapter = listMenuPresenter$MenuAdapter = new ListMenuPresenter$MenuAdapter(this);
        }
        return this.mAdapter;
    }

    public int getId() {
        return this.mId;
    }

    public int getItemIndexOffset() {
        return this.mItemIndexOffset;
    }

    public MenuView getMenuView(ViewGroup object) {
        Object object2 = this.mMenuView;
        if (object2 == null) {
            object2 = this.mInflater;
            int n10 = R$layout.abc_expanded_menu_layout;
            object = (ExpandedMenuView)object2.inflate(n10, object, false);
            this.mMenuView = object;
            object = this.mAdapter;
            if (object == null) {
                object = new ListMenuPresenter$MenuAdapter(this);
                this.mAdapter = object;
            }
            object = this.mMenuView;
            object2 = this.mAdapter;
            object.setAdapter((ListAdapter)object2);
            object = this.mMenuView;
            object.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context object, MenuBuilder menuBuilder) {
        int n10 = this.mThemeRes;
        if (n10 != 0) {
            int n11 = this.mThemeRes;
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper((Context)object, n11);
            this.mContext = contextThemeWrapper;
            object = LayoutInflater.from((Context)contextThemeWrapper);
            this.mInflater = object;
        } else {
            Context context = this.mContext;
            if (context != null) {
                this.mContext = object;
                context = this.mInflater;
                if (context == null) {
                    object = LayoutInflater.from((Context)object);
                    this.mInflater = object;
                }
            }
        }
        this.mMenu = menuBuilder;
        object = this.mAdapter;
        if (object != null) {
            ((ListMenuPresenter$MenuAdapter)((Object)object)).notifyDataSetChanged();
        }
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        MenuPresenter$Callback menuPresenter$Callback = this.mCallback;
        if (menuPresenter$Callback != null) {
            menuPresenter$Callback.onCloseMenu(menuBuilder, bl2);
        }
    }

    public void onItemClick(AdapterView object, View object2, int n10, long l10) {
        object = this.mMenu;
        object2 = this.mAdapter.getItem(n10);
        ((MenuBuilder)object).performItemAction((MenuItem)object2, this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        parcelable = (Bundle)parcelable;
        this.restoreHierarchyState((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView == null) {
            return null;
        }
        expandedMenuView = new Bundle();
        this.saveHierarchyState((Bundle)expandedMenuView);
        return expandedMenuView;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl2 = subMenuBuilder.hasVisibleItems();
        if (!bl2) {
            return false;
        }
        MenuPresenter$Callback menuPresenter$Callback = new MenuDialogHelper(subMenuBuilder);
        ((MenuDialogHelper)menuPresenter$Callback).show(null);
        menuPresenter$Callback = this.mCallback;
        if (menuPresenter$Callback != null) {
            menuPresenter$Callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    public void restoreHierarchyState(Bundle bundle) {
        Object object = VIEWS_TAG;
        if ((bundle = bundle.getSparseParcelableArray((String)object)) != null) {
            object = this.mMenuView;
            object.restoreHierarchyState((SparseArray)bundle);
        }
    }

    public void saveHierarchyState(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray(VIEWS_TAG, sparseArray);
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mCallback = menuPresenter$Callback;
    }

    public void setId(int n10) {
        this.mId = n10;
    }

    public void setItemIndexOffset(int n10) {
        this.mItemIndexOffset = n10;
        ExpandedMenuView expandedMenuView = this.mMenuView;
        if (expandedMenuView != null) {
            n10 = 0;
            expandedMenuView = null;
            this.updateMenuView(false);
        }
    }

    public void updateMenuView(boolean bl2) {
        ListMenuPresenter$MenuAdapter listMenuPresenter$MenuAdapter = this.mAdapter;
        if (listMenuPresenter$MenuAdapter != null) {
            listMenuPresenter$MenuAdapter.notifyDataSetChanged();
        }
    }
}

