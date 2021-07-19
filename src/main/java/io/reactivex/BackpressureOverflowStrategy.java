/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex;

public final class BackpressureOverflowStrategy
extends Enum {
    public static final /* enum */ BackpressureOverflowStrategy DROP_LATEST;
    public static final /* enum */ BackpressureOverflowStrategy DROP_OLDEST;
    public static final /* enum */ BackpressureOverflowStrategy ERROR;
    private static final /* synthetic */ BackpressureOverflowStrategy[] a;

    static {
        BackpressureOverflowStrategy backpressureOverflowStrategy;
        BackpressureOverflowStrategy backpressureOverflowStrategy2;
        BackpressureOverflowStrategy backpressureOverflowStrategy3;
        ERROR = backpressureOverflowStrategy3 = new BackpressureOverflowStrategy("ERROR", 0);
        int n10 = 1;
        DROP_OLDEST = backpressureOverflowStrategy2 = new BackpressureOverflowStrategy("DROP_OLDEST", n10);
        int n11 = 2;
        DROP_LATEST = backpressureOverflowStrategy = new BackpressureOverflowStrategy("DROP_LATEST", n11);
        BackpressureOverflowStrategy[] backpressureOverflowStrategyArray = new BackpressureOverflowStrategy[3];
        backpressureOverflowStrategyArray[0] = backpressureOverflowStrategy3;
        backpressureOverflowStrategyArray[n10] = backpressureOverflowStrategy2;
        backpressureOverflowStrategyArray[n11] = backpressureOverflowStrategy;
        a = backpressureOverflowStrategyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BackpressureOverflowStrategy() {
        void var2_-1;
        void var1_-1;
    }

    public static BackpressureOverflowStrategy valueOf(String string2) {
        return Enum.valueOf(BackpressureOverflowStrategy.class, string2);
    }

    public static BackpressureOverflowStrategy[] values() {
        return (BackpressureOverflowStrategy[])a.clone();
    }
}

