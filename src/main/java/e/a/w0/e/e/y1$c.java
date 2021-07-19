/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.d.k;
import e.a.w0.e.e.y1$c$a;
import e.a.w0.e.e.y1$c$b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class y1$c
extends k
implements b,
Runnable {
    public final long K;
    public final long L;
    public final TimeUnit M;
    public final h0$c N;
    public final int O;
    public final List P;
    public b Q;
    public volatile boolean R;

    public y1$c(g0 linkedList, long l10, long l11, TimeUnit timeUnit, h0$c h0$c, int n10) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)((Object)linkedList), mpscLinkedQueue);
        this.K = l10;
        this.L = l11;
        this.M = timeUnit;
        this.N = h0$c;
        this.O = n10;
        this.P = linkedList = new LinkedList();
    }

    public void dispose() {
        this.H = true;
    }

    public void i(UnicastSubject unicastSubject) {
        n n10 = this.G;
        y1$c$b y1$c$b = new y1$c$b(unicastSubject, false);
        n10.offer(y1$c$b);
        boolean bl2 = this.b();
        if (bl2) {
            this.k();
        }
    }

    public boolean isDisposed() {
        return this.H;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void k() {
        var1_1 = (MpscLinkedQueue)this.G;
        var2_2 = this.F;
        var3_3 = this.P;
        var5_5 = var4_4 = 1;
        block0: while (true) {
            if ((var6_6 = this.R) != 0) {
                this.Q.dispose();
                var1_1.clear();
                var3_3.clear();
                this.N.dispose();
                return;
            }
            var6_6 = this.I;
            var7_7 = var1_1.poll();
            if (var7_7 == null) {
                var8_8 = var4_4;
            } else {
                var8_8 = 0;
                var9_9 = null;
            }
            var10_10 = var7_7 instanceof y1$c$b;
            if (var6_6 != 0 && (var8_8 != 0 || var10_10)) {
                var1_1.clear();
                var1_1 = this.J;
                if (var1_1 != null) {
                    var2_2 = var3_3.iterator();
                    while ((var4_4 = (int)var2_2.hasNext()) != 0) {
                        var11_13 = (UnicastSubject)var2_2.next();
                        var11_13.onError((Throwable)var1_1);
                    }
                } else {
                    var1_1 = var3_3.iterator();
                    while (var12_14 = var1_1.hasNext()) {
                        var2_2 = (UnicastSubject)var1_1.next();
                        var2_2.onComplete();
                    }
                }
                var3_3.clear();
                this.N.dispose();
                return;
            }
            if (var8_8 != 0) {
                var5_5 = -var5_5;
                if ((var5_5 = this.a(var5_5)) != 0) continue;
                return;
            }
            if (var10_10) {
                var7_7 = (y1$c$b)var7_7;
                var6_6 = var7_7.b;
                if (var6_6 != 0) {
                    var6_6 = this.H;
                    if (var6_6 != 0) continue;
                    var6_6 = this.O;
                    var13_11 /* !! */  = UnicastSubject.n8(var6_6);
                    var3_3.add(var13_11 /* !! */ );
                    var2_2.onNext(var13_11 /* !! */ );
                    var7_7 = this.N;
                    var9_9 = new y1$c$a(this, (UnicastSubject)var13_11 /* !! */ );
                    var14_12 = this.K;
                    var13_11 /* !! */  = this.M;
                    var7_7.c((Runnable)var9_9, var14_12, (TimeUnit)var13_11 /* !! */ );
                    continue;
                }
                var13_11 /* !! */  = var7_7.a;
                var3_3.remove(var13_11 /* !! */ );
                var13_11 /* !! */  = var7_7.a;
                var13_11 /* !! */ .onComplete();
                var6_6 = (int)var3_3.isEmpty();
                if (var6_6 == 0 || (var6_6 = (int)this.H) == 0) continue;
                this.R = var4_4;
                continue;
            }
            var13_11 /* !! */  = var3_3.iterator();
            while (true) {
                if ((var8_8 = (int)var13_11 /* !! */ .hasNext()) != 0) ** break;
                continue block0;
                var9_9 = (UnicastSubject)var13_11 /* !! */ .next();
                var9_9.onNext(var7_7);
            }
            break;
        }
    }

    public void onComplete() {
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.k();
        }
        this.F.onComplete();
    }

    public void onError(Throwable throwable) {
        this.J = throwable;
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.k();
        }
        this.F.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.f();
        if (bl2) {
            boolean bl3;
            Iterator iterator2 = this.P.iterator();
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
            n11.offer(object);
            boolean bl4 = this.b();
            if (!bl4) {
                return;
            }
        }
        this.k();
    }

    public void onSubscribe(b object) {
        b b10 = this.Q;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.Q = object;
            object = this.F;
            object.onSubscribe(this);
            int n10 = this.H;
            if (n10 != 0) {
                return;
            }
            n10 = this.O;
            object = UnicastSubject.n8(n10);
            this.P.add(object);
            this.F.onNext(object);
            b10 = this.N;
            y1$c$a y1$c$a = new y1$c$a(this, (UnicastSubject)object);
            long l10 = this.K;
            object = this.M;
            ((h0$c)b10).c(y1$c$a, l10, (TimeUnit)((Object)object));
            h0$c h0$c = this.N;
            long l11 = this.L;
            TimeUnit timeUnit = this.M;
            h0$c.d(this, l11, l11, timeUnit);
        }
    }

    public void run() {
        Object object = UnicastSubject.n8(this.O);
        boolean bl2 = true;
        y1$c$b y1$c$b = new y1$c$b((UnicastSubject)object, bl2);
        boolean bl3 = this.H;
        if (!bl3) {
            object = this.G;
            object.offer(y1$c$b);
        }
        if (bl3 = this.b()) {
            this.k();
        }
    }
}

