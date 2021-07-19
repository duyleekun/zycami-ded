/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.RggbChannelVector
 */
package d.v.d.h;

import android.hardware.camera2.params.RggbChannelVector;

public class e {
    private static float a(float f10) {
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object >= 0) {
            f11 = f10;
        }
        object = 1132396544;
        float f13 = 255.0f;
        float f14 = f10 == f13 ? 0 : (f10 > f13 ? 1 : -1);
        if (f14 > 0) {
            f11 = f13;
        }
        return f11;
    }

    public static int b(RggbChannelVector rggbChannelVector) {
        float f10;
        float f11;
        float f12;
        Object object;
        float f13 = rggbChannelVector.getRed();
        float f14 = rggbChannelVector.getBlue();
        float f15 = 0.0f;
        float f16 = 1000.0f;
        float f17 = 40000.0f;
        while ((object = (f12 = (f11 = f17 - f16) - (f10 = 0.4f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0) {
            f15 = (f17 + f16) / 2.0f;
            RggbChannelVector rggbChannelVector2 = e.d(f15);
            f10 = rggbChannelVector2.getBlue();
            f11 = rggbChannelVector2.getRed();
            float f18 = (f10 /= f11) - (f11 = f14 / f13);
            object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
            if (object >= 0) {
                f17 = f15;
                continue;
            }
            f16 = f15;
        }
        return Math.round(f15);
    }

    public static RggbChannelVector c(int n10) {
        float f10;
        double d10;
        double d11;
        float f11;
        if (n10 <= 0) {
            return null;
        }
        float f12 = (float)n10 / 100.0f;
        int n11 = 1115947008;
        float f13 = 66.0f;
        float f14 = f12 == f13 ? 0 : (f12 < f13 ? -1 : 1);
        float f15 = 60.0f;
        int n12 = 1132396544;
        float f16 = 255.0f;
        if (f14 <= 0) {
            f11 = f16;
        } else {
            f11 = f12 - f15;
            d11 = 329.698727446;
            d10 = f11;
            double d12 = -0.1332047592;
            d10 = Math.pow(d10, d12) * d11;
            f11 = (float)d10;
            e.a(f11);
        }
        if (f14 <= 0) {
            d11 = Math.log(f12) * 99.4708025861;
            double d13 = 161.1195681661;
            f10 = (float)(d11 -= d13);
            e.a(f10);
        } else {
            f10 = f12 - f15;
            d11 = 288.1221695283;
            double d14 = f10;
            d10 = -0.0755148492;
            d14 = Math.pow(d14, d10) * d11;
            f10 = (float)d14;
            e.a(f10);
        }
        n11 = (int)(f12 == f13 ? 0 : (f12 > f13 ? 1 : -1));
        if (n11 >= 0) {
            n10 = n12;
            f12 = f16;
        } else {
            f13 = 19.0f;
            float f17 = f12 - f13;
            n11 = (int)(f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1));
            if (n11 <= 0) {
                n10 = 0;
                f12 = 0.0f;
            } else {
                n11 = 1092616192;
                f13 = 10.0f;
                d10 = Math.log(f12 - f13) * 138.5177312231;
                d11 = 305.0447927307;
                f12 = (float)(d10 -= d11);
                e.a(f12);
            }
        }
        f11 /= f16;
        f15 = 2.0f;
        f12 = f12 / f16 * f15;
        RggbChannelVector rggbChannelVector = new RggbChannelVector(f11 *= f15, f10 /= f16, f10, f12);
        return rggbChannelVector;
    }

    private static RggbChannelVector d(float f10) {
        double d10;
        double d11;
        double d12;
        double d13 = (double)f10 / 100.0;
        double d14 = 66.0;
        Object object = d13 == d14 ? 0 : (d13 < d14 ? -1 : 1);
        double d15 = 255.0;
        if (object < 0) {
            d12 = d15;
        } else {
            d12 = d13 - 55.0;
            d11 = 0.114206453784165 * d12 + 351.97690566805693;
            d10 = 40.25366309332127;
            d12 = Math.log(d12) * d10;
            float f11 = e.a((float)(d11 -= d12));
            d12 = f11;
        }
        if (object < 0) {
            d10 = d13 - 2.0;
            double d16 = 0.44596950469579133 * d10;
            d11 = -155.25485562709179 - d16;
            d16 = 104.49216199393888;
            d10 = Math.log(d10) * d16;
            f10 = e.a((float)(d11 += d10));
        } else {
            d10 = d13 - 50.0;
            double d17 = 0.07943456536662342 * d10 + 325.4494125711974;
            d11 = 28.0852963507957;
            d10 = Math.log(d10) * d11;
            f10 = e.a((float)(d17 -= d10));
        }
        d10 = f10;
        object = d13 == d14 ? 0 : (d13 > d14 ? 1 : -1);
        if (object < 0) {
            d14 = 20.0;
            double d18 = d13 - d14;
            object = d18 == 0.0 ? 0 : (d18 < 0.0 ? -1 : 1);
            if (object <= 0) {
                d15 = 0.0;
            } else {
                d15 = 0.8274096064007395 * (d13 -= 10.0) + -254.76935184120902;
                d14 = 115.67994401066147;
                d13 = Math.log(d13) * d14;
                f10 = e.a((float)(d15 + d13));
                d15 = f10;
            }
        }
        f10 = Math.round(d12);
        float f12 = Math.round(d10);
        float f13 = Math.round(d15);
        RggbChannelVector rggbChannelVector = new RggbChannelVector(f10, f12, f12, f13);
        return rggbChannelVector;
    }
}

