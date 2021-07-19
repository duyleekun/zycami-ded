/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

public final class AVOSCloud$REGION
extends Enum {
    private static final /* synthetic */ AVOSCloud$REGION[] $VALUES;
    public static final /* enum */ AVOSCloud$REGION EastChina;
    public static final /* enum */ AVOSCloud$REGION NorthAmerica;
    public static final /* enum */ AVOSCloud$REGION NorthChina;

    static {
        AVOSCloud$REGION aVOSCloud$REGION;
        AVOSCloud$REGION aVOSCloud$REGION2;
        AVOSCloud$REGION aVOSCloud$REGION3;
        EastChina = aVOSCloud$REGION3 = new AVOSCloud$REGION("EastChina", 0);
        int n10 = 1;
        NorthChina = aVOSCloud$REGION2 = new AVOSCloud$REGION("NorthChina", n10);
        int n11 = 2;
        NorthAmerica = aVOSCloud$REGION = new AVOSCloud$REGION("NorthAmerica", n11);
        AVOSCloud$REGION[] aVOSCloud$REGIONArray = new AVOSCloud$REGION[3];
        aVOSCloud$REGIONArray[0] = aVOSCloud$REGION3;
        aVOSCloud$REGIONArray[n10] = aVOSCloud$REGION2;
        aVOSCloud$REGIONArray[n11] = aVOSCloud$REGION;
        $VALUES = aVOSCloud$REGIONArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVOSCloud$REGION() {
        void var2_-1;
        void var1_-1;
    }

    public static AVOSCloud$REGION valueOf(String string2) {
        return Enum.valueOf(AVOSCloud$REGION.class, string2);
    }

    public static AVOSCloud$REGION[] values() {
        return (AVOSCloud$REGION[])$VALUES.clone();
    }
}

