/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.p;

import d.c.a.p.i;
import d.c.a.s.j.p;
import d.c.a.u.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class o
implements i {
    private final Set a;

    public o() {
        Object object = new WeakHashMap();
        this.a = object = Collections.newSetFromMap(object);
    }

    public void b() {
        this.a.clear();
    }

    public List c() {
        return m.k(this.a);
    }

    public void d(p p10) {
        this.a.add(p10);
    }

    public void e(p p10) {
        this.a.remove(p10);
    }

    public void onDestroy() {
        boolean bl2;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            p p10 = (p)iterator2.next();
            p10.onDestroy();
        }
    }

    public void onStart() {
        boolean bl2;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            p p10 = (p)iterator2.next();
            p10.onStart();
        }
    }

    public void onStop() {
        boolean bl2;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            p p10 = (p)iterator2.next();
            p10.onStop();
        }
    }
}

