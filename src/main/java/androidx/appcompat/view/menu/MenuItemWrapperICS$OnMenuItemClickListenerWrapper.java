/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuItemWrapperICS;

public class MenuItemWrapperICS$OnMenuItemClickListenerWrapper
implements MenuItem.OnMenuItemClickListener {
    private final MenuItem.OnMenuItemClickListener mObject;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$OnMenuItemClickListenerWrapper(MenuItemWrapperICS menuItemWrapperICS, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.this$0 = menuItemWrapperICS;
        this.mObject = onMenuItemClickListener;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mObject;
        menuItem = this.this$0.getMenuItemWrapper(menuItem);
        return onMenuItemClickListener.onMenuItemClick(menuItem);
    }
}

