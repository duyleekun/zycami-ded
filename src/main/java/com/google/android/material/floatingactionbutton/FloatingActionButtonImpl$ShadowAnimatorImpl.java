/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1;
import com.google.android.material.shadow.ShadowDrawableWrapper;

public abstract class FloatingActionButtonImpl$ShadowAnimatorImpl
extends AnimatorListenerAdapter
implements ValueAnimator.AnimatorUpdateListener {
    private float shadowSizeEnd;
    private float shadowSizeStart;
    public final /* synthetic */ FloatingActionButtonImpl this$0;
    private boolean validValues;

    private FloatingActionButtonImpl$ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
    }

    public /* synthetic */ FloatingActionButtonImpl$ShadowAnimatorImpl(FloatingActionButtonImpl floatingActionButtonImpl, FloatingActionButtonImpl$1 floatingActionButtonImpl$1) {
        this(floatingActionButtonImpl);
    }

    public abstract float getTargetShadowSize();

    public void onAnimationEnd(Animator object) {
        object = this.this$0.shadowDrawable;
        float f10 = this.shadowSizeEnd;
        ((ShadowDrawableWrapper)((Object)object)).setShadowSize(f10);
        this.validValues = false;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ShadowDrawableWrapper shadowDrawableWrapper;
        boolean bl2 = this.validValues;
        if (!bl2) {
            float f10;
            shadowDrawableWrapper = this.this$0.shadowDrawable;
            this.shadowSizeStart = f10 = shadowDrawableWrapper.getShadowSize();
            this.shadowSizeEnd = f10 = this.getTargetShadowSize();
            bl2 = true;
            f10 = Float.MIN_VALUE;
            this.validValues = bl2;
        }
        shadowDrawableWrapper = this.this$0.shadowDrawable;
        float f11 = this.shadowSizeStart;
        float f12 = this.shadowSizeEnd - f11;
        float f13 = valueAnimator.getAnimatedFraction();
        shadowDrawableWrapper.setShadowSize(f11 += (f12 *= f13));
    }
}

