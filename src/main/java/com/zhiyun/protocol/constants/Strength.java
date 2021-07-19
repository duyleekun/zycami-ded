/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class Strength
extends Enum {
    private static final /* synthetic */ Strength[] $VALUES;
    public static final /* enum */ Strength HIGH;
    public static final /* enum */ Strength LOW;
    public static final /* enum */ Strength MEDIUM;
    public static final /* enum */ Strength N_CALIBRATED;
    public static final /* enum */ Strength N_CALIBRATION;
    public static final /* enum */ Strength N_HIGH;
    public static final /* enum */ Strength N_LOW;
    public static final /* enum */ Strength N_MEDIUM;
    public static final /* enum */ Strength N_MEDIUM_HIGH;
    public static final /* enum */ Strength N_MID_LOW;
    public static final /* enum */ Strength N_ULTRA;
    public final int value;

    static {
        Strength strength;
        Strength strength2;
        Strength strength3;
        Strength strength4;
        Strength strength5;
        Strength strength6;
        Strength strength7;
        Strength strength8;
        Strength strength9;
        Strength strength10;
        Strength strength11;
        LOW = strength11 = new Strength("LOW", 0, 0);
        int n10 = 1;
        MEDIUM = strength10 = new Strength("MEDIUM", n10, n10);
        int n11 = 2;
        HIGH = strength9 = new Strength("HIGH", n11, n11);
        int n12 = 3;
        N_CALIBRATION = strength8 = new Strength("N_CALIBRATION", n12, n12);
        int n13 = 4;
        N_CALIBRATED = strength7 = new Strength("N_CALIBRATED", n13, n13);
        int n14 = 5;
        N_LOW = strength6 = new Strength("N_LOW", n14, n14);
        int n15 = 6;
        N_MID_LOW = strength5 = new Strength("N_MID_LOW", n15, n15);
        n15 = 7;
        N_MEDIUM = strength4 = new Strength("N_MEDIUM", n15, n15);
        n14 = 8;
        N_MEDIUM_HIGH = strength3 = new Strength("N_MEDIUM_HIGH", n14, n14);
        n13 = 9;
        N_HIGH = strength2 = new Strength("N_HIGH", n13, n13);
        n12 = 10;
        N_ULTRA = strength = new Strength("N_ULTRA", n12, n12);
        Strength[] strengthArray = new Strength[11];
        strengthArray[0] = strength11;
        strengthArray[n10] = strength10;
        strengthArray[n11] = strength9;
        strengthArray[3] = strength8;
        strengthArray[4] = strength7;
        strengthArray[5] = strength6;
        strengthArray[6] = strength5;
        strengthArray[7] = strength4;
        strengthArray[8] = strength3;
        strengthArray[9] = strength2;
        strengthArray[n12] = strength;
        $VALUES = strengthArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Strength() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Strength from(int n10) {
        Strength strength = LOW;
        for (Strength strength2 : Strength.values()) {
            int n11 = strength2.value;
            if (n11 != n10) continue;
            strength = strength2;
            break;
        }
        return strength;
    }

    public static Strength valueOf(String string2) {
        return Enum.valueOf(Strength.class, string2);
    }

    public static Strength[] values() {
        return (Strength[])$VALUES.clone();
    }
}

