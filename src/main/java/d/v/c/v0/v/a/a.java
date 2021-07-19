/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.a;

import androidx.lifecycle.LiveData;
import d.v.c.v0.v.a.a$a;
import d.v.c.v0.v.a.b;
import d.v.c.v0.v.c.s;
import d.v.e.l.c1;
import java.util.Map;

public class a
implements b {
    private static volatile a d;
    private final s a;
    private final d.v.c.v0.v.e.a b;
    private c1 c;

    private a(c1 object) {
        this.c = object;
        this.a = object = s.p();
        this.b = object = d.v.c.v0.v.e.a.a();
    }

    public static /* synthetic */ s r(a a10) {
        return a10.a;
    }

    public static /* synthetic */ d.v.c.v0.v.e.a s(a a10) {
        return a10.b;
    }

    private LiveData t(boolean bl2) {
        c1 c12 = this.c;
        a$a a$a = new a$a(this, c12, bl2);
        return a$a.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a u(c1 c12) {
        Object object = d;
        if (object != null) return d;
        object = a.class;
        synchronized (object) {
            a a10 = d;
            if (a10 != null) return d;
            d = a10 = new a(c12);
            return d;
        }
    }

    public LiveData b(boolean bl2, Map map) {
        return this.t(bl2);
    }

    public void d() {
    }

    public void release() {
    }
}

