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
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;

public class BinaryFrame$1
implements Parcelable.Creator {
    public BinaryFrame createFromParcel(Parcel parcel) {
        BinaryFrame binaryFrame = new BinaryFrame(parcel);
        return binaryFrame;
    }

    public BinaryFrame[] newArray(int n10) {
        return new BinaryFrame[n10];
    }
}

