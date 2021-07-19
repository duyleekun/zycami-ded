/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.ListenableFuture;

public class AggregateFuture$1
implements Runnable {
    public final /* synthetic */ AggregateFuture this$0;
    public final /* synthetic */ ListenableFuture val$future;
    public final /* synthetic */ int val$index;

    public AggregateFuture$1(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int n10) {
        this.this$0 = aggregateFuture;
        this.val$future = listenableFuture;
        this.val$index = n10;
    }

    public void run() {
        try {
            ListenableFuture listenableFuture = this.val$future;
            boolean bl2 = listenableFuture.isCancelled();
            if (bl2) {
                listenableFuture = this.this$0;
                AggregateFuture.access$002((AggregateFuture)listenableFuture, null);
                listenableFuture = this.this$0;
                boolean bl3 = false;
                ((AbstractFuture$TrustedFuture)listenableFuture).cancel(false);
            } else {
                listenableFuture = this.this$0;
                int n10 = this.val$index;
                ListenableFuture listenableFuture2 = this.val$future;
                AggregateFuture.access$100((AggregateFuture)listenableFuture, n10, listenableFuture2);
            }
            return;
        }
        finally {
            AggregateFuture.access$200(this.this$0, null);
        }
    }
}

