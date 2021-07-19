/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import com.zhiyun.protocol.constants.Model;

public class k0$b {
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
            model = Model.SMOOTHX;
            n11 = model.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTHXS;
            n11 = model.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

