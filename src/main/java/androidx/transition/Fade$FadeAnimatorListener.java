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
import androidx.core.view.ViewCompat;
import androidx.transition.ViewUtils;

public class Fade$FadeAnimatorListener
extends AnimatorListenerAdapter {
    private boolean mLayerTypeChanged = false;
    private final View mView;

    public Fade$FadeAnimatorListener(View view) {
        this.mView = view;
    }

    public void onAnimationEnd(Animator animator2) {
        animator2 = this.mView;
        float f10 = 1.0f;
        ViewUtils.setTransitionAlpha((View)animator2, f10);
        boolean bl2 = this.mLayerTypeChanged;
        if (bl2) {
            animator2 = this.mView;
            f10 = 0.0f;
            animator2.setLayerType(0, null);
        }
    }

    public void onAnimationStart(Animator animator2) {
        animator2 = this.mView;
        int n10 = ViewCompat.hasOverlappingRendering((View)animator2);
        if (n10 != 0 && (n10 = (animator2 = this.mView).getLayerType()) == 0) {
            n10 = 1;
            this.mLayerTypeChanged = n10;
            animator2 = this.mView;
            int n11 = 2;
            animator2.setLayerType(n11, null);
        }
    }
}

