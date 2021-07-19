/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.o0;
import e.a.t0.a;
import e.a.v0.b;
import e.a.v0.c;
import e.a.v0.d;
import e.a.v0.e;
import e.a.v0.g;
import e.a.v0.h;
import e.a.v0.i;
import e.a.v0.j;
import e.a.v0.k;
import e.a.v0.l;
import e.a.v0.m;
import e.a.v0.o;
import e.a.v0.r;
import e.a.w;
import e.a.w0.e.b.d0;
import e.a.w0.e.b.n;
import e.a.w0.e.c.a0;
import e.a.w0.e.c.b0;
import e.a.w0.e.c.c0;
import e.a.w0.e.c.e0;
import e.a.w0.e.c.f;
import e.a.w0.e.c.f0;
import e.a.w0.e.c.g0;
import e.a.w0.e.c.h0;
import e.a.w0.e.c.i0;
import e.a.w0.e.c.j0;
import e.a.w0.e.c.k0;
import e.a.w0.e.c.p;
import e.a.w0.e.c.s;
import e.a.w0.e.c.t;
import e.a.w0.e.c.u;
import e.a.w0.e.c.v;
import e.a.w0.e.c.x;
import e.a.w0.e.c.z;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class q
implements w {
    public static e.a.j A(w ... object) {
        int n10 = ((w[])object).length;
        if (n10 == 0) {
            return e.a.j.r2();
        }
        n10 = ((w[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            object = object[0];
            MaybeToFlowable maybeToFlowable = new MaybeToFlowable((w)object);
            return e.a.a1.a.P(maybeToFlowable);
        }
        MaybeConcatArrayDelayError maybeConcatArrayDelayError = new MaybeConcatArrayDelayError((w[])object);
        return e.a.a1.a.P(maybeConcatArrayDelayError);
    }

    public static e.a.j B(w ... object) {
        object = e.a.j.Y2((Object[])object);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)object).h1(o10);
    }

    public static q B0(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        a0 a02 = new a0(object);
        return e.a.a1.a.Q(a02);
    }

    public static e.a.j C(Iterable object) {
        e.a.w0.b.a.g(object, "sources is null");
        object = e.a.j.e3((Iterable)object);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)object).f1(o10);
    }

    public static e.a.j D(i.g.c c10) {
        c10 = e.a.j.f3(c10);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)c10).f1(o10);
    }

    public static e.a.j E(Iterable object) {
        object = e.a.j.e3((Iterable)object);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)object).h1(o10);
    }

    public static e.a.j F(i.g.c c10) {
        c10 = e.a.j.f3(c10);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)c10).h1(o10);
    }

    public static e.a.j F0(w w10, w w11) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        w[] wArray = new w[]{w10, w11};
        return q.M0(wArray);
    }

    public static e.a.j G0(w w10, w w11, w w12) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        w[] wArray = new w[]{w10, w11, w12};
        return q.M0(wArray);
    }

    public static e.a.j H0(w w10, w w11, w w12, w w13) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        w[] wArray = new w[]{w10, w11, w12, w13};
        return q.M0(wArray);
    }

    public static q H1(long l10, TimeUnit timeUnit) {
        e.a.h0 h02 = e.a.c1.b.a();
        return q.I1(l10, timeUnit, h02);
    }

    public static e.a.j I0(Iterable iterable) {
        return q.J0(e.a.j.e3(iterable));
    }

    public static q I1(long l10, TimeUnit timeUnit, e.a.h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        l10 = Math.max(0L, l10);
        MaybeTimer maybeTimer = new MaybeTimer(l10, timeUnit, h02);
        return e.a.a1.a.Q(maybeTimer);
    }

    public static e.a.j J0(i.g.c c10) {
        return q.K0(c10, -1 >>> 1);
    }

    public static q K(e.a.u u10) {
        e.a.w0.b.a.g(u10, "onSubscribe is null");
        MaybeCreate maybeCreate = new MaybeCreate(u10);
        return e.a.a1.a.Q(maybeCreate);
    }

    public static e.a.j K0(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "source is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        o o10 = MaybeToPublisher.instance();
        d0 d02 = new d0(c10, o10, false, n10, 1);
        return e.a.a1.a.P(d02);
    }

    public static q L0(w w10) {
        e.a.w0.b.a.g(w10, "source is null");
        o o10 = Functions.k();
        MaybeFlatten maybeFlatten = new MaybeFlatten(w10, o10);
        return e.a.a1.a.Q(maybeFlatten);
    }

    public static q M(Callable callable) {
        e.a.w0.b.a.g(callable, "maybeSupplier is null");
        e.a.w0.e.c.e e10 = new e.a.w0.e.c.e(callable);
        return e.a.a1.a.Q(e10);
    }

    public static e.a.j M0(w ... object) {
        Object object2 = "sources is null";
        e.a.w0.b.a.g(object, (String)object2);
        int n10 = ((w[])object).length;
        if (n10 == 0) {
            return e.a.j.r2();
        }
        n10 = ((w[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            object = object[0];
            object2 = new MaybeToFlowable((w)object);
            return e.a.a1.a.P((e.a.j)object2);
        }
        object2 = new MaybeMergeArray((w[])object);
        return e.a.a1.a.P((e.a.j)object2);
    }

    public static e.a.j N0(w ... wArray) {
        int n10 = wArray.length;
        if (n10 == 0) {
            return e.a.j.r2();
        }
        e.a.j j10 = e.a.j.Y2(wArray);
        o o10 = MaybeToPublisher.instance();
        int n11 = wArray.length;
        return j10.I2(o10, true, n11);
    }

    public static e.a.j O0(w w10, w w11) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        w[] wArray = new w[]{w10, w11};
        return q.N0(wArray);
    }

    public static q O1(w object) {
        boolean bl2 = object instanceof q;
        if (!bl2) {
            e.a.w0.b.a.g(object, "onSubscribe is null");
            j0 j02 = new j0((w)object);
            return e.a.a1.a.Q(j02);
        }
        object = new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        throw object;
    }

    public static e.a.j P0(w w10, w w11, w w12) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        w[] wArray = new w[]{w10, w11, w12};
        return q.N0(wArray);
    }

    public static e.a.j Q0(w w10, w w11, w w12, w w13) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        w[] wArray = new w[]{w10, w11, w12, w13};
        return q.N0(wArray);
    }

    public static q Q1(Callable callable, o o10, g g10) {
        return q.R1(callable, o10, g10, true);
    }

    public static e.a.j R0(Iterable object) {
        object = e.a.j.e3((Iterable)object);
        o o10 = MaybeToPublisher.instance();
        return ((e.a.j)object).H2(o10, true);
    }

    public static q R1(Callable callable, o o10, g g10, boolean bl2) {
        e.a.w0.b.a.g(callable, "resourceSupplier is null");
        e.a.w0.b.a.g(o10, "sourceSupplier is null");
        e.a.w0.b.a.g(g10, "disposer is null");
        MaybeUsing maybeUsing = new MaybeUsing(callable, o10, g10, bl2);
        return e.a.a1.a.Q(maybeUsing);
    }

    public static e.a.j S0(i.g.c c10) {
        return q.T0(c10, -1 >>> 1);
    }

    public static q S1(w w10) {
        boolean bl2 = w10 instanceof q;
        if (bl2) {
            return e.a.a1.a.Q((q)w10);
        }
        e.a.w0.b.a.g(w10, "onSubscribe is null");
        j0 j02 = new j0(w10);
        return e.a.a1.a.Q(j02);
    }

    public static e.a.j T0(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "source is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        o o10 = MaybeToPublisher.instance();
        d0 d02 = new d0(c10, o10, true, n10, 1);
        return e.a.a1.a.P(d02);
    }

    public static q T1(w w10, w w11, w w12, w w13, w w14, w w15, w w16, w w17, w w18, e.a.v0.n object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        e.a.w0.b.a.g(w14, "source5 is null");
        e.a.w0.b.a.g(w15, "source6 is null");
        e.a.w0.b.a.g(w16, "source7 is null");
        e.a.w0.b.a.g(w17, "source8 is null");
        e.a.w0.b.a.g(w18, "source9 is null");
        object = Functions.E((e.a.v0.n)object);
        w[] wArray = new w[]{w10, w11, w12, w13, w14, w15, w16, w17, w18};
        return q.c2((o)object, wArray);
    }

    public static q U1(w w10, w w11, w w12, w w13, w w14, w w15, w w16, w w17, m object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        e.a.w0.b.a.g(w14, "source5 is null");
        e.a.w0.b.a.g(w15, "source6 is null");
        e.a.w0.b.a.g(w16, "source7 is null");
        e.a.w0.b.a.g(w17, "source8 is null");
        object = Functions.D((m)object);
        w[] wArray = new w[]{w10, w11, w12, w13, w14, w15, w16, w17};
        return q.c2((o)object, wArray);
    }

    public static q V0() {
        return e.a.a1.a.Q(e0.a);
    }

    public static q V1(w w10, w w11, w w12, w w13, w w14, w w15, w w16, l object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        e.a.w0.b.a.g(w14, "source5 is null");
        e.a.w0.b.a.g(w15, "source6 is null");
        e.a.w0.b.a.g(w16, "source7 is null");
        object = Functions.C((l)object);
        w[] wArray = new w[]{w10, w11, w12, w13, w14, w15, w16};
        return q.c2((o)object, wArray);
    }

    public static q W1(w w10, w w11, w w12, w w13, w w14, w w15, k object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        e.a.w0.b.a.g(w14, "source5 is null");
        e.a.w0.b.a.g(w15, "source6 is null");
        object = Functions.B((k)object);
        w[] wArray = new w[]{w10, w11, w12, w13, w14, w15};
        return q.c2((o)object, wArray);
    }

    public static q X1(w w10, w w11, w w12, w w13, w w14, j object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        e.a.w0.b.a.g(w14, "source5 is null");
        object = Functions.A((j)object);
        w[] wArray = new w[]{w10, w11, w12, w13, w14};
        return q.c2((o)object, wArray);
    }

    public static q Y1(w w10, w w11, w w12, w w13, i object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        object = Functions.z((i)object);
        w[] wArray = new w[]{w10, w11, w12, w13};
        return q.c2((o)object, wArray);
    }

    public static q Z1(w w10, w w11, w w12, h object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        object = Functions.y((h)object);
        w[] wArray = new w[]{w10, w11, w12};
        return q.c2((o)object, wArray);
    }

    public static q a2(w w10, w w11, c object) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        object = Functions.x((c)object);
        w[] wArray = new w[]{w10, w11};
        return q.c2((o)object, wArray);
    }

    public static q b2(Iterable iterable, o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        k0 k02 = new k0(iterable, o10);
        return e.a.a1.a.Q(k02);
    }

    public static q c2(o o10, w ... wArray) {
        Object object = "sources is null";
        e.a.w0.b.a.g(wArray, (String)object);
        int n10 = wArray.length;
        if (n10 == 0) {
            return q.d0();
        }
        e.a.w0.b.a.g(o10, "zipper is null");
        object = new MaybeZipArray(wArray, o10);
        return e.a.a1.a.Q((q)object);
    }

    public static q d0() {
        return e.a.a1.a.Q(e.a.w0.e.c.j.a);
    }

    public static q e0(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "exception is null");
        e.a.w0.e.c.k k10 = new e.a.w0.e.c.k(throwable);
        return e.a.a1.a.Q(k10);
    }

    public static q f0(Callable callable) {
        e.a.w0.b.a.g(callable, "errorSupplier is null");
        e.a.w0.e.c.l l10 = new e.a.w0.e.c.l(callable);
        return e.a.a1.a.Q(l10);
    }

    public static q j(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.e.c.b b10 = new e.a.w0.e.c.b(null, iterable);
        return e.a.a1.a.Q(b10);
    }

    public static q k(w ... wArray) {
        int n10 = wArray.length;
        if (n10 == 0) {
            return q.d0();
        }
        n10 = wArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return q.S1(wArray[0]);
        }
        e.a.w0.e.c.b b10 = new e.a.w0.e.c.b(wArray, null);
        return e.a.a1.a.Q(b10);
    }

    public static q r0(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "run is null");
        p p10 = new p(a10);
        return e.a.a1.a.Q(p10);
    }

    public static e.a.i0 r1(w w10, w w11) {
        d d10 = e.a.w0.b.a.d();
        return q.s1(w10, w11, d10);
    }

    public static q s0(Callable callable) {
        e.a.w0.b.a.g(callable, "callable is null");
        e.a.w0.e.c.q q10 = new e.a.w0.e.c.q(callable);
        return e.a.a1.a.Q(q10);
    }

    public static e.a.i0 s1(w w10, w w11, d d10) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(d10, "isEqual is null");
        MaybeEqualSingle maybeEqualSingle = new MaybeEqualSingle(w10, w11, d10);
        return e.a.a1.a.S(maybeEqualSingle);
    }

    public static e.a.j t(w w10, w w11) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        w[] wArray = new w[]{w10, w11};
        return q.z(wArray);
    }

    public static q t0(e.a.g g10) {
        e.a.w0.b.a.g(g10, "completableSource is null");
        e.a.w0.e.c.r r10 = new e.a.w0.e.c.r(g10);
        return e.a.a1.a.Q(r10);
    }

    public static e.a.j u(w w10, w w11, w w12) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        w[] wArray = new w[]{w10, w11, w12};
        return q.z(wArray);
    }

    public static q u0(Future future) {
        e.a.w0.b.a.g(future, "future is null");
        s s10 = new s(future, 0L, null);
        return e.a.a1.a.Q(s10);
    }

    public static e.a.j v(w w10, w w11, w w12, w w13) {
        e.a.w0.b.a.g(w10, "source1 is null");
        e.a.w0.b.a.g(w11, "source2 is null");
        e.a.w0.b.a.g(w12, "source3 is null");
        e.a.w0.b.a.g(w13, "source4 is null");
        w[] wArray = new w[]{w10, w11, w12, w13};
        return q.z(wArray);
    }

    public static q v0(Future future, long l10, TimeUnit timeUnit) {
        e.a.w0.b.a.g(future, "future is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        s s10 = new s(future, l10, timeUnit);
        return e.a.a1.a.Q(s10);
    }

    public static e.a.j w(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        MaybeConcatIterable maybeConcatIterable = new MaybeConcatIterable(iterable);
        return e.a.a1.a.P(maybeConcatIterable);
    }

    public static q w0(Runnable runnable) {
        e.a.w0.b.a.g(runnable, "run is null");
        t t10 = new t(runnable);
        return e.a.a1.a.Q(t10);
    }

    public static e.a.j x(i.g.c c10) {
        return q.y(c10, 2);
    }

    public static q x0(o0 o02) {
        e.a.w0.b.a.g(o02, "singleSource is null");
        u u10 = new u(o02);
        return e.a.a1.a.Q(u10);
    }

    public static e.a.j y(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch");
        o o10 = MaybeToPublisher.instance();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        n n11 = new n(c10, o10, n10, errorMode);
        return e.a.a1.a.P(n11);
    }

    public static e.a.j z(w ... object) {
        Object object2 = "sources is null";
        e.a.w0.b.a.g(object, (String)object2);
        int n10 = ((w[])object).length;
        if (n10 == 0) {
            return e.a.j.r2();
        }
        n10 = ((w[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            object = object[0];
            object2 = new MaybeToFlowable((w)object);
            return e.a.a1.a.P((e.a.j)object2);
        }
        object2 = new MaybeConcatArray((w[])object);
        return e.a.a1.a.P((e.a.j)object2);
    }

    public final e.a.i0 A0() {
        z z10 = new z(this);
        return e.a.a1.a.S(z10);
    }

    public final q A1(long l10, TimeUnit timeUnit, w w10) {
        e.a.w0.b.a.g(w10, "fallback is null");
        e.a.h0 h02 = e.a.c1.b.a();
        return this.C1(l10, timeUnit, h02, w10);
    }

    public final q B1(long l10, TimeUnit timeUnit, e.a.h0 h02) {
        q q10 = q.I1(l10, timeUnit, h02);
        return this.D1(q10);
    }

    public final q C0(e.a.v v10) {
        e.a.w0.b.a.g(v10, "lift is null");
        b0 b02 = new b0(this, v10);
        return e.a.a1.a.Q(b02);
    }

    public final q C1(long l10, TimeUnit timeUnit, e.a.h0 h02, w w10) {
        e.a.w0.b.a.g(w10, "fallback is null");
        q q10 = q.I1(l10, timeUnit, h02);
        return this.E1(q10, w10);
    }

    public final q D0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        c0 c02 = new c0(this, o10);
        return e.a.a1.a.Q(c02);
    }

    public final q D1(w w10) {
        e.a.w0.b.a.g(w10, "timeoutIndicator is null");
        MaybeTimeoutMaybe maybeTimeoutMaybe = new MaybeTimeoutMaybe(this, w10, null);
        return e.a.a1.a.Q(maybeTimeoutMaybe);
    }

    public final e.a.i0 E0() {
        e.a.w0.e.c.d0 d02 = new e.a.w0.e.c.d0(this);
        return e.a.a1.a.S(d02);
    }

    public final q E1(w w10, w w11) {
        e.a.w0.b.a.g(w10, "timeoutIndicator is null");
        e.a.w0.b.a.g(w11, "fallback is null");
        MaybeTimeoutMaybe maybeTimeoutMaybe = new MaybeTimeoutMaybe(this, w10, w11);
        return e.a.a1.a.Q(maybeTimeoutMaybe);
    }

    public final q F1(i.g.c c10) {
        e.a.w0.b.a.g(c10, "timeoutIndicator is null");
        MaybeTimeoutPublisher maybeTimeoutPublisher = new MaybeTimeoutPublisher(this, c10, null);
        return e.a.a1.a.Q(maybeTimeoutPublisher);
    }

    public final q G(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatten maybeFlatten = new MaybeFlatten(this, o10);
        return e.a.a1.a.Q(maybeFlatten);
    }

    public final q G1(i.g.c c10, w w10) {
        e.a.w0.b.a.g(c10, "timeoutIndicator is null");
        e.a.w0.b.a.g(w10, "fallback is null");
        MaybeTimeoutPublisher maybeTimeoutPublisher = new MaybeTimeoutPublisher(this, c10, w10);
        return e.a.a1.a.Q(maybeTimeoutPublisher);
    }

    public final e.a.j H(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        return q.t(this, w10);
    }

    public final e.a.i0 I(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        e.a.w0.e.c.c c10 = new e.a.w0.e.c.c(this, object);
        return e.a.a1.a.S(c10);
    }

    public final e.a.i0 J() {
        e.a.w0.e.c.d d10 = new e.a.w0.e.c.d(this);
        return e.a.a1.a.S(d10);
    }

    public final Object J1(o object) {
        String string2 = "convert is null";
        try {
            object = e.a.w0.b.a.g(object, string2);
        }
        catch (Throwable throwable) {
            a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
        object = (o)object;
        return object.apply(this);
    }

    public final e.a.j K1() {
        boolean bl2 = this instanceof e.a.w0.c.b;
        if (bl2) {
            q q10 = this;
            return ((e.a.w0.c.b)((Object)this)).l();
        }
        MaybeToFlowable maybeToFlowable = new MaybeToFlowable(this);
        return e.a.a1.a.P(maybeToFlowable);
    }

    public final q L(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        object = q.B0(object);
        return this.v1((w)object);
    }

    public final e.a.z L1() {
        boolean bl2 = this instanceof e.a.w0.c.d;
        if (bl2) {
            q q10 = this;
            return ((e.a.w0.c.d)((Object)this)).i();
        }
        MaybeToObservable maybeToObservable = new MaybeToObservable(this);
        return e.a.a1.a.R(maybeToObservable);
    }

    public final e.a.i0 M1() {
        i0 i02 = new i0(this, null);
        return e.a.a1.a.S(i02);
    }

    public final q N(long l10, TimeUnit timeUnit) {
        e.a.h0 h02 = e.a.c1.b.a();
        return this.O(l10, timeUnit, h02);
    }

    public final e.a.i0 N1(Object object) {
        e.a.w0.b.a.g(object, "defaultValue is null");
        i0 i02 = new i0(this, object);
        return e.a.a1.a.S(i02);
    }

    public final q O(long l10, TimeUnit timeUnit, e.a.h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        long l11 = Math.max(0L, l10);
        MaybeDelay maybeDelay = new MaybeDelay(this, l11, timeUnit, h02);
        return e.a.a1.a.Q(maybeDelay);
    }

    public final q P(i.g.c c10) {
        e.a.w0.b.a.g(c10, "delayIndicator is null");
        MaybeDelayOtherPublisher maybeDelayOtherPublisher = new MaybeDelayOtherPublisher(this, c10);
        return e.a.a1.a.Q(maybeDelayOtherPublisher);
    }

    public final q P1(e.a.h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        MaybeUnsubscribeOn maybeUnsubscribeOn = new MaybeUnsubscribeOn(this, h02);
        return e.a.a1.a.Q(maybeUnsubscribeOn);
    }

    public final q Q(long l10, TimeUnit timeUnit) {
        e.a.h0 h02 = e.a.c1.b.a();
        return this.R(l10, timeUnit, h02);
    }

    public final q R(long l10, TimeUnit timeUnit, e.a.h0 h02) {
        e.a.j j10 = e.a.j.t7(l10, timeUnit, h02);
        return this.S(j10);
    }

    public final q S(i.g.c c10) {
        e.a.w0.b.a.g(c10, "subscriptionIndicator is null");
        MaybeDelaySubscriptionOtherPublisher maybeDelaySubscriptionOtherPublisher = new MaybeDelaySubscriptionOtherPublisher(this, c10);
        return e.a.a1.a.Q(maybeDelaySubscriptionOtherPublisher);
    }

    public final q T(g g10) {
        e.a.w0.b.a.g(g10, "onAfterSuccess is null");
        e.a.w0.e.c.g g11 = new e.a.w0.e.c.g(this, g10);
        return e.a.a1.a.Q(g11);
    }

    public final q U(e.a.v0.a object) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        Object object2 = object = e.a.w0.b.a.g(object, "onAfterTerminate is null");
        object2 = (e.a.v0.a)object;
        h0 h02 = new h0(this, g10, g11, g12, a10, (e.a.v0.a)object2, a10);
        return e.a.a1.a.Q(h02);
    }

    public final e.a.j U0(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        return q.F0(this, w10);
    }

    public final q V(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        MaybeDoFinally maybeDoFinally = new MaybeDoFinally(this, a10);
        return e.a.a1.a.Q(maybeDoFinally);
    }

    public final q W(e.a.v0.a object) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        g g12 = Functions.h();
        Object object2 = object = e.a.w0.b.a.g(object, "onComplete is null");
        object2 = (e.a.v0.a)object;
        e.a.v0.a a10 = Functions.c;
        h0 h02 = new h0(this, g10, g11, g12, (e.a.v0.a)object2, a10, a10);
        return e.a.a1.a.Q(h02);
    }

    public final q W0(e.a.h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        MaybeObserveOn maybeObserveOn = new MaybeObserveOn(this, h02);
        return e.a.a1.a.Q(maybeObserveOn);
    }

    public final q X(e.a.v0.a object) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        Object object2 = object = e.a.w0.b.a.g(object, "onDispose is null");
        object2 = (e.a.v0.a)object;
        h0 h02 = new h0(this, g10, g11, g12, a10, a10, (e.a.v0.a)object2);
        return e.a.a1.a.Q(h02);
    }

    public final q X0(Class clazz) {
        e.a.w0.b.a.g(clazz, "clazz is null");
        r r10 = Functions.l(clazz);
        return this.g0(r10).r(clazz);
    }

    public final q Y(g object) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        Object object2 = object = e.a.w0.b.a.g(object, "onError is null");
        object2 = (g)object;
        e.a.v0.a a10 = Functions.c;
        h0 h02 = new h0(this, g10, g11, (g)object2, a10, a10, a10);
        return e.a.a1.a.Q(h02);
    }

    public final q Y0() {
        r r10 = Functions.c();
        return this.Z0(r10);
    }

    public final q Z(b b10) {
        e.a.w0.b.a.g(b10, "onEvent is null");
        e.a.w0.e.c.h h10 = new e.a.w0.e.c.h(this, b10);
        return e.a.a1.a.Q(h10);
    }

    public final q Z0(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        f0 f02 = new f0(this, r10);
        return e.a.a1.a.Q(f02);
    }

    public final e.a.s0.b a() {
        g g10 = Functions.h();
        g g11 = Functions.f;
        e.a.v0.a a10 = Functions.c;
        return this.f(g10, g11, a10);
    }

    public final q a0(g object) {
        Object object2 = object = e.a.w0.b.a.g(object, "onSubscribe is null");
        object2 = (g)object;
        g g10 = Functions.h();
        g g11 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        h0 h02 = new h0(this, (g)object2, g10, g11, a10, a10, a10);
        return e.a.a1.a.Q(h02);
    }

    public final q a1(w object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        return this.b1((o)object);
    }

    public final TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.g(testObserver);
        return testObserver;
    }

    public final q b0(g object) {
        g g10 = Functions.h();
        Object object2 = object = e.a.w0.b.a.g(object, "onSuccess is null");
        object2 = (g)object;
        g g11 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        h0 h02 = new h0(this, g10, (g)object2, g11, a10, a10, a10);
        return e.a.a1.a.Q(h02);
    }

    public final q b1(o o10) {
        e.a.w0.b.a.g(o10, "resumeFunction is null");
        MaybeOnErrorNext maybeOnErrorNext = new MaybeOnErrorNext(this, o10, true);
        return e.a.a1.a.Q(maybeOnErrorNext);
    }

    public final e.a.s0.b c(g g10, g g11) {
        e.a.v0.a a10 = Functions.c;
        return this.f(g10, g11, a10);
    }

    public final q c0(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onTerminate is null");
        e.a.w0.e.c.i i10 = new e.a.w0.e.c.i(this, a10);
        return e.a.a1.a.Q(i10);
    }

    public final q c1(o o10) {
        e.a.w0.b.a.g(o10, "valueSupplier is null");
        g0 g02 = new g0(this, o10);
        return e.a.a1.a.Q(g02);
    }

    public final e.a.s0.b d(g g10) {
        g g11 = Functions.f;
        e.a.v0.a a10 = Functions.c;
        return this.f(g10, g11, a10);
    }

    public final q d1(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        object = Functions.n(object);
        return this.c1((o)object);
    }

    public final q d2(w w10, c c10) {
        e.a.w0.b.a.g(w10, "other is null");
        return q.a2(this, w10, c10);
    }

    public final TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.cancel();
        }
        this.g(testObserver);
        return testObserver;
    }

    public final q e1(w object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        MaybeOnErrorNext maybeOnErrorNext = new MaybeOnErrorNext(this, (o)object, false);
        return e.a.a1.a.Q(maybeOnErrorNext);
    }

    public final e.a.s0.b f(g g10, g g11, e.a.v0.a a10) {
        e.a.w0.b.a.g(g10, "onSuccess is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        MaybeCallbackObserver maybeCallbackObserver = new MaybeCallbackObserver(g10, g11, a10);
        return (e.a.s0.b)((Object)this.h(maybeCallbackObserver));
    }

    public final q f1() {
        f f10 = new f(this);
        return e.a.a1.a.Q(f10);
    }

    public final void g(e.a.t t10) {
        e.a.w0.b.a.g(t10, "observer is null");
        t10 = e.a.a1.a.e0(this, t10);
        Object object = "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins";
        e.a.w0.b.a.g(t10, (String)object);
        try {
            this.t1(t10);
            return;
        }
        catch (Throwable throwable) {
            a.b(throwable);
            object = new NullPointerException("subscribeActual failed");
            ((Throwable)object).initCause(throwable);
            throw object;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    public final q g0(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        e.a.w0.e.c.m m10 = new e.a.w0.e.c.m(this, r10);
        return e.a.a1.a.Q(m10);
    }

    public final e.a.j g1() {
        return this.h1(Long.MAX_VALUE);
    }

    public final e.a.t h(e.a.t t10) {
        this.g(t10);
        return t10;
    }

    public final q h0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatten maybeFlatten = new MaybeFlatten(this, o10);
        return e.a.a1.a.Q(maybeFlatten);
    }

    public final e.a.j h1(long l10) {
        return this.K1().b5(l10);
    }

    public final q i0(o o10, c c10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        MaybeFlatMapBiSelector maybeFlatMapBiSelector = new MaybeFlatMapBiSelector(this, o10, c10);
        return e.a.a1.a.Q(maybeFlatMapBiSelector);
    }

    public final e.a.j i1(e e10) {
        return this.K1().c5(e10);
    }

    public final q j0(o o10, o o11, Callable callable) {
        e.a.w0.b.a.g(o10, "onSuccessMapper is null");
        e.a.w0.b.a.g(o11, "onErrorMapper is null");
        e.a.w0.b.a.g(callable, "onCompleteSupplier is null");
        MaybeFlatMapNotification maybeFlatMapNotification = new MaybeFlatMapNotification(this, o10, o11, callable);
        return e.a.a1.a.Q(maybeFlatMapNotification);
    }

    public final e.a.j j1(o o10) {
        return this.K1().d5(o10);
    }

    public final e.a.a k0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapCompletable maybeFlatMapCompletable = new MaybeFlatMapCompletable(this, o10);
        return e.a.a1.a.O(maybeFlatMapCompletable);
    }

    public final q k1() {
        r r10 = Functions.c();
        return this.m1(Long.MAX_VALUE, r10);
    }

    public final e.a.z l0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapObservable maybeFlatMapObservable = new MaybeFlatMapObservable(this, o10);
        return e.a.a1.a.R(maybeFlatMapObservable);
    }

    public final q l1(long l10) {
        r r10 = Functions.c();
        return this.m1(l10, r10);
    }

    public final q m(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        w[] wArray = new w[]{this, w10};
        return q.k(wArray);
    }

    public final e.a.j m0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapPublisher maybeFlatMapPublisher = new MaybeFlatMapPublisher(this, o10);
        return e.a.a1.a.P(maybeFlatMapPublisher);
    }

    public final q m1(long l10, r r10) {
        return this.K1().w5(l10, r10).S5();
    }

    public final Object n(e.a.r r10) {
        return ((e.a.r)e.a.w0.b.a.g(r10, "converter is null")).f(this);
    }

    public final e.a.i0 n0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapSingle maybeFlatMapSingle = new MaybeFlatMapSingle(this, o10);
        return e.a.a1.a.S(maybeFlatMapSingle);
    }

    public final q n1(d d10) {
        return this.K1().x5(d10).S5();
    }

    public final Object o() {
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.g(f10);
        return f10.b();
    }

    public final q o0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapSingleElement maybeFlatMapSingleElement = new MaybeFlatMapSingleElement(this, o10);
        return e.a.a1.a.Q(maybeFlatMapSingleElement);
    }

    public final q o1(r r10) {
        return this.m1(Long.MAX_VALUE, r10);
    }

    public final Object p(Object object) {
        e.a.w0.b.a.g(object, "defaultValue is null");
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.g(f10);
        return f10.c(object);
    }

    public final e.a.j p0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        MaybeFlatMapIterableFlowable maybeFlatMapIterableFlowable = new MaybeFlatMapIterableFlowable(this, o10);
        return e.a.a1.a.P(maybeFlatMapIterableFlowable);
    }

    public final q p1(e object) {
        e.a.w0.b.a.g(object, "stop is null");
        object = Functions.v((e)object);
        return this.m1(Long.MAX_VALUE, (r)object);
    }

    public final q q() {
        MaybeCache maybeCache = new MaybeCache(this);
        return e.a.a1.a.Q(maybeCache);
    }

    public final e.a.z q0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.e.c.o o11 = new e.a.w0.e.c.o(this, o10);
        return e.a.a1.a.R(o11);
    }

    public final q q1(o o10) {
        return this.K1().A5(o10).S5();
    }

    public final q r(Class object) {
        e.a.w0.b.a.g(object, "clazz is null");
        object = Functions.e((Class)object);
        return this.D0((o)object);
    }

    public final q s(e.a.x x10) {
        return q.S1(((e.a.x)e.a.w0.b.a.g(x10, "transformer is null")).f(this));
    }

    public abstract void t1(e.a.t var1);

    public final q u1(e.a.h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        MaybeSubscribeOn maybeSubscribeOn = new MaybeSubscribeOn(this, h02);
        return e.a.a1.a.Q(maybeSubscribeOn);
    }

    public final q v1(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        MaybeSwitchIfEmpty maybeSwitchIfEmpty = new MaybeSwitchIfEmpty(this, w10);
        return e.a.a1.a.Q(maybeSwitchIfEmpty);
    }

    public final e.a.i0 w1(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        MaybeSwitchIfEmptySingle maybeSwitchIfEmptySingle = new MaybeSwitchIfEmptySingle(this, o02);
        return e.a.a1.a.S(maybeSwitchIfEmptySingle);
    }

    public final q x1(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        MaybeTakeUntilMaybe maybeTakeUntilMaybe = new MaybeTakeUntilMaybe(this, w10);
        return e.a.a1.a.Q(maybeTakeUntilMaybe);
    }

    public final q y0() {
        v v10 = new v(this);
        return e.a.a1.a.Q(v10);
    }

    public final q y1(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        MaybeTakeUntilPublisher maybeTakeUntilPublisher = new MaybeTakeUntilPublisher(this, c10);
        return e.a.a1.a.Q(maybeTakeUntilPublisher);
    }

    public final e.a.a z0() {
        x x10 = new x(this);
        return e.a.a1.a.O(x10);
    }

    public final q z1(long l10, TimeUnit timeUnit) {
        e.a.h0 h02 = e.a.c1.b.a();
        return this.B1(l10, timeUnit, h02);
    }
}

