/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

public class TXCEventRecorderProxy {
    private long a;

    public static void a(String string2, int n10, long l10, long l11, String string3, int n11) {
        if (string2 != null && string3 != null) {
            TXCEventRecorderProxy.nativeAddEventMsg(string2, n10, l10, l11, string3, n11);
        }
    }

    private static native void nativeAddEventMsg(String var0, int var1, long var2, long var4, String var6, int var7);

    private static native void nativeRelease(long var0);

    public void finalize() {
        TXCEventRecorderProxy.nativeRelease(this.a);
        this.a = 0L;
        super.finalize();
    }
}

