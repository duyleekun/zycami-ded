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
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;

public class TimeSignalCommand$1
implements Parcelable.Creator {
    public TimeSignalCommand createFromParcel(Parcel parcel) {
        long l10 = parcel.readLong();
        long l11 = parcel.readLong();
        TimeSignalCommand timeSignalCommand = new TimeSignalCommand(l10, l11, null);
        return timeSignalCommand;
    }

    public TimeSignalCommand[] newArray(int n10) {
        return new TimeSignalCommand[n10];
    }
}

