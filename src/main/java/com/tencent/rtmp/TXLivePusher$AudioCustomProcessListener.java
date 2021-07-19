/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

public interface TXLivePusher$AudioCustomProcessListener {
    public void onRecordPcmData(byte[] var1, long var2, int var4, int var5, int var6);

    public void onRecordRawPcmData(byte[] var1, long var2, int var4, int var5, int var6, boolean var7);
}

