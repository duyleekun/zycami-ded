/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import d.c.a.o.j.e;
import d.c.a.o.j.e$a;
import d.c.a.o.j.f$a;
import d.c.a.u.k;
import java.util.HashMap;
import java.util.Map;

public class f {
    private static final e$a b;
    private final Map a;

    static {
        f$a f$a = new f$a();
        b = f$a;
    }

    public f() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e a(Object object) {
        synchronized (this) {
            k.d(object);
            Object object2 = this.a;
            Object object3 = object.getClass();
            object2 = object2.get(object3);
            object2 = (e$a)object2;
            if (object2 == null) {
                boolean bl2;
                object3 = this.a;
                object3 = object3.values();
                object3 = object3.iterator();
                while (bl2 = object3.hasNext()) {
                    Class<?> clazz;
                    Object object4 = object3.next();
                    Class clazz2 = (object4 = (e$a)object4).a();
                    boolean bl3 = clazz2.isAssignableFrom(clazz = object.getClass());
                    if (!bl3) continue;
                    object2 = object4;
                    break;
                }
            }
            if (object2 != null) return object2.b(object);
            object2 = b;
            return object2.b(object);
        }
    }

    public void b(e$a e$a) {
        synchronized (this) {
            Map map = this.a;
            Class clazz = e$a.a();
            map.put(clazz, e$a);
            return;
        }
    }
}

