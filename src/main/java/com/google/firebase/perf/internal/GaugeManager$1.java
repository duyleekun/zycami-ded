/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.internal;

import com.google.firebase.perf.v1.ApplicationProcessState;

public class GaugeManager$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ApplicationProcessState applicationProcessState;
        int n12 = ApplicationProcessState.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState = nArray;
        try {
            applicationProcessState = ApplicationProcessState.BACKGROUND;
            n11 = applicationProcessState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$firebase$perf$v1$ApplicationProcessState;
            applicationProcessState = ApplicationProcessState.FOREGROUND;
            n11 = applicationProcessState.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

