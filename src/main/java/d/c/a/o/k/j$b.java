/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.k.j;
import d.c.a.o.k.j$e;
import d.c.a.o.k.n;
import d.c.a.s.h;

public class j$b
implements Runnable {
    private final h a;
    public final /* synthetic */ j b;

    public j$b(j j10, h h10) {
        this.b = j10;
        this.a = h10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = this.a.f();
        synchronized (object) {
            j j10 = this.b;
            synchronized (j10) {
                Object object2 = this.b;
                object2 = ((j)object2).a;
                h h10 = this.a;
                boolean bl2 = ((j$e)object2).b(h10);
                if (bl2) {
                    object2 = this.b;
                    object2 = ((j)object2).v;
                    ((n)object2).a();
                    object2 = this.b;
                    h10 = this.a;
                    ((j)object2).g(h10);
                    object2 = this.b;
                    h10 = this.a;
                    ((j)object2).s(h10);
                }
                object2 = this.b;
                ((j)object2).i();
                return;
            }
        }
    }
}

