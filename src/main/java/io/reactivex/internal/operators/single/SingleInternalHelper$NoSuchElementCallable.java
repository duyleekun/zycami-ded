/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;

public final class SingleInternalHelper$NoSuchElementCallable
extends Enum
implements Callable {
    public static final /* enum */ SingleInternalHelper$NoSuchElementCallable INSTANCE;
    private static final /* synthetic */ SingleInternalHelper$NoSuchElementCallable[] a;

    static {
        SingleInternalHelper$NoSuchElementCallable singleInternalHelper$NoSuchElementCallable;
        INSTANCE = singleInternalHelper$NoSuchElementCallable = new SingleInternalHelper$NoSuchElementCallable("INSTANCE", 0);
        SingleInternalHelper$NoSuchElementCallable[] singleInternalHelper$NoSuchElementCallableArray = new SingleInternalHelper$NoSuchElementCallable[]{singleInternalHelper$NoSuchElementCallable};
        a = singleInternalHelper$NoSuchElementCallableArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SingleInternalHelper$NoSuchElementCallable() {
        void var2_-1;
        void var1_-1;
    }

    public static SingleInternalHelper$NoSuchElementCallable valueOf(String string2) {
        return Enum.valueOf(SingleInternalHelper$NoSuchElementCallable.class, string2);
    }

    public static SingleInternalHelper$NoSuchElementCallable[] values() {
        return (SingleInternalHelper$NoSuchElementCallable[])a.clone();
    }

    public NoSuchElementException call() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        return noSuchElementException;
    }
}

