/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.collection.ArrayMap;
import androidx.transition.Transition;

public class Transition$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ Transition this$0;
    public final /* synthetic */ ArrayMap val$runningAnimators;

    public Transition$2(Transition transition, ArrayMap arrayMap) {
        this.this$0 = transition;
        this.val$runningAnimators = arrayMap;
    }

    public void onAnimationEnd(Animator animator2) {
        this.val$runningAnimators.remove(animator2);
        this.this$0.mCurrentAnimators.remove(animator2);
    }

    public void onAnimationStart(Animator animator2) {
        this.this$0.mCurrentAnimators.add(animator2);
    }
}

