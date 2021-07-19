/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.module;

public class TXCStatus {
    public static long a(String string2, int n10) {
        return TXCStatus.a(string2, n10, 0);
    }

    public static long a(String string2, int n10, int n11) {
        return TXCStatus.nativeStatusGetIntValue(string2, n10, n11);
    }

    public static void a(String string2) {
        TXCStatus.nativeStatusStartRecord(string2);
    }

    public static boolean a(String string2, int n10, int n11, Object object) {
        int n12;
        boolean bl2 = false;
        if (string2 != null && (n12 = string2.length()) != 0) {
            if (object == null) {
                return false;
            }
            bl2 = object instanceof Double;
            if (bl2) {
                double d10 = (Double)object;
                return TXCStatus.nativeStatusSetDoubleValue(string2, n10, n11, d10);
            }
            bl2 = object instanceof String;
            if (bl2) {
                object = (String)object;
                return TXCStatus.nativeStatusSetStrValue(string2, n10, n11, (String)object);
            }
            bl2 = object instanceof Long;
            if (bl2) {
                long l10 = (Long)object;
                return TXCStatus.nativeStatusSetIntValue(string2, n10, n11, l10);
            }
            long l11 = ((Integer)object).intValue();
            return TXCStatus.nativeStatusSetIntValue(string2, n10, n11, l11);
        }
        return false;
    }

    public static boolean a(String string2, int n10, Object object) {
        return TXCStatus.a(string2, n10, 0, object);
    }

    public static String b(String string2, int n10) {
        return TXCStatus.b(string2, n10, 0);
    }

    public static String b(String string2, int n10, int n11) {
        return TXCStatus.nativeStatusGetStrValue(string2, n10, n11);
    }

    public static void b(String string2) {
        TXCStatus.nativeStatusStopRecord(string2);
    }

    public static int c(String string2, int n10) {
        return TXCStatus.c(string2, n10, 0);
    }

    public static int c(String string2, int n10, int n11) {
        return (int)TXCStatus.nativeStatusGetIntValue(string2, n10, n11);
    }

    public static double d(String string2, int n10) {
        return TXCStatus.d(string2, n10, 0);
    }

    public static double d(String string2, int n10, int n11) {
        return TXCStatus.nativeStatusGetDoubleValue(string2, n10, n11);
    }

    private static native double nativeStatusGetDoubleValue(String var0, int var1, int var2);

    private static native long nativeStatusGetIntValue(String var0, int var1, int var2);

    private static native String nativeStatusGetStrValue(String var0, int var1, int var2);

    private static native boolean nativeStatusSetDoubleValue(String var0, int var1, int var2, double var3);

    private static native boolean nativeStatusSetIntValue(String var0, int var1, int var2, long var3);

    private static native boolean nativeStatusSetStrValue(String var0, int var1, int var2, String var3);

    private static native void nativeStatusStartRecord(String var0);

    private static native void nativeStatusStopRecord(String var0);
}

