/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w;

import androidx.lifecycle.LiveData;
import d.v.c.v0.w.a$a;
import d.v.c.v0.w.b.h;
import k.d;

public class a {
    private static volatile a c;
    private final h a;
    private final d.v.c.v0.w.c.a b;

    private a(h h10, d.v.c.v0.w.c.a a10) {
        this.a = h10;
        this.b = a10;
    }

    public static /* synthetic */ h a(a a10) {
        return a10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a b(h h10, d.v.c.v0.w.c.a a10) {
        Object object = c;
        if (object != null) return c;
        object = a.class;
        synchronized (object) {
            a a11 = c;
            if (a11 != null) return c;
            c = a11 = new a(h10, a10);
            return c;
        }
    }

    public LiveData c() {
        return this.a.u();
    }

    public void d(int n10) {
        this.b.b(n10);
    }

    public void e() {
        d d10 = this.b.c();
        a$a a$a = new a$a(this);
        d10.h(a$a);
    }
}

