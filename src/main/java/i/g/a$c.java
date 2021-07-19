/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$h;
import i.g.d;
import i.g.e;
import java.util.concurrent.Flow;

public final class a$c
implements Flow.Subscriber {
    public final d a;

    public a$c(d d10) {
        this.a = d10;
    }

    public void a() {
        this.a.onComplete();
    }

    public void b(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void c(Object object) {
        this.a.onNext(object);
    }

    public void d(Flow.Subscription object) {
        d d10 = this.a;
        if (object == null) {
            object = null;
        } else {
            a$h a$h = new a$h((Flow.Subscription)object);
            object = a$h;
        }
        d10.onSubscribe((e)object);
    }
}

