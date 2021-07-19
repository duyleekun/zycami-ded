/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.Futures$InCompletionOrderState;

public final class Futures$InCompletionOrderFuture
extends AbstractFuture {
    private Futures$InCompletionOrderState state;

    private Futures$InCompletionOrderFuture(Futures$InCompletionOrderState futures$InCompletionOrderState) {
        this.state = futures$InCompletionOrderState;
    }

    public /* synthetic */ Futures$InCompletionOrderFuture(Futures$InCompletionOrderState futures$InCompletionOrderState, Futures$1 futures$1) {
        this(futures$InCompletionOrderState);
    }

    public void afterDone() {
        this.state = null;
    }

    public boolean cancel(boolean bl2) {
        Futures$InCompletionOrderState futures$InCompletionOrderState = this.state;
        boolean bl3 = super.cancel(bl2);
        if (bl3) {
            Futures$InCompletionOrderState.access$400(futures$InCompletionOrderState, bl2);
            return true;
        }
        return false;
    }

    public String pendingToString() {
        Futures$InCompletionOrderState futures$InCompletionOrderState = this.state;
        if (futures$InCompletionOrderState != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("inputCount=[");
            int n10 = Futures$InCompletionOrderState.access$500(futures$InCompletionOrderState).length;
            stringBuilder.append(n10);
            stringBuilder.append("], remaining=[");
            int n11 = Futures$InCompletionOrderState.access$600(futures$InCompletionOrderState).get();
            stringBuilder.append(n11);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return null;
    }
}

