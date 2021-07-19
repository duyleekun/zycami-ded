/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.h0;
import h.i0;
import h.m;
import h.m0;
import h.o0;
import h.x;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

public final class u
implements m0 {
    private byte a;
    private final h0 b;
    private final Inflater c;
    private final x d;
    private final CRC32 e;

    public u(m0 object) {
        x x10;
        h0 h02;
        f0.p(object, "source");
        this.b = h02 = new h0((m0)object);
        this.c = object = new Inflater(true);
        this.d = x10 = new x(h02, (Inflater)object);
        this.e = object = new CRC32();
    }

    private final void B(m object, long l10, long l11) {
        long l12;
        int n10;
        int n11;
        long l13;
        long l14;
        long l15;
        object = ((m)object).a;
        f0.m(object);
        while ((l15 = (l14 = l10 - (l13 = (long)((n11 = ((i0)object).c) - (n10 = ((i0)object).b)))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0) {
            l12 = n11 -= n10;
            l10 -= l12;
            object = ((i0)object).f;
            f0.m(object);
        }
        l12 = 0L;
        while ((l15 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) > 0) {
            l15 = ((i0)object).b;
            int n12 = (int)((long)l15 + l10);
            l13 = Math.min((long)(((i0)object).c - n12), l11);
            int n13 = (int)l13;
            CRC32 cRC32 = this.e;
            byte[] byArray = ((i0)object).a;
            cRC32.update(byArray, n12, n13);
            l10 = n13;
            l11 -= l10;
            object = ((i0)object).f;
            f0.m(object);
            l10 = l12;
        }
    }

    private final void a(String object, int n10, int n11) {
        if (n11 == n10) {
            return;
        }
        int n12 = 3;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object;
        Integer n13 = n11;
        objectArray[1] = n13;
        Integer n14 = n10;
        objectArray[2] = n14;
        object = Arrays.copyOf(objectArray, n12);
        object = String.format("%s: actual 0x%08x != expected 0x%08x", object);
        f0.o(object, "java.lang.String.format(this, *args)");
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    private final void h() {
        long l10;
        long l11;
        long l12;
        Object object;
        u u10 = this;
        this.b.L(10);
        Object object2 = this.b.a;
        long l13 = 3;
        byte by2 = ((m)object2).z0(l13);
        int n10 = by2 >> 1;
        int n11 = 1;
        int n12 = (n10 &= n11) == n11 ? n11 : 0;
        if (n12 != 0) {
            object = u10.b.a;
            l12 = 0L;
            l11 = 10;
            object2 = this;
            this.B((m)object, l12, l11);
        }
        n10 = u10.b.readShort();
        int n13 = 8075;
        String string2 = "ID1ID2";
        u10.a(string2, n13, n10);
        object2 = u10.b;
        l13 = 8;
        ((h0)object2).skip(l13);
        n10 = by2 >> 2 & n11;
        if (n10 == n11) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object2 = u10.b;
            l13 = 2;
            ((h0)object2).L(l13);
            if (n12 != 0) {
                object = u10.b.a;
                l12 = 0L;
                l11 = 2;
                object2 = this;
                this.B((m)object, l12, l11);
            }
            n10 = u10.b.a.G();
            l10 = n10;
            object2 = u10.b;
            ((h0)object2).L(l10);
            if (n12 != 0) {
                object = u10.b.a;
                l12 = 0L;
                object2 = this;
                l11 = l10;
                this.B((m)object, l12, l10);
            }
            object2 = u10.b;
            ((h0)object2).skip(l10);
        }
        if ((n10 = by2 >> 3 & n11) == n11) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        l10 = -1;
        long l14 = 1L;
        if (n10 != 0) {
            object2 = u10.b;
            long l15 = ((h0)object2).N((byte)0);
            long l16 = l15 - l10;
            n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n10 != 0) {
                if (n12 != 0) {
                    object = u10.b.a;
                    l12 = 0L;
                    l11 = l15 + l14;
                    object2 = this;
                    this.B((m)object, l12, l11);
                }
                object2 = u10.b;
                l13 = l15 + l14;
                ((h0)object2).skip(l13);
            } else {
                object2 = new EOFException();
                throw object2;
            }
        }
        if ((n10 = by2 >> 4 & n11) != n11) {
            n11 = 0;
        }
        if (n11 != 0) {
            object2 = u10.b;
            long l17 = ((h0)object2).N((byte)0);
            long l18 = l17 - l10;
            n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
            if (n10 != 0) {
                if (n12 != 0) {
                    object = u10.b.a;
                    l12 = 0L;
                    l11 = l17 + l14;
                    object2 = this;
                    this.B((m)object, l12, l11);
                }
                object2 = u10.b;
                ((h0)object2).skip(l17 += l14);
            } else {
                object2 = new EOFException();
                throw object2;
            }
        }
        if (n12 != 0) {
            n10 = u10.b.G();
            object = u10.e;
            l13 = ((CRC32)object).getValue();
            n13 = (short)l13;
            string2 = "FHCRC";
            u10.a(string2, n10, n13);
            object2 = u10.e;
            ((CRC32)object2).reset();
        }
    }

    private final void q() {
        int n10 = this.b.e0();
        int n11 = (int)this.e.getValue();
        this.a("CRC", n10, n11);
        n10 = this.b.e0();
        n11 = (int)this.c.getBytesWritten();
        this.a("ISIZE", n10, n11);
    }

    public void close() {
        this.d.close();
    }

    public long read(m object, long l10) {
        Object object2 = "sink";
        f0.p(object, (String)object2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        byte by2 = 1;
        byte by3 = l12 >= 0 ? by2 : (byte)0;
        if (by3 != 0) {
            byte by4;
            if (l12 == false) {
                return l11;
            }
            byte by5 = this.a;
            if (by5 == 0) {
                this.h();
                this.a = by2;
            }
            by5 = this.a;
            long l13 = -1;
            by3 = 2;
            if (by5 == by2) {
                long l14 = ((m)object).S0();
                object2 = this.d;
                long l15 = (l10 = ((x)object2).read((m)object, l10)) - l13;
                by5 = (byte)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                if (by5 != 0) {
                    this.B((m)object, l14, l10);
                    return l10;
                }
                this.a = by3;
            }
            if ((by4 = this.a) == by3) {
                this.q();
                this.a = (byte)3;
                object = this.b;
                by4 = (byte)(((h0)object).V() ? 1 : 0);
                if (by4 == 0) {
                    object = new IOException("gzip finished without exhausting source");
                    throw object;
                }
            }
            return l13;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public o0 timeout() {
        return this.b.timeout();
    }
}

