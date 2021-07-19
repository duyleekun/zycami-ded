/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.o;
import e.a.w0.c.a;
import e.a.w0.h.b;
import i.g.d;

public final class u$b
extends b
implements a {
    public final o f;
    public final e.a.v0.d g;
    public Object h;
    public boolean i;

    public u$b(d d10, o o10, e.a.v0.d d11) {
        super(d10);
        this.f = o10;
        this.g = d11;
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
            e.a.v0.d d10 = this.g;
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
        boolean bl2;
        block14: {
            Object object2;
            block13: {
                int n10 = this.d;
                if (n10 != 0) {
                    return false;
                }
                n10 = this.e;
                bl2 = true;
                if (n10 != 0) {
                    this.a.onNext(object);
                    return bl2;
                }
                try {
                    object2 = this.f;
                }
                catch (Throwable throwable) {
                    this.c(throwable);
                    return bl2;
                }
                object2 = object2.apply(object);
                boolean bl3 = this.i;
                if (!bl3) break block13;
                e.a.v0.d d10 = this.g;
                Object object3 = this.h;
                bl3 = d10.a(object3, object2);
                this.h = object2;
                if (bl3) {
                    return false;
                }
                break block14;
            }
            this.i = bl2;
            this.h = object2;
        }
        this.a.onNext(object);
        return bl2;
    }
}

