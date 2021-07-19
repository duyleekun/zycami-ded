/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.material.bottomnavigation;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;

public class BottomNavigationMenuView$1
implements View.OnClickListener {
    public final /* synthetic */ BottomNavigationMenuView this$0;

    public BottomNavigationMenuView$1(BottomNavigationMenuView bottomNavigationMenuView) {
        this.this$0 = bottomNavigationMenuView;
    }

    public void onClick(View object) {
        BottomNavigationPresenter bottomNavigationPresenter;
        object = ((BottomNavigationItemView)object).getItemData();
        MenuBuilder menuBuilder = BottomNavigationMenuView.access$100(this.this$0);
        boolean bl2 = menuBuilder.performItemAction((MenuItem)object, bottomNavigationPresenter = BottomNavigationMenuView.access$000(this.this$0), 0);
        if (!bl2) {
            bl2 = true;
            object.setChecked(bl2);
        }
    }
}

