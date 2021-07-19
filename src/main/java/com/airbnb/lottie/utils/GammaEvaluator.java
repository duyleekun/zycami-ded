/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.utils;

public class GammaEvaluator {
    private static float EOCF_sRGB(float f10) {
        float f11 = 0.04045f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            object = 1095678034;
            f11 = 12.92f;
            f10 /= f11;
        } else {
            object = 1065814589;
            f11 = 1.055f;
            double d10 = (f10 += 0.055f) / f11;
            double d11 = 2.4f;
            d10 = Math.pow(d10, d11);
            f10 = (float)d10;
        }
        return f10;
    }

    private static float OECF_sRGB(float f10) {
        float f11 = 0.0031308f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            object = 1095678034;
            f11 = 12.92f;
            f10 *= f11;
        } else {
            double d10 = Math.pow(f10, 0.4166666567325592) * (double)1.055f;
            double d11 = 0.055f;
            f10 = (float)(d10 -= d11);
        }
        return f10;
    }

    public static int evaluate(float f10, int n10, int n11) {
        if (n10 == n11) {
            return n10;
        }
        float f11 = n10 >> 24 & 0xFF;
        float f12 = 255.0f;
        float f13 = (float)(n10 >> 16 & 0xFF) / f12;
        float f14 = (float)(n10 >> 8 & 0xFF) / f12;
        float f15 = (float)(n10 & 0xFF) / f12;
        float f16 = (float)(n11 >> 24 & 0xFF) / f12;
        float f17 = (float)(n11 >> 16 & 0xFF) / f12;
        float f18 = (float)(n11 >> 8 & 0xFF) / f12;
        float f19 = (float)(n11 & 0xFF) / f12;
        f13 = GammaEvaluator.EOCF_sRGB(f13);
        f14 = GammaEvaluator.EOCF_sRGB(f14);
        f15 = GammaEvaluator.EOCF_sRGB(f15);
        f17 = GammaEvaluator.EOCF_sRGB(f17);
        f18 = GammaEvaluator.EOCF_sRGB(f18);
        f19 = GammaEvaluator.EOCF_sRGB(f19);
        f16 = (f16 - (f11 /= f12)) * f10;
        f11 += f16;
        f17 = (f17 - f13) * f10;
        f18 = (f18 - f14) * f10;
        f10 *= (f19 -= f15);
        f15 += f10;
        f10 = GammaEvaluator.OECF_sRGB(f13 += f17) * f12;
        f19 = GammaEvaluator.OECF_sRGB(f14 += f18) * f12;
        f15 = GammaEvaluator.OECF_sRGB(f15) * f12;
        int n12 = Math.round(f11 *= f12) << 24;
        int n13 = Math.round(f10) << 16 | n12;
        n11 = Math.round(f19) << 8;
        n10 = Math.round(f15);
        return (n13 |= n11) | n10;
    }
}

