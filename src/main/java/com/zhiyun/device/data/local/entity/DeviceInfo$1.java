/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.device.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.device.data.local.entity.DeviceInfo;

public final class DeviceInfo$1
implements Parcelable.Creator {
    public DeviceInfo createFromParcel(Parcel parcel) {
        DeviceInfo deviceInfo = new DeviceInfo(parcel);
        return deviceInfo;
    }

    public DeviceInfo[] newArray(int n10) {
        return new DeviceInfo[n10];
    }
}

