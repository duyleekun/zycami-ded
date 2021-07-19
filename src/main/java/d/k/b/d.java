/*
 * Decompiled with CFR 0.151.
 */
package d.k.b;

import d.k.b.a;
import d.k.b.c;
import e.a.g0;

public final class d
extends c {
    private final c a;
    private boolean b;
    private a c;

    public d(c c10) {
        this.a = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j8() {
        while (true) {
            c c10;
            a a10;
            synchronized (this) {
                a10 = this.c;
                if (a10 == null) {
                    a10 = null;
                    this.b = false;
                    return;
                }
                c10 = null;
                this.c = null;
            }
            c10 = this.a;
            a10.a(c10);
        }
    }

    public void K5(g0 g02) {
        this.a.subscribe(g02);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void accept(Object object) {
        synchronized (this) {
            boolean bl2 = this.b;
            if (!bl2) {
                this.b = bl2 = true;
                // MONITOREXIT @DISABLED, blocks:[2, 4] lbl5 : MonitorExitStatement: MONITOREXIT : this
                this.a.accept(object);
                this.j8();
                return;
            }
            a a10 = this.c;
            if (a10 == null) {
                int n10 = 4;
                this.c = a10 = new a(n10);
            }
            a10.b(object);
            return;
        }
    }

    public boolean h8() {
        return this.a.h8();
    }
}

