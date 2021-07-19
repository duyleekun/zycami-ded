/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.x1.c;
import f.x1.z;
import java.util.List;

public class z0
extends c {
    private final List b;

    public z0(List list) {
        f0.p(list, "delegate");
        this.b = list;
    }

    public int b() {
        return this.b.size();
    }

    public Object get(int n10) {
        List list = this.b;
        n10 = z.W0(this, n10);
        return list.get(n10);
    }
}

