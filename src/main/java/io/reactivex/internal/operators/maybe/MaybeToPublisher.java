/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.v0.o;
import e.a.w;
import i.g.c;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;

public final class MaybeToPublisher
extends Enum
implements o {
    public static final /* enum */ MaybeToPublisher INSTANCE;
    private static final /* synthetic */ MaybeToPublisher[] a;

    static {
        MaybeToPublisher maybeToPublisher;
        INSTANCE = maybeToPublisher = new MaybeToPublisher("INSTANCE", 0);
        MaybeToPublisher[] maybeToPublisherArray = new MaybeToPublisher[]{maybeToPublisher};
        a = maybeToPublisherArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MaybeToPublisher() {
        void var2_-1;
        void var1_-1;
    }

    public static o instance() {
        return INSTANCE;
    }

    public static MaybeToPublisher valueOf(String string2) {
        return Enum.valueOf(MaybeToPublisher.class, string2);
    }

    public static MaybeToPublisher[] values() {
        return (MaybeToPublisher[])a.clone();
    }

    public c apply(w w10) {
        MaybeToFlowable maybeToFlowable = new MaybeToFlowable(w10);
        return maybeToFlowable;
    }
}

