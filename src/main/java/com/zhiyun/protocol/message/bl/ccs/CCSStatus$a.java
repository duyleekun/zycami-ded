/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.ccs;

import com.zhiyun.protocol.message.bl.ccs.CCSStatus;

public class CCSStatus$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CCSStatus cCSStatus;
        int n12 = CCSStatus.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            cCSStatus = CCSStatus.NO_ERROR;
            n11 = cCSStatus.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cCSStatus = CCSStatus.GEN_ERROR;
            n11 = cCSStatus.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cCSStatus = CCSStatus.WAIT;
            n11 = cCSStatus.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

