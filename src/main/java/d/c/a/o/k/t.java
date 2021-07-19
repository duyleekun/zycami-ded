/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.c;
import d.c.a.o.i;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.k.e;
import d.c.a.o.k.e$a;
import d.c.a.o.k.f;
import d.c.a.o.k.u;
import d.c.a.o.k.x.b;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.io.File;
import java.util.List;

public class t
implements e,
d$a {
    private final e$a a;
    private final f b;
    private int c;
    private int d = -1;
    private c e;
    private List f;
    private int g;
    private volatile n$a h;
    private File i;
    private u j;

    public t(f f10, e$a e$a) {
        this.b = f10;
        this.a = e$a;
    }

    private boolean a() {
        int n10 = this.g;
        List list = this.f;
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean b() {
        Class<File> clazz = this.b.c();
        int n10 = clazz.isEmpty();
        int n11 = 0;
        Class clazz2 = null;
        if (n10 != 0) {
            return false;
        }
        Object object = this.b.m();
        int n12 = object.isEmpty();
        if (n12 != 0) {
            clazz = File.class;
            object = this.b.q();
            boolean bl2 = clazz.equals(object);
            if (bl2) {
                return false;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to find any load path from ");
            clazz2 = this.b.i();
            ((StringBuilder)object).append(clazz2);
            ((StringBuilder)object).append(" to ");
            clazz2 = this.b.q();
            ((StringBuilder)object).append(clazz2);
            object = ((StringBuilder)object).toString();
            clazz = new IllegalStateException((String)object);
            throw clazz;
        }
        while (true) {
            u u10;
            Object object2;
            Object object3;
            int n13;
            Object object4 = this.f;
            int n14 = 1;
            if (object4 != null && (n12 = this.a()) != 0) {
                boolean bl3 = false;
                clazz = null;
                this.h = null;
                while (n11 == 0 && (bl3 = this.a())) {
                    clazz = this.f;
                    n10 = this.g;
                    this.g = n12 = n10 + 1;
                    clazz = (n)clazz.get(n10);
                    object = this.i;
                    object4 = this.b;
                    n12 = ((f)object4).s();
                    this.h = clazz = clazz.b(object, n12, n13 = ((f)(object3 = this.b)).f(), (d.c.a.o.f)(object2 = this.b.k()));
                    if ((clazz = this.h) == null || !(bl3 = ((f)((Object)(clazz = this.b))).t((Class)(object = this.h.c.a())))) continue;
                    clazz = this.h.c;
                    object = this.b.l();
                    clazz.d((Priority)((Object)object), (d$a)this);
                    n11 = n14;
                }
                return n11 != 0;
            }
            this.d = n12 = this.d + n14;
            n13 = object.size();
            if (n12 >= n13) {
                this.c = n12 = this.c + n14;
                n14 = clazz.size();
                if (n12 >= n14) {
                    return false;
                }
                this.d = 0;
            }
            n12 = this.c;
            object4 = (c)clazz.get(n12);
            n14 = this.d;
            Object object5 = object.get(n14);
            Object object6 = object5;
            object6 = (Class)object5;
            i i10 = this.b.r((Class)object6);
            object3 = this.b.b();
            c c10 = this.b.o();
            int n15 = this.b.s();
            int n16 = this.b.f();
            d.c.a.o.f f10 = this.b.k();
            object5 = u10;
            object2 = object4;
            this.j = u10 = new u((b)object3, (c)object4, c10, n15, n16, i10, (Class)object6, f10);
            object5 = this.b.d();
            object3 = this.j;
            this.i = object5 = object5.b((c)object3);
            if (object5 == null) continue;
            this.e = object4;
            this.f = object4 = this.b.j((File)object5);
            this.g = 0;
        }
    }

    public void c(Exception exception) {
        e$a e$a = this.a;
        u u10 = this.j;
        d d10 = this.h.c;
        DataSource dataSource = DataSource.RESOURCE_DISK_CACHE;
        e$a.a(u10, exception, d10, dataSource);
    }

    public void cancel() {
        Object object = this.h;
        if (object != null) {
            object = ((n$a)object).c;
            object.cancel();
        }
    }

    public void e(Object object) {
        e$a e$a = this.a;
        c c10 = this.e;
        d d10 = this.h.c;
        DataSource dataSource = DataSource.RESOURCE_DISK_CACHE;
        u u10 = this.j;
        e$a.e(c10, object, d10, dataSource, u10);
    }
}

