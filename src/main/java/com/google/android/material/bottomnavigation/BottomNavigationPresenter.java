/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  android.view.ViewGroup
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter$SavedState;

public class BottomNavigationPresenter
implements MenuPresenter {
    private int id;
    private MenuBuilder menu;
    private BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.id;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        return this.menuView;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
        this.menuView.initialize(menuBuilder);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof BottomNavigationPresenter$SavedState;
        if (bl2) {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            parcelable = (BottomNavigationPresenter$SavedState)parcelable;
            int n10 = parcelable.selectedItemId;
            bottomNavigationMenuView.tryRestoreSelectedItemId(n10);
        }
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        BottomNavigationPresenter$SavedState bottomNavigationPresenter$SavedState = new BottomNavigationPresenter$SavedState();
        bottomNavigationPresenter$SavedState.selectedItemId = n10 = this.menuView.getSelectedItemId();
        return bottomNavigationPresenter$SavedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void setBottomNavigationMenuView(BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setUpdateSuspended(boolean bl2) {
        this.updateSuspended = bl2;
    }

    public void updateMenuView(boolean bl2) {
        boolean bl3 = this.updateSuspended;
        if (bl3) {
            return;
        }
        if (bl2) {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            bottomNavigationMenuView.buildMenuView();
        } else {
            BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
            bottomNavigationMenuView.updateMenuView();
        }
    }
}

