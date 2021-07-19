/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.n.a.d;

import d.c.a.n.a.d.k;
import d.c.a.o.k.o;
import d.c.a.o.m.f.b;

public class m
extends b
implements o {
    public m(k k10) {
        super(k10);
    }

    public void a() {
        ((k)this.a).e().prepareToDraw();
    }

    public Class b() {
        return k.class;
    }

    public int getSize() {
        return ((k)this.a).l();
    }

    public void recycle() {
        ((k)this.a).stop();
        ((k)this.a).o();
    }
}

