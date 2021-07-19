/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.h;

import e.a.o;
import e.a.w0.c.n;
import e.a.w0.h.l;
import e.a.w0.i.b;
import e.a.w0.i.m;
import i.g.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class h
extends l
implements o,
m {
    public final d V;
    public final n W;
    public volatile boolean X;
    public volatile boolean Y;
    public Throwable Z;

    public h(d d10, n n10) {
        this.V = d10;
        this.W = n10;
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
        return this.Y;
    }

    public final boolean d() {
        return this.X;
    }

    public boolean e(d d10, Object object) {
        return false;
    }

    public final Throwable error() {
        return this.Z;
    }

    public final long f(long l10) {
        AtomicLong atomicLong = this.F;
        l10 = -l10;
        return atomicLong.addAndGet(l10);
    }

    public final boolean g() {
        AtomicInteger atomicInteger = this.p;
        int n10 = atomicInteger.get();
        int n11 = 1;
        if (n10 != 0 || (n10 = (int)((atomicInteger = this.p).compareAndSet(0, n11) ? 1 : 0)) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void h(Object object, boolean bl2, e.a.s0.b b10) {
        d d10 = this.V;
        n n10 = this.W;
        boolean bl3 = this.g();
        if (bl3) {
            long l10;
            long l11;
            AtomicLong atomicLong = this.F;
            long l12 = atomicLong.get();
            long l13 = l12 - (l11 = 0L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 == false) {
                b10.dispose();
                object = new MissingBackpressureException("Could not emit buffer due to lack of requests");
                d10.onError((Throwable)object);
                return;
            }
            int n11 = this.e(d10, object);
            if (n11 != 0 && (n11 = (int)((l10 = l12 - (l11 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
                l12 = 1L;
                this.f(l12);
            }
            if ((n11 = this.a(-1)) == 0) {
                return;
            }
        } else {
            n10.offer(object);
            boolean bl4 = this.b();
            if (!bl4) {
                return;
            }
        }
        e.a.w0.i.n.e(n10, d10, bl2, b10, this);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final void i(Object object, boolean bl2, e.a.s0.b b10) {
        d d10 = this.V;
        n n10 = this.W;
        boolean bl3 = this.g();
        if (bl3) {
            long l10;
            AtomicLong atomicLong = this.F;
            long l11 = atomicLong.get();
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                this.X = true;
                b10.dispose();
                object = new MissingBackpressureException("Could not emit buffer due to lack of requests");
                d10.onError((Throwable)object);
                return;
            }
            boolean bl4 = n10.isEmpty();
            if (bl4) {
                long l13;
                int n11 = this.e(d10, object);
                if (n11 != 0 && (n11 = (int)((l13 = l11 - (l10 = Long.MAX_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0) {
                    l11 = 1L;
                    this.f(l11);
                }
                if ((n11 = this.a(-1)) == 0) {
                    return;
                }
            } else {
                n10.offer(object);
            }
        } else {
            n10.offer(object);
            boolean bl5 = this.b();
            if (!bl5) {
                return;
            }
        }
        e.a.w0.i.n.e(n10, d10, bl2, b10, this);
    }

    public final void j(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.F;
            e.a.w0.i.b.a(atomicLong, l10);
        }
    }

    public final long requested() {
        return this.F.get();
    }
}

