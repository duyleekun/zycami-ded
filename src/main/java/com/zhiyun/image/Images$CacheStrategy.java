/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.image;

public final class Images$CacheStrategy
extends Enum {
    public static final /* enum */ Images$CacheStrategy All;
    public static final /* enum */ Images$CacheStrategy DEFAULT;
    public static final /* enum */ Images$CacheStrategy NONE;
    public static final /* enum */ Images$CacheStrategy RESULT;
    public static final /* enum */ Images$CacheStrategy SOURCE;
    private static final /* synthetic */ Images$CacheStrategy[] a;

    static {
        Images$CacheStrategy images$CacheStrategy;
        Images$CacheStrategy images$CacheStrategy2;
        Images$CacheStrategy images$CacheStrategy3;
        Images$CacheStrategy images$CacheStrategy4;
        Images$CacheStrategy images$CacheStrategy5;
        All = images$CacheStrategy5 = new Images$CacheStrategy("All", 0);
        int n10 = 1;
        NONE = images$CacheStrategy4 = new Images$CacheStrategy("NONE", n10);
        int n11 = 2;
        SOURCE = images$CacheStrategy3 = new Images$CacheStrategy("SOURCE", n11);
        int n12 = 3;
        RESULT = images$CacheStrategy2 = new Images$CacheStrategy("RESULT", n12);
        int n13 = 4;
        DEFAULT = images$CacheStrategy = new Images$CacheStrategy("DEFAULT", n13);
        Images$CacheStrategy[] images$CacheStrategyArray = new Images$CacheStrategy[5];
        images$CacheStrategyArray[0] = images$CacheStrategy5;
        images$CacheStrategyArray[n10] = images$CacheStrategy4;
        images$CacheStrategyArray[n11] = images$CacheStrategy3;
        images$CacheStrategyArray[n12] = images$CacheStrategy2;
        images$CacheStrategyArray[n13] = images$CacheStrategy;
        a = images$CacheStrategyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Images$CacheStrategy() {
        void var2_-1;
        void var1_-1;
    }

    public static Images$CacheStrategy valueOf(String string2) {
        return Enum.valueOf(Images$CacheStrategy.class, string2);
    }

    public static Images$CacheStrategy[] values() {
        return (Images$CacheStrategy[])a.clone();
    }
}

