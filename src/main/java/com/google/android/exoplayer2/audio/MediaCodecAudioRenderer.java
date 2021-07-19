/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Handler
 */
package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer$WakeupListener;
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
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$Factory;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.MediaFormatUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class MediaCodecAudioRenderer
extends MediaCodecRenderer
implements MediaClock {
    private static final String TAG = "MediaCodecAudioRenderer";
    private static final String VIVO_BITS_PER_SAMPLE_KEY = "v-bits-per-sample";
    private boolean allowFirstBufferPositionDiscontinuity;
    private boolean allowPositionDiscontinuity;
    private final AudioSink audioSink;
    private boolean audioSinkNeedsReset;
    private int codecMaxInputSize;
    private boolean codecNeedsDiscardChannelsWorkaround;
    private final Context context;
    private long currentPositionUs;
    private Format decryptOnlyCodecFormat;
    private final AudioRendererEventListener$EventDispatcher eventDispatcher;
    private boolean experimentalKeepAudioTrackOnSeek;
    private Renderer$WakeupListener wakeupListener;

    public MediaCodecAudioRenderer(Context object, MediaCodecAdapter$Factory mediaCodecAdapter$Factory, MediaCodecSelector mediaCodecSelector, boolean bl2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, mediaCodecAdapter$Factory, mediaCodecSelector, bl2, 44100.0f);
        this.context = object = object.getApplicationContext();
        this.audioSink = audioSink;
        super(handler, audioRendererEventListener);
        this.eventDispatcher = object;
        super(this, null);
        audioSink.setListener((AudioSink$Listener)object);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener) {
        AudioProcessor[] audioProcessorArray = new AudioProcessor[]{};
        this(context, mediaCodecSelector, handler, audioRendererEventListener, null, audioProcessorArray);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor ... audioProcessorArray) {
        DefaultAudioSink defaultAudioSink = new DefaultAudioSink(audioCapabilities, audioProcessorArray);
        this(context, mediaCodecSelector, handler, audioRendererEventListener, defaultAudioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        MediaCodecAdapter$Factory mediaCodecAdapter$Factory = MediaCodecAdapter$Factory.DEFAULT;
        this(context, mediaCodecAdapter$Factory, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean bl2, Handler handler, AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        MediaCodecAdapter$Factory mediaCodecAdapter$Factory = MediaCodecAdapter$Factory.DEFAULT;
        this(context, mediaCodecAdapter$Factory, mediaCodecSelector, bl2, handler, audioRendererEventListener, audioSink);
    }

    public static /* synthetic */ AudioRendererEventListener$EventDispatcher access$100(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        return mediaCodecAudioRenderer.eventDispatcher;
    }

    public static /* synthetic */ Renderer$WakeupListener access$200(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        return mediaCodecAudioRenderer.wakeupListener;
    }

    private static boolean codecNeedsDiscardChannelsWorkaround(String string2) {
        String string3;
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 24;
        if (n10 < n11 && (bl2 = (string3 = "OMX.SEC.aac.dec").equals(string2)) && (bl2 = (string3 = "samsung").equals(string2 = Util.MANUFACTURER)) && ((n10 = (int)((string2 = Util.DEVICE).startsWith(string3 = "zeroflte") ? 1 : 0)) != 0 || (n10 = (int)(string2.startsWith(string3 = "herolte") ? 1 : 0)) != 0 || (bl2 = string2.startsWith(string3 = "heroqlte")))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    private static boolean deviceDoesntSupportOperatingRate() {
        String string2;
        String string3;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 == n11 && ((n11 = (string3 = "ZTE B2017G").equals(string2 = Util.MODEL)) || (n10 = (string3 = "AXON 7 mini").equals(string2)))) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }

    private int getCodecMaxInputSize(MediaCodecInfo object, Format format) {
        int n10;
        String string2 = "OMX.google.raw.decoder";
        object = ((MediaCodecInfo)object).name;
        int n11 = string2.equals(object);
        if (n11 != 0 && (n11 = Util.SDK_INT) < (n10 = 24) && (n11 != (n10 = 23) || (n11 = (int)(Util.isTv((Context)(object = this.context)) ? 1 : 0)) == 0)) {
            return -1;
        }
        return format.maxInputSize;
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

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int n10;
        int n11;
        DecoderReuseEvaluation decoderReuseEvaluation = mediaCodecInfo.canReuseCodec(format, format2);
        int n12 = decoderReuseEvaluation.discardReasons;
        int n13 = this.getCodecMaxInputSize(mediaCodecInfo, format2);
        if (n13 > (n11 = this.codecMaxInputSize)) {
            n12 |= 0x40;
        }
        int n14 = n12;
        String string2 = mediaCodecInfo.name;
        if (n12 != 0) {
            n10 = 0;
            mediaCodecInfo = null;
        } else {
            n10 = decoderReuseEvaluation.result;
        }
        DecoderReuseEvaluation decoderReuseEvaluation2 = new DecoderReuseEvaluation(string2, format, format2, n10, n14);
        return decoderReuseEvaluation2;
    }

    public void configureCodec(MediaCodecInfo object, MediaCodecAdapter object2, Format format, MediaCrypto mediaCrypto, float f10) {
        int n10;
        Object object3 = this.getStreamFormats();
        this.codecMaxInputSize = n10 = this.getCodecMaxInputSize((MediaCodecInfo)object, format, (Format[])object3);
        n10 = (int)(MediaCodecAudioRenderer.codecNeedsDiscardChannelsWorkaround(((MediaCodecInfo)object).name) ? 1 : 0);
        this.codecNeedsDiscardChannelsWorkaround = n10;
        object3 = ((MediaCodecInfo)object).codecMimeType;
        int n11 = this.codecMaxInputSize;
        MediaFormat mediaFormat = this.getMediaFormat(format, (String)object3, n11, f10);
        n10 = 0;
        object3 = null;
        n11 = 0;
        object2.configure(mediaFormat, null, mediaCrypto, 0);
        object = ((MediaCodecInfo)object).mimeType;
        object2 = "audio/raw";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2 && !(bl2 = ((String)object2).equals(object = format.sampleMimeType))) {
            n11 = 1;
        }
        if (n11 == 0) {
            format = null;
        }
        this.decryptOnlyCodecFormat = format;
    }

    public void experimentalSetEnableKeepAudioTrackOnSeek(boolean bl2) {
        this.experimentalKeepAudioTrackOnSeek = bl2;
    }

    public int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArray) {
        int n10 = this.getCodecMaxInputSize(mediaCodecInfo, format);
        int n11 = formatArray.length;
        int n12 = 1;
        if (n11 == n12) {
            return n10;
        }
        for (Format format2 : formatArray) {
            DecoderReuseEvaluation decoderReuseEvaluation = mediaCodecInfo.canReuseCodec(format, format2);
            int n13 = decoderReuseEvaluation.result;
            if (n13 == 0) continue;
            int n14 = this.getCodecMaxInputSize(mediaCodecInfo, format2);
            n10 = Math.max(n10, n14);
        }
        return n10;
    }

    public float getCodecOperatingRateV23(float f10, Format format, Format[] formatArray) {
        int n10 = formatArray.length;
        int n11 = -1;
        int n12 = n11;
        for (int i10 = 0; i10 < n10; ++i10) {
            Format format2 = formatArray[i10];
            int n13 = format2.sampleRate;
            if (n13 == n11) continue;
            n12 = Math.max(n12, n13);
        }
        if (n12 == n11) {
            f10 = -1.0f;
        } else {
            float f11 = n12;
            f10 *= f11;
        }
        return f10;
    }

    public List getDecoderInfos(MediaCodecSelector object, Format arrayList, boolean bl2) {
        Object object2 = ((Format)arrayList).sampleMimeType;
        if (object2 == null) {
            return Collections.emptyList();
        }
        Object object3 = this.audioSink;
        boolean bl3 = object3.supportsFormat((Format)((Object)arrayList));
        if (bl3 && (object3 = MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null) {
            return Collections.singletonList(object3);
        }
        bl3 = false;
        object3 = null;
        arrayList = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(object.getDecoderInfos((String)object2, bl2, false), (Format)((Object)arrayList));
        String string2 = "audio/eac3-joc";
        boolean bl4 = string2.equals(object2);
        if (bl4) {
            object2 = new Object(arrayList);
            object = object.getDecoderInfos("audio/eac3", bl2, false);
            object2.addAll(object);
            arrayList = object2;
        }
        return Collections.unmodifiableList(arrayList);
    }

    public MediaClock getMediaClock() {
        return this;
    }

    public MediaFormat getMediaFormat(Format object, String object2, int n10, float f10) {
        String string2;
        String string3;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", (String)object2);
        int n11 = ((Format)object).channelCount;
        mediaFormat.setInteger("channel-count", n11);
        n11 = ((Format)object).sampleRate;
        String string4 = "sample-rate";
        mediaFormat.setInteger(string4, n11);
        object2 = ((Format)object).initializationData;
        MediaFormatUtil.setCsdBuffers(mediaFormat, (List)object2);
        object2 = "max-input-size";
        MediaFormatUtil.maybeSetInteger(mediaFormat, (String)object2, n10);
        n11 = Util.SDK_INT;
        n10 = 23;
        float f11 = 3.2E-44f;
        if (n11 >= n10) {
            string3 = null;
            string4 = "priority";
            mediaFormat.setInteger(string4, 0);
            f11 = -1.0f;
            n10 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
            if (n10 != 0 && (n10 = (int)(MediaCodecAudioRenderer.deviceDoesntSupportOperatingRate() ? 1 : 0)) == 0) {
                string3 = "operating-rate";
                mediaFormat.setFloat(string3, f10);
            }
        }
        n10 = 28;
        f11 = 3.9E-44f;
        if (n11 <= n10 && (n10 = (int)((string2 = "audio/ac4").equals(string3 = ((Format)object).sampleMimeType) ? 1 : 0)) != 0) {
            n10 = 1;
            f11 = Float.MIN_VALUE;
            string2 = "ac4-is-sync";
            mediaFormat.setInteger(string2, n10);
        }
        n10 = 24;
        f11 = 3.4E-44f;
        if (n11 >= n10) {
            object2 = this.audioSink;
            n10 = ((Format)object).channelCount;
            int n12 = ((Format)object).sampleRate;
            int n13 = 4;
            f10 = 5.6E-45f;
            object = Util.getPcmFormat(n13, n10, n12);
            if ((n12 = object2.getFormatSupport((Format)object)) == (n11 = 2)) {
                object = "pcm-encoding";
                mediaFormat.setInteger((String)object, n13);
            }
        }
        return mediaFormat;
    }

    public String getName() {
        return TAG;
    }

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

    public void handleMessage(int n10, Object object) {
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            super.handleMessage(n10, object);
                            break;
                        }
                        case 103: {
                            this.wakeupListener = object = (Renderer$WakeupListener)object;
                            break;
                        }
                        case 102: {
                            AudioSink audioSink = this.audioSink;
                            object = (Integer)object;
                            int n12 = (Integer)object;
                            audioSink.setAudioSessionId(n12);
                            break;
                        }
                        case 101: {
                            AudioSink audioSink = this.audioSink;
                            object = (Boolean)object;
                            boolean bl2 = (Boolean)object;
                            audioSink.setSkipSilenceEnabled(bl2);
                            break;
                        }
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
        boolean bl2 = super.isEnded();
        if (bl2 && (bl2 = (audioSink = this.audioSink).isEnded())) {
            bl2 = true;
        } else {
            bl2 = false;
            audioSink = null;
        }
        return bl2;
    }

    public boolean isReady() {
        AudioSink audioSink = this.audioSink;
        boolean bl2 = audioSink.hasPendingData();
        if (!bl2 && !(bl2 = super.isReady())) {
            bl2 = false;
            audioSink = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void onCodecInitialized(String string2, long l10, long l11) {
        this.eventDispatcher.decoderInitialized(string2, l10, l11);
    }

    public void onCodecReleased(String string2) {
        this.eventDispatcher.decoderReleased(string2);
    }

    public void onDisabled() {
        Object object;
        boolean bl2;
        this.audioSinkNeedsReset = bl2 = true;
        try {
            object = this.audioSink;
        }
        catch (Throwable throwable) {
            try {
                super.onDisabled();
                throw throwable;
            }
            finally {
                AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
                DecoderCounters decoderCounters = this.decoderCounters;
                audioRendererEventListener$EventDispatcher.disabled(decoderCounters);
            }
        }
        object.flush();
        try {
            super.onDisabled();
            return;
        }
        finally {
            object = this.eventDispatcher;
            DecoderCounters decoderCounters = this.decoderCounters;
            ((AudioRendererEventListener$EventDispatcher)object).disabled(decoderCounters);
        }
    }

    public void onEnabled(boolean bl2, boolean bl3) {
        super.onEnabled(bl2, bl3);
        Object object = this.eventDispatcher;
        DecoderCounters decoderCounters = this.decoderCounters;
        ((AudioRendererEventListener$EventDispatcher)object).enabled(decoderCounters);
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

    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder object) {
        DecoderReuseEvaluation decoderReuseEvaluation = super.onInputFormatChanged((FormatHolder)object);
        AudioRendererEventListener$EventDispatcher audioRendererEventListener$EventDispatcher = this.eventDispatcher;
        object = ((FormatHolder)object).format;
        audioRendererEventListener$EventDispatcher.inputFormatChanged((Format)object, decoderReuseEvaluation);
        return decoderReuseEvaluation;
    }

    public void onOutputFormatChanged(Format format, MediaFormat object) {
        Object object2 = this.decryptOnlyCodecFormat;
        int[] nArray = null;
        if (object2 != null) {
            format = object2;
        } else {
            object2 = this.getCodec();
            if (object2 != null) {
                int n10;
                String string2 = "audio/raw";
                object2 = format.sampleMimeType;
                int n11 = string2.equals(object2);
                n11 = n11 != 0 ? format.pcmEncoding : ((n11 = Util.SDK_INT) >= (n10 = 24) && (n10 = (int)(object.containsKey((String)(object2 = "pcm-encoding")) ? 1 : 0)) != 0 ? object.getInteger((String)object2) : ((n10 = (int)(object.containsKey((String)(object2 = VIVO_BITS_PER_SAMPLE_KEY)) ? 1 : 0)) != 0 ? Util.getPcmEncoding(object.getInteger((String)object2)) : ((n11 = (int)(string2.equals(object2 = format.sampleMimeType) ? 1 : 0)) != 0 ? format.pcmEncoding : 2)));
                Format$Builder format$Builder = new Format$Builder();
                object2 = format$Builder.setSampleMimeType(string2).setPcmEncoding(n11);
                int n12 = format.encoderDelay;
                object2 = ((Format$Builder)object2).setEncoderDelay(n12);
                n12 = format.encoderPadding;
                object2 = ((Format$Builder)object2).setEncoderPadding(n12);
                n12 = object.getInteger("channel-count");
                object2 = ((Format$Builder)object2).setChannelCount(n12);
                string2 = "sample-rate";
                int n13 = object.getInteger(string2);
                object = ((Format$Builder)object2).setSampleRate(n13).build();
                n11 = (int)(this.codecNeedsDiscardChannelsWorkaround ? 1 : 0);
                if (n11 != 0 && (n11 = object.channelCount) == (n12 = 6) && (n11 = format.channelCount) < n12) {
                    nArray = new int[n11];
                    object2 = null;
                    for (n11 = 0; n11 < (n12 = format.channelCount); ++n11) {
                        nArray[n11] = n11;
                    }
                }
                format = object;
            }
        }
        try {
            object = this.audioSink;
        }
        catch (AudioSink$ConfigurationException audioSink$ConfigurationException) {
            object = audioSink$ConfigurationException.format;
            throw this.createRendererException(audioSink$ConfigurationException, (Format)object);
        }
        object.configure(format, 0, nArray);
    }

    public void onPositionDiscontinuity() {
        this.allowPositionDiscontinuity = true;
    }

    public void onPositionReset(long l10, boolean bl2) {
        boolean bl3;
        super.onPositionReset(l10, bl2);
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
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        this.audioSink.handleDiscontinuity();
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
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

    public void onReset() {
        AudioSink audioSink = null;
        try {
            super.onReset();
            return;
        }
        finally {
            boolean bl2 = this.audioSinkNeedsReset;
            if (bl2) {
                this.audioSinkNeedsReset = false;
                audioSink = this.audioSink;
                audioSink.reset();
            }
        }
    }

    public void onStarted() {
        super.onStarted();
        this.audioSink.play();
    }

    public void onStopped() {
        this.updateCurrentPosition();
        this.audioSink.pause();
        super.onStopped();
    }

    public boolean processOutputBuffer(long l10, long l11, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int n10, int n11, int n12, long l12, boolean bl2, boolean bl3, Format format) {
        int n13;
        Assertions.checkNotNull(byteBuffer);
        Object object = this.decryptOnlyCodecFormat;
        boolean bl4 = true;
        int n14 = 0;
        if (object != null && (n13 = n11 & 2) != 0) {
            ((MediaCodecAdapter)Assertions.checkNotNull(mediaCodecAdapter)).releaseOutputBuffer(n10, false);
            return bl4;
        }
        if (bl2) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.releaseOutputBuffer(n10, false);
            }
            object = this.decoderCounters;
            ((DecoderCounters)object).skippedOutputBufferCount = n14 = ((DecoderCounters)object).skippedOutputBufferCount + n12;
            this.audioSink.handleDiscontinuity();
            return bl4;
        }
        object = this.audioSink;
        try {
            n13 = (int)(object.handleBuffer(byteBuffer, l12, n12) ? 1 : 0);
            if (n13 != 0) {
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.releaseOutputBuffer(n10, false);
                }
                object = this.decoderCounters;
                ((DecoderCounters)object).renderedOutputBufferCount = n14 = ((DecoderCounters)object).renderedOutputBufferCount + n12;
                return bl4;
            }
            return false;
        }
        catch (AudioSink$WriteException audioSink$WriteException) {
            bl4 = audioSink$WriteException.isRecoverable;
            throw this.createRendererException(audioSink$WriteException, format, bl4);
        }
        catch (AudioSink$InitializationException audioSink$InitializationException) {
            Format format2 = audioSink$InitializationException.format;
            n14 = audioSink$InitializationException.isRecoverable;
            throw this.createRendererException(audioSink$InitializationException, format2, n14 != 0);
        }
    }

    public void renderToEndOfStream() {
        AudioSink audioSink;
        try {
            audioSink = this.audioSink;
        }
        catch (AudioSink$WriteException audioSink$WriteException) {
            Format format = audioSink$WriteException.format;
            boolean bl2 = audioSink$WriteException.isRecoverable;
            throw this.createRendererException(audioSink$WriteException, format, bl2);
        }
        audioSink.playToEndOfStream();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.audioSink.setPlaybackParameters(playbackParameters);
    }

    public boolean shouldUseBypass(Format format) {
        return this.audioSink.supportsFormat(format);
    }

    public int supportsFormat(MediaCodecSelector object, Format format) {
        boolean bl2;
        Object object2;
        int n10;
        String string2 = format.sampleMimeType;
        int n11 = MimeTypes.isAudio(string2);
        boolean bl3 = false;
        if (n11 == 0) {
            return RendererCapabilities.create(0);
        }
        n11 = Util.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            n11 = 32;
        } else {
            n11 = 0;
            string2 = null;
        }
        Object object3 = format.exoMediaCryptoType;
        int n13 = 1;
        if (object3 != null) {
            n12 = n13;
        } else {
            n12 = 0;
            object3 = null;
        }
        boolean bl4 = MediaCodecRenderer.supportsFormatDrm(format);
        int n14 = 8;
        int n15 = 4;
        if (bl4 && (n10 = (object2 = this.audioSink).supportsFormat(format)) != 0 && (n12 == 0 || (object3 = MediaCodecUtil.getDecryptOnlyDecoderInfo()) != null)) {
            return RendererCapabilities.create(n15, n14, n11);
        }
        object2 = "audio/raw";
        object3 = format.sampleMimeType;
        n12 = (int)(((String)object2).equals(object3) ? 1 : 0);
        if (n12 != 0 && (n12 = (int)((object3 = this.audioSink).supportsFormat(format) ? 1 : 0)) == 0) {
            return RendererCapabilities.create(n13);
        }
        object3 = this.audioSink;
        int n16 = 2;
        n10 = format.channelCount;
        int n17 = format.sampleRate;
        object2 = Util.getPcmFormat(n16, n10, n17);
        n12 = (int)(object3.supportsFormat((Format)object2) ? 1 : 0);
        if (n12 == 0) {
            return RendererCapabilities.create(n13);
        }
        n12 = (int)((object = this.getDecoderInfos((MediaCodecSelector)object, format, false)).isEmpty() ? 1 : 0);
        if (n12 != 0) {
            return RendererCapabilities.create(n13);
        }
        if (!bl4) {
            return RendererCapabilities.create(n16);
        }
        bl3 = ((MediaCodecInfo)(object = (MediaCodecInfo)object.get(0))).isFormatSupported(format);
        if (bl3 && (bl2 = ((MediaCodecInfo)object).isSeamlessAdaptationSupported(format))) {
            n14 = 16;
        }
        if (!bl3) {
            n15 = 3;
        }
        return RendererCapabilities.create(n15, n14, n11);
    }
}

