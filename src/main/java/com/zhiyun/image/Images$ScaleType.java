/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.image;

public final class Images$ScaleType
extends Enum {
    public static final /* enum */ Images$ScaleType CENTER_CROP;
    public static final /* enum */ Images$ScaleType CENTER_INSIDE;
    public static final /* enum */ Images$ScaleType FIT_CENTER;
    private static final /* synthetic */ Images$ScaleType[] a;

    static {
        Images$ScaleType images$ScaleType;
        Images$ScaleType images$ScaleType2;
        Images$ScaleType images$ScaleType3;
        CENTER_CROP = images$ScaleType3 = new Images$ScaleType("CENTER_CROP", 0);
        int n10 = 1;
        FIT_CENTER = images$ScaleType2 = new Images$ScaleType("FIT_CENTER", n10);
        int n11 = 2;
        CENTER_INSIDE = images$ScaleType = new Images$ScaleType("CENTER_INSIDE", n11);
        Images$ScaleType[] images$ScaleTypeArray = new Images$ScaleType[3];
        images$ScaleTypeArray[0] = images$ScaleType3;
        images$ScaleTypeArray[n10] = images$ScaleType2;
        images$ScaleTypeArray[n11] = images$ScaleType;
        a = images$ScaleTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Images$ScaleType() {
        void var2_-1;
        void var1_-1;
    }

    public static Images$ScaleType valueOf(String string2) {
        return Enum.valueOf(Images$ScaleType.class, string2);
    }

    public static Images$ScaleType[] values() {
        return (Images$ScaleType[])a.clone();
    }
}

