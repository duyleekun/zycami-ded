/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w0.a.c;
import e.a.x0.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver;
import io.reactivex.internal.operators.observable.ObservableReplay$a;
import io.reactivex.internal.operators.observable.ObservableReplay$c;
import io.reactivex.internal.operators.observable.ObservableReplay$d;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import io.reactivex.internal.operators.observable.ObservableReplay$f;
import io.reactivex.internal.operators.observable.ObservableReplay$g;
import io.reactivex.internal.operators.observable.ObservableReplay$h;
import io.reactivex.internal.operators.observable.ObservableReplay$i;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay
extends a
implements e.a.w0.c.g,
c {
    public static final ObservableReplay$a e;
    public final e0 a;
    public final AtomicReference b;
    public final ObservableReplay$a c;
    public final e0 d;

    static {
        ObservableReplay$i observableReplay$i = new ObservableReplay$i();
        e = observableReplay$i;
    }

    private ObservableReplay(e0 e02, e0 e03, AtomicReference atomicReference, ObservableReplay$a observableReplay$a) {
        this.d = e02;
        this.a = e03;
        this.b = atomicReference;
        this.c = observableReplay$a;
    }

    public static a t8(e0 e02, int n10) {
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return ObservableReplay.x8(e02);
        }
        ObservableReplay$f observableReplay$f = new ObservableReplay$f(n10);
        return ObservableReplay.w8(e02, observableReplay$f);
    }

    public static a u8(e0 e02, long l10, TimeUnit timeUnit, h0 h02) {
        return ObservableReplay.v8(e02, l10, timeUnit, h02, -1 >>> 1);
    }

    public static a v8(e0 e02, long l10, TimeUnit timeUnit, h0 h02, int n10) {
        ObservableReplay$h observableReplay$h = new ObservableReplay$h(n10, l10, timeUnit, h02);
        return ObservableReplay.w8(e02, observableReplay$h);
    }

    public static a w8(e0 e02, ObservableReplay$a observableReplay$a) {
        AtomicReference atomicReference = new AtomicReference();
        ObservableReplay$g observableReplay$g = new ObservableReplay$g(atomicReference, observableReplay$a);
        ObservableReplay observableReplay = new ObservableReplay(observableReplay$g, e02, atomicReference, observableReplay$a);
        return e.a.a1.a.U(observableReplay);
    }

    public static a x8(e0 e02) {
        ObservableReplay$a observableReplay$a = e;
        return ObservableReplay.w8(e02, observableReplay$a);
    }

    public static z y8(Callable callable, o o10) {
        ObservableReplay$c observableReplay$c = new ObservableReplay$c(callable, o10);
        return e.a.a1.a.R(observableReplay$c);
    }

    public static a z8(a a10, h0 object) {
        object = a10.i4((h0)object);
        ObservableReplay$d observableReplay$d = new ObservableReplay$d(a10, (z)object);
        return e.a.a1.a.U(observableReplay$d);
    }

    public void K5(g0 g02) {
        this.d.subscribe(g02);
    }

    public void l8(g object) {
        Object object2;
        boolean bl2;
        Serializable serializable;
        while ((serializable = (ObservableReplay$ReplayObserver)this.b.get()) == null || (bl2 = ((ObservableReplay$ReplayObserver)serializable).isDisposed())) {
            object2 = this.c.call();
            object2 = this.b;
            ObservableReplay$ReplayObserver observableReplay$ReplayObserver = new ObservableReplay$ReplayObserver((ObservableReplay$e)object2);
            boolean bl3 = ((AtomicReference)object2).compareAndSet(serializable, observableReplay$ReplayObserver);
            if (!bl3) continue;
            serializable = observableReplay$ReplayObserver;
            break;
        }
        object2 = ((ObservableReplay$ReplayObserver)serializable).shouldConnect;
        bl2 = ((AtomicBoolean)object2).get();
        boolean bl4 = true;
        if (!bl2 && (bl2 = ((AtomicBoolean)(object2 = ((ObservableReplay$ReplayObserver)serializable).shouldConnect)).compareAndSet(false, bl4))) {
            bl2 = bl4;
        } else {
            bl2 = false;
            object2 = null;
        }
        try {
            object.accept(serializable);
            if (bl2) {
                object = this.a;
                object.subscribe((g0)((Object)serializable));
            }
            return;
        }
        catch (Throwable throwable) {
            if (bl2) {
                serializable = ((ObservableReplay$ReplayObserver)serializable).shouldConnect;
                ((AtomicBoolean)serializable).compareAndSet(bl4, false);
            }
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public void m(b b10) {
        AtomicReference atomicReference = this.b;
        b10 = (ObservableReplay$ReplayObserver)b10;
        atomicReference.compareAndSet(b10, null);
    }

    public e0 source() {
        return this.a;
    }
}

