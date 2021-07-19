/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public final class ab
extends Enum {
    public static final /* enum */ ab CRASH;
    public static final /* enum */ ab ERROR;
    public static final /* enum */ ab NETWORK;
    public static final /* enum */ ab NORMAL;
    public static final /* enum */ ab USER;
    private static final /* synthetic */ ab[] a;
    public int flag;

    static {
        ab ab2;
        ab ab3;
        ab ab4;
        ab ab5;
        ab ab6;
        NORMAL = ab6 = new ab("NORMAL", 0, 0);
        int n10 = 1;
        NETWORK = ab5 = new ab("NETWORK", n10, n10);
        int n11 = 2;
        USER = ab4 = new ab("USER", n11, n11);
        int n12 = 3;
        CRASH = ab3 = new ab("CRASH", n12, n12);
        int n13 = 4;
        ERROR = ab2 = new ab("ERROR", n13, n13);
        ab[] abArray = new ab[5];
        abArray[0] = ab6;
        abArray[n10] = ab5;
        abArray[n11] = ab4;
        abArray[n12] = ab3;
        abArray[n13] = ab2;
        a = abArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ab() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.flag = var3_1;
    }

    public static ab valueOf(String string2) {
        return Enum.valueOf(ab.class, string2);
    }

    public static ab[] values() {
        return (ab[])a.clone();
    }
}

