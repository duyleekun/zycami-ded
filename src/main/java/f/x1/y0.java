/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.x1.e;
import f.x1.z;
import java.util.List;

public final class y0
extends e {
    private final List a;

    public y0(List list) {
        f0.p(list, "delegate");
        this.a = list;
    }

    public void add(int n10, Object object) {
        List list = this.a;
        n10 = z.X0(this, n10);
        list.add(n10, object);
    }

    public int b() {
        return this.a.size();
    }

    public Object c(int n10) {
        List list = this.a;
        n10 = z.W0(this, n10);
        return list.remove(n10);
    }

    public void clear() {
        this.a.clear();
    }

    public Object get(int n10) {
        List list = this.a;
        n10 = z.W0(this, n10);
        return list.get(n10);
    }

    public Object set(int n10, Object object) {
        List list = this.a;
        n10 = z.W0(this, n10);
        return list.set(n10, object);
    }
}

