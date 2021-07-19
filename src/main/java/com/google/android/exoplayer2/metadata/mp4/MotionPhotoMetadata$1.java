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
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;

public class MotionPhotoMetadata$1
implements Parcelable.Creator {
    public MotionPhotoMetadata createFromParcel(Parcel parcel) {
        MotionPhotoMetadata motionPhotoMetadata = new MotionPhotoMetadata(parcel, null);
        return motionPhotoMetadata;
    }

    public MotionPhotoMetadata[] newArray(int n10) {
        return new MotionPhotoMetadata[n10];
    }
}

