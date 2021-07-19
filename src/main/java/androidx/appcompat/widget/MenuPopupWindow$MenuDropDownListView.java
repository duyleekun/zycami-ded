/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.MotionEvent
 *  android.view.View
 *  android.widget.HeaderViewListAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuItemHoverListener;

public class MenuPopupWindow$MenuDropDownListView
extends DropDownListView {
    public final int mAdvanceKey;
    private MenuItemHoverListener mHoverListener;
    private MenuItem mHoveredMenuItem;
    public final int mRetreatKey;

    public MenuPopupWindow$MenuDropDownListView(Context context, boolean n10) {
        super(context, n10 != 0);
        int n11;
        context = context.getResources().getConfiguration();
        n10 = Build.VERSION.SDK_INT;
        int n12 = 21;
        int n13 = 22;
        int n14 = 17;
        if (n10 >= n14 && (n10 = 1) == (n11 = context.getLayoutDirection())) {
            this.mAdvanceKey = n12;
            this.mRetreatKey = n13;
        } else {
            this.mAdvanceKey = n13;
            this.mRetreatKey = n12;
        }
    }

    public void clearSelection() {
        this.setSelection(-1);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        Object object = this.mHoverListener;
        if (object != null) {
            Object object2;
            object = this.getAdapter();
            int n10 = object instanceof HeaderViewListAdapter;
            if (n10 != 0) {
                object = (HeaderViewListAdapter)object;
                n10 = object.getHeadersCount();
                object = (MenuAdapter)object.getWrappedAdapter();
            } else {
                n10 = 0;
                object2 = null;
                object = (MenuAdapter)((Object)object);
            }
            MenuItemImpl menuItemImpl = null;
            int n11 = motionEvent.getAction();
            int n12 = 10;
            if (n11 != n12) {
                float f10 = motionEvent.getX();
                n11 = (int)f10;
                n12 = (int)motionEvent.getY();
                if ((n11 = this.pointToPosition(n11, n12)) != (n12 = -1) && (n11 -= n10) >= 0 && n11 < (n10 = ((MenuAdapter)((Object)object)).getCount())) {
                    menuItemImpl = ((MenuAdapter)((Object)object)).getItem(n11);
                }
            }
            if ((object2 = this.mHoveredMenuItem) != menuItemImpl) {
                object = ((MenuAdapter)((Object)object)).getAdapterMenu();
                if (object2 != null) {
                    MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
                    menuItemHoverListener.onItemHoverExit((MenuBuilder)object, (MenuItem)object2);
                }
                this.mHoveredMenuItem = menuItemImpl;
                if (menuItemImpl != null) {
                    object2 = this.mHoverListener;
                    object2.onItemHoverEnter((MenuBuilder)object, menuItemImpl);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        int n11;
        int n12;
        ListMenuItemView listMenuItemView = (ListMenuItemView)this.getSelectedView();
        boolean bl2 = true;
        if (listMenuItemView != null && n10 == (n12 = this.mAdvanceKey)) {
            MenuItemImpl menuItemImpl;
            n10 = (int)(listMenuItemView.isEnabled() ? 1 : 0);
            if (n10 != 0 && (n10 = (int)((menuItemImpl = listMenuItemView.getItemData()).hasSubMenu() ? 1 : 0)) != 0) {
                n10 = this.getSelectedItemPosition();
                long l10 = this.getSelectedItemId();
                this.performItemClick((View)listMenuItemView, n10, l10);
            }
            return bl2;
        }
        if (listMenuItemView != null && n10 == (n11 = this.mRetreatKey)) {
            n10 = -1;
            this.setSelection(n10);
            Object object = this.getAdapter();
            boolean bl3 = object instanceof HeaderViewListAdapter;
            object = bl3 ? (MenuAdapter)((HeaderViewListAdapter)object).getWrappedAdapter() : (MenuAdapter)((Object)object);
            object.getAdapterMenu().close(false);
            return bl2;
        }
        return super.onKeyDown(n10, keyEvent);
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }
}

