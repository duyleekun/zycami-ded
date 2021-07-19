/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer;

public final class FlowableReplay$SizeBoundReplayBuffer
extends FlowableReplay$BoundedReplayBuffer {
    private static final long serialVersionUID = -5898283885385201806L;
    public final int limit;

    public FlowableReplay$SizeBoundReplayBuffer(int n10) {
        this.limit = n10;
    }

    public void truncate() {
        int n10 = this.size;
        int n11 = this.limit;
        if (n10 > n11) {
            this.removeFirst();
        }
    }
}

