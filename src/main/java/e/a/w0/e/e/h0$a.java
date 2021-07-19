/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.r;
import e.a.w0.d.a;

public final class h0$a
extends a {
    public final r f;

    public h0$a(g0 g02, r r10) {
        super(g02);
        this.f = r10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void onNext(Object object) {
        int n10 = this.e;
        if (n10 == 0) {
            Object object2;
            try {
                object2 = this.f;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
            n10 = (int)(object2.test(object) ? 1 : 0);
            if (n10 == 0) return;
            object2 = this.a;
            object2.onNext(object);
            return;
        } else {
            object = this.a;
            n10 = 0;
            Object var3_5 = null;
            object.onNext(null);
        }
    }

    public Object poll() {
        r r10;
        boolean bl2;
        Object object;
        while ((object = this.c.poll()) != null && !(bl2 = (r10 = this.f).test(object))) {
        }
        return object;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }
}

