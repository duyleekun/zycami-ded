/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

public final class GradientType
extends Enum {
    private static final /* synthetic */ GradientType[] $VALUES;
    public static final /* enum */ GradientType LINEAR;
    public static final /* enum */ GradientType RADIAL;

    static {
        GradientType gradientType;
        GradientType gradientType2;
        LINEAR = gradientType2 = new GradientType("LINEAR", 0);
        int n10 = 1;
        RADIAL = gradientType = new GradientType("RADIAL", n10);
        GradientType[] gradientTypeArray = new GradientType[2];
        gradientTypeArray[0] = gradientType2;
        gradientTypeArray[n10] = gradientType;
        $VALUES = gradientTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private GradientType() {
        void var2_-1;
        void var1_-1;
    }

    public static GradientType valueOf(String string2) {
        return Enum.valueOf(GradientType.class, string2);
    }

    public static GradientType[] values() {
        return (GradientType[])$VALUES.clone();
    }
}

