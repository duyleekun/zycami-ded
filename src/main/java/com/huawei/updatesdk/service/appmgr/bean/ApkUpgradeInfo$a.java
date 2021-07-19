/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;

public final class ApkUpgradeInfo$a
implements Parcelable.Creator {
    public ApkUpgradeInfo createFromParcel(Parcel parcel) {
        ApkUpgradeInfo apkUpgradeInfo = new ApkUpgradeInfo(parcel);
        return apkUpgradeInfo;
    }

    public ApkUpgradeInfo[] newArray(int n10) {
        return new ApkUpgradeInfo[n10];
    }
}

