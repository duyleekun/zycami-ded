/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.d.k;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.TimeUnit;

public final class y1$b
extends k
implements g0,
b,
Runnable {
    public static final Object S;
    public final long K;
    public final TimeUnit L;
    public final h0 M;
    public final int N;
    public b O;
    public UnicastSubject P;
    public final SequentialDisposable Q;
    public volatile boolean R;

    static {
        Object object;
        S = object = new Object();
    }

    public y1$b(g0 object, long l10, TimeUnit timeUnit, h0 h02, int n10) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((g0)object, mpscLinkedQueue);
        this.Q = object = new SequentialDisposable();
        this.K = l10;
        this.L = timeUnit;
        this.M = h02;
        this.N = n10;
    }

    public void dispose() {
        this.H = true;
    }

    public void i() {
        Object object = (MpscLinkedQueue)this.G;
        g0 g02 = this.F;
        UnicastSubject unicastSubject = this.P;
        int n10 = 1;
        while (true) {
            Object object2;
            Object object3;
            boolean bl2 = this.R;
            boolean bl3 = this.I;
            Object object4 = ((MpscLinkedQueue)object).poll();
            if (bl3 && (object4 == null || object4 == (object3 = S))) {
                g02 = null;
                this.P = null;
                ((MpscLinkedQueue)object).clear();
                object = this.J;
                if (object != null) {
                    unicastSubject.onError((Throwable)object);
                } else {
                    unicastSubject.onComplete();
                }
                this.Q.dispose();
                return;
            }
            if (object4 == null) {
                n10 = -n10;
                if ((n10 = this.a(n10)) != 0) continue;
                return;
            }
            object3 = S;
            if (object4 == object3) {
                unicastSubject.onComplete();
                if (!bl2) {
                    int n11 = this.N;
                    this.P = unicastSubject = UnicastSubject.n8(n11);
                    g02.onNext(unicastSubject);
                    continue;
                }
                object2 = this.O;
                object2.dispose();
                continue;
            }
            object2 = NotificationLite.getValue(object4);
            unicastSubject.onNext(object2);
        }
    }

    public boolean isDisposed() {
        return this.H;
    }

    public void onComplete() {
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.i();
        }
        this.F.onComplete();
    }

    public void onError(Throwable throwable) {
        this.J = throwable;
        this.I = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.i();
        }
        this.F.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.R;
        if (bl2) {
            return;
        }
        bl2 = this.f();
        if (bl2) {
            UnicastSubject unicastSubject = this.P;
            unicastSubject.onNext(object);
            int n10 = this.a(-1);
            if (n10 == 0) {
                return;
            }
        } else {
            n n11 = this.G;
            object = NotificationLite.next(object);
            n11.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        this.i();
    }

    public void onSubscribe(b object) {
        Object object2 = this.O;
        boolean bl2 = DisposableHelper.validate((b)object2, (b)object);
        if (bl2) {
            this.O = object;
            this.P = object = UnicastSubject.n8(this.N);
            object = this.F;
            object.onSubscribe(this);
            object2 = this.P;
            object.onNext(object2);
            boolean bl3 = this.H;
            if (!bl3) {
                object2 = this.M;
                long l10 = this.K;
                TimeUnit timeUnit = this.L;
                object = ((h0)object2).g(this, l10, l10, timeUnit);
                object2 = this.Q;
                ((SequentialDisposable)object2).replace((b)object);
            }
        }
    }

    public void run() {
        boolean bl2 = this.H;
        if (bl2) {
            this.R = bl2 = true;
        }
        n n10 = this.G;
        Object object = S;
        n10.offer(object);
        bl2 = this.b();
        if (bl2) {
            this.i();
        }
    }
}

