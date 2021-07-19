/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

public final class BottomNavigationMenu
extends MenuBuilder {
    public static final int MAX_ITEM_COUNT = 5;

    public BottomNavigationMenu(Context context) {
        super(context);
    }

    public MenuItem addInternal(int n10, int n11, int n12, CharSequence charSequence) {
        int n13 = this.size();
        int n14 = 1;
        int n15 = 5;
        if ((n13 += n14) <= n15) {
            this.stopDispatchingItemsChanged();
            MenuItem menuItem = super.addInternal(n10, n11, n12, charSequence);
            n11 = menuItem instanceof MenuItemImpl;
            if (n11 != 0) {
                MenuItem menuItem2 = menuItem;
                menuItem2 = (MenuItemImpl)menuItem;
                menuItem2.setExclusiveCheckable(n14 != 0);
            }
            this.startDispatchingItemsChanged();
            return menuItem;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
        throw illegalArgumentException;
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, CharSequence charSequence) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("BottomNavigationView does not support submenus");
        throw unsupportedOperationException;
    }
}

