/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

public final class c$b
extends Enum {
    public static final /* enum */ int Z = 1;
    public static final /* enum */ int aa = 2;
    public static final /* enum */ int ab = 3;
    private static final /* synthetic */ int[] ac;

    static {
        int n10;
        int n11;
        int n12 = 3;
        int[] nArray = new int[n12];
        nArray[0] = n11 = 1;
        nArray[n11] = n10 = 2;
        nArray[n10] = n12;
        ac = nArray;
    }

    public static int[] p() {
        return (int[])ac.clone();
    }
}

