/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Definition;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AdaptiveTrackSelection
extends BaseTrackSelection {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.7f;
    public static final float DEFAULT_BUFFERED_FRACTION_TO_LIVE_EDGE_FOR_QUALITY_INCREASE = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    private static final long MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS = 1000L;
    private final ImmutableList adaptationCheckpoints;
    private final float bandwidthFraction;
    private final BandwidthMeter bandwidthMeter;
    private final float bufferedFractionToLiveEdgeForQualityIncrease;
    private final Clock clock;
    private MediaChunk lastBufferEvaluationMediaChunk;
    private long lastBufferEvaluationMs;
    private final long maxDurationForQualityDecreaseUs;
    private final long minDurationForQualityIncreaseUs;
    private final long minDurationToRetainAfterDiscardUs;
    private float playbackSpeed;
    private int reason;
    private int selectedIndex;

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] nArray, BandwidthMeter bandwidthMeter) {
        ImmutableList immutableList = ImmutableList.of();
        Clock clock = Clock.DEFAULT;
        this(trackGroup, nArray, bandwidthMeter, 10000L, 25000L, 25000L, 0.7f, 0.75f, immutableList, clock);
    }

    public AdaptiveTrackSelection(TrackGroup object, int[] nArray, BandwidthMeter bandwidthMeter, long l10, long l11, long l12, float f10, float f11, List list, Clock clock) {
        super((TrackGroup)object, nArray);
        this.bandwidthMeter = bandwidthMeter;
        long l13 = 1000L;
        this.minDurationForQualityIncreaseUs = l10 *= l13;
        this.maxDurationForQualityDecreaseUs = l11 *= l13;
        this.minDurationToRetainAfterDiscardUs = l12 *= l13;
        this.bandwidthFraction = f10;
        this.bufferedFractionToLiveEdgeForQualityIncrease = f11;
        this.adaptationCheckpoints = object = ImmutableList.copyOf((Collection)list);
        this.clock = clock;
        this.playbackSpeed = 1.0f;
        this.reason = 0;
        this.lastBufferEvaluationMs = -9223372036854775807L;
    }

    public static /* synthetic */ ImmutableList access$000(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray) {
        return AdaptiveTrackSelection.getAdaptationCheckpoints(exoTrackSelection$DefinitionArray);
    }

    private static void addCheckpoint(List list, long[] lArray) {
        int n10;
        int n11;
        int n12 = 0;
        long l10 = 0L;
        ImmutableList$Builder immutableList$Builder = null;
        for (n11 = 0; n11 < (n10 = lArray.length); ++n11) {
            long l11 = lArray[n11];
            l10 += l11;
        }
        while (n12 < (n11 = list.size())) {
            immutableList$Builder = (ImmutableList$Builder)list.get(n12);
            if (immutableList$Builder != null) {
                long l12 = lArray[n12];
                AdaptiveTrackSelection$AdaptationCheckpoint adaptiveTrackSelection$AdaptationCheckpoint = new AdaptiveTrackSelection$AdaptationCheckpoint(l10, l12);
                immutableList$Builder.add(adaptiveTrackSelection$AdaptationCheckpoint);
            }
            ++n12;
        }
    }

    private int determineIdealSelectedIndex(long l10) {
        int n10;
        long l11 = this.getAllocatedBandwidth();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.length); ++i10) {
            float f10;
            int n12;
            long l12 = Long.MIN_VALUE;
            long l13 = l10 - l12;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 != 0 && (n10 = (int)(this.isBlacklisted(i10, l10) ? 1 : 0)) != 0) continue;
            Format format = this.getFormat(i10);
            n11 = (int)(this.canSelectFormat(format, n12 = format.bitrate, f10 = this.playbackSpeed, l11) ? 1 : 0);
            if (n11 != 0) {
                return i10;
            }
            n11 = i10;
        }
        return n11;
    }

    private static ImmutableList getAdaptationCheckpoints(ExoTrackSelection$Definition[] object) {
        Object object2;
        int n10;
        Object object3;
        int n11;
        long l10;
        int n12;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n13 = 0;
        int n14 = 0;
        Object object4 = null;
        while (true) {
            n12 = ((ExoTrackSelection$Definition[])object).length;
            l10 = 0L;
            n11 = 1;
            if (n14 >= n12) break;
            object3 = object[n14];
            if (object3 != null && (n12 = ((Object)(object3 = (Object)object[n14].tracks)).length) > n11) {
                object3 = ImmutableList.builder();
                AdaptiveTrackSelection$AdaptationCheckpoint adaptiveTrackSelection$AdaptationCheckpoint = new AdaptiveTrackSelection$AdaptationCheckpoint(l10, l10);
                ((ImmutableList$Builder)object3).add(adaptiveTrackSelection$AdaptationCheckpoint);
                arrayList.add(object3);
            } else {
                n12 = 0;
                object3 = null;
                arrayList.add(null);
            }
            ++n14;
        }
        object4 = AdaptiveTrackSelection.getSortedTrackBitrates((ExoTrackSelection$Definition[])object);
        n12 = ((long[][])object4).length;
        object3 = new int[n12];
        int n15 = ((long[][])object4).length;
        long[] lArray = new long[n15];
        Integer n16 = null;
        for (n10 = 0; n10 < (object2 = ((long[][])object4).length); ++n10) {
            long l11;
            long[] lArray2 = object4[n10];
            object2 = lArray2.length;
            if (object2 == 0) {
                l11 = l10;
            } else {
                lArray2 = object4[n10];
                l11 = lArray2[0];
            }
            lArray[n10] = l11;
        }
        AdaptiveTrackSelection.addCheckpoint(arrayList, lArray);
        ImmutableList immutableList = AdaptiveTrackSelection.getSwitchOrder((long[][])object4);
        for (int i10 = 0; i10 < (n10 = immutableList.size()); ++i10) {
            long l12;
            n16 = (Integer)immutableList.get(i10);
            n10 = n16;
            object2 = object3[n10] + n11;
            object3[n10] = object2;
            long[] lArray3 = object4[n10];
            lArray[n10] = l12 = lArray3[object2];
            AdaptiveTrackSelection.addCheckpoint(arrayList, lArray);
        }
        object4 = null;
        for (n14 = 0; n14 < (n12 = ((ExoTrackSelection$Definition[])object).length); ++n14) {
            object3 = arrayList.get(n14);
            if (object3 == null) continue;
            long l13 = lArray[n14];
            long l14 = 2;
            lArray[n14] = l13 *= l14;
        }
        AdaptiveTrackSelection.addCheckpoint(arrayList, lArray);
        object = ImmutableList.builder();
        while (n13 < (n14 = arrayList.size())) {
            object4 = (ImmutableList$Builder)arrayList.get(n13);
            object4 = object4 == null ? (Object)ImmutableList.of() : (Object)((ImmutableList$Builder)object4).build();
            ((ImmutableList$Builder)object).add(object4);
            ++n13;
        }
        return ((ImmutableList$Builder)object).build();
    }

    private long getAllocatedBandwidth() {
        long l10;
        Object object;
        int n10;
        int n11;
        BandwidthMeter bandwidthMeter = this.bandwidthMeter;
        float f10 = bandwidthMeter.getBitrateEstimate();
        float f11 = this.bandwidthFraction;
        long l11 = (long)(f10 *= f11);
        Object object2 = this.adaptationCheckpoints;
        int n12 = (int)(((AbstractCollection)object2).isEmpty() ? 1 : 0);
        if (n12 != 0) {
            return l11;
        }
        n12 = 1;
        float f12 = Float.MIN_VALUE;
        float f13 = f12;
        for (n11 = n12; n11 < (n10 = ((AbstractCollection)(object = this.adaptationCheckpoints)).size() - n12); ++n11) {
            object = (AdaptiveTrackSelection$AdaptationCheckpoint)this.adaptationCheckpoints.get(n11);
            l10 = ((AdaptiveTrackSelection$AdaptationCheckpoint)object).totalBandwidth;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 >= 0) break;
        }
        object2 = this.adaptationCheckpoints;
        n10 = n11 + -1;
        object2 = (AdaptiveTrackSelection$AdaptationCheckpoint)object2.get(n10);
        AdaptiveTrackSelection$AdaptationCheckpoint adaptiveTrackSelection$AdaptationCheckpoint = (AdaptiveTrackSelection$AdaptationCheckpoint)this.adaptationCheckpoints.get(n11);
        l10 = ((AdaptiveTrackSelection$AdaptationCheckpoint)object2).totalBandwidth;
        f10 = l11 - l10;
        f11 = adaptiveTrackSelection$AdaptationCheckpoint.totalBandwidth - l10;
        long l13 = ((AdaptiveTrackSelection$AdaptationCheckpoint)object2).allocatedBandwidth;
        f13 = adaptiveTrackSelection$AdaptationCheckpoint.allocatedBandwidth - l13;
        long l14 = (long)((f10 /= f11) * f13);
        return l13 + l14;
    }

    private static long[][] getSortedTrackBitrates(ExoTrackSelection$Definition[] exoTrackSelection$DefinitionArray) {
        int n10;
        int n11 = exoTrackSelection$DefinitionArray.length;
        long[][] lArrayArray = new long[n11][];
        for (int i10 = 0; i10 < (n10 = exoTrackSelection$DefinitionArray.length); ++i10) {
            Object object;
            int n12;
            Object object2 = exoTrackSelection$DefinitionArray[i10];
            if (object2 == null) {
                object2 = new long[0];
                lArrayArray[i10] = (long[])object2;
                continue;
            }
            long[] lArray = new long[((ExoTrackSelection$Definition)object2).tracks.length];
            lArrayArray[i10] = lArray;
            lArray = null;
            for (int i11 = 0; i11 < (n12 = ((int[])(object = ((ExoTrackSelection$Definition)object2).tracks)).length); ++i11) {
                long l10;
                long[] lArray2 = lArrayArray[i10];
                TrackGroup trackGroup = ((ExoTrackSelection$Definition)object2).group;
                int n13 = object[i11];
                object = trackGroup.getFormat(n13);
                n13 = object.bitrate;
                lArray2[i11] = l10 = (long)n13;
            }
            object2 = lArrayArray[i10];
            Arrays.sort((long[])object2);
        }
        return lArrayArray;
    }

    private static ImmutableList getSwitchOrder(long[][] lArray) {
        int n10;
        long[][] lArray2 = lArray;
        ListMultimap listMultimap = MultimapBuilder.treeKeys().arrayListValues().build();
        for (int i10 = 0; i10 < (n10 = lArray2.length); ++i10) {
            double d10;
            long[] lArray3 = lArray2[i10];
            n10 = lArray3.length;
            int n11 = 1;
            if (n10 <= n11) continue;
            lArray3 = lArray2[i10];
            n10 = lArray3.length;
            double[] dArray = new double[n10];
            int n12 = 0;
            while (true) {
                long[] lArray4 = lArray2[i10];
                int n13 = lArray4.length;
                long l10 = 0L;
                d10 = 0.0;
                if (n12 >= n13) break;
                lArray4 = lArray2[i10];
                long l11 = lArray4[n12];
                long l12 = -1;
                long l13 = l11 - l12;
                n13 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n13 != 0) {
                    lArray4 = lArray2[i10];
                    l10 = lArray4[n12];
                    double d11 = l10;
                    d10 = Math.log(d11);
                }
                dArray[n12] = d10;
                ++n12;
            }
            double d12 = dArray[n10 += -1];
            double d13 = dArray[0];
            d12 -= d13;
            int n14 = 0;
            while (n14 < n10) {
                double d14 = 0.5;
                double d15 = dArray[n14];
                double d16 = dArray[++n14];
                d15 = (d15 + d16) * d14;
                Object object = d12 == d10 ? 0 : (d12 > d10 ? 1 : -1);
                if (object == false) {
                    d14 = 1.0;
                } else {
                    d14 = dArray[0];
                    d15 -= d14;
                    d14 = d15 / d12;
                }
                Double d17 = d14;
                Integer n15 = i10;
                listMultimap.put(d17, n15);
            }
        }
        return ImmutableList.copyOf(listMultimap.values());
    }

    private long minDurationForQualityIncreaseUs(long l10) {
        long l11;
        long l12 = -9223372036854775807L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object != false && (object = (l11 = l10 - (l12 = this.minDurationForQualityIncreaseUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0 ? (Object)1 : (Object)0;
        if (object != false) {
            float f10 = l10;
            float f11 = this.bufferedFractionToLiveEdgeForQualityIncrease;
            l10 = (long)(f10 *= f11);
        } else {
            l10 = this.minDurationForQualityIncreaseUs;
        }
        return l10;
    }

    public boolean canSelectFormat(Format format, int n10, float f10, long l10) {
        float f11 = (float)n10 * f10;
        long l11 = Math.round(f11);
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            object = 1;
            f11 = Float.MIN_VALUE;
        } else {
            object = 0;
            f11 = 0.0f;
        }
        return (boolean)object;
    }

    public void disable() {
        this.lastBufferEvaluationMediaChunk = null;
    }

    public void enable() {
        this.lastBufferEvaluationMs = -9223372036854775807L;
        this.lastBufferEvaluationMediaChunk = null;
    }

    public int evaluateQueueSize(long l10, List list) {
        long l11;
        MediaChunk mediaChunk;
        Object object = this.clock;
        long l12 = object.elapsedRealtime();
        int n10 = this.shouldEvaluateQueueSize(l12, list);
        if (n10 == 0) {
            return list.size();
        }
        this.lastBufferEvaluationMs = l12;
        n10 = list.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            mediaChunk = null;
        } else {
            mediaChunk = (MediaChunk)Iterables.getLast(list);
        }
        this.lastBufferEvaluationMediaChunk = mediaChunk;
        n10 = list.isEmpty();
        if (n10 != 0) {
            return 0;
        }
        n10 = list.size();
        int n11 = n10 + -1;
        Object object2 = (MediaChunk)list.get(n11);
        long l13 = ((Chunk)object2).startTimeUs - l10;
        float f10 = this.playbackSpeed;
        long l14 = (l13 = Util.getPlayoutDurationForMediaDuration(l13, f10)) - (l11 = this.getMinDurationToRetainAfterDiscardUs());
        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n11 < 0) {
            return n10;
        }
        int n12 = this.determineIdealSelectedIndex(l12);
        object = this.getFormat(n12);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13;
            int n14;
            MediaChunk mediaChunk2 = (MediaChunk)list.get(i10);
            object2 = mediaChunk2.trackFormat;
            long l15 = mediaChunk2.startTimeUs - l10;
            float f11 = this.playbackSpeed;
            long l16 = (l15 = Util.getPlayoutDurationForMediaDuration(l15, f11)) - l11;
            Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object3 < 0 || (object3 = (Object)((Format)object2).bitrate) >= (n14 = ((Format)object).bitrate) || (object3 = (Object)((Format)object2).height) == (n14 = -1) || object3 >= (n13 = 720) || (n11 = ((Format)object2).width) == n14 || n11 >= (n14 = 1280) || object3 >= (n11 = ((Format)object).height)) continue;
            return i10;
        }
        return n10;
    }

    public long getMinDurationToRetainAfterDiscardUs() {
        return this.minDurationToRetainAfterDiscardUs;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void onPlaybackSpeed(float f10) {
        this.playbackSpeed = f10;
    }

    public boolean shouldEvaluateQueueSize(long l10, List list) {
        MediaChunk mediaChunk;
        MediaChunk mediaChunk2;
        long l11;
        int n10;
        long l12 = this.lastBufferEvaluationMs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object != false && (n10 = (l11 = (l10 -= l12) - (l12 = 1000L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0 && ((n10 = (int)(list.isEmpty() ? 1 : 0)) != 0 || (n10 = (int)((mediaChunk2 = (MediaChunk)Iterables.getLast(list)).equals(mediaChunk = this.lastBufferEvaluationMediaChunk) ? 1 : 0)) != 0)) {
            n10 = 0;
            mediaChunk2 = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void updateSelectedTrack(long l10, long l11, long l12, List object, MediaChunkIterator[] mediaChunkIteratorArray) {
        Object object2 = this.clock;
        l10 = object2.elapsedRealtime();
        int n10 = this.reason;
        if (n10 == 0) {
            int n11;
            this.reason = 1;
            this.selectedIndex = n11 = this.determineIdealSelectedIndex(l10);
            return;
        }
        int n12 = this.selectedIndex;
        int n13 = object.isEmpty();
        int n14 = -1;
        if (n13 != 0) {
            n13 = n14;
        } else {
            Format format = ((MediaChunk)Iterables.getLast((Iterable)object)).trackFormat;
            n13 = this.indexOf(format);
        }
        if (n13 != n14) {
            object = (MediaChunk)Iterables.getLast((Iterable)object);
            n10 = ((Chunk)object).trackSelectionReason;
            n12 = n13;
        }
        int n15 = this.determineIdealSelectedIndex(l10);
        int n16 = this.isBlacklisted(n12, l10);
        if (n16 == 0) {
            long l13;
            int n17;
            long l14;
            long l15;
            object2 = this.getFormat(n12);
            Format format = this.getFormat(n15);
            n13 = format.bitrate;
            n14 = ((Format)object2).bitrate;
            if (n13 > n14 && (l15 = (l14 = l11 - (l12 = this.minDurationForQualityIncreaseUs(l12))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) < 0 || (n17 = format.bitrate) < (n16 = ((Format)object2).bitrate) && (n16 = (int)((l13 = l11 - (l10 = this.maxDurationForQualityDecreaseUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) >= 0) {
                n15 = n12;
            }
        }
        if (n15 != n12) {
            n10 = 3;
        }
        this.reason = n10;
        this.selectedIndex = n15;
    }
}

