/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.httpcore.country;

public final class OooO0O0$OooO00o
extends Enum {
    private static final /* synthetic */ OooO0O0$OooO00o[] $VALUES;
    public static final /* enum */ OooO0O0$OooO00o IP;
    public static final /* enum */ OooO0O0$OooO00o LOCALE;
    public static final /* enum */ OooO0O0$OooO00o SIM;
    public static final /* enum */ OooO0O0$OooO00o USER;

    static {
        OooO0O0$OooO00o oooO0O0$OooO00o;
        OooO0O0$OooO00o oooO0O0$OooO00o2;
        OooO0O0$OooO00o oooO0O0$OooO00o3;
        OooO0O0$OooO00o oooO0O0$OooO00o4;
        USER = oooO0O0$OooO00o4 = new OooO0O0$OooO00o("USER", 0);
        int n10 = 1;
        SIM = oooO0O0$OooO00o3 = new OooO0O0$OooO00o("SIM", n10);
        int n11 = 2;
        IP = oooO0O0$OooO00o2 = new OooO0O0$OooO00o("IP", n11);
        int n12 = 3;
        LOCALE = oooO0O0$OooO00o = new OooO0O0$OooO00o("LOCALE", n12);
        OooO0O0$OooO00o[] oooO0O0$OooO00oArray = new OooO0O0$OooO00o[4];
        oooO0O0$OooO00oArray[0] = oooO0O0$OooO00o4;
        oooO0O0$OooO00oArray[n10] = oooO0O0$OooO00o3;
        oooO0O0$OooO00oArray[n11] = oooO0O0$OooO00o2;
        oooO0O0$OooO00oArray[n12] = oooO0O0$OooO00o;
        $VALUES = oooO0O0$OooO00oArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OooO0O0$OooO00o() {
        void var2_-1;
        void var1_-1;
    }

    public static OooO0O0$OooO00o valueOf(String string2) {
        return Enum.valueOf(OooO0O0$OooO00o.class, string2);
    }

    public static OooO0O0$OooO00o[] values() {
        return (OooO0O0$OooO00o[])$VALUES.clone();
    }
}

