/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.AudioTimestampPoller$AudioTimestampV19;
import com.google.android.exoplayer2.util.Util;

public final class AudioTimestampPoller {
    private static final int ERROR_POLL_INTERVAL_US = 500000;
    private static final int FAST_POLL_INTERVAL_US = 10000;
    private static final int INITIALIZING_DURATION_US = 500000;
    private static final int SLOW_POLL_INTERVAL_US = 10000000;
    private static final int STATE_ERROR = 4;
    private static final int STATE_INITIALIZING = 0;
    private static final int STATE_NO_TIMESTAMP = 3;
    private static final int STATE_TIMESTAMP = 1;
    private static final int STATE_TIMESTAMP_ADVANCING = 2;
    private final AudioTimestampPoller$AudioTimestampV19 audioTimestamp;
    private long initialTimestampPositionFrames;
    private long initializeSystemTimeUs;
    private long lastTimestampSampleTimeUs;
    private long sampleIntervalUs;
    private int state;

    public AudioTimestampPoller(AudioTrack audioTrack) {
        int n10 = Util.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19;
            this.audioTimestamp = audioTimestampPoller$AudioTimestampV19 = new AudioTimestampPoller$AudioTimestampV19(audioTrack);
            this.reset();
        } else {
            audioTrack = null;
            this.audioTimestamp = null;
            int n12 = 3;
            this.updateState(n12);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateState(int n10) {
        this.state = n10;
        long l10 = 10000L;
        if (n10 == 0) {
            this.lastTimestampSampleTimeUs = 0L;
            this.initialTimestampPositionFrames = -1;
            long l11 = System.nanoTime();
            long l12 = 1000L;
            this.initializeSystemTimeUs = l11 /= l12;
            this.sampleIntervalUs = l10;
            return;
        }
        int n11 = 1;
        if (n10 == n11) {
            this.sampleIntervalUs = l10;
            return;
        }
        int n12 = 2;
        if (n10 != n12 && n10 != (n12 = 3)) {
            n12 = 4;
            if (n10 == n12) {
                this.sampleIntervalUs = l10 = 500000L;
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        this.sampleIntervalUs = l10 = 10000000L;
    }

    public void acceptTimestamp() {
        int n10 = this.state;
        int n11 = 4;
        if (n10 == n11) {
            this.reset();
        }
    }

    public long getTimestampPositionFrames() {
        AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
        long l10 = audioTimestampPoller$AudioTimestampV19 != null ? audioTimestampPoller$AudioTimestampV19.getTimestampPositionFrames() : (long)-1;
        return l10;
    }

    public long getTimestampSystemTimeUs() {
        AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
        long l10 = audioTimestampPoller$AudioTimestampV19 != null ? audioTimestampPoller$AudioTimestampV19.getTimestampSystemTimeUs() : -9223372036854775807L;
        return l10;
    }

    public boolean hasAdvancingTimestamp() {
        int n10 = this.state;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean hasTimestamp() {
        int n10;
        int n11 = this.state;
        int n12 = 1;
        if (n11 != n12 && n11 != (n10 = 2)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public boolean maybePollTimestamp(long l10) {
        boolean bl2;
        block13: {
            boolean bl3;
            block15: {
                int n10;
                block16: {
                    int n11;
                    long l11;
                    block14: {
                        AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
                        bl2 = false;
                        if (audioTimestampPoller$AudioTimestampV19 == null) break block13;
                        l11 = this.lastTimestampSampleTimeUs;
                        long l12 = this.sampleIntervalUs;
                        long l13 = (l11 = l10 - l11) - l12;
                        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                        if (object < 0) break block13;
                        this.lastTimestampSampleTimeUs = l10;
                        bl3 = audioTimestampPoller$AudioTimestampV19.maybeUpdateTimestamp();
                        object = this.state;
                        n10 = 3;
                        n11 = 1;
                        if (object == false) break block14;
                        int n12 = 2;
                        if (object != n11) {
                            if (object != n12) {
                                if (object != n10) {
                                    n12 = 4;
                                    if (object != n12) {
                                        IllegalStateException illegalStateException = new IllegalStateException();
                                        throw illegalStateException;
                                    }
                                } else if (bl3) {
                                    this.reset();
                                }
                            } else if (!bl3) {
                                this.reset();
                            }
                        } else if (bl3) {
                            long l14;
                            AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV192 = this.audioTimestamp;
                            long l15 = audioTimestampPoller$AudioTimestampV192.getTimestampPositionFrames();
                            long l16 = l15 - (l14 = this.initialTimestampPositionFrames);
                            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                            if (object2 > 0) {
                                this.updateState(n12);
                            }
                        } else {
                            this.reset();
                        }
                        break block15;
                    }
                    if (!bl3) break block16;
                    AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
                    l10 = audioTimestampPoller$AudioTimestampV19.getTimestampSystemTimeUs();
                    long l17 = l10 - (l11 = this.initializeSystemTimeUs);
                    Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (object < 0) break block13;
                    audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
                    this.initialTimestampPositionFrames = l10 = audioTimestampPoller$AudioTimestampV19.getTimestampPositionFrames();
                    this.updateState(n11);
                    break block15;
                }
                long l18 = this.initializeSystemTimeUs;
                long l19 = (l10 -= l18) - (l18 = 500000L);
                Object object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object > 0) {
                    this.updateState(n10);
                }
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public void rejectTimestamp() {
        this.updateState(4);
    }

    public void reset() {
        AudioTimestampPoller$AudioTimestampV19 audioTimestampPoller$AudioTimestampV19 = this.audioTimestamp;
        if (audioTimestampPoller$AudioTimestampV19 != null) {
            audioTimestampPoller$AudioTimestampV19 = null;
            this.updateState(0);
        }
    }
}

