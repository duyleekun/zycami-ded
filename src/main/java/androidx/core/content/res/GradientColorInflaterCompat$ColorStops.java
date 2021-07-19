/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

import java.util.List;

public final class GradientColorInflaterCompat$ColorStops {
    public final int[] mColors;
    public final float[] mOffsets;

    public GradientColorInflaterCompat$ColorStops(int n10, int n11) {
        int n12 = 2;
        int[] nArray = new int[n12];
        nArray[0] = n10;
        nArray[1] = n11;
        this.mColors = nArray;
        float[] fArray = new float[n12];
        fArray[0] = 0.0f;
        fArray[1] = 1.0f;
        this.mOffsets = fArray;
    }

    public GradientColorInflaterCompat$ColorStops(int n10, int n11, int n12) {
        float[] fArray;
        int n13 = 3;
        int[] nArray = new int[n13];
        nArray[0] = n10;
        nArray[1] = n11;
        nArray[2] = n12;
        this.mColors = nArray;
        float[] fArray2 = fArray = new float[n13];
        fArray[0] = 0.0f;
        fArray2[1] = 0.5f;
        fArray2[2] = 1.0f;
        this.mOffsets = fArray;
    }

    public GradientColorInflaterCompat$ColorStops(List list, List list2) {
        int n10 = list.size();
        Object[] objectArray = new int[n10];
        this.mColors = objectArray;
        objectArray = new float[n10];
        this.mOffsets = objectArray;
        objectArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Object[] objectArray2 = this.mColors;
            objectArray2[i10] = n11 = ((Integer)list.get(i10)).intValue();
            objectArray2 = this.mOffsets;
            Float f10 = (Float)list2.get(i10);
            float f11 = f10.floatValue();
            objectArray2[i10] = (int)f11;
        }
    }
}

