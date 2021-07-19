/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TypeEvaluator
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;

public class ArgbEvaluator
implements TypeEvaluator {
    private static final ArgbEvaluator sInstance;

    static {
        ArgbEvaluator argbEvaluator;
        sInstance = argbEvaluator = new ArgbEvaluator();
    }

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    public Object evaluate(float f10, Object object, Object object2) {
        int n10 = (Integer)object;
        float f11 = n10 >> 24 & 0xFF;
        float f12 = 255.0f;
        float f13 = (float)(n10 >> 16 & 0xFF) / f12;
        float f14 = (float)(n10 >> 8 & 0xFF) / f12;
        float f15 = (float)(n10 & 0xFF) / f12;
        int n11 = (Integer)object2;
        float f16 = (float)(n11 >> 24 & 0xFF) / f12;
        float f17 = (float)(n11 >> 16 & 0xFF) / f12;
        float f18 = (float)(n11 >> 8 & 0xFF) / f12;
        float f19 = (float)(n11 & 0xFF) / f12;
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
        int n12 = Math.round(f11 *= f12) << 24;
        int n13 = Math.round(f10) << 16 | n12;
        n11 = Math.round(f19) << 8;
        n10 = Math.round(f15);
        return (n13 |= n11) | n10;
    }
}

