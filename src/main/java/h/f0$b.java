/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.q1;
import h.f0;
import h.m;
import h.m0;
import h.o0;
import java.io.IOException;

public final class f0$b
implements m0 {
    private final o0 a;
    public final /* synthetic */ f0 b;

    public f0$b(f0 object) {
        this.b = object;
        this.a = object = new o0();
    }

    public void close() {
        m m10 = this.b.g();
        synchronized (m10) {
            Object object;
            block9: {
                object = this.b;
                boolean bl2 = true;
                ((f0)object).p(bl2);
                object = this.b;
                object = ((f0)object).g();
                if (object == null) break block9;
                object.notifyAll();
                object = q1.a;
                return;
            }
            String string2 = "null cannot be cast to non-null type java.lang.Object";
            object = new NullPointerException(string2);
            throw object;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long read(m object, long l10) {
        f.h2.t.f0.p(object, "sink");
        m m10 = this.b.g();
        synchronized (m10) {
            void var2_2;
            Object object2;
            block9: {
                object2 = this.b;
                Object object3 = ((f0)object2).l() ^ true;
                if (!object3) {
                    object = "closed";
                    object = object.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                object2 = this.b;
                object3 = ((f0)object2).h();
                if (object3) {
                    String string2 = "canceled";
                    object = new IOException(string2);
                    throw object;
                }
                do {
                    long l11;
                    object2 = this.b;
                    long l12 = ((m)(object2 = ((f0)object2).g())).S0();
                    long l13 = l12 - (l11 = 0L);
                    object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object3) break block9;
                    object2 = this.b;
                    object3 = ((f0)object2).k();
                    if (object3) {
                        return -1;
                    }
                    object2 = this.a;
                    Object object4 = this.b;
                    object4 = ((f0)object4).g();
                    ((o0)object2).k(object4);
                } while (!(object3 = ((f0)(object2 = this.b)).h()));
                String string3 = "canceled";
                object = new IOException(string3);
                throw object;
            }
            object2 = this.b;
            object2 = ((f0)object2).g();
            long l14 = ((m)object2).read((m)object, (long)var2_2);
            Object object5 = this.b;
            if ((object5 = ((f0)object5).g()) != null) {
                object5.notifyAll();
                return l14;
            }
            String string4 = "null cannot be cast to non-null type java.lang.Object";
            object = new NullPointerException(string4);
            throw object;
        }
    }

    public o0 timeout() {
        return this.a;
    }
}

