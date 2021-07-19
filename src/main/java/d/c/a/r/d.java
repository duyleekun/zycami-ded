/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import d.c.a.u.j;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class d {
    private final AtomicReference a;
    private final ArrayMap b;

    public d() {
        Object object = new AtomicReference();
        this.a = object;
        this.b = object = new ArrayMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        ArrayMap arrayMap = this.b;
        synchronized (arrayMap) {
            ArrayMap arrayMap2 = this.b;
            arrayMap2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List b(Class object, Class object2, Class clazz) {
        j j10 = this.a.getAndSet(null);
        if (j10 == null) {
            j10 = new j((Class)object, (Class)object2, clazz);
        } else {
            j10.b((Class)object, (Class)object2, clazz);
        }
        object = this.b;
        synchronized (object) {
            object2 = this.b;
            object2 = ((SimpleArrayMap)object2).get(j10);
            object2 = (List)object2;
        }
        this.a.set(j10);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(Class clazz, Class clazz2, Class clazz3, List list) {
        ArrayMap arrayMap = this.b;
        synchronized (arrayMap) {
            ArrayMap arrayMap2 = this.b;
            j j10 = new j(clazz, clazz2, clazz3);
            arrayMap2.put(j10, list);
            return;
        }
    }
}

