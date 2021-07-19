/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import java.nio.ByteBuffer;

public class ForwardingAudioSink
implements AudioSink {
    private final AudioSink sink;

    public ForwardingAudioSink(AudioSink audioSink) {
        this.sink = audioSink;
    }

    public void configure(Format format, int n10, int[] nArray) {
        this.sink.configure(format, n10, nArray);
    }

    public void disableTunneling() {
        this.sink.disableTunneling();
    }

    public void enableTunnelingV21() {
        this.sink.enableTunnelingV21();
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        this.sink.experimentalFlushWithoutAudioTrackRelease();
    }

    public void flush() {
        this.sink.flush();
    }

    public long getCurrentPositionUs(boolean bl2) {
        return this.sink.getCurrentPositionUs(bl2);
    }

    public int getFormatSupport(Format format) {
        return this.sink.getFormatSupport(format);
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.sink.getPlaybackParameters();
    }

    public boolean getSkipSilenceEnabled() {
        return this.sink.getSkipSilenceEnabled();
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long l10, int n10) {
        return this.sink.handleBuffer(byteBuffer, l10, n10);
    }

    public void handleDiscontinuity() {
        this.sink.handleDiscontinuity();
    }

    public boolean hasPendingData() {
        return this.sink.hasPendingData();
    }

    public boolean isEnded() {
        return this.sink.isEnded();
    }

    public void pause() {
        this.sink.pause();
    }

    public void play() {
        this.sink.play();
    }

    public void playToEndOfStream() {
        this.sink.playToEndOfStream();
    }

    public void reset() {
        this.sink.reset();
    }

    public void setAudioAttributes(AudioAttributes audioAttributes) {
        this.sink.setAudioAttributes(audioAttributes);
    }

    public void setAudioSessionId(int n10) {
        this.sink.setAudioSessionId(n10);
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        this.sink.setAuxEffectInfo(auxEffectInfo);
    }

    public void setListener(AudioSink$Listener audioSink$Listener) {
        this.sink.setListener(audioSink$Listener);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.sink.setPlaybackParameters(playbackParameters);
    }

    public void setSkipSilenceEnabled(boolean bl2) {
        this.sink.setSkipSilenceEnabled(bl2);
    }

    public void setVolume(float f10) {
        this.sink.setVolume(f10);
    }

    public boolean supportsFormat(Format format) {
        return this.sink.supportsFormat(format);
    }
}

