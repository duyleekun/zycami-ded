/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public final class Funnels$LongFunnel
extends Enum
implements Funnel {
    private static final /* synthetic */ Funnels$LongFunnel[] $VALUES;
    public static final /* enum */ Funnels$LongFunnel INSTANCE;

    static {
        Funnels$LongFunnel funnels$LongFunnel;
        INSTANCE = funnels$LongFunnel = new Funnels$LongFunnel("INSTANCE", 0);
        Funnels$LongFunnel[] funnels$LongFunnelArray = new Funnels$LongFunnel[]{funnels$LongFunnel};
        $VALUES = funnels$LongFunnelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Funnels$LongFunnel() {
        void var2_-1;
        void var1_-1;
    }

    public static Funnels$LongFunnel valueOf(String string2) {
        return Enum.valueOf(Funnels$LongFunnel.class, string2);
    }

    public static Funnels$LongFunnel[] values() {
        return (Funnels$LongFunnel[])$VALUES.clone();
    }

    public void funnel(Long l10, PrimitiveSink primitiveSink) {
        long l11 = l10;
        primitiveSink.putLong(l11);
    }

    public String toString() {
        return "Funnels.longFunnel()";
    }
}

