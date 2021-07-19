/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide;

public final class MemoryCategory
extends Enum {
    public static final /* enum */ MemoryCategory HIGH;
    public static final /* enum */ MemoryCategory LOW;
    public static final /* enum */ MemoryCategory NORMAL;
    private static final /* synthetic */ MemoryCategory[] a;
    private final float multiplier;

    static {
        MemoryCategory memoryCategory;
        MemoryCategory memoryCategory2;
        MemoryCategory memoryCategory3;
        LOW = memoryCategory3 = new MemoryCategory("LOW", 0, 0.5f);
        int n10 = 1;
        NORMAL = memoryCategory2 = new MemoryCategory("NORMAL", n10, 1.0f);
        int n11 = 2;
        HIGH = memoryCategory = new MemoryCategory("HIGH", n11, 1.5f);
        MemoryCategory[] memoryCategoryArray = new MemoryCategory[3];
        memoryCategoryArray[0] = memoryCategory3;
        memoryCategoryArray[n10] = memoryCategory2;
        memoryCategoryArray[n11] = memoryCategory;
        a = memoryCategoryArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MemoryCategory() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.multiplier = var3_1;
    }

    public static MemoryCategory valueOf(String string2) {
        return Enum.valueOf(MemoryCategory.class, string2);
    }

    public static MemoryCategory[] values() {
        return (MemoryCategory[])a.clone();
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}

