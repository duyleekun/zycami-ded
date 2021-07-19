/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.FixedFrameRateEstimator$Matcher;

public final class FixedFrameRateEstimator {
    public static final int CONSECUTIVE_MATCHING_FRAME_DURATIONS_FOR_SYNC = 15;
    public static final long MAX_MATCHING_FRAME_DIFFERENCE_NS = 1000000L;
    private FixedFrameRateEstimator$Matcher candidateMatcher;
    private boolean candidateMatcherActive;
    private FixedFrameRateEstimator$Matcher currentMatcher;
    private int framesWithoutSyncCount;
    private long lastFramePresentationTimeNs;
    private boolean switchToCandidateMatcherWhenSynced;

    public FixedFrameRateEstimator() {
        FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher;
        this.currentMatcher = fixedFrameRateEstimator$Matcher = new FixedFrameRateEstimator$Matcher();
        this.candidateMatcher = fixedFrameRateEstimator$Matcher = new FixedFrameRateEstimator$Matcher();
        this.lastFramePresentationTimeNs = -9223372036854775807L;
    }

    public long getFrameDurationNs() {
        long l10;
        boolean bl2 = this.isSynced();
        if (bl2) {
            FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher = this.currentMatcher;
            l10 = fixedFrameRateEstimator$Matcher.getFrameDurationNs();
        } else {
            l10 = -9223372036854775807L;
        }
        return l10;
    }

    public float getFrameRate() {
        float f10;
        int n10 = this.isSynced();
        if (n10 != 0) {
            FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher = this.currentMatcher;
            long l10 = fixedFrameRateEstimator$Matcher.getFrameDurationNs();
            double d10 = l10;
            double d11 = 1.0E9 / d10;
            f10 = (float)d11;
        } else {
            n10 = -1082130432;
            f10 = -1.0f;
        }
        return f10;
    }

    public int getFramesWithoutSyncCount() {
        return this.framesWithoutSyncCount;
    }

    public long getMatchingFrameDurationSumNs() {
        long l10;
        boolean bl2 = this.isSynced();
        if (bl2) {
            FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher = this.currentMatcher;
            l10 = fixedFrameRateEstimator$Matcher.getMatchingFrameDurationSumNs();
        } else {
            l10 = -9223372036854775807L;
        }
        return l10;
    }

    public boolean isSynced() {
        return this.currentMatcher.isSynced();
    }

    public void onNextFrame(long l10) {
        this.currentMatcher.onNextFrame(l10);
        FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher = this.currentMatcher;
        Object object = fixedFrameRateEstimator$Matcher.isSynced();
        boolean bl2 = true;
        int n10 = 0;
        if (object && !(object = this.switchToCandidateMatcherWhenSynced)) {
            this.candidateMatcherActive = false;
        } else {
            long l11 = this.lastFramePresentationTimeNs;
            long l12 = -9223372036854775807L;
            long l13 = l11 - l12;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object) {
                object = this.candidateMatcherActive;
                if (!object || (object = (fixedFrameRateEstimator$Matcher = this.candidateMatcher).isLastFrameOutlier())) {
                    this.candidateMatcher.reset();
                    fixedFrameRateEstimator$Matcher = this.candidateMatcher;
                    l11 = this.lastFramePresentationTimeNs;
                    fixedFrameRateEstimator$Matcher.onNextFrame(l11);
                }
                this.candidateMatcherActive = bl2;
                fixedFrameRateEstimator$Matcher = this.candidateMatcher;
                fixedFrameRateEstimator$Matcher.onNextFrame(l10);
            }
        }
        object = this.candidateMatcherActive;
        if (object && (object = (fixedFrameRateEstimator$Matcher = this.candidateMatcher).isSynced())) {
            FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher2;
            fixedFrameRateEstimator$Matcher = this.currentMatcher;
            this.currentMatcher = fixedFrameRateEstimator$Matcher2 = this.candidateMatcher;
            this.candidateMatcher = fixedFrameRateEstimator$Matcher;
            this.candidateMatcherActive = false;
            this.switchToCandidateMatcherWhenSynced = false;
        }
        this.lastFramePresentationTimeNs = l10;
        FixedFrameRateEstimator$Matcher fixedFrameRateEstimator$Matcher3 = this.currentMatcher;
        int n11 = fixedFrameRateEstimator$Matcher3.isSynced();
        if (n11 == 0) {
            n11 = this.framesWithoutSyncCount;
            n10 = n11 + 1;
        }
        this.framesWithoutSyncCount = n10;
    }

    public void reset() {
        this.currentMatcher.reset();
        this.candidateMatcher.reset();
        this.candidateMatcherActive = false;
        this.lastFramePresentationTimeNs = -9223372036854775807L;
        this.framesWithoutSyncCount = 0;
    }
}

