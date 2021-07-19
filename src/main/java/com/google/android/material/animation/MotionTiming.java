/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.google.android.material.animation.AnimationUtils;

public class MotionTiming {
    private long delay = 0L;
    private long duration = 300L;
    private TimeInterpolator interpolator = null;
    private int repeatCount = 0;
    private int repeatMode = 1;

    public MotionTiming(long l10, long l11) {
        this.delay = l10;
        this.duration = l11;
    }

    public MotionTiming(long l10, long l11, TimeInterpolator timeInterpolator) {
        this.delay = l10;
        this.duration = l11;
        this.interpolator = timeInterpolator;
    }

    public static MotionTiming createFromAnimator(ValueAnimator valueAnimator) {
        int n10;
        int n11;
        long l10 = valueAnimator.getStartDelay();
        long l11 = valueAnimator.getDuration();
        TimeInterpolator timeInterpolator = MotionTiming.getInterpolatorCompat(valueAnimator);
        MotionTiming motionTiming = new MotionTiming(l10, l11, timeInterpolator);
        motionTiming.repeatCount = n11 = valueAnimator.getRepeatCount();
        motionTiming.repeatMode = n10 = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator valueAnimator) {
        boolean bl2 = (valueAnimator = valueAnimator.getInterpolator()) instanceof AccelerateDecelerateInterpolator;
        if (!bl2 && valueAnimator != null) {
            bl2 = valueAnimator instanceof AccelerateInterpolator;
            if (bl2) {
                return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            }
            bl2 = valueAnimator instanceof DecelerateInterpolator;
            if (bl2) {
                valueAnimator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            }
            return valueAnimator;
        }
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void apply(Animator animator2) {
        long l10 = this.getDelay();
        animator2.setStartDelay(l10);
        l10 = this.getDuration();
        animator2.setDuration(l10);
        TimeInterpolator timeInterpolator = this.getInterpolator();
        animator2.setInterpolator(timeInterpolator);
        int n10 = animator2 instanceof ValueAnimator;
        if (n10 != 0) {
            animator2 = (ValueAnimator)animator2;
            n10 = this.getRepeatCount();
            animator2.setRepeatCount(n10);
            n10 = this.getRepeatMode();
            animator2.setRepeatMode(n10);
        }
    }

    public boolean equals(Object clazz) {
        Class<?> clazz2;
        Class<?> clazz3;
        if (this == clazz) {
            return true;
        }
        Class<?> clazz4 = null;
        if (clazz != null && (clazz3 = this.getClass()) == (clazz2 = clazz.getClass())) {
            int n10;
            long l10;
            clazz = (MotionTiming)((Object)clazz);
            long l11 = this.getDelay();
            long l12 = l11 - (l10 = ((MotionTiming)((Object)clazz)).getDelay());
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) {
                return false;
            }
            l11 = this.getDuration();
            long l13 = l11 - (l10 = ((MotionTiming)((Object)clazz)).getDuration());
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object != false) {
                return false;
            }
            object = this.getRepeatCount();
            if (object != (n10 = ((MotionTiming)((Object)clazz)).getRepeatCount())) {
                return false;
            }
            object = this.getRepeatMode();
            if (object != (n10 = ((MotionTiming)((Object)clazz)).getRepeatMode())) {
                return false;
            }
            clazz4 = this.getInterpolator().getClass();
            clazz = ((MotionTiming)((Object)clazz)).getInterpolator().getClass();
            return clazz4.equals(clazz);
        }
        return false;
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        if (timeInterpolator == null) {
            timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        return timeInterpolator;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public int hashCode() {
        long l10 = this.getDelay();
        long l11 = this.getDelay();
        int n10 = 32;
        int n11 = (int)(l10 ^ (l11 >>>= n10)) * 31;
        long l12 = this.getDuration();
        long l13 = this.getDuration() >>> n10;
        int n12 = (int)(l12 ^ l13);
        n11 = (n11 + n12) * 31;
        n12 = this.getInterpolator().getClass().hashCode();
        n11 = (n11 + n12) * 31;
        n12 = this.getRepeatCount();
        n11 = (n11 + n12) * 31;
        n12 = this.getRepeatMode();
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        Object object = this.getClass().getName();
        stringBuilder.append((String)object);
        stringBuilder.append('{');
        object = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append((String)object);
        stringBuilder.append(" delay: ");
        long l10 = this.getDelay();
        stringBuilder.append(l10);
        stringBuilder.append(" duration: ");
        l10 = this.getDuration();
        stringBuilder.append(l10);
        stringBuilder.append(" interpolator: ");
        object = this.getInterpolator().getClass();
        stringBuilder.append(object);
        stringBuilder.append(" repeatCount: ");
        int n10 = this.getRepeatCount();
        stringBuilder.append(n10);
        stringBuilder.append(" repeatMode: ");
        n10 = this.getRepeatMode();
        stringBuilder.append(n10);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

