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
import com.google.android.exoplayer2.metadata.scte35.SpliceCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand$1;

public final class SpliceNullCommand
extends SpliceCommand {
    public static final Parcelable.Creator CREATOR;

    static {
        SpliceNullCommand$1 spliceNullCommand$1 = new SpliceNullCommand$1();
        CREATOR = spliceNullCommand$1;
    }

    public void writeToParcel(Parcel parcel, int n10) {
    }
}

