/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.other;

import com.zhiyun.protocol.message.bl.other.Status;

public class Status$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Status status;
        int n12 = Status.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            status = Status.ERR_CRC;
            n11 = status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.ERR_WRITE;
            n11 = status.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.ERR_ERASE;
            n11 = status.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.ERR_CMD;
            n11 = status.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            status = Status.ERR_NONE;
            n11 = status.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

