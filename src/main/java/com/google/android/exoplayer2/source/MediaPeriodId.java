/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

public class MediaPeriodId {
    public final int adGroupIndex;
    public final int adIndexInAdGroup;
    public final int nextAdGroupIndex;
    public final Object periodUid;
    public final long windowSequenceNumber;

    public MediaPeriodId(MediaPeriodId mediaPeriodId) {
        int n10;
        long l10;
        int n11;
        Object object;
        this.periodUid = object = mediaPeriodId.periodUid;
        this.adGroupIndex = n11 = mediaPeriodId.adGroupIndex;
        this.adIndexInAdGroup = n11 = mediaPeriodId.adIndexInAdGroup;
        this.windowSequenceNumber = l10 = mediaPeriodId.windowSequenceNumber;
        this.nextAdGroupIndex = n10 = mediaPeriodId.nextAdGroupIndex;
    }

    public MediaPeriodId(Object object) {
        this(object, -1);
    }

    public MediaPeriodId(Object object, int n10, int n11, long l10) {
        this(object, n10, n11, l10, -1);
    }

    private MediaPeriodId(Object object, int n10, int n11, long l10, int n12) {
        this.periodUid = object;
        this.adGroupIndex = n10;
        this.adIndexInAdGroup = n11;
        this.windowSequenceNumber = l10;
        this.nextAdGroupIndex = n12;
    }

    public MediaPeriodId(Object object, long l10) {
        this(object, -1, -1, l10, -1);
    }

    public MediaPeriodId(Object object, long l10, int n10) {
        this(object, -1, -1, l10, n10);
    }

    public MediaPeriodId copyWithPeriodUid(Object object) {
        Object object2 = this.periodUid;
        boolean bl2 = object2.equals(object);
        if (bl2) {
            object2 = this;
        } else {
            int n10 = this.adGroupIndex;
            int n11 = this.adIndexInAdGroup;
            long l10 = this.windowSequenceNumber;
            int n12 = this.nextAdGroupIndex;
            object2 = new MediaPeriodId(object, n10, n11, l10, n12);
        }
        return object2;
    }

    public boolean equals(Object object) {
        int n10;
        long l10;
        long l11;
        long l12;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof MediaPeriodId;
        if (n12 == 0) {
            return false;
        }
        object = (MediaPeriodId)object;
        Object object2 = this.periodUid;
        Object object3 = ((MediaPeriodId)object).periodUid;
        n12 = object2.equals(object3);
        if (n12 == 0 || (n12 = this.adGroupIndex) != (n11 = ((MediaPeriodId)object).adGroupIndex) || (n12 = this.adIndexInAdGroup) != (n11 = ((MediaPeriodId)object).adIndexInAdGroup) || (n12 = (int)((l12 = (l11 = this.windowSequenceNumber) - (l10 = ((MediaPeriodId)object).windowSequenceNumber)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 || (n12 = this.nextAdGroupIndex) != (n10 = ((MediaPeriodId)object).nextAdGroupIndex)) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.periodUid.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.adGroupIndex;
        n11 = (n11 + n10) * 31;
        n10 = this.adIndexInAdGroup;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.windowSequenceNumber;
        n11 = (n11 + n10) * 31;
        n10 = this.nextAdGroupIndex;
        return n11 + n10;
    }

    public boolean isAd() {
        int n10 = this.adGroupIndex;
        int n11 = -1;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }
}

