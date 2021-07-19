/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.o;
import e.a.w0.b.a;

public final class p0$a
extends e.a.w0.h.a {
    public final o f;

    public p0$a(e.a.w0.c.a a10, o o10) {
        super(a10);
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

    public boolean tryOnNext(Object object) {
        Object object2;
        boolean bl2 = this.d;
        if (bl2) {
            return false;
        }
        try {
            object2 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return true;
        }
        object = object2.apply(object);
        object2 = "The mapper function returned a null value.";
        object = e.a.w0.b.a.g(object, (String)object2);
        return this.a.tryOnNext(object);
    }
}

