/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.VID$1;

public final class VID
extends Enum {
    private static final /* synthetic */ VID[] $VALUES;
    public static final /* enum */ VID CANON;
    private static final int CANON_CODE = 0;
    public static final /* enum */ VID GENERAL;
    private static final int GENERAL_CODE = 3;
    public static final /* enum */ VID NIKON;
    private static final int NIKON_CODE = 2;
    public static final /* enum */ VID SONY;
    private static final int SONY_CODE = 1;

    static {
        VID vID;
        VID vID2;
        VID vID3;
        VID vID4;
        CANON = vID4 = new VID("CANON", 0);
        int n10 = 1;
        SONY = vID3 = new VID("SONY", n10);
        int n11 = 2;
        NIKON = vID2 = new VID("NIKON", n11);
        int n12 = 3;
        GENERAL = vID = new VID("GENERAL", n12);
        VID[] vIDArray = new VID[4];
        vIDArray[0] = vID4;
        vIDArray[n10] = vID3;
        vIDArray[n11] = vID2;
        vIDArray[n12] = vID;
        $VALUES = vIDArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private VID() {
        void var2_-1;
        void var1_-1;
    }

    public static VID from(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return GENERAL;
                }
                return NIKON;
            }
            return SONY;
        }
        return CANON;
    }

    public static int to(VID vID) {
        int[] nArray = VID$1.$SwitchMap$com$zhiyun$protocol$constants$VID;
        int n10 = vID.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    return n11;
                }
                return n12;
            }
            return n11;
        }
        return 0;
    }

    public static VID valueOf(String string2) {
        return Enum.valueOf(VID.class, string2);
    }

    public static VID[] values() {
        return (VID[])$VALUES.clone();
    }
}

