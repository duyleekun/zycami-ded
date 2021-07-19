/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;

public class MiddleOutFallbackStrategy
implements StackTraceTrimmingStrategy {
    private final int maximumStackSize;
    private final MiddleOutStrategy middleOutStrategy;
    private final StackTraceTrimmingStrategy[] trimmingStrategies;

    public MiddleOutFallbackStrategy(int n10, StackTraceTrimmingStrategy ... object) {
        this.maximumStackSize = n10;
        this.trimmingStrategies = object;
        super(n10);
        this.middleOutStrategy = object;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] object) {
        int n10;
        int n11 = ((StackTraceElement[])object).length;
        int n12 = this.maximumStackSize;
        if (n11 <= n12) {
            return object;
        }
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArray = this.trimmingStrategies;
        n12 = stackTraceTrimmingStrategyArray.length;
        StackTraceElement[] stackTraceElementArray = object;
        for (int i10 = 0; i10 < n12; ++i10) {
            StackTraceTrimmingStrategy stackTraceTrimmingStrategy = stackTraceTrimmingStrategyArray[i10];
            int n13 = stackTraceElementArray.length;
            int n14 = this.maximumStackSize;
            if (n13 <= n14) break;
            stackTraceElementArray = stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])object);
        }
        if ((n10 = stackTraceElementArray.length) > (n11 = this.maximumStackSize)) {
            object = this.middleOutStrategy;
            stackTraceElementArray = ((MiddleOutStrategy)object).getTrimmedStackTrace(stackTraceElementArray);
        }
        return stackTraceElementArray;
    }
}

