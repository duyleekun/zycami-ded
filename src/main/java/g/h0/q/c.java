/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import h.m;
import h.m0;
import h.x;
import java.io.Closeable;
import java.util.zip.Inflater;

public final class c
implements Closeable {
    private final m a;
    private final Inflater b;
    private final x c;
    private final boolean d;

    public c(boolean bl2) {
        x x10;
        Inflater inflater;
        m m10;
        this.d = bl2;
        this.a = m10 = new m();
        this.b = inflater = new Inflater(true);
        this.c = x10 = new x((m0)m10, inflater);
    }

    public final void a(m object) {
        f0.p(object, "buffer");
        Object object2 = this.a;
        long l10 = ((m)object2).S0();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            l12 = 1;
        } else {
            l12 = 0;
            object2 = null;
        }
        if (l12 != false) {
            long l13;
            long l14;
            l12 = (long)this.d;
            if (l12 != false) {
                object2 = this.b;
                ((Inflater)object2).reset();
            }
            this.a.v((m0)object);
            object2 = this.a;
            char c10 = (char)-1;
            ((m)object2).e1(c10);
            object2 = this.b;
            l10 = ((Inflater)object2).getBytesRead();
            Object object3 = this.a;
            l11 = ((m)object3).S0();
            l10 += l11;
            do {
                object3 = this.c;
                long l15 = Long.MAX_VALUE;
                ((x)object3).a((m)object, l15);
            } while ((l14 = (l13 = (l11 = ((Inflater)(object3 = this.b)).getBytesRead()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0);
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

