/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.k;
import d.j.d.a.o.f;

public final class f$a
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ f b;

    public f$a(f f10, k k10) {
        this.b = f10;
        this.a = k10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = f.a(this.b);
        synchronized (object) {
            Object object2 = this.b;
            object2 = f.b((f)object2);
            if (object2 != null) {
                object2 = this.b;
                object2 = f.b((f)object2);
                Object object3 = this.a;
                object3 = ((k)object3).q();
                object2.onFailure((Exception)object3);
            }
            return;
        }
    }
}

