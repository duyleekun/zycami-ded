/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load;

public final class EncodeStrategy
extends Enum {
    public static final /* enum */ EncodeStrategy NONE;
    public static final /* enum */ EncodeStrategy SOURCE;
    public static final /* enum */ EncodeStrategy TRANSFORMED;
    private static final /* synthetic */ EncodeStrategy[] a;

    static {
        EncodeStrategy encodeStrategy;
        EncodeStrategy encodeStrategy2;
        EncodeStrategy encodeStrategy3;
        SOURCE = encodeStrategy3 = new EncodeStrategy("SOURCE", 0);
        int n10 = 1;
        TRANSFORMED = encodeStrategy2 = new EncodeStrategy("TRANSFORMED", n10);
        int n11 = 2;
        NONE = encodeStrategy = new EncodeStrategy("NONE", n11);
        EncodeStrategy[] encodeStrategyArray = new EncodeStrategy[3];
        encodeStrategyArray[0] = encodeStrategy3;
        encodeStrategyArray[n10] = encodeStrategy2;
        encodeStrategyArray[n11] = encodeStrategy;
        a = encodeStrategyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EncodeStrategy() {
        void var2_-1;
        void var1_-1;
    }

    public static EncodeStrategy valueOf(String string2) {
        return Enum.valueOf(EncodeStrategy.class, string2);
    }

    public static EncodeStrategy[] values() {
        return (EncodeStrategy[])a.clone();
    }
}

