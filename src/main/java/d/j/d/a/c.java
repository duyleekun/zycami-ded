/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a;

import d.j.d.a.b;
import java.util.Iterator;

public class c {
    private d.j.d.a.o.c a;

    public c() {
        d.j.d.a.o.c c10;
        this.a = c10 = new d.j.d.a.o.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Iterator iterator2 = this.a;
        boolean bl2 = ((d.j.d.a.o.c)iterator2).c;
        if (bl2) {
            return;
        }
        Object object = ((d.j.d.a.o.c)iterator2).b;
        synchronized (object) {
            boolean bl3;
            ((d.j.d.a.o.c)iterator2).c = bl3 = true;
            iterator2 = ((d.j.d.a.o.c)iterator2).a;
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                object2 = (Runnable)object2;
                object2.run();
            }
            return;
        }
    }

    public b b() {
        return this.a;
    }
}

