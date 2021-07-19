/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVQuery$CachePolicy
extends Enum {
    private static final /* synthetic */ AVQuery$CachePolicy[] $VALUES;
    public static final /* enum */ AVQuery$CachePolicy CACHE_ELSE_NETWORK;
    public static final /* enum */ AVQuery$CachePolicy CACHE_ONLY;
    public static final /* enum */ AVQuery$CachePolicy CACHE_THEN_NETWORK;
    public static final /* enum */ AVQuery$CachePolicy IGNORE_CACHE;
    public static final /* enum */ AVQuery$CachePolicy NETWORK_ELSE_CACHE;
    public static final /* enum */ AVQuery$CachePolicy NETWORK_ONLY;

    static {
        AVQuery$CachePolicy aVQuery$CachePolicy;
        AVQuery$CachePolicy aVQuery$CachePolicy2;
        AVQuery$CachePolicy aVQuery$CachePolicy3;
        AVQuery$CachePolicy aVQuery$CachePolicy4;
        AVQuery$CachePolicy aVQuery$CachePolicy5;
        AVQuery$CachePolicy aVQuery$CachePolicy6;
        CACHE_ELSE_NETWORK = aVQuery$CachePolicy6 = new AVQuery$CachePolicy("CACHE_ELSE_NETWORK", 0);
        int n10 = 1;
        CACHE_ONLY = aVQuery$CachePolicy5 = new AVQuery$CachePolicy("CACHE_ONLY", n10);
        int n11 = 2;
        CACHE_THEN_NETWORK = aVQuery$CachePolicy4 = new AVQuery$CachePolicy("CACHE_THEN_NETWORK", n11);
        int n12 = 3;
        IGNORE_CACHE = aVQuery$CachePolicy3 = new AVQuery$CachePolicy("IGNORE_CACHE", n12);
        int n13 = 4;
        NETWORK_ELSE_CACHE = aVQuery$CachePolicy2 = new AVQuery$CachePolicy("NETWORK_ELSE_CACHE", n13);
        int n14 = 5;
        NETWORK_ONLY = aVQuery$CachePolicy = new AVQuery$CachePolicy("NETWORK_ONLY", n14);
        AVQuery$CachePolicy[] aVQuery$CachePolicyArray = new AVQuery$CachePolicy[6];
        aVQuery$CachePolicyArray[0] = aVQuery$CachePolicy6;
        aVQuery$CachePolicyArray[n10] = aVQuery$CachePolicy5;
        aVQuery$CachePolicyArray[n11] = aVQuery$CachePolicy4;
        aVQuery$CachePolicyArray[n12] = aVQuery$CachePolicy3;
        aVQuery$CachePolicyArray[n13] = aVQuery$CachePolicy2;
        aVQuery$CachePolicyArray[n14] = aVQuery$CachePolicy;
        $VALUES = aVQuery$CachePolicyArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVQuery$CachePolicy() {
        void var2_-1;
        void var1_-1;
    }

    public static AVQuery$CachePolicy valueOf(String string2) {
        return Enum.valueOf(AVQuery$CachePolicy.class, string2);
    }

    public static AVQuery$CachePolicy[] values() {
        return (AVQuery$CachePolicy[])$VALUES.clone();
    }
}

