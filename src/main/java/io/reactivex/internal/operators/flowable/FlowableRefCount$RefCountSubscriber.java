/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.operators.flowable.FlowableRefCount$RefConnection;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FlowableRefCount$RefCountSubscriber
extends AtomicBoolean
implements o,
e {
    private static final long serialVersionUID = -7419642935409022375L;
    public final FlowableRefCount$RefConnection connection;
    public final d downstream;
    public final FlowableRefCount parent;
    public e upstream;

    public FlowableRefCount$RefCountSubscriber(d d10, FlowableRefCount flowableRefCount, FlowableRefCount$RefConnection flowableRefCount$RefConnection) {
        this.downstream = d10;
        this.parent = flowableRefCount;
        this.connection = flowableRefCount$RefConnection;
    }

    public void cancel() {
        this.upstream.cancel();
        FlowableRefCount flowableRefCount = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            flowableRefCount = this.parent;
            FlowableRefCount$RefConnection flowableRefCount$RefConnection = this.connection;
            flowableRefCount.K8(flowableRefCount$RefConnection);
        }
    }

    public void onComplete() {
        Object object = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            object = this.parent;
            FlowableRefCount$RefConnection flowableRefCount$RefConnection = this.connection;
            ((FlowableRefCount)object).N8(flowableRefCount$RefConnection);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            object = this.parent;
            FlowableRefCount$RefConnection flowableRefCount$RefConnection = this.connection;
            ((FlowableRefCount)object).N8(flowableRefCount$RefConnection);
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.upstream.request(l10);
    }
}

