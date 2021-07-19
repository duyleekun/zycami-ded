/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.w.e;
import d.n.a.q0.w.g;
import d.n.a.q0.w.h;
import d.n.a.q0.w.k;
import e.a.h0;

public class e$a
implements Runnable {
    public final /* synthetic */ h0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ e c;

    public e$a(e e10, h0 h02, String string2) {
        this.c = e10;
        this.a = h02;
        this.b = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        while (true) {
            Object object3 = this.c;
            boolean bl2 = ((e)object3).f;
            Object[] objectArray = null;
            if (!bl2) break;
            try {
                object3 = this.c;
                object3 = ((e)object3).d;
                object3 = ((h)object3).d();
                object2 = ((g)object3).b;
                long l10 = System.currentTimeMillis();
                d.n.a.q0.t.b.t((d.n.a.q0.u.p)object2);
                d.n.a.q0.t.b.r((d.n.a.q0.u.p)object2);
                k k10 = new k();
                h0 h02 = this.a;
                ((g)object3).b(k10, h02);
                k10.a();
                long l11 = System.currentTimeMillis();
                d.n.a.q0.t.b.o((d.n.a.q0.u.p)object2, l10, l11);
            }
            catch (InterruptedException interruptedException) {
                object2 = this.c;
                synchronized (object2) {
                    object = this.c;
                    boolean bl3 = ((e)object).f;
                    if (!bl3) {
                        break;
                    }
                }
                object2 = "Error while processing connection operation queue";
                objectArray = new Object[]{};
                p.e(interruptedException, (String)object2, objectArray);
            }
        }
        this.c.e();
        object = d.n.a.q0.t.b.d(this.b);
        object2 = new Object[]{object};
        p.s("Terminated (%s)", object2);
    }
}

