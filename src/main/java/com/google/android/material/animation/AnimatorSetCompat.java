/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.Collection;
import java.util.List;

public class AnimatorSetCompat {
    public static void playTogether(AnimatorSet animatorSet, List list) {
        int n10 = list.size();
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Animator animator2 = (Animator)list.get(i10);
            long l11 = animator2.getStartDelay();
            long l12 = animator2.getDuration();
            l10 = Math.max(l10, l11 += l12);
        }
        Object object = new int[]{0, 0};
        object = ValueAnimator.ofInt((int[])object);
        object.setDuration(l10);
        list.add(0, object);
        animatorSet.playTogether((Collection)list);
    }
}

