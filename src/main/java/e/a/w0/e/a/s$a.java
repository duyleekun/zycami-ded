/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class s$a
implements d {
    public final d a;
    public final e.a.s0.a b;
    public final AtomicThrowable c;
    public final AtomicInteger d;

    public s$a(d d10, e.a.s0.a a10, AtomicThrowable atomicThrowable, AtomicInteger atomicInteger) {
        this.a = d10;
        this.b = a10;
        this.c = atomicThrowable;
        this.d = atomicInteger;
    }

    public void a() {
        Object object = this.d;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = this.c.terminate();
            if (object == null) {
                object = this.a;
                object.onComplete();
            } else {
                d d10 = this.a;
                d10.onError((Throwable)object);
            }
        }
    }

    public void onComplete() {
        this.a();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.c;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            this.a();
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.b.b(b10);
    }
}

