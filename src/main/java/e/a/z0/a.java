/*
 * Decompiled with CFR 0.151.
 */
package e.a.z0;

import e.a.h0;
import e.a.j;
import e.a.v0.o;
import e.a.v0.q;
import e.a.v0.r;
import e.a.w0.e.f.d;
import e.a.w0.e.f.e;
import e.a.w0.e.f.f;
import e.a.w0.e.f.g;
import e.a.w0.e.f.h;
import e.a.w0.e.f.i;
import e.a.z0.b;
import e.a.z0.c;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.parallel.ParallelCollect;
import io.reactivex.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.internal.operators.parallel.ParallelJoin;
import io.reactivex.internal.operators.parallel.ParallelReduce;
import io.reactivex.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.internal.operators.parallel.ParallelRunOn;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.ListAddBiConsumer;
import io.reactivex.parallel.ParallelFailureHandling;
import java.util.Comparator;
import java.util.concurrent.Callable;

public abstract class a {
    public static a A(i.g.c c10, int n10) {
        int n11 = j.f0();
        return a.B(c10, n10, n11);
    }

    public static a B(i.g.c c10, int n10, int n11) {
        e.a.w0.b.a.g(c10, "source");
        e.a.w0.b.a.h(n10, "parallelism");
        e.a.w0.b.a.h(n11, "prefetch");
        ParallelFromPublisher parallelFromPublisher = new ParallelFromPublisher(c10, n10, n11);
        return e.a.a1.a.V(parallelFromPublisher);
    }

    public static a C(i.g.c ... cArray) {
        int n10 = cArray.length;
        if (n10 != 0) {
            f f10 = new f(cArray);
            return e.a.a1.a.V(f10);
        }
        cArray = new IllegalArgumentException("Zero publishers not supported");
        throw cArray;
    }

    public static a z(i.g.c c10) {
        int n10 = Runtime.getRuntime().availableProcessors();
        int n11 = j.f0();
        return a.B(c10, n10, n11);
    }

    public final a D(o o10) {
        e.a.w0.b.a.g(o10, "mapper");
        g g10 = new g(this, o10);
        return e.a.a1.a.V(g10);
    }

    public final a E(o o10, e.a.v0.c c10) {
        e.a.w0.b.a.g(o10, "mapper");
        e.a.w0.b.a.g(c10, "errorHandler is null");
        h h10 = new h(this, o10, c10);
        return e.a.a1.a.V(h10);
    }

    public final a F(o o10, ParallelFailureHandling parallelFailureHandling) {
        e.a.w0.b.a.g(o10, "mapper");
        e.a.w0.b.a.g(parallelFailureHandling, "errorHandler is null");
        h h10 = new h(this, o10, parallelFailureHandling);
        return e.a.a1.a.V(h10);
    }

    public abstract int G();

    public final j H(e.a.v0.c c10) {
        e.a.w0.b.a.g(c10, "reducer");
        ParallelReduceFull parallelReduceFull = new ParallelReduceFull(this, c10);
        return e.a.a1.a.P(parallelReduceFull);
    }

    public final a I(Callable callable, e.a.v0.c c10) {
        e.a.w0.b.a.g(callable, "initialSupplier");
        e.a.w0.b.a.g(c10, "reducer");
        ParallelReduce parallelReduce = new ParallelReduce(this, callable, c10);
        return e.a.a1.a.V(parallelReduce);
    }

    public final a J(h0 h02) {
        int n10 = j.f0();
        return this.K(h02, n10);
    }

    public final a K(h0 h02, int n10) {
        e.a.w0.b.a.g(h02, "scheduler");
        e.a.w0.b.a.h(n10, "prefetch");
        ParallelRunOn parallelRunOn = new ParallelRunOn(this, h02, n10);
        return e.a.a1.a.V(parallelRunOn);
    }

    public final j L() {
        int n10 = j.f0();
        return this.M(n10);
    }

