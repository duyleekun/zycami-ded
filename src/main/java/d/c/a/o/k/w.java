/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.a;
import d.c.a.o.c;
import d.c.a.o.k.b;
import d.c.a.o.k.d;
import d.c.a.o.k.e;
import d.c.a.o.k.e$a;
import d.c.a.o.k.f;
import d.c.a.o.k.h;
import d.c.a.o.k.w$a;
import d.c.a.o.k.y.a$b;
import d.c.a.o.l.n$a;
import d.c.a.u.g;
import java.util.Collections;
import java.util.List;

public class w
implements e,
e$a {
    private static final String h = "SourceGenerator";
    private final f a;
    private final e$a b;
    private int c;
    private b d;
    private Object e;
    private volatile n$a f;
    private d.c.a.o.k.c g;

    public w(f f10, e$a e$a) {
        this.a = f10;
        this.b = e$a;
    }

    private void d(Object object) {
        Object object2;
        block29: {
            object2 = h;
            long l10 = d.c.a.u.g.b();
            Object object3 = this.a;
            object3 = ((f)object3).p(object);
            Object object4 = this.a;
            object4 = ((f)object4).k();
            Object object5 = new d((a)object3, object, (d.c.a.o.f)object4);
            Object object6 = this.f;
            object6 = ((n$a)object6).a;
            Object object7 = this.a;
            object7 = ((f)object7).o();
            object4 = new d.c.a.o.k.c((c)object6, (c)object7);
            this.g = object4;
            object4 = this.a;
            object4 = ((f)object4).d();
            object6 = this.g;
            object4.a((c)object6, (a$b)object5);
            int n10 = 2;
            n10 = (int)(Log.isLoggable((String)object2, (int)n10) ? 1 : 0);
            if (n10 == 0) break block29;
            object5 = new StringBuilder();
            object4 = "Finished encoding source to cache, key: ";
            ((StringBuilder)object5).append((String)object4);
            object4 = this.g;
            ((StringBuilder)object5).append(object4);
            object4 = ", data: ";
            ((StringBuilder)object5).append((String)object4);
            ((StringBuilder)object5).append(object);
            object = ", encoder: ";
            ((StringBuilder)object5).append((String)object);
            ((StringBuilder)object5).append(object3);
            object = ", duration: ";
            ((StringBuilder)object5).append((String)object);
            double d10 = d.c.a.u.g.a(l10);
            ((StringBuilder)object5).append(d10);
            object = ((StringBuilder)object5).toString();
            Log.v((String)object2, (String)object);
        }
        object2 = Collections.singletonList(this.f.a);
        f f10 = this.a;
        this.d = object = new b((List)object2, f10, this);
        return;
        finally {
            this.f.c.b();
        }
    }

    private boolean f() {
        int n10 = this.c;
        List list = this.a.g();
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    private void j(n$a n$a) {
        d.c.a.o.j.d d10 = this.f.c;
        Priority priority = this.a.l();
        w$a w$a = new w$a(this, n$a);
        d10.d(priority, w$a);
    }

    public void a(c c10, Exception exception, d.c.a.o.j.d d10, DataSource object) {
        object = this.b;
        DataSource dataSource = this.f.c.getDataSource();
        object.a(c10, exception, d10, dataSource);
    }

    public boolean b() {
        boolean bl2;
        Object object = this.e;
        boolean bl3 = false;
        Object object2 = null;
        if (object != null) {
            this.e = null;
            this.d(object);
        }
        object = this.d;
        boolean bl4 = true;
        if (object != null && (bl2 = ((b)object).b())) {
            return bl4;
        }
        this.d = null;
        this.f = null;
        bl2 = false;
        object = null;
        while (!bl2 && (bl3 = this.f())) {
            Object object3;
            int n10;
            object2 = this.a.g();
            int n11 = this.c;
            this.c = n10 = n11 + 1;
            this.f = object2 = (n$a)object2.get(n11);
            if ((object2 = this.f) == null || !(bl3 = ((h)(object2 = this.a.e())).c((DataSource)((Object)(object3 = this.f.c.getDataSource())))) && !(bl3 = ((f)(object2 = this.a)).t((Class)(object3 = this.f.c.a())))) continue;
            object = this.f;
            this.j((n$a)object);
            bl2 = bl4;
        }
        return bl2;
    }

    public void c() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void cancel() {
        Object object = this.f;
        if (object != null) {
            object = ((n$a)object).c;
            object.cancel();
        }
    }

    public void e(c c10, Object object, d.c.a.o.j.d d10, DataSource dataSource, c c11) {
        e$a e$a = this.b;
        DataSource dataSource2 = this.f.c.getDataSource();
        e$a.e(c10, object, d10, dataSource2, c10);
    }

    public boolean g(n$a n$a) {
        boolean bl2;
        n$a n$a2 = this.f;
        if (n$a2 != null && n$a2 == n$a) {
            bl2 = true;
        } else {
            bl2 = false;
            n$a = null;
        }
        return bl2;
    }

    public void h(n$a object, Object object2) {
        Object object3;
        boolean bl2;
        Object object4 = this.a.e();
        if (object2 != null && (bl2 = ((h)object4).c((DataSource)((Object)(object3 = ((n$a)object).c.getDataSource()))))) {
            this.e = object2;
            object = this.b;
            object.c();
        } else {
            object4 = this.b;
            object3 = ((n$a)object).a;
            d.c.a.o.j.d d10 = ((n$a)object).c;
            DataSource dataSource = d10.getDataSource();
            d.c.a.o.k.c c10 = this.g;
            object4.e((c)object3, object2, d10, dataSource, c10);
        }
    }

    public void i(n$a object, Exception exception) {
        e$a e$a = this.b;
        d.c.a.o.k.c c10 = this.g;
        object = ((n$a)object).c;
        DataSource dataSource = object.getDataSource();
        e$a.a(c10, exception, (d.c.a.o.j.d)object, dataSource);
    }
}

