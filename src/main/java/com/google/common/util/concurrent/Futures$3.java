/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures$InCompletionOrderState;

public final class Futures$3
implements Runnable {
    public final /* synthetic */ ImmutableList val$delegates;
    public final /* synthetic */ int val$localI;
    public final /* synthetic */ Futures$InCompletionOrderState val$state;

    public Futures$3(Futures$InCompletionOrderState inCompletionOrderState, ImmutableList immutableList, int n10) {
        this.val$state = inCompletionOrderState;
        this.val$delegates = immutableList;
        this.val$localI = n10;
    }

    public void run() {
        Futures$InCompletionOrderState futures$InCompletionOrderState = this.val$state;
        ImmutableList immutableList = this.val$delegates;
        int n10 = this.val$localI;
        Futures$InCompletionOrderState.access$300(futures$InCompletionOrderState, immutableList, n10);
    }
}

