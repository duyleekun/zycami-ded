/*
 * Decompiled with CFR 0.151.
 */
package h.q0;

import f.h2.s.p;
import f.h2.t.f0;
import f.x1.n;
import h.c0;
import h.i;
import h.i0;
import h.j;
import h.j0;
import h.k0;
import h.m;
import h.m0;
import h.q0.f;
import java.io.EOFException;
import okio.ByteString;
import okio.SegmentedByteString;

public final class a {
    private static final byte[] a = i.a("0123456789abcdef");
    public static final int b = 4096;
    public static final long c = -922337203685477580L;
    public static final long d = 249L;

    public static final short A(m object) {
        Object object2 = "$this$commonReadShort";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        long l11 = 2;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            object2 = ((m)object).a;
            f0.m(object2);
            int n10 = ((i0)object2).b;
            int n11 = ((i0)object2).c;
            int n12 = n11 - n10;
            int n13 = 2;
            if (n12 < n13) {
                l12 = (((m)object).readByte() & 0xFF) << 8;
                return (short)(((m)object).readByte() & 0xFF | l12);
            }
            byte[] byArray = ((i0)object2).a;
            n13 = n10 + 1;
            n10 = (byArray[n10] & 0xFF) << 8;
            int n14 = n13 + 1;
            n12 = byArray[n13] & 0xFF;
            n10 |= n12;
            long l13 = ((m)object).S0() - l11;
            ((m)object).O0(l13);
            if (n14 == n11) {
                i0 i02;
                ((m)object).a = i02 = ((i0)object2).b();
                j0.d((i0)object2);
            } else {
                ((i0)object2).b = n14;
            }
            return (short)n10;
        }
        object = new EOFException();
        throw object;
    }

    public static final String B(m object, long l10) {
        long l11;
        long l12;
        int n10;
        Object object2 = "$this$commonReadUtf8";
        f0.p(object, (String)object2);
        long l13 = 0L;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        Object object3 = null;
        n10 = l14 >= 0 && (n10 = (l12 = l10 - (l11 = (long)(-1 >>> 1))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0 ? 1 : 0;
        if (n10 != 0) {
            l11 = ((m)object).S0();
            long l15 = l11 - l10;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 >= 0) {
                if (l14 == false) {
                    return "";
                }
                object2 = ((m)object).a;
                f0.m(object2);
                n10 = ((i0)object2).b;
                long l16 = (long)n10 + l10;
                int n11 = ((i0)object2).c;
                long l17 = n11;
                long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
                if (l18 > 0) {
                    return f.c(((m)object).z(l10), 0, 0, 3, null);
                }
                object3 = ((i0)object2).a;
                l18 = (int)l10;
                int n12 = n10 + l18;
                object3 = f.b(object3, n10, n12);
                ((i0)object2).b = n10 = ((i0)object2).b + l18;
                l11 = ((m)object).S0() - l10;
                ((m)object).O0(l11);
                int n13 = ((i0)object2).b;
                int n14 = ((i0)object2).c;
                if (n13 == n14) {
                    i0 i02;
                    ((m)object).a = i02 = ((i0)object2).b();
                    j0.d((i0)object2);
                }
                return object3;
            }
            object = new EOFException();
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final int C(m object) {
        block8: {
            int n10;
            block13: {
                int n11;
                int n12;
                int n13;
                int n14;
                int n15;
                long l10;
                block10: {
                    block12: {
                        block11: {
                            block9: {
                                String string2 = "$this$commonReadUtf8CodePoint";
                                f0.p(object, string2);
                                long l11 = ((m)object).S0();
                                long l12 = 0L;
                                l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                                if (l10 == false) break block8;
                                l10 = ((m)object).z0(l12);
                                n15 = l10 & 0x80;
                                n14 = 1;
                                n13 = 128;
                                n10 = -3;
                                if (n15 != 0) break block9;
                                n15 = l10 & 0x7F;
                                n12 = 0;
                                n11 = n14;
                                break block10;
                            }
                            n15 = l10 & 0xE0;
                            n11 = 192;
                            if (n15 != n11) break block11;
                            n15 = l10 & 0x1F;
                            n11 = 2;
                            n12 = n13;
                            break block10;
                        }
                        n15 = l10 & 0xF0;
                        n11 = 224;
                        if (n15 != n11) break block12;
                        n15 = l10 & 0xF;
                        n11 = 3;
                        n12 = 2048;
                        break block10;
                    }
                    n15 = l10 & 0xF8;
                    n11 = 240;
                    if (n15 != n11) break block13;
                    n15 = l10 & 7;
                    n11 = 4;
                    n12 = 65536;
                }
                long l13 = ((m)object).S0();
                long l14 = n11;
                long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                if (l15 >= 0) {
                    while (n14 < n11) {
                        l13 = n14;
                        l10 = ((m)object).z0(l13);
                        int n16 = l10 & 0xC0;
                        if (n16 == n13) {
                            n15 <<= 6;
                            l10 = l10 & 0x3F;
                            n15 |= l10;
                            ++n14;
                            continue;
                        }
                        ((m)object).skip(l13);
                        return n10;
                    }
                    ((m)object).skip(l14);
                    int n17 = 0x10FFFF;
                    if (n15 <= n17) {
                        n17 = 57343;
                        l10 = 55296;
                        if ((l10 > n15 || n17 < n15) && n15 >= n12) {
                            n10 = n15;
                        }
                    }
                    return n10;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("size < ");
                stringBuilder.append(n11);
                stringBuilder.append(": ");
                long l16 = ((m)object).S0();
                stringBuilder.append(l16);
                stringBuilder.append(" (to read code point prefixed 0x");
                object = j.m((byte)l10);
                stringBuilder.append((String)object);
                stringBuilder.append(')');
                object = stringBuilder.toString();
                EOFException eOFException = new EOFException((String)object);
                throw eOFException;
            }
            ((m)object).skip(1L);
            return n10;
        }
        object = new EOFException();
        throw object;
    }

    public static final String D(m object) {
        String string2 = "$this$commonReadUtf8Line";
        f0.p(object, string2);
        byte by2 = (byte)10;
        long l10 = ((m)object).N(by2);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            object = h.q0.a.b0((m)object, l10);
        } else {
            l10 = ((m)object).S0();
            long l13 = l10 - (l11 = 0L);
            by2 = (byte)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (by2 != 0) {
                l10 = ((m)object).S0();
                object = ((m)object).P(l10);
            } else {
                object = null;
            }
        }
        return object;
    }

    public static final String E(m object, long l10) {
        Object object2 = "$this$commonReadUtf8LineStrict";
        f0.p(object, (String)object2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            object2 = null;
        }
        if (l12 != false) {
            byte by2;
            byte by3;
            l11 = Long.MAX_VALUE;
            long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            long l14 = 1L;
            if (l13 != false) {
                l11 = l10 + l14;
            }
            l13 = (byte)10;
            long l15 = ((m)object).l((byte)l13, 0L, l11);
            long l16 = -1;
            long l17 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
            if (l17 != false) {
                return h.q0.a.b0((m)object, l15);
            }
            l15 = ((m)object).S0();
            long l18 = l11 - l15;
            Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object3 < 0 && (by3 = ((m)object).z0(l14 = l11 - l14)) == (by2 = (byte)13) && (by3 = ((m)object).z0(l11)) == l13) {
                return h.q0.a.b0((m)object, l11);
            }
            m m10 = new m();
            long l19 = ((m)object).S0();
            l19 = Math.min((long)32, l19);
            object2 = object;
            Object object4 = m10;
            ((m)object).s0(m10, 0L, l19);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("\\n not found: limit=");
            long l20 = Math.min(((m)object).S0(), l10);
            ((StringBuilder)object4).append(l20);
            ((StringBuilder)object4).append(" content=");
            object = m10.b0().hex();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append('\u2026');
            object = ((StringBuilder)object4).toString();
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

    public static final int F(m m10, c0 c02) {
        f0.p(m10, "$this$commonSelect");
        f0.p(c02, "options");
        int n10 = h.q0.a.e0(m10, c02, false, 2, null);
        int n11 = -1;
        if (n10 == n11) {
            return n11;
        }
        long l10 = c02.f()[n10].size();
        m10.skip(l10);
        return n10;
    }

    public static final void G(m object, long l10) {
        long l11;
        long l12;
        long l13;
        Object object2 = "$this$commonSkip";
        f0.p(object, (String)object2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            object2 = ((m)object).a;
            if (object2 != null) {
                i0 i02;
                int n10 = ((i0)object2).c;
                int n11 = ((i0)object2).b;
                long l14 = n10 - n11;
                l14 = Math.min(l10, l14);
                n10 = (int)l14;
                long l15 = ((m)object).S0();
                long l16 = n10;
                ((m)object).O0(l15 -= l16);
                l10 -= l16;
                ((i0)object2).b = n11 = ((i0)object2).b + n10;
                n10 = ((i0)object2).c;
                if (n11 != n10) continue;
                ((m)object).a = i02 = ((i0)object2).b();
                j0.d((i0)object2);
                continue;
            }
            object = new EOFException();
            throw object;
        }
    }

    public static final ByteString H(m object) {
        Object object2 = "$this$commonSnapshot";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        int n10 = -1 >>> 1;
        long l11 = n10;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 <= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            object2 = null;
        }
        if (l12 != false) {
            l12 = (int)((m)object).S0();
            return ((m)object).U0((int)l12);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("size > Int.MAX_VALUE: ");
        long l13 = ((m)object).S0();
        ((StringBuilder)object2).append(l13);
        object = ((StringBuilder)object2).toString();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public static final ByteString I(m object, int n10) {
        int n11;
        int n12;
        Object object2 = "$this$commonSnapshot";
        f0.p(object, (String)object2);
        if (n10 == 0) {
            return ByteString.EMPTY;
        }
        long l10 = ((m)object).S0();
        long l11 = 0L;
        long l12 = n10;
        j.e(l10, l11, l12);
        object2 = ((m)object).a;
        int n13 = 0;
        int n14 = 0;
        int[] nArray = null;
        int n15 = 0;
        while (n14 < n10) {
            f0.m(object2);
            n12 = ((i0)object2).c;
            n11 = ((i0)object2).b;
            if (n12 != n11) {
                n14 += (n12 -= n11);
                ++n15;
                object2 = ((i0)object2).f;
                continue;
            }
            object = new AssertionError((Object)"s.limit == s.pos");
            throw object;
        }
        object2 = new byte[n15][];
        n14 = n15 * 2;
        nArray = new int[n14];
        object = ((m)object).a;
        n12 = 0;
        while (n13 < n10) {
            f0.m(object);
            byte[] byArray = ((i0)object).a;
            object2[n12] = byArray;
            n11 = ((i0)object).c;
            int n16 = ((i0)object).b;
            nArray[n12] = n11 = Math.min(n13 += (n11 -= n16), n10);
            n11 = n12 + n15;
            nArray[n11] = n16 = ((i0)object).b;
            n11 = 1;
            ((i0)object).d = n11;
            n12 += n11;
            object = ((i0)object).f;
        }
        object = new SegmentedByteString((byte[][])object2, nArray);
        return object;
    }

    public static final i0 J(m object, int n10) {
        i0 i02;
        String string2 = "$this$commonWritableSegment";
        f0.p(object, string2);
        int n11 = 8192;
        int n12 = 1;
        if (n10 < n12 || n10 > n11) {
            n12 = 0;
            i02 = null;
        }
        if (n12 != 0) {
            i02 = ((m)object).a;
            if (i02 == null) {
                i0 i03;
                ((m)object).a = i03 = j0.e();
                i03.g = i03;
                i03.f = i03;
                return i03;
            }
            f0.m(i02);
            object = i02.g;
            f0.m(object);
            n12 = ((i0)object).c + n10;
            if (n12 > n11 || (n10 = (int)(((i0)object).e ? 1 : 0)) == 0) {
                i0 i04 = j0.e();
                object = ((i0)object).c(i04);
            }
            return object;
        }
        String string3 = "unexpected capacity".toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public static final m K(m m10, ByteString byteString, int n10, int n11) {
        f0.p(m10, "$this$commonWrite");
        f0.p(byteString, "byteString");
        byteString.write$okio(m10, n10, n11);
        return m10;
    }

    public static final m L(m object, m0 m02, long l10) {
        long l11;
        long l12;
        long l13;
        f0.p(object, "$this$commonWrite");
        String string2 = "source";
        f0.p(m02, string2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14;
            l11 = m02.read((m)object, l10);
            long l15 = l11 - (l14 = (long)-1);
            Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object2 != false) {
                l10 -= l11;
                continue;
            }
            object = new EOFException();
            throw object;
        }
        return object;
    }

    public static final m M(m m10, byte[] byArray) {
        f0.p(m10, "$this$commonWrite");
        f0.p(byArray, "source");
        int n10 = byArray.length;
        return m10.a1(byArray, 0, n10);
    }

    public static final m N(m m10, byte[] byArray, int n10, int n11) {
        f0.p(m10, "$this$commonWrite");
        Object object = "source";
        f0.p(byArray, (String)object);
        int n12 = byArray.length;
        long l10 = n12;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        n11 += n10;
        while (n10 < n11) {
            n12 = 1;
            object = m10.V0(n12);
            int n13 = n11 - n10;
            int n14 = ((i0)object).c;
            n14 = 8192 - n14;
            n13 = Math.min(n13, n14);
            byte[] byArray2 = ((i0)object).a;
            int n15 = ((i0)object).c;
            int n16 = n10 + n13;
            n.W0(byArray, byArray2, n15, n10, n16);
            ((i0)object).c = n10 = ((i0)object).c + n13;
            n10 = n16;
        }
        long l13 = m10.S0() + l12;
        m10.O0(l13);
        return m10;
    }

    public static final void O(m object, m object2, long l10) {
        i0 i02;
        int n10;
        f0.p(object, "$this$commonWrite");
        f0.p(object2, "source");
        i0 i03 = null;
        if (object2 != object) {
            n10 = 1;
        } else {
            n10 = 0;
            i02 = null;
        }
        if (n10 != 0) {
            long l11;
            long l12;
            long l13 = ((m)object2).S0();
            long l14 = 0L;
            j.e(l13, l14, l10);
            while ((n10 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                i0 i04;
                i02 = ((m)object2).a;
                f0.m(i02);
                n10 = i02.c;
                i0 i05 = ((m)object2).a;
                f0.m(i05);
                int n11 = i05.b;
                l11 = n10 - n11;
                n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n10 < 0) {
                    i02 = ((m)object).a;
                    if (i02 != null) {
                        f0.m(i02);
                        i02 = i02.g;
                    } else {
                        n10 = 0;
                        i02 = null;
                    }
                    if (i02 != null && (n11 = (int)(i02.e ? 1 : 0)) != 0) {
                        n11 = i02.c;
                        l13 = (long)n11 + l10;
                        int n12 = i02.d;
                        if (n12 != 0) {
                            n12 = 0;
                            i04 = null;
                        } else {
                            n12 = i02.b;
                        }
                        l14 = n12;
                        l13 -= l14;
                        n12 = 8192;
                        l14 = n12;
                        n11 = (int)(l13 == l14 ? 0 : (l13 < l14 ? -1 : 1));
                        if (n11 <= 0) {
                            i03 = ((m)object2).a;
                            f0.m(i03);
                            n11 = (int)l10;
                            i03.g(i02, n11);
                            long l15 = ((m)object2).S0() - l10;
                            ((m)object2).O0(l15);
                            l15 = ((m)object).S0() + l10;
                            ((m)object).O0(l15);
                            return;
                        }
                    }
                    i02 = ((m)object2).a;
                    f0.m(i02);
                    n11 = (int)l10;
                    ((m)object2).a = i02 = i02.e(n11);
                }
                i02 = ((m)object2).a;
                f0.m(i02);
                n11 = i02.c;
                int n13 = i02.b;
                l13 = n11 -= n13;
                ((m)object2).a = i04 = i02.b();
                i04 = ((m)object).a;
                if (i04 == null) {
                    ((m)object).a = i02;
                    i02.g = i02;
                    i02.f = i02;
                } else {
                    f0.m(i04);
                    i04 = i04.g;
                    f0.m(i04);
                    i02 = i04.c(i02);
                    i02.a();
                }
                l14 = ((m)object2).S0() - l13;
                ((m)object2).O0(l14);
                l14 = ((m)object).S0() + l13;
                ((m)object).O0(l14);
                l10 -= l13;
            }
            return;
        }
        object2 = "source == this".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static /* synthetic */ m P(m m10, ByteString byteString, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = byteString.size();
        }
        f0.p(m10, "$this$commonWrite");
        f0.p(byteString, "byteString");
        byteString.write$okio(m10, n10, n11);
        return m10;
    }

    public static final long Q(m m10, m0 m02) {
        f0.p(m10, "$this$commonWriteAll");
        String string2 = "source";
        f0.p(m02, string2);
        long l10 = 0L;
        while (true) {
            long l11;
            int n10 = 8192;
            long l12 = n10;
            long l13 = (l12 = m02.read(m10, l12)) - (l11 = (long)-1);
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object == false) {
                return l10;
            }
            l10 += l12;
        }
    }

    public static final m R(m m10, int n10) {
        int n11;
        f0.p(m10, "$this$commonWriteByte");
        i0 i02 = m10.V0(1);
        byte[] byArray = i02.a;
        int n12 = i02.c;
        i02.c = n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)n10);
        long l10 = m10.S0() + 1L;
        m10.O0(l10);
        return m10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final m S(m var0, long var1_1) {
        block10: {
            block20: {
                block22: {
                    block21: {
                        block17: {
                            block19: {
                                block18: {
                                    block11: {
                                        block16: {
                                            block14: {
                                                block15: {
                                                    block12: {
                                                        block13: {
                                                            var3_2 = "$this$commonWriteDecimalLong";
                                                            f0.p(var0, var3_2);
                                                            var4_3 = 0L;
                                                            var6_4 /* !! */  = var1_1 == var4_3 ? 0 : (var1_1 < var4_3 ? -1 : 1);
                                                            if (var6_4 /* !! */  == false) {
                                                                return var0.b1(48);
                                                            }
                                                            var7_5 = 0;
                                                            var8_6 = 1;
                                                            if (var6_4 /* !! */  < 0) {
                                                                cfr_temp_0 = (var1_1 = -var1_1) - var4_3;
                                                                var6_4 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                if (var6_4 /* !! */  < 0) {
                                                                    return var0.p1("-9223372036854775808");
                                                                }
                                                                var7_5 = var8_6;
                                                            }
                                                            var9_7 = 100000000L;
                                                            var6_4 /* !! */  = var1_1 == var9_7 ? 0 : (var1_1 < var9_7 ? -1 : 1);
                                                            var11_8 = 10;
                                                            var12_9 = 1.4E-44f;
                                                            if (var6_4 /* !! */  >= 0) break block11;
                                                            var13_10 = 10000L;
                                                            cfr_temp_1 = var1_1 - var13_10;
                                                            var6_4 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                                                            if (var6_4 /* !! */  >= 0) break block12;
                                                            var13_10 = 100;
                                                            cfr_temp_2 = var1_1 - var13_10;
                                                            var6_4 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                                            if (var6_4 /* !! */  >= 0) break block13;
                                                            var13_10 = 10;
                                                            cfr_temp_3 = var1_1 - var13_10;
                                                            var6_4 /* !! */  = (long)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                                                            if (var6_4 /* !! */  >= 0) {
                                                                var8_6 = 2;
                                                            }
                                                            break block10;
                                                        }
                                                        var13_10 = 1000L;
                                                        cfr_temp_4 = var1_1 - var13_10;
                                                        var6_4 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
                                                        if (var6_4 /* !! */  < 0) {
                                                            var6_4 /* !! */  = 3;
                                                            var15_11 = 4.2E-45f;
                                                        } else {
                                                            var6_4 /* !! */  = 4;
                                                            var15_11 = 5.6E-45f;
                                                        }
lbl44:
                                                        // 10 sources

                                                        while (true) {
                                                            var8_6 = (int)var6_4 /* !! */ ;
                                                            break block10;
                                                            break;
                                                        }
                                                    }
                                                    var13_10 = 1000000L;
                                                    cfr_temp_5 = var1_1 - var13_10;
                                                    var6_4 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
                                                    if (var6_4 /* !! */  >= 0) break block14;
                                                    var13_10 = 100000L;
                                                    cfr_temp_6 = var1_1 - var13_10;
                                                    var6_4 /* !! */  = (long)(cfr_temp_6 == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1));
                                                    if (var6_4 /* !! */  >= 0) break block15;
                                                    var6_4 /* !! */  = 5;
                                                    var15_11 = 7.0E-45f;
                                                    ** GOTO lbl44
                                                }
                                                var6_4 /* !! */  = 6;
                                                var15_11 = 8.4E-45f;
                                                ** GOTO lbl44
                                            }
                                            var13_10 = 10000000L;
                                            cfr_temp_7 = var1_1 - var13_10;
                                            var6_4 /* !! */  = (long)(cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1));
                                            if (var6_4 /* !! */  >= 0) break block16;
                                            var6_4 /* !! */  = 7;
                                            var15_11 = 9.8E-45f;
                                            ** GOTO lbl44
                                        }
                                        var6_4 /* !! */  = 8;
                                        var15_11 = 1.1E-44f;
                                        ** GOTO lbl44
                                    }
                                    var13_10 = 1000000000000L;
                                    cfr_temp_8 = var1_1 - var13_10;
                                    var6_4 /* !! */  = (long)(cfr_temp_8 == 0L ? 0 : (cfr_temp_8 < 0L ? -1 : 1));
                                    if (var6_4 /* !! */  >= 0) break block17;
                                    var13_10 = 10000000000L;
                                    cfr_temp_9 = var1_1 - var13_10;
                                    var6_4 /* !! */  = (long)(cfr_temp_9 == 0L ? 0 : (cfr_temp_9 < 0L ? -1 : 1));
                                    if (var6_4 /* !! */  >= 0) break block18;
                                    var13_10 = 1000000000L;
                                    cfr_temp_10 = var1_1 - var13_10;
                                    var6_4 /* !! */  = (long)(cfr_temp_10 == 0L ? 0 : (cfr_temp_10 < 0L ? -1 : 1));
                                    var8_6 = var6_4 /* !! */  < 0 ? 9 : var11_8;
                                    break block10;
                                }
                                var13_10 = 100000000000L;
                                cfr_temp_11 = var1_1 - var13_10;
                                var6_4 /* !! */  = (long)(cfr_temp_11 == 0L ? 0 : (cfr_temp_11 < 0L ? -1 : 1));
                                if (var6_4 /* !! */  >= 0) break block19;
                                var6_4 /* !! */  = 11;
                                var15_11 = 1.5E-44f;
                                ** GOTO lbl44
                            }
                            var6_4 /* !! */  = 12;
                            var15_11 = 1.7E-44f;
                            ** GOTO lbl44
                        }
                        var13_10 = 1000000000000000L;
                        cfr_temp_12 = var1_1 - var13_10;
                        var6_4 /* !! */  = (long)(cfr_temp_12 == 0L ? 0 : (cfr_temp_12 < 0L ? -1 : 1));
                        if (var6_4 /* !! */  >= 0) break block20;
                        var13_10 = 10000000000000L;
                        cfr_temp_13 = var1_1 - var13_10;
                        var6_4 /* !! */  = (long)(cfr_temp_13 == 0L ? 0 : (cfr_temp_13 < 0L ? -1 : 1));
                        if (var6_4 /* !! */  >= 0) break block21;
                        var8_6 = 13;
                        break block10;
                    }
                    var13_10 = 100000000000000L;
                    cfr_temp_14 = var1_1 - var13_10;
                    var6_4 /* !! */  = (long)(cfr_temp_14 == 0L ? 0 : (cfr_temp_14 < 0L ? -1 : 1));
                    if (var6_4 /* !! */  >= 0) break block22;
                    var6_4 /* !! */  = 14;
                    var15_11 = 2.0E-44f;
                    ** GOTO lbl44
                }
                var6_4 /* !! */  = 15;
                var15_11 = 2.1E-44f;
                ** while (true)
            }
            var13_10 = 100000000000000000L;
            cfr_temp_15 = var1_1 - var13_10;
            var6_4 /* !! */  = (long)(cfr_temp_15 == 0L ? 0 : (cfr_temp_15 < 0L ? -1 : 1));
            var8_6 = var6_4 /* !! */  < 0 ? ((var6_4 /* !! */  = (cfr_temp_16 = var1_1 - (var13_10 = 10000000000000000L)) == 0L ? 0 : (cfr_temp_16 < 0L ? -1 : 1)) < 0 ? 16 : 17) : ((var6_4 /* !! */  = (cfr_temp_17 = var1_1 - (var13_10 = 1000000000000000000L)) == 0L ? 0 : (cfr_temp_17 < 0L ? -1 : 1)) < 0 ? 18 : 19);
        }
        if (var7_5 != 0) {
            ++var8_6;
        }
        var16_12 = var0.V0(var8_6);
        var17_13 = var16_12.a;
        var18_14 = var16_12.c + var8_6;
        while ((var19_15 = var1_1 == var4_3 ? 0 : (var1_1 < var4_3 ? -1 : 1)) != false) {
            var20_16 = var11_8;
            var22_17 = var1_1 % var20_16;
            var24_18 = (int)var22_17;
            var25_19 = h.q0.a.Z();
            var17_13[var18_14 += -1] = var24_18 = var25_19[var24_18];
            var1_1 /= var20_16;
        }
        if (var7_5 != 0) {
            var17_13[var18_14 += -1] = var26_20 = (int)((byte)45);
        }
        var16_12.c = var26_20 = var16_12.c + var8_6;
        var1_1 = var0.S0();
        var4_3 = var8_6;
        var0.O0(var1_1 += var4_3);
        return var0;
    }

    public static final m T(m m10, long l10) {
        int n10;
        Object object = "$this$commonWriteHexadecimalUnsignedLong";
        f0.p(m10, (String)object);
        long l11 = 0L;
        Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object2 == false) {
            return m10.b1(48);
        }
        object2 = 1;
        long l12 = l10 >>> object2 | l10;
        int n11 = 2;
        long l13 = l12 >>> n11;
        int n12 = 4;
        long l14 = (l12 |= l13) >>> n12;
        int n13 = 8;
        long l15 = (l12 |= l14) >>> n13;
        int n14 = 16;
        long l16 = (l12 |= l15) >>> n14;
        int n15 = 32;
        long l17 = (l12 |= l16) >>> n15;
        l12 |= l17;
        l17 = l12 >>> object2 & 0x5555555555555555L;
        l12 -= l17;
        l17 = l12 >>> n11;
        long l18 = 0x3333333333333333L;
        l17 &= l18;
        l12 = ((l17 += (l12 &= l18)) >>> n12) + l17 & 0xF0F0F0F0F0F0F0FL;
        l17 = l12 >>> n13;
        l14 = (l12 += l17) >>> n14;
        l12 += l14;
        l14 = 63;
        l17 = l12 & l14;
        l12 = l12 >>> n15 & l14;
        l17 += l12;
        l12 = 3;
        l17 += l12;
        l12 = n12;
        int n16 = (int)(l17 /= l12);
        i0 i02 = m10.V0(n16);
        byte[] byArray = i02.a;
        n13 = i02.c;
        for (n14 = n13 + n16 - object2; n14 >= n13; n14 += -1) {
            object = h.q0.a.Z();
            l16 = (long)15 & l10;
            n15 = (int)l16;
            object2 = object[n15];
            byArray[n14] = (byte)object2;
            l10 >>>= n12;
        }
        i02.c = n10 = i02.c + n16;
        l10 = m10.S0();
        l11 = n16;
        m10.O0(l10 += l11);
        return m10;
    }

    public static final m U(m m10, int n10) {
        byte by2;
        f0.p(m10, "$this$commonWriteInt");
        i0 i02 = m10.V0(4);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 24 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = by2 = (byte)(n10 >>> 16 & 0xFF);
        n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 8 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0xFF));
        i02.c = n11;
        long l10 = m10.S0() + (long)4;
        m10.O0(l10);
        return m10;
    }

    public static final m V(m m10, long l10) {
        byte by2;
        byte by3;
        f0.p(m10, "$this$commonWriteLong");
        int n10 = 8;
        i0 i02 = m10.V0(n10);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        long l11 = l10 >>> 56;
        long l12 = 255L;
        byArray[n11] = by3 = (byte)(l11 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 48 & l12);
        n12 = n11 + 1;
        byArray[n11] = by3 = (byte)(l10 >>> 40 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 32 & l12);
        n12 = n11 + 1;
        byArray[n11] = by3 = (byte)(l10 >>> 24 & l12);
        n11 = n12 + 1;
        byArray[n12] = by3 = (byte)(l10 >>> 16 & l12);
        n12 = n11 + 1;
        byArray[n11] = n10 = (int)((byte)(l10 >>> n10 & l12));
        n10 = n12 + 1;
        byArray[n12] = by2 = (byte)(l10 & l12);
        i02.c = n10;
        l10 = m10.S0() + (long)8;
        m10.O0(l10);
        return m10;
    }

    public static final m W(m m10, int n10) {
        byte by2;
        f0.p(m10, "$this$commonWriteShort");
        i0 i02 = m10.V0(2);
        byte[] byArray = i02.a;
        int n11 = i02.c;
        int n12 = n11 + 1;
        byArray[n11] = by2 = (byte)(n10 >>> 8 & 0xFF);
        n11 = n12 + 1;
        byArray[n12] = n10 = (int)((byte)(n10 & 0xFF));
        i02.c = n11;
        long l10 = m10.S0() + (long)2;
        m10.O0(l10);
        return m10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final m X(m object, String object2, int n10, int n11) {
        f0.p(object, "$this$commonWriteUtf8");
        f0.p(object2, "string");
        int n12 = 1;
        int n13 = n10 >= 0 ? n12 : 0;
        if (n13 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("beginIndex < 0: ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        n13 = n11 >= n10 ? n12 : 0;
        if (n13 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex < beginIndex: ");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" < ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        n13 = ((String)object2).length();
        n13 = n11 <= n13 ? n12 : 0;
        if (n13 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex > string.length: ");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" > ");
            int n14 = ((String)object2).length();
            ((StringBuilder)object).append(n14);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        while (n10 < n11) {
            long l10;
            long l11;
            int n15;
            int n16;
            int n17;
            i0 i02;
            int n18;
            n13 = ((String)object2).charAt(n10);
            if (n13 < (n18 = 128)) {
                i02 = ((m)object).V0(n12);
                byte[] byArray = i02.a;
                n17 = i02.c - n10;
                n16 = 8192 - n17;
                n16 = Math.min(n11, n16);
                n15 = n10 + 1;
                byArray[n10 += n17] = n13 = (int)((byte)n13);
            } else {
                int n19 = 2048;
                if (n13 < n19) {
                    n19 = 2;
                    i0 i03 = ((m)object).V0(n19);
                    byte[] byArray = i03.a;
                    n16 = i03.c;
                    byArray[n16] = n15 = (int)((byte)(n13 >> 6 | 0xC0));
                    n15 = n16 + 1;
                    byArray[n15] = n13 = (int)((byte)(n13 & 0x3F | n18));
                    i03.c = n16 += n19;
                    l11 = ((m)object).S0();
                    l10 = 2;
                    ((m)object).O0(l11 += l10);
                } else {
                    int n20;
                    int n21;
                    byte[] byArray;
                    n19 = 55296;
                    int n22 = 63;
                    if (n13 >= n19 && n13 <= (n19 = 57343)) {
                        n17 = n10 + 1;
                        if (n17 < n11) {
                            n16 = ((String)object2).charAt(n17);
                        } else {
                            n16 = 0;
                            byArray = null;
                        }
                        n15 = 56319;
                        if (n13 <= n15 && (n15 = 56320) <= n16 && n19 >= n16) {
                            n13 = (n13 & 0x3FF) << 10;
                            n17 = n16 & 0x3FF;
                            n13 = (n13 | n17) + 65536;
                            n19 = 4;
                            i0 i04 = ((m)object).V0(n19);
                            byArray = i04.a;
                            n15 = i04.c;
                            byArray[n15] = n21 = (int)((byte)(n13 >> 18 | 0xF0));
                            n21 = n15 + 1;
                            byArray[n21] = n20 = (int)((byte)(n13 >> 12 & n22 | n18));
                            n21 = n15 + 2;
                            byArray[n21] = n20 = (int)((byte)(n13 >> 6 & n22 | n18));
                            n21 = n15 + 3;
                            byArray[n21] = n13 = (int)((byte)(n13 & n22 | n18));
                            i04.c = n15 += n19;
                            l11 = ((m)object).S0();
                            l10 = 4;
                            ((m)object).O0(l11 += l10);
                            n10 += 2;
                            continue;
                        }
                        ((m)object).b1(n22);
                        n10 = n17;
                        continue;
                    }
                    n19 = 3;
                    i0 i05 = ((m)object).V0(n19);
                    byArray = i05.a;
                    n15 = i05.c;
                    byArray[n15] = n21 = (int)(n13 >> 12 | 0xE0);
                    n21 = n15 + 1;
                    n20 = n13 >> 6;
                    byArray[n21] = n22 = (int)((byte)(n22 & n20 | n18));
                    n22 = n15 + 2;
                    byArray[n22] = n13 = (int)((byte)(n13 & 0x3F | n18));
                    i05.c = n15 += n19;
                    l11 = ((m)object).S0();
                    l10 = 3;
                    ((m)object).O0(l11 += l10);
                }
                ++n10;
                continue;
            }
            while (n15 < n16 && (n10 = (int)((String)object2).charAt(n15)) < n18) {
                n13 = n15 + 1;
                byArray[n15 += n17] = n10 = (int)((byte)n10);
                n15 = n13;
            }
            n17 += n15;
            n10 = i02.c;
            n17 -= n10;
            i02.c = n10 += n17;
            l11 = ((m)object).S0();
            l10 = n17;
            ((m)object).O0(l11 += l10);
            n10 = n15;
        }
        return object;
    }

    public static final m Y(m object, int n10) {
        CharSequence charSequence;
        block7: {
            block3: {
                byte by2;
                int n11;
                int n12;
                int n13;
                int n14;
                block6: {
                    byte by3;
                    int n15;
                    block5: {
                        block4: {
                            int n16;
                            block2: {
                                charSequence = "$this$commonWriteUtf8CodePoint";
                                f0.p(object, (String)charSequence);
                                n14 = 128;
                                if (n10 >= n14) break block2;
                                ((m)object).b1(n10);
                                break block3;
                            }
                            n13 = 2048;
                            n12 = 63;
                            if (n10 >= n13) break block4;
                            n13 = 2;
                            i0 i02 = ((m)object).V0(n13);
                            byte[] byArray = i02.a;
                            int n17 = i02.c;
                            byArray[n17] = n16 = (int)(n10 >> 6 | 0xC0);
                            n16 = n17 + 1;
                            byArray[n16] = n10 = (int)((byte)(n10 & n12 | n14));
                            i02.c = n17 += n13;
                            long l10 = ((m)object).S0();
                            long l11 = 2;
                            ((m)object).O0(l10 += l11);
                            break block3;
                        }
                        n13 = 57343;
                        int n18 = 55296;
                        if (n18 > n10 || n13 < n10) break block5;
                        ((m)object).b1(n12);
                        break block3;
                    }
                    n13 = 65536;
                    if (n10 >= n13) break block6;
                    n13 = 3;
                    i0 i03 = ((m)object).V0(n13);
                    byte[] byArray = i03.a;
                    int n19 = i03.c;
                    byArray[n19] = n15 = (int)(n10 >> 12 | 0xE0);
                    n15 = n19 + 1;
                    byArray[n15] = by3 = (byte)(n10 >> 6 & n12 | n14);
                    n15 = n19 + 2;
                    byArray[n15] = n10 = (int)((byte)(n10 & n12 | n14));
                    i03.c = n19 += n13;
                    long l12 = ((m)object).S0();
                    long l13 = 3;
                    ((m)object).O0(l12 += l13);
                    break block3;
                }
                n13 = 0x10FFFF;
                if (n10 > n13) break block7;
                n13 = 4;
                i0 i04 = ((m)object).V0(n13);
                byte[] byArray = i04.a;
                int n20 = i04.c;
                byArray[n20] = n11 = (int)(n10 >> 18 | 0xF0);
                n11 = n20 + 1;
                byArray[n11] = by2 = (byte)(n10 >> 12 & n12 | n14);
                n11 = n20 + 2;
                byArray[n11] = by2 = (byte)(n10 >> 6 & n12 | n14);
                n11 = n20 + 3;
                byArray[n11] = n10 = (int)((byte)(n10 & n12 | n14));
                i04.c = n20 += n13;
                long l14 = ((m)object).S0();
                long l15 = 4;
                ((m)object).O0(l14 += l15);
            }
            return object;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Unexpected code point: 0x");
        String string2 = j.n(n10);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static final byte[] Z() {
        return a;
    }

    public static final void a(m m10) {
        f0.p(m10, "$this$commonClear");
        long l10 = m10.S0();
        m10.skip(l10);
    }

    public static final boolean a0(i0 i02, int n10, byte[] byArray, int n11, int n12) {
        f0.p(i02, "segment");
        String string2 = "bytes";
        f0.p(byArray, string2);
        int n13 = i02.c;
        byte[] byArray2 = i02.a;
        while (n11 < n12) {
            byte by2;
            byte by3;
            if (n10 == n13) {
                i02 = i02.f;
                f0.m(i02);
                byte[] byArray3 = i02.a;
                n13 = i02.b;
                int n14 = i02.c;
                byArray2 = byArray3;
                n10 = n13;
                n13 = n14;
            }
            if ((by3 = byArray2[n10]) != (by2 = byArray[n11])) {
                return false;
            }
            ++n10;
            ++n11;
        }
        return true;
    }

    public static final long b(m object) {
        String string2 = "$this$commonCompleteSegmentByteCount";
        f0.p(object, string2);
        long l10 = ((m)object).S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return l11;
        }
        object = ((m)object).a;
        f0.m(object);
        object = ((i0)object).g;
        f0.m(object);
        int n10 = ((i0)object).c;
        int n11 = 8192;
        if (n10 < n11 && (n11 = (int)(((i0)object).e ? 1 : 0)) != 0) {
            int n12 = ((i0)object).b;
            l11 = n10 -= n12;
            l10 -= l11;
        }
        return l10;
    }

    public static final String b0(m m10, long l10) {
        String string2;
        byte by2;
        long l11;
        String string3 = "$this$readUtf8Line";
        f0.p(m10, string3);
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        long l14 = 1L;
        if (l13 > 0 && (l13 = (long)m10.z0(l11 = l10 - l14)) == (by2 = (byte)13)) {
            string2 = m10.P(l11);
            l12 = 2;
            m10.skip(l12);
        } else {
            string2 = m10.P(l10);
            m10.skip(l14);
        }
        return string2;
    }

    public static final m c(m m10) {
        i0 i02;
        f0.p(m10, "$this$commonCopy");
        m m11 = new m();
        long l10 = m10.S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return m11;
        }
        i0 i03 = m10.a;
        f0.m(i03);
        m11.a = i02 = i03.d();
        i02.g = i02;
        i02.f = i02;
        i0 i04 = i03.f;
        while (i04 != i03) {
            i0 i05 = i02.g;
            f0.m(i05);
            f0.m(i04);
            i0 i06 = i04.d();
            i05.c(i06);
            i04 = i04.f;
        }
        l10 = m10.S0();
        m11.O0(l10);
        return m11;
    }

    public static final Object c0(m object, long l10, p p10) {
        f0.p(object, "$this$seek");
        f0.p(p10, "lambda");
        i0 i02 = ((m)object).a;
        if (i02 != null) {
            long l11 = ((m)object).S0() - l10;
            long l12 = l11 - l10;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 < 0) {
                long l13;
                l11 = ((m)object).S0();
                while ((l13 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0) {
                    i02 = i02.g;
                    f0.m(i02);
                    l13 = i02.c;
                    int n10 = i02.b;
                    long l14 = l13 -= n10;
                    l11 -= l14;
                }
                object = l11;
                return p10.invoke(i02, object);
            }
            l11 = 0L;
            while (true) {
                int n11 = i02.c;
                int n12 = i02.b;
                long l15 = (long)(n11 - n12) + l11;
                long l16 = l15 - l10;
                if ((n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1))) > 0) {
                    object = l11;
                    return p10.invoke(i02, object);
                }
                i02 = i02.f;
                f0.m(i02);
                l11 = l15;
            }
        }
        Long l17 = -1;
        return p10.invoke(null, l17);
    }

    public static final m d(m m10, m m11, long l10, long l11) {
        int n10;
        int n11;
        f0.p(m10, "$this$commonCopyTo");
        String string2 = "out";
        f0.p(m11, string2);
        long l12 = m10.S0();
        long l13 = l10;
        long l14 = l11;
        j.e(l12, l10, l11);
        long l15 = 0L;
        long l16 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1);
        if (l16 == false) {
            return m10;
        }
        long l17 = m11.S0() + l11;
        m11.O0(l17);
        i0 i02 = m10.a;
        while (true) {
            f0.m(i02);
            n11 = i02.c;
            n10 = i02.b;
            l14 = n11 - n10;
            long l18 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            if (l18 < 0) break;
            l13 = n11 -= n10;
            l10 -= l13;
            i02 = i02.f;
        }
        while ((n11 = (int)(l11 == l15 ? 0 : (l11 < l15 ? -1 : 1))) > 0) {
            f0.m(i02);
            i0 i03 = i02.d();
            n10 = i03.b;
            int n12 = (int)l10;
            i03.b = n10 += n12;
            n12 = (int)l11;
            n10 += n12;
            n12 = i03.c;
            i03.c = n12 = Math.min(n10, n12);
            i0 i04 = m11.a;
            if (i04 == null) {
                i03.g = i03;
                i03.f = i03;
                m11.a = i03;
            } else {
                f0.m(i04);
                i04 = i04.g;
                f0.m(i04);
                i04.c(i03);
            }
            n12 = i03.c;
            int n13 = i03.b;
            l10 = n12 -= n13;
            l11 -= l10;
            i02 = i02.f;
            l10 = l15;
        }
        return m10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final int d0(m var0, c0 var1_1, boolean var2_2) {
        block17: {
            var3_3 = var0;
            f0.p(var0, "$this$selectPrefix");
            var4_4 = "options";
            var5_5 = var1_1;
            f0.p(var1_1, var4_4);
            var3_3 = var0.a;
            var6_6 = -2;
            var7_7 = -1;
            if (var3_3 == null) break block17;
            var8_8 /* !! */  = var3_3.a;
            var9_9 /* !! */  = var3_3.b;
            var10_10 = var3_3.c;
            var5_5 = var1_1.g();
            var11_11 = var3_3;
            var12_12 = var7_7;
            var13_13 /* !! */  = 0;
            var14_14 = null;
            block0: while (true) {
                block18: {
                    var15_15 /* !! */  = var13_13 /* !! */  + 1;
                    var13_13 /* !! */  = (int)var5_5[var13_13 /* !! */ ];
                    var16_16 /* !! */  = var15_15 /* !! */  + 1;
                    if ((var15_15 /* !! */  = (int)var5_5[var15_15 /* !! */ ]) != var7_7) {
                        var12_12 = var15_15 /* !! */ ;
                    }
                    if (var11_11 == null) ** GOTO lbl44
                    var15_15 /* !! */  = 0;
                    if (var13_13 /* !! */  >= 0) break block18;
                    var17_17 = var16_16 /* !! */  + (var13_13 /* !! */  *= -1);
                    while (true) {
                        block23: {
                            block22: {
                                block19: {
                                    block20: {
                                        block21: {
                                            var13_13 /* !! */  = var9_9 /* !! */  + 1;
                                            var9_9 /* !! */  = var8_8 /* !! */ [var9_9 /* !! */ ] & 255;
                                            var18_18 = var16_16 /* !! */  + 1;
                                            if (var9_9 /* !! */  != (var16_16 /* !! */  = (int)var5_5[var16_16 /* !! */ ])) {
                                                return var12_12;
                                            }
                                            var9_9 /* !! */  = var18_18 == var17_17 ? 1 : 0;
                                            if (var13_13 /* !! */  != var10_10) break block19;
                                            f0.m(var11_11);
                                            var8_8 /* !! */  = (byte[])var11_11.f;
                                            f0.m(var8_8 /* !! */ );
                                            var10_10 = var8_8 /* !! */ .b;
                                            var14_14 = var8_8 /* !! */ .a;
                                            var19_19 = var8_8 /* !! */ .c;
                                            if (var8_8 /* !! */  != var3_3) break block20;
                                            if (var9_9 /* !! */  != 0) break block21;
lbl44:
                                            // 2 sources

                                            if (var2_2) {
                                                return var6_6;
                                            }
                                            return var12_12;
                                        }
                                        var8_8 /* !! */  = (byte[])var14_14;
                                        var13_13 /* !! */  = 0;
                                        var14_14 = null;
                                        break block22;
                                    }
                                    var20_20 = var14_14;
                                    var14_14 = var8_8 /* !! */ ;
                                    var8_8 /* !! */  = (byte[])var20_20;
                                    break block22;
                                }
                                var20_20 = var11_11;
                                var19_19 = var10_10;
                                var10_10 = var13_13 /* !! */ ;
                                var14_14 = var11_11;
                            }
                            if (var9_9 /* !! */  == 0) break block23;
                            var9_9 /* !! */  = (int)var5_5[var18_18];
                            var17_17 = var10_10;
                            var10_10 = var19_19;
                            var11_11 = var14_14;
                            ** GOTO lbl97
                        }
                        var9_9 /* !! */  = var10_10;
                        var10_10 = var19_19;
                        var16_16 /* !! */  = var18_18;
                        var11_11 = var14_14;
                    }
                }
                var17_17 = var9_9 /* !! */  + 1;
                var9_9 /* !! */  = var8_8 /* !! */ [var9_9 /* !! */ ] & 255;
                var18_18 = var16_16 /* !! */  + var13_13 /* !! */ ;
                while (true) {
                    block24: {
                        if (var16_16 /* !! */  == var18_18) {
                            return var12_12;
                        }
                        var21_21 = var5_5[var16_16 /* !! */ ];
                        if (var9_9 /* !! */  != var21_21) break block24;
                        var9_9 /* !! */  = (int)var5_5[var16_16 /* !! */  += var13_13 /* !! */ ];
                        if (var17_17 == var10_10) {
                            var11_11 = var11_11.f;
                            f0.m(var11_11);
                            var22_22 = var11_11.b;
                            var23_23 = var11_11.a;
                            var13_13 /* !! */  = var11_11.c;
                            var17_17 = var22_22;
                            var8_8 /* !! */  = var23_23;
                            var10_10 = var13_13 /* !! */ ;
                            if (var11_11 == var3_3) {
                                var19_19 = 0;
                                var11_11 = null;
                            }
                        }
lbl97:
                        // 6 sources

                        if (var9_9 /* !! */  >= 0) {
                            return var9_9 /* !! */ ;
                        }
                        var13_13 /* !! */  = -var9_9 /* !! */ ;
                        var9_9 /* !! */  = var17_17;
                        continue block0;
                    }
                    ++var16_16 /* !! */ ;
                }
                break;
            }
        }
        if (!var2_2) {
            var6_6 = var7_7;
        }
        return var6_6;
    }

    public static final boolean e(m m10, Object object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = object;
        String string2 = "$this$commonEquals";
        f0.p(m10, string2);
        boolean bl2 = true;
        if (m10 == object) {
            return bl2;
        }
        Object object3 = object instanceof m;
        if (!object3) {
            return false;
        }
        long l14 = m10.S0();
        long l15 = l14 - (l13 = ((m)(object2 = (m)object)).S0());
        object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object3) {
            return false;
        }
        l14 = m10.S0();
        long l16 = l14 - (l13 = 0L);
        object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (!object3) {
            return bl2;
        }
        i0 i02 = m10.a;
        f0.m(i02);
        object2 = ((m)object2).a;
        f0.m(object2);
        int n10 = i02.b;
        int n11 = ((i0)object2).b;
        long l17 = l13;
        while ((l12 = (l11 = l17 - (l10 = m10.S0())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            long l18;
            l12 = i02.c - n10;
            int n12 = ((i0)object2).c - n11;
            l12 = Math.min((int)l12, n12);
            l10 = l12;
            long l19 = l13;
            while ((l18 = l19 == l10 ? 0 : (l19 < l10 ? -1 : 1)) < 0) {
                byte[] byArray = i02.a;
                int n13 = n10 + 1;
                n10 = byArray[n10];
                byArray = ((i0)object2).a;
                int n14 = n11 + 1;
                if (n10 != (n11 = byArray[n11])) {
                    return false;
                }
                l14 = 1L;
                l19 += l14;
                n10 = n13;
                n11 = n14;
            }
            int n15 = i02.c;
            if (n10 == n15) {
                i02 = i02.f;
                f0.m(i02);
                n10 = i02.b;
            }
            if (n11 == (n15 = ((i0)object2).c)) {
                object2 = ((i0)object2).f;
                f0.m(object2);
                n11 = ((i0)object2).b;
            }
            l17 += l10;
        }
        return bl2;
    }

    public static /* synthetic */ int e0(m m10, c0 c02, boolean bl2, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            bl2 = false;
        }
        return h.q0.a.d0(m10, c02, bl2);
    }

    public static final byte f(m object, long l10) {
        f0.p(object, "$this$commonGet");
        long l11 = ((m)object).S0();
        long l12 = 1L;
        long l13 = l10;
        j.e(l11, l10, l12);
        i0 i02 = ((m)object).a;
        if (i02 != null) {
            l11 = ((m)object).S0() - l10;
            long l14 = l11 - l10;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 < 0) {
                long l15;
                l11 = ((m)object).S0();
                while ((l15 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0) {
                    i02 = i02.g;
                    f0.m(i02);
                    l15 = i02.c;
                    int n10 = i02.b;
                    l13 = l15 -= n10;
                    l11 -= l13;
                }
                f0.m(i02);
                object = i02.a;
                int n11 = (int)((long)i02.b + l10 - l11);
                return (byte)object[n11];
            }
            l11 = 0L;
            while (true) {
                int n12 = i02.c;
                int n13 = i02.b;
                l13 = (long)(n12 - n13) + l11;
                long l16 = l13 - l10;
                if ((n12 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1))) > 0) {
                    f0.m(i02);
                    object = i02.a;
                    int n14 = (int)((long)i02.b + l10 - l11);
                    return (byte)object[n14];
                }
                i02 = i02.f;
                f0.m(i02);
                l11 = l13;
            }
        }
        f0.m(null);
        byte[] byArray = null.a;
        int n15 = (int)((long)null.b + l10 - (long)-1);
        return byArray[n15];
    }

    public static final int g(m m10) {
        f0.p(m10, "$this$commonHashCode");
        i0 i02 = m10.a;
        if (i02 != null) {
            i0 i03;
            int n10 = 1;
            do {
                int n11 = i02.c;
                for (int i10 = i02.b; i10 < n11; ++i10) {
                    n10 *= 31;
                    byte[] byArray = i02.a;
                    byte by2 = byArray[i10];
                    n10 += by2;
                }
                i02 = i02.f;
                f0.m(i02);
            } while (i02 != (i03 = m10.a));
            return n10;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final long h(m var0, byte var1_1, long var2_2, long var4_3) {
        var6_4 = "$this$commonIndexOf";
        f0.p(var0, var6_4);
        var7_5 = 0L;
        var9_6 /* !! */  = var7_5 == var2_2 ? 0 : (var7_5 < var2_2 ? -1 : 1);
        if (var9_6 /* !! */  <= 0 && (var9_6 /* !! */  = var4_3 == var2_2 ? 0 : (var4_3 < var2_2 ? -1 : 1)) >= 0) {
            var9_6 /* !! */  = 1;
        } else {
            var9_6 /* !! */  = 0;
            var10_7 = null;
        }
        if (var9_6 /* !! */  != false) {
            var11_8 = var0.S0();
            cfr_temp_0 = var4_3 - var11_8;
            var9_6 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var9_6 /* !! */  > 0) {
                var4_3 = var0.S0();
            }
            var9_6 /* !! */  = var2_2 == var4_3 ? 0 : (var2_2 < var4_3 ? -1 : 1);
            var13_9 = -1;
            if (var9_6 /* !! */  == false) {
                return var13_9;
            }
            var10_7 = var0.a;
            if (var10_7 != null) {
                var15_10 = var0.S0() - var2_2;
                cfr_temp_1 = var15_10 - var2_2;
                var17_11 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var17_11 /* !! */  < 0) {
                    var7_5 = var0.S0();
                    while ((var18_12 = (int)(var7_5 == var2_2 ? 0 : (var7_5 < var2_2 ? -1 : 1))) > 0) {
                        var10_7 = var10_7.g;
                        f0.m(var10_7);
                        var18_12 = var10_7.c;
                        var17_11 /* !! */  = var10_7.b;
                        var15_10 = var18_12 -= var17_11 /* !! */ ;
                        var7_5 -= var15_10;
                    }
                    if (var10_7 != null) {
                        while ((var18_12 = (int)(var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1))) < 0) {
                            var0 = var10_7.a;
                            var15_10 = var10_7.c;
                            var19_13 = var10_7.b;
                            var20_15 = (long)var19_13 + var4_3 - var7_5;
                            var15_10 = Math.min(var15_10, var20_15);
                            var17_11 /* !! */  = (int)var15_10;
                            var22_17 = var10_7.b;
                            var23_19 = (long)var22_17 + var2_2 - var7_5;
                            for (var25_21 = (int)var23_19; var25_21 < var17_11 /* !! */ ; ++var25_21) {
                                var26_22 = var0[var25_21];
                                if (var26_22 != var1_1) continue;
                                while (true) {
                                    var18_12 = var10_7.b;
                                    return (long)(var25_21 - var18_12) + var7_5;
                                }
                            }
                            var18_12 = var10_7.c;
                            var25_21 = var10_7.b;
                            var2_2 = var18_12 -= var25_21;
                            var7_5 += var2_2;
                            var10_7 = var10_7.f;
                            f0.m(var10_7);
                            var2_2 = var7_5;
                        }
                    }
                    return var13_9;
                }
                while (true) {
                    var18_12 = var10_7.c;
                    var17_11 /* !! */  = var10_7.b;
                    var15_10 = (long)(var18_12 - var17_11 /* !! */ ) + var7_5;
                    cfr_temp_2 = var15_10 - var2_2;
                    if ((var18_12 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) > 0) {
                        if (var10_7 != null) {
                            while ((var18_12 = (int)(var7_5 == var4_3 ? 0 : (var7_5 < var4_3 ? -1 : 1))) < 0) {
                                var0 = var10_7.a;
                                var15_10 = var10_7.c;
                                var19_14 = var10_7.b;
                                var20_16 = (long)var19_14 + var4_3 - var7_5;
                                var15_10 = Math.min(var15_10, var20_16);
                                var17_11 /* !! */  = (int)var15_10;
                                var22_18 = var10_7.b;
                                var23_20 = (long)var22_18 + var2_2 - var7_5;
                                for (var25_21 = (int)var23_20; var25_21 < var17_11 /* !! */ ; ++var25_21) {
                                    if ((var26_23 = var0[var25_21]) == var1_1) ** continue;
                                }
                                var18_12 = var10_7.c;
                                var25_21 = var10_7.b;
                                var2_2 = var18_12 -= var25_21;
                                var7_5 += var2_2;
                                var10_7 = var10_7.f;
                                f0.m(var10_7);
                                var2_2 = var7_5;
                            }
                        }
                        return var13_9;
                    }
                    var10_7 = var10_7.f;
                    f0.m(var10_7);
                    var7_5 = var15_10;
                }
            }
            return var13_9;
        }
        var27_24 /* !! */  = new StringBuilder();
        var27_24 /* !! */ .append("size=");
        var7_5 = var0.S0();
        var27_24 /* !! */ .append(var7_5);
        var27_24 /* !! */ .append(" fromIndex=");
        var27_24 /* !! */ .append(var2_2);
        var27_24 /* !! */ .append(" toIndex=");
        var27_24 /* !! */ .append(var4_3);
        var0 = var27_24 /* !! */ .toString();
        var0 = var0.toString();
        var27_24 /* !! */  = new IllegalArgumentException((String)var0);
        throw var27_24 /* !! */ ;
    }

    public static final long i(m m10, ByteString byteString, long l10) {
        Object object = m10;
        long l11 = l10;
        f0.p(m10, "$this$commonIndexOf");
        Object object2 = "bytes";
        f0.p(byteString, (String)object2);
        int n10 = byteString.size();
        byte by2 = 0;
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 > 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            long l12 = 0L;
            long l13 = l11 - l12;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 >= 0) {
                n10 = n11;
            } else {
                n10 = 0;
                object2 = null;
            }
            if (n10 != 0) {
                object2 = ((m)object).a;
                if (object2 != null) {
                    long l14 = m10.S0() - l11;
                    Object object3 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
                    long l15 = 1L;
                    if (object3 < 0) {
                        long l16;
                        l12 = m10.S0();
                        while ((object3 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) > 0) {
                            object2 = ((i0)object2).g;
                            f0.m(object2);
                            object3 = ((i0)object2).c;
                            int n12 = ((i0)object2).b;
                            l16 = object3 -= n12;
                            l12 -= l16;
                        }
                        if (object2 != null) {
                            long l17;
                            byte[] byArray = byteString.internalArray$okio();
                            by2 = byArray[0];
                            int n13 = byteString.size();
                            l16 = m10.S0();
                            long l18 = n13;
                            l16 = l16 - l18 + l15;
                            while ((l17 = l12 == l16 ? 0 : (l12 < l16 ? -1 : 1)) < 0) {
                                int n14;
                                object = ((i0)object2).a;
                                int n15 = ((i0)object2).c;
                                l15 = (long)((i0)object2).b + l16 - l12;
                                l18 = Math.min((long)n15, l15);
                                n15 = (int)l18;
                                int n16 = ((i0)object2).b;
                                l15 = (long)n16 + l11 - l12;
                                for (n14 = (int)l15; n14 < n15; ++n14) {
                                    Object object4 = object[n14];
                                    if (object4 != by2) continue;
                                    object4 = n14 + 1;
                                    if ((object4 = (Object)h.q0.a.a0((i0)object2, (int)object4, byArray, n11, n13)) == false) continue;
                                    l17 = ((i0)object2).b;
                                    return (long)(n14 - l17) + l12;
                                }
                                l17 = ((i0)object2).c;
                                n14 = ((i0)object2).b;
                                long l19 = l17 -= n14;
                                object2 = ((i0)object2).f;
                                f0.m(object2);
                                l11 = l12 += l19;
                            }
                            return -1;
                        }
                        return -1;
                    }
                    while (true) {
                        float f11;
                        int n17;
                        long l20;
                        int n18 = ((i0)object2).c;
                        int n19 = ((i0)object2).b;
                        long l21 = (long)(n18 -= n19) + l12;
                        long l22 = l21 - l11;
                        object3 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                        if (object3 > 0) {
                            if (object2 != null) {
                                long l23;
                                byte[] byArray = byteString.internalArray$okio();
                                by2 = byArray[0];
                                int n20 = byteString.size();
                                long l24 = m10.S0();
                                l20 = n20;
                                l24 = l24 - l20 + l15;
                                while ((l23 = l12 == l24 ? 0 : (l12 < l24 ? -1 : 1)) < 0) {
                                    int n21;
                                    object = ((i0)object2).a;
                                    int n22 = ((i0)object2).c;
                                    int n23 = ((i0)object2).b;
                                    long l25 = (long)n23 + l24 - l12;
                                    long l26 = l12;
                                    long l27 = Math.min((long)n22, l25);
                                    n11 = (int)l27;
                                    n17 = ((i0)object2).b;
                                    l12 = (long)n17 + l11 - l26;
                                    for (n21 = (int)l12; n21 < n11; ++n21) {
                                        Object object5 = object[n21];
                                        if (object5 == by2) {
                                            object5 = n21 + 1;
                                            n17 = 1;
                                            f11 = Float.MIN_VALUE;
                                            if ((object5 = (Object)h.q0.a.a0((i0)object2, (int)object5, byArray, n17, n20)) == false) continue;
                                            l23 = ((i0)object2).b;
                                            return (long)(n21 - l23) + l26;
                                        }
                                        n17 = 1;
                                        f11 = Float.MIN_VALUE;
                                    }
                                    n17 = 1;
                                    f11 = Float.MIN_VALUE;
                                    l23 = ((i0)object2).c;
                                    n21 = ((i0)object2).b;
                                    long l28 = l23 -= n21;
                                    l28 = l26 + l28;
                                    object2 = ((i0)object2).f;
                                    f0.m(object2);
                                    n11 = n17;
                                    f10 = f11;
                                    l12 = l28;
                                    l11 = l28;
                                }
                                return -1;
                            }
                            return -1;
                        }
                        n17 = n11;
                        f11 = f10;
                        l20 = -1;
                        object2 = ((i0)object2).f;
                        f0.m(object2);
                        l12 = l21;
                    }
                }
                return -1;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("fromIndex < 0: ");
            ((StringBuilder)object).append(l11);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        String string2 = "bytes is empty".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final long j(m object, ByteString object2, long l10) {
        int n10;
        int n11;
        i0 i02;
        long l11;
        block24: {
            int n12;
            int n13;
            long l12;
            long l13;
            long l14;
            int n14;
            block25: {
                block23: {
                    long l15;
                    f0.p(object, "$this$commonIndexOfElement");
                    String string2 = "targetBytes";
                    f0.p(object2, string2);
                    l11 = 0L;
                    long l16 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    byte by2 = 0;
                    n14 = 1;
                    if (l16 >= 0) {
                        l16 = n14;
                    } else {
                        l16 = 0;
                        i02 = null;
                    }
                    if (l16 == false) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("fromIndex < 0: ");
                        ((StringBuilder)object).append(l10);
                        object = ((StringBuilder)object).toString();
                        object = object.toString();
                        object2 = new IllegalArgumentException((String)object);
                        throw object2;
                    }
                    i02 = ((m)object).a;
                    l14 = -1;
                    if (i02 == null) return l14;
                    l13 = ((m)object).S0() - l10;
                    l12 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                    n13 = 2;
                    if (l12 < 0) {
                        long l17;
                        l11 = ((m)object).S0();
                        while ((l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) > 0) {
                            i02 = i02.g;
                            f0.m(i02);
                            l12 = i02.c;
                            int n15 = i02.b;
                            long l18 = l12 -= n15;
                            l11 -= l18;
                        }
                        if (i02 == null) return l14;
                        l12 = ((ByteString)object2).size();
                        if (l12 == n13) {
                            long l19;
                            by2 = ((ByteString)object2).getByte(0);
                            byte by3 = ((ByteString)object2).getByte(n14);
                            while ((n14 = (int)((l19 = l11 - (l13 = ((m)object).S0())) == 0L ? 0 : (l19 < 0L ? -1 : 1))) < 0) {
                                byte[] byArray = i02.a;
                                l12 = i02.b;
                                l13 = (long)l12 + l10 - l11;
                                int n16 = i02.c;
                                for (n11 = (int)l13; n11 < n16; ++n11) {
                                    l12 = byArray[n11];
                                    if (l12 != by2 && l12 != by3) {
                                        continue;
                                    }
                                    break block23;
                                }
                                n11 = i02.c;
                                n16 = i02.b;
                                l10 = n11 -= n16;
                                l11 += l10;
                                i02 = i02.f;
                                f0.m(i02);
                                l10 = l11;
                            }
                            return l14;
                        }
                        object2 = ((ByteString)object2).internalArray$okio();
                        while ((n14 = (int)((l17 = l11 - (l13 = ((m)object).S0())) == 0L ? 0 : (l17 < 0L ? -1 : 1))) < 0) {
                            byte[] byArray = i02.a;
                            l12 = i02.b;
                            l13 = (long)l12 + l10 - l11;
                            int n17 = i02.c;
                            for (n11 = (int)l13; n11 < n17; ++n11) {
                                l12 = byArray[n11];
                                for (Object object3 : object2) {
                                    if (l12 != object3) {
                                        continue;
                                    }
                                    break block24;
                                }
                            }
                            n11 = i02.c;
                            n17 = i02.b;
                            l10 = n11 -= n17;
                            l11 += l10;
                            i02 = i02.f;
                            f0.m(i02);
                            l10 = l11;
                        }
                        return l14;
                    }
                    while (true) {
                        l12 = i02.c;
                        n12 = i02.b;
                        long l20 = (long)(l12 - n12) + l11;
                        long l21 = l20 - l10;
                        if ((l12 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1)) > 0) {
                            if (i02 == null) return l14;
                            l12 = ((ByteString)object2).size();
                            if (l12 == n13) break;
                            break block25;
                        }
                        i02 = i02.f;
                        f0.m(i02);
                        l11 = l20;
                    }
                    by2 = ((ByteString)object2).getByte(0);
                    byte by4 = ((ByteString)object2).getByte(n14);
                    while ((n14 = (int)((l15 = l11 - (l13 = ((m)object).S0())) == 0L ? 0 : (l15 < 0L ? -1 : 1))) < 0) {
                        byte[] byArray = i02.a;
                        l12 = i02.b;
                        l13 = (long)l12 + l10 - l11;
                        int n18 = i02.c;
                        for (n11 = (int)l13; n11 < n18; ++n11) {
                            l12 = byArray[n11];
                            if (l12 != by2 && l12 != by4) {
                                continue;
                            }
                            break block23;
                        }
                        n11 = i02.c;
                        n18 = i02.b;
                        l10 = n11 -= n18;
                        l11 += l10;
                        i02 = i02.f;
                        f0.m(i02);
                        l10 = l11;
                    }
                    return l14;
                }
                n10 = i02.b;
                return (long)(n11 - n10) + l11;
            }
            object2 = ((ByteString)object2).internalArray$okio();
            block9: while (true) {
                long l22;
                if ((n14 = (int)((l22 = l11 - (l13 = ((m)object).S0())) == 0L ? 0 : (l22 < 0L ? -1 : 1))) >= 0) return l14;
                byte[] byArray = i02.a;
                l12 = i02.b;
                l13 = (long)l12 + l10 - l11;
                n11 = (int)l13;
                int n19 = i02.c;
                while (true) {
                    if (n11 < n19) {
                        l12 = byArray[n11];
                        n13 = ((Object)object2).length;
                    } else {
                        n11 = i02.c;
                        n19 = i02.b;
                        l10 = n11 -= n19;
                        l11 += l10;
                        i02 = i02.f;
                        f0.m(i02);
                        l10 = l11;
                        continue block9;
                    }
                    for (n12 = 0; n12 < n13; ++n12) {
                        Object object4 = object2[n12];
                        if (l12 == object4) break block9;
                    }
                    ++n11;
                }
                break;
            }
        }
        n10 = i02.b;
        return (long)(n11 - n10) + l11;
    }

    public static final boolean k(m m10, long l10, ByteString byteString, int n10, int n11) {
        long l11;
        long l12;
        long l13;
        f0.p(m10, "$this$commonRangeEquals");
        String string2 = "bytes";
        f0.p(byteString, string2);
        long l14 = 0L;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (l15 >= 0 && n10 >= 0 && n11 >= 0 && (l15 = (l13 = (l12 = m10.S0() - l10) - (l11 = (long)n11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && (l15 = (long)(byteString.size() - n10)) >= n11) {
            string2 = null;
            for (l15 = (long)0; l15 < n11; ++l15) {
                l12 = (long)l15 + l10;
                byte by2 = m10.z0(l12);
                int n12 = n10 + l15;
                if (by2 == (n12 = (int)byteString.getByte(n12))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static final int l(m m10, byte[] byArray) {
        f0.p(m10, "$this$commonRead");
        f0.p(byArray, "sink");
        int n10 = byArray.length;
        return m10.read(byArray, 0, n10);
    }

    public static final int m(m m10, byte[] object, int n10, int n11) {
        f0.p(m10, "$this$commonRead");
        f0.p(object, "sink");
        int n12 = ((byte[])object).length;
        long l10 = n12;
        long l11 = n10;
        long l12 = n11;
        j.e(l10, l11, l12);
        i0 i02 = m10.a;
        if (i02 != null) {
            int n13;
            int n14 = i02.c;
            int n15 = i02.b;
            n11 = Math.min(n11, n14 -= n15);
            byte[] byArray = i02.a;
            n15 = i02.b;
            int n16 = n15 + n11;
            n.W0(byArray, object, n10, n15, n16);
            i02.b = n13 = i02.b + n11;
            long l13 = m10.S0();
            l10 = n11;
            m10.O0(l13 -= l10);
            n13 = i02.b;
            n10 = i02.c;
            if (n13 == n10) {
                object = i02.b();
                m10.a = object;
                j0.d(i02);
            }
            return n11;
        }
        return -1;
    }

    public static final long n(m object, m object2, long l10) {
        f0.p(object, "$this$commonRead");
        String string2 = "sink";
        f0.p(object2, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 >= 0 ? (long)1 : (long)0;
        if (l12 != false) {
            long l13 = ((m)object).S0();
            long l14 = l13 - l11;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 == false) {
                return -1;
            }
            l11 = ((m)object).S0();
            long l15 = l10 - l11;
            object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 > 0) {
                l10 = ((m)object).S0();
            }
            ((m)object2).t((m)object, l10);
            return l10;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static final long o(m m10, k0 k02) {
        f0.p(m10, "$this$commonReadAll");
        String string2 = "sink";
        f0.p(k02, string2);
        long l10 = m10.S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            k02.t(m10, l10);
        }
        return l10;
    }

    public static final byte p(m object) {
        Object object2 = "$this$commonReadByte";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            object2 = ((m)object).a;
            f0.m(object2);
            int by2 = ((i0)object2).b;
            int n10 = ((i0)object2).c;
            byte[] byArray = ((i0)object2).a;
            int n11 = by2 + 1;
            byte by3 = byArray[by2];
            long l13 = ((m)object).S0();
            long l14 = 1L;
            ((m)object).O0(l13 -= l14);
            if (n11 == n10) {
                i0 i02;
                ((m)object).a = i02 = ((i0)object2).b();
                j0.d((i0)object2);
            } else {
                ((i0)object2).b = n11;
            }
            return by3;
        }
        object = new EOFException();
        throw object;
    }

    public static final byte[] q(m m10) {
        f0.p(m10, "$this$commonReadByteArray");
        long l10 = m10.S0();
        return m10.z(l10);
    }

    public static final byte[] r(m object, long l10) {
        long l11;
        String string2 = "$this$commonReadByteArray";
        f0.p(object, string2);
        long l12 = 0L;
        Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object2 >= 0 && (object2 = (l11 = l10 - (l12 = (long)(-1 >>> 1))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            object2 = 1;
        } else {
            object2 = 0;
            string2 = null;
        }
        if (object2 != false) {
            l12 = ((m)object).S0();
            long l13 = l12 - l10;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0) {
                byte[] byArray = new byte[(int)l10];
                ((m)object).readFully(byArray);
                return byArray;
            }
            object = new EOFException();
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final ByteString s(m m10) {
        f0.p(m10, "$this$commonReadByteString");
        long l10 = m10.S0();
        return m10.Q(l10);
    }

    public static final ByteString t(m object, long l10) {
        long l11;
        Object object2 = "$this$commonReadByteString";
        f0.p(object, (String)object2);
        long l12 = 0L;
        Object object3 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object3 >= 0 && (object3 = (l11 = l10 - (l12 = (long)(-1 >>> 1))) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            object3 = 1;
        } else {
            object3 = 0;
            object2 = null;
        }
        if (object3 != false) {
            l12 = ((m)object).S0();
            long l13 = l12 - l10;
            object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 >= 0) {
                l12 = 4096;
                long l14 = l10 - l12;
                object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 >= 0) {
                    object3 = (int)l10;
                    object2 = ((m)object).U0((int)object3);
                    ((m)object).skip(l10);
                    return object2;
                }
                object = ((m)object).z(l10);
                object2 = new ByteString((byte[])object);
                return object2;
            }
            object = new EOFException();
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final long u(m var0) {
        block9: {
            var1_1 = var0;
            var2_2 = "$this$commonReadDecimalLong";
            f0.p(var0, (String)var2_2);
            var3_3 = var0.S0();
            var5_4 = 0L;
            var7_5 = var3_3 == var5_4 ? 0 : (var3_3 < var5_4 ? -1 : 1);
            if (var7_5 == false) break block9;
            var3_3 = -7;
            var8_6 = 0;
            var9_7 = 0;
            var10_8 = 0;
            var11_9 = 0.0f;
            do {
                var12_10 = var1_1.a;
                f0.m(var12_10);
                var13_11 = var12_10.a;
                var14_12 = var12_10.b;
                var15_13 = var12_10.c;
                while (true) {
                    var16_14 /* !! */  = 1;
                    var17_15 = 1.4E-45f;
                    if (var14_12 >= var15_13) ** GOTO lbl84
                    var18_16 = var13_11[var14_12];
                    var19_17 = 48;
                    if (var18_16 < var19_17) ** GOTO lbl56
                    var20_18 = 8.0E-44f;
                    var21_19 = (byte)57;
                    if (var18_16 > var21_19) ** GOTO lbl56
                    var19_17 -= var18_16;
                    var22_20 = -922337203685477580L;
                    cfr_temp_0 = var5_4 - var22_20;
                    var16_14 /* !! */  = (byte)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var16_14 /* !! */  < 0) ** GOTO lbl-1000
                    var21_19 = var10_8;
                    var20_18 = var11_9;
                    var24_21 = var12_10;
                    if (var16_14 /* !! */  != 0 || (var10_8 = (byte)((cfr_temp_1 = (var25_22 = (long)var19_17) - var3_3) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) >= 0) {
                        var5_4 *= (long)10;
                        var25_22 = var19_17;
                        var5_4 += var25_22;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var1_1 = new m();
                        var1_1 = var1_1.c1(var5_4).b1(var18_16);
                        if (var9_7 == 0) {
                            var1_1.readByte();
                        }
                        var27_24 = new StringBuilder();
                        var27_24.append("Number too large: ");
                        var1_1 = var1_1.f0();
                        var27_24.append((String)var1_1);
                        var1_1 = var27_24.toString();
                        var2_2 = new NumberFormatException((String)var1_1);
                        throw var2_2;
lbl56:
                        // 2 sources

                        var21_19 = var10_8;
                        var20_18 = var11_9;
                        var24_21 = var12_10;
                        var11_9 = 6.3E-44f;
                        var10_8 = (byte)45;
                        if (var18_16 != var10_8 || var8_6 != 0) break;
                        var28_23 = 1L;
                        var3_3 -= var28_23;
                        var9_7 = var16_14 /* !! */ ;
                    }
                    ++var14_12;
                    ++var8_6;
                    var10_8 = var21_19;
                    var11_9 = var20_18;
                    var12_10 = var24_21;
                }
                if (var8_6 != 0) {
                    var10_8 = var16_14 /* !! */ ;
                    var11_9 = var17_15;
                } else {
                    var2_2 = new StringBuilder();
                    var2_2.append("Expected leading [0-9] or '-' character but was 0x");
                    var27_25 = j.m(var18_16);
                    var2_2.append(var27_25);
                    var2_2 = var2_2.toString();
                    var1_1 = new NumberFormatException((String)var2_2);
                    throw var1_1;
lbl84:
                    // 1 sources

                    var21_19 = var10_8;
                    var20_18 = var11_9;
                    var24_21 = var12_10;
                }
                if (var14_12 == var15_13) {
                    var1_1.a = var12_10 = var24_21.b();
                    j0.d(var24_21);
                    continue;
                }
                var12_10 = var24_21;
                var24_21.b = var14_12;
            } while (var10_8 == 0 && (var12_10 = var1_1.a) != null);
            var3_3 = var0.S0();
            var25_22 = var8_6;
            var1_1.O0(var3_3 -= var25_22);
            if (var9_7 == 0) {
                var5_4 = -var5_4;
            }
            return var5_4;
        }
        var1_1 = new EOFException();
        throw var1_1;
    }

    public static final void v(m object, m m10, long l10) {
        f0.p(object, "$this$commonReadFully");
        String string2 = "sink";
        f0.p(m10, string2);
        long l11 = ((m)object).S0();
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l12 >= 0) {
            m10.t((m)object, l10);
            return;
        }
        l10 = ((m)object).S0();
        m10.t((m)object, l10);
        object = new EOFException();
        throw object;
    }

    public static final void w(m object, byte[] byArray) {
        int n10;
        f0.p(object, "$this$commonReadFully");
        f0.p(byArray, "sink");
        for (int i10 = 0; i10 < (n10 = byArray.length); i10 += n10) {
            int n11;
            n10 = byArray.length - i10;
            if ((n10 = ((m)object).read(byArray, i10, n10)) != (n11 = -1)) {
                continue;
            }
            object = new EOFException();
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final long x(m object) {
        i0 i02;
        Object object2 = "$this$commonReadHexadecimalUnsignedLong";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object = new EOFException();
            throw object;
        }
        l12 = 0;
        object2 = null;
        boolean bl2 = false;
        CharSequence charSequence = null;
        long l13 = l11;
        do {
            int n10;
            long l14;
            i02 = ((m)object).a;
            f0.m(i02);
            byte[] byArray = i02.a;
            int n11 = i02.c;
            for (n10 = i02.b; n10 < n11; l13 |= l14, ++n10, ++l12) {
                byte by2;
                block11: {
                    byte by3;
                    int n12;
                    block10: {
                        block9: {
                            by2 = byArray[n10];
                            n12 = 48;
                            if (by2 < n12 || by2 > (by3 = (byte)57)) break block9;
                            n12 = by2 - n12;
                            break block10;
                        }
                        n12 = (byte)97;
                        if ((by2 < n12 || by2 > (by3 = (byte)102)) && (by2 < (n12 = (byte)65) || by2 > (by3 = (byte)70))) break block11;
                        n12 = by2 - n12 + 10;
                    }
                    long l15 = 0xF000000000000000L & l13;
                    by3 = (byte)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1));
                    if (by3 != 0) {
                        object = new m();
                        object = ((m)object).d1(l13).b1(by2);
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Number too large: ");
                        object = ((m)object).f0();
                        ((StringBuilder)charSequence).append((String)object);
                        object = ((StringBuilder)charSequence).toString();
                        object2 = new NumberFormatException((String)object);
                        throw object2;
                    }
                    by2 = 4;
                    l13 <<= by2;
                    l14 = n12;
                    continue;
                }
                if (l12 == false) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Expected leading [0-9a-fA-F] character but was 0x");
                    charSequence = j.m(by2);
                    ((StringBuilder)object2).append((String)charSequence);
                    object2 = ((StringBuilder)object2).toString();
                    object = new NumberFormatException((String)object2);
                    throw object;
                }
                bl2 = true;
                break;
            }
            if (n10 == n11) {
                i0 i03;
                ((m)object).a = i03 = i02.b();
                j0.d(i02);
                continue;
            }
            i02.b = n10;
        } while (!bl2 && (i02 = ((m)object).a) != null);
        long l16 = ((m)object).S0();
        long l17 = l12;
        ((m)object).O0(l16 -= l17);
        return l13;
    }

    public static final int y(m object) {
        Object object2 = "$this$commonReadInt";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        long l11 = 4;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            object2 = ((m)object).a;
            f0.m(object2);
            int n10 = ((i0)object2).b;
            int n11 = ((i0)object2).c;
            long l13 = n11 - n10;
            long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
            if (l14 < 0) {
                l12 = (((m)object).readByte() & 0xFF) << 24;
                n10 = (((m)object).readByte() & 0xFF) << 16;
                l12 = l12 | n10;
                n10 = (((m)object).readByte() & 0xFF) << 8;
                l12 = l12 | n10;
                return ((m)object).readByte() & 0xFF | l12;
            }
            byte[] byArray = ((i0)object2).a;
            int n12 = n10 + 1;
            n10 = (byArray[n10] & 0xFF) << 24;
            int n13 = n12 + 1;
            n12 = (byArray[n12] & 0xFF) << 16;
            n10 |= n12;
            n12 = n13 + 1;
            n13 = (byArray[n13] & 0xFF) << 8;
            n10 |= n13;
            n13 = n12 + 1;
            l14 = byArray[n12] & 0xFF;
            n10 |= l14;
            l13 = ((m)object).S0() - l11;
            ((m)object).O0(l13);
            if (n13 == n11) {
                i0 i02;
                ((m)object).a = i02 = ((i0)object2).b();
                j0.d((i0)object2);
            } else {
                ((i0)object2).b = n13;
            }
            return n10;
        }
        object = new EOFException();
        throw object;
    }

    public static final long z(m object) {
        Object object2 = "$this$commonReadLong";
        f0.p(object, (String)object2);
        long l10 = ((m)object).S0();
        long l11 = 8;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            object2 = ((m)object).a;
            f0.m(object2);
            int n10 = ((i0)object2).b;
            int n11 = ((i0)object2).c;
            long l13 = n11 - n10;
            long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
            int n12 = 32;
            if (l14 < 0) {
                l10 = ((m)object).readInt();
                l11 = 0xFFFFFFFFL;
                l10 = (l10 & l11) << n12;
                long l15 = ((m)object).readInt();
                return l10 | (l11 &= l15);
            }
            byte[] byArray = ((i0)object2).a;
            int n13 = n10 + 1;
            long l16 = byArray[n10];
            long l17 = 255L;
            l16 = (l16 & l17) << 56;
            n10 = n13 + 1;
            long l18 = (long)byArray[n13] & l17;
            n13 = 48;
            long l19 = l16 | (l18 <<= n13);
            int n14 = n10 + 1;
            l18 = ((long)byArray[n10] & l17) << 40;
            l19 |= l18;
            n10 = n14 + 1;
            n14 = byArray[n14];
            l18 = ((long)n14 & l17) << n12;
            long l20 = l19 | l18;
            int n15 = n10 + 1;
            l18 = ((long)byArray[n10] & l17) << 24;
            l20 |= l18;
            n10 = n15 + 1;
            l16 = (long)byArray[n15] & l17;
            int n16 = 16;
            l20 |= (l16 <<= n16);
            n15 = n10 + 1;
            l18 = ((long)byArray[n10] & l17) << 8;
            n10 = n15 + 1;
            l14 = byArray[n15];
            l16 = (long)l14 & l17;
            l13 = (l20 |= l18) | l16;
            l19 = ((m)object).S0() - l11;
            ((m)object).O0(l19);
            if (n10 == n11) {
                i0 i02;
                ((m)object).a = i02 = ((i0)object2).b();
                j0.d((i0)object2);
            } else {
                ((i0)object2).b = n10;
            }
            return l13;
        }
        object = new EOFException();
        throw object;
    }
}

