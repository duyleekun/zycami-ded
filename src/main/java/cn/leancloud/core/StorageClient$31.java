/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVQuery$CachePolicy;

public class StorageClient$31 {
    public static final /* synthetic */ int[] $SwitchMap$cn$leancloud$AVQuery$CachePolicy;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        AVQuery$CachePolicy aVQuery$CachePolicy;
        int n12 = AVQuery$CachePolicy.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$cn$leancloud$AVQuery$CachePolicy = nArray;
        try {
            aVQuery$CachePolicy = AVQuery$CachePolicy.CACHE_ONLY;
            n11 = aVQuery$CachePolicy.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVQuery$CachePolicy;
            aVQuery$CachePolicy = AVQuery$CachePolicy.CACHE_ELSE_NETWORK;
            n11 = aVQuery$CachePolicy.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVQuery$CachePolicy;
            aVQuery$CachePolicy = AVQuery$CachePolicy.NETWORK_ELSE_CACHE;
            n11 = aVQuery$CachePolicy.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$cn$leancloud$AVQuery$CachePolicy;
            aVQuery$CachePolicy = AVQuery$CachePolicy.IGNORE_CACHE;
            n11 = aVQuery$CachePolicy.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

