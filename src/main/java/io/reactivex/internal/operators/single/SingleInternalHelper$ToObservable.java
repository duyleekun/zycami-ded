/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.o0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.internal.operators.single.SingleToObservable;

public final class SingleInternalHelper$ToObservable
extends Enum
implements o {
    public static final /* enum */ SingleInternalHelper$ToObservable INSTANCE;
    private static final /* synthetic */ SingleInternalHelper$ToObservable[] a;

    static {
        SingleInternalHelper$ToObservable singleInternalHelper$ToObservable;
        INSTANCE = singleInternalHelper$ToObservable = new SingleInternalHelper$ToObservable("INSTANCE", 0);
        SingleInternalHelper$ToObservable[] singleInternalHelper$ToObservableArray = new SingleInternalHelper$ToObservable[]{singleInternalHelper$ToObservable};
        a = singleInternalHelper$ToObservableArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SingleInternalHelper$ToObservable() {
        void var2_-1;
        void var1_-1;
    }

    public static SingleInternalHelper$ToObservable valueOf(String string2) {
        return Enum.valueOf(SingleInternalHelper$ToObservable.class, string2);
    }

    public static SingleInternalHelper$ToObservable[] values() {
        return (SingleInternalHelper$ToObservable[])a.clone();
    }

    public z apply(o0 o02) {
        SingleToObservable singleToObservable = new SingleToObservable(o02);
        return singleToObservable;
    }
}

