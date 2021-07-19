/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.view.menu;

import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPopupHelper;

public class MenuPopupHelper$1
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ MenuPopupHelper this$0;

    public MenuPopupHelper$1(MenuPopupHelper menuPopupHelper) {
        this.this$0 = menuPopupHelper;
    }

    public void onDismiss() {
        this.this$0.onDismiss();
    }
}

