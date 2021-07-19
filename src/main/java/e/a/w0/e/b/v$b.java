/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.g;
import e.a.w0.h.b;
import i.g.d;

public final class v$b
extends b {
    public final g f;

    public v$b(d d10, g g10) {
        super(d10);
        this.f = g10;
    }

    public void onNext(Object object) {
        int n10 = this.d;
        if (n10 != 0) {
            return;
        }
        Object object2 = this.a;
        object2.onNext(object);
        n10 = this.e;
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

