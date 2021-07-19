/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import com.zhiyun.protocol.constants.WorkingMode;

public class q6$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WorkingMode workingMode;
        int n12 = WorkingMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            workingMode = WorkingMode.L;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            workingMode = WorkingMode.F;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            workingMode = WorkingMode.POV;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            workingMode = WorkingMode.GO;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            workingMode = WorkingMode.THREE_DIMENSION;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            workingMode = WorkingMode.PF;
            n11 = workingMode.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

