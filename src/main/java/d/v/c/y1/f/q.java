/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import d.v.c.k1.b.a;
import d.v.c.v0.q.c;

public class q
extends c {
    private a f;
    private boolean g;
    private boolean h;

    public a G() {
        return this.f;
    }

    public boolean H() {
        return this.h;
    }

    public boolean I() {
        return this.g;
    }

    public q J(boolean bl2) {
        this.h = bl2;
        this.notifyPropertyChanged(92);
        return this;
    }

    public q K(a a10) {
        this.f = a10;
        return this;
    }

    public q L(boolean bl2) {
        this.g = bl2;
        this.notifyPropertyChanged(93);
        return this;
    }

    public long x() {
        return this.G().f();
    }
}

