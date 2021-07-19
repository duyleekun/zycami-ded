/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class MappingTrackSelector$MappedTrackInfo {
    public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
    public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
    public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
    public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
    private final int rendererCount;
    private final int[][][] rendererFormatSupports;
    private final int[] rendererMixedMimeTypeAdaptiveSupports;
    private final String[] rendererNames;
    private final TrackGroupArray[] rendererTrackGroups;
    private final int[] rendererTrackTypes;
    private final TrackGroupArray unmappedTrackGroups;

    public MappingTrackSelector$MappedTrackInfo(String[] stringArray, int[] nArray, TrackGroupArray[] trackGroupArrayArray, int[] nArray2, int[][][] nArray3, TrackGroupArray trackGroupArray) {
        int n10;
        this.rendererNames = stringArray;
        this.rendererTrackTypes = nArray;
        this.rendererTrackGroups = trackGroupArrayArray;
        this.rendererFormatSupports = nArray3;
        this.rendererMixedMimeTypeAdaptiveSupports = nArray2;
        this.unmappedTrackGroups = trackGroupArray;
        this.rendererCount = n10 = nArray.length;
    }

    public int getAdaptiveSupport(int n10, int n11, boolean bl2) {
        TrackGroup trackGroup = this.rendererTrackGroups[n10].get(n11);
        int n12 = trackGroup.length;
        int[] nArray = new int[n12];
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14;
            int n15 = this.getTrackSupport(n10, n11, i10);
            if (n15 != (n14 = 4) && (!bl2 || n15 != (n14 = 3))) continue;
            n15 = n13 + 1;
            nArray[n13] = i10;
            n13 = n15;
        }
        int[] nArray2 = Arrays.copyOf(nArray, n13);
        return this.getAdaptiveSupport(n10, n11, nArray2);
    }

    public int getAdaptiveSupport(int n10, int n11, int[] nArray) {
        int n12;
        int n13 = 16;
        String string2 = null;
        int n14 = 0;
        int n15 = 0;
        int[] nArray2 = null;
        for (int i10 = 0; i10 < (n12 = nArray.length); ++i10) {
            n12 = nArray[i10];
            TrackGroup trackGroup = this.rendererTrackGroups[n10].get(n11);
            String string3 = trackGroup.getFormat((int)n12).sampleMimeType;
            int n16 = n15 + 1;
            if (n15 == 0) {
                string2 = string3;
            } else {
                n15 = Util.areEqual(string2, string3) ^ 1;
                n14 |= n15;
            }
            nArray2 = this.rendererFormatSupports[n10][n11];
            n15 = RendererCapabilities.getAdaptiveSupport(nArray2[i10]);
            n13 = Math.min(n13, n15);
            n15 = n16;
        }
        if (n14 != 0) {
            int[] nArray3 = this.rendererMixedMimeTypeAdaptiveSupports;
            n10 = nArray3[n10];
            n13 = Math.min(n13, n10);
        }
        return n13;
    }

    public int getRendererCount() {
        return this.rendererCount;
    }

    public String getRendererName(int n10) {
        return this.rendererNames[n10];
    }

    public int getRendererSupport(int n10) {
        int[][][] nArray = this.rendererFormatSupports;
        Object object = nArray[n10];
        int n11 = ((int[][])object).length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int[] nArray2 = object[i10];
            int n13 = nArray2.length;
            for (int i11 = 0; i11 < n13; ++i11) {
                int n14 = RendererCapabilities.getFormatSupport(nArray2[i11]);
                int n15 = 2;
                int n16 = 1;
                if (n14 != 0 && n14 != n16 && n14 != n15) {
                    n16 = 3;
                    if (n14 != n16) {
                        n10 = 4;
                        if (n14 == n10) {
                            return n16;
                        }
                        object = new IllegalStateException;
                        object();
                        throw object;
                    }
                } else {
                    n15 = n16;
                }
                n12 = Math.max(n12, n15);
            }
        }
        return n12;
    }

    public int getRendererType(int n10) {
        return this.rendererTrackTypes[n10];
    }

    public TrackGroupArray getTrackGroups(int n10) {
        return this.rendererTrackGroups[n10];
    }

    public int getTrackSupport(int n10, int n11, int n12) {
        return RendererCapabilities.getFormatSupport(this.rendererFormatSupports[n10][n11][n12]);
    }

    public int getTypeSupport(int n10) {
        int n11;
        int n12 = 0;
        for (int i10 = 0; i10 < (n11 = this.rendererCount); ++i10) {
            int[] nArray = this.rendererTrackTypes;
            n11 = nArray[i10];
            if (n11 != n10) continue;
            n11 = this.getRendererSupport(i10);
            n12 = Math.max(n12, n11);
        }
        return n12;
    }

    public TrackGroupArray getUnmappedTrackGroups() {
        return this.unmappedTrackGroups;
    }
}

