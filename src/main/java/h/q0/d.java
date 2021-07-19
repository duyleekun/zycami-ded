/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.t.f0;
import f.q2.b;
import h.c0;
import h.e0;
import h.h0;
import h.j;
import h.k0;
import h.m;
import h.m0;
import h.o;
import h.o0;
import h.q0.a;
import h.z;
import java.io.EOFException;
import okio.ByteString;

public final class d {
    public static final String A(h0 h02, long l10) {
        f0.p(h02, "$this$commonReadUtf8");
        h02.L(l10);
        return h02.a.P(l10);
    }

    public static final int B(h0 h02) {
        f0.p(h02, "$this$commonReadUtf8CodePoint");
        long l10 = 1L;
        h02.L(l10);
        m m10 = h02.a;
        long l11 = 0L;
        int n10 = m10.z0(l11);
        int n11 = n10 & 0xE0;
        int n12 = 192;
        if (n11 == n12) {
            l10 = 2;
            h02.L(l10);
        } else {
            n11 = n10 & 0xF0;
            n12 = 224;
            if (n11 == n12) {
                l10 = 3;
                h02.L(l10);
            } else {
                n11 = 240;
                if ((n10 &= 0xF8) == n11) {
                    l10 = 4;
                    h02.L(l10);
                }
            }
        }
        return h02.a.Z();
    }

