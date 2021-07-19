/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import java.util.ArrayList;

public class AnimatedVectorDrawableCompat$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ AnimatedVectorDrawableCompat this$0;

    public AnimatedVectorDrawableCompat$2(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    public void onAnimationEnd(Animator object) {
        ArrayList arrayList = this.this$0.mAnimationCallbacks;
        object = new ArrayList(arrayList);
        int n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = (Animatable2Compat$AnimationCallback)((ArrayList)object).get(i10);
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.this$0;
            animatable2Compat$AnimationCallback.onAnimationEnd(animatedVectorDrawableCompat);
        }
    }

    public void onAnimationStart(Animator object) {
        ArrayList arrayList = this.this$0.mAnimationCallbacks;
        object = new ArrayList(arrayList);
        int n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = (Animatable2Compat$AnimationCallback)((ArrayList)object).get(i10);
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.this$0;
            animatable2Compat$AnimationCallback.onAnimationStart(animatedVectorDrawableCompat);
        }
    }
}

