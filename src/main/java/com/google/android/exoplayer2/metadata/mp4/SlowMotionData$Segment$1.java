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
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;

public class SlowMotionData$Segment$1
implements Parcelable.Creator {
    public SlowMotionData$Segment createFromParcel(Parcel object) {
        long l10 = object.readLong();
        long l11 = object.readLong();
        int n10 = object.readInt();
        object = new SlowMotionData$Segment(l10, l11, n10);
        return object;
    }

    public SlowMotionData$Segment[] newArray(int n10) {
        return new SlowMotionData$Segment[n10];
    }
}

