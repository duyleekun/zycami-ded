/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 */
package com.yalantis.ucrop.view;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.GestureCropImageView$a;
import d.t.a.j.b;

public class GestureCropImageView$b
extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ GestureCropImageView a;

    private GestureCropImageView$b(GestureCropImageView gestureCropImageView) {
        this.a = gestureCropImageView;
    }

    public /* synthetic */ GestureCropImageView$b(GestureCropImageView gestureCropImageView, GestureCropImageView$a gestureCropImageView$a) {
        this(gestureCropImageView);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        GestureCropImageView gestureCropImageView = this.a;
        float f10 = gestureCropImageView.getDoubleTapTargetScale();
        float f11 = motionEvent.getX();
        float f12 = motionEvent.getY();
        gestureCropImageView.C(f10, f11, f12, 200L);
        return super.onDoubleTap(motionEvent);
    }

    public boolean onScroll(MotionEvent object, MotionEvent motionEvent, float f10, float f11) {
        object = this.a;
        float f12 = -f10;
        f10 = -f11;
        ((b)object).m(f12, f10);
        return true;
    }
}

