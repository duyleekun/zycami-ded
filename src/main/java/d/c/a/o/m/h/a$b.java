/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.h;

import d.c.a.m.d;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.util.Queue;

public class a$b {
    private final Queue a;

    public a$b() {
        Queue queue;
        this.a = queue = m.f(0);
    }

    public d a(ByteBuffer object) {
        synchronized (this) {
            Object object2 = this.a;
            object2 = object2.poll();
            object2 = (d)object2;
            if (object2 == null) {
                object2 = new d();
            }
            object = ((d)object2).q((ByteBuffer)object);
            return object;
        }
    }

    public void b(d d10) {
        synchronized (this) {
            d10.a();
            Queue queue = this.a;
            queue.offer(d10);
            return;
        }
    }
}

