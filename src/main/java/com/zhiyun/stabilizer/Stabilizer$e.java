/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.zhiyun.protocol.constants.Model;

public class Stabilizer$e {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = Model.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = Model.WEEBILL_LAB;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = Model.CRANE3_LAB;
            n12 = object3.ordinal();
            object4[n12] = (Model)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = Model.CRANE3;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (Model)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            enum_ = Model.COV_01;
            n10 = enum_.ordinal();
            object2[n10] = (Model)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = b;
            enum_ = Model.COV_03;
            n10 = enum_.ordinal();
            int n16 = 5;
            object2[n10] = (Model)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = RxBleConnection$RxBleConnectionState.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = RxBleConnection$RxBleConnectionState.CONNECTING;
            n10 = enum_.ordinal();
            object2[n10] = (Model)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = RxBleConnection$RxBleConnectionState.CONNECTED;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)RxBleConnection$RxBleConnectionState.DISCONNECTING;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = RxBleConnection$RxBleConnectionState.DISCONNECTED;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

