/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.h;

import d.c.a.o.k.o;
import d.c.a.o.m.f.b;
import d.c.a.o.m.h.c;

public class e
extends b
implements o {
    public e(c c10) {
        super(c10);
    }

    public void a() {
        ((c)this.a).e().prepareToDraw();
    }

    public Class b() {
        return c.class;
    }

    public int getSize() {
        return ((c)this.a).j();
    }

    public void recycle() {
        ((c)this.a).stop();
        ((c)this.a).m();
    }
}

