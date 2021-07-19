/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.v0.o;

public final class ObservableInternalHelper$MapToInt
extends Enum
implements o {
    public static final /* enum */ ObservableInternalHelper$MapToInt INSTANCE;
    private static final /* synthetic */ ObservableInternalHelper$MapToInt[] a;

    static {
        ObservableInternalHelper$MapToInt observableInternalHelper$MapToInt;
        INSTANCE = observableInternalHelper$MapToInt = new ObservableInternalHelper$MapToInt("INSTANCE", 0);
        ObservableInternalHelper$MapToInt[] observableInternalHelper$MapToIntArray = new ObservableInternalHelper$MapToInt[]{observableInternalHelper$MapToInt};
        a = observableInternalHelper$MapToIntArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ObservableInternalHelper$MapToInt() {
        void var2_-1;
        void var1_-1;
    }

    public static ObservableInternalHelper$MapToInt valueOf(String string2) {
        return Enum.valueOf(ObservableInternalHelper$MapToInt.class, string2);
    }

    public static ObservableInternalHelper$MapToInt[] values() {
        return (ObservableInternalHelper$MapToInt[])a.clone();
    }

    public Object apply(Object object) {
        return 0;
    }
}

