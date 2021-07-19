/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.p;

import d.c.a.p.h;
import d.c.a.p.i;
import d.c.a.u.m;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class a
implements h {
    private final Set a;
    private boolean b;
    private boolean c;

    public a() {
        Object object = new WeakHashMap();
        this.a = object = Collections.newSetFromMap(object);
    }

    public void a(i i10) {
        this.a.remove(i10);
    }

    public void b(i i10) {
        Set set = this.a;
        set.add(i10);
        boolean bl2 = this.c;
        if (bl2) {
            i10.onDestroy();
        } else {
            bl2 = this.b;
            if (bl2) {
                i10.onStart();
            } else {
                i10.onStop();
            }
        }
    }

    public void c() {
        boolean bl2;
        boolean bl3;
        this.c = bl3 = true;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            i i10 = (i)iterator2.next();
            i10.onDestroy();
        }
    }

    public void d() {
        boolean bl2;
        boolean bl3;
        this.b = bl3 = true;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            i i10 = (i)iterator2.next();
            i10.onStart();
        }
    }

    public void e() {
        boolean bl2;
        this.b = false;
        Iterator iterator2 = m.k(this.a).iterator();
        while (bl2 = iterator2.hasNext()) {
            i i10 = (i)iterator2.next();
            i10.onStop();
        }
    }
}

