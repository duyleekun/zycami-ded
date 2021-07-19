/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;

public class UrlLinkFrame$1
implements Parcelable.Creator {
    public UrlLinkFrame createFromParcel(Parcel parcel) {
        UrlLinkFrame urlLinkFrame = new UrlLinkFrame(parcel);
        return urlLinkFrame;
    }

    public UrlLinkFrame[] newArray(int n10) {
        return new UrlLinkFrame[n10];
    }
}

