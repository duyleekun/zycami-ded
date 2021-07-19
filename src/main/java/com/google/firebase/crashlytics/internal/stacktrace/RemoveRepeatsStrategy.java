/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.util.HashMap;

public class RemoveRepeatsStrategy
implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    public RemoveRepeatsStrategy(int n10) {
        this.maxRepetitions = n10;
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArray, int n10, int n11) {
        int n12 = n11 - n10;
        int n13 = n11 + n12;
        int n14 = stackTraceElementArray.length;
        if (n13 > n14) {
            return false;
        }
        for (n13 = 0; n13 < n12; ++n13) {
            n14 = n10 + n13;
            StackTraceElement stackTraceElement = stackTraceElementArray[n14];
            int n15 = n11 + n13;
            StackTraceElement stackTraceElement2 = stackTraceElementArray[n15];
            if ((n14 = (int)(stackTraceElement.equals(stackTraceElement2) ? 1 : 0)) != 0) continue;
            return false;
        }
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private static StackTraceElement[] trimRepeats(StackTraceElement[] var0, int var1_1) {
        var2_2 = new HashMap<StackTraceElement, Integer>();
        var3_3 = var0.length;
        var4_4 = new StackTraceElement[var3_3];
        var5_5 = 1;
        var6_6 = 0;
        var7_7 = null;
        var8_8 = 0;
        var9_9 = var5_5;
        while (var6_6 < (var10_10 = var0.length)) {
            var11_11 = var0[var6_6];
            var12_12 = (Integer)var2_2.get(var11_11);
            if (var12_12 == null) ** GOTO lbl-1000
            var13_13 = var12_12;
            if ((var13_13 = (int)RemoveRepeatsStrategy.isRepeatingSequence(var0, var13_13, var6_6)) != 0) {
                var14_14 = var12_12;
                var14_14 = var6_6 - var14_14;
                if (var9_9 < var1_1) {
                    System.arraycopy(var0, var6_6, var4_4, var8_8, var14_14);
                    var8_8 += var14_14;
                    ++var9_9;
                }
                var14_14 = var14_14 + -1 + var6_6;
            } else lbl-1000:
            // 2 sources

            {
                var4_4[var8_8] = var15_15 = var0[var6_6];
                ++var8_8;
                var9_9 = var5_5;
                var14_14 = var6_6;
            }
            var7_7 = var6_6;
            var2_2.put(var11_11, var7_7);
            var6_6 = var14_14 + 1;
        }
        var0 = new StackTraceElement[var8_8];
        System.arraycopy(var4_4, 0, var0, 0, var8_8);
        return var0;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArray) {
        int n10;
        int n11 = this.maxRepetitions;
        StackTraceElement[] stackTraceElementArray2 = RemoveRepeatsStrategy.trimRepeats(stackTraceElementArray, n11);
        int n12 = stackTraceElementArray2.length;
        if (n12 < (n10 = stackTraceElementArray.length)) {
            return stackTraceElementArray2;
        }
        return stackTraceElementArray;
    }
}

