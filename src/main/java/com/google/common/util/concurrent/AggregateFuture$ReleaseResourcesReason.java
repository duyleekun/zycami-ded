/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public final class AggregateFuture$ReleaseResourcesReason
extends Enum {
    private static final /* synthetic */ AggregateFuture$ReleaseResourcesReason[] $VALUES;
    public static final /* enum */ AggregateFuture$ReleaseResourcesReason ALL_INPUT_FUTURES_PROCESSED;
    public static final /* enum */ AggregateFuture$ReleaseResourcesReason OUTPUT_FUTURE_DONE;

    static {
        AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason;
        AggregateFuture$ReleaseResourcesReason aggregateFuture$ReleaseResourcesReason2;
        OUTPUT_FUTURE_DONE = aggregateFuture$ReleaseResourcesReason2 = new AggregateFuture$ReleaseResourcesReason("OUTPUT_FUTURE_DONE", 0);
        int n10 = 1;
        ALL_INPUT_FUTURES_PROCESSED = aggregateFuture$ReleaseResourcesReason = new AggregateFuture$ReleaseResourcesReason("ALL_INPUT_FUTURES_PROCESSED", n10);
        AggregateFuture$ReleaseResourcesReason[] aggregateFuture$ReleaseResourcesReasonArray = new AggregateFuture$ReleaseResourcesReason[2];
        aggregateFuture$ReleaseResourcesReasonArray[0] = aggregateFuture$ReleaseResourcesReason2;
        aggregateFuture$ReleaseResourcesReasonArray[n10] = aggregateFuture$ReleaseResourcesReason;
        $VALUES = aggregateFuture$ReleaseResourcesReasonArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AggregateFuture$ReleaseResourcesReason() {
        void var2_-1;
        void var1_-1;
    }

    public static AggregateFuture$ReleaseResourcesReason valueOf(String string2) {
        return Enum.valueOf(AggregateFuture$ReleaseResourcesReason.class, string2);
    }

    public static AggregateFuture$ReleaseResourcesReason[] values() {
        return (AggregateFuture$ReleaseResourcesReason[])$VALUES.clone();
    }
}

