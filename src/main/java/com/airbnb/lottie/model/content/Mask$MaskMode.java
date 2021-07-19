/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

public final class Mask$MaskMode
extends Enum {
    private static final /* synthetic */ Mask$MaskMode[] $VALUES;
    public static final /* enum */ Mask$MaskMode MASK_MODE_ADD;
    public static final /* enum */ Mask$MaskMode MASK_MODE_INTERSECT;
    public static final /* enum */ Mask$MaskMode MASK_MODE_NONE;
    public static final /* enum */ Mask$MaskMode MASK_MODE_SUBTRACT;

    static {
        Mask$MaskMode mask$MaskMode;
        Mask$MaskMode mask$MaskMode2;
        Mask$MaskMode mask$MaskMode3;
        Mask$MaskMode mask$MaskMode4;
        MASK_MODE_ADD = mask$MaskMode4 = new Mask$MaskMode("MASK_MODE_ADD", 0);
        int n10 = 1;
        MASK_MODE_SUBTRACT = mask$MaskMode3 = new Mask$MaskMode("MASK_MODE_SUBTRACT", n10);
        int n11 = 2;
        MASK_MODE_INTERSECT = mask$MaskMode2 = new Mask$MaskMode("MASK_MODE_INTERSECT", n11);
        int n12 = 3;
        MASK_MODE_NONE = mask$MaskMode = new Mask$MaskMode("MASK_MODE_NONE", n12);
        Mask$MaskMode[] mask$MaskModeArray = new Mask$MaskMode[4];
        mask$MaskModeArray[0] = mask$MaskMode4;
        mask$MaskModeArray[n10] = mask$MaskMode3;
        mask$MaskModeArray[n11] = mask$MaskMode2;
        mask$MaskModeArray[n12] = mask$MaskMode;
        $VALUES = mask$MaskModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Mask$MaskMode() {
        void var2_-1;
        void var1_-1;
    }

    public static Mask$MaskMode valueOf(String string2) {
        return Enum.valueOf(Mask$MaskMode.class, string2);
    }

    public static Mask$MaskMode[] values() {
        return (Mask$MaskMode[])$VALUES.clone();
    }
}

