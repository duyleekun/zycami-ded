/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.c;

import d.v.k0.f.c.e;
import d.v.k0.f.d.a;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class d
implements e {
    private final BlockingQueue a;

    public d() {
        LinkedBlockingQueue linkedBlockingQueue;
        this.a = linkedBlockingQueue = new LinkedBlockingQueue();
    }

    public a a() {
        BlockingQueue blockingQueue = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return (a)blockingQueue.poll(30, timeUnit);
    }

    public void b(List list) {
    }

    public void c(a a10) {
        this.a.offer(a10);
    }

    public void clear() {
        this.a.clear();
    }
}

