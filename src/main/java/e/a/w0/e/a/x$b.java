/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class x$b
implements d {
    private final e.a.s0.a a;
    private final AtomicBoolean b;
    private final d c;

    public x$b(e.a.s0.a a10, AtomicBoolean atomicBoolean, d d10) {
        this.a = a10;
        this.b = atomicBoolean;
        this.c = d10;
    }

    public void onComplete() {
        Object object = this.b;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.a.dispose();
            object = this.c;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.a.dispose();
            object = this.c;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.a.b(b10);
    }
}

