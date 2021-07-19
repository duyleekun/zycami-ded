/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import e.a.v0.g;
import e.a.y0.f;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class BoundedSubscriber
extends AtomicReference
implements o,
e,
b,
f {
    private static final long serialVersionUID = -7251123623727029452L;
    public final int bufferSize;
    public int consumed;
    public final int limit;
    public final e.a.v0.a onComplete;
    public final g onError;
    public final g onNext;
    public final g onSubscribe;

    public BoundedSubscriber(g g10, g g11, e.a.v0.a a10, g g12, int n10) {
        this.onNext = g10;
        this.onError = g11;
        this.onComplete = a10;
        this.onSubscribe = g12;
        this.bufferSize = n10;
        int n11 = n10 >> 2;
        this.limit = n10 -= n11;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        this.cancel();
    }

    public boolean hasCustomOnError() {
        boolean bl2;
        g g10 = this.onError;
        g g11 = Functions.f;
        if (g10 != g11) {
            bl2 = true;
        } else {
            bl2 = false;
            g10 = null;
        }
        return bl2;
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper;
        Object object = this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object = this.onComplete;
            try {
                object.run();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                a.Y(throwable);
            }
        }
    }

    public void onError(Throwable throwable) {
        Object object;
        Object object2 = this.get();
        if (object2 != (object = SubscriptionHelper.CANCELLED)) {
            this.lazySet(object);
            object2 = this.onError;
            try {
                object2.accept(throwable);
            }
            catch (Throwable throwable2) {
                e.a.t0.a.b(throwable2);
                int n10 = 2;
                Throwable[] throwableArray = new Throwable[n10];
                throwableArray[0] = throwable;
                int n11 = 1;
                throwableArray[n11] = throwable2;
                object = new CompositeException(throwableArray);
                a.Y((Throwable)object);
            }
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        int n10 = this.isDisposed();
        if (n10 == 0) {
            int n11;
            Object object2;
            block10: {
                object2 = this.onNext;
                object2.accept(object);
                n11 = this.consumed + 1;
                n10 = this.limit;
                if (n11 != n10) break block10;
                n11 = 0;
                object = null;
                this.consumed = 0;
                object = this.get();
                object = (e)object;
                n10 = this.limit;
                long l10 = n10;
                object.request(l10);
            }
            try {
                this.consumed = n11;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = (e)this.get();
                object2.cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(e e10) {
        boolean bl2 = SubscriptionHelper.setOnce(this, e10);
        if (bl2) {
            g g10 = this.onSubscribe;
            try {
                g10.accept(this);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                e10.cancel();
                this.onError(throwable);
            }
        }
    }

    public void request(long l10) {
        ((e)this.get()).request(l10);
    }
}

