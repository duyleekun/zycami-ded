/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.w.g;
import java.util.Iterator;
import java.util.concurrent.PriorityBlockingQueue;

public class h {
    private final PriorityBlockingQueue a;

    public h() {
        PriorityBlockingQueue priorityBlockingQueue;
        this.a = priorityBlockingQueue = new PriorityBlockingQueue();
    }

    public void a(g g10) {
        this.a.add(g10);
    }

    public boolean b() {
        return this.a.isEmpty();
    }

    public boolean c(g g10) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            g g11 = (g)iterator2.next();
            if (g11 != g10) continue;
            return this.a.remove(g11);
        }
        return false;
    }

    public g d() {
        return (g)this.a.take();
    }

    public g e() {
        return (g)this.a.poll();
    }
}

