/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.set.privacy;

import com.zhiyun.account.data.NetworkState$Status;

public class BindThirdFragment$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        NetworkState$Status networkState$Status;
        int n12 = NetworkState$Status.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            networkState$Status = NetworkState$Status.RUNNING;
            n11 = networkState$Status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            networkState$Status = NetworkState$Status.SUCCESS;
            n11 = networkState$Status.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            networkState$Status = NetworkState$Status.FAILED;
            n11 = networkState$Status.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

