/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionProvider
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;

public class MenuItemWrapperICS$ActionProviderWrapper
extends ActionProvider {
    public final android.view.ActionProvider mInner;
    public final /* synthetic */ MenuItemWrapperICS this$0;

    public MenuItemWrapperICS$ActionProviderWrapper(MenuItemWrapperICS menuItemWrapperICS, Context context, android.view.ActionProvider actionProvider) {
        this.this$0 = menuItemWrapperICS;
        super(context);
        this.mInner = actionProvider;
    }

    public boolean hasSubMenu() {
        return this.mInner.hasSubMenu();
    }

    public View onCreateActionView() {
        return this.mInner.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return this.mInner.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        android.view.ActionProvider actionProvider = this.mInner;
        subMenu = this.this$0.getSubMenuWrapper(subMenu);
        actionProvider.onPrepareSubMenu(subMenu);
    }
}

