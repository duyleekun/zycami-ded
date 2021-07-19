/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

public final class Layer$MatteType
extends Enum {
    private static final /* synthetic */ Layer$MatteType[] $VALUES;
    public static final /* enum */ Layer$MatteType ADD;
    public static final /* enum */ Layer$MatteType INVERT;
    public static final /* enum */ Layer$MatteType LUMA;
    public static final /* enum */ Layer$MatteType LUMA_INVERTED;
    public static final /* enum */ Layer$MatteType NONE;
    public static final /* enum */ Layer$MatteType UNKNOWN;

    static {
        Layer$MatteType layer$MatteType;
        Layer$MatteType layer$MatteType2;
        Layer$MatteType layer$MatteType3;
        Layer$MatteType layer$MatteType4;
        Layer$MatteType layer$MatteType5;
        Layer$MatteType layer$MatteType6;
        NONE = layer$MatteType6 = new Layer$MatteType("NONE", 0);
        int n10 = 1;
        ADD = layer$MatteType5 = new Layer$MatteType("ADD", n10);
        int n11 = 2;
        INVERT = layer$MatteType4 = new Layer$MatteType("INVERT", n11);
        int n12 = 3;
        LUMA = layer$MatteType3 = new Layer$MatteType("LUMA", n12);
        int n13 = 4;
        LUMA_INVERTED = layer$MatteType2 = new Layer$MatteType("LUMA_INVERTED", n13);
        int n14 = 5;
        UNKNOWN = layer$MatteType = new Layer$MatteType("UNKNOWN", n14);
        Layer$MatteType[] layer$MatteTypeArray = new Layer$MatteType[6];
        layer$MatteTypeArray[0] = layer$MatteType6;
        layer$MatteTypeArray[n10] = layer$MatteType5;
        layer$MatteTypeArray[n11] = layer$MatteType4;
        layer$MatteTypeArray[n12] = layer$MatteType3;
        layer$MatteTypeArray[n13] = layer$MatteType2;
        layer$MatteTypeArray[n14] = layer$MatteType;
        $VALUES = layer$MatteTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Layer$MatteType() {
        void var2_-1;
        void var1_-1;
    }

    public static Layer$MatteType valueOf(String string2) {
        return Enum.valueOf(Layer$MatteType.class, string2);
    }

    public static Layer$MatteType[] values() {
        return (Layer$MatteType[])$VALUES.clone();
    }
}

