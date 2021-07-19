/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.SubMenu
 */
package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.internal.NavigationSubMenu;

public class NavigationMenu
extends MenuBuilder {
    public NavigationMenu(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl)this.addInternal(n10, n11, n12, charSequence);
        Context context = this.getContext();
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(context, this, menuItemImpl);
        menuItemImpl.setSubMenu(navigationSubMenu);
        return navigationSubMenu;
    }
}

