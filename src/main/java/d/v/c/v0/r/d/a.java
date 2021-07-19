/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.r.d;

import androidx.lifecycle.LiveData;
import d.v.c.v0.r.b.g;
import d.v.c.v0.r.d.a$a;
import d.v.c.v0.r.d.a$b;
import d.v.c.v0.r.d.b;
import d.v.e.l.c1;
import java.util.Map;

public class a
implements b {
    private g a;
    private d.v.c.v0.r.c.a b;
    private c1 c;

    public a() {
        Object object = g.k();
        this.a = object;
        this.b = object = d.v.c.v0.r.c.a.a();
        this.c = object = c1.b();
    }

    public static /* synthetic */ g r(a a10) {
        return a10.a;
    }

    public static /* synthetic */ d.v.c.v0.r.c.a s(a a10) {
        return a10.b;
    }

    private LiveData t() {
        c1 c12 = this.c;
        a$a a$a = new a$a(this, c12);
        return a$a.d();
    }

    public static a u() {
        return a$b.a();
    }

    public LiveData b(boolean bl2, Map map) {
        return null;
    }

    public LiveData c() {
        return this.t();
    }

    public void d() {
    }

    public LiveData i() {
        return this.a.r();
    }

    public void release() {
    }
}

