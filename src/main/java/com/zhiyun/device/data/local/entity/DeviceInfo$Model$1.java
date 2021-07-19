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
import com.zhiyun.device.data.local.entity.DeviceInfo$Model;

public final class DeviceInfo$Model$1
implements Parcelable.Creator {
    public DeviceInfo$Model createFromParcel(Parcel parcel) {
        DeviceInfo$Model deviceInfo$Model = new DeviceInfo$Model(parcel);
        return deviceInfo$Model;
    }

    public DeviceInfo$Model[] newArray(int n10) {
        return new DeviceInfo$Model[n10];
    }
}

