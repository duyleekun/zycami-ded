/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure1V;

public class Closure$Result {
    private Object res;
    private Throwable t;

    public static /* synthetic */ Object access$002(Closure$Result closure$Result, Object object) {
        closure$Result.res = object;
        return object;
    }

    public static /* synthetic */ Throwable access$102(Closure$Result closure$Result, Throwable throwable) {
        closure$Result.t = throwable;
        return throwable;
    }

    public Throwable error() {
        return this.t;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onError(Closure$IClosure1V closure$IClosure1V) {
        Throwable throwable = this.t;
        if (throwable == null) return;
        if (closure$IClosure1V == null) return;
        try {
            closure$IClosure1V.call(throwable);
            return;
        }
        catch (Throwable throwable2) {
            return;
        }
    }

    public void printError() {
        Throwable throwable = this.t;
        if (throwable != null) {
            throwable.printStackTrace();
        }
    }

    public Object result() {
        return this.res;
    }

    public void throwError() {
        Throwable throwable = this.t;
        if (throwable == null) {
            return;
        }
        Throwable throwable2 = this.t;
        throwable = new RuntimeException(throwable2);
        throw throwable;
    }
}

