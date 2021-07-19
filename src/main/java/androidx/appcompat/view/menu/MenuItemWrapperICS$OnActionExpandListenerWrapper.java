/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;

public class MenuItemWrapperICS$OnActionExpandListenerWrapper
implements MenuItem.OnActionExpandListener {
    private final MenuItem.OnActionExpandListener mObject;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$OnActionExpandListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = onActionExpandListener;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        MenuItem.OnActionExpandListener onActionExpandListener = this.mObject;
        menuItem = this.this$0.getMenuItemWrapper(menuItem);
        return onActionExpandListener.onMenuItemActionCollapse(menuItem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        MenuItem.OnActionExpandListener onActionExpandListener = this.mObject;
        menuItem = this.this$0.getMenuItemWrapper(menuItem);
        return onActionExpandListener.onMenuItemActionExpand(menuItem);
    }
}

