/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.r.a$a;
import java.util.ArrayList;
import java.util.List;

public class a {
    private final List a;

    public a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void a(Class clazz, d.c.a.o.a a10) {
        synchronized (this) {
            List list = this.a;
            a$a a$a = new a$a(clazz, a10);
            list.add(a$a);
            return;
        }
    }

    public d.c.a.o.a b(Class object) {
        synchronized (this) {
            block11: {
                Object object2;
                Object object3 = this.a;
                object3 = object3.iterator();
                while (true) {
                    boolean bl2;
                    boolean bl3 = object3.hasNext();
                    if (!bl3) break block11;
                    object2 = object3.next();
                    object2 = (a$a)object2;
                    if (!(bl2 = ((a$a)object2).a((Class)object))) continue;
                    break;
                }
                try {
                    object = ((a$a)object2).b;
                    return object;
                }
                catch (Throwable throwable) {
                    throw throwable;
                }
                finally {
                }
            }
            return null;
        }
    }

    public void c(Class clazz, d.c.a.o.a a10) {
        synchronized (this) {
            List list = this.a;
            a$a a$a = new a$a(clazz, a10);
            list.add(0, a$a);
            return;
        }
    }
}

