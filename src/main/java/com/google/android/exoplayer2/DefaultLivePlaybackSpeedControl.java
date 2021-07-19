/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl$1;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.util.Util;
import com.google.common.primitives.Longs;

public final class DefaultLivePlaybackSpeedControl
implements LivePlaybackSpeedControl {
    public static final float DEFAULT_FALLBACK_MAX_PLAYBACK_SPEED = 1.03f;
    public static final float DEFAULT_FALLBACK_MIN_PLAYBACK_SPEED = 0.97f;
    public static final long DEFAULT_MAX_LIVE_OFFSET_ERROR_MS_FOR_UNIT_SPEED = 20L;
    public static final float DEFAULT_MIN_POSSIBLE_LIVE_OFFSET_SMOOTHING_FACTOR = 0.999f;
    public static final long DEFAULT_MIN_UPDATE_INTERVAL_MS = 1000L;
    public static final float DEFAULT_PROPORTIONAL_CONTROL_FACTOR = 0.1f;
    public static final long DEFAULT_TARGET_LIVE_OFFSET_INCREMENT_ON_REBUFFER_MS = 500L;
    private float adjustedPlaybackSpeed;
    private long currentTargetLiveOffsetUs;
    private final float fallbackMaxPlaybackSpeed;
    private final float fallbackMinPlaybackSpeed;
    private long idealTargetLiveOffsetUs;
    private long lastPlaybackSpeedUpdateMs;
    private final long maxLiveOffsetErrorUsForUnitSpeed;
    private float maxPlaybackSpeed;
    private long maxTargetLiveOffsetUs;
    private long mediaConfigurationTargetLiveOffsetUs;
    private float minPlaybackSpeed;
    private final float minPossibleLiveOffsetSmoothingFactor;
    private long minTargetLiveOffsetUs;
    private final long minUpdateIntervalMs;
    private final float proportionalControlFactor;
    private long smoothedMinPossibleLiveOffsetDeviationUs;
    private long smoothedMinPossibleLiveOffsetUs;
    private long targetLiveOffsetOverrideUs;
    private final long targetLiveOffsetRebufferDeltaUs;

    private DefaultLivePlaybackSpeedControl(float f10, float f11, long l10, float f12, long l11, long l12, float f13) {
        this.fallbackMinPlaybackSpeed = f10;
        this.fallbackMaxPlaybackSpeed = f11;
        this.minUpdateIntervalMs = l10;
        this.proportionalControlFactor = f12;
        this.maxLiveOffsetErrorUsForUnitSpeed = l11;
        this.targetLiveOffsetRebufferDeltaUs = l12;
        this.minPossibleLiveOffsetSmoothingFactor = f13;
        this.mediaConfigurationTargetLiveOffsetUs = l10 = -9223372036854775807L;
        this.targetLiveOffsetOverrideUs = l10;
        this.minTargetLiveOffsetUs = l10;
        this.maxTargetLiveOffsetUs = l10;
        this.minPlaybackSpeed = f10;
        this.maxPlaybackSpeed = f11;
        this.adjustedPlaybackSpeed = 1.0f;
        this.lastPlaybackSpeedUpdateMs = l10;
        this.idealTargetLiveOffsetUs = l10;
        this.currentTargetLiveOffsetUs = l10;
        this.smoothedMinPossibleLiveOffsetUs = l10;
        this.smoothedMinPossibleLiveOffsetDeviationUs = l10;
    }

    public /* synthetic */ DefaultLivePlaybackSpeedControl(float f10, float f11, long l10, float f12, long l11, long l12, float f13, DefaultLivePlaybackSpeedControl$1 defaultLivePlaybackSpeedControl$1) {
        this(f10, f11, l10, f12, l11, l12, f13);
    }

    private void adjustTargetLiveOffsetUs(long l10) {
        long l11 = this.smoothedMinPossibleLiveOffsetUs;
        long l12 = this.smoothedMinPossibleLiveOffsetDeviationUs;
        long l13 = 3;
        long l14 = l11 + (l12 *= l13);
        l11 = this.currentTargetLiveOffsetUs;
        long l15 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
        float f10 = 1.0f;
        if (l15 > 0) {
            l10 = C.msToUs(this.minUpdateIntervalMs);
            float f11 = this.adjustedPlaybackSpeed - f10;
            float f12 = l10;
            l12 = (long)(f11 *= f12);
            l10 = (long)((this.maxPlaybackSpeed - f10) * f12);
            int n10 = 3;
            f12 = 4.2E-45f;
            long[] lArray = new long[n10];
            lArray[0] = l14;
            lArray[1] = l11 = this.idealTargetLiveOffsetUs;
            int n11 = 2;
            lArray[n11] = l11 = this.currentTargetLiveOffsetUs - (l12 += l10);
            this.currentTargetLiveOffsetUs = l10 = Longs.max(lArray);
        } else {
            long l16;
            l15 = 0;
            float f13 = this.adjustedPlaybackSpeed - f10;
            float f14 = Math.max(0.0f, f13);
            f10 = this.proportionalControlFactor;
            l11 = (long)(f14 /= f10);
            l13 = l10 - l11;
            long l17 = this.currentTargetLiveOffsetUs;
            this.currentTargetLiveOffsetUs = l10 = Util.constrainValue(l13, l17, l14);
            l11 = this.maxTargetLiveOffsetUs;
            l12 = -9223372036854775807L;
            long l18 = l11 - l12;
            Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object != false && (l16 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) > 0) {
                this.currentTargetLiveOffsetUs = l11;
            }
        }
    }

    private void maybeResetTargetLiveOffsetUs() {
        long l10;
        long l11;
        long l12 = this.mediaConfigurationTargetLiveOffsetUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false) {
            long l15;
            long l16;
            l11 = this.targetLiveOffsetOverrideUs;
            long l17 = l11 - l13;
            Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object2 != false) {
                l12 = l11;
            }
            if ((object2 = (l16 = (l11 = this.minTargetLiveOffsetUs) - l13) == 0L ? 0 : (l16 < 0L ? -1 : 1)) != false && (object2 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) < 0) {
                l12 = l11;
            }
            if ((object2 = (l15 = (l11 = this.maxTargetLiveOffsetUs) - l13) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false && (object2 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) > 0) {
                l12 = l11;
            }
        } else {
            l12 = l13;
        }
        if ((object = (l10 = (l11 = this.idealTargetLiveOffsetUs) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            return;
        }
        this.idealTargetLiveOffsetUs = l12;
        this.currentTargetLiveOffsetUs = l12;
        this.smoothedMinPossibleLiveOffsetUs = l13;
        this.smoothedMinPossibleLiveOffsetDeviationUs = l13;
        this.lastPlaybackSpeedUpdateMs = l13;
    }

    private static long smooth(long l10, long l11, float f10) {
        float f11 = (float)l10 * f10;
        float f12 = 1.0f - f10;
        float f13 = l11;
        return (long)(f11 + (f12 *= f13));
    }

    private void updateSmoothedMinPossibleLiveOffsetUs(long l10, long l11) {
        l10 -= l11;
        l11 = this.smoothedMinPossibleLiveOffsetUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            this.smoothedMinPossibleLiveOffsetUs = l10;
            this.smoothedMinPossibleLiveOffsetDeviationUs = l10 = 0L;
        } else {
            float f10 = this.minPossibleLiveOffsetSmoothingFactor;
            l11 = DefaultLivePlaybackSpeedControl.smooth(l11, l10, f10);
            this.smoothedMinPossibleLiveOffsetUs = l11 = Math.max(l10, l11);
            l10 = Math.abs(l10 - l11);
            l11 = this.smoothedMinPossibleLiveOffsetDeviationUs;
            f10 = this.minPossibleLiveOffsetSmoothingFactor;
            this.smoothedMinPossibleLiveOffsetDeviationUs = l10 = DefaultLivePlaybackSpeedControl.smooth(l11, l10, f10);
        }
    }

    public float getAdjustedPlaybackSpeed(long l10, long l11) {
        long l12 = this.mediaConfigurationTargetLiveOffsetUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        float f10 = 1.0f;
        if (l14 == false) {
            return f10;
        }
        this.updateSmoothedMinPossibleLiveOffsetUs(l10, l11);
        l11 = this.lastPlaybackSpeedUpdateMs;
        Object object = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        if (object != false) {
            l11 = SystemClock.elapsedRealtime();
            l13 = this.lastPlaybackSpeedUpdateMs;
            long l15 = (l11 -= l13) - (l13 = this.minUpdateIntervalMs);
            object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object < 0) {
                return this.adjustedPlaybackSpeed;
            }
        }
        this.lastPlaybackSpeedUpdateMs = l11 = SystemClock.elapsedRealtime();
        this.adjustTargetLiveOffsetUs(l10);
        l11 = this.currentTargetLiveOffsetUs;
        l10 -= l11;
        l11 = Math.abs(l10);
        l13 = this.maxLiveOffsetErrorUsForUnitSpeed;
        object = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
        if (object < 0) {
            this.adjustedPlaybackSpeed = f10;
        } else {
            float f11 = this.proportionalControlFactor;
            float f12 = l10;
            f11 = f11 * f12 + f10;
            f12 = this.minPlaybackSpeed;
            float f13 = this.maxPlaybackSpeed;
            this.adjustedPlaybackSpeed = f12 = Util.constrainValue(f11, f12, f13);
        }
        return this.adjustedPlaybackSpeed;
    }

    public long getTargetLiveOffsetUs() {
        return this.currentTargetLiveOffsetUs;
    }

    public void notifyRebuffer() {
        long l10;
        long l11 = this.currentTargetLiveOffsetUs;
        long l12 = -9223372036854775807L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        long l14 = this.targetLiveOffsetRebufferDeltaUs;
        this.currentTargetLiveOffsetUs = l11 += l14;
        l14 = this.maxTargetLiveOffsetUs;
        long l15 = l14 - l12;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 != false && (l10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1)) > 0) {
            this.currentTargetLiveOffsetUs = l14;
        }
        this.lastPlaybackSpeedUpdateMs = l12;
    }

    public void setLiveConfiguration(MediaItem$LiveConfiguration mediaItem$LiveConfiguration) {
        long l10;
        this.mediaConfigurationTargetLiveOffsetUs = l10 = C.msToUs(mediaItem$LiveConfiguration.targetOffsetMs);
        this.minTargetLiveOffsetUs = l10 = C.msToUs(mediaItem$LiveConfiguration.minOffsetMs);
        this.maxTargetLiveOffsetUs = l10 = C.msToUs(mediaItem$LiveConfiguration.maxOffsetMs);
        float f10 = mediaItem$LiveConfiguration.minPlaybackSpeed;
        float f11 = -3.4028235E38f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = this.fallbackMinPlaybackSpeed;
        }
        this.minPlaybackSpeed = f10;
        float f13 = mediaItem$LiveConfiguration.maxPlaybackSpeed;
        float f14 = f13 == f11 ? 0 : (f13 > f11 ? 1 : -1);
        if (f14 == false) {
            f13 = this.fallbackMaxPlaybackSpeed;
        }
        this.maxPlaybackSpeed = f13;
        this.maybeResetTargetLiveOffsetUs();
    }

    public void setTargetLiveOffsetOverrideUs(long l10) {
        this.targetLiveOffsetOverrideUs = l10;
        this.maybeResetTargetLiveOffsetUs();
    }
}

