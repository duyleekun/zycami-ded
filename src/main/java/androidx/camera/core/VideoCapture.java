/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.media.AudioRecord
 *  android.media.CamcorderProfile
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.media.AudioRecord;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture$1;
import androidx.camera.core.VideoCapture$Builder;
import androidx.camera.core.VideoCapture$Defaults;
import androidx.camera.core.VideoCapture$Metadata;
import androidx.camera.core.VideoCapture$OnVideoSavedCallback;
import androidx.camera.core.VideoCapture$OutputFileOptions;
import androidx.camera.core.VideoCapture$OutputFileResults;
import androidx.camera.core.VideoCapture$VideoSavedListenerWrapper;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.utils.VideoUtil;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import b.a.b.k1;
import b.a.b.l1;
import b.a.b.o1;
import b.a.b.p1;
import b.a.b.q1;
import b.a.b.r1;
import b.a.b.s1;
import b.a.b.t0;
import b.a.b.t1;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class VideoCapture
extends UseCase {
    private static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    private static final int[] CamcorderQuality;
    public static final VideoCapture$Defaults DEFAULT_CONFIG;
    private static final int DEQUE_TIMEOUT_USEC = 10000;
    public static final int ERROR_ENCODER = 1;
    public static final int ERROR_FILE_IO = 4;
    public static final int ERROR_INVALID_CAMERA = 5;
    public static final int ERROR_MUXER = 2;
    public static final int ERROR_RECORDING_IN_PROGRESS = 3;
    public static final int ERROR_UNKNOWN = 0;
    private static final String TAG = "VideoCapture";
    private static final String VIDEO_MIME_TYPE = "video/avc";
    private static final short[] sAudioEncoding;
    private int mAudioBitRate;
    private final MediaCodec.BufferInfo mAudioBufferInfo;
    private int mAudioBufferSize;
    private int mAudioChannelCount;
    private MediaCodec mAudioEncoder;
    private Handler mAudioHandler;
    private HandlerThread mAudioHandlerThread;
    private AudioRecord mAudioRecorder;
    private int mAudioSampleRate;
    private int mAudioTrackIndex;
    public Surface mCameraSurface;
    private DeferrableSurface mDeferrableSurface;
    private final AtomicBoolean mEndOfAudioStreamSignal;
    private final AtomicBoolean mEndOfAudioVideoSignal;
    private final AtomicBoolean mEndOfVideoStreamSignal;
    private final AtomicBoolean mIsFirstAudioSampleWrite;
    private final AtomicBoolean mIsFirstVideoSampleWrite;
    private boolean mIsRecording;
    private MediaMuxer mMuxer;
    private final Object mMuxerLock;
    private boolean mMuxerStarted;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private ListenableFuture mRecordingFuture;
    public Uri mSavedVideoUri;
    private final MediaCodec.BufferInfo mVideoBufferInfo;
    public MediaCodec mVideoEncoder;
    private Handler mVideoHandler;
    private HandlerThread mVideoHandlerThread;
    private int mVideoTrackIndex;

    static {
        Object object = new VideoCapture$Defaults();
        DEFAULT_CONFIG = object;
        Object object2 = object = (Object)new int[4];
        object2[0] = 8;
        object2[1] = 6;
        object2[2] = 5;
        object2[3] = 4;
        CamcorderQuality = (int[])object;
        Object object3 = object = (Object)new short[3];
        object3[0] = 2;
        object3[1] = 3;
        object3[2] = 4;
        sAudioEncoding = (short[])object;
    }

    public VideoCapture(VideoCaptureConfig object) {
        super((UseCaseConfig)object);
        super();
        this.mVideoBufferInfo = object;
        this.mMuxerLock = object = new Object();
        boolean bl2 = true;
        this.mEndOfVideoStreamSignal = object = new AtomicBoolean(bl2);
        this.mEndOfAudioStreamSignal = object = new AtomicBoolean(bl2);
        this.mEndOfAudioVideoSignal = object = new AtomicBoolean(bl2);
        object = new MediaCodec.BufferInfo();
        this.mAudioBufferInfo = object;
        this.mIsFirstVideoSampleWrite = object = new AtomicBoolean(false);
        this.mIsFirstAudioSampleWrite = object = new AtomicBoolean(false);
        this.mRecordingFuture = null;
        this.mMuxerStarted = false;
        this.mIsRecording = false;
    }

    private /* synthetic */ void a() {
        this.releaseResources();
    }

    private AudioRecord autoConfigAudioRecordSource(VideoCaptureConfig videoCaptureConfig) {
        VideoCapture videoCapture = this;
        String string2 = TAG;
        short[] sArray = sAudioEncoding;
        int n10 = sArray.length;
        short s10 = 0;
        String string3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            AudioRecord audioRecord;
            int n11;
            int n12;
            int n13;
            int n14;
            block23: {
                float f10;
                s10 = sArray[i10];
                n14 = videoCapture.mAudioChannelCount;
                n13 = 1;
                if (n14 == n13) {
                    n14 = 16;
                    f10 = 2.24E-44f;
                } else {
                    n14 = 12;
                    f10 = 1.7E-44f;
                }
                n12 = n14;
                n11 = videoCaptureConfig.getAudioRecordSource();
                n14 = videoCapture.mAudioSampleRate;
                n14 = AudioRecord.getMinBufferSize((int)n14, (int)n12, (int)s10);
                if (n14 > 0) break block23;
                n14 = videoCaptureConfig.getAudioMinBufferSize();
            }
            int n15 = n14;
            int n16 = videoCapture.mAudioSampleRate;
            int n17 = n14 * 2;
            CharSequence charSequence = audioRecord;
            int n18 = n11;
            audioRecord = new AudioRecord(n11, n16, n12, (int)s10, n17);
            n14 = audioRecord.getState();
            if (n14 != n13) continue;
            videoCapture.mAudioBufferSize = n15;
            charSequence = new StringBuilder();
            String string4 = "source: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(n11);
            string4 = " audioSampleRate: ";
            ((StringBuilder)charSequence).append(string4);
            n18 = videoCapture.mAudioSampleRate;
            ((StringBuilder)charSequence).append(n18);
            string4 = " channelConfig: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(n12);
            string4 = " audioFormat: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(s10);
            string3 = " bufferSize: ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(n15);
            string3 = ((StringBuilder)charSequence).toString();
            try {
                Logger.i(string2, string3);
                return audioRecord;
            }
            catch (Exception exception) {
                charSequence = "Exception, keep trying.";
                Logger.e(string2, (String)charSequence, exception);
            }
        }
        return null;
    }

    public static /* synthetic */ void c(boolean bl2, MediaCodec mediaCodec) {
        if (bl2 && mediaCodec != null) {
            mediaCodec.release();
        }
    }

    private MediaFormat createAudioMediaFormat() {
        int n10 = this.mAudioSampleRate;
        int n11 = this.mAudioChannelCount;
        MediaFormat mediaFormat = MediaFormat.createAudioFormat((String)AUDIO_MIME_TYPE, (int)n10, (int)n11);
        mediaFormat.setInteger("aac-profile", 2);
        n11 = this.mAudioBitRate;
        mediaFormat.setInteger("bitrate", n11);
        return mediaFormat;
    }

    private static MediaFormat createMediaFormat(VideoCaptureConfig videoCaptureConfig, Size size) {
        int n10 = size.getWidth();
        int n11 = size.getHeight();
        size = MediaFormat.createVideoFormat((String)VIDEO_MIME_TYPE, (int)n10, (int)n11);
        size.setInteger("color-format", 2130708361);
        n10 = videoCaptureConfig.getBitRate();
        size.setInteger("bitrate", n10);
        n10 = videoCaptureConfig.getVideoFrameRate();
        size.setInteger("frame-rate", n10);
        int n12 = videoCaptureConfig.getIFrameInterval();
        size.setInteger("i-frame-interval", n12);
        return size;
    }

    private /* synthetic */ void d(VideoCapture$OutputFileOptions videoCapture$OutputFileOptions, Executor executor, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.startRecording(videoCapture$OutputFileOptions, executor, videoCapture$OnVideoSavedCallback);
    }

    public static /* synthetic */ Object f(AtomicReference atomicReference, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        atomicReference.set(callbackToFutureAdapter$Completer);
        return "startRecording";
    }

    private /* synthetic */ void g() {
        this.mRecordingFuture = null;
        Object object = this.getCamera();
        if (object != null) {
            object = this.getCameraId();
            Size size = this.getAttachedSurfaceResolution();
            this.setupEncoder((String)object, size);
            this.notifyReset();
        }
    }

    private ByteBuffer getInputBuffer(MediaCodec mediaCodec, int n10) {
        return mediaCodec.getInputBuffer(n10);
    }

    private ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int n10) {
        return mediaCodec.getOutputBuffer(n10);
    }

    private /* synthetic */ void i(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.audioEncode(videoCapture$OnVideoSavedCallback);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private MediaMuxer initMediaMuxer(VideoCapture$OutputFileOptions var1_1) {
        block23: {
            block24: {
                block21: {
                    block22: {
                        var2_3 = Build.VERSION.SDK_INT;
                        var3_4 = var1_1.isSavingToFile();
                        if (!var3_4) break block22;
                        var4_5 = var1_1.getFile();
                        var1_1 = Uri.fromFile((File)var1_1.getFile());
                        this.mSavedVideoUri = var1_1;
                        var4_5 = var4_5.getAbsolutePath();
                        var1_1 = new MediaMuxer((String)var4_5, 0);
                        break block21;
                    }
                    var3_4 = var1_1.isSavingToFileDescriptor();
                    var5_8 = 26;
                    if (var3_4) {
                        if (var2_3 >= var5_8) {
                            var1_1 = var1_1.getFileDescriptor();
                            var4_6 /* !! */  = new MediaMuxer((FileDescriptor)var1_1, 0);
lbl17:
                            // 2 sources

                            while (true) {
                                var1_1 = var4_6 /* !! */ ;
                                break block21;
                                break;
                            }
                        }
                        var1_1 = new IllegalArgumentException("Using a FileDescriptor to record a video is only supported for Android 8.0 or above.");
                        throw var1_1;
                    }
                    var3_4 = var1_1.isSavingToMediaStore();
                    if (!var3_4) break block23;
                    var6_9 = var1_1.getContentValues();
                    if (var6_9 != null) {
                        var7_10 = var1_1.getContentValues();
                        var6_9 = new ContentValues(var7_10);
                    } else {
                        var6_9 = new ContentValues();
                    }
                    var7_10 = var1_1.getContentResolver();
                    var8_11 = var1_1.getSaveCollection();
                    var6_9 = var7_10.insert(var8_11, (ContentValues)var6_9);
                    this.mSavedVideoUri = var6_9;
                    if (var6_9 == null) break block24;
                    if (var2_3 >= var5_8) ** GOTO lbl61
                    try {
                        var1_1 = var1_1.getContentResolver();
                    }
                    catch (IOException var1_2) {
                        this.mSavedVideoUri = null;
                        throw var1_2;
                    }
                    var4_6 /* !! */  = this.mSavedVideoUri;
                    var1_1 = VideoUtil.getAbsolutePathFromUri((ContentResolver)var1_1, (Uri)var4_6 /* !! */ );
                    var4_6 /* !! */  = "VideoCapture";
                    var6_9 = new StringBuilder();
                    var9_12 = "Saved Location Path: ";
                    var6_9.append(var9_12);
                    var6_9.append((String)var1_1);
                    var6_9 = var6_9.toString();
                    Logger.i((String)var4_6 /* !! */ , (String)var6_9);
                    var4_6 /* !! */  = new MediaMuxer((String)var1_1, 0);
                    ** continue;
lbl61:
                    // 1 sources

                    var1_1 = var1_1.getContentResolver();
                    var4_7 /* !! */  = this.mSavedVideoUri;
                    var6_9 = "rw";
                    var1_1 = var1_1.openFileDescriptor(var4_7 /* !! */ , (String)var6_9);
                    this.mParcelFileDescriptor = var1_1;
                    var4_7 /* !! */  = this.mParcelFileDescriptor;
                    var4_7 /* !! */  = var4_7 /* !! */ .getFileDescriptor();
                    var1_1 = new MediaMuxer((FileDescriptor)var4_7 /* !! */ , 0);
                }
                return var1_1;
            }
            var1_1 = new IOException("Invalid Uri!");
            throw var1_1;
        }
        var1_1 = new IllegalArgumentException("The OutputFileOptions should assign before recording");
        throw var1_1;
    }

    private /* synthetic */ void k(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback, String object, Size size, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        boolean bl2 = this.videoEncode(videoCapture$OnVideoSavedCallback, (String)object, size);
        size = null;
        if (!bl2) {
            Uri uri = this.mSavedVideoUri;
            object = new VideoCapture$OutputFileResults(uri);
            videoCapture$OnVideoSavedCallback.onVideoSaved((VideoCapture$OutputFileResults)object);
            this.mSavedVideoUri = null;
        }
        callbackToFutureAdapter$Completer.set(null);
    }

    private /* synthetic */ void m() {
        this.stopRecording();
    }

    private void releaseCameraSurface(boolean bl2) {
        Object object = this.mDeferrableSurface;
        if (object == null) {
            return;
        }
        Object object2 = this.mVideoEncoder;
        ((DeferrableSurface)object).close();
        object = this.mDeferrableSurface.getTerminationFuture();
        o1 o12 = new o1(bl2, (MediaCodec)object2);
        object2 = CameraXExecutors.mainThreadExecutor();
        object.addListener(o12, (Executor)object2);
        object = null;
        if (bl2) {
            this.mVideoEncoder = null;
        }
        this.mCameraSurface = null;
        this.mDeferrableSurface = null;
    }

    private void releaseResources() {
        this.mVideoHandlerThread.quitSafely();
        this.mAudioHandlerThread.quitSafely();
        MediaCodec mediaCodec = this.mAudioEncoder;
        if (mediaCodec != null) {
            mediaCodec.release();
            this.mAudioEncoder = null;
        }
        if ((mediaCodec = this.mAudioRecorder) != null) {
            mediaCodec.release();
            this.mAudioRecorder = null;
        }
        if ((mediaCodec = this.mCameraSurface) != null) {
            boolean bl2 = true;
            this.releaseCameraSurface(bl2);
        }
    }

    private void setAudioParametersByCamcorderProfile(Size object, String string2) {
        int n10;
        int n11 = 0;
        int[] nArray = CamcorderQuality;
        int n12 = nArray.length;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13 = nArray[i10];
            int n14 = Integer.parseInt(string2);
            n14 = (int)(CamcorderProfile.hasProfile((int)n14, (int)n13) ? 1 : 0);
            if (n14 == 0) continue;
            n14 = Integer.parseInt(string2);
            CamcorderProfile camcorderProfile = CamcorderProfile.get((int)n14, (int)n13);
            n14 = object.getWidth();
            int n15 = camcorderProfile.videoFrameWidth;
            if (n14 != n15) continue;
            n14 = object.getHeight();
            n15 = camcorderProfile.videoFrameHeight;
            if (n14 != n15) continue;
            n10 = camcorderProfile.audioChannels;
            this.mAudioChannelCount = n10;
            n10 = camcorderProfile.audioSampleRate;
            this.mAudioSampleRate = n10;
            n10 = camcorderProfile.audioBitRate;
            try {
                this.mAudioBitRate = n10;
                n11 = n10 = 1;
                break;
            }
            catch (NumberFormatException numberFormatException) {
                object = TAG;
                string2 = "The camera Id is not an integer because the camera may be a removable device. Use the default values for the audio related settings.";
                Logger.i((String)object, string2);
                break;
            }
        }
        if (n11 == 0) {
            int n16;
            object = (VideoCaptureConfig)this.getCurrentConfig();
            this.mAudioChannelCount = n16 = ((VideoCaptureConfig)object).getAudioChannelCount();
            this.mAudioSampleRate = n16 = ((VideoCaptureConfig)object).getAudioSampleRate();
            this.mAudioBitRate = n10 = ((VideoCaptureConfig)object).getAudioBitRate();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean writeAudioEncodedBuffer(int n10) {
        boolean bl2;
        int n11;
        Object object;
        Object object2;
        block8: {
            object2 = this.mAudioEncoder;
            object2 = this.getOutputBuffer((MediaCodec)object2, n10);
            object = this.mAudioBufferInfo;
            n11 = object.offset;
            ((ByteBuffer)object2).position(n11);
            n11 = this.mAudioTrackIndex;
            bl2 = true;
            if (n11 >= 0 && (n11 = this.mVideoTrackIndex) >= 0) {
                long l10;
                long l11;
                long l12;
                object = this.mAudioBufferInfo;
                int n12 = object.size;
                if (n12 > 0 && (n11 = (int)((l12 = (l11 = object.presentationTimeUs) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
                    Object object3;
                    try {
                        object = this.mMuxerLock;
                        synchronized (object) {
                            object3 = this.mIsFirstAudioSampleWrite;
                        }
                    }
                    catch (Exception exception) {
                        object = TAG;
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("audio error:size=");
                        int n13 = this.mAudioBufferInfo.size;
                        charSequence.append(n13);
                        charSequence.append("/offset=");
                        n13 = this.mAudioBufferInfo.offset;
                        charSequence.append(n13);
                        charSequence.append("/timeUs=");
                        MediaCodec.BufferInfo bufferInfo = this.mAudioBufferInfo;
                        long l13 = bufferInfo.presentationTimeUs;
                        charSequence.append(l13);
                        charSequence = charSequence.toString();
                        Logger.e((String)object, (String)charSequence);
                        exception.printStackTrace();
                        break block8;
                    }
                    {
                        n12 = (int)(((AtomicBoolean)object3).get() ? 1 : 0);
                        if (n12 == 0) {
                            object3 = TAG;
                            String string2 = "First audio sample written.";
                            Logger.i((String)object3, string2);
                            object3 = this.mIsFirstAudioSampleWrite;
                            ((AtomicBoolean)object3).set(bl2);
                        }
                        object3 = this.mMuxer;
                        int n14 = this.mAudioTrackIndex;
                        MediaCodec.BufferInfo bufferInfo = this.mAudioBufferInfo;
                        object3.writeSampleData(n14, (ByteBuffer)object2, bufferInfo);
                    }
                }
            }
        }
        object2 = this.mAudioEncoder;
        n11 = 0;
        object = null;
        object2.releaseOutputBuffer(n10, false);
        MediaCodec.BufferInfo bufferInfo = this.mAudioBufferInfo;
        n10 = bufferInfo.flags & 4;
        if (n10 == 0) return false;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean writeVideoEncodedBuffer(int n10) {
        boolean bl2 = false;
        if (n10 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Output buffer should not have negative index: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            Logger.e(TAG, string2);
            return false;
        }
        ByteBuffer byteBuffer = this.mVideoEncoder.getOutputBuffer(n10);
        if (byteBuffer == null) {
            Logger.d(TAG, "OutputBuffer was null.");
            return false;
        }
        int n11 = this.mAudioTrackIndex;
        boolean bl3 = true;
        if (n11 >= 0 && (n11 = this.mVideoTrackIndex) >= 0) {
            Object object = this.mVideoBufferInfo;
            int n12 = object.size;
            if (n12 > 0) {
                n11 = object.offset;
                byteBuffer.position(n11);
                object = this.mVideoBufferInfo;
                n12 = object.offset;
                n11 = object.size;
                byteBuffer.limit(n12 += n11);
                object = this.mVideoBufferInfo;
                long l10 = System.nanoTime();
                long l11 = 1000L;
                object.presentationTimeUs = l10 /= l11;
                object = this.mMuxerLock;
                synchronized (object) {
                    Object object2 = this.mIsFirstVideoSampleWrite;
                    n12 = (int)(((AtomicBoolean)object2).get() ? 1 : 0);
                    if (n12 == 0) {
                        object2 = TAG;
                        String string3 = "First video sample written.";
                        Logger.i((String)object2, string3);
                        object2 = this.mIsFirstVideoSampleWrite;
                        ((AtomicBoolean)object2).set(bl3);
                    }
                    object2 = this.mMuxer;
                    int n13 = this.mVideoTrackIndex;
                    MediaCodec.BufferInfo bufferInfo = this.mVideoBufferInfo;
                    object2.writeSampleData(n13, byteBuffer, bufferInfo);
                }
            }
        }
        byteBuffer = this.mVideoEncoder;
        byteBuffer.releaseOutputBuffer(n10, false);
        MediaCodec.BufferInfo bufferInfo = this.mVideoBufferInfo;
        n10 = bufferInfo.flags & 4;
        if (n10 == 0) return bl2;
        return bl3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean audioEncode(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        boolean bl2 = false;
        String string2 = null;
        while (true) {
            MediaCodec mediaCodec;
            int n10;
            Object object;
            Object object2;
            int n11;
            boolean bl3;
            block14: {
                block13: {
                    bl3 = true;
                    if (bl2 || (n11 = this.mIsRecording) == 0) break block13;
                    object2 = this.mEndOfAudioStreamSignal;
                    n11 = ((AtomicBoolean)object2).get();
                    if (n11 != 0) {
                        object2 = this.mEndOfAudioStreamSignal;
                        ((AtomicBoolean)object2).set(false);
                        this.mIsRecording = false;
                    }
                    if ((object2 = this.mAudioEncoder) == null || (object = this.mAudioRecorder) == null) continue;
                    long l10 = -1;
                    int n12 = object2.dequeueInputBuffer(l10);
                    if (n12 >= 0) {
                        object2 = this.mAudioEncoder;
                        object2 = this.getInputBuffer((MediaCodec)object2, n12);
                        ((ByteBuffer)object2).clear();
                        object = this.mAudioRecorder;
                        n10 = this.mAudioBufferSize;
                        int n13 = object.read((ByteBuffer)object2, n10);
                        if (n13 > 0) {
                            mediaCodec = this.mAudioEncoder;
                            long l11 = System.nanoTime();
                            long l12 = l11 / 1000L;
                            n11 = (int)(this.mIsRecording ? 1 : 0);
                            int n14 = n11 != 0 ? 0 : (n11 = 4);
                            mediaCodec.queueInputBuffer(n12, 0, n13, l12, n14);
                        }
                    }
                    break block14;
                }
                string2 = TAG;
                object2 = "audioRecorder stop";
                try {
                    Logger.i(string2, (String)object2);
                    string2 = this.mAudioRecorder;
                    string2.stop();
                }
                catch (IllegalStateException illegalStateException) {
                    object2 = "Audio recorder stop failed!";
                    videoCapture$OnVideoSavedCallback.onError((int)(bl3 ? 1 : 0), (String)object2, illegalStateException);
                }
                try {
                    string2 = this.mAudioEncoder;
                    string2.stop();
                }
                catch (IllegalStateException illegalStateException) {
                    object2 = "Audio encoder stop failed!";
                    videoCapture$OnVideoSavedCallback.onError((int)(bl3 ? 1 : 0), (String)object2, illegalStateException);
                }
                Logger.i(TAG, "Audio encode thread end");
                this.mEndOfVideoStreamSignal.set(bl3);
                return false;
            }
            do {
                int n15;
                long l13;
                if ((n11 = (object2 = this.mAudioEncoder).dequeueOutputBuffer((MediaCodec.BufferInfo)(object = this.mAudioBufferInfo), l13 = 0L)) != (n15 = -2)) {
                    n15 = -1;
                    if (n11 == n15) continue;
                    bl2 = this.writeAudioEncodedBuffer(n11);
                    continue;
                }
                object = this.mMuxerLock;
                synchronized (object) {
                    MediaMuxer mediaMuxer = this.mMuxer;
                    mediaCodec = this.mAudioEncoder;
                    mediaCodec = mediaCodec.getOutputFormat();
                    this.mAudioTrackIndex = n10 = mediaMuxer.addTrack((MediaFormat)mediaCodec);
                    if (n10 >= 0 && (n10 = this.mVideoTrackIndex) >= 0) {
                        this.mMuxerStarted = bl3;
                        mediaMuxer = this.mMuxer;
                        mediaMuxer.start();
                    }
                }
            } while (n11 >= 0 && !bl2);
        }
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public /* synthetic */ void e(VideoCapture$OutputFileOptions videoCapture$OutputFileOptions, Executor executor, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.d(videoCapture$OutputFileOptions, executor, videoCapture$OnVideoSavedCallback);
    }

    public UseCaseConfig getDefaultConfig(boolean bl2, UseCaseConfigFactory object) {
        Config config;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.VIDEO_CAPTURE;
        object = object.getConfig(useCaseConfigFactory$CaptureType);
        if (bl2) {
            config = DEFAULT_CONFIG.getConfig();
            object = Config.mergeConfigs((Config)object, config);
        }
        if (object == null) {
            bl2 = false;
            config = null;
        } else {
            config = this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        }
        return config;
    }

    public UseCaseConfig$Builder getUseCaseConfigBuilder(Config config) {
        return VideoCapture$Builder.fromConfig(config);
    }

    public /* synthetic */ void h() {
        this.g();
    }

    public /* synthetic */ void j(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        this.i(videoCapture$OnVideoSavedCallback);
    }

    public /* synthetic */ void l(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback, String string2, Size size, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        this.k(videoCapture$OnVideoSavedCallback, string2, size, callbackToFutureAdapter$Completer);
    }

    public /* synthetic */ void n() {
        this.m();
    }

    public void onAttached() {
        HandlerThread handlerThread;
        this.mVideoHandlerThread = handlerThread = new HandlerThread("CameraX-video encoding thread");
        this.mAudioHandlerThread = handlerThread = new HandlerThread("CameraX-audio encoding thread");
        this.mVideoHandlerThread.start();
        Looper looper = this.mVideoHandlerThread.getLooper();
        handlerThread = new Handler(looper);
        this.mVideoHandler = handlerThread;
        this.mAudioHandlerThread.start();
        looper = this.mAudioHandlerThread.getLooper();
        handlerThread = new Handler(looper);
        this.mAudioHandler = handlerThread;
    }

    public void onDetached() {
        this.stopRecording();
        ListenableFuture listenableFuture = this.mRecordingFuture;
        if (listenableFuture != null) {
            t1 t12 = new t1(this);
            ScheduledExecutorService scheduledExecutorService = CameraXExecutors.mainThreadExecutor();
            listenableFuture.addListener(t12, scheduledExecutorService);
        } else {
            this.releaseResources();
        }
    }

    public void onStateDetached() {
        this.stopRecording();
    }

    public Size onSuggestedResolutionUpdated(Size size) {
        Object object = this.mCameraSurface;
        if (object != null) {
            this.mVideoEncoder.stop();
            this.mVideoEncoder.release();
            this.mAudioEncoder.stop();
            this.mAudioEncoder.release();
            object = null;
            this.releaseCameraSurface(false);
        }
        object = VIDEO_MIME_TYPE;
        try {
            object = MediaCodec.createEncoderByType((String)object);
        }
        catch (IOException iOException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to create MediaCodec due to: ");
            Object object2 = iOException.getCause();
            stringBuilder.append(object2);
            object2 = stringBuilder.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        this.mVideoEncoder = object;
        object = AUDIO_MIME_TYPE;
        object = MediaCodec.createEncoderByType((String)object);
        this.mAudioEncoder = object;
        object = this.getCameraId();
        this.setupEncoder((String)object, size);
        return size;
    }

    public void setTargetRotation(int n10) {
        this.setTargetRotationInternal(n10);
    }

    public void setupEncoder(String string2, Size object) {
        int n10;
        VideoCaptureConfig videoCaptureConfig = (VideoCaptureConfig)this.getCurrentConfig();
        this.mVideoEncoder.reset();
        Object object2 = this.mVideoEncoder;
        MediaFormat mediaFormat = VideoCapture.createMediaFormat(videoCaptureConfig, object);
        int n11 = 1;
        object2.configure(mediaFormat, null, null, n11);
        object2 = this.mCameraSurface;
        mediaFormat = null;
        if (object2 != null) {
            this.releaseCameraSurface(false);
        }
        object2 = this.mVideoEncoder.createInputSurface();
        this.mCameraSurface = object2;
        SessionConfig$Builder sessionConfig$Builder = SessionConfig$Builder.createFrom(videoCaptureConfig);
        Object object3 = this.mDeferrableSurface;
        if (object3 != null) {
            ((DeferrableSurface)object3).close();
        }
        Object object4 = this.mCameraSurface;
        object3 = new ImmediateSurface((Surface)object4);
        this.mDeferrableSurface = object3;
        object3 = ((DeferrableSurface)object3).getTerminationFuture();
        Objects.requireNonNull(object2);
        object4 = new t0((Surface)object2);
        object2 = CameraXExecutors.mainThreadExecutor();
        object3.addListener((Runnable)object4, (Executor)object2);
        object2 = this.mDeferrableSurface;
        sessionConfig$Builder.addSurface((DeferrableSurface)object2);
        object2 = new VideoCapture$1(this, string2, (Size)object);
        sessionConfig$Builder.addErrorListener((SessionConfig$ErrorListener)object2);
        object2 = sessionConfig$Builder.build();
        this.updateSessionConfig((SessionConfig)object2);
        this.setAudioParametersByCamcorderProfile((Size)object, string2);
        this.mAudioEncoder.reset();
        string2 = this.mAudioEncoder;
        object = this.createAudioMediaFormat();
        string2.configure((MediaFormat)object, null, null, n11);
        string2 = this.mAudioRecorder;
        if (string2 != null) {
            string2.release();
        }
        string2 = this.autoConfigAudioRecordSource(videoCaptureConfig);
        this.mAudioRecorder = string2;
        if (string2 == null) {
            string2 = TAG;
            object = "AudioRecord object cannot initialized correctly!";
            Logger.e(string2, (String)object);
        }
        this.mVideoTrackIndex = n10 = -1;
        this.mAudioTrackIndex = n10;
        this.mIsRecording = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startRecording(VideoCapture$OutputFileOptions object, Executor object2, VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback) {
        Object object3;
        Object object4;
        Object object5 = Looper.getMainLooper();
        if (object5 != (object4 = Looper.myLooper())) {
            object5 = CameraXExecutors.mainThreadExecutor();
            object4 = new k1(this, (VideoCapture$OutputFileOptions)object, (Executor)object2, videoCapture$OnVideoSavedCallback);
            object5.execute((Runnable)object4);
            return;
        }
        Logger.i(TAG, "startRecording");
        object5 = this.mIsFirstVideoSampleWrite;
        object4 = null;
        ((AtomicBoolean)object5).set(false);
        object5 = this.mIsFirstAudioSampleWrite;
        ((AtomicBoolean)object5).set(false);
        VideoCapture$VideoSavedListenerWrapper videoCapture$VideoSavedListenerWrapper = new VideoCapture$VideoSavedListenerWrapper((Executor)object2, videoCapture$OnVideoSavedCallback);
        object2 = this.getCamera();
        videoCapture$OnVideoSavedCallback = null;
        if (object2 == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Not bound to a Camera [");
            ((StringBuilder)object2).append(this);
            ((StringBuilder)object2).append("]");
            object2 = ((StringBuilder)object2).toString();
            videoCapture$VideoSavedListenerWrapper.onError(5, (String)object2, null);
            return;
        }
        object5 = this.mEndOfAudioVideoSignal;
        int n10 = (int)(((AtomicBoolean)object5).get() ? 1 : 0);
        if (n10 == 0) {
            videoCapture$VideoSavedListenerWrapper.onError(3, "It is still in video recording!", null);
            return;
        }
        n10 = 1;
        try {
            object3 = this.mAudioRecorder;
            object3.startRecording();
        }
        catch (IllegalStateException illegalStateException) {
            videoCapture$VideoSavedListenerWrapper.onError(n10, "AudioRecorder start fail", illegalStateException);
            return;
        }
        object3 = new AtomicReference();
        Object object6 = new r1((AtomicReference)object3);
        this.mRecordingFuture = object6 = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object6);
        Object object7 = object3 = Preconditions.checkNotNull((CallbackToFutureAdapter$Completer)((AtomicReference)object3).get());
        object7 = (CallbackToFutureAdapter$Completer)object3;
        object3 = this.mRecordingFuture;
        object6 = new p1(this);
        Object object8 = CameraXExecutors.mainThreadExecutor();
        object3.addListener((Runnable)object6, (Executor)object8);
        object3 = TAG;
        object6 = "videoEncoder start";
        try {
            Logger.i((String)object3, (String)object6);
            object3 = this.mVideoEncoder;
            object3.start();
            object3 = TAG;
            object6 = "audioEncoder start";
            Logger.i((String)object3, (String)object6);
            object3 = this.mAudioEncoder;
            object3.start();
        }
        catch (IllegalStateException illegalStateException) {
            ((CallbackToFutureAdapter$Completer)object7).set(null);
            videoCapture$VideoSavedListenerWrapper.onError(n10, "Audio/Video encoder start fail", illegalStateException);
            return;
        }
        try {
            object3 = this.mMuxerLock;
            synchronized (object3) {
                object6 = this.initMediaMuxer((VideoCapture$OutputFileOptions)object);
                this.mMuxer = object6;
            }
        }
        catch (IOException iOException) {
            ((CallbackToFutureAdapter$Completer)object7).set(null);
            videoCapture$VideoSavedListenerWrapper.onError(2, "MediaMuxer creation failed!", iOException);
            return;
        }
        {
            Preconditions.checkNotNull(object6);
            object6 = this.mMuxer;
            int n11 = this.getRelativeRotation((CameraInternal)object2);
            object6.setOrientationHint(n11);
            object = ((VideoCapture$OutputFileOptions)object).getMetadata();
            if (object != null && (object2 = ((VideoCapture$Metadata)object).location) != null) {
                object6 = this.mMuxer;
                double d10 = object2.getLatitude();
                float f10 = (float)d10;
                object = ((VideoCapture$Metadata)object).location;
                d10 = object.getLongitude();
                float f11 = (float)d10;
                object6.setLocation(f10, f11);
            }
        }
        this.mEndOfVideoStreamSignal.set(false);
        this.mEndOfAudioStreamSignal.set(false);
        this.mEndOfAudioVideoSignal.set(false);
        this.mIsRecording = n10;
        this.notifyActive();
        object = this.mAudioHandler;
        object2 = new l1(this, videoCapture$VideoSavedListenerWrapper);
        object.post((Runnable)object2);
        object8 = this.getCameraId();
        Size size = this.getAttachedSurfaceResolution();
        object = this.mVideoHandler;
        object3 = object2;
        object6 = this;
        object2 = new q1(this, videoCapture$VideoSavedListenerWrapper, (String)object8, size, (CallbackToFutureAdapter$Completer)object7);
        object.post((Runnable)object2);
    }

    public void stopRecording() {
        Object object;
        Object object2 = Looper.getMainLooper();
        if (object2 != (object = Looper.myLooper())) {
            object2 = CameraXExecutors.mainThreadExecutor();
            object = new s1(this);
            object2.execute((Runnable)object);
            return;
        }
        object = "stopRecording";
        Logger.i(TAG, (String)object);
        this.notifyInactive();
        object2 = this.mEndOfAudioVideoSignal;
        boolean bl2 = ((AtomicBoolean)object2).get();
        if (!bl2 && (bl2 = this.mIsRecording)) {
            object2 = this.mEndOfAudioStreamSignal;
            boolean bl3 = true;
            ((AtomicBoolean)object2).set(bl3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean videoEncode(VideoCapture$OnVideoSavedCallback videoCapture$OnVideoSavedCallback, String string2, Size object) {
        Object object2;
        boolean bl2;
        String string3;
        boolean bl3;
        int n10;
        block17: {
            MediaCodec.BufferInfo bufferInfo;
            n10 = 0;
            object = null;
            bl3 = false;
            String string4 = null;
            while (true) {
                int n11;
                long l10;
                int n12 = 0;
                string3 = null;
                bl2 = true;
                if (n10 != 0 || bl3) break;
                object2 = this.mEndOfVideoStreamSignal;
                int n13 = ((AtomicBoolean)object2).get();
                if (n13 != 0) {
                    this.mVideoEncoder.signalEndOfInputStream();
                    object2 = this.mEndOfVideoStreamSignal;
                    ((AtomicBoolean)object2).set(false);
                }
                if ((n13 = (object2 = this.mVideoEncoder).dequeueOutputBuffer(bufferInfo = this.mVideoBufferInfo, l10 = 10000L)) != (n11 = -2)) {
                    n12 = -1;
                    if (n13 == n12) continue;
                    n10 = (int)(this.writeVideoEncodedBuffer(n13) ? 1 : 0);
                    continue;
                }
                n13 = (int)(this.mMuxerStarted ? 1 : 0);
                if (n13 != 0) {
                    string4 = "Unexpected change in video encoding format.";
                    videoCapture$OnVideoSavedCallback.onError((int)(bl2 ? 1 : 0), string4, null);
                    bl3 = bl2;
                }
                object2 = this.mMuxerLock;
                synchronized (object2) {
                    string3 = this.mMuxer;
                    bufferInfo = this.mVideoEncoder;
                    bufferInfo = bufferInfo.getOutputFormat();
                    this.mVideoTrackIndex = n12 = string3.addTrack((MediaFormat)bufferInfo);
                    n11 = this.mAudioTrackIndex;
                    if (n11 >= 0 && n12 >= 0) {
                        this.mMuxerStarted = bl2;
                        string3 = TAG;
                        String string5 = "media mMuxer start";
                        Logger.i(string3, string5);
                        string3 = this.mMuxer;
                        string3.start();
                    }
                }
            }
            object = TAG;
            object2 = "videoEncoder stop";
            try {
                Logger.i((String)object, (String)object2);
                object = this.mVideoEncoder;
                object.stop();
            }
            catch (IllegalStateException illegalStateException) {
                string4 = "Video encoder stop failed!";
                videoCapture$OnVideoSavedCallback.onError((int)(bl2 ? 1 : 0), string4, illegalStateException);
                bl3 = bl2;
            }
            n10 = 2;
            try {
                object2 = this.mMuxerLock;
                synchronized (object2) {
                    bufferInfo = this.mMuxer;
                    if (bufferInfo == null) break block17;
                    boolean bl4 = this.mMuxerStarted;
                    if (!bl4) break block18;
                }
            }
            catch (IllegalStateException illegalStateException) {
                object2 = "Muxer stop failed!";
                videoCapture$OnVideoSavedCallback.onError(n10, (String)object2, illegalStateException);
                bl3 = bl2;
                break block17;
            }
            {
                block18: {
                    bufferInfo.stop();
                }
                bufferInfo = this.mMuxer;
                bufferInfo.release();
                this.mMuxer = null;
            }
        }
        object2 = this.mParcelFileDescriptor;
        if (object2 != null) {
            try {
                object2.close();
                this.mParcelFileDescriptor = null;
            }
            catch (IOException iOException) {
                string3 = "File descriptor close failed!";
                videoCapture$OnVideoSavedCallback.onError(n10, string3, iOException);
                bl3 = bl2;
            }
        }
        this.mMuxerStarted = false;
        this.mEndOfAudioVideoSignal.set(bl2);
        Logger.i(TAG, "Video encode thread end.");
        return bl3;
    }
}