    public final j M(int n10) {
        e.a.w0.b.a.h(n10, "prefetch");
        ParallelJoin parallelJoin = new ParallelJoin(this, n10, false);
        return e.a.a1.a.P(parallelJoin);
    }

    public final j N() {
        int n10 = j.f0();
        return this.O(n10);
    }

    public final j O(int n10) {
        e.a.w0.b.a.h(n10, "prefetch");
        ParallelJoin parallelJoin = new ParallelJoin(this, n10, true);
        return e.a.a1.a.P(parallelJoin);
    }

    public final j P(Comparator comparator) {
        return this.Q(comparator, 16);
    }

    public final j Q(Comparator comparator, int n10) {
        e.a.w0.b.a.g(comparator, "comparator is null");
        e.a.w0.b.a.h(n10, "capacityHint");
        int n11 = this.G();
        Object object = Functions.f(n10 / n11 + 1);
        Object object2 = ListAddBiConsumer.instance();
        object = this.I((Callable)object, (e.a.v0.c)object2);
        object2 = new e.a.w0.i.o(comparator);
        object = ((a)object).D((o)object2);
        object2 = new ParallelSortedJoin((a)object, comparator);
        return e.a.a1.a.P((j)object2);
    }

    public final Object R(o object) {
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

    public final j S(Comparator comparator) {
        return this.T(comparator, 16);
    }

    public final j T(Comparator comparator, int n10) {
        e.a.w0.b.a.g(comparator, "comparator is null");
        e.a.w0.b.a.h(n10, "capacityHint");
        int n11 = this.G();
        Object object = Functions.f(n10 / n11 + 1);
        Object object2 = ListAddBiConsumer.instance();
        object = this.I((Callable)object, (e.a.v0.c)object2);
        object2 = new e.a.w0.i.o(comparator);
        object = ((a)object).D((o)object2);
        object2 = new e.a.w0.i.i(comparator);
        return e.a.a1.a.P(((a)object).H((e.a.v0.c)object2));
    }

    public final boolean U(i.g.d[] dArray) {
        int n10 = dArray.length;
        int n11 = this.G();
        if (n10 != n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("parallelism = ");
            stringBuilder.append(n11);
            stringBuilder.append(", subscribers = ");
            n11 = dArray.length;
            stringBuilder.append(n11);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            n11 = dArray.length;
            stringBuilder = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                i.g.d d10 = dArray[i10];
                EmptySubscription.error(illegalArgumentException, d10);
            }
            return false;
        }
        return true;
    }

    public abstract void a(i.g.d[] var1);

    public final Object b(b b10) {
        return ((b)e.a.w0.b.a.g(b10, "converter is null")).d(this);
    }

    public final a c(Callable callable, e.a.v0.b b10) {
        e.a.w0.b.a.g(callable, "collectionSupplier is null");
        e.a.w0.b.a.g(b10, "collector is null");
        ParallelCollect parallelCollect = new ParallelCollect(this, callable, b10);
        return e.a.a1.a.V(parallelCollect);
    }

    public final a d(c c10) {
        return e.a.a1.a.V(((c)e.a.w0.b.a.g(c10, "composer is null")).d(this));
    }

    public final a e(o o10) {
        return this.f(o10, 2);
    }

