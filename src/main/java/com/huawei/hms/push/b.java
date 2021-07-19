/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.RemoteMessage;

public final class b
implements Parcelable.Creator {
    public RemoteMessage createFromParcel(Parcel parcel) {
        RemoteMessage remoteMessage = new RemoteMessage(parcel);
        return remoteMessage;
    }

    public RemoteMessage[] newArray(int n10) {
        return new RemoteMessage[n10];
    }
}

