/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.usb.command;

import com.zhiyun.protocol.message.usb.command.CmdType;

public class CmdType$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        CmdType cmdType;
        int n12 = CmdType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            cmdType = CmdType.STAR;
            n11 = cmdType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cmdType = CmdType.ZYBL;
            n11 = cmdType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cmdType = CmdType.MEDIA;
            n11 = cmdType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            cmdType = CmdType.PING;
            n11 = cmdType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

