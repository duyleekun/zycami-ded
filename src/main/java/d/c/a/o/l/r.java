/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Registry$NoModelLoaderAvailableException;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r$a;
import d.c.a.o.l.r$b;
import d.c.a.o.l.r$c;
import d.c.a.u.k;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class r {
    private static final r$c e;
    private static final n f;
    private final List a;
    private final r$c b;
    private final Set c;
    private final Pools$Pool d;

    static {
        Object object = new r$c();
        e = object;
        f = object = new r$a();
    }

    public r(Pools$Pool pools$Pool) {
        r$c r$c = e;
        this(pools$Pool, r$c);
    }

    public r(Pools$Pool pools$Pool, r$c r$c) {
        AbstractCollection abstractCollection;
        this.a = abstractCollection = new AbstractCollection();
        this.c = abstractCollection;
        this.d = pools$Pool;
        this.b = r$c;
    }

    private void a(Class object, Class clazz, o o10, boolean bl2) {
        int n10;
        r$b r$b = new r$b((Class)object, clazz, o10);
        object = this.a;
        if (bl2) {
            n10 = object.size();
        } else {
            n10 = 0;
            clazz = null;
        }
        object.add(n10, r$b);
    }

    private n c(r$b r$b) {
        return (n)k.d(r$b.c.c(this));
    }

    private static n f() {
        return f;
    }

    private o h(r$b r$b) {
        return r$b.c;
    }

    public void b(Class clazz, Class clazz2, o o10) {
        synchronized (this) {
            boolean bl2 = true;
            this.a(clazz, clazz2, o10, bl2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public n d(Class object, Class object2) {
        synchronized (this) {
            Object object3;
            int n10;
            Serializable serializable;
            block11: {
                int n11;
                int n12;
                block10: {
                    try {
                        boolean bl2;
                        serializable = new ArrayList();
                        Object object4 = this.a;
                        object4 = object4.iterator();
                        n12 = 1;
                        n10 = 0;
                        while (bl2 = object4.hasNext()) {
                            Object object5 = object4.next();
                            Object object6 = this.c;
                            boolean bl3 = object6.contains(object5 = (r$b)object5);
                            if (bl3) {
                                n10 = n12;
                                continue;
                            }
                            bl3 = ((r$b)object5).b((Class)object, (Class)object3);
                            if (!bl3) continue;
                            object6 = this.c;
                            object6.add(object5);
                            object6 = this.c((r$b)object5);
                            serializable.add(object6);
                            object6 = this.c;
                            object6.remove(object5);
                        }
                        n11 = serializable.size();
                        if (n11 <= n12) break block10;
                        object = this.b;
                        object3 = this.d;
                        return ((r$c)object).a((List)((Object)serializable), (Pools$Pool)object3);
                    }
                    catch (Throwable throwable) {
                        object3 = this.c;
                        object3.clear();
                        throw throwable;
                    }
                }
                n11 = serializable.size();
                if (n11 != n12) break block11;
                object = serializable.get(0);
                return (n)object;
            }
            if (n10 != 0) {
                return r.f();
            }
            serializable = new Registry$NoModelLoaderAvailableException((Class)object, (Class)object3);
            throw serializable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List e(Class clazz) {
        synchronized (this) {
            try {
                ArrayList<Object> arrayList = new ArrayList<Object>();
                Object object = this.a;
                object = object.iterator();
                while (true) {
                    boolean bl2;
                    if (!(bl2 = object.hasNext())) {
                        return arrayList;
                    }
                    Object object2 = object.next();
                    Object object3 = this.c;
                    boolean bl3 = object3.contains(object2 = (r$b)object2);
                    if (bl3 || !(bl3 = ((r$b)object2).a(clazz))) continue;
                    object3 = this.c;
                    object3.add(object2);
                    object3 = this.c((r$b)object2);
                    arrayList.add(object3);
                    object3 = this.c;
                    object3.remove(object2);
                }
            }
            catch (Throwable throwable) {
                Set set = this.c;
                set.clear();
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List g(Class clazz) {
        synchronized (this) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object = this.a;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (r$b)object2;
                Class clazz2 = ((r$b)object2).b;
                boolean bl3 = arrayList.contains(clazz2);
                if (bl3 || !(bl3 = ((r$b)object2).a(clazz))) continue;
                object2 = ((r$b)object2).b;
                arrayList.add(object2);
            }
            return arrayList;
        }
    }

    public void i(Class clazz, Class clazz2, o o10) {
        synchronized (this) {
            this.a(clazz, clazz2, o10, false);
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List j(Class clazz, Class clazz2) {
        synchronized (this) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object = this.a;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                void var2_2;
                Object object2 = object.next();
                boolean bl3 = ((r$b)(object2 = (r$b)object2)).b(clazz, (Class)var2_2);
                if (!bl3) continue;
                object.remove();
                object2 = this.h((r$b)object2);
                arrayList.add(object2);
            }
            return arrayList;
        }
    }

    public List k(Class clazz, Class clazz2, o o10) {
        synchronized (this) {
            List list = this.j(clazz, clazz2);
            this.b(clazz, clazz2, o10);
            return list;
        }
    }
}

