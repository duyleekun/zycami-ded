/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;

public class AggregateFuture$2
implements Runnable {
    public final /* synthetic */ AggregateFuture this$0;
    public final /* synthetic */ ImmutableCollection val$localFutures;

    public AggregateFuture$2(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.this$0 = aggregateFuture;
        this.val$localFutures = immutableCollection;
    }

    public void run() {
        AggregateFuture aggregateFuture = this.this$0;
        ImmutableCollection immutableCollection = this.val$localFutures;
        AggregateFuture.access$200(aggregateFuture, immutableCollection);
    }
}

