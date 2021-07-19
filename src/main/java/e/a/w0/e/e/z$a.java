/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.g;
import e.a.w0.d.a;

public final class z$a
extends a {
    public final g f;

    public z$a(g0 g02, g g10) {
        super(g02);
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
}

