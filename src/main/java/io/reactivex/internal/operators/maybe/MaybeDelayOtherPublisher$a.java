/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import i.g.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher$OtherSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class MaybeDelayOtherPublisher$a
implements t,
b {
    public final MaybeDelayOtherPublisher$OtherSubscriber a;
    public final c b;
    public b c;

    public MaybeDelayOtherPublisher$a(t t10, c c10) {
        MaybeDelayOtherPublisher$OtherSubscriber maybeDelayOtherPublisher$OtherSubscriber;
        this.a = maybeDelayOtherPublisher$OtherSubscriber = new MaybeDelayOtherPublisher$OtherSubscriber(t10);
        this.b = c10;
    }

    public void a() {
        c c10 = this.b;
        MaybeDelayOtherPublisher$OtherSubscriber maybeDelayOtherPublisher$OtherSubscriber = this.a;
        c10.subscribe(maybeDelayOtherPublisher$OtherSubscriber);
    }

    public void dispose() {
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        SubscriptionHelper.cancel(this.a);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.a.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a();
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.error = throwable;
        this.a();
    }

    public void onSubscribe(b object) {
        b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.c = object;
            object = this.a.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.value = object;
        this.a();
    }
}

