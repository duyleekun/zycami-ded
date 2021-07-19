/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

public final class BleViewModel$PanoramaState
extends Enum {
    public static final /* enum */ BleViewModel$PanoramaState CANCEL;
    public static final /* enum */ BleViewModel$PanoramaState END;
    public static final /* enum */ BleViewModel$PanoramaState ERROR;
    public static final /* enum */ BleViewModel$PanoramaState SPLICE;
    public static final /* enum */ BleViewModel$PanoramaState START;
    private static final /* synthetic */ BleViewModel$PanoramaState[] a;

    static {
        BleViewModel$PanoramaState bleViewModel$PanoramaState;
        BleViewModel$PanoramaState bleViewModel$PanoramaState2;
        BleViewModel$PanoramaState bleViewModel$PanoramaState3;
        BleViewModel$PanoramaState bleViewModel$PanoramaState4;
        BleViewModel$PanoramaState bleViewModel$PanoramaState5;
        START = bleViewModel$PanoramaState5 = new BleViewModel$PanoramaState("START", 0);
        int n10 = 1;
        SPLICE = bleViewModel$PanoramaState4 = new BleViewModel$PanoramaState("SPLICE", n10);
        int n11 = 2;
        END = bleViewModel$PanoramaState3 = new BleViewModel$PanoramaState("END", n11);
        int n12 = 3;
        CANCEL = bleViewModel$PanoramaState2 = new BleViewModel$PanoramaState("CANCEL", n12);
        int n13 = 4;
        ERROR = bleViewModel$PanoramaState = new BleViewModel$PanoramaState("ERROR", n13);
        BleViewModel$PanoramaState[] bleViewModel$PanoramaStateArray = new BleViewModel$PanoramaState[5];
        bleViewModel$PanoramaStateArray[0] = bleViewModel$PanoramaState5;
        bleViewModel$PanoramaStateArray[n10] = bleViewModel$PanoramaState4;
        bleViewModel$PanoramaStateArray[n11] = bleViewModel$PanoramaState3;
        bleViewModel$PanoramaStateArray[n12] = bleViewModel$PanoramaState2;
        bleViewModel$PanoramaStateArray[n13] = bleViewModel$PanoramaState;
        a = bleViewModel$PanoramaStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleViewModel$PanoramaState() {
        void var2_-1;
        void var1_-1;
    }

    public static BleViewModel$PanoramaState valueOf(String string2) {
        return Enum.valueOf(BleViewModel$PanoramaState.class, string2);
    }

    public static BleViewModel$PanoramaState[] values() {
        return (BleViewModel$PanoramaState[])a.clone();
    }
}

