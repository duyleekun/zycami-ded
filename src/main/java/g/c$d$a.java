/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.c;
import g.c$d;
import h.k0;
import h.q;

public final class c$d$a
extends q {
    public final /* synthetic */ c$d b;

    public c$d$a(c$d c$d, k0 k02) {
        this.b = c$d;
        super(k02);
    }

    public void close() {
        c c10 = this.b.e;
        synchronized (c10) {
            Object object;
            block9: {
                object = this.b;
                boolean bl2 = ((c$d)object).d();
                if (!bl2) break block9;
                return;
            }
            object = this.b;
            int n10 = 1;
            ((c$d)object).e(n10 != 0);
            object = this.b;
            object = ((c$d)object).e;
            int n11 = ((c)object).S() + n10;
            ((c)object).w0(n11);
            // MONITOREXIT @DISABLED, blocks:[6, 7] lbl22 : MonitorExitStatement: MONITOREXIT : var1_1
            super.close();
            c$d.c(this.b).b();
            return;
        }
    }
}

