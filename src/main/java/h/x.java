/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import h.j0;
import h.m;
import h.m0;
import h.o;
import h.o0;
import h.z;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class x
implements m0 {
    private int a;
    private boolean b;
    private final o c;
    private final Inflater d;

    public x(m0 m02, Inflater inflater) {
        f0.p(m02, "source");
        f0.p(inflater, "inflater");
        m02 = z.d(m02);
        this((o)m02, inflater);
    }

    public x(o o10, Inflater inflater) {
        f0.p(o10, "source");
        f0.p(inflater, "inflater");
        this.c = o10;
        this.d = inflater;
    }

    private final void q() {
        int n10 = this.a;
        if (n10 == 0) {
            return;
        }
        int n11 = this.d.getRemaining();
        n10 -= n11;
        this.a = n11 = this.a - n10;
        o o10 = this.c;
        long l10 = n10;
        o10.skip(l10);
    }

    public final long a(m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        int n11 = l12 >= 0 ? n10 : 0;
        if (n11 != 0) {
            n11 = this.b ^ n10;
            if (n11 != 0) {
                block20: {
                    int n12;
                    Object object2;
                    i0 i02;
                    block19: {
                        if (l12 == false) {
                            return l11;
                        }
                        try {
                            i02 = ((m)object).V0(n10);
                        }
                        catch (DataFormatException dataFormatException) {
                            object2 = new IOException(dataFormatException);
                            throw object2;
                        }
                        n10 = i02.c;
                        n10 = 8192 - n10;
                        long l13 = n10;
                        l10 = Math.min(l10, l13);
                        n12 = (int)l10;
                        this.h();
                        Inflater inflater = this.d;
                        byte[] byArray = i02.a;
                        n11 = i02.c;
                        n12 = inflater.inflate(byArray, n11, n12);
                        this.q();
                        if (n12 <= 0) break block19;
                        int n13 = i02.c + n12;
                        i02.c = n13;
                        l11 = ((m)object).S0();
                        l10 = n12;
                        l11 += l10;
                        ((m)object).O0(l11);
                        return l10;
                    }
                    n12 = i02.b;
                    int n14 = i02.c;
                    if (n12 != n14) break block20;
                    object2 = i02.b();
                    ((m)object).a = object2;
                    j0.d(i02);
                }
                return l11;
            }
            String string3 = "closed".toString();
            object = new IllegalStateException(string3);
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

    public void close() {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        this.d.end();
        this.b = true;
        this.c.close();
    }

    public final boolean h() {
        Object object = this.d;
        boolean bl2 = ((Inflater)object).needsInput();
        if (!bl2) {
            return false;
        }
        object = this.c;
        bl2 = object.V();
        if (bl2) {
            return true;
        }
        object = this.c.getBuffer().a;
        f0.m(object);
        int n10 = ((i0)object).c;
        int n11 = ((i0)object).b;
        this.a = n10 -= n11;
        Inflater inflater = this.d;
        object = ((i0)object).a;
        inflater.setInput((byte[])object, n11, n10);
        return false;
    }

    public long read(m object, long l10) {
        block2: {
            boolean bl2;
            Object object2 = "sink";
            f0.p(object, (String)object2);
            do {
                long l11;
                long l12;
                long l13;
                long l14;
                if ((l14 = (l13 = (l12 = this.a((m)object, l10)) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
                    return l12;
                }
                object2 = this.d;
                bl2 = ((Inflater)object2).finished();
                if (bl2 || (bl2 = ((Inflater)(object2 = this.d)).needsDictionary())) break block2;
            } while (!(bl2 = (object2 = this.c).V()));
            object = new EOFException("source exhausted prematurely");
            throw object;
        }
        return -1;
    }

    public o0 timeout() {
        return this.c.timeout();
    }
}

