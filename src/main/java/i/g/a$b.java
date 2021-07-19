/*
 * Decompiled with CFR 0.151.
 */
package i.g;

import i.g.a$g;
import i.g.a$h;
import i.g.b;
import i.g.d;
import i.g.e;
import java.util.concurrent.Flow;

public final class a$b
implements Flow.Processor {
    public final b a;

    public a$b(b b10) {
        this.a = b10;
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
        b b10 = this.a;
        if (object == null) {
            object = null;
        } else {
            a$h a$h = new a$h((Flow.Subscription)object);
            object = a$h;
        }
        b10.onSubscribe((e)object);
    }

    public void e(Flow.Subscriber object) {
        b b10 = this.a;
        if (object == null) {
            object = null;
        } else {
            a$g a$g = new a$g((Flow.Subscriber)object);
            object = a$g;
        }
        b10.subscribe((d)object);
    }
}

