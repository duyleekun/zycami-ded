/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$2;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$3;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;

public abstract class CycleDetectingLockFactory$Policies
extends Enum
implements CycleDetectingLockFactory$Policy {
    private static final /* synthetic */ CycleDetectingLockFactory$Policies[] $VALUES;
    public static final /* enum */ CycleDetectingLockFactory$Policies DISABLED;
    public static final /* enum */ CycleDetectingLockFactory$Policies THROW;
    public static final /* enum */ CycleDetectingLockFactory$Policies WARN;

    static {
        CycleDetectingLockFactory$Policies$1 cycleDetectingLockFactory$Policies$1 = new CycleDetectingLockFactory$Policies$1();
        THROW = cycleDetectingLockFactory$Policies$1;
        int n10 = 1;
        CycleDetectingLockFactory$Policies$2 cycleDetectingLockFactory$Policies$2 = new CycleDetectingLockFactory$Policies$2();
        WARN = cycleDetectingLockFactory$Policies$2;
        int n11 = 2;
        CycleDetectingLockFactory$Policies$3 cycleDetectingLockFactory$Policies$3 = new CycleDetectingLockFactory$Policies$3();
        DISABLED = cycleDetectingLockFactory$Policies$3;
        CycleDetectingLockFactory$Policies[] cycleDetectingLockFactory$PoliciesArray = new CycleDetectingLockFactory$Policies[3];
        cycleDetectingLockFactory$PoliciesArray[0] = cycleDetectingLockFactory$Policies$1;
        cycleDetectingLockFactory$PoliciesArray[n10] = cycleDetectingLockFactory$Policies$2;
        cycleDetectingLockFactory$PoliciesArray[n11] = cycleDetectingLockFactory$Policies$3;
        $VALUES = cycleDetectingLockFactory$PoliciesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CycleDetectingLockFactory$Policies() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ CycleDetectingLockFactory$Policies(CycleDetectingLockFactory$1 cycleDetectingLockFactory$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static CycleDetectingLockFactory$Policies valueOf(String string2) {
        return Enum.valueOf(CycleDetectingLockFactory$Policies.class, string2);
    }

    public static CycleDetectingLockFactory$Policies[] values() {
        return (CycleDetectingLockFactory$Policies[])$VALUES.clone();
    }
}

