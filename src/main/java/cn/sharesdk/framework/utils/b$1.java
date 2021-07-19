/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils;

import cn.sharesdk.framework.utils.b$a;

public class b$1 {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        b$a b$a;
        int n12 = b$a.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            b$a = b$a.a;
            n11 = b$a.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            b$a = b$a.b;
            n11 = b$a.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

