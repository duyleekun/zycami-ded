/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.push;

import com.zhiyun.cama.push.PushEntity$PushType;

public class CustomPushReceiver$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        PushEntity$PushType pushEntity$PushType;
        int n12 = PushEntity$PushType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            pushEntity$PushType = PushEntity$PushType.LIKELIST;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pushEntity$PushType = PushEntity$PushType.SHARENOTICE;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pushEntity$PushType = PushEntity$PushType.WORKS;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pushEntity$PushType = PushEntity$PushType.CONNECTION;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pushEntity$PushType = PushEntity$PushType.TEXT;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            pushEntity$PushType = PushEntity$PushType.PRIME;
            n11 = pushEntity$PushType.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

