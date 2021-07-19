/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.RemovalCause$1;
import com.google.common.cache.RemovalCause$2;
import com.google.common.cache.RemovalCause$3;
import com.google.common.cache.RemovalCause$4;
import com.google.common.cache.RemovalCause$5;

public abstract class RemovalCause
extends Enum {
    private static final /* synthetic */ RemovalCause[] $VALUES;
    public static final /* enum */ RemovalCause COLLECTED;
    public static final /* enum */ RemovalCause EXPIRED;
    public static final /* enum */ RemovalCause EXPLICIT;
    public static final /* enum */ RemovalCause REPLACED;
    public static final /* enum */ RemovalCause SIZE;

    static {
        RemovalCause$1 removalCause$1 = new RemovalCause$1();
        EXPLICIT = removalCause$1;
        int n10 = 1;
        RemovalCause$2 removalCause$2 = new RemovalCause$2();
        REPLACED = removalCause$2;
        int n11 = 2;
        RemovalCause$3 removalCause$3 = new RemovalCause$3();
        COLLECTED = removalCause$3;
        int n12 = 3;
        RemovalCause$4 removalCause$4 = new RemovalCause$4();
        EXPIRED = removalCause$4;
        int n13 = 4;
        RemovalCause$5 removalCause$5 = new RemovalCause$5();
        SIZE = removalCause$5;
        RemovalCause[] removalCauseArray = new RemovalCause[5];
        removalCauseArray[0] = removalCause$1;
        removalCauseArray[n10] = removalCause$2;
        removalCauseArray[n11] = removalCause$3;
        removalCauseArray[n12] = removalCause$4;
        removalCauseArray[n13] = removalCause$5;
        $VALUES = removalCauseArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RemovalCause() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ RemovalCause(RemovalCause$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static RemovalCause valueOf(String string2) {
        return Enum.valueOf(RemovalCause.class, string2);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[])$VALUES.clone();
    }

    public abstract boolean wasEvicted();
}

