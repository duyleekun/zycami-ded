/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.e0;
import e.a.h0;
import e.a.j0;
import e.a.l0;
import e.a.m0;
import e.a.n0;
import e.a.o0;
import e.a.p0;
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
import e.a.w0.e.b.a1;
import e.a.w0.e.b.d0;
import e.a.w0.e.b.n;
import e.a.w0.e.c.u;
import e.a.w0.e.e.l1;
import e.a.w0.e.g.f;
import e.a.w0.e.g.p;
import e.a.w0.e.g.q;
import e.a.w0.e.g.r;
import e.a.w0.e.g.s;
import e.a.w0.e.g.t;
import e.a.w0.e.g.v;
import e.a.w0.e.g.w;
import e.a.w0.e.g.x;
import e.a.w0.e.g.y;
import e.a.w0.e.g.z;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class i0
implements o0 {
    public static e.a.j A(o0 ... object) {
        object = e.a.j.Y2(object);
        o o10 = SingleInternalHelper.c();
        ErrorMode errorMode = ErrorMode.BOUNDARY;
        FlowableConcatMap flowableConcatMap = new FlowableConcatMap((e.a.j)object, o10, 2, errorMode);
        return e.a.a1.a.P(flowableConcatMap);
    }

    public static i0 A1(Callable callable, o o10, g g10, boolean bl2) {
        e.a.w0.b.a.g(callable, "resourceSupplier is null");
        e.a.w0.b.a.g(o10, "singleFunction is null");
        e.a.w0.b.a.g(g10, "disposer is null");
        SingleUsing singleUsing = new SingleUsing(callable, o10, g10, bl2);
        return e.a.a1.a.S(singleUsing);
    }

    public static e.a.j B(o0 ... object) {
        object = e.a.j.Y2((Object[])object);
        o o10 = SingleInternalHelper.c();
        return ((e.a.j)object).h1(o10);
    }

    public static e.a.j B0(o0 o02, o0 o03) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        Object[] objectArray = new o0[]{o02, o03};
        return i0.F0(e.a.j.Y2(objectArray));
    }

    public static i0 B1(o0 o02) {
        Object object = "source is null";
        e.a.w0.b.a.g(o02, (String)object);
        boolean bl2 = o02 instanceof i0;
        if (bl2) {
            return e.a.a1.a.S((i0)o02);
        }
        object = new r(o02);
        return e.a.a1.a.S((i0)object);
    }

    public static e.a.j C(Iterable object) {
        object = e.a.j.e3((Iterable)object);
        o o10 = SingleInternalHelper.c();
        return ((e.a.j)object).h1(o10);
    }

    public static e.a.j C0(o0 o02, o0 o03, o0 o04) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        Object[] objectArray = new o0[]{o02, o03, o04};
        return i0.F0(e.a.j.Y2(objectArray));
    }

    public static i0 C1(o0 o02, o0 o03, o0 o04, o0 o05, o0 o06, o0 o07, o0 o08, o0 o09, o0 o010, e.a.v0.n object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        e.a.w0.b.a.g(o06, "source5 is null");
        e.a.w0.b.a.g(o07, "source6 is null");
        e.a.w0.b.a.g(o08, "source7 is null");
        e.a.w0.b.a.g(o09, "source8 is null");
        e.a.w0.b.a.g(o010, "source9 is null");
        object = Functions.E((e.a.v0.n)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05, o06, o07, o08, o09, o010};
        return i0.L1((o)object, o0Array);
    }

    public static e.a.j D(i.g.c c10) {
        c10 = e.a.j.f3(c10);
        o o10 = SingleInternalHelper.c();
        return ((e.a.j)c10).h1(o10);
    }

    public static e.a.j D0(o0 o02, o0 o03, o0 o04, o0 o05) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        Object[] objectArray = new o0[]{o02, o03, o04, o05};
        return i0.F0(e.a.j.Y2(objectArray));
    }

    public static i0 D1(o0 o02, o0 o03, o0 o04, o0 o05, o0 o06, o0 o07, o0 o08, o0 o09, m object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        e.a.w0.b.a.g(o06, "source5 is null");
        e.a.w0.b.a.g(o07, "source6 is null");
        e.a.w0.b.a.g(o08, "source7 is null");
        e.a.w0.b.a.g(o09, "source8 is null");
        object = Functions.D((m)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05, o06, o07, o08, o09};
        return i0.L1((o)object, o0Array);
    }

    public static e.a.j E0(Iterable iterable) {
        return i0.F0(e.a.j.e3(iterable));
    }

    public static i0 E1(o0 o02, o0 o03, o0 o04, o0 o05, o0 o06, o0 o07, o0 o08, l object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        e.a.w0.b.a.g(o06, "source5 is null");
        e.a.w0.b.a.g(o07, "source6 is null");
        e.a.w0.b.a.g(o08, "source7 is null");
        object = Functions.C((l)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05, o06, o07, o08};
        return i0.L1((o)object, o0Array);
    }

    public static e.a.j F0(i.g.c c10) {
        e.a.w0.b.a.g(c10, "sources is null");
        o o10 = SingleInternalHelper.c();
        int n10 = e.a.j.f0();
        d0 d02 = new d0(c10, o10, false, -1 >>> 1, n10);
        return e.a.a1.a.P(d02);
    }

    public static i0 F1(o0 o02, o0 o03, o0 o04, o0 o05, o0 o06, o0 o07, k object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        e.a.w0.b.a.g(o06, "source5 is null");
        e.a.w0.b.a.g(o07, "source6 is null");
        object = Functions.B((k)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05, o06, o07};
        return i0.L1((o)object, o0Array);
    }

    public static i0 G0(o0 o02) {
        e.a.w0.b.a.g(o02, "source is null");
        o o10 = Functions.k();
        SingleFlatMap singleFlatMap = new SingleFlatMap(o02, o10);
        return e.a.a1.a.S(singleFlatMap);
    }

    public static i0 G1(o0 o02, o0 o03, o0 o04, o0 o05, o0 o06, j object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        e.a.w0.b.a.g(o06, "source5 is null");
        object = Functions.A((j)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05, o06};
        return i0.L1((o)object, o0Array);
    }

    public static i0 H(m0 m02) {
        e.a.w0.b.a.g(m02, "source is null");
        SingleCreate singleCreate = new SingleCreate(m02);
        return e.a.a1.a.S(singleCreate);
    }

    public static e.a.j H0(o0 o02, o0 o03) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        Object[] objectArray = new o0[]{o02, o03};
        return i0.L0(e.a.j.Y2(objectArray));
    }

    public static i0 H1(o0 o02, o0 o03, o0 o04, o0 o05, i object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        object = Functions.z((i)object);
        o0[] o0Array = new o0[]{o02, o03, o04, o05};
        return i0.L1((o)object, o0Array);
    }

    public static i0 I(Callable callable) {
        e.a.w0.b.a.g(callable, "singleSupplier is null");
        e.a.w0.e.g.c c10 = new e.a.w0.e.g.c(callable);
        return e.a.a1.a.S(c10);
    }

    public static e.a.j I0(o0 o02, o0 o03, o0 o04) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        Object[] objectArray = new o0[]{o02, o03, o04};
        return i0.L0(e.a.j.Y2(objectArray));
    }

    public static i0 I1(o0 o02, o0 o03, o0 o04, h object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        object = Functions.y((h)object);
        o0[] o0Array = new o0[]{o02, o03, o04};
        return i0.L1((o)object, o0Array);
    }

    public static e.a.j J0(o0 o02, o0 o03, o0 o04, o0 o05) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        Object[] objectArray = new o0[]{o02, o03, o04, o05};
        return i0.L0(e.a.j.Y2(objectArray));
    }

    public static i0 J1(o0 o02, o0 o03, c object) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        object = Functions.x((c)object);
        o0[] o0Array = new o0[]{o02, o03};
        return i0.L1((o)object, o0Array);
    }

    public static e.a.j K0(Iterable iterable) {
        return i0.L0(e.a.j.e3(iterable));
    }

    public static i0 K1(Iterable iterable, o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        z z10 = new z(iterable, o10);
        return e.a.a1.a.S(z10);
    }

    public static e.a.j L0(i.g.c c10) {
        e.a.w0.b.a.g(c10, "sources is null");
        o o10 = SingleInternalHelper.c();
        int n10 = e.a.j.f0();
        d0 d02 = new d0(c10, o10, true, -1 >>> 1, n10);
        return e.a.a1.a.P(d02);
    }

    public static i0 L1(o object, o0 ... o0Array) {
        e.a.w0.b.a.g(object, "zipper is null");
        Object object2 = "sources is null";
        e.a.w0.b.a.g(o0Array, (String)object2);
        int n10 = o0Array.length;
        if (n10 == 0) {
            object = new NoSuchElementException();
            return i0.e0((Throwable)object);
        }
        object2 = new SingleZipArray(o0Array, (o)object);
        return e.a.a1.a.S((i0)object2);
    }

    public static i0 N0() {
        return e.a.a1.a.S(x.a);
    }

    public static i0 d0(o0 o02, o0 o03) {
        e.a.w0.b.a.g(o02, "first is null");
        e.a.w0.b.a.g(o03, "second is null");
        e.a.w0.e.g.n n10 = new e.a.w0.e.g.n(o02, o03);
        return e.a.a1.a.S(n10);
    }

    public static i0 e0(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "exception is null");
        return i0.f0(Functions.m(throwable));
    }

    public static i0 f0(Callable callable) {
        e.a.w0.b.a.g(callable, "errorSupplier is null");
        e.a.w0.e.g.o o10 = new e.a.w0.e.g.o(callable);
        return e.a.a1.a.S(o10);
    }

    public static i0 k(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.e.g.a a10 = new e.a.w0.e.g.a(null, iterable);
        return e.a.a1.a.S(a10);
    }

    public static i0 m(o0 ... o0Array) {
        int n10 = o0Array.length;
        if (n10 == 0) {
            return i0.f0(SingleInternalHelper.a());
        }
        n10 = o0Array.length;
        int n11 = 1;
        if (n10 == n11) {
            return i0.B1(o0Array[0]);
        }
        e.a.w0.e.g.a a10 = new e.a.w0.e.g.a(o0Array, null);
        return e.a.a1.a.S(a10);
    }

    private i0 n1(long l10, TimeUnit timeUnit, h0 h02, o0 o02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        SingleTimeout singleTimeout = new SingleTimeout(this, l10, timeUnit, h02, o02);
        return e.a.a1.a.S(singleTimeout);
    }

    public static i0 o0(Callable callable) {
        e.a.w0.b.a.g(callable, "callable is null");
        p p10 = new p(callable);
        return e.a.a1.a.S(p10);
    }

    public static i0 o1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return i0.p1(l10, timeUnit, h02);
    }

    public static i0 p0(Future future) {
        return i0.w1(e.a.j.a3(future));
    }

    public static i0 p1(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        SingleTimer singleTimer = new SingleTimer(l10, timeUnit, h02);
        return e.a.a1.a.S(singleTimer);
    }

    public static i0 q0(Future future, long l10, TimeUnit timeUnit) {
        return i0.w1(e.a.j.b3(future, l10, timeUnit));
    }

    public static i0 r0(Future future, long l10, TimeUnit timeUnit, h0 h02) {
        return i0.w1(e.a.j.c3(future, l10, timeUnit, h02));
    }

    public static i0 s0(Future future, h0 h02) {
        return i0.w1(e.a.j.d3(future, h02));
    }

    public static e.a.j t(o0 o02, o0 o03) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        Object[] objectArray = new o0[]{o02, o03};
        return i0.x(e.a.j.Y2(objectArray));
    }

    public static i0 t0(e0 e02) {
        e.a.w0.b.a.g(e02, "observableSource is null");
        l1 l12 = new l1(e02, null);
        return e.a.a1.a.S(l12);
    }

    public static e.a.j u(o0 o02, o0 o03, o0 o04) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        Object[] objectArray = new o0[]{o02, o03, o04};
        return i0.x(e.a.j.Y2(objectArray));
    }

    public static i0 u0(i.g.c c10) {
        e.a.w0.b.a.g(c10, "publisher is null");
        q q10 = new q(c10);
        return e.a.a1.a.S(q10);
    }

    public static e.a.j v(o0 o02, o0 o03, o0 o04, o0 o05) {
        e.a.w0.b.a.g(o02, "source1 is null");
        e.a.w0.b.a.g(o03, "source2 is null");
        e.a.w0.b.a.g(o04, "source3 is null");
        e.a.w0.b.a.g(o05, "source4 is null");
        Object[] objectArray = new o0[]{o02, o03, o04, o05};
        return i0.x(e.a.j.Y2(objectArray));
    }

    public static e.a.j w(Iterable iterable) {
        return i0.x(e.a.j.e3(iterable));
    }

    private static i0 w1(e.a.j j10) {
        a1 a12 = new a1(j10, null);
        return e.a.a1.a.S(a12);
    }

    public static e.a.j x(i.g.c c10) {
        return i0.y(c10, 2);
    }

    public static i0 x0(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        t t10 = new t(object);
        return e.a.a1.a.S(t10);
    }

    public static i0 x1(o0 object) {
        Object object2 = "onSubscribe is null";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = object instanceof i0;
        if (!bl2) {
            object2 = new r((o0)object);
            return e.a.a1.a.S((i0)object2);
        }
        object = new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        throw object;
    }

    public static e.a.j y(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch");
        o o10 = SingleInternalHelper.c();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        n n11 = new n(c10, o10, n10, errorMode);
        return e.a.a1.a.P(n11);
    }

    public static e.a.z z(e0 e02) {
        e.a.w0.b.a.g(e02, "sources is null");
        o o10 = SingleInternalHelper.d();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMap observableConcatMap = new ObservableConcatMap(e02, o10, 2, errorMode);
        return e.a.a1.a.R(observableConcatMap);
    }

    public static i0 z1(Callable callable, o o10, g g10) {
        return i0.A1(callable, o10, g10, true);
    }

    public final i0 A0() {
        w w10 = new w(this);
        return e.a.a1.a.S(w10);
    }

    public final e.a.j E(o0 o02) {
        return i0.t(this, o02);
    }

    public final i0 F(Object object) {
        d d10 = e.a.w0.b.a.d();
        return this.G(object, d10);
    }

    public final i0 G(Object object, d d10) {
        e.a.w0.b.a.g(object, "value is null");
        e.a.w0.b.a.g(d10, "comparer is null");
        e.a.w0.e.g.b b10 = new e.a.w0.e.g.b(this, object, d10);
        return e.a.a1.a.S(b10);
    }

    public final i0 J(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.L(l10, timeUnit, h02, false);
    }

    public final i0 K(long l10, TimeUnit timeUnit, h0 h02) {
        return this.L(l10, timeUnit, h02, false);
    }

    public final i0 L(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.e.g.d d10 = new e.a.w0.e.g.d(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.S(d10);
    }

    public final i0 M(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.L(l10, timeUnit, h02, bl2);
    }

    public final e.a.j M0(o0 o02) {
        return i0.B0(this, o02);
    }

    public final i0 M1(o0 o02, c c10) {
        return i0.J1(this, o02, c10);
    }

    public final i0 N(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.O(l10, timeUnit, h02);
    }

    public final i0 O(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.z z10 = e.a.z.P6(l10, timeUnit, h02);
        return this.Q(z10);
    }

    public final i0 O0(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        SingleObserveOn singleObserveOn = new SingleObserveOn(this, h02);
        return e.a.a1.a.S(singleObserveOn);
    }

    public final i0 P(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        SingleDelayWithCompletable singleDelayWithCompletable = new SingleDelayWithCompletable(this, g10);
        return e.a.a1.a.S(singleDelayWithCompletable);
    }

    public final i0 P0(i0 object) {
        e.a.w0.b.a.g(object, "resumeSingleInCaseOfError is null");
        object = Functions.n(object);
        return this.Q0((o)object);
    }

    public final i0 Q(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        SingleDelayWithObservable singleDelayWithObservable = new SingleDelayWithObservable(this, e02);
        return e.a.a1.a.S(singleDelayWithObservable);
    }

    public final i0 Q0(o o10) {
        e.a.w0.b.a.g(o10, "resumeFunctionInCaseOfError is null");
        SingleResumeNext singleResumeNext = new SingleResumeNext(this, o10);
        return e.a.a1.a.S(singleResumeNext);
    }

    public final i0 R(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        SingleDelayWithSingle singleDelayWithSingle = new SingleDelayWithSingle(this, o02);
        return e.a.a1.a.S(singleDelayWithSingle);
    }

    public final i0 R0(o o10) {
        e.a.w0.b.a.g(o10, "resumeFunction is null");
        y y10 = new y(this, o10, null);
        return e.a.a1.a.S(y10);
    }

    public final i0 S(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        SingleDelayWithPublisher singleDelayWithPublisher = new SingleDelayWithPublisher(this, c10);
        return e.a.a1.a.S(singleDelayWithPublisher);
    }

    public final i0 S0(Object object) {
        e.a.w0.b.a.g(object, "value is null");
        y y10 = new y(this, null, object);
        return e.a.a1.a.S(y10);
    }

    public final e.a.q T(o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.e.g.e e10 = new e.a.w0.e.g.e(this, o10);
        return e.a.a1.a.Q(e10);
    }

    public final i0 T0() {
        f f10 = new f(this);
        return e.a.a1.a.S(f10);
    }

    public final i0 U(g g10) {
        e.a.w0.b.a.g(g10, "onAfterSuccess is null");
        e.a.w0.e.g.g g11 = new e.a.w0.e.g.g(this, g10);
        return e.a.a1.a.S(g11);
    }

    public final e.a.j U0() {
        return this.s1().a5();
    }

    public final i0 V(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onAfterTerminate is null");
        e.a.w0.e.g.h h10 = new e.a.w0.e.g.h(this, a10);
        return e.a.a1.a.S(h10);
    }

    public final e.a.j V0(long l10) {
        return this.s1().b5(l10);
    }

    public final i0 W(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        SingleDoFinally singleDoFinally = new SingleDoFinally(this, a10);
        return e.a.a1.a.S(singleDoFinally);
    }

    public final e.a.j W0(e e10) {
        return this.s1().c5(e10);
    }

    public final i0 X(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onDispose is null");
        SingleDoOnDispose singleDoOnDispose = new SingleDoOnDispose(this, a10);
        return e.a.a1.a.S(singleDoOnDispose);
    }

    public final e.a.j X0(o o10) {
        return this.s1().d5(o10);
    }

    public final i0 Y(g g10) {
        e.a.w0.b.a.g(g10, "onError is null");
        e.a.w0.e.g.i i10 = new e.a.w0.e.g.i(this, g10);
        return e.a.a1.a.S(i10);
    }

    public final i0 Y0() {
        return i0.w1(this.s1().u5());
    }

    public final i0 Z(b b10) {
        e.a.w0.b.a.g(b10, "onEvent is null");
        e.a.w0.e.g.j j10 = new e.a.w0.e.g.j(this, b10);
        return e.a.a1.a.S(j10);
    }

    public final i0 Z0(long l10) {
        return i0.w1(this.s1().v5(l10));
    }

    public final e.a.s0.b a() {
        g g10 = Functions.h();
        g g11 = Functions.f;
        return this.c(g10, g11);
    }

    public final i0 a0(g g10) {
        e.a.w0.b.a.g(g10, "onSubscribe is null");
        e.a.w0.e.g.k k10 = new e.a.w0.e.g.k(this, g10);
        return e.a.a1.a.S(k10);
    }

    public final i0 a1(long l10, e.a.v0.r r10) {
        return i0.w1(this.s1().w5(l10, r10));
    }

    public final TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.f(testObserver);
        return testObserver;
    }

    public final i0 b0(g g10) {
        e.a.w0.b.a.g(g10, "onSuccess is null");
        e.a.w0.e.g.l l10 = new e.a.w0.e.g.l(this, g10);
        return e.a.a1.a.S(l10);
    }

    public final i0 b1(d d10) {
        return i0.w1(this.s1().x5(d10));
    }

    public final e.a.s0.b c(g g10, g g11) {
        e.a.w0.b.a.g(g10, "onSuccess is null");
        e.a.w0.b.a.g(g11, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(g10, g11);
        this.f(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final i0 c0(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onTerminate is null");
        e.a.w0.e.g.m m10 = new e.a.w0.e.g.m(this, a10);
        return e.a.a1.a.S(m10);
    }

    public final i0 c1(e.a.v0.r r10) {
        return i0.w1(this.s1().y5(r10));
    }

    public final e.a.s0.b d(g g10) {
        g g11 = Functions.f;
        return this.c(g10, g11);
    }

    public final i0 d1(o o10) {
        return i0.w1(this.s1().A5(o10));
    }

    public final TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.cancel();
        }
        this.f(testObserver);
        return testObserver;
    }

    public abstract void e1(l0 var1);

    public final void f(l0 l02) {
        e.a.w0.b.a.g(l02, "observer is null");
        l02 = e.a.a1.a.g0(this, l02);
        Object object = "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins";
        e.a.w0.b.a.g(l02, (String)object);
        try {
            this.e1(l02);
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

    public final i0 f1(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        SingleSubscribeOn singleSubscribeOn = new SingleSubscribeOn(this, h02);
        return e.a.a1.a.S(singleSubscribeOn);
    }

    public final e.a.s0.b g(b b10) {
        e.a.w0.b.a.g(b10, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(b10);
        this.f(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final e.a.q g0(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        e.a.w0.e.c.n n10 = new e.a.w0.e.c.n(this, r10);
        return e.a.a1.a.Q(n10);
    }

    public final i0 g1(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        e.a.w0.e.a.y y10 = new e.a.w0.e.a.y(g10);
        return this.i1(y10);
    }

    public final l0 h(l0 l02) {
        this.f(l02);
        return l02;
    }

    public final i0 h0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMap singleFlatMap = new SingleFlatMap(this, o10);
        return e.a.a1.a.S(singleFlatMap);
    }

    public final i0 h1(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        SingleToFlowable singleToFlowable = new SingleToFlowable(o02);
        return this.i1(singleToFlowable);
    }

    public final e.a.a i0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapCompletable singleFlatMapCompletable = new SingleFlatMapCompletable(this, o10);
        return e.a.a1.a.O(singleFlatMapCompletable);
    }

    public final i0 i1(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        SingleTakeUntil singleTakeUntil = new SingleTakeUntil(this, c10);
        return e.a.a1.a.S(singleTakeUntil);
    }

    public final e.a.q j0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapMaybe singleFlatMapMaybe = new SingleFlatMapMaybe(this, o10);
        return e.a.a1.a.Q(singleFlatMapMaybe);
    }

    public final i0 j1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.n1(l10, timeUnit, h02, null);
    }

    public final e.a.z k0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapObservable singleFlatMapObservable = new SingleFlatMapObservable(this, o10);
        return e.a.a1.a.R(singleFlatMapObservable);
    }

    public final i0 k1(long l10, TimeUnit timeUnit, h0 h02) {
        return this.n1(l10, timeUnit, h02, null);
    }

    public final e.a.j l0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapPublisher singleFlatMapPublisher = new SingleFlatMapPublisher(this, o10);
        return e.a.a1.a.P(singleFlatMapPublisher);
    }

    public final i0 l1(long l10, TimeUnit timeUnit, h0 h02, o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        return this.n1(l10, timeUnit, h02, o02);
    }

    public final e.a.j m0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapIterableFlowable singleFlatMapIterableFlowable = new SingleFlatMapIterableFlowable(this, o10);
        return e.a.a1.a.P(singleFlatMapIterableFlowable);
    }

    public final i0 m1(long l10, TimeUnit timeUnit, o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        h0 h02 = e.a.c1.b.a();
        return this.n1(l10, timeUnit, h02, o02);
    }

    public final i0 n(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        o0[] o0Array = new o0[]{this, o02};
        return i0.m(o0Array);
    }

    public final e.a.z n0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        SingleFlatMapIterableObservable singleFlatMapIterableObservable = new SingleFlatMapIterableObservable(this, o10);
        return e.a.a1.a.R(singleFlatMapIterableObservable);
    }

    public final Object o(j0 j02) {
        return ((j0)e.a.w0.b.a.g(j02, "converter is null")).e(this);
    }

    public final Object p() {
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.f(f10);
        return f10.b();
    }

    public final i0 q() {
        SingleCache singleCache = new SingleCache(this);
        return e.a.a1.a.S(singleCache);
    }

    public final Object q1(o object) {
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

    public final i0 r(Class object) {
        e.a.w0.b.a.g(object, "clazz is null");
        object = Functions.e((Class)object);
        return this.z0((o)object);
    }

    public final e.a.a r1() {
        e.a.w0.e.a.n n10 = new e.a.w0.e.a.n(this);
        return e.a.a1.a.O(n10);
    }

    public final i0 s(p0 p02) {
        return i0.B1(((p0)e.a.w0.b.a.g(p02, "transformer is null")).e(this));
    }

    public final e.a.j s1() {
        boolean bl2 = this instanceof e.a.w0.c.b;
        if (bl2) {
            i0 i02 = this;
            return ((e.a.w0.c.b)((Object)this)).l();
        }
        SingleToFlowable singleToFlowable = new SingleToFlowable(this);
        return e.a.a1.a.P(singleToFlowable);
    }

    public final Future t1() {
        e.a.w0.d.i i10 = new e.a.w0.d.i();
        return (Future)((Object)this.h(i10));
    }

    public final e.a.q u1() {
        boolean bl2 = this instanceof e.a.w0.c.c;
        if (bl2) {
            i0 i02 = this;
            return ((e.a.w0.c.c)((Object)this)).j();
        }
        u u10 = new u(this);
        return e.a.a1.a.Q(u10);
    }

    public final i0 v0() {
        s s10 = new s(this);
        return e.a.a1.a.S(s10);
    }

    public final e.a.z v1() {
        boolean bl2 = this instanceof e.a.w0.c.d;
        if (bl2) {
            i0 i02 = this;
            return ((e.a.w0.c.d)((Object)this)).i();
        }
        SingleToObservable singleToObservable = new SingleToObservable(this);
        return e.a.a1.a.R(singleToObservable);
    }

    public final e.a.a w0() {
        e.a.w0.e.a.n n10 = new e.a.w0.e.a.n(this);
        return e.a.a1.a.O(n10);
    }

    public final i0 y0(n0 n02) {
        e.a.w0.b.a.g(n02, "lift is null");
        e.a.w0.e.g.u u10 = new e.a.w0.e.g.u(this, n02);
        return e.a.a1.a.S(u10);
    }

    public final i0 y1(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        SingleUnsubscribeOn singleUnsubscribeOn = new SingleUnsubscribeOn(this, h02);
        return e.a.a1.a.S(singleUnsubscribeOn);
    }

    public final i0 z0(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        v v10 = new v(this, o10);
        return e.a.a1.a.S(v10);
    }
}

