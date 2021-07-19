/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.other;

import com.zhiyun.protocol.message.bl.other.OtherStatus;

public class OtherStatus$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        OtherStatus otherStatus;
        int n12 = OtherStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            otherStatus = OtherStatus.MD5_ERROR;
            n11 = otherStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            otherStatus = OtherStatus.UPDATE_ERROR;
            n11 = otherStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            otherStatus = OtherStatus.UPDATE_STARTED;
            n11 = otherStatus.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            otherStatus = OtherStatus.NONE_ERROR;
            n11 = otherStatus.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

