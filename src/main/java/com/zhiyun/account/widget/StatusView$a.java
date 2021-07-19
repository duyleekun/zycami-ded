/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.widget;

import com.zhiyun.account.widget.StatusView$Status;

public class StatusView$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        StatusView$Status statusView$Status;
        int n12 = StatusView$Status.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            statusView$Status = StatusView$Status.STATUS_NONE;
            n11 = statusView$Status.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            statusView$Status = StatusView$Status.STATUS_LOADING;
            n11 = statusView$Status.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            statusView$Status = StatusView$Status.STATUS_ERROR;
            n11 = statusView$Status.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

