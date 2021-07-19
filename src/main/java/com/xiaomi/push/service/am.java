/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.hs;
import com.xiaomi.push.ht;

public class am {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object;
        int n13 = ht.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object = ht.a;
            n12 = ((Enum)object).ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object = b;
            enum_ = ht.b;
            n11 = enum_.ordinal();
            object[n11] = (ht)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = ht.c;
            n11 = enum_.ordinal();
            n10 = 3;
            object[n11] = (ht)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = ht.d;
            n11 = enum_.ordinal();
            n10 = 4;
            object[n11] = (ht)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = hs.values().length;
        object = new int[n12];
        a = (int[])object;
        try {
            enum_ = hs.a;
            n11 = enum_.ordinal();
            object[n11] = (ht)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            int[] nArray2 = a;
            object = hs.b;
            n12 = ((Enum)object).ordinal();
            nArray2[n12] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

