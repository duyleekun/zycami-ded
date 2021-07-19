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
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;

public class TextInformationFrame$1
implements Parcelable.Creator {
    public TextInformationFrame createFromParcel(Parcel parcel) {
        TextInformationFrame textInformationFrame = new TextInformationFrame(parcel);
        return textInformationFrame;
    }

    public TextInformationFrame[] newArray(int n10) {
        return new TextInformationFrame[n10];
    }
}

