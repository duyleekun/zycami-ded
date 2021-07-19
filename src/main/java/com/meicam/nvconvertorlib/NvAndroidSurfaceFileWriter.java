/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 */
package com.meicam.nvconvertorlib;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.Mp4v2Helper;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$2;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$3;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$4;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$5;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$OnReleaseEncoderListener;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker;
import com.meicam.nvconvertorlib.NvAndroidSurfaceVideoFileReader;
import com.meicam.nvconvertorlib.NvConvertorUtils;
import com.meicam.nvconvertorlib.NvSampleBufferReturnCallBack;
import com.meicam.nvconvertorlib.NvVideoFrame;
import com.meicam.nvconvertorlib.NvVideoResolution;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class NvAndroidSurfaceFileWriter {
    private static final int FAULT_TOLERATE_VALUE = 100000;
    public static final int NV_ANDROID_SURFACE_FILE_WRITER_ENCODER_CONFIG_DATA_EVENT_TYPE = 0;
    public static final int NV_ANDROID_SURFACE_FILE_WRITER_ENCODER_DATA_EVENT_TYPE = 1;
    public static final int NV_ANDROID_SURFACE_FILE_WRITER_ENCODER_REVERSE_CONTINUE_EVENT_TYPE = 2;
    public static final String TAG = "SurfaceFileWriter";
    public final int TIMEOUT_USEC;
    public Thread audioWriter;
    public boolean isSuccess;
    public long lastVideoTimeStamp;
    private NvAndroidSurfaceFileWriter$OnReleaseEncoderListener mOnReleaseEncoderListener;
    public boolean mRelease;
    private NvVideoFrame mTempMuxsampleBuffer;
    public Runnable mVideoThreadHandlerRunable;
    private MediaCodec m_AudioEncoder;
    private NvSampleBufferReturnCallBack m_BufferCallback;
    public boolean m_IFrameOnly;
    public Mp4v2Helper m_MediaMuxer;
    private Object m_audioArraySyncObject;
    private MediaCodec.BufferInfo m_audiobufferInfo;
    public int m_avgFps;
    public long m_bitrate;
    private int m_channelCount;
    private boolean m_endOfAudioInputStreamSignaled;
    public long m_endTime;
    public Handler m_eventHandler;
    public String m_filePath;
    public Object m_flushSyncObject;
    private float m_frameDuation;
    public int m_gopsize;
    private boolean m_hasAudioStream;
    public boolean m_is4K;
    public boolean m_isAVC;
    public boolean m_isReverse;
    public ArrayList m_mp4MuxBuffer;
    public Object m_mp4muxSyncObject;
    private ArrayList m_pendingAudioSamples;
    public ArrayList m_pendingVideoFrame;
    public Handler m_processEventHandler;
    public int m_rotation;
    private int m_sampleRate;
    public long m_startTime;
    public boolean m_stopping = false;
    public NvAndroidSurfaceVideoFileReader m_videoReader;
    public NvVideoResolution m_videoRes;
    public HandlerThread m_videoThread;
    public Handler m_videoThreadHandler;
    public NvAndroidSurfaceFileWriterVideoWorker m_videoWorker;
    public boolean m_writeAudioCompleted;
    public Object m_writeCompleteObject;
    public boolean m_writeCompleted;
    public boolean m_writeVideoCompleted;
    private boolean m_writerStarted = false;
    public Thread mp4Writer;
    public Semaphore semaphore;
    public SurfaceTexture surfaceTexture;

    public NvAndroidSurfaceFileWriter(Handler object, NvSampleBufferReturnCallBack object2, boolean bl2) {
        Object object3;
        long l10;
        Object object4;
        this.m_writeCompleteObject = object4 = new Object();
        this.m_mp4muxSyncObject = object4 = new Object();
        this.m_MediaMuxer = null;
        this.m_startTime = l10 = 0L;
        this.m_endTime = l10;
        this.m_rotation = 0;
        this.m_is4K = false;
        this.surfaceTexture = null;
        this.m_isReverse = false;
        Object object5 = new NvVideoResolution();
        this.m_videoRes = object5;
        this.m_flushSyncObject = object5 = new Object();
        this.lastVideoTimeStamp = l10;
        this.TIMEOUT_USEC = 1000;
        this.m_audiobufferInfo = null;
        this.m_sampleRate = 0;
        this.m_channelCount = 0;
        this.m_hasAudioStream = false;
        this.m_audioArraySyncObject = object3 = new Object();
        this.m_endOfAudioInputStreamSignaled = false;
        this.m_BufferCallback = null;
        this.m_frameDuation = 100.0f;
        this.mRelease = false;
        this.m_is4K = bl2;
        Object object6 = new ArrayList();
        this.m_pendingVideoFrame = object6;
        object6 = new ArrayList();
        this.m_pendingAudioSamples = object6;
        object6 = new ArrayList();
        this.m_mp4MuxBuffer = object6;
        this.m_videoWorker = object6 = new NvAndroidSurfaceFileWriterVideoWorker(this, (Handler)object);
        this.m_audiobufferInfo = object;
        super();
        this.m_MediaMuxer = object;
        this.m_BufferCallback = object2;
        Logger.e(TAG, "NvAndroidSurfaceFileWriter: \u7a7a\u4e86");
        object = Looper.getMainLooper();
        super(this, (Looper)object);
        this.m_eventHandler = object2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean FeedAudioEncoder(ByteBuffer byteBuffer, long l10) {
        int n10;
        Object object;
        int n11;
        int n12;
        int n13;
        NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter = this;
        ByteBuffer byteBuffer2 = byteBuffer;
        int n14 = 1;
        if (byteBuffer != null) {
            byteBuffer.clear();
            n12 = n13 = byteBuffer.limit();
            n11 = 0;
        } else {
            n11 = n14;
            n13 = 0;
            object = null;
            n12 = 0;
        }
        if (n11 != 0 && (n10 = nvAndroidSurfaceFileWriter.m_endOfAudioInputStreamSignaled) != 0) {
            return n14 != 0;
        }
        Object object2 = nvAndroidSurfaceFileWriter.m_AudioEncoder.getOutputBuffers();
        MediaFormat mediaFormat = object2;
        while ((n10 = nvAndroidSurfaceFileWriter.mRelease) == 0) {
            if (n13 > 0 || n11 != 0 && (n10 = (int)(nvAndroidSurfaceFileWriter.m_endOfAudioInputStreamSignaled ? 1 : 0)) == 0) {
                n10 = n12 - n13;
                if ((n10 = nvAndroidSurfaceFileWriter.QueueInputAudioSamples(byteBuffer2, l10, n10)) < 0) {
                    return n14 != 0;
                }
                n13 -= n10;
            }
            int n15 = n13;
            object = nvAndroidSurfaceFileWriter.m_AudioEncoder;
            object2 = nvAndroidSurfaceFileWriter.m_audiobufferInfo;
            long l11 = 1000L;
            int n16 = object.dequeueOutputBuffer((MediaCodec.BufferInfo)object2, l11);
            n13 = -1;
            String string2 = TAG;
            if (n16 == n13) {
                if (n11 == 0) {
                    if (n15 <= 0) {
                        return n14 != 0;
                    }
                } else {
                    object = "no output available, spinning to await EOS";
                    Log.d((String)string2, (String)object);
                }
            } else {
                n13 = -3;
                if (n16 == n13) {
                    object = nvAndroidSurfaceFileWriter.m_AudioEncoder.getOutputBuffers();
                    mediaFormat = object;
                } else {
                    CharSequence charSequence;
                    n13 = -2;
                    if (n16 == n13) {
                        object = nvAndroidSurfaceFileWriter.m_AudioEncoder.getOutputFormat();
                        object2 = new StringBuilder();
                        charSequence = "encoder output format changed: ";
                        ((StringBuilder)object2).append((String)charSequence);
                        ((StringBuilder)object2).append(object);
                        object = ((StringBuilder)object2).toString();
                        Log.d((String)string2, (String)object);
                    } else if (n16 < 0) {
                        object = new StringBuilder();
                        object2 = "unexpected result from encoder.dequeueOutputBuffer: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(n16);
                        object = ((StringBuilder)object).toString();
                        Log.w((String)string2, (String)object);
                    } else {
                        int n17;
                        int n18;
                        String string3;
                        int n19;
                        MediaFormat mediaFormat2 = mediaFormat[n16];
                        if (mediaFormat2 == null) {
                            n10 = n16;
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("encoderOutputBuffer ");
                            ((StringBuilder)charSequence).append(n16);
                            ((StringBuilder)charSequence).append(" was null");
                            object2 = ((StringBuilder)charSequence).toString();
                            object = new RuntimeException((String)object2);
                            throw object;
                        }
                        object = nvAndroidSurfaceFileWriter.m_audiobufferInfo;
                        n10 = ((MediaCodec.BufferInfo)object).flags & 2;
                        if (n10 != 0) {
                            l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                            n19 = ((MediaCodec.BufferInfo)object).offset;
                            n10 = ((MediaCodec.BufferInfo)object).size;
                            int n20 = 2;
                            object = this;
                            object2 = mediaFormat2;
                            string3 = string2;
                            n18 = n10;
                            n17 = n16;
                            n16 = n20;
                            this.sendBufferToMux((ByteBuffer)mediaFormat2, l11, n19, n10, n20);
                            Log.d((String)string2, (String)"ignoring BUFFER_FLAG_CODEC_CONFIG");
                            object = nvAndroidSurfaceFileWriter.m_audiobufferInfo;
                            ((MediaCodec.BufferInfo)object).size = 0;
                        } else {
                            string3 = string2;
                            n17 = n16;
                        }
                        object = nvAndroidSurfaceFileWriter.m_audiobufferInfo;
                        n18 = ((MediaCodec.BufferInfo)object).size;
                        if (n18 != 0) {
                            n16 = 17;
                            l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                            n19 = ((MediaCodec.BufferInfo)object).offset;
                            object = this;
                            object2 = mediaFormat2;
                            this.sendBufferToMux((ByteBuffer)mediaFormat2, l11, n19, n18, n16);
                        }
                        object = nvAndroidSurfaceFileWriter.m_AudioEncoder;
                        n10 = n17;
                        object.releaseOutputBuffer(n17, false);
                        object = nvAndroidSurfaceFileWriter.m_audiobufferInfo;
                        n13 = ((MediaCodec.BufferInfo)object).flags & 4;
                        if (n13 != 0) {
                            if (n11 == 0) {
                                object = "reached end of stream unexpectedly";
                                Log.w((String)string3, (String)object);
                                return 1 != 0;
                            } else {
                                object = "end of stream reached";
                                Log.d((String)string3, (String)object);
                            }
                            return 1 != 0;
                        }
                    }
                }
            }
            n13 = n15;
            n14 = 1;
        }
        return n14 != 0;
    }

    private int QueueInputAudioSamples(ByteBuffer byteBuffer, long l10, int n10) {
        Object object = this.m_AudioEncoder.getInputBuffers();
        MediaCodec mediaCodec = this.m_AudioEncoder;
        long l11 = 1000L;
        int n11 = mediaCodec.dequeueInputBuffer(l11);
        int n12 = 0;
        mediaCodec = null;
        int n13 = -1;
        if (n11 == n13) {
            return 0;
        }
        if (byteBuffer == null) {
            long l12 = NvConvertorUtils.NvTimeToUs(l10);
            this.m_AudioEncoder.queueInputBuffer(n11, 0, 0, l12, 4);
            this.m_endOfAudioInputStreamSignaled = true;
            return 0;
        }
        object = object[n11];
        ((ByteBuffer)object).clear();
        n12 = this.m_channelCount * 2;
        n13 = ((Buffer)object).limit();
        int n14 = byteBuffer.limit();
        n13 = n13 / n12 * n12;
        n12 = n14 - n10;
        n12 = Math.min(n13, n12);
        byteBuffer.position(n10);
        byteBuffer.limit(n10 += n12);
        ((ByteBuffer)object).put(byteBuffer);
        byteBuffer.position(n10);
        byteBuffer.limit(n14);
        long l13 = NvConvertorUtils.NvTimeToUs(l10);
        this.m_AudioEncoder.queueInputBuffer(n11, 0, n12, l13, 0);
        return n12;
    }

    public static /* synthetic */ float access$002(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, float f10) {
        nvAndroidSurfaceFileWriter.m_frameDuation = f10;
        return f10;
    }

    public static /* synthetic */ ArrayList access$100(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_pendingAudioSamples;
    }

    public static /* synthetic */ int access$1000(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_sampleRate;
    }

    public static /* synthetic */ Object access$200(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_audioArraySyncObject;
    }

    public static /* synthetic */ boolean access$300(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, ByteBuffer byteBuffer, long l10) {
        return nvAndroidSurfaceFileWriter.FeedAudioEncoder(byteBuffer, l10);
    }

    public static /* synthetic */ void access$400(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, ByteBuffer byteBuffer, long l10, int n10, int n11, int n12) {
        nvAndroidSurfaceFileWriter.sendBufferToMux(byteBuffer, l10, n10, n11, n12);
    }

    public static /* synthetic */ NvAndroidSurfaceFileWriter$OnReleaseEncoderListener access$500(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.mOnReleaseEncoderListener;
    }

    public static /* synthetic */ boolean access$600(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_endOfAudioInputStreamSignaled;
    }

    public static /* synthetic */ boolean access$602(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, boolean bl2) {
        nvAndroidSurfaceFileWriter.m_endOfAudioInputStreamSignaled = bl2;
        return bl2;
    }

    public static /* synthetic */ NvSampleBufferReturnCallBack access$700(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_BufferCallback;
    }

    public static /* synthetic */ boolean access$800(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter) {
        return nvAndroidSurfaceFileWriter.m_hasAudioStream;
    }

    public static /* synthetic */ NvVideoFrame access$902(NvAndroidSurfaceFileWriter nvAndroidSurfaceFileWriter, NvVideoFrame nvVideoFrame) {
        nvAndroidSurfaceFileWriter.mTempMuxsampleBuffer = nvVideoFrame;
        return nvVideoFrame;
    }

    private boolean prepareAudioEncoder(int n10, int n11) {
        Object object;
        String string2 = "audio/mp4a-latm";
        Object object2 = NvConvertorUtils.SelectEncoderByMimeType(string2);
        if (object2 == null) {
            return false;
        }
        object2 = object2.getName();
        MediaFormat mediaFormat = MediaFormat.createAudioFormat((String)string2, (int)n10, (int)n11);
        mediaFormat.setInteger("bitrate", 128000);
        n11 = 2;
        string2 = "aac-profile";
        mediaFormat.setInteger(string2, n11);
        try {
            object = MediaCodec.createByCodecName((String)object2);
        }
        catch (IOException iOException) {
            object = new RuntimeException("MediaCodec creation failed", iOException);
            throw object;
        }
        this.m_AudioEncoder = object;
        boolean bl2 = true;
        object2 = null;
        object.configure(mediaFormat, null, null, (int)(bl2 ? 1 : 0));
        mediaFormat = this.m_AudioEncoder;
        mediaFormat.start();
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void releaseEncoder() {
        String string2;
        Object object;
        String string3;
        block16: {
            block18: {
                boolean bl2;
                block17: {
                    string3 = TAG;
                    Log.d((String)string3, (String)"releasing encoder objects");
                    object = this.m_videoWorker;
                    if (object == null) break block16;
                    object = new Message();
                    string2 = null;
                    ((Message)object).what = 0;
                    Handler handler = this.m_videoWorker.m_eventHandler;
                    handler.sendMessage((Message)object);
                    object = this.m_videoWorker;
                    boolean bl3 = ((NvAndroidSurfaceFileWriterVideoWorker)object).m_bIsReverseConvert;
                    bl2 = true;
                    if (!bl3) break block17;
                    long l10 = this.m_startTime;
                    long l11 = ((NvAndroidSurfaceFileWriterVideoWorker)object).getPlayBackStartPosForReverse();
                    long l12 = l10 - l11;
                    Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object2 >= 0) {
                        object = this.mOnReleaseEncoderListener;
                        if (object != null) {
                            object.onReleaseEncoder(bl2);
                            this.isSuccess = bl2;
                        }
                        break block18;
                    } else {
                        object = this.mOnReleaseEncoderListener;
                        if (object != null) {
                            object.onReleaseEncoder(false);
                            this.isSuccess = false;
                        }
                    }
                    break block18;
                }
                if (object != null) {
                    long l13 = ((NvAndroidSurfaceFileWriterVideoWorker)object).getmTempStreamTimeForJudgeEndOfConvert();
                    long l14 = this.m_endTime;
                    long l15 = (l13 = Math.abs(l13 - l14)) - (l14 = 100000L);
                    Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object3 < 0) {
                        object = this.mOnReleaseEncoderListener;
                        object.onReleaseEncoder(bl2);
                        this.isSuccess = bl2;
                    } else {
                        object = this.mOnReleaseEncoderListener;
                        object.onReleaseEncoder(false);
                        this.isSuccess = false;
                    }
                } else {
                    object = this.mOnReleaseEncoderListener;
                    object.onReleaseEncoder(false);
                    this.isSuccess = false;
                }
                this.mTempMuxsampleBuffer = null;
            }
            this.m_videoWorker = null;
            this.m_videoWorker = null;
        }
        try {
            object = this.m_AudioEncoder;
            if (object != null) {
                object.stop();
                object = this.m_AudioEncoder;
                object.release();
                this.m_AudioEncoder = null;
            }
        }
        catch (Exception exception) {}
        if ((object = this.m_MediaMuxer) != null) {
            try {
                long l16 = this.m_endTime;
                ((Mp4v2Helper)object).writeFileTrailer(l16);
                object = this.m_MediaMuxer;
                ((Mp4v2Helper)object).CloseFile();
            }
            catch (Exception exception) {
                string2 = "You started a Muxer but haven't fed any data into it";
                Logger.e(string3, string2);
                exception.printStackTrace();
            }
            this.m_MediaMuxer = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendBufferToMux(ByteBuffer object, long l10, int n10, int n11, int n12) {
        Object object2;
        try {
            NvVideoFrame nvVideoFrame = new NvVideoFrame();
            nvVideoFrame.bufferFlags = n12;
            nvVideoFrame.streamTime = l10;
            if (object != null) {
                ((ByteBuffer)object).position(n10);
                ((ByteBuffer)object).limit(n10 += n11);
                nvVideoFrame.buffer = object2 = ByteBuffer.allocateDirect(n11);
                ((ByteBuffer)object2).put((ByteBuffer)object);
            }
            object = this.m_mp4muxSyncObject;
            synchronized (object) {
                object2 = this.m_mp4MuxBuffer;
                ((ArrayList)object2).add(nvVideoFrame);
            }
        }
        catch (Exception exception) {
            return;
        }
        {
            object2 = this.m_mp4muxSyncObject;
            object2.notifyAll();
            return;
        }
    }

    public void CloseVideoThreadHandler() {
        String string2 = "CloseVideoThreadHandler: ";
        Logger.e(TAG, string2);
        HandlerThread handlerThread = this.m_videoThread;
        if (handlerThread != null) {
            int n10 = handlerThread.isAlive();
            if (n10 != 0) {
                n10 = Build.VERSION.SDK_INT;
                int n11 = 18;
                if (n10 >= n11) {
                    handlerThread = this.m_videoThread;
                    handlerThread.quitSafely();
                }
                handlerThread = this.m_videoThread;
                try {
                    handlerThread.interrupt();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            n10 = 0;
            handlerThread = null;
            this.m_videoThread = null;
        }
        this.close();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void FlushWriter() {
        CharSequence charSequence;
        boolean bl2;
        this.NotifyVideoEOS();
        this.NotifyAudioEOS();
        Object object = TAG;
        Object object2 = new StringBuilder();
        CharSequence charSequence2 = "FlushWriter111: ";
        ((StringBuilder)object2).append((String)charSequence2);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        object2 = ((StringBuilder)object2).toString();
        Logger.e((String)object, object2);
        boolean bl3 = this.m_writerStarted;
        if (bl3 && !(bl3 = this.mRelease)) {
            object = this.m_writeCompleteObject;
            synchronized (object) {
                bl2 = this.m_writeCompleted;
                if (!bl2) {
                    object2 = "wait";
                    charSequence2 = "m_writeCompleteObject";
                    try {
                        Logger.e((String)object2, charSequence2);
                        object2 = this.m_writeCompleteObject;
                        object2.wait();
                        this.m_writeCompleted = bl2 = true;
                    }
                    catch (InterruptedException interruptedException) {
                        charSequence2 = TAG;
                        charSequence = new StringBuilder();
                        String string2 = "";
                        charSequence.append(string2);
                        string2 = interruptedException.getMessage();
                        charSequence.append(string2);
                        charSequence = charSequence.toString();
                        Logger.e((String)charSequence2, charSequence);
                        interruptedException.printStackTrace();
                    }
                }
            }
        }
        object2 = new StringBuilder();
        charSequence2 = "FlushWriter222: ";
        ((StringBuilder)object2).append((String)charSequence2);
        l10 = System.currentTimeMillis();
        ((StringBuilder)object2).append(l10);
        object2 = ((StringBuilder)object2).toString();
        Logger.e(TAG, object2);
        object = this.m_flushSyncObject;
        synchronized (object) {
            this.releaseEncoder();
            try {
                object2 = this.m_pendingVideoFrame;
                if (object2 != null) {
                    ((ArrayList)object2).clear();
                }
                if ((object2 = this.m_pendingAudioSamples) != null) {
                    ((ArrayList)object2).clear();
                }
                if ((object2 = this.m_mp4MuxBuffer) != null) {
                    ((ArrayList)object2).clear();
                }
            }
            catch (Exception exception) {}
            bl2 = false;
            object2 = null;
            this.m_pendingVideoFrame = null;
            this.m_pendingAudioSamples = null;
            this.m_mp4MuxBuffer = null;
            bl2 = false;
            object2 = null;
            this.m_writerStarted = false;
            object2 = TAG;
            charSequence2 = new StringBuilder();
            charSequence = "FlushWriter333: ";
            ((StringBuilder)charSequence2).append((String)charSequence);
            long l11 = System.currentTimeMillis();
            ((StringBuilder)charSequence2).append(l11);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            Logger.e((String)object2, charSequence2);
            this.CloseVideoThreadHandler();
            return;
        }
    }

    public void InitVideoInfo(int n10, int n11, int n12, long l10, long l11) {
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 21;
        if (n13 >= n14) {
            n13 = this.m_rotation;
            if (n13 != 0 && n13 != (n14 = 180)) {
                n14 = 90;
                if (n13 == n14 || n13 == (n14 = 270)) {
                    NvVideoResolution nvVideoResolution = this.m_videoRes;
                    nvVideoResolution.imageWidth = n11;
                    nvVideoResolution.imageHeight = n10;
                }
            } else {
                NvVideoResolution nvVideoResolution = this.m_videoRes;
                nvVideoResolution.imageWidth = n10;
                nvVideoResolution.imageHeight = n11;
            }
            n10 = 0;
            this.m_rotation = 0;
        } else {
            NvVideoResolution nvVideoResolution = this.m_videoRes;
            nvVideoResolution.imageWidth = n10;
            nvVideoResolution.imageHeight = n11;
        }
        this.m_avgFps = n12;
        this.m_startTime = l10;
        this.m_endTime = l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void NotifyAudioEOS() {
        block11: {
            long l10;
            boolean bl2 = this.m_hasAudioStream;
            if (!bl2) {
                return;
            }
            bl2 = this.m_writerStarted;
            if (!bl2) {
                return;
            }
            Object object = TAG;
            Object object2 = "NotifyAudioEOS: 1111w";
            Logger.e((String)object, object2);
            bl2 = this.m_writeCompleted;
            if (bl2) break block11;
            Logger.e(TAG, "NotifyAudioEOS: 22222");
            object = new NvVideoFrame();
            ((NvVideoFrame)object).buffer = null;
            ((NvVideoFrame)object).streamTime = l10 = 0L;
            object2 = this.m_writeCompleteObject;
            synchronized (object2) {
                boolean bl3 = this.m_writeCompleted;
                if (bl3) {
                    return;
                }
                Object object3 = TAG;
                Object object4 = "NotifyAudioEOS: 33333";
                Logger.e((String)object3, object4);
                try {
                    object3 = this.m_audioArraySyncObject;
                    synchronized (object3) {
                        object4 = this.m_pendingAudioSamples;
                        ((ArrayList)object4).add(object);
                    }
                }
                catch (Exception exception) {}
                {
                    object = this.m_audioArraySyncObject;
                    object.notifyAll();
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void NotifyVideoEOS() {
        long l10;
        boolean bl2 = this.m_writerStarted;
        if (!bl2) {
            return;
        }
        bl2 = this.m_writeCompleted;
        if (bl2) return;
        Object object = new NvVideoFrame();
        Object var3_3 = null;
        ((NvVideoFrame)object).buffer = null;
        ((NvVideoFrame)object).streamTime = l10 = 0L;
        object = this.m_writeCompleteObject;
        synchronized (object) {
            boolean bl3 = this.m_writeCompleted;
            if (bl3) {
                return;
            }
            ArrayList arrayList = this.m_pendingVideoFrame;
            arrayList.add(null);
            return;
        }
    }

    public SurfaceTexture OpenFile(String object, int n10, boolean bl2, boolean bl3, boolean bl4) {
        Object object2;
        Object object3;
        String string2;
        String string3;
        block16: {
            Object object4;
            long l10;
            string3 = "";
            string2 = TAG;
            this.m_filePath = object;
            this.m_rotation = n10;
            this.m_isReverse = bl2;
            object3 = this.m_videoWorker;
            ((NvAndroidSurfaceFileWriterVideoWorker)object3).m_bIsReverseConvert = bl2;
            ((NvAndroidSurfaceFileWriterVideoWorker)object3).m_bHasInstalledLicense = bl3;
            ((NvAndroidSurfaceFileWriterVideoWorker)object3).m_deposeOperatingRate = bl4;
            n10 = 0;
            object3 = null;
            this.m_endOfAudioInputStreamSignaled = false;
            this.m_hasAudioStream = false;
            this.m_writerStarted = false;
            this.m_bitrate = l10 = 0L;
            this.m_IFrameOnly = false;
            this.m_gopsize = 0;
            object2 = this.m_MediaMuxer;
            if (object2 == null) {
                object2 = new Mp4v2Helper();
                this.m_MediaMuxer = object2;
            }
            bl2 = false;
            object2 = null;
            try {
                object4 = this.m_MediaMuxer;
            }
            catch (Exception exception) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                object4 = exception.getMessage();
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                Logger.e(string2, object3);
                exception.printStackTrace();
                return null;
            }
            ((Mp4v2Helper)object4).OpenMediaFile((String)object);
            object = this.m_videoThread;
            if (object != null) break block16;
            object4 = "video handler thread";
            object = new HandlerThread((String)object4);
            this.m_videoThread = object;
            if (object == null) {
                Logger.e(string2, "Failed to create video handler thread!");
                return null;
            }
            object.start();
            object = this.m_videoThread.getLooper();
            object4 = this.m_videoWorker;
            ((NvAndroidSurfaceFileWriterVideoWorker)object4).setLooper((Looper)object);
            if (object == null) {
                Logger.e(string2, "Failed to getLooper of the video thread!");
                this.CloseVideoThreadHandler();
                return null;
            }
            object4 = new Handler((Looper)object);
            this.m_videoThreadHandler = object4;
            if (object4 == null) {
                Logger.e(string2, "Failed to create video thread handler with looper!");
                this.CloseVideoThreadHandler();
                return null;
            }
        }
        object = new Semaphore(0);
        this.semaphore = object;
        object = this.m_videoThreadHandler;
        object3 = new NvAndroidSurfaceFileWriter$2(this);
        object.post((Runnable)object3);
        object = this.semaphore;
        ((Semaphore)object).acquire();
        try {
            this.semaphore = null;
        }
        catch (Exception exception) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string3);
            object2 = exception.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            Logger.e(string2, object3);
            exception.printStackTrace();
        }
        return this.surfaceTexture;
    }

    public boolean Start() {
        Runnable runnable;
        boolean bl2;
        this.m_writeCompleted = false;
        this.m_writeVideoCompleted = false;
        this.m_writeAudioCompleted = bl2 = true;
        int n10 = this.m_hasAudioStream;
        if (n10 != 0) {
            n10 = this.m_sampleRate;
            int n11 = this.m_channelCount;
            this.prepareAudioEncoder(n10, n11);
        }
        this.mVideoThreadHandlerRunable = runnable = new NvAndroidSurfaceFileWriter$3(this);
        Object object = this.m_videoThreadHandler;
        object.post(runnable);
        n10 = (int)(this.m_hasAudioStream ? 1 : 0);
        if (n10 != 0) {
            object = new NvAndroidSurfaceFileWriter$4(this);
            runnable = new Thread((Runnable)object);
            this.audioWriter = runnable;
            ((Thread)runnable).start();
        }
        object = new NvAndroidSurfaceFileWriter$5(this);
        runnable = new Thread((Runnable)object);
        this.mp4Writer = runnable;
        ((Thread)runnable).start();
        this.m_writerStarted = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int WriteAudioFrame(NvVideoFrame object) {
        if (object == null) {
            return -1;
        }
        try {
            Object object2 = this.m_audioArraySyncObject;
            synchronized (object2) {
                ArrayList arrayList = this.m_pendingAudioSamples;
                arrayList.add(object);
            }
        }
        catch (Exception exception) {
            return 0;
        }
        {
            object = this.m_audioArraySyncObject;
            object.notifyAll();
            return 0;
        }
    }

    public void addAudioStream(int n10, int n11) {
        Logger.e(TAG, "addAudioStream: ");
        this.m_sampleRate = n10;
        this.m_channelCount = n11;
        this.m_hasAudioStream = true;
    }

    public void checkAndClearHandler(Handler handler) {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = TAG;
        Logger.e((String)object, "close: 1");
        Handler handler = this.m_processEventHandler;
        this.checkAndClearHandler(handler);
        Logger.e((String)object, "close: 2");
        Handler handler2 = this.m_eventHandler;
        this.checkAndClearHandler(handler2);
        Logger.e((String)object, "close: 3");
        Handler handler3 = this.m_videoThreadHandler;
        this.checkAndClearHandler(handler3);
        String string2 = "close: 4";
        Logger.e((String)object, string2);
        try {
            boolean bl2;
            object = this.mp4Writer;
            if (object != null && (bl2 = ((Thread)object).isAlive())) {
                object = this.mp4Writer;
                ((Thread)object).interrupt();
            }
            if ((object = this.audioWriter) == null) return;
            bl2 = ((Thread)object).isAlive();
            if (!bl2) return;
            object = this.audioWriter;
            ((Thread)object).interrupt();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void setOnReleaseEncoderListener(NvAndroidSurfaceFileWriter$OnReleaseEncoderListener nvAndroidSurfaceFileWriter$OnReleaseEncoderListener) {
        this.mOnReleaseEncoderListener = nvAndroidSurfaceFileWriter$OnReleaseEncoderListener;
    }

    public void setmRelease(boolean bl2) {
        this.mRelease = bl2;
    }
}

