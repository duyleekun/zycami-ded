/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.i.b;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.flowable.FlowableDebounce$DebounceSubscriber$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableDebounce$DebounceSubscriber
extends AtomicLong
implements e.a.o,
e {
    private static final long serialVersionUID = 6725975399620862591L;
    public final o debounceSelector;
    public final AtomicReference debouncer;
    public boolean done;
    public final d downstream;
    public volatile long index;
    public e upstream;

    public FlowableDebounce$DebounceSubscriber(d d10, o o10) {
        AtomicReference atomicReference;
        this.debouncer = atomicReference = new AtomicReference();
        this.downstream = d10;
        this.debounceSelector = o10;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this.debouncer);
    }

    public void emit(long l10, Object object) {
        long l11 = this.index;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            l10 = this.get();
            long l13 = l10 - (l11 = 0L);
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false) {
                d d10 = this.downstream;
                d10.onNext(object);
                l10 = 1L;
                b.e(this, l10);
            } else {
                this.cancel();
                d d11 = this.downstream;
                object = "Could not deliver value due to lack of requests";
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException((String)object);
                d11.onError(missingBackpressureException);
            }
        }
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        Object object = (e.a.s0.b)this.debouncer.get();
        boolean bl3 = DisposableHelper.isDisposed((e.a.s0.b)object);
        if (!bl3) {
            if ((object = (FlowableDebounce$DebounceSubscriber$a)object) != null) {
                ((FlowableDebounce$DebounceSubscriber$a)object).d();
            }
            DisposableHelper.dispose(this.debouncer);
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        DisposableHelper.dispose(this.debouncer);
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        long l10 = this.index;
        long l11 = 1L;
        this.index = l10 += l11;
        e.a.s0.b b10 = (e.a.s0.b)this.debouncer.get();
        if (b10 != null) {
            b10.dispose();
        }
        try {
            object2 = this.debounceSelector;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.downstream.onError(throwable);
            return;
        }
        object2 = object2.apply(object);
        Object object3 = "The publisher supplied is null";
        object2 = a.g(object2, (String)object3);
        object2 = (c)object2;
        object3 = new FlowableDebounce$DebounceSubscriber$a(this, l10, object);
        object = this.debouncer;
        boolean bl3 = ((AtomicReference)object).compareAndSet(b10, object3);
        if (bl3) {
            object2.subscribe((d)object3);
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.a(this, l10);
        }
    }
}

