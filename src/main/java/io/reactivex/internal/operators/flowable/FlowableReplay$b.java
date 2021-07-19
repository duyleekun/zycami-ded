/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay$UnboundedReplayBuffer;
import java.util.concurrent.Callable;

public final class FlowableReplay$b
implements Callable {
    public Object call() {
        FlowableReplay$UnboundedReplayBuffer flowableReplay$UnboundedReplayBuffer = new FlowableReplay$UnboundedReplayBuffer(16);
        return flowableReplay$UnboundedReplayBuffer;
    }
}

