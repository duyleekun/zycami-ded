/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.AnimatorUtils$AnimatorPauseListenerCompat;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;

public class Visibility$DisappearListener
extends AnimatorListenerAdapter
implements Transition$TransitionListener,
AnimatorUtils$AnimatorPauseListenerCompat {
    public boolean mCanceled = false;
    private final int mFinalVisibility;
    private boolean mLayoutSuppressed;
    private final ViewGroup mParent;
    private final boolean mSuppressLayout;
    private final View mView;

    public Visibility$DisappearListener(View view, int n10, boolean bl2) {
        this.mView = view;
        this.mFinalVisibility = n10;
        view = (ViewGroup)view.getParent();
        this.mParent = view;
        this.mSuppressLayout = bl2;
        this.suppressLayout(true);
    }

    private void hideViewWhenNotCanceled() {
        boolean bl2 = this.mCanceled;
        if (!bl2) {
            View view = this.mView;
            int n10 = this.mFinalVisibility;
            ViewUtils.setTransitionVisibility(view, n10);
            view = this.mParent;
            if (view != null) {
                view.invalidate();
            }
        }
        this.suppressLayout(false);
    }

    private void suppressLayout(boolean bl2) {
        ViewGroup viewGroup;
        boolean bl3 = this.mSuppressLayout;
        if (bl3 && (bl3 = this.mLayoutSuppressed) != bl2 && (viewGroup = this.mParent) != null) {
            this.mLayoutSuppressed = bl2;
            ViewGroupUtils.suppressLayout(viewGroup, bl2);
        }
    }

    public void onAnimationCancel(Animator animator2) {
        this.mCanceled = true;
    }

    public void onAnimationEnd(Animator animator2) {
        this.hideViewWhenNotCanceled();
    }

    public void onAnimationPause(Animator animator2) {
        boolean bl2 = this.mCanceled;
        if (!bl2) {
            animator2 = this.mView;
            int n10 = this.mFinalVisibility;
            ViewUtils.setTransitionVisibility((View)animator2, n10);
        }
    }

    public void onAnimationRepeat(Animator animator2) {
    }

    public void onAnimationResume(Animator animator2) {
        boolean bl2 = this.mCanceled;
        if (!bl2) {
            animator2 = this.mView;
            ViewUtils.setTransitionVisibility((View)animator2, 0);
        }
    }

    public void onAnimationStart(Animator animator2) {
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        this.hideViewWhenNotCanceled();
        transition.removeListener(this);
    }

    public void onTransitionPause(Transition transition) {
        this.suppressLayout(false);
    }

    public void onTransitionResume(Transition transition) {
        this.suppressLayout(true);
    }

    public void onTransitionStart(Transition transition) {
    }
}

