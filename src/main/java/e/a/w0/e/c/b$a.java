/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.a1.a;
import e.a.s0.b;
import e.a.t;
import java.util.concurrent.atomic.AtomicBoolean;

public final class b$a
implements t {
    public final t a;
    public final AtomicBoolean b;
    public final e.a.s0.a c;
    public b d;

    public b$a(t t10, e.a.s0.a a10, AtomicBoolean atomicBoolean) {
        this.a = t10;
        this.c = a10;
        this.b = atomicBoolean;
    }

    public void onComplete() {
        Object object = this.b;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.c;
            b10 = this.d;
            ((e.a.s0.a)object).c(b10);
            this.c.dispose();
            object = this.a;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        Object object = this.b;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.c;
            b10 = this.d;
            ((e.a.s0.a)object).c(b10);
            this.c.dispose();
            object = this.a;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.d = b10;
        this.c.b(b10);
    }

    public void onSuccess(Object object) {
        Object object2 = this.b;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object2).compareAndSet(false, bl2);
        if (bl3) {
            object2 = this.c;
            b10 = this.d;
            ((e.a.s0.a)object2).c(b10);
            this.c.dispose();
            object2 = this.a;
            object2.onSuccess(object);
        }
    }
}

