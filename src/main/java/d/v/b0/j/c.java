/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.Matrix
 */
package d.v.b0.j;

import android.opengl.Matrix;

public class c {
    /*
     * WARNING - void declaration
     */
    public static float[] a(float[] fArray, boolean bl2, boolean bl3) {
        void var2_4;
        if (bl2 || var2_4 != false) {
            float f10;
            int n10 = -1082130432;
            float f11 = -1.0f;
            int n11 = 1065353216;
            float f12 = 1.0f;
            if (bl2) {
                int n12 = n10;
                f10 = f11;
            } else {
                int n13 = n11;
                f10 = f12;
            }
            if (var2_4 == false) {
                n10 = n11;
                f11 = f12;
            }
            Matrix.scaleM((float[])fArray, (int)0, (float)f10, (float)f11, (float)f12);
        }
        return fArray;
    }

    public static float[] b() {
        float[] fArray;
        float[] fArray2 = fArray = new float[16];
        float[] fArray3 = fArray;
        fArray2[0] = 1.0f;
        fArray3[1] = 0.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 0.0f;
        fArray2[4] = 0.0f;
        fArray3[5] = 1.0f;
        fArray2[6] = 0.0f;
        fArray3[7] = 0.0f;
        fArray2[8] = 0.0f;
        fArray3[9] = 0.0f;
        fArray2[10] = 1.0f;
        fArray3[11] = 0.0f;
        fArray2[12] = 0.0f;
        fArray3[13] = 0.0f;
        fArray2[14] = 0.0f;
        fArray3[15] = 1.0f;
        return fArray;
    }

    public static float[] c() {
        float[] fArray;
        float[] fArray2 = fArray = new float[8];
        float[] fArray3 = fArray;
        fArray2[0] = 0.0f;
        fArray3[1] = 0.0f;
        fArray2[2] = 0.0f;
        fArray3[3] = 1.0f;
        fArray2[4] = 1.0f;
        fArray3[5] = 0.0f;
        fArray2[6] = 1.0f;
        fArray3[7] = 1.0f;
        return fArray;
    }

    public static float[] d() {
        float[] fArray;
        float[] fArray2 = fArray = new float[8];
        float[] fArray3 = fArray;
        fArray2[0] = -1.0f;
        fArray3[1] = 1.0f;
        fArray2[2] = -1.0f;
        fArray3[3] = -1.0f;
        fArray2[4] = 1.0f;
        fArray3[5] = 1.0f;
        fArray2[6] = 1.0f;
        fArray3[7] = -1.0f;
        return fArray;
    }

    public static float[] e(float[] fArray, float f10, float f11) {
        Matrix.scaleM((float[])fArray, (int)0, (float)f10, (float)f11, (float)1.0f);
        return fArray;
    }
}

