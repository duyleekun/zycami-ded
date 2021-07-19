/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x1;

import m.a.a;

public class o {
    private static int a(float f10, float[] fArray) {
        if (fArray != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
                float f11 = fArray[i10];
                float f12 = f11 - f10;
                n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
                if (n10 < 0) continue;
                return i10 + -1;
            }
        }
        return -1;
    }

    public static Float b(float f10, float[] fArray, float[] objectArray) {
        float f11;
        int n10 = 0;
        if (fArray == null) {
            return null;
        }
        if (objectArray == null) {
            return null;
        }
        n10 = o.a(f10, fArray);
        int n11 = 1;
        if (n10 < 0) {
            f11 = objectArray[0];
        } else {
            int n12 = fArray.length - n11;
            if (n10 >= n12) {
                int n13 = fArray.length - n11;
                f11 = objectArray[n13];
            } else {
                float f12 = fArray[n10];
                f12 = f10 - f12;
                int n14 = n10 + 1;
                float f13 = fArray[n14];
                f11 = fArray[n10];
                f12 /= (f13 -= f11);
                f11 = objectArray[n14];
                float f14 = objectArray[n10];
                f11 = objectArray[n10] + (f12 *= (f11 -= f14));
            }
        }
        objectArray = new Object[2];
        Float f15 = Float.valueOf(f10);
        objectArray[0] = f15;
        f15 = Float.valueOf(f11);
        objectArray[n11] = f15;
        a.b("value:%s to value2:%s", objectArray);
        return Float.valueOf(f11);
    }
}

