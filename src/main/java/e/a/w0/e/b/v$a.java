/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.g;
import e.a.w0.c.a;

public final class v$a
extends e.a.w0.h.a {
    public final g f;

    public v$a(a a10, g g10) {
        super(a10);
        this.f = g10;
    }

    public void onNext(Object object) {
        Object object2 = this.a;
        object2.onNext(object);
        int n10 = this.e;
        if (n10 == 0) {
            object2 = this.f;
            try {
                object2.accept(object);
            }
            catch (Throwable throwable) {
                this.c(throwable);
            }
        }
    }

    public Object poll() {
        Object object = this.c.poll();
        if (object != null) {
            g g10 = this.f;
            g10.accept(object);
        }
        return object;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }

    public boolean tryOnNext(Object object) {
        a a10 = this.a;
        boolean bl2 = a10.tryOnNext(object);
        g g10 = this.f;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            this.c(throwable);
        }
        return bl2;
    }
}

