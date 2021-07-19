/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.o;
import e.a.v0.c;
import e.a.w0.b.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class x0$a
implements o,
e {
    public final d a;
    public final c b;
    public e c;
    public Object d;
    public boolean e;

    public x0$a(d d10, c c10) {
        this.a = d10;
        this.b = c10;
    }

    public void cancel() {
        this.c.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.a.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        d d10 = this.a;
        Object object2 = this.d;
        if (object2 == null) {
            this.d = object;
            d10.onNext(object);
            return;
        }
        try {
            c c10 = this.b;
            object = c10.apply(object2, object);
            object2 = "The value returned by the accumulator is null";
            this.d = object = e.a.w0.b.a.g(object, (String)object2);
            d10.onNext(object);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.cancel();
            this.onError(throwable);
            return;
        }
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

