/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;

public class he$a {
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
            model = Model.CRANE;
            n11 = model.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.CRANE2;
            n11 = model.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.CRANE_M;
            n11 = model.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.CRANE_PLUS;
            n11 = model.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTH;
            n11 = model.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTH2;
            n11 = model.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SMOOTHQ;
            n11 = model.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.PROUND;
            n11 = model.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.RIDER_M;
            n11 = model.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.EVOLUTION;
            n11 = model.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.SHINING;
            n11 = model.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            model = Model.C11;
            n11 = model.ordinal();
            nArray[n11] = n10 = 12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

