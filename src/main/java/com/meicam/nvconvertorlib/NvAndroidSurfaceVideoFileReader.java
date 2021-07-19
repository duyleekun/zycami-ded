/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.SurfaceTexture
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaExtractor
 *  android.media.MediaFormat
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.Surface
 */
package com.meicam.nvconvertorlib;

import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.meicam.nvconvertorlib.Logger;
import java.io.FileDescriptor;
import java.nio.ByteBuffer;

public class NvAndroidSurfaceVideoFileReader {
    private static final int ERROR_EOF = 1;
    private static final int ERROR_FAIL = 2;
    private static final int ERROR_OK = 0;
    private static final String TAG = "SurfaceVideoReader";
    private static final boolean m_verbose = false;
    private MediaCodec.BufferInfo m_bufferInfo = null;
    private MediaCodec m_decoder = null;
    public ByteBuffer[] m_decoderInputBuffers = null;
    private boolean m_decoderStarted = false;
    private long m_duration = 0L;
    public long m_endTime;
    private MediaExtractor m_extractor = null;
    private boolean m_extractorInOriginalState = true;
    private boolean m_firstPlaybackTexFrameUnconsumed;
    public MediaFormat m_format = null;
    public Object m_frameSyncObject;
    private boolean m_inputBufferQueued;
    private int m_pendingInputFrameCount;
    private boolean m_sawInputEOS;
    private boolean m_sawOutputEOS;
    public long m_startTime;
    private Surface m_surface = null;
    private SurfaceTexture m_surfaceTexture = null;
    public long m_timestampOfCurTexFrame;
    public long m_timestampOfLastDecodedFrame;
    private int m_videoTrackIndex = -1;

