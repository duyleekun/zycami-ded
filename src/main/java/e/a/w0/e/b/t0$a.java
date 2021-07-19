/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import e.a.t;
import e.a.v0.c;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class t0$a
implements o,
b {
    public final t a;
    public final c b;
    public Object c;
    public e d;
    public boolean e;

    public t0$a(t t10, c c10) {
        this.a = t10;
        this.b = c10;
    }

    public void dispose() {
        this.d.cancel();
        this.e = true;
    }

    public boolean isDisposed() {
        return this.e;
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = bl2 = true;
        Object object = this.c;
        if (object != null) {
            t t10 = this.a;
            t10.onSuccess(object);
        } else {
            object = this.a;
            object.onComplete();
        }
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

    public void onNext(Object object) {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        Object object2 = this.c;
        if (object2 == null) {
            this.c = object;
        } else {
            c c10 = this.b;
            object = c10.apply(object2, object);
            object2 = "The reducer returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            try {
                this.c = object;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                object2 = this.d;
                object2.cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.d;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.d = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

