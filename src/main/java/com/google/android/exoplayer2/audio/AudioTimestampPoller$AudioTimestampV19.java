/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTimestamp
 *  android.media.AudioTrack
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

public final class AudioTimestampPoller$AudioTimestampV19 {
    private final AudioTimestamp audioTimestamp;
    private final AudioTrack audioTrack;
    private long lastTimestampPositionFrames;
    private long lastTimestampRawPositionFrames;
    private long rawTimestampFramePositionWrapCount;

    public AudioTimestampPoller$AudioTimestampV19(AudioTrack audioTrack) {
        this.audioTrack = audioTrack;
        this.audioTimestamp = audioTrack;
    }

    public long getTimestampPositionFrames() {
        return this.lastTimestampPositionFrames;
    }

    public long getTimestampSystemTimeUs() {
        return this.audioTimestamp.nanoTime / 1000L;
    }

    public boolean maybeUpdateTimestamp() {
        AudioTrack audioTrack = this.audioTrack;
        AudioTimestamp audioTimestamp = this.audioTimestamp;
        boolean bl2 = audioTrack.getTimestamp(audioTimestamp);
        if (bl2) {
            audioTimestamp = this.audioTimestamp;
            long l10 = this.lastTimestampRawPositionFrames;
            long l11 = audioTimestamp.framePosition;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object > 0) {
                l10 = this.rawTimestampFramePositionWrapCount;
                long l13 = 1L;
                this.rawTimestampFramePositionWrapCount = l10 += l13;
            }
            this.lastTimestampRawPositionFrames = l11;
            l10 = this.rawTimestampFramePositionWrapCount;
            int n10 = 32;
            this.lastTimestampPositionFrames = l11 += (l10 <<= n10);
        }
        return bl2;
    }
}

