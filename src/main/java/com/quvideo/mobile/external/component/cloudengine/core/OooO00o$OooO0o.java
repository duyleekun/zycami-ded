/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.core;

public final class OooO00o$OooO0o
extends Enum {
    public static final /* enum */ OooO00o$OooO0o FAILURE;
    public static final /* enum */ OooO00o$OooO0o IDEL;
    public static final /* enum */ OooO00o$OooO0o INITING;
    public static final /* enum */ OooO00o$OooO0o SUCCESS;
    private static final /* synthetic */ OooO00o$OooO0o[] a;

    static {
        OooO00o$OooO0o oooO00o$OooO0o;
        OooO00o$OooO0o oooO00o$OooO0o2;
        OooO00o$OooO0o oooO00o$OooO0o3;
        OooO00o$OooO0o oooO00o$OooO0o4;
        IDEL = oooO00o$OooO0o4 = new OooO00o$OooO0o("IDEL", 0);
        int n10 = 1;
        INITING = oooO00o$OooO0o3 = new OooO00o$OooO0o("INITING", n10);
        int n11 = 2;
        SUCCESS = oooO00o$OooO0o2 = new OooO00o$OooO0o("SUCCESS", n11);
        int n12 = 3;
        FAILURE = oooO00o$OooO0o = new OooO00o$OooO0o("FAILURE", n12);
        OooO00o$OooO0o[] oooO00o$OooO0oArray = new OooO00o$OooO0o[4];
        oooO00o$OooO0oArray[0] = oooO00o$OooO0o4;
        oooO00o$OooO0oArray[n10] = oooO00o$OooO0o3;
        oooO00o$OooO0oArray[n11] = oooO00o$OooO0o2;
        oooO00o$OooO0oArray[n12] = oooO00o$OooO0o;
        a = oooO00o$OooO0oArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OooO00o$OooO0o() {
        void var2_-1;
        void var1_-1;
    }

    public static OooO00o$OooO0o valueOf(String string2) {
        return Enum.valueOf(OooO00o$OooO0o.class, string2);
    }

    public static OooO00o$OooO0o[] values() {
        return (OooO00o$OooO0o[])a.clone();
    }
}

