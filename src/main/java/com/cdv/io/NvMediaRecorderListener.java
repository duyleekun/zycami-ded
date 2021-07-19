/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnErrorListener
 *  android.media.MediaRecorder$OnInfoListener
 */
package com.cdv.io;

import android.media.MediaRecorder;

public class NvMediaRecorderListener
implements MediaRecorder.OnErrorListener,
MediaRecorder.OnInfoListener {
    private int m_id = -1;

    public NvMediaRecorderListener(int n10) {
        this.m_id = n10;
    }

    private static native void notifyMediaRecorderError(int var0, int var1, int var2);

    private static native void notifyMediaRecorderInfo(int var0, int var1, int var2);

    public void onError(MediaRecorder mediaRecorder, int n10, int n11) {
        NvMediaRecorderListener.notifyMediaRecorderError(this.m_id, n10, n11);
    }

    public void onInfo(MediaRecorder mediaRecorder, int n10, int n11) {
        NvMediaRecorderListener.notifyMediaRecorderInfo(this.m_id, n10, n11);
    }
}

