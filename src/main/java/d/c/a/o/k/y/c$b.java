/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.k.y.c$a;
import java.util.ArrayDeque;
import java.util.Queue;

public class c$b {
    private static final int b = 10;
    private final Queue a;

    public c$b() {
        ArrayDeque arrayDeque;
        this.a = arrayDeque = new ArrayDeque();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c$a a() {
        Object object;
        Queue queue = this.a;
        synchronized (queue) {
            object = this.a;
            object = object.poll();
            object = (c$a)object;
        }
        if (object != null) return object;
        return new c$a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(c$a c$a) {
        Queue queue = this.a;
        synchronized (queue) {
            Queue queue2 = this.a;
            int n10 = queue2.size();
            int n11 = 10;
            if (n10 < n11) {
                queue2 = this.a;
                queue2.offer(c$a);
            }
            return;
        }
    }
}

