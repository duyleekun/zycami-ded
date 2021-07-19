/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

public final class ExoTimeoutException
extends Exception {
    public static final int TIMEOUT_OPERATION_DETACH_SURFACE = 3;
    public static final int TIMEOUT_OPERATION_RELEASE = 1;
    public static final int TIMEOUT_OPERATION_SET_FOREGROUND_MODE = 2;
    public static final int TIMEOUT_OPERATION_UNDEFINED;
    public final int timeoutOperation;

    public ExoTimeoutException(int n10) {
        String string2 = ExoTimeoutException.getErrorMessage(n10);
        super(string2);
        this.timeoutOperation = n10;
    }

    private static String getErrorMessage(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return "Undefined timeout.";
                }
                return "Detaching surface timed out.";
            }
            return "Setting foreground mode timed out.";
        }
        return "Player release timed out.";
    }
}

