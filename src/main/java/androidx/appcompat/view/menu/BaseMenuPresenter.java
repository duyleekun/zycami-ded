/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import java.util.ArrayList;

public abstract class BaseMenuPresenter
implements MenuPresenter {
    private MenuPresenter$Callback mCallback;
    public Context mContext;
    private int mId;
    public LayoutInflater mInflater;
    private int mItemLayoutRes;
    public MenuBuilder mMenu;
    private int mMenuLayoutRes;
    public MenuView mMenuView;
    public Context mSystemContext;
    public LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context context, int n10, int n11) {
        this.mSystemContext = context;
        context = LayoutInflater.from((Context)context);
        this.mSystemInflater = context;
        this.mMenuLayoutRes = n10;
        this.mItemLayoutRes = n11;
    }

    public void addItemView(View view, int n10) {
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.mMenuView).addView(view, n10);
    }

    public abstract void bindItemView(MenuItemImpl var1, MenuView$ItemView var2);

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public MenuView$ItemView createItemView(ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.mSystemInflater;
        int n10 = this.mItemLayoutRes;
        return (MenuView$ItemView)layoutInflater.inflate(n10, viewGroup, false);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int n10) {
        viewGroup.removeViewAt(n10);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuPresenter$Callback getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View object, ViewGroup viewGroup) {
        boolean bl2 = object instanceof MenuView$ItemView;
        object = bl2 ? (MenuView$ItemView)object : this.createItemView(viewGroup);
        this.bindItemView(menuItemImpl, (MenuView$ItemView)object);
        return object;
    }

    public MenuView getMenuView(ViewGroup object) {
        Object object2 = this.mMenuView;
        if (object2 == null) {
            object2 = this.mSystemInflater;
            int n10 = this.mMenuLayoutRes;
            object = (MenuView)object2.inflate(n10, (ViewGroup)object, false);
            this.mMenuView = object;
            object2 = this.mMenu;
            object.initialize((MenuBuilder)object2);
            boolean bl2 = true;
            this.updateMenuView(bl2);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        context = LayoutInflater.from((Context)context);
        this.mInflater = context;
        this.mMenu = menuBuilder;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        MenuPresenter$Callback menuPresenter$Callback = this.mCallback;
        if (menuPresenter$Callback != null) {
            menuPresenter$Callback.onCloseMenu(menuBuilder, bl2);
        }
    }

    public boolean onSubMenuSelected(SubMenuBuilder menuBuilder) {
        MenuPresenter$Callback menuPresenter$Callback = this.mCallback;
        if (menuPresenter$Callback != null) {
            if (menuBuilder == null) {
                menuBuilder = this.mMenu;
            }
            return menuPresenter$Callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mCallback = menuPresenter$Callback;
    }

    public void setId(int n10) {
        this.mId = n10;
    }

    public boolean shouldIncludeItem(int n10, MenuItemImpl menuItemImpl) {
        return true;
    }

    public void updateMenuView(boolean bl2) {
        int n10;
        ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return;
        }
        Object object = this.mMenu;
        int n11 = 0;
        if (object != null) {
            ((MenuBuilder)object).flagActionItems();
            object = this.mMenu.getVisibleItems();
            int n12 = ((ArrayList)object).size();
            int n13 = 0;
            for (int i10 = 0; i10 < n12; ++i10) {
                Object object2;
                MenuItemImpl menuItemImpl = (MenuItemImpl)((ArrayList)object).get(i10);
                boolean bl3 = this.shouldIncludeItem(n13, menuItemImpl);
                if (!bl3) continue;
                View view = viewGroup.getChildAt(n13);
                boolean bl4 = view instanceof MenuView$ItemView;
                if (bl4) {
                    object2 = view;
                    object2 = ((MenuView$ItemView)view).getItemData();
                } else {
                    bl4 = false;
                    object2 = null;
                }
                View view2 = this.getItemView(menuItemImpl, view, viewGroup);
                if (menuItemImpl != object2) {
                    view2.setPressed(false);
                    view2.jumpDrawablesToCurrentState();
                }
                if (view2 != view) {
                    this.addItemView(view2, n13);
                }
                ++n13;
            }
            n11 = n13;
        }
        while (n11 < (n10 = viewGroup.getChildCount())) {
            n10 = (int)(this.filterLeftoverView(viewGroup, n11) ? 1 : 0);
            if (n10 != 0) continue;
            ++n11;
        }
    }
}

