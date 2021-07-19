/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.t.f0;
import h.g0;
import h.k0;
import h.m;
import h.m0;
import h.n;
import h.o0;
import java.io.EOFException;
import okio.ByteString;

public final class c {
    public static final void a(g0 g02) {
        int n10;
        Object object;
        block13: {
            k0 k02;
            block12: {
                object = "$this$commonClose";
                f0.p(g02, (String)object);
                boolean bl2 = g02.b;
                if (bl2) {
                    return;
                }
                bl2 = false;
                object = null;
                k02 = g02.a;
                long l10 = ((m)k02).S0();
                long l11 = 0L;
                n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (n10 <= 0) break block12;
                k02 = g02.c;
                m m10 = g02.a;
                l11 = m10.S0();
                try {
                    k02.t(m10, l11);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            k02 = g02.c;
            try {
                k02.close();
            }
            catch (Throwable throwable) {
                if (object != null) break block13;
                object = throwable;
            }
        }
        g02.b = n10 = 1;
        if (object == null) {
            return;
        }
        throw object;
    }

    public static final n b(g0 object) {
        Object object2 = "$this$commonEmit";
        f0.p(object, (String)object2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            long l10;
            object2 = ((g0)object).a;
            long l11 = ((m)object2).S0();
            long l12 = l11 - (l10 = 0L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 > 0) {
                k0 k02 = ((g0)object).c;
                m m10 = ((g0)object).a;
                k02.t(m10, l11);
            }
            return object;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final n c(g0 object) {
        Object object2 = "$this$commonEmitCompleteSegments";
        f0.p(object, (String)object2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            long l10;
            object2 = ((g0)object).a;
            long l11 = ((m)object2).O();
            long l12 = l11 - (l10 = 0L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 > 0) {
                k0 k02 = ((g0)object).c;
                m m10 = ((g0)object).a;
                k02.t(m10, l11);
            }
            return object;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final void d(g0 object) {
        Object object2 = "$this$commonFlush";
        f0.p(object, (String)object2);
        Object object3 = ((g0)object).b ^ 1;
        if (object3 != 0) {
            long l10;
            object2 = ((g0)object).a;
            long l11 = ((m)object2).S0();
            long l12 = l11 - (l10 = 0L);
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 > 0) {
                object2 = ((g0)object).c;
                m m10 = ((g0)object).a;
                l10 = m10.S0();
                object2.t(m10, l10);
            }
            ((g0)object).c.flush();
            return;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final o0 e(g0 g02) {
        f0.p(g02, "$this$commonTimeout");
        return g02.c.timeout();
    }

    public static final String f(g0 k02) {
        f0.p(k02, "$this$commonToString");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        k02 = k02.c;
        stringBuilder.append(k02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static final n g(g0 object, ByteString object2) {
        f0.p(object, "$this$commonWrite");
        String string2 = "byteString";
        f0.p(object2, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.W0((ByteString)object2);
            return ((g0)object).o();
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final n h(g0 object, ByteString object2, int n10, int n11) {
        f0.p(object, "$this$commonWrite");
        String string2 = "byteString";
        f0.p(object2, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.X0((ByteString)object2, n10, n11);
            return ((g0)object).o();
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final n i(g0 object, m0 m02, long l10) {
        long l11;
        long l12;
        long l13;
        f0.p(object, "$this$commonWrite");
        Object object2 = "source";
        f0.p(m02, (String)object2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14;
            object2 = ((g0)object).a;
            l11 = m02.read((m)object2, l10);
            long l15 = l11 - (l14 = (long)-1);
            Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 != false) {
                l10 -= l11;
                ((g0)object).o();
                continue;
            }
            object = new EOFException();
            throw object;
        }
        return object;
    }

    public static final n j(g0 object, byte[] object2) {
        f0.p(object, "$this$commonWrite");
        String string2 = "source";
        f0.p(object2, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.Z0((byte[])object2);
            return ((g0)object).o();
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final n k(g0 object, byte[] object2, int n10, int n11) {
        f0.p(object, "$this$commonWrite");
        String string2 = "source";
        f0.p(object2, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.a1((byte[])object2, n10, n11);
            return ((g0)object).o();
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final void l(g0 object, m object2, long l10) {
        f0.p(object, "$this$commonWrite");
        String string2 = "source";
        f0.p(object2, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.t((m)object2, l10);
            ((g0)object).o();
            return;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final long m(g0 g02, m0 m02) {
        f0.p(g02, "$this$commonWriteAll");
        String string2 = "source";
        f0.p(m02, string2);
        long l10 = 0L;
        long l11;
        int n10;
        long l12;
        m m10;
        long l13;
        long l14;
        long l15;
        while ((l15 = (l14 = (l13 = m02.read(m10 = g02.a, l12 = (long)(n10 = 8192))) - (l11 = (long)-1)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            l10 += l13;
            g02.o();
        }
        return l10;
    }

    public static final n n(g0 object, int n10) {
        String string2 = "$this$commonWriteByte";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.b1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n o(g0 object, long l10) {
        String string2 = "$this$commonWriteDecimalLong";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.c1(l10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n p(g0 object, long l10) {
        String string2 = "$this$commonWriteHexadecimalUnsignedLong";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.d1(l10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n q(g0 object, int n10) {
        String string2 = "$this$commonWriteInt";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.e1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n r(g0 object, int n10) {
        String string2 = "$this$commonWriteIntLe";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.f1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n s(g0 object, long l10) {
        String string2 = "$this$commonWriteLong";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.g1(l10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n t(g0 object, long l10) {
        String string2 = "$this$commonWriteLongLe";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.h1(l10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n u(g0 object, int n10) {
        String string2 = "$this$commonWriteShort";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.i1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n v(g0 object, int n10) {
        String string2 = "$this$commonWriteShortLe";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.j1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final n w(g0 object, String string2) {
        f0.p(object, "$this$commonWriteUtf8");
        String string3 = "string";
        f0.p(string2, string3);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.p1(string2);
            return ((g0)object).o();
        }
        string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public static final n x(g0 object, String string2, int n10, int n11) {
        f0.p(object, "$this$commonWriteUtf8");
        String string3 = "string";
        f0.p(string2, string3);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.q1(string2, n10, n11);
            return ((g0)object).o();
        }
        string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public static final n y(g0 object, int n10) {
        String string2 = "$this$commonWriteUtf8CodePoint";
        f0.p(object, string2);
        boolean bl2 = ((g0)object).b ^ true;
        if (bl2) {
            ((g0)object).a.r1(n10);
            return ((g0)object).o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }
}

