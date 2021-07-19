/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.hw;

public class HWAes {
    static {
        System.loadLibrary("hwaes");
    }

    public static native byte[] decrypt(byte[] var0, byte[] var1);

    public static native byte[] encrypt(byte[] var0, byte[] var1);
}

