/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class AppCompatDelegateImpl$7
extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$7(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onAnimationEnd(View view) {
        this.this$0.mActionModeView.setAlpha(1.0f);
        this.this$0.mFadeAnim.setListener(null);
        this.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View object) {
        this.this$0.mActionModeView.setVisibility(0);
        object = this.this$0.mActionModeView;
        int n10 = 32;
        object.sendAccessibilityEvent(n10);
        object = this.this$0.mActionModeView.getParent();
        boolean bl2 = object instanceof View;
        if (bl2) {
            object = (View)this.this$0.mActionModeView.getParent();
            ViewCompat.requestApplyInsets(object);
        }
    }
}

