/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.c.n;
import e.a.w0.e.b.j1$a;
import e.a.w0.e.b.j1$b;
import e.a.w0.e.b.j1$d;
import e.a.w0.h.h;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class j1$c
extends h
implements e {
    public final c k0;
    public final o o0;
    public final int p0;
    public final e.a.s0.a q0;
    public e r0;
    public final AtomicReference s0;
    public final List t0;
    public final AtomicLong u0;
    public final AtomicBoolean v0;

    public j1$c(d serializable, c arrayList, o o10, int n10) {
        Object object = new MpscLinkedQueue();
        super((d)((Object)serializable), (n)object);
        serializable = new AtomicReference();
        this.s0 = serializable;
        super();
        this.u0 = serializable;
        this.v0 = object = new AtomicBoolean();
        this.k0 = arrayList;
        this.o0 = o10;
        this.p0 = n10;
        arrayList = new ArrayList();
        this.q0 = arrayList;
        this.t0 = arrayList = new ArrayList();
        ((AtomicLong)serializable).lazySet(1L);
    }

    public void cancel() {
        Object object = this.v0;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            DisposableHelper.dispose(this.s0);
            object = this.u0;
            long l10 = ((AtomicLong)object).decrementAndGet();
            long l11 = 0L;
            bl3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (!bl3) {
                object = this.r0;
                object.cancel();
            }
        }
    }

    public void dispose() {
        this.q0.dispose();
        DisposableHelper.dispose(this.s0);
    }

    public boolean e(d d10, Object object) {
        return false;
    }

    public void k(j1$a o10) {
        this.q0.c((b)((Object)o10));
        n n10 = this.W;
        o10 = o10.c;
        j1$d j1$d = new j1$d((UnicastProcessor)o10, null);
        n10.offer(j1$d);
        boolean bl2 = this.b();
        if (bl2) {
            this.l();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void l() {
        var1_1 = this.W;
        var2_2 = this.V;
        var3_3 = this.t0;
        var5_5 = var4_4 = 1;
        block6: while (true) {
            var6_6 = this.Y;
            var7_7 = var1_1.poll();
            if (var7_7 == null) {
                var8_8 = var4_4;
            } else {
                var8_8 = 0;
                var9_9 = null;
            }
            if (var6_6 != 0 && var8_8 != 0) {
                this.dispose();
                var1_1 = this.Z;
                if (var1_1 != null) {
                    var2_2 = var3_3.iterator();
                    while ((var4_4 = (int)var2_2.hasNext()) != 0) {
                        var10_16 = (UnicastProcessor)var2_2.next();
                        var10_16.onError((Throwable)var1_1);
                    }
                } else {
                    var1_1 = var3_3.iterator();
                    while (var11_17 = var1_1.hasNext()) {
                        var2_2 = (UnicastProcessor)var1_1.next();
                        var2_2.onComplete();
                    }
                }
                var3_3.clear();
                return;
            }
            if (var8_8 != 0) {
                var5_5 = -var5_5;
                if ((var5_5 = this.a(var5_5)) != 0) continue;
                return;
            }
            var6_6 = var7_7 instanceof j1$d;
            if (var6_6 != 0) {
                var7_7 = (j1$d)var7_7;
                var12_10 = var7_7.a;
                var13_12 = 0L;
                if (var12_10 != null) {
                    var6_6 = var3_3.remove(var12_10);
                    if (var6_6 == 0) continue;
                    var7_7.a.onComplete();
                    var12_10 = this.u0;
                    var15_13 = var12_10.decrementAndGet();
                    cfr_temp_0 = var15_13 - var13_12;
                    var6_6 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var6_6 != 0) continue;
                    this.dispose();
                    return;
                }
                var12_10 = this.v0;
                var6_6 = var12_10.get();
                if (var6_6 != 0) continue;
                var6_6 = this.p0;
                var12_10 = UnicastProcessor.R8(var6_6);
                var17_14 = this.requested();
                cfr_temp_1 = var17_14 - var13_12;
                var8_8 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var8_8 != 0) {
                    var3_3.add(var12_10);
                    var2_2.onNext(var12_10);
                    var13_12 = 0x7FFFFFFFFFFFFFFFL;
                    var8_8 = (int)(var17_14 == var13_12 ? 0 : (var17_14 < var13_12 ? -1 : 1));
                    if (var8_8 != 0) {
                        var13_12 = 1L;
                        this.f(var13_12);
                    }
                    var9_9 = this.o0;
                    var7_7 = var7_7.b;
                    var7_7 = var9_9.apply(var7_7);
                    var9_9 = "The publisher supplied is null";
                    var7_7 = e.a.w0.b.a.g(var7_7, (String)var9_9);
                    try {
                        var7_7 = (c)var7_7;
                    }
                    catch (Throwable var12_11) {
                        this.cancel();
                        var2_2.onError(var12_11);
                    }
                    var12_10 = this.q0;
                    var9_9 = new j1$a(this, (UnicastProcessor)var12_10);
                    var6_6 = (int)var12_10.b((b)var9_9);
                    if (var6_6 == 0) continue;
                    var12_10 = this.u0;
                    var12_10.getAndIncrement();
                    var7_7.subscribe((d)var9_9);
                    continue;
                }
                this.cancel();
                var7_7 = "Could not deliver new window due to lack of requests";
                var12_10 = new MissingBackpressureException((String)var7_7);
                var2_2.onError((Throwable)var12_10);
                continue;
            }
            var12_10 = var3_3.iterator();
            while (true) {
                if ((var8_8 = (int)var12_10.hasNext()) != 0) ** break;
                continue block6;
                var9_9 = (UnicastProcessor)var12_10.next();
                var19_15 = NotificationLite.getValue(var7_7);
                var9_9.onNext(var19_15);
            }
            break;
        }
    }

    public void m(Throwable throwable) {
        this.r0.cancel();
        this.q0.dispose();
        DisposableHelper.dispose(this.s0);
        this.V.onError(throwable);
    }

    public void o(Object object) {
        n n10 = this.W;
        j1$d j1$d = new j1$d(null, object);
        n10.offer(j1$d);
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
        boolean bl2 = this.Y;
        if (bl2) {
            return;
        }
        this.Y = true;
        bl2 = this.b();
        if (bl2) {
            this.l();
        }
        if (!(bl2 = (l12 = (l11 = ((AtomicLong)(object = this.u0)).decrementAndGet()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = this.q0;
            ((e.a.s0.a)object).dispose();
        }
        this.V.onComplete();
    }

    public void onError(Throwable throwable) {
        long l10;
        Object object;
        long l11;
        long l12;
        boolean bl2 = this.Y;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.Z = throwable;
        this.Y = true;
        bl2 = this.b();
        if (bl2) {
            this.l();
        }
        if (!(bl2 = (l12 = (l11 = ((AtomicLong)(object = this.u0)).decrementAndGet()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            object = this.q0;
            ((e.a.s0.a)object).dispose();
        }
        this.V.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.Y;
        if (bl2) {
            return;
        }
        bl2 = this.g();
        if (bl2) {
            boolean bl3;
            Iterator iterator2 = this.t0.iterator();
            while (bl3 = iterator2.hasNext()) {
                UnicastProcessor unicastProcessor = (UnicastProcessor)iterator2.next();
                unicastProcessor.onNext(object);
            }
            int n10 = this.a(-1);
            if (n10 == 0) {
                return;
            }
        } else {
            n n11 = this.W;
            object = NotificationLite.next(object);
            n11.offer(object);
            boolean bl4 = this.b();
            if (!bl4) {
                return;
            }
        }
        this.l();
    }

    public void onSubscribe(e object) {
        Object object2 = this.r0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            this.r0 = object;
            this.V.onSubscribe(this);
            object2 = this.v0;
            bl2 = ((AtomicBoolean)object2).get();
            if (bl2) {
                return;
            }
            AtomicReference atomicReference = this.s0;
            object2 = new j1$b(this);
            boolean bl3 = atomicReference.compareAndSet(null, object2);
            if (bl3) {
                long l10 = Long.MAX_VALUE;
                object.request(l10);
                object = this.k0;
                object.subscribe((d)object2);
            }
        }
    }

    public void request(long l10) {
        this.j(l10);
    }
}