    public static final String C(h0 object) {
        Object object2 = "$this$commonReadUtf8Line";
        f0.p(object, (String)object2);
        byte by2 = (byte)10;
        long l10 = ((h0)object).N(by2);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object2 = ((h0)object).a;
            l10 = ((m)object2).S0();
            long l13 = l10 - (l11 = 0L);
            by2 = (byte)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (by2 != 0) {
                object2 = ((h0)object).a;
                l10 = ((m)object2).S0();
                object = ((h0)object).P(l10);
            } else {
                object = null;
            }
        } else {
            object = a.b0(((h0)object).a, l10);
        }
        return object;
    }

    public static final String D(h0 object, long l10) {
        Object object2 = "$this$commonReadUtf8LineStrict";
        f0.p(object, (String)object2);
        long l11 = 0L;
        Object object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 >= 0) {
            object3 = 1;
        } else {
            object3 = 0;
            object2 = null;
        }
        if (object3 != false) {
            byte by2;
            long l12;
            l11 = Long.MAX_VALUE;
            long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            long l14 = 1L;
            l13 = (byte)10;
            long l15 = l13 == false ? l11 : l10 + l14;
            long l16 = ((h0)object).l((byte)l13, 0L, l15);
            long l17 = l16 - (l12 = (long)-1);
            Object object4 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object4 != false) {
                return a.b0(((h0)object).a, l16);
            }
            object3 = l15 == l11 ? 0 : (l15 < l11 ? -1 : 1);
            if (object3 < 0 && (object3 = (Object)((h0)object).request(l15)) != false && (object3 = (Object)((m)(object2 = ((h0)object).a)).z0(l16 = l15 - l14)) == (by2 = (byte)13) && (object3 = (Object)((h0)object).request(l14 += l15)) != false && (object3 = (Object)((m)(object2 = ((h0)object).a)).z0(l15)) == l13) {
                return a.b0(((h0)object).a, l15);
            }
            m m10 = new m();
            object2 = ((h0)object).a;
            long l18 = ((m)object2).S0();
            l18 = Math.min((long)32, l18);
            Object object5 = m10;
            ((m)object2).s0(m10, 0L, l18);
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("\\n not found: limit=");
            long l19 = Math.min(((h0)object).a.S0(), l10);
            ((StringBuilder)object5).append(l19);
            ((StringBuilder)object5).append(" content=");
            object = m10.b0().hex();
            ((StringBuilder)object5).append((String)object);
            ((StringBuilder)object5).append("\u2026");
            object = ((StringBuilder)object5).toString();
            object2 = new EOFException((String)object);
            throw object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("limit < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final boolean E(h0 object, long l10) {
        Object object2 = "$this$commonRequest";
        f0.p(object, (String)object2);
        long l11 = 0L;
        Object object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (object3 >= 0) {
            object3 = n10;
        } else {
            object3 = 0;
            object2 = null;
        }
        if (object3 != false) {
            object3 = ((h0)object).b ^ n10;
            if (object3 != false) {
                long l12;
                long l13;
                while ((object3 = (l13 = (l12 = ((m)(object2 = ((h0)object).a)).S0()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                    long l14;
                    object2 = ((h0)object).c;
                    m m10 = ((h0)object).a;
                    int n11 = 8192;
                    long l15 = n11;
                    l12 = object2.read(m10, l15);
                    long l16 = l12 - (l14 = (long)-1);
                    object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (object3 != false) continue;
                    return false;
                }
                return n10 != 0;
            }
            String string2 = "closed".toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final void F(h0 object, long l10) {
        String string2 = "$this$commonRequire";
        f0.p(object, string2);
        boolean bl2 = ((h0)object).request(l10);
        if (bl2) {
            return;
        }
        object = new EOFException();
        throw object;
    }

    public static final int G(h0 object, c0 object2) {
        f0.p(object, "$this$commonSelect");
        Object object3 = "options";
        f0.p(object2, (String)object3);
        int n10 = ((h0)object).b;
        int n11 = 1;
        if ((n10 ^= n11) != 0) {
            int n12;
            long l10;
            m m10;
            long l11;
            long l12;
            do {
                object3 = ((h0)object).a;
                n10 = a.d0((m)object3, (c0)object2, n11 != 0);
                int n13 = -2;
                n12 = -1;
                if (n10 != n13) {
                    if (n10 != n12) {
                        int n14 = ((c0)object2).f()[n10].size();
                        object = ((h0)object).a;
                        long l13 = n14;
                        ((m)object).skip(l13);
                        return n10;
                    }
                    return n12;
                }
                object3 = ((h0)object).c;
                m10 = ((h0)object).a;
                int n15 = 8192;
                l11 = n15;
            } while ((n10 = (int)((l12 = (l11 = object3.read(m10, l11)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0);
            return n12;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final void H(h0 object, long l10) {
        Object object2 = "$this$commonSkip";
        f0.p(object, (String)object2);
        Object object3 = ((h0)object).b ^ true;
        if (object3) {
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                m m10 = ((h0)object).a;
                long l14 = m10.S0();
                long l15 = l14 - l11;
                object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (!object3) {
                    object2 = ((h0)object).c;
                    m m11 = ((h0)object).a;
                    l13 = 8192;
                    l14 = l13;
                    l11 = object2.read(m11, l14);
                    long l16 = l11 - (l14 = (long)-1);
                    object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (!object3) {
                        object = new EOFException();
                        throw object;
                    }
                }
                object2 = ((h0)object).a;
                l11 = ((m)object2).S0();
                l11 = Math.min(l10, l11);
                m10 = ((h0)object).a;
                m10.skip(l11);
                l10 -= l11;
            }
            return;
        }
        String string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public static final o0 I(h0 h02) {
        f0.p(h02, "$this$commonTimeout");
        return h02.c.timeout();
    }

    public static final String J(h0 m02) {
        f0.p(m02, "$this$commonToString");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        m02 = m02.c;
        stringBuilder.append(m02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public static final void a(h0 h02) {
        String string2 = "$this$commonClose";
        f0.p(h02, string2);
        boolean bl2 = h02.b;
        if (bl2) {
            return;
        }
        h02.b = true;
        h02.c.close();
        h02.a.B();
    }

    public static final boolean b(h0 object) {
        Object object2;
        block2: {
            boolean bl2;
            block4: {
                block3: {
                    long l10;
                    object2 = "$this$commonExhausted";
                    f0.p(object, (String)object2);
                    boolean bl3 = ((h0)object).b;
                    bl2 = true;
                    if (!(bl3 ^= bl2)) break block2;
                    object2 = ((h0)object).a;
                    bl3 = ((m)object2).V();
                    if (!bl3) break block3;
                    object2 = ((h0)object).c;
                    object = ((h0)object).a;
                    int n10 = 8192;
                    long l11 = n10;
                    long l12 = (l11 = object2.read((m)object, l11)) - (l10 = (long)-1);
                    Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 == false) break block4;
                }
                bl2 = false;
            }
            return bl2;
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final long c(h0 object, byte by2, long l10, long l11) {
        Object object2 = "$this$commonIndexOf";
        f0.p(object, (String)object2);
        Object object3 = ((h0)object).b;
        int n10 = 1;
        if ((object3 ^= n10) != 0) {
            long l12 = 0L;
            long l13 = l12 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 > 0 || (object3 = (Object)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1))) < 0) {
                n10 = 0;
            }
            if (n10 != 0) {
                long l14;
                while (true) {
                    int n11;
                    m m10;
                    long l15;
                    object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    l14 = -1;
                    if (object3 >= 0) break;
                    m0 m02 = ((h0)object).a;
                    long l16 = l10;
                    long l17 = ((m)m02).l(by2, l10, l11);
                    long l18 = l17 - l14;
                    Object object4 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object4 != false) {
                        return l17;
                    }
                    object2 = ((h0)object).a;
                    l17 = ((m)object2).S0();
                    long l19 = l17 - l11;
                    object4 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                    if (object4 >= 0 || (object4 = (l15 = (l12 = (m02 = ((h0)object).c).read(m10 = ((h0)object).a, l16 = (long)(n11 = 8192))) - l14) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) break;
                    l10 = Math.max(l10, l17);
                }
                return l14;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("fromIndex=");
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(" toIndex=");
            ((StringBuilder)object).append(l11);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        String string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public static final long d(h0 object, ByteString object2, long l10) {
        f0.p(object, "$this$commonIndexOf");
        Object object3 = "bytes";
        f0.p(object2, (String)object3);
        boolean bl2 = ((h0)object).b ^ true;
        if (bl2) {
            while (true) {
                long l11;
                long l12;
                long l13;
                Object object4;
                if ((object4 = (l13 = (l12 = ((m)(object3 = ((h0)object).a)).c((ByteString)object2, l10)) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                    return l12;
                }
                object3 = ((h0)object).a;
                l12 = ((m)object3).S0();
                m0 m02 = ((h0)object).c;
                m m10 = ((h0)object).a;
                int n10 = 8192;
                long l14 = n10;
                long l15 = m02.read(m10, l14);
                long l16 = l15 - l11;
                object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 == false) {
                    return l11;
                }
                int n11 = ((ByteString)object2).size();
                l11 = n11;
                l12 -= l11;
                l11 = 1L;
                l10 = Math.max(l10, l12 += l11);
            }
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final long e(h0 object, ByteString object2, long l10) {
        f0.p(object, "$this$commonIndexOfElement");
        Object object3 = "targetBytes";
        f0.p(object2, (String)object3);
        boolean bl2 = ((h0)object).b ^ true;
        if (bl2) {
            while (true) {
                long l11;
                long l12;
                long l13;
                Object object4;
                if ((object4 = (l13 = (l12 = ((m)(object3 = ((h0)object).a)).K((ByteString)object2, l10)) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                    return l12;
                }
                object3 = ((h0)object).a;
                l12 = ((m)object3).S0();
                m0 m02 = ((h0)object).c;
                m m10 = ((h0)object).a;
                int n10 = 8192;
                long l14 = n10;
                long l15 = m02.read(m10, l14);
                long l16 = l15 - l11;
                object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 == false) {
                    return l11;
                }
                l10 = Math.max(l10, l12);
            }
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public static final o f(h0 h02) {
        f0.p(h02, "$this$commonPeek");
        e0 e02 = new e0(h02);
        return z.d(e02);
    }

    public static final boolean g(h0 object, long l10, ByteString byteString, int n10, int n11) {
        f0.p(object, "$this$commonRangeEquals");
        String string2 = "bytes";
        f0.p(byteString, string2);
        Object object2 = ((h0)object).b;
        int n12 = 1;
        if ((object2 ^= n12) != 0) {
            long l11 = 0L;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 >= 0 && n10 >= 0 && n11 >= 0 && (object2 = byteString.size() - n10) >= n11) {
                string2 = null;
                for (object2 = 0; object2 < n11; ++object2) {
                    long l13 = (long)object2 + l10;
                    long l14 = 1L + l13;
                    boolean bl2 = ((h0)object).request(l14);
                    if (!bl2) {
                        return false;
                    }
                    m m10 = ((h0)object).a;
                    byte by2 = m10.z0(l13);
                    int n13 = n10 + object2;
                    if (by2 == (n13 = (int)byteString.getByte(n13))) continue;
                    return false;
                }
                return n12 != 0;
            }
            return false;
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public static final int h(h0 h02, byte[] byArray, int n10, int n11) {
        int n12;
        long l10;
        f0.p(h02, "$this$commonRead");
        Object object = "sink";
        f0.p(byArray, (String)object);
        int n13 = byArray.length;
        long l11 = n13;
        long l12 = n10;
        long l13 = n11;
        j.e(l11, l12, l13);
        m0 m02 = h02.a;
        long l14 = ((m)m02).S0();
        long l15 = 0L;
        n11 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
        if (n11 == 0 && (n11 = (int)((l10 = (l14 = (m02 = h02.c).read((m)(object = h02.a), l11 = (long)(n12 = 8192))) - (l15 = (long)-1)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) == 0) {
            return -1;
        }
        l14 = h02.a.S0();
        n11 = (int)Math.min(l13, l14);
        return h02.a.read(byArray, n10, n11);
    }

    public static final long i(h0 object, m object2, long l10) {
        m m10;
        f0.p(object, "$this$commonRead");
        Object object3 = "sink";
        f0.p(object2, (String)object3);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 >= 0) {
            l12 = n10;
        } else {
            l12 = 0;
            m10 = null;
        }
        if (l12 != false) {
            l12 = ((h0)object).b ^ n10;
            if (l12 != false) {
                m10 = ((h0)object).a;
                long l13 = m10.S0();
                long l14 = l13 - l11;
                Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object4 == false) {
                    object3 = ((h0)object).c;
                    m m11 = ((h0)object).a;
                    l12 = 8192;
                    l13 = l12;
                    l11 = object3.read(m11, l13);
                    long l15 = l11 - (l13 = (long)-1);
                    object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object4 == false) {
                        return l13;
                    }
                }
                l11 = ((h0)object).a.S0();
                l10 = Math.min(l10, l11);
                return ((h0)object).a.read((m)object2, l10);
            }
            object2 = "closed".toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static final long j(h0 o10, k0 k02) {
        long l10;
        m0 m02;
        long l11;
        f0.p(o10, "$this$commonReadAll");
        Object object = "sink";
        f0.p(k02, (String)object);
        long l12 = l11 = 0L;
        while (true) {
            m02 = ((h0)o10).c;
            m m10 = ((h0)o10).a;
            int n10 = 8192;
            long l13 = n10;
            l10 = m02.read(m10, l13);
            long l14 = l10 - (l13 = (long)-1);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 == false) break;
            m02 = ((h0)o10).a;
            l10 = ((m)m02).O();
            long l15 = l10 - l11;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 <= 0) continue;
            l12 += l10;
            m m11 = ((h0)o10).a;
            k02.t(m11, l10);
        }
        m02 = ((h0)o10).a;
        l10 = ((m)m02).S0();
        long l16 = l10 - l11;
        Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object3 > 0) {
            object = ((h0)o10).a;
            l11 = ((m)object).S0();
            l12 += l11;
            o10 = ((h0)o10).a;
            l11 = ((m)o10).S0();
            k02.t((m)o10, l11);
        }
        return l12;
    }

    public static final byte k(h0 h02) {
        f0.p(h02, "$this$commonReadByte");
        h02.L(1L);
        return h02.a.readByte();
    }

    public static final byte[] l(h0 h02) {
        f0.p(h02, "$this$commonReadByteArray");
        m m10 = h02.a;
        m0 m02 = h02.c;
        m10.v(m02);
        return h02.a.T();
    }

    public static final byte[] m(h0 h02, long l10) {
        f0.p(h02, "$this$commonReadByteArray");
        h02.L(l10);
        return h02.a.z(l10);
    }

    public static final ByteString n(h0 h02) {
        f0.p(h02, "$this$commonReadByteString");
        m m10 = h02.a;
        m0 m02 = h02.c;
        m10.v(m02);
        return h02.a.b0();
    }

    public static final ByteString o(h0 h02, long l10) {
        f0.p(h02, "$this$commonReadByteString");
        h02.L(l10);
        return h02.a.Q(l10);
    }

    public static final long p(h0 object) {
        long l10;
        byte by2;
        long l11;
        CharSequence charSequence = "$this$commonReadDecimalLong";
        f0.p(object, (String)charSequence);
        long l12 = 1L;
        ((h0)object).L(l12);
        long l13 = l11 = 0L;
        while ((by2 = ((h0)object).request(l10 = l13 + l12)) != 0) {
            byte by3;
            long l14;
            byte by4;
            m m10 = ((h0)object).a;
            by2 = m10.z0(l13);
            if (by2 >= (by4 = (byte)48) && by2 <= (by4 = (byte)57) || (l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) == false && by2 == (by3 = (byte)45)) {
                l13 = l10;
                continue;
            }
            if (l14 != false) break;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Expected leading [0-9] or '-' character but was 0x");
            int n10 = b.a(b.a(16));
            String string2 = Integer.toString(by2, n10);
            f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            object = new NumberFormatException((String)charSequence);
            throw object;
        }
        return ((h0)object).a.W();
    }

    public static final void q(h0 o10, m m10, long l10) {
        f0.p(o10, "$this$commonReadFully");
        String string2 = "sink";
        f0.p(m10, string2);
        try {
            o10.L(l10);
            o10.a.k(m10, l10);
            return;
        }
        catch (EOFException eOFException) {
            o10 = o10.a;
            m10.v(o10);
            throw eOFException;
        }
    }

    public static final void r(h0 object, byte[] byArray) {
        int n10;
        f0.p(object, "$this$commonReadFully");
        String string2 = "sink";
        f0.p(byArray, string2);
        try {
            n10 = byArray.length;
        }
        catch (EOFException eOFException) {
            long l10;
            m m10;
            long l11;
            long l12;
            long l13;
            int n11 = 0;
            while ((l13 = (l12 = (l11 = (m10 = ((h0)object).a).S0()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                m10 = ((h0)object).a;
                long l14 = m10.S0();
                int n12 = (int)l14;
                l13 = m10.read(byArray, n11, n12);
                if (l13 != (n12 = -1)) {
                    n11 += l13;
                    continue;
                }
                object = new AssertionError();
                throw object;
            }
            throw eOFException;
        }
        long l15 = n10;
        ((h0)object).L(l15);
        ((h0)object).a.readFully(byArray);
    }

    public static final long s(h0 object) {
        int n10;
        long l10;
        byte by2;
        f0.p(object, "$this$commonReadHexadecimalUnsignedLong");
        long l11 = 1L;
        ((h0)object).L(l11);
        int n11 = 0;
        CharSequence charSequence = null;
        while ((by2 = ((h0)object).request(l10 = (long)(n10 = n11 + 1))) != 0) {
            byte by3;
            m m10 = ((h0)object).a;
            long l12 = n11;
            by2 = m10.z0(l12);
            if (by2 >= (by3 = (byte)48) && by2 <= (by3 = (byte)57) || by2 >= (by3 = (byte)97) && by2 <= (by3 = (byte)102) || by2 >= (by3 = (byte)65) && by2 <= (by3 = (byte)70)) {
                n11 = n10;
                continue;
            }
            if (n11 != 0) break;
            charSequence = new StringBuilder();
            charSequence.append("Expected leading [0-9a-fA-F] character but was 0x");
            n10 = b.a(b.a(16));
            String string2 = Integer.toString(by2, n10);
            f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = new NumberFormatException((String)charSequence);
            throw object;
        }
        return ((h0)object).a.k0();
    }

    public static final int t(h0 h02) {
        f0.p(h02, "$this$commonReadInt");
        h02.L(4);
        return h02.a.readInt();
    }

    public static final int u(h0 h02) {
        f0.p(h02, "$this$commonReadIntLe");
        h02.L(4);
        return h02.a.e0();
    }

    public static final long v(h0 h02) {
        f0.p(h02, "$this$commonReadLong");
        h02.L(8);
        return h02.a.readLong();
    }

    public static final long w(h0 h02) {
        f0.p(h02, "$this$commonReadLongLe");
        h02.L(8);
        return h02.a.I();
    }

    public static final short x(h0 h02) {
        f0.p(h02, "$this$commonReadShort");
        h02.L(2);
        return h02.a.readShort();
    }

    public static final short y(h0 h02) {
        f0.p(h02, "$this$commonReadShortLe");
        h02.L(2);
        return h02.a.G();
    }

    public static final String z(h0 h02) {
        f0.p(h02, "$this$commonReadUtf8");
        m m10 = h02.a;
        m0 m02 = h02.c;
        m10.v(m02);
        return h02.a.f0();
    }
}

