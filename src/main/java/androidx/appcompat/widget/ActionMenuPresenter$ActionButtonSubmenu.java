/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;

public class ActionMenuPresenter$ActionButtonSubmenu
extends MenuPopupHelper {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$ActionButtonSubmenu(ActionMenuPresenter object, Context object2, SubMenuBuilder subMenuBuilder, View view) {
        this.this$0 = object;
        int n10 = R$attr.actionOverflowMenuStyle;
        super((Context)object2, subMenuBuilder, view, false, n10);
        object2 = (MenuItemImpl)subMenuBuilder.getItem();
        boolean bl2 = ((MenuItemImpl)object2).isActionButton();
        if (!bl2) {
            object2 = ((ActionMenuPresenter)object).mOverflowButton;
            if (object2 == null) {
                object2 = (View)ActionMenuPresenter.access$200((ActionMenuPresenter)object);
            }
            this.setAnchorView((View)object2);
        }
        object = ((ActionMenuPresenter)object).mPopupPresenterCallback;
        this.setPresenterCallback((MenuPresenter$Callback)object);
    }

    public void onDismiss() {
        ActionMenuPresenter actionMenuPresenter = this.this$0;
        actionMenuPresenter.mActionButtonPopup = null;
        actionMenuPresenter.mOpenSubMenuId = 0;
        super.onDismiss();
    }
}

