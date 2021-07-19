/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$6$1;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class AppCompatDelegateImpl$6
implements Runnable {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$6(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void run() {
        Object object = this.this$0;
        Object object2 = ((AppCompatDelegateImpl)object).mActionModePopup;
        object = ((AppCompatDelegateImpl)object).mActionModeView;
        int n10 = 55;
        object2.showAtLocation((View)object, n10, 0, 0);
        this.this$0.endOnGoingFadeAnimation();
        object = this.this$0;
        boolean bl2 = ((AppCompatDelegateImpl)object).shouldAnimateActionModeView();
        float f10 = 1.0f;
        if (bl2) {
            object = this.this$0.mActionModeView;
            n10 = 0;
            object.setAlpha(0.0f);
            object = this.this$0;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)((AppCompatDelegateImpl)object).mActionModeView);
            object2 = viewPropertyAnimatorCompat.alpha(f10);
            ((AppCompatDelegateImpl)object).mFadeAnim = object2;
            object = this.this$0.mFadeAnim;
            object2 = new AppCompatDelegateImpl$6$1(this);
            ((ViewPropertyAnimatorCompat)object).setListener((ViewPropertyAnimatorListener)object2);
        } else {
            this.this$0.mActionModeView.setAlpha(f10);
            object = this.this$0.mActionModeView;
            ((ActionBarContextView)((Object)object)).setVisibility(0);
        }
    }
}

