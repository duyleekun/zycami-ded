/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.k;
import j$.time.p.b;
import j$.time.p.j;
import j$.time.q.b_0;
import j$.time.q.d;
import j$.time.q.e;
import j$.time.q.s;
import j$.time.q.w;
import j$.time.q.z;

class u
implements s {
    final /* synthetic */ b a;
    final /* synthetic */ s b;
    final /* synthetic */ j c;
    final /* synthetic */ k d;

    u(b b10, s s10, j j10, k k10) {
        this.a = b10;
        this.b = s10;
        this.c = j10;
        this.d = k10;
    }

    public Object d(w w10) {
        w w11 = b_0.a;
        if (w10 == w11) {
            return this.c;
        }
        w11 = j$.time.q.d.a;
        if (w10 == w11) {
            return this.d;
        }
        w11 = e.a;
        if (w10 == w11) {
            return this.b.d(w10);
        }
        return w10.a(this);
    }

    public boolean g(j$.time.q.u u10) {
        boolean bl2;
        b b10 = this.a;
        if (b10 != null && (bl2 = u10.m())) {
            return this.a.g(u10);
        }
        return this.b.g(u10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long h(j$.time.q.u u10) {
        boolean bl2;
        s s10 = this.a;
        if (s10 != null && (bl2 = u10.m())) {
            s10 = this.a;
            return s10.h(u10);
        }
        s10 = this.b;
        return s10.h(u10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public z i(j$.time.q.u u10) {
        boolean bl2;
        s s10 = this.a;
        if (s10 != null && (bl2 = u10.m())) {
            s10 = this.a;
            return s10.i(u10);
        }
        s10 = this.b;
        return s10.i(u10);
    }
}