    public final a f(o o10, int n10) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        e.a.w0.e.f.a a10 = new e.a.w0.e.f.a(this, o10, n10, errorMode);
        return e.a.a1.a.V(a10);
    }

    public final a g(o o10, int n10, boolean bl2) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "prefetch");
        ErrorMode errorMode = bl2 ? ErrorMode.END : ErrorMode.BOUNDARY;
        e.a.w0.e.f.a a10 = new e.a.w0.e.f.a(this, o10, n10, errorMode);
        return e.a.a1.a.V(a10);
    }

    public final a h(o o10, boolean bl2) {
        return this.g(o10, 2, bl2);
    }

    public final a i(e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onAfterNext is null");
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g11, g10, g12, a10, a10, g13, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a j(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onAfterTerminate is null");
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g10, g11, g12, a11, a10, g13, q10, a11);
        return e.a.a1.a.V(i10);
    }

    public final a k(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onCancel is null");
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g10, g11, g12, a11, a11, g13, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a l(e.a.v0.a a10) {
        e.a.w0.b.a.g(a10, "onComplete is null");
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a11 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g10, g11, g12, a10, a11, g13, q10, a11);
        return e.a.a1.a.V(i10);
    }

    public final a m(e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onError is null");
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g11, g12, g10, a10, a10, g13, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a n(e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        q q10 = Functions.g;
        i i10 = new i(this, g10, g11, g12, a10, a10, g13, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a o(e.a.v0.g g10, e.a.v0.c c10) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(c10, "errorHandler is null");
        e.a.w0.e.f.b b10 = new e.a.w0.e.f.b(this, g10, c10);
        return e.a.a1.a.V(b10);
    }

    public final a p(e.a.v0.g g10, ParallelFailureHandling parallelFailureHandling) {
        e.a.w0.b.a.g(g10, "onNext is null");
        e.a.w0.b.a.g(parallelFailureHandling, "errorHandler is null");
        e.a.w0.e.f.b b10 = new e.a.w0.e.f.b(this, g10, parallelFailureHandling);
        return e.a.a1.a.V(b10);
    }

    public final a q(q q10) {
        e.a.w0.b.a.g(q10, "onRequest is null");
        e.a.v0.g g10 = Functions.h();
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        e.a.v0.g g13 = Functions.h();
        i i10 = new i(this, g10, g11, g12, a10, a10, g13, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a r(e.a.v0.g g10) {
        e.a.w0.b.a.g(g10, "onSubscribe is null");
        e.a.v0.g g11 = Functions.h();
        e.a.v0.g g12 = Functions.h();
        e.a.v0.g g13 = Functions.h();
        e.a.v0.a a10 = Functions.c;
        q q10 = Functions.g;
        i i10 = new i(this, g11, g12, g13, a10, a10, g10, q10, a10);
        return e.a.a1.a.V(i10);
    }

    public final a s(r r10) {
        e.a.w0.b.a.g(r10, "predicate");
        e.a.w0.e.f.c c10 = new e.a.w0.e.f.c(this, r10);
        return e.a.a1.a.V(c10);
    }

    public final a t(r r10, e.a.v0.c c10) {
        e.a.w0.b.a.g(r10, "predicate");
        e.a.w0.b.a.g(c10, "errorHandler is null");
        d d10 = new d(this, r10, c10);
        return e.a.a1.a.V(d10);
    }

    public final a u(r r10, ParallelFailureHandling parallelFailureHandling) {
        e.a.w0.b.a.g(r10, "predicate");
        e.a.w0.b.a.g(parallelFailureHandling, "errorHandler is null");
        d d10 = new d(this, r10, parallelFailureHandling);
        return e.a.a1.a.V(d10);
    }

    public final a v(o o10) {
        int n10 = j.f0();
        return this.y(o10, false, -1 >>> 1, n10);
    }

    public final a w(o o10, boolean bl2) {
        int n10 = j.f0();
        return this.y(o10, bl2, -1 >>> 1, n10);
    }

    public final a x(o o10, boolean bl2, int n10) {
        int n11 = j.f0();
        return this.y(o10, bl2, n10, n11);
    }

    public final a y(o o10, boolean bl2, int n10, int n11) {
        e.a.w0.b.a.g(o10, "mapper is null");
        e.a.w0.b.a.h(n10, "maxConcurrency");
        e.a.w0.b.a.h(n11, "prefetch");
        e e10 = new e(this, o10, bl2, n10, n11);
        return e.a.a1.a.V(e10);
    }
}

