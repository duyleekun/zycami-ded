/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

public final class Descriptors$DescriptorPool$SearchFilter
extends Enum {
    private static final /* synthetic */ Descriptors$DescriptorPool$SearchFilter[] $VALUES;
    public static final /* enum */ Descriptors$DescriptorPool$SearchFilter AGGREGATES_ONLY;
    public static final /* enum */ Descriptors$DescriptorPool$SearchFilter ALL_SYMBOLS;
    public static final /* enum */ Descriptors$DescriptorPool$SearchFilter TYPES_ONLY;

    static {
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter;
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter2;
        Descriptors$DescriptorPool$SearchFilter descriptors$DescriptorPool$SearchFilter3;
        TYPES_ONLY = descriptors$DescriptorPool$SearchFilter3 = new Descriptors$DescriptorPool$SearchFilter("TYPES_ONLY", 0);
        int n10 = 1;
        AGGREGATES_ONLY = descriptors$DescriptorPool$SearchFilter2 = new Descriptors$DescriptorPool$SearchFilter("AGGREGATES_ONLY", n10);
        int n11 = 2;
        ALL_SYMBOLS = descriptors$DescriptorPool$SearchFilter = new Descriptors$DescriptorPool$SearchFilter("ALL_SYMBOLS", n11);
        Descriptors$DescriptorPool$SearchFilter[] descriptors$DescriptorPool$SearchFilterArray = new Descriptors$DescriptorPool$SearchFilter[3];
        descriptors$DescriptorPool$SearchFilterArray[0] = descriptors$DescriptorPool$SearchFilter3;
        descriptors$DescriptorPool$SearchFilterArray[n10] = descriptors$DescriptorPool$SearchFilter2;
        descriptors$DescriptorPool$SearchFilterArray[n11] = descriptors$DescriptorPool$SearchFilter;
        $VALUES = descriptors$DescriptorPool$SearchFilterArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Descriptors$DescriptorPool$SearchFilter() {
        void var2_-1;
        void var1_-1;
    }

    public static Descriptors$DescriptorPool$SearchFilter valueOf(String string2) {
        return Enum.valueOf(Descriptors$DescriptorPool$SearchFilter.class, string2);
    }

    public static Descriptors$DescriptorPool$SearchFilter[] values() {
        return (Descriptors$DescriptorPool$SearchFilter[])$VALUES.clone();
    }
}

