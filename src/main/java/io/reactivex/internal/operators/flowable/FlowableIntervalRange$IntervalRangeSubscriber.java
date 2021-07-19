/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableIntervalRange$IntervalRangeSubscriber
extends AtomicLong
implements e,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public long count;
    public final d downstream;
    public final long end;
    public final AtomicReference resource;

    public FlowableIntervalRange$IntervalRangeSubscriber(d d10, long l10, long l11) {
        AtomicReference atomicReference;
        this.resource = atomicReference = new AtomicReference();
        this.downstream = d10;
        this.count = l10;
        this.end = l11;
    }

    public void cancel() {
        DisposableHelper.dispose(this.resource);
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.a(this, l10);
        }
    }

    public void run() {
        Object object;
        Object object2 = this.resource.get();
        if (object2 != (object = DisposableHelper.DISPOSED)) {
            long l10;
            long l11 = this.get();
            long l12 = l11 - (l10 = 0L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false) {
                l10 = this.count;
                object2 = this.downstream;
                Long l13 = l10;
                object2.onNext(l13);
                long l14 = this.end;
                object3 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                if (object3 == false) {
                    object2 = this.resource.get();
                    if (object2 != object) {
                        object2 = this.downstream;
                        object2.onComplete();
                    }
                    DisposableHelper.dispose(this.resource);
                    return;
                }
                this.count = ++l10;
                long l15 = Long.MAX_VALUE;
                long l16 = l11 - l15;
                object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object3 != false) {
                    this.decrementAndGet();
                }
            } else {
                object2 = this.downstream;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Can't deliver value ");
                long l17 = this.count;
                charSequence.append(l17);
                String string2 = " due to lack of requests";
                charSequence.append(string2);
                charSequence = charSequence.toString();
                object = new MissingBackpressureException((String)charSequence);
                object2.onError((Throwable)object);
                object2 = this.resource;
                DisposableHelper.dispose((AtomicReference)object2);
            }
        }
    }

    public void setResource(e.a.s0.b b10) {
        DisposableHelper.setOnce(this.resource, b10);
    }
}

