/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.LongSerializationPolicy$1;
import com.google.gson.LongSerializationPolicy$2;

public abstract class LongSerializationPolicy
extends Enum {
    private static final /* synthetic */ LongSerializationPolicy[] $VALUES;
    public static final /* enum */ LongSerializationPolicy DEFAULT;
    public static final /* enum */ LongSerializationPolicy STRING;

    static {
        LongSerializationPolicy$1 longSerializationPolicy$1 = new LongSerializationPolicy$1();
        DEFAULT = longSerializationPolicy$1;
        int n10 = 1;
        LongSerializationPolicy$2 longSerializationPolicy$2 = new LongSerializationPolicy$2();
        STRING = longSerializationPolicy$2;
        LongSerializationPolicy[] longSerializationPolicyArray = new LongSerializationPolicy[2];
        longSerializationPolicyArray[0] = longSerializationPolicy$1;
        longSerializationPolicyArray[n10] = longSerializationPolicy$2;
        $VALUES = longSerializationPolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LongSerializationPolicy() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ LongSerializationPolicy(LongSerializationPolicy$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static LongSerializationPolicy valueOf(String string2) {
        return Enum.valueOf(LongSerializationPolicy.class, string2);
    }

    public static LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[])$VALUES.clone();
    }

    public abstract JsonElement serialize(Long var1);
}

