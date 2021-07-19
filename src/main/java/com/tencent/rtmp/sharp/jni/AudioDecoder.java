/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.sharp.jni.AudioDecoder$OnCompleteListener;
import com.tencent.rtmp.sharp.jni.AudioDecoder$OnProgressListener;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.RingBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;

public class AudioDecoder {
    private static final String TAG = "AudioDecoder";
    public boolean IsTenFramesReady = false;
    public int channels = 0;
    private boolean codeOver = true;
    private RingBuffer decRingBuffer = null;
    private MediaCodec.BufferInfo decodeBufferInfo = null;
    private ByteBuffer[] decodeInputBuffers = null;
    private ByteBuffer[] decodeOutputBuffers = null;
    private long fileTotalMs = 0L;
    public int m_nIndex = 0;
    private MediaCodec mediaDecode = null;
    private MediaExtractor mediaExtractor = null;
    public int nFirstThreeFrameInfo = 3;
    public int nFrameSize = 3840;
    private AudioDecoder$OnCompleteListener onCompleteListener = null;
    private AudioDecoder$OnProgressListener onProgressListener = null;
    public int sampleRate = 0;
    private String srcPath;

    private int initMediaDecode(int n10) {
        Object object;
        String string2;
        int n11;
        int n12;
        Object object2;
        Object object3;
        int n13;
        int n14;
        String string3;
        block62: {
            block63: {
                string3 = TAG;
                n14 = -1;
                n13 = 1;
                object3 = new MediaExtractor();
                this.mediaExtractor = object3;
                object2 = this.srcPath;
                object3.setDataSource((String)object2);
                object3 = this.mediaExtractor;
                n12 = object3.getTrackCount();
                object2 = "TRAE";
                n11 = 2;
                string2 = "m_nIndex: ";
                if (n12 <= n13) break block62;
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 == 0) break block63;
                object = new StringBuilder();
                object.append(string2);
                n12 = this.m_nIndex;
                object.append(n12);
                object3 = " initMediaDecode mediaExtractor container video, getTrackCount: ";
                object.append((String)object3);
                object3 = this.mediaExtractor;
                n12 = object3.getTrackCount();
                object.append(n12);
                object = object.toString();
                QLog.w((String)object2, n11, (String)object);
            }
            try {
                this.codeOver = n13;
                return -2;
            }
            catch (IOException iOException) {
                TXCLog.e(string3, "init media decode failed.", iOException);
                this.codeOver = n13;
                return n14;
            }
        }
        n12 = 0;
        object3 = null;
        int n15 = 0;
        Object object4 = null;
        while (true) {
            block65: {
                CharSequence charSequence;
                boolean bl2;
                String string4;
                int n16;
                Object object5;
                block64: {
                    object5 = this.mediaExtractor;
                    n16 = object5.getTrackCount();
                    if (n15 >= n16) break;
                    object5 = this.mediaExtractor;
                    object5 = object5.getTrackFormat(n15);
                    string4 = "mime";
                    string4 = object5.getString(string4);
                    bl2 = QLog.isColorLevel();
                    if (!bl2) break block64;
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2);
                    int n17 = this.m_nIndex;
                    ((StringBuilder)charSequence).append(n17);
                    String string5 = " initMediaDecode mediaExtractor audio type:";
                    ((StringBuilder)charSequence).append(string5);
                    ((StringBuilder)charSequence).append(string4);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w((String)object2, n11, (String)charSequence);
                }
                charSequence = "audio/mpeg";
                bl2 = string4.startsWith((String)charSequence);
                if (!bl2) break block65;
                charSequence = this.mediaExtractor;
                charSequence.selectTrack(n15);
                object4 = MediaCodec.createDecoderByType((String)string4);
                this.mediaDecode = object4;
                string4 = null;
                object4.configure((MediaFormat)object5, null, null, 0);
                object4 = "sample-rate";
                n15 = object5.getInteger((String)object4);
                this.sampleRate = n15;
                object4 = "channel-count";
                n15 = object5.getInteger((String)object4);
                this.channels = n15;
                object4 = "durationUs";
                long l10 = object5.getLong((String)object4);
                long l11 = 1000L;
                l10 /= l11;
                this.fileTotalMs = l10;
                n15 = this.sampleRate;
                n16 = this.channels;
                n15 = n15 * n16 * n11 * 20;
                n15 /= 1000;
                this.nFrameSize = n15;
                n15 *= n10;
                object5 = new RingBuffer(n15);
                this.decRingBuffer = object5;
                n15 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n15 == 0) break;
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string2);
                n16 = this.m_nIndex;
                ((StringBuilder)object4).append(n16);
                object5 = " initMediaDecode open succeed, mp3 format:(";
                ((StringBuilder)object4).append((String)object5);
                n16 = this.sampleRate;
                ((StringBuilder)object4).append(n16);
                object5 = ",";
                ((StringBuilder)object4).append((String)object5);
                n16 = this.channels;
                ((StringBuilder)object4).append(n16);
                object5 = "), fileTotalMs:";
                ((StringBuilder)object4).append((String)object5);
                long l12 = this.fileTotalMs;
                ((StringBuilder)object4).append(l12);
                object5 = "ms RingBufferFrame:";
                ((StringBuilder)object4).append((String)object5);
                ((StringBuilder)object4).append(n10);
                object = ((StringBuilder)object4).toString();
                QLog.w((String)object2, n11, (String)object);
                break;
            }
            ++n15;
        }
        if ((object = this.mediaDecode) == null) {
            object = new StringBuilder();
            object.append(string2);
            n12 = this.m_nIndex;
            object.append(n12);
            object.append(" initMediaDecode create mediaDecode failed");
            object = object.toString();
            Log.e((String)string3, (String)object);
            this.codeOver = n13;
            return n14;
        }
        object2 = this.decRingBuffer;
        if (object2 == null) {
            object = new StringBuilder();
            object.append(string2);
            n12 = this.m_nIndex;
            object.append(n12);
            object.append(" initMediaDecode create decRingBuffer failed");
            object = object.toString();
            Log.e((String)string3, (String)object);
            this.codeOver = n13;
            return n14;
        }
        object.start();
        object = this.mediaDecode.getInputBuffers();
        this.decodeInputBuffers = object;
        object = this.mediaDecode.getOutputBuffers();
        this.decodeOutputBuffers = object;
        this.decodeBufferInfo = object = new MediaCodec.BufferInfo();
        this.codeOver = false;
        this.IsTenFramesReady = false;
        this.nFirstThreeFrameInfo = 3;
        return 0;
    }

    private void showLog(String string2) {
        Log.e((String)"AudioCodec", (String)string2);
    }

    private void srcAudioFormatToPCM() {
        int n10;
        int n11;
        Object object = this.decodeInputBuffers;
        int n12 = ((ByteBuffer[])object).length;
        Object object2 = "m_nIndex: ";
        int n13 = 2;
        String string2 = "TRAE";
        int n14 = 1;
        if (n12 <= n14) {
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                int n15 = this.m_nIndex;
                ((StringBuilder)object).append(n15);
                ((StringBuilder)object).append(" srcAudioFormatToPCM decodeInputBuffers.length to small,");
                object2 = this.decodeInputBuffers;
                n15 = ((ByteBuffer[])object2).length;
                ((StringBuilder)object).append(n15);
                object = ((StringBuilder)object).toString();
                QLog.w(string2, n13, (String)object);
            }
            this.codeOver = n14;
            return;
        }
        object = this.mediaDecode;
        long l10 = -1;
        int n16 = object.dequeueInputBuffer(l10);
        if (n16 < 0) {
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object2);
                int n17 = this.m_nIndex;
                ((StringBuilder)object).append(n17);
                object2 = " srcAudioFormatToPCM decodeInputBuffers.inputIndex <0";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                QLog.w(string2, n13, (String)object);
            }
            this.codeOver = n14;
            return;
        }
        n12 = Build.VERSION.SDK_INT;
        int n18 = 21;
        Object object3 = n12 >= n18 ? this.mediaDecode.getInputBuffer(n16) : this.decodeInputBuffers[n16];
        ((ByteBuffer)object3).clear();
        Object object4 = this.mediaExtractor;
        int n19 = object4.readSampleData((ByteBuffer)object3, 0);
        if (n19 < 0) {
            n11 = QLog.isColorLevel();
            if (n11 != 0) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                n10 = this.m_nIndex;
                ((StringBuilder)object3).append(n10);
                object4 = " srcAudioFormatToPCM readSampleData over,end";
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                QLog.w(string2, n13, (String)object3);
            }
            this.codeOver = n14;
        } else {
            object4 = this.mediaDecode;
            long l11 = 0L;
            object4.queueInputBuffer(n16, 0, n19, l11, 0);
            object3 = this.mediaExtractor;
            object3.advance();
        }
        object3 = this.mediaDecode;
        object4 = this.decodeBufferInfo;
        long l12 = 10000L;
        n11 = object3.dequeueOutputBuffer((MediaCodec.BufferInfo)object4, l12);
        while (n11 >= 0) {
            object4 = n12 >= n18 ? this.mediaDecode.getOutputBuffer(n11) : this.decodeOutputBuffers[n11];
            n19 = this.decodeBufferInfo.size;
            Object object5 = new byte[n19];
            try {
                ((ByteBuffer)object4).get((byte[])object5);
                ((ByteBuffer)object4).clear();
            }
            catch (Exception exception) {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    int n20 = this.m_nIndex;
                    ((StringBuilder)object).append(n20);
                    object2 = " srcAudioFormatToPCM wrong outputIndex: ";
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(n11);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string2, n13, (String)object);
                }
                this.codeOver = n14;
                break;
            }
            object4 = this.decRingBuffer;
            if (object4 != null) {
                MediaCodec.BufferInfo bufferInfo = this.decodeBufferInfo;
                int n21 = bufferInfo.size;
                if (n21 > 0) {
                    ((RingBuffer)object4).Push((byte[])object5, n21);
                    n10 = this.nFirstThreeFrameInfo;
                    this.nFirstThreeFrameInfo = n19 = n10 + -1;
                    if (n10 > 0 && (n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append((String)object2);
                        n19 = this.m_nIndex;
                        ((StringBuilder)object4).append(n19);
                        ((StringBuilder)object4).append(" DecodeOneFrame size: ");
                        n19 = this.decodeBufferInfo.size;
                        ((StringBuilder)object4).append(n19);
                        ((StringBuilder)object4).append(" Remain: ");
                        object5 = this.decRingBuffer;
                        n19 = ((RingBuffer)object5).RemainRead();
                        n21 = this.nFrameSize;
                        ((StringBuilder)object4).append(n19 /= n21);
                        object4 = ((StringBuilder)object4).toString();
                        QLog.w(string2, n13, (String)object4);
                    }
                }
            }
            object4 = this.mediaDecode;
            object4.releaseOutputBuffer(n11, false);
            object3 = this.decodeBufferInfo;
            n10 = ((MediaCodec.BufferInfo)object3).size;
            if (n10 > 0) break;
            object4 = this.mediaDecode;
            n11 = object4.dequeueOutputBuffer((MediaCodec.BufferInfo)object3, l12);
        }
    }

    public int ReadOneFrame(byte[] byArray, int n10) {
        RingBuffer ringBuffer;
        int n11;
        int n12 = this.IsTenFramesReady;
        int n13 = 10;
        int n14 = 20;
        if (n12 == 0) {
            int n15;
            Object object;
            n12 = n14;
            while (true) {
                object = this.decRingBuffer;
                n11 = ((RingBuffer)object).RemainRead();
                n15 = this.nFrameSize;
                if ((n11 /= n15) >= n13) break;
                n11 = n12 + -1;
                if (n12 <= 0 || (n12 = (int)(this.codeOver ? 1 : 0)) != 0) break;
                this.srcAudioFormatToPCM();
                n12 = n11;
            }
            if ((n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                n12 = 2;
                object = new StringBuilder();
                ((StringBuilder)object).append("m_nIndex: ");
                n15 = this.m_nIndex;
                ((StringBuilder)object).append(n15);
                ((StringBuilder)object).append(" 10 FramesReady Remain frame: ");
                n15 = this.decRingBuffer.RemainRead();
                int n16 = this.nFrameSize;
                ((StringBuilder)object).append(n15 /= n16);
                object = ((StringBuilder)object).toString();
                String string2 = "TRAE";
                QLog.w(string2, n12, (String)object);
            }
            n12 = 1;
            this.IsTenFramesReady = n12;
        }
        while ((n12 = (int)(this.codeOver ? 1 : 0)) == 0) {
            ringBuffer = this.decRingBuffer;
            n12 = ringBuffer.RemainRead();
            n11 = this.nFrameSize;
            if ((n12 /= n11) >= n13) break;
            n12 = n14 + -1;
            if (n14 <= 0) break;
            this.srcAudioFormatToPCM();
            n14 = n12;
        }
        if ((n12 = (ringBuffer = this.decRingBuffer).RemainRead()) >= n10) {
            ringBuffer = this.decRingBuffer;
            ringBuffer.Pop(byArray, n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int SeekTo(int n10) {
        Object object = this.mediaExtractor;
        if (object != null) {
            long l10;
            long l11 = object.getSampleTime();
            Object object2 = this.decRingBuffer;
            int n11 = ((RingBuffer)object2).RemainRead() * 20;
            int n12 = this.nFrameSize;
            n10 += (n11 /= n12);
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            String string2 = "m_nIndex: ";
            String string3 = "TRAE";
            long l12 = 1000L;
            int n13 = 2;
            if (n11 != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                int n14 = this.m_nIndex;
                ((StringBuilder)object2).append(n14);
                ((StringBuilder)object2).append(" current PlayMs: ");
                l10 = l11 / l12;
                ((StringBuilder)object2).append(l10);
                String string4 = " SeekTo: ";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n10);
                object2 = ((StringBuilder)object2).toString();
                QLog.w(string3, n13, (String)object2);
            }
            object2 = this.mediaExtractor;
            l10 = n10 * 1000;
            object2.seekTo(l10, n13);
            MediaExtractor mediaExtractor = this.mediaExtractor;
            l10 = mediaExtractor.getSampleTime();
            l11 = (l10 - l11) / l12;
            n10 = (int)l11;
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                int n15 = this.m_nIndex;
                ((StringBuilder)object).append(n15);
                ((StringBuilder)object).append(" total SeekTo time: ");
                ((StringBuilder)object).append(n10);
                String string5 = " t2:";
                ((StringBuilder)object).append(string5);
                ((StringBuilder)object).append(l10 /= l12);
                object = ((StringBuilder)object).toString();
                QLog.w(string3, n13, (String)object);
            }
            return n10;
        }
        return 0;
    }

    public int getChannels() {
        return this.channels;
    }

    public long getFileTotalMs() {
        return this.fileTotalMs;
    }

    public int getFrameSize() {
        return this.nFrameSize;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int prepare(int n10) {
        String string2 = this.srcPath;
        if (string2 == null) {
            return -1;
        }
        return this.initMediaDecode(n10);
    }

    public void release() {
        Object object = this.mediaDecode;
        if (object != null) {
            object.stop();
            object = this.mediaDecode;
            object.release();
            this.mediaDecode = null;
        }
        if ((object = this.mediaExtractor) != null) {
            object.release();
            this.mediaExtractor = null;
        }
        if ((object = this.onCompleteListener) != null) {
            this.onCompleteListener = null;
        }
        if ((object = this.onProgressListener) != null) {
            this.onProgressListener = null;
        }
        this.showLog("release");
    }

    public void setIOPath(String string2) {
        this.srcPath = string2;
    }

    public void setIndex(int n10) {
        this.m_nIndex = n10;
    }

    public void setOnCompleteListener(AudioDecoder$OnCompleteListener audioDecoder$OnCompleteListener) {
        this.onCompleteListener = audioDecoder$OnCompleteListener;
    }

    public void setOnProgressListener(AudioDecoder$OnProgressListener audioDecoder$OnProgressListener) {
        this.onProgressListener = audioDecoder$OnProgressListener;
    }
}

