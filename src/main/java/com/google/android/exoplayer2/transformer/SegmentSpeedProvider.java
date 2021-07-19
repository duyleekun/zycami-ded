/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.transformer.SpeedProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.TreeMap;

public class SegmentSpeedProvider
implements SpeedProvider {
    private static final int INPUT_FRAME_RATE = 30;
    private final float baseSpeedMultiplier;
    private final ImmutableSortedMap speedsByStartTimeUs;

    public SegmentSpeedProvider(Format object) {
        float f10 = SegmentSpeedProvider.getCaptureFrameRate((Format)object);
        float f11 = -3.4028235E38f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f12 == false) {
            f10 = 1.0f;
        } else {
            f12 = 1106247680;
            f11 = 30.0f;
            f10 /= f11;
        }
        this.baseSpeedMultiplier = f10;
        this.speedsByStartTimeUs = object = SegmentSpeedProvider.buildSpeedByStartTimeUsMap((Format)object, f10);
    }

    private static ImmutableSortedMap buildSpeedByStartTimeUsMap(Format object, float f10) {
        Object object2;
        int n10;
        int n11;
        boolean bl2 = (object = SegmentSpeedProvider.extractSlowMotionSegments((Format)object)).isEmpty();
        if (bl2) {
            return ImmutableSortedMap.of();
        }
        TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
        int n12 = 0;
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = object.size()); ++n11) {
            object2 = (SlowMotionData$Segment)object.get(n11);
            long l10 = C.msToUs(((SlowMotionData$Segment)object2).startTimeMs);
            Long l11 = l10;
            n10 = ((SlowMotionData$Segment)object2).speedDivisor;
            float f11 = n10;
            f11 = f10 / f11;
            object2 = Float.valueOf(f11);
            treeMap.put(l11, object2);
        }
        while (n12 < (n11 = object.size())) {
            object3 = (SlowMotionData$Segment)object.get(n12);
            long l12 = C.msToUs(((SlowMotionData$Segment)object3).endTimeMs);
            object2 = l12;
            n10 = (int)(treeMap.containsKey(object2) ? 1 : 0);
            if (n10 == 0) {
                long l13 = C.msToUs(((SlowMotionData$Segment)object3).endTimeMs);
                object3 = l13;
                object2 = Float.valueOf(f10);
                treeMap.put(object3, object2);
            }
            ++n12;
        }
        return ImmutableSortedMap.copyOf(treeMap);
    }

    private static ImmutableList extractSlowMotionSegments(Format object) {
        ArrayList arrayList = new ArrayList();
        object = ((Format)object).metadata;
        if (object != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = ((Metadata)object).length()); ++i10) {
                Object object2 = ((Metadata)object).get(i10);
                boolean bl2 = object2 instanceof SlowMotionData;
                if (!bl2) continue;
                object2 = ((SlowMotionData)object2).segments;
                arrayList.addAll(object2);
            }
        }
        return ImmutableList.sortedCopyOf(SlowMotionData$Segment.BY_START_THEN_END_THEN_DIVISOR, arrayList);
    }

    private static float getCaptureFrameRate(Format object) {
        int n10;
        object = ((Format)object).metadata;
        float f10 = -3.4028235E38f;
        if (object == null) {
            return f10;
        }
        for (int i10 = 0; i10 < (n10 = ((Metadata)object).length()); ++i10) {
            Metadata$Entry metadata$Entry = ((Metadata)object).get(i10);
            boolean bl2 = metadata$Entry instanceof SmtaMetadataEntry;
            if (!bl2) continue;
            return ((SmtaMetadataEntry)metadata$Entry).captureFrameRate;
        }
        return f10;
    }

    public float getSpeed(long l10) {
        float f10;
        ImmutableSortedMap immutableSortedMap;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            object = 1;
        } else {
            object = 0;
            immutableSortedMap = null;
        }
        Assertions.checkArgument((boolean)object);
        immutableSortedMap = this.speedsByStartTimeUs;
        Object object2 = l10;
        object2 = immutableSortedMap.floorEntry(object2);
        if (object2 != null) {
            object2 = (Float)object2.getValue();
            f10 = ((Float)object2).floatValue();
        } else {
            f10 = this.baseSpeedMultiplier;
        }
        return f10;
    }
}

