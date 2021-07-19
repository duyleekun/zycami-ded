/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.material.internal;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter;

public class NavigationMenuPresenter$1
implements View.OnClickListener {
    public final /* synthetic */ NavigationMenuPresenter this$0;

    public NavigationMenuPresenter$1(NavigationMenuPresenter navigationMenuPresenter) {
        this.this$0 = navigationMenuPresenter;
    }

    public void onClick(View object) {
        object = (NavigationMenuItemView)object;
        Object object2 = this.this$0;
        boolean bl2 = true;
        ((NavigationMenuPresenter)object2).setUpdateSuspended(bl2);
        object = ((NavigationMenuItemView)object).getItemData();
        object2 = this.this$0;
        MenuBuilder menuBuilder = ((NavigationMenuPresenter)object2).menu;
        boolean bl3 = menuBuilder.performItemAction((MenuItem)object, (MenuPresenter)object2, 0);
        if (object != null && (bl2 = ((MenuItemImpl)object).isCheckable()) && bl3) {
            object2 = this.this$0.adapter;
            ((NavigationMenuPresenter$NavigationMenuAdapter)object2).setCheckedItem((MenuItemImpl)object);
        }
        this.this$0.setUpdateSuspended(false);
        this.this$0.updateMenuView(false);
    }
}

