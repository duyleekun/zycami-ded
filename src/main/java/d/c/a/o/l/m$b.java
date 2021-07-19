/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.u.m;
import java.util.Queue;

public final class m$b {
    private static final Queue d = m.f(0);
    private int a;
    private int b;
    private Object c;

    private m$b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static m$b a(Object object, int n10, int n11) {
        Queue queue = d;
        // MONITORENTER : queue
        Object object2 = queue.poll();
        object2 = (m$b)object2;
        // MONITOREXIT : queue
        if (object2 == null) {
            object2 = new Object();
        }
        super.b(object, n10, n11);
        return object2;
    }

    private void b(Object object, int n10, int n11) {
        this.c = object;
        this.b = n10;
        this.a = n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Queue queue = d;
        synchronized (queue) {
            queue.offer(this);
            return;
        }
    }

    public boolean equals(Object object) {
        int n10 = object instanceof m$b;
        boolean bl2 = false;
        if (n10 != 0) {
            Object object2;
            boolean bl3;
            object = (m$b)object;
            n10 = this.b;
            int n11 = ((m$b)object).b;
            if (n10 == n11 && (n10 = this.a) == (n11 = ((m$b)object).a) && (bl3 = (object2 = this.c).equals(object = ((m$b)object).c))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.a * 31;
        int n11 = this.b;
        n10 = (n10 + n11) * 31;
        n11 = this.c.hashCode();
        return n10 + n11;
    }
}

