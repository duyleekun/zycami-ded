/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0$c;
import e.a.o;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSubscribeOn$SubscribeOnSubscriber
extends AtomicReference
implements o,
e,
Runnable {
    private static final long serialVersionUID = 8094547886072529208L;
    public final d downstream;
    public final boolean nonScheduledRequests;
    public final AtomicLong requested;
    public c source;
    public final AtomicReference upstream;
    public final h0$c worker;

    public FlowableSubscribeOn$SubscribeOnSubscriber(d serializable, h0$c h0$c, c c10, boolean bl2) {
        boolean bl3;
        this.downstream = serializable;
        this.worker = h0$c;
        this.source = c10;
        this.upstream = serializable = new Serializable();
        this.requested = serializable;
        this.nonScheduledRequests = bl3 = bl2 ^ true;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this.upstream);
        this.worker.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.worker.dispose();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.worker.dispose();
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(e e10) {
        long l10;
        long l11;
        long l12;
        Serializable serializable = this.upstream;
        boolean bl2 = SubscriptionHelper.setOnce((AtomicReference)serializable, e10);
        if (bl2 && (bl2 = (l12 = (l11 = ((AtomicLong)(serializable = this.requested)).getAndSet(l10 = 0L)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            this.requestUpstream(l11, e10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            Object object = (e)this.upstream.get();
            if (object != null) {
                this.requestUpstream(l10, (e)object);
            } else {
                long l11;
                AtomicLong atomicLong;
                long l12;
                long l13;
                long l14;
                object = this.requested;
                b.a((AtomicLong)object, l10);
                e e10 = (e)this.upstream.get();
                if (e10 != null && (l14 = (l13 = (l12 = (atomicLong = this.requested).getAndSet(l11 = 0L)) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                    this.requestUpstream(l12, e10);
                }
            }
        }
    }

    public void requestUpstream(long l10, e e10) {
        Object object;
        Object object2;
        boolean bl2 = this.nonScheduledRequests;
        if (!bl2 && (object2 = Thread.currentThread()) != (object = this.get())) {
            object2 = this.worker;
            object = new Object(e10, l10);
            ((h0$c)object2).b((Runnable)object);
        } else {
            e10.request(l10);
        }
    }

    public void run() {
        Object object = Thread.currentThread();
        this.lazySet(object);
        object = this.source;
        this.source = null;
        object.subscribe(this);
    }
}

