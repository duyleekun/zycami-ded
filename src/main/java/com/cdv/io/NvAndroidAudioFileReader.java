/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.util.Log
 */
package com.cdv.io;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import com.cdv.io.NvAndroidAudioFileReader$AudioFrame;
import com.cdv.utils.NvAndroidUtils;
import java.nio.ByteBuffer;

public class NvAndroidAudioFileReader {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_OK = 0;
    private static final String TAG = "NvAndroidAudioFileReader";
    private static final boolean m_verbose = false;
    private int m_audioTrackIndex = -1;
    private MediaCodec.BufferInfo m_bufferInfo = null;
    private int m_channelCount = 1;
    private MediaCodec m_decoder = null;
    public ByteBuffer[] m_decoderInputBuffers = null;
    public ByteBuffer[] m_decoderOutputBuffers = null;
    private boolean m_decoderSetupFailed = false;
    private boolean m_decoderStarted = false;
    private long m_duration = 0L;
    private MediaExtractor m_extractor = null;
    private MediaFormat m_format = null;
    private boolean m_inputBufferQueued = false;
    private int m_pcmEncoding = 2;
    private int m_pendingInputFrameCount = 0;
    private int m_sampleRate = 44100;
    private boolean m_sawInputEOS = false;
    private boolean m_sawOutputEOS = false;

