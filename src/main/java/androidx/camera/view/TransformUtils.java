/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.util.Size
 */
package androidx.camera.view;

import android.graphics.RectF;
import android.util.Size;

public class TransformUtils {
    private static final int FLOAT_NUMBER_PER_VERTEX = 2;

    private TransformUtils() {
    }

    public static float[] createRotatedVertices(float[] fArray, int n10) {
        int n11;
        int n12 = fArray.length;
        float[] fArray2 = new float[n12];
        n10 = -n10 / 90 * 2;
        for (int i10 = 0; i10 < (n11 = fArray.length); ++i10) {
            float f10;
            n11 = i10 + n10;
            int n13 = fArray.length;
            if ((n11 %= n13) < 0) {
                n13 = fArray.length;
                n11 += n13;
            }
            fArray2[n11] = f10 = fArray[i10];
        }
        return fArray2;
    }

    public static boolean is90or270(int n10) {
        int n11 = 90;
        if (n10 != n11 && n10 != (n11 = 270)) {
            if (n10 != 0 && n10 != (n11 = 180)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid rotation degrees: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            return false;
        }
        return true;
    }

    public static float max(float f10, float f11, float f12, float f13) {
        f10 = Math.max(f10, f11);
        f11 = Math.max(f12, f13);
        return Math.max(f10, f11);
    }

    public static float min(float f10, float f11, float f12, float f13) {
        f10 = Math.min(f10, f11);
        f11 = Math.min(f12, f13);
        return Math.min(f10, f11);
    }

    public static float[] rectToVertices(RectF rectF) {
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        float[] fArray = new float[]{f10, f11, f12, f11, f12, f13, f10, f13};
        return fArray;
    }

    public static float[] sizeToVertices(Size size) {
        float f10;
        float f11 = size.getWidth();
        float[] fArray = new float[]{0.0f, 0.0f, f11, 0.0f, f11 = (float)size.getWidth(), f11 = (float)size.getHeight(), 0.0f, f10 = (float)size.getHeight()};
        return fArray;
    }

    public static int surfaceRotationToRotationDegrees(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        return 270;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected rotation value ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    IllegalStateException illegalStateException = new IllegalStateException(string2);
                    throw illegalStateException;
                }
                return 180;
            }
            return 90;
        }
        return 0;
    }

    public static RectF verticesToRect(float[] fArray) {
        float f10 = fArray[0];
        int n10 = 2;
        float f11 = fArray[n10];
        int n11 = 4;
        float f12 = fArray[n11];
        int n12 = 6;
        float f13 = fArray[n12];
        f10 = TransformUtils.min(f10, f11, f12, f13);
        int n13 = 1;
        f12 = fArray[n13];
        int n14 = 3;
        float f14 = fArray[n14];
        int n15 = 5;
        float f15 = fArray[n15];
        int n16 = 7;
        float f16 = fArray[n16];
        f12 = TransformUtils.min(f12, f14, f15, f16);
        float f17 = fArray[0];
        float f18 = fArray[n10];
        float f19 = fArray[n11];
        float f20 = fArray[n12];
        f17 = TransformUtils.max(f17, f18, f19, f20);
        f18 = fArray[n13];
        f11 = fArray[n14];
        f19 = fArray[n15];
        float f21 = fArray[n16];
        f21 = TransformUtils.max(f18, f11, f19, f21);
        RectF rectF = new RectF(f10, f12, f17, f21);
        return rectF;
    }
}

