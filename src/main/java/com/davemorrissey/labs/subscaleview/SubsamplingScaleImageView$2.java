/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 */
package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$AnimationBuilder;

public class SubsamplingScaleImageView$2
extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ SubsamplingScaleImageView this$0;
    public final /* synthetic */ Context val$context;

    public SubsamplingScaleImageView$2(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
        this.this$0 = subsamplingScaleImageView;
        this.val$context = context;
    }

    public boolean onDoubleTap(MotionEvent object) {
        SubsamplingScaleImageView subsamplingScaleImageView = this.this$0;
        boolean bl2 = SubsamplingScaleImageView.access$1400(subsamplingScaleImageView);
        if (bl2 && (bl2 = SubsamplingScaleImageView.access$700(subsamplingScaleImageView = this.this$0)) && (subsamplingScaleImageView = SubsamplingScaleImageView.access$800(this.this$0)) != null) {
            subsamplingScaleImageView = this.this$0;
            Context context = this.val$context;
            SubsamplingScaleImageView.access$1500(subsamplingScaleImageView, context);
            subsamplingScaleImageView = this.this$0;
            bl2 = SubsamplingScaleImageView.access$1600(subsamplingScaleImageView);
            boolean bl3 = true;
            float f10 = Float.MIN_VALUE;
            if (bl2) {
                subsamplingScaleImageView = this.this$0;
                float f11 = object.getX();
                float f12 = object.getY();
                PointF pointF = new PointF(f11, f12);
                SubsamplingScaleImageView.access$1702(subsamplingScaleImageView, pointF);
                subsamplingScaleImageView = this.this$0;
                f11 = SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).x;
                f12 = SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).y;
                pointF = new PointF(f11, f12);
                SubsamplingScaleImageView.access$1802(subsamplingScaleImageView, pointF);
                subsamplingScaleImageView = this.this$0;
                float f13 = SubsamplingScaleImageView.access$1000(subsamplingScaleImageView);
                SubsamplingScaleImageView.access$1902(subsamplingScaleImageView, f13);
                SubsamplingScaleImageView.access$2002(this.this$0, bl3);
                SubsamplingScaleImageView.access$902(this.this$0, bl3);
                SubsamplingScaleImageView.access$2102(this.this$0, -1.0f);
                subsamplingScaleImageView = this.this$0;
                context = SubsamplingScaleImageView.access$1700(subsamplingScaleImageView);
                context = subsamplingScaleImageView.viewToSourceCoord((PointF)context);
                SubsamplingScaleImageView.access$2202(subsamplingScaleImageView, (PointF)context);
                subsamplingScaleImageView = this.this$0;
                f13 = object.getX();
                float f14 = object.getY();
                context = new PointF(f13, f14);
                SubsamplingScaleImageView.access$2302(subsamplingScaleImageView, (PointF)context);
                object = this.this$0;
                f10 = SubsamplingScaleImageView.access$2200((SubsamplingScaleImageView)this.this$0).x;
                f13 = SubsamplingScaleImageView.access$2200((SubsamplingScaleImageView)this.this$0).y;
                subsamplingScaleImageView = new PointF(f10, f13);
                SubsamplingScaleImageView.access$2402((SubsamplingScaleImageView)((Object)object), (PointF)subsamplingScaleImageView);
                SubsamplingScaleImageView.access$2502(this.this$0, false);
                return false;
            }
            subsamplingScaleImageView = this.this$0;
            float f15 = object.getX();
            float f16 = object.getY();
            PointF pointF = new PointF(f15, f16);
            pointF = subsamplingScaleImageView.viewToSourceCoord(pointF);
            f16 = object.getX();
            float f17 = object.getY();
            PointF pointF2 = new PointF(f16, f17);
            SubsamplingScaleImageView.access$2600(subsamplingScaleImageView, pointF, pointF2);
            return bl3;
        }
        return super.onDoubleTapEvent(object);
    }

    public boolean onFling(MotionEvent object, MotionEvent motionEvent, float f10, float f11) {
        block4: {
            float f12;
            float f13;
            float f14;
            float f15;
            Object object2;
            SubsamplingScaleImageView subsamplingScaleImageView;
            block5: {
                subsamplingScaleImageView = this.this$0;
                object2 = SubsamplingScaleImageView.access$600(subsamplingScaleImageView);
                if (object2 == 0 || (object2 = SubsamplingScaleImageView.access$700(subsamplingScaleImageView = this.this$0)) == 0 || (subsamplingScaleImageView = SubsamplingScaleImageView.access$800(this.this$0)) == null || object == null || motionEvent == null) break block4;
                f15 = object.getX();
                f14 = motionEvent.getX();
                float f16 = (f15 = Math.abs(f15 - f14)) - (f14 = 50.0f);
                object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                if (object2 > 0) break block5;
                f15 = object.getY();
                float f17 = motionEvent.getY();
                float f18 = (f15 = Math.abs(f15 - f17)) - f14;
                object2 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
                if (object2 <= 0) break block4;
            }
            if (((object2 = (Object)((f13 = (f15 = Math.abs(f10)) - (f14 = 500.0f)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) > 0 || (object2 = (Object)((f12 = (f15 = Math.abs(f11)) - f14) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) > 0) && (object2 = (Object)SubsamplingScaleImageView.access$900(subsamplingScaleImageView = this.this$0)) == 0) {
                float f19 = SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).x;
                f15 = 0.25f;
                f10 = SubsamplingScaleImageView.access$800((SubsamplingScaleImageView)this.this$0).y;
                object = new PointF(f19 += (f10 *= f15), f10 += (f11 *= f15));
                f19 = this.this$0.getWidth() / 2;
                f10 = ((PointF)object).x;
                f19 -= f10;
                f10 = SubsamplingScaleImageView.access$1000(this.this$0);
                f19 /= f10;
                f10 = this.this$0.getHeight() / 2;
                float f20 = ((PointF)object).y;
                f10 -= f20;
                f20 = SubsamplingScaleImageView.access$1000(this.this$0);
                SubsamplingScaleImageView subsamplingScaleImageView2 = this.this$0;
                subsamplingScaleImageView = new PointF(f19, f10 /= f20);
                object = new SubsamplingScaleImageView$AnimationBuilder(subsamplingScaleImageView2, (PointF)subsamplingScaleImageView, null);
                boolean bl2 = true;
                SubsamplingScaleImageView$AnimationBuilder.access$1300(SubsamplingScaleImageView$AnimationBuilder.access$1200(((SubsamplingScaleImageView$AnimationBuilder)object).withEasing((int)(bl2 ? 1 : 0)), false), 3).start();
                return bl2;
            }
        }
        return super.onFling((MotionEvent)object, motionEvent, f10, f11);
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.this$0.performClick();
        return true;
    }
}

