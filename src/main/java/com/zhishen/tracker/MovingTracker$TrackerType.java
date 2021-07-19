/*
 * Decompiled with CFR 0.151.
 */
package com.zhishen.tracker;

public final class MovingTracker$TrackerType
extends Enum {
    private static final /* synthetic */ MovingTracker$TrackerType[] a;
    public static final /* enum */ MovingTracker$TrackerType cmt;
    public static final /* enum */ MovingTracker$TrackerType dsst;
    public static final /* enum */ MovingTracker$TrackerType kcf;
    public static final /* enum */ MovingTracker$TrackerType mot;
    private int value = 0;

    static {
        MovingTracker$TrackerType movingTracker$TrackerType;
        MovingTracker$TrackerType movingTracker$TrackerType2;
        MovingTracker$TrackerType movingTracker$TrackerType3;
        MovingTracker$TrackerType movingTracker$TrackerType4;
        cmt = movingTracker$TrackerType4 = new MovingTracker$TrackerType("cmt", 0, 0);
        int n10 = 1;
        kcf = movingTracker$TrackerType3 = new MovingTracker$TrackerType("kcf", n10, n10);
        int n11 = 2;
        dsst = movingTracker$TrackerType2 = new MovingTracker$TrackerType("dsst", n11, n11);
        int n12 = 3;
        mot = movingTracker$TrackerType = new MovingTracker$TrackerType("mot", n12, n12);
        MovingTracker$TrackerType[] movingTracker$TrackerTypeArray = new MovingTracker$TrackerType[4];
        movingTracker$TrackerTypeArray[0] = movingTracker$TrackerType4;
        movingTracker$TrackerTypeArray[n10] = movingTracker$TrackerType3;
        movingTracker$TrackerTypeArray[n11] = movingTracker$TrackerType2;
        movingTracker$TrackerTypeArray[n12] = movingTracker$TrackerType;
        a = movingTracker$TrackerTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MovingTracker$TrackerType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static MovingTracker$TrackerType valueOf(String string2) {
        return Enum.valueOf(MovingTracker$TrackerType.class, string2);
    }

    public static MovingTracker$TrackerType[] values() {
        return (MovingTracker$TrackerType[])a.clone();
    }

    public int value() {
        return this.value;
    }
}

