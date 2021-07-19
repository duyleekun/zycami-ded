/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1;

import com.zhiyun.protocol.message.usb.LenType;

public class b$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        LenType lenType;
        int n12 = LenType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            lenType = LenType.BIT_1;
            n11 = lenType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lenType = LenType.BIT_2;
            n11 = lenType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            lenType = LenType.BIT_4;
            n11 = lenType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

