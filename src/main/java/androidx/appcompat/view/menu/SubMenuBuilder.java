/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuItemImpl;

public class SubMenuBuilder
extends MenuBuilder
implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.mParentMenu = menuBuilder;
        this.mItem = menuItemImpl;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.collapseItemActionView(menuItemImpl);
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuBuilder menuBuilder2;
        boolean bl2;
        boolean bl3 = super.dispatchMenuItemSelected(menuBuilder, menuItem);
        if (!bl3 && !(bl2 = (menuBuilder2 = this.mParentMenu).dispatchMenuItemSelected(menuBuilder, menuItem))) {
            bl2 = false;
            menuBuilder = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return this.mParentMenu.expandItemActionView(menuItemImpl);
    }

    public String getActionViewStatesKey() {
        int n10;
        MenuItemImpl menuItemImpl = this.mItem;
        if (menuItemImpl != null) {
            n10 = menuItemImpl.getItemId();
        } else {
            n10 = 0;
            menuItemImpl = null;
        }
        if (n10 == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.getActionViewStatesKey();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(MenuBuilder$Callback menuBuilder$Callback) {
        this.mParentMenu.setCallback(menuBuilder$Callback);
    }

    public void setGroupDividerEnabled(boolean bl2) {
        this.mParentMenu.setGroupDividerEnabled(bl2);
    }

    public SubMenu setHeaderIcon(int n10) {
        return (SubMenu)super.setHeaderIconInt(n10);
    }

    public SubMenu setHeaderIcon(Drawable drawable2) {
        return (SubMenu)super.setHeaderIconInt(drawable2);
    }

    public SubMenu setHeaderTitle(int n10) {
        return (SubMenu)super.setHeaderTitleInt(n10);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu)super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu)super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(int n10) {
        this.mItem.setIcon(n10);
        return this;
    }

    public SubMenu setIcon(Drawable drawable2) {
        this.mItem.setIcon(drawable2);
        return this;
    }

    public void setQwertyMode(boolean bl2) {
        this.mParentMenu.setQwertyMode(bl2);
    }

    public void setShortcutsVisible(boolean bl2) {
        this.mParentMenu.setShortcutsVisible(bl2);
    }
}

