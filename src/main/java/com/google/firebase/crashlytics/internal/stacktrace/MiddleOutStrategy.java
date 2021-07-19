/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;

public class MiddleOutStrategy
implements StackTraceTrimmingStrategy {
    private final int trimmedSize;

    public MiddleOutStrategy(int n10) {
        this.trimmedSize = n10;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArray) {
        int n10 = stackTraceElementArray.length;
        int n11 = this.trimmedSize;
        if (n10 <= n11) {
            return stackTraceElementArray;
        }
        n10 = n11 / 2;
        int n12 = n11 - n10;
        StackTraceElement[] stackTraceElementArray2 = new StackTraceElement[n11];
        System.arraycopy(stackTraceElementArray, 0, stackTraceElementArray2, 0, n12);
        int n13 = stackTraceElementArray.length - n10;
        System.arraycopy(stackTraceElementArray, n13, stackTraceElementArray2, n12, n10);
        return stackTraceElementArray2;
    }
}

