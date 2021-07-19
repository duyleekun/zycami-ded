/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ActionProvider$VisibilityListener;

public class MenuItemImpl$1
implements ActionProvider$VisibilityListener {
    public final /* synthetic */ MenuItemImpl this$0;

    public MenuItemImpl$1(MenuItemImpl menuItemImpl) {
        this.this$0 = menuItemImpl;
    }

    public void onActionProviderVisibilityChanged(boolean bl2) {
        MenuItemImpl menuItemImpl = this.this$0;
        menuItemImpl.mMenu.onItemVisibleChanged(menuItemImpl);
    }
}

