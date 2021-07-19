/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.a1.a;
import e.a.l0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a$a
implements l0 {
    public final e.a.s0.a a;
    public final l0 b;
    public final AtomicBoolean c;
    public b d;

    public a$a(l0 l02, e.a.s0.a a10, AtomicBoolean atomicBoolean) {
        this.b = l02;
        this.a = a10;
        this.c = atomicBoolean;
    }

    public void onError(Throwable throwable) {
        Object object = this.c;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.a;
            b10 = this.d;
            ((e.a.s0.a)object).c(b10);
            this.a.dispose();
            object = this.b;
            object.onError(throwable);
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.d = b10;
        this.a.b(b10);
    }

    public void onSuccess(Object object) {
        Object object2 = this.c;
        b b10 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object2).compareAndSet(false, bl2);
        if (bl3) {
            object2 = this.a;
            b10 = this.d;
            ((e.a.s0.a)object2).c(b10);
            this.a.dispose();
            object2 = this.b;
            object2.onSuccess(object);
        }
    }
}