    public NvAndroidSurfaceVideoFileReader(SurfaceTexture surfaceTexture) {
        Object object;
        long l10;
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_inputBufferQueued = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.m_frameSyncObject = object = new Object();
        this.m_surfaceTexture = surfaceTexture;
        this.m_bufferInfo = surfaceTexture;
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
            try {
                boolean bl2 = this.m_decoderStarted;
                if (bl2) {
                    bl2 = this.m_inputBufferQueued;
                    if (bl2) {
                        mediaCodec.flush();
                        this.m_inputBufferQueued = false;
                    }
                    mediaCodec = this.m_decoder;
                    mediaCodec.stop();
                    this.m_decoderStarted = false;
                    this.m_decoderInputBuffers = null;
                }
                mediaCodec = this.m_decoder;
                mediaCodec.release();
                this.m_decoder = null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        this.m_timestampOfLastDecodedFrame = l10 = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = l10;
        this.m_firstPlaybackTexFrameUnconsumed = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    private int DecodeToFrame(long l10, long l11) {
        try {
            return this.DoDecodeToFrame(l10, l11);
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int DoDecodeToFrame(long l10, long l11) {
        int n10;
        int n11;
        NvAndroidSurfaceVideoFileReader nvAndroidSurfaceVideoFileReader = this;
        Object object = this.m_decoderInputBuffers;
        int n12 = ((ByteBuffer[])object).length / 3;
        int n13 = 2;
        n12 = Math.max(n12, n13);
        CharSequence charSequence = null;
        int n14 = 0;
        Object object2 = null;
        do {
            long l12;
            Object object3;
            int n15;
            int n16;
            Object object4;
            long l13;
            Object object5;
            int n17;
            n11 = nvAndroidSurfaceVideoFileReader.m_sawOutputEOS;
            n10 = 1;
            if (n11 != 0) {
                nvAndroidSurfaceVideoFileReader.m_timestampOfCurTexFrame = -1;
                return n10;
            }
            n11 = nvAndroidSurfaceVideoFileReader.m_sawInputEOS;
            if (n11 == 0 && (n17 = (object5 = nvAndroidSurfaceVideoFileReader.m_decoder).dequeueInputBuffer(l13 = 4000L)) >= 0) {
                int n18;
                long l14;
                MediaCodec mediaCodec;
                object4 = nvAndroidSurfaceVideoFileReader.m_extractor;
                object5 = nvAndroidSurfaceVideoFileReader.m_decoderInputBuffers[n17];
                int n19 = object4.readSampleData((ByteBuffer)object5, 0);
                if (n19 < 0) {
                    mediaCodec = nvAndroidSurfaceVideoFileReader.m_decoder;
                    n19 = 0;
                    l14 = 0L;
                    n18 = 4;
                    mediaCodec.queueInputBuffer(n17, 0, 0, l14, n18);
                    nvAndroidSurfaceVideoFileReader.m_sawInputEOS = n10;
                } else {
                    object5 = nvAndroidSurfaceVideoFileReader.m_extractor;
                    n11 = object5.getSampleTrackIndex();
                    if (n11 != (n16 = nvAndroidSurfaceVideoFileReader.m_videoTrackIndex)) {
                        object5 = TAG;
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("WEIRD: got sample from track ");
                        n15 = nvAndroidSurfaceVideoFileReader.m_extractor.getSampleTrackIndex();
                        ((StringBuilder)object4).append(n15);
                        object3 = ", expected ";
                        ((StringBuilder)object4).append((String)object3);
                        n15 = nvAndroidSurfaceVideoFileReader.m_videoTrackIndex;
                        ((StringBuilder)object4).append(n15);
                        object4 = ((StringBuilder)object4).toString();
                        Log.w((String)object5, (String)object4);
                    }
                    l14 = nvAndroidSurfaceVideoFileReader.m_extractor.getSampleTime();
                    mediaCodec = nvAndroidSurfaceVideoFileReader.m_decoder;
                    n18 = 0;
                    mediaCodec.queueInputBuffer(n17, 0, n19, l14, 0);
                    nvAndroidSurfaceVideoFileReader.m_inputBufferQueued = n10;
                    nvAndroidSurfaceVideoFileReader.m_pendingInputFrameCount = n11 = nvAndroidSurfaceVideoFileReader.m_pendingInputFrameCount + n10;
                    object5 = nvAndroidSurfaceVideoFileReader.m_extractor;
                    object5.advance();
                    nvAndroidSurfaceVideoFileReader.m_extractorInOriginalState = false;
                }
            }
            if ((n11 = nvAndroidSurfaceVideoFileReader.m_pendingInputFrameCount) <= n12 && (n11 = (int)(nvAndroidSurfaceVideoFileReader.m_sawInputEOS ? 1 : 0)) == 0) {
                n11 = 0;
                object5 = null;
            } else {
                n11 = 4000;
            }
            n16 = this.IsValid();
            if (n16 == 0) {
                Log.e((String)TAG, (String)"video decoder codec is invalid!");
                return n10;
            }
            object4 = nvAndroidSurfaceVideoFileReader.m_decoder;
            object3 = nvAndroidSurfaceVideoFileReader.m_bufferInfo;
            long l15 = n11;
            n11 = object4.dequeueOutputBuffer(object3, l15);
            n14 += n10;
            n16 = -1;
            if (n11 == n16 || n11 == (n16 = -3)) continue;
            n16 = -2;
            if (n11 == n16) {
                object5 = nvAndroidSurfaceVideoFileReader.m_decoder;
                object5.getOutputFormat();
                continue;
            }
            if (n11 < 0) {
                charSequence = new StringBuilder();
                charSequence.append("Unexpected result from decoder.dequeueOutputBuffer: ");
                charSequence.append(n11);
                charSequence = charSequence.toString();
                Logger.e(TAG, charSequence);
                return n13;
            }
            object4 = nvAndroidSurfaceVideoFileReader.m_bufferInfo;
            n15 = ((MediaCodec.BufferInfo)object4).flags & 4;
            if (n15 != 0) {
                nvAndroidSurfaceVideoFileReader.m_sawOutputEOS = n10;
            }
            if ((n16 = (int)((l12 = (l13 = ((MediaCodec.BufferInfo)object4).presentationTimeUs) - (l15 = nvAndroidSurfaceVideoFileReader.m_endTime)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
                object4 = TAG;
                object3 = "Already read to end time!";
                Log.d((String)object4, (String)object3);
                nvAndroidSurfaceVideoFileReader.m_sawOutputEOS = n10;
            }
            if ((n16 = (int)(nvAndroidSurfaceVideoFileReader.m_sawOutputEOS ? 1 : 0)) == 0) {
                object2 = nvAndroidSurfaceVideoFileReader.m_bufferInfo;
                nvAndroidSurfaceVideoFileReader.m_timestampOfLastDecodedFrame = l13 = ((MediaCodec.BufferInfo)object2).presentationTimeUs;
                nvAndroidSurfaceVideoFileReader.m_pendingInputFrameCount = n14 = nvAndroidSurfaceVideoFileReader.m_pendingInputFrameCount - n10;
                l15 = Long.MIN_VALUE;
                long l16 = l10 - l15;
                n14 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                if (n14 != 0) {
                    l15 = l10 - l11;
                    long l17 = l13 - l15;
                    n14 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                    if (n14 >= 0) {
                        n14 = n10;
                    } else {
                        n14 = 0;
                        object2 = null;
                    }
                    n16 = 0;
                    object4 = null;
                } else {
                    n16 = 0;
                    object4 = null;
                    n14 = n10;
                }
            } else {
                n16 = n14;
                n14 = 0;
                object2 = null;
            }
            if (n14 != 0) {
                object3 = nvAndroidSurfaceVideoFileReader.m_frameSyncObject;
                synchronized (object3) {
                    long l18;
                    object = nvAndroidSurfaceVideoFileReader.m_bufferInfo;
                    nvAndroidSurfaceVideoFileReader.m_timestampOfCurTexFrame = l18 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                    object = nvAndroidSurfaceVideoFileReader.m_decoder;
                    object.releaseOutputBuffer(n11, n14 != 0);
                    object = "wait";
                    String string2 = "m_frameSyncObject";
                    try {
                        Logger.e((String)object, string2);
                        object = nvAndroidSurfaceVideoFileReader.m_frameSyncObject;
                        object.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        string2 = TAG;
                        object2 = new StringBuilder();
                        object5 = "";
                        ((StringBuilder)object2).append((String)object5);
                        object5 = interruptedException.getMessage();
                        ((StringBuilder)object2).append((String)object5);
                        object2 = ((StringBuilder)object2).toString();
                        Logger.e(string2, object2);
                        interruptedException.printStackTrace();
                    }
                    return 0;
                }
            }
            object3 = nvAndroidSurfaceVideoFileReader.m_decoder;
            object3.releaseOutputBuffer(n11, n14 != 0);
            n14 = n16;
        } while (n14 <= (n11 = 100));
        Logger.e(TAG, "We have tried too many times and can't decode a frame!");
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
    private int SeekInternal(long l10, long l11) {
        int n10 = 2;
        try {
            MediaExtractor mediaExtractor = this.m_extractor;
            String string2 = null;
            mediaExtractor.seekTo(l10, 0);
            boolean bl2 = this.m_sawInputEOS;
            if (!bl2 && !(bl2 = this.m_sawOutputEOS)) {
                bl2 = this.m_inputBufferQueued;
                if (!bl2) return this.DecodeToFrame(l10, l11);
                MediaCodec mediaCodec = this.m_decoder;
                mediaCodec.flush();
                this.m_inputBufferQueued = false;
                this.m_pendingInputFrameCount = 0;
                return this.DecodeToFrame(l10, l11);
            }
            this.CleanupDecoder();
            MediaFormat mediaFormat = this.m_format;
            string2 = "mime";
            String string3 = mediaFormat.getString(string2);
            bl2 = this.SetupDecoder(string3);
            if (bl2) return this.DecodeToFrame(l10, l11);
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
        string3 = this.m_surface;
        string2.configure((MediaFormat)byteBufferArray, (Surface)string3, null, 0);
        string2 = this.m_decoder;
        string2.start();
        boolean bl2 = true;
        this.m_decoderStarted = bl2;
        byteBufferArray = this.m_decoder;
        byteBufferArray = byteBufferArray.getInputBuffers();
        this.m_decoderInputBuffers = byteBufferArray;
        return bl2;
    }

    public void CloseFile() {
        this.CleanupDecoder();
        Surface surface = this.m_surface;
        if (surface != null) {
            surface.release();
            this.m_surface = null;
        }
        if ((surface = this.m_extractor) != null) {
            boolean bl2;
            long l10;
            surface.release();
            this.m_extractor = null;
            this.m_videoTrackIndex = -1;
            this.m_format = null;
            this.m_duration = l10 = 0L;
            this.m_extractorInOriginalState = bl2 = true;
        }
    }

    public int GetNextVideoFrameForPlayback() {
        int n10 = this.IsValid();
        if (n10 == 0) {
            return 1;
        }
        n10 = this.m_firstPlaybackTexFrameUnconsumed;
        if (n10 == 0) {
            long l10 = Long.MIN_VALUE;
            long l11 = 0L;
            n10 = this.DecodeToFrame(l10, l11);
            if (n10 != 0) {
                return n10;
            }
        } else {
            this.m_firstPlaybackTexFrameUnconsumed = false;
        }
        return 0;
    }

    public long GetTimestampOfCurrentTextureFrame() {
        return this.m_timestampOfCurTexFrame;
    }

    public void GetTransformMatrixOfSurfaceTexture(float[] fArray) {
        SurfaceTexture surfaceTexture = this.m_surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.getTransformMatrix(fArray);
        }
    }

    public boolean OpenFile(String string2, long l10, long l11, AssetManager object) {
        long l12;
        boolean bl2;
        String string3;
        Object object2;
        Object object3;
        String string4;
        block21: {
            block20: {
                boolean bl3 = this.IsValid();
                string4 = TAG;
                if (bl3) {
                    Logger.e(string4, "You can't call OpenFile() twice!");
                    return false;
                }
                this.m_startTime = l10;
                this.m_endTime = l11;
                object3 = new MediaExtractor();
                this.m_extractor = object3;
                if (object != null) break block20;
                object3.setDataSource(string2);
                break block21;
            }
            object3 = object.openFd(string2);
            MediaExtractor mediaExtractor = this.m_extractor;
            FileDescriptor fileDescriptor = object3.getFileDescriptor();
            long l13 = object3.getStartOffset();
            long l14 = object3.getLength();
            mediaExtractor.setDataSource(fileDescriptor, l13, l14);
            object3.close();
        }
        boolean bl4 = true;
        try {
            this.m_extractorInOriginalState = bl4;
            object2 = this.m_extractor;
        }
        catch (Exception exception) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("");
            String string5 = exception.getMessage();
            ((StringBuilder)object3).append(string5);
            object3 = ((StringBuilder)object3).toString();
            Logger.e(string4, object3);
            exception.printStackTrace();
            this.CloseFile();
            return false;
        }
        int n10 = object2.getTrackCount();
        int n11 = 0;
        SurfaceTexture surfaceTexture = null;
        while (true) {
            String string6;
            string3 = "mime";
            if (n11 >= n10) break;
            object = this.m_extractor.getTrackFormat(n11).getString(string3);
            boolean bl5 = ((String)object).startsWith(string6 = "video/");
            if (bl5) {
                this.m_videoTrackIndex = n11;
                break;
            }
            ++n11;
        }
        if ((n10 = this.m_videoTrackIndex) < 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Failed to find a video track from ");
            ((StringBuilder)object3).append(string2);
            string2 = ((StringBuilder)object3).toString();
            Logger.e(string4, string2);
            this.CloseFile();
            return false;
        }
        this.m_extractor.selectTrack(n10);
        string2 = this.m_extractor;
        n10 = this.m_videoTrackIndex;
        string2 = string2.getTrackFormat(n10);
        this.m_format = string2;
        n10 = Build.VERSION.SDK_INT;
        n11 = 16;
        if (n10 == n11) {
            object2 = "max-input-size";
            string2.setInteger((String)object2, 0);
        }
        if ((bl2 = (string2 = Build.HARDWARE).equals(object2 = "qcom")) && (bl2 = (string2 = this.m_format).containsKey((String)(object2 = "frame-rate")))) {
            string2 = this.m_format;
            string2.setInteger((String)object2, 0);
        }
        this.m_duration = l12 = this.m_format.getLong("durationUs");
        string2 = this.m_format.getString(string3);
        object2 = this.m_surfaceTexture;
        if (object2 == null) {
            this.CloseFile();
            return false;
        }
        surfaceTexture = this.m_surfaceTexture;
        object2 = new Surface(surfaceTexture);
        this.m_surface = object2;
        bl2 = this.SetupDecoder(string2);
        if (!bl2) {
            this.CloseFile();
            return false;
        }
        return bl4;
    }

    public int SeekVideoFrame(long l10, long l11) {
        long l12;
        long l13;
        Object object = this.IsValid();
        int n10 = 1;
        if (object == 0) {
            return n10;
        }
        long l14 = (l10 = Math.max(l10, 0L)) - (l13 = this.m_duration);
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0) {
            return n10;
        }
        long l15 = this.m_timestampOfCurTexFrame;
        l13 = Long.MIN_VALUE;
        long l16 = l15 - l13;
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 != false && (object = (Object)((l12 = (l15 = Math.abs(l10 - l15)) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            return 0;
        }
        return this.SeekInternal(l10, l11);
    }

    public int StartPlayback(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        this.m_timestampOfCurTexFrame = l15 = Long.MIN_VALUE;
        Object object = this.IsValid();
        int n10 = 1;
        if (object == 0) {
            return n10;
        }
        long l16 = (l10 = Math.max(l10, 0L)) - (l14 = this.m_duration);
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object >= 0) {
            return n10;
        }
        l14 = this.m_timestampOfCurTexFrame;
        long l17 = l10 - l14;
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object == 0 && (object = (Object)((l13 = l14 - (l12 = this.m_timestampOfLastDecodedFrame)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0) {
            this.m_firstPlaybackTexFrameUnconsumed = n10;
            return 0;
        }
        int n11 = this.SeekInternal(l10, l11);
        if (n11 != 0) {
            return n11;
        }
        this.m_firstPlaybackTexFrameUnconsumed = n10;
        return 0;
    }
}

