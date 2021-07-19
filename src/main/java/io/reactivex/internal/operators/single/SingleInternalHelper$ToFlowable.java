/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.o0;
import e.a.v0.o;
import i.g.c;
import io.reactivex.internal.operators.single.SingleToFlowable;

public final class SingleInternalHelper$ToFlowable
extends Enum
implements o {
    public static final /* enum */ SingleInternalHelper$ToFlowable INSTANCE;
    private static final /* synthetic */ SingleInternalHelper$ToFlowable[] a;

    static {
        SingleInternalHelper$ToFlowable singleInternalHelper$ToFlowable;
        INSTANCE = singleInternalHelper$ToFlowable = new SingleInternalHelper$ToFlowable("INSTANCE", 0);
        SingleInternalHelper$ToFlowable[] singleInternalHelper$ToFlowableArray = new SingleInternalHelper$ToFlowable[]{singleInternalHelper$ToFlowable};
        a = singleInternalHelper$ToFlowableArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SingleInternalHelper$ToFlowable() {
        void var2_-1;
        void var1_-1;
    }

    public static SingleInternalHelper$ToFlowable valueOf(String string2) {
        return Enum.valueOf(SingleInternalHelper$ToFlowable.class, string2);
    }

    public static SingleInternalHelper$ToFlowable[] values() {
        return (SingleInternalHelper$ToFlowable[])a.clone();
    }

    public c apply(o0 o02) {
        SingleToFlowable singleToFlowable = new SingleToFlowable(o02);
        return singleToFlowable;
    }
}

