/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.util.Util;

public final class MediaPeriodInfo {
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource$MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final boolean isLastInTimelineWindow;
    public final long requestedContentPositionUs;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10, long l11, long l12, long l13, boolean bl2, boolean bl3, boolean bl4) {
        this.id = mediaSource$MediaPeriodId;
        this.startPositionUs = l10;
        this.requestedContentPositionUs = l11;
        this.endPositionUs = l12;
        this.durationUs = l13;
        this.isLastInTimelinePeriod = bl2;
        this.isLastInTimelineWindow = bl3;
        this.isFinal = bl4;
    }

    public MediaPeriodInfo copyWithRequestedContentPositionUs(long l10) {
        MediaPeriodInfo mediaPeriodInfo;
        long l11 = this.requestedContentPositionUs;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            mediaPeriodInfo = this;
        } else {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.id;
            long l13 = this.startPositionUs;
            long l14 = this.endPositionUs;
            long l15 = this.durationUs;
            boolean bl2 = this.isLastInTimelinePeriod;
            boolean bl3 = this.isLastInTimelineWindow;
            boolean bl4 = this.isFinal;
            mediaPeriodInfo = new MediaPeriodInfo(mediaSource$MediaPeriodId, l13, l10, l14, l15, bl2, bl3, bl4);
        }
        return mediaPeriodInfo;
    }

    public MediaPeriodInfo copyWithStartPositionUs(long l10) {
        MediaPeriodInfo mediaPeriodInfo;
        long l11 = this.startPositionUs;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            mediaPeriodInfo = this;
        } else {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.id;
            long l13 = this.requestedContentPositionUs;
            long l14 = this.endPositionUs;
            long l15 = this.durationUs;
            boolean bl2 = this.isLastInTimelinePeriod;
            boolean bl3 = this.isLastInTimelineWindow;
            boolean bl4 = this.isFinal;
            mediaPeriodInfo = new MediaPeriodInfo(mediaSource$MediaPeriodId, l10, l13, l14, l15, bl2, bl3, bl4);
        }
        return mediaPeriodInfo;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = MediaPeriodInfo.class) == (clazz = object.getClass())) {
            boolean bl3;
            boolean bl4;
            long l10;
            long l11;
            long l12;
            object = (MediaPeriodInfo)object;
            long l13 = this.startPositionUs;
            long l14 = ((MediaPeriodInfo)object).startPositionUs;
            long l15 = l13 - l14;
            Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 != false || (object3 = (l12 = (l13 = this.requestedContentPositionUs) - (l14 = ((MediaPeriodInfo)object).requestedContentPositionUs)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || (object3 = (l11 = (l13 = this.endPositionUs) - (l14 = ((MediaPeriodInfo)object).endPositionUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false || (object3 = (l10 = (l13 = this.durationUs) - (l14 = ((MediaPeriodInfo)object).durationUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object3 = (Object)this.isLastInTimelinePeriod) != (bl4 = ((MediaPeriodInfo)object).isLastInTimelinePeriod) || (object3 = (Object)this.isLastInTimelineWindow) != (bl4 = ((MediaPeriodInfo)object).isLastInTimelineWindow) || (object3 = (Object)this.isFinal) != (bl4 = ((MediaPeriodInfo)object).isFinal) || !(bl3 = Util.areEqual(object2 = this.id, object = ((MediaPeriodInfo)object).id))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.id.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = (int)this.startPositionUs;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.requestedContentPositionUs;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.endPositionUs;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.durationUs;
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.isLastInTimelinePeriod ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.isLastInTimelineWindow ? 1 : 0);
        n11 = (n11 + n10) * 31;
        n10 = (int)(this.isFinal ? 1 : 0);
        return n11 + n10;
    }
}

