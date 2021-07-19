/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.trackselection;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public abstract class MappingTrackSelector
extends TrackSelector {
    private MappingTrackSelector$MappedTrackInfo currentMappedTrackInfo;

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArray, TrackGroup trackGroup, int[] nArray, boolean bl2) {
        int n10;
        int n11 = rendererCapabilitiesArray.length;
        int n12 = 1;
        float f10 = Float.MIN_VALUE;
        int n13 = n12;
        int n14 = 0;
        for (int i10 = 0; i10 < (n10 = rendererCapabilitiesArray.length); ++i10) {
            int n15;
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArray[i10];
            int n16 = 0;
            for (int i11 = 0; i11 < (n15 = trackGroup.length); ++i11) {
                Format format = trackGroup.getFormat(i11);
                n15 = RendererCapabilities.getFormatSupport(rendererCapabilities.supportsFormat(format));
                n16 = Math.max(n16, n15);
            }
            n10 = nArray[i10];
            if (n10 == 0) {
                n10 = n12;
            } else {
                n10 = 0;
                rendererCapabilities = null;
            }
            if (n16 <= n14 && (n16 != n14 || !bl2 || n13 != 0 || n10 == 0)) continue;
            n11 = i10;
            n13 = n10;
            n14 = n16;
        }
        return n11;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) {
        int n10;
        int n11 = trackGroup.length;
        int[] nArray = new int[n11];
        for (int i10 = 0; i10 < (n10 = trackGroup.length); ++i10) {
            Format format = trackGroup.getFormat(i10);
            nArray[i10] = n10 = rendererCapabilities.supportsFormat(format);
        }
        return nArray;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArray) {
        int n10 = rendererCapabilitiesArray.length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArray[i10];
            nArray[i10] = n11 = rendererCapabilities.supportsMixedMimeTypeAdaptation();
        }
        return nArray;
    }

    public final MappingTrackSelector$MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object object) {
        this.currentMappedTrackInfo = object = (MappingTrackSelector$MappedTrackInfo)object;
    }

    public abstract Pair selectTracks(MappingTrackSelector$MappedTrackInfo var1, int[][][] var2, int[] var3, MediaSource$MediaPeriodId var4, Timeline var5);

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArray, TrackGroupArray trackGroupArray, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Timeline timeline) {
        RendererConfiguration[] rendererConfigurationArray;
        TrackGroup[] trackGroupArray2;
        Object object;
        Object object2;
        Object object3;
        int n10;
        int n11;
        Object object4 = rendererCapabilitiesArray;
        ExoTrackSelection[] exoTrackSelectionArray = trackGroupArray;
        int n12 = rendererCapabilitiesArray.length;
        int n13 = 1;
        Object object5 = new int[n12 += n13];
        int n14 = rendererCapabilitiesArray.length + n13;
        TrackGroup[][] trackGroupArrayArray = new TrackGroup[n14][];
        int n15 = rendererCapabilitiesArray.length + n13;
        int[][][] nArrayArray = new int[n15][][];
        int n16 = 0;
        Object object6 = null;
        for (n11 = 0; n11 < n14; ++n11) {
            n10 = exoTrackSelectionArray.length;
            object3 = new TrackGroup[n10];
            trackGroupArrayArray[n11] = object3;
            object2 = new int[n10][];
            nArrayArray[n11] = object2;
        }
        int[] nArray = MappingTrackSelector.getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArray);
        object6 = null;
        for (n11 = 0; n11 < (n10 = exoTrackSelectionArray.length); ++n11) {
            int n17;
            object2 = exoTrackSelectionArray.get(n11);
            object3 = object2.getFormat((int)0).sampleMimeType;
            int n18 = MimeTypes.getTrackType((String)object3);
            if (n18 == (n17 = 5)) {
                n18 = n13;
            } else {
                n18 = 0;
                object3 = null;
            }
            n18 = MappingTrackSelector.findRenderer(rendererCapabilitiesArray, (TrackGroup)object2, object5, n18 != 0);
            n17 = ((RendererCapabilities[])object4).length;
            if (n18 == n17) {
                n17 = object2.length;
                object = new int[n17];
            } else {
                object = MappingTrackSelector.getFormatSupport(object4[n18], (TrackGroup)object2);
            }
            int n19 = object5[n18];
            trackGroupArray2 = trackGroupArrayArray[n18];
            trackGroupArray2[n19] = object2;
            object2 = nArrayArray[n18];
            object2[n19] = (int[])object;
            object5[n18] = n10 = object5[n18] + n13;
        }
        object3 = new TrackGroupArray[((RendererCapabilities[])object4).length];
        object6 = new String[((RendererCapabilities[])object4).length];
        int n20 = ((RendererCapabilities[])object4).length;
        object2 = new int[n20];
        while (n16 < (n20 = ((RendererCapabilities[])object4).length)) {
            n20 = object5[n16];
            object = (TrackGroup[])Util.nullSafeArrayCopy(trackGroupArrayArray[n16], n20);
            rendererConfigurationArray = new TrackGroupArray((TrackGroup)object);
            object3[n16] = rendererConfigurationArray;
            rendererConfigurationArray = (RendererConfiguration[])nArrayArray[n16];
            exoTrackSelectionArray = (ExoTrackSelection[])((int[][])Util.nullSafeArrayCopy(rendererConfigurationArray, n20));
            nArrayArray[n16] = (int[][])exoTrackSelectionArray;
            exoTrackSelectionArray = object4[n16].getName();
            object6[n16] = exoTrackSelectionArray;
            exoTrackSelectionArray = object4[n16];
            n20 = exoTrackSelectionArray.getTrackType();
            object2[n16] = (int[])n20;
            ++n16;
        }
        n20 = ((RendererCapabilities[])object4).length;
        n20 = object5[n20];
        int n21 = ((RendererCapabilities[])object4).length;
        object4 = (TrackGroup[])Util.nullSafeArrayCopy(trackGroupArrayArray[n21], n20);
        trackGroupArray2 = new TrackGroupArray((TrackGroup[])object4);
        object = nArray;
        object4 = new MappingTrackSelector$MappedTrackInfo((String[])object6, (int[])object2, (TrackGroupArray[])object3, nArray, nArrayArray, (TrackGroupArray)trackGroupArray2);
        object6 = object4;
        object2 = nArrayArray;
        object3 = nArray;
        object = mediaSource$MediaPeriodId;
        exoTrackSelectionArray = this.selectTracks((MappingTrackSelector$MappedTrackInfo)object4, nArrayArray, nArray, mediaSource$MediaPeriodId, timeline);
        object5 = new TrackSelectorResult;
        rendererConfigurationArray = (RendererConfiguration[])exoTrackSelectionArray.first;
        exoTrackSelectionArray = (ExoTrackSelection[])exoTrackSelectionArray.second;
        object5(rendererConfigurationArray, exoTrackSelectionArray, object4);
        return object5;
    }
}

