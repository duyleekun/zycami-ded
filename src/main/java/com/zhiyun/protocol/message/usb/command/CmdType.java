/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.CmdType$a;

public final class CmdType
extends Enum {
    public static final /* enum */ CmdType MEDIA;
    public static final /* enum */ CmdType PING;
    public static final /* enum */ CmdType STAR;
    public static final /* enum */ CmdType UNKNOWN;
    public static final /* enum */ CmdType ZYBL;
    private static final int a = 255;
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static final int e = 3;
    private static final /* synthetic */ CmdType[] f;

    static {
        CmdType cmdType;
        CmdType cmdType2;
        CmdType cmdType3;
        CmdType cmdType4;
        CmdType cmdType5;
        UNKNOWN = cmdType5 = new CmdType("UNKNOWN", 0);
        int n10 = 1;
        STAR = cmdType4 = new CmdType("STAR", n10);
        int n11 = 2;
        ZYBL = cmdType3 = new CmdType("ZYBL", n11);
        int n12 = 3;
        MEDIA = cmdType2 = new CmdType("MEDIA", n12);
        int n13 = 4;
        PING = cmdType = new CmdType("PING", n13);
        CmdType[] cmdTypeArray = new CmdType[5];
        cmdTypeArray[0] = cmdType5;
        cmdTypeArray[n10] = cmdType4;
        cmdTypeArray[n11] = cmdType3;
        cmdTypeArray[n12] = cmdType2;
        cmdTypeArray[n13] = cmdType;
        f = cmdTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CmdType() {
        void var2_-1;
        void var1_-1;
    }

    public static CmdType toType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return UNKNOWN;
                    }
                    return PING;
                }
                return MEDIA;
            }
            return ZYBL;
        }
        return STAR;
    }

    public static int toValue(CmdType cmdType) {
        int[] nArray = CmdType$a.a;
        int n10 = cmdType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n11 = 3;
                if (n10 != n11) {
                    n12 = 4;
                    if (n10 != n12) {
                        return -1;
                    }
                    return n11;
                }
                return n12;
            }
            return n11;
        }
        return 0;
    }

    public static CmdType valueOf(String string2) {
        return Enum.valueOf(CmdType.class, string2);
    }

    public static CmdType[] values() {
        return (CmdType[])f.clone();
    }
}

