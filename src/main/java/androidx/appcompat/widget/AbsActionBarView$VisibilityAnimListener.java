/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class AbsActionBarView$VisibilityAnimListener
implements ViewPropertyAnimatorListener {
    private boolean mCanceled = false;
    public int mFinalVisibility;
    public final /* synthetic */ AbsActionBarView this$0;

    public AbsActionBarView$VisibilityAnimListener(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    public void onAnimationCancel(View view) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(View object) {
        boolean bl2 = this.mCanceled;
        if (bl2) {
            return;
        }
        object = this.this$0;
        object.mVisibilityAnim = null;
        int n10 = this.mFinalVisibility;
        AbsActionBarView.access$101((AbsActionBarView)((Object)object), n10);
    }

    public void onAnimationStart(View view) {
        AbsActionBarView.access$001(this.this$0, 0);
        this.mCanceled = false;
    }

    public AbsActionBarView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int n10) {
        this.this$0.mVisibilityAnim = viewPropertyAnimatorCompat;
        this.mFinalVisibility = n10;
        return this;
    }
}

