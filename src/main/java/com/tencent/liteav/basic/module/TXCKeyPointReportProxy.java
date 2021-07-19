/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

public class TXCKeyPointReportProxy {
    public static void a(int n10) {
        TXCKeyPointReportProxy.nativeTagKeyPointStart(n10);
    }

    public static void a(int n10, int n11) {
        TXCKeyPointReportProxy.nativeTagKeyPointEnd(n10, n11);
    }

    public static void a(int n10, int n11, int n12) {
        TXCKeyPointReportProxy.nativeSetLocalQuality(n10, n11, n12);
    }

    public static void a(String string2, int n10) {
        TXCKeyPointReportProxy.nativeTagKeyPointVideo(string2, n10);
    }

    public static void a(String string2, int n10, long l10, int n11) {
        TXCKeyPointReportProxy.nativesetRemoteQuality(string2, n10, l10, n11);
    }

    private static native void nativeSetLocalQuality(int var0, int var1, int var2);

    private static native void nativeTagKeyPointEnd(int var0, int var1);

    private static native void nativeTagKeyPointStart(int var0);

    private static native void nativeTagKeyPointVideo(String var0, int var1);

    private static native void nativesetRemoteQuality(String var0, int var1, long var2, int var4);
}

