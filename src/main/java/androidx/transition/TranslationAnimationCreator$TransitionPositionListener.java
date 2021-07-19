/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.transition.R$id;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;

public class TranslationAnimationCreator$TransitionPositionListener
extends AnimatorListenerAdapter
implements Transition$TransitionListener {
    private final View mMovingView;
    private float mPausedX;
    private float mPausedY;
    private final int mStartX;
    private final int mStartY;
    private final float mTerminalX;
    private final float mTerminalY;
    private int[] mTransitionPosition;
    private final View mViewInHierarchy;

    public TranslationAnimationCreator$TransitionPositionListener(View view, View view2, int n10, int n11, float f10, float f11) {
        this.mMovingView = view;
        this.mViewInHierarchy = view2;
        float f12 = view.getTranslationX();
        int n12 = Math.round(f12);
        this.mStartX = n10 -= n12;
        float f13 = view.getTranslationY();
        int n13 = Math.round(f13);
        this.mStartY = n11 -= n13;
        this.mTerminalX = f10;
        this.mTerminalY = f11;
        n13 = R$id.transition_position;
        int[] nArray = (int[])view2.getTag(n13);
        this.mTransitionPosition = nArray;
        if (nArray != null) {
            n10 = 0;
            nArray = null;
            view2.setTag(n13, null);
        }
    }

    public void onAnimationCancel(Animator object) {
        object = this.mTransitionPosition;
        if (object == null) {
            int n10 = 2;
            object = new int[n10];
            this.mTransitionPosition = (int[])object;
        }
        object = this.mTransitionPosition;
        float f10 = this.mStartX;
        float f11 = this.mMovingView.getTranslationX();
        int n11 = Math.round(f10 + f11);
        object[0] = (Animator)n11;
        object = this.mTransitionPosition;
        f10 = this.mStartY;
        f11 = this.mMovingView.getTranslationY();
        n11 = Math.round(f10 + f11);
        object[1] = (Animator)n11;
        object = this.mViewInHierarchy;
        int n12 = R$id.transition_position;
        int[] nArray = this.mTransitionPosition;
        object.setTag(n12, (Object)nArray);
    }

    public void onAnimationPause(Animator animator2) {
        float f10;
        this.mPausedX = f10 = this.mMovingView.getTranslationX();
        this.mPausedY = f10 = this.mMovingView.getTranslationY();
        animator2 = this.mMovingView;
        float f11 = this.mTerminalX;
        animator2.setTranslationX(f11);
        animator2 = this.mMovingView;
        f11 = this.mTerminalY;
        animator2.setTranslationY(f11);
    }

    public void onAnimationResume(Animator animator2) {
        animator2 = this.mMovingView;
        float f10 = this.mPausedX;
        animator2.setTranslationX(f10);
        animator2 = this.mMovingView;
        f10 = this.mPausedY;
        animator2.setTranslationY(f10);
    }

    public void onTransitionCancel(Transition transition) {
    }

    public void onTransitionEnd(Transition transition) {
        View view = this.mMovingView;
        float f10 = this.mTerminalX;
        view.setTranslationX(f10);
        view = this.mMovingView;
        f10 = this.mTerminalY;
        view.setTranslationY(f10);
        transition.removeListener(this);
    }

    public void onTransitionPause(Transition transition) {
    }

    public void onTransitionResume(Transition transition) {
    }

    public void onTransitionStart(Transition transition) {
    }
}

