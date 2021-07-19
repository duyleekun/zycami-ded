/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex;

public final class BackpressureStrategy
extends Enum {
    public static final /* enum */ BackpressureStrategy BUFFER;
    public static final /* enum */ BackpressureStrategy DROP;
    public static final /* enum */ BackpressureStrategy ERROR;
    public static final /* enum */ BackpressureStrategy LATEST;
    public static final /* enum */ BackpressureStrategy MISSING;
    private static final /* synthetic */ BackpressureStrategy[] a;

    static {
        BackpressureStrategy backpressureStrategy;
        BackpressureStrategy backpressureStrategy2;
        BackpressureStrategy backpressureStrategy3;
        BackpressureStrategy backpressureStrategy4;
        BackpressureStrategy backpressureStrategy5;
        MISSING = backpressureStrategy5 = new BackpressureStrategy("MISSING", 0);
        int n10 = 1;
        ERROR = backpressureStrategy4 = new BackpressureStrategy("ERROR", n10);
        int n11 = 2;
        BUFFER = backpressureStrategy3 = new BackpressureStrategy("BUFFER", n11);
        int n12 = 3;
        DROP = backpressureStrategy2 = new BackpressureStrategy("DROP", n12);
        int n13 = 4;
        LATEST = backpressureStrategy = new BackpressureStrategy("LATEST", n13);
        BackpressureStrategy[] backpressureStrategyArray = new BackpressureStrategy[5];
        backpressureStrategyArray[0] = backpressureStrategy5;
        backpressureStrategyArray[n10] = backpressureStrategy4;
        backpressureStrategyArray[n11] = backpressureStrategy3;
        backpressureStrategyArray[n12] = backpressureStrategy2;
        backpressureStrategyArray[n13] = backpressureStrategy;
        a = backpressureStrategyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BackpressureStrategy() {
        void var2_-1;
        void var1_-1;
    }

    public static BackpressureStrategy valueOf(String string2) {
        return Enum.valueOf(BackpressureStrategy.class, string2);
    }

    public static BackpressureStrategy[] values() {
        return (BackpressureStrategy[])a.clone();
    }
}

