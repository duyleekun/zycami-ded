/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.c.n;
import e.a.w0.e.b.k1$a$a;
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

public final class k1$a
extends h
implements e {
    public final long k0;
    public final TimeUnit o0;
    public final h0 p0;
    public final int q0;
    public final boolean r0;
    public final long s0;
    public final h0$c t0;
    public long u0;
    public long v0;
    public e w0;
    public UnicastProcessor x0;
    public volatile boolean y0;
    public final SequentialDisposable z0;

    public k1$a(d object, long l10, TimeUnit timeUnit, h0 h02, int n10, long l11, boolean bl2) {
        MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
        super((d)object, mpscLinkedQueue);
        this.z0 = object = new SequentialDisposable();
        this.k0 = l10;
        this.o0 = timeUnit;
        this.p0 = h02;
        this.q0 = n10;
        this.s0 = l11;
        this.r0 = bl2;
        if (bl2) {
            this.t0 = object = h02.c();
        } else {
            object = null;
            this.t0 = null;
        }
    }

    public static /* synthetic */ boolean k(k1$a k1$a) {
        return k1$a.X;
    }

    public static /* synthetic */ n l(k1$a k1$a) {
        return k1$a.W;
    }

    public void cancel() {
        this.X = true;
    }

    public void m() {
        this.z0.dispose();
        h0$c h0$c = this.t0;
        if (h0$c != null) {
            h0$c.dispose();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void o() {
        k1$a k1$a = this;
        Object object = this.W;
        Object object2 = this.V;
        Object object3 = this.x0;
        int n10 = 1;
        while (true) {
            int n11;
            block15: {
                int n12;
                long l10;
                long l11;
                long l12;
                long l13;
                k1$a$a k1$a$a;
                int n13;
                Object object4;
                block14: {
                    long l14;
                    Object object5;
                    boolean bl2;
                    if (bl2 = k1$a.y0) {
                        k1$a.w0.cancel();
                        object.clear();
                        this.m();
                        return;
                    }
                    bl2 = k1$a.Y;
                    object4 = object.poll();
                    n11 = object4 == null ? 1 : 0;
                    n13 = object4 instanceof k1$a$a;
                    k1$a$a = null;
                    if (bl2 && (n11 != 0 || n13 != 0)) {
                        k1$a.x0 = null;
                        object.clear();
                        object = k1$a.Z;
                        if (object != null) {
                            ((UnicastProcessor)object3).onError((Throwable)object);
                        } else {
                            ((UnicastProcessor)object3).onComplete();
                        }
                        this.m();
                        return;
                    }
                    if (n11 != 0) {
                        n10 = -n10;
                        if ((n10 = k1$a.a(n10)) != 0) continue;
                        return;
                    }
                    l13 = Long.MAX_VALUE;
                    l12 = 0L;
                    n11 = n10;
                    if (n13 == 0) break block14;
                    object4 = (k1$a$a)object4;
                    n13 = k1$a.r0;
                    if (n13 == 0 || (object5 = (l14 = (l11 = k1$a.v0) - (l10 = ((k1$a$a)object4).a)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
                        ((UnicastProcessor)object3).onComplete();
                        k1$a.u0 = l12;
                        n12 = k1$a.q0;
                        object3 = UnicastProcessor.R8(n12);
                        k1$a.x0 = object3;
                        l11 = this.requested();
                        bl2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (!bl2) {
                            k1$a.x0 = null;
                            k1$a.W.clear();
                            k1$a.w0.cancel();
                            object = new MissingBackpressureException("Could not deliver first window due to lack of requests.");
                            object2.onError((Throwable)object);
                            this.m();
                            return;
                        }
                        object2.onNext(object3);
                        object5 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                        if (object5 != false) {
                            l11 = 1L;
                            k1$a.f(l11);
                        }
                    }
                    break block15;
                }
                Object object6 = NotificationLite.getValue(object4);
                ((UnicastProcessor)object3).onNext(object6);
                l11 = k1$a.u0;
                l10 = 1L;
                long l15 = k1$a.s0;
                long l16 = (l11 += l10) - l15;
                n13 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (n13 >= 0) {
                    UnicastProcessor unicastProcessor;
                    k1$a.v0 = l11 = k1$a.v0 + l10;
                    k1$a.u0 = l12;
                    ((UnicastProcessor)object3).onComplete();
                    long l17 = this.requested();
                    n10 = (int)(l17 == l12 ? 0 : (l17 < l12 ? -1 : 1));
                    if (n10 == 0) {
                        k1$a.x0 = null;
                        k1$a.w0.cancel();
                        object = k1$a.V;
                        object2 = new MissingBackpressureException("Could not deliver window due to lack of requests");
                        object.onError((Throwable)object2);
                        this.m();
                        return;
                    }
                    n10 = k1$a.q0;
                    k1$a.x0 = unicastProcessor = UnicastProcessor.R8(n10);
                    d d10 = k1$a.V;
                    d10.onNext(unicastProcessor);
                    n12 = (int)(l17 == l13 ? 0 : (l17 < l13 ? -1 : 1));
                    if (n12 != 0) {
                        l17 = 1L;
                        k1$a.f(l17);
                    }
                    if ((n12 = (int)(k1$a.r0 ? 1 : 0)) != 0) {
                        ((b)k1$a.z0.get()).dispose();
                        h0$c h0$c = k1$a.t0;
                        l17 = k1$a.v0;
                        k1$a$a = new k1$a$a(l17, k1$a);
                        l12 = k1$a.k0;
                        TimeUnit timeUnit = k1$a.o0;
                        l13 = l12;
                        object3 = h0$c.d(k1$a$a, l12, l12, timeUnit);
                        object6 = k1$a.z0;
                        ((SequentialDisposable)object6).replace((b)object3);
                    }
                    object3 = unicastProcessor;
                } else {
                    k1$a.u0 = l11;
                }
            }
            n10 = n11;
        }
    }

    public void onComplete() {
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.o();
        }
        this.V.onComplete();
    }

    public void onError(Throwable throwable) {
        this.Z = throwable;
        this.Y = true;
        boolean bl2 = this.b();
        if (bl2) {
            this.o();
        }
        this.V.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onNext(Object object) {
        boolean bl2 = this.y0;
        if (bl2) {
            return;
        }
        bl2 = this.g();
        if (bl2) {
            Object object2 = this.x0;
            ((UnicastProcessor)object2).onNext(object);
            long l10 = this.u0;
            long l11 = 1L;
            long l12 = this.s0;
            long l13 = (l10 += l11) - l12;
            long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (l14 >= 0) {
                this.v0 = l10 = this.v0 + l11;
                this.u0 = l10 = 0L;
                ((UnicastProcessor)object2).onComplete();
                l12 = this.requested();
                l14 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                if (l14 == false) {
                    this.x0 = null;
                    this.w0.cancel();
                    object = this.V;
                    object2 = new MissingBackpressureException("Could not deliver window due to lack of requests");
                    object.onError((Throwable)object2);
                    this.m();
                    return;
                }
                this.x0 = object = UnicastProcessor.R8(this.q0);
                object2 = this.V;
                object2.onNext(object);
                long l15 = Long.MAX_VALUE;
                l14 = l12 == l15 ? 0 : (l12 < l15 ? -1 : 1);
                if (l14 != false) {
                    this.f(l11);
                }
                if ((l14 = (long)this.r0) != false) {
                    ((b)this.z0.get()).dispose();
                    object2 = this.t0;
                    long l16 = this.v0;
                    k1$a$a k1$a$a = new k1$a$a(l16, this);
                    long l17 = this.k0;
                    TimeUnit timeUnit = this.o0;
                    l16 = l17;
                    object = ((h0$c)object2).d(k1$a$a, l17, l17, timeUnit);
                    object2 = this.z0;
                    ((SequentialDisposable)object2).replace((b)object);
                }
            } else {
                this.u0 = l10;
            }
            if ((l14 = (long)this.a(-1)) == false) {
                return;
            }
        } else {
            n n10 = this.W;
            object = NotificationLite.next(object);
            n10.offer(object);
            boolean bl3 = this.b();
            if (!bl3) {
                return;
            }
        }
        this.o();
    }

    public void onSubscribe(e object) {
        Object object2 = this.w0;
        boolean bl2 = SubscriptionHelper.validate((e)object2, (e)object);
        if (bl2) {
            long l10;
            this.w0 = object;
            object2 = this.V;
            object2.onSubscribe(this);
            int n10 = this.X;
            if (n10 != 0) {
                return;
            }
            n10 = this.q0;
            Object object3 = UnicastProcessor.R8(n10);
            this.x0 = object3;
            long l11 = this.requested();
            long l12 = l11 - (l10 = 0L);
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 != false) {
                b b10;
                object2.onNext(object3);
                long l13 = Long.MAX_VALUE;
                long l14 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (l14 != false) {
                    l11 = 1L;
                    this.f(l11);
                }
                l11 = this.v0;
                k1$a$a k1$a$a = new k1$a$a(l11, this);
                l14 = (long)this.r0;
                if (l14 != false) {
                    h0$c h0$c = this.t0;
                    long l15 = this.k0;
                    TimeUnit timeUnit = this.o0;
                    b10 = h0$c.d(k1$a$a, l15, l15, timeUnit);
                } else {
                    h0 h02 = this.p0;
                    long l16 = this.k0;
                    TimeUnit timeUnit = this.o0;
                    b10 = h02.g(k1$a$a, l16, l16, timeUnit);
                }
                SequentialDisposable sequentialDisposable = this.z0;
                l14 = (long)sequentialDisposable.replace(b10);
                if (l14 != false) {
                    object.request(l13);
                }
            } else {
                n10 = 1;
                this.X = n10;
                object.cancel();
                object3 = "Could not deliver initial window due to lack of requests.";
                object = new MissingBackpressureException((String)object3);
                object2.onError((Throwable)object);
            }
        }
    }

    public void request(long l10) {
        this.j(l10);
    }
}

