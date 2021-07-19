/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.view.Surface
 *  android.view.WindowManager
 */
package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.DummySurface;
import com.google.android.exoplayer2.video.FixedFrameRateEstimator;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper$DefaultDisplayListener;
import com.google.android.exoplayer2.video.VideoFrameReleaseHelper$VSyncSampler;

public final class VideoFrameReleaseHelper {
    private static final long MAX_ALLOWED_ADJUSTMENT_NS = 20000000L;
    private static final int MINIMUM_FRAMES_WITHOUT_SYNC_TO_CLEAR_SURFACE_FRAME_RATE = 30;
    private static final long MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS = 5000000000L;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE = 0.02f;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_LOW_CONFIDENCE = 1.0f;
    private static final String TAG = "VideoFrameReleaseHelper";
    private static final long VSYNC_OFFSET_PERCENTAGE = 80L;
    private static final long VSYNC_SAMPLE_UPDATE_PERIOD_MS = 500L;
    private final VideoFrameReleaseHelper$DefaultDisplayListener displayListener;
    private float formatFrameRate;
    private long frameIndex;
    private final FixedFrameRateEstimator frameRateEstimator;
    private long lastAdjustedFrameIndex;
    private long lastAdjustedReleaseTimeNs;
    private long pendingLastAdjustedFrameIndex;
    private long pendingLastAdjustedReleaseTimeNs;
    private float playbackSpeed;
    private boolean started;
    private Surface surface;
    private float surfaceMediaFrameRate;
    private float surfacePlaybackFrameRate;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VideoFrameReleaseHelper$VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    public VideoFrameReleaseHelper(Context object) {
        long l10;
        WindowManager windowManager;
        Object object2 = new FixedFrameRateEstimator();
        this.frameRateEstimator = object2;
        object2 = null;
        if (object != null) {
            object = object.getApplicationContext();
            this.windowManager = windowManager = (WindowManager)object.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        windowManager = this.windowManager;
        if (windowManager != null) {
            int n10 = Util.SDK_INT;
            int n11 = 17;
            if (n10 >= n11) {
                object = (Context)Assertions.checkNotNull(object);
                object2 = this.maybeBuildDefaultDisplayListenerV17((Context)object);
            }
            this.displayListener = object2;
            object = VideoFrameReleaseHelper$VSyncSampler.getInstance();
            this.vsyncSampler = object;
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = l10 = -9223372036854775807L;
        this.vsyncOffsetNs = l10;
        this.formatFrameRate = -1.0f;
        this.playbackSpeed = 1.0f;
    }

    public static /* synthetic */ void access$000(VideoFrameReleaseHelper videoFrameReleaseHelper) {
        videoFrameReleaseHelper.updateDefaultDisplayRefreshRateParams();
    }

    private static boolean adjustmentAllowed(long l10, long l11) {
        long l12 = (l10 = Math.abs(l10 - l11)) - (l11 = 20000000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    private void clearSurfaceFrameRate() {
        float f10;
        Surface surface;
        int n10 = Util.SDK_INT;
        int n11 = 30;
        float f11 = 4.2E-44f;
        if (n10 >= n11 && (surface = this.surface) != null && (n11 = (int)((f10 = (f11 = this.surfacePlaybackFrameRate) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != 0) {
            this.surfacePlaybackFrameRate = 0.0f;
            VideoFrameReleaseHelper.setSurfaceFrameRateV30(surface, 0.0f);
        }
    }

    private static long closestVsync(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15;
        if ((l15 = (l14 = l10 - (l11 += (l13 = (l10 - l11) / l12 * l12))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) <= 0) {
            l12 = l11 - l12;
        } else {
            l12 += l11;
            long l16 = l11;
            l11 = l12;
            l12 = l16;
        }
        l13 = l11 - l10;
        long l17 = l13 - (l10 -= l12);
        long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (l18 >= 0) {
            l11 = l12;
        }
        return l11;
    }

    private VideoFrameReleaseHelper$DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context object) {
        Object object2 = "display";
        if ((object = (DisplayManager)object.getSystemService((String)object2)) == null) {
            object = null;
        } else {
            object2 = new VideoFrameReleaseHelper$DefaultDisplayListener(this, (DisplayManager)object);
            object = object2;
        }
        return object;
    }

    private void resetAdjustment() {
        long l10;
        this.frameIndex = 0L;
        this.lastAdjustedFrameIndex = l10 = (long)-1;
        this.pendingLastAdjustedFrameIndex = l10;
    }

    private static void setSurfaceFrameRateV30(Surface surface, float f10) {
        String string2 = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object == false) {
            object = false;
            string2 = null;
        } else {
            object = true;
        }
        try {
            surface.setFrameRate(f10, (int)object);
        }
        catch (IllegalStateException illegalStateException) {
            String string3 = TAG;
            string2 = "Failed to call Surface.setFrameRate";
            Log.e(string3, string2, illegalStateException);
        }
    }

    private void updateDefaultDisplayRefreshRateParams() {
        Object object = ((WindowManager)Assertions.checkNotNull(this.windowManager)).getDefaultDisplay();
        if (object != null) {
            long l10;
            float f10 = object.getRefreshRate();
            double d10 = f10;
            this.vsyncDurationNs = l10 = (long)(1.0E9 / d10);
            l10 *= (long)80;
            long l11 = 100;
            this.vsyncOffsetNs = l10 /= l11;
        } else {
            object = TAG;
            String string2 = "Unable to query display refresh rate";
            Log.w((String)object, string2);
            long l12 = -9223372036854775807L;
            double d11 = -4.9E-324;
            this.vsyncDurationNs = l12;
            this.vsyncOffsetNs = l12;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void updateSurfaceMediaFrameRate() {
        float f10;
        float f11;
        int n10 = Util.SDK_INT;
        int n11 = 30;
        float f12 = 4.2E-44f;
        if (n10 < n11) return;
        Object object = this.surface;
        if (object == null) return;
        object = this.frameRateEstimator;
        n10 = (int)(((FixedFrameRateEstimator)object).isSynced() ? 1 : 0);
        if (n10 != 0) {
            object = this.frameRateEstimator;
            f11 = ((FixedFrameRateEstimator)object).getFrameRate();
        } else {
            f11 = this.formatFrameRate;
        }
        float f13 = this.surfaceMediaFrameRate;
        float f14 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
        if (f14 == false) {
            return;
        }
        f14 = -1082130432;
        float f15 = -1.0f;
        float f16 = f11 == f15 ? 0 : (f11 > f15 ? 1 : -1);
        int n12 = 1;
        float f17 = Float.MIN_VALUE;
        if (f16 != false && (f10 = f13 == f15 ? 0 : (f13 > f15 ? 1 : -1)) != false) {
            long l10;
            long l11;
            long l12;
            FixedFrameRateEstimator fixedFrameRateEstimator = this.frameRateEstimator;
            n11 = (int)(fixedFrameRateEstimator.isSynced() ? 1 : 0);
            if (n11 != 0 && (n11 = (int)((l12 = (l11 = (fixedFrameRateEstimator = this.frameRateEstimator).getMatchingFrameDurationSumNs()) - (l10 = 5000000000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
                n11 = n12;
                f12 = f17;
            } else {
                n11 = 0;
                fixedFrameRateEstimator = null;
                f12 = 0.0f;
            }
            if (n11 != 0) {
                n11 = 1017370378;
                f12 = 0.02f;
            } else {
                n11 = 1065353216;
                f12 = 1.0f;
            }
            f13 = this.surfaceMediaFrameRate;
            f13 = Math.abs(f11 - f13);
            n11 = (int)(f13 == f12 ? 0 : (f13 > f12 ? 1 : -1));
            if (n11 < 0) return;
        } else if (f16 == false) {
            FixedFrameRateEstimator fixedFrameRateEstimator = this.frameRateEstimator;
            f10 = fixedFrameRateEstimator.getFramesWithoutSyncCount();
            if (f10 < n11) return;
        }
        if (n12 == 0) return;
        this.surfaceMediaFrameRate = f11;
        this.updateSurfacePlaybackFrameRate(false);
    }

    private void updateSurfacePlaybackFrameRate(boolean bl2) {
        Surface surface;
        int n10 = Util.SDK_INT;
        int n11 = 30;
        float f10 = 4.2E-44f;
        if (n10 >= n11 && (surface = this.surface) != null) {
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            n11 = 0;
            f10 = 0.0f;
            boolean bl3 = this.started;
            if (bl3 && (f16 = (f15 = (f14 = this.surfaceMediaFrameRate) - (f13 = -1.0f)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false) {
                f10 = this.playbackSpeed * f14;
            }
            if (!bl2 && !(bl2 = (f12 = (f11 = this.surfacePlaybackFrameRate) - f10) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) {
                return;
            }
            this.surfacePlaybackFrameRate = f10;
            VideoFrameReleaseHelper.setSurfaceFrameRateV30(surface, f10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public long adjustReleaseTime(long var1_1) {
        var3_2 = this.lastAdjustedFrameIndex;
        var5_3 = -1;
        cfr_temp_0 = var3_2 - var5_3;
        var7_4 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var7_4 /* !! */  == false || (var7_4 /* !! */  = (long)(var8_5 = this.frameRateEstimator).isSynced()) == false) ** GOTO lbl19
        var8_5 = this.frameRateEstimator;
        var3_2 = var8_5.getFrameDurationNs();
        var5_3 = this.lastAdjustedReleaseTimeNs;
        var9_6 = this.frameIndex;
        var11_7 = this.lastAdjustedFrameIndex;
        var13_8 = var3_2 * (var9_6 -= var11_7);
        var14_9 = this.playbackSpeed;
        var3_2 = (long)(var13_8 /= var14_9);
        var7_4 /* !! */  = (long)VideoFrameReleaseHelper.adjustmentAllowed(var1_1, var5_3 += var3_2);
        if (var7_4 /* !! */  != false) {
            var9_6 = var5_3;
        } else {
            this.resetAdjustment();
lbl19:
            // 2 sources

            var9_6 = var1_1;
        }
        this.pendingLastAdjustedFrameIndex = var1_1 = this.frameIndex;
        this.pendingLastAdjustedReleaseTimeNs = var9_6;
        var15_10 = this.vsyncSampler;
        if (var15_10 != null && (var16_11 = (cfr_temp_1 = (var3_2 = this.vsyncDurationNs) - (var5_3 = -9223372036854775807L)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false) {
            var11_7 = var15_10.sampledVsyncTimeNs;
            cfr_temp_2 = var11_7 - var5_3;
            var17_12 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
            if (var17_12 /* !! */  == false) {
                return var9_6;
            }
            var18_13 = this.vsyncDurationNs;
            var1_1 = VideoFrameReleaseHelper.closestVsync(var9_6, var11_7, var18_13);
            var3_2 = this.vsyncOffsetNs;
            return var1_1 - var3_2;
        }
        return var9_6;
    }

    public void onDisabled() {
        Object object = this.windowManager;
        if (object != null) {
            object = this.displayListener;
            if (object != null) {
                ((VideoFrameReleaseHelper$DefaultDisplayListener)object).unregister();
            }
            object = (VideoFrameReleaseHelper$VSyncSampler)Assertions.checkNotNull(this.vsyncSampler);
            ((VideoFrameReleaseHelper$VSyncSampler)object).removeObserver();
        }
    }

    public void onEnabled() {
        Object object = this.windowManager;
        if (object != null) {
            ((VideoFrameReleaseHelper$VSyncSampler)Assertions.checkNotNull(this.vsyncSampler)).addObserver();
            object = this.displayListener;
            if (object != null) {
                ((VideoFrameReleaseHelper$DefaultDisplayListener)object).register();
            }
            this.updateDefaultDisplayRefreshRateParams();
        }
    }

    public void onFormatChanged(float f10) {
        this.formatFrameRate = f10;
        this.frameRateEstimator.reset();
        this.updateSurfaceMediaFrameRate();
    }

    public void onNextFrame(long l10) {
        long l11 = this.pendingLastAdjustedFrameIndex;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            this.lastAdjustedFrameIndex = l11;
            this.lastAdjustedReleaseTimeNs = l11 = this.pendingLastAdjustedReleaseTimeNs;
        }
        this.frameIndex = l11 = this.frameIndex + 1L;
        FixedFrameRateEstimator fixedFrameRateEstimator = this.frameRateEstimator;
        fixedFrameRateEstimator.onNextFrame(l10 *= 1000L);
        this.updateSurfaceMediaFrameRate();
    }

    public void onPlaybackSpeed(float f10) {
        this.playbackSpeed = f10;
        this.resetAdjustment();
        this.updateSurfacePlaybackFrameRate(false);
    }

    public void onPositionReset() {
        this.resetAdjustment();
    }

    public void onStarted() {
        this.started = true;
        this.resetAdjustment();
        this.updateSurfacePlaybackFrameRate(false);
    }

    public void onStopped() {
        this.started = false;
        this.clearSurfaceFrameRate();
    }

    public void onSurfaceChanged(Surface surface) {
        Surface surface2;
        boolean bl2 = surface instanceof DummySurface;
        if (bl2) {
            surface = null;
        }
        if ((surface2 = this.surface) == surface) {
            return;
        }
        this.clearSurfaceFrameRate();
        this.surface = surface;
        this.updateSurfacePlaybackFrameRate(true);
    }
}

