/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.a;
import e.a.w0.c.l;
import i.g.e;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowableDoFinally$DoFinallyConditionalSubscriber
extends BasicIntQueueSubscription
implements a {
    private static final long serialVersionUID = 4109457741734051389L;
    public final a downstream;
    public final e.a.v0.a onFinally;
    public l qs;
    public boolean syncFused;
    public e upstream;

    public FlowableDoFinally$DoFinallyConditionalSubscriber(a a10, e.a.v0.a a11) {
        this.downstream = a10;
        this.onFinally = a11;
    }

    public void cancel() {
        this.upstream.cancel();
        this.runFinally();
    }

    public void clear() {
        this.qs.clear();
    }

    public boolean isEmpty() {
        return this.qs.isEmpty();
    }

    public void onComplete() {
        this.downstream.onComplete();
        this.runFinally();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
        this.runFinally();
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            bl2 = object instanceof l;
            if (bl2) {
                this.qs = object = (l)object;
            }
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public Object poll() {
        boolean bl2;
        Object object = this.qs.poll();
        if (object == null && (bl2 = this.syncFused)) {
            this.runFinally();
        }
        return object;
    }

    public void request(long l10) {
        this.upstream.request(l10);
    }

    public int requestFusion(int n10) {
        int n11;
        l l10 = this.qs;
        int n12 = 0;
        if (l10 != null && (n11 = n10 & 4) == 0) {
            if ((n10 = l10.requestFusion(n10)) != 0) {
                int n13 = 1;
                if (n10 == n13) {
                    n12 = n13;
                }
                this.syncFused = n12;
            }
            return n10;
        }
        return 0;
    }

    public void runFinally() {
        e.a.v0.a a10 = null;
        int n10 = 1;
        boolean bl2 = this.compareAndSet(0, n10);
        if (bl2) {
            a10 = this.onFinally;
            try {
                a10.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e.a.a1.a.Y(throwable);
            }
        }
    }

    public boolean tryOnNext(Object object) {
        return this.downstream.tryOnNext(object);
    }
}

