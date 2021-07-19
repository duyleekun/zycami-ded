/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import g.h0.q.b;
import h.k0;
import h.m;
import h.m$a;
import h.p;
import java.io.Closeable;
import java.util.zip.Deflater;
import okio.ByteString;

public final class a
implements Closeable {
    private final m a;
    private final Deflater b;
    private final p c;
    private final boolean d;

    public a(boolean bl2) {
        p p10;
        Deflater deflater;
        m m10;
        this.d = bl2;
        this.a = m10 = new m();
        this.b = deflater = new Deflater(-1, true);
        this.c = p10 = new p((k0)m10, deflater);
    }

    private final boolean h(m m10, ByteString byteString) {
        long l10 = m10.S0();
        long l11 = byteString.size();
        return m10.s(l10 -= l11, byteString);
    }

    public final void a(m object) {
        Object object2;
        block7: {
            block9: {
                block8: {
                    f0.p(object, "buffer");
                    object2 = this.a;
                    long l10 = ((m)object2).S0();
                    long l11 = 0L;
                    long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    int n10 = 1;
                    if (l12 == false) {
                        l12 = n10;
                    } else {
                        l12 = 0;
                        object2 = null;
                    }
                    if (l12 == false) break block7;
                    l12 = (long)this.d;
                    if (l12 != false) {
                        object2 = this.b;
                        ((Deflater)object2).reset();
                    }
                    object2 = this.c;
                    long l13 = ((m)object).S0();
                    ((p)object2).t((m)object, l13);
                    this.c.flush();
                    object2 = this.a;
                    ByteString byteString = g.h0.q.b.a();
                    l12 = (long)this.h((m)object2, byteString);
                    if (l12 == false) break block8;
                    l11 = this.a.S0();
                    l12 = 4;
                    long l14 = l12;
                    l11 -= l14;
                    object2 = m.H0(this.a, null, n10, null);
                    try {
                        ((m$a)object2).q(l11);
                    }
                    catch (Throwable throwable) {
                        try {
                            throw throwable;
                        }
                        catch (Throwable throwable2) {
                            f.e2.b.a((Closeable)object2, throwable);
                            throw throwable2;
                        }
                    }
                    f.e2.b.a((Closeable)object2, null);
                    break block9;
                }
                object2 = this.a;
                ((m)object2).b1(0);
            }
            object2 = this.a;
            long l15 = ((m)object2).S0();
            ((m)object).t((m)object2, l15);
            return;
        }
        object2 = "Failed requirement.".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public void close() {
        this.c.close();
    }
}

