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
import h.o0;
import java.io.OutputStream;

public final class d0
implements k0 {
    private final OutputStream a;
    private final o0 b;

    public d0(OutputStream outputStream, o0 o02) {
        f0.p(outputStream, "out");
        f0.p(o02, "timeout");
        this.a = outputStream;
        this.b = o02;
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        this.a.flush();
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
            i0 i02;
            this.b.h();
            object = m10.a;
            f0.m(object);
            int n10 = ((i0)object).c;
            int n11 = ((i0)object).b;
            l14 = n10 - n11;
            n10 = (int)Math.min(l10, l14);
            OutputStream outputStream = this.a;
            byte[] byArray = ((i0)object).a;
            int n12 = ((i0)object).b;
            outputStream.write(byArray, n12, n10);
            ((i0)object).b = n11 = ((i0)object).b + n10;
            l14 = n10;
            l10 -= l14;
            l15 = m10.S0() - l14;
            m10.O0(l15);
            n10 = ((i0)object).b;
            n11 = ((i0)object).c;
            if (n10 != n11) continue;
            m10.a = i02 = ((i0)object).b();
            j0.d((i0)object);
        }
    }

    public o0 timeout() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sink(");
        OutputStream outputStream = this.a;
        stringBuilder.append(outputStream);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

