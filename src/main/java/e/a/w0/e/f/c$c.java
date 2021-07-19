/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.a1.a;
import e.a.v0.r;
import e.a.w0.e.f.c$a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class c$c
extends c$a {
    public final d d;

    public c$c(d d10, r r10) {
        super(r10);
        this.d = d10;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (!bl2) {
            this.c = bl2 = true;
            d d10 = this.d;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.d.onError(throwable);
    }

    public void onSubscribe(e object) {
        e e10 = this.b;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.b = object;
            object = this.d;
            object.onSubscribe(this);
        }
    }

    public boolean tryOnNext(Object object) {
        boolean bl2 = this.c;
        if (!bl2) {
            r r10 = this.a;
            try {
                bl2 = r10.test(object);
                if (bl2) {
                    this.d.onNext(object);
                    return true;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                this.onError(throwable);
            }
        }
        return false;
    }
}

