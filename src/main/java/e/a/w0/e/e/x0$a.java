/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.o;
import e.a.w0.b.a;

public final class x0$a
extends e.a.w0.d.a {
    public final o f;

    public x0$a(g0 g02, o o10) {
        super(g02);
        this.f = o10;
    }

    public void onNext(Object object) {
        Object object2;
        int n10 = this.d;
        if (n10 != 0) {
            return;
        }
        n10 = this.e;
        if (n10 != 0) {
            this.a.onNext(null);
            return;
        }
        try {
            object2 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper function returned a null value.";
        object = e.a.w0.b.a.g(object, (String)object2);
        this.a.onNext(object);
    }

    public Object poll() {
        Object object = this.c.poll();
        if (object != null) {
            object = this.f.apply(object);
            String string2 = "The mapper function returned a null value.";
            object = e.a.w0.b.a.g(object, string2);
        } else {
            object = null;
        }
        return object;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }
}

