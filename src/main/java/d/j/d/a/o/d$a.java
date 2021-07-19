/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.k;
import d.j.d.a.o.d;

public final class d$a
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ d b;

    public d$a(d d10, k k10) {
        this.b = d10;
        this.a = k10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = d.a(this.b);
        synchronized (object) {
            Object object2 = this.b;
            object2 = d.b((d)object2);
            if (object2 != null) {
                object2 = this.b;
                object2 = d.b((d)object2);
                k k10 = this.a;
                object2.onComplete(k10);
            }
            return;
        }
    }
}

