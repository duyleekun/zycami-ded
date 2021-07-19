/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.utils;

public class MeanCalculator {
    private int n;
    private float sum;

    public void add(float f10) {
        int n10;
        float f11;
        this.sum = f11 = this.sum + f10;
        this.n = n10 = this.n + 1;
        int n11 = -1 >>> 1;
        float f12 = 0.0f / 0.0f;
        if (n10 == n11) {
            n11 = 0x40000000;
            f12 = 2.0f;
            this.sum = f11 /= f12;
            this.n = n10 /= 2;
        }
    }

    public float getMean() {
        int n10 = this.n;
        if (n10 == 0) {
            return 0.0f;
        }
        float f10 = this.sum;
        float f11 = n10;
        return f10 / f11;
    }
}

