/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.layer;

public final class Layer$LayerType
extends Enum {
    private static final /* synthetic */ Layer$LayerType[] $VALUES;
    public static final /* enum */ Layer$LayerType IMAGE;
    public static final /* enum */ Layer$LayerType NULL;
    public static final /* enum */ Layer$LayerType PRE_COMP;
    public static final /* enum */ Layer$LayerType SHAPE;
    public static final /* enum */ Layer$LayerType SOLID;
    public static final /* enum */ Layer$LayerType TEXT;
    public static final /* enum */ Layer$LayerType UNKNOWN;

    static {
        Layer$LayerType layer$LayerType;
        Layer$LayerType layer$LayerType2;
        Layer$LayerType layer$LayerType3;
        Layer$LayerType layer$LayerType4;
        Layer$LayerType layer$LayerType5;
        Layer$LayerType layer$LayerType6;
        Layer$LayerType layer$LayerType7;
        PRE_COMP = layer$LayerType7 = new Layer$LayerType("PRE_COMP", 0);
        int n10 = 1;
        SOLID = layer$LayerType6 = new Layer$LayerType("SOLID", n10);
        int n11 = 2;
        IMAGE = layer$LayerType5 = new Layer$LayerType("IMAGE", n11);
        int n12 = 3;
        NULL = layer$LayerType4 = new Layer$LayerType("NULL", n12);
        int n13 = 4;
        SHAPE = layer$LayerType3 = new Layer$LayerType("SHAPE", n13);
        int n14 = 5;
        TEXT = layer$LayerType2 = new Layer$LayerType("TEXT", n14);
        int n15 = 6;
        UNKNOWN = layer$LayerType = new Layer$LayerType("UNKNOWN", n15);
        Layer$LayerType[] layer$LayerTypeArray = new Layer$LayerType[7];
        layer$LayerTypeArray[0] = layer$LayerType7;
        layer$LayerTypeArray[n10] = layer$LayerType6;
        layer$LayerTypeArray[n11] = layer$LayerType5;
        layer$LayerTypeArray[n12] = layer$LayerType4;
        layer$LayerTypeArray[n13] = layer$LayerType3;
        layer$LayerTypeArray[n14] = layer$LayerType2;
        layer$LayerTypeArray[n15] = layer$LayerType;
        $VALUES = layer$LayerTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Layer$LayerType() {
        void var2_-1;
        void var1_-1;
    }

    public static Layer$LayerType valueOf(String string2) {
        return Enum.valueOf(Layer$LayerType.class, string2);
    }

    public static Layer$LayerType[] values() {
        return (Layer$LayerType[])$VALUES.clone();
    }
}

