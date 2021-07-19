/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.DefaultAudioSink$AudioProcessorChain;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.android.exoplayer2.audio.SonicAudioProcessor;

public class DefaultAudioSink$DefaultAudioProcessorChain
implements DefaultAudioSink$AudioProcessorChain {
    private final AudioProcessor[] audioProcessors;
    private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
    private final SonicAudioProcessor sonicAudioProcessor;

    public DefaultAudioSink$DefaultAudioProcessorChain(AudioProcessor ... audioProcessorArray) {
        SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
        SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
        this(audioProcessorArray, silenceSkippingAudioProcessor, sonicAudioProcessor);
    }

    public DefaultAudioSink$DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArray, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
        AudioProcessor[] audioProcessorArray2 = new AudioProcessor[audioProcessorArray.length + 2];
        this.audioProcessors = audioProcessorArray2;
        int n10 = audioProcessorArray.length;
        System.arraycopy(audioProcessorArray, 0, audioProcessorArray2, 0, n10);
        this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor;
        this.sonicAudioProcessor = sonicAudioProcessor;
        n10 = audioProcessorArray.length;
        audioProcessorArray2[n10] = silenceSkippingAudioProcessor;
        int n11 = audioProcessorArray.length + 1;
        audioProcessorArray2[n11] = sonicAudioProcessor;
    }

    public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
        SonicAudioProcessor sonicAudioProcessor = this.sonicAudioProcessor;
        float f10 = playbackParameters.speed;
        sonicAudioProcessor.setSpeed(f10);
        sonicAudioProcessor = this.sonicAudioProcessor;
        f10 = playbackParameters.pitch;
        sonicAudioProcessor.setPitch(f10);
        return playbackParameters;
    }

    public boolean applySkipSilenceEnabled(boolean bl2) {
        this.silenceSkippingAudioProcessor.setEnabled(bl2);
        return bl2;
    }

    public AudioProcessor[] getAudioProcessors() {
        return this.audioProcessors;
    }

    public long getMediaDuration(long l10) {
        return this.sonicAudioProcessor.getMediaDuration(l10);
    }

    public long getSkippedOutputFrameCount() {
        return this.silenceSkippingAudioProcessor.getSkippedFrames();
    }
}

