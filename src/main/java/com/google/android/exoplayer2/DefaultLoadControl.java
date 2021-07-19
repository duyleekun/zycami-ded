/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public class DefaultLoadControl
implements LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 0xC80000;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 0xC80000;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = 255;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 0x7D00000;
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isLoading;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public DefaultLoadControl() {
        DefaultAllocator defaultAllocator = new DefaultAllocator(true, 65536);
        this(defaultAllocator, 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int n10, int n11, int n12, int n13, int n14, boolean bl2, int n15, boolean bl3) {
        long l10;
        String string2 = "bufferForPlaybackMs";
        String string3 = "0";
        DefaultLoadControl.assertGreaterOrEqual(n12, 0, string2, string3);
        String string4 = "bufferForPlaybackAfterRebufferMs";
        DefaultLoadControl.assertGreaterOrEqual(n13, 0, string4, string3);
        String string5 = "minBufferMs";
        DefaultLoadControl.assertGreaterOrEqual(n10, n12, string5, string2);
        DefaultLoadControl.assertGreaterOrEqual(n10, n13, string5, string4);
        DefaultLoadControl.assertGreaterOrEqual(n11, n10, "maxBufferMs", string5);
        string2 = "backBufferDurationMs";
        DefaultLoadControl.assertGreaterOrEqual(n15, 0, string2, string3);
        this.allocator = defaultAllocator;
        this.minBufferUs = l10 = C.msToUs(n10);
        this.maxBufferUs = l10 = C.msToUs(n11);
        this.bufferForPlaybackUs = l10 = C.msToUs(n12);
        this.bufferForPlaybackAfterRebufferUs = l10 = C.msToUs(n13);
        this.targetBufferBytesOverwrite = n14;
        int n16 = -1;
        if (n14 == n16) {
            n14 = 0xC80000;
        }
        this.targetBufferBytes = n14;
        this.prioritizeTimeOverSizeThresholds = bl2;
        this.backBufferDurationUs = l10 = C.msToUs(n15);
        this.retainBackBufferFromKeyframe = bl3;
    }

    public static /* synthetic */ void access$000(int n10, int n11, String string2, String string3) {
        DefaultLoadControl.assertGreaterOrEqual(n10, n11, string2, string3);
    }

    private static void assertGreaterOrEqual(int n10, int n11, String string2, String string3) {
        n10 = n10 >= n11 ? 1 : 0;
        n11 = String.valueOf(string2).length() + 21;
        int n12 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be less than ");
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        Assertions.checkArgument(n10 != 0, string4);
    }

    private static int getDefaultBufferSize(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    int n12 = 131072;
                    if (n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 6)) {
                        n11 = 7;
                        if (n10 == n11) {
                            return 0;
                        }
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        throw illegalArgumentException;
                    }
                    return n12;
                }
                return 0x7D00000;
            }
            return 0xC80000;
        }
        return 144310272;
    }

    private void reset(boolean bl2) {
        int n10 = this.targetBufferBytesOverwrite;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0xC80000;
        }
        this.targetBufferBytes = n10;
        n10 = 0;
        this.isLoading = false;
        if (bl2) {
            DefaultAllocator defaultAllocator = this.allocator;
            defaultAllocator.reset();
        }
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = rendererArray.length); ++i10) {
            Object object = exoTrackSelectionArray[i10];
            if (object == null) continue;
            object = rendererArray[i10];
            n10 = DefaultLoadControl.getDefaultBufferSize(object.getTrackType());
            n11 += n10;
        }
        return Math.max(0xC80000, n11);
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    public void onPrepared() {
        this.reset(false);
    }

    public void onReleased() {
        this.reset(true);
    }

    public void onStopped() {
        this.reset(true);
    }

    public void onTracksSelected(Renderer[] rendererArray, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10 = this.targetBufferBytesOverwrite;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.calculateTargetBufferBytes(rendererArray, exoTrackSelectionArray);
        }
        this.targetBufferBytes = n10;
        this.allocator.setTargetBufferSize(n10);
    }

    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    public boolean shouldContinueLoading(long l10, long l11, float f10) {
        long l12;
        long l13;
        Object object = this.allocator;
        int n10 = ((DefaultAllocator)object).getTotalBytesAllocated();
        int n11 = this.targetBufferBytes;
        int n12 = 1;
        if (n10 >= n11) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        long l14 = this.minBufferUs;
        float f11 = 1.0f;
        n11 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
        if (n11 > 0) {
            l14 = Util.getMediaDurationForPlayoutDuration(l14, f10);
            l13 = this.maxBufferUs;
            l14 = Math.min(l14, l13);
        }
        if ((n11 = (int)((l12 = l11 - (l14 = Math.max(l14, l13 = 500000L))) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) {
            n11 = (int)(this.prioritizeTimeOverSizeThresholds ? 1 : 0);
            if (n11 == 0 && n10 != 0) {
                n12 = 0;
            }
            this.isLoading = n12;
            if (n12 == 0 && (n10 = (int)(l11 == l13 ? 0 : (l11 < l13 ? -1 : 1))) < 0) {
                object = "DefaultLoadControl";
                String string2 = "Target buffer size reached with less than 500ms of buffered media data.";
                Log.w((String)object, string2);
            }
        } else {
            l14 = this.maxBufferUs;
            long l15 = l11 - l14;
            n11 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n11 >= 0 || n10 != 0) {
                this.isLoading = false;
            }
        }
        return this.isLoading;
    }

    public boolean shouldStartPlayback(long l10, float f10, boolean bl2, long l11) {
        int n10;
        DefaultAllocator defaultAllocator;
        int n11;
        long l12;
        long l13;
        l10 = Util.getPlayoutDurationForMediaDuration(l10, f10);
        long l14 = bl2 ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        long l15 = -9223372036854775807L;
        long l16 = l11 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false) {
            l15 = 2;
            l14 = Math.min(l11 /= l15, l14);
        }
        if ((l13 = (l12 = l14 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (n11 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) < 0 && ((n11 = (int)(this.prioritizeTimeOverSizeThresholds ? 1 : 0)) != 0 || (n11 = (defaultAllocator = this.allocator).getTotalBytesAllocated()) < (n10 = this.targetBufferBytes))) {
            n11 = 0;
            defaultAllocator = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }
}

