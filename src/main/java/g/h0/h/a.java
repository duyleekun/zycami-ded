/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.h.c;

public abstract class a {
    private c a;
    private long b;
    private final String c;
    private final boolean d;

    public a(String string2, boolean bl2) {
        f0.p(string2, "name");
        this.c = string2;
        this.d = bl2;
        this.b = -1;
    }

    public /* synthetic */ a(String string2, boolean bl2, int n10, u u10) {
        if ((n10 &= 2) != 0) {
            bl2 = true;
        }
        this(string2, bl2);
    }

    public final boolean a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final long c() {
        return this.b;
    }

    public final c d() {
        return this.a;
    }

    public final void e(c object) {
        boolean bl2;
        f0.p(object, "queue");
        Object object2 = this.a;
        if (object2 == object) {
            return;
        }
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            this.a = object;
            return;
        }
        object2 = "task is in multiple queues".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public abstract long f();

    public final void g(long l10) {
        this.b = l10;
    }

    public final void h(c c10) {
        this.a = c10;
    }

    public String toString() {
        return this.c;
    }
}

