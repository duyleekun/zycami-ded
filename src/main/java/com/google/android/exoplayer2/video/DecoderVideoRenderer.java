/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.video.VideoDecoderInputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher;

public abstract class DecoderVideoRenderer
extends BaseRenderer {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private int consecutiveDroppedFrameCount;
    private Decoder decoder;
    public DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener$EventDispatcher eventDispatcher;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private final TimedValueQueue formatQueue;
    private VideoFrameMetadataListener frameMetadataListener;
    private long initialPositionUs;
    private VideoDecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private long joiningDeadlineMs;
    private long lastRenderTimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private VideoDecoderOutputBuffer outputBuffer;
    private VideoDecoderOutputBufferRenderer outputBufferRenderer;
    private Format outputFormat;
    private int outputMode;
    private boolean outputStreamEnded;
    private long outputStreamOffsetUs;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private int reportedHeight;
    private int reportedWidth;
    private DrmSession sourceDrmSession;
    private Surface surface;
    private boolean waitingForFirstSampleInFormat;

    public DecoderVideoRenderer(long l10, Handler handler, VideoRendererEventListener videoRendererEventListener, int n10) {
        super(2);
        this.allowedJoiningTimeMs = l10;
        this.maxDroppedFramesToNotify = n10;
        this.joiningDeadlineMs = -9223372036854775807L;
        this.clearReportedVideoSize();
        Object object = new TimedValueQueue();
        this.formatQueue = object;
        this.flagsOnlyBuffer = object = DecoderInputBuffer.newFlagsOnlyInstance();
        this.eventDispatcher = object = new VideoRendererEventListener$EventDispatcher(handler, videoRendererEventListener);
        this.decoderReinitializationState = 0;
        this.outputMode = -1;
    }

    private void clearRenderedFirstFrame() {
        this.renderedFirstFrameAfterReset = false;
    }

    private void clearReportedVideoSize() {
        int n10;
        this.reportedWidth = n10 = -1;
        this.reportedHeight = n10;
    }

    private boolean drainOutputBuffer(long l10, long l11) {
        int n10;
        int n11;
        DecoderCounters decoderCounters;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        if (videoDecoderOutputBuffer == null) {
            this.outputBuffer = videoDecoderOutputBuffer = (VideoDecoderOutputBuffer)this.decoder.dequeueOutputBuffer();
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            decoderCounters = this.decoderCounters;
            int n12 = decoderCounters.skippedOutputBufferCount;
            n11 = videoDecoderOutputBuffer.skippedOutputBufferCount;
            decoderCounters.skippedOutputBufferCount = n12 += n11;
            this.buffersInCodecCount = n10 = this.buffersInCodecCount - n11;
        }
        videoDecoderOutputBuffer = this.outputBuffer;
        n11 = videoDecoderOutputBuffer.isEndOfStream();
        n10 = 0;
        decoderCounters = null;
        if (n11 != 0) {
            int n13 = this.decoderReinitializationState;
            int n14 = 2;
            if (n13 == n14) {
                this.releaseDecoder();
                this.maybeInitDecoder();
            } else {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.outputBuffer;
                videoDecoderOutputBuffer2.release();
                this.outputBuffer = null;
                n13 = 1;
                this.outputStreamEnded = n13;
            }
            return false;
        }
        boolean bl2 = this.processOutputBuffer(l10, l11);
        if (bl2) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = this.outputBuffer;
            long l12 = videoDecoderOutputBuffer3.timeUs;
            this.onProcessedOutputBuffer(l12);
            this.outputBuffer = null;
        }
        return bl2;
    }

    private boolean feedInputBuffer() {
        int n10;
        int n11;
        Object object = this.decoder;
        int n12 = 0;
        Object object2 = null;
        if (object != null && (n11 = this.decoderReinitializationState) != (n10 = 2) && (n11 = (int)(this.inputStreamEnded ? 1 : 0)) == 0) {
            int n13;
            Object object3;
            VideoDecoderInputBuffer videoDecoderInputBuffer = this.inputBuffer;
            if (videoDecoderInputBuffer == null) {
                this.inputBuffer = object = (VideoDecoderInputBuffer)object.dequeueInputBuffer();
                if (object == null) {
                    return false;
                }
            }
            int n14 = this.decoderReinitializationState;
            n11 = 0;
            videoDecoderInputBuffer = null;
            int n15 = 1;
            if (n14 == n15) {
                this.inputBuffer.setFlags(4);
                object = this.decoder;
                VideoDecoderInputBuffer videoDecoderInputBuffer2 = this.inputBuffer;
                object.queueInputBuffer(videoDecoderInputBuffer2);
                this.inputBuffer = null;
                this.decoderReinitializationState = n10;
                return false;
            }
            object = this.getFormatHolder();
            n10 = this.readSource((FormatHolder)object, (DecoderInputBuffer)(object3 = this.inputBuffer), false);
            if (n10 != (n13 = -5)) {
                n14 = -4;
                if (n10 != n14) {
                    n14 = -3;
                    if (n10 == n14) {
                        return false;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                object = this.inputBuffer;
                n14 = (int)(((Buffer)object).isEndOfStream() ? 1 : 0);
                if (n14 != 0) {
                    this.inputStreamEnded = n15;
                    object = this.decoder;
                    object3 = this.inputBuffer;
                    object.queueInputBuffer(object3);
                    this.inputBuffer = null;
                    return false;
                }
                n14 = (int)(this.waitingForFirstSampleInFormat ? 1 : 0);
                if (n14 != 0) {
                    object = this.formatQueue;
                    long l10 = this.inputBuffer.timeUs;
                    object3 = this.inputFormat;
                    ((TimedValueQueue)object).add(l10, object3);
                    this.waitingForFirstSampleInFormat = false;
                }
                this.inputBuffer.flip();
                object = this.inputBuffer;
                object2 = this.inputFormat;
                ((VideoDecoderInputBuffer)object).format = object2;
                this.onQueueInputBuffer((VideoDecoderInputBuffer)object);
                object = this.decoder;
                object2 = this.inputBuffer;
                object.queueInputBuffer(object2);
                this.buffersInCodecCount = n14 = this.buffersInCodecCount + n15;
                this.decoderReceivedBuffers = n15;
                object = this.decoderCounters;
                ((DecoderCounters)object).inputBufferCount = n12 = ((DecoderCounters)object).inputBufferCount + n15;
                this.inputBuffer = null;
                return n15 != 0;
            }
            this.onInputFormatChanged((FormatHolder)object);
            return n15 != 0;
        }
        return false;
    }

    private boolean hasOutput() {
        int n10 = this.outputMode;
        int n11 = -1;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    private static boolean isBufferLate(long l10) {
        long l11 = -30000L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private static boolean isBufferVeryLate(long l10) {
        long l11 = 4294467296L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    /*
     * WARNING - void declaration
     */
    private void maybeInitDecoder() {
        void var1_4;
        Object object = this.decoder;
        if (object != null) {
            return;
        }
        object = this.sourceDrmSession;
        this.setDecoderDrmSession((DrmSession)object);
        int n10 = 0;
        object = null;
        Object object2 = this.decoderDrmSession;
        if (object2 != null && (object = object2.getMediaCrypto()) == null && (object2 = this.decoderDrmSession.getError()) == null) {
            return;
        }
        long l10 = SystemClock.elapsedRealtime();
        Object object3 = this.inputFormat;
        object = this.createDecoder((Format)object3, (ExoMediaCrypto)object);
        this.decoder = object;
        n10 = this.outputMode;
        this.setDecoderOutputMode(n10);
        long l11 = SystemClock.elapsedRealtime();
        object3 = this.eventDispatcher;
        object = this.decoder;
        String string2 = object.getName();
        long l12 = l11 - l10;
        ((VideoRendererEventListener$EventDispatcher)object3).decoderInitialized(string2, l11, l12);
        object = this.decoderCounters;
        int n11 = ((DecoderCounters)object).decoderInitCount + 1;
        try {
            ((DecoderCounters)object).decoderInitCount = n11;
            return;
        }
        catch (OutOfMemoryError outOfMemoryError) {
        }
        catch (DecoderException decoderException) {
            // empty catch block
        }
        object2 = this.inputFormat;
        throw this.createRendererException((Throwable)var1_4, (Format)object2);
    }

    private void maybeNotifyDroppedFrames() {
        int n10 = this.droppedFrames;
        if (n10 > 0) {
            long l10 = SystemClock.elapsedRealtime();
            long l11 = this.droppedFrameAccumulationStartTimeMs;
            l11 = l10 - l11;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            int n11 = this.droppedFrames;
            videoRendererEventListener$EventDispatcher.droppedFrames(n11, l11);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = l10;
        }
    }

    private void maybeNotifyRenderedFirstFrame() {
        boolean bl2;
        this.renderedFirstFrameAfterEnable = bl2 = true;
        boolean bl3 = this.renderedFirstFrameAfterReset;
        if (!bl3) {
            this.renderedFirstFrameAfterReset = bl2;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            Surface surface = this.surface;
            videoRendererEventListener$EventDispatcher.renderedFirstFrame(surface);
        }
    }

    private void maybeNotifyVideoSizeChanged(int n10, int n11) {
        int n12 = this.reportedWidth;
        if (n12 != n10 || (n12 = this.reportedHeight) != n11) {
            this.reportedWidth = n10;
            this.reportedHeight = n11;
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            float f10 = 1.0f;
            videoRendererEventListener$EventDispatcher.videoSizeChanged(n10, n11, 0, f10);
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        boolean bl2 = this.renderedFirstFrameAfterReset;
        if (bl2) {
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            Surface surface = this.surface;
            videoRendererEventListener$EventDispatcher.renderedFirstFrame(surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        int n10;
        int n11 = this.reportedWidth;
        int n12 = -1;
        if (n11 != n12 || (n10 = this.reportedHeight) != n12) {
            VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            n10 = this.reportedHeight;
            float f10 = 1.0f;
            videoRendererEventListener$EventDispatcher.videoSizeChanged(n11, n10, 0, f10);
        }
    }

    private void onOutputChanged() {
        this.maybeRenotifyVideoSizeChanged();
        this.clearRenderedFirstFrame();
        int n10 = this.getState();
        int n11 = 2;
        if (n10 == n11) {
            this.setJoiningDeadlineMs();
        }
    }

    private void onOutputRemoved() {
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
    }

    private void onOutputReset() {
        this.maybeRenotifyVideoSizeChanged();
        this.maybeRenotifyRenderedFirstFrame();
    }

    private boolean processOutputBuffer(long l10, long l11) {
        boolean bl2;
        int n10;
        long l12 = this.initialPositionUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            this.initialPositionUs = l10;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
        l12 = videoDecoderOutputBuffer.timeUs - l10;
        int n11 = this.hasOutput();
        int n12 = 1;
        if (!n11) {
            boolean bl3 = DecoderVideoRenderer.isBufferLate(l12);
            if (bl3) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.outputBuffer;
                this.skipOutputBuffer(videoDecoderOutputBuffer2);
                return n12 != 0;
            }
            return false;
        }
        long l15 = this.outputBuffer.timeUs;
        long l16 = this.outputStreamOffsetUs;
        Format format = (Format)this.formatQueue.pollFloor(l15 -= l16);
        if (format != null) {
            this.outputFormat = format;
        }
        l16 = SystemClock.elapsedRealtime() * 1000L;
        long l17 = this.lastRenderTimeUs;
        l16 -= l17;
        n11 = this.getState();
        if (n11 == (n10 = 2)) {
            n11 = n12;
        } else {
            n11 = 0;
            format = null;
        }
        n10 = (int)(this.renderedFirstFrameAfterEnable ? 1 : 0);
        n10 = (n10 == 0 ? n11 != 0 || (n10 = (int)(this.mayRenderFirstFrameAfterEnableIfNotStarted ? 1 : 0)) != 0 : (n10 = (int)(this.renderedFirstFrameAfterReset ? 1 : 0)) == 0) ? n12 : 0;
        if (!(n10 || n11 && (bl2 = this.shouldForceRenderOutputBuffer(l12, l16)))) {
            long l18;
            if (n11 && (n11 = (int)((l18 = l10 - (l16 = this.initialPositionUs)) == 0L ? 0 : (l18 < 0L ? -1 : 1)))) {
                Object object2;
                n11 = this.shouldDropBuffersToKeyframe(l12, l11);
                if (n11 && (object2 = this.maybeDropBuffersToKeyframe(l10)) != 0) {
                    return false;
                }
                object2 = this.shouldDropOutputBuffer(l12, l11);
                if (object2 != 0) {
                    VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = this.outputBuffer;
                    this.dropOutputBuffer(videoDecoderOutputBuffer3);
                    return n12 != 0;
                }
                l10 = 30000L;
                long l19 = l12 - l10;
                object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object2 < 0) {
                    VideoDecoderOutputBuffer videoDecoderOutputBuffer4 = this.outputBuffer;
                    Format format2 = this.outputFormat;
                    this.renderOutputBuffer(videoDecoderOutputBuffer4, l15, format2);
                    return n12 != 0;
                }
            }
            return false;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer5 = this.outputBuffer;
        Format format3 = this.outputFormat;
        this.renderOutputBuffer(videoDecoderOutputBuffer5, l15, format3);
        return n12 != 0;
    }

    private void setDecoderDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void setJoiningDeadlineMs() {
        long l10 = this.allowedJoiningTimeMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = SystemClock.elapsedRealtime();
            l11 = this.allowedJoiningTimeMs;
            l10 += l11;
        } else {
            l10 = -9223372036854775807L;
        }
        this.joiningDeadlineMs = l10;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    public DecoderReuseEvaluation canReuseDecoder(String string2, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluation = new DecoderReuseEvaluation(string2, format, format2, 0, 1);
        return decoderReuseEvaluation;
    }

    public abstract Decoder createDecoder(Format var1, ExoMediaCrypto var2);

    public void dropOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.updateDroppedBufferCounters(1);
        videoDecoderOutputBuffer.release();
    }

    public void flushDecoder() {
        this.buffersInCodecCount = 0;
        int n10 = this.decoderReinitializationState;
        if (n10 != 0) {
            this.releaseDecoder();
            this.maybeInitDecoder();
        } else {
            n10 = 0;
            Decoder decoder = null;
            this.inputBuffer = null;
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.outputBuffer;
            if (videoDecoderOutputBuffer != null) {
                videoDecoderOutputBuffer.release();
                this.outputBuffer = null;
            }
            decoder = this.decoder;
            decoder.flush();
            this.decoderReceivedBuffers = false;
        }
    }

    public void handleMessage(int n10, Object object) {
        int n11 = 1;
        if (n10 == n11) {
            object = (Surface)object;
            this.setOutputSurface((Surface)object);
        } else {
            n11 = 8;
            if (n10 == n11) {
                object = (VideoDecoderOutputBufferRenderer)object;
                this.setOutputBufferRenderer((VideoDecoderOutputBufferRenderer)object);
            } else {
                n11 = 6;
                if (n10 == n11) {
                    this.frameMetadataListener = object = (VideoFrameMetadataListener)object;
                } else {
                    super.handleMessage(n10, object);
                }
            }
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        long l10;
        Object object;
        Object object2 = this.inputFormat;
        boolean bl2 = true;
        long l11 = -9223372036854775807L;
        if (!(object2 == null || (object = this.isSourceReady()) == 0 && (object2 = this.outputBuffer) == null || (object = this.renderedFirstFrameAfterReset) == 0 && (object = this.hasOutput()) != 0)) {
            this.joiningDeadlineMs = l11;
            return bl2;
        }
        long l12 = this.joiningDeadlineMs;
        long l13 = l12 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == 0) {
            return false;
        }
        long l14 = SystemClock.elapsedRealtime();
        long l15 = l14 - (l10 = this.joiningDeadlineMs);
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            return bl2;
        }
        this.joiningDeadlineMs = l11;
        return false;
    }

    public boolean maybeDropBuffersToKeyframe(long l10) {
        int n10 = this.skipSource(l10);
        if (n10 == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        int n11 = decoderCounters.droppedToKeyframeCount;
        int n12 = 1;
        decoderCounters.droppedToKeyframeCount = n11 += n12;
        int n13 = this.buffersInCodecCount + n10;
        this.updateDroppedBufferCounters(n13);
        this.flushDecoder();
        return n12 != 0;
    }

    public void onDisabled() {
        VideoRendererEventListener$EventDispatcher videoRendererEventListener$EventDispatcher = null;
        this.inputFormat = null;
        this.clearReportedVideoSize();
        this.clearRenderedFirstFrame();
        try {
            this.setSourceDrmSession(null);
            this.releaseDecoder();
            return;
        }
        finally {
            videoRendererEventListener$EventDispatcher = this.eventDispatcher;
            DecoderCounters decoderCounters = this.decoderCounters;
            videoRendererEventListener$EventDispatcher.disabled(decoderCounters);
        }
    }

    public void onEnabled(boolean bl2, boolean bl3) {
        DecoderCounters decoderCounters;
        this.decoderCounters = decoderCounters = new DecoderCounters();
        this.eventDispatcher.enabled(decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = bl3;
        this.renderedFirstFrameAfterEnable = false;
    }

    public void onInputFormatChanged(FormatHolder object) {
        Object object2;
        boolean bl2;
        this.waitingForFirstSampleInFormat = bl2 = true;
        Object object3 = object2 = Assertions.checkNotNull(((FormatHolder)object).format);
        object3 = (Format)object2;
        object = ((FormatHolder)object).drmSession;
        this.setSourceDrmSession((DrmSession)object);
        Format format = this.inputFormat;
        this.inputFormat = object3;
        object = this.decoder;
        if (object == null) {
            this.maybeInitDecoder();
            object = this.eventDispatcher;
            Format format2 = this.inputFormat;
            ((VideoRendererEventListener$EventDispatcher)object).inputFormatChanged(format2, null);
            return;
        }
        object2 = this.sourceDrmSession;
        Object object4 = this.decoderDrmSession;
        if (object2 != object4) {
            String string2 = object.getName();
            int n10 = 128;
            object4 = object2;
            object2 = new DecoderReuseEvaluation(string2, format, (Format)object3, 0, n10);
        } else {
            object = object.getName();
            object2 = this.canReuseDecoder((String)object, format, (Format)object3);
        }
        int n11 = ((DecoderReuseEvaluation)object2).result;
        if (n11 == 0) {
            n11 = (int)(this.decoderReceivedBuffers ? 1 : 0);
            if (n11 != 0) {
                this.decoderReinitializationState = (int)(bl2 ? 1 : 0);
            } else {
                this.releaseDecoder();
                this.maybeInitDecoder();
            }
        }
        object = this.eventDispatcher;
        Format format3 = this.inputFormat;
        ((VideoRendererEventListener$EventDispatcher)object).inputFormatChanged(format3, (DecoderReuseEvaluation)object2);
    }

    public void onPositionReset(long l10, boolean bl2) {
        long l11;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.clearRenderedFirstFrame();
        this.initialPositionUs = l11 = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        Decoder decoder = this.decoder;
        if (decoder != null) {
            this.flushDecoder();
        }
        if (bl2) {
            this.setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = l11;
        }
        this.formatQueue.clear();
    }

    public void onProcessedOutputBuffer(long l10) {
        int n10;
        this.buffersInCodecCount = n10 = this.buffersInCodecCount + -1;
    }

    public void onQueueInputBuffer(VideoDecoderInputBuffer videoDecoderInputBuffer) {
    }

    public void onStarted() {
        long l10;
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = l10 = SystemClock.elapsedRealtime();
        this.lastRenderTimeUs = l10 = SystemClock.elapsedRealtime() * 1000L;
    }

    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        this.maybeNotifyDroppedFrames();
    }

    public void onStreamChanged(Format[] formatArray, long l10, long l11) {
        this.outputStreamOffsetUs = l11;
        super.onStreamChanged(formatArray, l10, l11);
    }

    public void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        this.buffersInCodecCount = 0;
        Object object = this.decoder;
        if (object != null) {
            int n10;
            Object object2 = this.decoderCounters;
            ((DecoderCounters)object2).decoderReleaseCount = n10 = ((DecoderCounters)object2).decoderReleaseCount + 1;
            object.release();
            object = this.eventDispatcher;
            object2 = this.decoder.getName();
            ((VideoRendererEventListener$EventDispatcher)object).decoderReleased((String)object2);
            this.decoder = null;
        }
        this.setDecoderDrmSession(null);
    }

    public void render(long l10, long l11) {
        boolean bl2 = this.outputStreamEnded;
        if (bl2) {
            return;
        }
        Object object = this.inputFormat;
        if (object == null) {
            object = this.getFormatHolder();
            this.flagsOnlyBuffer.clear();
            DecoderInputBuffer decoderInputBuffer = this.flagsOnlyBuffer;
            boolean bl3 = true;
            int bl4 = this.readSource((FormatHolder)object, decoderInputBuffer, bl3);
            int bl5 = -5;
            if (bl4 == bl5) {
                this.onInputFormatChanged((FormatHolder)object);
            } else {
                int bl6 = -4;
                if (bl4 == bl6) {
                    DecoderInputBuffer decoderCounters = this.flagsOnlyBuffer;
                    boolean bl7 = decoderCounters.isEndOfStream();
                    Assertions.checkState(bl7);
                    this.inputStreamEnded = bl3;
                    this.outputStreamEnded = bl3;
                }
                return;
            }
        }
        this.maybeInitDecoder();
        object = this.decoder;
        if (object != null) {
            object = "drainAndFeed";
            TraceUtil.beginSection((String)object);
            while (true) {
                bl2 = this.drainOutputBuffer(l10, l11);
                if (bl2) continue;
                break;
            }
            while (true) {
                boolean bl3 = this.feedInputBuffer();
                if (bl3) continue;
                break;
            }
            try {
                TraceUtil.endSection();
                DecoderCounters decoderException = this.decoderCounters;
                decoderException.ensureUpdated();
            }
            catch (DecoderException decoderException) {
                Format format = this.inputFormat;
                throw this.createRendererException(decoderException, format);
            }
        }
    }

    public void renderOutputBuffer(VideoDecoderOutputBuffer object, long l10, Format format) {
        VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;
        int n10;
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            long l11 = System.nanoTime();
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(l10, l11, format, null);
        }
        l10 = SystemClock.elapsedRealtime();
        long l12 = 1000L;
        this.lastRenderTimeUs = l10 = C.msToUs(l10 * l12);
        int n11 = ((VideoDecoderOutputBuffer)object).mode;
        int n12 = 1;
        if (n11 == n12 && (videoFrameMetadataListener = this.surface) != null) {
            n10 = n12;
        } else {
            n10 = 0;
            videoFrameMetadataListener = null;
        }
        if (n11 == 0 && (videoDecoderOutputBufferRenderer = this.outputBufferRenderer) != null) {
            n11 = n12;
        } else {
            n11 = 0;
            videoDecoderOutputBufferRenderer = null;
        }
        if (n11 == 0 && n10 == 0) {
            this.dropOutputBuffer((VideoDecoderOutputBuffer)object);
        } else {
            n10 = ((VideoDecoderOutputBuffer)object).width;
            int n13 = ((VideoDecoderOutputBuffer)object).height;
            this.maybeNotifyVideoSizeChanged(n10, n13);
            if (n11 != 0) {
                videoDecoderOutputBufferRenderer = this.outputBufferRenderer;
                videoDecoderOutputBufferRenderer.setOutputBuffer((VideoDecoderOutputBuffer)object);
            } else {
                videoDecoderOutputBufferRenderer = this.surface;
                this.renderOutputBufferToSurface((VideoDecoderOutputBuffer)object, (Surface)videoDecoderOutputBufferRenderer);
            }
            this.consecutiveDroppedFrameCount = 0;
            object = this.decoderCounters;
            ((DecoderCounters)object).renderedOutputBufferCount = n11 = ((DecoderCounters)object).renderedOutputBufferCount + n12;
            this.maybeNotifyRenderedFirstFrame();
        }
    }

    public abstract void renderOutputBufferToSurface(VideoDecoderOutputBuffer var1, Surface var2);

    public abstract void setDecoderOutputMode(int var1);

    public final void setOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        Object object = this.outputBufferRenderer;
        if (object != videoDecoderOutputBufferRenderer) {
            this.outputBufferRenderer = videoDecoderOutputBufferRenderer;
            if (videoDecoderOutputBufferRenderer != null) {
                this.surface = null;
                boolean bl2 = false;
                videoDecoderOutputBufferRenderer = null;
                this.outputMode = 0;
                object = this.decoder;
                if (object != null) {
                    this.setDecoderOutputMode(0);
                }
                this.onOutputChanged();
            } else {
                int n10;
                this.outputMode = n10 = -1;
                this.onOutputRemoved();
            }
        } else if (videoDecoderOutputBufferRenderer != null) {
            this.onOutputReset();
        }
    }

    public final void setOutputSurface(Surface surface) {
        Object object = this.surface;
        if (object != surface) {
            this.surface = surface;
            if (surface != null) {
                int n10;
                surface = null;
                this.outputBufferRenderer = null;
                this.outputMode = n10 = 1;
                object = this.decoder;
                if (object != null) {
                    this.setDecoderOutputMode(n10);
                }
                this.onOutputChanged();
            } else {
                int n11;
                this.outputMode = n11 = -1;
                this.onOutputRemoved();
            }
        } else if (surface != null) {
            this.onOutputReset();
        }
    }

    public boolean shouldDropBuffersToKeyframe(long l10, long l11) {
        return DecoderVideoRenderer.isBufferVeryLate(l10);
    }

    public boolean shouldDropOutputBuffer(long l10, long l11) {
        return DecoderVideoRenderer.isBufferLate(l10);
    }

    public boolean shouldForceRenderOutputBuffer(long l10, long l11) {
        long l12;
        int n10 = DecoderVideoRenderer.isBufferLate(l10);
        n10 = n10 != 0 && (n10 = (l12 = l11 - (l10 = 100000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 ? 1 : 0;
        return n10 != 0;
    }

    public void skipOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        int n10;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.skippedOutputBufferCount = n10 = decoderCounters.skippedOutputBufferCount + 1;
        videoDecoderOutputBuffer.release();
    }

    public void updateDroppedBufferCounters(int n10) {
        int n11;
        int n12;
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount = n12 = decoderCounters.droppedBufferCount + n10;
        this.droppedFrames = n12 = this.droppedFrames + n10;
        this.consecutiveDroppedFrameCount = n12 = this.consecutiveDroppedFrameCount + n10;
        n10 = decoderCounters.maxConsecutiveDroppedBufferCount;
        decoderCounters.maxConsecutiveDroppedBufferCount = n10 = Math.max(n12, n10);
        n10 = this.maxDroppedFramesToNotify;
        if (n10 > 0 && (n11 = this.droppedFrames) >= n10) {
            this.maybeNotifyDroppedFrames();
        }
    }
}

