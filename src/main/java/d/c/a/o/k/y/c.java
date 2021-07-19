/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.k.y.c$a;
import d.c.a.o.k.y.c$b;
import d.c.a.u.k;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private final Map a;
    private final c$b b;

    public c() {
        Object object = new HashMap();
        this.a = object;
        this.b = object = new c$b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        Object object;
        synchronized (this) {
            int n10;
            object = this.a;
            object = object.get(string2);
            object = (c$a)object;
            if (object == null) {
                object = this.b;
                object = ((c$b)object).a();
                Map map = this.a;
                map.put(string2, object);
            }
            ((c$a)object).b = n10 = ((c$a)object).b + 1;
        }
        ((c$a)object).a.lock();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        Object object2;
        synchronized (this) {
            object2 = this.a;
            object2 = object2.get(object);
            object2 = k.d(object2);
            object2 = (c$a)object2;
            int n10 = ((c$a)object2).b;
            int n11 = 1;
            if (n10 < n11) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Cannot release a lock that is not held, safeKey: ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
                object = ", interestedThreads: ";
                stringBuilder.append((String)object);
                int n12 = ((c$a)object2).b;
                stringBuilder.append(n12);
                object = stringBuilder.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
            ((c$a)object2).b = n10 -= n11;
            if (n10 == 0) {
                Object object3 = this.a;
                object3 = object3.remove(object);
                n11 = (int)((object3 = (c$a)object3).equals(object2) ? 1 : 0);
                if (n11 == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "Removed the wrong lock, expected to remove: ";
                    stringBuilder.append(string3);
                    stringBuilder.append(object2);
                    object2 = ", but actually removed: ";
                    stringBuilder.append((String)object2);
                    stringBuilder.append(object3);
                    object2 = ", safeKey: ";
                    stringBuilder.append((String)object2);
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                object = this.b;
                ((c$b)object).b((c$a)object3);
            }
        }
        ((c$a)object2).a.unlock();
    }
}

