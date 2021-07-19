/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.other;

import com.zhiyun.protocol.message.bl.other.Status$a;

public final class Status
extends Enum {
    public static final /* enum */ Status ERR_CMD;
    public static final /* enum */ Status ERR_CRC;
    public static final /* enum */ Status ERR_ERASE;
    public static final /* enum */ Status ERR_NONE;
    public static final /* enum */ Status ERR_WRITE;
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private static final int e = 4;
    private static final /* synthetic */ Status[] f;

    static {
        Status status;
        Status status2;
        Status status3;
        Status status4;
        Status status5;
        ERR_NONE = status5 = new Status("ERR_NONE", 0);
        int n10 = 1;
        ERR_CRC = status4 = new Status("ERR_CRC", n10);
        int n11 = 2;
        ERR_WRITE = status3 = new Status("ERR_WRITE", n11);
        int n12 = 3;
        ERR_ERASE = status2 = new Status("ERR_ERASE", n12);
        int n13 = 4;
        ERR_CMD = status = new Status("ERR_CMD", n13);
        Status[] statusArray = new Status[5];
        statusArray[0] = status5;
        statusArray[n10] = status4;
        statusArray[n11] = status3;
        statusArray[n12] = status2;
        statusArray[n13] = status;
        f = statusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Status() {
        void var2_-1;
        void var1_-1;
    }

    public static Status from(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        return ERR_NONE;
                    }
                    return ERR_CMD;
                }
                return ERR_ERASE;
            }
            return ERR_WRITE;
        }
        return ERR_CRC;
    }

    public static int to(Status status) {
        int[] nArray = Status$a.a;
        int n10 = status.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11 && n10 != (n11 = 2) && n10 != (n11 = 3) && n10 != (n11 = 4)) {
            return 0;
        }
        return n11;
    }

    public static Status valueOf(String string2) {
        return Enum.valueOf(Status.class, string2);
    }

    public static Status[] values() {
        return (Status[])f.clone();
    }
}

