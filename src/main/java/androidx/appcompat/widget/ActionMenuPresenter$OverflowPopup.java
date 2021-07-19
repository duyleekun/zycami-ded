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
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.ActionMenuPresenter;

public class ActionMenuPresenter$OverflowPopup
extends MenuPopupHelper {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$OverflowPopup(ActionMenuPresenter object, Context context, MenuBuilder menuBuilder, View view, boolean bl2) {
        this.this$0 = object;
        int n10 = R$attr.actionOverflowMenuStyle;
        super(context, menuBuilder, view, bl2, n10);
        this.setGravity(0x800005);
        object = ((ActionMenuPresenter)object).mPopupPresenterCallback;
        this.setPresenterCallback((MenuPresenter$Callback)object);
    }

    public void onDismiss() {
        MenuBuilder menuBuilder = ActionMenuPresenter.access$000(this.this$0);
        if (menuBuilder != null) {
            menuBuilder = ActionMenuPresenter.access$100(this.this$0);
            menuBuilder.close();
        }
        this.this$0.mOverflowPopup = null;
        super.onDismiss();
    }
}

