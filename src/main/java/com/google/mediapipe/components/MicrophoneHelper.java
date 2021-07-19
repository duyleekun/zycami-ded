/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioFormat
 *  android.media.AudioFormat$Builder
 *  android.media.AudioRecord
 *  android.media.AudioRecord$Builder
 *  android.media.AudioTimestamp
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.util.Log
 */
package com.google.mediapipe.components;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.google.common.base.Preconditions;
import com.google.mediapipe.components.AudioDataConsumer;
import com.google.mediapipe.components.AudioDataProducer;
import d.h.b.a.f;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class MicrophoneHelper
implements AudioDataProducer {
    private static final int AUDIO_ENCODING = 2;
    private static final int AUDIO_SOURCE = 1;
    private static final int BUFFER_SIZE_MULTIPLIER = 2;
    private static final int BYTES_PER_SAMPLE = 2;
    private static final long DEFAULT_READ_INTERVAL_MICROS = 10000L;
    private static final long MICROS_PER_SECOND = 1000000L;
    private static final long NANOS_PER_MICROS = 1000L;
    private static final long NANOS_PER_SECOND = 1000000000L;
    private static final String TAG = "MicrophoneHelper";
    private static final long UNINITIALIZED_TIMESTAMP = Long.MIN_VALUE;
    private AudioFormat audioFormat;
    private int audioPacketBufferSize;
    private AudioRecord audioRecord;
    private int audioRecordBufferSize;
    private final int bytesPerFrame;
    private final int channelConfig;
    private AudioDataConsumer consumer;
    private long initialTimestampNanos;
    private final int minBufferSize;
    private long readIntervalMicros = 10000L;
    private boolean recording;
    private Thread recordingThread;
    private final int sampleRateInHz;
    private long startRecordingTimestampNanos;

    public MicrophoneHelper(int n10, int n11) {
        long l10;
        this.initialTimestampNanos = l10 = Long.MIN_VALUE;
        this.startRecordingTimestampNanos = l10;
        this.recording = false;
        this.sampleRateInHz = n10;
        this.channelConfig = n11;
        int n12 = 2;
        int n13 = 12;
        n13 = n11 == n13 ? n12 : 1;
        this.bytesPerFrame = n13 *= n12;
        this.minBufferSize = n10 = AudioRecord.getMinBufferSize((int)n10, (int)n11, (int)n12);
        long l11 = this.readIntervalMicros;
        this.updateBufferSizes(l11);
    }

    private /* synthetic */ void a() {
        Object object;
        int n10;
        long l10;
        int n11 = -16;
        Process.setThreadPriority((int)n11);
        this.startRecordingTimestampNanos = l10 = System.nanoTime();
        l10 = 0L;
        int n12 = 0;
        while ((n10 = this.recording) != 0 && (object = this.audioRecord) != null) {
            AudioDataConsumer audioDataConsumer;
            long l11;
            long l12;
            long l13;
            long l14;
            n10 = this.audioPacketBufferSize;
            object = ByteBuffer.allocateDirect(n10);
            try {
                this.readAudioPacket((ByteBuffer)object);
            }
            catch (IOException iOException) {
                object = iOException.getMessage();
                String string2 = TAG;
                Log.e((String)string2, (String)object);
                continue;
            }
            long l15 = n12;
            l15 = this.getTimestampNanos(l15);
            if (n12 == 0 && (l14 = (l13 = (l12 = this.initialTimestampNanos) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                l10 = l15 - l12;
            }
            l15 -= l10;
            l12 = 1000L;
            l15 /= l12;
            int n13 = ((Buffer)object).limit();
            int n14 = this.bytesPerFrame;
            n12 += (n13 /= n14);
            n13 = (int)(this.recording ? 1 : 0);
            if (n13 == 0 || (audioDataConsumer = this.consumer) == null) continue;
            AudioFormat audioFormat = this.audioFormat;
            audioDataConsumer.onNewAudioData((ByteBuffer)object, l15, audioFormat);
        }
    }

    private AudioTimestamp getAudioRecordTimestamp() {
        Object object = this.audioRecord;
        Preconditions.checkNotNull(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = new AudioTimestamp();
            Object object2 = this.audioRecord;
            String string2 = null;
            n11 = object2.getTimestamp((AudioTimestamp)object, 0);
            if (n11 == 0) {
                return object;
            }
            object = new StringBuilder();
            string2 = "audioRecord.getTimestamp failed with status: ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            object2 = TAG;
            Log.e((String)object2, (String)object);
        }
        return null;
    }

    private long getTimestampNanos(long l10) {
        long l11;
        long l12 = this.startRecordingTimestampNanos;
        AudioTimestamp audioTimestamp = this.getAudioRecordTimestamp();
        if (audioTimestamp != null) {
            l12 = audioTimestamp.framePosition;
            l11 = audioTimestamp.nanoTime;
            long l13 = l12;
            l12 = l11;
            l11 = l13;
        } else {
            l11 = 0L;
        }
        l10 = (l10 - l11) * 1000000000L;
        l11 = this.sampleRateInHz;
        return l12 + (l10 /= l11);
    }

    private void readAudioPacket(ByteBuffer object) {
        int n10;
        IOException iOException = null;
        int n11 = 0;
        StringBuilder stringBuilder = null;
        while (n11 < (n10 = ((Buffer)object).capacity())) {
            AudioRecord audioRecord;
            n10 = ((Buffer)object).capacity() - n11;
            int n12 = Build.VERSION.SDK_INT;
            int n13 = 23;
            if (n12 >= n13) {
                audioRecord = this.audioRecord;
                n10 = audioRecord.read((ByteBuffer)object, n10, 0);
            } else {
                audioRecord = this.audioRecord;
                n10 = audioRecord.read((ByteBuffer)object, n10);
            }
            if (n10 <= 0) {
                int n14 = -3;
                object = n10 != n14 ? (n10 != (n14 = -2) ? (n10 == (n14 = -6) ? "ERROR_DEAD_OBJECT" : "ERROR") : "ERROR_BAD_VALUE") : "ERROR_INVALID_OPERATION";
                stringBuilder = new StringBuilder();
                stringBuilder.append("AudioRecord.read(...) failed due to ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                iOException = new IOException((String)object);
                throw iOException;
            }
            ((ByteBuffer)object).position(n11 += n10);
        }
        ((ByteBuffer)object).position(0);
    }

    private void setupAudioRecord() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("AudioRecord(");
        int n10 = this.sampleRateInHz;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", ");
        n10 = this.audioRecordBufferSize;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(")");
        object = ((StringBuilder)object).toString();
        Object object2 = TAG;
        Log.d((String)object2, (String)object);
        object = new AudioFormat.Builder();
        object = object.setEncoding(2);
        int n11 = this.sampleRateInHz;
        object = object.setSampleRate(n11);
        n11 = this.channelConfig;
        object = object.setChannelMask(n11).build();
        this.audioFormat = object;
        object = new AudioRecord.Builder();
        n11 = 1;
        object = object.setAudioSource(n11);
        AudioFormat audioFormat = this.audioFormat;
        object = object.setAudioFormat(audioFormat);
        int n12 = this.audioRecordBufferSize;
        object = object.setBufferSizeInBytes(n12).build();
        this.audioRecord = object;
        int n13 = object.getState();
        if (n13 != n11) {
            this.audioRecord.release();
            Log.e((String)object2, (String)"AudioRecord could not open.");
            return;
        }
        object2 = new f(this);
        this.recordingThread = object = new Thread((Runnable)object2, "microphoneHelperRecordingThread");
    }

    private void updateBufferSizes(long l10) {
        int n10;
        double d10 = (double)this.bytesPerFrame * 1.0;
        double d11 = this.sampleRateInHz;
        double d12 = l10;
        this.audioPacketBufferSize = n10 = (int)Math.ceil((d10 *= d11) * d12 / 1000000.0);
        int n11 = this.minBufferSize;
        this.audioRecordBufferSize = n10 = Math.max(n10, n11) * 2;
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public void cleanup() {
        AudioRecord audioRecord = this.audioRecord;
        Preconditions.checkNotNull(audioRecord);
        boolean bl2 = this.recording;
        if (bl2) {
            return;
        }
        this.audioRecord.release();
    }

    public int getAudioPacketBufferSize() {
        return this.audioPacketBufferSize;
    }

    public int getAudioRecordBufferSize() {
        return this.audioRecordBufferSize;
    }

    public void setAudioConsumer(AudioDataConsumer audioDataConsumer) {
        this.consumer = audioDataConsumer;
    }

    public void setInitialTimestampNanos(long l10) {
        this.initialTimestampNanos = l10;
    }

    public void setReadIntervalMicros(long l10) {
        this.readIntervalMicros = l10;
        this.updateBufferSizes(l10);
    }

    public void startMicrophone() {
        int n10 = this.recording;
        if (n10 != 0) {
            return;
        }
        this.setupAudioRecord();
        this.audioRecord.startRecording();
        AudioRecord audioRecord = this.audioRecord;
        n10 = audioRecord.getRecordingState();
        int n11 = 3;
        String string2 = TAG;
        if (n10 != n11) {
            Log.e((String)string2, (String)"AudioRecord couldn't start recording.");
            this.audioRecord.release();
            return;
        }
        this.recording = true;
        this.recordingThread.start();
        Log.d((String)string2, (String)"AudioRecord is recording audio.");
    }

    public void stopMicrophone() {
        this.stopMicrophoneWithoutCleanup();
        this.cleanup();
        Log.d((String)TAG, (String)"AudioRecord stopped recording audio.");
    }

    public void stopMicrophoneWithoutCleanup() {
        int n10;
        Object object;
        String string2;
        block5: {
            string2 = TAG;
            object = this.audioRecord;
            Preconditions.checkNotNull(object);
            n10 = this.recording;
            if (n10 == 0) {
                return;
            }
            n10 = 0;
            object = null;
            this.recording = false;
            object = this.recordingThread;
            if (object == null) break block5;
            try {
                ((Thread)object).join();
            }
            catch (InterruptedException interruptedException) {
                String string3 = "Exception: ";
                Log.e((String)string2, (String)string3, (Throwable)interruptedException);
            }
        }
        this.audioRecord.stop();
        object = this.audioRecord;
        n10 = object.getRecordingState();
        int n11 = 1;
        if (n10 != n11) {
            object = "AudioRecord.stop() didn't run properly.";
            Log.e((String)string2, (String)object);
        }
    }
}

