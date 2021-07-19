/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

public interface IAndroidIO {
    public int close();

    public int open(String var1);

    public int read(byte[] var1, int var2);

    public long seek(long var1, int var3);
}

