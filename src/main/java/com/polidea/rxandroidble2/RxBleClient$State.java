/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2;

public final class RxBleClient$State
extends Enum {
    public static final /* enum */ RxBleClient$State BLUETOOTH_NOT_AVAILABLE;
    public static final /* enum */ RxBleClient$State BLUETOOTH_NOT_ENABLED;
    public static final /* enum */ RxBleClient$State LOCATION_PERMISSION_NOT_GRANTED;
    public static final /* enum */ RxBleClient$State LOCATION_SERVICES_NOT_ENABLED;
    public static final /* enum */ RxBleClient$State READY;
    private static final /* synthetic */ RxBleClient$State[] a;

    static {
        RxBleClient$State rxBleClient$State;
        RxBleClient$State rxBleClient$State2;
        RxBleClient$State rxBleClient$State3;
        RxBleClient$State rxBleClient$State4;
        RxBleClient$State rxBleClient$State5;
        BLUETOOTH_NOT_AVAILABLE = rxBleClient$State5 = new RxBleClient$State("BLUETOOTH_NOT_AVAILABLE", 0);
        int n10 = 1;
        LOCATION_PERMISSION_NOT_GRANTED = rxBleClient$State4 = new RxBleClient$State("LOCATION_PERMISSION_NOT_GRANTED", n10);
        int n11 = 2;
        BLUETOOTH_NOT_ENABLED = rxBleClient$State3 = new RxBleClient$State("BLUETOOTH_NOT_ENABLED", n11);
        int n12 = 3;
        LOCATION_SERVICES_NOT_ENABLED = rxBleClient$State2 = new RxBleClient$State("LOCATION_SERVICES_NOT_ENABLED", n12);
        int n13 = 4;
        READY = rxBleClient$State = new RxBleClient$State("READY", n13);
        RxBleClient$State[] rxBleClient$StateArray = new RxBleClient$State[5];
        rxBleClient$StateArray[0] = rxBleClient$State5;
        rxBleClient$StateArray[n10] = rxBleClient$State4;
        rxBleClient$StateArray[n11] = rxBleClient$State3;
        rxBleClient$StateArray[n12] = rxBleClient$State2;
        rxBleClient$StateArray[n13] = rxBleClient$State;
        a = rxBleClient$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RxBleClient$State() {
        void var2_-1;
        void var1_-1;
    }

    public static RxBleClient$State valueOf(String string2) {
        return Enum.valueOf(RxBleClient$State.class, string2);
    }

    public static RxBleClient$State[] values() {
        return (RxBleClient$State[])a.clone();
    }
}