    public NvAndroidAudioFileReader() {
        MediaCodec.BufferInfo bufferInfo;
        this.m_bufferInfo = bufferInfo = new MediaCodec.BufferInfo();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void cleanupDecoder() {
        var1_1 = this.m_decoder;
        if (var1_1 == null) ** GOTO lbl36
        var2_3 = this.m_decoderStarted;
        if (!var2_3) ** GOTO lbl33
        var2_3 = this.m_inputBufferQueued;
        if (!var2_3) ** GOTO lbl15
        try {
            var1_1.flush();
        }
        catch (Exception v0) {
            ** continue;
        }
lbl12:
        // 2 sources

        while (true) {
            this.m_inputBufferQueued = false;
lbl15:
            // 2 sources

            var1_1 = this.m_decoder;
            try {
                var1_1.stop();
            }
            catch (Exception var1_2) {
                var3_4 /* !! */  = new StringBuilder();
                var3_4 /* !! */ .append("");
                var4_5 = var1_2.getMessage();
                var3_4 /* !! */ .append(var4_5);
                var3_4 /* !! */  = var3_4 /* !! */ .toString();
                var4_5 = "NvAndroidAudioFileReader";
                Log.e((String)var4_5, (String)var3_4 /* !! */ );
                var1_2.printStackTrace();
            }
            this.m_decoderStarted = false;
            this.m_decoderInputBuffers = null;
lbl33:
            // 2 sources

            var1_1 = this.m_decoder;
            var1_1.release();
            this.m_decoder = null;
lbl36:
            // 2 sources

            this.m_pendingInputFrameCount = 0;
            this.m_sawInputEOS = false;
            this.m_sawOutputEOS = false;
            return;
        }
    }

    private NvAndroidAudioFileReader$AudioFrame decodeNextFrame() {
        int n10;
        NvAndroidAudioFileReader nvAndroidAudioFileReader = this;
        int n11 = this.m_decoderInputBuffers.length;
        int n12 = 3;
        int n13 = 2;
        int n14 = Math.max(n11 /= n12, n13);
        NvAndroidAudioFileReader$AudioFrame nvAndroidAudioFileReader$AudioFrame = new NvAndroidAudioFileReader$AudioFrame();
        n11 = 0;
        Object object = null;
        while (true) {
            int n15;
            int n16;
            Object object2;
            int n17;
            Object object3;
            long l10;
            Object object4;
            int n18;
            int n19 = nvAndroidAudioFileReader.m_sawOutputEOS;
            n10 = 1;
            if (n19 != 0) break;
            n19 = nvAndroidAudioFileReader.m_sawInputEOS;
            String string2 = TAG;
            if (n19 == 0 && (n18 = (object4 = nvAndroidAudioFileReader.m_decoder).dequeueInputBuffer(l10 = 500L)) >= 0) {
                int n20;
                long l11;
                object3 = nvAndroidAudioFileReader.m_extractor;
                object4 = nvAndroidAudioFileReader.m_decoderInputBuffers[n18];
                n17 = object3.readSampleData((ByteBuffer)object4, 0);
                if (n17 < 0) {
                    object2 = nvAndroidAudioFileReader.m_decoder;
                    n16 = 0;
                    n17 = 0;
                    l11 = 0L;
                    n20 = 4;
                    object2.queueInputBuffer(n18, 0, 0, l11, n20);
                    nvAndroidAudioFileReader.m_sawInputEOS = n10;
                } else {
                    object4 = nvAndroidAudioFileReader.m_extractor;
                    n19 = object4.getSampleTrackIndex();
                    if (n19 != (n15 = nvAndroidAudioFileReader.m_audioTrackIndex)) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("WEIRD: got sample from track ");
                        n15 = nvAndroidAudioFileReader.m_extractor.getSampleTrackIndex();
                        ((StringBuilder)object4).append(n15);
                        object3 = ", expected ";
                        ((StringBuilder)object4).append((String)object3);
                        n15 = nvAndroidAudioFileReader.m_audioTrackIndex;
                        ((StringBuilder)object4).append(n15);
                        object4 = ((StringBuilder)object4).toString();
                        Log.w((String)string2, (String)object4);
                    }
                    l11 = nvAndroidAudioFileReader.m_extractor.getSampleTime();
                    object2 = nvAndroidAudioFileReader.m_decoder;
                    n16 = 0;
                    n20 = 0;
                    object2.queueInputBuffer(n18, 0, n17, l11, 0);
                    nvAndroidAudioFileReader.m_inputBufferQueued = n10;
                    nvAndroidAudioFileReader.m_pendingInputFrameCount = n19 = nvAndroidAudioFileReader.m_pendingInputFrameCount + n10;
                    object4 = nvAndroidAudioFileReader.m_extractor;
                    object4.advance();
                }
            }
            if ((n19 = nvAndroidAudioFileReader.m_pendingInputFrameCount) <= n14 && (n19 = (int)(nvAndroidAudioFileReader.m_sawInputEOS ? 1 : 0)) == 0) {
                n19 = 0;
                object4 = null;
            } else {
                n19 = 500;
            }
            object3 = nvAndroidAudioFileReader.m_decoder;
            MediaCodec.BufferInfo bufferInfo = nvAndroidAudioFileReader.m_bufferInfo;
            long l12 = n19;
            n19 = object3.dequeueOutputBuffer(bufferInfo, l12);
            n15 = n11 + 1;
            n11 = -1;
            bufferInfo = null;
            if (n19 != n11) {
                n11 = -3;
                if (n19 == n11) {
                    object = nvAndroidAudioFileReader.m_decoder.getOutputBuffers();
                    nvAndroidAudioFileReader.m_decoderOutputBuffers = object;
                } else {
                    n11 = -2;
                    if (n19 == n11) {
                        object = nvAndroidAudioFileReader.m_decoder.getOutputFormat();
                        nvAndroidAudioFileReader.parseMediaFormat((MediaFormat)object);
                    } else {
                        if (n19 < 0) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Unexpected result from decoder.dequeueOutputBuffer: ");
                            ((StringBuilder)object).append(n19);
                            object = ((StringBuilder)object).toString();
                            Log.e((String)string2, (String)object);
                            return null;
                        }
                        object = nvAndroidAudioFileReader.m_bufferInfo;
                        int n21 = ((MediaCodec.BufferInfo)object).flags;
                        n18 = 4;
                        if ((n21 &= n18) != 0) {
                            nvAndroidAudioFileReader.m_sawOutputEOS = n10;
                        } else {
                            nvAndroidAudioFileReader.m_pendingInputFrameCount = n21 = nvAndroidAudioFileReader.m_pendingInputFrameCount - n10;
                        }
                        n11 = ((MediaCodec.BufferInfo)object).size;
                        if (n11 == 0) {
                            n10 = 0;
                        }
                        if (n10 != 0) {
                            nvAndroidAudioFileReader$AudioFrame.channelCount = n21 = nvAndroidAudioFileReader.m_channelCount;
                            nvAndroidAudioFileReader$AudioFrame.sampleRate = n16 = nvAndroidAudioFileReader.m_sampleRate;
                            nvAndroidAudioFileReader$AudioFrame.sampleSize = 16;
                            n16 = nvAndroidAudioFileReader.m_pcmEncoding;
                            n17 = 8;
                            if (n16 == n12) {
                                nvAndroidAudioFileReader$AudioFrame.sampleSize = n17;
                            } else if (n16 == n18) {
                                nvAndroidAudioFileReader$AudioFrame.sampleSize = n18 = 32;
                            }
                            n18 = nvAndroidAudioFileReader$AudioFrame.sampleSize / n17 * n21;
                            nvAndroidAudioFileReader$AudioFrame.sampleCount = n11 /= n18;
                            object = nvAndroidAudioFileReader.m_decoderOutputBuffers;
                            object = object[n19];
                            ((ByteBuffer)object).position(0);
                            object2 = nvAndroidAudioFileReader.m_bufferInfo;
                            n21 = ((MediaCodec.BufferInfo)object2).size;
                            ((ByteBuffer)object).limit(n21);
                            object2 = nvAndroidAudioFileReader.m_bufferInfo;
                            n21 = ((MediaCodec.BufferInfo)object2).size;
                            object2 = ByteBuffer.allocateDirect(n21);
                            ((ByteBuffer)object2).put((ByteBuffer)object);
                            nvAndroidAudioFileReader$AudioFrame.audioFrame = object2;
                            object = nvAndroidAudioFileReader.m_bufferInfo;
                            l12 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                            nvAndroidAudioFileReader$AudioFrame.pts = l12;
                            try {
                                nvAndroidAudioFileReader$AudioFrame.retCode = 0;
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                nvAndroidAudioFileReader$AudioFrame.retCode = n13;
                                n10 = 0;
                            }
                        }
                        object = nvAndroidAudioFileReader.m_decoder;
                        object.releaseOutputBuffer(n19, false);
                        if (n10 != 0) {
                            return nvAndroidAudioFileReader$AudioFrame;
                        }
                    }
                }
            }
            if (n15 > (n11 = 100)) {
                Log.e((String)string2, (String)"We have tried too many times and can't decode a frame!");
                return null;
            }
            n11 = n15;
        }
        nvAndroidAudioFileReader$AudioFrame.retCode = n10;
        return nvAndroidAudioFileReader$AudioFrame;
    }

    private boolean isValid() {
        boolean bl2;
        MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodec = null;
        }
        return bl2;
    }

    private void parseMediaFormat(MediaFormat mediaFormat) {
        int n10;
        String string2 = "channel-count";
        boolean bl2 = mediaFormat.containsKey(string2);
        if (bl2) {
            this.m_channelCount = n10 = mediaFormat.getInteger(string2);
        }
        if (bl2 = mediaFormat.containsKey(string2 = "sample-rate")) {
            this.m_sampleRate = n10 = mediaFormat.getInteger(string2);
        }
        if (bl2 = mediaFormat.containsKey(string2 = "pcm-encoding")) {
            int n11;
            this.m_pcmEncoding = n11 = mediaFormat.getInteger(string2);
        }
    }

    private boolean setupDecoder(String string2) {
        String string3;
        ByteBuffer[] byteBufferArray;
        try {
            string2 = MediaCodec.createDecoderByType((String)string2);
        }
        catch (Exception exception) {
            byteBufferArray = new StringBuilder();
            byteBufferArray.append("");
            string3 = exception.getMessage();
            byteBufferArray.append(string3);
            byteBufferArray = byteBufferArray.toString();
            Log.e((String)TAG, (String)byteBufferArray);
            exception.printStackTrace();
            this.cleanupDecoder();
            return false;
        }
        this.m_decoder = string2;
        byteBufferArray = this.m_format;
        string3 = null;
        string2.configure((MediaFormat)byteBufferArray, null, null, 0);
        string2 = this.m_decoder;
        string2.start();
        boolean bl2 = true;
        this.m_decoderStarted = bl2;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getInputBuffers();
        this.m_decoderInputBuffers = byteBufferArray;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getOutputBuffers();
        this.m_decoderOutputBuffers = byteBufferArray;
        return bl2;
    }

    public void closeFile() {
        this.cleanupDecoder();
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            long l10;
            int n10;
            mediaExtractor.release();
            mediaExtractor = null;
            this.m_extractor = null;
            this.m_audioTrackIndex = n10 = -1;
            this.m_format = null;
            this.m_duration = l10 = 0L;
        }
    }

    public NvAndroidAudioFileReader$AudioFrame getNextAudioFrameForPlayback() {
        boolean bl2 = this.isValid();
        if (!bl2) {
            NvAndroidAudioFileReader$AudioFrame nvAndroidAudioFileReader$AudioFrame = new NvAndroidAudioFileReader$AudioFrame();
            nvAndroidAudioFileReader$AudioFrame.retCode = 1;
            return nvAndroidAudioFileReader$AudioFrame;
        }
        try {
            return this.decodeNextFrame();
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            this.cleanupDecoder();
            return null;
        }
    }

    public boolean hasDecoderSetupFailed() {
        return this.m_decoderSetupFailed;
    }

    public boolean openFile(String string2, int n10, Context object) {
        long l10;
        String string3;
        int n11 = this.isValid();
        String string4 = TAG;
        if (n11 != 0) {
            Log.e((String)string4, (String)"You can't call OpenFile() twice!");
            return false;
        }
        object = NvAndroidUtils.createMediaExtractorFromMediaFilePath(object, string2);
        this.m_extractor = object;
        if (object == null) {
            return false;
        }
        int n12 = object.getTrackCount();
        if (n10 >= n12) {
            n10 = -1;
        }
        n11 = 0;
        while (true) {
            String string5;
            string3 = "mime";
            if (n11 >= n12) break;
            String string6 = this.m_extractor.getTrackFormat(n11).getString(string3);
            boolean bl2 = string6.startsWith(string5 = "audio/");
            if (bl2 && (n10 < 0 || n10 == 0)) {
                this.m_audioTrackIndex = n11;
                break;
            }
            ++n11;
        }
        if ((n10 = this.m_audioTrackIndex) < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to find a audio track from ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.e((String)string4, (String)string2);
            this.closeFile();
            return false;
        }
        this.m_extractor.selectTrack(n10);
        string2 = this.m_extractor;
        n10 = this.m_audioTrackIndex;
        string2 = string2.getTrackFormat(n10);
        this.m_format = string2;
        CharSequence charSequence = "durationUs";
        try {
            l10 = string2.getLong((String)charSequence);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("");
            object = exception.getMessage();
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.e((String)string4, (String)charSequence);
            exception.printStackTrace();
            this.closeFile();
            return false;
        }
        this.m_duration = l10;
        string2 = this.m_format;
        string2 = string2.getString(string3);
        this.m_decoderSetupFailed = false;
        boolean bl3 = this.setupDecoder(string2);
        n10 = 1;
        if (!bl3) {
            this.m_decoderSetupFailed = n10;
            this.closeFile();
            return false;
        }
        return n10 != 0;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int startPlayback(long var1_1) {
        var3_2 /* !! */  = this.isValid();
        var4_3 = 1;
        if (var3_2 /* !! */  == 0) {
            return var4_3;
        }
        cfr_temp_0 = (var1_1 = Math.max(var1_1, 0L)) - (var5_4 = this.m_duration);
        var3_2 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var3_2 /* !! */  >= 0) {
            return var4_3;
        }
        var3_2 /* !! */  = 2;
        try {
            var7_5 /* !! */  = this.m_extractor;
            var7_5 /* !! */ .seekTo(var1_1, 0);
            var8_6 = this.m_sawInputEOS;
            if (var8_6 || (var8_6 = this.m_sawOutputEOS)) ** GOTO lbl34
            var8_6 = this.m_inputBufferQueued;
            if (var8_6 == false) return 0;
        }
lbl17:
        // 2 sources

        catch (Exception var9_9) {
            var10_11 /* !! */  = new StringBuilder();
            var10_11 /* !! */ .append("");
            var7_5 /* !! */  = var9_9.getMessage();
            var10_11 /* !! */ .append((String)var7_5 /* !! */ );
            var10_11 /* !! */  = var10_11 /* !! */ .toString();
            Log.e((String)"NvAndroidAudioFileReader", (String)var10_11 /* !! */ );
            var9_9.printStackTrace();
            return var3_2 /* !! */ ;
        }
        var9_7 = this.m_decoder;
        var9_7.flush();
        ** GOTO lbl41
        {
            catch (Exception v0) {}
lbl34:
            // 1 sources

            this.cleanupDecoder();
            var9_8 /* !! */  = this.m_format;
            var10_10 = "mime";
            var9_8 /* !! */  = var9_8 /* !! */ .getString(var10_10);
            var8_6 = this.setupDecoder((String)var9_8 /* !! */ );
            if (var8_6 != false) return 0;
            return var3_2 /* !! */ ;
lbl41:
            // 2 sources

            ** try [egrp 2[TRYBLOCK] [7 : 102->144)] { 
lbl42:
            // 1 sources

            this.m_inputBufferQueued = false;
            this.m_pendingInputFrameCount = 0;
            return 0;
        }
    }
}

