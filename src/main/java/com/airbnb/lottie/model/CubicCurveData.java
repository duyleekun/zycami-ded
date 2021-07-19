/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.airbnb.lottie.model;

import android.graphics.PointF;

public class CubicCurveData {
    private final PointF controlPoint1;
    private final PointF controlPoint2;
    private final PointF vertex;

    public CubicCurveData() {
        PointF pointF;
        this.controlPoint1 = pointF = new PointF();
        this.controlPoint2 = pointF = new PointF();
        this.vertex = pointF = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.controlPoint1 = pointF;
        this.controlPoint2 = pointF2;
        this.vertex = pointF3;
    }

    public PointF getControlPoint1() {
        return this.controlPoint1;
    }

    public PointF getControlPoint2() {
        return this.controlPoint2;
    }

    public PointF getVertex() {
        return this.vertex;
    }

    public void setControlPoint1(float f10, float f11) {
        this.controlPoint1.set(f10, f11);
    }

    public void setControlPoint2(float f10, float f11) {
        this.controlPoint2.set(f10, f11);
    }

    public void setVertex(float f10, float f11) {
        this.vertex.set(f10, f11);
    }
}

