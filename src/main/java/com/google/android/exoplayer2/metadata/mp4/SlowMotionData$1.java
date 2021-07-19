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
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData$Segment;
import java.util.ArrayList;

public class SlowMotionData$1
implements Parcelable.Creator {
    public SlowMotionData createFromParcel(Parcel object) {
        ArrayList arrayList = new ArrayList();
        ClassLoader classLoader = SlowMotionData$Segment.class.getClassLoader();
        object.readList(arrayList, classLoader);
        object = new SlowMotionData(arrayList);
        return object;
    }

    public SlowMotionData[] newArray(int n10) {
        return new SlowMotionData[n10];
    }
}

