/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.value;

public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY() {
        float f10 = 1.0f;
        this(f10, f10);
    }

    public ScaleXY(float f10, float f11) {
        this.scaleX = f10;
        this.scaleY = f11;
    }

    public boolean equals(float f10, float f11) {
        float f12;
        float f13 = this.scaleX;
        float f14 = f13 - f10;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object == false && (object = (f12 = (f10 = this.scaleY) - f11) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) == false) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float f10, float f11) {
        this.scaleX = f10;
        this.scaleY = f11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        float f10 = this.getScaleX();
        stringBuilder.append(f10);
        stringBuilder.append("x");
        f10 = this.getScaleY();
        stringBuilder.append(f10);
        return stringBuilder.toString();
    }
}

