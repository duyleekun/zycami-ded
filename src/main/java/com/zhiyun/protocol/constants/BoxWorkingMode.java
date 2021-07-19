/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.BoxWorkingMode$1;

public final class BoxWorkingMode
extends Enum {
    private static final /* synthetic */ BoxWorkingMode[] $VALUES;
    private static final int CODE_HOST = 1;
    private static final int CODE_SALVE = 0;
    private static final int CODE_UNCONNECTED = 2;
    public static final /* enum */ BoxWorkingMode HOST;
    public static final /* enum */ BoxWorkingMode SALVE;
    public static final /* enum */ BoxWorkingMode UNCONNECTED;

    static {
        BoxWorkingMode boxWorkingMode;
        BoxWorkingMode boxWorkingMode2;
        BoxWorkingMode boxWorkingMode3;
        SALVE = boxWorkingMode3 = new BoxWorkingMode("SALVE", 0);
        int n10 = 1;
        HOST = boxWorkingMode2 = new BoxWorkingMode("HOST", n10);
        int n11 = 2;
        UNCONNECTED = boxWorkingMode = new BoxWorkingMode("UNCONNECTED", n11);
        BoxWorkingMode[] boxWorkingModeArray = new BoxWorkingMode[3];
        boxWorkingModeArray[0] = boxWorkingMode3;
        boxWorkingModeArray[n10] = boxWorkingMode2;
        boxWorkingModeArray[n11] = boxWorkingMode;
        $VALUES = boxWorkingModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BoxWorkingMode() {
        void var2_-1;
        void var1_-1;
    }

    public static BoxWorkingMode from(int n10) {
        if (n10 != 0) {
            int n11 = 2;
            if (n10 != n11) {
                return HOST;
            }
            return UNCONNECTED;
        }
        return SALVE;
    }

    public static int to(BoxWorkingMode boxWorkingMode) {
        int[] nArray = BoxWorkingMode$1.$SwitchMap$com$zhiyun$protocol$constants$BoxWorkingMode;
        int n10 = boxWorkingMode.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                return n11;
            }
            return n12;
        }
        return 0;
    }

    public static BoxWorkingMode valueOf(String string2) {
        return Enum.valueOf(BoxWorkingMode.class, string2);
    }

    public static BoxWorkingMode[] values() {
        return (BoxWorkingMode[])$VALUES.clone();
    }
}

