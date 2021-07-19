/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1
extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl$ActionModeCallbackWrapperV9 this$1;

    public AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1(AppCompatDelegateImpl$ActionModeCallbackWrapperV9 appCompatDelegateImpl$ActionModeCallbackWrapperV9) {
        this.this$1 = appCompatDelegateImpl$ActionModeCallbackWrapperV9;
    }

    public void onAnimationEnd(View object) {
        object = this.this$1.this$0.mActionModeView;
        int n10 = 8;
        ((ActionBarContextView)((Object)object)).setVisibility(n10);
        object = this.this$1.this$0;
        PopupWindow popupWindow = ((AppCompatDelegateImpl)object).mActionModePopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
        } else {
            object = ((AppCompatDelegateImpl)object).mActionModeView.getParent();
            boolean bl2 = object instanceof View;
            if (bl2) {
                object = (View)this.this$1.this$0.mActionModeView.getParent();
                ViewCompat.requestApplyInsets((View)object);
            }
        }
        this.this$1.this$0.mActionModeView.killMode();
        this.this$1.this$0.mFadeAnim.setListener(null);
        object = this.this$1.this$0;
        ((AppCompatDelegateImpl)object).mFadeAnim = null;
        ViewCompat.requestApplyInsets((View)((AppCompatDelegateImpl)object).mSubDecor);
    }
}

