/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0.l;

import d.v.k0.f.c.e;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a
implements e {
    private final ConcurrentLinkedQueue a;

    public a() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.a = concurrentLinkedQueue = new ConcurrentLinkedQueue();
    }

    public d.v.k0.f.d.a a() {
        return (d.v.k0.f.d.a)this.a.poll();
    }

    public void b(List list) {
        this.a.addAll(list);
    }

    public void c(d.v.k0.f.d.a a10) {
        this.a.offer(a10);
    }

    public void clear() {
        this.a.clear();
    }
}

