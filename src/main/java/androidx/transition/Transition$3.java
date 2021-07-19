/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.transition.Transition;

public class Transition$3
extends AnimatorListenerAdapter {
    public final /* synthetic */ Transition this$0;

    public Transition$3(Transition transition) {
        this.this$0 = transition;
    }

    public void onAnimationEnd(Animator animator2) {
        this.this$0.end();
        animator2.removeListener((Animator.AnimatorListener)this);
    }
}

