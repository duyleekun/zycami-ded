/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter$OpenOverflowRunnable;
import androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton;
import androidx.appcompat.widget.ActionMenuPresenter$OverflowPopup;
import androidx.appcompat.widget.ForwardingListener;

public class ActionMenuPresenter$OverflowMenuButton$1
extends ForwardingListener {
    public final /* synthetic */ ActionMenuPresenter$OverflowMenuButton this$1;
    public final /* synthetic */ ActionMenuPresenter val$this$0;

    public ActionMenuPresenter$OverflowMenuButton$1(ActionMenuPresenter$OverflowMenuButton overflowMenuButton, View view, ActionMenuPresenter actionMenuPresenter) {
        this.this$1 = overflowMenuButton;
        this.val$this$0 = actionMenuPresenter;
        super(view);
    }

    public ShowableListMenu getPopup() {
        ActionMenuPresenter$OverflowPopup actionMenuPresenter$OverflowPopup = this.this$1.this$0.mOverflowPopup;
        if (actionMenuPresenter$OverflowPopup == null) {
            return null;
        }
        return actionMenuPresenter$OverflowPopup.getPopup();
    }

    public boolean onForwardingStarted() {
        this.this$1.this$0.showOverflowMenu();
        return true;
    }

    public boolean onForwardingStopped() {
        ActionMenuPresenter actionMenuPresenter = this.this$1.this$0;
        ActionMenuPresenter$OpenOverflowRunnable actionMenuPresenter$OpenOverflowRunnable = actionMenuPresenter.mPostedOpenRunnable;
        if (actionMenuPresenter$OpenOverflowRunnable != null) {
            return false;
        }
        actionMenuPresenter.hideOverflowMenu();
        return true;
    }
}

