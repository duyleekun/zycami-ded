/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0;
import e.a.o;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.h.h;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;

public final class k1$b
extends h
implements o,
e,
Runnable {
    public static final Object v0;
    public final long k0;
    public final TimeUnit o0;
    public final h0 p0;
    public final int q0;
    public e r0;
    public UnicastProcessor s0;
    public final SequentialDisposable t0;
    public volatile boolean u0;

    static {
        Object object;
        v0 = object = new Object();
    }

    public k1$b(d object, long l10, TimeUnit timeUnit, h0 h02, int n10) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)object, mpscLinkedQueue);
        this.t0 = object = new SequentialDisposable();
        this.k0 = l10;
        this.o0 = timeUnit;
        this.p0 = h02;
        this.q0 = n10;
    }

    public void cancel() {
        this.X = true;
    }

    public void k() {
        Object object = this.W;
        d d10 = this.V;
        UnicastProcessor unicastProcessor = this.s0;
        int n10 = 1;
        while (true) {
            Object object2;
            Object object3;
            Object object4 = this.u0;
            boolean bl2 = this.Y;
            Object object5 = object.poll();
            if (bl2 && (object5 == null || object5 == (object3 = v0))) {
                this.s0 = null;
                object.clear();
                object = this.Z;
                if (object != null) {
                    unicastProcessor.onError((Throwable)object);
                } else {
                    unicastProcessor.onComplete();
                }
                this.t0.dispose();
                return;
            }
            if (object5 == null) {
                n10 = -n10;
                if ((n10 = this.a(n10)) != 0) continue;
                return;
            }
            object3 = v0;
            if (object5 == object3) {
                unicastProcessor.onComplete();
                if (!object4) {
                    long l10;
                    int n11 = this.q0;
                    this.s0 = unicastProcessor = UnicastProcessor.R8(n11);
                    long l11 = this.requested();
                    long l12 = l11 - (l10 = 0L);
                    Object object6 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object6 != false) {
                        d10.onNext(unicastProcessor);
                        long l13 = Long.MAX_VALUE;
                        long l14 = l11 - l13;
                        object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                        if (!object4) continue;
                        l11 = 1L;
                        this.f(l11);
                        continue;
                    }
                    this.s0 = null;
                    this.W.clear();
                    this.r0.cancel();
                    object = new MissingBackpressureException("Could not deliver first window due to lack of requests.");
                    d10.onError((Throwable)object);
                    this.t0.dispose();
                    return;
                }
                object2 = this.r0;
                object2.cancel();
                continue;
            }
            object2 = NotificationLite.getValue(object5);
            unicastProcessor.onNext(object2);
        }
    }

    public void onComplete() {
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.k();
        }
        this.V.onComplete();
    }

    public void onError(Throwable throwable) {
        this.Z = throwable;
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.k();
        }
        this.V.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.u0;
        if (bl2) {
            return;
        }
        bl2 = this.g();
        if (bl2) {
            UnicastProcessor unicastProcessor = this.s0;
            unicastProcessor.onNext(object);
            int n10 = this.a(-1);
            if (n10 == 0) {
                return;
            }
        } else {
            n n11 = this.W;
            object = NotificationLite.next(object);
            n11.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        this.k();
    }

    public void onSubscribe(e object) {
        Object object2 = this.r0;
        int n10 = SubscriptionHelper.validate((e)object2, (e)object);
        if (n10 != 0) {
            this.r0 = object;
            n10 = this.q0;
            this.s0 = object2 = UnicastProcessor.R8(n10);
            object2 = this.V;
            object2.onSubscribe(this);
            long l10 = this.requested();
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                TimeUnit timeUnit;
                long l13;
                h0 h02;
                b b10;
                UnicastProcessor unicastProcessor = this.s0;
                object2.onNext(unicastProcessor);
                l11 = Long.MAX_VALUE;
                n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
                if (n10 != 0) {
                    long l14 = 1L;
                    this.f(l14);
                }
                if ((n10 = (int)(this.X ? 1 : 0)) == 0 && (n10 = (int)(((SequentialDisposable)(object2 = this.t0)).replace(b10 = (h02 = this.p0).g(this, l13 = this.k0, l13, timeUnit = this.o0)) ? 1 : 0)) != 0) {
                    object.request(l11);
                }
            } else {
                boolean bl2;
                this.X = bl2 = true;
                object.cancel();
                String string2 = "Could not deliver first window due to lack of requests.";
                object = new MissingBackpressureException(string2);
                object2.onError((Throwable)object);
            }
        }
    }

    public void request(long l10) {
        this.j(l10);
    }

    public void run() {
        boolean bl2 = this.X;
        if (bl2) {
            this.u0 = bl2 = true;
        }
        n n10 = this.W;
        Object object = v0;
        n10.offer(object);
        bl2 = this.b();
        if (bl2) {
            this.k();
        }
    }
}

