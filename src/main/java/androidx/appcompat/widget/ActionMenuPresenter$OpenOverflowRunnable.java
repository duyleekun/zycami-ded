/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter$OverflowPopup;

public class ActionMenuPresenter$OpenOverflowRunnable
implements Runnable {
    private ActionMenuPresenter$OverflowPopup mPopup;
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, ActionMenuPresenter$OverflowPopup overflowPopup) {
        this.this$0 = actionMenuPresenter;
        this.mPopup = overflowPopup;
    }

    public void run() {
        boolean bl2;
        Object object = ActionMenuPresenter.access$400(this.this$0);
        if (object != null) {
            object = ActionMenuPresenter.access$500(this.this$0);
            ((MenuBuilder)object).changeMenuMode();
        }
        if ((object = (View)ActionMenuPresenter.access$600(this.this$0)) != null && (object = object.getWindowToken()) != null && (bl2 = ((MenuPopupHelper)(object = this.mPopup)).tryShow())) {
            ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup;
            object = this.this$0;
            ((ActionMenuPresenter)object).mOverflowPopup = actionMenuPresenter$OverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}

