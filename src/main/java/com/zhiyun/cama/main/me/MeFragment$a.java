/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main.me;

import com.zhiyun.cama.data.PublishState;

public class MeFragment$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PublishState publishState;
        int n12 = PublishState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            publishState = PublishState.STATE_PUBLISHING;
            n11 = publishState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            publishState = PublishState.STATE_FAILED;
            n11 = publishState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            publishState = PublishState.STATE_SUCCESS;
            n11 = publishState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            publishState = PublishState.STATE_NONE;
            n11 = publishState.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            publishState = PublishState.STATE_CANCEL;
            n11 = publishState.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

