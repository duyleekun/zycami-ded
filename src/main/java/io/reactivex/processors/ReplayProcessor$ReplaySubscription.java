/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.ReplayProcessor;
import io.reactivex.processors.ReplayProcessor$a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class ReplayProcessor$ReplaySubscription
extends AtomicInteger
implements e {
    private static final long serialVersionUID = 466549804534799122L;
    public volatile boolean cancelled;
    public final d downstream;
    public long emitted;
    public Object index;
    public final AtomicLong requested;
    public final ReplayProcessor state;

    public ReplayProcessor$ReplaySubscription(d object, ReplayProcessor replayProcessor) {
        this.downstream = object;
        this.state = replayProcessor;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            ReplayProcessor replayProcessor = this.state;
            replayProcessor.b9(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            ReplayProcessor$a replayProcessor$a = this.state.b;
            replayProcessor$a.a(this);
        }
    }
}

