/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.f;
import f.l2.g;
import f.l2.p;
import f.l2.q;
import f.l2.r;
import f.l2.r$a;
import f.l2.t;
import f.l2.u;
import f.l2.u$a;
import f.l2.w;
import f.m1;
import f.s1;
import f.y0;
import java.util.NoSuchElementException;

public class y {
    private static final int A(t t10) {
        e$a e$a = e.b;
        return y.B(t10, e$a);
    }

    public static final int B(t t10, e object) {
        f0.p(t10, "$this$random");
        String string2 = "random";
        f0.p(object, string2);
        try {
            return f.k2.g.h((e)object, t10);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string3 = illegalArgumentException.getMessage();
            object = new NoSuchElementException(string3);
            throw object;
        }
    }

    private static final long C(w w10) {
        e$a e$a = e.b;
        return y.D(w10, e$a);
    }

    public static final long D(w w10, e object) {
        f0.p(w10, "$this$random");
        String string2 = "random";
        f0.p(object, string2);
        try {
            return f.k2.g.l((e)object, w10);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            String string3 = illegalArgumentException.getMessage();
            object = new NoSuchElementException(string3);
            throw object;
        }
    }

    private static final c1 E(t t10) {
        e$a e$a = e.b;
        return y.F(t10, e$a);
    }

