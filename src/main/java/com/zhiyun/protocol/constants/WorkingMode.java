/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

public final class WorkingMode
extends Enum {
    private static final /* synthetic */ WorkingMode[] $VALUES;
    public static final /* enum */ WorkingMode F;
    public static final /* enum */ WorkingMode GO;
    public static final /* enum */ WorkingMode L;
    public static final /* enum */ WorkingMode PF;
    public static final /* enum */ WorkingMode POV;
    public static final /* enum */ WorkingMode THREE_DIMENSION;
    public final int code;

    static {
        WorkingMode workingMode;
        WorkingMode workingMode2;
        WorkingMode workingMode3;
        WorkingMode workingMode4;
        WorkingMode workingMode5;
        WorkingMode workingMode6;
        PF = workingMode6 = new WorkingMode("PF", 0, 0);
        int n10 = 1;
        L = workingMode5 = new WorkingMode("L", n10, n10);
        int n11 = 2;
        F = workingMode4 = new WorkingMode("F", n11, n11);
        int n12 = 3;
        POV = workingMode3 = new WorkingMode("POV", n12, n12);
        int n13 = 4;
        GO = workingMode2 = new WorkingMode("GO", n13, n13);
        int n14 = 5;
        THREE_DIMENSION = workingMode = new WorkingMode("THREE_DIMENSION", n14, n14);
        WorkingMode[] workingModeArray = new WorkingMode[6];
        workingModeArray[0] = workingMode6;
        workingModeArray[n10] = workingMode5;
        workingModeArray[n11] = workingMode4;
        workingModeArray[n12] = workingMode3;
        workingModeArray[n13] = workingMode2;
        workingModeArray[n14] = workingMode;
        $VALUES = workingModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WorkingMode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static WorkingMode from(int n10) {
        WorkingMode workingMode = PF;
        for (WorkingMode workingMode2 : WorkingMode.values()) {
            int n11 = workingMode2.code;
            if (n11 != n10) continue;
            workingMode = workingMode2;
            break;
        }
        return workingMode;
    }

    public static WorkingMode valueOf(String string2) {
        return Enum.valueOf(WorkingMode.class, string2);
    }

    public static WorkingMode[] values() {
        return (WorkingMode[])$VALUES.clone();
    }
}

