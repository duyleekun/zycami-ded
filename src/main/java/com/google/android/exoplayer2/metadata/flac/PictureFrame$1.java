/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;

public class PictureFrame$1
implements Parcelable.Creator {
    public PictureFrame createFromParcel(Parcel parcel) {
        PictureFrame pictureFrame = new PictureFrame(parcel);
        return pictureFrame;
    }

    public PictureFrame[] newArray(int n10) {
        return new PictureFrame[n10];
    }
}

