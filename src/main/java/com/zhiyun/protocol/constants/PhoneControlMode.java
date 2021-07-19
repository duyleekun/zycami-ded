/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.PhoneControlMode$1;

public final class PhoneControlMode
extends Enum {
    private static final /* synthetic */ PhoneControlMode[] $VALUES;
    public static final /* enum */ PhoneControlMode BEGIN;
    private static final int BEGIN_COIDE = 1;
    public static final /* enum */ PhoneControlMode END;
    private static final int END_COIDE;

    static {
        PhoneControlMode phoneControlMode;
        PhoneControlMode phoneControlMode2;
        END = phoneControlMode2 = new PhoneControlMode("END", 0);
        int n10 = 1;
        BEGIN = phoneControlMode = new PhoneControlMode("BEGIN", n10);
        PhoneControlMode[] phoneControlModeArray = new PhoneControlMode[2];
        phoneControlModeArray[0] = phoneControlMode2;
        phoneControlModeArray[n10] = phoneControlMode;
        $VALUES = phoneControlModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PhoneControlMode() {
        void var2_-1;
        void var1_-1;
    }

    public static PhoneControlMode from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            return END;
        }
        return BEGIN;
    }

    public static int to(PhoneControlMode phoneControlMode) {
        int[] nArray = PhoneControlMode$1.$SwitchMap$com$zhiyun$protocol$constants$PhoneControlMode;
        int n10 = phoneControlMode.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            return 0;
        }
        return n11;
    }

    public static PhoneControlMode valueOf(String string2) {
        return Enum.valueOf(PhoneControlMode.class, string2);
    }

    public static PhoneControlMode[] values() {
        return (PhoneControlMode[])$VALUES.clone();
    }
}

