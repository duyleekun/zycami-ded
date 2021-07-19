/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable;
import com.google.android.exoplayer2.util.Assertions;

public class AppInfoTable$1
implements Parcelable.Creator {
    public AppInfoTable createFromParcel(Parcel parcel) {
        String string2 = (String)Assertions.checkNotNull(parcel.readString());
        int n10 = parcel.readInt();
        AppInfoTable appInfoTable = new AppInfoTable(n10, string2);
        return appInfoTable;
    }

    public AppInfoTable[] newArray(int n10) {
        return new AppInfoTable[n10];
    }
}

