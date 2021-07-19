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
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;

public class SpliceScheduleCommand$1
implements Parcelable.Creator {
    public SpliceScheduleCommand createFromParcel(Parcel parcel) {
        SpliceScheduleCommand spliceScheduleCommand = new SpliceScheduleCommand(parcel, null);
        return spliceScheduleCommand;
    }

    public SpliceScheduleCommand[] newArray(int n10) {
        return new SpliceScheduleCommand[n10];
    }
}

