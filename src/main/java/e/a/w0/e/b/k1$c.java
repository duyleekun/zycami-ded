/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0$c;
import e.a.w0.c.n;
import e.a.w0.e.b.k1$c$a;
import e.a.w0.e.b.k1$c$b;
import e.a.w0.h.h;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class k1$c
extends h
implements e,
Runnable {
    public final long k0;
    public final long o0;
    public final TimeUnit p0;
    public final h0$c q0;
    public final int r0;
    public final List s0;
    public e t0;
    public volatile boolean u0;

    public k1$c(d linkedList, long l10, long l11, TimeUnit timeUnit, h0$c h0$c, int n10) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)((Object)linkedList), mpscLinkedQueue);
        this.k0 = l10;
        this.o0 = l11;
        this.p0 = timeUnit;
        this.q0 = h0$c;
        this.r0 = n10;
        this.s0 = linkedList = new LinkedList();
    }

    public void cancel() {
        this.X = true;
    }

    public void k(UnicastProcessor unicastProcessor) {
        n n10 = this.W;
        k1$c$b k1$c$b = new k1$c$b(unicastProcessor, false);
        n10.offer(k1$c$b);
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
        var3_3 = this.s0;
        var5_5 = var4_4 = 1;
        block0: while (true) {
            if (var6_6 = this.u0) {
                this.t0.cancel();
                var1_1.clear();
                var3_3.clear();
                this.q0.dispose();
                return;
            }
            var6_6 = this.Y;
            var7_7 = var1_1.poll();
            if (var7_7 == null) {
                var8_8 = var4_4;
            } else {
                var8_8 = 0;
                var9_9 = null;
            }
            var10_10 = var7_7 instanceof k1$c$b;
            if (var6_6 && (var8_8 != 0 || var10_10)) {
                var1_1.clear();
                var1_1 = this.Z;
                if (var1_1 != null) {
                    var2_2 = var3_3.iterator();
                    while ((var4_4 = (int)var2_2.hasNext()) != 0) {
                        var11_16 = (UnicastProcessor)var2_2.next();
                        var11_16.onError((Throwable)var1_1);
                    }
                } else {
                    var1_1 = var3_3.iterator();
                    while (var12_17 = var1_1.hasNext()) {
                        var2_2 = (UnicastProcessor)var1_1.next();
                        var2_2.onComplete();
                    }
                }
                var3_3.clear();
                this.q0.dispose();
                return;
            }
            if (var8_8 != 0) {
                var5_5 = -var5_5;
                if ((var5_5 = this.a(var5_5)) != 0) continue;
                return;
            }
            if (var10_10) {
                var7_7 = (k1$c$b)var7_7;
                var6_6 = var7_7.b;
                if (var6_6) {
                    var6_6 = this.X;
                    if (var6_6) continue;
                    var13_11 = this.requested();
                    cfr_temp_0 = var13_11 - (var15_12 = 0L);
                    var8_8 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var8_8 != 0) {
                        var8_8 = this.r0;
                        var9_9 = UnicastProcessor.R8(var8_8);
                        var3_3.add(var9_9);
                        var2_2.onNext(var9_9);
                        var17_13 = 0x7FFFFFFFFFFFFFFFL;
                        var6_6 = var13_11 == var17_13 ? 0 : (var13_11 < var17_13 ? -1 : 1);
                        if (var6_6) {
                            var13_11 = 1L;
                            this.f(var13_11);
                        }
                        var19_14 = this.q0;
                        var7_7 = new k1$c$a(this, var9_9);
                        var15_12 = this.k0;
                        var20_15 = this.p0;
                        var19_14.c((Runnable)var7_7, var15_12, var20_15);
                        continue;
                    }
                    var7_7 = "Can't emit window due to lack of requests";
                    var19_14 = new MissingBackpressureException((String)var7_7);
                    var2_2.onError((Throwable)var19_14);
                    continue;
                }
                var19_14 = var7_7.a;
                var3_3.remove(var19_14);
                var19_14 = var7_7.a;
                var19_14.onComplete();
                var6_6 = var3_3.isEmpty();
                if (!var6_6 || !(var6_6 = this.X)) continue;
                this.u0 = var4_4;
                continue;
            }
            var19_14 = var3_3.iterator();
            while (true) {
                if ((var8_8 = (int)var19_14.hasNext()) != 0) ** break;
                continue block0;
                var9_9 = (UnicastProcessor)var19_14.next();
                var9_9.onNext(var7_7);
            }
            break;
        }
    }

    public void onComplete() {
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.l();
        }
        this.V.onComplete();
    }

    public void onError(Throwable throwable) {
        this.Z = throwable;
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.l();
        }
        this.V.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.g();
        if (bl2) {
            boolean bl3;
            Iterator iterator2 = this.s0.iterator();
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
            n11.offer(object);
            boolean bl4 = this.b();
            if (!bl4) {
                return;
            }
        }
        this.l();
    }

    public void onSubscribe(e object) {
        Object object2 = this.t0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            long l10;
            this.t0 = object;
            object2 = this.V;
            object2.onSubscribe(this);
            bl2 = this.X;
            if (bl2) {
                return;
            }
            long l11 = this.requested();
            long l12 = l11 - (l10 = 0L);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false) {
                object3 = this.r0;
                Object object4 = UnicastProcessor.R8((int)object3);
                this.s0.add(object4);
                d d10 = this.V;
                d10.onNext(object4);
                long l13 = Long.MAX_VALUE;
                bl2 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (bl2) {
                    l11 = 1L;
                    this.f(l11);
                }
                object2 = this.q0;
                k1$c$a k1$c$a = new k1$c$a(this, (UnicastProcessor)object4);
                long l14 = this.k0;
                object4 = this.p0;
                ((h0$c)object2).c(k1$c$a, l14, (TimeUnit)((Object)object4));
                h0$c h0$c = this.q0;
                long l15 = this.o0;
                TimeUnit timeUnit = this.p0;
                h0$c.d(this, l15, l15, timeUnit);
                object.request(l13);
            } else {
                object.cancel();
                object = this.V;
                String string2 = "Could not emit the first window due to lack of requests";
                object2 = new MissingBackpressureException(string2);
                object.onError((Throwable)object2);
            }
        }
    }

    public void request(long l10) {
        this.j(l10);
    }

    public void run() {
        Object object = UnicastProcessor.R8(this.r0);
        boolean bl2 = true;
        k1$c$b k1$c$b = new k1$c$b((UnicastProcessor)object, bl2);
        boolean bl3 = this.X;
        if (!bl3) {
            object = this.W;
            object.offer(k1$c$b);
        }
        if (bl3 = this.b()) {
            this.l();
        }
    }
}

