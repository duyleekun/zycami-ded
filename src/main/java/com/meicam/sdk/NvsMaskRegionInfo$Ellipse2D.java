/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsPosition2D;

public class NvsMaskRegionInfo$Ellipse2D {
    private float a;
    private float b;
    private NvsPosition2D center;
    private float theta;

    public NvsMaskRegionInfo$Ellipse2D() {
        NvsPosition2D nvsPosition2D;
        this.center = nvsPosition2D = new NvsPosition2D(0.0f, 0.0f);
        this.theta = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
    }

    public NvsMaskRegionInfo$Ellipse2D(NvsPosition2D nvsPosition2D, float f10, float f11, float f12) {
        this.center = nvsPosition2D;
        this.a = f10;
        this.b = f11;
        this.theta = f12;
    }

    public float getA() {
        return this.a;
    }

    public float getB() {
        return this.b;
    }

    public NvsPosition2D getCenter() {
        return this.center;
    }

    public float getTheta() {
        return this.theta;
    }

    public void setA(float f10) {
        this.a = f10;
    }

    public void setB(float f10) {
        this.b = f10;
    }

    public void setCenter(NvsPosition2D nvsPosition2D) {
        this.center = nvsPosition2D;
    }

    public void setTheta(float f10) {
        this.theta = f10;
    }
}

