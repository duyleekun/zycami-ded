/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay$SizeBoundReplayBuffer;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import java.util.concurrent.Callable;

public final class FlowableReplay$e
implements Callable {
    private final int a;

    public FlowableReplay$e(int n10) {
        this.a = n10;
    }

    public FlowableReplay$d a() {
        int n10 = this.a;
        FlowableReplay$SizeBoundReplayBuffer flowableReplay$SizeBoundReplayBuffer = new FlowableReplay$SizeBoundReplayBuffer(n10);
        return flowableReplay$SizeBoundReplayBuffer;
    }
}

