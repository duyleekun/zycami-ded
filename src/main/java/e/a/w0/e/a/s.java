/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import e.a.w0.e.a.s$a;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class s
extends a {
    public final g[] a;

    public s(g[] gArray) {
        this.a = gArray;
    }

    public void L0(d d10) {
        Object object = new e.a.s0.a();
        int n10 = this.a.length + 1;
        AtomicInteger atomicInteger = new AtomicInteger(n10);
        AtomicThrowable atomicThrowable = new AtomicThrowable();
        d10.onSubscribe((b)object);
        for (g g10 : this.a) {
            Object object2;
            boolean bl2 = ((e.a.s0.a)object).isDisposed();
            if (bl2) {
                return;
            }
            if (g10 == null) {
                object2 = "A completable source is null";
                NullPointerException nullPointerException = new NullPointerException((String)object2);
                atomicThrowable.addThrowable(nullPointerException);
                atomicInteger.decrementAndGet();
                continue;
            }
            object2 = new s$a(d10, (e.a.s0.a)object, atomicThrowable, atomicInteger);
            g10.f((d)object2);
        }
        int n11 = atomicInteger.decrementAndGet();
        if (n11 == 0) {
            object = atomicThrowable.terminate();
            if (object == null) {
                d10.onComplete();
            } else {
                d10.onError((Throwable)object);
            }
        }
    }
}

