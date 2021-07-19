/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.image;

public final class Images$ResourceType
extends Enum {
    public static final /* enum */ Images$ResourceType BITMAP;
    public static final /* enum */ Images$ResourceType DRAWABLE;
    public static final /* enum */ Images$ResourceType GIT;
    private static final /* synthetic */ Images$ResourceType[] a;

    static {
        Images$ResourceType images$ResourceType;
        Images$ResourceType images$ResourceType2;
        Images$ResourceType images$ResourceType3;
        GIT = images$ResourceType3 = new Images$ResourceType("GIT", 0);
        int n10 = 1;
        BITMAP = images$ResourceType2 = new Images$ResourceType("BITMAP", n10);
        int n11 = 2;
        DRAWABLE = images$ResourceType = new Images$ResourceType("DRAWABLE", n11);
        Images$ResourceType[] images$ResourceTypeArray = new Images$ResourceType[3];
        images$ResourceTypeArray[0] = images$ResourceType3;
        images$ResourceTypeArray[n10] = images$ResourceType2;
        images$ResourceTypeArray[n11] = images$ResourceType;
        a = images$ResourceTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Images$ResourceType() {
        void var2_-1;
        void var1_-1;
    }

    public static Images$ResourceType valueOf(String string2) {
        return Enum.valueOf(Images$ResourceType.class, string2);
    }

    public static Images$ResourceType[] values() {
        return (Images$ResourceType[])a.clone();
    }
}

