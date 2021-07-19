/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.audio;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioSink$ConfigurationException;
import com.google.android.exoplayer2.audio.AudioSink$InitializationException;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.AudioSink$WriteException;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.Decoder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.SimpleOutputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.ExoMediaCrypto;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public abstract class DecoderAudioRenderer
extends BaseRenderer
implements MediaClock {
    private static final int REINITIALIZATION_STATE_NONE = 0;
    private static final int REINITIALIZATION_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REINITIALIZATION_STATE_WAIT_END_OF_STREAM = 2;
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioTrackNeedsConfigure;
    private long currentPositionUs;
    private Decoder decoder;
    private DecoderCounters decoderCounters;
    private DrmSession decoderDrmSession;
    private boolean decoderReceivedBuffers;
    private int decoderReinitializationState;
    private int encoderDelay;
    private int encoderPadding;
    private final AudioRendererEventListener$EventDispatcher eventDispatcher;
    private boolean experimentalKeepAudioTrackOnSeek;
    private final DecoderInputBuffer flagsOnlyBuffer;
    private DecoderInputBuffer inputBuffer;
    private Format inputFormat;
    private boolean inputStreamEnded;
    private SimpleOutputBuffer outputBuffer;
    private boolean outputStreamEnded;
    private DrmSession sourceDrmSession;

    public DecoderAudioRenderer() {
        AudioProcessor[] audioProcessorArray = new AudioProcessor[]{};
        this(null, null, audioProcessorArray);
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor ... audioProcessorArray) {
        DefaultAudioSink defaultAudioSink = new DefaultAudioSink(audioCapabilities, audioProcessorArray);
        this(handler, audioRendererEventListener, defaultAudioSink);
    }

    public DecoderAudioRenderer(Handler object, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher;
        int n10 = 1;
        super(n10);
        this.eventDispatcher = audioRendererEventListener$EventDispatcher = new AudioRendererEventListener$EventDispatcher((Handler)object, audioRendererEventListener);
        this.audioSink = audioSink;
        super(this, null);
        audioSink.setListener((AudioSink$Listener)object);
        object = DecoderInputBuffer.newFlagsOnlyInstance();
        this.flagsOnlyBuffer = object;
        this.decoderReinitializationState = 0;
        this.audioTrackNeedsConfigure = n10;
    }

    public DecoderAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor ... audioProcessorArray) {
        this(handler, audioRendererEventListener, (AudioCapabilities)null, audioProcessorArray);
    }

    public static /* synthetic */ AudioRendererEventListener$EventDispatcher access$100(DecoderAudioRenderer decoderAudioRenderer) {
        return decoderAudioRenderer.eventDispatcher;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean drainOutputBuffer() {
        Object object;
        int n10;
        DecoderCounters decoderCounters;
        Object object2 = this.outputBuffer;
        int n12 = 0;
        Format format = null;
        if (object2 == null) {
            object2 = (SimpleOutputBuffer)this.decoder.dequeueOutputBuffer();
            this.outputBuffer = object2;
            if (object2 == null) {
                return false;
            }
            int n11 = ((OutputBuffer)object2).skippedOutputBufferCount;
            if (n11 > 0) {
                decoderCounters = this.decoderCounters;
                decoderCounters.skippedOutputBufferCount = n10 = decoderCounters.skippedOutputBufferCount + n11;
                object2 = this.audioSink;
                object2.handleDiscontinuity();
            }
        }
        object2 = this.outputBuffer;
        boolean bl2 = ((Buffer)object2).isEndOfStream();
        boolean bl3 = false;
        decoderCounters = null;
        n10 = 1;
        if (bl2) {
            int n11 = this.decoderReinitializationState;
            int n13 = 2;
            if (n11 == n13) {
                this.releaseDecoder();
                this.maybeInitDecoder();
                this.audioTrackNeedsConfigure = n10;
                return false;
            }
            object2 = this.outputBuffer;
            ((SimpleOutputBuffer)object2).release();
            this.outputBuffer = null;
            try {
                this.processEndOfStream();
                return false;
            }
            catch (AudioSink$WriteException audioSink$WriteException) {
                format = audioSink$WriteException.format;
                bl3 = audioSink$WriteException.isRecoverable;
                throw this.createRendererException(audioSink$WriteException, format, bl3);
            }
        }
        boolean bl4 = this.audioTrackNeedsConfigure;
        if (bl4) {
            object2 = this.decoder;
            object2 = this.getOutputFormat((Decoder)object2).buildUpon();
            int n14 = this.encoderDelay;
            object2 = ((Format$Builder)object2).setEncoderDelay(n14);
            n14 = this.encoderPadding;
            object2 = ((Format$Builder)object2).setEncoderPadding(n14).build();
            object = this.audioSink;
            object.configure((Format)object2, 0, null);
            this.audioTrackNeedsConfigure = false;
        }
        object2 = this.audioSink;
        object = this.outputBuffer;
        ByteBuffer byteBuffer = ((SimpleOutputBuffer)object).data;
        long l10 = ((OutputBuffer)object).timeUs;
        boolean bl5 = object2.handleBuffer(byteBuffer, l10, n10);
        if (!bl5) return false;
        object2 = this.decoderCounters;
        ((DecoderCounters)object2).renderedOutputBufferCount = n12 = ((DecoderCounters)object2).renderedOutputBufferCount + n10;
        this.outputBuffer.release();
        this.outputBuffer = null;
        return n10 != 0;
    }

    private boolean feedInputBuffer() {
        int n10;
        int n11;
        Object object = this.decoder;
        int n12 = 0;
        DecoderInputBuffer decoderInputBuffer = null;
        if (object != null && (n11 = this.decoderReinitializationState) != (n10 = 2) && (n11 = (int)(this.inputStreamEnded ? 1 : 0)) == 0) {
            int n13;
            DecoderInputBuffer decoderInputBuffer2;
            DecoderInputBuffer decoderInputBuffer3 = this.inputBuffer;
            if (decoderInputBuffer3 == null) {
                this.inputBuffer = object = (DecoderInputBuffer)object.dequeueInputBuffer();
                if (object == null) {
                    return false;
                }
            }
            int n14 = this.decoderReinitializationState;
            n11 = 0;
            decoderInputBuffer3 = null;
            int n15 = 1;
            if (n14 == n15) {
                this.inputBuffer.setFlags(4);
                object = this.decoder;
                DecoderInputBuffer decoderInputBuffer4 = this.inputBuffer;
                object.queueInputBuffer(decoderInputBuffer4);
                this.inputBuffer = null;
                this.decoderReinitializationState = n10;
                return false;
            }
            object = this.getFormatHolder();
            n10 = this.readSource((FormatHolder)object, decoderInputBuffer2 = this.inputBuffer, false);
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
                    decoderInputBuffer2 = this.inputBuffer;
                    object.queueInputBuffer(decoderInputBuffer2);
                    this.inputBuffer = null;
                    return false;
                }
                this.inputBuffer.flip();
                object = this.inputBuffer;
                this.onQueueInputBuffer((DecoderInputBuffer)object);
                object = this.decoder;
                decoderInputBuffer = this.inputBuffer;
                object.queueInputBuffer(decoderInputBuffer);
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

    private void flushDecoder() {
        int n10 = this.decoderReinitializationState;
        if (n10 != 0) {
            this.releaseDecoder();
            this.maybeInitDecoder();
        } else {
            n10 = 0;
            this.inputBuffer = null;
            SimpleOutputBuffer simpleOutputBuffer = this.outputBuffer;
            if (simpleOutputBuffer != null) {
                simpleOutputBuffer.release();
                this.outputBuffer = null;
            }
            this.decoder.flush();
            n10 = 0;
            this.decoderReceivedBuffers = false;
        }
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
        object = null;
        Object object2 = this.decoderDrmSession;
        if (object2 != null && (object = object2.getMediaCrypto()) == null && (object2 = this.decoderDrmSession.getError()) == null) {
            return;
        }
        long l10 = SystemClock.elapsedRealtime();
        Object object3 = "createAudioDecoder";
        TraceUtil.beginSection((String)object3);
        object3 = this.inputFormat;
        object = this.createDecoder((Format)object3, (ExoMediaCrypto)object);
        this.decoder = object;
        TraceUtil.endSection();
        long l11 = SystemClock.elapsedRealtime();
        object3 = this.eventDispatcher;
        object = this.decoder;
        String string2 = object.getName();
        long l12 = l11 - l10;
        ((AudioRendererEventListener$EventDispatcher)object3).decoderInitialized(string2, l11, l12);
        object = this.decoderCounters;
        int n10 = ((DecoderCounters)object).decoderInitCount + 1;
        try {
            ((DecoderCounters)object).decoderInitCount = n10;
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

    private void onInputFormatChanged(FormatHolder object) {
        int n10;
        Object object2;
        Object object3 = object2 = Assertions.checkNotNull(((FormatHolder)object).format);
        object3 = (Format)object2;
        object = ((FormatHolder)object).drmSession;
        this.setSourceDrmSession((DrmSession)object);
        Format format = this.inputFormat;
        this.inputFormat = object3;
        this.encoderDelay = n10 = ((Format)object3).encoderDelay;
        this.encoderPadding = n10 = ((Format)object3).encoderPadding;
        object = this.decoder;
        if (object == null) {
            this.maybeInitDecoder();
            object = this.eventDispatcher;
            object2 = this.inputFormat;
            ((AudioRendererEventListener$EventDispatcher)object).inputFormatChanged((Format)object2, null);
            return;
        }
        object2 = this.sourceDrmSession;
        Object object4 = this.decoderDrmSession;
        if (object2 != object4) {
            String string2 = object.getName();
            int n11 = 128;
            object4 = object2;
            object2 = new DecoderReuseEvaluation(string2, format, (Format)object3, 0, n11);
        } else {
            object = object.getName();
            object2 = this.canReuseDecoder((String)object, format, (Format)object3);
        }
        n10 = ((DecoderReuseEvaluation)object2).result;
        if (n10 == 0) {
            n10 = (int)(this.decoderReceivedBuffers ? 1 : 0);
            int n12 = 1;
            if (n10 != 0) {
                this.decoderReinitializationState = n12;
            } else {
                this.releaseDecoder();
                this.maybeInitDecoder();
                this.audioTrackNeedsConfigure = n12;
            }
        }
        object = this.eventDispatcher;
        object4 = this.inputFormat;
        ((AudioRendererEventListener$EventDispatcher)object).inputFormatChanged((Format)object4, (DecoderReuseEvaluation)object2);
    }

    private void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        Object object = this.allowFirstBufferPositionDiscontinuity;
        if (object != 0 && (object = decoderInputBuffer.isDecodeOnly()) == 0) {
            long l10 = decoderInputBuffer.timeUs;
            long l11 = this.currentPositionUs;
            long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 500000L);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                this.currentPositionUs = l10 = decoderInputBuffer.timeUs;
            }
            decoderInputBuffer = null;
            this.allowFirstBufferPositionDiscontinuity = false;
        }
    }

    private void processEndOfStream() {
        this.outputStreamEnded = true;
        this.audioSink.playToEndOfStream();
    }

    private void releaseDecoder() {
        this.inputBuffer = null;
        this.outputBuffer = null;
        this.decoderReinitializationState = 0;
        this.decoderReceivedBuffers = false;
        Object object = this.decoder;
        if (object != null) {
            int n10;
            Object object2 = this.decoderCounters;
            ((DecoderCounters)object2).decoderReleaseCount = n10 = ((DecoderCounters)object2).decoderReleaseCount + 1;
            object.release();
            object = this.eventDispatcher;
            object2 = this.decoder.getName();
            ((AudioRendererEventListener$EventDispatcher)object).decoderReleased((String)object2);
            this.decoder = null;
        }
        this.setDecoderDrmSession(null);
    }

    private void setDecoderDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.decoderDrmSession, drmSession);
        this.decoderDrmSession = drmSession;
    }

    private void setSourceDrmSession(DrmSession drmSession) {
        DrmSession.replaceSession(this.sourceDrmSession, drmSession);
        this.sourceDrmSession = drmSession;
    }

    private void updateCurrentPosition() {
        long l10;
        AudioSink audioSink = this.audioSink;
        boolean bl2 = this.isEnded();
        long l11 = audioSink.getCurrentPositionUs(bl2);
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = this.allowPositionDiscontinuity;
            if (object == false) {
                l10 = this.currentPositionUs;
                l11 = Math.max(l10, l11);
            }
            this.currentPositionUs = l11;
            audioSink = null;
            this.allowPositionDiscontinuity = false;
        }
    }

    public DecoderReuseEvaluation canReuseDecoder(String string2, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluation = new DecoderReuseEvaluation(string2, format, format2, 0, 1);
        return decoderReuseEvaluation;
    }

    public abstract Decoder createDecoder(Format var1, ExoMediaCrypto var2);

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean bl2) {
        this.experimentalKeepAudioTrackOnSeek = bl2;
    }

    public MediaClock getMediaClock() {
        return this;
    }

    public abstract Format getOutputFormat(Decoder var1);

    public PlaybackParameters getPlaybackParameters() {
        return this.audioSink.getPlaybackParameters();
    }

    public long getPositionUs() {
        int n10;
        int n11 = this.getState();
        if (n11 == (n10 = 2)) {
            this.updateCurrentPosition();
        }
        return this.currentPositionUs;
    }

    public final int getSinkFormatSupport(Format format) {
        return this.audioSink.getFormatSupport(format);
    }

    public void handleMessage(int n10, Object object) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    n11 = 101;
                    if (n10 != n11) {
                        n11 = 102;
                        if (n10 != n11) {
                            super.handleMessage(n10, object);
                        } else {
                            AudioSink audioSink = this.audioSink;
                            object = (Integer)object;
                            int n12 = (Integer)object;
                            audioSink.setAudioSessionId(n12);
                        }
                    } else {
                        AudioSink audioSink = this.audioSink;
                        object = (Boolean)object;
                        boolean bl2 = (Boolean)object;
                        audioSink.setSkipSilenceEnabled(bl2);
                    }
                } else {
                    object = (AuxEffectInfo)object;
                    AudioSink audioSink = this.audioSink;
                    audioSink.setAuxEffectInfo((AuxEffectInfo)object);
                }
            } else {
                object = (AudioAttributes)object;
                AudioSink audioSink = this.audioSink;
                audioSink.setAudioAttributes((AudioAttributes)object);
            }
        } else {
            AudioSink audioSink = this.audioSink;
            object = (Float)object;
            float f10 = ((Float)object).floatValue();
            audioSink.setVolume(f10);
        }
    }

    public boolean isEnded() {
        AudioSink audioSink;
        boolean bl2 = this.outputStreamEnded;
        if (bl2 && (bl2 = (audioSink = this.audioSink).isEnded())) {
            bl2 = true;
        } else {
            bl2 = false;
            audioSink = null;
        }
        return bl2;
    }

    public boolean isReady() {
        Object object = this.audioSink;
        boolean bl2 = object.hasPendingData();
        if (!bl2 && ((object = this.inputFormat) == null || !(bl2 = this.isSourceReady()) && (object = this.outputBuffer) == null)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void onDisabled() {
        boolean bl2;
        Object object = null;
        this.inputFormat = null;
        this.audioTrackNeedsConfigure = bl2 = true;
        try {
            this.setSourceDrmSession(null);
            this.releaseDecoder();
            object = this.audioSink;
            object.reset();
            return;
        }
        finally {
            AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
            DecoderCounters decoderCounters = this.decoderCounters;
            audioRendererEventListener$EventDispatcher.disabled(decoderCounters);
        }
    }

    public void onEnabled(boolean bl2, boolean bl3) {
        Object object = new DecoderCounters();
        this.decoderCounters = object;
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        audioRendererEventListener$EventDispatcher.enabled((DecoderCounters)object);
        object = this.getConfiguration();
        bl2 = ((RendererConfiguration)object).tunneling;
        if (bl2) {
            object = this.audioSink;
            object.enableTunnelingV21();
        } else {
            object = this.audioSink;
            object.disableTunneling();
        }
    }

    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    public void onPositionReset(long l10, boolean bl2) {
        boolean bl3;
        bl2 = this.experimentalKeepAudioTrackOnSeek;
        if (bl2) {
            AudioSink audioSink = this.audioSink;
            audioSink.experimentalFlushWithoutAudioTrackRelease();
        } else {
            AudioSink audioSink = this.audioSink;
            audioSink.flush();
        }
        this.currentPositionUs = l10;
        this.allowFirstBufferPositionDiscontinuity = bl3 = true;
        this.allowPositionDiscontinuity = bl3;
        bl3 = false;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        Decoder decoder = this.decoder;
        if (decoder != null) {
            this.flushDecoder();
        }
    }

    public void onStarted() {
        this.audioSink.play();
    }

    public void onStopped() {
        this.updateCurrentPosition();
        this.audioSink.pause();
    }

    public void render(long l10, long l11) {
        boolean bl2;
        Object object;
        boolean bl3 = this.outputStreamEnded;
        if (bl3) {
            AudioSink audioSink$WriteException;
            try {
                audioSink$WriteException = this.audioSink;
            }
            catch (AudioSink$WriteException audioSink$InitializationException) {
                Format format = audioSink$InitializationException.format;
                boolean bl4 = audioSink$InitializationException.isRecoverable;
                throw this.createRendererException(audioSink$InitializationException, format, bl4);
            }
            audioSink$WriteException.playToEndOfStream();
            return;
        }
        Object audioSink$ConfigurationException = this.inputFormat;
        if (audioSink$ConfigurationException == null) {
            audioSink$ConfigurationException = this.getFormatHolder();
            this.flagsOnlyBuffer.clear();
            object = this.flagsOnlyBuffer;
            bl2 = true;
            int n10 = this.readSource((FormatHolder)audioSink$ConfigurationException, (DecoderInputBuffer)object, bl2);
            int n11 = -5;
            if (n10 == n11) {
                this.onInputFormatChanged((FormatHolder)audioSink$ConfigurationException);
            } else {
                int n12 = -4;
                if (n10 == n12) {
                    audioSink$ConfigurationException = this.flagsOnlyBuffer;
                    boolean bl5 = ((Buffer)audioSink$ConfigurationException).isEndOfStream();
                    Assertions.checkState(bl5);
                    this.inputStreamEnded = bl2;
                    try {
                        this.processEndOfStream();
                        return;
                    }
                    catch (AudioSink$WriteException decoderException) {
                        throw this.createRendererException(decoderException, null);
                    }
                }
                return;
            }
        }
        this.maybeInitDecoder();
        audioSink$ConfigurationException = this.decoder;
        if (audioSink$ConfigurationException != null) {
            boolean bl6;
            audioSink$ConfigurationException = "drainAndFeed";
            TraceUtil.beginSection((String)audioSink$ConfigurationException);
            while (bl6 = this.drainOutputBuffer()) {
            }
            while (true) {
                boolean bl7 = this.feedInputBuffer();
                if (bl7) continue;
                break;
            }
            try {
                TraceUtil.endSection();
                audioSink$ConfigurationException = this.decoderCounters;
                ((DecoderCounters)audioSink$ConfigurationException).ensureUpdated();
            }
            catch (AudioSink$WriteException audioSink$WriteException) {
                object = audioSink$WriteException.format;
                bl2 = audioSink$WriteException.isRecoverable;
                throw this.createRendererException(audioSink$WriteException, (Format)object, bl2);
            }
            catch (AudioSink$InitializationException audioSink$InitializationException) {
                object = audioSink$InitializationException.format;
                bl2 = audioSink$InitializationException.isRecoverable;
                throw this.createRendererException(audioSink$InitializationException, (Format)object, bl2);
            }
            catch (AudioSink$ConfigurationException audioSink$ConfigurationException2) {
                object = audioSink$ConfigurationException2.format;
                throw this.createRendererException(audioSink$ConfigurationException2, (Format)object);
            }
            catch (DecoderException decoderException) {
                object = this.inputFormat;
                throw this.createRendererException(decoderException, (Format)object);
            }
        }
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.audioSink.setPlaybackParameters(playbackParameters);
    }

    public final boolean sinkSupportsFormat(Format format) {
        return this.audioSink.supportsFormat(format);
    }

    public final int supportsFormat(Format format) {
        String string2 = format.sampleMimeType;
        int n10 = MimeTypes.isAudio(string2);
        int n11 = 0;
        if (n10 == 0) {
            return RendererCapabilities.create(0);
        }
        int n12 = this.supportsFormatInternal(format);
        if (n12 <= (n10 = 2)) {
            return RendererCapabilities.create(n12);
        }
        n10 = Util.SDK_INT;
        int n13 = 21;
        if (n10 >= n13) {
            n11 = 32;
        }
        return RendererCapabilities.create(n12, 8, n11);
    }

    public abstract int supportsFormatInternal(Format var1);
}

