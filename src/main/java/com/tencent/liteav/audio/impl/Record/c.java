/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.Record;

public interface c {
    public void onAudioRecordError(int var1, String var2);

    public void onAudioRecordPCM(byte[] var1, int var2, long var3);

    public void onAudioRecordStart();

    public void onAudioRecordStop();
}

