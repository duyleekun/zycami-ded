/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.ViewPropertyAnimator
 */
package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import androidx.appcompat.widget.ActionBarOverlayLayout;

public class ActionBarOverlayLayout$2
implements Runnable {
    public final /* synthetic */ ActionBarOverlayLayout this$0;

    public ActionBarOverlayLayout$2(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.this$0 = actionBarOverlayLayout;
    }

    public void run() {
        this.this$0.haltActionBarHideOffsetAnimations();
        ActionBarOverlayLayout actionBarOverlayLayout = this.this$0;
        ViewPropertyAnimator viewPropertyAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(0.0f);
        AnimatorListenerAdapter animatorListenerAdapter = this.this$0.mTopAnimatorListener;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = viewPropertyAnimator = viewPropertyAnimator.setListener((Animator.AnimatorListener)animatorListenerAdapter);
    }
}

