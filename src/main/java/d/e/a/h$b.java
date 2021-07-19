/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import d.e.a.h;
import d.e.a.m$a;
import java.util.concurrent.ConcurrentLinkedQueue;

public class h$b
implements m$a {
    public final /* synthetic */ h a;

    public h$b(h h10) {
        this.a = h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        Object object = h.a(this.a);
        synchronized (object) {
            Object object2 = this.a;
            h.b((h)object2, n10);
            int n11 = 10002;
            if (n10 == n11) {
                Object object3 = this.a;
                object3 = h.d((h)object3);
                object2 = this.a;
                object2 = h.c((h)object2);
                ((ConcurrentLinkedQueue)object3).addAll(object2);
                object3 = this.a;
                object3 = h.c((h)object3);
                ((ConcurrentLinkedQueue)object3).clear();
                object3 = this.a;
                ((h)object3).o();
            }
            return;
        }
    }
}

