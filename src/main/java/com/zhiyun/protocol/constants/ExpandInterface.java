/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.ExpandInterface$1;

public final class ExpandInterface
extends Enum {
    private static final /* synthetic */ ExpandInterface[] $VALUES;
    public static final /* enum */ ExpandInterface CLOSED;
    private static final int CLOSED_CODE = 0;
    public static final /* enum */ ExpandInterface GENERAL;
    private static final int GENERAL_CODE = 1;
    public static final /* enum */ ExpandInterface PANASONIC;
    private static final int PANASONIC_CODE = 3;
    public static final /* enum */ ExpandInterface SONY;
    private static final int SONY_CODE = 2;

    static {
        ExpandInterface expandInterface;
        ExpandInterface expandInterface2;
        ExpandInterface expandInterface3;
        ExpandInterface expandInterface4;
        CLOSED = expandInterface4 = new ExpandInterface("CLOSED", 0);
        int n10 = 1;
        GENERAL = expandInterface3 = new ExpandInterface("GENERAL", n10);
        int n11 = 2;
        SONY = expandInterface2 = new ExpandInterface("SONY", n11);
        int n12 = 3;
        PANASONIC = expandInterface = new ExpandInterface("PANASONIC", n12);
        ExpandInterface[] expandInterfaceArray = new ExpandInterface[4];
        expandInterfaceArray[0] = expandInterface4;
        expandInterfaceArray[n10] = expandInterface3;
        expandInterfaceArray[n11] = expandInterface2;
        expandInterfaceArray[n12] = expandInterface;
        $VALUES = expandInterfaceArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ExpandInterface() {
        void var2_-1;
        void var1_-1;
    }

    public static ExpandInterface from(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return PANASONIC;
                }
                return SONY;
            }
            return GENERAL;
        }
        return CLOSED;
    }

    public static int to(ExpandInterface expandInterface) {
        int[] nArray = ExpandInterface$1.$SwitchMap$com$zhiyun$protocol$constants$ExpandInterface;
        int n10 = expandInterface.ordinal();
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

    public static ExpandInterface valueOf(String string2) {
        return Enum.valueOf(ExpandInterface.class, string2);
    }

    public static ExpandInterface[] values() {
        return (ExpandInterface[])$VALUES.clone();
    }
}

