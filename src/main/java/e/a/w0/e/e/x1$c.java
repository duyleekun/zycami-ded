/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.o;
import e.a.w0.c.n;
import e.a.w0.d.k;
import e.a.w0.e.e.x1$a;
import e.a.w0.e.e.x1$b;
import e.a.w0.e.e.x1$d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class x1$c
extends k
implements b {
    public final e0 K;
    public final o L;
    public final int M;
    public final e.a.s0.a N;
    public b O;
    public final AtomicReference P;
    public final List Q;
    public final AtomicLong R;
    public final AtomicBoolean S;

    public x1$c(g0 serializable, e0 arrayList, o o10, int n10) {
        Object object = new MpscLinkedQueue();
        super((g0)((Object)serializable), (n)object);
        serializable = new AtomicReference();
        this.P = serializable;
        super();
        this.R = serializable;
        this.S = object = new AtomicBoolean();
        this.K = arrayList;
        this.L = o10;
        this.M = n10;
        arrayList = new ArrayList();
        this.N = arrayList;
        this.Q = arrayList = new ArrayList();
        ((AtomicLong)serializable).lazySet(1L);
    }

    public void dispose() {
        Object object = this.S;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this.P);
            object = this.R;
            long l10 = ((AtomicLong)object).decrementAndGet();
            long l11 = 0L;
            bl3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (!bl3) {
                object = this.O;
                object.dispose();
            }
        }
    }

    public void e(g0 g02, Object object) {
    }

    public void i(x1$a g02) {
        this.N.c((b)((Object)g02));
        n n10 = this.G;
        g02 = g02.c;
        x1$d x1$d = new x1$d((UnicastSubject)g02, null);
        n10.offer(x1$d);
        boolean bl2 = this.b();
        if (bl2) {
            this.l();
        }
    }

    public boolean isDisposed() {
        return this.S.get();
    }

    public void k() {
        this.N.dispose();
        DisposableHelper.dispose(this.P);
    }

    /*
     * Unable to fully structure code
     */
    public void l() {
        var1_1 = (MpscLinkedQueue)this.G;
        var2_2 = this.F;
        var3_3 = this.Q;
        var5_5 = var4_4 = true;
        block6: while (true) {
            var6_6 = this.I;
            var7_7 = var1_1.poll();
            if (var7_7 == null) {
                var8_8 = var4_4;
            } else {
                var8_8 = false;
                var9_9 = null;
            }
            if (var6_6 != 0 && var8_8) {
                this.k();
                var1_1 = this.J;
                if (var1_1 != null) {
                    var2_2 = var3_3.iterator();
                    while (var4_4 = (boolean)var2_2.hasNext()) {
                        var10_15 = (UnicastSubject)var2_2.next();
                        var10_15.onError((Throwable)var1_1);
                    }
                } else {
                    var1_1 = var3_3.iterator();
                    while (var11_16 = var1_1.hasNext()) {
                        var2_2 = (UnicastSubject)var1_1.next();
                        var2_2.onComplete();
                    }
                }
                var3_3.clear();
                return;
            }
            if (var8_8) {
                var5_5 = -var5_5;
                if (var5_5 = this.a((int)var5_5)) continue;
                return;
            }
            var6_6 = var7_7 instanceof x1$d;
            if (var6_6 != 0) {
                var7_7 = (x1$d)var7_7;
                var12_10 = var7_7.a;
                if (var12_10 != null) {
                    var6_6 = var3_3.remove(var12_10);
                    if (var6_6 == 0) continue;
                    var7_7.a.onComplete();
                    var12_10 = this.R;
                    var13_12 = var12_10.decrementAndGet();
                    cfr_temp_0 = var13_12 - (var15_13 = 0L);
                    var6_6 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var6_6 != 0) continue;
                    this.k();
                    return;
                }
                var12_10 = this.S;
                var6_6 = var12_10.get();
                if (var6_6 != 0) continue;
                var6_6 = this.M;
                var12_10 = UnicastSubject.n8(var6_6);
                var3_3.add(var12_10);
                var2_2.onNext(var12_10);
                var9_9 = this.L;
                var7_7 = var7_7.b;
                var7_7 = var9_9.apply(var7_7);
                var9_9 = "The ObservableSource supplied is null";
                var7_7 = e.a.w0.b.a.g(var7_7, (String)var9_9);
                try {
                    var7_7 = (e0)var7_7;
                }
                catch (Throwable var12_11) {
                    e.a.t0.a.b(var12_11);
                    var7_7 = this.S;
                    var7_7.set(var4_4);
                    var2_2.onError(var12_11);
                }
                var12_10 = this.N;
                var9_9 = new x1$a(this, (UnicastSubject)var12_10);
                var6_6 = (int)var12_10.b((b)var9_9);
                if (var6_6 == 0) continue;
                var12_10 = this.R;
                var12_10.getAndIncrement();
                var7_7.subscribe((g0)var9_9);
                continue;
            }
            var12_10 = var3_3.iterator();
            while (true) {
                if (var8_8 = (boolean)var12_10.hasNext()) ** break;
                continue block6;
                var9_9 = (UnicastSubject)var12_10.next();
                var17_14 = NotificationLite.getValue(var7_7);
                var9_9.onNext(var17_14);
            }
            break;
        }
    }

    public void m(Throwable throwable) {
        this.O.dispose();
        this.N.dispose();
        this.onError(throwable);
    }

    public void o(Object object) {
        n n10 = this.G;
        x1$d x1$d = new x1$d(null, object);
        n10.offer(x1$d);
        boolean bl2 = this.b();
        if (bl2) {
            this.l();
        }
    }

    public void onComplete() {
        long l10;
        Object object;
        long l11;
        long l12;
        boolean bl2 = this.I;
        if (bl2) {
            return;
        }
        this.I = true;
        bl2 = this.b();
        if (bl2) {
            this.l();
        }
        if (!(bl2 = (l12 = (l11 = ((AtomicLong)(object = this.R)).decrementAndGet()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = this.N;
            ((e.a.s0.a)object).dispose();
        }
        this.F.onComplete();
    }

    public void onError(Throwable throwable) {
        long l10;
        Object object;
        long l11;
        long l12;
        boolean bl2 = this.I;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.J = throwable;
        this.I = true;
        bl2 = this.b();
        if (bl2) {
            this.l();
        }
        if (!(bl2 = (l12 = (l11 = ((AtomicLong)(object = this.R)).decrementAndGet()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = this.N;
            ((e.a.s0.a)object).dispose();
        }
        this.F.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f();
        if (bl2) {
            boolean bl3;
            Iterator iterator2 = this.Q.iterator();
            while (bl3 = iterator2.hasNext()) {
                UnicastSubject unicastSubject = (UnicastSubject)iterator2.next();
                unicastSubject.onNext(object);
            }
            int n10 = this.a(-1);
            if (n10 == 0) {
                return;
            }
        } else {
            n n11 = this.G;
            object = NotificationLite.next(object);
            n11.offer(object);
            boolean bl4 = this.b();
            if (!bl4) {
                return;
            }
        }
        this.l();
    }

    public void onSubscribe(b object) {
        Object object2 = this.O;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.O = object;
            this.F.onSubscribe(this);
            object = this.S;
            boolean bl3 = ((AtomicBoolean)object).get();
            if (bl3) {
                return;
            }
            object2 = this.P;
            object = new x1$b(this);
            bl2 = ((AtomicReference)object2).compareAndSet(null, object);
            if (bl2) {
                object2 = this.K;
                object2.subscribe((g0)object);
            }
        }
    }
}

