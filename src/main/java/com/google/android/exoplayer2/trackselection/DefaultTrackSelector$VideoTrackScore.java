/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.AbstractCollection;
import java.util.Comparator;

public final class DefaultTrackSelector$VideoTrackScore
implements Comparable {
    private final int bitrate;
    public final boolean isWithinMaxConstraints;
    private final boolean isWithinMinConstraints;
    private final boolean isWithinRendererCapabilities;
    private final DefaultTrackSelector$Parameters parameters;
    private final int pixelCount;
    private final int preferredMimeTypeMatchIndex;

    public DefaultTrackSelector$VideoTrackScore(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int n10, boolean n11) {
        Object object;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        int n12;
        int n13;
        this.parameters = defaultTrackSelector$Parameters;
        int n14 = -1082130432;
        float f17 = -1.0f;
        boolean bl2 = true;
        float f18 = Float.MIN_VALUE;
        int n15 = 0;
        int n16 = -1;
        if (!(n11 == 0 || (n13 = format.width) != n16 && n13 > (n12 = defaultTrackSelector$Parameters.maxVideoWidth) || (n13 = format.height) != n16 && n13 > (n12 = defaultTrackSelector$Parameters.maxVideoHeight) || (n12 = (int)((f16 = (f15 = format.frameRate) - f17) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) != 0 && (n13 = (int)((f14 = f15 - (f13 = (float)(n12 = defaultTrackSelector$Parameters.maxVideoFrameRate))) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1))) > 0 || (n13 = format.bitrate) != n16 && n13 > (n12 = defaultTrackSelector$Parameters.maxVideoBitrate))) {
            n13 = (int)(bl2 ? 1 : 0);
            f15 = f18;
        } else {
            n13 = 0;
            f15 = 0.0f;
        }
        this.isWithinMaxConstraints = n13;
        if (n11 == 0 || (n11 = format.width) != n16 && n11 < (n13 = defaultTrackSelector$Parameters.minVideoWidth) || (n11 = format.height) != n16 && n11 < (n13 = defaultTrackSelector$Parameters.minVideoHeight) || (n14 = (int)((f12 = (f11 = format.frameRate) - f17) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != 0 && (n11 = (int)((f10 = f11 - (f17 = (float)(n14 = defaultTrackSelector$Parameters.minVideoFrameRate))) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) < 0 || (n11 = format.bitrate) != n16 && n11 < (n14 = defaultTrackSelector$Parameters.minVideoBitrate)) {
            bl2 = false;
            f18 = 0.0f;
        }
        this.isWithinMinConstraints = bl2;
        n10 = (int)(DefaultTrackSelector.isSupported(n10, false) ? 1 : 0);
        this.isWithinRendererCapabilities = n10;
        this.bitrate = n10 = format.bitrate;
        this.pixelCount = n10 = format.getPixelCount();
        n10 = -1 >>> 1;
        while (n15 < (n11 = ((AbstractCollection)(object = defaultTrackSelector$Parameters.preferredVideoMimeTypes)).size())) {
            Object e10;
            object = format.sampleMimeType;
            if (object != null && (n11 = (int)(((String)object).equals(e10 = defaultTrackSelector$Parameters.preferredVideoMimeTypes.get(n15)) ? 1 : 0)) != 0) {
                n10 = n15;
                break;
            }
            ++n15;
        }
        this.preferredMimeTypeMatchIndex = n10;
    }

    public int compareTo(DefaultTrackSelector$VideoTrackScore comparable) {
        boolean bl2 = this.isWithinMaxConstraints;
        Ordering ordering = bl2 && (bl2 = this.isWithinRendererCapabilities) ? DefaultTrackSelector.access$300() : DefaultTrackSelector.access$300().reverse();
        ComparisonChain comparisonChain = ComparisonChain.start();
        int n10 = this.isWithinRendererCapabilities;
        int n11 = comparable.isWithinRendererCapabilities;
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        n10 = this.isWithinMaxConstraints;
        n11 = comparable.isWithinMaxConstraints;
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        n10 = this.isWithinMinConstraints;
        n11 = comparable.isWithinMinConstraints;
        comparisonChain = comparisonChain.compareFalseFirst(n10 != 0, n11 != 0);
        Integer n12 = this.preferredMimeTypeMatchIndex;
        Integer n13 = comparable.preferredMimeTypeMatchIndex;
        Object object = Ordering.natural().reverse();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object);
        n10 = this.bitrate;
        n12 = n10;
        n11 = comparable.bitrate;
        n13 = n11;
        object = this.parameters;
        boolean bl3 = ((DefaultTrackSelector$Parameters)object).forceLowestBitrate;
        object = bl3 ? DefaultTrackSelector.access$300().reverse() : DefaultTrackSelector.access$400();
        comparisonChain = comparisonChain.compare(n12, n13, (Comparator)object);
        n12 = this.pixelCount;
        n13 = comparable.pixelCount;
        comparisonChain = comparisonChain.compare(n12, n13, ordering);
        n12 = this.bitrate;
        comparable = Integer.valueOf(comparable.bitrate);
        return comparisonChain.compare(n12, comparable, ordering).result();
    }
}

