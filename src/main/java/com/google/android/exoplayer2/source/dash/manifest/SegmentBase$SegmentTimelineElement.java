/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

public final class SegmentBase$SegmentTimelineElement {
    public final long duration;
    public final long startTime;

    public SegmentBase$SegmentTimelineElement(long l10, long l11) {
        this.startTime = l10;
        this.duration = l11;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<SegmentBase$SegmentTimelineElement> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = SegmentBase$SegmentTimelineElement.class) == (clazz = object.getClass())) {
            long l10;
            long l11;
            object = (SegmentBase$SegmentTimelineElement)object;
            long l12 = this.startTime;
            long l13 = ((SegmentBase$SegmentTimelineElement)object).startTime;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false || (l11 = (l10 = (l12 = this.duration) - (l13 = ((SegmentBase$SegmentTimelineElement)object).duration)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = (int)this.startTime * 31;
        int n11 = (int)this.duration;
        return n10 + n11;
    }
}

