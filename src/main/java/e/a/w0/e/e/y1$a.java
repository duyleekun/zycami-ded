/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.d.k;
import e.a.w0.e.e.y1$a$a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class y1$a
extends k
implements b {
    public final long K;
    public final TimeUnit L;
    public final h0 M;
    public final int N;
    public final boolean O;
    public final long P;
    public final h0$c Q;
    public long R;
    public long S;
    public b T;
    public UnicastSubject U;
    public volatile boolean V;
    public final SequentialDisposable W;

    public y1$a(g0 object, long l10, TimeUnit timeUnit, h0 h02, int n10, long l11, boolean bl2) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)object, mpscLinkedQueue);
        this.W = object = new SequentialDisposable();
        this.K = l10;
        this.L = timeUnit;
        this.M = h02;
        this.N = n10;
        this.P = l11;
        this.O = bl2;
        if (bl2) {
            this.Q = object = h02.c();
        } else {
            object = null;
            this.Q = null;
        }
    }

    public static /* synthetic */ boolean i(y1$a y1$a) {
        return y1$a.H;
    }

    public static /* synthetic */ n k(y1$a y1$a) {
        return y1$a.G;
    }

    public void dispose() {
        this.H = true;
    }

    public boolean isDisposed() {
        return this.H;
    }

    public void l() {
        DisposableHelper.dispose(this.W);
        h0$c h0$c = this.Q;
        if (h0$c != null) {
            h0$c.dispose();
        }
    }

    public void m() {
        int n10;
        Object object = (MpscLinkedQueue)this.G;
        g0 g02 = this.F;
        UnicastSubject unicastSubject = this.U;
        int n11 = n10 = 1;
        while (true) {
            int n12;
            long l10;
            long l11;
            Object object2;
            int n13;
            boolean bl2;
            if (bl2 = this.V) {
                this.T.dispose();
                ((MpscLinkedQueue)object).clear();
                this.l();
                return;
            }
            bl2 = this.I;
            Object object3 = ((MpscLinkedQueue)object).poll();
            if (object3 == null) {
                n13 = n10;
            } else {
                n13 = 0;
                object2 = null;
            }
            boolean bl3 = object3 instanceof y1$a$a;
            if (bl2 && (n13 != 0 || bl3)) {
                g02 = null;
                this.U = null;
                ((MpscLinkedQueue)object).clear();
                object = this.J;
                if (object != null) {
                    unicastSubject.onError((Throwable)object);
                } else {
                    unicastSubject.onComplete();
                }
                this.l();
                return;
            }
            if (n13 != 0) {
                n11 = -n11;
                if ((n11 = this.a(n11)) != 0) continue;
                return;
            }
            long l12 = 0L;
            if (bl3) {
                long l13;
                object3 = (y1$a$a)object3;
                bl2 = this.O;
                if (bl2 && (bl2 = (l13 = (l11 = this.S) - (l10 = ((y1$a$a)object3).a)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) continue;
                unicastSubject.onComplete();
                this.R = l12;
                n12 = this.N;
                this.U = unicastSubject = UnicastSubject.n8(n12);
                g02.onNext(unicastSubject);
                continue;
            }
            Object object4 = NotificationLite.getValue(object3);
            unicastSubject.onNext(object4);
            l10 = this.R;
            l11 = 1L;
            long l14 = this.P;
            long l15 = (l10 += l11) - l14;
            long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (l16 >= 0) {
                this.S = l10 = this.S + l11;
                this.R = l12;
                unicastSubject.onComplete();
                n12 = this.N;
                this.U = unicastSubject = UnicastSubject.n8(n12);
                object4 = this.F;
                object4.onNext(unicastSubject);
                bl2 = this.O;
                if (!bl2) continue;
                object4 = (b)this.W.get();
                object4.dispose();
                object3 = this.Q;
                long l17 = this.S;
                object2 = new y1$a$a(l17, this);
                long l18 = this.K;
                TimeUnit timeUnit = this.L;
                l17 = l18;
                object2 = this.W;
                bl2 = ((AtomicReference)object2).compareAndSet(object4, object3 = ((h0$c)object3).d((Runnable)object2, l18, l18, timeUnit));
                if (bl2) continue;
                object3.dispose();
                continue;
            }
            this.R = l10;
        }
    }

    public void onComplete() {
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.m();
        }
        this.F.onComplete();
    }

    public void onError(Throwable throwable) {
        this.J = throwable;
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.m();
        }
        this.F.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.V;
        if (bl2) {
            return;
        }
        bl2 = this.f();
        if (bl2) {
            Object object2 = this.U;
            ((UnicastSubject)object2).onNext(object);
            long l10 = this.R;
            long l11 = 1L;
            long l12 = this.P;
            long l13 = (l10 += l11) - l12;
            long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (l14 >= 0) {
                this.S = l10 = this.S + l11;
                this.R = l10 = 0L;
                ((UnicastSubject)object2).onComplete();
                this.U = object = UnicastSubject.n8(this.N);
                object2 = this.F;
                object2.onNext(object);
                l14 = (long)this.O;
                if (l14 != false) {
                    ((b)this.W.get()).dispose();
                    object2 = this.Q;
                    long l15 = this.S;
                    y1$a$a y1$a$a = new y1$a$a(l15, this);
                    long l16 = this.K;
                    TimeUnit timeUnit = this.L;
                    l15 = l16;
                    object = ((h0$c)object2).d(y1$a$a, l16, l16, timeUnit);
                    object2 = this.W;
                    DisposableHelper.replace((AtomicReference)object2, (b)object);
                }
            } else {
                this.R = l10;
            }
            if ((l14 = (long)this.a(-1)) == false) {
                return;
            }
        } else {
            n n10 = this.G;
            object = NotificationLite.next(object);
            n10.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        this.m();
    }

    public void onSubscribe(b object) {
        Object object2 = this.T;
        int n10 = DisposableHelper.validate((b)object2, (b)object);
        if (n10 != 0) {
            this.T = object;
            object = this.F;
            object.onSubscribe(this);
            n10 = this.H;
            if (n10 != 0) {
                return;
            }
            n10 = this.N;
            this.U = object2 = UnicastSubject.n8(n10);
            object.onNext(object2);
            long l10 = this.S;
            y1$a$a y1$a$a = new y1$a$a(l10, this);
            boolean bl2 = this.O;
            if (bl2) {
                h0$c h0$c = this.Q;
                long l11 = this.K;
                TimeUnit timeUnit = this.L;
                object = h0$c.d(y1$a$a, l11, l11, timeUnit);
            } else {
                h0 h02 = this.M;
                long l12 = this.K;
                TimeUnit timeUnit = this.L;
                object = h02.g(y1$a$a, l12, l12, timeUnit);
            }
            object2 = this.W;
            ((SequentialDisposable)object2).replace((b)object);
        }
    }
}

