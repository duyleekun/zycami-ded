/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.view.menu;

import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.appcompat.widget.ListPopupWindow;

public class StandardMenuPopup$1
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ StandardMenuPopup this$0;

    public StandardMenuPopup$1(StandardMenuPopup standardMenuPopup) {
        this.this$0 = standardMenuPopup;
    }

    public void onGlobalLayout() {
        ShowableListMenu showableListMenu = this.this$0;
        boolean bl2 = ((StandardMenuPopup)showableListMenu).isShowing();
        if (bl2 && !(bl2 = ((ListPopupWindow)(showableListMenu = this.this$0.mPopup)).isModal())) {
            showableListMenu = this.this$0.mShownAnchorView;
            if (showableListMenu != null && (bl2 = showableListMenu.isShown())) {
                showableListMenu = this.this$0.mPopup;
                ((ListPopupWindow)showableListMenu).show();
            } else {
                showableListMenu = this.this$0;
                ((StandardMenuPopup)showableListMenu).dismiss();
            }
        }
    }
}

