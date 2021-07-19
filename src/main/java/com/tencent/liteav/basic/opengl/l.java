/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.opengl;

import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l$1;

public class l {
    public static final float[] a;
    public static final float[] b;
    public static final float[] c;
    public static final float[] d;
    public static final float[] e;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 8;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = 0.0f;
        fArray4[1] = 1.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = 1.0f;
        fArray3[4] = 0.0f;
        fArray4[5] = 0.0f;
        fArray3[6] = 1.0f;
        fArray4[7] = 0.0f;
        a = fArray2;
        float[] fArray5 = fArray2 = new float[n10];
        float[] fArray6 = fArray2;
        fArray5[0] = 1.0f;
        fArray6[1] = 1.0f;
        fArray5[2] = 1.0f;
        fArray6[3] = 0.0f;
        fArray5[4] = 0.0f;
        fArray6[5] = 1.0f;
        fArray5[6] = 0.0f;
        fArray6[7] = 0.0f;
        b = fArray2;
        float[] fArray7 = fArray2 = new float[n10];
        float[] fArray8 = fArray2;
        fArray7[0] = 1.0f;
        fArray8[1] = 0.0f;
        fArray7[2] = 0.0f;
        fArray8[3] = 0.0f;
        fArray7[4] = 1.0f;
        fArray8[5] = 1.0f;
        fArray7[6] = 0.0f;
        fArray8[7] = 1.0f;
        c = fArray2;
        float[] fArray9 = fArray2 = new float[n10];
        float[] fArray10 = fArray2;
        fArray9[0] = 0.0f;
        fArray10[1] = 0.0f;
        fArray9[2] = 0.0f;
        fArray10[3] = 1.0f;
        fArray9[4] = 1.0f;
        fArray10[5] = 0.0f;
        fArray9[6] = 1.0f;
        fArray10[7] = 1.0f;
        d = fArray2;
        float[] fArray11 = fArray = new float[n10];
        float[] fArray12 = fArray;
        fArray11[0] = -1.0f;
        fArray12[1] = -1.0f;
        fArray11[2] = 1.0f;
        fArray12[3] = -1.0f;
        fArray11[4] = -1.0f;
        fArray12[5] = 1.0f;
        fArray11[6] = 1.0f;
        fArray12[7] = 1.0f;
        e = fArray;
    }

    private static float a(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object == false) {
            return 1.0f;
        }
        return 0.0f;
    }

    public static float[] a(k object, boolean bl2, boolean bl3) {
        Object object2;
        float[] fArray;
        int[] nArray = l$1.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 3;
        int n12 = 2;
        int n13 = 1;
        object = n10 != n13 ? (n10 != n12 ? (n10 != n11 ? (Object)((float[])a.clone()) : (Object)((float[])d.clone())) : (Object)((float[])c.clone())) : (Object)((float[])b.clone());
        int n14 = 8;
        int n15 = 7;
        int n16 = 6;
        int n17 = 5;
        int n18 = 4;
        if (bl2) {
            float f10;
            fArray = new float[n14];
            fArray[0] = f10 = l.a((float)object[0]);
            fArray[n13] = f10 = (float)object[n13];
            fArray[n12] = f10 = l.a((float)object[n12]);
            fArray[n11] = f10 = (float)object[n11];
            fArray[n18] = f10 = l.a((float)object[n18]);
            fArray[n17] = f10 = (float)object[n17];
            fArray[n16] = f10 = l.a((float)object[n16]);
            object2 = object[n15];
            fArray[n15] = (float)object2;
            object = fArray;
        }
        if (bl3) {
            fArray = new float[n14];
            Object object3 = object[0];
            fArray[0] = (float)object3;
            object3 = l.a((float)object[n13]);
            fArray[n13] = (float)object3;
            object3 = object[n12];
            fArray[n12] = (float)object3;
            object3 = l.a((float)object[n11]);
            fArray[n11] = (float)object3;
            object3 = object[n18];
            fArray[n18] = (float)object3;
            object3 = l.a((float)object[n17]);
            fArray[n17] = (float)object3;
            object3 = object[n16];
            fArray[n16] = (float)object3;
            object2 = l.a((float)object[n15]);
            fArray[n15] = (float)object2;
            object = fArray;
        }
        return object;
    }
}

