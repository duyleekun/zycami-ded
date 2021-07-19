/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.MenuBuilder$ItemInvoker;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ForwardingListener;

public class ActionMenuItemView$ActionMenuItemForwardingListener
extends ForwardingListener {
    public final /* synthetic */ ActionMenuItemView this$0;

    public ActionMenuItemView$ActionMenuItemForwardingListener(ActionMenuItemView actionMenuItemView) {
        this.this$0 = actionMenuItemView;
        super((View)actionMenuItemView);
    }

    public ShowableListMenu getPopup() {
        ActionMenuItemView$PopupCallback actionMenuItemView$PopupCallback = this.this$0.mPopupCallback;
        if (actionMenuItemView$PopupCallback != null) {
            return actionMenuItemView$PopupCallback.getPopup();
        }
        return null;
    }

    public boolean onForwardingStarted() {
        boolean bl2;
        Object object = this.this$0;
        MenuBuilder$ItemInvoker menuBuilder$ItemInvoker = ((ActionMenuItemView)object).mItemInvoker;
        boolean bl3 = false;
        if (menuBuilder$ItemInvoker != null && (bl2 = menuBuilder$ItemInvoker.invokeItem((MenuItemImpl)(object = ((ActionMenuItemView)object).mItemData))) && (object = this.getPopup()) != null && (bl2 = object.isShowing())) {
            bl3 = true;
        }
        return bl3;
    }
}

