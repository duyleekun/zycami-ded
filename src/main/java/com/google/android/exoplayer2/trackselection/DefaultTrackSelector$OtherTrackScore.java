/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.collect.ComparisonChain;

public final class DefaultTrackSelector$OtherTrackScore
implements Comparable {
    private final boolean isDefault;
    private final boolean isWithinRendererCapabilities;

    public DefaultTrackSelector$OtherTrackScore(Format format, int n10) {
        int n11 = format.selectionFlags;
        int n12 = 1;
        if ((n11 &= n12) == 0) {
            n12 = 0;
        }
        this.isDefault = n12;
        n11 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0);
        this.isWithinRendererCapabilities = n11;
    }

    public int compareTo(DefaultTrackSelector$OtherTrackScore defaultTrackSelector$OtherTrackScore) {
        ComparisonChain comparisonChain = ComparisonChain.start();
        boolean bl2 = this.isWithinRendererCapabilities;
        boolean bl3 = defaultTrackSelector$OtherTrackScore.isWithinRendererCapabilities;
        comparisonChain = comparisonChain.compareFalseFirst(bl2, bl3);
        bl2 = this.isDefault;
        boolean bl4 = defaultTrackSelector$OtherTrackScore.isDefault;
        return comparisonChain.compareFalseFirst(bl2, bl4).result();
    }
}

