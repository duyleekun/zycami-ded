/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb;

import com.zhiyun.protocol.message.usb.DataType$a;

public final class DataType
extends Enum {
    public static final /* enum */ DataType COMMAND;
    public static final /* enum */ DataType MEDIA;
    public static final /* enum */ DataType UNKNOWN;
    private static final int a = 255;
    private static final int b = 0;
    private static final int c = 1;
    private static final /* synthetic */ DataType[] d;

    static {
        DataType dataType;
        DataType dataType2;
        DataType dataType3;
        UNKNOWN = dataType3 = new DataType("UNKNOWN", 0);
        int n10 = 1;
        MEDIA = dataType2 = new DataType("MEDIA", n10);
        int n11 = 2;
        COMMAND = dataType = new DataType("COMMAND", n11);
        DataType[] dataTypeArray = new DataType[3];
        dataTypeArray[0] = dataType3;
        dataTypeArray[n10] = dataType2;
        dataTypeArray[n11] = dataType;
        d = dataTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DataType() {
        void var2_-1;
        void var1_-1;
    }

    public static DataType toType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return UNKNOWN;
            }
            return COMMAND;
        }
        return MEDIA;
    }

    public static int toValue(DataType dataType) {
        int[] nArray = DataType$a.a;
        int n10 = dataType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            int n12 = 2;
            if (n10 != n12) {
                return -1;
            }
            return n11;
        }
        return 0;
    }

    public static DataType valueOf(String string2) {
        return Enum.valueOf(DataType.class, string2);
    }

    public static DataType[] values() {
        return (DataType[])d.clone();
    }
}

