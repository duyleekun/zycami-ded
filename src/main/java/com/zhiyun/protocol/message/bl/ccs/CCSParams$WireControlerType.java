/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

public final class CCSParams$WireControlerType
extends Enum {
    public static final /* enum */ CCSParams$WireControlerType COMMON_USB;
    public static final /* enum */ CCSParams$WireControlerType SONY_USB;
    public static final /* enum */ CCSParams$WireControlerType UNKNOW;
    private static final /* synthetic */ CCSParams$WireControlerType[] a;

    static {
        CCSParams$WireControlerType cCSParams$WireControlerType;
        CCSParams$WireControlerType cCSParams$WireControlerType2;
        CCSParams$WireControlerType cCSParams$WireControlerType3;
        COMMON_USB = cCSParams$WireControlerType3 = new CCSParams$WireControlerType("COMMON_USB", 0);
        int n10 = 1;
        SONY_USB = cCSParams$WireControlerType2 = new CCSParams$WireControlerType("SONY_USB", n10);
        int n11 = 2;
        UNKNOW = cCSParams$WireControlerType = new CCSParams$WireControlerType("UNKNOW", n11);
        CCSParams$WireControlerType[] cCSParams$WireControlerTypeArray = new CCSParams$WireControlerType[3];
        cCSParams$WireControlerTypeArray[0] = cCSParams$WireControlerType3;
        cCSParams$WireControlerTypeArray[n10] = cCSParams$WireControlerType2;
        cCSParams$WireControlerTypeArray[n11] = cCSParams$WireControlerType;
        a = cCSParams$WireControlerTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CCSParams$WireControlerType() {
        void var2_-1;
        void var1_-1;
    }

    public static CCSParams$WireControlerType valueOf(String string2) {
        return Enum.valueOf(CCSParams$WireControlerType.class, string2);
    }

    public static CCSParams$WireControlerType[] values() {
        return (CCSParams$WireControlerType[])a.clone();
    }
}

