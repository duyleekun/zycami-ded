/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.ParamType$1;

public final class ParamType
extends Enum {
    private static final /* synthetic */ ParamType[] $VALUES;
    public static final /* enum */ ParamType APERTURE;
    private static final int AV_CODE = 0;
    public static final /* enum */ ParamType EV;
    private static final int EV_CODE = 3;
    public static final /* enum */ ParamType ISO;
    private static final int ISO_CODE = 2;
    public static final /* enum */ ParamType SHUTTER;
    private static final int TV_CODE = 1;

    static {
        ParamType paramType;
        ParamType paramType2;
        ParamType paramType3;
        ParamType paramType4;
        APERTURE = paramType4 = new ParamType("APERTURE", 0);
        int n10 = 1;
        SHUTTER = paramType3 = new ParamType("SHUTTER", n10);
        int n11 = 2;
        ISO = paramType2 = new ParamType("ISO", n11);
        int n12 = 3;
        EV = paramType = new ParamType("EV", n12);
        ParamType[] paramTypeArray = new ParamType[4];
        paramTypeArray[0] = paramType4;
        paramTypeArray[n10] = paramType3;
        paramTypeArray[n11] = paramType2;
        paramTypeArray[n12] = paramType;
        $VALUES = paramTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ParamType() {
        void var2_-1;
        void var1_-1;
    }

    public static ParamType from(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return EV;
                }
                return ISO;
            }
            return SHUTTER;
        }
        return APERTURE;
    }

    public static int to(ParamType paramType) {
        int[] nArray = ParamType$1.$SwitchMap$com$zhiyun$protocol$constants$ParamType;
        int n10 = paramType.ordinal();
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

    public static ParamType valueOf(String string2) {
        return Enum.valueOf(ParamType.class, string2);
    }

    public static ParamType[] values() {
        return (ParamType[])$VALUES.clone();
    }
}

