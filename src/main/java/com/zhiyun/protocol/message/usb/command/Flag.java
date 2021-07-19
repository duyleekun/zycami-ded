/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.Flag$a;

public final class Flag
extends Enum {
    public static final /* enum */ Flag DISABLE;
    public static final /* enum */ Flag ENABLE;
    public static final /* enum */ Flag QUERY;
    public static final /* enum */ Flag REPULL;
    public static final /* enum */ Flag REPUSH;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 4;
    private static final int e = 3;
    private static final /* synthetic */ Flag[] f;

    static {
        Flag flag;
        Flag flag2;
        Flag flag3;
        Flag flag4;
        Flag flag5;
        DISABLE = flag5 = new Flag("DISABLE", 0);
        int n10 = 1;
        ENABLE = flag4 = new Flag("ENABLE", n10);
        int n11 = 2;
        QUERY = flag3 = new Flag("QUERY", n11);
        int n12 = 3;
        REPULL = flag2 = new Flag("REPULL", n12);
        int n13 = 4;
        REPUSH = flag = new Flag("REPUSH", n13);
        Flag[] flagArray = new Flag[5];
        flagArray[0] = flag5;
        flagArray[n10] = flag4;
        flagArray[n11] = flag3;
        flagArray[n12] = flag2;
        flagArray[n13] = flag;
        f = flagArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Flag() {
        void var2_-1;
        void var1_-1;
    }

    public static Flag toFlag(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return DISABLE;
                    }
                    return REPULL;
                }
                return REPUSH;
            }
            return QUERY;
        }
        return ENABLE;
    }

    public static int toValue(Flag flag) {
        int[] nArray = Flag$a.a;
        int n10 = flag.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2)) {
            n11 = 4;
            int n12 = 3;
            if (n10 != n12) {
                if (n10 != n11) {
                    return 0;
                }
                return n12;
            }
        }
        return n11;
    }

    public static Flag valueOf(String string2) {
        return Enum.valueOf(Flag.class, string2);
    }

    public static Flag[] values() {
        return (Flag[])f.clone();
    }
}

