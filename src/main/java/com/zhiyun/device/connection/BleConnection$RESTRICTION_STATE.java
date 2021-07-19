/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

public final class BleConnection$RESTRICTION_STATE
extends Enum {
    public static final /* enum */ BleConnection$RESTRICTION_STATE RESTRICTION_STATE_NORMAL;
    public static final /* enum */ BleConnection$RESTRICTION_STATE RESTRICTION_STATE_NO_RESTRICT;
    public static final /* enum */ BleConnection$RESTRICTION_STATE RESTRICTION_STATE_RESTRICT;
    private static final /* synthetic */ BleConnection$RESTRICTION_STATE[] a;

    static {
        BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE;
        BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE2;
        BleConnection$RESTRICTION_STATE bleConnection$RESTRICTION_STATE3;
        RESTRICTION_STATE_NORMAL = bleConnection$RESTRICTION_STATE3 = new BleConnection$RESTRICTION_STATE("RESTRICTION_STATE_NORMAL", 0);
        int n10 = 1;
        RESTRICTION_STATE_RESTRICT = bleConnection$RESTRICTION_STATE2 = new BleConnection$RESTRICTION_STATE("RESTRICTION_STATE_RESTRICT", n10);
        int n11 = 2;
        RESTRICTION_STATE_NO_RESTRICT = bleConnection$RESTRICTION_STATE = new BleConnection$RESTRICTION_STATE("RESTRICTION_STATE_NO_RESTRICT", n11);
        BleConnection$RESTRICTION_STATE[] bleConnection$RESTRICTION_STATEArray = new BleConnection$RESTRICTION_STATE[3];
        bleConnection$RESTRICTION_STATEArray[0] = bleConnection$RESTRICTION_STATE3;
        bleConnection$RESTRICTION_STATEArray[n10] = bleConnection$RESTRICTION_STATE2;
        bleConnection$RESTRICTION_STATEArray[n11] = bleConnection$RESTRICTION_STATE;
        a = bleConnection$RESTRICTION_STATEArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleConnection$RESTRICTION_STATE() {
        void var2_-1;
        void var1_-1;
    }

    public static BleConnection$RESTRICTION_STATE valueOf(String string2) {
        return Enum.valueOf(BleConnection$RESTRICTION_STATE.class, string2);
    }

    public static BleConnection$RESTRICTION_STATE[] values() {
        return (BleConnection$RESTRICTION_STATE[])a.clone();
    }
}

