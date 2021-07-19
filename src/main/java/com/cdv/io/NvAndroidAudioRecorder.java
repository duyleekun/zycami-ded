/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 *  android.os.Build
 *  android.util.Log
 */
package com.cdv.io;

import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;
import com.cdv.io.NvAndroidAudioRecorder$1;
import com.cdv.io.NvAndroidAudioRecorder$RecordDataCallback;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public class NvAndroidAudioRecorder {
    private static final String TAG = "NvAndroidAudioRecorder";
    private static final int m_audioFormat = 2;
    private static final int m_channelConfig = 16;
    private static final int m_chunkSizeInBytes = 2048;
    private static final int m_sampleCountInChunk = 1024;
    private static final int m_sampleRateInHz = 44100;
    private static final int m_sampleSizeInBytes = 2;
    private static final boolean m_verbose = false;
    private ByteBuffer m_chunkBuffer;
    private AtomicInteger m_exitingRecordingThread;
    private boolean m_isRecording;
    private NvAndroidAudioRecorder$RecordDataCallback m_recordDataCallback;
    private AudioRecord m_recorder;
    private Thread m_recordingThread;

    public NvAndroidAudioRecorder() {
        block9: {
            String string2 = TAG;
            Object var2_2 = null;
            this.m_chunkBuffer = null;
            this.m_recordDataCallback = null;
            Object object = null;
            this.m_isRecording = false;
            this.m_recordingThread = null;
            Object object2 = new AtomicInteger(0);
            this.m_exitingRecordingThread = object2;
            int n10 = 2;
            int n11 = AudioRecord.getMinBufferSize((int)44100, (int)16, (int)n10);
            int n12 = 32768;
            int n13 = n12 < n11 ? n11 : n12;
            n11 = 1;
            object2 = Build.MODEL;
            Object object3 = "Redmi Note 2";
            n12 = (int)(((String)object2).equals(object3) ? 1 : 0);
            if (n12 != 0) {
                n11 = 7;
            }
            int n14 = n11;
            n11 = 2048;
            object = ByteBuffer.allocateDirect(n11);
            this.m_chunkBuffer = object;
            int n15 = 44100;
            int n16 = 16;
            int n17 = 2;
            object3 = object;
            super(n14, n15, n16, n17, n13);
            this.m_recorder = object;
            n11 = object.getState();
            if (n11 != 0) break block9;
            object = "Failed to initialize AudioRecord object!";
            Log.e((String)string2, (String)object);
            object = this.m_recorder;
            object.release();
            try {
                this.m_recorder = null;
            }
            catch (Exception exception) {
                super();
                ((StringBuilder)object).append("");
                object2 = exception.getMessage();
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Log.e((String)string2, (String)object);
                exception.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void access$000(NvAndroidAudioRecorder nvAndroidAudioRecorder) {
        nvAndroidAudioRecorder.readAudioData();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void readAudioData() {
        String string2;
        Object object;
        String string3 = TAG;
        try {
            block3: while (true) {
                Object object2 = this.m_chunkBuffer;
                int n10 = 0;
                object = null;
                ((ByteBuffer)object2).position(0);
                while (true) {
                    Object object3;
                    int n11;
                    if ((n11 = ((AtomicInteger)(object2 = this.m_exitingRecordingThread)).get()) != 0) {
                        return;
                    }
                    n11 = 2048 - n10;
                    string2 = this.m_recorder;
                    ByteBuffer byteBuffer = this.m_chunkBuffer;
                    int n12 = string2.read(byteBuffer, n11);
                    long l10 = 4;
                    if (n12 < 0) {
                        object2 = new StringBuilder();
                        object3 = "read() failed! errno=";
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append(n12);
                        object2 = ((StringBuilder)object2).toString();
                        Log.e((String)string3, (String)object2);
                        Thread.sleep(l10);
                        continue;
                    }
                    if (n12 != 0) {
                        object3 = this.m_chunkBuffer;
                        ((ByteBuffer)object3).position(n10 += n12);
                    }
                    if (n12 == n11) {
                        object2 = this.m_recordDataCallback;
                        if (object2 == null) continue block3;
                        object = this.m_chunkBuffer;
                        n12 = 1024;
                        object2.onAudioRecordDataArrived((ByteBuffer)object, n12);
                        continue block3;
                    }
                    Thread.sleep(l10);
                }
                break;
            }
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)string3, (String)object);
            exception.printStackTrace();
            return;
        }
    }

    public void releaseAudioRecorder() {
        AudioRecord audioRecord = this.m_recorder;
        if (audioRecord != null) {
            audioRecord.release();
            audioRecord = null;
            this.m_recorder = null;
        }
    }

    public boolean startRecord(NvAndroidAudioRecorder$RecordDataCallback object) {
        Object object2;
        Object object3;
        boolean bl2 = this.m_isRecording;
        if (bl2) {
            return false;
        }
        try {
            object3 = this.m_recorder;
        }
        catch (Exception exception) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("");
            object2 = exception.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            object2 = TAG;
            Log.e((String)object2, (String)object3);
            exception.printStackTrace();
            boolean bl3 = this.m_isRecording;
            if (bl3) {
                AudioRecord audioRecord = this.m_recorder;
                audioRecord.stop();
                this.m_isRecording = false;
            }
            this.m_recordDataCallback = null;
            return false;
        }
        object3.startRecording();
        bl2 = true;
        this.m_isRecording = bl2;
        this.m_recordDataCallback = object;
        object2 = new NvAndroidAudioRecorder$1(this);
        String string2 = "Audio Recorder";
        object = new Thread((Runnable)object2, string2);
        this.m_recordingThread = object;
        ((Thread)object).start();
        return bl2;
    }

    public boolean stopRecord() {
        boolean bl2;
        Object object;
        boolean bl3 = this.m_isRecording;
        if (!bl3) {
            return false;
        }
        try {
            object = this.m_exitingRecordingThread;
            bl2 = true;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            return false;
        }
        ((AtomicInteger)object).set((int)(bl2 ? 1 : 0));
        object = this.m_recordingThread;
        ((Thread)object).join();
        object = this.m_exitingRecordingThread;
        ((AtomicInteger)object).set(0);
        bl3 = false;
        object = null;
        this.m_recordingThread = null;
        this.m_recordDataCallback = null;
        object = this.m_recorder;
        object.stop();
        this.m_isRecording = false;
        return bl2;
    }
}

