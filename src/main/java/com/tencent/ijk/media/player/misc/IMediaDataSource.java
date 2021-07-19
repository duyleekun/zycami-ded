/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.ijk.media.player.misc;

public interface IMediaDataSource {
    public void close();

    public long getSize();

    public int readAt(long var1, byte[] var3, int var4, int var5);
}

