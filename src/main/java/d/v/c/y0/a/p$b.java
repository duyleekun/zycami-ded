/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import com.zhiyun.protocol.constants.Model;

public class p$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Model model;
        int n12 = Model.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            model = Model.SMOOTHQ3;
            n11 = model.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTHXS;
            n11 = model.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTHX;
            n11 = model.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

