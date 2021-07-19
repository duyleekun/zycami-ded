/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.c0;
import e.a.d0;
import e.a.e0;
import e.a.f0;
import e.a.g0;
import e.a.h0;
import e.a.i0;
import e.a.q;
import e.a.v0.a;
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
import e.a.v0.n;
import e.a.v0.o;
import e.a.v0.r;
import e.a.w;
import e.a.w0.c.m;
import e.a.w0.e.e.a0;
import e.a.w0.e.e.a1;
import e.a.w0.e.e.b0;
import e.a.w0.e.e.b1;
import e.a.w0.e.e.c1;
import e.a.w0.e.e.e1;
import e.a.w0.e.e.f;
import e.a.w0.e.e.f1;
import e.a.w0.e.e.g1;
import e.a.w0.e.e.h1;
import e.a.w0.e.e.i1;
import e.a.w0.e.e.j0;
import e.a.w0.e.e.j1;
import e.a.w0.e.e.k0;
import e.a.w0.e.e.k1;
import e.a.w0.e.e.l0;
import e.a.w0.e.e.l1;
import e.a.w0.e.e.m0;
import e.a.w0.e.e.m1;
import e.a.w0.e.e.n0;
import e.a.w0.e.e.n1;
import e.a.w0.e.e.o0;
import e.a.w0.e.e.o1;
import e.a.w0.e.e.p0;
import e.a.w0.e.e.p1;
import e.a.w0.e.e.q0;
import e.a.w0.e.e.q1;
import e.a.w0.e.e.r0;
import e.a.w0.e.e.r1;
import e.a.w0.e.e.s;
import e.a.w0.e.e.s0;
import e.a.w0.e.e.s1;
import e.a.w0.e.e.t;
import e.a.w0.e.e.t0;
import e.a.w0.e.e.t1;
import e.a.w0.e.e.u;
import e.a.w0.e.e.u0;
import e.a.w0.e.e.u1;
import e.a.w0.e.e.v;
import e.a.w0.e.e.v0;
import e.a.w0.e.e.v1;
import e.a.w0.e.e.w0;
import e.a.w0.e.e.w1;
import e.a.w0.e.e.x;
import e.a.w0.e.e.x0;
import e.a.w0.e.e.x1;
import e.a.w0.e.e.y;
import e.a.w0.e.e.y0;
import e.a.w0.e.e.y1;
import e.a.w0.e.e.z0;
import e.a.w0.e.e.z1;
import e.a.z$a;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class z
implements e0 {
    public static z A0(e0 e02) {
        int n10 = z.b0();
        return z.B0(e02, n10);
    }

    public static z A3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        e.a.w0.b.a.g(object8, "item8 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8};
        return z.Q2(objectArray);
    }

    public static z B0(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch");
        o o10 = Functions.k();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMap observableConcatMap = new ObservableConcatMap(e02, o10, n10, errorMode);
        return e.a.a1.a.R(observableConcatMap);
    }

    public static z B3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        e.a.w0.b.a.g(object8, "item8 is null");
        e.a.w0.b.a.g(object9, "item9 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9};
        return z.Q2(objectArray);
    }

    public static z C0(e0 e02, e0 e03) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e0[] e0Array = new e0[]{e02, e03};
        return z.G0(e0Array);
    }

    public static z C3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        e.a.w0.b.a.g(object8, "item8 is null");
        e.a.w0.b.a.g(object9, "item9 is null");
        e.a.w0.b.a.g(object10, "item10 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10};
        return z.Q2(objectArray);
    }

    public static z D0(e0 e02, e0 e03, e0 e04) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e0[] e0Array = new e0[]{e02, e03, e04};
        return z.G0(e0Array);
    }

    public static z D1(Callable callable) {
        e.a.w0.b.a.g(callable, "supplier is null");
        s s10 = new s(callable);
        return e.a.a1.a.R(s10);
    }

    public static z E0(e0 e02, e0 e03, e0 e04, e0 e05) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e0[] e0Array = new e0[]{e02, e03, e04, e05};
        return z.G0(e0Array);
    }

    public static z F0(Iterable object) {
        e.a.w0.b.a.g(object, "sources is null");
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        int n10 = z.b0();
        return ((z)object).b1(o10, n10, false);
    }

    public static z G0(e0 ... object) {
        int n10 = ((e0[])object).length;
        if (n10 == 0) {
            return z.l2();
        }
        n10 = ((e0[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            return z.O7(object[0]);
        }
        object = z.Q2(object);
        o o10 = Functions.k();
        int n12 = z.b0();
        ErrorMode errorMode = ErrorMode.BOUNDARY;
        ObservableConcatMap observableConcatMap = new ObservableConcatMap((e0)object, o10, n12, errorMode);
        return e.a.a1.a.R(observableConcatMap);
    }

    public static z H0(e0 ... e0Array) {
        int n10 = e0Array.length;
        if (n10 == 0) {
            return z.l2();
        }
        n10 = e0Array.length;
        int n11 = 1;
        if (n10 == n11) {
            return z.O7(e0Array[0]);
        }
        return z.M0(z.Q2(e0Array));
    }

    public static z I0(int n10, int n11, e0 ... object) {
        object = z.Q2((Object[])object);
        o o10 = Functions.k();
        return ((z)object).e1(o10, n10, n11, false);
    }

    public static z J0(e0 ... e0Array) {
        int n10 = z.b0();
        int n11 = z.b0();
        return z.I0(n10, n11, e0Array);
    }

    public static z J3(e0 e02) {
        e.a.w0.b.a.g(e02, "sources is null");
        o o10 = Functions.k();
        int n10 = z.b0();
        ObservableFlatMap observableFlatMap = new ObservableFlatMap(e02, o10, false, -1 >>> 1, n10);
        return e.a.a1.a.R(observableFlatMap);
    }

    public static z K0(int n10, int n11, e0 ... object) {
        object = z.Q2((Object[])object);
        o o10 = Functions.k();
        return ((z)object).e1(o10, n10, n11, true);
    }

    public static z K3(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        o o10 = Functions.k();
        int n11 = z.b0();
        ObservableFlatMap observableFlatMap = new ObservableFlatMap(e02, o10, false, n10, n11);
        return e.a.a1.a.R(observableFlatMap);
    }

    public static z L0(e0 ... e0Array) {
        int n10 = z.b0();
        int n11 = z.b0();
        return z.K0(n10, n11, e0Array);
    }

    public static z L3(e0 e02, e0 object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        int n10 = 2;
        Object[] objectArray = new e0[n10];
        objectArray[0] = e02;
        objectArray[1] = object;
        e02 = z.Q2(objectArray);
        object = Functions.k();
        return ((z)e02).C2((o)object, false, n10);
    }

    public static z M0(e0 e02) {
        int n10 = z.b0();
        return z.N0(e02, n10, true);
    }

    public static z M3(e0 e02, e0 object, e0 e03) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        e.a.w0.b.a.g(e03, "source3 is null");
        int n10 = 3;
        Object[] objectArray = new e0[n10];
        objectArray[0] = e02;
        objectArray[1] = object;
        objectArray[2] = e03;
        e02 = z.Q2(objectArray);
        object = Functions.k();
        return ((z)e02).C2((o)object, false, n10);
    }

    private z M6(long l10, TimeUnit timeUnit, e0 e02, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "timeUnit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableTimeoutTimed observableTimeoutTimed = new ObservableTimeoutTimed(this, l10, timeUnit, h02, e02);
        return e.a.a1.a.R(observableTimeoutTimed);
    }

    public static z N0(e0 e02, int n10, boolean bl2) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch is null");
        o o10 = Functions.k();
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        ObservableConcatMap observableConcatMap = new ObservableConcatMap(e02, o10, n10, errorMode);
        return e.a.a1.a.R(observableConcatMap);
    }

    public static z N3(e0 e02, e0 object, e0 e03, e0 e04) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        e.a.w0.b.a.g(e03, "source3 is null");
        e.a.w0.b.a.g(e04, "source4 is null");
        int n10 = 4;
        Object[] objectArray = new e0[n10];
        objectArray[0] = e02;
        objectArray[1] = object;
        objectArray[2] = e03;
        objectArray[3] = e04;
        e02 = z.Q2(objectArray);
        object = Functions.k();
        return ((z)e02).C2((o)object, false, n10);
    }

    private z N6(e0 e02, o o10, e0 e03) {
        e.a.w0.b.a.g(o10, "itemTimeoutIndicator is null");
        ObservableTimeout observableTimeout = new ObservableTimeout(this, e02, o10, e03);
        return e.a.a1.a.R(observableTimeout);
    }

    public static z O0(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        return z.M0(z.W2(iterable));
    }

    public static z O3(Iterable object) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).s2(o10);
    }

    public static z O6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return z.P6(l10, timeUnit, h02);
    }

    public static z O7(e0 e02) {
        Object object = "source is null";
        e.a.w0.b.a.g(e02, (String)object);
        boolean bl2 = e02 instanceof z;
        if (bl2) {
            return e.a.a1.a.R((z)e02);
        }
        object = new o0(e02);
        return e.a.a1.a.R((z)object);
    }

    public static z P0(e0 e02) {
        int n10 = z.b0();
        int n11 = z.b0();
        return z.Q0(e02, n10, n11);
    }

    public static z P3(Iterable object, int n10) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).t2(o10, n10);
    }

    public static z P6(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        l10 = Math.max(l10, 0L);
        ObservableTimer observableTimer = new ObservableTimer(l10, timeUnit, h02);
        return e.a.a1.a.R(observableTimer);
    }

    public static z P7(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, e0 e09, e0 e010, n object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        e.a.w0.b.a.g(e09, "source8 is null");
        e.a.w0.b.a.g(e010, "source9 is null");
        object = Functions.E((n)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08, e09, e010};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z Q0(e0 e02, int n10, int n11) {
        e02 = z.O7(e02);
        o o10 = Functions.k();
        return ((z)e02).d1(o10, n10, n11);
    }

    public static z Q2(Object ... objectArray) {
        Object object = "items is null";
        e.a.w0.b.a.g(objectArray, (String)object);
        int n10 = objectArray.length;
        if (n10 == 0) {
            return z.l2();
        }
        n10 = objectArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return z.t3(objectArray[0]);
        }
        object = new j0(objectArray);
        return e.a.a1.a.R((z)object);
    }

    public static z Q3(Iterable object, int n10, int n11) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).D2(o10, false, n10, n11);
    }

    public static z Q7(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, e0 e09, e.a.v0.m object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        e.a.w0.b.a.g(e09, "source8 is null");
        object = Functions.D((e.a.v0.m)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08, e09};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z R0(Iterable iterable) {
        int n10 = z.b0();
        int n11 = z.b0();
        return z.S0(iterable, n10, n11);
    }

    public static z R2(Callable callable) {
        e.a.w0.b.a.g(callable, "supplier is null");
        k0 k02 = new k0(callable);
        return e.a.a1.a.R(k02);
    }

    public static z R3(int n10, int n11, e0 ... object) {
        object = z.Q2((Object[])object);
        o o10 = Functions.k();
        return ((z)object).D2(o10, false, n10, n11);
    }

    public static z R7(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, l object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        object = Functions.C((l)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z S0(Iterable object, int n10, int n11) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).e1(o10, n10, n11, false);
    }

    public static z S2(Future future) {
        e.a.w0.b.a.g(future, "future is null");
        l0 l02 = new l0(future, 0L, null);
        return e.a.a1.a.R(l02);
    }

    public static z S3(e0 ... e0Array) {
        z z10 = z.Q2(e0Array);
        o o10 = Functions.k();
        int n10 = e0Array.length;
        return z10.t2(o10, n10);
    }

    public static z S7(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, k object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        object = Functions.B((k)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z T2(Future future, long l10, TimeUnit timeUnit) {
        e.a.w0.b.a.g(future, "future is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        l0 l02 = new l0(future, l10, timeUnit);
        return e.a.a1.a.R(l02);
    }

    public static z T3(int n10, int n11, e0 ... object) {
        object = z.Q2((Object[])object);
        o o10 = Functions.k();
        return ((z)object).D2(o10, true, n10, n11);
    }

    public static z T7(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, j object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        object = Functions.A((j)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z U2(Future future, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return z.T2(future, l10, timeUnit).L5(h02);
    }

    public static z U3(e0 ... e0Array) {
        z z10 = z.Q2(e0Array);
        o o10 = Functions.k();
        int n10 = e0Array.length;
        return z10.C2(o10, true, n10);
    }

    public static z U7(e0 e02, e0 e03, e0 e04, e0 e05, i object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        object = Functions.z((i)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z V2(Future future, h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return z.S2(future).L5(h02);
    }

    public static z V3(e0 e02) {
        e.a.w0.b.a.g(e02, "sources is null");
        o o10 = Functions.k();
        int n10 = z.b0();
        ObservableFlatMap observableFlatMap = new ObservableFlatMap(e02, o10, true, -1 >>> 1, n10);
        return e.a.a1.a.R(observableFlatMap);
    }

    public static z V7(e0 e02, e0 e03, e0 e04, h object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        object = Functions.y((h)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z W2(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "source is null");
        m0 m02 = new m0(iterable);
        return e.a.a1.a.R(m02);
    }

    public static z W3(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        o o10 = Functions.k();
        int n11 = z.b0();
        ObservableFlatMap observableFlatMap = new ObservableFlatMap(e02, o10, true, n10, n11);
        return e.a.a1.a.R(observableFlatMap);
    }

    public static z W7(e0 e02, e0 e03, c object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        object = Functions.x((c)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03};
        return z.b8((o)object, false, n10, e0Array);
    }

    public static z X2(i.g.c c10) {
        e.a.w0.b.a.g(c10, "publisher is null");
        n0 n02 = new n0(c10);
        return e.a.a1.a.R(n02);
    }

    public static z X3(e0 e02, e0 e03) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        int n10 = 2;
        Object object = new e0[n10];
        object[0] = e02;
        boolean bl2 = true;
        object[bl2] = e03;
        e03 = z.Q2(object);
        object = Functions.k();
        return ((z)e03).C2((o)object, bl2, n10);
    }

    public static z X5(e0 e02) {
        int n10 = z.b0();
        return z.Y5(e02, n10);
    }

    public static z X7(e0 e02, e0 e03, c object, boolean bl2) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        object = Functions.x((c)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03};
        return z.b8((o)object, bl2, n10, e0Array);
    }

    public static z Y2(g object) {
        e.a.w0.b.a.g(object, "generator is null");
        Callable callable = Functions.u();
        object = ObservableInternalHelper.m((g)object);
        g g10 = Functions.h();
        return z.c3(callable, (c)object, g10);
    }

    public static z Y3(e0 e02, e0 e03, e0 object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(object, "source3 is null");
        int n10 = 3;
        Object[] objectArray = new e0[n10];
        objectArray[0] = e02;
        boolean bl2 = true;
        objectArray[bl2] = e03;
        objectArray[2] = object;
        e03 = z.Q2(objectArray);
        object = Functions.k();
        return ((z)e03).C2((o)object, bl2, n10);
    }

    public static z Y5(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        o o10 = Functions.k();
        ObservableSwitchMap observableSwitchMap = new ObservableSwitchMap(e02, o10, n10, false);
        return e.a.a1.a.R(observableSwitchMap);
    }

    public static z Y7(e0 e02, e0 e03, c object, boolean bl2, int n10) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        object = Functions.x((c)object);
        e0[] e0Array = new e0[]{e02, e03};
        return z.b8((o)object, bl2, n10, e0Array);
    }

    public static z Z2(Callable callable, b object) {
        e.a.w0.b.a.g(object, "generator is null");
        object = ObservableInternalHelper.l((b)object);
        g g10 = Functions.h();
        return z.c3(callable, (c)object, g10);
    }

    public static z Z3(e0 e02, e0 e03, e0 object, e0 e04) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(object, "source3 is null");
        e.a.w0.b.a.g(e04, "source4 is null");
        int n10 = 4;
        Object[] objectArray = new e0[n10];
        objectArray[0] = e02;
        boolean bl2 = true;
        objectArray[bl2] = e03;
        objectArray[2] = object;
        objectArray[3] = e04;
        e03 = z.Q2(objectArray);
        object = Functions.k();
        return ((z)e03).C2((o)object, bl2, n10);
    }

    public static z Z5(e0 e02) {
        int n10 = z.b0();
        return z.a6(e02, n10);
    }

    public static z Z7(e0 object, o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(object, "sources is null");
        v1 v12 = new v1((e0)object, 16);
        object = ObservableInternalHelper.n(o10);
        return e.a.a1.a.R(v12.s2((o)object));
    }

    public static z a3(Callable callable, b object, g g10) {
        e.a.w0.b.a.g(object, "generator is null");
        object = ObservableInternalHelper.l((b)object);
        return z.c3(callable, (c)object, g10);
    }

    public static z a4(Iterable object) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).B2(o10, true);
    }

    public static z a6(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch");
        o o10 = Functions.k();
        ObservableSwitchMap observableSwitchMap = new ObservableSwitchMap(e02, o10, n10, true);
        return e.a.a1.a.R(observableSwitchMap);
    }

    public static z a8(Iterable iterable, o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        int n10 = z.b0();
        ObservableZip observableZip = new ObservableZip(null, iterable, o10, n10, false);
        return e.a.a1.a.R(observableZip);
    }

    public static int b0() {
        return e.a.j.f0();
    }

    public static z b3(Callable callable, c c10) {
        g g10 = Functions.h();
        return z.c3(callable, c10, g10);
    }

    public static z b4(Iterable object, int n10) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).C2(o10, true, n10);
    }

    public static z b8(o o10, boolean bl2, int n10, e0 ... e0Array) {
        int n11 = e0Array.length;
        if (n11 == 0) {
            return z.l2();
        }
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableZip observableZip = new ObservableZip(e0Array, null, o10, n10, bl2);
        return e.a.a1.a.R(observableZip);
    }

    private z c2(g g10, g g11, a a10, a a11) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.w0.b.a.g(a11, "onAfterTerminate is null");
        a0 a02 = new a0(this, g10, g11, a10, a11);
        return e.a.a1.a.R(a02);
    }

    public static z c3(Callable callable, c c10, g g10) {
        e.a.w0.b.a.g(callable, "initialState is null");
        e.a.w0.b.a.g(c10, "generator is null");
        e.a.w0.b.a.g(g10, "disposeState is null");
        p0 p02 = new p0(callable, c10, g10);
        return e.a.a1.a.R(p02);
    }

    public static z c4(Iterable object, int n10, int n11) {
        object = z.W2((Iterable)object);
        o o10 = Functions.k();
        return ((z)object).D2(o10, true, n10, n11);
    }

    public static z c8(Iterable iterable, o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableZip observableZip = new ObservableZip(null, iterable, o10, n10, bl2);
        return e.a.a1.a.R(observableZip);
    }

    public static z h0(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, e0 e09, e0 e010, n object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        e.a.w0.b.a.g(e09, "source8 is null");
        e.a.w0.b.a.g(e010, "source9 is null");
        object = Functions.E((n)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08, e09, e010};
        return z.p0((o)object, n10, e0Array);
    }

    public static z h4() {
        return e.a.a1.a.R(a1.a);
    }

    public static z i0(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, e0 e09, e.a.v0.m object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        e.a.w0.b.a.g(e09, "source8 is null");
        object = Functions.D((e.a.v0.m)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08, e09};
        return z.p0((o)object, n10, e0Array);
    }

    public static z j0(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, e0 e08, l object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        e.a.w0.b.a.g(e08, "source7 is null");
        object = Functions.C((l)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07, e08};
        return z.p0((o)object, n10, e0Array);
    }

    public static z k0(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, e0 e07, k object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        e.a.w0.b.a.g(e07, "source6 is null");
        object = Functions.B((k)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06, e07};
        return z.p0((o)object, n10, e0Array);
    }

    public static i0 k5(e0 e02, e0 e03) {
        d d10 = e.a.w0.b.a.d();
        int n10 = z.b0();
        return z.n5(e02, e03, d10, n10);
    }

    public static z l(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        ObservableAmb observableAmb = new ObservableAmb(null, iterable);
        return e.a.a1.a.R(observableAmb);
    }

    public static z l0(e0 e02, e0 e03, e0 e04, e0 e05, e0 e06, j object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        e.a.w0.b.a.g(e06, "source5 is null");
        object = Functions.A((j)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05, e06};
        return z.p0((o)object, n10, e0Array);
    }

    public static z l2() {
        return e.a.a1.a.R(e.a.w0.e.e.f0.a);
    }

    public static z l3(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return z.m3(l10, l11, timeUnit, h02);
    }

    public static i0 l5(e0 e02, e0 e03, int n10) {
        d d10 = e.a.w0.b.a.d();
        return z.n5(e02, e03, d10, n10);
    }

    public static z l7(e0 object) {
        Object object2 = "onSubscribe is null";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = object instanceof z;
        if (!bl2) {
            object2 = new o0((e0)object);
            return e.a.a1.a.R((z)object2);
        }
        object = new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        throw object;
    }

    public static z m0(e0 e02, e0 e03, e0 e04, e0 e05, i object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        e.a.w0.b.a.g(e05, "source4 is null");
        object = Functions.z((i)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04, e05};
        return z.p0((o)object, n10, e0Array);
    }

    public static z m2(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "exception is null");
        return z.n2(Functions.m(throwable));
    }

    public static z m3(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        long l12 = 0L;
        l10 = Math.max(l12, l10);
        long l13 = Math.max(l12, l11);
        ObservableInterval observableInterval = new ObservableInterval(l10, l13, timeUnit, h02);
        return e.a.a1.a.R(observableInterval);
    }

    public static i0 m5(e0 e02, e0 e03, d d10) {
        int n10 = z.b0();
        return z.n5(e02, e03, d10, n10);
    }

    public static z n(e0 ... e0Array) {
        Object object = "sources is null";
        e.a.w0.b.a.g(e0Array, (String)object);
        int n10 = e0Array.length;
        if (n10 == 0) {
            return z.l2();
        }
        int n11 = 1;
        if (n10 == n11) {
            return z.O7(e0Array[0]);
        }
        object = new ObservableAmb(e0Array, null);
        return e.a.a1.a.R((z)object);
    }

    public static z n0(e0 e02, e0 e03, e0 e04, h object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(e04, "source3 is null");
        object = Functions.y((h)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03, e04};
        return z.p0((o)object, n10, e0Array);
    }

    public static z n2(Callable callable) {
        e.a.w0.b.a.g(callable, "errorSupplier is null");
        e.a.w0.e.e.g0 g02 = new e.a.w0.e.e.g0(callable);
        return e.a.a1.a.R(g02);
    }

    public static z n3(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return z.m3(l10, l10, timeUnit, h02);
    }

    public static i0 n5(e0 e02, e0 e03, d d10, int n10) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        e.a.w0.b.a.g(d10, "isEqual is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableSequenceEqualSingle observableSequenceEqualSingle = new ObservableSequenceEqualSingle(e02, e03, d10, n10);
        return e.a.a1.a.S(observableSequenceEqualSingle);
    }

    public static z n7(Callable callable, o o10, g g10) {
        return z.o7(callable, o10, g10, true);
    }

    public static z o0(e0 e02, e0 e03, c object) {
        e.a.w0.b.a.g(e02, "source1 is null");
        e.a.w0.b.a.g(e03, "source2 is null");
        object = Functions.x((c)object);
        int n10 = z.b0();
        e0[] e0Array = new e0[]{e02, e03};
        return z.p0((o)object, n10, e0Array);
    }

    public static z o3(long l10, TimeUnit timeUnit, h0 h02) {
        return z.m3(l10, l10, timeUnit, h02);
    }

    public static z o7(Callable callable, o o10, g g10, boolean bl2) {
        e.a.w0.b.a.g(callable, "resourceSupplier is null");
        e.a.w0.b.a.g(o10, "sourceSupplier is null");
        e.a.w0.b.a.g(g10, "disposer is null");
        ObservableUsing observableUsing = new ObservableUsing(callable, o10, g10, bl2);
        return e.a.a1.a.R(observableUsing);
    }

    public static z p0(o o10, int n10, e0 ... e0Array) {
        return z.t0(e0Array, o10, n10);
    }

    public static z p3(long l10, long l11, long l12, long l13, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return z.q3(l10, l11, l12, l13, timeUnit, h02);
    }

    public static z q0(Iterable iterable, o o10) {
        int n10 = z.b0();
        return z.r0(iterable, o10, n10);
    }

    public static z q3(long l10, long l11, long l12, long l13, TimeUnit timeUnit, h0 h02) {
        long l14 = l11;
        long l15 = l12;
        TimeUnit timeUnit2 = timeUnit;
        h0 h03 = h02;
        long l16 = 0L;
        long l17 = l11 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object >= 0) {
            ObservableIntervalRange observableIntervalRange;
            if (object == false) {
                return z.l2().F1(l12, timeUnit, h02);
            }
            l14 = l11 - 1L;
            long l18 = l10 + l14;
            Object object2 = l10 == l16 ? 0 : (l10 < l16 ? -1 : 1);
            if (object2 > 0 && (object2 = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1)) < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                throw illegalArgumentException;
            }
            e.a.w0.b.a.g((Object)timeUnit2, "unit is null");
            e.a.w0.b.a.g(h03, "scheduler is null");
            long l19 = Math.max(l16, l15);
            l14 = l13;
            long l20 = Math.max(l16, l13);
            ObservableIntervalRange observableIntervalRange2 = observableIntervalRange;
            timeUnit2 = timeUnit;
            h03 = h02;
            observableIntervalRange = new ObservableIntervalRange(l10, l18, l19, l20, timeUnit, h02);
            return e.a.a1.a.R(observableIntervalRange);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static z r0(Iterable iterable, o o10, int n10) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        int n11 = n10 << 1;
        ObservableCombineLatest observableCombineLatest = new ObservableCombineLatest(null, iterable, o10, n11, false);
        return e.a.a1.a.R(observableCombineLatest);
    }

    public static z s0(e0[] e0Array, o o10) {
        int n10 = z.b0();
        return z.t0(e0Array, o10, n10);
    }

    public static z t0(e0[] e0Array, o o10, int n10) {
        String string2 = "sources is null";
        e.a.w0.b.a.g(e0Array, string2);
        int n11 = e0Array.length;
        if (n11 == 0) {
            return z.l2();
        }
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        int n12 = n10 << 1;
        ObservableCombineLatest observableCombineLatest = new ObservableCombineLatest(e0Array, null, o10, n12, false);
        return e.a.a1.a.R(observableCombineLatest);
    }

    public static z t3(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        t0 t02 = new t0(object);
        return e.a.a1.a.R(t02);
    }

    public static z u0(o o10, int n10, e0 ... e0Array) {
        return z.y0(e0Array, o10, n10);
    }

    public static z u3(Object object, Object object2) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        Object[] objectArray = new Object[]{object, object2};
        return z.Q2(objectArray);
    }

    public static z u4(int n10, int n11) {
        if (n11 >= 0) {
            if (n11 == 0) {
                return z.l2();
            }
            int n12 = 1;
            if (n11 == n12) {
                return z.t3(n10);
            }
            long l10 = n10;
            int n13 = n11 + -1;
            long l11 = n13;
            long l12 = (l10 += l11) - (l11 = Integer.MAX_VALUE);
            n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n12 <= 0) {
                ObservableRange observableRange = new ObservableRange(n10, n11);
                return e.a.a1.a.R(observableRange);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Integer overflow");
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static z v0(Iterable iterable, o o10) {
        int n10 = z.b0();
        return z.w0(iterable, o10, n10);
    }

    public static z v3(Object object, Object object2, Object object3) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        Object[] objectArray = new Object[]{object, object2, object3};
        return z.Q2(objectArray);
    }

    public static z v4(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            long l14;
            if (object == false) {
                return z.l2();
            }
            long l15 = 1L;
            long l16 = l11 - l15;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 == false) {
                return z.t3(l10);
            }
            l15 = l11 - l15 + l10;
            object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object2 > 0 && (l14 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1)) < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                throw illegalArgumentException;
            }
            ObservableRangeLong observableRangeLong = new ObservableRangeLong(l10, l11);
            return e.a.a1.a.R(observableRangeLong);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("count >= 0 required but it was ");
        charSequence.append(l11);
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static z w0(Iterable iterable, o o10, int n10) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        int n11 = n10 << 1;
        ObservableCombineLatest observableCombineLatest = new ObservableCombineLatest(null, iterable, o10, n11, true);
        return e.a.a1.a.R(observableCombineLatest);
    }

    public static z w3(Object object, Object object2, Object object3, Object object4) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        return z.Q2(objectArray);
    }

    public static z x0(e0[] e0Array, o o10) {
        int n10 = z.b0();
        return z.y0(e0Array, o10, n10);
    }

    public static z x3(Object object, Object object2, Object object3, Object object4, Object object5) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5};
        return z.Q2(objectArray);
    }

    public static z y0(e0[] e0Array, o o10, int n10) {
        ObservableCombineLatest observableCombineLatest;
        e.a.w0.b.a.h(n10, "bufferSize");
        Object object = "combiner is null";
        e.a.w0.b.a.g(o10, (String)object);
        int n11 = e0Array.length;
        if (n11 == 0) {
            return z.l2();
        }
        int n12 = n10 << 1;
        object = observableCombineLatest;
        observableCombineLatest = new ObservableCombineLatest(e0Array, null, o10, n12, true);
        return e.a.a1.a.R(observableCombineLatest);
    }

    public static z y1(c0 c02) {
        e.a.w0.b.a.g(c02, "source is null");
        ObservableCreate observableCreate = new ObservableCreate(c02);
        return e.a.a1.a.R(observableCreate);
    }

    public static z y3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6};
        return z.Q2(objectArray);
    }

    public static z z3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7};
        return z.Q2(objectArray);
    }

    public final Iterable A() {
        e.a.w0.e.e.d d10 = new e.a.w0.e.e.d(this);
        return d10;
    }

    public final z A1(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableDebounceTimed observableDebounceTimed = new ObservableDebounceTimed(this, l10, timeUnit, h02);
        return e.a.a1.a.R(observableDebounceTimed);
    }

    public final z A2(o o10, o o11, Callable callable, int n10) {
        e.a.w0.b.a.g(o10, "onNextMapper is null");
        e.a.w0.b.a.g(o11, "onErrorMapper is null");
        e.a.w0.b.a.g(callable, "onCompleteSupplier is null");
        y0 y02 = new y0(this, o10, o11, callable);
        return z.K3(y02, n10);
    }

    public final z A4(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            if (object == false) {
                return z.l2();
            }
            ObservableRepeat observableRepeat = new ObservableRepeat(this, l10);
            return e.a.a1.a.R(observableRepeat);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final z A5(long l10, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        int n11 = n10 << 1;
        ObservableSkipLastTimed observableSkipLastTimed = new ObservableSkipLastTimed(this, l10, timeUnit, h02, n11, bl2);
        return e.a.a1.a.R(observableSkipLastTimed);
    }

    public final z A6() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.a();
        return this.D6(timeUnit, h02);
    }

    public final z A7(long l10, TimeUnit timeUnit, h0 h02, long l11, boolean bl2) {
        int n10 = z.b0();
        return this.B7(l10, timeUnit, h02, l11, bl2, n10);
    }

    public final Object B() {
        Object object = this.r5().o();
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final z B1(o o10) {
        e.a.w0.b.a.g(o10, "debounceSelector is null");
        e.a.w0.e.e.r r10 = new e.a.w0.e.e.r(this, o10);
        return e.a.a1.a.R(r10);
    }

    public final z B2(o o10, boolean bl2) {
        return this.C2(o10, bl2, -1 >>> 1);
    }

    public final z B4(e e10) {
        e.a.w0.b.a.g(e10, "stop is null");
        ObservableRepeatUntil observableRepeatUntil = new ObservableRepeatUntil(this, e10);
        return e.a.a1.a.R(observableRepeatUntil);
    }

    public final z B5(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.i();
        int n10 = z.b0();
        return this.A5(l10, timeUnit, h02, bl2, n10);
    }

    public final z B6(h0 h02) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return this.D6(timeUnit, h02);
    }

    public final z B7(long l10, TimeUnit timeUnit, h0 h02, long l11, boolean bl2, int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.i(l11, "count");
        y1 y12 = new y1(this, l10, l10, timeUnit, h02, l11, n10, bl2);
        return e.a.a1.a.R(y12);
    }

    public final Object C(Object object) {
        return this.q5(object).p();
    }

    public final z C1(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        object = z.t3(object);
        return this.M5((e0)object);
    }

    public final z C2(o o10, boolean bl2, int n10) {
        int n11 = z.b0();
        return this.D2(o10, bl2, n10, n11);
    }

    public final z C4(o o10) {
        e.a.w0.b.a.g(o10, "handler is null");
        ObservableRepeatWhen observableRepeatWhen = new ObservableRepeatWhen(this, o10);
        return e.a.a1.a.R(observableRepeatWhen);
    }

    public final z C5(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        n1 n12 = new n1(this, e02);
        return e.a.a1.a.R(n12);
    }

    public final z C6(TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.D6(timeUnit, h02);
    }

    public final z C7(e0 e02) {
        int n10 = z.b0();
        return this.D7(e02, n10);
    }

    public final void D() {
        e.a.w0.e.e.j.a(this);
    }

    public final z D2(o o10, boolean bl2, int n10, int n11) {
        ObservableFlatMap observableFlatMap;
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n11, (String)object);
        boolean bl3 = this instanceof m;
        if (bl3) {
            Object object2 = this;
            object2 = ((m)((Object)this)).call();
            if (object2 == null) {
                return z.l2();
            }
            return ObservableScalarXMap.a(object2, o10);
        }
        object = observableFlatMap;
        observableFlatMap = new ObservableFlatMap(this, o10, bl2, n10, n11);
        return e.a.a1.a.R(observableFlatMap);
    }

    public final i0 D3(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        v0 v02 = new v0(this, object);
        return e.a.a1.a.S(v02);
    }

    public final z D4(o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        return ObservableReplay.y8(ObservableInternalHelper.g(this), o10);
    }

    public final z D5(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        o1 o12 = new o1(this, r10);
        return e.a.a1.a.R(o12);
    }

    public final z D6(TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        u1 u12 = new u1(this, timeUnit, h02);
        return e.a.a1.a.R(u12);
    }

    public final z D7(e0 e02, int n10) {
        e.a.w0.b.a.g(e02, "boundary is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableWindowBoundary observableWindowBoundary = new ObservableWindowBoundary(this, e02, n10);
        return e.a.a1.a.R(observableWindowBoundary);
    }

    public final void E(g0 g02) {
        e.a.w0.e.e.j.b(this, g02);
    }

    public final z E1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.G1(l10, timeUnit, h02, false);
    }

    public final e.a.a E2(o o10) {
        return this.F2(o10, false);
    }

    public final q E3() {
        u0 u02 = new u0(this);
        return e.a.a1.a.Q(u02);
    }

    public final z E4(o o10, int n10) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        return ObservableReplay.y8(ObservableInternalHelper.h(this, n10), o10);
    }

    public final z E5() {
        z z10 = this.X6().v1();
        o o10 = Functions.o(Functions.p());
        z10 = z10.H3(o10);
        o10 = Functions.k();
        return z10.G2(o10);
    }

    public final z E6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.M6(l10, timeUnit, null, h02);
    }

    public final z E7(e0 e02, o o10) {
        int n10 = z.b0();
        return this.F7(e02, o10, n10);
    }

    public final void F(g g10) {
        g g11 = Functions.f;
        a a10 = Functions.c;
        e.a.w0.e.e.j.c(this, g10, g11, a10);
    }

    public final z F1(long l10, TimeUnit timeUnit, h0 h02) {
        return this.G1(l10, timeUnit, h02, false);
    }

    public final e.a.a F2(o o10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableFlatMapCompletableCompletable observableFlatMapCompletableCompletable = new ObservableFlatMapCompletableCompletable(this, o10, bl2);
        return e.a.a1.a.O(observableFlatMapCompletableCompletable);
    }

    public final i0 F3() {
        v0 v02 = new v0(this, null);
        return e.a.a1.a.S(v02);
    }

    public final z F4(o o10, int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.G4(o10, n10, l10, timeUnit, h02);
    }

    public final z F5(Comparator object) {
        e.a.w0.b.a.g(object, "sortFunction is null");
        Object object2 = this.X6().v1();
        object = Functions.o((Comparator)object);
        object = ((z)object2).H3((o)object);
        object2 = Functions.k();
        return ((z)object).G2((o)object2);
    }

    public final z F6(long l10, TimeUnit timeUnit, e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        h0 h02 = e.a.c1.b.a();
        return this.M6(l10, timeUnit, e02, h02);
    }

    public final z F7(e0 e02, o o10, int n10) {
        e.a.w0.b.a.g(e02, "openingIndicator is null");
        e.a.w0.b.a.g(o10, "closingIndicator is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        x1 x12 = new x1(this, e02, o10, n10);
        return e.a.a1.a.R(x12);
    }

    public final void G(g g10, g g11) {
        a a10 = Functions.c;
        e.a.w0.e.e.j.c(this, g10, g11, a10);
    }

    public final z G1(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        t t10 = new t(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.R(t10);
    }

    public final z G2(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.e.e.i0 i02 = new e.a.w0.e.e.i0(this, o10);
        return e.a.a1.a.R(i02);
    }

    public final z G3(d0 d02) {
        e.a.w0.b.a.g(d02, "lifter is null");
        w0 w02 = new w0(this, d02);
        return e.a.a1.a.R(w02);
    }

    public final z G4(o o10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return ObservableReplay.y8(ObservableInternalHelper.i(this, n10, l10, timeUnit, h02), o10);
    }

    public final z G5(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        e0[] e0Array = new e0[]{e02, this};
        return z.G0(e0Array);
    }

    public final z G6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.M6(l10, timeUnit, null, h02);
    }

    public final z G7(Callable callable) {
        int n10 = z.b0();
        return this.H7(callable, n10);
    }

    public final void H(g g10, g g11, a a10) {
        e.a.w0.e.e.j.c(this, g10, g11, a10);
    }

    public final z H1(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.G1(l10, timeUnit, h02, bl2);
    }

    public final z H2(o o10, c c10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        o o11 = ObservableInternalHelper.a(o10);
        int n10 = z.b0();
        int n11 = z.b0();
        return this.y2(o11, c10, false, n10, n11);
    }

    public final z H3(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        x0 x02 = new x0(this, o10);
        return e.a.a1.a.R(x02);
    }

    public final z H4(o o10, int n10, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        Callable callable = ObservableInternalHelper.h(this, n10);
        o10 = ObservableInternalHelper.k(o10, h02);
        return ObservableReplay.y8(callable, o10);
    }

    public final z H5(Iterable object) {
        e0[] e0Array = new e0[]{object = z.W2((Iterable)object), this};
        return z.G0(e0Array);
    }

    public final z H6(long l10, TimeUnit timeUnit, h0 h02, e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        return this.M6(l10, timeUnit, e02, h02);
    }

    public final z H7(Callable callable, int n10) {
        e.a.w0.b.a.g(callable, "boundary is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableWindowBoundarySupplier observableWindowBoundarySupplier = new ObservableWindowBoundarySupplier(this, callable, n10);
        return e.a.a1.a.R(observableWindowBoundarySupplier);
    }

    public final z I(int n10) {
        return this.J(n10, n10);
    }

    public final z I1(e0 e02, o o10) {
        return this.M1(e02).J1(o10);
    }

    public final z I2(o o10) {
        return this.J2(o10, false);
    }

    public final z I3() {
        z0 z02 = new z0(this);
        return e.a.a1.a.R(z02);
    }

    public final z I4(o o10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.J4(o10, l10, timeUnit, h02);
    }

    public final z I5(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        e0[] e0Array = new e0[]{object = z.t3(object), this};
        return z.G0(e0Array);
    }

    public final z I6(e0 e02, o o10) {
        e.a.w0.b.a.g(e02, "firstTimeoutIndicator is null");
        return this.N6(e02, o10, null);
    }

    public final z I7(e0 e02, e0 e03, e0 e04, e0 e05, j object) {
        e.a.w0.b.a.g(e02, "o1 is null");
        e.a.w0.b.a.g(e03, "o2 is null");
        e.a.w0.b.a.g(e04, "o3 is null");
        e.a.w0.b.a.g(e05, "o4 is null");
        e.a.w0.b.a.g(object, "combiner is null");
        object = Functions.A((j)object);
        e0[] e0Array = new e0[]{e02, e03, e04, e05};
        return this.N7(e0Array, (o)object);
    }

    public final z J(int n10, int n11) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.K(n10, n11, callable);
    }

    public final z J1(o o10) {
        e.a.w0.b.a.g(o10, "itemDelay is null");
        o10 = ObservableInternalHelper.c(o10);
        return this.s2(o10);
    }

    public final z J2(o o10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableFlatMapMaybe observableFlatMapMaybe = new ObservableFlatMapMaybe(this, o10, bl2);
        return e.a.a1.a.R(observableFlatMapMaybe);
    }

    public final z J4(o o10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return ObservableReplay.y8(ObservableInternalHelper.j(this, l10, timeUnit, h02), o10);
    }

    public final z J5(Object ... object) {
        e0[] e0Array;
        if ((object = z.Q2(object)) == (e0Array = z.l2())) {
            return e.a.a1.a.R(this);
        }
        e0Array = new e0[]{object, this};
        return z.G0(e0Array);
    }

    public final z J6(e0 e02, o o10, e0 e03) {
        e.a.w0.b.a.g(e02, "firstTimeoutIndicator is null");
        e.a.w0.b.a.g(e03, "other is null");
        return this.N6(e02, o10, e03);
    }

    public final z J7(e0 e02, e0 e03, e0 e04, i object) {
        e.a.w0.b.a.g(e02, "o1 is null");
        e.a.w0.b.a.g(e03, "o2 is null");
        e.a.w0.b.a.g(e04, "o3 is null");
        e.a.w0.b.a.g(object, "combiner is null");
        object = Functions.z((i)object);
        e0[] e0Array = new e0[]{e02, e03, e04};
        return this.N7(e0Array, (o)object);
    }

    public final z K(int n10, int n11, Callable callable) {
        e.a.w0.b.a.h(n10, "count");
        e.a.w0.b.a.h(n11, "skip");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        ObservableBuffer observableBuffer = new ObservableBuffer(this, n10, n11, callable);
        return e.a.a1.a.R(observableBuffer);
    }

    public final z K1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.L1(l10, timeUnit, h02);
    }

    public final z K2(o o10) {
        return this.L2(o10, false);
    }

    public final z K4(o o10, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        Callable callable = ObservableInternalHelper.g(this);
        o10 = ObservableInternalHelper.k(o10, h02);
        return ObservableReplay.y8(callable, o10);
    }

    public abstract void K5(g0 var1);

    public final z K6(o o10) {
        return this.N6(null, o10, null);
    }

    public final z K7(e0 e02, e0 e03, h object) {
        e.a.w0.b.a.g(e02, "o1 is null");
        e.a.w0.b.a.g(e03, "o2 is null");
        e.a.w0.b.a.g(object, "combiner is null");
        object = Functions.y((h)object);
        e0[] e0Array = new e0[]{e02, e03};
        return this.N7(e0Array, (o)object);
    }

    public final z L(int n10, Callable callable) {
        return this.K(n10, n10, callable);
    }

    public final z L1(long l10, TimeUnit timeUnit, h0 h02) {
        z z10 = z.P6(l10, timeUnit, h02);
        return this.M1(z10);
    }

    public final z L2(o o10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableFlatMapSingle observableFlatMapSingle = new ObservableFlatMapSingle(this, o10, bl2);
        return e.a.a1.a.R(observableFlatMapSingle);
    }

    public final e.a.x0.a L4() {
        return ObservableReplay.x8(this);
    }

    public final z L5(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableSubscribeOn observableSubscribeOn = new ObservableSubscribeOn(this, h02);
        return e.a.a1.a.R(observableSubscribeOn);
    }

    public final z L6(o o10, e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        return this.N6(null, o10, e02);
    }

    public final z L7(e0 e02, c c10) {
        e.a.w0.b.a.g(e02, "other is null");
        e.a.w0.b.a.g(c10, "combiner is null");
        ObservableWithLatestFrom observableWithLatestFrom = new ObservableWithLatestFrom(this, c10, e02);
        return e.a.a1.a.R(observableWithLatestFrom);
    }

    public final z M(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        Callable callable = ArrayListSupplier.asCallable();
        return this.O(l10, l11, timeUnit, h02, callable);
    }

    public final z M1(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        u u10 = new u(this, e02);
        return e.a.a1.a.R(u10);
    }

    public final e.a.s0.b M2(g g10) {
        return this.d(g10);
    }

    public final e.a.x0.a M4(int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        return ObservableReplay.t8(this, n10);
    }

    public final z M5(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        p1 p12 = new p1(this, e02);
        return e.a.a1.a.R(p12);
    }

    public final z M7(Iterable iterable, o o10) {
        e.a.w0.b.a.g(iterable, "others is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        ObservableWithLatestFromMany observableWithLatestFromMany = new ObservableWithLatestFromMany((e0)this, iterable, o10);
        return e.a.a1.a.R(observableWithLatestFromMany);
    }

    public final z N(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.O(l10, l11, timeUnit, h02, callable);
    }

    public final z N1() {
        o o10 = Functions.k();
        v v10 = new v(this, o10);
        return e.a.a1.a.R(v10);
    }

    public final e.a.s0.b N2(r r10) {
        g g10 = Functions.f;
        a a10 = Functions.c;
        return this.P2(r10, g10, a10);
    }

    public final e.a.x0.a N4(int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.O4(n10, l10, timeUnit, h02);
    }

    public final z N5(o o10) {
        int n10 = z.b0();
        return this.O5(o10, n10);
    }

    public final z N7(e0[] e0Array, o o10) {
        e.a.w0.b.a.g(e0Array, "others is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        ObservableWithLatestFromMany observableWithLatestFromMany = new ObservableWithLatestFromMany((e0)this, e0Array, o10);
        return e.a.a1.a.R(observableWithLatestFromMany);
    }

    public final z O(long l10, long l11, TimeUnit timeUnit, h0 h02, Callable callable) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        e.a.w0.e.e.m m10 = new e.a.w0.e.e.m(this, l10, l11, timeUnit, h02, callable, -1 >>> 1, false);
        return e.a.a1.a.R(m10);
    }

    public final z O1(o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        v v10 = new v(this, o10);
        return e.a.a1.a.R(v10);
    }

    public final e.a.s0.b O2(r r10, g g10) {
        a a10 = Functions.c;
        return this.P2(r10, g10, a10);
    }

    public final e.a.x0.a O4(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return ObservableReplay.v8(this, l10, timeUnit, h02, n10);
    }

    public final z O5(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl2 = this instanceof m;
        if (bl2) {
            Object object2 = this;
            object2 = ((m)((Object)this)).call();
            if (object2 == null) {
                return z.l2();
            }
            return ObservableScalarXMap.a(object2, o10);
        }
        object = new ObservableSwitchMap(this, o10, n10, false);
        return e.a.a1.a.R((z)object);
    }

    public final z P(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.S(l10, timeUnit, h02, -1 >>> 1);
    }

    public final z P1() {
        o o10 = Functions.k();
        Callable callable = Functions.g();
        return this.R1(o10, callable);
    }

    public final e.a.s0.b P2(r r10, g g10, a a10) {
        e.a.w0.b.a.g(r10, "onNext is null");
        e.a.w0.b.a.g(g10, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(r10, g10, a10);
        this.subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final e.a.x0.a P4(int n10, h0 h02) {
        e.a.w0.b.a.h(n10, "bufferSize");
        return ObservableReplay.z8(this.M4(n10), h02);
    }

    public final e.a.a P5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapCompletable observableSwitchMapCompletable = new ObservableSwitchMapCompletable(this, o10, false);
        return e.a.a1.a.O(observableSwitchMapCompletable);
    }

    public final z Q(long l10, TimeUnit timeUnit, int n10) {
        h0 h02 = e.a.c1.b.a();
        return this.S(l10, timeUnit, h02, n10);
    }

    public final z Q1(o o10) {
        Callable callable = Functions.g();
        return this.R1(o10, callable);
    }

    public final e.a.x0.a Q4(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.R4(l10, timeUnit, h02);
    }

    public final e.a.a Q5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapCompletable observableSwitchMapCompletable = new ObservableSwitchMapCompletable(this, o10, true);
        return e.a.a1.a.O(observableSwitchMapCompletable);
    }

    public final z Q6() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.a();
        return this.T6(timeUnit, h02);
    }

    public final z R(long l10, TimeUnit timeUnit, h0 h02) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.T(l10, timeUnit, h02, -1 >>> 1, callable, false);
    }

    public final z R1(o o10, Callable callable) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.w0.b.a.g(callable, "collectionSupplier is null");
        x x10 = new x(this, o10, callable);
        return e.a.a1.a.R(x10);
    }

    public final e.a.x0.a R4(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return ObservableReplay.u8(this, l10, timeUnit, h02);
    }

    public final z R5(o o10) {
        int n10 = z.b0();
        return this.S5(o10, n10);
    }

    public final z R6(h0 h02) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return this.T6(timeUnit, h02);
    }

    public final z S(long l10, TimeUnit timeUnit, h0 h02, int n10) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.T(l10, timeUnit, h02, n10, callable, false);
    }

    public final z S1() {
        o o10 = Functions.k();
        return this.U1(o10);
    }

    public final e.a.x0.a S4(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return ObservableReplay.z8(this.L4(), h02);
    }

    public final z S5(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl2 = this instanceof m;
        if (bl2) {
            Object object2 = this;
            object2 = ((m)((Object)this)).call();
            if (object2 == null) {
                return z.l2();
            }
            return ObservableScalarXMap.a(object2, o10);
        }
        object = new ObservableSwitchMap(this, o10, n10, true);
        return e.a.a1.a.R((z)object);
    }

    public final z S6(TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.T6(timeUnit, h02);
    }

    public final z T(long l10, TimeUnit timeUnit, h0 h02, int n10, Callable callable, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        e.a.w0.b.a.h(n10, "count");
        e.a.w0.e.e.m m10 = new e.a.w0.e.e.m(this, l10, l10, timeUnit, h02, callable, n10, bl2);
        return e.a.a1.a.R(m10);
    }

    public final z T0(o o10) {
        return this.U0(o10, 2);
    }

    public final z T1(d d10) {
        e.a.w0.b.a.g(d10, "comparer is null");
        o o10 = Functions.k();
        y y10 = new y(this, o10, d10);
        return e.a.a1.a.R(y10);
    }

    public final z T4() {
        r r10 = Functions.c();
        return this.V4(Long.MAX_VALUE, r10);
    }

    public final z T5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapMaybe observableSwitchMapMaybe = new ObservableSwitchMapMaybe(this, o10, false);
        return e.a.a1.a.R(observableSwitchMapMaybe);
    }

    public final z T6(TimeUnit object, h0 h02) {
        e.a.w0.b.a.g(object, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        object = Functions.w(object, h02);
        return this.H3((o)object);
    }

    public final z U(e0 e02) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.Y(e02, callable);
    }

    public final z U0(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "prefetch";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl2 = this instanceof m;
        if (bl2) {
            Object object2 = this;
            object2 = ((m)((Object)this)).call();
            if (object2 == null) {
                return z.l2();
            }
            return ObservableScalarXMap.a(object2, o10);
        }
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        object = new ObservableConcatMap(this, o10, n10, errorMode);
        return e.a.a1.a.R((z)object);
    }

    public final z U1(o o10) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        d d10 = e.a.w0.b.a.d();
        y y10 = new y(this, o10, d10);
        return e.a.a1.a.R(y10);
    }

    public final z U4(long l10) {
        r r10 = Functions.c();
        return this.V4(l10, r10);
    }

    public final z U5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapMaybe observableSwitchMapMaybe = new ObservableSwitchMapMaybe(this, o10, true);
        return e.a.a1.a.R(observableSwitchMapMaybe);
    }

    public final Object U6(o object) {
        String string2 = "converter is null";
        try {
            object = e.a.w0.b.a.g(object, string2);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
        object = (o)object;
        return object.apply(this);
    }

    public final z V(e0 e02, int n10) {
        e.a.w0.b.a.h(n10, "initialCapacity");
        Callable callable = Functions.f(n10);
        return this.Y(e02, callable);
    }

    public final e.a.a V0(o o10) {
        return this.W0(o10, 2);
    }

    public final z V1(g g10) {
        e.a.w0.b.a.g(g10, "onAfterNext is null");
        e.a.w0.e.e.z z10 = new e.a.w0.e.e.z(this, g10);
        return e.a.a1.a.R(z10);
    }

    public final z V4(long l10, r object) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            e.a.w0.b.a.g(object, "predicate is null");
            ObservableRetryPredicate observableRetryPredicate = new ObservableRetryPredicate(this, l10, (r)object);
            return e.a.a1.a.R(observableRetryPredicate);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final z V5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapSingle observableSwitchMapSingle = new ObservableSwitchMapSingle(this, o10, false);
        return e.a.a1.a.R(observableSwitchMapSingle);
    }

    public final e.a.j V6(BackpressureStrategy object) {
        e.a.w0.e.b.g0 g02 = new e.a.w0.e.b.g0(this);
        int[] nArray = z$a.a;
        int n10 = object.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return g02.w4();
                    }
                    object = new FlowableOnBackpressureError(g02);
                    return e.a.a1.a.P((e.a.j)object);
                }
                return g02;
            }
            return g02.G4();
        }
        return g02.E4();
    }

    public final z W(e0 e02, o o10) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.X(e02, o10, callable);
    }

    public final e.a.a W0(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "capacityHint");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMapCompletable observableConcatMapCompletable = new ObservableConcatMapCompletable(this, o10, errorMode, n10);
        return e.a.a1.a.O(observableConcatMapCompletable);
    }

    public final z W1(a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        g g10 = Functions.h();
        g g11 = Functions.h();
        a a11 = Functions.c;
        return this.c2(g10, g11, a11, a10);
    }

    public final z W4(d d10) {
        e.a.w0.b.a.g(d10, "predicate is null");
        ObservableRetryBiPredicate observableRetryBiPredicate = new ObservableRetryBiPredicate(this, d10);
        return e.a.a1.a.R(observableRetryBiPredicate);
    }

    public final z W5(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        ObservableSwitchMapSingle observableSwitchMapSingle = new ObservableSwitchMapSingle(this, o10, true);
        return e.a.a1.a.R(observableSwitchMapSingle);
    }

    public final Future W6() {
        e.a.w0.d.h h10 = new e.a.w0.d.h();
        return (Future)((Object)this.i(h10));
    }

    public final z X(e0 e02, o o10, Callable callable) {
        e.a.w0.b.a.g(e02, "openingIndicator is null");
        e.a.w0.b.a.g(o10, "closingIndicator is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        ObservableBufferBoundary observableBufferBoundary = new ObservableBufferBoundary(this, e02, o10, callable);
        return e.a.a1.a.R(observableBufferBoundary);
    }

    public final e.a.a X0(o o10) {
        return this.Z0(o10, true, 2);
    }

    public final z X1(a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        ObservableDoFinally observableDoFinally = new ObservableDoFinally(this, a10);
        return e.a.a1.a.R(observableDoFinally);
    }

    public final z X4(r r10) {
        return this.V4(Long.MAX_VALUE, r10);
    }

    public final i0 X6() {
        return this.Y6(16);
    }

    public final z Y(e0 e02, Callable callable) {
        e.a.w0.b.a.g(e02, "boundary is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        e.a.w0.e.e.l l10 = new e.a.w0.e.e.l(this, e02, callable);
        return e.a.a1.a.R(l10);
    }

    public final e.a.a Y0(o o10, boolean bl2) {
        return this.Z0(o10, bl2, 2);
    }

    public final z Y1(a a10) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        a a11 = Functions.c;
        return this.c2(g10, g11, a10, a11);
    }

    public final z Y4(e object) {
        e.a.w0.b.a.g(object, "stop is null");
        object = Functions.v((e)object);
        return this.V4(Long.MAX_VALUE, (r)object);
    }

    public final i0 Y6(int n10) {
        e.a.w0.b.a.h(n10, "capacityHint");
        w1 w12 = new w1((e0)this, n10);
        return e.a.a1.a.S(w12);
    }

    public final z Z(Callable callable) {
        Callable callable2 = ArrayListSupplier.asCallable();
        return this.a0(callable, callable2);
    }

    public final e.a.a Z0(o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        ObservableConcatMapCompletable observableConcatMapCompletable = new ObservableConcatMapCompletable(this, o10, errorMode, n10);
        return e.a.a1.a.O(observableConcatMapCompletable);
    }

    public final z Z1(a a10) {
        g g10 = Functions.h();
        return this.e2(g10, a10);
    }

    public final z Z4(o o10) {
        e.a.w0.b.a.g(o10, "handler is null");
        ObservableRetryWhen observableRetryWhen = new ObservableRetryWhen(this, o10);
        return e.a.a1.a.R(observableRetryWhen);
    }

    public final i0 Z6(Callable callable) {
        e.a.w0.b.a.g(callable, "collectionSupplier is null");
        w1 w12 = new w1((e0)this, callable);
        return e.a.a1.a.S(w12);
    }

    public final e.a.s0.b a() {
        g g10 = Functions.h();
        g g11 = Functions.f;
        a a10 = Functions.c;
        g g12 = Functions.h();
        return this.h(g10, g11, a10, g12);
    }

    public final z a0(Callable callable, Callable callable2) {
        e.a.w0.b.a.g(callable, "boundarySupplier is null");
        e.a.w0.b.a.g(callable2, "bufferSupplier is null");
        e.a.w0.e.e.k k10 = new e.a.w0.e.e.k(this, callable, callable2);
        return e.a.a1.a.R(k10);
    }

    public final z a1(o o10) {
        int n10 = z.b0();
        return this.b1(o10, n10, true);
    }

    public final z a2(g0 object) {
        e.a.w0.b.a.g(object, "observer is null");
        g g10 = ObservableInternalHelper.f((g0)object);
        g g11 = ObservableInternalHelper.e((g0)object);
        object = ObservableInternalHelper.d((g0)object);
        a a10 = Functions.c;
        return this.c2(g10, g11, (a)object, a10);
    }

    public final void a5(g0 g02) {
        Object object = "observer is null";
        e.a.w0.b.a.g(g02, (String)object);
        boolean bl2 = g02 instanceof e.a.y0.k;
        if (bl2) {
            this.subscribe(g02);
        } else {
            object = new e.a.y0.k(g02);
            this.subscribe((g0)object);
        }
    }

    public final i0 a7(o object) {
        e.a.w0.b.a.g(object, "keySelector is null");
        Callable callable = HashMapSupplier.asCallable();
        object = Functions.F((o)object);
        return this.f0(callable, (b)object);
    }

    public final TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.subscribe(testObserver);
        return testObserver;
    }

    public final z b1(o o10, int n10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "prefetch";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl3 = this instanceof m;
        if (bl3) {
            Object object2 = this;
            object2 = ((m)((Object)this)).call();
            if (object2 == null) {
                return z.l2();
            }
            return ObservableScalarXMap.a(object2, o10);
        }
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        object = new ObservableConcatMap(this, o10, n10, errorMode);
        return e.a.a1.a.R((z)object);
    }

    public final z b2(g object) {
        e.a.w0.b.a.g(object, "onNotification is null");
        g g10 = Functions.t((g)object);
        g g11 = Functions.s((g)object);
        object = Functions.r((g)object);
        a a10 = Functions.c;
        return this.c2(g10, g11, (a)object, a10);
    }

    public final z b5(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.c5(l10, timeUnit, h02);
    }

    public final z b6(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            q1 q12 = new q1(this, l10);
            return e.a.a1.a.R(q12);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final i0 b7(o object, o o10) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        Callable callable = HashMapSupplier.asCallable();
        object = Functions.G((o)object, o10);
        return this.f0(callable, (b)object);
    }

    public final e.a.s0.b c(g g10, g g11) {
        a a10 = Functions.c;
        g g12 = Functions.h();
        return this.h(g10, g11, a10, g12);
    }

    public final z c0() {
        return this.d0(16);
    }

    public final z c1(o o10) {
        int n10 = z.b0();
        return this.d1(o10, -1 >>> 1, n10);
    }

    public final z c5(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableSampleTimed observableSampleTimed = new ObservableSampleTimed(this, l10, timeUnit, h02, false);
        return e.a.a1.a.R(observableSampleTimed);
    }

    public final z c6(long l10, TimeUnit timeUnit) {
        z z10 = z.O6(l10, timeUnit);
        return this.n6(z10);
    }

    public final i0 c7(o object, o o10, Callable callable) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        e.a.w0.b.a.g(callable, "mapSupplier is null");
        object = Functions.G((o)object, o10);
        return this.f0(callable, (b)object);
    }

    public final e.a.s0.b d(g g10) {
        g g11 = Functions.f;
        a a10 = Functions.c;
        g g12 = Functions.h();
        return this.h(g10, g11, a10, g12);
    }

    public final z d0(int n10) {
        e.a.w0.b.a.h(n10, "initialCapacity");
        ObservableCache observableCache = new ObservableCache(this, n10);
        return e.a.a1.a.R(observableCache);
    }

    public final z d1(o o10, int n10, int n11) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMapEager observableConcatMapEager = new ObservableConcatMapEager(this, o10, errorMode, n10, n11);
        return e.a.a1.a.R(observableConcatMapEager);
    }

    public final z d2(g g10) {
        g g11 = Functions.h();
        a a10 = Functions.c;
        return this.c2(g11, g10, a10, a10);
    }

    public final z d3(o o10) {
        o o11 = Functions.k();
        int n10 = z.b0();
        return this.g3(o10, o11, false, n10);
    }

    public final z d4(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        ObservableMergeWithCompletable observableMergeWithCompletable = new ObservableMergeWithCompletable(this, g10);
        return e.a.a1.a.R(observableMergeWithCompletable);
    }

    public final z d5(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableSampleTimed observableSampleTimed = new ObservableSampleTimed(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.R(observableSampleTimed);
    }

    public final z d6(long l10, TimeUnit timeUnit, h0 h02) {
        z z10 = z.P6(l10, timeUnit, h02);
        return this.n6(z10);
    }

    public final i0 d7(o o10) {
        o o11 = Functions.k();
        Callable callable = HashMapSupplier.asCallable();
        o o12 = ArrayListSupplier.asFunction();
        return this.g7(o10, o11, callable, o12);
    }

    public final z d8(e0 e02, c c10) {
        e.a.w0.b.a.g(e02, "other is null");
        return z.W7(this, e02, c10);
    }

    public final TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.dispose();
        }
        this.subscribe(testObserver);
        return testObserver;
    }

    public final z e0(Class object) {
        e.a.w0.b.a.g(object, "clazz is null");
        object = Functions.e((Class)object);
        return this.H3((o)object);
    }

    public final z e1(o o10, int n10, int n11, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        ObservableConcatMapEager observableConcatMapEager = new ObservableConcatMapEager(this, o10, errorMode, n10, n11);
        return e.a.a1.a.R(observableConcatMapEager);
    }

    public final z e2(g g10, a a10) {
        e.a.w0.b.a.g(g10, "onSubscribe is null");
        e.a.w0.b.a.g(a10, "onDispose is null");
        b0 b02 = new b0(this, g10, a10);
        return e.a.a1.a.R(b02);
    }

    public final z e3(o o10, o o11) {
        int n10 = z.b0();
        return this.g3(o10, o11, false, n10);
    }

    public final z e4(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        ObservableMergeWithMaybe observableMergeWithMaybe = new ObservableMergeWithMaybe(this, w10);
        return e.a.a1.a.R(observableMergeWithMaybe);
    }

    public final z e5(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.d5(l10, timeUnit, h02, bl2);
    }

    public final z e6(int n10) {
        if (n10 >= 0) {
            if (n10 == 0) {
                r0 r02 = new r0(this);
                return e.a.a1.a.R(r02);
            }
            int n11 = 1;
            if (n10 == n11) {
                r1 r12 = new r1(this);
                return e.a.a1.a.R(r12);
            }
            ObservableTakeLast observableTakeLast = new ObservableTakeLast(this, n10);
            return e.a.a1.a.R(observableTakeLast);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final i0 e7(o o10, o o11) {
        Callable callable = HashMapSupplier.asCallable();
        o o12 = ArrayListSupplier.asFunction();
        return this.g7(o10, o11, callable, o12);
    }

    public final z e8(e0 e02, c c10, boolean bl2) {
        return z.X7(this, e02, c10, bl2);
    }

    public final e.a.s0.b f(g g10, g g11, a a10) {
        g g12 = Functions.h();
        return this.h(g10, g11, a10, g12);
    }

    public final i0 f0(Callable callable, b b10) {
        e.a.w0.b.a.g(callable, "initialValueSupplier is null");
        e.a.w0.b.a.g(b10, "collector is null");
        e.a.w0.e.e.o o10 = new e.a.w0.e.e.o(this, callable, b10);
        return e.a.a1.a.S(o10);
    }

    public final z f1(o o10, boolean bl2) {
        int n10 = z.b0();
        return this.e1(o10, -1 >>> 1, n10, bl2);
    }

    public final z f2(g g10) {
        g g11 = Functions.h();
        a a10 = Functions.c;
        return this.c2(g10, g11, a10, a10);
    }

    public final z f3(o o10, o o11, boolean bl2) {
        int n10 = z.b0();
        return this.g3(o10, o11, bl2, n10);
    }

    public final z f4(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        return z.L3(this, e02);
    }

    public final z f5(e0 e02) {
        e.a.w0.b.a.g(e02, "sampler is null");
        ObservableSampleWithObservable observableSampleWithObservable = new ObservableSampleWithObservable(this, e02, false);
        return e.a.a1.a.R(observableSampleWithObservable);
    }

    public final z f6(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.i();
        int n10 = z.b0();
        return this.h6(l10, l11, timeUnit, h02, false, n10);
    }

    public final i0 f7(o o10, o o11, Callable callable) {
        o o12 = ArrayListSupplier.asFunction();
        return this.g7(o10, o11, callable, o12);
    }

    public final z f8(e0 e02, c c10, boolean bl2, int n10) {
        return z.Y7(this, e02, c10, bl2, n10);
    }

    public final i0 g0(Object object, b b10) {
        e.a.w0.b.a.g(object, "initialValue is null");
        object = Functions.m(object);
        return this.f0((Callable)object, b10);
    }

    public final z g1(o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.e.e.i0 i02 = new e.a.w0.e.e.i0(this, o10);
        return e.a.a1.a.R(i02);
    }

    public final z g2(g g10) {
        a a10 = Functions.c;
        return this.e2(g10, a10);
    }

    public final z g3(o o10, o o11, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.w0.b.a.g(o11, "valueSelector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableGroupBy observableGroupBy = new ObservableGroupBy(this, o10, o11, n10, bl2);
        return e.a.a1.a.R(observableGroupBy);
    }

    public final z g4(e.a.o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        ObservableMergeWithSingle observableMergeWithSingle = new ObservableMergeWithSingle(this, o02);
        return e.a.a1.a.R(observableMergeWithSingle);
    }

    public final z g5(e0 e02, boolean bl2) {
        e.a.w0.b.a.g(e02, "sampler is null");
        ObservableSampleWithObservable observableSampleWithObservable = new ObservableSampleWithObservable(this, e02, bl2);
        return e.a.a1.a.R(observableSampleWithObservable);
    }

    public final z g6(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        int n10 = z.b0();
        return this.h6(l10, l11, timeUnit, h02, false, n10);
    }

    public final i0 g7(o object, o o10, Callable callable, o o11) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        e.a.w0.b.a.g(callable, "mapSupplier is null");
        e.a.w0.b.a.g(o11, "collectionFactory is null");
        object = Functions.H((o)object, o10, o11);
        return this.f0(callable, (b)object);
    }

    public final z g8(Iterable iterable, c c10) {
        e.a.w0.b.a.g(iterable, "other is null");
        e.a.w0.b.a.g(c10, "zipper is null");
        z1 z12 = new z1(this, iterable, c10);
        return e.a.a1.a.R(z12);
    }

    public final e.a.s0.b h(g g10, g g11, a a10, g g12) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.w0.b.a.g(g12, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(g10, g11, a10, g12);
        this.subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final z h1(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        o10 = ObservableInternalHelper.a(o10);
        return this.U0(o10, n10);
    }

    public final z h2(a a10) {
        e.a.w0.b.a.g(a10, "onTerminate is null");
        g g10 = Functions.h();
        g g11 = Functions.a(a10);
        a a11 = Functions.c;
        return this.c2(g10, g11, a10, a11);
    }

    public final z h3(o o10, boolean bl2) {
        o o11 = Functions.k();
        int n10 = z.b0();
        return this.g3(o10, o11, bl2, n10);
    }

    public final z h5(c c10) {
        e.a.w0.b.a.g(c10, "accumulator is null");
        h1 h12 = new h1(this, c10);
        return e.a.a1.a.R(h12);
    }

    public final z h6(long l10, long l11, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 >= 0) {
            ObservableTakeLastTimed observableTakeLastTimed;
            object = observableTakeLastTimed;
            z z10 = this;
            observableTakeLastTimed = new ObservableTakeLastTimed(this, l10, l11, timeUnit, h02, n10, bl2);
            return e.a.a1.a.R(observableTakeLastTimed);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("count >= 0 required but it was ");
        charSequence.append(l10);
        charSequence = charSequence.toString();
        object = new IndexOutOfBoundsException((String)charSequence);
        throw object;
    }

    public final i0 h7() {
        Comparator comparator = Functions.q();
        return this.j7(comparator);
    }

    public final g0 i(g0 g02) {
        this.subscribe(g02);
        return g02;
    }

    public final z i1(o o10) {
        return this.j1(o10, 2);
    }

    public final q i2(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            e.a.w0.e.e.d0 d02 = new e.a.w0.e.e.d0(this, l10);
            return e.a.a1.a.Q(d02);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final z i3(e0 e02, o o10, o o11, c c10) {
        e.a.w0.b.a.g(e02, "other is null");
        e.a.w0.b.a.g(o10, "leftEnd is null");
        e.a.w0.b.a.g(o11, "rightEnd is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        ObservableGroupJoin observableGroupJoin = new ObservableGroupJoin(this, e02, o10, o11, c10);
        return e.a.a1.a.R(observableGroupJoin);
    }

    public final z i4(h0 h02) {
        int n10 = z.b0();
        return this.k4(h02, false, n10);
    }

    public final z i5(Object object, c c10) {
        e.a.w0.b.a.g(object, "initialValue is null");
        object = Functions.m(object);
        return this.j5((Callable)object, c10);
    }

    public final z i6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.i();
        int n10 = z.b0();
        return this.l6(l10, timeUnit, h02, false, n10);
    }

    public final i0 i7(int n10) {
        Comparator comparator = Functions.q();
        return this.k7(comparator, n10);
    }

    public final z j1(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMapMaybe observableConcatMapMaybe = new ObservableConcatMapMaybe(this, o10, errorMode, n10);
        return e.a.a1.a.R(observableConcatMapMaybe);
    }

    public final i0 j2(long l10, Object object) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            e.a.w0.b.a.g(object, "defaultItem is null");
            e.a.w0.e.e.e0 e02 = new e.a.w0.e.e.e0(this, l10, object);
            return e.a.a1.a.S(e02);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final z j3() {
        q0 q02 = new q0(this);
        return e.a.a1.a.R(q02);
    }

    public final z j4(h0 h02, boolean bl2) {
        int n10 = z.b0();
        return this.k4(h02, bl2, n10);
    }

    public final z j5(Callable callable, c c10) {
        e.a.w0.b.a.g(callable, "seedSupplier is null");
        e.a.w0.b.a.g(c10, "accumulator is null");
        i1 i12 = new i1(this, callable, c10);
        return e.a.a1.a.R(i12);
    }

    public final z j6(long l10, TimeUnit timeUnit, h0 h02) {
        int n10 = z.b0();
        return this.l6(l10, timeUnit, h02, false, n10);
    }

    public final i0 j7(Comparator object) {
        e.a.w0.b.a.g(object, "comparator is null");
        i0 i02 = this.X6();
        object = Functions.o((Comparator)object);
        return i02.z0((o)object);
    }

    public final i0 k(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        f f10 = new f(this, r10);
        return e.a.a1.a.S(f10);
    }

    public final z k1(o o10) {
        return this.m1(o10, true, 2);
    }

    public final i0 k2(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            e.a.w0.e.e.e0 e02 = new e.a.w0.e.e.e0(this, l10, null);
            return e.a.a1.a.S(e02);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final e.a.a k3() {
        s0 s02 = new s0(this);
        return e.a.a1.a.O(s02);
    }

    public final z k4(h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableObserveOn observableObserveOn = new ObservableObserveOn(this, h02, bl2, n10);
        return e.a.a1.a.R(observableObserveOn);
    }

    public final z k6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        int n10 = z.b0();
        return this.l6(l10, timeUnit, h02, bl2, n10);
    }

    public final i0 k7(Comparator object, int n10) {
        e.a.w0.b.a.g(object, "comparator is null");
        i0 i02 = this.Y6(n10);
        object = Functions.o((Comparator)object);
        return i02.z0((o)object);
    }

    public final z l1(o o10, boolean bl2) {
        return this.m1(o10, bl2, 2);
    }

    public final z l4(Class clazz) {
        e.a.w0.b.a.g(clazz, "clazz is null");
        r r10 = Functions.l(clazz);
        return this.o2(r10).e0(clazz);
    }

    public final z l6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        return this.h6(Long.MAX_VALUE, l10, timeUnit, h02, bl2, n10);
    }

    public final z m1(o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        ObservableConcatMapMaybe observableConcatMapMaybe = new ObservableConcatMapMaybe(this, o10, errorMode, n10);
        return e.a.a1.a.R(observableConcatMapMaybe);
    }

    public final z m4(e0 object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        return this.n4((o)object);
    }

    public final z m6(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.i();
        int n10 = z.b0();
        return this.l6(l10, timeUnit, h02, bl2, n10);
    }

    public final z m7(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableUnsubscribeOn observableUnsubscribeOn = new ObservableUnsubscribeOn(this, h02);
        return e.a.a1.a.R(observableUnsubscribeOn);
    }

    public final z n1(o o10) {
        return this.o1(o10, 2);
    }

    public final z n4(o o10) {
        e.a.w0.b.a.g(o10, "resumeFunction is null");
        b1 b12 = new b1(this, o10, false);
        return e.a.a1.a.R(b12);
    }

    public final z n6(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        ObservableTakeUntil observableTakeUntil = new ObservableTakeUntil(this, e02);
        return e.a.a1.a.R(observableTakeUntil);
    }

    public final z o(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        e0[] e0Array = new e0[]{this, e02};
        return z.n(e0Array);
    }

    public final z o1(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        ObservableConcatMapSingle observableConcatMapSingle = new ObservableConcatMapSingle(this, o10, errorMode, n10);
        return e.a.a1.a.R(observableConcatMapSingle);
    }

    public final z o2(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        e.a.w0.e.e.h0 h02 = new e.a.w0.e.e.h0(this, r10);
        return e.a.a1.a.R(h02);
    }

    public final z o4(o o10) {
        e.a.w0.b.a.g(o10, "valueSupplier is null");
        c1 c12 = new c1(this, o10);
        return e.a.a1.a.R(c12);
    }

    public final z o5() {
        j1 j12 = new j1(this);
        return e.a.a1.a.R(j12);
    }

    public final z o6(r r10) {
        e.a.w0.b.a.g(r10, "stopPredicate is null");
        s1 s12 = new s1(this, r10);
        return e.a.a1.a.R(s12);
    }

    public final i0 p(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        e.a.w0.e.e.h h10 = new e.a.w0.e.e.h(this, r10);
        return e.a.a1.a.S(h10);
    }

    public final z p1(o o10) {
        return this.r1(o10, true, 2);
    }

    public final i0 p2(Object object) {
        return this.j2(0L, object);
    }

    public final z p4(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        object = Functions.n(object);
        return this.o4((o)object);
    }

    public final z p5() {
        return this.t4().n8();
    }

    public final z p6(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        t1 t12 = new t1(this, r10);
        return e.a.a1.a.R(t12);
    }

    public final z p7(long l10) {
        int n10 = z.b0();
        return this.r7(l10, l10, n10);
    }

    public final Object q(e.a.a0 a02) {
        return ((e.a.a0)e.a.w0.b.a.g(a02, "converter is null")).a(this);
    }

    public final z q1(o o10, boolean bl2) {
        return this.r1(o10, bl2, 2);
    }

    public final q q2() {
        return this.i2(0L);
    }

    public final z q4(e0 object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        b1 b12 = new b1(this, (o)object, true);
        return e.a.a1.a.R(b12);
    }

    public final i0 q5(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        l1 l12 = new l1(this, object);
        return e.a.a1.a.S(l12);
    }

    public final z q6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.r6(l10, timeUnit, h02);
    }

    public final z q7(long l10, long l11) {
        int n10 = z.b0();
        return this.r7(l10, l11, n10);
    }

    public final Object r() {
        Object object = new e.a.w0.d.d();
        this.subscribe((g0)object);
        object = ((e.a.w0.d.c)object).a();
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final z r1(o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        ObservableConcatMapSingle observableConcatMapSingle = new ObservableConcatMapSingle(this, o10, errorMode, n10);
        return e.a.a1.a.R(observableConcatMapSingle);
    }

    public final i0 r2() {
        return this.k2(0L);
    }

    public final i0 r3() {
        r r10 = Functions.b();
        return this.k(r10);
    }

    public final z r4() {
        e.a.w0.e.e.w w10 = new e.a.w0.e.e.w(this);
        return e.a.a1.a.R(w10);
    }

    public final q r5() {
        k1 k12 = new k1(this);
        return e.a.a1.a.Q(k12);
    }

    public final z r6(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableThrottleFirstTimed observableThrottleFirstTimed = new ObservableThrottleFirstTimed(this, l10, timeUnit, h02);
        return e.a.a1.a.R(observableThrottleFirstTimed);
    }

    public final z r7(long l10, long l11, int n10) {
        e.a.w0.b.a.i(l10, "count");
        e.a.w0.b.a.i(l11, "skip");
        e.a.w0.b.a.h(n10, "bufferSize");
        ObservableWindow observableWindow = new ObservableWindow(this, l10, l11, n10);
        return e.a.a1.a.R(observableWindow);
    }

    public final Object s(Object object) {
        Object object2 = new e.a.w0.d.d();
        this.subscribe((g0)object2);
        object2 = ((e.a.w0.d.c)object2).a();
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    public final z s1(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        ObservableConcatWithCompletable observableConcatWithCompletable = new ObservableConcatWithCompletable(this, g10);
        return e.a.a1.a.R(observableConcatWithCompletable);
    }

    public final z s2(o o10) {
        return this.B2(o10, false);
    }

    public final z s3(e0 e02, o o10, o o11, c c10) {
        e.a.w0.b.a.g(e02, "other is null");
        e.a.w0.b.a.g(o10, "leftEnd is null");
        e.a.w0.b.a.g(o11, "rightEnd is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        ObservableJoin observableJoin = new ObservableJoin(this, e02, o10, o11, c10);
        return e.a.a1.a.R(observableJoin);
    }

    public final z s4(o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        ObservablePublishSelector observablePublishSelector = new ObservablePublishSelector(this, o10);
        return e.a.a1.a.R(observablePublishSelector);
    }

    public final i0 s5() {
        l1 l12 = new l1(this, null);
        return e.a.a1.a.S(l12);
    }

    public final z s6(long l10, TimeUnit timeUnit) {
        return this.b5(l10, timeUnit);
    }

    public final z s7(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        int n10 = z.b0();
        return this.u7(l10, l11, timeUnit, h02, n10);
    }

    public final void subscribe(g0 g02) {
        Object object = "observer is null";
        e.a.w0.b.a.g(g02, (String)object);
        g02 = e.a.a1.a.f0(this, g02);
        object = "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins";
        e.a.w0.b.a.g(g02, (String)object);
        try {
            this.K5(g02);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
            object = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            ((Throwable)object).initCause(throwable);
            throw object;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    public final void t(g g10) {
        boolean bl2;
        Iterator iterator2 = this.u().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object t10;
            try {
                t10 = iterator2.next();
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                ((e.a.s0.b)((Object)iterator2)).dispose();
                throw ExceptionHelper.f(throwable);
            }
            g10.accept(t10);
        }
    }

    public final z t1(w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        ObservableConcatWithMaybe observableConcatWithMaybe = new ObservableConcatWithMaybe(this, w10);
        return e.a.a1.a.R(observableConcatWithMaybe);
    }

    public final z t2(o o10, int n10) {
        int n11 = z.b0();
        return this.D2(o10, false, n10, n11);
    }

    public final e.a.x0.a t4() {
        return ObservablePublish.t8(this);
    }

    public final z t5(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return e.a.a1.a.R(this);
        }
        m1 m12 = new m1(this, l10);
        return e.a.a1.a.R(m12);
    }

    public final z t6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.c5(l10, timeUnit, h02);
    }

    public final z t7(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        int n10 = z.b0();
        return this.u7(l10, l11, timeUnit, h02, n10);
    }

    public final Iterable u() {
        int n10 = z.b0();
        return this.v(n10);
    }

    public final z u1(e0 e02) {
        e.a.w0.b.a.g(e02, "other is null");
        return z.C0(this, e02);
    }

    public final z u2(o o10, c c10) {
        int n10 = z.b0();
        int n11 = z.b0();
        return this.y2(o10, c10, false, n10, n11);
    }

    public final z u5(long l10, TimeUnit timeUnit) {
        z z10 = z.O6(l10, timeUnit);
        return this.C5(z10);
    }

    public final z u6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.w6(l10, timeUnit, h02, false);
    }

    public final z u7(long l10, long l11, TimeUnit timeUnit, h0 h02, int n10) {
        e.a.w0.b.a.i(l10, "timespan");
        e.a.w0.b.a.i(l11, "timeskip");
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        y1 y12 = new y1(this, l10, l11, timeUnit, h02, Long.MAX_VALUE, n10, false);
        return e.a.a1.a.R(y12);
    }

    public final Iterable v(int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        BlockingObservableIterable blockingObservableIterable = new BlockingObservableIterable(this, n10);
        return blockingObservableIterable;
    }

    public final z v1(e.a.o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        ObservableConcatWithSingle observableConcatWithSingle = new ObservableConcatWithSingle(this, o02);
        return e.a.a1.a.R(observableConcatWithSingle);
    }

    public final z v2(o o10, c c10, int n10) {
        int n11 = z.b0();
        return this.y2(o10, c10, false, n10, n11);
    }

    public final z v5(long l10, TimeUnit timeUnit, h0 h02) {
        z z10 = z.P6(l10, timeUnit, h02);
        return this.C5(z10);
    }

    public final z v6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.w6(l10, timeUnit, h02, false);
    }

    public final z v7(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.A7(l10, timeUnit, h02, Long.MAX_VALUE, false);
    }

    public final Object w() {
        Object object = new e.a.w0.d.e();
        this.subscribe((g0)object);
        object = ((e.a.w0.d.c)object).a();
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final i0 w1(Object object) {
        e.a.w0.b.a.g(object, "element is null");
        object = Functions.i(object);
        return this.p((r)object);
    }

    public final z w2(o o10, c c10, boolean bl2) {
        int n10 = z.b0();
        int n11 = z.b0();
        return this.y2(o10, c10, bl2, n10, n11);
    }

    public final q w4(c c10) {
        e.a.w0.b.a.g(c10, "reducer is null");
        e1 e12 = new e1(this, c10);
        return e.a.a1.a.Q(e12);
    }

    public final z w5(int n10) {
        if (n10 >= 0) {
            if (n10 == 0) {
                return e.a.a1.a.R(this);
            }
            ObservableSkipLast observableSkipLast = new ObservableSkipLast(this, n10);
            return e.a.a1.a.R(observableSkipLast);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final z w6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        ObservableThrottleLatest observableThrottleLatest = new ObservableThrottleLatest(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.R(observableThrottleLatest);
    }

    public final z w7(long l10, TimeUnit timeUnit, long l11) {
        h0 h02 = e.a.c1.b.a();
        return this.A7(l10, timeUnit, h02, l11, false);
    }

    public final Object x(Object object) {
        Object object2 = new e.a.w0.d.e();
        this.subscribe((g0)object2);
        object2 = ((e.a.w0.d.c)object2).a();
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    public final i0 x1() {
        e.a.w0.e.e.q q10 = new e.a.w0.e.e.q(this);
        return e.a.a1.a.S(q10);
    }

    public final z x2(o o10, c c10, boolean bl2, int n10) {
        int n11 = z.b0();
        return this.y2(o10, c10, bl2, n10, n11);
    }

    public final i0 x4(Object object, c c10) {
        e.a.w0.b.a.g(object, "seed is null");
        e.a.w0.b.a.g(c10, "reducer is null");
        f1 f12 = new f1(this, object, c10);
        return e.a.a1.a.S(f12);
    }

    public final z x5(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.i();
        int n10 = z.b0();
        return this.A5(l10, timeUnit, h02, false, n10);
    }

    public final z x6(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.w6(l10, timeUnit, h02, bl2);
    }

    public final z x7(long l10, TimeUnit timeUnit, long l11, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.A7(l10, timeUnit, h02, l11, bl2);
    }

    public final Iterable y() {
        e.a.w0.e.e.b b10 = new e.a.w0.e.e.b(this);
        return b10;
    }

    public final z y2(o o10, c c10, boolean bl2, int n10, int n11) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "combiner is null");
        o10 = ObservableInternalHelper.b(o10, c10);
        return this.D2(o10, bl2, n10, n11);
    }

    public final i0 y4(Callable callable, c c10) {
        e.a.w0.b.a.g(callable, "seedSupplier is null");
        e.a.w0.b.a.g(c10, "reducer is null");
        g1 g12 = new g1(this, callable, c10);
        return e.a.a1.a.S(g12);
    }

    public final z y5(long l10, TimeUnit timeUnit, h0 h02) {
        int n10 = z.b0();
        return this.A5(l10, timeUnit, h02, false, n10);
    }

    public final z y6(long l10, TimeUnit timeUnit) {
        return this.z1(l10, timeUnit);
    }

    public final z y7(long l10, TimeUnit timeUnit, h0 h02) {
        return this.A7(l10, timeUnit, h02, Long.MAX_VALUE, false);
    }

    public final Iterable z(Object object) {
        e.a.w0.e.e.c c10 = new e.a.w0.e.e.c(this, object);
        return c10;
    }

    public final z z0(f0 f02) {
        return z.O7(((f0)e.a.w0.b.a.g(f02, "composer is null")).a(this));
    }

    public final z z1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.A1(l10, timeUnit, h02);
    }

    public final z z2(o o10, o o11, Callable callable) {
        e.a.w0.b.a.g(o10, "onNextMapper is null");
        e.a.w0.b.a.g(o11, "onErrorMapper is null");
        e.a.w0.b.a.g(callable, "onCompleteSupplier is null");
        y0 y02 = new y0(this, o10, o11, callable);
        return z.J3(y02);
    }

    public final z z4() {
        return this.A4(Long.MAX_VALUE);
    }

    public final z z5(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        int n10 = z.b0();
        return this.A5(l10, timeUnit, h02, bl2, n10);
    }

    public final z z6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.A1(l10, timeUnit, h02);
    }

    public final z z7(long l10, TimeUnit timeUnit, h0 h02, long l11) {
        return this.A7(l10, timeUnit, h02, l11, false);
    }
}

