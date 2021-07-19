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
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class t
extends a {
    public final Iterable a;

    public t(Iterable iterable) {
        this.a = iterable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void L0(d d10) {
        AtomicThrowable atomicThrowable;
        Object object;
        Object object2;
        Object object3 = new e.a.s0.a();
        d10.onSubscribe((b)object3);
        try {
            object2 = this.a;
            object2 = object2.iterator();
            object = "The source iterator returned is null";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (Iterator)object2;
            int n10 = 1;
            object = new AtomicInteger(n10);
            atomicThrowable = new AtomicThrowable();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            d10.onError(throwable);
            return;
        }
        while (true) {
            Object object4;
            Object object5;
            boolean bl2;
            if (bl2 = ((e.a.s0.a)object3).isDisposed()) {
                return;
            }
            try {
                bl2 = object2.hasNext();
                if (!bl2) break;
                bl2 = ((e.a.s0.a)object3).isDisposed();
                if (bl2) {
                    return;
                }
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                atomicThrowable.addThrowable(throwable);
                break;
            }
            try {
                object5 = object2.next();
                object4 = "The iterator returned a null CompletableSource";
                object5 = e.a.w0.b.a.g(object5, (String)object4);
                object5 = (g)object5;
                boolean bl3 = ((e.a.s0.a)object3).isDisposed();
                if (bl3) {
                    return;
                }
                ((AtomicInteger)object).getAndIncrement();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                atomicThrowable.addThrowable(throwable);
                break;
            }
            object4 = new s$a(d10, (e.a.s0.a)object3, atomicThrowable, (AtomicInteger)object);
            object5.f((d)object4);
        }
        int n11 = ((AtomicInteger)object).decrementAndGet();
        if (n11 != 0) return;
        object3 = atomicThrowable.terminate();
        if (object3 == null) {
            d10.onComplete();
            return;
        }
        d10.onError((Throwable)object3);
        return;
    }
}

