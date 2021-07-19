/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.q1;
import h.k;

public final class k$b
extends Thread {
    public k$b() {
        super("Okio Watchdog");
        this.setDaemon(true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        while (true) {
            var1_1 = k.class;
            var2_2 = k.m;
            if ((var2_2 = var2_2.c()) != (var3_3 = k.l())) ** GOTO lbl10
            var2_2 = null;
            k.s(null);
            // MONITOREXIT : var1_1
            return;
lbl10:
            // 1 sources

            v0 = q1.a;
            try {
                var3_3 = v0;
                // MONITOREXIT : var1_1
                if (var2_2 == null) continue;
                var2_2.B();
            }
            catch (InterruptedException v1) {
            }
        }
    }
}

