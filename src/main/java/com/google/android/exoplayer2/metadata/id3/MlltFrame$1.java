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
import com.google.android.exoplayer2.metadata.id3.MlltFrame;

public class MlltFrame$1
implements Parcelable.Creator {
    public MlltFrame createFromParcel(Parcel parcel) {
        MlltFrame mlltFrame = new MlltFrame(parcel);
        return mlltFrame;
    }

    public MlltFrame[] newArray(int n10) {
        return new MlltFrame[n10];
    }
}

