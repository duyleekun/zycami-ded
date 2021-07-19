/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.d1.c;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.c.o;
import e.a.z;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject
extends c {
    public final e.a.w0.f.a a;
    public final AtomicReference b;
    public final AtomicReference c;
    public final boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public Throwable g;
    public final AtomicBoolean h;
    public final BasicIntQueueDisposable i;
    public boolean j;

    public UnicastSubject(int n10, Runnable runnable) {
        this(n10, runnable, true);
    }

    public UnicastSubject(int n10, Runnable object, boolean bl2) {
        Serializable serializable;
        e.a.w0.f.a a10;
        n10 = e.a.w0.b.a.h(n10, "capacityHint");
        this.a = a10 = new e.a.w0.f.a(n10);
        object = e.a.w0.b.a.g(object, "onTerminate");
        this.c = serializable = new Serializable(object);
        this.d = bl2;
        this.b = serializable = new Serializable();
        this.h = serializable;
        super(this);
        this.i = serializable;
    }

    public UnicastSubject(int n10, boolean bl2) {
        Serializable serializable;
        e.a.w0.f.a a10;
        n10 = e.a.w0.b.a.h(n10, "capacityHint");
        this.a = a10 = new e.a.w0.f.a(n10);
        this.c = serializable = new Serializable();
        this.d = bl2;
        this.b = serializable = new Serializable();
        this.h = serializable;
        super(this);
        this.i = serializable;
    }

    public static UnicastSubject m8() {
        int n10 = z.b0();
        UnicastSubject unicastSubject = new UnicastSubject(n10, true);
        return unicastSubject;
    }

    public static UnicastSubject n8(int n10) {
        UnicastSubject unicastSubject = new UnicastSubject(n10, true);
        return unicastSubject;
    }

    public static UnicastSubject o8(int n10, Runnable runnable) {
        UnicastSubject unicastSubject = new UnicastSubject(n10, runnable, true);
        return unicastSubject;
    }

    public static UnicastSubject p8(int n10, Runnable runnable, boolean bl2) {
        UnicastSubject unicastSubject = new UnicastSubject(n10, runnable, bl2);
        return unicastSubject;
    }

    public static UnicastSubject q8(boolean bl2) {
        int n10 = z.b0();
        UnicastSubject unicastSubject = new UnicastSubject(n10, bl2);
        return unicastSubject;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void K5(g0 g02) {
        String string2;
        Serializable serializable = this.h;
        boolean bl2 = ((AtomicBoolean)serializable).get();
        if (!bl2) {
            serializable = this.h;
            string2 = null;
            boolean bl3 = true;
            bl2 = ((AtomicBoolean)serializable).compareAndSet(false, bl3);
            if (bl2) {
                serializable = this.i;
                g02.onSubscribe((b)((Object)serializable));
                serializable = this.b;
                ((AtomicReference)serializable).lazySet(g02);
                boolean bl4 = this.e;
                if (bl4) {
                    this.b.lazySet(null);
                    return;
                }
                this.s8();
                return;
            }
        }
        string2 = "Only a single observer allowed.";
        serializable = new IllegalStateException(string2);
        EmptyDisposable.error((Throwable)serializable, g02);
    }

    public Throwable h8() {
        boolean bl2 = this.f;
        if (bl2) {
            return this.g;
        }
        return null;
    }

    public boolean i8() {
        Throwable throwable;
        boolean bl2 = this.f;
        if (bl2 && (throwable = this.g) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public boolean j8() {
        boolean bl2;
        Object v10 = this.b.get();
        if (v10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public boolean k8() {
        Throwable throwable;
        boolean bl2 = this.f;
        if (bl2 && (throwable = this.g) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            throwable = null;
        }
        return bl2;
    }

    public void onComplete() {
        boolean bl2 = this.f;
        if (!bl2 && !(bl2 = this.e)) {
            this.f = bl2 = true;
            this.r8();
            this.s8();
        }
    }

    public void onError(Throwable throwable) {
        String string2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(throwable, string2);
        boolean bl2 = this.f;
        if (!bl2 && !(bl2 = this.e)) {
            this.g = throwable;
            this.f = true;
            this.r8();
            this.s8();
            return;
        }
        e.a.a1.a.Y(throwable);
    }

    public void onNext(Object object) {
        Object object2 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = this.f;
        if (!bl2 && !(bl2 = this.e)) {
            object2 = this.a;
            ((e.a.w0.f.a)object2).offer(object);
            this.s8();
        }
    }

    public void onSubscribe(b b10) {
        boolean bl2 = this.f;
        if (bl2 || (bl2 = this.e)) {
            b10.dispose();
        }
    }

    public void r8() {
        AtomicReference atomicReference;
        boolean bl2;
        Runnable runnable = (Runnable)this.c.get();
        if (runnable != null && (bl2 = (atomicReference = this.c).compareAndSet(runnable, null))) {
            runnable.run();
        }
    }

    public void s8() {
        Object object = this.i;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 != 0) {
            return;
        }
        object = (g0)this.b.get();
        int n11 = 1;
        while (true) {
            if (object != null) {
                n11 = this.j;
                if (n11 != 0) {
                    this.t8((g0)object);
                } else {
                    this.u8((g0)object);
                }
                return;
            }
            object = this.i;
            n11 = -n11;
            if ((n11 = ((AtomicInteger)object).addAndGet(n11)) == 0) {
                return;
            }
            object = (g0)this.b.get();
        }
    }

    public void t8(g0 g02) {
        BasicIntQueueDisposable basicIntQueueDisposable;
        e.a.w0.f.a a10 = this.a;
        boolean bl2 = this.d;
        int n10 = 1;
        bl2 ^= n10;
        do {
            boolean bl3;
            boolean bl4;
            if (bl4 = this.e) {
                this.b.lazySet(null);
                return;
            }
            bl4 = this.f;
            if (bl2 && bl4 && (bl3 = this.w8(a10, g02))) {
                return;
            }
            g02.onNext(null);
            if (bl4) {
                this.v8(g02);
                return;
            }
            basicIntQueueDisposable = this.i;
            n10 = -n10;
        } while ((n10 = basicIntQueueDisposable.addAndGet(n10)) != 0);
    }

    public void u8(g0 g02) {
        e.a.w0.f.a a10 = this.a;
        boolean bl2 = this.d;
        int n10 = 1;
        bl2 ^= n10;
        int n11 = n10;
        int n12 = n10;
        while (true) {
            boolean bl3;
            if (bl3 = this.e) {
                this.b.lazySet(null);
                a10.clear();
                return;
            }
            bl3 = this.f;
            Object object = this.a.poll();
            int n13 = object == null ? n10 : 0;
            if (bl3) {
                if (bl2 && n11 != 0) {
                    n11 = (int)(this.w8(a10, g02) ? 1 : 0);
                    if (n11 != 0) {
                        return;
                    }
                    n11 = 0;
                }
                if (n13 != 0) {
                    this.v8(g02);
                    return;
                }
            }
            if (n13 != 0) {
                BasicIntQueueDisposable basicIntQueueDisposable = this.i;
                n12 = -n12;
                if ((n12 = basicIntQueueDisposable.addAndGet(n12)) != 0) continue;
                return;
            }
            g02.onNext(object);
        }
    }

    public void v8(g0 g02) {
        this.b.lazySet(null);
        Throwable throwable = this.g;
        if (throwable != null) {
            g02.onError(throwable);
        } else {
            g02.onComplete();
        }
    }

    public boolean w8(o o10, g0 g02) {
        Throwable throwable = this.g;
        if (throwable != null) {
            this.b.lazySet(null);
            o10.clear();
            g02.onError(throwable);
            return true;
        }
        return false;
    }
}

