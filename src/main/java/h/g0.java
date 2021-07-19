/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.g0$a;
import h.k0;
import h.m;
import h.m0;
import h.n;
import h.o0;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;

public final class g0
implements n {
    public final m a;
    public boolean b;
    public final k0 c;

    public g0(k0 k02) {
        f0.p(k02, "sink");
        this.c = k02;
        this.a = k02;
    }

    public static /* synthetic */ void a() {
    }

    public n J(String object, int n10, int n11, Charset charset) {
        f0.p(object, "string");
        String string2 = "charset";
        f0.p(charset, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.k1((String)object, n10, n11, charset);
            return this.o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public n M(long l10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.c1(l10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n R(ByteString serializable, int n10, int n11) {
        String string2 = "byteString";
        f0.p(serializable, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.X0((ByteString)serializable, n10, n11);
            return this.o();
        }
        String string3 = "closed".toString();
        serializable = new IllegalStateException(string3);
        throw serializable;
    }

    public n U(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.f1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n X(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.j1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n a0(long l10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.d1(l10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public m b() {
        return this.a;
    }

    public n c0(String object, Charset object2) {
        f0.p(object, "string");
        String string2 = "charset";
        f0.p(object2, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.l1((String)object, (Charset)object2);
            return this.o();
        }
        object2 = "closed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void close() {
        Throwable throwable;
        block15: {
            block14: {
                int n10;
                block13: {
                    k0 k02;
                    block12: {
                        boolean bl2 = this.b;
                        if (bl2) break block14;
                        bl2 = false;
                        throwable = null;
                        k02 = this.a;
                        long l10 = ((m)k02).S0();
                        long l11 = 0L;
                        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (n10 <= 0) break block12;
                        k02 = this.c;
                        m m10 = this.a;
                        l11 = m10.S0();
                        try {
                            k02.t(m10, l11);
                        }
                        catch (Throwable throwable2) {
                            // empty catch block
                        }
                    }
                    k02 = this.c;
                    try {
                        k02.close();
                    }
                    catch (Throwable throwable3) {
                        if (throwable != null) break block13;
                        throwable = throwable3;
                    }
                }
                this.b = n10 = 1;
                if (throwable != null) break block15;
            }
            return;
        }
        throw throwable;
    }

    public n d() {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            long l10;
            m m10 = this.a;
            long l11 = m10.S0();
            long l12 = l11 - (l10 = 0L);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                k0 k02 = this.c;
                m m11 = this.a;
                k02.t(m11, l11);
            }
            return this;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n d0(m0 object, long l10) {
        long l11;
        long l12;
        long l13;
        Object object2 = "source";
        f0.p(object, (String)object2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14;
            object2 = this.a;
            l11 = object.read((m)object2, l10);
            long l15 = l11 - (l14 = (long)-1);
            Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 != false) {
                l10 -= l11;
                this.o();
                continue;
            }
            object = new EOFException();
            throw object;
        }
        return this;
    }

    public n e(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.r1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public void flush() {
        Object object = this.b ^ 1;
        if (object != 0) {
            long l10;
            k0 k02 = this.a;
            long l11 = ((m)k02).S0();
            long l12 = l11 - (l10 = 0L);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                k02 = this.c;
                m m10 = this.a;
                l10 = m10.S0();
                k02.t(m10, l10);
            }
            this.c.flush();
            return;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n g(long l10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.h1(l10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public m getBuffer() {
        return this.a;
    }

    public n h0(ByteString serializable) {
        String string2 = "byteString";
        f0.p(serializable, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.W0((ByteString)serializable);
            return this.o();
        }
        string2 = "closed".toString();
        serializable = new IllegalStateException(string2);
        throw serializable;
    }

    public boolean isOpen() {
        return this.b ^ true;
    }

    public OutputStream j0() {
        g0$a g0$a = new g0$a(this);
        return g0$a;
    }

    public n o() {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            long l10;
            m m10 = this.a;
            long l11 = m10.O();
            long l12 = l11 - (l10 = 0L);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                k0 k02 = this.c;
                m m11 = this.a;
                k02.t(m11, l11);
            }
            return this;
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n r(String object) {
        String string2 = "string";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.p1((String)object);
            return this.o();
        }
        string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public void t(m object, long l10) {
        String string2 = "source";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.t((m)object, l10);
            this.o();
            return;
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public o0 timeout() {
        return this.c.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        k0 k02 = this.c;
        stringBuilder.append(k02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public n u(String object, int n10, int n11) {
        String string2 = "string";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.q1((String)object, n10, n11);
            return this.o();
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public long v(m0 m02) {
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
        while ((l15 = (l14 = (l13 = m02.read(m10 = this.a, l12 = (long)(n10 = 8192))) - (l11 = (long)-1)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
            l10 += l13;
            this.o();
        }
        return l10;
    }

    public int write(ByteBuffer object) {
        String string2 = "source";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            int n10 = this.a.write((ByteBuffer)object);
            this.o();
            return n10;
        }
        string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public n write(byte[] object) {
        String string2 = "source";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.Z0((byte[])object);
            return this.o();
        }
        object = new IllegalStateException;
        string2 = "closed".toString();
        object(string2);
        throw object;
    }

    public n write(byte[] object, int n10, int n11) {
        String string2 = "source";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.a1((byte[])object, n10, n11);
            return this.o();
        }
        object = new IllegalStateException;
        String string3 = "closed".toString();
        object(string3);
        throw object;
    }

    public n writeByte(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.b1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n writeInt(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.e1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n writeLong(long l10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.g1(l10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public n writeShort(int n10) {
        boolean bl2 = this.b ^ true;
        if (bl2) {
            this.a.i1(n10);
            return this.o();
        }
        String string2 = "closed".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }
}

