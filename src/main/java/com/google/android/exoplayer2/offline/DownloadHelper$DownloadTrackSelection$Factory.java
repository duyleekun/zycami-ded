/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.offline.DownloadHelper$1;
import com.google.android.exoplayer2.offline.DownloadHelper$DownloadTrackSelection;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

public final class DownloadHelper$DownloadTrackSelection$Factory
implements ExoTrackSelection$Factory {
    private DownloadHelper$DownloadTrackSelection$Factory() {
    }

    public /* synthetic */ DownloadHelper$DownloadTrackSelection$Factory(DownloadHelper$1 downloadHelper$1) {
        this();
    }

    public ExoTrackSelection[] createTrackSelections(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray, BandwidthMeter exoTrackSelectionArray, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline object) {
        int n10;
        int n11 = exoTrackSelection$DefinitionArray.length;
        exoTrackSelectionArray = new ExoTrackSelection[n11];
        for (int i10 = 0; i10 < (n10 = exoTrackSelection$DefinitionArray.length); ++i10) {
            object = exoTrackSelection$DefinitionArray[i10];
            if (object == null) {
                n10 = 0;
                object = null;
            } else {
                TrackGroup trackGroup = exoTrackSelection$DefinitionArray[i10].group;
                int[] nArray = exoTrackSelection$DefinitionArray[i10].tracks;
                object = new DownloadHelper$DownloadTrackSelection(trackGroup, nArray);
            }
            exoTrackSelectionArray[i10] = object;
        }
        return exoTrackSelectionArray;
    }
}

