/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.client;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.client.Status;

public final class Status$a
implements Parcelable.Creator {
    public Status createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        String string2 = parcel.readString();
        parcel = PendingIntent.readPendingIntentOrNullFromParcel((Parcel)parcel);
        Status status = new Status(n10, string2, (PendingIntent)parcel);
        return status;
    }

    public Status[] newArray(int n10) {
        return new Status[n10];
    }
}

