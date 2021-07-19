/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;

public abstract class MenuPopup
implements ShowableListMenu,
MenuPresenter,
AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    public static int measureIndividualMenuWidth(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int n10) {
        int n11 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n12 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n13 = listAdapter.getCount();
        int n14 = 0;
        int n15 = 0;
        View view = null;
        for (int i10 = 0; i10 < n13; ++i10) {
            int n16 = listAdapter.getItemViewType(i10);
            if (n16 != n15) {
                view = null;
                n15 = n16;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i10, view, viewGroup);
            view.measure(n11, n12);
            n16 = view.getMeasuredWidth();
            if (n16 >= n10) {
                return n10;
            }
            if (n16 <= n14) continue;
            n14 = n16;
        }
        return n14;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder menuBuilder) {
        int n10 = menuBuilder.size();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuItem menuItem = menuBuilder.getItem(i10);
            boolean bl3 = menuItem.isVisible();
            if (!bl3 || (menuItem = menuItem.getIcon()) == null) continue;
            bl2 = true;
            break;
        }
        return bl2;
    }

    public static MenuAdapter toMenuAdapter(ListAdapter listAdapter) {
        boolean bl2 = listAdapter instanceof HeaderViewListAdapter;
        if (bl2) {
            return (MenuAdapter)((HeaderViewListAdapter)listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter)listAdapter;
    }

    public abstract void addMenu(MenuBuilder var1);

    public boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    public int getId() {
        return 0;
    }

    public MenuView getMenuView(ViewGroup object) {
        object = new UnsupportedOperationException("MenuPopups manage their own views");
        throw object;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
    }

    public void onItemClick(AdapterView adapterView, View object, int n10, long l10) {
        adapterView = (ListAdapter)adapterView.getAdapter();
        object = MenuPopup.toMenuAdapter((ListAdapter)adapterView).mAdapterMenu;
        adapterView = (MenuItem)adapterView.getItem(n10);
        n10 = (int)(this.closeMenuOnSubMenuOpened() ? 1 : 0);
        n10 = n10 != 0 ? 0 : 4;
        ((MenuBuilder)object).performItemAction((MenuItem)adapterView, this, n10);
    }

    public abstract void setAnchorView(View var1);

    public void setEpicenterBounds(Rect rect) {
        this.mEpicenterBounds = rect;
    }

    public abstract void setForceShowIcon(boolean var1);

    public abstract void setGravity(int var1);

    public abstract void setHorizontalOffset(int var1);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener var1);

    public abstract void setShowTitle(boolean var1);

    public abstract void setVerticalOffset(int var1);
}

