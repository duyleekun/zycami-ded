/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.t.a.i;

import android.graphics.RectF;

public class g {
    public static float[] a(RectF rectF) {
        float f10;
        float f11 = rectF.centerX();
        float[] fArray = new float[]{f11, f10 = rectF.centerY()};
        return fArray;
    }

    public static float[] b(RectF rectF) {
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        float[] fArray = new float[]{f10, f11, f12, f11, f12, f13, f10, f13};
        return fArray;
    }

    public static float[] c(float[] fArray) {
        int n10 = 2;
        float[] fArray2 = new float[n10];
        float f10 = fArray[0];
        float f11 = fArray[n10];
        double d10 = f10 - f11;
        double d11 = 2.0;
        d10 = Math.pow(d10, d11);
        int n11 = 1;
        float f12 = fArray[n11];
        int n12 = 3;
        float f13 = fArray[n12];
        double d12 = Math.pow(f12 - f13, d11);
        fArray2[0] = f10 = (float)Math.sqrt(d10 + d12);
        float f14 = fArray[n10];
        float f15 = fArray[4];
        double d13 = Math.pow(f14 - f15, d11);
        f14 = fArray[n12];
        float f16 = fArray[5];
        double d14 = Math.pow(f14 - f16, d11);
        fArray2[n11] = f16 = (float)Math.sqrt(d13 + d14);
        return fArray2;
    }

    public static RectF d(float[] fArray) {
        float f10 = 1.0f / 0.0f;
        int n10 = -8388608;
        float f11 = -1.0f / 0.0f;
        RectF rectF = new RectF(f10, f10, f11, f11);
        f10 = Float.MIN_VALUE;
        for (int i10 = 1; i10 < (n10 = fArray.length); i10 += 2) {
            n10 = i10 + -1;
            f11 = fArray[n10];
            int n11 = 1092616192;
            float f12 = 10.0f;
            n10 = Math.round(f11 * f12);
            f11 = (float)n10 / f12;
            int n12 = Math.round(fArray[i10] * f12);
            float f13 = (float)n12 / f12;
            f12 = rectF.left;
            float f14 = f11 - f12;
            Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
            if (object < 0) {
                f12 = f11;
            }
            rectF.left = f12;
            f12 = rectF.top;
            float f15 = f13 - f12;
            object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object < 0) {
                f12 = f13;
            }
            rectF.top = f12;
            f12 = rectF.right;
            float f16 = f11 - f12;
            object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object <= 0) {
                f11 = f12;
            }
            rectF.right = f11;
            f11 = rectF.bottom;
            n11 = (int)(f13 == f11 ? 0 : (f13 > f11 ? 1 : -1));
            if (n11 <= 0) {
                f13 = f11;
            }
            rectF.bottom = f13;
        }
        rectF.sort();
        return rectF;
    }
}

