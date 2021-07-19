/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.p;
import d.n.a.q0.v.u$b;
import d.n.a.q0.v.u$c;
import d.n.a.q0.v.u$d;
import d.n.a.q0.v.u$e;
import d.n.a.q0.v.u$f;
import d.n.a.q0.x.w;
import e.a.f0;
import e.a.h0;
import e.a.v0.o;
import java.util.concurrent.TimeUnit;

public class u {
    public final h0 a;
    public final f0 b;
    public final f0 c;
    private final f0 d;

    public u(h0 h02) {
        f0 f02 = new u$e(this);
        this.c = f02;
        super(this);
        this.d = f02;
        this.a = h02;
        super(this, h02);
        this.b = f02;
    }

    private f0 c(int n10) {
        long l10 = TimeUnit.SECONDS.toMillis(5);
        long l11 = n10;
        l10 = Math.max(l10 - l11, 0L);
        u$b u$b = new u$b(this, n10, l10);
        return u$b;
    }

    private f0 d() {
        return this.c(2500);
    }

    private f0 e() {
        return this.c(500);
    }

    private static f0 f(f0 f02) {
        u$c u$c = new u$c(f02);
        return u$c;
    }

    public static o g() {
        u$d u$d = new u$d();
        return u$d;
    }

    public static o h() {
        u$f u$f = new u$f();
        return u$f;
    }

    public f0 a(int n10) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    return w.a();
                }
                return u.f(this.d);
            }
            return u.f(this.c);
        }
        return u.f(this.b);
    }

    public f0 b(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            if (n10 != 0) {
                n11 = 1;
                if (n10 != n11) {
                    return w.a();
                }
                return this.d();
            }
        } else {
            n10 = 0;
            Object[] objectArray = new Object[]{};
            String string2 = "Cannot emulate opportunistic scan mode since it is OS dependent - fallthrough to low power";
            p.u(string2, objectArray);
        }
        return this.e();
    }
}

