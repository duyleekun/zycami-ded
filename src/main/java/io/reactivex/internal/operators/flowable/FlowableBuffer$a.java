/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class FlowableBuffer$a
implements o,
e {
    public final d a;
    public final Callable b;
    public final int c;
    public Collection d;
    public e e;
    public boolean f;
    public int g;

    public FlowableBuffer$a(d d10, int n10, Callable callable) {
        this.a = d10;
        this.c = n10;
        this.b = callable;
    }

    public void cancel() {
        this.e.cancel();
    }

    public void onComplete() {
        boolean bl2;
        boolean bl3 = this.f;
        if (bl3) {
            return;
        }
        this.f = bl3 = true;
        Collection collection = this.d;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            d d10 = this.a;
            d10.onNext(collection);
        }
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.f;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.f = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        Object object2 = this.d;
        if (object2 == null) {
            try {
                object2 = this.b;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                this.onError(throwable);
                return;
            }
            object2 = object2.call();
            String string2 = "The bufferSupplier returned a null buffer";
            object2 = e.a.w0.b.a.g(object2, string2);
            this.d = object2 = (Collection)object2;
        }
        object2.add(object);
        int n10 = this.g + 1;
        int n11 = this.c;
        if (n10 == n11) {
            this.g = 0;
            n10 = 0;
            this.d = null;
            object = this.a;
            object.onNext(object2);
        } else {
            this.g = n10;
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.e;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.e = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            e e10 = this.e;
            int n10 = this.c;
            long l11 = n10;
            l10 = e.a.w0.i.b.d(l10, l11);
            e10.request(l10);
        }
    }
}

