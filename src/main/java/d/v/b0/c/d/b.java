/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.c.d;

import d.v.b0.f.c.b.a;

public class b
extends a {
    private static final float[] h;
    private static final float[] i;

    static {
        float[] fArray;
        float[] fArray2;
        int n10 = 8;
        float[] fArray3 = fArray2 = new float[n10];
        float[] fArray4 = fArray2;
        fArray3[0] = -1.0f;
        fArray4[1] = -1.0f;
        fArray3[2] = 1.0f;
        fArray4[3] = -1.0f;
        fArray3[4] = -1.0f;
        fArray4[5] = 1.0f;
        fArray3[6] = 1.0f;
        fArray4[7] = 1.0f;
        h = fArray2;
        float[] fArray5 = fArray = new float[n10];
        float[] fArray6 = fArray;
        fArray5[0] = 0.0f;
        fArray6[1] = 1.0f;
        fArray5[2] = 1.0f;
        fArray6[3] = 1.0f;
        fArray5[4] = 0.0f;
        fArray6[5] = 0.0f;
        fArray5[6] = 1.0f;
        fArray6[7] = 0.0f;
        i = fArray;
    }

    public b() {
        float[] fArray = h;
        float[] fArray2 = i;
        super(fArray, fArray2);
    }
}

