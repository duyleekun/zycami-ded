/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.o;
import e.a.w0.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class g$b
implements o,
e {
    public final d a;
    public final e.a.v0.o b;
    public e c;
    public boolean d;

    public g$b(d d10, e.a.v0.o o10) {
        this.a = d10;
        this.b = o10;
    }

    public void cancel() {
        this.c.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.cancel();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null value";
        object = e.a.w0.b.a.g(object, (String)object2);
        this.a.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.c.request(l10);
    }
}

