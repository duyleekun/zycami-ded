/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final ExoTrackSelection[] selections;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArray, ExoTrackSelection[] exoTrackSelectionArray, Object object) {
        int n10;
        this.rendererConfigurations = rendererConfigurationArray;
        exoTrackSelectionArray = (ExoTrackSelection[])exoTrackSelectionArray.clone();
        this.selections = exoTrackSelectionArray;
        this.info = object;
        this.length = n10 = rendererConfigurationArray.length;
    }

    public boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        ExoTrackSelection[] exoTrackSelectionArray;
        int n10;
        ExoTrackSelection[] exoTrackSelectionArray2;
        int n11;
        if (trackSelectorResult != null && (n11 = (exoTrackSelectionArray2 = trackSelectorResult.selections).length) == (n10 = (exoTrackSelectionArray = this.selections).length)) {
            exoTrackSelectionArray2 = null;
            for (n11 = 0; n11 < (n10 = (exoTrackSelectionArray = this.selections).length); ++n11) {
                n10 = (int)(this.isEquivalent(trackSelectorResult, n11) ? 1 : 0);
                if (n10 != 0) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isEquivalent(TrackSelectorResult object, int n10) {
        boolean bl2;
        boolean bl3 = false;
        if (object == null) {
            return false;
        }
        Object object2 = this.rendererConfigurations[n10];
        RendererConfiguration rendererConfiguration = ((TrackSelectorResult)object).rendererConfigurations[n10];
        boolean bl4 = Util.areEqual(object2, rendererConfiguration);
        if (bl4 && (bl2 = Util.areEqual(object2 = this.selections[n10], object = ((TrackSelectorResult)object).selections[n10]))) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean isRendererEnabled(int n10) {
        RendererConfiguration[] rendererConfigurationArray = this.rendererConfigurations;
        RendererConfiguration rendererConfiguration = rendererConfigurationArray[n10];
        if (rendererConfiguration != null) {
            n10 = 1;
        } else {
            n10 = 0;
            rendererConfiguration = null;
        }
        return n10 != 0;
    }
}

