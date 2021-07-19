/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.annotations;

public final class BackpressureKind
extends Enum {
    public static final /* enum */ BackpressureKind ERROR;
    public static final /* enum */ BackpressureKind FULL;
    public static final /* enum */ BackpressureKind NONE;
    public static final /* enum */ BackpressureKind PASS_THROUGH;
    public static final /* enum */ BackpressureKind SPECIAL;
    public static final /* enum */ BackpressureKind UNBOUNDED_IN;
    private static final /* synthetic */ BackpressureKind[] a;

    static {
        BackpressureKind backpressureKind;
        BackpressureKind backpressureKind2;
        BackpressureKind backpressureKind3;
        BackpressureKind backpressureKind4;
        BackpressureKind backpressureKind5;
        BackpressureKind backpressureKind6;
        PASS_THROUGH = backpressureKind6 = new BackpressureKind("PASS_THROUGH", 0);
        int n10 = 1;
        FULL = backpressureKind5 = new BackpressureKind("FULL", n10);
        int n11 = 2;
        SPECIAL = backpressureKind4 = new BackpressureKind("SPECIAL", n11);
        int n12 = 3;
        UNBOUNDED_IN = backpressureKind3 = new BackpressureKind("UNBOUNDED_IN", n12);
        int n13 = 4;
        ERROR = backpressureKind2 = new BackpressureKind("ERROR", n13);
        int n14 = 5;
        NONE = backpressureKind = new BackpressureKind("NONE", n14);
        BackpressureKind[] backpressureKindArray = new BackpressureKind[6];
        backpressureKindArray[0] = backpressureKind6;
        backpressureKindArray[n10] = backpressureKind5;
        backpressureKindArray[n11] = backpressureKind4;
        backpressureKindArray[n12] = backpressureKind3;
        backpressureKindArray[n13] = backpressureKind2;
        backpressureKindArray[n14] = backpressureKind;
        a = backpressureKindArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BackpressureKind() {
        void var2_-1;
        void var1_-1;
    }

    public static BackpressureKind valueOf(String string2) {
        return Enum.valueOf(BackpressureKind.class, string2);
    }

    public static BackpressureKind[] values() {
        return (BackpressureKind[])a.clone();
    }
}

