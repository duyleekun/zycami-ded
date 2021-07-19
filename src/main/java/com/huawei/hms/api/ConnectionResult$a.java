/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.api.ConnectionResult;

public final class ConnectionResult$a
implements Parcelable.Creator {
    public ConnectionResult createFromParcel(Parcel parcel) {
        ConnectionResult connectionResult = new ConnectionResult(parcel, null);
        return connectionResult;
    }

    public ConnectionResult[] newArray(int n10) {
        return new ConnectionResult[n10];
    }
}

