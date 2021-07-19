/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.video.ColorInfo;

public class ColorInfo$1
implements Parcelable.Creator {
    public ColorInfo createFromParcel(Parcel parcel) {
        ColorInfo colorInfo = new ColorInfo(parcel);
        return colorInfo;
    }

    public ColorInfo[] newArray(int n10) {
        return new ColorInfo[n10];
    }
}

