/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.parallel;

import e.a.v0.c;

public final class ParallelFailureHandling
extends Enum
implements c {
    public static final /* enum */ ParallelFailureHandling ERROR;
    public static final /* enum */ ParallelFailureHandling RETRY;
    public static final /* enum */ ParallelFailureHandling SKIP;
    public static final /* enum */ ParallelFailureHandling STOP;
    private static final /* synthetic */ ParallelFailureHandling[] a;

    static {
        ParallelFailureHandling parallelFailureHandling;
        ParallelFailureHandling parallelFailureHandling2;
        ParallelFailureHandling parallelFailureHandling3;
        ParallelFailureHandling parallelFailureHandling4;
        STOP = parallelFailureHandling4 = new ParallelFailureHandling("STOP", 0);
        int n10 = 1;
        ERROR = parallelFailureHandling3 = new ParallelFailureHandling("ERROR", n10);
        int n11 = 2;
        SKIP = parallelFailureHandling2 = new ParallelFailureHandling("SKIP", n11);
        int n12 = 3;
        RETRY = parallelFailureHandling = new ParallelFailureHandling("RETRY", n12);
        ParallelFailureHandling[] parallelFailureHandlingArray = new ParallelFailureHandling[4];
        parallelFailureHandlingArray[0] = parallelFailureHandling4;
        parallelFailureHandlingArray[n10] = parallelFailureHandling3;
        parallelFailureHandlingArray[n11] = parallelFailureHandling2;
        parallelFailureHandlingArray[n12] = parallelFailureHandling;
        a = parallelFailureHandlingArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ParallelFailureHandling() {
        void var2_-1;
        void var1_-1;
    }

    public static ParallelFailureHandling valueOf(String string2) {
        return Enum.valueOf(ParallelFailureHandling.class, string2);
    }

    public static ParallelFailureHandling[] values() {
        return (ParallelFailureHandling[])a.clone();
    }

    public ParallelFailureHandling apply(Long l10, Throwable throwable) {
        return this;
    }
}

