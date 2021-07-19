/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.util;

import com.tencent.liteav.basic.util.g;

public class TXCTimeUtil {
    static {
        g.f();
    }

    public static long generatePtsMS() {
        return TXCTimeUtil.nativeGeneratePtsMS();
    }

    public static long getClockTickInHz() {
        return TXCTimeUtil.nativeGetClockTickInHz();
    }

    public static long getTimeTick() {
        return TXCTimeUtil.nativeGetTimeTick();
    }

    public static long getUtcTimeTick() {
        return TXCTimeUtil.nativeGetUtcTimeTick();
    }

    public static void initAppStartTime() {
        TXCTimeUtil.nativeInitAppStartTime();
    }

    private static native long nativeGeneratePtsMS();

    private static native long nativeGetClockTickInHz();

    private static native long nativeGetTimeTick();

    private static native long nativeGetUtcTimeTick();

    private static native void nativeInitAppStartTime();
}

