/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q2.b;
import h.c0;
import h.e0;
import h.h0$a;
import h.j;
import h.k0;
import h.m;
import h.m0;
import h.o;
import h.o0;
import h.q0.a;
import h.z;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

public final class h0
implements o {
    public final m a;
    public boolean b;
    public final m0 c;

    public h0(m0 m02) {
        f0.p(m02, "source");
        this.c = m02;
        this.a = m02;
    }

    public static /* synthetic */ void a() {
    }

    public short G() {
        this.L(2);
        return this.a.G();
    }

    public long I() {
        this.L(8);
        return this.a.I();
    }

    public long K(ByteString serializable, long l10) {
        block3: {
            Object object = "targetBytes";
            f0.p(serializable, (String)object);
            boolean bl2 = this.b ^ true;
            if (!bl2) break block3;
            while (true) {
                long l11;
                block5: {
                    block4: {
                        long l12;
                        long l13;
                        Object object2;
                        if ((object2 = (l13 = (l11 = ((m)(object = this.a)).K((ByteString)serializable, l10)) - (l12 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) break block4;
                        object = this.a;
                        l11 = ((m)object).S0();
                        m0 m02 = this.c;
                        m m10 = this.a;
                        int n10 = 8192;
                        long l14 = n10;
                        long l15 = m02.read(m10, l14);
                        long l16 = l15 - l12;
                        object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object2 != false) break block5;
                        l11 = l12;
                    }
                    return l11;
                }
                l10 = Math.max(l10, l11);
            }
        }
        String string2 = "closed".toString();
        serializable = new IllegalStateException(string2);
        throw serializable;
    }

    public void L(long l10) {
        boolean bl2 = this.request(l10);
        if (bl2) {
            return;
        }
        EOFException eOFException = new EOFException();
        throw eOFException;
    }

    public long N(byte by2) {
        return this.l(by2, 0L, Long.MAX_VALUE);
    }

    public String P(long l10) {
        this.L(l10);
        return this.a.P(l10);
    }

    public ByteString Q(long l10) {
        this.L(l10);
        return this.a.Q(l10);
    }

    public byte[] T() {
        m m10 = this.a;
        m0 m02 = this.c;
        m10.v(m02);
        return this.a.T();
    }

    public boolean V() {
        boolean bl2 = this.b;
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            long l10;
            int n10;
            long l11;
            m m10;
            long l12;
            long l13;
            m0 m02 = this.a;
            bl2 = ((m)m02).V();
            if (!bl2 || (bl2 = (l13 = (l12 = (m02 = this.c).read(m10 = this.a, l11 = (long)(n10 = 8192))) - (l10 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
                bl3 = false;
                Object var12_10 = null;
            }
            return bl3;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public long W() {
        long l10;
        byte by2;
        long l11;
        long l12 = 1L;
        this.L(l12);
        long l13 = l11 = 0L;
        while ((by2 = this.request(l10 = l13 + l12)) != 0) {
            byte by3;
            long l14;
            byte by4;
            m m10 = this.a;
            by2 = m10.z0(l13);
            if (by2 >= (by4 = (byte)48) && by2 <= (by4 = (byte)57) || (l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) == false && by2 == (by3 = (byte)45)) {
                l13 = l10;
                continue;
            }
            if (l14 != false) break;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Expected leading [0-9] or '-' character but was 0x");
            int n10 = f.q2.b.a(f.q2.b.a(16));
            String string2 = Integer.toString(by2, n10);
            f0.o(string2, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            NumberFormatException numberFormatException = new NumberFormatException((String)charSequence);
            throw numberFormatException;
        }
        return this.a.W();
    }

    public String Y(Charset charset) {
        f0.p(charset, "charset");
        m m10 = this.a;
        m0 m02 = this.c;
        m10.v(m02);
        return this.a.Y(charset);
    }

    public int Z() {
        long l10 = 1L;
        this.L(l10);
        m m10 = this.a;
        long l11 = 0L;
        int n10 = m10.z0(l11);
        int n11 = n10 & 0xE0;
        int n12 = 192;
        if (n11 == n12) {
            l10 = 2;
            this.L(l10);
        } else {
            n11 = n10 & 0xF0;
            n12 = 224;
            if (n11 == n12) {
                l10 = 3;
                this.L(l10);
            } else {
                n11 = 240;
                if ((n10 &= 0xF8) == n11) {
                    l10 = 4;
                    this.L(l10);
                }
            }
        }
        return this.a.Z();
    }

    public m b() {
        return this.a;
    }

    public ByteString b0() {
        m m10 = this.a;
        m0 m02 = this.c;
        m10.v(m02);
        return this.a.b0();
    }

    public long c(ByteString serializable, long l10) {
        block3: {
            Object object = "bytes";
            f0.p(serializable, (String)object);
            boolean bl2 = this.b ^ true;
            if (!bl2) break block3;
            while (true) {
                long l11;
                block5: {
                    long l12;
                    block4: {
                        long l13;
                        Object object2;
                        if ((object2 = (l13 = (l12 = ((m)(object = this.a)).c((ByteString)serializable, l10)) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) break block4;
                        object = this.a;
                        l12 = ((m)object).S0();
                        m0 m02 = this.c;
                        m m10 = this.a;
                        int n10 = 8192;
                        long l14 = n10;
                        long l15 = m02.read(m10, l14);
                        long l16 = l15 - l11;
                        object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object2 != false) break block5;
                        l12 = l11;
                    }
                    return l12;
                }
                int n11 = ((ByteString)serializable).size();
                l11 = n11;
                l12 -= l11;
                l11 = 1L;
                l10 = Math.max(l10, l12 += l11);
            }
        }
        String string2 = "closed".toString();
        serializable = new IllegalStateException(string2);
        throw serializable;
    }

    public void close() {
        boolean bl2 = this.b;
        if (!bl2) {
            this.b = bl2 = true;
            this.c.close();
            m m10 = this.a;
            m10.B();
        }
    }

    public int e0() {
        this.L(4);
        return this.a.e0();
    }

    public String f0() {
        m m10 = this.a;
        m0 m02 = this.c;
        m10.v(m02);
        return this.a.f0();
    }

    public String g0(long l10, Charset charset) {
        f0.p(charset, "charset");
        this.L(l10);
        return this.a.g0(l10, charset);
    }

    public m getBuffer() {
        return this.a;
    }

    public long i(ByteString byteString) {
        f0.p(byteString, "bytes");
        return this.c(byteString, 0L);
    }

    public long i0(k0 k02) {
        long l10;
        m0 m02;
        long l11;
        Object object = "sink";
        f0.p(k02, (String)object);
        long l12 = l11 = 0L;
        while (true) {
            m02 = this.c;
            m m10 = this.a;
            int n10 = 8192;
            long l13 = n10;
            l10 = m02.read(m10, l13);
            long l14 = l10 - (l13 = (long)-1);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 == false) break;
            m02 = this.a;
            l10 = ((m)m02).O();
            long l15 = l10 - l11;
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 <= 0) continue;
            l12 += l10;
            m m11 = this.a;
            k02.t(m11, l10);
        }
        m02 = this.a;
        l10 = ((m)m02).S0();
        long l16 = l10 - l11;
        Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object3 > 0) {
            l11 = this.a.S0();
            l12 += l11;
            object = this.a;
            l10 = ((m)object).S0();
            k02.t((m)object, l10);
        }
        return l12;
    }

    public boolean isOpen() {
        return this.b ^ true;
    }

    public long j(byte by2, long l10) {
        return this.l(by2, l10, Long.MAX_VALUE);
    }

    public void k(m m10, long l10) {
        String string2 = "sink";
        f0.p(m10, string2);
        try {
            this.L(l10);
            this.a.k(m10, l10);
            return;
        }
        catch (EOFException eOFException) {
            m m11 = this.a;
            m10.v(m11);
            throw eOFException;
        }
    }

    public long k0() {
        int n10;
        long l10;
        byte by2;
        long l11 = 1L;
        this.L(l11);
        int n11 = 0;
        NumberFormatException numberFormatException = null;
        while ((by2 = this.request(l10 = (long)(n10 = n11 + 1))) != 0) {
            int n12;
            Object object = this.a;
            long l12 = n11;
            by2 = ((m)object).z0(l12);
            if (by2 >= (n12 = (int)48) && by2 <= (n12 = (byte)57) || by2 >= (n12 = (byte)97) && by2 <= (n12 = (byte)102) || by2 >= (n12 = (byte)65) && by2 <= (n12 = (byte)70)) {
                n11 = n10;
                continue;
            }
            if (n11 != 0) break;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Expected leading [0-9a-fA-F] character but was 0x");
            n12 = f.q2.b.a(f.q2.b.a(16));
            object = Integer.toString(by2, n12);
            f0.o(object, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            numberFormatException = new NumberFormatException((String)charSequence);
            throw numberFormatException;
        }
        return this.a.k0();
    }

    public long l(byte by2, long l10, long l11) {
        Object object = this.b;
        int n10 = 1;
        if ((object ^= n10) != 0) {
            long l12 = 0L;
            long l13 = l12 - l10;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object > 0 || (object = (Object)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1))) < 0) {
                n10 = 0;
            }
            if (n10 != 0) {
                long l14;
                while (true) {
                    int n11;
                    m m10;
                    long l15;
                    object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    l14 = -1;
                    if (object >= 0) break;
                    m0 m02 = this.a;
                    long l16 = l10;
                    long l17 = ((m)m02).l(by2, l10, l11);
                    long l18 = l17 - l14;
                    Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object2 != false) {
                        l14 = l17;
                        break;
                    }
                    m m11 = this.a;
                    l17 = m11.S0();
                    long l19 = l17 - l11;
                    object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                    if (object2 >= 0 || (object2 = (l15 = (l12 = (m02 = this.c).read(m10 = this.a, l16 = (long)(n11 = 8192))) - l14) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) break;
                    l10 = Math.max(l10, l17);
                }
                return l14;
            }
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("fromIndex=");
            ((StringBuilder)charSequence).append(l10);
            ((StringBuilder)charSequence).append(" toIndex=");
            ((StringBuilder)charSequence).append(l11);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence = ((Object)charSequence).toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public InputStream l0() {
        h0$a h0$a = new h0$a(this);
        return h0$a;
    }

    public long m(ByteString byteString) {
        f0.p(byteString, "targetBytes");
        return this.K(byteString, 0L);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int m0(c0 object) {
        int n10;
        long l10;
        m m10;
        long l11;
        long l12;
        Object object2 = "options";
        f0.p(object, (String)object2);
        int n11 = this.b;
        int n12 = 1;
        if ((n11 ^= n12) == 0) {
            object2 = "closed".toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        do {
            object2 = this.a;
            n11 = h.q0.a.d0((m)object2, (c0)object, n12 != 0);
            int n13 = -2;
            n10 = -1;
            if (n11 != n13) {
                if (n11 == n10) return n10;
                object = ((c0)object).f()[n11];
                int n14 = ((ByteString)object).size();
                m m11 = this.a;
                long l13 = n14;
                m11.skip(l13);
                return n11;
            }
            object2 = this.c;
            m10 = this.a;
            int n15 = 8192;
            l11 = n15;
        } while ((n11 = (int)((l12 = (l11 = object2.read(m10, l11)) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0);
        return n10;
    }

    public String n() {
        Object object;
        long l10;
        byte by2 = (byte)10;
        long l11 = this.N(by2);
        long l12 = l11 - (l10 = (long)-1);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            object = this.a;
            l11 = ((m)object).S0();
            long l13 = l11 - (l10 = 0L);
            by2 = (byte)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (by2 != 0) {
                l11 = this.a.S0();
                object = this.P(l11);
            } else {
                by2 = 0;
                object = null;
            }
        } else {
            m m10 = this.a;
            object = h.q0.a.b0(m10, l11);
        }
        return object;
    }

    public String p(long l10) {
        Object object;
        block5: {
            block8: {
                String string2;
                block7: {
                    byte by2;
                    long l11;
                    long l12;
                    long l13;
                    long l14;
                    Object object2;
                    long l15;
                    block6: {
                        long l16;
                        l15 = 0L;
                        long l17 = l10 - l15;
                        object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                        if (object2 >= 0) {
                            object2 = 1;
                        } else {
                            object2 = 0;
                            object = null;
                        }
                        if (object2 == false) break block5;
                        l15 = Long.MAX_VALUE;
                        l14 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
                        l13 = 1L;
                        l14 = (byte)10;
                        l12 = l14 == false ? l15 : l10 + l13;
                        l11 = this.l((byte)l14, 0L, l12);
                        long l18 = l11 - (l16 = (long)-1);
                        Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                        if (object3 == false) break block6;
                        string2 = h.q0.a.b0(this.a, l11);
                        break block7;
                    }
                    object2 = l12 == l15 ? 0 : (l12 < l15 ? -1 : 1);
                    if (object2 >= 0 || (object2 = (Object)this.request(l12)) == false || (object2 = (Object)((m)(object = this.a)).z0(l11 = l12 - l13)) != (by2 = (byte)13) || (object2 = (Object)this.request(l13 += l12)) == false || (object2 = (Object)((m)(object = this.a)).z0(l12)) != l14) break block8;
                    string2 = h.q0.a.b0(this.a, l12);
                }
                return string2;
            }
            m m10 = new m();
            object = this.a;
            long l19 = ((m)object).S0();
            l19 = Math.min((long)32, l19);
            Object object4 = m10;
            ((m)object).s0(m10, 0L, l19);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("\\n not found: limit=");
            l10 = Math.min(this.a.S0(), l10);
            ((StringBuilder)object4).append(l10);
            ((StringBuilder)object4).append(" content=");
            String string3 = m10.b0().hex();
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append("\u2026");
            string3 = ((StringBuilder)object4).toString();
            object = new EOFException(string3);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("limit < 0: ");
        ((StringBuilder)object).append(l10);
        String string4 = ((StringBuilder)object).toString();
        string4 = string4.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    public o peek() {
        e0 e02 = new e0(this);
        return z.d(e02);
    }

    public int read(ByteBuffer byteBuffer) {
        f0.p(byteBuffer, "sink");
        m0 m02 = this.a;
        long l10 = ((m)m02).S0();
        long l11 = 0L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object == false) {
            m02 = this.c;
            m m10 = this.a;
            int n10 = 8192;
            l11 = n10;
            l10 = m02.read(m10, l11);
            long l12 = l10 - (l11 = (long)-1);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                return -1;
            }
        }
        return this.a.read(byteBuffer);
    }

    public int read(byte[] byArray) {
        f0.p(byArray, "sink");
        int n10 = byArray.length;
        return this.read(byArray, 0, n10);
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        int n13;
        long l10;
        Object object = "sink";
        f0.p(byArray, (String)object);
        int n14 = byArray.length;
        long l11 = n14;
        long l12 = n10;
        long l13 = n11;
        j.e(l11, l12, l13);
        m0 m02 = this.a;
        long l14 = ((m)m02).S0();
        long l15 = 0L;
        n11 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
        if (n11 == 0 && (n11 = (int)((l10 = (l14 = (m02 = this.c).read((m)(object = this.a), l11 = (long)(n13 = 8192))) - (l15 = (long)-1)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) == 0) {
            n12 = -1;
        } else {
            m02 = this.a;
            l14 = ((m)m02).S0();
            l14 = Math.min(l13, l14);
            n11 = (int)l14;
            object = this.a;
            n12 = ((m)object).read(byArray, n10, n11);
        }
        return n12;
    }

    public long read(m object, long l10) {
        m m10;
        Object object2 = "sink";
        f0.p(object, (String)object2);
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
            l12 = this.b ^ n10;
            if (l12 != false) {
                int n11;
                long l13;
                m m11;
                long l14;
                long l15;
                m10 = this.a;
                long l16 = m10.S0();
                long l17 = l16 == l11 ? 0 : (l16 < l11 ? -1 : 1);
                long l18 = -1;
                if (l17 != false || (l17 = (l15 = (l14 = (object2 = this.c).read(m11 = this.a, l13 = (long)(n11 = 8192))) - l18) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false) {
                    l11 = this.a.S0();
                    l10 = Math.min(l10, l11);
                    object2 = this.a;
                    l18 = ((m)object2).read((m)object, l10);
                }
                return l18;
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

    public byte readByte() {
        this.L(1L);
        return this.a.readByte();
    }

    public void readFully(byte[] object) {
        int n10;
        String string2 = "sink";
        f0.p(object, string2);
        try {
            n10 = ((byte[])object).length;
        }
        catch (EOFException eOFException) {
            long l10;
            m m10;
            long l11;
            long l12;
            long l13;
            int n11 = 0;
            while ((l13 = (l12 = (l11 = (m10 = this.a).S0()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                m10 = this.a;
                long l14 = m10.S0();
                int n12 = (int)l14;
                l13 = m10.read((byte[])object, n11, n12);
                if (l13 != (n12 = -1)) {
                    n11 += l13;
                    continue;
                }
                object = new AssertionError;
                object();
                throw object;
            }
            throw eOFException;
        }
        long l15 = n10;
        this.L(l15);
        this.a.readFully((byte[])object);
    }

    public int readInt() {
        this.L(4);
        return this.a.readInt();
    }

    public long readLong() {
        this.L(8);
        return this.a.readLong();
    }

    public short readShort() {
        this.L(2);
        return this.a.readShort();
    }

    public boolean request(long l10) {
        Object object;
        long l11 = 0L;
        Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 0;
        int n11 = 1;
        if (object2 >= 0) {
            object2 = n11;
        } else {
            object2 = 0;
            object = null;
        }
        if (object2 != false) {
            object2 = this.b ^ n11;
            if (object2 != false) {
                block5: {
                    long l12;
                    long l13;
                    while ((object2 = (l13 = (l12 = ((m)(object = this.a)).S0()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                        long l14;
                        object = this.c;
                        m m10 = this.a;
                        int n12 = 8192;
                        long l15 = n12;
                        l12 = object.read(m10, l15);
                        long l16 = l12 - (l14 = (long)-1);
                        object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                        if (object2 != false) continue;
                        break block5;
                    }
                    n10 = n11;
                }
                return n10 != 0;
            }
            String string2 = "closed".toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public boolean s(long l10, ByteString byteString) {
        f0.p(byteString, "bytes");
        int n10 = byteString.size();
        return this.x(l10, byteString, 0, n10);
    }

    public void skip(long l10) {
        Object object = this.b ^ true;
        if (object) {
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                m0 m02;
                m m10 = this.a;
                long l14 = m10.S0();
                long l15 = l14 - l11;
                object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (!object) {
                    m02 = this.c;
                    m m11 = this.a;
                    l13 = 8192;
                    l14 = l13;
                    l11 = m02.read(m11, l14);
                    long l16 = l11 - (l14 = (long)-1);
                    object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    if (!object) {
                        EOFException eOFException = new EOFException();
                        throw eOFException;
                    }
                }
                m02 = this.a;
                l11 = ((m)m02).S0();
                l11 = Math.min(l10, l11);
                m10 = this.a;
                m10.skip(l11);
                l10 -= l11;
            }
            return;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public o0 timeout() {
        return this.c.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        m0 m02 = this.c;
        stringBuilder.append(m02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public String w() {
        return this.p(Long.MAX_VALUE);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean x(long l10, ByteString byteString, int n10, int n11) {
        String string2 = "bytes";
        f0.p(byteString, string2);
        boolean bl2 = this.b;
        boolean bl3 = true;
        boolean bl4 = bl2 ^ bl3;
        if (bl4) {
            void var7_11;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object < 0) return false;
            if (n10 < 0) return false;
            if (n11 < 0) return false;
            int n12 = byteString.size() - n10;
            if (n12 < n11) return false;
            boolean bl5 = false;
            string2 = null;
            while (++var7_11 < n11) {
                long l13 = (long)var7_11 + l10;
                long l14 = 1L + l13;
                boolean bl6 = this.request(l14);
                if (!bl6) return false;
                m m10 = this.a;
                byte by2 = m10.z0(l13);
                int n13 = n10 + var7_11;
                if (by2 != (n13 = (int)byteString.getByte(n13))) return false;
            }
            return bl3;
        }
        String string3 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string3);
        throw illegalStateException;
    }

    public byte[] z(long l10) {
        this.L(l10);
        return this.a.z(l10);
    }
}

