/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

public final class HeartBeatInfo$HeartBeat
extends Enum {
    private static final /* synthetic */ HeartBeatInfo$HeartBeat[] $VALUES;
    public static final /* enum */ HeartBeatInfo$HeartBeat COMBINED;
    public static final /* enum */ HeartBeatInfo$HeartBeat GLOBAL;
    public static final /* enum */ HeartBeatInfo$HeartBeat NONE;
    public static final /* enum */ HeartBeatInfo$HeartBeat SDK;
    private final int code;

    static {
        HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat;
        HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat2;
        HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat3;
        HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat4;
        NONE = heartBeatInfo$HeartBeat4 = new HeartBeatInfo$HeartBeat("NONE", 0, 0);
        int n10 = 1;
        SDK = heartBeatInfo$HeartBeat3 = new HeartBeatInfo$HeartBeat("SDK", n10, n10);
        int n11 = 2;
        GLOBAL = heartBeatInfo$HeartBeat2 = new HeartBeatInfo$HeartBeat("GLOBAL", n11, n11);
        int n12 = 3;
        COMBINED = heartBeatInfo$HeartBeat = new HeartBeatInfo$HeartBeat("COMBINED", n12, n12);
        HeartBeatInfo$HeartBeat[] heartBeatInfo$HeartBeatArray = new HeartBeatInfo$HeartBeat[4];
        heartBeatInfo$HeartBeatArray[0] = heartBeatInfo$HeartBeat4;
        heartBeatInfo$HeartBeatArray[n10] = heartBeatInfo$HeartBeat3;
        heartBeatInfo$HeartBeatArray[n11] = heartBeatInfo$HeartBeat2;
        heartBeatInfo$HeartBeatArray[n12] = heartBeatInfo$HeartBeat;
        $VALUES = heartBeatInfo$HeartBeatArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HeartBeatInfo$HeartBeat() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static HeartBeatInfo$HeartBeat valueOf(String string2) {
        return Enum.valueOf(HeartBeatInfo$HeartBeat.class, string2);
    }

    public static HeartBeatInfo$HeartBeat[] values() {
        return (HeartBeatInfo$HeartBeat[])$VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }
}

