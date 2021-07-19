/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;

public class PrivateCommand$1
implements Parcelable.Creator {
    public PrivateCommand createFromParcel(Parcel parcel) {
        PrivateCommand privateCommand = new PrivateCommand(parcel, null);
        return privateCommand;
    }

    public PrivateCommand[] newArray(int n10) {
        return new PrivateCommand[n10];
    }
}

