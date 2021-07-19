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
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;

public class SpliceInsertCommand$1
implements Parcelable.Creator {
    public SpliceInsertCommand createFromParcel(Parcel parcel) {
        SpliceInsertCommand spliceInsertCommand = new SpliceInsertCommand(parcel, null);
        return spliceInsertCommand;
    }

    public SpliceInsertCommand[] newArray(int n10) {
        return new SpliceInsertCommand[n10];
    }
}

