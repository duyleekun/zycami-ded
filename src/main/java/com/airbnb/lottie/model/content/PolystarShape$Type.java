/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

public final class PolystarShape$Type
extends Enum {
    private static final /* synthetic */ PolystarShape$Type[] $VALUES;
    public static final /* enum */ PolystarShape$Type POLYGON;
    public static final /* enum */ PolystarShape$Type STAR;
    private final int value;

    static {
        PolystarShape$Type polystarShape$Type;
        PolystarShape$Type polystarShape$Type2;
        int n10 = 1;
        STAR = polystarShape$Type2 = new PolystarShape$Type("STAR", 0, n10);
        int n11 = 2;
        POLYGON = polystarShape$Type = new PolystarShape$Type("POLYGON", n10, n11);
        PolystarShape$Type[] polystarShape$TypeArray = new PolystarShape$Type[n11];
        polystarShape$TypeArray[0] = polystarShape$Type2;
        polystarShape$TypeArray[n10] = polystarShape$Type;
        $VALUES = polystarShape$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PolystarShape$Type() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static PolystarShape$Type forValue(int n10) {
        for (PolystarShape$Type polystarShape$Type : PolystarShape$Type.values()) {
            int n11 = polystarShape$Type.value;
            if (n11 != n10) continue;
            return polystarShape$Type;
        }
        return null;
    }

    public static PolystarShape$Type valueOf(String string2) {
        return Enum.valueOf(PolystarShape$Type.class, string2);
    }

    public static PolystarShape$Type[] values() {
        return (PolystarShape$Type[])$VALUES.clone();
    }
}

