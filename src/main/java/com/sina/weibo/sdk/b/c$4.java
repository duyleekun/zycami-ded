/*
 * Decompiled with CFR 0.151.
 */
package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.b.c$b;

public final class c$4 {
    public static final /* synthetic */ int[] W;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        int[] nArray;
        block6: {
            int n12 = c$b.p().length;
            nArray = new int[n12];
            W = nArray;
            n11 = 1;
            try {
                n10 = c$b.aa - n11;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                break block6;
            }
            {
                nArray[n10] = n11;
            }
        }
        try {
            nArray = W;
            n10 = c$b.ab - n11;
            n11 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
        {
            nArray[n10] = n11;
            return;
        }
    }
}

