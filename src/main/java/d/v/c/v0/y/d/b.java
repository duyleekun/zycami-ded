/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.y.d;

import androidx.lifecycle.LiveData;
import d.v.c.v0.y.b.e;
import d.v.c.v0.y.d.a;
import d.v.c.v0.y.d.b$a;
import d.v.c.v0.y.d.b$b;
import d.v.e.l.c1;
import java.util.Map;

public class b
implements a {
    private final e a;
    private final d.v.c.v0.y.c.a b;
    private final c1 c;

    public b() {
        Object object = e.l();
        this.a = object;
        this.b = object = d.v.c.v0.y.c.a.a();
        this.c = object = c1.b();
    }

    public static /* synthetic */ e r(b b10) {
        return b10.a;
    }

    public static /* synthetic */ d.v.c.v0.y.c.a s(b b10) {
        return b10.b;
    }

    private LiveData t() {
        c1 c12 = this.c;
        b$a b$a = new b$a(this, c12);
        return b$a.d();
    }

    public static b u() {
        return b$b.a();
    }

    public LiveData b(boolean bl2, Map map) {
        return null;
    }

    public LiveData c() {
        return this.t();
    }

    public void d() {
    }

    public void release() {
    }
}

