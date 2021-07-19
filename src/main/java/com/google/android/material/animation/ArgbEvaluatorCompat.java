/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package com.google.android.material.animation;

import android.animation.TypeEvaluator;

public class ArgbEvaluatorCompat
implements TypeEvaluator {
    private static final ArgbEvaluatorCompat instance;

    static {
        ArgbEvaluatorCompat argbEvaluatorCompat;
        instance = argbEvaluatorCompat = new ArgbEvaluatorCompat();
    }

    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    public Integer evaluate(float f10, Integer n10, Integer n11) {
        int n12 = n10;
        float f11 = n12 >> 24 & 0xFF;
        float f12 = 255.0f;
        float f13 = (float)(n12 >> 16 & 0xFF) / f12;
        float f14 = (float)(n12 >> 8 & 0xFF) / f12;
        float f15 = (float)(n12 & 0xFF) / f12;
        int n13 = n11;
        float f16 = (float)(n13 >> 24 & 0xFF) / f12;
        float f17 = (float)(n13 >> 16 & 0xFF) / f12;
        float f18 = (float)(n13 >> 8 & 0xFF) / f12;
        float f19 = (float)(n13 & 0xFF) / f12;
        double d10 = f13;
        double d11 = 2.2;
        f13 = (float)Math.pow(d10, d11);
        f14 = (float)Math.pow(f14, d11);
        f15 = (float)Math.pow(f15, d11);
        f17 = (float)Math.pow(f17, d11);
        f18 = (float)Math.pow(f18, d11);
        f19 = (float)Math.pow(f19, d11);
        f16 = (f16 - (f11 /= f12)) * f10;
        f11 += f16;
        f17 = (f17 - f13) * f10;
        f18 = (f18 - f14) * f10;
        f10 *= (f19 -= f15);
        f15 += f10;
        double d12 = f13 += f17;
        double d13 = 0.45454545454545453;
        f10 = (float)Math.pow(d12, d13) * f12;
        f19 = (float)Math.pow(f14 += f18, d13) * f12;
        f15 = (float)Math.pow(f15, d13) * f12;
        int n14 = Math.round(f11 *= f12) << 24;
        int n15 = Math.round(f10) << 16 | n14;
        n13 = Math.round(f19) << 8;
        n12 = Math.round(f15);
        return (n15 |= n13) | n12;
    }
}

