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

public final class f1$a
implements o,
e {
    public final d a;
    public final r b;
    public e c;
    public boolean d;

    public f1$a(d d10, r r10) {
        this.a = d10;
        this.b = r10;
    }

    public void cancel() {
        this.c.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            d d10 = this.a;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            d d10 = this.a;
            d10.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (!bl2) {
            Object object2 = this.a;
            object2.onNext(object);
            object2 = this.b;
            try {
                boolean bl3 = object2.test(object);
                if (bl3) {
                    this.d = bl3 = true;
                    this.c.cancel();
                    object = this.a;
                    object.onComplete();
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.c;
                object2.cancel();
                this.onError(throwable);
            }
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

