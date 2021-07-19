/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.x;

import d.c.a.o.k.x.m;
import java.util.Queue;

public abstract class d {
    private static final int b = 20;
    private final Queue a;

    public d() {
        Queue queue;
        this.a = queue = d.c.a.u.m.f(20);
    }

    public abstract m a();

    public m b() {
        m m10 = (m)this.a.poll();
        if (m10 == null) {
            m10 = this.a();
        }
        return m10;
    }

    public void c(m m10) {
        int n10;
        Queue queue = this.a;
        int n11 = queue.size();
        if (n11 < (n10 = 20)) {
            queue = this.a;
            queue.offer(m10);
        }
    }
}

