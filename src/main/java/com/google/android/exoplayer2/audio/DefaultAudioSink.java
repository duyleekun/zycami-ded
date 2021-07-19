/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.AudioFormat
 *  android.media.AudioFormat$Builder
 *  android.media.AudioManager
 *  android.media.AudioTrack
 *  android.media.PlaybackParams
 *  android.os.ConditionVariable
 *  android.os.SystemClock
 *  android.util.Pair
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioSink$ConfigurationException;
import com.google.android.exoplayer2.audio.AudioSink$InitializationException;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.AudioSink$WriteException;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.audio.ChannelMappingAudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink$1;
import com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain;
import com.google.android.exoplayer2.audio.DefaultAudioSink$Configuration;
import com.google.android.exoplayer2.audio.DefaultAudioSink$DefaultAudioProcessorChain;
import com.google.android.exoplayer2.audio.DefaultAudioSink$MediaPositionParameters;
import com.google.android.exoplayer2.audio.DefaultAudioSink$PendingExceptionHolder;
import com.google.android.exoplayer2.audio.DefaultAudioSink$PositionTrackerListener;
import com.google.android.exoplayer2.audio.DefaultAudioSink$StreamEventCallbackV29;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.FloatResamplingAudioProcessor;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.audio.ResamplingAudioProcessor;
import com.google.android.exoplayer2.audio.TrimmingAudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public final class DefaultAudioSink
implements AudioSink {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int AUDIO_TRACK_RETRY_DURATION_MS = 100;
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final boolean DEFAULT_SKIP_SILENCE = false;
    private static final int ERROR_NATIVE_DEAD_OBJECT = 224;
    private static final long MAX_BUFFER_DURATION_US = 750000L;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    private static final long MIN_BUFFER_DURATION_US = 250000L;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    private static final long OFFLOAD_BUFFER_DURATION_US = 50000000L;
    private static final int OUTPUT_MODE_OFFLOAD = 1;
    private static final int OUTPUT_MODE_PASSTHROUGH = 2;
    private static final int OUTPUT_MODE_PCM = 0;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000L;
    private static final String TAG = "DefaultAudioSink";
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    private DefaultAudioSink$MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final DefaultAudioSink$AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private PlaybackParameters audioTrackPlaybackParameters;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private DefaultAudioSink$Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableAudioTrackPlaybackParams;
    private final boolean enableFloatOutput;
    private final boolean enableOffload;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private final DefaultAudioSink$PendingExceptionHolder initializationExceptionPendingExceptionHolder;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private boolean isWaitingForOffloadEndOfStreamHandled;
    private long lastFeedElapsedRealtimeMs;
    private AudioSink$Listener listener;
    private DefaultAudioSink$MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque mediaPositionParametersCheckpoints;
    private boolean offloadDisabledUntilNextConfiguration;
    private DefaultAudioSink$StreamEventCallbackV29 offloadStreamEventCallbackV29;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private DefaultAudioSink$Configuration pendingConfiguration;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private final ConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private final DefaultAudioSink$PendingExceptionHolder writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public DefaultAudioSink(AudioCapabilities object, DefaultAudioSink$AudioProcessorChain object2, boolean n10, boolean bl2, boolean bl3) {
        Object object3;
        this.audioCapabilities = object;
        object = (DefaultAudioSink$AudioProcessorChain)Assertions.checkNotNull(object2);
        this.audioProcessorChain = object;
        int n11 = Util.SDK_INT;
        int n12 = 1;
        int n13 = 21;
        if (n11 >= n13 && n10 != 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object3 = null;
        }
        this.enableFloatOutput = n10;
        n10 = 23;
        if (n11 >= n10 && bl2) {
            n10 = n12;
        } else {
            n10 = 0;
            object3 = null;
        }
        this.enableAudioTrackPlaybackParams = n10;
        n10 = 29;
        if (n11 >= n10 && bl3) {
            n11 = n12;
        } else {
            n11 = 0;
            object = null;
        }
        this.enableOffload = n11;
        object = new ConditionVariable(n12 != 0);
        this.releasingConditionVariable = object;
        object3 = new DefaultAudioSink$PositionTrackerListener(this, null);
        object = new AudioTrackPositionTracker((AudioTrackPositionTracker$Listener)object3);
        this.audioTrackPositionTracker = object;
        object = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = object;
        this.trimmingAudioProcessor = object3 = new TrimmingAudioProcessor();
        ArrayList arrayList = new ArrayList();
        BaseAudioProcessor[] baseAudioProcessorArray = new BaseAudioProcessor[3];
        Object object4 = new ResamplingAudioProcessor();
        baseAudioProcessorArray[0] = object4;
        baseAudioProcessorArray[n12] = object;
        baseAudioProcessorArray[2] = object3;
        Collections.addAll(arrayList, baseAudioProcessorArray);
        object = object2.getAudioProcessors();
        Collections.addAll(arrayList, object);
        object = new AudioProcessor[]{};
        object = arrayList.toArray((T[])object);
        this.toIntPcmAvailableAudioProcessors = object;
        object = new AudioProcessor[n12];
        object[0] = object2 = new FloatResamplingAudioProcessor();
        this.toFloatPcmAvailableAudioProcessors = object;
        this.volume = 1.0f;
        this.audioAttributes = object = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        super(0, 0.0f);
        this.auxEffectInfo = object;
        object2 = PlaybackParameters.DEFAULT;
        object4 = object;
        super((PlaybackParameters)object2, false, 0L, 0L, null);
        this.mediaPositionParameters = object;
        this.audioTrackPlaybackParameters = object2;
        this.drainingAudioProcessorIndex = -1;
        object = new AudioProcessor[]{};
        this.activeAudioProcessors = object;
        object = new ByteBuffer[]{};
        this.outputBuffers = object;
        super();
        this.mediaPositionParametersCheckpoints = object;
        long l10 = 100;
        super(l10);
        this.initializationExceptionPendingExceptionHolder = object;
        super(l10);
        this.writeExceptionPendingExceptionHolder = object;
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArray) {
        this(audioCapabilities, audioProcessorArray, false);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArray, boolean bl2) {
        DefaultAudioSink$DefaultAudioProcessorChain defaultAudioSink$DefaultAudioProcessorChain = new DefaultAudioSink$DefaultAudioProcessorChain(audioProcessorArray);
        this(audioCapabilities, defaultAudioSink$DefaultAudioProcessorChain, bl2, false, false);
    }

    public static /* synthetic */ AudioFormat access$1000(int n10, int n11, int n12) {
        return DefaultAudioSink.getAudioFormat(n10, n11, n12);
    }

    public static /* synthetic */ int access$1100(int n10) {
        return DefaultAudioSink.getMaximumEncodedRateBytesPerSecond(n10);
    }

    public static /* synthetic */ ConditionVariable access$200(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.releasingConditionVariable;
    }

    public static /* synthetic */ AudioTrack access$300(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.audioTrack;
    }

    public static /* synthetic */ AudioSink$Listener access$400(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.listener;
    }

    public static /* synthetic */ boolean access$500(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.playing;
    }

    public static /* synthetic */ long access$600(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.getSubmittedFrames();
    }

    public static /* synthetic */ long access$700(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.getWrittenFrames();
    }

    public static /* synthetic */ long access$900(DefaultAudioSink defaultAudioSink) {
        return defaultAudioSink.lastFeedElapsedRealtimeMs;
    }

    private void applyAudioProcessorPlaybackParametersAndSkipSilence(long l10) {
        DefaultAudioSink$MediaPositionParameters defaultAudioSink$MediaPositionParameters;
        Object object;
        Object object2;
        boolean bl2 = this.shouldApplyAudioProcessorPlaybackParameters();
        if (bl2) {
            object2 = this.audioProcessorChain;
            object = this.getAudioProcessorPlaybackParameters();
            object2 = object2.applyPlaybackParameters((PlaybackParameters)object);
        } else {
            object2 = PlaybackParameters.DEFAULT;
        }
        Object object3 = object2;
        bl2 = this.shouldApplyAudioProcessorPlaybackParameters();
        if (bl2) {
            object2 = this.audioProcessorChain;
            boolean bl3 = this.getSkipSilenceEnabled();
            bl2 = object2.applySkipSilenceEnabled(bl3);
        } else {
            bl2 = false;
            object2 = null;
        }
        ArrayDeque arrayDeque = this.mediaPositionParametersCheckpoints;
        long l11 = 0L;
        long l12 = Math.max(l11, l10);
        Object object4 = this.configuration;
        long l13 = this.getWrittenFrames();
        l13 = ((DefaultAudioSink$Configuration)object4).framesToDurationUs(l13);
        object = defaultAudioSink$MediaPositionParameters;
        defaultAudioSink$MediaPositionParameters = new DefaultAudioSink$MediaPositionParameters((PlaybackParameters)object3, bl2, l12, l13, null);
        arrayDeque.add(defaultAudioSink$MediaPositionParameters);
        this.setupAudioProcessors();
        object4 = this.listener;
        if (object4 != null) {
            object4.onSkipSilenceEnabledChanged(bl2);
        }
    }

    private long applyMediaPositionParameters(long l10) {
        Object object;
        Object object2;
        while ((object2 = ((ArrayDeque)(object = this.mediaPositionParametersCheckpoints)).isEmpty()) == 0) {
            object = (DefaultAudioSink$MediaPositionParameters)this.mediaPositionParametersCheckpoints.getFirst();
            long l11 = ((DefaultAudioSink$MediaPositionParameters)object).audioTrackPositionUs;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 < 0) break;
            this.mediaPositionParameters = object = (DefaultAudioSink$MediaPositionParameters)this.mediaPositionParametersCheckpoints.remove();
        }
        object = this.mediaPositionParameters;
        long l13 = ((DefaultAudioSink$MediaPositionParameters)object).audioTrackPositionUs;
        l13 = l10 - l13;
        object = ((DefaultAudioSink$MediaPositionParameters)object).playbackParameters;
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        object2 = ((PlaybackParameters)object).equals(playbackParameters);
        if (object2 != 0) {
            return this.mediaPositionParameters.mediaTimeUs + l13;
        }
        object = this.mediaPositionParametersCheckpoints;
        object2 = ((ArrayDeque)object).isEmpty();
        if (object2 != 0) {
            l10 = this.audioProcessorChain.getMediaDuration(l13);
            return this.mediaPositionParameters.mediaTimeUs + l10;
        }
        object = (DefaultAudioSink$MediaPositionParameters)this.mediaPositionParametersCheckpoints.getFirst();
        l13 = ((DefaultAudioSink$MediaPositionParameters)object).audioTrackPositionUs - l10;
        float f10 = this.mediaPositionParameters.playbackParameters.speed;
        l10 = Util.getMediaDurationForPlayoutDuration(l13, f10);
        return ((DefaultAudioSink$MediaPositionParameters)object).mediaTimeUs - l10;
    }

    private long applySkipping(long l10) {
        DefaultAudioSink$Configuration defaultAudioSink$Configuration = this.configuration;
        long l11 = this.audioProcessorChain.getSkippedOutputFrameCount();
        long l12 = defaultAudioSink$Configuration.framesToDurationUs(l11);
        return l10 + l12;
    }

    private AudioTrack buildAudioTrack() {
        Object object;
        try {
            object = this.configuration;
        }
        catch (AudioSink$InitializationException audioSink$InitializationException) {
            this.maybeDisableOffload();
            AudioSink$Listener audioSink$Listener = this.listener;
            if (audioSink$Listener != null) {
                audioSink$Listener.onAudioSinkError(audioSink$InitializationException);
            }
            throw audioSink$InitializationException;
        }
        object = Assertions.checkNotNull(object);
        object = (DefaultAudioSink$Configuration)object;
        boolean bl2 = this.tunneling;
        AudioAttributes audioAttributes = this.audioAttributes;
        int n10 = this.audioSessionId;
        return ((DefaultAudioSink$Configuration)object).buildAudioTrack(bl2, audioAttributes, n10);
    }

    /*
     * Unable to fully structure code
     */
    private boolean drainToEndOfStream() {
        var1_1 = this.drainingAudioProcessorIndex;
        var2_2 = -1;
        var3_3 = 1;
        if (var1_1 == var2_2) {
            this.drainingAudioProcessorIndex = 0;
lbl6:
            // 2 sources

            while (true) {
                var1_1 = var3_3;
                break;
            }
        } else {
            var1_1 = 0;
            var4_4 = null;
        }
        var5_5 = this.drainingAudioProcessorIndex;
        var6_6 = this.activeAudioProcessors;
        var7_7 = var6_6.length;
        var8_8 = -9223372036854775807L;
        if (var5_5 < var7_7) {
            var10_9 = var6_6[var5_5];
            if (var1_1 != 0) {
                var10_9.queueEndOfStream();
            }
            this.processBuffers(var8_8);
            var1_1 = var10_9.isEnded();
            if (var1_1 == 0) {
                return false;
            }
            this.drainingAudioProcessorIndex = var1_1 = this.drainingAudioProcessorIndex + var3_3;
            ** continue;
        }
        var4_4 = this.outputBuffer;
        if (var4_4 != null) {
            this.writeBuffer(var4_4, var8_8);
            var4_4 = this.outputBuffer;
            if (var4_4 != null) {
                return false;
            }
        }
        this.drainingAudioProcessorIndex = var2_2;
        return (boolean)var3_3;
    }

    private void flushAudioProcessors() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((AudioProcessor[])(object = this.activeAudioProcessors)).length); ++i10) {
            object = object[i10];
            object.flush();
            ByteBuffer[] byteBufferArray = this.outputBuffers;
            byteBufferArray[i10] = object = object.getOutput();
        }
    }

    private static AudioFormat getAudioFormat(int n10, int n11, int n12) {
        AudioFormat.Builder builder = new AudioFormat.Builder();
        return builder.setSampleRate(n10).setChannelMask(n11).setEncoding(n12).build();
    }

    private PlaybackParameters getAudioProcessorPlaybackParameters() {
        return this.getMediaPositionParameters().playbackParameters;
    }

    private static int getChannelConfigForPassthrough(int n10) {
        String string2;
        String string3;
        int n11 = Util.SDK_INT;
        int n12 = 28;
        if (n11 <= n12) {
            n12 = 7;
            if (n10 == n12) {
                n10 = 8;
            } else {
                n12 = 3;
                if (n10 == n12 || n10 == (n12 = 4) || n10 == (n12 = 5)) {
                    n10 = 6;
                }
            }
        }
        if (n11 <= (n12 = 26) && (n11 = (int)((string3 = "fugu").equals(string2 = Util.DEVICE) ? 1 : 0)) != 0 && n10 == (n11 = 1)) {
            n10 = 2;
        }
        return Util.getAudioTrackChannelConfig(n10);
    }

    private static Pair getEncodingAndChannelConfigForPassthrough(Format object, AudioCapabilities object2) {
        int n10;
        if (object2 == null) {
            return null;
        }
        String string2 = (String)Assertions.checkNotNull(((Format)object).sampleMimeType);
        String string3 = ((Format)object).codecs;
        int n11 = MimeTypes.getEncoding(string2, string3);
        int n12 = 5;
        int n13 = 6;
        int n14 = 18;
        if (n11 != n12 && n11 != n13 && n11 != n14 && n11 != (n12 = 17) && n11 != (n12 = 7) && n11 != (n12 = 8) && n11 != (n12 = 14)) {
            n12 = 0;
            string3 = null;
        } else {
            n12 = 1;
        }
        if (n12 == 0) {
            return null;
        }
        if (n11 == n14 && (n12 = (int)(((AudioCapabilities)object2).supportsEncoding(n14) ? 1 : 0)) == 0) {
            n11 = n13;
        }
        if ((n12 = (int)(((AudioCapabilities)object2).supportsEncoding(n11) ? 1 : 0)) == 0) {
            return null;
        }
        if (n11 == n14) {
            int n15 = Util.SDK_INT;
            n12 = 29;
            if (n15 >= n12 && (n13 = DefaultAudioSink.getMaxSupportedChannelCountForPassthroughV29(n14, n10 = ((Format)object).sampleRate)) == 0) {
                Log.w(TAG, "E-AC3 JOC encoding supported but no channel count supported");
                return null;
            }
        } else {
            n13 = ((Format)object).channelCount;
            n10 = ((AudioCapabilities)object2).getMaxChannelCount();
            if (n13 > n10) {
                return null;
            }
        }
        if ((n10 = DefaultAudioSink.getChannelConfigForPassthrough(n13)) == 0) {
            return null;
        }
        object2 = n11;
        object = n10;
        return Pair.create((Object)object2, (Object)object);
    }

    private static int getFramesPerEncodedSample(int n10, ByteBuffer object) {
        int n11 = 1024;
        int n12 = -1;
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder(38);
                stringBuilder.append("Unexpected audio encoding: ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                object = new IllegalStateException(string2);
                throw object;
            }
            case 17: {
                return Ac4Util.parseAc4SyncframeAudioSampleCount((ByteBuffer)object);
            }
            case 16: {
                return n11;
            }
            case 15: {
                return 512;
            }
            case 14: {
                n10 = Ac3Util.findTrueHdSyncframeOffset((ByteBuffer)object);
                if (n10 == n12) {
                    n10 = 0;
                    Object var5_6 = null;
                } else {
                    n10 = Ac3Util.parseTrueHdSyncframeAudioSampleCount((ByteBuffer)object, n10) * 16;
                }
                return n10;
            }
            case 11: 
            case 12: {
                return 2048;
            }
            case 10: {
                return n11;
            }
            case 9: {
                n10 = ((Buffer)object).position();
                n10 = MpegAudioUtil.parseMpegAudioFrameSampleCount(Util.getBigEndianInt((ByteBuffer)object, n10));
                if (n10 != n12) {
                    return n10;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
            case 7: 
            case 8: {
                return DtsUtil.parseDtsAudioSampleCount((ByteBuffer)object);
            }
            case 5: 
            case 6: 
            case 18: 
        }
        return Ac3Util.parseAc3SyncframeAudioSampleCount((ByteBuffer)object);
    }

    private static int getMaxSupportedChannelCountForPassthroughV29(int n10, int n11) {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder = builder.setUsage(1).setContentType(3).build();
        for (int i10 = 8; i10 > 0; i10 += -1) {
            AudioFormat.Builder builder2 = new AudioFormat.Builder();
            builder2 = builder2.setEncoding(n10).setSampleRate(n11);
            int n12 = Util.getAudioTrackChannelConfig(i10);
            boolean bl2 = AudioTrack.isDirectPlaybackSupported((AudioFormat)(builder2 = builder2.setChannelMask(n12).build()), (android.media.AudioAttributes)builder);
            if (!bl2) continue;
            return i10;
        }
        return 0;
    }

    private static int getMaximumEncodedRateBytesPerSecond(int n10) {
        switch (n10) {
            default: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
            case 17: {
                return 336000;
            }
            case 16: {
                return 256000;
            }
            case 15: {
                return 8000;
            }
            case 14: {
                return 3062500;
            }
            case 12: {
                return 7000;
            }
            case 11: {
                return 16000;
            }
            case 10: {
                return 100000;
            }
            case 9: {
                return 40000;
            }
            case 8: {
                return 2250000;
            }
            case 7: {
                return 192000;
            }
            case 6: 
            case 18: {
                return 768000;
            }
            case 5: 
        }
        return 80000;
    }

    private DefaultAudioSink$MediaPositionParameters getMediaPositionParameters() {
        Object object = this.afterDrainParameters;
        if (object == null) {
            object = this.mediaPositionParametersCheckpoints;
            boolean bl2 = ((ArrayDeque)object).isEmpty();
            object = !bl2 ? (DefaultAudioSink$MediaPositionParameters)this.mediaPositionParametersCheckpoints.getLast() : this.mediaPositionParameters;
        }
        return object;
    }

    private long getSubmittedFrames() {
        long l10;
        DefaultAudioSink$Configuration defaultAudioSink$Configuration = this.configuration;
        int n10 = defaultAudioSink$Configuration.outputMode;
        if (n10 == 0) {
            l10 = this.submittedPcmBytes;
            int n11 = defaultAudioSink$Configuration.inputPcmFrameSize;
            long l11 = n11;
            l10 /= l11;
        } else {
            l10 = this.submittedEncodedFrames;
        }
        return l10;
    }

    private long getWrittenFrames() {
        long l10;
        DefaultAudioSink$Configuration defaultAudioSink$Configuration = this.configuration;
        int n10 = defaultAudioSink$Configuration.outputMode;
        if (n10 == 0) {
            l10 = this.writtenPcmBytes;
            int n11 = defaultAudioSink$Configuration.outputPcmFrameSize;
            long l11 = n11;
            l10 /= l11;
        } else {
            l10 = this.writtenEncodedFrames;
        }
        return l10;
    }

    private void initializeAudioTrack() {
        Object object;
        Object object2;
        this.releasingConditionVariable.block();
        this.audioTrack = object2 = this.buildAudioTrack();
        int n10 = DefaultAudioSink.isOffloadedPlayback(object2);
        if (n10 != 0) {
            object2 = this.audioTrack;
            this.registerStreamEventCallbackV29((AudioTrack)object2);
            object2 = this.audioTrack;
            object = this.configuration.inputFormat;
            int n11 = ((Format)object).encoderDelay;
            int n12 = ((Format)object).encoderPadding;
            object2.setOffloadDelayPadding(n11, n12);
        }
        this.audioSessionId = n10 = this.audioTrack.getAudioSessionId();
        object = this.audioTrackPositionTracker;
        AudioTrack audioTrack = this.audioTrack;
        object2 = this.configuration;
        int n13 = object2.outputMode;
        int n14 = 2;
        int n15 = 1;
        n13 = n13 == n14 ? n15 : 0;
        n14 = object2.outputEncoding;
        int n16 = object2.outputPcmFrameSize;
        int n17 = object2.bufferSize;
        ((AudioTrackPositionTracker)object).setAudioTrack(audioTrack, n13 != 0, n14, n16, n17);
        this.setVolumeInternal();
        object2 = this.auxEffectInfo;
        n10 = object2.effectId;
        if (n10 != 0) {
            this.audioTrack.attachAuxEffect(n10);
            object2 = this.audioTrack;
            object = this.auxEffectInfo;
            float f10 = ((AuxEffectInfo)object).sendLevel;
            object2.setAuxEffectSendLevel(f10);
        }
        this.startMediaTimeUsNeedsInit = n15;
    }

    private static boolean isAudioTrackDeadObject(int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 24;
        n10 = n11 >= n12 && n10 == (n11 = -6) || n10 == (n11 = -32) ? 1 : 0;
        return n10 != 0;
    }

    private boolean isAudioTrackInitialized() {
        boolean bl2;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            bl2 = true;
        } else {
            bl2 = false;
            audioTrack = null;
        }
        return bl2;
    }

    private static boolean isOffloadedGaplessPlaybackSupported() {
        String string2;
        String string3;
        int n10 = Util.SDK_INT;
        int n11 = 30;
        if (n10 >= n11 && (n10 = (string3 = Util.MODEL).startsWith(string2 = "Pixel"))) {
            n10 = 1;
        } else {
            n10 = 0;
            string3 = null;
        }
        return n10 != 0;
    }

    private static boolean isOffloadedPlayback(AudioTrack audioTrack) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (bl2 = audioTrack.isOffloadedPlayback())) {
            bl2 = true;
        } else {
            bl2 = false;
            audioTrack = null;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private static boolean isOffloadedPlaybackSupported(Format format, AudioAttributes audioAttributes) {
        boolean bl2;
        void var9_15;
        int n10;
        String string2;
        int bl22 = Util.SDK_INT;
        boolean bl3 = false;
        int n11 = 29;
        if (bl22 < n11) {
            return false;
        }
        String string3 = (String)Assertions.checkNotNull(format.sampleMimeType);
        int n12 = MimeTypes.getEncoding(string3, string2 = format.codecs);
        if (n12 == 0) {
            return false;
        }
        int n13 = Util.getAudioTrackChannelConfig(format.channelCount);
        if (n13 == 0) {
            return false;
        }
        int n14 = format.sampleRate;
        string3 = DefaultAudioSink.getAudioFormat(n14, n13, n12);
        int n15 = AudioManager.isOffloadedPlaybackSupported((AudioFormat)string3, (android.media.AudioAttributes)(audioAttributes = audioAttributes.getAudioAttributesV21()));
        if (n15 == 0) {
            return false;
        }
        n15 = format.encoderDelay;
        boolean bl4 = true;
        if (n15 == 0 && (n10 = format.encoderPadding) == 0) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
            format = null;
        }
        if (var9_15 != false || (bl2 = DefaultAudioSink.isOffloadedGaplessPlaybackSupported())) {
            bl3 = bl4;
        }
        return bl3;
    }

    private static boolean isPassthroughPlaybackSupported(Format format, AudioCapabilities audioCapabilities) {
        boolean bl2;
        if ((format = DefaultAudioSink.getEncodingAndChannelConfigForPassthrough(format, audioCapabilities)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            format = null;
        }
        return bl2;
    }

    private void maybeDisableOffload() {
        DefaultAudioSink$Configuration defaultAudioSink$Configuration = this.configuration;
        boolean bl2 = defaultAudioSink$Configuration.outputModeIsOffload();
        if (!bl2) {
            return;
        }
        this.offloadDisabledUntilNextConfiguration = true;
    }

    private void playPendingData() {
        boolean bl2 = this.stoppedAudioTrack;
        if (!bl2) {
            this.stoppedAudioTrack = true;
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            long l10 = this.getWrittenFrames();
            audioTrackPositionTracker.handleEndOfStream(l10);
            this.audioTrack.stop();
            bl2 = false;
            audioTrackPositionTracker = null;
            this.bytesUntilNextAvSync = 0;
        }
    }

    private void processBuffers(long l10) {
        int n10;
        AudioProcessor[] audioProcessorArray = this.activeAudioProcessors;
        int n11 = n10 = audioProcessorArray.length;
        while (n11 >= 0) {
            int n12;
            Object object;
            if (n11 > 0) {
                object = this.outputBuffers;
                n12 = n11 + -1;
                object = object[n12];
            } else {
                object = this.inputBuffer;
                if (object == null) {
                    object = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (n11 == n10) {
                this.writeBuffer((ByteBuffer)object, l10);
            } else {
                Object object2 = this.activeAudioProcessors[n11];
                int n13 = this.drainingAudioProcessorIndex;
                if (n11 > n13) {
                    object2.queueInput((ByteBuffer)object);
                }
                object2 = object2.getOutput();
                ByteBuffer[] byteBufferArray = this.outputBuffers;
                byteBufferArray[n11] = object2;
                n12 = (int)(((Buffer)object2).hasRemaining() ? 1 : 0);
                if (n12 != 0) {
                    ++n11;
                    continue;
                }
            }
            boolean bl2 = ((Buffer)object).hasRemaining();
            if (bl2) {
                return;
            }
            n11 += -1;
        }
    }

    private void registerStreamEventCallbackV29(AudioTrack audioTrack) {
        DefaultAudioSink$StreamEventCallbackV29 defaultAudioSink$StreamEventCallbackV29 = this.offloadStreamEventCallbackV29;
        if (defaultAudioSink$StreamEventCallbackV29 == null) {
            this.offloadStreamEventCallbackV29 = defaultAudioSink$StreamEventCallbackV29 = new DefaultAudioSink$StreamEventCallbackV29(this);
        }
        this.offloadStreamEventCallbackV29.register(audioTrack);
    }

    private void resetSinkStateForFlush() {
        DefaultAudioSink$MediaPositionParameters defaultAudioSink$MediaPositionParameters;
        long l10;
        this.submittedPcmBytes = l10 = 0L;
        this.submittedEncodedFrames = l10;
        this.writtenPcmBytes = l10;
        this.writtenEncodedFrames = l10;
        this.isWaitingForOffloadEndOfStreamHandled = false;
        this.framesPerEncodedSample = 0;
        PlaybackParameters playbackParameters = this.getAudioProcessorPlaybackParameters();
        boolean bl2 = this.getSkipSilenceEnabled();
        this.mediaPositionParameters = defaultAudioSink$MediaPositionParameters = new DefaultAudioSink$MediaPositionParameters(playbackParameters, bl2, 0L, 0L, null);
        this.startMediaTimeUs = l10;
        this.afterDrainParameters = null;
        this.mediaPositionParametersCheckpoints.clear();
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = false;
        this.handledEndOfStream = false;
        this.drainingAudioProcessorIndex = -1;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.trimmingAudioProcessor.resetTrimmedFrameCount();
        this.flushAudioProcessors();
    }

    private void setAudioProcessorPlaybackParametersAndSkipSilence(PlaybackParameters playbackParameters, boolean bl2) {
        boolean bl3;
        DefaultAudioSink$MediaPositionParameters defaultAudioSink$MediaPositionParameters = this.getMediaPositionParameters();
        Object object = defaultAudioSink$MediaPositionParameters.playbackParameters;
        boolean bl4 = playbackParameters.equals(object);
        if (!bl4 || bl2 != (bl3 = defaultAudioSink$MediaPositionParameters.skipSilence)) {
            long l10 = -9223372036854775807L;
            long l11 = -9223372036854775807L;
            object = defaultAudioSink$MediaPositionParameters;
            defaultAudioSink$MediaPositionParameters = new DefaultAudioSink$MediaPositionParameters(playbackParameters, bl2, l10, l11, null);
            boolean bl5 = this.isAudioTrackInitialized();
            if (bl5) {
                this.afterDrainParameters = defaultAudioSink$MediaPositionParameters;
            } else {
                this.mediaPositionParameters = defaultAudioSink$MediaPositionParameters;
            }
        }
    }

    private void setAudioTrackPlaybackParametersV23(PlaybackParameters playbackParameters) {
        int n10 = this.isAudioTrackInitialized();
        if (n10 != 0) {
            String string2;
            Object object = new PlaybackParams();
            object = object.allowDefaults();
            float f10 = playbackParameters.speed;
            object = object.setSpeed(f10);
            float f11 = playbackParameters.pitch;
            playbackParameters = object.setPitch(f11);
            n10 = 2;
            float f12 = 2.8E-45f;
            playbackParameters = playbackParameters.setAudioFallbackMode(n10);
            object = this.audioTrack;
            try {
                object.setPlaybackParams((PlaybackParams)playbackParameters);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = TAG;
                string2 = "Failed to set playback params";
                Log.w((String)object, string2, illegalArgumentException);
            }
            f12 = this.audioTrack.getPlaybackParams().getSpeed();
            string2 = this.audioTrack.getPlaybackParams();
            f10 = string2.getPitch();
            playbackParameters = new PlaybackParameters(f12, f10);
            object = this.audioTrackPositionTracker;
            f10 = playbackParameters.speed;
            ((AudioTrackPositionTracker)object).setAudioTrackPlaybackSpeed(f10);
        }
        this.audioTrackPlaybackParameters = playbackParameters;
    }

    private void setVolumeInternal() {
        int n10 = this.isAudioTrackInitialized();
        if (n10 != 0) {
            n10 = Util.SDK_INT;
            int n11 = 21;
            float f10 = 2.9E-44f;
            if (n10 >= n11) {
                AudioTrack audioTrack = this.audioTrack;
                f10 = this.volume;
                DefaultAudioSink.setVolumeInternalV21(audioTrack, f10);
            } else {
                AudioTrack audioTrack = this.audioTrack;
                f10 = this.volume;
                DefaultAudioSink.setVolumeInternalV3(audioTrack, f10);
            }
        }
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack, float f10) {
        audioTrack.setVolume(f10);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack, float f10) {
        audioTrack.setStereoVolume(f10, f10);
    }

    private void setupAudioProcessors() {
        Object[] objectArray = this.configuration.availableAudioProcessors;
        AudioProcessor[] audioProcessorArray = new ArrayList();
        for (AudioProcessor audioProcessor : objectArray) {
            boolean bl2 = audioProcessor.isActive();
            if (bl2) {
                audioProcessorArray.add(audioProcessor);
                continue;
            }
            audioProcessor.flush();
        }
        int n10 = audioProcessorArray.size();
        AudioProcessor[] audioProcessorArray2 = new AudioProcessor[n10];
        audioProcessorArray = audioProcessorArray.toArray(audioProcessorArray2);
        this.activeAudioProcessors = audioProcessorArray;
        objectArray = new ByteBuffer[n10];
        this.outputBuffers = objectArray;
        this.flushAudioProcessors();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean shouldApplyAudioProcessorPlaybackParameters() {
        int n10 = this.tunneling;
        if (n10 != 0) return 0 != 0;
        String string2 = "audio/raw";
        Object object = this.configuration.inputFormat.sampleMimeType;
        n10 = string2.equals(object);
        if (n10 == 0) return 0 != 0;
        object = this.configuration.inputFormat;
        n10 = ((Format)object).pcmEncoding;
        if ((n10 = (int)(this.shouldUseFloatOutput(n10) ? 1 : 0)) != 0) return 0 != 0;
        return 1 != 0;
    }

    private boolean shouldUseFloatOutput(int n10) {
        boolean bl2 = this.enableFloatOutput;
        n10 = bl2 && (n10 = (int)(Util.isEncodingHighResolutionPcm(n10) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    private void writeBuffer(ByteBuffer object, long l10) {
        long l11;
        int n10;
        Object object2;
        int n11;
        long l12;
        Object object3;
        int n12;
        boolean n13 = ((Buffer)object).hasRemaining();
        if (!n13) {
            return;
        }
        Object object4 = this.outputBuffer;
        int n14 = 21;
        int n15 = 1;
        if (object4 != null) {
            void var4_6;
            if (object4 == object) {
                int n16 = n15;
            } else {
                boolean bl2 = false;
                object4 = null;
            }
            Assertions.checkArgument((boolean)var4_6);
        } else {
            this.outputBuffer = object;
            int n17 = Util.SDK_INT;
            if (n17 < n14) {
                int n18 = ((Buffer)object).remaining();
                byte[] byArray = this.preV21OutputBuffer;
                if (byArray == null || (n12 = byArray.length) < n18) {
                    this.preV21OutputBuffer = byArray = new byte[n18];
                }
                n12 = ((Buffer)object).position();
                byte[] byArray2 = this.preV21OutputBuffer;
                ((ByteBuffer)object).get(byArray2, 0, n18);
                ((ByteBuffer)object).position(n12);
                this.preV21OutputBufferOffset = 0;
            }
        }
        int n19 = ((Buffer)object).remaining();
        n12 = Util.SDK_INT;
        if (n12 < n14) {
            object3 = this.audioTrackPositionTracker;
            l12 = this.writtenPcmBytes;
            n11 = ((AudioTrackPositionTracker)object3).getAvailableBufferSize(l12);
            if (n11 > 0) {
                n11 = Math.min(n19, n11);
                object2 = this.audioTrack;
                byte[] byArray = this.preV21OutputBuffer;
                n12 = this.preV21OutputBufferOffset;
                if ((n11 = object2.write(byArray, n12, n11)) > 0) {
                    this.preV21OutputBufferOffset = n10 = this.preV21OutputBufferOffset + n11;
                    n10 = ((Buffer)object).position() + n11;
                    ((ByteBuffer)object).position(n10);
                }
            } else {
                n11 = 0;
                object3 = null;
            }
        } else {
            n14 = (int)(this.tunneling ? 1 : 0);
            if (n14) {
                l12 = -9223372036854775807L;
                long l13 = l10 - l12;
                n14 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n14) {
                    n14 = n15;
                } else {
                    n14 = 0;
                    Object var16_23 = null;
                }
                Assertions.checkState(n14 != 0);
                AudioTrack audioTrack = this.audioTrack;
                n11 = this.writeNonBlockingWithAvSyncV21(audioTrack, (ByteBuffer)object, n19, l10);
            } else {
                object3 = this.audioTrack;
                n11 = DefaultAudioSink.writeNonBlockingV21((AudioTrack)object3, (ByteBuffer)object, n19);
            }
        }
        this.lastFeedElapsedRealtimeMs = l12 = SystemClock.elapsedRealtime();
        if (n11 < 0) {
            boolean bl3 = DefaultAudioSink.isAudioTrackDeadObject(n11);
            if (bl3) {
                this.maybeDisableOffload();
            }
            object4 = this.configuration.inputFormat;
            object2 = new AudioSink$WriteException(n11, (Format)object4, bl3);
            object = this.listener;
            if (object != null) {
                object.onAudioSinkError((Exception)object2);
            }
            if (!(bl3 = ((AudioSink$WriteException)object2).isRecoverable)) {
                this.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached((Exception)object2);
                return;
            }
            throw object2;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        object2 = this.audioTrack;
        n10 = DefaultAudioSink.isOffloadedPlayback((AudioTrack)object2);
        if (n10 != 0) {
            l12 = this.writtenEncodedFrames;
            l11 = 0L;
            long l14 = l12 - l11;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 > 0) {
                this.isWaitingForOffloadEndOfStreamHandled = false;
            }
            if ((n10 = (int)(this.playing ? 1 : 0)) != 0 && (object2 = this.listener) != null && n11 < n19 && (n10 = (int)(this.isWaitingForOffloadEndOfStreamHandled ? 1 : 0)) == 0) {
                l12 = this.audioTrackPositionTracker.getPendingBufferDurationMs(l12);
                object2 = this.listener;
                object2.onOffloadBufferFull(l12);
            }
        }
        object2 = this.configuration;
        n10 = ((DefaultAudioSink$Configuration)object2).outputMode;
        if (n10 == 0) {
            l12 = this.writtenPcmBytes;
            l11 = n11;
            this.writtenPcmBytes = l12 += l11;
        }
        if (n11 == n19) {
            if (n10 != 0) {
                object3 = this.inputBuffer;
                if (object != object3) {
                    n15 = 0;
                }
                Assertions.checkState(n15 != 0);
                long l15 = this.writtenEncodedFrames;
                n10 = this.framesPerEncodedSample;
                int n20 = this.inputBufferAccessUnitCount;
                long l16 = n10 *= n20;
                this.writtenEncodedFrames = l15 += l16;
            }
            boolean bl4 = false;
            object = null;
            this.outputBuffer = null;
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int n10) {
        return audioTrack.write(byteBuffer, n10, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int n10, long l10) {
        int n11;
        int n12;
        int n13;
        ByteBuffer byteBuffer2;
        ByteOrder byteOrder;
        int n14 = Util.SDK_INT;
        long l11 = 1000L;
        int n15 = 26;
        if (n14 >= n15) {
            long l12 = l10 * l11;
            return audioTrack.write(byteBuffer, n10, 1, l12);
        }
        ByteBuffer byteBuffer3 = this.avSyncHeader;
        if (byteBuffer3 == null) {
            n14 = 16;
            this.avSyncHeader = byteBuffer3 = ByteBuffer.allocate(n14);
            byteOrder = ByteOrder.BIG_ENDIAN;
            byteBuffer3.order(byteOrder);
            byteBuffer3 = this.avSyncHeader;
            n15 = 0x55550001;
            byteBuffer3.putInt(n15);
        }
        n14 = this.bytesUntilNextAvSync;
        n15 = 0;
        byteOrder = null;
        if (n14 == 0) {
            this.avSyncHeader.putInt(4, n10);
            byteBuffer3 = this.avSyncHeader;
            int n16 = 8;
            byteBuffer3.putLong(n16, l10 *= l11);
            byteBuffer2 = this.avSyncHeader;
            byteBuffer2.position(0);
            this.bytesUntilNextAvSync = n10;
        }
        if ((n13 = (byteBuffer2 = this.avSyncHeader).remaining()) > 0) {
            ByteBuffer byteBuffer4 = this.avSyncHeader;
            n14 = 1;
            int n17 = audioTrack.write(byteBuffer4, n13, n14);
            if (n17 < 0) {
                this.bytesUntilNextAvSync = 0;
                return n17;
            }
            if (n17 < n13) {
                return 0;
            }
        }
        if ((n12 = DefaultAudioSink.writeNonBlockingV21(audioTrack, byteBuffer, n10)) < 0) {
            this.bytesUntilNextAvSync = 0;
            return n12;
        }
        this.bytesUntilNextAvSync = n11 = this.bytesUntilNextAvSync - n12;
        return n12;
    }

    public void configure(Format format, int n10, int[] nArray) {
        int n11;
        Object object;
        Object object2;
        Format format2;
        block17: {
            int n12;
            AudioProcessor[] audioProcessorArray;
            int n13;
            Object object3;
            int n14;
            int n15;
            int n16;
            String string2;
            int n17;
            DefaultAudioSink defaultAudioSink;
            block15: {
                int n18;
                block16: {
                    Object object4;
                    block14: {
                        int[] nArray2;
                        defaultAudioSink = this;
                        format2 = format;
                        object2 = format.sampleMimeType;
                        object = "audio/raw";
                        n17 = object.equals(object2);
                        n18 = -1;
                        float f10 = 0.0f / 0.0f;
                        n11 = 0;
                        string2 = null;
                        if (n17 == 0) break block14;
                        Assertions.checkArgument(Util.isEncodingLinearPcm(format.pcmEncoding));
                        n17 = format.pcmEncoding;
                        n18 = format.channelCount;
                        n17 = Util.getPcmFrameSize(n17, n18);
                        n18 = format.pcmEncoding;
                        n18 = (int)(this.shouldUseFloatOutput(n18) ? 1 : 0);
                        object = n18 != 0 ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
                        Object object5 = defaultAudioSink.trimmingAudioProcessor;
                        n16 = format2.encoderDelay;
                        n15 = format2.encoderPadding;
                        ((TrimmingAudioProcessor)object5).setTrimFrameCount(n16, n15);
                        n14 = Util.SDK_INT;
                        n16 = 21;
                        if (n14 < n16 && (n14 = format2.channelCount) == (n16 = 8) && nArray == null) {
                            n14 = 6;
                            nArray2 = new int[n14];
                            object3 = null;
                            for (n15 = 0; n15 < n14; ++n15) {
                                nArray2[n15] = n15;
                            }
                        } else {
                            nArray2 = nArray;
                        }
                        defaultAudioSink.channelMappingAudioProcessor.setChannelMap(nArray2);
                        n16 = format2.sampleRate;
                        n15 = format2.channelCount;
                        n13 = format2.pcmEncoding;
                        object5 = new AudioProcessor$AudioFormat(n16, n15, n13);
                        n16 = ((AudioProcessor[])object).length;
                        object3 = null;
                        for (n15 = 0; n15 < n16; ++n15) {
                            AudioProcessor$AudioFormat audioProcessor$AudioFormat;
                            AudioProcessor audioProcessor = object[n15];
                            try {
                                audioProcessor$AudioFormat = audioProcessor.configure((AudioProcessor$AudioFormat)object5);
                            }
                            catch (AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException) {
                                object = new AudioSink$ConfigurationException(audioProcessor$UnhandledAudioFormatException, format2);
                                throw object;
                            }
                            n13 = (int)(audioProcessor.isActive() ? 1 : 0);
                            if (n13 == 0) continue;
                            object5 = audioProcessor$AudioFormat;
                            continue;
                        }
                        n16 = ((AudioProcessor$AudioFormat)object5).encoding;
                        n15 = ((AudioProcessor$AudioFormat)object5).sampleRate;
                        n13 = Util.getAudioTrackChannelConfig(((AudioProcessor$AudioFormat)object5).channelCount);
                        n14 = ((AudioProcessor$AudioFormat)object5).channelCount;
                        n14 = Util.getPcmFrameSize(n16, n14);
                        audioProcessorArray = object;
                        n12 = n16;
                        n16 = n14;
                        n14 = 0;
                        object5 = null;
                        break block15;
                    }
                    object2 = new AudioProcessor[]{};
                    n14 = format.sampleRate;
                    n16 = this.enableOffload;
                    if (n16 == 0 || (n16 = (int)(DefaultAudioSink.isOffloadedPlaybackSupported(format, (AudioAttributes)(object4 = this.audioAttributes)) ? 1 : 0)) == 0) break block16;
                    object4 = (String)Assertions.checkNotNull(format.sampleMimeType);
                    object3 = format.codecs;
                    n16 = MimeTypes.getEncoding((String)object4, (String)object3);
                    n15 = Util.getAudioTrackChannelConfig(format.channelCount);
                    audioProcessorArray = object2;
                    n17 = n18;
                    n12 = n16;
                    n16 = n18;
                    int n19 = n15;
                    n15 = n14;
                    n14 = 1;
                    n13 = n19;
                    break block15;
                }
                n16 = 2;
                object3 = defaultAudioSink.audioCapabilities;
                if ((object3 = DefaultAudioSink.getEncodingAndChannelConfigForPassthrough(format2, (AudioCapabilities)object3)) == null) break block17;
                Integer n20 = (Integer)((Pair)object3).first;
                n13 = n20;
                object3 = (Integer)((Pair)object3).second;
                n15 = (Integer)object3;
                audioProcessorArray = object2;
                n17 = n18;
                n12 = n13;
                n13 = n15;
                n15 = n14;
                n14 = n16;
                n16 = n18;
            }
            object = ") for: ";
            if (n12 != 0) {
                if (n13 != 0) {
                    DefaultAudioSink$Configuration defaultAudioSink$Configuration;
                    defaultAudioSink.offloadDisabledUntilNextConfiguration = false;
                    boolean bl2 = defaultAudioSink.enableAudioTrackPlaybackParams;
                    object = defaultAudioSink$Configuration;
                    format2 = format;
                    n11 = n17;
                    defaultAudioSink$Configuration = new DefaultAudioSink$Configuration(format, n17, n14, n16, n15, n13, n12, n10, bl2, audioProcessorArray);
                    n17 = (int)(this.isAudioTrackInitialized() ? 1 : 0);
                    if (n17 != 0) {
                        defaultAudioSink.pendingConfiguration = defaultAudioSink$Configuration;
                    } else {
                        defaultAudioSink.configuration = defaultAudioSink$Configuration;
                    }
                    return;
                }
                string2 = String.valueOf(format);
                n16 = String.valueOf(string2).length() + 54;
                object3 = new StringBuilder(n16);
                ((StringBuilder)object3).append("Invalid output channel config (mode=");
                ((StringBuilder)object3).append(n14);
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(string2);
                object = ((StringBuilder)object3).toString();
                object2 = new AudioSink$ConfigurationException((String)object, format2);
                throw object2;
            }
            string2 = String.valueOf(format);
            n16 = String.valueOf(string2).length() + 48;
            object3 = new StringBuilder(n16);
            ((StringBuilder)object3).append("Invalid output encoding (mode=");
            ((StringBuilder)object3).append(n14);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(string2);
            object = ((StringBuilder)object3).toString();
            object2 = new AudioSink$ConfigurationException((String)object, format2);
            throw object2;
        }
        object = String.valueOf(format);
        n11 = String.valueOf(object).length() + 37;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append("Unable to configure passthrough for: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new AudioSink$ConfigurationException((String)object, format2);
        throw object2;
    }

    public void disableTunneling() {
        boolean bl2 = this.tunneling;
        if (bl2) {
            bl2 = false;
            this.tunneling = false;
            this.flush();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void enableTunnelingV21() {
        void var1_4;
        int bl2 = Util.SDK_INT;
        boolean bl3 = true;
        int n10 = 21;
        if (bl2 >= n10) {
            boolean bl4 = bl3;
        } else {
            boolean bl5 = false;
        }
        Assertions.checkState((boolean)var1_4);
        Assertions.checkState(this.externalAudioSessionIdProvided);
        boolean bl6 = this.tunneling;
        if (!bl6) {
            this.tunneling = bl3;
            this.flush();
        }
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        int n10 = Util.SDK_INT;
        int n11 = 25;
        if (n10 < n11) {
            this.flush();
            return;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        Object object = this.initializationExceptionPendingExceptionHolder;
        ((DefaultAudioSink$PendingExceptionHolder)object).clear();
        n10 = (int)(this.isAudioTrackInitialized() ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        this.resetSinkStateForFlush();
        object = this.audioTrackPositionTracker;
        n10 = (int)(((AudioTrackPositionTracker)object).isPlaying() ? 1 : 0);
        if (n10 != 0) {
            object = this.audioTrack;
            object.pause();
        }
        this.audioTrack.flush();
        this.audioTrackPositionTracker.reset();
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        AudioTrack audioTrack = this.audioTrack;
        object = this.configuration;
        int n12 = ((DefaultAudioSink$Configuration)object).outputMode;
        int n13 = 2;
        int n14 = 1;
        n12 = n12 == n13 ? n14 : 0;
        n13 = ((DefaultAudioSink$Configuration)object).outputEncoding;
        int n15 = ((DefaultAudioSink$Configuration)object).outputPcmFrameSize;
        int n16 = ((DefaultAudioSink$Configuration)object).bufferSize;
        audioTrackPositionTracker.setAudioTrack(audioTrack, n12 != 0, n13, n15, n16);
        this.startMediaTimeUsNeedsInit = n14;
    }

    public void flush() {
        boolean bl2 = this.isAudioTrackInitialized();
        if (bl2) {
            Object object;
            Object object2;
            this.resetSinkStateForFlush();
            Object object3 = this.audioTrackPositionTracker;
            bl2 = ((AudioTrackPositionTracker)object3).isPlaying();
            if (bl2) {
                object3 = this.audioTrack;
                object3.pause();
            }
            if (bl2 = DefaultAudioSink.isOffloadedPlayback((AudioTrack)(object3 = this.audioTrack))) {
                object3 = (DefaultAudioSink$StreamEventCallbackV29)Assertions.checkNotNull(this.offloadStreamEventCallbackV29);
                object2 = this.audioTrack;
                ((DefaultAudioSink$StreamEventCallbackV29)object3).unregister((AudioTrack)object2);
            }
            object3 = this.audioTrack;
            object2 = null;
            this.audioTrack = null;
            int n10 = Util.SDK_INT;
            int n11 = 21;
            if (n10 < n11 && (n10 = (int)(this.externalAudioSessionIdProvided ? 1 : 0)) == 0) {
                n10 = 0;
                object = null;
                this.audioSessionId = 0;
            }
            if ((object = this.pendingConfiguration) != null) {
                this.configuration = object;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            object = "ExoPlayer:AudioTrackReleaseThread";
            object2 = new DefaultAudioSink$1(this, (String)object, (AudioTrack)object3);
            ((Thread)object2).start();
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
    }

    public long getCurrentPositionUs(boolean bl2) {
        boolean bl3 = this.isAudioTrackInitialized();
        if (bl3 && !(bl3 = this.startMediaTimeUsNeedsInit)) {
            long l10 = this.audioTrackPositionTracker.getCurrentPositionUs(bl2);
            DefaultAudioSink$Configuration defaultAudioSink$Configuration = this.configuration;
            long l11 = this.getWrittenFrames();
            l11 = defaultAudioSink$Configuration.framesToDurationUs(l11);
            l10 = Math.min(l10, l11);
            l10 = this.applyMediaPositionParameters(l10);
            return this.applySkipping(l10);
        }
        return Long.MIN_VALUE;
    }

    public int getFormatSupport(Format object) {
        Object object2 = ((Format)object).sampleMimeType;
        int n10 = "audio/raw".equals(object2);
        int n11 = 2;
        if (n10 != 0) {
            n10 = Util.isEncodingLinearPcm(((Format)object).pcmEncoding);
            if (n10 == 0) {
                int n12 = ((Format)object).pcmEncoding;
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Invalid PCM encoding: ");
                stringBuilder.append(n12);
                object = stringBuilder.toString();
                Log.w(TAG, (String)object);
                return 0;
            }
            int n13 = ((Format)object).pcmEncoding;
            if (n13 != n11 && ((n10 = this.enableFloatOutput) == 0 || n13 != (n10 = 4))) {
                return 1;
            }
            return n11;
        }
        n10 = this.enableOffload;
        if (n10 != 0 && (n10 = this.offloadDisabledUntilNextConfiguration) == 0 && (n10 = DefaultAudioSink.isOffloadedPlaybackSupported((Format)object, (AudioAttributes)(object2 = this.audioAttributes))) != 0) {
            return n11;
        }
        object2 = this.audioCapabilities;
        boolean bl2 = DefaultAudioSink.isPassthroughPlaybackSupported((Format)object, (AudioCapabilities)object2);
        if (bl2) {
            return n11;
        }
        return 0;
    }

    public PlaybackParameters getPlaybackParameters() {
        boolean bl2 = this.enableAudioTrackPlaybackParams;
        PlaybackParameters playbackParameters = bl2 ? this.audioTrackPlaybackParameters : this.getAudioProcessorPlaybackParameters();
        return playbackParameters;
    }

    public boolean getSkipSilenceEnabled() {
        return this.getMediaPositionParameters().skipSilence;
    }

    /*
     * WARNING - void declaration
     */
    public boolean handleBuffer(ByteBuffer byteBuffer, long l10, int n10) {
        boolean bl2;
        long l11;
        boolean bl3;
        void var12_13;
        DefaultAudioSink defaultAudioSink = this;
        Object object = byteBuffer;
        long l12 = l10;
        int n12 = n10;
        Object object2 = this.inputBuffer;
        boolean n13 = true;
        if (object2 != null && byteBuffer != object2) {
            boolean n11 = false;
            object2 = null;
        } else {
            boolean bl4 = n13;
        }
        Assertions.checkArgument((boolean)var12_13);
        object2 = defaultAudioSink.pendingConfiguration;
        boolean bl5 = false;
        Object object3 = null;
        if (object2 != null) {
            boolean bl6 = this.drainToEndOfStream();
            if (!bl6) {
                return false;
            }
            object2 = defaultAudioSink.pendingConfiguration;
            Object object4 = defaultAudioSink.configuration;
            boolean bl7 = ((DefaultAudioSink$Configuration)object2).canReuseAudioTrack((DefaultAudioSink$Configuration)object4);
            if (!bl7) {
                this.playPendingData();
                boolean bl8 = this.hasPendingData();
                if (bl8) {
                    return false;
                }
                this.flush();
            } else {
                defaultAudioSink.configuration = object2 = defaultAudioSink.pendingConfiguration;
                defaultAudioSink.pendingConfiguration = null;
                object2 = defaultAudioSink.audioTrack;
                boolean bl9 = DefaultAudioSink.isOffloadedPlayback((AudioTrack)object2);
                if (bl9) {
                    defaultAudioSink.audioTrack.setOffloadEndOfStream();
                    object2 = defaultAudioSink.audioTrack;
                    object4 = defaultAudioSink.configuration.inputFormat;
                    int n11 = ((Format)object4).encoderDelay;
                    int n14 = ((Format)object4).encoderPadding;
                    object2.setOffloadDelayPadding(n11, n14);
                    defaultAudioSink.isWaitingForOffloadEndOfStreamHandled = n13;
                }
            }
            defaultAudioSink.applyAudioProcessorPlaybackParametersAndSkipSilence(l12);
        }
        if (!(bl3 = this.isAudioTrackInitialized())) {
            try {
                this.initializeAudioTrack();
            }
            catch (AudioSink$InitializationException audioSink$InitializationException) {
                AudioSink$InitializationException audioSink$InitializationException2 = audioSink$InitializationException;
                boolean bl10 = audioSink$InitializationException.isRecoverable;
                if (!bl10) {
                    defaultAudioSink.initializationExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(audioSink$InitializationException2);
                    return false;
                }
                throw audioSink$InitializationException;
            }
        }
        object2 = defaultAudioSink.initializationExceptionPendingExceptionHolder;
        ((DefaultAudioSink$PendingExceptionHolder)object2).clear();
        boolean bl11 = defaultAudioSink.startMediaTimeUsNeedsInit;
        long l13 = 0L;
        if (bl11) {
            int n15;
            int n16;
            defaultAudioSink.startMediaTimeUs = l11 = Math.max(l13, l12);
            defaultAudioSink.startMediaTimeUsNeedsSync = false;
            defaultAudioSink.startMediaTimeUsNeedsInit = false;
            boolean bl12 = defaultAudioSink.enableAudioTrackPlaybackParams;
            if (bl12 && (n16 = Util.SDK_INT) >= (n15 = 23)) {
                object2 = defaultAudioSink.audioTrackPlaybackParameters;
                defaultAudioSink.setAudioTrackPlaybackParametersV23((PlaybackParameters)object2);
            }
            defaultAudioSink.applyAudioProcessorPlaybackParametersAndSkipSilence(l12);
            boolean bl13 = defaultAudioSink.playing;
            if (bl13) {
                this.play();
            }
        }
        if (!(bl2 = ((AudioTrackPositionTracker)(object2 = defaultAudioSink.audioTrackPositionTracker)).mayHandleBuffer(l11 = this.getWrittenFrames()))) {
            return false;
        }
        object2 = defaultAudioSink.inputBuffer;
        String string2 = TAG;
        if (object2 == null) {
            boolean bl14;
            long l14;
            long l15;
            void var12_27;
            ByteOrder byteOrder;
            object2 = byteBuffer.order();
            if (object2 == (byteOrder = ByteOrder.LITTLE_ENDIAN)) {
                boolean bl15 = n13;
            } else {
                boolean bl16 = false;
                object2 = null;
            }
            Assertions.checkArgument((boolean)var12_27);
            boolean bl17 = byteBuffer.hasRemaining();
            if (!bl17) {
                return n13;
            }
            object2 = defaultAudioSink.configuration;
            int n17 = ((DefaultAudioSink$Configuration)object2).outputMode;
            if (n17 != 0 && (n17 = defaultAudioSink.framesPerEncodedSample) == 0) {
                int n18;
                defaultAudioSink.framesPerEncodedSample = n18 = DefaultAudioSink.getFramesPerEncodedSample(((DefaultAudioSink$Configuration)object2).outputEncoding, (ByteBuffer)object);
                if (n18 == 0) {
                    return n13;
                }
            }
            if ((object2 = defaultAudioSink.afterDrainParameters) != null) {
                boolean bl18 = this.drainToEndOfStream();
                if (!bl18) {
                    return false;
                }
                defaultAudioSink.applyAudioProcessorPlaybackParametersAndSkipSilence(l12);
                defaultAudioSink.afterDrainParameters = null;
            }
            long l16 = defaultAudioSink.startMediaTimeUs;
            object2 = defaultAudioSink.configuration;
            long l17 = this.getSubmittedFrames();
            object3 = defaultAudioSink.trimmingAudioProcessor;
            long l18 = ((TrimmingAudioProcessor)object3).getTrimmedFrameCount();
            l17 -= l18;
            l17 = ((DefaultAudioSink$Configuration)object2).inputFramesToDurationUs(l17);
            l16 += l17;
            boolean bl19 = defaultAudioSink.startMediaTimeUsNeedsSync;
            if (!bl19 && (l15 = (l14 = (l17 = Math.abs(l16 - l12)) - (l18 = 200000L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0) {
                int n19 = 80;
                object3 = new StringBuilder(n19);
                ((StringBuilder)object3).append("Discontinuity detected [expected ");
                ((StringBuilder)object3).append(l16);
                ((StringBuilder)object3).append(", got ");
                ((StringBuilder)object3).append(l12);
                ((StringBuilder)object3).append("]");
                object2 = ((StringBuilder)object3).toString();
                Log.e(string2, (String)object2);
                defaultAudioSink.startMediaTimeUsNeedsSync = n13;
            }
            if (bl14 = defaultAudioSink.startMediaTimeUsNeedsSync) {
                boolean bl20 = this.drainToEndOfStream();
                if (!bl20) {
                    return false;
                }
                l16 = l12 - l16;
                defaultAudioSink.startMediaTimeUs = l17 = defaultAudioSink.startMediaTimeUs + l16;
                defaultAudioSink.startMediaTimeUsNeedsSync = false;
                defaultAudioSink.applyAudioProcessorPlaybackParametersAndSkipSilence(l12);
                object2 = defaultAudioSink.listener;
                if (object2 != null && (bl5 = l16 == l13 ? 0 : (l16 < l13 ? -1 : 1))) {
                    object2.onPositionDiscontinuity();
                }
            }
            object2 = defaultAudioSink.configuration;
            int n20 = ((DefaultAudioSink$Configuration)object2).outputMode;
            if (n20 == 0) {
                long l19 = defaultAudioSink.submittedPcmBytes;
                int n21 = byteBuffer.remaining();
                l16 = n21;
                defaultAudioSink.submittedPcmBytes = l19 += l16;
            } else {
                long l20 = defaultAudioSink.submittedEncodedFrames;
                int n22 = defaultAudioSink.framesPerEncodedSample * n12;
                l16 = n22;
                defaultAudioSink.submittedEncodedFrames = l20 += l16;
            }
            defaultAudioSink.inputBuffer = object;
            defaultAudioSink.inputBufferAccessUnitCount = n12;
        }
        defaultAudioSink.processBuffers(l12);
        object = defaultAudioSink.inputBuffer;
        boolean bl21 = ((Buffer)object).hasRemaining();
        if (!bl21) {
            defaultAudioSink.inputBuffer = null;
            defaultAudioSink.inputBufferAccessUnitCount = 0;
            return n13;
        }
        object = defaultAudioSink.audioTrackPositionTracker;
        l12 = this.getWrittenFrames();
        bl21 = ((AudioTrackPositionTracker)object).isStalled(l12);
        if (bl21) {
            Log.w(string2, "Resetting stalled audio track");
            this.flush();
            return n13;
        }
        return false;
    }

    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    public boolean hasPendingData() {
        long l10;
        AudioTrackPositionTracker audioTrackPositionTracker;
        boolean bl2 = this.isAudioTrackInitialized();
        if (bl2 && (bl2 = (audioTrackPositionTracker = this.audioTrackPositionTracker).hasPendingData(l10 = this.getWrittenFrames()))) {
            bl2 = true;
        } else {
            bl2 = false;
            audioTrackPositionTracker = null;
        }
        return bl2;
    }

    public boolean isEnded() {
        boolean bl2 = this.isAudioTrackInitialized();
        bl2 = !bl2 || (bl2 = this.handledEndOfStream) && !(bl2 = this.hasPendingData());
        return bl2;
    }

    public void pause() {
        AudioTrackPositionTracker audioTrackPositionTracker = null;
        this.playing = false;
        boolean bl2 = this.isAudioTrackInitialized();
        if (bl2 && (bl2 = (audioTrackPositionTracker = this.audioTrackPositionTracker).pause())) {
            audioTrackPositionTracker = this.audioTrack;
            audioTrackPositionTracker.pause();
        }
    }

    public void play() {
        this.playing = true;
        boolean bl2 = this.isAudioTrackInitialized();
        if (bl2) {
            this.audioTrackPositionTracker.start();
            AudioTrack audioTrack = this.audioTrack;
            audioTrack.play();
        }
    }

    public void playToEndOfStream() {
        boolean bl2 = this.handledEndOfStream;
        if (!bl2 && (bl2 = this.isAudioTrackInitialized()) && (bl2 = this.drainToEndOfStream())) {
            this.playPendingData();
            this.handledEndOfStream = bl2 = true;
        }
    }

    public void reset() {
        this.flush();
        for (AudioProcessor audioProcessor : this.toIntPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor : this.toFloatPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        this.playing = false;
        this.offloadDisabledUntilNextConfiguration = false;
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        AudioAttributes audioAttributes2 = this.audioAttributes;
        boolean bl2 = audioAttributes2.equals(audioAttributes);
        if (bl2) {
            return;
        }
        this.audioAttributes = audioAttributes;
        boolean bl3 = this.tunneling;
        if (bl3) {
            return;
        }
        this.flush();
    }

    public void setAudioSessionId(int n10) {
        int n11 = this.audioSessionId;
        if (n11 != n10) {
            this.audioSessionId = n10;
            n10 = n10 != 0 ? 1 : 0;
            this.externalAudioSessionIdProvided = n10;
            this.flush();
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        AuxEffectInfo auxEffectInfo2 = this.auxEffectInfo;
        int n10 = auxEffectInfo2.equals(auxEffectInfo);
        if (n10 != 0) {
            return;
        }
        n10 = auxEffectInfo.effectId;
        float f10 = auxEffectInfo.sendLevel;
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            AuxEffectInfo auxEffectInfo3 = this.auxEffectInfo;
            int n11 = auxEffectInfo3.effectId;
            if (n11 != n10) {
                audioTrack.attachAuxEffect(n10);
            }
            if (n10 != 0) {
                auxEffectInfo2 = this.audioTrack;
                auxEffectInfo2.setAuxEffectSendLevel(f10);
            }
        }
        this.auxEffectInfo = auxEffectInfo;
    }

    public void setListener(AudioSink$Listener audioSink$Listener) {
        this.listener = audioSink$Listener;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        float f10 = playbackParameters.speed;
        float f11 = 0.1f;
        float f12 = 8.0f;
        f10 = Util.constrainValue(f10, f11, f12);
        float f13 = Util.constrainValue(playbackParameters.pitch, f11, f12);
        PlaybackParameters playbackParameters2 = new PlaybackParameters(f10, f13);
        int n10 = this.enableAudioTrackPlaybackParams;
        if (n10 != 0) {
            n10 = Util.SDK_INT;
            int n11 = 23;
            f10 = 3.2E-44f;
            if (n10 >= n11) {
                this.setAudioTrackPlaybackParametersV23(playbackParameters2);
                return;
            }
        }
        n10 = (int)(this.getSkipSilenceEnabled() ? 1 : 0);
        this.setAudioProcessorPlaybackParametersAndSkipSilence(playbackParameters2, n10 != 0);
    }

    public void setSkipSilenceEnabled(boolean bl2) {
        PlaybackParameters playbackParameters = this.getAudioProcessorPlaybackParameters();
        this.setAudioProcessorPlaybackParametersAndSkipSilence(playbackParameters, bl2);
    }

    public void setVolume(float f10) {
        float f11 = this.volume;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.volume = f10;
            this.setVolumeInternal();
        }
    }

    public boolean supportsFormat(Format format) {
        int n10 = this.getFormatSupport(format);
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            format = null;
        }
        return n10 != 0;
    }
}

