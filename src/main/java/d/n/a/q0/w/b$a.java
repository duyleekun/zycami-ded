/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.p;
import d.n.a.q0.w.b;
import d.n.a.q0.w.g;
import d.n.a.q0.w.h;
import d.n.a.q0.w.k;
import e.a.h0;

public class b$a
implements Runnable {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ b b;

    public b$a(b b10, h0 h02) {
        this.b = b10;
        this.a = h02;
    }

    public void run() {
        while (true) {
            Object object;
            Object object2;
            try {
                object2 = this.b;
            }
            catch (InterruptedException interruptedException) {
                object = new Object[]{};
                String string2 = "Error while processing client operation queue";
                p.e(interruptedException, string2, object);
                continue;
            }
            object2 = ((b)object2).a;
            object2 = ((h)object2).d();
            object = ((g)object2).b;
            long l10 = System.currentTimeMillis();
            d.n.a.q0.t.b.t((d.n.a.q0.u.p)object);
            d.n.a.q0.t.b.r((d.n.a.q0.u.p)object);
            k k10 = new k();
            h0 h02 = this.a;
            ((g)object2).b(k10, h02);
            k10.a();
            long l11 = System.currentTimeMillis();
            d.n.a.q0.t.b.o((d.n.a.q0.u.p)object, l10, l11);
            continue;
            break;
        }
    }
}

