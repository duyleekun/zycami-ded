/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.h0;
import e.a.j;
import e.a.s0.b;
import e.a.t0.a;
import e.a.v0.g;
import e.a.v0.o;
import e.a.w0.c.h;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber;
import io.reactivex.internal.operators.flowable.FlowableReplay$a;
import io.reactivex.internal.operators.flowable.FlowableReplay$b;
import io.reactivex.internal.operators.flowable.FlowableReplay$c;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.operators.flowable.FlowableReplay$e;
import io.reactivex.internal.operators.flowable.FlowableReplay$f;
import io.reactivex.internal.operators.flowable.FlowableReplay$g;
import io.reactivex.internal.util.ExceptionHelper;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableReplay
extends e.a.u0.a
implements h,
e.a.w0.a.c {
    public static final Callable f;
    public final j b;
    public final AtomicReference c;
    public final Callable d;
    public final c e;

    static {
        FlowableReplay$b flowableReplay$b = new FlowableReplay$b();
        f = flowableReplay$b;
    }

    private FlowableReplay(c c10, j j10, AtomicReference atomicReference, Callable callable) {
        this.e = c10;
        this.b = j10;
        this.c = atomicReference;
        this.d = callable;
    }

    public static e.a.u0.a W8(j j10, int n10) {
        int n11 = -1 >>> 1;
        if (n10 == n11) {
            return FlowableReplay.a9(j10);
        }
        FlowableReplay$e flowableReplay$e = new FlowableReplay$e(n10);
        return FlowableReplay.Z8(j10, flowableReplay$e);
    }

    public static e.a.u0.a X8(j j10, long l10, TimeUnit timeUnit, h0 h02) {
        return FlowableReplay.Y8(j10, l10, timeUnit, h02, -1 >>> 1);
    }

    public static e.a.u0.a Y8(j j10, long l10, TimeUnit timeUnit, h0 h02, int n10) {
        FlowableReplay$g flowableReplay$g = new FlowableReplay$g(n10, l10, timeUnit, h02);
        return FlowableReplay.Z8(j10, flowableReplay$g);
    }

    public static e.a.u0.a Z8(j j10, Callable callable) {
        AtomicReference atomicReference = new AtomicReference();
        FlowableReplay$f flowableReplay$f = new FlowableReplay$f(atomicReference, callable);
        FlowableReplay flowableReplay = new FlowableReplay(flowableReplay$f, j10, atomicReference, callable);
        return e.a.a1.a.T(flowableReplay);
    }

    public static e.a.u0.a a9(j j10) {
        Callable callable = f;
        return FlowableReplay.Z8(j10, callable);
    }

    public static j b9(Callable callable, o o10) {
        FlowableReplay$c flowableReplay$c = new FlowableReplay$c(callable, o10);
        return flowableReplay$c;
    }

    public static e.a.u0.a c9(e.a.u0.a a10, h0 object) {
        object = a10.s4((h0)object);
        FlowableReplay$a flowableReplay$a = new FlowableReplay$a(a10, (j)object);
        return e.a.a1.a.T(flowableReplay$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void O8(g object) {
        Object object2;
        boolean bl2;
        Serializable serializable;
        while ((serializable = (FlowableReplay$ReplaySubscriber)this.c.get()) == null || (bl2 = ((FlowableReplay$ReplaySubscriber)serializable).isDisposed())) {
            try {
                object2 = this.d;
                object2 = object2.call();
                object2 = (FlowableReplay$d)object2;
                FlowableReplay$ReplaySubscriber flowableReplay$ReplaySubscriber = new FlowableReplay$ReplaySubscriber((FlowableReplay$d)object2);
                object2 = this.c;
                boolean bl3 = ((AtomicReference)object2).compareAndSet(serializable, flowableReplay$ReplaySubscriber);
                if (!bl3) continue;
                serializable = flowableReplay$ReplaySubscriber;
                break;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                throw ExceptionHelper.f(throwable);
            }
        }
        object2 = ((FlowableReplay$ReplaySubscriber)serializable).shouldConnect;
        bl2 = ((AtomicBoolean)object2).get();
        boolean bl4 = true;
        if (!bl2 && (bl2 = ((AtomicBoolean)(object2 = ((FlowableReplay$ReplaySubscriber)serializable).shouldConnect)).compareAndSet(false, bl4))) {
            bl2 = bl4;
        } else {
            bl2 = false;
            object2 = null;
        }
        try {
            object.accept(serializable);
            if (bl2) {
                object = this.b;
                ((j)object).l6((e.a.o)((Object)serializable));
            }
            return;
        }
        catch (Throwable throwable) {
            if (bl2) {
                serializable = ((FlowableReplay$ReplaySubscriber)serializable).shouldConnect;
                ((AtomicBoolean)serializable).compareAndSet(bl4, false);
            }
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
    }

    public void m(b b10) {
        AtomicReference atomicReference = this.c;
        b10 = (FlowableReplay$ReplaySubscriber)b10;
        atomicReference.compareAndSet(b10, null);
    }

    public void m6(d d10) {
        this.e.subscribe(d10);
    }

    public c source() {
        return this.b;
    }
}

