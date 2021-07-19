/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.l0;
import e.a.s0.b;
import e.a.w0.b.a;
import java.util.concurrent.atomic.AtomicInteger;

public class n$a
implements l0 {
    public final int a;
    public final e.a.s0.a b;
    public final Object[] c;
    public final l0 d;
    public final AtomicInteger e;

    public n$a(int n10, e.a.s0.a a10, Object[] objectArray, l0 l02, AtomicInteger atomicInteger) {
        this.a = n10;
        this.b = a10;
        this.c = objectArray;
        this.d = l02;
        this.e = atomicInteger;
    }

    public void onError(Throwable throwable) {
        int n10;
        AtomicInteger atomicInteger;
        int n11;
        do {
            AtomicInteger atomicInteger2;
            if ((n11 = (atomicInteger2 = this.e).get()) < (n10 = 2)) continue;
            e.a.a1.a.Y(throwable);
            return;
        } while ((n11 = (int)((atomicInteger = this.e).compareAndSet(n11, n10) ? 1 : 0)) == 0);
        this.b.dispose();
        this.d.onError(throwable);
    }

    public void onSubscribe(b b10) {
        this.b.b(b10);
    }

    public void onSuccess(Object object) {
        int n10;
        Object object2 = this.c;
        int n11 = this.a;
        object2[n11] = object;
        object = this.e;
        int n12 = ((AtomicInteger)object).incrementAndGet();
        if (n12 == (n10 = 2)) {
            object = this.d;
            object2 = this.c;
            n11 = 0;
            Object object3 = object2[0];
            int n13 = 1;
            object2 = object2[n13];
            n10 = (int)(e.a.w0.b.a.c(object3, object2) ? 1 : 0);
            object2 = n10 != 0;
            object.onSuccess(object2);
        }
    }
}

