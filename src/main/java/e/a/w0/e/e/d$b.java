/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.w0.i.c;
import e.a.y;
import e.a.y0.d;
import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class d$b
extends d {
    private final BlockingQueue b;
    public final AtomicInteger c;

    public d$b() {
        Serializable serializable;
        this.b = serializable = new Serializable(1);
        this.c = serializable;
    }

    public void b(y object) {
        int n10;
        Object object2 = this.c;
        int n11 = ((AtomicInteger)object2).getAndSet(0);
        if (n11 == (n10 = 1) || (n11 = (int)(((y)object).h() ? 1 : 0)) == 0) {
            while ((n11 = (int)((object2 = this.b).offer(object) ? 1 : 0)) == 0) {
                object2 = (y)this.b.poll();
                if (object2 == null || (n10 = (int)(((y)object2).h() ? 1 : 0)) != 0) continue;
                object = object2;
            }
        }
    }

    public void c() {
        this.c.set(1);
    }

    public y d() {
        this.c();
        e.a.w0.i.c.b();
        return (y)this.b.take();
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        e.a.a1.a.Y(throwable);
    }
}

