/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.y;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class r$a
implements o,
e {
    public final d a;
    public final e.a.v0.o b;
    public boolean c;
    public e d;

    public r$a(d d10, e.a.v0.o o10) {
        this.a = d10;
        this.b = o10;
    }

    public void cancel() {
        this.d.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.c;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = true;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        Object object2;
        boolean bl2 = this.c;
        if (bl2) {
            bl2 = object instanceof y;
            if (bl2 && (bl2 = ((y)(object = (y)object)).g())) {
                object = ((y)object).d();
                e.a.a1.a.Y((Throwable)object);
            }
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.d.cancel();
            this.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The selector returned a null Notification";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (y)object;
        bl2 = ((y)object).g();
        if (bl2) {
            object2 = this.d;
            object2.cancel();
            object = ((y)object).d();
            this.onError((Throwable)object);
        } else {
            bl2 = ((y)object).f();
            if (bl2) {
                object = this.d;
                object.cancel();
                this.onComplete();
            } else {
                object2 = this.a;
                object = ((y)object).e();
                object2.onNext(object);
            }
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.d;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.d.request(l10);
    }
}

