/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.disposables;

import e.a.d;
import e.a.g0;
import e.a.l0;
import e.a.t;
import e.a.w0.c.j;

public final class EmptyDisposable
extends Enum
implements j {
    public static final /* enum */ EmptyDisposable INSTANCE;
    public static final /* enum */ EmptyDisposable NEVER;
    private static final /* synthetic */ EmptyDisposable[] a;

    static {
        EmptyDisposable emptyDisposable;
        EmptyDisposable emptyDisposable2;
        INSTANCE = emptyDisposable2 = new EmptyDisposable("INSTANCE", 0);
        int n10 = 1;
        NEVER = emptyDisposable = new EmptyDisposable("NEVER", n10);
        EmptyDisposable[] emptyDisposableArray = new EmptyDisposable[2];
        emptyDisposableArray[0] = emptyDisposable2;
        emptyDisposableArray[n10] = emptyDisposable;
        a = emptyDisposableArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private EmptyDisposable() {
        void var2_-1;
        void var1_-1;
    }

    public static void complete(d d10) {
        EmptyDisposable emptyDisposable = INSTANCE;
        d10.onSubscribe(emptyDisposable);
        d10.onComplete();
    }

    public static void complete(g0 g02) {
        EmptyDisposable emptyDisposable = INSTANCE;
        g02.onSubscribe(emptyDisposable);
        g02.onComplete();
    }

    public static void complete(t t10) {
        EmptyDisposable emptyDisposable = INSTANCE;
        t10.onSubscribe(emptyDisposable);
        t10.onComplete();
    }

    public static void error(Throwable throwable, d d10) {
        EmptyDisposable emptyDisposable = INSTANCE;
        d10.onSubscribe(emptyDisposable);
        d10.onError(throwable);
    }

    public static void error(Throwable throwable, g0 g02) {
        EmptyDisposable emptyDisposable = INSTANCE;
        g02.onSubscribe(emptyDisposable);
        g02.onError(throwable);
    }

    public static void error(Throwable throwable, l0 l02) {
        EmptyDisposable emptyDisposable = INSTANCE;
        l02.onSubscribe(emptyDisposable);
        l02.onError(throwable);
    }

    public static void error(Throwable throwable, t t10) {
        EmptyDisposable emptyDisposable = INSTANCE;
        t10.onSubscribe(emptyDisposable);
        t10.onError(throwable);
    }

    public static EmptyDisposable valueOf(String string2) {
        return Enum.valueOf(EmptyDisposable.class, string2);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[])a.clone();
    }

    public void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        boolean bl2;
        EmptyDisposable emptyDisposable = INSTANCE;
        if (this == emptyDisposable) {
            bl2 = true;
        } else {
            bl2 = false;
            emptyDisposable = null;
        }
        return bl2;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object object) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public boolean offer(Object object, Object object2) {
        object = new UnsupportedOperationException("Should not be called!");
        throw object;
    }

    public Object poll() {
        return null;
    }

    public int requestFusion(int n10) {
        return n10 & 2;
    }
}

