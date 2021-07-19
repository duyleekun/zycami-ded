/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.remotetransmitter;

public final class Constant$RemoteMode
extends Enum {
    public static final /* enum */ Constant$RemoteMode CLIENT;
    public static final /* enum */ Constant$RemoteMode SERVER;
    private static final /* synthetic */ Constant$RemoteMode[] a;

    static {
        Constant$RemoteMode constant$RemoteMode;
        Constant$RemoteMode constant$RemoteMode2;
        SERVER = constant$RemoteMode2 = new Constant$RemoteMode("SERVER", 0);
        int n10 = 1;
        CLIENT = constant$RemoteMode = new Constant$RemoteMode("CLIENT", n10);
        Constant$RemoteMode[] constant$RemoteModeArray = new Constant$RemoteMode[2];
        constant$RemoteModeArray[0] = constant$RemoteMode2;
        constant$RemoteModeArray[n10] = constant$RemoteMode;
        a = constant$RemoteModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Constant$RemoteMode() {
        void var2_-1;
        void var1_-1;
    }

    public static Constant$RemoteMode valueOf(String string2) {
        return Enum.valueOf(Constant$RemoteMode.class, string2);
    }

    public static Constant$RemoteMode[] values() {
        return (Constant$RemoteMode[])a.clone();
    }
}

