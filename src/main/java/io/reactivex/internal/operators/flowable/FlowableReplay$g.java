/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import io.reactivex.internal.operators.flowable.FlowableReplay$SizeAndTimeBoundReplayBuffer;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class FlowableReplay$g
implements Callable {
    private final int a;
    private final long b;
    private final TimeUnit c;
    private final h0 d;

    public FlowableReplay$g(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = n10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public FlowableReplay$d a() {
        int n10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        FlowableReplay$SizeAndTimeBoundReplayBuffer flowableReplay$SizeAndTimeBoundReplayBuffer = new FlowableReplay$SizeAndTimeBoundReplayBuffer(n10, l10, timeUnit, h02);
        return flowableReplay$SizeAndTimeBoundReplayBuffer;
    }
}

