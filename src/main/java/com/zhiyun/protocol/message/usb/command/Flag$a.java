/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.Flag;

public class Flag$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Flag flag;
        int n12 = Flag.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            flag = Flag.ENABLE;
            n11 = flag.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            flag = Flag.QUERY;
            n11 = flag.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            flag = Flag.REPULL;
            n11 = flag.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            flag = Flag.REPUSH;
            n11 = flag.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            flag = Flag.DISABLE;
            n11 = flag.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

