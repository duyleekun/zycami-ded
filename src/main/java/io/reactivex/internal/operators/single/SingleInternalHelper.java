/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.v0.o;
import io.reactivex.internal.operators.single.SingleInternalHelper$NoSuchElementCallable;
import io.reactivex.internal.operators.single.SingleInternalHelper$ToFlowable;
import io.reactivex.internal.operators.single.SingleInternalHelper$ToObservable;
import io.reactivex.internal.operators.single.SingleInternalHelper$a;
import java.util.concurrent.Callable;

public final class SingleInternalHelper {
    private SingleInternalHelper() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static Callable a() {
        return SingleInternalHelper$NoSuchElementCallable.INSTANCE;
    }

    public static Iterable b(Iterable iterable) {
        SingleInternalHelper$a singleInternalHelper$a = new SingleInternalHelper$a(iterable);
        return singleInternalHelper$a;
    }

    public static o c() {
        return SingleInternalHelper$ToFlowable.INSTANCE;
    }

    public static o d() {
        return SingleInternalHelper$ToObservable.INSTANCE;
    }
}

