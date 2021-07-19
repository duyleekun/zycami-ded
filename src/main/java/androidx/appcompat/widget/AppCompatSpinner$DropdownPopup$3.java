/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup;

public class AppCompatSpinner$DropdownPopup$3
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener val$layoutListener;

    public AppCompatSpinner$DropdownPopup$3(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.this$1 = appCompatSpinner$DropdownPopup;
        this.val$layoutListener = onGlobalLayoutListener;
    }

    public void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.this$1.this$0.getViewTreeObserver();
        if (viewTreeObserver != null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.val$layoutListener;
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}

