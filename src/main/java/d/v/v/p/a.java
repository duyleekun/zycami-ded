/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.p;

import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsVideoClip;
import d.v.h.e.d;
import d.v.v.g.h;
import d.v.v.p.a$a;
import d.v.v.p.b;

public class a
implements d.v.h.k.a {
    public static a e() {
        return a$a.a();
    }

    private void f(int n10, long l10) {
        NvsVideoClip nvsVideoClip = d.v.v.q.h.W(n10);
        if (nvsVideoClip != null) {
            long l11 = nvsVideoClip.getOutPoint();
            long l12 = 2;
            h h10 = h.k();
            boolean bl2 = true;
            long l13 = l11 - (l10 /= l12);
            long l14 = l11 + l10;
            boolean bl3 = true;
            h10.p(bl2, l13, l14, bl3);
        }
    }

    private void g(int n10) {
        d.v.h.k.b b10 = d.v.v.j.h.t().v(n10).N();
        Object object = d.v.v.q.h.W(n10);
        if (object != null) {
            long l10 = b10.a();
            long l11 = ((NvsClip)object).getOutPoint();
            object = h.k();
            long l12 = 2;
            ((h)object).H(l11 -= (l10 /= l12));
        }
    }

    public void a(int n10) {
    }

    public void b() {
    }

    public boolean c(int n10, boolean bl2) {
        d d10;
        b b10 = b.j();
        boolean bl3 = b10.i(n10);
        if (bl3 && (d10 = d.v.v.j.h.t().v(n10)) != null) {
            if (bl2) {
                this.g(n10);
            }
            d.v.h.k.b b11 = new d.v.h.k.b();
            d10.o0(b11);
        }
        return bl3;
    }

    public boolean d(int n10, long l10, boolean bl2) {
        b b10 = b.j();
        boolean bl3 = b10.d(n10, l10);
        if (bl3 && bl2) {
            this.f(n10, l10);
        }
        return bl3;
    }

    public boolean h(int n10, d.v.h.k.b b10, boolean bl2) {
        b b11 = b.j();
        boolean bl3 = b11.a(n10, b10);
        if (bl3) {
            d d10 = d.v.v.j.h.t().v(n10);
            if (d10 != null) {
                d10.o0(b10);
            }
            if (bl2) {
                long l10 = b10.a();
                this.f(n10, l10);
            }
        }
        return bl3;
    }
}

