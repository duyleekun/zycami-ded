/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.c1;
import f.g1;
import f.h2.t.f0;
import f.m1;
import f.q2.b;
import f.q2.t;
import f.s1;
import f.y0;
import kotlin.KotlinNothingValueException;

public final class z {
    public static final String a(long l10, int n10) {
        n10 = b.a(n10);
        return s1.l(l10, n10);
    }

    public static final String b(byte by2, int n10) {
        by2 = (byte)(by2 & 0xFF);
        n10 = b.a(n10);
        String string2 = Integer.toString(by2, n10);
        f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string2;
    }

    public static final String c(int n10, int n11) {
        long l10 = (long)n10 & 0xFFFFFFFFL;
        n10 = b.a(n11);
        String string2 = Long.toString(l10, n10);
        f0.o(string2, "java.lang.Long.toString(this, checkRadix(radix))");
        return string2;
    }

    public static final String d(short s10, int n10) {
        s10 = (short)(s10 & (char)-1);
        n10 = b.a(n10);
        String string2 = Integer.toString(s10, n10);
        f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return string2;
    }

    public static final byte e(String object) {
        f0.p(object, "$this$toUByte");
        y0 y02 = z.g((String)object);
        if (y02 != null) {
            return y02.Y();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final byte f(String object, int n10) {
        String string2 = "$this$toUByte";
        f0.p(object, string2);
        y0 y02 = z.h((String)object, n10);
        if (y02 != null) {
            return y02.Y();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final y0 g(String string2) {
        f0.p(string2, "$this$toUByteOrNull");
        return z.h(string2, 10);
    }

    public static final y0 h(String object, int n10) {
        String string2 = "$this$toUByteOrNull";
        f0.p(object, string2);
        object = z.l((String)object, n10);
        n10 = 0;
        if (object != null) {
            int n11 = ((c1)object).a0();
            int n12 = c1.h(255);
            if ((n12 = s1.c(n11, n12)) > 0) {
                return null;
            }
            return y0.b(y0.h((byte)n11));
        }
        return null;
    }

    public static final int i(String object) {
        f0.p(object, "$this$toUInt");
        c1 c12 = z.k((String)object);
        if (c12 != null) {
            return c12.a0();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final int j(String object, int n10) {
        String string2 = "$this$toUInt";
        f0.p(object, string2);
        c1 c12 = z.l((String)object, n10);
        if (c12 != null) {
            return c12.a0();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final c1 k(String string2) {
        f0.p(string2, "$this$toUIntOrNull");
        return z.l(string2, 10);
    }

    public static final c1 l(String string2, int n10) {
        String string3 = "$this$toUIntOrNull";
        f0.p(string2, string3);
        b.a(n10);
        int n11 = string2.length();
        if (n11 == 0) {
            return null;
        }
        int n12 = -1;
        int n13 = 0;
        int n14 = string2.charAt(0);
        int n15 = f0.t(n14, 48);
        int n16 = 1;
        if (n15 < 0) {
            if (n11 == n16 || n14 != (n15 = 43)) {
                return null;
            }
        } else {
            n16 = 0;
        }
        n14 = 0x71C71C7;
        n15 = c1.h(n10);
        int n17 = n14;
        while (n16 < n11) {
            int n18 = b.b(string2.charAt(n16), n10);
            if (n18 < 0) {
                return null;
            }
            int n19 = s1.c(n13, n17);
            if (n19 > 0 && (n17 != n14 || (n19 = s1.c(n13, n17 = s1.d(n12, n15))) > 0)) {
                return null;
            }
            n13 = c1.h(n13 * n15);
            n13 = s1.c(n18 = c1.h(c1.h(n18) + n13), n13);
            if (n13 < 0) {
                return null;
            }
            ++n16;
            n13 = n18;
        }
        return c1.b(n13);
    }

    public static final long m(String object) {
        f0.p(object, "$this$toULong");
        g1 g12 = z.o((String)object);
        if (g12 != null) {
            return g12.a0();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final long n(String object, int n10) {
        String string2 = "$this$toULong";
        f0.p(object, string2);
        g1 g12 = z.p((String)object, n10);
        if (g12 != null) {
            return g12.a0();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final g1 o(String string2) {
        f0.p(string2, "$this$toULongOrNull");
        return z.p(string2, 10);
    }

    public static final g1 p(String string2, int n10) {
        String string3 = string2;
        int n11 = n10;
        String string4 = "$this$toULongOrNull";
        f0.p(string2, string4);
        b.a(n10);
        int n12 = string2.length();
        if (n12 == 0) {
            return null;
        }
        long l10 = -1;
        int n13 = 0;
        int n14 = string2.charAt(0);
        int n15 = f0.t(n14, 48);
        int n16 = 1;
        if (n15 < 0) {
            if (n12 != n16 && n14 == (n13 = 43)) {
                n13 = n16;
            } else {
                return null;
            }
        }
        long l11 = 0x71C71C71C71C71CL;
        long l12 = g1.h(n11);
        long l13 = 0L;
        long l14 = l11;
        while (n13 < n12) {
            long l15;
            int n17 = b.b(string3.charAt(n13), n11);
            if (n17 < 0) {
                return null;
            }
            int n18 = s1.g(l13, l14);
            if (n18 > 0 && ((l15 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1)) != false || (n18 = s1.g(l13, l14 = s1.h(l10, l12))) > 0)) {
                return null;
            }
            l13 = g1.h(l13 * l12);
            n17 = c1.h(n17);
            l10 = n17;
            long l16 = 0xFFFFFFFFL;
            int n19 = s1.g(l10 = g1.h(g1.h(l10 & l16) + l13), l13);
            if (n19 < 0) {
                return null;
            }
            ++n13;
            l13 = l10;
            l10 = -1;
        }
        return g1.b(l13);
    }

    public static final short q(String object) {
        f0.p(object, "$this$toUShort");
        m1 m12 = z.s((String)object);
        if (m12 != null) {
            return m12.Y();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final short r(String object, int n10) {
        String string2 = "$this$toUShort";
        f0.p(object, string2);
        m1 m12 = z.t((String)object, n10);
        if (m12 != null) {
            return m12.Y();
        }
        t.U0((String)object);
        object = new KotlinNothingValueException();
        throw object;
    }

    public static final m1 s(String string2) {
        f0.p(string2, "$this$toUShortOrNull");
        return z.t(string2, 10);
    }

    public static final m1 t(String object, int n10) {
        String string2 = "$this$toUShortOrNull";
        f0.p(object, string2);
        object = z.l((String)object, n10);
        n10 = 0;
        if (object != null) {
            int n11 = ((c1)object).a0();
            int n12 = c1.h((char)-1);
            if ((n12 = s1.c(n11, n12)) > 0) {
                return null;
            }
            return m1.b(m1.h((short)n11));
        }
        return null;
    }
}

