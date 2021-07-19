/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.r;
import e.a.w0.c.a;
import e.a.w0.e.f.c$a;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class c$b
extends c$a {
    public final a d;

    public c$b(a a10, r r10) {
        super(r10);
        this.d = a10;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (!bl2) {
            this.c = bl2 = true;
            a a10 = this.d;
            a10.onComplete();
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
                    return this.d.tryOnNext(object);
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