    public static final c1 F(t t10, e e10) {
        f0.p(t10, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        boolean bl2 = t10.isEmpty();
        if (bl2) {
            return null;
        }
        return c1.b(f.k2.g.h(e10, t10));
    }

    private static final g1 G(w w10) {
        e$a e$a = e.b;
        return y.H(w10, e$a);
    }

    public static final g1 H(w w10, e e10) {
        f0.p(w10, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        boolean bl2 = w10.isEmpty();
        if (bl2) {
            return null;
        }
        return g1.b(f.k2.g.l(e10, w10));
    }

    public static final r I(r r10) {
        f0.p(r10, "$this$reversed");
        r$a r$a = r.d;
        int n10 = r10.f();
        int n11 = r10.e();
        int n12 = -r10.g();
        return r$a.a(n10, n11, n12);
    }

    public static final u J(u u10) {
        f0.p(u10, "$this$reversed");
        u$a u$a = u.d;
        long l10 = u10.f();
        long l11 = u10.e();
        long l12 = -u10.g();
        return u$a.a(l10, l11, l12);
    }

    public static final r K(r r10, int n10) {
        boolean bl2;
        Object object = "$this$step";
        f0.p(r10, (String)object);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Integer n11 = n10;
        p.a(bl2, n11);
        object = r.d;
        int n12 = r10.e();
        int n13 = r10.f();
        int n14 = r10.g();
        if (n14 <= 0) {
            n10 = -n10;
        }
        return ((r$a)object).a(n12, n13, n10);
    }

    public static final u L(u u10, long l10) {
        String string2 = "$this$step";
        f0.p(u10, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 > 0 ? (long)1 : (long)0;
        Long l13 = l10;
        p.a((boolean)l12, l13);
        u$a u$a = u.d;
        long l14 = u10.e();
        long l15 = u10.f();
        long l16 = u10.g();
        long l17 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1);
        if (l17 <= 0) {
            l10 = -l10;
        }
        return u$a.a(l14, l15, l10);
    }

    public static final t M(short s10, short s11) {
        char c10 = (char)-1;
        int n10 = f0.t(s11 = (short)(s11 & c10), 0);
        if (n10 <= 0) {
            return t.f.a();
        }
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(c1.h(s11) + -1);
        t t10 = new t(s10, s11, null);
        return t10;
    }

    public static final t N(int n10, int n11) {
        t t10 = null;
        int n12 = s1.c(n11, 0);
        if (n12 <= 0) {
            return t.f.a();
        }
        n11 = c1.h(n11 + -1);
        t10 = new t(n10, n11, null);
        return t10;
    }

    public static final t O(byte by2, byte by3) {
        by3 = (byte)(by3 & 0xFF);
        t t10 = null;
        int n10 = f0.t(by3, 0);
        if (n10 <= 0) {
            return t.f.a();
        }
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(c1.h(by3) + -1);
        t10 = new t(by2, by3, null);
        return t10;
    }

    public static final w P(long l10, long l11) {
        long l12 = 0L;
        int n10 = s1.g(l11, l12);
        if (n10 <= 0) {
            return w.f.a();
        }
        l12 = g1.h((long)1 & 0xFFFFFFFFL);
        long l13 = g1.h(l11 - l12);
        w w10 = new w(l10, l13, null);
        return w10;
    }

    public static final short a(short s10, short s11) {
        int n10 = -1;
        int n11 = s10 & n10;
        n10 &= s11;
        if ((n10 = f0.t(n11, n10)) < 0) {
            s10 = s11;
        }
        return s10;
    }

    public static final int b(int n10, int n11) {
        int n12 = s1.c(n10, n11);
        if (n12 < 0) {
            n10 = n11;
        }
        return n10;
    }

    public static final byte c(byte by2, byte by3) {
        int n10 = by2 & 0xFF;
        int n11 = by3 & 0xFF;
        if ((n10 = f0.t(n10, n11)) < 0) {
            by2 = by3;
        }
        return by2;
    }

    public static final long d(long l10, long l11) {
        int n10 = s1.g(l10, l11);
        if (n10 < 0) {
            l10 = l11;
        }
        return l10;
    }

    public static final short e(short s10, short s11) {
        int n10 = -1;
        int n11 = s10 & n10;
        n10 &= s11;
        if ((n10 = f0.t(n11, n10)) > 0) {
            s10 = s11;
        }
        return s10;
    }

    public static final int f(int n10, int n11) {
        int n12 = s1.c(n10, n11);
        if (n12 > 0) {
            n10 = n11;
        }
        return n10;
    }

    public static final byte g(byte by2, byte by3) {
        int n10 = by2 & 0xFF;
        int n11 = by3 & 0xFF;
        if ((n10 = f0.t(n10, n11)) > 0) {
            by2 = by3;
        }
        return by2;
    }

    public static final long h(long l10, long l11) {
        int n10 = s1.g(l10, l11);
        if (n10 > 0) {
            l10 = l11;
        }
        return l10;
    }

    public static final long i(long l10, g g10) {
        Object object = "range";
        f0.p(g10, (String)object);
        int n10 = g10 instanceof f;
        if (n10 != 0) {
            g1 g12 = g1.b(l10);
            g10 = (f)g10;
            return ((g1)q.G(g12, (f)g10)).a0();
        }
        n10 = g10.isEmpty();
        if (n10 == 0) {
            object = (g1)g10.getStart();
            long l11 = ((g1)object).a0();
            n10 = s1.g(l10, l11);
            if (n10 < 0) {
                g1 g13 = (g1)g10.getStart();
                l10 = g13.a0();
            } else {
                object = (g1)g10.c();
                l11 = ((g1)object).a0();
                n10 = s1.g(l10, l11);
                if (n10 > 0) {
                    g1 g14 = (g1)g10.c();
                    l10 = g14.a0();
                }
            }
            return l10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot coerce value to an empty range: ");
        charSequence.append(g10);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final short j(short s10, short s11, short s12) {
        int n10 = -1;
        int n11 = s11 & n10;
        int n12 = s12 & n10;
        int n13 = f0.t(n11, n12);
        if (n13 <= 0) {
            if ((n11 = f0.t(n10 &= s10, n11)) < 0) {
                return s11;
            }
            s11 = (short)f0.t(n10, n12);
            if (s11 > 0) {
                return s12;
            }
            return s10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        String string2 = m1.T(s12);
        stringBuilder.append(string2);
        stringBuilder.append(" is less than minimum ");
        String string3 = m1.T(s11);
        stringBuilder.append(string3);
        stringBuilder.append('.');
        string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static final int k(int n10, int n11, int n12) {
        int n13 = s1.c(n11, n12);
        if (n13 <= 0) {
            n13 = s1.c(n10, n11);
            if (n13 < 0) {
                return n11;
            }
            n11 = s1.c(n10, n12);
            if (n11 > 0) {
                return n12;
            }
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        String string2 = c1.V(n12);
        stringBuilder.append(string2);
        stringBuilder.append(" is less than minimum ");
        String string3 = c1.V(n11);
        stringBuilder.append(string3);
        stringBuilder.append('.');
        string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static final byte l(byte by2, byte by3, byte by4) {
        int n10 = by3 & 0xFF;
        int n11 = by4 & 0xFF;
        int n12 = f0.t(n10, n11);
        if (n12 <= 0) {
            n12 = by2 & 0xFF;
            if ((n10 = f0.t(n12, n10)) < 0) {
                return by3;
            }
            by3 = (byte)f0.t(n12, n11);
            if (by3 > 0) {
                return by4;
            }
            return by2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        String string2 = y0.T(by4);
        stringBuilder.append(string2);
        stringBuilder.append(" is less than minimum ");
        String string3 = y0.T(by3);
        stringBuilder.append(string3);
        stringBuilder.append('.');
        string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static final long m(long l10, long l11, long l12) {
        int n10 = s1.g(l11, l12);
        if (n10 <= 0) {
            n10 = s1.g(l10, l11);
            if (n10 < 0) {
                return l11;
            }
            int n11 = s1.g(l10, l12);
            if (n11 > 0) {
                return l12;
            }
            return l10;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Cannot coerce value to an empty range: maximum ");
        String string2 = g1.V(l12);
        charSequence.append(string2);
        charSequence.append(" is less than minimum ");
        String string3 = g1.V(l11);
        charSequence.append(string3);
        charSequence.append('.');
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static final int n(int n10, g object) {
        Object object2 = "range";
        f0.p(object, (String)object2);
        int n11 = object instanceof f;
        if (n11 != 0) {
            c1 c12 = c1.b(n10);
            object = (f)object;
            return ((c1)q.G(c12, (f)object)).a0();
        }
        n11 = object.isEmpty();
        if (n11 == 0) {
            object2 = (c1)object.getStart();
            n11 = ((c1)object2).a0();
            if ((n11 = s1.c(n10, n11)) < 0) {
                c1 c13 = (c1)object.getStart();
                n10 = c13.a0();
            } else {
                object2 = (c1)object.c();
                n11 = ((c1)object2).a0();
                if ((n11 = s1.c(n10, n11)) > 0) {
                    c1 c14 = (c1)object.c();
                    n10 = c14.a0();
                }
            }
            return n10;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot coerce value to an empty range: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append('.');
        object = ((StringBuilder)object2).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final boolean o(t t10, byte by2) {
        f0.p(t10, "$this$contains");
        by2 = (byte)c1.h(by2 & 0xFF);
        return t10.j(by2);
    }

    private static final boolean p(w w10, g1 g12) {
        long l10;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(w10, string2);
        if (g12 != null && (bl2 = w10.j(l10 = g12.a0()))) {
            bl2 = true;
        } else {
            bl2 = false;
            w10 = null;
        }
        return bl2;
    }

    public static final boolean q(w w10, int n10) {
        f0.p(w10, "$this$contains");
        long l10 = g1.h((long)n10 & 0xFFFFFFFFL);
        return w10.j(l10);
    }

    public static final boolean r(w w10, byte by2) {
        f0.p(w10, "$this$contains");
        long l10 = g1.h((long)by2 & 0xFFL);
        return w10.j(l10);
    }

    public static final boolean s(t t10, short s10) {
        f0.p(t10, "$this$contains");
        s10 = (short)c1.h(s10 & (char)-1);
        return t10.j(s10);
    }

    private static final boolean t(t t10, c1 c12) {
        int n10;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(t10, string2);
        if (c12 != null && (bl2 = t10.j(n10 = c12.a0()))) {
            bl2 = true;
        } else {
            bl2 = false;
            t10 = null;
        }
        return bl2;
    }

    public static final boolean u(t t10, long l10) {
        int n10;
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(t10, string2);
        long l11 = g1.h(l10 >>> 32);
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false && (bl2 = t10.j(n10 = c1.h((int)l10)))) {
            bl2 = true;
        } else {
            bl2 = false;
            t10 = null;
        }
        return bl2;
    }

    public static final boolean v(w w10, short s10) {
        f0.p(w10, "$this$contains");
        long l10 = g1.h((long)s10 & (long)((char)-1));
        return w10.j(l10);
    }

    public static final r w(short s10, short s11) {
        r$a r$a = r.d;
        char c10 = (char)-1;
        s10 = (short)c1.h(s10 & c10);
        s11 = (short)c1.h(s11 & c10);
        return r$a.a(s10, s11, -1);
    }

    public static final r x(int n10, int n11) {
        return r.d.a(n10, n11, -1);
    }

    public static final r y(byte by2, byte by3) {
        r$a r$a = r.d;
        by2 = (byte)c1.h(by2 & 0xFF);
        by3 = (byte)c1.h(by3 & 0xFF);
        return r$a.a(by2, by3, -1);
    }

    public static final u z(long l10, long l11) {
        return u.d.a(l10, l11, -1);
    }
}

