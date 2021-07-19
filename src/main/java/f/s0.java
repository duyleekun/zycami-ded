/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.a;
import f.h2.t.c0;
import f.r0;

public class s0
extends r0 {
    private static final Object l(Object object, a object2) {
        synchronized (object) {
            int n10 = 1;
            try {
                object2 = object2.invoke();
                return object2;
            }
            finally {
                c0.d(n10);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl8 : MonitorExitStatement: MONITOREXIT : var0
                c0.c(n10);
            }
        }
    }
}

