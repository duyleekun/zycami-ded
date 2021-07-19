/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import h.m;
import h.m0;
import h.o;
import h.o0;

public final class e0
implements m0 {
    private final m a;
    private i0 b;
    private int c;
    private boolean d;
    private long e;
    private final o f;

    public e0(o object) {
        String string2 = "upstream";
        f0.p(object, string2);
        this.f = object;
        object = object.getBuffer();
        this.a = object;
        this.b = object = ((m)object).a;
        int n10 = object != null ? ((i0)object).b : -1;
        this.c = n10;
    }

    public void close() {
        this.d = true;
    }

    public long read(m object, long l10) {
        block9: {
            block10: {
                int n10;
                long l11;
                long l12;
                Object object2;
                block12: {
                    int n11;
                    block11: {
                        i0 i02;
                        int n12;
                        object2 = "sink";
                        f0.p(object, (String)object2);
                        l12 = 0L;
                        l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                        n10 = 0;
                        n11 = 1;
                        if (l11 >= 0) {
                            n12 = n11;
                        } else {
                            n12 = 0;
                            i02 = null;
                        }
                        if (n12 == 0) break block9;
                        n12 = this.d ^ n11;
                        if (n12 == 0) break block10;
                        i02 = this.b;
                        if (i02 == null) break block11;
                        i0 i03 = this.a.a;
                        if (i02 != i03) break block12;
                        n12 = this.c;
                        f0.m(i03);
                        int n13 = i03.b;
                        if (n12 != n13) break block12;
                    }
                    n10 = n11;
                }
                if (n10 != 0) {
                    if (l11 == false) {
                        return l12;
                    }
                    object2 = this.f;
                    long l13 = this.e;
                    long l14 = 1L;
                    int n14 = object2.request(l13 += l14);
                    if (n14 == 0) {
                        return -1;
                    }
                    object2 = this.b;
                    if (object2 == null && (object2 = this.a.a) != null) {
                        this.b = object2;
                        f0.m(object2);
                        this.c = n14 = ((i0)object2).b;
                    }
                    l12 = this.a.S0();
                    long l15 = this.e;
                    l10 = Math.min(l10, l12 -= l15);
                    m m10 = this.a;
                    long l16 = this.e;
                    m10.s0((m)object, l16, l10);
                    this.e = l12 = this.e + l10;
                    return l10;
                }
                String string2 = "Peek source is invalid because upstream source was used".toString();
                object = new IllegalStateException(string2);
                throw object;
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

    public o0 timeout() {
        return this.f.timeout();
    }
}

