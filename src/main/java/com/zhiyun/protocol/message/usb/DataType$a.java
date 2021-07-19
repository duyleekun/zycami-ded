/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb;

import com.zhiyun.protocol.message.usb.DataType;

public class DataType$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DataType dataType;
        int n12 = DataType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            dataType = DataType.MEDIA;
            n11 = dataType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            dataType = DataType.COMMAND;
            n11 = dataType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

