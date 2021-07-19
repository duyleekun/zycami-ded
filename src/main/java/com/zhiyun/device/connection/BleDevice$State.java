/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleDevice$State
extends Enum {
    public static final /* enum */ BleDevice$State CONNECTED;
    public static final /* enum */ BleDevice$State CONNECTING;
    public static final /* enum */ BleDevice$State UNCONNECTED;
    private static final /* synthetic */ BleDevice$State[] a;

    static {
        BleDevice$State bleDevice$State;
        BleDevice$State bleDevice$State2;
        BleDevice$State bleDevice$State3;
        UNCONNECTED = bleDevice$State3 = new BleDevice$State("UNCONNECTED", 0);
        int n10 = 1;
        CONNECTING = bleDevice$State2 = new BleDevice$State("CONNECTING", n10);
        int n11 = 2;
        CONNECTED = bleDevice$State = new BleDevice$State("CONNECTED", n11);
        BleDevice$State[] bleDevice$StateArray = new BleDevice$State[3];
        bleDevice$StateArray[0] = bleDevice$State3;
        bleDevice$StateArray[n10] = bleDevice$State2;
        bleDevice$StateArray[n11] = bleDevice$State;
        a = bleDevice$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleDevice$State() {
        void var2_-1;
        void var1_-1;
    }

    public static BleDevice$State valueOf(String string2) {
        return Enum.valueOf(BleDevice$State.class, string2);
    }

    public static BleDevice$State[] values() {
        return (BleDevice$State[])a.clone();
    }
}

