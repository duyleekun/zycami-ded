/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

public interface TXLivePlayer$ITXAudioRawDataListener {
    public void onAudioInfoChanged(int var1, int var2, int var3);

    public void onPcmDataAvailable(byte[] var1, long var2);
}

