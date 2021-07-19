/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTimelineElement;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public abstract class SegmentBase$MultiSegmentBase
extends SegmentBase {
    public final long availabilityTimeOffsetUs;
    public final long duration;
    private final long periodStartUnixTimeUs;
    public final List segmentTimeline;
    public final long startNumber;
    private final long timeShiftBufferDepthUs;

    public SegmentBase$MultiSegmentBase(RangedUri rangedUri, long l10, long l11, long l12, long l13, List list, long l14, long l15, long l16) {
        super(rangedUri, l10, l11);
        this.startNumber = l12;
        this.duration = l13;
        this.segmentTimeline = list;
        this.availabilityTimeOffsetUs = l14;
        this.timeShiftBufferDepthUs = l15;
        this.periodStartUnixTimeUs = l16;
    }

    public int getAvailableSegmentCount(long l10, long l11) {
        int n10;
        int n11 = this.getSegmentCount(l10);
        if (n11 != (n10 = -1)) {
            return n11;
        }
        long l12 = this.periodStartUnixTimeUs;
        l12 = l11 - l12;
        long l13 = this.availabilityTimeOffsetUs;
        l12 += l13;
        l12 = this.getSegmentNum(l12, l10);
        l10 = this.getFirstAvailableSegmentNum(l10, l11);
        return (int)(l12 - l10);
    }

    public long getFirstAvailableSegmentNum(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15 = this.getSegmentCount(l10);
        long l16 = l15 - (l14 = (long)-1);
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false && (l13 = (l12 = (l15 = this.timeShiftBufferDepthUs) - (l14 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            l14 = this.periodStartUnixTimeUs;
            l11 = l11 - l14 - l15;
            l10 = this.getSegmentNum(l11, l10);
            return Math.max(this.getFirstSegmentNum(), l10);
        }
        return this.getFirstSegmentNum();
    }

    public long getFirstSegmentNum() {
        return this.startNumber;
    }

    public long getNextSegmentAvailableTimeUs(long l10, long l11) {
        List list = this.segmentTimeline;
        if (list != null) {
            return -9223372036854775807L;
        }
        long l12 = this.getFirstAvailableSegmentNum(l10, l11);
        l11 = this.getAvailableSegmentCount(l10, l11);
        l12 += l11;
        l11 = this.getSegmentTimeUs(l12);
        l10 = this.getSegmentDurationUs(l12, l10);
        l11 += l10;
        l10 = this.availabilityTimeOffsetUs;
        return l11 - l10;
    }

    public abstract int getSegmentCount(long var1);

    /*
     * Enabled aggressive block sorting
     */
    public final long getSegmentDurationUs(long l10, long l11) {
        int n10;
        List list = this.segmentTimeline;
        long l12 = 1000000L;
        if (list != null) {
            l11 = this.startNumber;
            int n11 = (int)(l10 - l11);
            l10 = ((SegmentBase$SegmentTimelineElement)list.get((int)n11)).duration * l12;
            l11 = this.timescale;
            return l10 / l11;
        }
        int n12 = this.getSegmentCount(l11);
        if (n12 != (n10 = -1)) {
            long l13 = this.getFirstSegmentNum();
            long l14 = n12;
            l13 += l14;
            l14 = 1L;
            long l15 = l10 - (l13 -= l14);
            n12 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n12 == 0) {
                l10 = this.getSegmentTimeUs(l10);
                return l11 -= l10;
            }
        }
        l10 = this.duration * l12;
        l11 = this.timescale;
        return l10 / l11;
    }

    public long getSegmentNum(long l10, long l11) {
        long l12;
        long l13 = this.getFirstSegmentNum();
        int n10 = this.getSegmentCount(l11);
        long l14 = (l11 = (long)n10) - (l12 = 0L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return l13;
        }
        List list = this.segmentTimeline;
        long l15 = 1L;
        if (list == null) {
            long l16 = this.duration * 1000000L;
            long l17 = this.timescale;
            l16 /= l17;
            l17 = this.startNumber;
            long l18 = (l17 += (l10 /= l16)) - l13;
            Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 >= 0) {
                l10 = -1;
                long l19 = l11 - l10;
                object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object2 == false) {
                    l13 = l17;
                } else {
                    l13 = l13 + l11 - l15;
                    l13 = Math.min(l17, l13);
                }
            }
            return l13;
        }
        l11 = l11 + l13 - l15;
        long l20 = l13;
        while ((object = l20 == l11 ? 0 : (l20 < l11 ? -1 : 1)) <= 0) {
            long l21 = (l11 - l20) / (long)2 + l20;
            long l22 = this.getSegmentTimeUs(l21);
            long l23 = l22 - l10;
            object = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
            if (object < 0) {
                l20 = l21 + l15;
                continue;
            }
            if (object > 0) {
                l11 = l21 -= l15;
                continue;
            }
            return l21;
        }
        Object object3 = l20 == l13 ? 0 : (l20 < l13 ? -1 : 1);
        if (object3 == false) {
            l11 = l20;
        }
        return l11;
    }

    public final long getSegmentTimeUs(long l10) {
        long l11;
        List list = this.segmentTimeline;
        if (list != null) {
            long l12 = this.startNumber;
            int n10 = (int)(l10 - l12);
            SegmentBase$SegmentTimelineElement segmentBase$SegmentTimelineElement = (SegmentBase$SegmentTimelineElement)list.get(n10);
            l10 = segmentBase$SegmentTimelineElement.startTime;
            l11 = this.presentationTimeOffset;
            l10 -= l11;
        } else {
            l11 = this.startNumber;
            l10 -= l11;
            l11 = this.duration;
            l10 *= l11;
        }
        l11 = l10;
        long l13 = this.timescale;
        return Util.scaleLargeTimestamp(l10, 1000000L, l13);
    }

    public abstract RangedUri getSegmentUrl(Representation var1, long var2);

    public boolean isExplicit() {
        boolean bl2;
        List list = this.segmentTimeline;
        if (list != null) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }
}

