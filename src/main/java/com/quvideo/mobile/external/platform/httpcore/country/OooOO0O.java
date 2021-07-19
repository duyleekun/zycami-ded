/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.httpcore.country;

public final class OooOO0O
extends Enum {
    private static final /* synthetic */ OooOO0O[] $VALUES;
    public static final /* enum */ OooOO0O ZONE_AMERICAN;
    public static final /* enum */ OooOO0O ZONE_BIG_CHINA;
    public static final /* enum */ OooOO0O ZONE_EAST_ASIA;
    public static final /* enum */ OooOO0O ZONE_MIDDLE_EAST;
    private String zone;

    static {
        OooOO0O oooOO0O;
        OooOO0O oooOO0O2;
        OooOO0O oooOO0O3;
        OooOO0O oooOO0O4;
        ZONE_BIG_CHINA = oooOO0O4 = new OooOO0O("ZONE_BIG_CHINA", 0, "hz");
        int n10 = 1;
        ZONE_EAST_ASIA = oooOO0O3 = new OooOO0O("ZONE_EAST_ASIA", n10, "asia1");
        int n11 = 2;
        ZONE_AMERICAN = oooOO0O2 = new OooOO0O("ZONE_AMERICAN", n11, "us");
        int n12 = 3;
        ZONE_MIDDLE_EAST = oooOO0O = new OooOO0O("ZONE_MIDDLE_EAST", n12, "meast");
        OooOO0O[] oooOO0OArray = new OooOO0O[4];
        oooOO0OArray[0] = oooOO0O4;
        oooOO0OArray[n10] = oooOO0O3;
        oooOO0OArray[n11] = oooOO0O2;
        oooOO0OArray[n12] = oooOO0O;
        $VALUES = oooOO0OArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private OooOO0O() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zone = var3_1;
    }

    public static OooOO0O getZoneByStr(String string2) {
        for (OooOO0O oooOO0O : OooOO0O.values()) {
            String string3 = oooOO0O.value();
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return oooOO0O;
        }
        return null;
    }

    public static OooOO0O valueOf(String string2) {
        return Enum.valueOf(OooOO0O.class, string2);
    }

    public static OooOO0O[] values() {
        return (OooOO0O[])$VALUES.clone();
    }

    public String value() {
        return this.zone;
    }
}

