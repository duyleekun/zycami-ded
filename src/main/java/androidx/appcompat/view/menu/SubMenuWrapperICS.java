/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.core.internal.view.SupportSubMenu;

public class SubMenuWrapperICS
extends MenuWrapperICS
implements SubMenu {
    private final SupportSubMenu mSubMenu;

    public SubMenuWrapperICS(Context context, SupportSubMenu supportSubMenu) {
        super(context, supportSubMenu);
        this.mSubMenu = supportSubMenu;
    }

    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    public MenuItem getItem() {
        MenuItem menuItem = this.mSubMenu.getItem();
        return this.getMenuItemWrapper(menuItem);
    }

    public SubMenu setHeaderIcon(int n10) {
        this.mSubMenu.setHeaderIcon(n10);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable2) {
        this.mSubMenu.setHeaderIcon(drawable2);
        return this;
    }

    public SubMenu setHeaderTitle(int n10) {
        this.mSubMenu.setHeaderTitle(n10);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.mSubMenu.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.mSubMenu.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int n10) {
        this.mSubMenu.setIcon(n10);
        return this;
    }

    public SubMenu setIcon(Drawable drawable2) {
        this.mSubMenu.setIcon(drawable2);
        return this;
    }
}

