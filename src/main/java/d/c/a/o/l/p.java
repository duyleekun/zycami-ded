/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry$NoModelLoaderAvailableException;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.p$a;
import d.c.a.o.l.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p {
    private final r a;
    private final p$a b;

    public p(Pools$Pool pools$Pool) {
        r r10 = new r(pools$Pool);
        this(r10);
    }

    private p(r r10) {
        p$a p$a;
        this.b = p$a = new p$a();
        this.a = r10;
    }

    private static Class c(Object object) {
        return object.getClass();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private List f(Class clazz) {
        synchronized (this) {
            List list = this.b;
            list = ((p$a)((Object)list)).b(clazz);
            if (list == null) {
                list = this.a;
                list = ((r)((Object)list)).e(clazz);
                list = Collections.unmodifiableList(list);
                p$a p$a = this.b;
                p$a.c(clazz, list);
            }
            return list;
        }
    }

    private void j(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            o o10 = (o)object.next();
            o10.a();
        }
    }

    public void a(Class object, Class clazz, o o10) {
        synchronized (this) {
            r r10 = this.a;
            r10.b((Class)object, clazz, o10);
            object = this.b;
            ((p$a)object).a();
            return;
        }
    }

    public n b(Class object, Class clazz) {
        synchronized (this) {
            r r10 = this.a;
            object = r10.d((Class)object, clazz);
            return object;
        }
    }

    public List d(Class object) {
        synchronized (this) {
            r r10 = this.a;
            object = r10.g((Class)object);
            return object;
        }
    }

    public List e(Object object) {
        Object object2 = p.c(object);
        int n10 = (object2 = this.f((Class)object2)).isEmpty();
        if (n10 == 0) {
            n10 = object2.size();
            ArrayList<n> arrayList = Collections.emptyList();
            int n11 = 1;
            for (int i10 = 0; i10 < n10; ++i10) {
                n n12 = (n)object2.get(i10);
                boolean bl2 = n12.a(object);
                if (!bl2) continue;
                if (n11 != 0) {
                    n11 = n10 - i10;
                    arrayList = new ArrayList<n>(n11);
                    n11 = 0;
                }
                arrayList.add(n12);
            }
            n10 = (int)(arrayList.isEmpty() ? 1 : 0);
            if (n10 == 0) {
                return arrayList;
            }
            Registry$NoModelLoaderAvailableException registry$NoModelLoaderAvailableException = new Registry$NoModelLoaderAvailableException(object, (List)object2);
            throw registry$NoModelLoaderAvailableException;
        }
        object2 = new Registry$NoModelLoaderAvailableException(object);
        throw object2;
    }

    public void g(Class object, Class clazz, o o10) {
        synchronized (this) {
            r r10 = this.a;
            r10.i((Class)object, clazz, o10);
            object = this.b;
            ((p$a)object).a();
            return;
        }
    }

    public void h(Class object, Class clazz) {
        synchronized (this) {
            r r10 = this.a;
            object = r10.j((Class)object, clazz);
            this.j((List)object);
            object = this.b;
            ((p$a)object).a();
            return;
        }
    }

    public void i(Class object, Class clazz, o o10) {
        synchronized (this) {
            r r10 = this.a;
            object = r10.k((Class)object, clazz, o10);
            this.j((List)object);
            object = this.b;
            ((p$a)object).a();
            return;
        }
    }
}

