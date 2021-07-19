/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.k.b;
import h.k0;
import h.m;
import h.o0;
import h.s;

public final class b$b
implements k0 {
    private final s a;
    private boolean b;
    public final /* synthetic */ b c;

    public b$b(b object) {
        s s10;
        this.c = object;
        object = g.h0.k.b.m((b)object).timeout();
        this.a = s10 = new s((o0)object);
    }

    public void close() {
        synchronized (this) {
            boolean bl2;
            block9: {
                bl2 = this.b;
                if (!bl2) break block9;
                return;
            }
            bl2 = true;
            this.b = bl2;
            Object object = this.c;
            object = g.h0.k.b.m((b)object);
            Object object2 = "0\r\n\r\n";
            object.r((String)object2);
            object = this.c;
            object2 = this.a;
            g.h0.k.b.j((b)object, (s)object2);
            object = this.c;
            int n10 = 3;
            g.h0.k.b.q((b)object, n10);
            return;
        }
    }

    public void flush() {
        synchronized (this) {
            block6: {
                boolean bl2 = this.b;
                if (!bl2) break block6;
                return;
            }
            Object object = this.c;
            object = g.h0.k.b.m((b)object);
            object.flush();
            return;
        }
    }

    public void t(m object, long l10) {
        Object object2 = "source";
        f0.p(object, (String)object2);
        Object object3 = this.b ^ true;
        if (object3) {
            long l11 = 0L;
            long l12 = l10 - l11;
            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object3) {
                return;
            }
            g.h0.k.b.m(this.c).a0(l10);
            object2 = g.h0.k.b.m(this.c);
            String string2 = "\r\n";
            object2.r(string2);
            g.h0.k.b.m(this.c).t((m)object, l10);
            g.h0.k.b.m(this.c).r(string2);
            return;
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public o0 timeout() {
        return this.a;
    }
}

