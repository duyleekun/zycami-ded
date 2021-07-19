/*
 * Decompiled with CFR 0.151.
 */
package d.v.l;

import d.c.a.s.d;

public abstract class f {
    private d a;

    public void a() {
        d d10 = this.a;
        if (d10 != null) {
            d10.pause();
            this.a.clear();
            d10 = null;
            this.a = null;
        }
    }

    public abstract void b();

    public abstract void c(Object var1);

    public final void d(d d10) {
        this.a = d10;
    }
}

