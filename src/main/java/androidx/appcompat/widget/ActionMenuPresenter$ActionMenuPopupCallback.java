/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;

public class ActionMenuPresenter$ActionMenuPopupCallback
extends ActionMenuItemView$PopupCallback {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$ActionMenuPopupCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    public ShowableListMenu getPopup() {
        Object object = this.this$0.mActionButtonPopup;
        object = object != null ? ((MenuPopupHelper)object).getPopup() : null;
        return object;
    }
}

