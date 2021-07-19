/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.g;
import i.g.e;

public final class FlowableInternalHelper$RequestMax
extends Enum
implements g {
    public static final /* enum */ FlowableInternalHelper$RequestMax INSTANCE;
    private static final /* synthetic */ FlowableInternalHelper$RequestMax[] a;

    static {
        FlowableInternalHelper$RequestMax flowableInternalHelper$RequestMax;
        INSTANCE = flowableInternalHelper$RequestMax = new FlowableInternalHelper$RequestMax("INSTANCE", 0);
        FlowableInternalHelper$RequestMax[] flowableInternalHelper$RequestMaxArray = new FlowableInternalHelper$RequestMax[]{flowableInternalHelper$RequestMax};
        a = flowableInternalHelper$RequestMaxArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FlowableInternalHelper$RequestMax() {
        void var2_-1;
        void var1_-1;
    }

    public static FlowableInternalHelper$RequestMax valueOf(String string2) {
        return Enum.valueOf(FlowableInternalHelper$RequestMax.class, string2);
    }

    public static FlowableInternalHelper$RequestMax[] values() {
        return (FlowableInternalHelper$RequestMax[])a.clone();
    }

    public void accept(e e10) {
        e10.request(Long.MAX_VALUE);
    }
}

