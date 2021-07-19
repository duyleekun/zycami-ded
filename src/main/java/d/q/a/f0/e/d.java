/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.f0.e;

import d.q.a.f0.e.a;
import d.q.a.f0.e.c;
import e.a.h0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d
implements b {
    private final AtomicBoolean a;

    public d() {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean();
    }

    public abstract void b();

    public final void dispose() {
        Object object = this.a;
        a a10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            bl3 = c.a();
            if (bl3) {
                this.b();
            } else {
                object = e.a.q0.c.a.c();
                a10 = new a(this);
                ((h0)object).e(a10);
            }
        }
    }

    public final boolean isDisposed() {
        return this.a.get();
    }
}

