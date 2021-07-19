/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.o.h;
import d.c.a.r.f$a;
import java.util.ArrayList;
import java.util.List;

public class f {
    private final List a;

    public f() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void a(Class clazz, h h10) {
        synchronized (this) {
            List list = this.a;
            f$a f$a = new f$a(clazz, h10);
            list.add(f$a);
            return;
        }
    }

    public h b(Class object) {
        synchronized (this) {
            int n10;
            List list = this.a;
            try {
                n10 = list.size();
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = this.a;
                object2 = object2.get(i10);
                object2 = (f$a)object2;
                boolean bl2 = ((f$a)object2).a((Class)object);
                if (!bl2) continue;
                object = ((f$a)object2).b;
                return object;
            }
            return null;
        }
    }

    public void c(Class clazz, h h10) {
        synchronized (this) {
            List list = this.a;
            f$a f$a = new f$a(clazz, h10);
            list.add(0, f$a);
            return;
        }
    }
}

