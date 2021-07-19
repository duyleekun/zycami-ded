/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.TouchTracker$Listener;

public class TouchTracker
extends GestureDetector.SimpleOnGestureListener
implements View.OnTouchListener,
OrientationListener$Listener {
    public static final float MAX_PITCH_DEGREES = 45.0f;
    private final PointF accumulatedTouchOffsetDegrees;
    private final GestureDetector gestureDetector;
    private final TouchTracker$Listener listener;
    private final PointF previousTouchPointPx;
    private final float pxPerDegrees;
    private volatile float roll;
    private SingleTapListener singleTapListener;

    public TouchTracker(Context context, TouchTracker$Listener touchTracker$Listener, float f10) {
        PointF pointF;
        this.previousTouchPointPx = pointF = new PointF();
        this.accumulatedTouchOffsetDegrees = pointF = new PointF();
        this.listener = touchTracker$Listener;
        this.pxPerDegrees = f10;
        super(context, (GestureDetector.OnGestureListener)this);
        this.gestureDetector = touchTracker$Listener;
        this.roll = (float)Math.PI;
    }

    public boolean onDown(MotionEvent motionEvent) {
        PointF pointF = this.previousTouchPointPx;
        float f10 = motionEvent.getX();
        float f11 = motionEvent.getY();
        pointF.set(f10, f11);
        return true;
    }

    public void onOrientationChange(float[] fArray, float f10) {
        float f11;
        this.roll = f11 = -f10;
    }

    public boolean onScroll(MotionEvent object, MotionEvent motionEvent, float f10, float f11) {
        float f12 = motionEvent.getX();
        f10 = this.previousTouchPointPx.x;
        f12 -= f10;
        f10 = this.pxPerDegrees;
        f12 /= f10;
        f10 = motionEvent.getY();
        PointF pointF = this.previousTouchPointPx;
        float f13 = pointF.y;
        f10 -= f13;
        f13 = this.pxPerDegrees;
        f10 /= f13;
        f13 = motionEvent.getX();
        float f14 = motionEvent.getY();
        pointF.set(f13, f14);
        double d10 = this.roll;
        f14 = (float)Math.cos(d10);
        f11 = (float)Math.sin(d10);
        PointF pointF2 = this.accumulatedTouchOffsetDegrees;
        float f15 = pointF2.x;
        float f16 = f14 * f12;
        float f17 = f11 * f10;
        pointF2.x = f15 -= (f16 -= f17);
        f15 = pointF2.y;
        f11 *= f12;
        pointF2.y = f15 += (f11 += (f14 *= f10));
        f12 = Math.min(45.0f, f15);
        pointF2.y = f12 = Math.max(-45.0f, f12);
        object = this.listener;
        motionEvent = this.accumulatedTouchOffsetDegrees;
        object.onScrollChange((PointF)motionEvent);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        SingleTapListener singleTapListener = this.singleTapListener;
        if (singleTapListener != null) {
            return singleTapListener.onSingleTapUp(motionEvent);
        }
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.gestureDetector.onTouchEvent(motionEvent);
    }

    public void setSingleTapListener(SingleTapListener singleTapListener) {
        this.singleTapListener = singleTapListener;
    }
}

