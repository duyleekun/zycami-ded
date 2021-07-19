/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl$6;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

public class AppCompatDelegateImpl$6$1
extends ViewPropertyAnimatorListenerAdapter {
    public final /* synthetic */ AppCompatDelegateImpl$6 this$1;

    public AppCompatDelegateImpl$6$1(AppCompatDelegateImpl$6 appCompatDelegateImpl$6) {
        this.this$1 = appCompatDelegateImpl$6;
    }

    public void onAnimationEnd(View view) {
        this.this$1.this$0.mActionModeView.setAlpha(1.0f);
        this.this$1.this$0.mFadeAnim.setListener(null);
        this.this$1.this$0.mFadeAnim = null;
    }

    public void onAnimationStart(View view) {
        this.this$1.this$0.mActionModeView.setVisibility(0);
    }
}

