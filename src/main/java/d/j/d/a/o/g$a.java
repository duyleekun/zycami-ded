/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.k;
import d.j.d.a.o.g;

public final class g$a
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ g b;

    public g$a(g g10, k k10) {
        this.b = g10;
        this.a = k10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = g.a(this.b);
        synchronized (object) {
            Object object2 = this.b;
            object2 = g.b((g)object2);
            if (object2 != null) {
                object2 = this.b;
                object2 = g.b((g)object2);
                Object object3 = this.a;
                object3 = ((k)object3).r();
                object2.onSuccess(object3);
            }
            return;
        }
    }
}

