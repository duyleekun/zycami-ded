/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.i;

import d.c.a.o.m.i.e;
import d.c.a.o.m.i.f$a;
import d.c.a.o.m.i.g;
import java.util.ArrayList;
import java.util.List;

public class f {
    private final List a;

    public f() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public e a(Class object, Class clazz) {
        synchronized (this) {
            Object object2;
            boolean bl2;
            boolean bl3 = clazz.isAssignableFrom((Class<?>)object);
            if (bl3) {
                object = g.b();
                return object;
            }
            Object object3 = this.a;
            object3 = object3.iterator();
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                boolean bl4 = ((f$a)(object2 = (f$a)object2)).a((Class)object, clazz);
                if (!bl4) continue;
                object = ((f$a)object2).c;
                return object;
            }
            object2 = new StringBuilder();
            String string2 = "No transcoder registered to transcode from ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = " to ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(clazz);
            object = ((StringBuilder)object2).toString();
            object3 = new IllegalArgumentException((String)object);
            throw object3;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List b(Class clazz, Class clazz2) {
        synchronized (this) {
            void var2_2;
            ArrayList<void> arrayList = new ArrayList<void>();
            boolean bl2 = var2_2.isAssignableFrom(clazz);
            if (bl2) {
                arrayList.add(var2_2);
                return arrayList;
            }
            Object object = this.a;
            object = object.iterator();
            boolean bl3;
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                bl3 = ((f$a)(object2 = (f$a)object2)).a(clazz, (Class)var2_2);
                if (!bl3) continue;
                arrayList.add(var2_2);
            }
            return arrayList;
        }
    }

    public void c(Class clazz, Class clazz2, e e10) {
        synchronized (this) {
            List list = this.a;
            f$a f$a = new f$a(clazz, clazz2, e10);
            list.add(f$a);
            return;
        }
    }
}

