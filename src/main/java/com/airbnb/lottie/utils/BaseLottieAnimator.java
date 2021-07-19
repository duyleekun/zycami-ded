/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.os.Build$VERSION
 */
package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class BaseLottieAnimator
extends ValueAnimator {
    private final Set listeners;
    private final Set updateListeners;

    public BaseLottieAnimator() {
        CopyOnWriteArraySet copyOnWriteArraySet;
        this.updateListeners = copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.listeners = copyOnWriteArraySet = new CopyOnWriteArraySet();
    }

    public void addListener(Animator.AnimatorListener animatorListener) {
        this.listeners.add(animatorListener);
    }

    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.add(animatorUpdateListener);
    }

    public long getStartDelay() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
        throw unsupportedOperationException;
    }

    public void notifyCancel() {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
            animatorListener.onAnimationCancel((Animator)this);
        }
    }

    public void notifyEnd(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.listeners.iterator();
        while (bl3 = iterator2.hasNext()) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                animatorListener.onAnimationEnd((Animator)this, bl2);
                continue;
            }
            animatorListener.onAnimationEnd((Animator)this);
        }
    }

    public void notifyRepeat() {
        boolean bl2;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
            animatorListener.onAnimationRepeat((Animator)this);
        }
    }

    public void notifyStart(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.listeners.iterator();
        while (bl3 = iterator2.hasNext()) {
            Animator.AnimatorListener animatorListener = (Animator.AnimatorListener)iterator2.next();
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                animatorListener.onAnimationStart((Animator)this, bl2);
                continue;
            }
            animatorListener.onAnimationStart((Animator)this);
        }
    }

    public void notifyUpdate() {
        boolean bl2;
        Iterator iterator2 = this.updateListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = (ValueAnimator.AnimatorUpdateListener)iterator2.next();
            animatorUpdateListener.onAnimationUpdate((ValueAnimator)this);
        }
    }

    public void removeAllListeners() {
        this.listeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.listeners.remove(animatorListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.updateListeners.remove(animatorUpdateListener);
    }

    public ValueAnimator setDuration(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("LottieAnimator does not support setDuration.");
        throw unsupportedOperationException;
    }

    public void setInterpolator(TimeInterpolator object) {
        object = new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
        throw object;
    }

    public void setStartDelay(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
        throw unsupportedOperationException;
    }
}

