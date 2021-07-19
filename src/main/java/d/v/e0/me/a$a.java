/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import e.a.g0;
import e.a.s0.b;
import java.util.concurrent.TimeoutException;

public final class a$a
implements g0 {
    public g0 a;
    public Object b;
    public boolean c;

    public a$a(g0 g02, Object object) {
        this.a = g02;
        this.b = object;
    }

    public void onComplete() {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.c = true;
        this.a.onComplete();
    }

    public void onError(Throwable object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        bl2 = object instanceof TimeoutException;
        if (bl2) {
            object = this.a;
            Object object2 = this.b;
            object.onNext(object2);
            object = this.a;
            object.onComplete();
        } else {
            g0 g02 = this.a;
            g02.onError((Throwable)object);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.c;
        if (bl2) {
            return;
        }
        this.a.onNext(object);
    }

    public void onSubscribe(b b10) {
        this.a.onSubscribe(b10);
    }
}

