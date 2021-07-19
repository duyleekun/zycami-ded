/*
 * Decompiled with CFR 0.151.
 */
package d.c.a;

import d.c.a.f$c;
import d.c.a.u.m;
import java.util.Queue;

public final class f$d {
    public final Queue a;

    public f$d(int n10) {
        Queue queue;
        this.a = queue = m.f(n10);
        queue = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Queue queue2 = this.a;
            f$c f$c = new f$c();
            queue2.offer(f$c);
        }
    }

    public f$c a(int n10, int n11) {
        f$c f$c = (f$c)this.a.poll();
        this.a.offer(f$c);
        f$c.b = n10;
        f$c.a = n11;
        return f$c;
    }
}

