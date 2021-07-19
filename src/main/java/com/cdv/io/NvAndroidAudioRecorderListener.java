/*
 * Decompiled with CFR 0.151.
 */
package com.cdv.io;

import com.cdv.io.NvAndroidAudioRecorder$RecordDataCallback;
import java.nio.ByteBuffer;

public class NvAndroidAudioRecorderListener
implements NvAndroidAudioRecorder$RecordDataCallback {
    private int m_id = -1;

    public NvAndroidAudioRecorderListener(int n10) {
        this.m_id = n10;
    }

    private static native void audioRecordDataReady(int var0, ByteBuffer var1, int var2);

    public void onAudioRecordDataArrived(ByteBuffer byteBuffer, int n10) {
        NvAndroidAudioRecorderListener.audioRecordDataReady(this.m_id, byteBuffer, n10);
    }
}

