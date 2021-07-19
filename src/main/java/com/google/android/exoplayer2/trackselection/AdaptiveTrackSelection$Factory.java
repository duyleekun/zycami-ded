/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.collect.ImmutableList;

public class AdaptiveTrackSelection$Factory
implements ExoTrackSelection$Factory {
    private final float bandwidthFraction;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private final int maxDurationForQualityDecreaseMs;
    private final int minDurationForQualityIncreaseMs;
    private final int minDurationToRetainAfterDiscardMs;

    public AdaptiveTrackSelection$Factory() {
        Clock clock = Clock.DEFAULT;
        this(10000, 25000, 25000, 0.7f, 0.75f, clock);
    }

    public AdaptiveTrackSelection$Factory(int n10, int n11, int n12, float f10) {
        Clock clock = Clock.DEFAULT;
        this(n10, n11, n12, f10, 0.75f, clock);
    }

    public AdaptiveTrackSelection$Factory(int n10, int n11, int n12, float f10, float f11, Clock clock) {
        this.minDurationForQualityIncreaseMs = n10;
        this.maxDurationForQualityDecreaseMs = n11;
        this.minDurationToRetainAfterDiscardMs = n12;
        this.bandwidthFraction = f10;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f11;
        this.clock = clock;
    }

    public AdaptiveTrackSelection createAdaptiveTrackSelection(TrackGroup trackGroup, BandwidthMeter bandwidthMeter, int[] nArray, ImmutableList immutableList) {
        long l10 = this.minDurationForQualityIncreaseMs;
        long l11 = this.maxDurationForQualityDecreaseMs;
        long l12 = this.minDurationToRetainAfterDiscardMs;
        float f10 = this.bandwidthFraction;
        float f11 = this.bufferedFractionToLiveEdgeForQualityIncrease;
        Clock clock = this.clock;
        AdaptiveTrackSelection adaptiveTrackSelection = new AdaptiveTrackSelection(trackGroup, nArray, bandwidthMeter, l10, l11, l12, f10, f11, immutableList, clock);
        return adaptiveTrackSelection;
    }

    public final ExoTrackSelection[] createTrackSelections(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray, BandwidthMeter bandwidthMeter, MediaSource$MediaPeriodId object, Timeline exoTrackSelectionArray) {
        int n10;
        object = AdaptiveTrackSelection.access$000(exoTrackSelection$DefinitionArray);
        int n11 = exoTrackSelection$DefinitionArray.length;
        exoTrackSelectionArray = new ExoTrackSelection[n11];
        for (int i10 = 0; i10 < (n10 = exoTrackSelection$DefinitionArray.length); ++i10) {
            Object object2;
            int[] nArray;
            int n12;
            Object object3 = exoTrackSelection$DefinitionArray[i10];
            if (object3 == null || (n12 = (nArray = ((ExoTrackSelection$Definition)object3).tracks).length) == 0) continue;
            n12 = nArray.length;
            int n13 = 1;
            if (n12 == n13) {
                TrackGroup trackGroup = ((ExoTrackSelection$Definition)object3).group;
                int n14 = nArray[0];
                int n15 = ((ExoTrackSelection$Definition)object3).reason;
                object3 = ((ExoTrackSelection$Definition)object3).data;
                object2 = new FixedTrackSelection(trackGroup, n14, n15, object3);
            } else {
                object3 = ((ExoTrackSelection$Definition)object3).group;
                object2 = (ImmutableList)object.get(i10);
                object2 = this.createAdaptiveTrackSelection((TrackGroup)object3, bandwidthMeter, nArray, (ImmutableList)object2);
            }
            exoTrackSelectionArray[i10] = object2;
        }
        return exoTrackSelectionArray;
    }
}

