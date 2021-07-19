/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import h.j;
import h.j0;
import h.k0;
import h.m;
import h.n;
import h.o0;
import h.z;
import java.util.zip.Deflater;

public final class p
implements k0 {
    private boolean a;
    private final n b;
    private final Deflater c;

    public p(k0 k02, Deflater deflater) {
        f0.p(k02, "sink");
        f0.p(deflater, "deflater");
        k02 = z.c(k02);
        this((n)k02, deflater);
    }

    public p(n n10, Deflater deflater) {
        f0.p(n10, "sink");
        f0.p(deflater, "deflater");
        this.b = n10;
        this.c = deflater;
    }

    private final void a(boolean n10) {
        int n11;
        Object object;
        m m10 = this.b.getBuffer();
        while (true) {
            int n12;
            int n13;
            byte[] byArray;
            Deflater deflater;
            int n14 = 1;
            object = m10.V0(n14);
            if (n10 != 0) {
                deflater = this.c;
                byArray = ((i0)object).a;
                n13 = ((i0)object).c;
                n12 = 8192 - n13;
                int n15 = 2;
                n11 = deflater.deflate(byArray, n13, n12, n15);
            } else {
                deflater = this.c;
                byArray = ((i0)object).a;
                n13 = ((i0)object).c;
                n12 = 8192 - n13;
                n11 = deflater.deflate(byArray, n13, n12);
            }
            if (n11 > 0) {
                int n16;
                ((i0)object).c = n16 = ((i0)object).c + n11;
                long l10 = m10.S0();
                long l11 = n11;
                m10.O0(l10 += l11);
                object = this.b;
                object.o();
                continue;
            }
            deflater = this.c;
            n11 = (int)(deflater.needsInput() ? 1 : 0);
            if (n11 != 0) break;
        }
        n10 = ((i0)object).b;
        n11 = ((i0)object).c;
        if (n10 == n11) {
            i0 i02;
            m10.a = i02 = ((i0)object).b();
            j0.d((i0)object);
        }
    }

    public void close() {
        boolean bl2;
        Throwable throwable;
        block11: {
            Object object;
            block10: {
                boolean bl3 = this.a;
                if (bl3) {
                    return;
                }
                bl3 = false;
                throwable = null;
                try {
                    this.h();
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
                object = this.c;
                try {
                    ((Deflater)object).end();
                }
                catch (Throwable throwable3) {
                    if (throwable != null) break block10;
                    throwable = throwable3;
                }
            }
            object = this.b;
            try {
                object.close();
            }
            catch (Throwable throwable4) {
                if (throwable != null) break block11;
                throwable = throwable4;
            }
        }
        this.a = bl2 = true;
        if (throwable == null) {
            return;
        }
        throw throwable;
    }

    public void flush() {
        this.a(true);
        this.b.flush();
    }

    public final void h() {
        this.c.finish();
        this.a(false);
    }

    public void t(m m10, long l10) {
        long l11;
        long l12;
        long l13;
        Object object = "source";
        f0.p(m10, (String)object);
        long l14 = m10.S0();
        long l15 = 0L;
        j.e(l14, l15, l10);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            object = m10.a;
            f0.m(object);
            int n10 = ((i0)object).c;
            int n11 = ((i0)object).b;
            l14 = n10 - n11;
            l14 = Math.min(l10, l14);
            n10 = (int)l14;
            Deflater deflater = this.c;
            byte[] byArray = ((i0)object).a;
            int n12 = ((i0)object).b;
            deflater.setInput(byArray, n12, n10);
            deflater = null;
            this.a(false);
            long l16 = m10.S0();
            long l17 = n10;
            m10.O0(l16 -= l17);
            ((i0)object).b = n11 = ((i0)object).b + n10;
            n10 = ((i0)object).c;
            if (n11 == n10) {
                i0 i02;
                m10.a = i02 = ((i0)object).b();
                j0.d((i0)object);
            }
            l10 -= l17;
        }
    }

    public o0 timeout() {
        return this.b.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeflaterSink(");
        n n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

