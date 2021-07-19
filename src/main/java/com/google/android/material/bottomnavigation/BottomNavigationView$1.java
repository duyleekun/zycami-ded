/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigationView$1
implements MenuBuilder$Callback {
    public final /* synthetic */ BottomNavigationView this$0;

    public BottomNavigationView$1(BottomNavigationView bottomNavigationView) {
        this.this$0 = bottomNavigationView;
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        BottomNavigationView bottomNavigationView;
        int n10;
        int n11;
        object = BottomNavigationView.access$000(this.this$0);
        boolean bl2 = true;
        if (object != null && (n11 = menuItem.getItemId()) == (n10 = (bottomNavigationView = this.this$0).getSelectedItemId())) {
            BottomNavigationView.access$000(this.this$0).onNavigationItemReselected(menuItem);
            return bl2;
        }
        object = BottomNavigationView.access$100(this.this$0);
        if (object == null || (n11 = (int)((object = BottomNavigationView.access$100(this.this$0)).onNavigationItemSelected(menuItem) ? 1 : 0)) != 0) {
            bl2 = false;
        }
        return bl2;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}

