/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.r;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ForEachWhileSubscriber
extends AtomicReference
implements o,
b {
    private static final long serialVersionUID = -4403180040475402120L;
    public boolean done;
    public final e.a.v0.a onComplete;
    public final g onError;
    public final r onNext;

    public ForEachWhileSubscriber(r r10, g g10, e.a.v0.a a10) {
        this.onNext = r10;
        this.onError = g10;
        this.onComplete = a10;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
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
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        e.a.v0.a a10 = this.onComplete;
        try {
            a10.run();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            a.Y(throwable);
        }
    }

    public void onError(Throwable throwable) {
        int n10 = (int)(this.done ? 1 : 0);
        if (n10 != 0) {
            a.Y(throwable);
            return;
        }
        n10 = 1;
        this.done = n10;
        g g10 = this.onError;
        try {
            g10.accept(throwable);
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            int n11 = 2;
            Throwable[] throwableArray = new Throwable[n11];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            a.Y(compositeException);
        }
    }

    public void onNext(Object object) {
        r r10;
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        try {
            r10 = this.onNext;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.dispose();
            this.onError(throwable);
            return;
        }
        boolean bl3 = r10.test(object);
        if (!bl3) {
            this.dispose();
            this.onComplete();
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

