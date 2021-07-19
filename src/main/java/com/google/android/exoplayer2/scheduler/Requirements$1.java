/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.scheduler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.scheduler.Requirements;

public class Requirements$1
implements Parcelable.Creator {
    public Requirements createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        Requirements requirements = new Requirements(n10);
        return requirements;
    }

    public Requirements[] newArray(int n10) {
        return new Requirements[n10];
    }
}

