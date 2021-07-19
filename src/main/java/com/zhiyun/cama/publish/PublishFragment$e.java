/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.publish;

import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PublishState;

public class PublishFragment$e {
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
        n11 = PublishState.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = PublishState.STATE_PUBLISHING;
            n10 = enum_.ordinal();
            object2[n10] = (PagingRequestHelper$Status)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = PublishState.STATE_FAILED;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)PublishState.STATE_SUCCESS;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PublishState.STATE_CANCEL;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = PublishState.STATE_NONE;
            n14 = ((Enum)object).ordinal();
            nArray[n14] = n12 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

