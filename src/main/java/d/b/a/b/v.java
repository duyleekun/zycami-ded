/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.e$a;
import d.b.a.b.h;

public final class v
implements Runnable {
    private final /* synthetic */ h a;
    private final /* synthetic */ e$a b;

    public v(e$a e$a, h h10) {
        this.b = e$a;
        this.a = h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object = e$a.a(this.b);
        synchronized (object) {
            Object object2 = this.b;
            object2 = e$a.e((e$a)object2);
            if (object2 != null) {
                object2 = this.b;
                object2 = e$a.e((e$a)object2);
                h h10 = this.a;
                object2.a(h10);
            }
            return;
        }
    }
}

