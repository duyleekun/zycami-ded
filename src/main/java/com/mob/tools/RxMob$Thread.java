/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools;

public final class RxMob$Thread
extends Enum {
    private static final /* synthetic */ RxMob$Thread[] $VALUES;
    public static final /* enum */ RxMob$Thread IMMEDIATE;
    public static final /* enum */ RxMob$Thread NEW_THREAD;
    public static final /* enum */ RxMob$Thread UI_THREAD;

    static {
        RxMob$Thread rxMob$Thread;
        RxMob$Thread rxMob$Thread2;
        RxMob$Thread rxMob$Thread3;
        IMMEDIATE = rxMob$Thread3 = new RxMob$Thread("IMMEDIATE", 0);
        int n10 = 1;
        UI_THREAD = rxMob$Thread2 = new RxMob$Thread("UI_THREAD", n10);
        int n11 = 2;
        NEW_THREAD = rxMob$Thread = new RxMob$Thread("NEW_THREAD", n11);
        RxMob$Thread[] rxMob$ThreadArray = new RxMob$Thread[3];
        rxMob$ThreadArray[0] = rxMob$Thread3;
        rxMob$ThreadArray[n10] = rxMob$Thread2;
        rxMob$ThreadArray[n11] = rxMob$Thread;
        $VALUES = rxMob$ThreadArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RxMob$Thread() {
        void var2_-1;
        void var1_-1;
    }

    public static RxMob$Thread valueOf(String string2) {
        return Enum.valueOf(RxMob$Thread.class, string2);
    }

    public static RxMob$Thread[] values() {
        return (RxMob$Thread[])$VALUES.clone();
    }
}

