/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 */
package com.google.android.exoplayer2.transformer;

import android.media.MediaCodec;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.SonicAudioProcessor;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.transformer.MediaCodecAdapterWrapper;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.SegmentSpeedProvider;
import com.google.android.exoplayer2.transformer.SpeedProvider;
import com.google.android.exoplayer2.transformer.Transformation;
import com.google.android.exoplayer2.transformer.TransformerBaseRenderer;
import com.google.android.exoplayer2.transformer.TransformerMediaClock;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class TransformerAudioRenderer
extends TransformerBaseRenderer {
    private static final int DEFAULT_ENCODER_BITRATE = 131072;
    private static final float SPEED_UNSET = -1.0f;
    private static final String TAG = "TransformerAudioRenderer";
    private float currentSpeed;
    private MediaCodecAdapterWrapper decoder;
    private final DecoderInputBuffer decoderInputBuffer;
    private boolean drainingSonicForSpeedChange;
    private MediaCodecAdapterWrapper encoder;
    private AudioProcessor$AudioFormat encoderInputAudioFormat;
    private final DecoderInputBuffer encoderInputBuffer;
    private boolean hasEncoderOutputFormat;
    private Format inputFormat;
    private boolean muxerWrapperTrackEnded;
    private long nextEncoderInputBufferTimeUs;
    private final SonicAudioProcessor sonicAudioProcessor;
    private ByteBuffer sonicOutputBuffer;
    private SpeedProvider speedProvider;

    public TransformerAudioRenderer(MuxerWrapper object, TransformerMediaClock transformerMediaClock, Transformation transformation) {
        super(1, (MuxerWrapper)object, transformerMediaClock, transformation);
        this.decoderInputBuffer = object = new DecoderInputBuffer(0);
        this.encoderInputBuffer = object = new DecoderInputBuffer(0);
        this.sonicAudioProcessor = object = new SonicAudioProcessor();
        this.sonicOutputBuffer = object = AudioProcessor.EMPTY_BUFFER;
        this.nextEncoderInputBufferTimeUs = 0L;
        this.currentSpeed = -1.0f;
    }

    private ExoPlaybackException createRendererException(Throwable throwable) {
        int n10 = this.getIndex();
        Format format = this.inputFormat;
        return ExoPlaybackException.createForRenderer(throwable, TAG, n10, format, 4);
    }

    private boolean drainDecoderToFeedEncoder() {
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.decoder);
        Object object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.encoder);
        DecoderInputBuffer decoderInputBuffer = this.encoderInputBuffer;
        boolean bl2 = ((MediaCodecAdapterWrapper)object).maybeDequeueInputBuffer(decoderInputBuffer);
        decoderInputBuffer = null;
        if (!bl2) {
            return false;
        }
        bl2 = mediaCodecAdapterWrapper.isEnded();
        if (bl2) {
            this.queueEndOfStreamToEncoder();
            return false;
        }
        object = mediaCodecAdapterWrapper.getOutputBuffer();
        if (object == null) {
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo)Assertions.checkNotNull(mediaCodecAdapterWrapper.getOutputBufferInfo());
        boolean bl3 = this.isSpeedChanging(bufferInfo);
        if (bl3) {
            float f10 = this.currentSpeed;
            this.flushSonicAndSetSpeed(f10);
            return false;
        }
        this.feedEncoder((ByteBuffer)object);
        bl2 = ((Buffer)object).hasRemaining();
        if (!bl2) {
            mediaCodecAdapterWrapper.releaseOutputBuffer();
        }
        return true;
    }

    private boolean drainDecoderToFeedSonic() {
        Object object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.decoder);
        boolean bl2 = this.drainingSonicForSpeedChange;
        SonicAudioProcessor sonicAudioProcessor = null;
        if (bl2) {
            object = this.sonicAudioProcessor;
            boolean bl3 = ((SonicAudioProcessor)object).isEnded();
            if (bl3 && !(bl3 = ((Buffer)(object = this.sonicOutputBuffer)).hasRemaining())) {
                float f10 = this.currentSpeed;
                this.flushSonicAndSetSpeed(f10);
                this.drainingSonicForSpeedChange = false;
            }
            return false;
        }
        ByteBuffer byteBuffer = this.sonicOutputBuffer;
        bl2 = byteBuffer.hasRemaining();
        if (bl2) {
            return false;
        }
        bl2 = ((MediaCodecAdapterWrapper)object).isEnded();
        if (bl2) {
            this.sonicAudioProcessor.queueEndOfStream();
            return false;
        }
        bl2 = this.sonicAudioProcessor.isEnded();
        boolean bl4 = true;
        Assertions.checkState(bl2 ^= bl4);
        byteBuffer = ((MediaCodecAdapterWrapper)object).getOutputBuffer();
        if (byteBuffer == null) {
            return false;
        }
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo)Assertions.checkNotNull(((MediaCodecAdapterWrapper)object).getOutputBufferInfo());
        boolean bl5 = this.isSpeedChanging(bufferInfo);
        if (bl5) {
            this.sonicAudioProcessor.queueEndOfStream();
            this.drainingSonicForSpeedChange = bl4;
            return false;
        }
        sonicAudioProcessor = this.sonicAudioProcessor;
        sonicAudioProcessor.queueInput(byteBuffer);
        bl2 = byteBuffer.hasRemaining();
        if (!bl2) {
            ((MediaCodecAdapterWrapper)object).releaseOutputBuffer();
        }
        return bl4;
    }

    private boolean drainEncoderToFeedMuxer() {
        long l10;
        boolean bl2;
        MuxerWrapper muxerWrapper;
        Format format;
        Object object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.encoder);
        int n10 = this.hasEncoderOutputFormat;
        boolean bl3 = true;
        if (n10 == 0) {
            format = ((MediaCodecAdapterWrapper)object).getOutputFormat();
            if (format == null) {
                return false;
            }
            this.hasEncoderOutputFormat = bl3;
            muxerWrapper = this.muxerWrapper;
            muxerWrapper.addTrackFormat(format);
        }
        if ((n10 = ((MediaCodecAdapterWrapper)object).isEnded()) != 0) {
            object = this.muxerWrapper;
            n10 = this.getTrackType();
            ((MuxerWrapper)object).endTrack(n10);
            this.muxerWrapperTrackEnded = bl3;
            return false;
        }
        ByteBuffer byteBuffer = ((MediaCodecAdapterWrapper)object).getOutputBuffer();
        if (byteBuffer == null) {
            return false;
        }
        format = (MediaCodec.BufferInfo)Assertions.checkNotNull(((MediaCodecAdapterWrapper)object).getOutputBufferInfo());
        muxerWrapper = this.muxerWrapper;
        int n11 = this.getTrackType();
        n10 = (int)(muxerWrapper.writeSample(n11, byteBuffer, bl2 = true, l10 = ((MediaCodec.BufferInfo)format).presentationTimeUs) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        ((MediaCodecAdapterWrapper)object).releaseOutputBuffer();
        return bl3;
    }

    private boolean drainSonicToFeedEncoder() {
        Object object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.encoder);
        DecoderInputBuffer decoderInputBuffer = this.encoderInputBuffer;
        boolean bl2 = ((MediaCodecAdapterWrapper)object).maybeDequeueInputBuffer(decoderInputBuffer);
        decoderInputBuffer = null;
        if (!bl2) {
            return false;
        }
        object = this.sonicOutputBuffer;
        bl2 = ((Buffer)object).hasRemaining();
        if (!bl2) {
            this.sonicOutputBuffer = object = this.sonicAudioProcessor.getOutput();
            bl2 = ((Buffer)object).hasRemaining();
            if (!bl2) {
                object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.decoder);
                bl2 = ((MediaCodecAdapterWrapper)object).isEnded();
                if (bl2 && (bl2 = ((SonicAudioProcessor)(object = this.sonicAudioProcessor)).isEnded())) {
                    this.queueEndOfStreamToEncoder();
                }
                return false;
            }
        }
        object = this.sonicOutputBuffer;
        this.feedEncoder((ByteBuffer)object);
        return true;
    }

    private boolean ensureDecoderConfigured() {
        float f10;
        int n10;
        Object object;
        Object object2 = this.decoder;
        boolean bl2 = true;
        if (object2 != null) {
            return bl2;
        }
        object2 = this.getFormatHolder();
        int n11 = this.readSource((FormatHolder)object2, (DecoderInputBuffer)(object = this.decoderInputBuffer), bl2);
        if (n11 != (n10 = -5)) {
            return false;
        }
        this.inputFormat = object2 = (Format)Assertions.checkNotNull(((FormatHolder)object2).format);
        try {
            object2 = MediaCodecAdapterWrapper.createForAudioDecoding((Format)object2);
        }
        catch (IOException iOException) {
            throw this.createRendererException(iOException);
        }
        this.decoder = object2;
        object = this.inputFormat;
        this.speedProvider = object2 = new SegmentSpeedProvider((Format)object);
        this.currentSpeed = f10 = object2.getSpeed(0L);
        return bl2;
    }

    private boolean ensureEncoderAndAudioProcessingConfigured() {
        Object object;
        Object object2 = this.encoder;
        boolean bl2 = true;
        if (object2 != null) {
            return bl2;
        }
        object2 = ((MediaCodecAdapterWrapper)Assertions.checkNotNull(this.decoder)).getOutputFormat();
        if (object2 == null) {
            return false;
        }
        int n10 = ((Format)object2).sampleRate;
        int n11 = ((Format)object2).channelCount;
        int n12 = ((Format)object2).pcmEncoding;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat = new AudioProcessor$AudioFormat(n10, n11, n12);
        object2 = this.transformation;
        n12 = (int)(((Transformation)object2).flattenForSlowMotion ? 1 : 0);
        if (n12 != 0) {
            try {
                object2 = this.sonicAudioProcessor;
            }
            catch (AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException) {
                throw this.createRendererException(audioProcessor$UnhandledAudioFormatException);
            }
            audioProcessor$AudioFormat = ((SonicAudioProcessor)object2).configure(audioProcessor$AudioFormat);
            float f10 = this.currentSpeed;
            this.flushSonicAndSetSpeed(f10);
        }
        try {
            object2 = new Format$Builder();
            object = this.inputFormat;
        }
        catch (IOException iOException) {
            throw this.createRendererException(iOException);
        }
        object = Assertions.checkNotNull(object);
        object = (Format)object;
        object = ((Format)object).sampleMimeType;
        object2 = ((Format$Builder)object2).setSampleMimeType((String)object);
        n10 = audioProcessor$AudioFormat.sampleRate;
        object2 = ((Format$Builder)object2).setSampleRate(n10);
        n10 = audioProcessor$AudioFormat.channelCount;
        object2 = ((Format$Builder)object2).setChannelCount(n10);
        n10 = 131072;
        object2 = ((Format$Builder)object2).setAverageBitrate(n10);
        object2 = ((Format$Builder)object2).build();
        object2 = MediaCodecAdapterWrapper.createForAudioEncoding((Format)object2);
        this.encoder = object2;
        this.encoderInputAudioFormat = audioProcessor$AudioFormat;
        return bl2;
    }

    private boolean feedDecoderInputFromSource() {
        Object object = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.decoder);
        Object object2 = this.decoderInputBuffer;
        boolean n10 = ((MediaCodecAdapterWrapper)object).maybeDequeueInputBuffer((DecoderInputBuffer)object2);
        int n11 = 0;
        if (!n10) {
            return false;
        }
        this.decoderInputBuffer.clear();
        object2 = this.getFormatHolder();
        DecoderInputBuffer decoderInputBuffer = this.decoderInputBuffer;
        int n12 = this.readSource((FormatHolder)object2, decoderInputBuffer, false);
        int n13 = -5;
        if (n12 != n13) {
            n13 = -4;
            if (n12 != n13) {
                return false;
            }
            object2 = this.mediaClock;
            n11 = this.getTrackType();
            long l10 = this.decoderInputBuffer.timeUs;
            ((TransformerMediaClock)object2).updateTimeForTrackType(n11, l10);
            this.decoderInputBuffer.flip();
            object2 = this.decoderInputBuffer;
            ((MediaCodecAdapterWrapper)object).queueInputBuffer((DecoderInputBuffer)object2);
            return this.decoderInputBuffer.isEndOfStream() ^ true;
        }
        object = new IllegalStateException("Format changes are not supported.");
        throw object;
    }

    private void feedEncoder(ByteBuffer object) {
        long l10;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat = (AudioProcessor$AudioFormat)Assertions.checkNotNull(this.encoderInputAudioFormat);
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.encoder);
        ByteBuffer byteBuffer = (ByteBuffer)Assertions.checkNotNull(this.encoderInputBuffer.data);
        int n10 = ((Buffer)object).limit();
        int n11 = ((Buffer)object).position();
        int n12 = byteBuffer.capacity();
        n11 += n12;
        n11 = Math.min(n10, n11);
        ((ByteBuffer)object).limit(n11);
        byteBuffer.put((ByteBuffer)object);
        DecoderInputBuffer decoderInputBuffer = this.encoderInputBuffer;
        decoderInputBuffer.timeUs = l10 = this.nextEncoderInputBufferTimeUs;
        long l11 = byteBuffer.position();
        int n13 = audioProcessor$AudioFormat.bytesPerFrame;
        int n14 = audioProcessor$AudioFormat.sampleRate;
        l11 = TransformerAudioRenderer.getBufferDurationUs(l11, n13, n14);
        this.nextEncoderInputBufferTimeUs = l10 += l11;
        this.encoderInputBuffer.setFlags(0);
        this.encoderInputBuffer.flip();
        ((ByteBuffer)object).limit(n10);
        object = this.encoderInputBuffer;
        mediaCodecAdapterWrapper.queueInputBuffer((DecoderInputBuffer)object);
    }

    private void flushSonicAndSetSpeed(float f10) {
        this.sonicAudioProcessor.setSpeed(f10);
        this.sonicAudioProcessor.setPitch(f10);
        this.sonicAudioProcessor.flush();
    }

    private static long getBufferDurationUs(long l10, int n10, int n11) {
        long l11 = n10;
        l10 = l10 / l11 * 1000000L;
        long l12 = n11;
        return l10 / l12;
    }

    private boolean isSpeedChanging(MediaCodec.BufferInfo bufferInfo) {
        float f10;
        long l10;
        Object object = this.transformation;
        Object object2 = ((Transformation)object).flattenForSlowMotion;
        boolean bl2 = false;
        if (!object2) {
            return false;
        }
        object = (SpeedProvider)Assertions.checkNotNull(this.speedProvider);
        float f11 = object.getSpeed(l10 = bufferInfo.presentationTimeUs);
        float f12 = f11 - (f10 = this.currentSpeed);
        object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2) {
            bl2 = true;
        }
        this.currentSpeed = f11;
        return bl2;
    }

    private void queueEndOfStreamToEncoder() {
        MediaCodecAdapterWrapper mediaCodecAdapterWrapper = (MediaCodecAdapterWrapper)Assertions.checkNotNull(this.encoder);
        Object object = (ByteBuffer)Assertions.checkNotNull(this.encoderInputBuffer.data);
        int n10 = ((Buffer)object).position();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        Assertions.checkState(n10 != 0);
        this.encoderInputBuffer.addFlag(4);
        this.encoderInputBuffer.flip();
        object = this.encoderInputBuffer;
        mediaCodecAdapterWrapper.queueInputBuffer((DecoderInputBuffer)object);
    }

    public String getName() {
        return TAG;
    }

    public boolean isEnded() {
        return this.muxerWrapperTrackEnded;
    }

    public void onReset() {
        this.decoderInputBuffer.clear();
        this.decoderInputBuffer.data = null;
        this.encoderInputBuffer.clear();
        this.encoderInputBuffer.data = null;
        this.sonicAudioProcessor.reset();
        Object object = this.decoder;
        if (object != null) {
            ((MediaCodecAdapterWrapper)object).release();
            this.decoder = null;
        }
        if ((object = this.encoder) != null) {
            ((MediaCodecAdapterWrapper)object).release();
            this.encoder = null;
        }
        this.speedProvider = null;
        this.inputFormat = null;
        this.encoderInputAudioFormat = null;
        this.sonicOutputBuffer = object = AudioProcessor.EMPTY_BUFFER;
        this.nextEncoderInputBufferTimeUs = 0L;
        this.currentSpeed = -1.0f;
        this.muxerWrapperTrackEnded = false;
        this.hasEncoderOutputFormat = false;
        this.drainingSonicForSpeedChange = false;
    }

    public void render(long l10, long l11) {
        boolean bl2 = this.isRendererStarted;
        if (bl2 && !(bl2 = this.isEnded()) && (bl2 = this.ensureDecoderConfigured())) {
            bl2 = this.ensureEncoderAndAudioProcessingConfigured();
            if (bl2) {
                while (bl2 = this.drainEncoderToFeedMuxer()) {
                }
                SonicAudioProcessor sonicAudioProcessor = this.sonicAudioProcessor;
                bl2 = sonicAudioProcessor.isActive();
                if (bl2) {
                    while (bl2 = this.drainSonicToFeedEncoder()) {
                    }
                    while (bl2 = this.drainDecoderToFeedSonic()) {
                    }
                } else {
                    while (bl2 = this.drainDecoderToFeedEncoder()) {
                    }
                }
            }
            while (bl2 = this.feedDecoderInputFromSource()) {
            }
        }
    }
}

