/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver
extends AtomicReference
implements o {
    private static final long serialVersionUID = -1266041316834525931L;
    public final MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver parent;

    public MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver$TakeUntilOtherMaybeObserver(MaybeTakeUntilPublisher$TakeUntilMainMaybeObserver maybeTakeUntilPublisher$TakeUntilMainMaybeObserver) {
        this.parent = maybeTakeUntilPublisher$TakeUntilMainMaybeObserver;
    }

    public void onComplete() {
        this.parent.otherComplete();
    }

    public void onError(Throwable throwable) {
        this.parent.otherError(throwable);
    }

    public void onNext(Object object) {
        SubscriptionHelper.cancel(this);
        this.parent.otherComplete();
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

