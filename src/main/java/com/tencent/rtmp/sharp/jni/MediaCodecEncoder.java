/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MediaCodecEncoder {
    private static final String TAG = "MediaCodecEncoder";
    private static boolean mDumpEnable = false;
    private MediaCodec.BufferInfo mAACEncBufferInfo = null;
    private MediaCodec mAudioAACEncoder = null;
    private MediaFormat mAudioFormat = null;
    private int mBitrate = 32000;
    private int mChannels = 1;
    private Context mContext;
    private ByteBuffer mEncInBuffer;
    private ByteBuffer mEncOutBuffer;
    private boolean mFormatChangeFlag = false;
    private ByteBuffer mInputBuffer = null;
    private ByteBuffer[] mMediaInputBuffers;
    private ByteBuffer[] mMediaOutputBuffers;
    private ByteBuffer mOutputBuffer = null;
    private File mRecFileDump = null;
    private FileOutputStream mRecFileOut = null;
    private int mSampleRate = 48000;
    private byte[] mTempBufEncIn;
    private byte[] mTempBufEncOut;
    private int nMaxBitRate = 256000;

    public MediaCodecEncoder() {
        ByteBuffer byteBuffer;
        Object object;
        this.mContext = object = TXCCommonUtil.getAppContext();
        int n10 = 7680;
        this.mEncInBuffer = byteBuffer = ByteBuffer.allocateDirect(n10);
        object = new byte[n10];
        this.mTempBufEncIn = (byte[])object;
        object = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
        this.mEncOutBuffer = object;
        object = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
        this.mTempBufEncOut = (byte[])object;
    }

    public MediaCodecEncoder(Context object) {
        ByteBuffer byteBuffer;
        this.mContext = object;
        int n10 = 7680;
        this.mEncInBuffer = byteBuffer = ByteBuffer.allocateDirect(n10);
        object = new byte[n10];
        this.mTempBufEncIn = (byte[])object;
        object = ByteBuffer.allocateDirect(this.nMaxBitRate * 2 / 8 / 50 + 100);
        this.mEncOutBuffer = object;
        object = new byte[this.nMaxBitRate * 2 / 8 / 50 + 100];
        this.mTempBufEncOut = (byte[])object;
    }

    /*
     * Unable to fully structure code
     */
    private void addADTStoPacket(byte[] var1_1, int var2_2) {
        var3_3 = this.mSampleRate;
        var4_4 = 4;
        var5_5 = 5;
        var6_6 = 6;
        var7_7 = 3;
        var8_8 = 48000;
        if (var3_3 == var8_8) {
            while (true) {
                var3_3 = var7_7;
                break;
            }
        } else {
            var8_8 = 44100;
            if (var3_3 == var8_8) {
                var3_3 = var4_4;
            } else {
                var8_8 = 32000;
                if (var3_3 == var8_8) {
                    var3_3 = var5_5;
                } else {
                    var8_8 = 24000;
                    if (var3_3 == var8_8) {
                        var3_3 = var6_6;
                    } else {
                        if (var3_3 != (var8_8 = 16000)) ** continue;
                        var3_3 = 8;
                    }
                }
            }
        }
        var8_8 = this.mChannels;
        var1_1[0] = -1;
        var1_1[1] = -7;
        var9_9 = 2;
        var10_10 = 64 + (var3_3 <<= var9_9);
        var3_3 = var8_8 >> 2;
        var1_1[var9_9] = var3_3 = (int)((byte)(var10_10 + var3_3));
        var3_3 = (var8_8 & 3) << var6_6;
        var8_8 = var2_2 >> 11;
        var1_1[var7_7] = var3_3 = (int)((byte)(var3_3 + var8_8));
        var1_1[var4_4] = var3_3 = (int)((byte)((var2_2 & 2047) >> var7_7));
        var1_1[var5_5] = var2_2 = (int)((byte)(((var2_2 & 7) << var5_5) + 31));
        var1_1[var6_6] = -4;
    }

    private String getDumpFilePath(String string2) {
        Object object;
        Object object2;
        boolean bl2 = QLog.isColorLevel();
        int n10 = 2;
        String string3 = "TRAE";
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("manufacture:");
            object = Build.MANUFACTURER;
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n10, (String)object2);
        }
        if (bl2 = QLog.isColorLevel()) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("MODEL:");
            object = Build.MODEL;
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n10, (String)object2);
        }
        object2 = this.mContext;
        boolean bl3 = false;
        object = null;
        if (object2 == null) {
            return null;
        }
        if ((object2 = object2.getExternalFilesDir(null)) == null) {
            return null;
        }
        object = new StringBuilder();
        object2 = ((File)object2).getPath();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("/MF-");
        object2 = Build.MANUFACTURER;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("-M-");
        object2 = Build.MODEL;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("-");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        object2 = new File(string2);
        object = ((File)object2).getParentFile();
        bl3 = ((File)object).exists();
        if (!bl3) {
            object2 = ((File)object2).getParentFile();
            ((File)object2).mkdirs();
        }
        if (bl2 = QLog.isColorLevel()) {
            object2 = new StringBuilder();
            object = "dump:";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n10, (String)object2);
        }
        bl2 = QLog.isColorLevel();
        object = "_";
        String string4 = " ";
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("dump replace:");
            String string5 = string2.replace(string4, (CharSequence)object);
            ((StringBuilder)object2).append(string5);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n10, (String)object2);
        }
        return string2.replace(string4, (CharSequence)object);
    }

    /*
     * Exception decompiling
     */
    public int createAACEncoder(int var1_1, int var2_2, int var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public int encodeAACFrame(int n10) {
        int n11;
        Object object;
        Object object2;
        Object object3;
        int n12 = this.mFormatChangeFlag;
        int n13 = 0;
        String string2 = null;
        if (n12 != 0) {
            this.mFormatChangeFlag = false;
            this.mAudioAACEncoder.stop();
            object3 = this.mAudioFormat;
            int n14 = this.mBitrate;
            object2 = "bitrate";
            object3.setInteger((String)object2, n14);
            object3 = this.mAudioAACEncoder;
            object = this.mAudioFormat;
            int n15 = 1;
            n11 = 0;
            object3.configure((MediaFormat)object, null, null, n15);
            object3 = this.mAudioAACEncoder;
            object3.start();
        }
        object3 = this.mEncInBuffer;
        object = this.mTempBufEncIn;
        ((ByteBuffer)object3).get((byte[])object, 0, n10);
        n10 = this.encodeInternalAACFrame(n10);
        object3 = this.mEncOutBuffer;
        ((ByteBuffer)object3).rewind();
        if (n10 > 0) {
            block8: {
                object3 = this.mEncOutBuffer;
                object = this.mTempBufEncOut;
                ((ByteBuffer)object3).put((byte[])object, 0, n10);
                n12 = mDumpEnable;
                if (n12 != 0 && (object3 = this.mRecFileOut) != null) {
                    n12 = n10 + 7;
                    object = new byte[n12];
                    this.addADTStoPacket((byte[])object, n12);
                    object2 = this.mTempBufEncOut;
                    n11 = 7;
                    System.arraycopy(object2, 0, object, n11, n10);
                    object2 = this.mRecFileOut;
                    try {
                        ((FileOutputStream)object2).write((byte[])object, 0, n12);
                    }
                    catch (IOException iOException) {
                        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n12 == 0) break block8;
                        n12 = 2;
                        string2 = TAG;
                        object = "write file failed.";
                        QLog.e(string2, n12, (String)object);
                    }
                }
            }
            n13 = n10;
        }
        return n13;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int encodeInternalAACFrame(int n10) {
        Object object;
        long l10;
        MediaCodec.BufferInfo bufferInfo;
        Object object2;
        Object object3;
        int n11 = Build.VERSION.SDK_INT;
        String string2 = TAG;
        int n12 = 2;
        int n13 = 0;
        MediaCodec mediaCodec = this.mAudioAACEncoder;
        long l11 = 2000L;
        int n14 = mediaCodec.dequeueInputBuffer(l11);
        int n15 = -1;
        int n16 = 21;
        if (n14 != n15) {
            if (n11 >= n16) {
                ByteBuffer byteBuffer;
                MediaCodec mediaCodec2 = this.mAudioAACEncoder;
                this.mInputBuffer = byteBuffer = mediaCodec2.getInputBuffer(n14);
            } else {
                ByteBuffer byteBuffer;
                MediaCodec mediaCodec3 = this.mAudioAACEncoder;
                ByteBuffer[] byteBufferArray = mediaCodec3.getInputBuffers();
                this.mMediaInputBuffers = byteBufferArray;
                this.mInputBuffer = byteBuffer = byteBufferArray[n14];
            }
            ByteBuffer byteBuffer = this.mInputBuffer;
            byteBuffer.clear();
            ByteBuffer byteBuffer2 = this.mInputBuffer;
            object3 = this.mTempBufEncIn;
            byteBuffer2.put((byte[])object3, 0, n10);
            MediaCodec mediaCodec4 = this.mAudioAACEncoder;
            long l12 = 0L;
            mediaCodec4.queueInputBuffer(n14, 0, n10, l12, 0);
            object2 = this.mEncInBuffer;
            ((ByteBuffer)object2).rewind();
        }
        if ((n10 = (object2 = this.mAudioAACEncoder).dequeueOutputBuffer(bufferInfo = this.mAACEncBufferInfo, l10 = 0L)) < 0) {
            return 0;
        }
        MediaCodec.BufferInfo bufferInfo2 = this.mAACEncBufferInfo;
        n15 = bufferInfo2.size;
        if (n11 >= n16) {
            object = this.mAudioAACEncoder;
            object = object.getOutputBuffer(n10);
            this.mOutputBuffer = object;
        } else {
            object = this.mAudioAACEncoder;
            object = object.getOutputBuffers();
            this.mMediaOutputBuffers = object;
            object = object[n10];
            this.mOutputBuffer = object;
        }
        object = this.mAACEncBufferInfo;
        n16 = ((MediaCodec.BufferInfo)object).flags & n12;
        n16 = n16 == n12 ? 0 : ((MediaCodec.BufferInfo)object).size;
        try {
            object3 = this.mOutputBuffer;
            n11 = ((MediaCodec.BufferInfo)object).offset;
            ((ByteBuffer)object3).position(n11);
            object = this.mOutputBuffer;
            object3 = this.mAACEncBufferInfo;
            int n17 = ((MediaCodec.BufferInfo)object3).offset + n15;
            ((ByteBuffer)object).limit(n17);
            object = this.mOutputBuffer;
            byte[] byArray = this.mTempBufEncOut;
            ((ByteBuffer)object).get(byArray, 0, n16);
            object = this.mOutputBuffer;
            ((ByteBuffer)object).position(0);
            object = this.mAudioAACEncoder;
            object.releaseOutputBuffer(n10, false);
            return n16;
        }
        catch (Exception exception) {
            try {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 == 0) return n16;
                object2 = "[ERROR] encoding aac stream failed!!!";
                QLog.e(string2, n12, (String)object2);
                return n16;
            }
            catch (Exception exception2) {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 == 0) return n13;
                object = new StringBuilder();
                String string3 = "encode failed.";
                ((StringBuilder)object).append(string3);
                String string4 = exception2.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                QLog.e(string2, n12, string4);
            }
        }
        return n13;
    }

    public int releaseAACEncoder() {
        boolean bl2;
        Object object;
        int n10;
        String string2;
        block7: {
            block8: {
                string2 = TAG;
                n10 = 2;
                object = this.mAudioAACEncoder;
                if (object == null) break block7;
                object.stop();
                object = this.mAudioAACEncoder;
                object.release();
                bl2 = false;
                object = null;
                this.mAudioAACEncoder = null;
                bl2 = QLog.isColorLevel();
                if (!bl2) break block8;
                object = "releaseAACEncoder, release aac encode stream succeed!!";
                try {
                    QLog.w(string2, n10, (String)object);
                }
                catch (Exception exception) {
                    boolean bl3 = QLog.isColorLevel();
                    if (!bl3) break block7;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "release aac encoder failed.";
                    stringBuilder.append(string3);
                    object = exception.getMessage();
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    QLog.e(string2, n10, (String)object);
                }
            }
            return 0;
        }
        if (bl2 = QLog.isColorLevel()) {
            object = "[ERROR] releaseAACEncoder, release aac encode stream failed!!!";
            QLog.e(string2, n10, (String)object);
        }
        return -1;
    }

    public int setAACEncodeBitrate(int n10) {
        int n11;
        MediaCodec mediaCodec = this.mAudioAACEncoder;
        if (mediaCodec != null && (n11 = this.mBitrate) != n10) {
            this.mFormatChangeFlag = true;
            this.mBitrate = n10;
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n11 != 0) {
                n11 = 2;
                CharSequence charSequence = new StringBuilder();
                String string2 = "Set AAC bitrate = ";
                charSequence.append(string2);
                charSequence.append(n10);
                String string3 = charSequence.toString();
                charSequence = TAG;
                QLog.w((String)charSequence, n11, string3);
            }
        }
        return 0;
    }
}

