/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import java.util.Arrays;

public final class FixedFrameRateEstimator$Matcher {
    private long firstFrameDurationNs;
    private long firstFramePresentationTimeNs;
    private long frameCount;
    private long lastFramePresentationTimeNs;
    private long matchingFrameCount;
    private long matchingFrameDurationSumNs;
    private int recentFrameOutlierCount;
    private final boolean[] recentFrameOutlierFlags;

    public FixedFrameRateEstimator$Matcher() {
        boolean[] blArray = new boolean[15];
        this.recentFrameOutlierFlags = blArray;
    }

    private static int getRecentFrameOutlierIndex(long l10) {
        return (int)(l10 % (long)15);
    }

    public long getFrameDurationNs() {
        long l10 = this.matchingFrameCount;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = this.matchingFrameDurationSumNs / l10;
        }
        return l11;
    }

    public long getMatchingFrameDurationSumNs() {
        return this.matchingFrameDurationSumNs;
    }

    public boolean isLastFrameOutlier() {
        long l10 = this.frameCount;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return false;
        }
        boolean[] blArray = this.recentFrameOutlierFlags;
        int n10 = FixedFrameRateEstimator$Matcher.getRecentFrameOutlierIndex(l10 - 1L);
        return blArray[n10];
    }

    public boolean isSynced() {
        long l10 = this.frameCount;
        long l11 = 15;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 && (object = (Object)this.recentFrameOutlierCount) == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void onNextFrame(long l10) {
        long l11 = this.frameCount;
        long l12 = 0L;
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        long l13 = 1L;
        if (object == false) {
            this.firstFramePresentationTimeNs = l10;
        } else {
            object = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
            if (object == false) {
                l11 = this.firstFramePresentationTimeNs;
                this.firstFrameDurationNs = l11 = l10 - l11;
                this.matchingFrameDurationSumNs = l11;
                this.matchingFrameCount = l13;
            } else {
                long l14 = this.lastFramePresentationTimeNs;
                l14 = l10 - l14;
                int n10 = FixedFrameRateEstimator$Matcher.getRecentFrameOutlierIndex(l11);
                long l15 = this.firstFrameDurationNs;
                l15 = Math.abs(l14 - l15);
                long l16 = 1000000L;
                long l17 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
                object = 1;
                if (l17 <= 0) {
                    this.matchingFrameCount = l16 = this.matchingFrameCount + l13;
                    this.matchingFrameDurationSumNs = l16 = this.matchingFrameDurationSumNs + l14;
                    boolean[] blArray = this.recentFrameOutlierFlags;
                    boolean bl2 = blArray[n10];
                    if (bl2) {
                        bl2 = false;
                        blArray[n10] = false;
                        this.recentFrameOutlierCount = n10 = this.recentFrameOutlierCount - object;
                    }
                } else {
                    boolean[] blArray = this.recentFrameOutlierFlags;
                    boolean bl3 = blArray[n10];
                    if (!bl3) {
                        blArray[n10] = object;
                        this.recentFrameOutlierCount = n10 = this.recentFrameOutlierCount + object;
                    }
                }
            }
        }
        this.frameCount = l11 = this.frameCount + l13;
        this.lastFramePresentationTimeNs = l10;
    }

    public void reset() {
        long l10;
        this.frameCount = l10 = 0L;
        this.matchingFrameCount = l10;
        this.matchingFrameDurationSumNs = l10;
        this.recentFrameOutlierCount = 0;
        Arrays.fill(this.recentFrameOutlierFlags, false);
    }
}

