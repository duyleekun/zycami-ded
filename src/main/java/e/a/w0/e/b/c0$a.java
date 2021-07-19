/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.r;
import e.a.w0.c.a;
import e.a.w0.c.l;

public final class c0$a
extends e.a.w0.h.a {
    public final r f;

    public c0$a(a a10, r r10) {
        super(a10);
        this.f = r10;
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
        l l10 = this.c;
        r r10 = this.f;
        Object object;
        while ((object = l10.poll()) != null) {
            int n10 = r10.test(object);
            if (n10 != 0) {
                return object;
            }
            int n11 = this.e;
            n10 = 2;
            if (n11 != n10) continue;
            long l11 = 1L;
            l10.request(l11);
        }
        return null;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }

    public boolean tryOnNext(Object object) {
        boolean bl2;
        Object object2;
        int n10 = this.d;
        int n11 = 0;
        if (n10) {
            return false;
        }
        n10 = this.e;
        if (n10) {
            return this.a.tryOnNext(null);
        }
        n10 = 1;
        try {
            object2 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return n10 != 0;
        }
        boolean bl3 = object2.test(object);
        if (bl3 && (bl2 = (object2 = this.a).tryOnNext(object))) {
            n11 = n10;
        }
        return n11 != 0;
    }
}

