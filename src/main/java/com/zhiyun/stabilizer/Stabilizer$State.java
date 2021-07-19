/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer;

public final class Stabilizer$State
extends Enum {
    public static final /* enum */ Stabilizer$State CONNECTED;
    public static final /* enum */ Stabilizer$State CONNECTING;
    public static final /* enum */ Stabilizer$State DISCONNECTED;
    public static final /* enum */ Stabilizer$State DISCONNECTING;
    private static final /* synthetic */ Stabilizer$State[] a;

    static {
        Stabilizer$State stabilizer$State;
        Stabilizer$State stabilizer$State2;
        Stabilizer$State stabilizer$State3;
        Stabilizer$State stabilizer$State4;
        CONNECTING = stabilizer$State4 = new Stabilizer$State("CONNECTING", 0);
        int n10 = 1;
        CONNECTED = stabilizer$State3 = new Stabilizer$State("CONNECTED", n10);
        int n11 = 2;
        DISCONNECTING = stabilizer$State2 = new Stabilizer$State("DISCONNECTING", n11);
        int n12 = 3;
        DISCONNECTED = stabilizer$State = new Stabilizer$State("DISCONNECTED", n12);
        Stabilizer$State[] stabilizer$StateArray = new Stabilizer$State[4];
        stabilizer$StateArray[0] = stabilizer$State4;
        stabilizer$StateArray[n10] = stabilizer$State3;
        stabilizer$StateArray[n11] = stabilizer$State2;
        stabilizer$StateArray[n12] = stabilizer$State;
        a = stabilizer$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Stabilizer$State() {
        void var2_-1;
        void var1_-1;
    }

    public static Stabilizer$State valueOf(String string2) {
        return Enum.valueOf(Stabilizer$State.class, string2);
    }

    public static Stabilizer$State[] values() {
        return (Stabilizer$State[])a.clone();
    }
}

