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
import com.zhiyun.device.data.local.entity.FirmwareInfo;

public final class FirmwareInfo$1
implements Parcelable.Creator {
    public FirmwareInfo createFromParcel(Parcel parcel) {
        FirmwareInfo firmwareInfo = new FirmwareInfo(parcel);
        return firmwareInfo;
    }

    public FirmwareInfo[] newArray(int n10) {
        return new FirmwareInfo[n10];
    }
}

