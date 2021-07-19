/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a$a
implements d {
    public final AtomicBoolean a;
    public final e.a.s0.a b;
    public final d c;
    public b d;

    public a$a(AtomicBoolean atomicBoolean, e.a.s0.a a10, d d10) {
        this.a = atomicBoolean;
        this.b = a10;
        this.c = d10;
    }

    public void onComplete() {
        Object object = this.a;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.b;
            b10 = this.d;
            ((e.a.s0.a)object).c(b10);
            this.b.dispose();
            object = this.c;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.a;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.b;
            b10 = this.d;
            ((e.a.s0.a)object).c(b10);
            this.b.dispose();
            object = this.c;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.d = b10;
        this.b.b(b10);
    }
}

