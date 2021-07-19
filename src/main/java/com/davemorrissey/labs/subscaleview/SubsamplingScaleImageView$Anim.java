/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$1;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener;

public class SubsamplingScaleImageView$Anim {
    private long duration = 500L;
    private int easing;
    private boolean interruptible;
    private SubsamplingScaleImageView.OnAnimationEventListener listener;
    private int origin;
    private PointF sCenterEnd;
    private PointF sCenterEndRequested;
    private PointF sCenterStart;
    private float scaleEnd;
    private float scaleStart;
    private long time;
    private PointF vFocusEnd;
    private PointF vFocusStart;

    private SubsamplingScaleImageView$Anim() {
        long l10;
        boolean bl2;
        this.interruptible = bl2 = true;
        this.easing = 2;
        this.origin = (int)(bl2 ? 1 : 0);
        this.time = l10 = System.currentTimeMillis();
    }

    public /* synthetic */ SubsamplingScaleImageView$Anim(SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this();
    }

    public static /* synthetic */ boolean access$2700(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.interruptible;
    }

    public static /* synthetic */ boolean access$2702(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, boolean bl2) {
        subsamplingScaleImageView$Anim.interruptible = bl2;
        return bl2;
    }

    public static /* synthetic */ SubsamplingScaleImageView.OnAnimationEventListener access$2800(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.listener;
    }

    public static /* synthetic */ SubsamplingScaleImageView.OnAnimationEventListener access$2802(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, SubsamplingScaleImageView.OnAnimationEventListener onAnimationEventListener) {
        subsamplingScaleImageView$Anim.listener = onAnimationEventListener;
        return onAnimationEventListener;
    }

    public static /* synthetic */ long access$3100(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.time;
    }

    public static /* synthetic */ long access$3102(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, long l10) {
        subsamplingScaleImageView$Anim.time = l10;
        return l10;
    }

    public static /* synthetic */ long access$3200(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.duration;
    }

    public static /* synthetic */ long access$3202(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, long l10) {
        subsamplingScaleImageView$Anim.duration = l10;
        return l10;
    }

    public static /* synthetic */ int access$3300(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.easing;
    }

    public static /* synthetic */ int access$3302(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, int n10) {
        subsamplingScaleImageView$Anim.easing = n10;
        return n10;
    }

    public static /* synthetic */ float access$3400(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.scaleStart;
    }

    public static /* synthetic */ float access$3402(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, float f10) {
        subsamplingScaleImageView$Anim.scaleStart = f10;
        return f10;
    }

    public static /* synthetic */ float access$3500(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.scaleEnd;
    }

    public static /* synthetic */ float access$3502(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, float f10) {
        subsamplingScaleImageView$Anim.scaleEnd = f10;
        return f10;
    }

    public static /* synthetic */ PointF access$3600(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.vFocusStart;
    }

    public static /* synthetic */ PointF access$3602(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, PointF pointF) {
        subsamplingScaleImageView$Anim.vFocusStart = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$3700(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.vFocusEnd;
    }

    public static /* synthetic */ PointF access$3702(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, PointF pointF) {
        subsamplingScaleImageView$Anim.vFocusEnd = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$3800(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.sCenterEnd;
    }

    public static /* synthetic */ PointF access$3802(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, PointF pointF) {
        subsamplingScaleImageView$Anim.sCenterEnd = pointF;
        return pointF;
    }

    public static /* synthetic */ int access$3900(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.origin;
    }

    public static /* synthetic */ int access$3902(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, int n10) {
        subsamplingScaleImageView$Anim.origin = n10;
        return n10;
    }

    public static /* synthetic */ PointF access$4400(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.sCenterStart;
    }

    public static /* synthetic */ PointF access$4402(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, PointF pointF) {
        subsamplingScaleImageView$Anim.sCenterStart = pointF;
        return pointF;
    }

    public static /* synthetic */ PointF access$4500(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim) {
        return subsamplingScaleImageView$Anim.sCenterEndRequested;
    }

    public static /* synthetic */ PointF access$4502(SubsamplingScaleImageView$Anim subsamplingScaleImageView$Anim, PointF pointF) {
        subsamplingScaleImageView$Anim.sCenterEndRequested = pointF;
        return pointF;
    }
}

