/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Log
 */
package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$1;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate;

public final class SubsamplingScaleImageView$AnimationBuilder {
    private long duration = 500L;
    private int easing = 2;
    private boolean interruptible;
    private SubsamplingScaleImageView$OnAnimationEventListener listener;
    private int origin;
    private boolean panLimited;
    private final PointF targetSCenter;
    private final float targetScale;
    public final /* synthetic */ SubsamplingScaleImageView this$0;
    private final PointF vFocus;

    private SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10) {
        int n10;
        this.this$0 = subsamplingScaleImageView;
        this.origin = n10 = 1;
        this.interruptible = n10;
        this.panLimited = n10;
        this.targetScale = f10;
        subsamplingScaleImageView = subsamplingScaleImageView.getCenter();
        this.targetSCenter = subsamplingScaleImageView;
        this.vFocus = null;
    }

    private SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10, PointF pointF) {
        int n10;
        this.this$0 = subsamplingScaleImageView;
        this.origin = n10 = 1;
        this.interruptible = n10;
        this.panLimited = n10;
        this.targetScale = f10;
        this.targetSCenter = pointF;
        this.vFocus = null;
    }

    private SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10, PointF pointF, PointF pointF2) {
        int n10;
        this.this$0 = subsamplingScaleImageView;
        this.origin = n10 = 1;
        this.interruptible = n10;
        this.panLimited = n10;
        this.targetScale = f10;
        this.targetSCenter = pointF;
        this.vFocus = pointF2;
    }

    public /* synthetic */ SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10, PointF pointF, PointF pointF2, SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this(subsamplingScaleImageView, f10, pointF, pointF2);
    }

    public /* synthetic */ SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10, PointF pointF, SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this(subsamplingScaleImageView, f10, pointF);
    }

    public /* synthetic */ SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, float f10, SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this(subsamplingScaleImageView, f10);
    }

    private SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
        float f10;
        int n10;
        this.this$0 = subsamplingScaleImageView;
        this.origin = n10 = 1;
        this.interruptible = n10;
        this.panLimited = n10;
        this.targetScale = f10 = SubsamplingScaleImageView.access$1000(subsamplingScaleImageView);
        this.targetSCenter = pointF;
        this.vFocus = null;
    }

    public /* synthetic */ SubsamplingScaleImageView$AnimationBuilder(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF, SubsamplingScaleImageView$1 subsamplingScaleImageView$1) {
        this(subsamplingScaleImageView, pointF);
    }

    public static /* synthetic */ SubsamplingScaleImageView$AnimationBuilder access$1200(SubsamplingScaleImageView$AnimationBuilder subsamplingScaleImageView$AnimationBuilder, boolean bl2) {
        return subsamplingScaleImageView$AnimationBuilder.withPanLimited(bl2);
    }

    public static /* synthetic */ SubsamplingScaleImageView$AnimationBuilder access$1300(SubsamplingScaleImageView$AnimationBuilder subsamplingScaleImageView$AnimationBuilder, int n10) {
        return subsamplingScaleImageView$AnimationBuilder.withOrigin(n10);
    }

    private SubsamplingScaleImageView$AnimationBuilder withOrigin(int n10) {
        this.origin = n10;
        return this;
    }

    private SubsamplingScaleImageView$AnimationBuilder withPanLimited(boolean bl2) {
        this.panLimited = bl2;
        return this;
    }

    public void start() {
        PointF pointF;
        float f10;
        float f11;
        Object object;
        Object object2;
        Object object3;
        Object object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        if (object4 != null && (object4 = SubsamplingScaleImageView$Anim.access$2800(SubsamplingScaleImageView.access$6400(this.this$0))) != null) {
            object4 = this.this$0;
            object4 = SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)((Object)object4));
            object4 = SubsamplingScaleImageView$Anim.access$2800((SubsamplingScaleImageView$Anim)object4);
            try {
                object4.onInterruptedByNewAnim();
            }
            catch (Exception exception) {
                object3 = SubsamplingScaleImageView.access$5400();
                object2 = "Error thrown by animation listener";
                Log.w((String)object3, (String)object2, (Throwable)exception);
            }
        }
        object4 = this.this$0;
        int n10 = object4.getPaddingLeft();
        int n11 = this.this$0.getWidth();
        int n12 = this.this$0.getPaddingRight();
        n11 -= n12;
        n12 = this.this$0.getPaddingLeft();
        n11 = (n11 - n12) / 2;
        n10 += n11;
        object3 = this.this$0;
        n11 = object3.getPaddingTop();
        n12 = this.this$0.getHeight();
        int n13 = this.this$0.getPaddingBottom();
        n12 -= n13;
        Object object5 = this.this$0;
        n13 = object5.getPaddingTop();
        n12 = (n12 - n13) / 2;
        n11 += n12;
        object2 = this.this$0;
        float f12 = this.targetScale;
        float f13 = SubsamplingScaleImageView.access$6500((SubsamplingScaleImageView)((Object)object2), f12);
        n13 = (int)(this.panLimited ? 1 : 0);
        if (n13 != 0) {
            object5 = this.this$0;
            object = this.targetSCenter;
            f11 = object.x;
            f10 = object.y;
            pointF = new PointF();
            object5 = SubsamplingScaleImageView.access$6600(object5, f11, f10, f13, pointF);
        } else {
            object5 = this.targetSCenter;
        }
        object = this.this$0;
        float f14 = 0.0f;
        pointF = null;
        Object object6 = new SubsamplingScaleImageView$Anim(null);
        SubsamplingScaleImageView.access$6402((SubsamplingScaleImageView)((Object)object), (SubsamplingScaleImageView$Anim)object6);
        object = SubsamplingScaleImageView.access$6400(this.this$0);
        f11 = SubsamplingScaleImageView.access$1000(this.this$0);
        SubsamplingScaleImageView$Anim.access$3402((SubsamplingScaleImageView$Anim)object, f11);
        SubsamplingScaleImageView$Anim.access$3502(SubsamplingScaleImageView.access$6400(this.this$0), f13);
        object = SubsamplingScaleImageView.access$6400(this.this$0);
        long l10 = System.currentTimeMillis();
        SubsamplingScaleImageView$Anim.access$3102((SubsamplingScaleImageView$Anim)object, l10);
        SubsamplingScaleImageView$Anim.access$4502(SubsamplingScaleImageView.access$6400(this.this$0), (PointF)object5);
        object = SubsamplingScaleImageView.access$6400(this.this$0);
        object6 = this.this$0.getCenter();
        SubsamplingScaleImageView$Anim.access$4402((SubsamplingScaleImageView$Anim)object, (PointF)object6);
        SubsamplingScaleImageView$Anim.access$3802(SubsamplingScaleImageView.access$6400(this.this$0), (PointF)object5);
        object = SubsamplingScaleImageView.access$6400(this.this$0);
        object6 = this.this$0;
        object5 = ((SubsamplingScaleImageView)((Object)object6)).sourceToViewCoord((PointF)object5);
        SubsamplingScaleImageView$Anim.access$3602((SubsamplingScaleImageView$Anim)object, (PointF)object5);
        object5 = SubsamplingScaleImageView.access$6400(this.this$0);
        float f15 = n10;
        float f16 = n11;
        object = new PointF(f15, f16);
        SubsamplingScaleImageView$Anim.access$3702((SubsamplingScaleImageView$Anim)object5, object);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        long l11 = this.duration;
        SubsamplingScaleImageView$Anim.access$3202((SubsamplingScaleImageView$Anim)object4, l11);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        n11 = (int)(this.interruptible ? 1 : 0);
        SubsamplingScaleImageView$Anim.access$2702((SubsamplingScaleImageView$Anim)object4, n11 != 0);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        n11 = this.easing;
        SubsamplingScaleImageView$Anim.access$3302((SubsamplingScaleImageView$Anim)object4, n11);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        n11 = this.origin;
        SubsamplingScaleImageView$Anim.access$3902((SubsamplingScaleImageView$Anim)object4, n11);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        l11 = System.currentTimeMillis();
        SubsamplingScaleImageView$Anim.access$3102((SubsamplingScaleImageView$Anim)object4, l11);
        object4 = SubsamplingScaleImageView.access$6400(this.this$0);
        object3 = this.listener;
        SubsamplingScaleImageView$Anim.access$2802((SubsamplingScaleImageView$Anim)object4, (SubsamplingScaleImageView$OnAnimationEventListener)object3);
        object4 = this.vFocus;
        if (object4 != null) {
            f15 = ((PointF)object4).x;
            f16 = SubsamplingScaleImageView$Anim.access$4400((SubsamplingScaleImageView$Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)).x * f13;
            f15 -= f16;
            object3 = this.vFocus;
            f16 = ((PointF)object3).y;
            f12 = SubsamplingScaleImageView$Anim.access$4400((SubsamplingScaleImageView$Anim)SubsamplingScaleImageView.access$6400((SubsamplingScaleImageView)this.this$0)).y * f13;
            object = new PointF(f15, f16 -= f12);
            object5 = new SubsamplingScaleImageView$ScaleAndTranslate(f13, (PointF)object, null);
            object2 = this.this$0;
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            SubsamplingScaleImageView.access$6800((SubsamplingScaleImageView)((Object)object2), bl2, (SubsamplingScaleImageView$ScaleAndTranslate)object5);
            object2 = SubsamplingScaleImageView.access$6400(this.this$0);
            object6 = this.vFocus;
            f11 = ((PointF)object6).x;
            pointF = SubsamplingScaleImageView$ScaleAndTranslate.access$4800((SubsamplingScaleImageView$ScaleAndTranslate)object5);
            f14 = pointF.x - f15;
            object4 = this.vFocus;
            f15 = ((PointF)object4).y;
            object5 = SubsamplingScaleImageView$ScaleAndTranslate.access$4800((SubsamplingScaleImageView$ScaleAndTranslate)object5);
            f12 = ((PointF)object5).y - f16;
            object = new PointF(f11 += f14, f15 += f12);
            SubsamplingScaleImageView$Anim.access$3702((SubsamplingScaleImageView$Anim)object2, object);
        }
        this.this$0.invalidate();
    }

    public SubsamplingScaleImageView$AnimationBuilder withDuration(long l10) {
        this.duration = l10;
        return this;
    }

    public SubsamplingScaleImageView$AnimationBuilder withEasing(int n10) {
        Comparable<Integer> comparable;
        Object object = SubsamplingScaleImageView.access$6300();
        boolean bl2 = object.contains(comparable = Integer.valueOf(n10));
        if (bl2) {
            this.easing = n10;
            return this;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Unknown easing type: ");
        ((StringBuilder)comparable).append(n10);
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public SubsamplingScaleImageView$AnimationBuilder withInterruptible(boolean bl2) {
        this.interruptible = bl2;
        return this;
    }

    public SubsamplingScaleImageView$AnimationBuilder withOnAnimationEventListener(SubsamplingScaleImageView$OnAnimationEventListener subsamplingScaleImageView$OnAnimationEventListener) {
        this.listener = subsamplingScaleImageView$OnAnimationEventListener;
        return this;
    }
}

