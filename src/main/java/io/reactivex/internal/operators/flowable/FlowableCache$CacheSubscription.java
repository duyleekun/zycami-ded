/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCache$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableCache$CacheSubscription
extends AtomicInteger
implements e {
    private static final long serialVersionUID = 6770240836423125754L;
    public final d downstream;
    public long index;
    public FlowableCache$a node;
    public int offset;
    public final FlowableCache parent;
    public final AtomicLong requested;

    public FlowableCache$CacheSubscription(d object, FlowableCache flowableCache) {
        this.downstream = object;
        this.parent = flowableCache;
        this.node = object = flowableCache.g;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        Object object = this.requested;
        long l10 = Long.MIN_VALUE;
        long l11 = ((AtomicLong)object).getAndSet(l10);
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 != false) {
            object = this.parent;
            ((FlowableCache)object).O8(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.b(atomicLong, l10);
            FlowableCache flowableCache = this.parent;
            flowableCache.P8(this);
        }
    }
}

