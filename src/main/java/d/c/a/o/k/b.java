/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.c;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.o.k.e;
import d.c.a.o.k.e$a;
import d.c.a.o.k.f;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import java.io.File;
import java.util.List;

public class b
implements e,
d$a {
    private final List a;
    private final f b;
    private final e$a c;
    private int d;
    private c e;
    private List f;
    private int g;
    private volatile n$a h;
    private File i;

    public b(f f10, e$a e$a) {
        List list = f10.c();
        this(list, f10, e$a);
    }

    public b(List list, f f10, e$a e$a) {
        this.d = -1;
        this.a = list;
        this.b = f10;
        this.c = e$a;
    }

    private boolean a() {
        int n10 = this.g;
        List list = this.f;
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean b() {
        while (true) {
            Object object;
            int n10;
            Object object2 = this.f;
            int n11 = 0;
            Priority priority = null;
            int n12 = 1;
            if (object2 != null && (n10 = this.a()) != 0) {
                n10 = 0;
                object2 = null;
                this.h = null;
                while (n11 == 0 && (n10 = (int)(this.a() ? 1 : 0)) != 0) {
                    d.c.a.o.f f10;
                    f f11;
                    int n13;
                    int n14;
                    object2 = this.f;
                    int n15 = this.g;
                    this.g = n14 = n15 + 1;
                    object2 = (n)object2.get(n15);
                    object = this.i;
                    f f12 = this.b;
                    n14 = f12.s();
                    this.h = object2 = object2.b(object, n14, n13 = (f11 = this.b).f(), f10 = this.b.k());
                    if ((object2 = this.h) == null || (n10 = (int)(((f)(object2 = this.b)).t((Class)(object = this.h.c.a())) ? 1 : 0)) == 0) continue;
                    object2 = this.h.c;
                    priority = this.b.l();
                    object2.d(priority, this);
                    n11 = n12;
                }
                return n11 != 0;
            }
            this.d = n10 = this.d + n12;
            Object object3 = this.a;
            n12 = object3.size();
            if (n10 >= n12) {
                return false;
            }
            object2 = this.a;
            n12 = this.d;
            object2 = (c)object2.get(n12);
            object = this.b.o();
            object3 = new d.c.a.o.k.c((c)object2, (c)object);
            object = this.b.d();
            this.i = object3 = object.b((c)object3);
            if (object3 == null) continue;
            this.e = object2;
            this.f = object2 = this.b.j((File)object3);
            this.g = 0;
        }
    }

    public void c(Exception exception) {
        e$a e$a = this.c;
        c c10 = this.e;
        d d10 = this.h.c;
        DataSource dataSource = DataSource.DATA_DISK_CACHE;
        e$a.a(c10, exception, d10, dataSource);
    }

    public void cancel() {
        Object object = this.h;
        if (object != null) {
            object = ((n$a)object).c;
            object.cancel();
        }
    }

    public void e(Object object) {
        e$a e$a = this.c;
        c c10 = this.e;
        d d10 = this.h.c;
        DataSource dataSource = DataSource.DATA_DISK_CACHE;
        c c11 = this.e;
        e$a.e(c10, object, d10, dataSource, c11);
    }
}

