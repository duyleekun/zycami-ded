/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.b1.a;
import e.a.j;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastProcessor
extends a {
    public final e.a.w0.f.a b;
    public final AtomicReference c;
    public final boolean d;
    public volatile boolean e;
    public Throwable f;
    public final AtomicReference g;
    public volatile boolean h;
    public final AtomicBoolean i;
    public final BasicIntQueueSubscription j;
    public final AtomicLong k;
    public boolean l;

    public UnicastProcessor(int n10) {
        this(n10, null, true);
    }

    public UnicastProcessor(int n10, Runnable runnable) {
        this(n10, runnable, true);
    }

    public UnicastProcessor(int n10, Runnable runnable, boolean bl2) {
        Serializable serializable;
        e.a.w0.f.a a10;
        n10 = e.a.w0.b.a.h(n10, "capacityHint");
        this.b = a10 = new e.a.w0.f.a(n10);
        this.c = serializable = new Serializable(runnable);
        this.d = bl2;
        this.g = serializable = new Serializable();
        this.i = serializable;
        super(this);
        this.j = serializable;
        super();
        this.k = serializable;
    }

    public static UnicastProcessor Q8() {
        int n10 = e.a.j.f0();
        UnicastProcessor unicastProcessor = new UnicastProcessor(n10);
        return unicastProcessor;
    }

    public static UnicastProcessor R8(int n10) {
        UnicastProcessor unicastProcessor = new UnicastProcessor(n10);
        return unicastProcessor;
    }

    public static UnicastProcessor S8(int n10, Runnable runnable) {
        e.a.w0.b.a.g(runnable, "onTerminate");
        UnicastProcessor unicastProcessor = new UnicastProcessor(n10, runnable);
        return unicastProcessor;
    }

    public static UnicastProcessor T8(int n10, Runnable runnable, boolean bl2) {
        e.a.w0.b.a.g(runnable, "onTerminate");
        UnicastProcessor unicastProcessor = new UnicastProcessor(n10, runnable, bl2);
        return unicastProcessor;
    }

    public static UnicastProcessor U8(boolean bl2) {
        int n10 = e.a.j.f0();
        UnicastProcessor unicastProcessor = new UnicastProcessor(n10, null, bl2);
        return unicastProcessor;
    }

    public Throwable K8() {
        boolean bl2 = this.e;
        if (bl2) {
            return this.f;
        }
        return null;
    }

    public boolean L8() {
        Throwable throwable;
        boolean bl2 = this.e;
        if (bl2 && (throwable = this.f) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public boolean M8() {
        boolean bl2;
        Object v10 = this.g.get();
        if (v10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean N8() {
        Throwable throwable;
        boolean bl2 = this.e;
        if (bl2 && (throwable = this.f) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public boolean P8(boolean bl2, boolean bl3, boolean bl4, d d10, e.a.w0.f.a a10) {
        boolean bl5 = this.h;
        boolean bl6 = true;
        if (bl5) {
            a10.clear();
            this.g.lazySet(null);
            return bl6;
        }
        if (bl3) {
            Throwable throwable;
            if (bl2 && (throwable = this.f) != null) {
                a10.clear();
                this.g.lazySet(null);
                throwable = this.f;
                d10.onError(throwable);
                return bl6;
            }
            if (bl4) {
                throwable = this.f;
                AtomicReference atomicReference = this.g;
                atomicReference.lazySet(null);
                if (throwable != null) {
                    d10.onError(throwable);
                } else {
                    d10.onComplete();
                }
                return bl6;
            }
        }
        return false;
    }

    public void V8() {
        Runnable runnable = this.c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void W8() {
        BasicIntQueueSubscription basicIntQueueSubscription = this.j;
        int n10 = basicIntQueueSubscription.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        n10 = 1;
        Object object = (d)this.g.get();
        while (true) {
            if (object != null) {
                n10 = (int)(this.l ? 1 : 0);
                if (n10 != 0) {
                    this.X8((d)object);
                } else {
                    this.Y8((d)object);
                }
                return;
            }
            object = this.j;
            n10 = -n10;
            if ((n10 = ((AtomicInteger)object).addAndGet(n10)) == 0) {
                return;
            }
            object = (d)this.g.get();
        }
    }

    public void X8(d d10) {
        BasicIntQueueSubscription basicIntQueueSubscription;
        Object object = this.b;
        boolean bl2 = this.d;
        int n10 = 1;
        bl2 ^= n10;
        do {
            Throwable throwable;
            boolean bl3;
            if (bl3 = this.h) {
                this.g.lazySet(null);
                return;
            }
            bl3 = this.e;
            if (bl2 && bl3 && (throwable = this.f) != null) {
                ((e.a.w0.f.a)object).clear();
                this.g.lazySet(null);
                object = this.f;
                d10.onError((Throwable)object);
                return;
            }
            d10.onNext(null);
            if (bl3) {
                this.g.lazySet(null);
                object = this.f;
                if (object != null) {
                    d10.onError((Throwable)object);
                } else {
                    d10.onComplete();
                }
                return;
            }
            basicIntQueueSubscription = this.j;
            n10 = -n10;
        } while ((n10 = basicIntQueueSubscription.addAndGet(n10)) != 0);
    }

    public void Y8(d d10) {
        UnicastProcessor unicastProcessor = this;
        e.a.w0.f.a a10 = this.b;
        boolean bl2 = this.d;
        boolean bl3 = true;
        float f10 = Float.MIN_VALUE;
        boolean bl4 = bl2 ^ true;
        boolean bl5 = bl3;
        while (true) {
            long l10;
            long l11;
            long l12;
            long l13;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            long l14;
            long l15;
            Object object;
            block10: {
                object = unicastProcessor.k;
                l15 = ((AtomicLong)object).get();
                long l16 = 0L;
                while ((l14 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1)) != false) {
                    boolean bl9;
                    bl8 = unicastProcessor.e;
                    Object object2 = a10.poll();
                    if (object2 == null) {
                        bl9 = bl3;
                    } else {
                        bl2 = false;
                        object = null;
                        bl9 = false;
                    }
                    object = this;
                    bl7 = bl4;
                    bl6 = bl9;
                    l13 = l16;
                    bl2 = this.P8(bl4, bl8, bl9, d10, a10);
                    if (bl2) {
                        return;
                    }
                    if (!bl9) {
                        d10.onNext(object2);
                        l16 = l12 = 1L + l16;
                        bl3 = true;
                        f10 = Float.MIN_VALUE;
                        continue;
                    }
                    break block10;
                }
                l13 = l16;
            }
            if (l14 == false) {
                bl8 = unicastProcessor.e;
                bl6 = a10.isEmpty();
                object = this;
                bl7 = bl4;
                bl2 = this.P8(bl4, bl8, bl6, d10, a10);
                if (bl2) {
                    return;
                }
            }
            if ((bl2 = (l11 = l13 - (l12 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) && (bl2 = (l10 = l15 - (l12 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
                object = unicastProcessor.k;
                long l17 = -l13;
                ((AtomicLong)object).addAndGet(l17);
            }
            if (!(bl5 = ((AtomicInteger)(object = unicastProcessor.j)).addAndGet((int)((bl7 = -bl5) ? 1 : 0)))) {
                return;
            }
            bl3 = true;
            f10 = Float.MIN_VALUE;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void m6(d object) {
        String string2;
        Serializable serializable = this.i;
        boolean bl2 = ((AtomicBoolean)serializable).get();
        if (!bl2) {
            serializable = this.i;
            string2 = null;
            boolean bl3 = true;
            bl2 = ((AtomicBoolean)serializable).compareAndSet(false, bl3);
            if (bl2) {
                serializable = this.j;
                object.onSubscribe((e)((Object)serializable));
                serializable = this.g;
                ((AtomicReference)serializable).set(object);
                boolean bl4 = this.h;
                if (bl4) {
                    object = this.g;
                    bl2 = false;
                    serializable = null;
                    ((AtomicReference)object).lazySet(null);
                    return;
                }
                this.W8();
                return;
            }
        }
        string2 = "This processor allows only a single Subscriber";
        serializable = new IllegalStateException(string2);
        EmptySubscription.error((Throwable)serializable, (d)object);
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (!bl2 && !(bl2 = this.h)) {
            this.e = bl2 = true;
            this.V8();
            this.W8();
        }
    }

    public void onError(Throwable throwable) {
        String string2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(throwable, string2);
        boolean bl2 = this.e;
        if (!bl2 && !(bl2 = this.h)) {
            this.f = throwable;
            this.e = true;
            this.V8();
            this.W8();
            return;
        }
        e.a.a1.a.Y(throwable);
    }

    public void onNext(Object object) {
        Object object2 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = this.e;
        if (!bl2 && !(bl2 = this.h)) {
            object2 = this.b;
            ((e.a.w0.f.a)object2).offer(object);
            this.W8();
        }
    }

    public void onSubscribe(e e10) {
        boolean bl2 = this.e;
        if (!bl2 && !(bl2 = this.h)) {
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        } else {
            e10.cancel();
        }
    }
}

