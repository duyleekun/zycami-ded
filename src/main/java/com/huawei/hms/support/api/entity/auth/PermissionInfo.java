/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.auth.PermissionInfo$a;

public class PermissionInfo
implements IMessageEntity,
Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String appID;
    private String packageName;
    private String permission;

    static {
        PermissionInfo$a permissionInfo$a = new PermissionInfo$a();
        CREATOR = permissionInfo$a;
    }

    public PermissionInfo() {
    }

    public PermissionInfo(Parcel object) {
        String string2;
        this.appID = string2 = object.readString();
        this.packageName = string2 = object.readString();
        object = object.readString();
        this.permission = object;
    }

    public PermissionInfo(String string2, String string3, String string4) {
        this.appID = string2;
        this.packageName = string3;
        this.permission = string4;
    }

    public int describeContents() {
        return 0;
    }

    public String getAppID() {
        return this.appID;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPermission() {
        return this.permission;
    }

    public void setAppID(String string2) {
        this.appID = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setPermission(String string2) {
        this.permission = string2;
    }

    public PermissionInfo setPermissionUri(String string2) {
        this.permission = string2;
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.appID;
        parcel.writeString(string2);
        string2 = this.packageName;
        parcel.writeString(string2);
        string2 = this.permission;
        parcel.writeString(string2);
    }
}

