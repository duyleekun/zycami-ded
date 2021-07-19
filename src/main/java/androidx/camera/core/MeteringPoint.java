/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 */
package androidx.camera.core;

import android.util.Rational;

public class MeteringPoint {
    private float mNormalizedX;
    private float mNormalizedY;
    private float mSize;
    private Rational mSurfaceAspectRatio;

    public MeteringPoint(float f10, float f11, float f12, Rational rational) {
        this.mNormalizedX = f10;
        this.mNormalizedY = f11;
        this.mSize = f12;
        this.mSurfaceAspectRatio = rational;
    }

    public float getSize() {
        return this.mSize;
    }

    public Rational getSurfaceAspectRatio() {
        return this.mSurfaceAspectRatio;
    }

    public float getX() {
        return this.mNormalizedX;
    }

    public float getY() {
        return this.mNormalizedY;
    }
}

