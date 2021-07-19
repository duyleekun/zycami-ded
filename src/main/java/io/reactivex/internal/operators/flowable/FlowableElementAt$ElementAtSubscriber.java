/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

public final class FlowableElementAt$ElementAtSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = 4066607327284737757L;
    public long count;
    public final Object defaultValue;
    public boolean done;
    public final boolean errorOnFewer;
    public final long index;
    public e upstream;

    public FlowableElementAt$ElementAtSubscriber(d d10, long l10, Object object, boolean bl2) {
        super(d10);
        this.index = l10;
        this.defaultValue = object;
        this.errorOnFewer = bl2;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            Object object = this.defaultValue;
            if (object == null) {
                bl2 = this.errorOnFewer;
                if (bl2) {
                    object = this.downstream;
                    NoSuchElementException noSuchElementException = new NoSuchElementException();
                    object.onError(noSuchElementException);
                } else {
                    object = this.downstream;
                    object.onComplete();
                }
            } else {
                this.complete(object);
            }
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        long l10 = this.count;
        long l11 = this.index;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.done = true;
            this.upstream.cancel();
            this.complete(object);
            return;
        }
        this.count = ++l10;
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
}

