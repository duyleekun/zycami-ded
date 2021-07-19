/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.g0;
import e.a.h0;
import e.a.v0.a;
import e.a.v0.b;
import e.a.v0.c;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$a;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$b;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$c;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$e;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$f;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$g;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$h;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$i;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$j;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$k;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$l;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$m;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$n;
import io.reactivex.internal.operators.observable.ObservableInternalHelper$o;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {
    private ObservableInternalHelper() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static o a(o o10) {
        ObservableInternalHelper$c observableInternalHelper$c = new ObservableInternalHelper$c(o10);
        return observableInternalHelper$c;
    }

    public static o b(o o10, c c10) {
        ObservableInternalHelper$e observableInternalHelper$e = new ObservableInternalHelper$e(c10, o10);
        return observableInternalHelper$e;
    }

    public static o c(o o10) {
        ObservableInternalHelper$f observableInternalHelper$f = new ObservableInternalHelper$f(o10);
        return observableInternalHelper$f;
    }

    public static a d(g0 g02) {
        ObservableInternalHelper$g observableInternalHelper$g = new ObservableInternalHelper$g(g02);
        return observableInternalHelper$g;
    }

    public static g e(g0 g02) {
        ObservableInternalHelper$h observableInternalHelper$h = new ObservableInternalHelper$h(g02);
        return observableInternalHelper$h;
    }

    public static g f(g0 g02) {
        ObservableInternalHelper$i observableInternalHelper$i = new ObservableInternalHelper$i(g02);
        return observableInternalHelper$i;
    }

    public static Callable g(z z10) {
        ObservableInternalHelper$j observableInternalHelper$j = new ObservableInternalHelper$j(z10);
        return observableInternalHelper$j;
    }

    public static Callable h(z z10, int n10) {
        ObservableInternalHelper$a observableInternalHelper$a = new ObservableInternalHelper$a(z10, n10);
        return observableInternalHelper$a;
    }

    public static Callable i(z z10, int n10, long l10, TimeUnit timeUnit, h0 h02) {
        ObservableInternalHelper$b observableInternalHelper$b = new ObservableInternalHelper$b(z10, n10, l10, timeUnit, h02);
        return observableInternalHelper$b;
    }

    public static Callable j(z z10, long l10, TimeUnit timeUnit, h0 h02) {
        ObservableInternalHelper$n observableInternalHelper$n = new ObservableInternalHelper$n(z10, l10, timeUnit, h02);
        return observableInternalHelper$n;
    }

    public static o k(o o10, h0 h02) {
        ObservableInternalHelper$k observableInternalHelper$k = new ObservableInternalHelper$k(o10, h02);
        return observableInternalHelper$k;
    }

    public static c l(b b10) {
        ObservableInternalHelper$l observableInternalHelper$l = new ObservableInternalHelper$l(b10);
        return observableInternalHelper$l;
    }

    public static c m(g g10) {
        ObservableInternalHelper$m observableInternalHelper$m = new ObservableInternalHelper$m(g10);
        return observableInternalHelper$m;
    }

    public static o n(o o10) {
        ObservableInternalHelper$o observableInternalHelper$o = new ObservableInternalHelper$o(o10);
        return observableInternalHelper$o;
    }
}

