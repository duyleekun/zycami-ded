/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableReplay$InnerSubscription
extends AtomicLong
implements e,
e.a.s0.b {
    public static final long CANCELLED = Long.MIN_VALUE;
    private static final long serialVersionUID = -4453897557930727610L;
    public final d child;
    public boolean emitting;
    public Object index;
    public boolean missed;
    public final FlowableReplay$ReplaySubscriber parent;
    public final AtomicLong totalRequested;

    public FlowableReplay$InnerSubscription(FlowableReplay$ReplaySubscriber serializable, d d10) {
        this.parent = serializable;
        this.child = d10;
        this.totalRequested = serializable;
    }

    public void cancel() {
        this.dispose();
    }

    public void dispose() {
        long l10 = Long.MIN_VALUE;
        long l11 = this.getAndSet(l10);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.parent.remove(this);
            this.parent.manageRequests();
            object = 0;
            this.index = null;
        }
    }

    public Object index() {
        return this.index;
    }

    public boolean isDisposed() {
        long l10;
        long l11 = this.get();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public long produced(long l10) {
        return b.f(this, l10);
    }

    public void request(long l10) {
        long l11;
        long l12;
        long l13;
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2 && (bl2 = (l13 = (l12 = b.b(this, l10)) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
            AtomicLong atomicLong = this.totalRequested;
            b.a(atomicLong, l10);
            this.parent.manageRequests();
            FlowableReplay$d flowableReplay$d = this.parent.buffer;
            flowableReplay$d.replay(this);
        }
    }
}

