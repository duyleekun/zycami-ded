/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AudioTimestampPoller;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Method;

public final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200L;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000L;
    private static final long MAX_LATENCY_US = 5000000L;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final long MODE_SWITCH_SMOOTHING_DURATION_US = 1000000L;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private float audioTrackPlaybackSpeed;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastPositionUs;
    private long lastRawPlaybackHeadPosition;
    private boolean lastSampleUsedGetTimestampMode;
    private long lastSystemTimeUs;
    private long latencyUs;
    private final AudioTrackPositionTracker$Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private boolean notifiedPositionIncreasing;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long previousModePositionUs;
    private long previousModeSystemTimeUs;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AudioTrackPositionTracker(AudioTrackPositionTracker$Listener object) {
        this.listener = object = (AudioTrackPositionTracker$Listener)Assertions.checkNotNull(object);
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            object = AudioTrack.class;
            String string2 = "getLatency";
            try {
                this.getLatencyMethod = object = ((Class)object).getMethod(string2, null);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }
        object = new long[10];
        this.playheadOffsets = (long[])object;
    }

    private boolean forceHasPendingData() {
        long l10;
        long l11;
        long l12;
        int n10;
        AudioTrack audioTrack;
        int n11 = this.needsPassthroughWorkarounds;
        if (n11 != 0 && (n11 = (audioTrack = (AudioTrack)Assertions.checkNotNull(this.audioTrack)).getPlayState()) == (n10 = 2) && (n11 = (int)((l12 = (l11 = this.getPlaybackHeadPosition()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            n11 = 1;
        } else {
            n11 = 0;
            audioTrack = null;
        }
        return n11 != 0;
    }

    private long framesToDurationUs(long l10) {
        long l11 = this.outputSampleRate;
        return (l10 *= 1000000L) / l11;
    }

    private long getPlaybackHeadPosition() {
        long l10;
        long l11;
        AudioTrack audioTrack = (AudioTrack)Assertions.checkNotNull(this.audioTrack);
        long l12 = this.stopTimestampUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            long l15 = SystemClock.elapsedRealtime() * 1000L;
            long l16 = this.stopTimestampUs;
            l15 -= l16;
            l16 = this.outputSampleRate;
            l15 = l15 * l16 / 1000000L;
            l16 = this.endPlaybackHeadPosition;
            long l17 = this.stopPlaybackHeadPosition + l15;
            return Math.min(l16, l17);
        }
        object = audioTrack.getPlayState();
        int n10 = 1;
        long l18 = 0L;
        if (object == n10) {
            return l18;
        }
        long l19 = audioTrack.getPlaybackHeadPosition();
        long l20 = 0xFFFFFFFFL & l19;
        int n11 = this.needsPassthroughWorkarounds;
        if (n11 != 0) {
            n11 = 2;
            if (object == n11 && (n11 = (int)(l20 == l18 ? 0 : (l20 < l18 ? -1 : 1))) == 0) {
                this.passthroughWorkaroundPauseOffset = l19 = this.lastRawPlaybackHeadPosition;
            }
            l19 = this.passthroughWorkaroundPauseOffset;
            l20 += l19;
        }
        if ((n11 = Util.SDK_INT) <= (n10 = 29)) {
            long l21;
            n11 = (int)(l20 == l18 ? 0 : (l20 < l18 ? -1 : 1));
            if (n11 == 0 && (n11 = (int)((l21 = (l19 = this.lastRawPlaybackHeadPosition) - l18) == 0L ? 0 : (l21 < 0L ? -1 : 1))) > 0 && object == (n11 = 3)) {
                long l22 = this.forceResetWorkaroundTimeMs;
                long l23 = l22 - l13;
                n11 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
                if (n11 == 0) {
                    this.forceResetWorkaroundTimeMs = l22 = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = l13;
        }
        if ((n11 = (int)((l11 = (l10 = this.lastRawPlaybackHeadPosition) - l20) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) {
            l10 = this.rawPlaybackHeadWrapCount;
            long l24 = 1L;
            this.rawPlaybackHeadWrapCount = l10 += l24;
        }
        this.lastRawPlaybackHeadPosition = l20;
        l10 = this.rawPlaybackHeadWrapCount << 32;
        return l20 + l10;
    }

    private long getPlaybackHeadPositionUs() {
        long l10 = this.getPlaybackHeadPosition();
        return this.framesToDurationUs(l10);
    }

    private void maybePollAndCheckTimestamp(long l10, long l11) {
        long l12;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller);
        Object object = audioTimestampPoller.maybePollTimestamp(l10);
        if (object == 0) {
            return;
        }
        long l13 = audioTimestampPoller.getTimestampSystemTimeUs();
        long l14 = audioTimestampPoller.getTimestampPositionFrames();
        long l15 = Math.abs(l13 - l10);
        long l16 = l15 - (l12 = 5000000L);
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object > 0) {
            AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = this.listener;
            l12 = l10;
            audioTrackPositionTracker$Listener.onSystemTimeUsMismatch(l14, l13, l10, l11);
            audioTimestampPoller.rejectTimestamp();
        } else {
            l15 = Math.abs(this.framesToDurationUs(l14) - l11);
            long l17 = l15 - l12;
            object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object > 0) {
                AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = this.listener;
                l12 = l10;
                audioTrackPositionTracker$Listener.onPositionFramesMismatch(l14, l13, l10, l11);
                audioTimestampPoller.rejectTimestamp();
            } else {
                audioTimestampPoller.acceptTimestamp();
            }
        }
    }

    private void maybeSampleSyncParams() {
        int n10;
        long l10;
        long l11 = this.getPlaybackHeadPositionUs();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        long l13 = System.nanoTime() / 1000L;
        long l14 = this.lastPlayheadSampleTimeUs;
        long l15 = 30000L;
        long l16 = (l14 = l13 - l14) - l15;
        Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 >= 0) {
            int n11;
            long[] lArray = this.playheadOffsets;
            int n12 = this.nextPlayheadOffsetIndex;
            lArray[n12] = l15 = l11 - l13;
            ++n12;
            object2 = 10;
            this.nextPlayheadOffsetIndex = n12 %= object2;
            n12 = this.playheadOffsetCount;
            if (n12 < object2) {
                this.playheadOffsetCount = ++n12;
            }
            this.lastPlayheadSampleTimeUs = l13;
            this.smoothedPlayheadOffsetUs = l10;
            for (n10 = 0; n10 < (n11 = this.playheadOffsetCount); ++n10) {
                l14 = this.smoothedPlayheadOffsetUs;
                long[] lArray2 = this.playheadOffsets;
                long l17 = lArray2[n10];
                long l18 = n11;
                this.smoothedPlayheadOffsetUs = l14 += (l17 /= l18);
            }
        }
        if ((n10 = this.needsPassthroughWorkarounds) != 0) {
            return;
        }
        this.maybePollAndCheckTimestamp(l13, l11);
        this.maybeUpdateLatency(l13);
    }

    private void maybeUpdateLatency(long l10) {
        Object object;
        int n10 = this.isOutputPcm;
        if (n10 != 0 && (object = this.getLatencyMethod) != null) {
            long l11 = this.lastLatencySampleTimeUs;
            long l12 = 500000L;
            long l13 = (l11 = l10 - l11) - l12;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0) {
                block18: {
                    Object object3 = this.audioTrack;
                    object3 = Assertions.checkNotNull(object3);
                    Object[] objectArray = null;
                    objectArray = new Object[]{};
                    object = ((Method)object).invoke(object3, objectArray);
                    object = (Integer)object;
                    object = Util.castNonNull(object);
                    object = (Integer)object;
                    n10 = (Integer)object;
                    long l14 = n10;
                    long l15 = 1000L;
                    l14 *= l15;
                    l15 = this.bufferSizeUs;
                    l14 -= l15;
                    this.latencyUs = l14;
                    l15 = 0L;
                    l14 = Math.max(l14, l15);
                    this.latencyUs = l14;
                    long l16 = 5000000L;
                    long l17 = l14 == l16 ? 0 : (l14 < l16 ? -1 : 1);
                    if (l17 <= 0) break block18;
                    AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = this.listener;
                    audioTrackPositionTracker$Listener.onInvalidLatency(l14);
                    try {
                        this.latencyUs = l15;
                    }
                    catch (Exception exception) {
                        n10 = 0;
                        object = null;
                        this.getLatencyMethod = null;
                    }
                }
                this.lastLatencySampleTimeUs = l10;
            }
        }
    }

    private static boolean needsPassthroughWorkarounds(int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 23;
        n10 = n11 < n12 && (n10 == (n11 = 5) || n10 == (n11 = 6)) ? 1 : 0;
        return n10 != 0;
    }

    private void resetSyncParams() {
        long l10;
        this.smoothedPlayheadOffsetUs = l10 = 0L;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = l10;
        this.lastSystemTimeUs = l10;
        this.previousModeSystemTimeUs = l10;
        this.notifiedPositionIncreasing = false;
    }

    public int getAvailableBufferSize(long l10) {
        long l11 = this.getPlaybackHeadPosition();
        long l12 = this.outputPcmFrameSize;
        int n10 = (int)(l10 - (l11 *= l12));
        return this.bufferSize - n10;
    }

    public long getCurrentPositionUs(boolean bl2) {
        long l10;
        boolean bl3;
        long l11;
        int n10;
        float f10;
        long l12;
        long l13;
        int n11;
        AudioTrackPositionTracker audioTrackPositionTracker = this;
        AudioTrack audioTrack = (AudioTrack)Assertions.checkNotNull(this.audioTrack);
        int n12 = audioTrack.getPlayState();
        if (n12 == (n11 = 3)) {
            this.maybeSampleSyncParams();
        }
        long l14 = System.nanoTime();
        long l15 = 1000L;
        l14 /= l15;
        AudioTimestampPoller audioTimestampPoller = (AudioTimestampPoller)Assertions.checkNotNull(audioTrackPositionTracker.audioTimestampPoller);
        int n13 = audioTimestampPoller.hasAdvancingTimestamp();
        if (n13 != 0) {
            l13 = audioTimestampPoller.getTimestampPositionFrames();
            l13 = audioTrackPositionTracker.framesToDurationUs(l13);
            l12 = audioTimestampPoller.getTimestampSystemTimeUs();
            l12 = l14 - l12;
            f10 = audioTrackPositionTracker.audioTrackPlaybackSpeed;
            l12 = Util.getMediaDurationForPlayoutDuration(l12, f10);
            l13 += l12;
        } else {
            n10 = audioTrackPositionTracker.playheadOffsetCount;
            l13 = n10 == 0 ? this.getPlaybackHeadPositionUs() : audioTrackPositionTracker.smoothedPlayheadOffsetUs + l14;
            if (!bl2) {
                l12 = 0L;
                l11 = audioTrackPositionTracker.latencyUs;
                l13 -= l11;
                l13 = Math.max(l12, l13);
            }
        }
        n10 = (int)(audioTrackPositionTracker.lastSampleUsedGetTimestampMode ? 1 : 0);
        if (n10 != n13) {
            audioTrackPositionTracker.previousModeSystemTimeUs = l12 = audioTrackPositionTracker.lastSystemTimeUs;
            audioTrackPositionTracker.previousModePositionUs = l12 = audioTrackPositionTracker.lastPositionUs;
        }
        l12 = audioTrackPositionTracker.previousModeSystemTimeUs;
        l11 = 1000000L;
        long l16 = (l12 = l14 - l12) - l11;
        n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
        if (n10 < 0) {
            long l17 = audioTrackPositionTracker.previousModePositionUs;
            f10 = audioTrackPositionTracker.audioTrackPlaybackSpeed;
            long l18 = Util.getMediaDurationForPlayoutDuration(l12, f10);
            l12 = l12 * l15 / l11;
            l13 *= l12;
            l12 = (l15 - l12) * (l17 += l18);
            l13 = (l13 + l12) / l15;
        }
        if (!(bl3 = audioTrackPositionTracker.notifiedPositionIncreasing) && (n10 = (int)((l10 = l13 - (l15 = audioTrackPositionTracker.lastPositionUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            n10 = 1;
            audioTrackPositionTracker.notifiedPositionIncreasing = n10;
            l15 = C.usToMs(l13 - l15);
            f10 = audioTrackPositionTracker.audioTrackPlaybackSpeed;
            l15 = Util.getPlayoutDurationForMediaDuration(l15, f10);
            l12 = System.currentTimeMillis();
            l15 = C.usToMs(l15);
            AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = audioTrackPositionTracker.listener;
            audioTrackPositionTracker$Listener.onPositionAdvancing(l12 -= l15);
        }
        audioTrackPositionTracker.lastSystemTimeUs = l14;
        audioTrackPositionTracker.lastPositionUs = l13;
        audioTrackPositionTracker.lastSampleUsedGetTimestampMode = n13;
        return l13;
    }

    public long getPendingBufferDurationMs(long l10) {
        long l11 = this.getPlaybackHeadPosition();
        return C.usToMs(this.framesToDurationUs(l10 -= l11));
    }

    public void handleEndOfStream(long l10) {
        long l11;
        this.stopPlaybackHeadPosition = l11 = this.getPlaybackHeadPosition();
        this.stopTimestampUs = l11 = SystemClock.elapsedRealtime() * 1000L;
        this.endPlaybackHeadPosition = l10;
    }

    public boolean hasPendingData(long l10) {
        long l11 = this.getPlaybackHeadPosition();
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 && (object = (Object)this.forceHasPendingData()) == false ? (Object)0 : (Object)1;
        return (boolean)object;
    }

    public boolean isPlaying() {
        int n10;
        AudioTrack audioTrack = (AudioTrack)Assertions.checkNotNull(this.audioTrack);
        int n11 = audioTrack.getPlayState();
        if (n11 == (n10 = 3)) {
            n11 = 1;
        } else {
            n11 = 0;
            audioTrack = null;
        }
        return n11 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isStalled(long l10) {
        long l11 = this.forceResetWorkaroundTimeMs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) return 0 != 0;
        l11 = 0L;
        long l14 = l10 - l11;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 <= 0) return 0 != 0;
        l10 = SystemClock.elapsedRealtime();
        l11 = this.forceResetWorkaroundTimeMs;
        long l15 = (l10 -= l11) - (l11 = 200L);
        object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 < 0) return 0 != 0;
        return 1 != 0;
    }

    public boolean mayHandleBuffer(long l10) {
        boolean bl2;
        AudioTrack audioTrack = (AudioTrack)Assertions.checkNotNull(this.audioTrack);
        boolean bl3 = audioTrack.getPlayState();
        boolean bl4 = this.needsPassthroughWorkarounds;
        boolean bl5 = true;
        if (bl4) {
            long l11;
            long l12;
            long l13;
            long l14;
            boolean bl6 = 2 != 0;
            if (bl3 == bl6) {
                this.hasData = false;
                return false;
            }
            if (bl3 == bl5 && (l14 = (l13 = (l12 = this.getPlaybackHeadPosition()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                return false;
            }
        }
        boolean bl7 = this.hasData;
        this.hasData = bl2 = this.hasPendingData(l10);
        if (bl7 && !bl2 && bl3 != bl5) {
            AudioTrackPositionTracker$Listener audioTrackPositionTracker$Listener = this.listener;
            int n10 = this.bufferSize;
            long l15 = C.usToMs(this.bufferSizeUs);
            audioTrackPositionTracker$Listener.onUnderrun(n10, l15);
        }
        return bl5;
    }

    public boolean pause() {
        this.resetSyncParams();
        long l10 = this.stopTimestampUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            ((AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller)).reset();
            return true;
        }
        return false;
    }

    public void reset() {
        this.resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    public void setAudioTrack(AudioTrack audioTrack, boolean bl2, int n10, int n11, int n12) {
        long l10;
        int n13;
        AudioTimestampPoller audioTimestampPoller;
        this.audioTrack = audioTrack;
        this.outputPcmFrameSize = n11;
        this.bufferSize = n12;
        this.audioTimestampPoller = audioTimestampPoller = new AudioTimestampPoller(audioTrack);
        this.outputSampleRate = n13 = audioTrack.getSampleRate();
        n13 = 0;
        audioTrack = null;
        bl2 = bl2 && (bl2 = AudioTrackPositionTracker.needsPassthroughWorkarounds(n10));
        this.needsPassthroughWorkarounds = bl2;
        this.isOutputPcm = bl2 = Util.isEncodingLinearPcm(n10);
        long l11 = -9223372036854775807L;
        if (bl2) {
            l10 = n12 /= n11;
            l10 = this.framesToDurationUs(l10);
        } else {
            l10 = l11;
        }
        this.bufferSizeUs = l10;
        this.lastRawPlaybackHeadPosition = l10 = 0L;
        this.rawPlaybackHeadWrapCount = l10;
        this.passthroughWorkaroundPauseOffset = l10;
        this.hasData = false;
        this.stopTimestampUs = l11;
        this.forceResetWorkaroundTimeMs = l11;
        this.lastLatencySampleTimeUs = l10;
        this.latencyUs = l10;
        this.audioTrackPlaybackSpeed = 1.0f;
    }

    public void setAudioTrackPlaybackSpeed(float f10) {
        this.audioTrackPlaybackSpeed = f10;
        AudioTimestampPoller audioTimestampPoller = this.audioTimestampPoller;
        if (audioTimestampPoller != null) {
            audioTimestampPoller.reset();
        }
    }

    public void start() {
        ((AudioTimestampPoller)Assertions.checkNotNull(this.audioTimestampPoller)).reset();
    }
}

