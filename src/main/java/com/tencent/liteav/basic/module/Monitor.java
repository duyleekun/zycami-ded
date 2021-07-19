/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

public class Monitor {
    public static void a() {
        Monitor.nativeUnInit();
    }

    public static void a(int n10, String string2, String string3, int n11) {
        Monitor.nativeOnlineLog(n10, string2, string3, n11);
    }

    public static void a(int n10, String string2, String string3, int n11, String string4) {
        Monitor.nativeOnlineLogWithTag(n10, string2, string3, n11, string4);
    }

    public static void a(String string2, int n10, String string3) {
        Monitor.nativeInit(string2, n10, string3);
    }

    private static native void nativeInit(String var0, int var1, String var2);

    private static native void nativeOnlineLog(int var0, String var1, String var2, int var3);

    private static native void nativeOnlineLogWithTag(int var0, String var1, String var2, int var3, String var4);

    private static native void nativeUnInit();
}

