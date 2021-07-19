/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.zhiyun.account.data.me.ThirdPlatform;

public class SharePlatformManager$4 {
    public static final /* synthetic */ int[] $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ThirdPlatform thirdPlatform;
        int n12 = ThirdPlatform.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform = nArray;
        try {
            thirdPlatform = ThirdPlatform.WE_CHAT;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.MOMENT;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.WEIBO;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.QQ;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.QQ_ZONE;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.FACEBOOK;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
            thirdPlatform = ThirdPlatform.TWITTER;
            n11 = thirdPlatform.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

