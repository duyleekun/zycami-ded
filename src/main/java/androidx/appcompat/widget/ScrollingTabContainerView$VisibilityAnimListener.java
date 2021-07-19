/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.ViewPropertyAnimator
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.ScrollingTabContainerView;

public class ScrollingTabContainerView$VisibilityAnimListener
extends AnimatorListenerAdapter {
    private boolean mCanceled = false;
    private int mFinalVisibility;
    public final /* synthetic */ ScrollingTabContainerView this$0;

    public ScrollingTabContainerView$VisibilityAnimListener(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    public void onAnimationCancel(Animator animator2) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator object) {
        boolean bl2 = this.mCanceled;
        if (bl2) {
            return;
        }
        object = this.this$0;
        object.mVisibilityAnim = null;
        int n10 = this.mFinalVisibility;
        object.setVisibility(n10);
    }

    public void onAnimationStart(Animator animator2) {
        this.this$0.setVisibility(0);
        this.mCanceled = false;
    }

    public ScrollingTabContainerView$VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator viewPropertyAnimator, int n10) {
        this.mFinalVisibility = n10;
        this.this$0.mVisibilityAnim = viewPropertyAnimator;
        return this;
    }
}

