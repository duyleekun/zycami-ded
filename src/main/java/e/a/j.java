/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.h0;
import e.a.o0;
import e.a.v0.a;
import e.a.v0.g;
import e.a.v0.n;
import e.a.w0.e.b.a0;
import e.a.w0.e.b.a1;
import e.a.w0.e.b.b;
import e.a.w0.e.b.b0;
import e.a.w0.e.b.b1;
import e.a.w0.e.b.c;
import e.a.w0.e.b.c0;
import e.a.w0.e.b.c1;
import e.a.w0.e.b.d;
import e.a.w0.e.b.d1;
import e.a.w0.e.b.e;
import e.a.w0.e.b.e0;
import e.a.w0.e.b.f;
import e.a.w0.e.b.f0;
import e.a.w0.e.b.f1;
import e.a.w0.e.b.g1;
import e.a.w0.e.b.h;
import e.a.w0.e.b.h1;
import e.a.w0.e.b.i;
import e.a.w0.e.b.i0;
import e.a.w0.e.b.i1;
import e.a.w0.e.b.j0;
import e.a.w0.e.b.j1;
import e.a.w0.e.b.k;
import e.a.w0.e.b.k0;
import e.a.w0.e.b.k1;
import e.a.w0.e.b.l;
import e.a.w0.e.b.l0;
import e.a.w0.e.b.l1;
import e.a.w0.e.b.m;
import e.a.w0.e.b.m0;
import e.a.w0.e.b.o;
import e.a.w0.e.b.p;
import e.a.w0.e.b.p0;
import e.a.w0.e.b.q;
import e.a.w0.e.b.r;
import e.a.w0.e.b.r0;
import e.a.w0.e.b.s;
import e.a.w0.e.b.t;
import e.a.w0.e.b.t0;
import e.a.w0.e.b.u;
import e.a.w0.e.b.u0;
import e.a.w0.e.b.v;
import e.a.w0.e.b.v0;
import e.a.w0.e.b.w;
import e.a.w0.e.b.w0;
import e.a.w0.e.b.x;
import e.a.w0.e.b.x0;
import e.a.w0.e.b.y;
import e.a.w0.e.b.y0;
import e.a.w0.e.b.z;
import e.a.w0.e.b.z0;
import e.a.w0.e.e.n0;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.subscribers.TestSubscriber;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class j
implements i.g.c {
    public static final int a;

    static {
        int n10 = Integer.getInteger("rx2.buffer-size", 128);
        a = Math.max(1, n10);
    }

    public static j A0(Iterable iterable, e.a.v0.o o10) {
        int n10 = j.f0();
        return j.B0(iterable, o10, n10);
    }

    public static j A8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, e.a.v0.k object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        object = Functions.B((e.a.v0.k)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j B0(Iterable iterable, e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableCombineLatest flowableCombineLatest = new FlowableCombineLatest(iterable, o10, n10, true);
        return e.a.a1.a.P(flowableCombineLatest);
    }

    public static j B6(i.g.c c10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).q6(o10);
    }

    public static j B8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, e.a.v0.l object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        object = Functions.C((e.a.v0.l)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j C0(i.g.c[] cArray, e.a.v0.o o10) {
        int n10 = j.f0();
        return j.D0(cArray, o10, n10);
    }

    public static j C3(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        l0 l02 = new l0(object);
        return e.a.a1.a.P(l02);
    }

    public static j C6(i.g.c c10, int n10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).r6(o10, n10);
    }

    public static j C8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, i.g.c c17, e.a.v0.m object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        e.a.w0.b.a.g(c17, "source8 is null");
        object = Functions.D((e.a.v0.m)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16, c17};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j D0(i.g.c[] cArray, e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(cArray, "sources is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        int n11 = cArray.length;
        if (n11 == 0) {
            return j.r2();
        }
        object = new FlowableCombineLatest(cArray, o10, n10, true);
        return e.a.a1.a.P((j)object);
    }

    public static j D1(e.a.m m10, BackpressureStrategy backpressureStrategy) {
        e.a.w0.b.a.g(m10, "source is null");
        e.a.w0.b.a.g((Object)backpressureStrategy, "mode is null");
        FlowableCreate flowableCreate = new FlowableCreate(m10, backpressureStrategy);
        return e.a.a1.a.P(flowableCreate);
    }

    public static j D3(Object object, Object object2) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        Object[] objectArray = new Object[]{object, object2};
        return j.Y2(objectArray);
    }

    public static j D6(i.g.c c10) {
        int n10 = j.f0();
        return j.E6(c10, n10);
    }

    public static j D8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, i.g.c c17, i.g.c c18, n object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        e.a.w0.b.a.g(c17, "source8 is null");
        e.a.w0.b.a.g(c18, "source9 is null");
        object = Functions.E((n)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16, c17, c18};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j E3(Object object, Object object2, Object object3) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        Object[] objectArray = new Object[]{object, object2, object3};
        return j.Y2(objectArray);
    }

    public static j E6(i.g.c c10, int n10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).w6(o10, n10);
    }

    public static j E8(e.a.v0.o o10, boolean bl2, int n10, i.g.c ... cArray) {
        int n11 = cArray.length;
        if (n11 == 0) {
            return j.r2();
        }
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableZip flowableZip = new FlowableZip(cArray, null, o10, n10, bl2);
        return e.a.a1.a.P(flowableZip);
    }

    public static j F0(Iterable object) {
        e.a.w0.b.a.g(object, "sources is null");
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).g1(o10, 2, false);
    }

    public static j F3(Object object, Object object2, Object object3, Object object4) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        return j.Y2(objectArray);
    }

    public static j F8(Iterable iterable, e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableZip flowableZip = new FlowableZip(null, iterable, o10, n10, bl2);
        return e.a.a1.a.P(flowableZip);
    }

    public static j G0(i.g.c c10) {
        int n10 = j.f0();
        return j.H0(c10, n10);
    }

    public static j G3(Object object, Object object2, Object object3, Object object4, Object object5) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5};
        return j.Y2(objectArray);
    }

    public static j H0(i.g.c c10, int n10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).Z0(o10, n10);
    }

    public static j H3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6};
        return j.Y2(objectArray);
    }

    public static j I0(i.g.c c10, i.g.c c11) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return j.L0(cArray);
    }

    public static j I1(Callable callable) {
        e.a.w0.b.a.g(callable, "supplier is null");
        p p10 = new p(callable);
        return e.a.a1.a.P(p10);
    }

    public static j I3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7};
        return j.Y2(objectArray);
    }

    public static j J0(i.g.c c10, i.g.c c11, i.g.c c12) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12};
        return j.L0(cArray);
    }

    public static j J3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        e.a.w0.b.a.g(object, "item1 is null");
        e.a.w0.b.a.g(object2, "item2 is null");
        e.a.w0.b.a.g(object3, "item3 is null");
        e.a.w0.b.a.g(object4, "item4 is null");
        e.a.w0.b.a.g(object5, "item5 is null");
        e.a.w0.b.a.g(object6, "item6 is null");
        e.a.w0.b.a.g(object7, "item7 is null");
        e.a.w0.b.a.g(object8, "item8 is null");
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8};
        return j.Y2(objectArray);
    }

    public static j K0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13};
        return j.L0(cArray);
    }

    public static j K3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
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
        return j.Y2(objectArray);
    }

    public static j L0(i.g.c ... cArray) {
        int n10 = cArray.length;
        if (n10 == 0) {
            return j.r2();
        }
        n10 = cArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return j.f3(cArray[0]);
        }
        FlowableConcatArray flowableConcatArray = new FlowableConcatArray(cArray, false);
        return e.a.a1.a.P(flowableConcatArray);
    }

    public static j L3(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
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
        return j.Y2(objectArray);
    }

    public static e.a.i0 L5(i.g.c c10, i.g.c c11) {
        e.a.v0.d d10 = e.a.w0.b.a.d();
        int n10 = j.f0();
        return j.O5(c10, c11, d10, n10);
    }

    public static j M0(i.g.c ... cArray) {
        boolean bl2 = cArray.length;
        if (!bl2) {
            return j.r2();
        }
        bl2 = cArray.length;
        boolean bl3 = true;
        if (bl2 == bl3) {
            return j.f3(cArray[0]);
        }
        FlowableConcatArray flowableConcatArray = new FlowableConcatArray(cArray, bl3);
        return e.a.a1.a.P(flowableConcatArray);
    }

    public static e.a.i0 M5(i.g.c c10, i.g.c c11, int n10) {
        e.a.v0.d d10 = e.a.w0.b.a.d();
        return j.O5(c10, c11, d10, n10);
    }

    public static j N0(int n10, int n11, i.g.c ... cArray) {
        e.a.w0.b.a.g(cArray, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        FlowableFromArray flowableFromArray = new FlowableFromArray(cArray);
        e.a.v0.o o10 = Functions.k();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapEager flowableConcatMapEager = new FlowableConcatMapEager(flowableFromArray, o10, n10, n11, errorMode);
        return e.a.a1.a.P(flowableConcatMapEager);
    }

    public static e.a.i0 N5(i.g.c c10, i.g.c c11, e.a.v0.d d10) {
        int n10 = j.f0();
        return j.O5(c10, c11, d10, n10);
    }

    public static j O0(i.g.c ... cArray) {
        int n10 = j.f0();
        int n11 = j.f0();
        return j.N0(n10, n11, cArray);
    }

    public static e.a.i0 O5(i.g.c c10, i.g.c c11, e.a.v0.d d10, int n10) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(d10, "isEqual is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableSequenceEqualSingle flowableSequenceEqualSingle = new FlowableSequenceEqualSingle(c10, c11, d10, n10);
        return e.a.a1.a.S(flowableSequenceEqualSingle);
    }

    public static j P0(int n10, int n11, i.g.c ... object) {
        object = j.Y2((Object[])object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).j1(o10, n10, n11, true);
    }

    public static j P7(i.g.c object) {
        Object object2 = "onSubscribe is null";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = object instanceof j;
        if (!bl2) {
            object2 = new e.a.w0.e.b.h0((i.g.c)object);
            return e.a.a1.a.P((j)object2);
        }
        object = new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        throw object;
    }

    public static j Q0(i.g.c ... cArray) {
        int n10 = j.f0();
        int n11 = j.f0();
        return j.P0(n10, n11, cArray);
    }

    public static j R0(Iterable object) {
        e.a.w0.b.a.g(object, "sources is null");
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).f1(o10);
    }

    public static j R7(Callable callable, e.a.v0.o o10, g g10) {
        return j.S7(callable, o10, g10, true);
    }

    public static j S0(i.g.c c10) {
        int n10 = j.f0();
        return j.T0(c10, n10, true);
    }

    public static j S7(Callable callable, e.a.v0.o o10, g g10, boolean bl2) {
        e.a.w0.b.a.g(callable, "resourceSupplier is null");
        e.a.w0.b.a.g(o10, "sourceSupplier is null");
        e.a.w0.b.a.g(g10, "resourceDisposer is null");
        FlowableUsing flowableUsing = new FlowableUsing(callable, o10, g10, bl2);
        return e.a.a1.a.P(flowableUsing);
    }

    public static j T0(i.g.c c10, int n10, boolean bl2) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).g1(o10, n10, bl2);
    }

    public static j T3(Iterable object) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).y2(o10);
    }

    public static j U0(Iterable iterable) {
        int n10 = j.f0();
        int n11 = j.f0();
        return j.V0(iterable, n10, n11);
    }

    public static j U3(Iterable object, int n10) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).z2(o10, n10);
    }

    public static j U4(int n10, int n11) {
        if (n11 >= 0) {
            if (n11 == 0) {
                return j.r2();
            }
            int n12 = 1;
            if (n11 == n12) {
                return j.C3(n10);
            }
            long l10 = n10;
            int n13 = n11 + -1;
            long l11 = n13;
            long l12 = (l10 += l11) - (l11 = Integer.MAX_VALUE);
            n12 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n12 <= 0) {
                FlowableRange flowableRange = new FlowableRange(n10, n11);
                return e.a.a1.a.P(flowableRange);
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

    public static j V0(Iterable iterable, int n10, int n11) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        FlowableFromIterable flowableFromIterable = new FlowableFromIterable(iterable);
        e.a.v0.o o10 = Functions.k();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapEager flowableConcatMapEager = new FlowableConcatMapEager(flowableFromIterable, o10, n10, n11, errorMode);
        return e.a.a1.a.P(flowableConcatMapEager);
    }

    public static j V3(Iterable object, int n10, int n11) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).J2(o10, false, n10, n11);
    }

    public static j V4(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            long l14;
            if (object == false) {
                return j.r2();
            }
            long l15 = 1L;
            long l16 = l11 - l15;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 == false) {
                return j.C3(l10);
            }
            l15 = l11 - l15 + l10;
            object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (object2 > 0 && (l14 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1)) < 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
                throw illegalArgumentException;
            }
            FlowableRangeLong flowableRangeLong = new FlowableRangeLong(l10, l11);
            return e.a.a1.a.P(flowableRangeLong);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("count >= 0 required but it was ");
        charSequence.append(l11);
        charSequence = charSequence.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public static j W0(i.g.c c10) {
        int n10 = j.f0();
        int n11 = j.f0();
        return j.X0(c10, n10, n11);
    }

    public static j W3(i.g.c c10) {
        int n10 = j.f0();
        return j.X3(c10, n10);
    }

    public static j X0(i.g.c c10, int n10, int n11) {
        e.a.w0.b.a.g(c10, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        e.a.v0.o o10 = Functions.k();
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        m m10 = new m(c10, o10, n10, n11, errorMode);
        return e.a.a1.a.P(m10);
    }

    public static j X3(i.g.c c10, int n10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).z2(o10, n10);
    }

    public static j Y2(Object ... objectArray) {
        Object object = "items is null";
        e.a.w0.b.a.g(objectArray, (String)object);
        int n10 = objectArray.length;
        if (n10 == 0) {
            return j.r2();
        }
        n10 = objectArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return j.C3(objectArray[0]);
        }
        object = new FlowableFromArray(objectArray);
        return e.a.a1.a.P((j)object);
    }

    public static j Y3(i.g.c c10, i.g.c object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        int n10 = 2;
        Object[] objectArray = new i.g.c[n10];
        objectArray[0] = c10;
        objectArray[1] = object;
        c10 = j.Y2(objectArray);
        object = Functions.k();
        return ((j)c10).I2((e.a.v0.o)object, false, n10);
    }

    public static j Z2(Callable callable) {
        e.a.w0.b.a.g(callable, "supplier is null");
        e0 e02 = new e0(callable);
        return e.a.a1.a.P(e02);
    }

    public static j Z3(i.g.c c10, i.g.c object, i.g.c c11) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        e.a.w0.b.a.g(c11, "source3 is null");
        int n10 = 3;
        Object[] objectArray = new i.g.c[n10];
        objectArray[0] = c10;
        objectArray[1] = object;
        objectArray[2] = c11;
        c10 = j.Y2(objectArray);
        object = Functions.k();
        return ((j)c10).I2((e.a.v0.o)object, false, n10);
    }

    public static j a3(Future future) {
        e.a.w0.b.a.g(future, "future is null");
        f0 f02 = new f0(future, 0L, null);
        return e.a.a1.a.P(f02);
    }

    public static j a4(i.g.c c10, i.g.c object, i.g.c c11, i.g.c c12) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(object, "source2 is null");
        e.a.w0.b.a.g(c11, "source3 is null");
        e.a.w0.b.a.g(c12, "source4 is null");
        int n10 = 4;
        Object[] objectArray = new i.g.c[n10];
        objectArray[0] = c10;
        objectArray[1] = object;
        objectArray[2] = c11;
        objectArray[3] = c12;
        c10 = j.Y2(objectArray);
        object = Functions.k();
        return ((j)c10).I2((e.a.v0.o)object, false, n10);
    }

    public static j b3(Future future, long l10, TimeUnit timeUnit) {
        e.a.w0.b.a.g(future, "future is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        f0 f02 = new f0(future, l10, timeUnit);
        return e.a.a1.a.P(f02);
    }

    public static j b4(int n10, int n11, i.g.c ... object) {
        object = j.Y2((Object[])object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).J2(o10, false, n10, n11);
    }

    public static j c3(Future future, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return j.b3(future, l10, timeUnit).n6(h02);
    }

    public static j c4(i.g.c ... cArray) {
        j j10 = j.Y2(cArray);
        e.a.v0.o o10 = Functions.k();
        int n10 = cArray.length;
        return j10.z2(o10, n10);
    }

    public static j d3(Future future, h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return j.a3(future).n6(h02);
    }

    public static j d4(int n10, int n11, i.g.c ... object) {
        object = j.Y2((Object[])object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).J2(o10, true, n10, n11);
    }

    public static j e3(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "source is null");
        FlowableFromIterable flowableFromIterable = new FlowableFromIterable(iterable);
        return e.a.a1.a.P(flowableFromIterable);
    }

    public static j e4(i.g.c ... cArray) {
        j j10 = j.Y2(cArray);
        e.a.v0.o o10 = Functions.k();
        int n10 = cArray.length;
        return j10.I2(o10, true, n10);
    }

    public static int f0() {
        return a;
    }

    public static j f3(i.g.c c10) {
        boolean bl2 = c10 instanceof j;
        if (bl2) {
            return e.a.a1.a.P((j)c10);
        }
        e.a.w0.b.a.g(c10, "source is null");
        e.a.w0.e.b.h0 h02 = new e.a.w0.e.b.h0(c10);
        return e.a.a1.a.P(h02);
    }

    public static j f4(Iterable object) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).H2(o10, true);
    }

    private j g2(g g10, g g11, a a10, a a11) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.w0.b.a.g(a11, "onAfterTerminate is null");
        w w10 = new w(this, g10, g11, a10, a11);
        return e.a.a1.a.P(w10);
    }

    public static j g3(g object) {
        e.a.w0.b.a.g(object, "generator is null");
        Callable callable = Functions.u();
        object = FlowableInternalHelper.j((g)object);
        g g10 = Functions.h();
        return j.k3(callable, (e.a.v0.c)object, g10);
    }

    public static j g4(Iterable object, int n10) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).I2(o10, true, n10);
    }

    public static j h3(Callable callable, e.a.v0.b object) {
        e.a.w0.b.a.g(object, "generator is null");
        object = FlowableInternalHelper.i((e.a.v0.b)object);
        g g10 = Functions.h();
        return j.k3(callable, (e.a.v0.c)object, g10);
    }

    public static j h4(Iterable object, int n10, int n11) {
        object = j.e3((Iterable)object);
        e.a.v0.o o10 = Functions.k();
        return ((j)object).J2(o10, true, n10, n11);
    }

    public static j i3(Callable callable, e.a.v0.b object, g g10) {
        e.a.w0.b.a.g(object, "generator is null");
        object = FlowableInternalHelper.i((e.a.v0.b)object);
        return j.k3(callable, (e.a.v0.c)object, g10);
    }

    public static j i4(i.g.c c10) {
        int n10 = j.f0();
        return j.j4(c10, n10);
    }

    public static j j3(Callable callable, e.a.v0.c c10) {
        g g10 = Functions.h();
        return j.k3(callable, c10, g10);
    }

    public static j j4(i.g.c c10, int n10) {
        c10 = j.f3(c10);
        e.a.v0.o o10 = Functions.k();
        return ((j)c10).I2(o10, true, n10);
    }

    public static j k3(Callable callable, e.a.v0.c c10, g g10) {
        e.a.w0.b.a.g(callable, "initialState is null");
        e.a.w0.b.a.g(c10, "generator is null");
        e.a.w0.b.a.g(g10, "disposeState is null");
        FlowableGenerate flowableGenerate = new FlowableGenerate(callable, c10, g10);
        return e.a.a1.a.P(flowableGenerate);
    }

    public static j k4(i.g.c c10, i.g.c c11) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        int n10 = 2;
        Object object = new i.g.c[n10];
        object[0] = c10;
        boolean bl2 = true;
        object[bl2] = c11;
        c11 = j.Y2(object);
        object = Functions.k();
        return ((j)c11).I2((e.a.v0.o)object, bl2, n10);
    }

    public static j l0(e.a.v0.o o10, i.g.c ... cArray) {
        int n10 = j.f0();
        return j.x0(cArray, o10, n10);
    }

    public static j l4(i.g.c c10, i.g.c c11, i.g.c object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(object, "source3 is null");
        int n10 = 3;
        Object[] objectArray = new i.g.c[n10];
        objectArray[0] = c10;
        boolean bl2 = true;
        objectArray[bl2] = c11;
        objectArray[2] = object;
        c11 = j.Y2(objectArray);
        object = Functions.k();
        return ((j)c11).I2((e.a.v0.o)object, bl2, n10);
    }

    public static j m0(Iterable iterable, e.a.v0.o o10) {
        int n10 = j.f0();
        return j.n0(iterable, o10, n10);
    }

    public static j m4(i.g.c c10, i.g.c c11, i.g.c object, i.g.c c12) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(object, "source3 is null");
        e.a.w0.b.a.g(c12, "source4 is null");
        int n10 = 4;
        Object[] objectArray = new i.g.c[n10];
        objectArray[0] = c10;
        boolean bl2 = true;
        objectArray[bl2] = c11;
        objectArray[2] = object;
        objectArray[3] = c12;
        c11 = j.Y2(objectArray);
        object = Functions.k();
        return ((j)c11).I2((e.a.v0.o)object, bl2, n10);
    }

    public static j n(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        FlowableAmb flowableAmb = new FlowableAmb(null, iterable);
        return e.a.a1.a.P(flowableAmb);
    }

    public static j n0(Iterable iterable, e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableCombineLatest flowableCombineLatest = new FlowableCombineLatest(iterable, o10, n10, false);
        return e.a.a1.a.P(flowableCombineLatest);
    }

    public static j o(i.g.c ... cArray) {
        Object object = "sources is null";
        e.a.w0.b.a.g(cArray, (String)object);
        int n10 = cArray.length;
        if (n10 == 0) {
            return j.r2();
        }
        int n11 = 1;
        if (n10 == n11) {
            return j.f3(cArray[0]);
        }
        object = new FlowableAmb(cArray, null);
        return e.a.a1.a.P((j)object);
    }

    public static j o0(i.g.c c10, i.g.c c11, e.a.v0.c object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        object = Functions.x((e.a.v0.c)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j p0(i.g.c c10, i.g.c c11, i.g.c c12, e.a.v0.h object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        object = Functions.y((e.a.v0.h)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j q0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, e.a.v0.i object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        object = Functions.z((e.a.v0.i)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13};
        return j.l0((e.a.v0.o)object, cArray);
    }

    private j q7(long l10, TimeUnit timeUnit, i.g.c c10, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "timeUnit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableTimeoutTimed flowableTimeoutTimed = new FlowableTimeoutTimed(this, l10, timeUnit, h02, c10);
        return e.a.a1.a.P(flowableTimeoutTimed);
    }

    public static j r0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, e.a.v0.j object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        object = Functions.A((e.a.v0.j)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j r2() {
        return e.a.a1.a.P(a0.b);
    }

    public static j r4() {
        return e.a.a1.a.P(r0.b);
    }

    private j r7(i.g.c c10, e.a.v0.o o10, i.g.c c11) {
        e.a.w0.b.a.g(o10, "itemTimeoutIndicator is null");
        FlowableTimeout flowableTimeout = new FlowableTimeout(this, c10, o10, c11);
        return e.a.a1.a.P(flowableTimeout);
    }

    public static j s0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, e.a.v0.k object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        object = Functions.B((e.a.v0.k)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j s2(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "throwable is null");
        return j.t2(Functions.m(throwable));
    }

    public static j s7(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return j.t7(l10, timeUnit, h02);
    }

    public static j s8(Iterable iterable, e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        e.a.w0.b.a.g(iterable, "sources is null");
        int n10 = j.f0();
        FlowableZip flowableZip = new FlowableZip(null, iterable, o10, n10, false);
        return e.a.a1.a.P(flowableZip);
    }

    public static j t0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, e.a.v0.l object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        object = Functions.C((e.a.v0.l)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j t2(Callable callable) {
        e.a.w0.b.a.g(callable, "supplier is null");
        b0 b02 = new b0(callable);
        return e.a.a1.a.P(b02);
    }

    public static j t7(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        l10 = Math.max(0L, l10);
        FlowableTimer flowableTimer = new FlowableTimer(l10, timeUnit, h02);
        return e.a.a1.a.P(flowableTimer);
    }

    public static j t8(i.g.c object, e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "zipper is null");
        object = j.f3((i.g.c)object).A7();
        o10 = FlowableInternalHelper.n(o10);
        return ((e.a.i0)object).l0(o10);
    }

    public static j u0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, i.g.c c17, e.a.v0.m object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        e.a.w0.b.a.g(c17, "source8 is null");
        object = Functions.D((e.a.v0.m)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16, c17};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j u3(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return j.v3(l10, l11, timeUnit, h02);
    }

    public static j u8(i.g.c c10, i.g.c c11, e.a.v0.c object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        object = Functions.x((e.a.v0.c)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j v0(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, i.g.c c15, i.g.c c16, i.g.c c17, i.g.c c18, n object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        e.a.w0.b.a.g(c15, "source6 is null");
        e.a.w0.b.a.g(c16, "source7 is null");
        e.a.w0.b.a.g(c17, "source8 is null");
        e.a.w0.b.a.g(c18, "source9 is null");
        object = Functions.E((n)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14, c15, c16, c17, c18};
        return j.l0((e.a.v0.o)object, cArray);
    }

    public static j v3(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        long l12 = 0L;
        l10 = Math.max(l12, l10);
        long l13 = Math.max(l12, l11);
        FlowableInterval flowableInterval = new FlowableInterval(l10, l13, timeUnit, h02);
        return e.a.a1.a.P(flowableInterval);
    }

    public static j v8(i.g.c c10, i.g.c c11, e.a.v0.c object, boolean bl2) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        object = Functions.x((e.a.v0.c)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return j.E8((e.a.v0.o)object, bl2, n10, cArray);
    }

    public static j w0(i.g.c[] cArray, e.a.v0.o o10) {
        int n10 = j.f0();
        return j.x0(cArray, o10, n10);
    }

    public static j w3(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return j.v3(l10, l10, timeUnit, h02);
    }

    public static j w8(i.g.c c10, i.g.c c11, e.a.v0.c object, boolean bl2, int n10) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        object = Functions.x((e.a.v0.c)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return j.E8((e.a.v0.o)object, bl2, n10, cArray);
    }

    public static j x0(i.g.c[] cArray, e.a.v0.o o10, int n10) {
        Object object = "sources is null";
        e.a.w0.b.a.g(cArray, (String)object);
        int n11 = cArray.length;
        if (n11 == 0) {
            return j.r2();
        }
        e.a.w0.b.a.g(o10, "combiner is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        object = new FlowableCombineLatest(cArray, o10, n10, false);
        return e.a.a1.a.P((j)object);
    }

    public static j x3(long l10, TimeUnit timeUnit, h0 h02) {
        return j.v3(l10, l10, timeUnit, h02);
    }

    public static j x8(i.g.c c10, i.g.c c11, i.g.c c12, e.a.v0.h object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        object = Functions.y((e.a.v0.h)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j y0(e.a.v0.o o10, int n10, i.g.c ... cArray) {
        return j.D0(cArray, o10, n10);
    }

    public static j y3(long l10, long l11, long l12, long l13, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return j.z3(l10, l11, l12, l13, timeUnit, h02);
    }

    public static j y8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, e.a.v0.i object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        object = Functions.z((e.a.v0.i)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public static j z0(e.a.v0.o o10, i.g.c ... cArray) {
        int n10 = j.f0();
        return j.D0(cArray, o10, n10);
    }

    public static j z3(long l10, long l11, long l12, long l13, TimeUnit timeUnit, h0 h02) {
        long l14 = l11;
        long l15 = l12;
        TimeUnit timeUnit2 = timeUnit;
        h0 h03 = h02;
        long l16 = 0L;
        long l17 = l11 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object >= 0) {
            FlowableIntervalRange flowableIntervalRange;
            if (object == false) {
                return j.r2().K1(l12, timeUnit, h02);
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
            FlowableIntervalRange flowableIntervalRange2 = flowableIntervalRange;
            timeUnit2 = timeUnit;
            h03 = h02;
            flowableIntervalRange = new FlowableIntervalRange(l10, l18, l19, l20, timeUnit, h02);
            return e.a.a1.a.P(flowableIntervalRange);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l11);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static j z8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, i.g.c c14, e.a.v0.j object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        e.a.w0.b.a.g(c14, "source5 is null");
        object = Functions.A((e.a.v0.j)object);
        int n10 = j.f0();
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13, c14};
        return j.E8((e.a.v0.o)object, false, n10, cArray);
    }

    public final Iterable A(Object object) {
        c c10 = new c(this, object);
        return c10;
    }

    public final j A1(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        return j.I0(this, c10);
    }

    public final j A2(e.a.v0.o o10, e.a.v0.c c10) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.E2(o10, c10, false, n10, n11);
    }

    public final e.a.i0 A3() {
        e.a.v0.r r10 = Functions.b();
        return this.e(r10);
    }

    public final j A4(int n10, boolean bl2, boolean bl3) {
        e.a.w0.b.a.h(n10, "capacity");
        a a10 = Functions.c;
        FlowableOnBackpressureBuffer flowableOnBackpressureBuffer = new FlowableOnBackpressureBuffer(this, n10, bl3, bl2, a10);
        return e.a.a1.a.P(flowableOnBackpressureBuffer);
    }

    public final j A5(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "handler is null");
        FlowableRetryWhen flowableRetryWhen = new FlowableRetryWhen(this, o10);
        return e.a.a1.a.P(flowableRetryWhen);
    }

    public final j A6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapSingle flowableSwitchMapSingle = new FlowableSwitchMapSingle(this, o10, true);
        return e.a.a1.a.P(flowableSwitchMapSingle);
    }

    public final e.a.i0 A7() {
        i1 i12 = new i1(this);
        return e.a.a1.a.S(i12);
    }

    public final Iterable B() {
        d d10 = new d(this);
        return d10;
    }

    public final e.a.i0 B1(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        object = Functions.i(object);
        return this.q((e.a.v0.r)object);
    }

    public final j B2(e.a.v0.o o10, e.a.v0.c c10, int n10) {
        int n11 = j.f0();
        return this.E2(o10, c10, false, n10, n11);
    }

    public final j B3(i.g.c c10, e.a.v0.o o10, e.a.v0.o o11, e.a.v0.c c11) {
        e.a.w0.b.a.g(c10, "other is null");
        e.a.w0.b.a.g(o10, "leftEnd is null");
        e.a.w0.b.a.g(o11, "rightEnd is null");
        e.a.w0.b.a.g(c11, "resultSelector is null");
        FlowableJoin flowableJoin = new FlowableJoin(this, c10, o10, o11, c11);
        return e.a.a1.a.P(flowableJoin);
    }

    public final j B4(int n10, boolean bl2, boolean bl3, a a10) {
        e.a.w0.b.a.g(a10, "onOverflow is null");
        e.a.w0.b.a.h(n10, "capacity");
        FlowableOnBackpressureBuffer flowableOnBackpressureBuffer = new FlowableOnBackpressureBuffer(this, n10, bl3, bl2, a10);
        return e.a.a1.a.P(flowableOnBackpressureBuffer);
    }

    public final void B5(i.g.d d10) {
        Object object = "s is null";
        e.a.w0.b.a.g(d10, (String)object);
        boolean bl2 = d10 instanceof e.a.e1.d;
        if (bl2) {
            d10 = (e.a.e1.d)d10;
            this.l6((e.a.o)d10);
        } else {
            object = new e.a.e1.d(d10);
            this.l6((e.a.o)object);
        }
    }

    public final e.a.i0 B7(int n10) {
        e.a.w0.b.a.h(n10, "capacityHint");
        Callable callable = Functions.f(n10);
        i1 i12 = new i1(this, callable);
        return e.a.a1.a.S(i12);
    }

    public final Object C() {
        return this.T5().p();
    }

    public final e.a.i0 C1() {
        o o10 = new o(this);
        return e.a.a1.a.S(o10);
    }

    public final j C2(e.a.v0.o o10, e.a.v0.c c10, boolean bl2) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.E2(o10, c10, bl2, n10, n11);
    }

    public final j C4(long l10, a a10, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        e.a.w0.b.a.g((Object)backpressureOverflowStrategy, "overflowStrategy is null");
        e.a.w0.b.a.i(l10, "capacity");
        FlowableOnBackpressureBufferStrategy flowableOnBackpressureBufferStrategy = new FlowableOnBackpressureBufferStrategy(this, l10, a10, backpressureOverflowStrategy);
        return e.a.a1.a.P(flowableOnBackpressureBufferStrategy);
    }

    public final j C5(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.D5(l10, timeUnit, h02);
    }

    public final e.a.i0 C7(Callable callable) {
        e.a.w0.b.a.g(callable, "collectionSupplier is null");
        i1 i12 = new i1(this, callable);
        return e.a.a1.a.S(i12);
    }

    public final Object D(Object object) {
        return this.R5(object).p();
    }

    public final j D2(e.a.v0.o o10, e.a.v0.c c10, boolean bl2, int n10) {
        int n11 = j.f0();
        return this.E2(o10, c10, bl2, n10, n11);
    }

    public final j D4(boolean bl2) {
        int n10 = j.f0();
        return this.A4(n10, bl2, true);
    }

    public final j D5(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableSampleTimed flowableSampleTimed = new FlowableSampleTimed(this, l10, timeUnit, h02, false);
        return e.a.a1.a.P(flowableSampleTimed);
    }

    public final e.a.i0 D7(e.a.v0.o object) {
        e.a.w0.b.a.g(object, "keySelector is null");
        Callable callable = HashMapSupplier.asCallable();
        object = Functions.F((e.a.v0.o)object);
        return this.j0(callable, (e.a.v0.b)object);
    }

    public final void E() {
        h.a(this);
    }

    public final j E0(e.a.p p10) {
        return j.f3(((e.a.p)e.a.w0.b.a.g(p10, "composer is null")).b(this));
    }

    public final j E1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.F1(l10, timeUnit, h02);
    }

    public final j E2(e.a.v0.o o10, e.a.v0.c c10, boolean bl2, int n10, int n11) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "combiner is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "bufferSize");
        o10 = FlowableInternalHelper.b(o10, c10);
        return this.J2(o10, bl2, n10, n11);
    }

    public final j E4() {
        FlowableOnBackpressureDrop flowableOnBackpressureDrop = new FlowableOnBackpressureDrop(this);
        return e.a.a1.a.P(flowableOnBackpressureDrop);
    }

    public final j E5(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableSampleTimed flowableSampleTimed = new FlowableSampleTimed(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.P(flowableSampleTimed);
    }

    public final e.a.i0 E7(e.a.v0.o object, e.a.v0.o o10) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        Callable callable = HashMapSupplier.asCallable();
        object = Functions.G((e.a.v0.o)object, o10);
        return this.j0(callable, (e.a.v0.b)object);
    }

    public final void F(g g10) {
        g g11 = Functions.f;
        a a10 = Functions.c;
        h.b(this, g10, g11, a10);
    }

    public final j F1(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableDebounceTimed flowableDebounceTimed = new FlowableDebounceTimed(this, l10, timeUnit, h02);
        return e.a.a1.a.P(flowableDebounceTimed);
    }

    public final j F2(e.a.v0.o o10, e.a.v0.o o11, Callable callable) {
        e.a.w0.b.a.g(o10, "onNextMapper is null");
        e.a.w0.b.a.g(o11, "onErrorMapper is null");
        e.a.w0.b.a.g(callable, "onCompleteSupplier is null");
        FlowableMapNotification flowableMapNotification = new FlowableMapNotification(this, o10, o11, callable);
        return j.W3(flowableMapNotification);
    }

    public final j F4(g g10) {
        e.a.w0.b.a.g(g10, "onDrop is null");
        FlowableOnBackpressureDrop flowableOnBackpressureDrop = new FlowableOnBackpressureDrop(this, g10);
        return e.a.a1.a.P(flowableOnBackpressureDrop);
    }

    public final j F5(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.E5(l10, timeUnit, h02, bl2);
    }

    public final j F6(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            FlowableTake flowableTake = new FlowableTake(this, l10);
            return e.a.a1.a.P(flowableTake);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final e.a.i0 F7(e.a.v0.o object, e.a.v0.o o10, Callable callable) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        object = Functions.G((e.a.v0.o)object, o10);
        return this.j0(callable, (e.a.v0.b)object);
    }

    public final void G(g g10, int n10) {
        g g11 = Functions.f;
        a a10 = Functions.c;
        h.c(this, g10, g11, a10, n10);
    }

    public final j G1(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "debounceIndicator is null");
        FlowableDebounce flowableDebounce = new FlowableDebounce(this, o10);
        return e.a.a1.a.P(flowableDebounce);
    }

    public final j G2(e.a.v0.o o10, e.a.v0.o o11, Callable callable, int n10) {
        e.a.w0.b.a.g(o10, "onNextMapper is null");
        e.a.w0.b.a.g(o11, "onErrorMapper is null");
        e.a.w0.b.a.g(callable, "onCompleteSupplier is null");
        FlowableMapNotification flowableMapNotification = new FlowableMapNotification(this, o10, o11, callable);
        return j.X3(flowableMapNotification, n10);
    }

    public final j G4() {
        FlowableOnBackpressureLatest flowableOnBackpressureLatest = new FlowableOnBackpressureLatest(this);
        return e.a.a1.a.P(flowableOnBackpressureLatest);
    }

    public final j G5(i.g.c c10) {
        e.a.w0.b.a.g(c10, "sampler is null");
        FlowableSamplePublisher flowableSamplePublisher = new FlowableSamplePublisher(this, c10, false);
        return e.a.a1.a.P(flowableSamplePublisher);
    }

    public final j G6(long l10, TimeUnit timeUnit) {
        j j10 = j.s7(l10, timeUnit);
        return this.S6(j10);
    }

    public final e.a.i0 G7(e.a.v0.o o10) {
        e.a.v0.o o11 = Functions.k();
        Callable callable = HashMapSupplier.asCallable();
        e.a.v0.o o12 = ArrayListSupplier.asFunction();
        return this.J7(o10, o11, callable, o12);
    }

    public final j G8(Iterable iterable, e.a.v0.c c10) {
        e.a.w0.b.a.g(iterable, "other is null");
        e.a.w0.b.a.g(c10, "zipper is null");
        l1 l12 = new l1(this, iterable, c10);
        return e.a.a1.a.P(l12);
    }

    public final void H(g g10, g g11) {
        a a10 = Functions.c;
        h.b(this, g10, g11, a10);
    }

    public final j H1(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        object = j.C3(object);
        return this.p6((i.g.c)object);
    }

    public final j H2(e.a.v0.o o10, boolean bl2) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.J2(o10, bl2, n10, n11);
    }

    public final j H4(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "resumeFunction is null");
        FlowableOnErrorNext flowableOnErrorNext = new FlowableOnErrorNext(this, o10, false);
        return e.a.a1.a.P(flowableOnErrorNext);
    }

    public final j H5(i.g.c c10, boolean bl2) {
        e.a.w0.b.a.g(c10, "sampler is null");
        FlowableSamplePublisher flowableSamplePublisher = new FlowableSamplePublisher(this, c10, bl2);
        return e.a.a1.a.P(flowableSamplePublisher);
    }

    public final j H6(long l10, TimeUnit timeUnit, h0 h02) {
        j j10 = j.t7(l10, timeUnit, h02);
        return this.S6(j10);
    }

    public final e.a.i0 H7(e.a.v0.o o10, e.a.v0.o o11) {
        Callable callable = HashMapSupplier.asCallable();
        e.a.v0.o o12 = ArrayListSupplier.asFunction();
        return this.J7(o10, o11, callable, o12);
    }

    public final j H8(i.g.c c10, e.a.v0.c c11) {
        e.a.w0.b.a.g(c10, "other is null");
        return j.u8(this, c10, c11);
    }

    public final void I(g g10, g g11, int n10) {
        a a10 = Functions.c;
        h.c(this, g10, g11, a10, n10);
    }

    public final j I2(e.a.v0.o o10, boolean bl2, int n10) {
        int n11 = j.f0();
        return this.J2(o10, bl2, n10, n11);
    }

    public final j I4(i.g.c object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        return this.H4((e.a.v0.o)object);
    }

    public final j I5(e.a.v0.c c10) {
        e.a.w0.b.a.g(c10, "accumulator is null");
        x0 x02 = new x0(this, c10);
        return e.a.a1.a.P(x02);
    }

    public final j I6(int n10) {
        if (n10 >= 0) {
            if (n10 == 0) {
                j0 j02 = new j0(this);
                return e.a.a1.a.P(j02);
            }
            int n11 = 1;
            if (n10 == n11) {
                FlowableTakeLastOne flowableTakeLastOne = new FlowableTakeLastOne(this);
                return e.a.a1.a.P(flowableTakeLastOne);
            }
            FlowableTakeLast flowableTakeLast = new FlowableTakeLast(this, n10);
            return e.a.a1.a.P(flowableTakeLast);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final e.a.i0 I7(e.a.v0.o o10, e.a.v0.o o11, Callable callable) {
        e.a.v0.o o12 = ArrayListSupplier.asFunction();
        return this.J7(o10, o11, callable, o12);
    }

    public final j I8(i.g.c c10, e.a.v0.c c11, boolean bl2) {
        return j.v8(this, c10, c11, bl2);
    }

    public final void J(g g10, g g11, a a10) {
        h.b(this, g10, g11, a10);
    }

    public final j J1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.L1(l10, timeUnit, h02, false);
    }

    public final j J2(e.a.v0.o o10, boolean bl2, int n10, int n11) {
        FlowableFlatMap flowableFlatMap;
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n11, (String)object);
        boolean bl3 = this instanceof e.a.w0.c.m;
        if (bl3) {
            Object object2 = this;
            object2 = ((e.a.w0.c.m)((Object)this)).call();
            if (object2 == null) {
                return j.r2();
            }
            return w0.a(object2, o10);
        }
        object = flowableFlatMap;
        flowableFlatMap = new FlowableFlatMap(this, o10, bl2, n10, n11);
        return e.a.a1.a.P(flowableFlatMap);
    }

    public final j J4(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "valueSupplier is null");
        FlowableOnErrorReturn flowableOnErrorReturn = new FlowableOnErrorReturn(this, o10);
        return e.a.a1.a.P(flowableOnErrorReturn);
    }

    public final j J5(Object object, e.a.v0.c c10) {
        e.a.w0.b.a.g(object, "initialValue is null");
        object = Functions.m(object);
        return this.K5((Callable)object, c10);
    }

    public final j J6(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.L6(l10, l11, timeUnit, h02, false, n10);
    }

    public final e.a.i0 J7(e.a.v0.o object, e.a.v0.o o10, Callable callable, e.a.v0.o o11) {
        e.a.w0.b.a.g(object, "keySelector is null");
        e.a.w0.b.a.g(o10, "valueSelector is null");
        e.a.w0.b.a.g(callable, "mapSupplier is null");
        e.a.w0.b.a.g(o11, "collectionFactory is null");
        object = Functions.H((e.a.v0.o)object, o10, o11);
        return this.j0(callable, (e.a.v0.b)object);
    }

    public final j J8(i.g.c c10, e.a.v0.c c11, boolean bl2, int n10) {
        return j.w8(this, c10, c11, bl2, n10);
    }

    public final void K(g g10, g g11, a a10, int n10) {
        h.c(this, g10, g11, a10, n10);
    }

    public final j K1(long l10, TimeUnit timeUnit, h0 h02) {
        return this.L1(l10, timeUnit, h02, false);
    }

    public final e.a.a K2(e.a.v0.o o10) {
        return this.L2(o10, false, -1 >>> 1);
    }

    public final j K4(Object object) {
        e.a.w0.b.a.g(object, "item is null");
        object = Functions.n(object);
        return this.J4((e.a.v0.o)object);
    }

    public final j K5(Callable callable, e.a.v0.c c10) {
        e.a.w0.b.a.g(callable, "seedSupplier is null");
        e.a.w0.b.a.g(c10, "accumulator is null");
        FlowableScanSeed flowableScanSeed = new FlowableScanSeed(this, callable, c10);
        return e.a.a1.a.P(flowableScanSeed);
    }

    public final j K6(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        int n10 = j.f0();
        return this.L6(l10, l11, timeUnit, h02, false, n10);
    }

    public final e.a.z K7() {
        n0 n02 = new n0(this);
        return e.a.a1.a.R(n02);
    }

    public final void L(i.g.d d10) {
        h.d(this, d10);
    }

    public final j L1(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        long l11 = Math.max(0L, l10);
        q q10 = new q(this, l11, timeUnit, h02, bl2);
        return e.a.a1.a.P(q10);
    }

    public final e.a.a L2(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        FlowableFlatMapCompletableCompletable flowableFlatMapCompletableCompletable = new FlowableFlatMapCompletableCompletable(this, o10, bl2, n10);
        return e.a.a1.a.O(flowableFlatMapCompletableCompletable);
    }

    public final j L4(i.g.c object) {
        e.a.w0.b.a.g(object, "next is null");
        object = Functions.n(object);
        FlowableOnErrorNext flowableOnErrorNext = new FlowableOnErrorNext(this, (e.a.v0.o)object, true);
        return e.a.a1.a.P(flowableOnErrorNext);
    }

    public final j L6(long l10, long l11, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        long l12 = 0L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (l13 >= 0) {
            FlowableTakeLastTimed flowableTakeLastTimed;
            object = flowableTakeLastTimed;
            j j10 = this;
            flowableTakeLastTimed = new FlowableTakeLastTimed(this, l10, l11, timeUnit, h02, n10, bl2);
            return e.a.a1.a.P(flowableTakeLastTimed);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("count >= 0 required but it was ");
        charSequence.append(l10);
        charSequence = charSequence.toString();
        object = new IndexOutOfBoundsException((String)charSequence);
        throw object;
    }

    public final e.a.i0 L7() {
        Comparator comparator = Functions.p();
        return this.N7(comparator);
    }

    public final j M(int n10) {
        return this.N(n10, n10);
    }

    public final j M1(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.L1(l10, timeUnit, h02, bl2);
    }

    public final j M2(e.a.v0.o o10) {
        int n10 = j.f0();
        return this.N2(o10, n10);
    }

    public final e.a.i0 M3(Object object) {
        e.a.w0.b.a.g(object, "defaultItem");
        e.a.w0.e.b.n0 n02 = new e.a.w0.e.b.n0(this, object);
        return e.a.a1.a.S(n02);
    }

    public final j M4() {
        s s10 = new s(this);
        return e.a.a1.a.P(s10);
    }

    public final j M6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.P6(l10, timeUnit, h02, false, n10);
    }

    public final e.a.i0 M7(int n10) {
        Comparator comparator = Functions.p();
        return this.O7(comparator, n10);
    }

    public final j N(int n10, int n11) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.O(n10, n11, callable);
    }

    public final j N1(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "itemDelayIndicator is null");
        o10 = FlowableInternalHelper.c(o10);
        return this.y2(o10);
    }

    public final j N2(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableFlattenIterable flowableFlattenIterable = new FlowableFlattenIterable(this, o10, n10);
        return e.a.a1.a.P(flowableFlattenIterable);
    }

    public final e.a.q N3() {
        m0 m02 = new m0(this);
        return e.a.a1.a.Q(m02);
    }

    public final e.a.z0.a N4() {
        return e.a.z0.a.z(this);
    }

    public final j N6(long l10, TimeUnit timeUnit, h0 h02) {
        int n10 = j.f0();
        return this.P6(l10, timeUnit, h02, false, n10);
    }

    public final e.a.i0 N7(Comparator object) {
        e.a.w0.b.a.g(object, "comparator is null");
        e.a.i0 i02 = this.A7();
        object = Functions.o((Comparator)object);
        return i02.z0((e.a.v0.o)object);
    }

    public final j O(int n10, int n11, Callable callable) {
        e.a.w0.b.a.h(n10, "count");
        e.a.w0.b.a.h(n11, "skip");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        FlowableBuffer flowableBuffer = new FlowableBuffer(this, n10, n11, callable);
        return e.a.a1.a.P(flowableBuffer);
    }

    public final j O1(i.g.c c10, e.a.v0.o o10) {
        return this.R1(c10).N1(o10);
    }

    public final j O2(e.a.v0.o o10, e.a.v0.c c10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        e.a.v0.o o11 = FlowableInternalHelper.a(o10);
        int n10 = j.f0();
        int n11 = j.f0();
        return this.E2(o11, c10, false, n10, n11);
    }

    public final e.a.i0 O3() {
        e.a.w0.e.b.n0 n02 = new e.a.w0.e.b.n0(this, null);
        return e.a.a1.a.S(n02);
    }

    public final e.a.z0.a O4(int n10) {
        e.a.w0.b.a.h(n10, "parallelism");
        return e.a.z0.a.A(this, n10);
    }

    public final j O6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        int n10 = j.f0();
        return this.P6(l10, timeUnit, h02, bl2, n10);
    }

    public final e.a.i0 O7(Comparator object, int n10) {
        e.a.w0.b.a.g(object, "comparator is null");
        e.a.i0 i02 = this.B7(n10);
        object = Functions.o((Comparator)object);
        return i02.z0((e.a.v0.o)object);
    }

    public final j P(int n10, Callable callable) {
        return this.O(n10, n10, callable);
    }

    public final j P1(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.Q1(l10, timeUnit, h02);
    }

    public final j P2(e.a.v0.o o10, e.a.v0.c c10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.g(c10, "resultSelector is null");
        e.a.v0.o o11 = FlowableInternalHelper.a(o10);
        int n11 = j.f0();
        return this.E2(o11, c10, false, n11, n10);
    }

    public final j P3(e.a.n n10) {
        e.a.w0.b.a.g(n10, "lifter is null");
        e.a.w0.e.b.o0 o02 = new e.a.w0.e.b.o0(this, n10);
        return e.a.a1.a.P(o02);
    }

    public final e.a.z0.a P4(int n10, int n11) {
        e.a.w0.b.a.h(n10, "parallelism");
        e.a.w0.b.a.h(n11, "prefetch");
        return e.a.z0.a.B(this, n10, n11);
    }

    public final j P5() {
        y0 y02 = new y0(this);
        return e.a.a1.a.P(y02);
    }

    public final j P6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        return this.L6(Long.MAX_VALUE, l10, timeUnit, h02, bl2, n10);
    }

    public final j Q(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        Callable callable = ArrayListSupplier.asCallable();
        return this.S(l10, l11, timeUnit, h02, callable);
    }

    public final j Q1(long l10, TimeUnit timeUnit, h0 h02) {
        j j10 = j.t7(l10, timeUnit, h02);
        return this.R1(j10);
    }

    public final j Q2(e.a.v0.o o10) {
        return this.R2(o10, false, -1 >>> 1);
    }

    public final j Q3(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            FlowableLimit flowableLimit = new FlowableLimit(this, l10);
            return e.a.a1.a.P(flowableLimit);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final j Q4(e.a.v0.o o10) {
        int n10 = j.f0();
        return this.R4(o10, n10);
    }

    public final j Q5() {
        return this.S4().Q8();
    }

    public final j Q6(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.P6(l10, timeUnit, h02, bl2, n10);
    }

    public final j Q7(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableUnsubscribeOn flowableUnsubscribeOn = new FlowableUnsubscribeOn(this, h02);
        return e.a.a1.a.P(flowableUnsubscribeOn);
    }

    public final j R(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.S(l10, l11, timeUnit, h02, callable);
    }

    public final j R1(i.g.c c10) {
        e.a.w0.b.a.g(c10, "subscriptionIndicator is null");
        FlowableDelaySubscriptionOther flowableDelaySubscriptionOther = new FlowableDelaySubscriptionOther(this, c10);
        return e.a.a1.a.P(flowableDelaySubscriptionOther);
    }

    public final j R2(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        FlowableFlatMapMaybe flowableFlatMapMaybe = new FlowableFlatMapMaybe(this, o10, bl2, n10);
        return e.a.a1.a.P(flowableFlatMapMaybe);
    }

    public final j R3(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        p0 p02 = new p0(this, o10);
        return e.a.a1.a.P(p02);
    }

    public final j R4(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.h(n10, "prefetch");
        FlowablePublishMulticast flowablePublishMulticast = new FlowablePublishMulticast(this, o10, n10, false);
        return e.a.a1.a.P(flowablePublishMulticast);
    }

    public final e.a.i0 R5(Object object) {
        e.a.w0.b.a.g(object, "defaultItem is null");
        a1 a12 = new a1(this, object);
        return e.a.a1.a.S(a12);
    }

    public final j R6(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "stopPredicate is null");
        f1 f12 = new f1(this, r10);
        return e.a.a1.a.P(f12);
    }

    public final j S(long l10, long l11, TimeUnit timeUnit, h0 h02, Callable callable) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        k k10 = new k(this, l10, l11, timeUnit, h02, callable, -1 >>> 1, false);
        return e.a.a1.a.P(k10);
    }

    public final j S1() {
        e.a.v0.o o10 = Functions.k();
        r r10 = new r(this, o10);
        return e.a.a1.a.P(r10);
    }

    public final j S2(e.a.v0.o o10) {
        return this.T2(o10, false, -1 >>> 1);
    }

    public final j S3() {
        FlowableMaterialize flowableMaterialize = new FlowableMaterialize(this);
        return e.a.a1.a.P(flowableMaterialize);
    }

    public final e.a.u0.a S4() {
        int n10 = j.f0();
        return this.T4(n10);
    }

    public final e.a.q S5() {
        z0 z02 = new z0(this);
        return e.a.a1.a.Q(z02);
    }

    public final j S6(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        FlowableTakeUntil flowableTakeUntil = new FlowableTakeUntil(this, c10);
        return e.a.a1.a.P(flowableTakeUntil);
    }

    public final j T(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.W(l10, timeUnit, h02, -1 >>> 1);
    }

    public final j T1(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        r r10 = new r(this, o10);
        return e.a.a1.a.P(r10);
    }

    public final j T2(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        FlowableFlatMapSingle flowableFlatMapSingle = new FlowableFlatMapSingle(this, o10, bl2, n10);
        return e.a.a1.a.P(flowableFlatMapSingle);
    }

    public final e.a.u0.a T4(int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        return FlowablePublish.W8(this, n10);
    }

    public final e.a.i0 T5() {
        a1 a12 = new a1(this, null);
        return e.a.a1.a.S(a12);
    }

    public final j T6(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        g1 g12 = new g1(this, r10);
        return e.a.a1.a.P(g12);
    }

    public final j T7(long l10) {
        int n10 = j.f0();
        return this.V7(l10, l10, n10);
    }

    public final j U(long l10, TimeUnit timeUnit, int n10) {
        h0 h02 = e.a.c1.b.a();
        return this.W(l10, timeUnit, h02, n10);
    }

    public final j U1() {
        e.a.v0.o o10 = Functions.k();
        Callable callable = Functions.g();
        return this.W1(o10, callable);
    }

    public final e.a.s0.b U2(g g10) {
        return this.d(g10);
    }

    public final j U5(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return e.a.a1.a.P(this);
        }
        b1 b12 = new b1(this, l10);
        return e.a.a1.a.P(b12);
    }

    public final j U6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.V6(l10, timeUnit, h02);
    }

    public final j U7(long l10, long l11) {
        int n10 = j.f0();
        return this.V7(l10, l11, n10);
    }

    public final j V(long l10, TimeUnit timeUnit, h0 h02) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.X(l10, timeUnit, h02, -1 >>> 1, callable, false);
    }

    public final j V1(e.a.v0.o o10) {
        Callable callable = Functions.g();
        return this.W1(o10, callable);
    }

    public final e.a.s0.b V2(e.a.v0.r r10) {
        g g10 = Functions.f;
        a a10 = Functions.c;
        return this.X2(r10, g10, a10);
    }

    public final j V5(long l10, TimeUnit timeUnit) {
        j j10 = j.s7(l10, timeUnit);
        return this.d6(j10);
    }

    public final j V6(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableThrottleFirstTimed flowableThrottleFirstTimed = new FlowableThrottleFirstTimed(this, l10, timeUnit, h02);
        return e.a.a1.a.P(flowableThrottleFirstTimed);
    }

    public final j V7(long l10, long l11, int n10) {
        e.a.w0.b.a.i(l11, "skip");
        e.a.w0.b.a.i(l10, "count");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableWindow flowableWindow = new FlowableWindow(this, l10, l11, n10);
        return e.a.a1.a.P(flowableWindow);
    }

    public final j W(long l10, TimeUnit timeUnit, h0 h02, int n10) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.X(l10, timeUnit, h02, n10, callable, false);
    }

    public final j W1(e.a.v0.o o10, Callable callable) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.w0.b.a.g(callable, "collectionSupplier is null");
        t t10 = new t(this, o10, callable);
        return e.a.a1.a.P(t10);
    }

    public final e.a.s0.b W2(e.a.v0.r r10, g g10) {
        a a10 = Functions.c;
        return this.X2(r10, g10, a10);
    }

    public final j W4(int n10) {
        h0 h02 = e.a.w0.g.c.b;
        return this.u4(h02, true, n10);
    }

    public final j W5(long l10, TimeUnit timeUnit, h0 h02) {
        j j10 = j.t7(l10, timeUnit, h02);
        return this.d6(j10);
    }

    public final j W6(long l10, TimeUnit timeUnit) {
        return this.C5(l10, timeUnit);
    }

    public final j W7(long l10, long l11, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.Y7(l10, l11, timeUnit, h02, n10);
    }

    public final j X(long l10, TimeUnit timeUnit, h0 h02, int n10, Callable callable, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        e.a.w0.b.a.h(n10, "count");
        k k10 = new k(this, l10, l10, timeUnit, h02, callable, n10, bl2);
        return e.a.a1.a.P(k10);
    }

    public final j X1() {
        e.a.v0.o o10 = Functions.k();
        return this.Z1(o10);
    }

    public final e.a.s0.b X2(e.a.v0.r r10, g g10, a a10) {
        e.a.w0.b.a.g(r10, "onNext is null");
        e.a.w0.b.a.g(g10, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(r10, g10, a10);
        this.l6(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    public final e.a.q X4(e.a.v0.c c10) {
        e.a.w0.b.a.g(c10, "reducer is null");
        t0 t02 = new t0(this, c10);
        return e.a.a1.a.Q(t02);
    }

    public final j X5(int n10) {
        if (n10 >= 0) {
            if (n10 == 0) {
                return e.a.a1.a.P(this);
            }
            FlowableSkipLast flowableSkipLast = new FlowableSkipLast(this, n10);
            return e.a.a1.a.P(flowableSkipLast);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("count >= 0 required but it was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final j X6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.D5(l10, timeUnit, h02);
    }

    public final j X7(long l10, long l11, TimeUnit timeUnit, h0 h02) {
        int n10 = j.f0();
        return this.Y7(l10, l11, timeUnit, h02, n10);
    }

    public final j Y(j j10, e.a.v0.o o10) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.Z(j10, o10, callable);
    }

    public final j Y0(e.a.v0.o o10) {
        return this.Z0(o10, 2);
    }

    public final j Y1(e.a.v0.d d10) {
        e.a.w0.b.a.g(d10, "comparer is null");
        e.a.v0.o o10 = Functions.k();
        u u10 = new u(this, o10, d10);
        return e.a.a1.a.P(u10);
    }

    public final e.a.i0 Y4(Object object, e.a.v0.c c10) {
        e.a.w0.b.a.g(object, "seed is null");
        e.a.w0.b.a.g(c10, "reducer is null");
        u0 u02 = new u0(this, object, c10);
        return e.a.a1.a.S(u02);
    }

    public final j Y5(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.b6(l10, timeUnit, h02, false, n10);
    }

    public final j Y6(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.a7(l10, timeUnit, h02, false);
    }

    public final j Y7(long l10, long l11, TimeUnit timeUnit, h0 h02, int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.i(l10, "timespan");
        e.a.w0.b.a.i(l11, "timeskip");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        k1 k12 = new k1(this, l10, l11, timeUnit, h02, Long.MAX_VALUE, n10, false);
        return e.a.a1.a.P(k12);
    }

    public final j Z(j j10, e.a.v0.o o10, Callable callable) {
        e.a.w0.b.a.g(j10, "openingIndicator is null");
        e.a.w0.b.a.g(o10, "closingIndicator is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        FlowableBufferBoundary flowableBufferBoundary = new FlowableBufferBoundary(this, j10, o10, callable);
        return e.a.a1.a.P(flowableBufferBoundary);
    }

    public final j Z0(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "prefetch";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl2 = this instanceof e.a.w0.c.m;
        if (bl2) {
            Object object2 = this;
            object2 = ((e.a.w0.c.m)((Object)this)).call();
            if (object2 == null) {
                return j.r2();
            }
            return w0.a(object2, o10);
        }
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        object = new FlowableConcatMap(this, o10, n10, errorMode);
        return e.a.a1.a.P((j)object);
    }

    public final j Z1(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.v0.d d10 = e.a.w0.b.a.d();
        u u10 = new u(this, o10, d10);
        return e.a.a1.a.P(u10);
    }

    public final e.a.i0 Z4(Callable callable, e.a.v0.c c10) {
        e.a.w0.b.a.g(callable, "seedSupplier is null");
        e.a.w0.b.a.g(c10, "reducer is null");
        v0 v02 = new v0(this, callable, c10);
        return e.a.a1.a.S(v02);
    }

    public final j Z5(long l10, TimeUnit timeUnit, h0 h02) {
        int n10 = j.f0();
        return this.b6(l10, timeUnit, h02, false, n10);
    }

    public final j Z6(long l10, TimeUnit timeUnit, h0 h02) {
        return this.a7(l10, timeUnit, h02, false);
    }

    public final j Z7(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.e8(l10, timeUnit, h02, Long.MAX_VALUE, false);
    }

    public final e.a.s0.b a() {
        g g10 = Functions.h();
        g g11 = Functions.f;
        a a10 = Functions.c;
        FlowableInternalHelper$RequestMax flowableInternalHelper$RequestMax = FlowableInternalHelper$RequestMax.INSTANCE;
        return this.h(g10, g11, a10, flowableInternalHelper$RequestMax);
    }

    public final j a0(Callable callable) {
        Callable callable2 = ArrayListSupplier.asCallable();
        return this.b0(callable, callable2);
    }

    public final e.a.a a1(e.a.v0.o o10) {
        return this.b1(o10, 2);
    }

    public final j a2(g g10) {
        e.a.w0.b.a.g(g10, "onAfterNext is null");
        v v10 = new v(this, g10);
        return e.a.a1.a.P(v10);
    }

    public final j a5() {
        return this.b5(Long.MAX_VALUE);
    }

    public final j a6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        int n10 = j.f0();
        return this.b6(l10, timeUnit, h02, bl2, n10);
    }

    public final j a7(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableThrottleLatest flowableThrottleLatest = new FlowableThrottleLatest(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.P(flowableThrottleLatest);
    }

    public final j a8(long l10, TimeUnit timeUnit, long l11) {
        h0 h02 = e.a.c1.b.a();
        return this.e8(l10, timeUnit, h02, l11, false);
    }

    public final TestSubscriber b() {
        TestSubscriber testSubscriber = new TestSubscriber();
        this.l6(testSubscriber);
        return testSubscriber;
    }

    public final j b0(Callable callable, Callable callable2) {
        e.a.w0.b.a.g(callable, "boundaryIndicatorSupplier is null");
        e.a.w0.b.a.g(callable2, "bufferSupplier is null");
        i i10 = new i(this, callable, callable2);
        return e.a.a1.a.P(i10);
    }

    public final e.a.a b1(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapCompletable flowableConcatMapCompletable = new FlowableConcatMapCompletable(this, o10, errorMode, n10);
        return e.a.a1.a.O(flowableConcatMapCompletable);
    }

    public final j b2(a a10) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        a a11 = Functions.c;
        return this.g2(g10, g11, a11, a10);
    }

    public final j b5(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            if (object == false) {
                return j.r2();
            }
            FlowableRepeat flowableRepeat = new FlowableRepeat(this, l10);
            return e.a.a1.a.P(flowableRepeat);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final j b6(long l10, TimeUnit timeUnit, h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        int n11 = n10 << 1;
        FlowableSkipLastTimed flowableSkipLastTimed = new FlowableSkipLastTimed(this, l10, timeUnit, h02, n11, bl2);
        return e.a.a1.a.P(flowableSkipLastTimed);
    }

    public final j b7(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.a7(l10, timeUnit, h02, bl2);
    }

    public final j b8(long l10, TimeUnit timeUnit, long l11, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        return this.e8(l10, timeUnit, h02, l11, bl2);
    }

    public final e.a.s0.b c(g g10, g g11) {
        a a10 = Functions.c;
        FlowableInternalHelper$RequestMax flowableInternalHelper$RequestMax = FlowableInternalHelper$RequestMax.INSTANCE;
        return this.h(g10, g11, a10, flowableInternalHelper$RequestMax);
    }

    public final j c0(i.g.c c10) {
        Callable callable = ArrayListSupplier.asCallable();
        return this.e0(c10, callable);
    }

    public final e.a.a c1(e.a.v0.o o10) {
        return this.e1(o10, true, 2);
    }

    public final j c2(a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        FlowableDoFinally flowableDoFinally = new FlowableDoFinally(this, a10);
        return e.a.a1.a.P(flowableDoFinally);
    }

    public final j c5(e.a.v0.e e10) {
        e.a.w0.b.a.g(e10, "stop is null");
        FlowableRepeatUntil flowableRepeatUntil = new FlowableRepeatUntil(this, e10);
        return e.a.a1.a.P(flowableRepeatUntil);
    }

    public final j c6(long l10, TimeUnit timeUnit, boolean bl2) {
        h0 h02 = e.a.c1.b.a();
        int n10 = j.f0();
        return this.b6(l10, timeUnit, h02, bl2, n10);
    }

    public final j c7(long l10, TimeUnit timeUnit) {
        return this.E1(l10, timeUnit);
    }

    public final j c8(long l10, TimeUnit timeUnit, h0 h02) {
        return this.e8(l10, timeUnit, h02, Long.MAX_VALUE, false);
    }

    public final e.a.s0.b d(g g10) {
        g g11 = Functions.f;
        a a10 = Functions.c;
        FlowableInternalHelper$RequestMax flowableInternalHelper$RequestMax = FlowableInternalHelper$RequestMax.INSTANCE;
        return this.h(g10, g11, a10, flowableInternalHelper$RequestMax);
    }

    public final j d0(i.g.c c10, int n10) {
        e.a.w0.b.a.h(n10, "initialCapacity");
        Callable callable = Functions.f(n10);
        return this.e0(c10, callable);
    }

    public final e.a.a d1(e.a.v0.o o10, boolean bl2) {
        return this.e1(o10, bl2, 2);
    }

    public final j d2(a a10) {
        g g10 = Functions.h();
        e.a.v0.q q10 = Functions.g;
        return this.j2(g10, q10, a10);
    }

    public final j d5(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "handler is null");
        FlowableRepeatWhen flowableRepeatWhen = new FlowableRepeatWhen(this, o10);
        return e.a.a1.a.P(flowableRepeatWhen);
    }

    public final j d6(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        FlowableSkipUntil flowableSkipUntil = new FlowableSkipUntil(this, c10);
        return e.a.a1.a.P(flowableSkipUntil);
    }

    public final j d7(long l10, TimeUnit timeUnit, h0 h02) {
        return this.F1(l10, timeUnit, h02);
    }

    public final j d8(long l10, TimeUnit timeUnit, h0 h02, long l11) {
        return this.e8(l10, timeUnit, h02, l11, false);
    }

    public final e.a.i0 e(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        e e10 = new e(this, r10);
        return e.a.a1.a.S(e10);
    }

    public final j e0(i.g.c c10, Callable callable) {
        e.a.w0.b.a.g(c10, "boundaryIndicator is null");
        e.a.w0.b.a.g(callable, "bufferSupplier is null");
        e.a.w0.e.b.j j10 = new e.a.w0.e.b.j(this, c10, callable);
        return e.a.a1.a.P(j10);
    }

    public final e.a.a e1(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        FlowableConcatMapCompletable flowableConcatMapCompletable = new FlowableConcatMapCompletable(this, o10, errorMode, n10);
        return e.a.a1.a.O(flowableConcatMapCompletable);
    }

    public final j e2(a a10) {
        g g10 = Functions.h();
        g g11 = Functions.h();
        a a11 = Functions.c;
        return this.g2(g10, g11, a10, a11);
    }

    public final j e5(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "selector is null");
        return FlowableReplay.b9(FlowableInternalHelper.d(this), o10);
    }

    public final j e6(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        c1 c12 = new c1(this, r10);
        return e.a.a1.a.P(c12);
    }

    public final j e7() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.a();
        return this.h7(timeUnit, h02);
    }

    public final j e8(long l10, TimeUnit timeUnit, h0 h02, long l11, boolean bl2) {
        int n10 = j.f0();
        return this.f8(l10, timeUnit, h02, l11, bl2, n10);
    }

    public final e.a.s0.b f(g g10, g g11, a a10) {
        FlowableInternalHelper$RequestMax flowableInternalHelper$RequestMax = FlowableInternalHelper$RequestMax.INSTANCE;
        return this.h(g10, g11, a10, flowableInternalHelper$RequestMax);
    }

    public final j f1(e.a.v0.o o10) {
        return this.g1(o10, 2, true);
    }

    public final j f2(g object) {
        e.a.w0.b.a.g(object, "onNotification is null");
        g g10 = Functions.t((g)object);
        g g11 = Functions.s((g)object);
        object = Functions.r((g)object);
        a a10 = Functions.c;
        return this.g2(g10, g11, (a)object, a10);
    }

    public final j f5(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        return FlowableReplay.b9(FlowableInternalHelper.e(this, n10), o10);
    }

    public final j f6() {
        j j10 = this.A7().s1();
        e.a.v0.o o10 = Functions.o(Functions.p());
        j10 = j10.R3(o10);
        o10 = Functions.k();
        return j10.M2(o10);
    }

    public final j f7(h0 h02) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return this.h7(timeUnit, h02);
    }

    public final j f8(long l10, TimeUnit timeUnit, h0 h02, long l11, boolean bl2, int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.i(l11, "count");
        k1 k12 = new k1(this, l10, l10, timeUnit, h02, l11, n10, bl2);
        return e.a.a1.a.P(k12);
    }

    public final j g0() {
        return this.h0(16);
    }

    public final j g1(e.a.v0.o o10, int n10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "prefetch";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl3 = this instanceof e.a.w0.c.m;
        if (bl3) {
            Object object2 = this;
            object2 = ((e.a.w0.c.m)((Object)this)).call();
            if (object2 == null) {
                return j.r2();
            }
            return w0.a(object2, o10);
        }
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        object = new FlowableConcatMap(this, o10, n10, errorMode);
        return e.a.a1.a.P((j)object);
    }

    public final j g5(e.a.v0.o o10, int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.h5(o10, n10, l10, timeUnit, h02);
    }

    public final j g6(Comparator object) {
        e.a.w0.b.a.g(object, "sortFunction");
        Object object2 = this.A7().s1();
        object = Functions.o((Comparator)object);
        object = ((j)object2).R3((e.a.v0.o)object);
        object2 = Functions.k();
        return ((j)object).M2((e.a.v0.o)object2);
    }

    public final j g7(TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.h7(timeUnit, h02);
    }

    public final j g8(Callable callable) {
        int n10 = j.f0();
        return this.h8(callable, n10);
    }

    public final e.a.s0.b h(g g10, g g11, a a10, g g12) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.w0.b.a.g(g12, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(g10, g11, a10, g12);
        this.l6(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final j h0(int n10) {
        e.a.w0.b.a.h(n10, "initialCapacity");
        FlowableCache flowableCache = new FlowableCache(this, n10);
        return e.a.a1.a.P(flowableCache);
    }

    public final j h1(e.a.v0.o o10) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.i1(o10, n10, n11);
    }

    public final j h2(i.g.d object) {
        e.a.w0.b.a.g(object, "subscriber is null");
        g g10 = FlowableInternalHelper.m((i.g.d)object);
        g g11 = FlowableInternalHelper.l((i.g.d)object);
        object = FlowableInternalHelper.k((i.g.d)object);
        a a10 = Functions.c;
        return this.g2(g10, g11, (a)object, a10);
    }

    public final j h5(e.a.v0.o o10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return FlowableReplay.b9(FlowableInternalHelper.f(this, n10, l10, timeUnit, h02), o10);
    }

    public final j h6(Iterable object) {
        i.g.c[] cArray = new i.g.c[]{object = j.e3((Iterable)object), this};
        return j.L0(cArray);
    }

    public final j h7(TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        h1 h12 = new h1(this, timeUnit, h02);
        return e.a.a1.a.P(h12);
    }

    public final j h8(Callable callable, int n10) {
        e.a.w0.b.a.g(callable, "boundaryIndicatorSupplier is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableWindowBoundarySupplier flowableWindowBoundarySupplier = new FlowableWindowBoundarySupplier(this, callable, n10);
        return e.a.a1.a.P(flowableWindowBoundarySupplier);
    }

    public final TestSubscriber i(long l10, boolean bl2) {
        TestSubscriber testSubscriber = new TestSubscriber(l10);
        if (bl2) {
            testSubscriber.cancel();
        }
        this.l6(testSubscriber);
        return testSubscriber;
    }

    public final j i0(Class object) {
        e.a.w0.b.a.g(object, "clazz is null");
        object = Functions.e((Class)object);
        return this.R3((e.a.v0.o)object);
    }

    public final j i1(e.a.v0.o o10, int n10, int n11) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapEager flowableConcatMapEager = new FlowableConcatMapEager(this, o10, n10, n11, errorMode);
        return e.a.a1.a.P(flowableConcatMapEager);
    }

    public final j i2(g g10) {
        g g11 = Functions.h();
        a a10 = Functions.c;
        return this.g2(g11, g10, a10, a10);
    }

    public final j i5(e.a.v0.o o10, int n10, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        Callable callable = FlowableInternalHelper.e(this, n10);
        o10 = FlowableInternalHelper.h(o10, h02);
        return FlowableReplay.b9(callable, o10);
    }

    public final j i6(Object object) {
        e.a.w0.b.a.g(object, "value is null");
        i.g.c[] cArray = new i.g.c[]{object = j.C3(object), this};
        return j.L0(cArray);
    }

    public final j i7(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.q7(l10, timeUnit, null, h02);
    }

    public final j i8(i.g.c c10) {
        int n10 = j.f0();
        return this.j8(c10, n10);
    }

    public final i.g.d j(i.g.d d10) {
        this.subscribe(d10);
        return d10;
    }

    public final e.a.i0 j0(Callable callable, e.a.v0.b b10) {
        e.a.w0.b.a.g(callable, "initialItemSupplier is null");
        e.a.w0.b.a.g(b10, "collector is null");
        l l10 = new l(this, callable, b10);
        return e.a.a1.a.S(l10);
    }

    public final j j1(e.a.v0.o o10, int n10, int n11, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        FlowableConcatMapEager flowableConcatMapEager = new FlowableConcatMapEager(this, o10, n10, n11, errorMode);
        return e.a.a1.a.P(flowableConcatMapEager);
    }

    public final j j2(g g10, e.a.v0.q q10, a a10) {
        e.a.w0.b.a.g(g10, "onSubscribe is null");
        e.a.w0.b.a.g(q10, "onRequest is null");
        e.a.w0.b.a.g(a10, "onCancel is null");
        x x10 = new x(this, g10, q10, a10);
        return e.a.a1.a.P(x10);
    }

    public final j j5(e.a.v0.o o10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.k5(o10, l10, timeUnit, h02);
    }

    public final j j6(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        i.g.c[] cArray = new i.g.c[]{c10, this};
        return j.L0(cArray);
    }

    public final j j7(long l10, TimeUnit timeUnit, h0 h02) {
        return this.q7(l10, timeUnit, null, h02);
    }

    public final j j8(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "boundaryIndicator is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableWindowBoundary flowableWindowBoundary = new FlowableWindowBoundary(this, c10, n10);
        return e.a.a1.a.P(flowableWindowBoundary);
    }

    public final e.a.i0 k0(Object object, e.a.v0.b b10) {
        e.a.w0.b.a.g(object, "initialItem is null");
        object = Functions.m(object);
        return this.j0((Callable)object, b10);
    }

    public final j k1(e.a.v0.o o10, boolean bl2) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.j1(o10, n10, n11, bl2);
    }

    public final j k2(g g10) {
        g g11 = Functions.h();
        a a10 = Functions.c;
        return this.g2(g10, g11, a10, a10);
    }

    public final j k5(e.a.v0.o o10, long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return FlowableReplay.b9(FlowableInternalHelper.g(this, l10, timeUnit, h02), o10);
    }

    public final j k6(Object ... object) {
        i.g.c[] cArray;
        if ((object = j.Y2(object)) == (cArray = j.r2())) {
            return e.a.a1.a.P(this);
        }
        cArray = new i.g.c[]{object, this};
        return j.L0(cArray);
    }

    public final j k7(long l10, TimeUnit timeUnit, h0 h02, i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        return this.q7(l10, timeUnit, c10, h02);
    }

    public final j k8(i.g.c c10, e.a.v0.o o10) {
        int n10 = j.f0();
        return this.l8(c10, o10, n10);
    }

    public final TestSubscriber l(long l10) {
        TestSubscriber testSubscriber = new TestSubscriber(l10);
        this.l6(testSubscriber);
        return testSubscriber;
    }

    public final j l1(e.a.v0.o o10) {
        return this.m1(o10, 2);
    }

    public final j l2(e.a.v0.q q10) {
        g g10 = Functions.h();
        a a10 = Functions.c;
        return this.j2(g10, q10, a10);
    }

    public final j l3(e.a.v0.o o10) {
        e.a.v0.o o11 = Functions.k();
        int n10 = j.f0();
        return this.o3(o10, o11, false, n10);
    }

    public final j l5(e.a.v0.o o10, h0 h02) {
        e.a.w0.b.a.g(o10, "selector is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        Callable callable = FlowableInternalHelper.d(this);
        o10 = FlowableInternalHelper.h(o10, h02);
        return FlowableReplay.b9(callable, o10);
    }

    public final void l6(e.a.o d10) {
        Object object = "s is null";
        e.a.w0.b.a.g(d10, (String)object);
        d10 = e.a.a1.a.h0(this, d10);
        object = "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins";
        e.a.w0.b.a.g(d10, (String)object);
        try {
            this.m6(d10);
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

    public final j l7(long l10, TimeUnit timeUnit, i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        h0 h02 = e.a.c1.b.a();
        return this.q7(l10, timeUnit, c10, h02);
    }

    public final j l8(i.g.c c10, e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(c10, "openingIndicator is null");
        e.a.w0.b.a.g(o10, "closingIndicator is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        j1 j12 = new j1(this, c10, o10, n10);
        return e.a.a1.a.P(j12);
    }

    public final j m1(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        FlowableFlattenIterable flowableFlattenIterable = new FlowableFlattenIterable(this, o10, n10);
        return e.a.a1.a.P(flowableFlattenIterable);
    }

    public final j m2(g g10) {
        e.a.v0.q q10 = Functions.g;
        a a10 = Functions.c;
        return this.j2(g10, q10, a10);
    }

    public final j m3(e.a.v0.o o10, e.a.v0.o o11) {
        int n10 = j.f0();
        return this.o3(o10, o11, false, n10);
    }

    public final e.a.u0.a m5() {
        return FlowableReplay.a9(this);
    }

    public abstract void m6(i.g.d var1);

    public final j m7(e.a.v0.o o10) {
        return this.r7(null, o10, null);
    }

    public final j m8(Iterable iterable, e.a.v0.o o10) {
        e.a.w0.b.a.g(iterable, "others is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        FlowableWithLatestFromMany flowableWithLatestFromMany = new FlowableWithLatestFromMany(this, iterable, o10);
        return e.a.a1.a.P(flowableWithLatestFromMany);
    }

    public final j n1(e.a.v0.o o10) {
        return this.o1(o10, 2);
    }

    public final j n2(a a10) {
        g g10 = Functions.h();
        g g11 = Functions.a(a10);
        a a11 = Functions.c;
        return this.g2(g10, g11, a10, a11);
    }

    public final j n3(e.a.v0.o o10, e.a.v0.o o11, boolean bl2) {
        int n10 = j.f0();
        return this.o3(o10, o11, bl2, n10);
    }

    public final j n4(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        FlowableMergeWithCompletable flowableMergeWithCompletable = new FlowableMergeWithCompletable(this, g10);
        return e.a.a1.a.P(flowableMergeWithCompletable);
    }

    public final e.a.u0.a n5(int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        return FlowableReplay.W8(this, n10);
    }

    public final j n6(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        boolean bl2 = this instanceof FlowableCreate ^ true;
        return this.o6(h02, bl2);
    }

    public final j n7(e.a.v0.o o10, j j10) {
        e.a.w0.b.a.g(j10, "other is null");
        return this.r7(null, o10, j10);
    }

    public final j n8(i.g.c c10, e.a.v0.c c11) {
        e.a.w0.b.a.g(c10, "other is null");
        e.a.w0.b.a.g(c11, "combiner is null");
        FlowableWithLatestFrom flowableWithLatestFrom = new FlowableWithLatestFrom(this, c11, c10);
        return e.a.a1.a.P(flowableWithLatestFrom);
    }

    public final j o1(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapMaybe flowableConcatMapMaybe = new FlowableConcatMapMaybe(this, o10, errorMode, n10);
        return e.a.a1.a.P(flowableConcatMapMaybe);
    }

    public final e.a.q o2(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            y y10 = new y(this, l10);
            return e.a.a1.a.Q(y10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final j o3(e.a.v0.o o10, e.a.v0.o o11, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.w0.b.a.g(o11, "valueSelector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableGroupBy flowableGroupBy = new FlowableGroupBy(this, o10, o11, n10, bl2, null);
        return e.a.a1.a.P(flowableGroupBy);
    }

    public final j o4(e.a.w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        FlowableMergeWithMaybe flowableMergeWithMaybe = new FlowableMergeWithMaybe(this, w10);
        return e.a.a1.a.P(flowableMergeWithMaybe);
    }

    public final e.a.u0.a o5(int n10, long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.p5(n10, l10, timeUnit, h02);
    }

    public final j o6(h0 h02, boolean bl2) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        FlowableSubscribeOn flowableSubscribeOn = new FlowableSubscribeOn(this, h02, bl2);
        return e.a.a1.a.P(flowableSubscribeOn);
    }

    public final j o7(i.g.c c10, e.a.v0.o o10) {
        e.a.w0.b.a.g(c10, "firstTimeoutIndicator is null");
        return this.r7(c10, o10, null);
    }

    public final j o8(i.g.c c10, i.g.c c11, e.a.v0.h object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        object = Functions.y((e.a.v0.h)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11};
        return this.r8(cArray, (e.a.v0.o)object);
    }

    public final j p(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        i.g.c[] cArray = new i.g.c[]{this, c10};
        return j.o(cArray);
    }

    public final j p1(e.a.v0.o o10) {
        return this.r1(o10, true, 2);
    }

    public final e.a.i0 p2(long l10, Object object) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            e.a.w0.b.a.g(object, "defaultItem is null");
            z z10 = new z(this, l10, object);
            return e.a.a1.a.S(z10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public final j p3(e.a.v0.o o10, e.a.v0.o o11, boolean bl2, int n10, e.a.v0.o o12) {
        e.a.w0.b.a.g(o10, "keySelector is null");
        e.a.w0.b.a.g(o11, "valueSelector is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        e.a.w0.b.a.g(o12, "evictingMapFactory is null");
        FlowableGroupBy flowableGroupBy = new FlowableGroupBy(this, o10, o11, n10, bl2, o12);
        return e.a.a1.a.P(flowableGroupBy);
    }

    public final j p4(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        FlowableMergeWithSingle flowableMergeWithSingle = new FlowableMergeWithSingle(this, o02);
        return e.a.a1.a.P(flowableMergeWithSingle);
    }

    public final e.a.u0.a p5(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, (String)object);
        object = this;
        return FlowableReplay.Y8(this, l10, timeUnit, h02, n10);
    }

    public final j p6(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        d1 d12 = new d1(this, c10);
        return e.a.a1.a.P(d12);
    }

    public final j p7(i.g.c c10, e.a.v0.o o10, i.g.c c11) {
        e.a.w0.b.a.g(c10, "firstTimeoutSelector is null");
        e.a.w0.b.a.g(c11, "other is null");
        return this.r7(c10, o10, c11);
    }

    public final j p8(i.g.c c10, i.g.c c11, i.g.c c12, e.a.v0.i object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        object = Functions.z((e.a.v0.i)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12};
        return this.r8(cArray, (e.a.v0.o)object);
    }

    public final e.a.i0 q(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        f f10 = new f(this, r10);
        return e.a.a1.a.S(f10);
    }

    public final j q1(e.a.v0.o o10, boolean bl2) {
        return this.r1(o10, bl2, 2);
    }

    public final e.a.i0 q2(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            z z10 = new z(this, l10, null);
            return e.a.a1.a.S(z10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final j q3(e.a.v0.o o10, boolean bl2) {
        e.a.v0.o o11 = Functions.k();
        int n10 = j.f0();
        return this.o3(o10, o11, bl2, n10);
    }

    public final j q4(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        return j.Y3(this, c10);
    }

    public final e.a.u0.a q5(int n10, h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return FlowableReplay.c9(this.n5(n10), h02);
    }

    public final j q6(e.a.v0.o o10) {
        int n10 = j.f0();
        return this.r6(o10, n10);
    }

    public final j q8(i.g.c c10, i.g.c c11, i.g.c c12, i.g.c c13, e.a.v0.j object) {
        e.a.w0.b.a.g(c10, "source1 is null");
        e.a.w0.b.a.g(c11, "source2 is null");
        e.a.w0.b.a.g(c12, "source3 is null");
        e.a.w0.b.a.g(c13, "source4 is null");
        object = Functions.A((e.a.v0.j)object);
        i.g.c[] cArray = new i.g.c[]{c10, c11, c12, c13};
        return this.r8(cArray, (e.a.v0.o)object);
    }

    public final Object r(e.a.k k10) {
        return ((e.a.k)e.a.w0.b.a.g(k10, "converter is null")).b(this);
    }

    public final j r1(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        FlowableConcatMapMaybe flowableConcatMapMaybe = new FlowableConcatMapMaybe(this, o10, errorMode, n10);
        return e.a.a1.a.P(flowableConcatMapMaybe);
    }

    public final j r3(i.g.c c10, e.a.v0.o o10, e.a.v0.o o11, e.a.v0.c c11) {
        e.a.w0.b.a.g(c10, "other is null");
        e.a.w0.b.a.g(o10, "leftEnd is null");
        e.a.w0.b.a.g(o11, "rightEnd is null");
        e.a.w0.b.a.g(c11, "resultSelector is null");
        FlowableGroupJoin flowableGroupJoin = new FlowableGroupJoin(this, c10, o10, o11, c11);
        return e.a.a1.a.P(flowableGroupJoin);
    }

    public final e.a.u0.a r5(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.s5(l10, timeUnit, h02);
    }

    public final j r6(e.a.v0.o o10, int n10) {
        return this.s6(o10, n10, false);
    }

    public final j r8(i.g.c[] cArray, e.a.v0.o o10) {
        e.a.w0.b.a.g(cArray, "others is null");
        e.a.w0.b.a.g(o10, "combiner is null");
        FlowableWithLatestFromMany flowableWithLatestFromMany = new FlowableWithLatestFromMany(this, cArray, o10);
        return e.a.a1.a.P(flowableWithLatestFromMany);
    }

    public final Object s() {
        Object object = new e.a.w0.h.d();
        this.l6((e.a.o)object);
        object = ((e.a.w0.h.c)object).a();
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final j s1(e.a.v0.o o10) {
        return this.t1(o10, 2);
    }

    public final j s3() {
        i0 i02 = new i0(this);
        return e.a.a1.a.P(i02);
    }

    public final j s4(h0 h02) {
        int n10 = j.f0();
        return this.u4(h02, false, n10);
    }

    public final e.a.u0.a s5(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        return FlowableReplay.X8(this, l10, timeUnit, h02);
    }

    public j s6(e.a.v0.o o10, int n10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        Object object = "bufferSize";
        e.a.w0.b.a.h(n10, (String)object);
        boolean bl3 = this instanceof e.a.w0.c.m;
        if (bl3) {
            Object object2 = this;
            object2 = ((e.a.w0.c.m)((Object)this)).call();
            if (object2 == null) {
                return j.r2();
            }
            return w0.a(object2, o10);
        }
        object = new FlowableSwitchMap(this, o10, n10, bl2);
        return e.a.a1.a.P((j)object);
    }

    public final void subscribe(i.g.d d10) {
        boolean bl2 = d10 instanceof e.a.o;
        if (bl2) {
            d10 = (e.a.o)d10;
            this.l6((e.a.o)d10);
        } else {
            e.a.w0.b.a.g(d10, "s is null");
            StrictSubscriber strictSubscriber = new StrictSubscriber(d10);
            this.l6(strictSubscriber);
        }
    }

    public final Object t(Object object) {
        Object object2 = new e.a.w0.h.d();
        this.l6((e.a.o)object2);
        object2 = ((e.a.w0.h.c)object2).a();
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    public final j t1(e.a.v0.o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        FlowableConcatMapSingle flowableConcatMapSingle = new FlowableConcatMapSingle(this, o10, errorMode, n10);
        return e.a.a1.a.P(flowableConcatMapSingle);
    }

    public final e.a.a t3() {
        k0 k02 = new k0(this);
        return e.a.a1.a.O(k02);
    }

    public final j t4(h0 h02, boolean bl2) {
        int n10 = j.f0();
        return this.u4(h02, bl2, n10);
    }

    public final e.a.u0.a t5(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        return FlowableReplay.c9(this.m5(), h02);
    }

    public final e.a.a t6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapCompletable flowableSwitchMapCompletable = new FlowableSwitchMapCompletable(this, o10, false);
        return e.a.a1.a.O(flowableSwitchMapCompletable);
    }

    public final void u(g g10) {
        boolean bl2;
        Iterator iterator2 = this.v().iterator();
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

    public final j u1(e.a.v0.o o10) {
        return this.w1(o10, true, 2);
    }

    public final j u2(e.a.v0.r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        c0 c02 = new c0(this, r10);
        return e.a.a1.a.P(c02);
    }

    public final j u4(h0 h02, boolean bl2, int n10) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.b.a.h(n10, "bufferSize");
        FlowableObserveOn flowableObserveOn = new FlowableObserveOn(this, h02, bl2, n10);
        return e.a.a1.a.P(flowableObserveOn);
    }

    public final j u5() {
        e.a.v0.r r10 = Functions.c();
        return this.w5(Long.MAX_VALUE, r10);
    }

    public final e.a.a u6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapCompletable flowableSwitchMapCompletable = new FlowableSwitchMapCompletable(this, o10, true);
        return e.a.a1.a.O(flowableSwitchMapCompletable);
    }

    public final j u7() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = e.a.c1.b.a();
        return this.x7(timeUnit, h02);
    }

    public final Iterable v() {
        int n10 = j.f0();
        return this.w(n10);
    }

    public final j v1(e.a.v0.o o10, boolean bl2) {
        return this.w1(o10, bl2, 2);
    }

    public final e.a.i0 v2(Object object) {
        return this.p2(0L, object);
    }

    public final j v4(Class clazz) {
        e.a.w0.b.a.g(clazz, "clazz is null");
        e.a.v0.r r10 = Functions.l(clazz);
        return this.u2(r10).i0(clazz);
    }

    public final j v5(long l10) {
        e.a.v0.r r10 = Functions.c();
        return this.w5(l10, r10);
    }

    public final j v6(e.a.v0.o o10) {
        int n10 = j.f0();
        return this.w6(o10, n10);
    }

    public final j v7(h0 h02) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return this.x7(timeUnit, h02);
    }

    public final Iterable w(int n10) {
        e.a.w0.b.a.h(n10, "bufferSize");
        BlockingFlowableIterable blockingFlowableIterable = new BlockingFlowableIterable(this, n10);
        return blockingFlowableIterable;
    }

    public final j w1(e.a.v0.o o10, boolean bl2, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        FlowableConcatMapSingle flowableConcatMapSingle = new FlowableConcatMapSingle(this, o10, errorMode, n10);
        return e.a.a1.a.P(flowableConcatMapSingle);
    }

    public final e.a.q w2() {
        return this.o2(0L);
    }

    public final j w4() {
        int n10 = j.f0();
        return this.A4(n10, false, true);
    }

    public final j w5(long l10, e.a.v0.r object) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 >= 0) {
            e.a.w0.b.a.g(object, "predicate is null");
            FlowableRetryPredicate flowableRetryPredicate = new FlowableRetryPredicate(this, l10, (e.a.v0.r)object);
            return e.a.a1.a.P(flowableRetryPredicate);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("times >= 0 required but it was ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final j w6(e.a.v0.o o10, int n10) {
        return this.s6(o10, n10, true);
    }

    public final j w7(TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.x7(timeUnit, h02);
    }

    public final Object x() {
        Object object = new e.a.w0.h.e();
        this.l6((e.a.o)object);
        object = ((e.a.w0.h.c)object).a();
        if (object != null) {
            return object;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public final j x1(e.a.g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        FlowableConcatWithCompletable flowableConcatWithCompletable = new FlowableConcatWithCompletable(this, g10);
        return e.a.a1.a.P(flowableConcatWithCompletable);
    }

    public final e.a.i0 x2() {
        return this.q2(0L);
    }

    public final j x4(int n10) {
        return this.A4(n10, false, false);
    }

    public final j x5(e.a.v0.d d10) {
        e.a.w0.b.a.g(d10, "predicate is null");
        FlowableRetryBiPredicate flowableRetryBiPredicate = new FlowableRetryBiPredicate(this, d10);
        return e.a.a1.a.P(flowableRetryBiPredicate);
    }

    public final j x6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapMaybe flowableSwitchMapMaybe = new FlowableSwitchMapMaybe(this, o10, false);
        return e.a.a1.a.P(flowableSwitchMapMaybe);
    }

    public final j x7(TimeUnit object, h0 h02) {
        e.a.w0.b.a.g(object, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        object = Functions.w(object, h02);
        return this.R3((e.a.v0.o)object);
    }

    public final Object y(Object object) {
        Object object2 = new e.a.w0.h.e();
        this.l6((e.a.o)object2);
        object2 = ((e.a.w0.h.c)object2).a();
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    public final j y1(e.a.w w10) {
        e.a.w0.b.a.g(w10, "other is null");
        FlowableConcatWithMaybe flowableConcatWithMaybe = new FlowableConcatWithMaybe(this, w10);
        return e.a.a1.a.P(flowableConcatWithMaybe);
    }

    public final j y2(e.a.v0.o o10) {
        int n10 = j.f0();
        int n11 = j.f0();
        return this.J2(o10, false, n10, n11);
    }

    public final j y4(int n10, a a10) {
        return this.B4(n10, false, false, a10);
    }

    public final j y5(e.a.v0.r r10) {
        return this.w5(Long.MAX_VALUE, r10);
    }

    public final j y6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapMaybe flowableSwitchMapMaybe = new FlowableSwitchMapMaybe(this, o10, true);
        return e.a.a1.a.P(flowableSwitchMapMaybe);
    }

    public final Object y7(e.a.v0.o object) {
        String string2 = "converter is null";
        try {
            object = e.a.w0.b.a.g(object, string2);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            throw ExceptionHelper.f(throwable);
        }
        object = (e.a.v0.o)object;
        return object.apply(this);
    }

    public final Iterable z() {
        b b10 = new b(this);
        return b10;
    }

    public final j z1(o0 o02) {
        e.a.w0.b.a.g(o02, "other is null");
        FlowableConcatWithSingle flowableConcatWithSingle = new FlowableConcatWithSingle(this, o02);
        return e.a.a1.a.P(flowableConcatWithSingle);
    }

    public final j z2(e.a.v0.o o10, int n10) {
        int n11 = j.f0();
        return this.J2(o10, false, n10, n11);
    }

    public final j z4(int n10, boolean bl2) {
        return this.A4(n10, bl2, false);
    }

    public final j z5(e.a.v0.e object) {
        e.a.w0.b.a.g(object, "stop is null");
        object = Functions.v((e.a.v0.e)object);
        return this.w5(Long.MAX_VALUE, (e.a.v0.r)object);
    }

    public final j z6(e.a.v0.o o10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        FlowableSwitchMapSingle flowableSwitchMapSingle = new FlowableSwitchMapSingle(this, o10, false);
        return e.a.a1.a.P(flowableSwitchMapSingle);
    }

    public final Future z7() {
        e.a.w0.h.f f10 = new e.a.w0.h.f();
        return (Future)((Object)this.j(f10));
    }
}

