/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment$1;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import d.h.a.a.j0.b.a;
import java.util.Comparator;

public final class SlowMotionData$Segment
implements Parcelable {
    public static final Comparator BY_START_THEN_END_THEN_DIVISOR = a.a;
    public static final Parcelable.Creator CREATOR;
    public final long endTimeMs;
    public final int speedDivisor;
    public final long startTimeMs;

    static {
        SlowMotionData$Segment$1 slowMotionData$Segment$1 = new SlowMotionData$Segment$1();
        CREATOR = slowMotionData$Segment$1;
    }

    public SlowMotionData$Segment(long l10, long l11, int n10) {
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 < 0 ? (long)1 : (long)0;
        Assertions.checkArgument((boolean)l12);
        this.startTimeMs = l10;
        this.endTimeMs = l11;
        this.speedDivisor = n10;
    }

    public static /* synthetic */ int a(SlowMotionData$Segment slowMotionData$Segment, SlowMotionData$Segment slowMotionData$Segment2) {
        ComparisonChain comparisonChain = ComparisonChain.start();
        long l10 = slowMotionData$Segment.startTimeMs;
        long l11 = slowMotionData$Segment2.startTimeMs;
        comparisonChain = comparisonChain.compare(l10, l11);
        l10 = slowMotionData$Segment.endTimeMs;
        l11 = slowMotionData$Segment2.endTimeMs;
        comparisonChain = comparisonChain.compare(l10, l11);
        int n10 = slowMotionData$Segment.speedDivisor;
        int n11 = slowMotionData$Segment2.speedDivisor;
        return comparisonChain.compare(n10, n11).result();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<SlowMotionData$Segment> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = SlowMotionData$Segment.class) == (clazz = object.getClass())) {
            int n10;
            long l10;
            object = (SlowMotionData$Segment)object;
            long l11 = this.startTimeMs;
            long l12 = ((SlowMotionData$Segment)object).startTimeMs;
            long l13 = l11 - l12;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 != false || (object2 = (l10 = (l11 = this.endTimeMs) - (l12 = ((SlowMotionData$Segment)object).endTimeMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false || (object2 = (Object)this.speedDivisor) != (n10 = ((SlowMotionData$Segment)object).speedDivisor)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        Number number = this.startTimeMs;
        objectArray[0] = number;
        number = this.endTimeMs;
        objectArray[1] = number;
        number = this.speedDivisor;
        objectArray[2] = number;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        Object[] objectArray = new Object[3];
        Number number = this.startTimeMs;
        objectArray[0] = number;
        number = this.endTimeMs;
        objectArray[1] = number;
        number = this.speedDivisor;
        objectArray[2] = number;
        return Util.formatInvariant("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", objectArray);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.startTimeMs;
        parcel.writeLong(l10);
        l10 = this.endTimeMs;
        parcel.writeLong(l10);
        n10 = this.speedDivisor;
        parcel.writeInt(n10);
    }
}

