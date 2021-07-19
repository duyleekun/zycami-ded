/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 */
package com.tencent.rtmp.sharp.jni;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.rtmp.sharp.jni.QLog;
import java.nio.ByteBuffer;

public class MediaCodecDecoder {
    private static final String TAG = "MediaCodecDecoder";
    private MediaCodec.BufferInfo mAACDecBufferInfo = null;
    private MediaCodec mAudioAACDecoder = null;
    private int mChannels = 2;
    private ByteBuffer mDecInBuffer;
    private ByteBuffer mDecOutBuffer;
    public ByteBuffer mInputBuffer = null;
    public ByteBuffer mOutputBuffer = null;
    private int mSampleRate = 44100;
    private byte[] mTempBufDec;

    public MediaCodecDecoder() {
        ByteBuffer byteBuffer;
        int n10 = 16384;
        this.mDecInBuffer = byteBuffer = ByteBuffer.allocateDirect(n10);
        this.mDecOutBuffer = byteBuffer = ByteBuffer.allocateDirect(n10);
        byte[] byArray = new byte[n10];
        this.mTempBufDec = byArray;
    }

    public int createAACDecoder(int n10, int n11) {
        block23: {
            String string2;
            Object object;
            String string3 = "audio/mp4a-latm";
            int n12 = 2;
            try {
                object = MediaCodec.createDecoderByType((String)string3);
            }
            catch (Exception exception) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    string2 = "TRAE";
                    String string4 = "Error when creating aac decode stream";
                    QLog.e(string2, n12, string4);
                }
                return -1;
            }
            this.mAudioAACDecoder = object;
            string3 = MediaFormat.createAudioFormat((String)string3, (int)n10, (int)n11);
            object = "sample-rate";
            string3.setInteger((String)object, n10);
            object = "channel-count";
            string3.setInteger((String)object, n11);
            object = "aac-profile";
            string3.setInteger((String)object, n12);
            object = new byte[n12];
            int n13 = 17;
            object[0] = (MediaCodec)n13;
            n13 = 1;
            int n14 = -112;
            object[n13] = (MediaCodec)n14;
            object = ByteBuffer.wrap((byte[])object);
            String string5 = "csd-0";
            string3.setByteBuffer(string5, (ByteBuffer)object);
            object = this.mAudioAACDecoder;
            n13 = 0;
            string5 = null;
            object.configure((MediaFormat)string3, null, null, 0);
            string3 = this.mAudioAACDecoder;
            if (string3 == null) break block23;
            string3.start();
            string3 = new MediaCodec.BufferInfo();
            this.mAACDecBufferInfo = string3;
            boolean bl2 = QLog.isColorLevel();
            if (!bl2) break block23;
            string3 = TAG;
            object = new StringBuilder();
            string5 = "createAACDecoder succeed!!! : (";
            ((StringBuilder)object).append(string5);
            ((StringBuilder)object).append(n10);
            string2 = ", ";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n11);
            string2 = ")";
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            QLog.w(string3, n12, string2);
        }
        return 0;
    }

    public int decodeAACFrame(int n10) {
        ByteBuffer byteBuffer = this.mDecInBuffer;
        byte[] byArray = this.mTempBufDec;
        int n11 = 0;
        byteBuffer.get(byArray, 0, n10);
        n10 = this.decodeInternalAACFrame(n10);
        byteBuffer = this.mDecOutBuffer;
        byteBuffer.rewind();
        if (n10 > 0) {
            byteBuffer = this.mDecOutBuffer;
            byArray = this.mTempBufDec;
            byteBuffer.put(byArray, 0, n10);
            n11 = n10;
        }
        return n11;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int decodeInternalAACFrame(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        String string2 = "TRAE";
        while (true) {
            long l10;
            int n12;
            Object object;
            Object object2;
            int n13 = 2;
            MediaCodec mediaCodec = this.mAudioAACDecoder;
            long l11 = 200L;
            int n14 = mediaCodec.dequeueInputBuffer(l11);
            int n15 = 21;
            if (n14 >= 0) {
                if (n11 >= n15) {
                    object2 = this.mAudioAACDecoder;
                    object2 = object2.getInputBuffer(n14);
                    this.mInputBuffer = object2;
                } else {
                    object2 = this.mAudioAACDecoder;
                    object2 = object2.getInputBuffers();
                    object2 = object2[n14];
                    this.mInputBuffer = object2;
                }
                object2 = this.mInputBuffer;
                ((ByteBuffer)object2).clear();
                object2 = this.mInputBuffer;
                object = this.mTempBufDec;
                ((ByteBuffer)object2).put((byte[])object, 0, n10);
                object2 = this.mDecInBuffer;
                ((ByteBuffer)object2).rewind();
                MediaCodec mediaCodec2 = this.mAudioAACDecoder;
                long l12 = 0L;
                mediaCodec2.queueInputBuffer(n14, 0, n10, l12, 0);
            }
            if ((n12 = (object2 = this.mAudioAACDecoder).dequeueOutputBuffer((MediaCodec.BufferInfo)(object = this.mAACDecBufferInfo), l10 = 10000L)) < 0) {
                return 0;
            }
            if (n11 >= n15) {
                ByteBuffer byteBuffer;
                MediaCodec mediaCodec3 = this.mAudioAACDecoder;
                this.mOutputBuffer = byteBuffer = mediaCodec3.getOutputBuffer(n12);
            } else {
                ByteBuffer byteBuffer;
                MediaCodec mediaCodec4 = this.mAudioAACDecoder;
                ByteBuffer[] byteBufferArray = mediaCodec4.getOutputBuffers();
                this.mOutputBuffer = byteBuffer = byteBufferArray[n12];
            }
            MediaCodec.BufferInfo bufferInfo = this.mAACDecBufferInfo;
            n15 = bufferInfo.size;
            {
                catch (Exception exception) {
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 != 0) {
                        String string3 = "decode failed.";
                        QLog.e(string2, n13, string3);
                    }
                    return 0;
                }
                try {
                    object = this.mOutputBuffer;
                    ((ByteBuffer)object).limit(n15);
                    object = this.mOutputBuffer;
                    byte[] byArray = this.mTempBufDec;
                    ((ByteBuffer)object).get(byArray, 0, n15);
                    object = this.mOutputBuffer;
                    ((ByteBuffer)object).position(0);
                    object = this.mAudioAACDecoder;
                    object.releaseOutputBuffer(n12, false);
                    return n15;
                }
                catch (Exception exception) {}
                {
                    n15 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n15 == 0) continue;
                    String string4 = "Error when decoding aac stream";
                    QLog.e(string2, n13, string4);
                    continue;
                }
            }
            break;
        }
    }

    public int releaseAACDecoder() {
        boolean bl2;
        Object object;
        int n10;
        String string2;
        block7: {
            block8: {
                string2 = "TRAE";
                n10 = 2;
                object = this.mAudioAACDecoder;
                if (object == null) break block7;
                object.stop();
                object = this.mAudioAACDecoder;
                object.release();
                bl2 = false;
                object = null;
                this.mAudioAACDecoder = null;
                bl2 = QLog.isColorLevel();
                if (!bl2) break block8;
                object = TAG;
                String string3 = "releaseAACDecoder, release aac decode stream succeed!!";
                try {
                    QLog.w((String)object, n10, string3);
                }
                catch (Exception exception) {
                    bl2 = QLog.isColorLevel();
                    if (!bl2) break block7;
                    object = "release aac decoder failed.";
                    QLog.e(string2, n10, (String)object);
                }
            }
            return 0;
        }
        if (bl2 = QLog.isColorLevel()) {
            object = "releaseAACDecoder, Error when releasing aac decode stream";
            QLog.e(string2, n10, (String)object);
        }
        return -1;
    }
}

