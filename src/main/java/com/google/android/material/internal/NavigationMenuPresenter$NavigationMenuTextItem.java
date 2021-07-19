/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.internal;

import androidx.appcompat.view.menu.MenuItemImpl;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem;

public class NavigationMenuPresenter$NavigationMenuTextItem
implements NavigationMenuPresenter$NavigationMenuItem {
    private final MenuItemImpl menuItem;
    public boolean needsEmptyIcon;

    public NavigationMenuPresenter$NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
        this.menuItem = menuItemImpl;
    }

    public MenuItemImpl getMenuItem() {
        return this.menuItem;
    }
}

