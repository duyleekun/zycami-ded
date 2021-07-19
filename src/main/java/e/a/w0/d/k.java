/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.d.m;
import e.a.w0.i.j;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k
extends m
implements g0,
j {
    public final g0 F;
    public final n G;
    public volatile boolean H;
    public volatile boolean I;
    public Throwable J;

    public k(g0 g02, n n10) {
        this.F = g02;
        this.G = n10;
    }

    public final int a(int n10) {
        return this.p.addAndGet(n10);
    }

    public final boolean b() {
        AtomicInteger atomicInteger = this.p;
        int n10 = atomicInteger.getAndIncrement();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            atomicInteger = null;
        }
        return n10 != 0;
    }

    public final boolean c() {
        return this.I;
    }

    public final boolean d() {
        return this.H;
    }

    public void e(g0 g02, Object object) {
    }

    public final Throwable error() {
        return this.J;
    }

    public final boolean f() {
        AtomicInteger atomicInteger = this.p;
        int n10 = atomicInteger.get();
        int n11 = 1;
        if (n10 != 0 || (n10 = (int)((atomicInteger = this.p).compareAndSet(0, n11) ? 1 : 0)) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public final void g(Object object, boolean bl2, b b10) {
        int n10;
        g0 g02 = this.F;
        n n11 = this.G;
        AtomicInteger atomicInteger = this.p;
        int n12 = atomicInteger.get();
        if (n12 == 0 && (n12 = (int)((atomicInteger = this.p).compareAndSet(0, n10 = 1) ? 1 : 0)) != 0) {
            this.e(g02, object);
            int n13 = this.a(-1);
            if (n13 == 0) {
                return;
            }
        } else {
            n11.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        e.a.w0.i.n.d(n11, g02, bl2, b10, this);
    }

    public final void h(Object object, boolean bl2, b b10) {
        int n10;
        g0 g02 = this.F;
        n n11 = this.G;
        AtomicInteger atomicInteger = this.p;
        int n12 = atomicInteger.get();
        if (n12 == 0 && (n12 = (int)((atomicInteger = this.p).compareAndSet(0, n10 = 1) ? 1 : 0)) != 0) {
            n12 = (int)(n11.isEmpty() ? 1 : 0);
            if (n12 != 0) {
                this.e(g02, object);
                int n13 = this.a(-1);
                if (n13 == 0) {
                    return;
                }
            } else {
                n11.offer(object);
            }
        } else {
            n11.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        e.a.w0.i.n.d(n11, g02, bl2, b10, this);
    }
}

