/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.g0;
import h.i0;
import h.k0;
import h.m;
import h.o0;
import h.p;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

public final class t
implements k0 {
    private final g0 a;
    private final Deflater b;
    private final p c;
    private boolean d;
    private final CRC32 e;

    public t(k0 object) {
        p p10;
        g0 g02;
        f0.p(object, "sink");
        this.a = g02 = new g0((k0)object);
        this.b = object = new Deflater(-1, true);
        this.c = p10 = new p(g02, (Deflater)object);
        this.e = object = new CRC32();
        object = g02.a;
        ((m)object).i1(8075);
        ((m)object).b1(8);
        ((m)object).b1(0);
        ((m)object).e1(0);
        ((m)object).b1(0);
        ((m)object).b1(0);
    }

    private final void B() {
        g0 g02 = this.a;
        int n10 = (int)this.e.getValue();
        g02.U(n10);
        g02 = this.a;
        n10 = (int)this.b.getBytesRead();
        g02.U(n10);
    }

    private final void q(m object, long l10) {
        long l11;
        long l12;
        long l13;
        object = ((m)object).a;
        f0.m(object);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            l13 = ((i0)object).c;
            int n10 = ((i0)object).b;
            l11 = l13 - n10;
            l13 = (int)Math.min(l10, l11);
            CRC32 cRC32 = this.e;
            byte[] byArray = ((i0)object).a;
            int n11 = ((i0)object).b;
            cRC32.update(byArray, n11, (int)l13);
            l11 = l13;
            l10 -= l11;
            object = ((i0)object).f;
            f0.m(object);
        }
    }

    public final Deflater a() {
        return this.b;
    }

    public void close() {
        boolean bl2;
        Throwable throwable;
        block12: {
            Object object;
            block11: {
                boolean bl3 = this.d;
                if (bl3) {
                    return;
                }
                bl3 = false;
                throwable = null;
                object = this.c;
                try {
                    ((p)object).h();
                    this.B();
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
                object = this.b;
                try {
                    ((Deflater)object).end();
                }
                catch (Throwable throwable3) {
                    if (throwable != null) break block11;
                    throwable = throwable3;
                }
            }
            object = this.a;
            try {
                ((g0)object).close();
            }
            catch (Throwable throwable4) {
                if (throwable != null) break block12;
                throwable = throwable4;
            }
        }
        this.d = bl2 = true;
        if (throwable == null) {
            return;
        }
        throw throwable;
    }

    public void flush() {
        this.c.flush();
    }

    public final Deflater h() {
        return this.b;
    }

    public void t(m object, long l10) {
        String string2 = "source";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = l12 >= 0;
        if (bl2) {
            if (l12 == false) {
                return;
            }
            this.q((m)object, l10);
            this.c.t((m)object, l10);
            return;
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
        return this.a.timeout();
    }
}

