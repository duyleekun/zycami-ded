/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil$AdaptiveTrackSelectionFactory;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import d.h.a.a.o0.d;
import java.util.Random;

public final class RandomTrackSelection$Factory
implements ExoTrackSelection$Factory {
    private final Random random;

    public RandomTrackSelection$Factory() {
        Random random;
        this.random = random = new Random();
    }

    public RandomTrackSelection$Factory(int n10) {
        Random random;
        long l10 = n10;
        this.random = random = new Random(l10);
    }

    private /* synthetic */ ExoTrackSelection a(ExoTrackSelection$Definition object) {
        TrackGroup trackGroup = ((ExoTrackSelection$Definition)object).group;
        object = ((ExoTrackSelection$Definition)object).tracks;
        Random random = this.random;
        RandomTrackSelection randomTrackSelection = new RandomTrackSelection(trackGroup, (int[])object, random);
        return randomTrackSelection;
    }

    public /* synthetic */ ExoTrackSelection b(ExoTrackSelection$Definition exoTrackSelection$Definition) {
        return this.a(exoTrackSelection$Definition);
    }

    public ExoTrackSelection[] createTrackSelections(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray, BandwidthMeter object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline timeline) {
        object = new d(this);
        return TrackSelectionUtil.createTrackSelectionsForDefinitions(exoTrackSelection$DefinitionArray, (TrackSelectionUtil$AdaptiveTrackSelectionFactory)object);
    }
}

