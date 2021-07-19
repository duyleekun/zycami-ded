/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import d.c.a.o.k.g;
import d.c.a.o.k.q;
import d.c.a.u.j;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class c {
    private static final q c;
    private final ArrayMap a;
    private final AtomicReference b;

    static {
        q q10;
        List list = Collections.emptyList();
        d.c.a.o.m.i.g g10 = new d.c.a.o.m.i.g();
        Object object = new g(Object.class, Object.class, Object.class, list, g10, null);
        List<g> list2 = Collections.singletonList(object);
        object = q10;
        c = q10 = new q(Object.class, Object.class, Object.class, list2, null);
    }

    public c() {
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
        this.b = atomicReference = new AtomicReference();
    }

    private j b(Class clazz, Class clazz2, Class clazz3) {
        j j10 = this.b.getAndSet(null);
        if (j10 == null) {
            j10 = new j();
        }
        j10.b(clazz, clazz2, clazz3);
        return j10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public q a(Class object, Class object2, Class object3) {
        object = this.b((Class)object, (Class)object2, (Class)object3);
        object2 = this.a;
        synchronized (object2) {
            object3 = this.a;
            object3 = ((SimpleArrayMap)object3).get(object);
            object3 = (q)object3;
        }
        this.b.set(object);
        return object3;
    }

    public boolean c(q q10) {
        return c.equals(q10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Class clazz, Class clazz2, Class clazz3, q q10) {
        ArrayMap arrayMap = this.a;
        synchronized (arrayMap) {
            ArrayMap arrayMap2 = this.a;
            j j10 = new j(clazz, clazz2, clazz3);
            if (q10 == null) {
                q10 = c;
            }
            arrayMap2.put(j10, q10);
            return;
        }
    }
}

