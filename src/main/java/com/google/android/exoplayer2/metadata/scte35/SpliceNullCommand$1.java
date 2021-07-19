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
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;

public class SpliceNullCommand$1
implements Parcelable.Creator {
    public SpliceNullCommand createFromParcel(Parcel object) {
        object = new SpliceNullCommand();
        return object;
    }

    public SpliceNullCommand[] newArray(int n10) {
        return new SpliceNullCommand[n10];
    }
}

