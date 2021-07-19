/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.engine.DecodeJob$e;
import d.c.a.e;
import d.c.a.o.c;
import d.c.a.o.i;
import d.c.a.o.k.h;
import d.c.a.o.k.q;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.o.k.y.a;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class f {
    private final List a;
    private final List b;
    private e c;
    private Object d;
    private int e;
    private int f;
    private Class g;
    private DecodeJob$e h;
    private d.c.a.o.f i;
    private Map j;
    private Class k;
    private boolean l;
    private boolean m;
    private c n;
    private Priority o;
    private h p;
    private boolean q;
    private boolean r;

    public f() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.b = arrayList = new ArrayList();
    }

    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    public b b() {
        return this.c.b();
    }

    public List c() {
        boolean bl2 = this.m;
        if (!bl2) {
            this.m = bl2 = true;
            this.b.clear();
            List list = this.g();
            int n10 = list.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                n$a n$a = (n$a)list.get(i10);
                List list2 = this.b;
                Object object = n$a.a;
                int n12 = list2.contains(object);
                if (n12 == 0) {
                    list2 = this.b;
                    object = n$a.a;
                    list2.add(object);
                }
                list2 = null;
                for (n12 = 0; n12 < (n11 = (object = n$a.b).size()); ++n12) {
                    object = this.b;
                    Object e10 = n$a.b.get(n12);
                    n11 = (int)(object.contains(e10) ? 1 : 0);
                    if (n11 != 0) continue;
                    object = this.b;
                    e10 = n$a.b.get(n12);
                    object.add(e10);
                }
            }
        }
        return this.b;
    }

    public a d() {
        return this.h.a();
    }

    public h e() {
        return this.p;
    }

    public int f() {
        return this.f;
    }

    public List g() {
        boolean bl2 = this.l;
        if (!bl2) {
            this.l = bl2 = true;
            this.a.clear();
            Object object = this.c.h();
            Object object2 = this.d;
            object = ((Registry)object).i(object2);
            object2 = null;
            int n10 = object.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object3 = (n)object.get(i10);
                Object object4 = this.d;
                int n11 = this.e;
                int n12 = this.f;
                d.c.a.o.f f10 = this.i;
                if ((object3 = object3.b(object4, n11, n12, f10)) == null) continue;
                object4 = this.a;
                object4.add(object3);
            }
        }
        return this.a;
    }

    public q h(Class clazz) {
        Registry registry = this.c.h();
        Class clazz2 = this.g;
        Class clazz3 = this.k;
        return registry.h(clazz, clazz2, clazz3);
    }

    public Class i() {
        return this.d.getClass();
    }

    public List j(File file) {
        return this.c.h().i(file);
    }

    public d.c.a.o.f k() {
        return this.i;
    }

    public Priority l() {
        return this.o;
    }

    public List m() {
        Registry registry = this.c.h();
        Class<?> clazz = this.d.getClass();
        Class clazz2 = this.g;
        Class clazz3 = this.k;
        return registry.j(clazz, clazz2, clazz3);
    }

    public d.c.a.o.h n(s s10) {
        return this.c.h().k(s10);
    }

    public c o() {
        return this.n;
    }

    public d.c.a.o.a p(Object object) {
        return this.c.h().m(object);
    }

    public Class q() {
        return this.k;
    }

    public i r(Class object) {
        Object object2;
        Object object3 = (i)this.j.get(object);
        if (object3 == null) {
            boolean bl2;
            object2 = this.j.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Map.Entry entry = object2.next();
                Class clazz = (Class)entry.getKey();
                boolean bl3 = clazz.isAssignableFrom((Class<?>)object);
                if (!bl3) continue;
                object3 = (i)entry.getValue();
                break;
            }
        }
        if (object3 == null) {
            object3 = this.j;
            boolean bl4 = object3.isEmpty();
            if (bl4 && (bl4 = this.q)) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Missing transformation for ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(". If you wish to ignore unknown resource types, use the optional transformation methods.");
                object = ((StringBuilder)object2).toString();
                object3 = new IllegalArgumentException((String)object);
                throw object3;
            }
            return d.c.a.o.m.c.c();
        }
        return object3;
    }

    public int s() {
        return this.e;
    }

    public boolean t(Class object) {
        boolean bl2;
        if ((object = this.h((Class)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void u(e e10, Object object, c c10, int n10, int n11, h h10, Class clazz, Class clazz2, Priority priority, d.c.a.o.f f10, Map map, boolean bl2, boolean bl3, DecodeJob$e decodeJob$e) {
        this.c = e10;
        this.d = object;
        this.n = c10;
        this.e = n10;
        this.f = n11;
        this.p = h10;
        this.g = clazz;
        this.h = decodeJob$e;
        this.k = clazz2;
        this.o = priority;
        this.i = f10;
        this.j = map;
        this.q = bl2;
        this.r = bl3;
    }

    public boolean v(s s10) {
        return this.c.h().n(s10);
    }

    public boolean w() {
        return this.r;
    }

    public boolean x(c c10) {
        List list = this.g();
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            c c11 = ((n$a)list.get((int)i10)).a;
            boolean bl2 = c11.equals(c10);
            if (!bl2) continue;
            return true;
        }
        return false;
    }
}

