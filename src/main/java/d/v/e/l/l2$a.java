/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l;

import java.math.RoundingMode;

public class l2$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        RoundingMode roundingMode;
        int n12 = RoundingMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            roundingMode = RoundingMode.FLOOR;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            roundingMode = RoundingMode.CEILING;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            roundingMode = RoundingMode.HALF_UP;
            n11 = roundingMode.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

