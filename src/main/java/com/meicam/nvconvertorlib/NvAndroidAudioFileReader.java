/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Surface
 */
package com.meicam.nvconvertorlib;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvConvertorUtils;
import com.meicam.nvconvertorlib.NvVideoFrame;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class NvAndroidAudioFileReader {
    private static final String TAG = "NvAudioReader";
    private static Method m_setOnFrameAvailableListener2;
    private static final boolean m_verbose = false;
    private MediaFormat m_Outputformat = null;
    private int m_audioTrackIndex = -1;
    private MediaCodec.BufferInfo m_bufferInfo = null;
    private NvVideoFrame m_cachedDecodedSample;
    private MediaCodec m_decoder = null;
    public ByteBuffer[] m_decoderInputBuffers = null;
    public ByteBuffer[] m_decoderOutputBuffers = null;
    private boolean m_decoderStarted = false;
    private long m_duration = 0L;
    private MediaExtractor m_extractor = null;
    private boolean m_extractorInOriginalState = true;
    private boolean m_firstPlaybackSampleAvailable;
    private MediaFormat m_format = null;
    private boolean m_frameAvailable;
    private Object m_frameSyncObject;
    private boolean m_inputBufferQueued;
    private int m_pendingInputFrameCount;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;
    private Surface m_surface = null;
    private SurfaceTexture m_surfaceTexture = null;
    private long m_timestampOfCurTexFrame;
    private long m_timestampOfLastDecodedFrame;

    public NvAndroidAudioFileReader() {
        Object object;
        long l10;
        Object object2;
        this.m_frameSyncObject = object2 = new Object();
        this.m_frameAvailable = false;
        this.m_cachedDecodedSample = null;
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_firstPlaybackSampleAvailable = false;
        this.m_inputBufferQueued = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.m_bufferInfo = object = new MediaCodec.BufferInfo();
        this.m_cachedDecodedSample = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void CleanupDecoder() {
        long l10;
        MediaCodec mediaCodec = this.m_decoder;
        if (mediaCodec != null) {
            boolean bl2 = this.m_decoderStarted;
            if (bl2) {
                try {
                    bl2 = this.m_inputBufferQueued;
                    if (bl2) {
                        mediaCodec.flush();
                        this.m_inputBufferQueued = false;
                    }
                    mediaCodec = this.m_decoder;
                    mediaCodec.stop();
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("");
                    String string2 = exception.getMessage();
                    stringBuilder.append(string2);
                    String string3 = stringBuilder.toString();
                    string2 = TAG;
                    Logger.e(string2, string3);
                    exception.printStackTrace();
                }
                this.m_decoderStarted = false;
                this.m_decoderInputBuffers = null;
                this.m_decoderOutputBuffers = null;
            }
            mediaCodec = this.m_decoder;
            mediaCodec.release();
            this.m_decoder = null;
        }
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_firstPlaybackSampleAvailable = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    private int DecodeToFrame(long l10, long l11, NvVideoFrame nvVideoFrame) {
        try {
            return this.DoDecodeToFrame(l10, l11, nvVideoFrame);
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Logger.e(TAG, charSequence);
            exception.printStackTrace();
            this.CleanupDecoder();
            return 2;
        }
    }

    private int DoDecodeToFrame(long l10, long l11, NvVideoFrame nvVideoFrame) {
        int n10;
        String string2;
        block20: {
            int n11;
            NvAndroidAudioFileReader nvAndroidAudioFileReader = this;
            Object object = nvVideoFrame;
            ByteBuffer[] byteBufferArray = this.m_decoderInputBuffers;
            int n12 = byteBufferArray.length / 3;
            int n13 = 2;
            n12 = Math.max(n12, n13);
            int n14 = 0;
            do {
                int n15;
                MediaCodec mediaCodec;
                Object object2;
                long l12;
                Object object3;
                int n16;
                n11 = nvAndroidAudioFileReader.m_sawOutputEOS;
                string2 = TAG;
                n10 = 1;
                if (n11 != 0) break block20;
                n11 = nvAndroidAudioFileReader.m_sawInputEOS;
                if (n11 == 0 && (n16 = (object3 = nvAndroidAudioFileReader.m_decoder).dequeueInputBuffer(l12 = (long)30)) >= 0) {
                    int n17;
                    long l13;
                    object2 = nvAndroidAudioFileReader.m_extractor;
                    object3 = nvAndroidAudioFileReader.m_decoderInputBuffers[n16];
                    int n18 = object2.readSampleData((ByteBuffer)object3, 0);
                    if (n18 < 0) {
                        mediaCodec = nvAndroidAudioFileReader.m_decoder;
                        n18 = 0;
                        l13 = 0L;
                        n17 = 4;
                        mediaCodec.queueInputBuffer(n16, 0, 0, l13, n17);
                        nvAndroidAudioFileReader.m_sawInputEOS = n10;
                    } else {
                        object3 = nvAndroidAudioFileReader.m_extractor;
                        n11 = object3.getSampleTrackIndex();
                        if (n11 != (n15 = nvAndroidAudioFileReader.m_audioTrackIndex)) {
                            object3 = new StringBuilder();
                            object3.append("WEIRD: got sample from track ");
                            n15 = nvAndroidAudioFileReader.m_extractor.getSampleTrackIndex();
                            object3.append(n15);
                            object2 = ", expected ";
                            object3.append((String)object2);
                            n15 = nvAndroidAudioFileReader.m_audioTrackIndex;
                            object3.append(n15);
                            object3 = object3.toString();
                            Log.w((String)string2, (String)object3);
                        }
                        l13 = nvAndroidAudioFileReader.m_extractor.getSampleTime();
                        mediaCodec = nvAndroidAudioFileReader.m_decoder;
                        n17 = 0;
                        mediaCodec.queueInputBuffer(n16, 0, n18, l13, 0);
                        nvAndroidAudioFileReader.m_inputBufferQueued = n10;
                        nvAndroidAudioFileReader.m_pendingInputFrameCount = n11 = nvAndroidAudioFileReader.m_pendingInputFrameCount + n10;
                        object3 = nvAndroidAudioFileReader.m_extractor;
                        object3.advance();
                        nvAndroidAudioFileReader.m_extractorInOriginalState = false;
                    }
                }
                if ((n11 = nvAndroidAudioFileReader.m_pendingInputFrameCount) <= n12 && (n11 = (int)(nvAndroidAudioFileReader.m_sawInputEOS ? 1 : 0)) == 0) {
                    n11 = 0;
                    object3 = null;
                } else {
                    n11 = 30;
                }
                object2 = nvAndroidAudioFileReader.m_decoder;
                Object object4 = nvAndroidAudioFileReader.m_bufferInfo;
                long l14 = n11;
                n11 = object2.dequeueOutputBuffer((MediaCodec.BufferInfo)object4, l14);
                n14 += n10;
                n15 = -1;
                if (n11 == n15) continue;
                n15 = -3;
                if (n11 == n15) {
                    object3 = nvAndroidAudioFileReader.m_decoder.getOutputBuffers();
                    nvAndroidAudioFileReader.m_decoderOutputBuffers = object3;
                    continue;
                }
                n15 = -2;
                if (n11 == n15) {
                    object3 = nvAndroidAudioFileReader.m_decoder.getOutputFormat();
                    n15 = (int)(object3.containsKey((String)(object2 = "sample-rate")) ? 1 : 0);
                    if (n15 == 0 || (n15 = (int)(object3.containsKey((String)(object2 = "channel-count")) ? 1 : 0)) == 0) continue;
                    nvAndroidAudioFileReader.m_Outputformat = object3;
                    continue;
                }
                if (n11 < 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unexpected result from decoder.dequeueOutputBuffer: ");
                    ((StringBuilder)object).append(n11);
                    object = ((StringBuilder)object).toString();
                    Logger.e(string2, object);
                    return n13;
                }
                object2 = nvAndroidAudioFileReader.m_bufferInfo;
                int n19 = ((MediaCodec.BufferInfo)object2).flags & 4;
                if (n19 != 0) {
                    nvAndroidAudioFileReader.m_sawOutputEOS = n10;
                }
                if ((n19 = (int)(nvAndroidAudioFileReader.m_sawOutputEOS ? 1 : 0)) == 0) {
                    long l15;
                    long l16;
                    nvAndroidAudioFileReader.m_timestampOfLastDecodedFrame = l16 = ((MediaCodec.BufferInfo)object2).presentationTimeUs;
                    nvAndroidAudioFileReader.m_pendingInputFrameCount = n14 = nvAndroidAudioFileReader.m_pendingInputFrameCount - n10;
                    long l17 = Long.MIN_VALUE;
                    long l18 = l10 - l17;
                    n14 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                    n14 = n14 != 0 && (n14 = (int)((l15 = l16 - (l17 = l10 - l11)) == 0L ? 0 : (l15 < 0L ? -1 : 1))) < 0 ? 0 : n10;
                    if (n14 != 0) {
                        object4 = nvAndroidAudioFileReader.m_decoderOutputBuffers[n11];
                        n15 = ((MediaCodec.BufferInfo)object2).offset;
                        ((ByteBuffer)object4).position(n15);
                        object2 = nvAndroidAudioFileReader.m_bufferInfo;
                        int n20 = ((MediaCodec.BufferInfo)object2).offset;
                        n15 = ((MediaCodec.BufferInfo)object2).size;
                        ((ByteBuffer)object4).limit(n20 += n15);
                        if (object != null) {
                            object2 = ((NvVideoFrame)object).buffer;
                            if (object2 == null) {
                                n15 = nvAndroidAudioFileReader.m_bufferInfo.size;
                                ((NvVideoFrame)object).buffer = object2 = ByteBuffer.allocateDirect(n15);
                            } else {
                                n15 = ((Buffer)object2).limit();
                                mediaCodec = nvAndroidAudioFileReader.m_bufferInfo;
                                n20 = mediaCodec.size;
                                if (n15 < n20) {
                                    n15 = 0;
                                    ((NvVideoFrame)object).buffer = null;
                                    ((NvVideoFrame)object).buffer = object2 = ByteBuffer.allocateDirect(n20);
                                }
                            }
                            ((NvVideoFrame)object).buffer.clear();
                            object2 = ((NvVideoFrame)object).buffer;
                            ((ByteBuffer)object2).put((ByteBuffer)object4);
                            ((NvVideoFrame)object).streamTime = l12 = NvConvertorUtils.UsToNvTime(nvAndroidAudioFileReader.m_timestampOfLastDecodedFrame);
                        }
                    }
                    n15 = 0;
                    object2 = null;
                } else {
                    n15 = n14;
                    n14 = 0;
                }
                if (object == null) {
                    object4 = "audio timestamp  error";
                    Logger.e(string2, object4);
                }
                object4 = nvAndroidAudioFileReader.m_decoder;
                object4.releaseOutputBuffer(n11, false);
                n11 = (int)(nvAndroidAudioFileReader.m_sawOutputEOS ? 1 : 0);
                if (n11 == 0 && n14 != 0) {
                    return 0;
                }
                n14 = n15;
            } while (n14 <= (n11 = 100));
            Logger.e(string2, "We have tried too many times and can't decode a frame!");
            return n10;
        }
        Logger.e(string2, "audio timestamp  eof");
        return n10;
    }

    private boolean IsValid() {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int SeekInternal(long l10, long l11, NvVideoFrame nvVideoFrame) {
        long l12;
        int n10;
        long l13 = this.m_timestampOfLastDecodedFrame;
        long l14 = Long.MIN_VALUE;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        boolean bl2 = true;
        long l16 = 1500000L;
        if (!(l15 != false && (l15 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) > 0 && (n10 = (int)((l12 = l10 - (l13 += l16)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0 || (n10 = this.m_extractorInOriginalState) != 0 && (n10 = l10 == l16 ? 0 : (l10 < l16 ? -1 : 1)) < 0)) {
            bl2 = false;
        }
        if (bl2) return this.DecodeToFrame(l10, l11, nvVideoFrame);
        n10 = 2;
        try {
            MediaExtractor mediaExtractor = this.m_extractor;
            mediaExtractor.seekTo(l10, 0);
            boolean bl3 = this.m_sawInputEOS;
            if (!bl3 && !(bl3 = this.m_sawOutputEOS)) {
                bl3 = this.m_inputBufferQueued;
                if (!bl3) return this.DecodeToFrame(l10, l11, nvVideoFrame);
                MediaCodec mediaCodec = this.m_decoder;
                mediaCodec.flush();
                this.m_inputBufferQueued = false;
                this.m_pendingInputFrameCount = 0;
                return this.DecodeToFrame(l10, l11, nvVideoFrame);
            }
            this.CleanupDecoder();
            MediaFormat mediaFormat = this.m_format;
            String string2 = "mime";
            String string3 = mediaFormat.getString(string2);
            bl3 = this.SetupDecoder(string3);
            if (bl3) return this.DecodeToFrame(l10, l11, nvVideoFrame);
            return n10;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            String string5 = stringBuilder.toString();
            Logger.e(TAG, string5);
            exception.printStackTrace();
            return n10;
        }
    }

    private boolean SetupDecoder(String string2) {
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
            Logger.e(TAG, byteBufferArray);
            exception.printStackTrace();
            this.CleanupDecoder();
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

    public void CloseFile() {
        this.CleanupDecoder();
        MediaExtractor mediaExtractor = this.m_extractor;
        if (mediaExtractor != null) {
            boolean bl2;
            long l10;
            int n10;
            mediaExtractor.release();
            mediaExtractor = null;
            this.m_extractor = null;
            this.m_audioTrackIndex = n10 = -1;
            this.m_format = null;
            this.m_Outputformat = null;
            this.m_duration = l10 = 0L;
            this.m_extractorInOriginalState = bl2 = true;
        }
    }

    public MediaFormat GetAudioOutputMediaFormat() {
        return this.m_Outputformat;
    }

    public int GetNextAudioSamplesForPlayback(NvVideoFrame nvVideoFrame) {
        int n10 = this.IsValid();
        if (n10 == 0) {
            return 1;
        }
        n10 = this.m_firstPlaybackSampleAvailable;
        if (n10 == 0) {
            long l10;
            NvVideoFrame nvVideoFrame2 = this.m_cachedDecodedSample;
            Object var4_5 = null;
            nvVideoFrame2.buffer = null;
            nvVideoFrame2.streamTime = l10 = Long.MAX_VALUE;
            long l11 = Long.MIN_VALUE;
            long l12 = 0L;
            int n11 = this.DecodeToFrame(l11, l12, nvVideoFrame);
            if (n11 != 0) {
                return n11;
            }
        } else {
            long l13;
            this.m_firstPlaybackSampleAvailable = false;
            Object object = nvVideoFrame.buffer;
            if (object == null) {
                n10 = this.m_cachedDecodedSample.buffer.limit();
                object = ByteBuffer.allocateDirect(n10);
                nvVideoFrame.buffer = object;
            }
            this.m_cachedDecodedSample.buffer.clear();
            nvVideoFrame.buffer.clear();
            object = nvVideoFrame.buffer;
            ByteBuffer byteBuffer = this.m_cachedDecodedSample.buffer;
            ((ByteBuffer)object).put(byteBuffer);
            object = this.m_cachedDecodedSample;
            nvVideoFrame.streamTime = l13 = ((NvVideoFrame)object).streamTime;
        }
        return 0;
    }

    public long GetTimestampOfCurrentTextureFrame() {
        return this.m_timestampOfCurTexFrame;
    }

    public boolean OpenFile(String string2) {
        long l10;
        String string3;
        MediaExtractor mediaExtractor;
        boolean bl2 = this.IsValid();
        String string4 = TAG;
        if (bl2) {
            Logger.e(string4, "You can't call OpenFile() twice!");
            return false;
        }
        Object object = new MediaExtractor();
        this.m_extractor = object;
        object.setDataSource(string2);
        bl2 = true;
        try {
            this.m_extractorInOriginalState = bl2;
            mediaExtractor = this.m_extractor;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string5 = exception.getMessage();
            ((StringBuilder)object).append(string5);
            object = ((StringBuilder)object).toString();
            Logger.e(string4, object);
            exception.printStackTrace();
            this.CloseFile();
            return false;
        }
        int n10 = mediaExtractor.getTrackCount();
        int n11 = 0;
        while (true) {
            String string6;
            string3 = "mime";
            if (n11 >= n10) break;
            String string7 = this.m_extractor.getTrackFormat(n11).getString(string3);
            boolean bl3 = string7.startsWith(string6 = "audio/");
            if (bl3) {
                this.m_audioTrackIndex = n11;
                break;
            }
            ++n11;
        }
        if ((n10 = this.m_audioTrackIndex) < 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to find a video track from ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            Logger.e(string4, string2);
            this.CloseFile();
            return false;
        }
        this.m_extractor.selectTrack(n10);
        string2 = this.m_extractor;
        int n12 = this.m_audioTrackIndex;
        string2 = string2.getTrackFormat(n12);
        this.m_format = string2;
        n12 = Build.VERSION.SDK_INT;
        n10 = 16;
        if (n12 == n10) {
            string4 = "max-input-size";
            string2.setInteger(string4, 0);
        }
        string2 = this.m_format;
        this.m_Outputformat = string2;
        string4 = "durationUs";
        this.m_duration = l10 = string2.getLong(string4);
        string2 = this.m_format.getString(string3);
        boolean bl4 = this.SetupDecoder(string2);
        if (!bl4) {
            this.CloseFile();
            return false;
        }
        return bl2;
    }

    public int StartPlayback(long l10, long l11) {
        boolean bl2 = this.IsValid();
        int n10 = 1;
        if (!bl2) {
            return n10;
        }
        long l12 = 0L;
        long l13 = Math.max(l10, l12);
        long l14 = l13 - (l10 = this.m_duration);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0) {
            return n10;
        }
        NvVideoFrame nvVideoFrame = this.m_cachedDecodedSample;
        object = this.SeekInternal(l13, l11, nvVideoFrame);
        if (object != false) {
            return (int)object;
        }
        this.m_firstPlaybackSampleAvailable = n10;
        return 0;
    }
}

