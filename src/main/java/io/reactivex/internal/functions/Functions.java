/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.functions;

import e.a.h0;
import e.a.v0.a;
import e.a.v0.b;
import e.a.v0.c;
import e.a.v0.e;
import e.a.v0.g;
import e.a.v0.h;
import e.a.v0.i;
import e.a.v0.j;
import e.a.v0.k;
import e.a.v0.l;
import e.a.v0.m;
import e.a.v0.n;
import e.a.v0.o;
import e.a.v0.q;
import e.a.v0.r;
import io.reactivex.internal.functions.Functions$HashSetCallable;
import io.reactivex.internal.functions.Functions$NaturalComparator;
import io.reactivex.internal.functions.Functions$a;
import io.reactivex.internal.functions.Functions$a0;
import io.reactivex.internal.functions.Functions$b;
import io.reactivex.internal.functions.Functions$b0;
import io.reactivex.internal.functions.Functions$c;
import io.reactivex.internal.functions.Functions$c0;
import io.reactivex.internal.functions.Functions$d;
import io.reactivex.internal.functions.Functions$d0;
import io.reactivex.internal.functions.Functions$e;
import io.reactivex.internal.functions.Functions$e0;
import io.reactivex.internal.functions.Functions$f;
import io.reactivex.internal.functions.Functions$f0;
import io.reactivex.internal.functions.Functions$g;
import io.reactivex.internal.functions.Functions$g0;
import io.reactivex.internal.functions.Functions$h;
import io.reactivex.internal.functions.Functions$h0;
import io.reactivex.internal.functions.Functions$i;
import io.reactivex.internal.functions.Functions$i0;
import io.reactivex.internal.functions.Functions$j;
import io.reactivex.internal.functions.Functions$j0;
import io.reactivex.internal.functions.Functions$k;
import io.reactivex.internal.functions.Functions$k0;
import io.reactivex.internal.functions.Functions$l;
import io.reactivex.internal.functions.Functions$m;
import io.reactivex.internal.functions.Functions$n;
import io.reactivex.internal.functions.Functions$o;
import io.reactivex.internal.functions.Functions$p;
import io.reactivex.internal.functions.Functions$q;
import io.reactivex.internal.functions.Functions$r;
import io.reactivex.internal.functions.Functions$s;
import io.reactivex.internal.functions.Functions$t;
import io.reactivex.internal.functions.Functions$u;
import io.reactivex.internal.functions.Functions$v;
import io.reactivex.internal.functions.Functions$w;
import io.reactivex.internal.functions.Functions$x;
import io.reactivex.internal.functions.Functions$y;
import io.reactivex.internal.functions.Functions$z;
import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class Functions {
    public static final o a;
    public static final Runnable b;
    public static final a c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final q g;
    public static final r h;
    public static final r i;
    public static final Callable j;
    public static final Comparator k;
    public static final g l;

    static {
        Object object = new Functions$w();
        a = object;
        b = object = new Functions$r();
        c = object = new Functions$o();
        d = object = new Functions$p();
        e = object = new Functions$t();
        f = object = new Functions$f0();
        g = object = new Functions$q();
        h = object = new Functions$k0();
        i = object = new Functions$u();
        j = object = new Functions$e0();
        k = object = new Functions$a0();
        l = object = new Functions$z();
    }

    private Functions() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static o A(j j10) {
        e.a.w0.b.a.g(j10, "f is null");
        Functions$e functions$e = new Functions$e(j10);
        return functions$e;
    }

    public static o B(k k10) {
        e.a.w0.b.a.g(k10, "f is null");
        Functions$f functions$f = new Functions$f(k10);
        return functions$f;
    }

    public static o C(l l10) {
        e.a.w0.b.a.g(l10, "f is null");
        Functions$g functions$g = new Functions$g(l10);
        return functions$g;
    }

    public static o D(m m10) {
        e.a.w0.b.a.g(m10, "f is null");
        Functions$h functions$h = new Functions$h(m10);
        return functions$h;
    }

    public static o E(n n10) {
        e.a.w0.b.a.g(n10, "f is null");
        Functions$i functions$i = new Functions$i(n10);
        return functions$i;
    }

    public static b F(o o10) {
        Functions$h0 functions$h0 = new Functions$h0(o10);
        return functions$h0;
    }

    public static b G(o o10, o o11) {
        Functions$i0 functions$i0 = new Functions$i0(o11, o10);
        return functions$i0;
    }

    public static b H(o o10, o o11, o o12) {
        Functions$j0 functions$j0 = new Functions$j0(o12, o11, o10);
        return functions$j0;
    }

    public static g a(a a10) {
        Functions$a functions$a = new Functions$a(a10);
        return functions$a;
    }

    public static r b() {
        return i;
    }

    public static r c() {
        return h;
    }

    public static g d(int n10) {
        Functions$l functions$l = new Functions$l(n10);
        return functions$l;
    }

    public static o e(Class clazz) {
        Functions$m functions$m = new Functions$m(clazz);
        return functions$m;
    }

    public static Callable f(int n10) {
        Functions$j functions$j = new Functions$j(n10);
        return functions$j;
    }

    public static Callable g() {
        return Functions$HashSetCallable.INSTANCE;
    }

    public static g h() {
        return d;
    }

    public static r i(Object object) {
        Functions$s functions$s = new Functions$s(object);
        return functions$s;
    }

    public static a j(Future future) {
        Functions$v functions$v = new Functions$v(future);
        return functions$v;
    }

    public static o k() {
        return a;
    }

    public static r l(Class clazz) {
        Functions$n functions$n = new Functions$n(clazz);
        return functions$n;
    }

    public static Callable m(Object object) {
        Functions$x functions$x = new Functions$x(object);
        return functions$x;
    }

    public static o n(Object object) {
        Functions$x functions$x = new Functions$x(object);
        return functions$x;
    }

    public static o o(Comparator comparator) {
        Functions$y functions$y = new Functions$y(comparator);
        return functions$y;
    }

    public static Comparator p() {
        return Functions$NaturalComparator.INSTANCE;
    }

    public static Comparator q() {
        return k;
    }

    public static a r(g g10) {
        Functions$b0 functions$b0 = new Functions$b0(g10);
        return functions$b0;
    }

    public static g s(g g10) {
        Functions$c0 functions$c0 = new Functions$c0(g10);
        return functions$c0;
    }

    public static g t(g g10) {
        Functions$d0 functions$d0 = new Functions$d0(g10);
        return functions$d0;
    }

    public static Callable u() {
        return j;
    }

    public static r v(e e10) {
        Functions$k functions$k = new Functions$k(e10);
        return functions$k;
    }

    public static o w(TimeUnit timeUnit, h0 h02) {
        Functions$g0 functions$g0 = new Functions$g0(timeUnit, h02);
        return functions$g0;
    }

    public static o x(c c10) {
        e.a.w0.b.a.g(c10, "f is null");
        Functions$b functions$b = new Functions$b(c10);
        return functions$b;
    }

    public static o y(h h10) {
        e.a.w0.b.a.g(h10, "f is null");
        Functions$c functions$c = new Functions$c(h10);
        return functions$c;
    }

    public static o z(i i10) {
        e.a.w0.b.a.g(i10, "f is null");
        Functions$d functions$d = new Functions$d(i10);
        return functions$d;
    }
}

