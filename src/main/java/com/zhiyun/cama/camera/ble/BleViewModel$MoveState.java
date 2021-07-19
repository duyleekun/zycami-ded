/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

public final class BleViewModel$MoveState
extends Enum {
    public static final /* enum */ BleViewModel$MoveState CANCELLED;
    public static final /* enum */ BleViewModel$MoveState COMPLETED;
    public static final /* enum */ BleViewModel$MoveState ERROR;
    public static final /* enum */ BleViewModel$MoveState STARTED;
    public static final /* enum */ BleViewModel$MoveState STOPOVER;
    private static final /* synthetic */ BleViewModel$MoveState[] a;

    static {
        BleViewModel$MoveState bleViewModel$MoveState;
        BleViewModel$MoveState bleViewModel$MoveState2;
        BleViewModel$MoveState bleViewModel$MoveState3;
        BleViewModel$MoveState bleViewModel$MoveState4;
        BleViewModel$MoveState bleViewModel$MoveState5;
        STARTED = bleViewModel$MoveState5 = new BleViewModel$MoveState("STARTED", 0);
        int n10 = 1;
        STOPOVER = bleViewModel$MoveState4 = new BleViewModel$MoveState("STOPOVER", n10);
        int n11 = 2;
        COMPLETED = bleViewModel$MoveState3 = new BleViewModel$MoveState("COMPLETED", n11);
        int n12 = 3;
        CANCELLED = bleViewModel$MoveState2 = new BleViewModel$MoveState("CANCELLED", n12);
        int n13 = 4;
        ERROR = bleViewModel$MoveState = new BleViewModel$MoveState("ERROR", n13);
        BleViewModel$MoveState[] bleViewModel$MoveStateArray = new BleViewModel$MoveState[5];
        bleViewModel$MoveStateArray[0] = bleViewModel$MoveState5;
        bleViewModel$MoveStateArray[n10] = bleViewModel$MoveState4;
        bleViewModel$MoveStateArray[n11] = bleViewModel$MoveState3;
        bleViewModel$MoveStateArray[n12] = bleViewModel$MoveState2;
        bleViewModel$MoveStateArray[n13] = bleViewModel$MoveState;
        a = bleViewModel$MoveStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BleViewModel$MoveState() {
        void var2_-1;
        void var1_-1;
    }

    public static BleViewModel$MoveState valueOf(String string2) {
        return Enum.valueOf(BleViewModel$MoveState.class, string2);
    }

    public static BleViewModel$MoveState[] values() {
        return (BleViewModel$MoveState[])a.clone();
    }
}

