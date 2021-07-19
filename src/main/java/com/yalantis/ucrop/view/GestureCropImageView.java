/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.view.GestureCropImageView$b;
import com.yalantis.ucrop.view.GestureCropImageView$c;
import com.yalantis.ucrop.view.GestureCropImageView$d;
import d.t.a.i.h;
import d.t.a.i.h$a;
import d.t.a.j.a;

public class GestureCropImageView
extends a {
    private static final int S = 200;
    private ScaleGestureDetector K;
    private h L;
    private GestureDetector M;
    private float N;
    private float O;
    private boolean P;
    private boolean Q;
    private int R;

    public GestureCropImageView(Context context) {
        super(context);
        boolean bl2;
        this.P = bl2 = true;
        this.Q = bl2;
        this.R = 5;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        boolean bl2;
        this.P = bl2 = true;
        this.Q = bl2;
        this.R = 5;
    }

    public static /* synthetic */ float H(GestureCropImageView gestureCropImageView) {
        return gestureCropImageView.N;
    }

    public static /* synthetic */ float I(GestureCropImageView gestureCropImageView) {
        return gestureCropImageView.O;
    }

    private void L() {
        Object object;
        Object object2 = this.getContext();
        Object object3 = new GestureCropImageView$b(this, null);
        this.M = object = new GestureDetector(object2, (GestureDetector.OnGestureListener)object3, null, true);
        object2 = this.getContext();
        object3 = new GestureCropImageView$d(this, null);
        object = new ScaleGestureDetector(object2, (ScaleGestureDetector.OnScaleGestureListener)object3);
        this.K = object;
        object2 = new GestureCropImageView$c(this, null);
        object = new h((h$a)object2);
        this.L = object;
    }

    public boolean J() {
        return this.P;
    }

    public boolean K() {
        return this.Q;
    }

    public int getDoubleTapScaleSteps() {
        return this.R;
    }

    public float getDoubleTapTargetScale() {
        float f10 = this.getCurrentScale();
        float f11 = this.getMaxScale();
        float f12 = this.getMinScale();
        double d10 = f11 / f12;
        float f13 = this.R;
        double d11 = 1.0f / f13;
        f11 = (float)Math.pow(d10, d11);
        return f10 * f11;
    }

    public void i() {
        super.i();
        this.L();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        Object object;
        int n11;
        int n12 = motionEvent.getAction() & 0xFF;
        if (n12 == 0) {
            this.u();
        }
        if ((n12 = motionEvent.getPointerCount()) > (n11 = 1)) {
            n12 = 0;
            object = null;
            float f10 = motionEvent.getX(0);
            float f11 = motionEvent.getX(n11);
            f10 += f11;
            f11 = 2.0f;
            this.N = f10 /= f11;
            float f12 = motionEvent.getY(0);
            f10 = motionEvent.getY(n11);
            this.O = f12 = (f12 + f10) / f11;
        }
        object = this.M;
        object.onTouchEvent(motionEvent);
        n12 = (int)(this.Q ? 1 : 0);
        if (n12 != 0) {
            object = this.K;
            object.onTouchEvent(motionEvent);
        }
        if ((n12 = (int)(this.P ? 1 : 0)) != 0) {
            object = this.L;
            ((h)object).d(motionEvent);
        }
        if ((n10 = motionEvent.getAction() & 0xFF) == n11) {
            this.A();
        }
        return n11 != 0;
    }

    public void setDoubleTapScaleSteps(int n10) {
        this.R = n10;
    }

    public void setRotateEnabled(boolean bl2) {
        this.P = bl2;
    }

    public void setScaleEnabled(boolean bl2) {
        this.Q = bl2;
    }
}

