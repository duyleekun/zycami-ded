/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

public final class ErrorMode
extends Enum {
    public static final /* enum */ ErrorMode BOUNDARY;
    public static final /* enum */ ErrorMode END;
    public static final /* enum */ ErrorMode IMMEDIATE;
    private static final /* synthetic */ ErrorMode[] a;

    static {
        ErrorMode errorMode;
        ErrorMode errorMode2;
        ErrorMode errorMode3;
        IMMEDIATE = errorMode3 = new ErrorMode("IMMEDIATE", 0);
        int n10 = 1;
        BOUNDARY = errorMode2 = new ErrorMode("BOUNDARY", n10);
        int n11 = 2;
        END = errorMode = new ErrorMode("END", n11);
        ErrorMode[] errorModeArray = new ErrorMode[3];
        errorModeArray[0] = errorMode3;
        errorModeArray[n10] = errorMode2;
        errorModeArray[n11] = errorMode;
        a = errorModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ErrorMode() {
        void var2_-1;
        void var1_-1;
    }

    public static ErrorMode valueOf(String string2) {
        return Enum.valueOf(ErrorMode.class, string2);
    }

    public static ErrorMode[] values() {
        return (ErrorMode[])a.clone();
    }
}

