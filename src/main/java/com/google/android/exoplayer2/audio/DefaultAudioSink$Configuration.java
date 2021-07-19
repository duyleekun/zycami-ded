/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.AudioFormat
 *  android.media.AudioTrack
 *  android.media.AudioTrack$Builder
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink$InitializationException;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class DefaultAudioSink$Configuration {
    public final AudioProcessor[] availableAudioProcessors;
    public final int bufferSize;
    public final Format inputFormat;
    public final int inputPcmFrameSize;
    public final int outputChannelConfig;
    public final int outputEncoding;
    public final int outputMode;
    public final int outputPcmFrameSize;
    public final int outputSampleRate;

    public DefaultAudioSink$Configuration(Format format, int n10, int n11, int n12, int n13, int n14, int n15, int n16, boolean bl2, AudioProcessor[] audioProcessorArray) {
        int n17;
        this.inputFormat = format;
        this.inputPcmFrameSize = n10;
        this.outputMode = n11;
        this.outputPcmFrameSize = n12;
        this.outputSampleRate = n13;
        this.outputChannelConfig = n14;
        this.outputEncoding = n15;
        this.availableAudioProcessors = audioProcessorArray;
        this.bufferSize = n17 = this.computeBufferSize(n16, bl2);
    }

    private int computeBufferSize(int n10, boolean n11) {
        float f10;
        if (n10 != 0) {
            return n10;
        }
        n10 = this.outputMode;
        if (n10 != 0) {
            n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    return this.getEncodedDefaultBufferSize(250000L);
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                throw illegalStateException;
            }
            return this.getEncodedDefaultBufferSize(50000000L);
        }
        if (n11 != 0) {
            n10 = 0x41000000;
            f10 = 8.0f;
        } else {
            n10 = 1065353216;
            f10 = 1.0f;
        }
        return this.getPcmDefaultBufferSize(f10);
    }

    private AudioTrack createAudioTrack(boolean bl2, AudioAttributes audioAttributes, int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            return this.createAudioTrackV29(bl2, audioAttributes, n10);
        }
        n12 = 21;
        if (n11 >= n12) {
            return this.createAudioTrackV21(bl2, audioAttributes, n10);
        }
        return this.createAudioTrackV9(audioAttributes, n10);
    }

    /*
     * WARNING - void declaration
     */
    private AudioTrack createAudioTrackV21(boolean bl2, AudioAttributes audioAttributes, int n10) {
        void var3_4;
        void var2_3;
        android.media.AudioAttributes audioAttributes2 = DefaultAudioSink$Configuration.getAudioTrackAttributesV21((AudioAttributes)var2_3, bl2);
        int n11 = this.outputSampleRate;
        int n12 = this.outputChannelConfig;
        int n13 = this.outputEncoding;
        AudioFormat audioFormat = DefaultAudioSink.access$1000(n11, n12, n13);
        int n14 = this.bufferSize;
        AudioTrack audioTrack = new AudioTrack(audioAttributes2, audioFormat, n14, 1, (int)var3_4);
        return audioTrack;
    }

    private AudioTrack createAudioTrackV29(boolean bl2, AudioAttributes audioAttributes, int n10) {
        int n11 = this.outputSampleRate;
        int n12 = this.outputChannelConfig;
        int n13 = this.outputEncoding;
        AudioFormat audioFormat = DefaultAudioSink.access$1000(n11, n12, n13);
        android.media.AudioAttributes audioAttributes2 = DefaultAudioSink$Configuration.getAudioTrackAttributesV21(audioAttributes, bl2);
        audioAttributes = new AudioTrack.Builder();
        audioAttributes2 = audioAttributes.setAudioAttributes(audioAttributes2).setAudioFormat(audioFormat);
        int n14 = 1;
        audioAttributes2 = audioAttributes2.setTransferMode(n14);
        n11 = this.bufferSize;
        audioAttributes2 = audioAttributes2.setBufferSizeInBytes(n11).setSessionId(n10);
        n10 = this.outputMode;
        if (n10 != n14) {
            n14 = 0;
            audioAttributes = null;
        }
        return audioAttributes2.setOffloadedPlayback(n14 != 0).build();
    }

    private AudioTrack createAudioTrackV9(AudioAttributes audioAttributes, int n10) {
        int n11 = audioAttributes.usage;
        int n12 = Util.getStreamTypeForAudioUsage(n11);
        if (n10 == 0) {
            int n13 = this.outputSampleRate;
            int n14 = this.outputChannelConfig;
            int n15 = this.outputEncoding;
            int n16 = this.bufferSize;
            audioAttributes = new AudioTrack(n12, n13, n14, n15, n16, 1);
            return audioAttributes;
        }
        int n17 = this.outputSampleRate;
        int n18 = this.outputChannelConfig;
        int n19 = this.outputEncoding;
        int n20 = this.bufferSize;
        audioAttributes = new AudioTrack(n12, n17, n18, n19, n20, 1, n10);
        return audioAttributes;
    }

    private static android.media.AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean bl2) {
        if (bl2) {
            return DefaultAudioSink$Configuration.getAudioTrackTunnelingAttributesV21();
        }
        return audioAttributes.getAudioAttributesV21();
    }

    private static android.media.AudioAttributes getAudioTrackTunnelingAttributesV21() {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        return builder.setContentType(3).setFlags(16).setUsage(1).build();
    }

    private int getEncodedDefaultBufferSize(long l10) {
        int n10 = DefaultAudioSink.access$1100(this.outputEncoding);
        int n11 = this.outputEncoding;
        int n12 = 5;
        if (n11 == n12) {
            n10 *= 2;
        }
        long l11 = n10;
        return (int)(l10 * l11 / 1000000L);
    }

    private int getPcmDefaultBufferSize(float f10) {
        int n10 = this.outputSampleRate;
        int n11 = this.outputChannelConfig;
        int n12 = this.outputEncoding;
        n10 = AudioTrack.getMinBufferSize((int)n10, (int)n11, (int)n12);
        n11 = -2;
        float f11 = 0.0f / 0.0f;
        if (n10 != n11) {
            n11 = 1;
            f11 = Float.MIN_VALUE;
        } else {
            n11 = 0;
            f11 = 0.0f;
        }
        Assertions.checkState(n11 != 0);
        n11 = n10 * 4;
        long l10 = this.durationUsToFrames(250000L);
        n12 = (int)l10;
        int n13 = this.outputPcmFrameSize;
        n12 *= n13;
        long l11 = this.durationUsToFrames(750000L);
        n13 = (int)l11;
        int n14 = this.outputPcmFrameSize;
        n10 = Math.max(n10, n13 *= n14);
        n10 = Util.constrainValue(n11, n12, n10);
        f11 = 1.0f;
        n11 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
        if (n11 != 0) {
            float f12 = (float)n10 * f10;
            n10 = Math.round(f12);
        }
        return n10;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AudioTrack buildAudioTrack(boolean bl2, AudioAttributes audioAttributes, int n10) {
        int n11;
        block6: {
            void var4_8;
            AudioTrack audioTrack = this.createAudioTrack(bl2, audioAttributes, n10);
            n11 = audioTrack.getState();
            int n12 = 1;
            if (n11 == n12) {
                return audioTrack;
            }
            try {
                audioTrack.release();
                break block6;
            }
            catch (Exception exception) {}
            catch (IllegalArgumentException illegalArgumentException) {
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
            void var12_22 = var4_8;
            int n13 = this.outputSampleRate;
            int n14 = this.outputChannelConfig;
            int n15 = this.bufferSize;
            Format format = this.inputFormat;
            boolean bl3 = this.outputModeIsOffload();
            AudioSink$InitializationException audioSink$InitializationException = new AudioSink$InitializationException(0, n13, n14, n15, format, bl3, (Exception)var12_22);
            throw audioSink$InitializationException;
        }
        int n16 = this.outputSampleRate;
        int n17 = this.outputChannelConfig;
        int n18 = this.bufferSize;
        Format format = this.inputFormat;
        boolean bl4 = this.outputModeIsOffload();
        AudioSink$InitializationException audioSink$InitializationException = new AudioSink$InitializationException(n11, n16, n17, n18, format, bl4, null);
        throw audioSink$InitializationException;
    }

    public boolean canReuseAudioTrack(DefaultAudioSink$Configuration defaultAudioSink$Configuration) {
        int n10;
        int n11 = defaultAudioSink$Configuration.outputMode;
        int n12 = this.outputMode;
        if (n11 == n12 && (n11 = defaultAudioSink$Configuration.outputEncoding) == (n12 = this.outputEncoding) && (n11 = defaultAudioSink$Configuration.outputSampleRate) == (n12 = this.outputSampleRate) && (n11 = defaultAudioSink$Configuration.outputChannelConfig) == (n12 = this.outputChannelConfig) && (n10 = defaultAudioSink$Configuration.outputPcmFrameSize) == (n11 = this.outputPcmFrameSize)) {
            n10 = 1;
        } else {
            n10 = 0;
            defaultAudioSink$Configuration = null;
        }
        return n10 != 0;
    }

    public long durationUsToFrames(long l10) {
        long l11 = this.outputSampleRate;
        return l10 * l11 / 1000000L;
    }

    public long framesToDurationUs(long l10) {
        long l11 = this.outputSampleRate;
        return (l10 *= 1000000L) / l11;
    }

    public long inputFramesToDurationUs(long l10) {
        long l11 = this.inputFormat.sampleRate;
        return (l10 *= 1000000L) / l11;
    }

    public boolean outputModeIsOffload() {
        int n10 = this.outputMode;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

