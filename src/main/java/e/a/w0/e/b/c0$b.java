/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.r;
import e.a.w0.c.a;
import e.a.w0.c.l;
import e.a.w0.h.b;
import i.g.d;

public final class c0$b
extends b
implements a {
    public final r f;

    public c0$b(d d10, r r10) {
        super(d10);
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
        r r10;
        boolean bl2 = this.d;
        if (bl2) {
            return false;
        }
        int n10 = this.e;
        boolean bl3 = true;
        if (n10 != 0) {
            this.a.onNext(null);
            return bl3;
        }
        try {
            r10 = this.f;
        }
        catch (Throwable throwable) {
            this.c(throwable);
            return bl3;
        }
        boolean bl4 = r10.test(object);
        if (bl4) {
            d d10 = this.a;
            d10.onNext(object);
        }
        return bl4;
    }
}

