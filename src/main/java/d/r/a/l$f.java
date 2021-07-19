/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.a;
import d.r.a.h$d;
import d.r.a.u.s;

public final class l$f {
    private a a;
    private h$d b;
    public a c;
    public Runnable d;
    public Object[] e;

    public l$f(h$d h$d, a a10) {
        this.b = h$d;
        this.a = a10;
    }

    public final void a() {
        Runnable runnable = this.d;
        if (runnable == null) {
            s.a("PushClientManager", "task is null");
            return;
        }
        runnable.run();
    }

    public final void b(int n10, Object ... object) {
        this.e = object;
        object = this.c;
        if (object != null) {
            object.onStateChanged(n10);
        }
        if ((object = this.a) != null) {
            object.onStateChanged(n10);
        }
    }
}

