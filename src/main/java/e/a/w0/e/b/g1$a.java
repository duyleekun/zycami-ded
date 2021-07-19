/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.v0.r;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class g1$a
implements o,
e {
    public final d a;
    public final r b;
    public e c;
    public boolean d;

    public g1$a(d d10, r r10) {
        this.a = d10;
        this.b = r10;
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
        r r10;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        try {
            r10 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.c.cancel();
            this.onError(throwable);
            return;
        }
        bl2 = r10.test(object);
        if (!bl2) {
            this.d = true;
            this.c.cancel();
            this.a.onComplete();
            return;
        }
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

