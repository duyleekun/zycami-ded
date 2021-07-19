/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;

public final class PermissionInfo$a
implements Parcelable.Creator {
    public PermissionInfo createFromParcel(Parcel parcel) {
        PermissionInfo permissionInfo = new PermissionInfo(parcel);
        return permissionInfo;
    }

    public PermissionInfo[] newArray(int n10) {
        return new PermissionInfo[n10];
    }
}

