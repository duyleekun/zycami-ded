/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.b;
import e.a.d;
import e.a.e;
import e.a.e0;
import e.a.f;
import e.a.g;
import e.a.h;
import e.a.h0;
import e.a.i0;
import e.a.j;
import e.a.o0;
import e.a.q;
import e.a.v0.o;
import e.a.v0.r;
import e.a.w0.c.c;
import e.a.w0.e.a.a0;
import e.a.w0.e.a.i;
import e.a.w0.e.a.k;
import e.a.w0.e.a.l;
import e.a.w0.e.a.m;
import e.a.w0.e.a.n;
import e.a.w0.e.a.p;
import e.a.w0.e.a.s;
import e.a.w0.e.a.t;
import e.a.w0.e.a.u;
import e.a.w0.e.a.v;
import e.a.w0.e.a.w;
import e.a.w0.e.a.x;
import e.a.w0.e.a.y;
import e.a.w0.e.a.z;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class a
implements g {
    public static a A(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        CompletableConcatIterable completableConcatIterable = new CompletableConcatIterable(iterable);
        return e.a.a1.a.O(completableConcatIterable);
    }

    public static a B(i.g.c c10) {
        return a.C(c10, 2);
    }

    public static a C(i.g.c c10, int n10) {
        e.a.w0.b.a.g(c10, "sources is null");
        e.a.w0.b.a.h(n10, "prefetch");
        CompletableConcat completableConcat = new CompletableConcat(c10, n10);
        return e.a.a1.a.O(completableConcat);
    }

    public static a D(g ... gArray) {
        Object object = "sources is null";
        e.a.w0.b.a.g(gArray, (String)object);
        int n10 = gArray.length;
        if (n10 == 0) {
            return a.y();
        }
        n10 = gArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return a.g1(gArray[0]);
        }
        object = new CompletableConcatArray(gArray);
        return e.a.a1.a.O((a)object);
    }

    public static a F(e e10) {
        e.a.w0.b.a.g(e10, "source is null");
        CompletableCreate completableCreate = new CompletableCreate(e10);
        return e.a.a1.a.O(completableCreate);
    }

    public static a G(Callable callable) {
        e.a.w0.b.a.g(callable, "completableSupplier");
        e.a.w0.e.a.b b10 = new e.a.w0.e.a.b(callable);
        return e.a.a1.a.O(b10);
    }

    private a S(e.a.v0.g g10, e.a.v0.g g11, e.a.v0.a a10, e.a.v0.a a11, e.a.v0.a a12, e.a.v0.a a13) {
        e.a.w0.b.a.g(g10, "onSubscribe is null");
        e.a.w0.b.a.g(g11, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.w0.b.a.g(a11, "onTerminate is null");
        e.a.w0.b.a.g(a12, "onAfterTerminate is null");
        e.a.w0.b.a.g(a13, "onDispose is null");
        w w10 = new w(this, g10, g11, a10, a11, a12, a13);
        return e.a.a1.a.O(w10);
    }

    private a S0(long l10, TimeUnit timeUnit, h0 h02, g g10) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        x x10 = new x(this, l10, timeUnit, h02, g10);
        return e.a.a1.a.O(x10);
    }

    public static a T0(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return a.U0(l10, timeUnit, h02);
    }

    public static a U0(long l10, TimeUnit timeUnit, h0 h02) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        CompletableTimer completableTimer = new CompletableTimer(l10, timeUnit, h02);
        return e.a.a1.a.O(completableTimer);
    }

    public static a V(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "error is null");
        e.a.w0.e.a.g g10 = new e.a.w0.e.a.g(throwable);
        return e.a.a1.a.O(g10);
    }

    public static a W(Callable callable) {
        e.a.w0.b.a.g(callable, "errorSupplier is null");
        e.a.w0.e.a.h h10 = new e.a.w0.e.a.h(callable);
        return e.a.a1.a.O(h10);
    }

    public static a X(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "run is null");
        i i10 = new i(a10);
        return e.a.a1.a.O(i10);
    }

    public static a Y(Callable callable) {
        e.a.w0.b.a.g(callable, "callable is null");
        e.a.w0.e.a.j j10 = new e.a.w0.e.a.j(callable);
        return e.a.a1.a.O(j10);
    }

    private static NullPointerException Y0(Throwable throwable) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(throwable);
        return nullPointerException;
    }

    public static a Z(Future future) {
        e.a.w0.b.a.g(future, "future is null");
        return a.X(Functions.j(future));
    }

    public static a a0(e.a.w w10) {
        e.a.w0.b.a.g(w10, "maybe is null");
        e.a.w0.e.c.x x10 = new e.a.w0.e.c.x(w10);
        return e.a.a1.a.O(x10);
    }

    public static a b0(e0 e02) {
        e.a.w0.b.a.g(e02, "observable is null");
        k k10 = new k(e02);
        return e.a.a1.a.O(k10);
    }

    public static a c(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        e.a.w0.e.a.a a10 = new e.a.w0.e.a.a(null, iterable);
        return e.a.a1.a.O(a10);
    }

    public static a c0(i.g.c c10) {
        e.a.w0.b.a.g(c10, "publisher is null");
        l l10 = new l(c10);
        return e.a.a1.a.O(l10);
    }

    public static a c1(g object) {
        Object object2 = "source is null";
        e.a.w0.b.a.g(object, (String)object2);
        boolean bl2 = object instanceof a;
        if (!bl2) {
            object2 = new e.a.w0.e.a.o((g)object);
            return e.a.a1.a.O((a)object2);
        }
        object = new IllegalArgumentException("Use of unsafeCreate(Completable)!");
        throw object;
    }

    public static a d(g ... gArray) {
        Object object = "sources is null";
        e.a.w0.b.a.g(gArray, (String)object);
        int n10 = gArray.length;
        if (n10 == 0) {
            return a.y();
        }
        n10 = gArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return a.g1(gArray[0]);
        }
        object = new e.a.w0.e.a.a(gArray, null);
        return e.a.a1.a.O((a)object);
    }

    public static a d0(Runnable runnable) {
        e.a.w0.b.a.g(runnable, "run is null");
        m m10 = new m(runnable);
        return e.a.a1.a.O(m10);
    }

    public static a e0(o0 o02) {
        e.a.w0.b.a.g(o02, "single is null");
        n n10 = new n(o02);
        return e.a.a1.a.O(n10);
    }

    public static a e1(Callable callable, o o10, e.a.v0.g g10) {
        return a.f1(callable, o10, g10, true);
    }

    public static a f1(Callable callable, o o10, e.a.v0.g g10, boolean bl2) {
        e.a.w0.b.a.g(callable, "resourceSupplier is null");
        e.a.w0.b.a.g(o10, "completableFunction is null");
        e.a.w0.b.a.g(g10, "disposer is null");
        CompletableUsing completableUsing = new CompletableUsing(callable, o10, g10, bl2);
        return e.a.a1.a.O(completableUsing);
    }

    public static a g1(g g10) {
        Object object = "source is null";
        e.a.w0.b.a.g(g10, (String)object);
        boolean bl2 = g10 instanceof a;
        if (bl2) {
            return e.a.a1.a.O((a)g10);
        }
        object = new e.a.w0.e.a.o(g10);
        return e.a.a1.a.O((a)object);
    }

    public static a i0(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        CompletableMergeIterable completableMergeIterable = new CompletableMergeIterable(iterable);
        return e.a.a1.a.O(completableMergeIterable);
    }

    public static a j0(i.g.c c10) {
        return a.l0(c10, -1 >>> 1, false);
    }

    public static a k0(i.g.c c10, int n10) {
        return a.l0(c10, n10, false);
    }

    private static a l0(i.g.c c10, int n10, boolean bl2) {
        e.a.w0.b.a.g(c10, "sources is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        CompletableMerge completableMerge = new CompletableMerge(c10, n10, bl2);
        return e.a.a1.a.O(completableMerge);
    }

    public static a m0(g ... gArray) {
        Object object = "sources is null";
        e.a.w0.b.a.g(gArray, (String)object);
        int n10 = gArray.length;
        if (n10 == 0) {
            return a.y();
        }
        n10 = gArray.length;
        int n11 = 1;
        if (n10 == n11) {
            return a.g1(gArray[0]);
        }
        object = new CompletableMergeArray(gArray);
        return e.a.a1.a.O((a)object);
    }

    public static a n0(g ... gArray) {
        e.a.w0.b.a.g(gArray, "sources is null");
        s s10 = new s(gArray);
        return e.a.a1.a.O(s10);
    }

    public static a o0(Iterable iterable) {
        e.a.w0.b.a.g(iterable, "sources is null");
        t t10 = new t(iterable);
        return e.a.a1.a.O(t10);
    }

    public static a p0(i.g.c c10) {
        return a.l0(c10, -1 >>> 1, true);
    }

    public static a q0(i.g.c c10, int n10) {
        return a.l0(c10, n10, true);
    }

    public static a s0() {
        return e.a.a1.a.O(u.a);
    }

    public static a y() {
        return e.a.a1.a.O(e.a.w0.e.a.f.a);
    }

    public final a A0(e.a.v0.e e10) {
        return a.c0(this.W0().c5(e10));
    }

    public final a B0(o o10) {
        return a.c0(this.W0().d5(o10));
    }

    public final a C0() {
        return a.c0(this.W0().u5());
    }

    public final a D0(long l10) {
        return a.c0(this.W0().v5(l10));
    }

    public final a E(g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        CompletableAndThenCompletable completableAndThenCompletable = new CompletableAndThenCompletable(this, g10);
        return e.a.a1.a.O(completableAndThenCompletable);
    }

    public final a E0(long l10, r r10) {
        return a.c0(this.W0().w5(l10, r10));
    }

    public final a F0(e.a.v0.d d10) {
        return a.c0(this.W0().x5(d10));
    }

    public final a G0(r r10) {
        return a.c0(this.W0().y5(r10));
    }

    public final a H(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.J(l10, timeUnit, h02, false);
    }

    public final a H0(o o10) {
        return a.c0(this.W0().A5(o10));
    }

    public final a I(long l10, TimeUnit timeUnit, h0 h02) {
        return this.J(l10, timeUnit, h02, false);
    }

    public final a I0(g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        g[] gArray = new g[]{g10, this};
        return a.D(gArray);
    }

    public final a J(long l10, TimeUnit timeUnit, h0 h02, boolean bl2) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.b.a.g(h02, "scheduler is null");
        CompletableDelay completableDelay = new CompletableDelay(this, l10, timeUnit, h02, bl2);
        return e.a.a1.a.O(completableDelay);
    }

    public final j J0(i.g.c c10) {
        e.a.w0.b.a.g(c10, "other is null");
        return this.W0().j6(c10);
    }

    public final a K(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.L(l10, timeUnit, h02);
    }

    public final e.a.z K0(e.a.z z10) {
        e.a.w0.b.a.g(z10, "other is null");
        e.a.z z11 = this.Z0();
        return z10.u1(z11);
    }

    public final a L(long l10, TimeUnit timeUnit, h0 h02) {
        return a.U0(l10, timeUnit, h02).n(this);
    }

    public abstract void L0(d var1);

    public final a M(e.a.v0.a a10) {
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        return this.S(g10, g11, a11, a11, a10, a11);
    }

    public final a M0(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        CompletableSubscribeOn completableSubscribeOn = new CompletableSubscribeOn(this, h02);
        return e.a.a1.a.O(completableSubscribeOn);
    }

    public final a N(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onFinally is null");
        CompletableDoFinally completableDoFinally = new CompletableDoFinally(this, a10);
        return e.a.a1.a.O(completableDoFinally);
    }

    public final a N0(g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        CompletableTakeUntilCompletable completableTakeUntilCompletable = new CompletableTakeUntilCompletable(this, g10);
        return e.a.a1.a.O(completableTakeUntilCompletable);
    }

    public final a O(e.a.v0.a a10) {
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        return this.S(g10, g11, a10, a11, a11, a11);
    }

    public final a O0(long l10, TimeUnit timeUnit) {
        h0 h02 = e.a.c1.b.a();
        return this.S0(l10, timeUnit, h02, null);
    }

    public final a P(e.a.v0.a a10) {
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        return this.S(g10, g11, a11, a11, a11, a10);
    }

    public final a P0(long l10, TimeUnit timeUnit, g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        h0 h02 = e.a.c1.b.a();
        return this.S0(l10, timeUnit, h02, g10);
    }

    public final a Q(e.a.v0.g g10) {
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        return this.S(g11, g10, a10, a10, a10, a10);
    }

    public final a Q0(long l10, TimeUnit timeUnit, h0 h02) {
        return this.S0(l10, timeUnit, h02, null);
    }

    public final a R(e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onEvent is null");
        e.a.w0.e.a.e e10 = new e.a.w0.e.a.e(this, g10);
        return e.a.a1.a.O(e10);
    }

    public final a R0(long l10, TimeUnit timeUnit, h0 h02, g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        return this.S0(l10, timeUnit, h02, g10);
    }

    public final a T(e.a.v0.g g10) {
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        return this.S(g10, g11, a10, a10, a10, a10);
    }

    public final a U(e.a.v0.a a10) {
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        return this.S(g10, g11, a11, a10, a11, a11);
    }

    public final Object V0(o object) {
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

    public final j W0() {
        boolean bl2 = this instanceof e.a.w0.c.b;
        if (bl2) {
            a a10 = this;
            return ((e.a.w0.c.b)((Object)this)).l();
        }
        y y10 = new y(this);
        return e.a.a1.a.P(y10);
    }

    public final q X0() {
        boolean bl2 = this instanceof c;
        if (bl2) {
            a a10 = this;
            return ((c)((Object)this)).j();
        }
        e.a.w0.e.c.r r10 = new e.a.w0.e.c.r(this);
        return e.a.a1.a.Q(r10);
    }

    public final e.a.z Z0() {
        boolean bl2 = this instanceof e.a.w0.c.d;
        if (bl2) {
            a a10 = this;
            return ((e.a.w0.c.d)((Object)this)).i();
        }
        z z10 = new z(this);
        return e.a.a1.a.R(z10);
    }

    public final e.a.s0.b a() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        this.f(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final i0 a1(Callable callable) {
        e.a.w0.b.a.g(callable, "completionValueSupplier is null");
        a0 a02 = new a0(this, callable, null);
        return e.a.a1.a.S(a02);
    }

    public final TestObserver b() {
        TestObserver testObserver = new TestObserver();
        this.f(testObserver);
        return testObserver;
    }

    public final i0 b1(Object object) {
        e.a.w0.b.a.g(object, "completionValue is null");
        a0 a02 = new a0(this, null, object);
        return e.a.a1.a.S(a02);
    }

    public final a d1(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        e.a.w0.e.a.d d10 = new e.a.w0.e.a.d(this, h02);
        return e.a.a1.a.O(d10);
    }

    public final TestObserver e(boolean bl2) {
        TestObserver testObserver = new TestObserver();
        if (bl2) {
            testObserver.cancel();
        }
        this.f(testObserver);
        return testObserver;
    }

    public final void f(d d10) {
        String string2 = "observer is null";
        e.a.w0.b.a.g(d10, string2);
        d10 = e.a.a1.a.d0(this, d10);
        string2 = "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins";
        e.a.w0.b.a.g(d10, string2);
        try {
            this.L0(d10);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
            throw a.Y0(throwable);
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }

    public final a f0() {
        p p10 = new p(this);
        return e.a.a1.a.O(p10);
    }

    public final d g(d d10) {
        this.f(d10);
        return d10;
    }

    public final a g0(f f10) {
        e.a.w0.b.a.g(f10, "onLift is null");
        e.a.w0.e.a.q q10 = new e.a.w0.e.a.q(this, f10);
        return e.a.a1.a.O(q10);
    }

    public final e.a.s0.b h(e.a.v0.a a10, e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onError is null");
        e.a.w0.b.a.g(a10, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(g10, a10);
        this.f(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final i0 h0() {
        e.a.w0.e.a.r r10 = new e.a.w0.e.a.r(this);
        return e.a.a1.a.S(r10);
    }

    public final e.a.s0.b k(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(a10);
        this.f(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final a m(g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        g[] gArray = new g[]{this, g10};
        return a.d(gArray);
    }

    public final a n(g g10) {
        e.a.w0.b.a.g(g10, "next is null");
        CompletableAndThenCompletable completableAndThenCompletable = new CompletableAndThenCompletable(this, g10);
        return e.a.a1.a.O(completableAndThenCompletable);
    }

    public final j o(i.g.c c10) {
        e.a.w0.b.a.g(c10, "next is null");
        CompletableAndThenPublisher completableAndThenPublisher = new CompletableAndThenPublisher(this, c10);
        return e.a.a1.a.P(completableAndThenPublisher);
    }

    public final q p(e.a.w w10) {
        e.a.w0.b.a.g(w10, "next is null");
        MaybeDelayWithCompletable maybeDelayWithCompletable = new MaybeDelayWithCompletable(w10, this);
        return e.a.a1.a.Q(maybeDelayWithCompletable);
    }

    public final e.a.z q(e0 e02) {
        e.a.w0.b.a.g(e02, "next is null");
        CompletableAndThenObservable completableAndThenObservable = new CompletableAndThenObservable(this, e02);
        return e.a.a1.a.R(completableAndThenObservable);
    }

    public final i0 r(o0 o02) {
        e.a.w0.b.a.g(o02, "next is null");
        SingleDelayWithCompletable singleDelayWithCompletable = new SingleDelayWithCompletable(o02, this);
        return e.a.a1.a.S(singleDelayWithCompletable);
    }

    public final a r0(g g10) {
        e.a.w0.b.a.g(g10, "other is null");
        g[] gArray = new g[]{this, g10};
        return a.m0(gArray);
    }

    public final Object s(b b10) {
        return ((b)e.a.w0.b.a.g(b10, "converter is null")).c(this);
    }

    public final void t() {
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.f(f10);
        f10.b();
    }

    public final a t0(h0 h02) {
        e.a.w0.b.a.g(h02, "scheduler is null");
        CompletableObserveOn completableObserveOn = new CompletableObserveOn(this, h02);
        return e.a.a1.a.O(completableObserveOn);
    }

    public final boolean u(long l10, TimeUnit timeUnit) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.f(f10);
        return f10.a(l10, timeUnit);
    }

    public final a u0() {
        r r10 = Functions.c();
        return this.v0(r10);
    }

    public final Throwable v() {
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.f(f10);
        return f10.d();
    }

    public final a v0(r r10) {
        e.a.w0.b.a.g(r10, "predicate is null");
        v v10 = new v(this, r10);
        return e.a.a1.a.O(v10);
    }

    public final Throwable w(long l10, TimeUnit timeUnit) {
        e.a.w0.b.a.g((Object)timeUnit, "unit is null");
        e.a.w0.d.f f10 = new e.a.w0.d.f();
        this.f(f10);
        return f10.e(l10, timeUnit);
    }

    public final a w0(o o10) {
        e.a.w0.b.a.g(o10, "errorMapper is null");
        CompletableResumeNext completableResumeNext = new CompletableResumeNext(this, o10);
        return e.a.a1.a.O(completableResumeNext);
    }

    public final a x() {
        CompletableCache completableCache = new CompletableCache(this);
        return e.a.a1.a.O(completableCache);
    }

    public final a x0() {
        e.a.w0.e.a.c c10 = new e.a.w0.e.a.c(this);
        return e.a.a1.a.O(c10);
    }

    public final a y0() {
        return a.c0(this.W0().a5());
    }

    public final a z(h h10) {
        return a.g1(((h)e.a.w0.b.a.g(h10, "transformer is null")).c(this));
    }

    public final a z0(long l10) {
        return a.c0(this.W0().b5(l10));
    }
}

