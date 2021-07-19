/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.me.help;

import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.me.help.data.FeedbackSet$DealStatus;

public class FeedbackDetailFragment$a {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13 = PagingRequestHelper$Status.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object3 = PagingRequestHelper$Status.RUNNING;
            n12 = object3.ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object3 = b;
            object2 = PagingRequestHelper$Status.SUCCESS;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (PagingRequestHelper$Status)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 3;
        try {
            object2 = b;
            enum_ = PagingRequestHelper$Status.FAILED;
            n10 = enum_.ordinal();
            object2[n10] = (PagingRequestHelper$Status)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = FeedbackSet$DealStatus.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = FeedbackSet$DealStatus.TO_BE_CONFIRM;
            n10 = enum_.ordinal();
            object2[n10] = (PagingRequestHelper$Status)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = FeedbackSet$DealStatus.ING;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)FeedbackSet$DealStatus.CLOSE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

