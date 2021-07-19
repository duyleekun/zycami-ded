/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.c.a.u.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class q$a
implements d,
d$a {
    private final List a;
    private final Pools$Pool b;
    private int c;
    private Priority d;
    private d$a e;
    private List f;
    private boolean g;

    public q$a(List list, Pools$Pool pools$Pool) {
        this.b = pools$Pool;
        k.c(list);
        this.a = list;
        this.c = 0;
    }

    private void f() {
        int n10 = this.g;
        if (n10 != 0) {
            return;
        }
        n10 = this.c;
        Object object = this.a;
        int n11 = object.size() + -1;
        if (n10 < n11) {
            this.c = n10 = this.c + 1;
            Priority priority = this.d;
            object = this.e;
            this.d(priority, (d$a)object);
        } else {
            k.d(this.f);
            d$a d$a = this.e;
            Object object2 = this.f;
            ArrayList arrayList = new ArrayList(object2);
            object2 = "Fetch failed";
            object = new GlideException((String)object2, arrayList);
            d$a.c((Exception)object);
        }
    }

    public Class a() {
        return ((d)this.a.get(0)).a();
    }

    public void b() {
        boolean bl2;
        Object object;
        Object object2 = this.f;
        if (object2 != null) {
            object = this.b;
            object.release(object2);
        }
        this.f = null;
        object2 = this.a.iterator();
        while (bl2 = object2.hasNext()) {
            object = (d)object2.next();
            object.b();
        }
    }

    public void c(Exception exception) {
        ((List)k.d(this.f)).add(exception);
        this.f();
    }

    public void cancel() {
        boolean bl2;
        boolean bl3;
        this.g = bl3 = true;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            d10.cancel();
        }
    }

    public void d(Priority priority, d$a object) {
        this.d = priority;
        this.e = object;
        this.f = object = (List)this.b.acquire();
        object = this.a;
        int n10 = this.c;
        object = (d)object.get(n10);
        object.d(priority, this);
        boolean bl2 = this.g;
        if (bl2) {
            this.cancel();
        }
    }

    public void e(Object object) {
        if (object != null) {
            d$a d$a = this.e;
            d$a.e(object);
        } else {
            this.f();
        }
    }

    public DataSource getDataSource() {
        return ((d)this.a.get(0)).getDataSource();
    }
}

