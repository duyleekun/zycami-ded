/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.FixedTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil$AdaptiveTrackSelectionFactory;

public final class TrackSelectionUtil {
    private TrackSelectionUtil() {
    }

    public static ExoTrackSelection[] createTrackSelectionsForDefinitions(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray, TrackSelectionUtil$AdaptiveTrackSelectionFactory trackSelectionUtil$AdaptiveTrackSelectionFactory) {
        int n10;
        int n11 = exoTrackSelection$DefinitionArray.length;
        ExoTrackSelection[] exoTrackSelectionArray = new ExoTrackSelection[n11];
        int n12 = 0;
        ExoTrackSelection exoTrackSelection = null;
        for (int i10 = 0; i10 < (n10 = exoTrackSelection$DefinitionArray.length); ++i10) {
            Object object = exoTrackSelection$DefinitionArray[i10];
            int n13 = 1;
            if (object == null) continue;
            int[] nArray = ((ExoTrackSelection$Definition)object).tracks;
            int n14 = nArray.length;
            if (n14 > n13 && n12 == 0) {
                exoTrackSelectionArray[i10] = exoTrackSelection = trackSelectionUtil$AdaptiveTrackSelectionFactory.createAdaptiveTrackSelection((ExoTrackSelection$Definition)object);
                n12 = n13;
                continue;
            }
            TrackGroup trackGroup = ((ExoTrackSelection$Definition)object).group;
            int n15 = nArray[0];
            int n16 = ((ExoTrackSelection$Definition)object).reason;
            object = ((ExoTrackSelection$Definition)object).data;
            FixedTrackSelection fixedTrackSelection = new FixedTrackSelection(trackGroup, n15, n16, object);
            exoTrackSelectionArray[i10] = fixedTrackSelection;
        }
        return exoTrackSelectionArray;
    }

    public static DefaultTrackSelector$Parameters updateParametersWithOverride(DefaultTrackSelector$Parameters object, int n10, TrackGroupArray trackGroupArray, boolean bl2, DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride) {
        object = ((DefaultTrackSelector$Parameters)object).buildUpon().clearSelectionOverrides(n10).setRendererDisabled(n10, bl2);
        if (defaultTrackSelector$SelectionOverride != null) {
            ((DefaultTrackSelector$ParametersBuilder)object).setSelectionOverride(n10, trackGroupArray, defaultTrackSelector$SelectionOverride);
        }
        return ((DefaultTrackSelector$ParametersBuilder)object).build();
    }
}

