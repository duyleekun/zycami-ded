/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0.k;

import com.zhiyun.vtpusher.VtDataType;

public class f$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        VtDataType vtDataType;
        int n12 = VtDataType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            vtDataType = VtDataType.ByteType;
            n11 = vtDataType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            vtDataType = VtDataType.SurfaceType;
            n11 = vtDataType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

