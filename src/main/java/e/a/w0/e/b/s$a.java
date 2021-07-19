/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;

public final class s$a
implements o,
e {
    public d a;
    public e b;

    public s$a(d d10) {
        this.a = d10;
    }

    public void cancel() {
        e e10 = this.b;
        d d10 = EmptyComponent.INSTANCE;
        this.b = d10;
        d10 = EmptyComponent.asSubscriber();
        this.a = d10;
        e10.cancel();
    }

    public void onComplete() {
        d d10 = this.a;
        d d11 = EmptyComponent.INSTANCE;
        this.b = d11;
        d11 = EmptyComponent.asSubscriber();
        this.a = d11;
        d10.onComplete();
    }

    public void onError(Throwable throwable) {
        d d10 = this.a;
        d d11 = EmptyComponent.INSTANCE;
        this.b = d11;
        d11 = EmptyComponent.asSubscriber();
        this.a = d11;
        d10.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.b;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.b = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.b.request(l10);
    }
}

