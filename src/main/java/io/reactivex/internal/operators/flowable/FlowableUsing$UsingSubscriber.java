/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.v0.g;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FlowableUsing$UsingSubscriber
extends AtomicBoolean
implements o,
e {
    private static final long serialVersionUID = 5904473792286235046L;
    public final g disposer;
    public final d downstream;
    public final boolean eager;
    public final Object resource;
    public e upstream;

    public FlowableUsing$UsingSubscriber(d d10, Object object, g g10, boolean bl2) {
        this.downstream = d10;
        this.resource = object;
        this.disposer = g10;
        this.eager = bl2;
    }

    public void cancel() {
        this.disposeAfter();
        this.upstream.cancel();
    }

    public void disposeAfter() {
        g g10 = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            g10 = this.disposer;
            Object object = this.resource;
            try {
                g10.accept(object);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a.Y(throwable);
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.eager;
        if (bl2) {
            Object object = null;
            boolean bl3 = true;
            bl2 = this.compareAndSet(false, bl3);
            if (bl2) {
                try {
                    object = this.disposer;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    this.downstream.onError(throwable);
                    return;
                }
                Object object2 = this.resource;
                object.accept(object2);
            }
            this.upstream.cancel();
            object = this.downstream;
            object.onComplete();
        } else {
            this.downstream.onComplete();
            e e10 = this.upstream;
            e10.cancel();
            this.disposeAfter();
        }
    }

    public void onError(Throwable object) {
        boolean bl2 = this.eager;
        if (bl2) {
            Object object2;
            Object object3;
            bl2 = false;
            d d10 = null;
            int n10 = 1;
            boolean bl3 = this.compareAndSet(false, n10 != 0);
            if (bl3) {
                object3 = this.disposer;
                object2 = this.resource;
                try {
                    object3.accept(object2);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                }
            }
            object3 = this.upstream;
            object3.cancel();
            if (d10 != null) {
                object3 = this.downstream;
                int n11 = 2;
                Throwable[] throwableArray = new Throwable[n11];
                throwableArray[0] = object;
                throwableArray[n10] = d10;
                object2 = new CompositeException(throwableArray);
                object3.onError((Throwable)object2);
            } else {
                d10 = this.downstream;
                d10.onError((Throwable)object);
            }
        } else {
            d d11 = this.downstream;
            d11.onError((Throwable)object);
            object = this.upstream;
            object.cancel();
            this.disposeAfter();
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

