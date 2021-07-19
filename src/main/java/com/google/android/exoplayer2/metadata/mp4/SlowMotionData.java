/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$1;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import com.google.android.exoplayer2.util.Assertions;
import java.util.List;

public final class SlowMotionData
implements Metadata$Entry {
    public static final Parcelable.Creator CREATOR;
    public final List segments;

    static {
        SlowMotionData$1 slowMotionData$1 = new SlowMotionData$1();
        CREATOR = slowMotionData$1;
    }

    public SlowMotionData(List list) {
        this.segments = list;
        Assertions.checkArgument(SlowMotionData.doSegmentsOverlap(list) ^ true);
    }

    private static boolean doSegmentsOverlap(List list) {
        int n10;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return false;
        }
        SlowMotionData$Segment slowMotionData$Segment = (SlowMotionData$Segment)list.get(0);
        long l10 = slowMotionData$Segment.endTimeMs;
        for (int i10 = n11 = 1; i10 < (n10 = list.size()); ++i10) {
            SlowMotionData$Segment slowMotionData$Segment2 = (SlowMotionData$Segment)list.get(i10);
            long l11 = slowMotionData$Segment2.startTimeMs;
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object < 0) {
                return n11 != 0;
            }
            SlowMotionData$Segment slowMotionData$Segment3 = (SlowMotionData$Segment)list.get(i10);
            l10 = slowMotionData$Segment3.endTimeMs;
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = SlowMotionData.class) == (clazz = object.getClass())) {
            object = (SlowMotionData)object;
            object2 = this.segments;
            object = ((SlowMotionData)object).segments;
            return object2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.segments.hashCode();
    }

    public String toString() {
        String string2 = String.valueOf(this.segments);
        int n10 = String.valueOf(string2).length() + 21;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("SlowMotion: segments=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        List list = this.segments;
        parcel.writeList(list);
    }
}

