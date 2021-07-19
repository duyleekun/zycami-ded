/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup;

public class AppCompatSpinner$DropdownPopup$2
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;

    public AppCompatSpinner$DropdownPopup$2(AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        this.this$1 = appCompatSpinner$DropdownPopup;
    }

    public void onGlobalLayout() {
        AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup = this.this$1;
        AppCompatSpinner appCompatSpinner = appCompatSpinner$DropdownPopup.this$0;
        boolean bl2 = appCompatSpinner$DropdownPopup.isVisibleToUser((View)appCompatSpinner);
        if (!bl2) {
            appCompatSpinner$DropdownPopup = this.this$1;
            appCompatSpinner$DropdownPopup.dismiss();
        } else {
            this.this$1.computeContentWidth();
            appCompatSpinner$DropdownPopup = this.this$1;
            AppCompatSpinner$DropdownPopup.access$001(appCompatSpinner$DropdownPopup);
        }
    }
}

