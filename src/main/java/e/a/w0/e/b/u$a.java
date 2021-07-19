/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.d;
import e.a.v0.o;
import e.a.w0.c.a;

public final class u$a
extends e.a.w0.h.a {
    public final o f;
    public final d g;
    public Object h;
    public boolean i;

    public u$a(a a10, o o10, d d10) {
        super(a10);
        this.f = o10;
        this.g = d10;
    }

    public void onNext(Object object) {
        boolean bl2 = this.tryOnNext(object);
        if (!bl2) {
            object = this.b;
            long l10 = 1L;
            object.request(l10);
        }
    }

    public Object poll() {
        Object object;
        while ((object = this.c.poll()) != null) {
            Object object2 = this.f.apply(object);
            boolean bl2 = this.i;
            int n10 = 1;
            if (!bl2) {
                this.i = n10;
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
            int n11 = this.e;
            if (n11 == n10) continue;
            object = this.b;
            long l10 = 1L;
            object.request(l10);
        }
        return null;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }

    public boolean tryOnNext(Object object) {
        int n10;
        block14: {
            Object object2;
            block13: {
                n10 = this.d;
                if (n10) {
                    return false;
                }
                n10 = this.e;
                if (n10) {
                    return this.a.tryOnNext(object);
                }
                n10 = 1;
                try {
                    object2 = this.f;
                }
                catch (Throwable throwable) {
                    this.c(throwable);
                    return n10 != 0;
                }
                object2 = object2.apply(object);
                boolean bl2 = this.i;
                if (!bl2) break block13;
                d d10 = this.g;
                Object object3 = this.h;
                bl2 = d10.a(object3, object2);
                this.h = object2;
                if (bl2) {
                    return false;
                }
                break block14;
            }
            this.i = n10;
            this.h = object2;
        }
        this.a.onNext(object);
        return n10 != 0;
    }
}

