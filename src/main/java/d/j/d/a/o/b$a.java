/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.o.b;

public final class b$a
implements Runnable {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = b.a(this.a);
        synchronized (object) {
            Object object2 = this.a;
            object2 = b.b((b)object2);
            if (object2 != null) {
                object2 = this.a;
                object2 = b.b((b)object2);
                object2.onCanceled();
            }
            return;
        }
    }
}

