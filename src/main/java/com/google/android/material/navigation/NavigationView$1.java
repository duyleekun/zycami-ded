/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package com.google.android.material.navigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import com.google.android.material.navigation.NavigationView;

public class NavigationView$1
implements MenuBuilder$Callback {
    public final /* synthetic */ NavigationView this$0;

    public NavigationView$1(NavigationView navigationView) {
        this.this$0 = navigationView;
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        boolean bl2;
        object = this.this$0.listener;
        if (object != null && (bl2 = object.onNavigationItemSelected(menuItem))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}

