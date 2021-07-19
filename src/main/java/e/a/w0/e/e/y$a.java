/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.d;
import e.a.v0.o;
import e.a.w0.d.a;

public final class y$a
extends a {
    public final o f;
    public final d g;
    public Object h;
    public boolean i;

    public y$a(g0 g02, o o10, d d10) {
        super(g02);
        this.f = o10;
        this.g = d10;
    }

    public void onNext(Object object) {
        block14: {
            boolean bl2;
            Object object2;
            block13: {
                int n10 = this.d;
                if (n10 != 0) {
                    return;
                }
                n10 = this.e;
                if (n10 != 0) {
                    this.a.onNext(object);
                    return;
                }
                try {
                    object2 = this.f;
                }
                catch (Throwable throwable) {
                    this.c(throwable);
                    return;
                }
                object2 = object2.apply(object);
                bl2 = this.i;
                if (!bl2) break block13;
                d d10 = this.g;
                Object object3 = this.h;
                bl2 = d10.a(object3, object2);
                this.h = object2;
                if (bl2) {
                    return;
                }
                break block14;
            }
            bl2 = true;
            this.i = bl2;
            this.h = object2;
        }
        this.a.onNext(object);
    }

    public Object poll() {
        Object object;
        while ((object = this.c.poll()) != null) {
            Object object2 = this.f.apply(object);
            boolean bl2 = this.i;
            if (!bl2) {
                this.i = true;
                this.h = object2;
                return object;
            }
            d d10 = this.g;
            Object object3 = this.h;
            bl2 = d10.a(object3, object2);
            if (!bl2) {
                this.h = object2;
                return object;
            }
            this.h = object2;
        }
        return null;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }
}

