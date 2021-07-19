/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.a;
import e.a.w0.e.g.n$a;
import java.util.concurrent.atomic.AtomicInteger;

public final class n
extends i0 {
    public final o0 a;
    public final o0 b;

    public n(o0 o02, o0 o03) {
        this.a = o02;
        this.b = o03;
    }

    public void e1(l0 l02) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objectArray = new Object[]{null, null};
        a a10 = new a();
        l02.onSubscribe(a10);
        o0 o02 = this.a;
        n$a n$a = new n$a(0, a10, objectArray, l02, atomicInteger);
        o02.f(n$a);
        o02 = this.b;
        n$a = new n$a(1, a10, objectArray, l02, atomicInteger);
        o02.f(n$a);
    }
}

