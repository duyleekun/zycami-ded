/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.data.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.data.api.entity.VersionInfo;

public final class VersionInfo$1
implements Parcelable.Creator {
    public VersionInfo createFromParcel(Parcel parcel) {
        VersionInfo versionInfo = new VersionInfo(parcel);
        return versionInfo;
    }

    public VersionInfo[] newArray(int n10) {
        return new VersionInfo[n10];
    }
}

