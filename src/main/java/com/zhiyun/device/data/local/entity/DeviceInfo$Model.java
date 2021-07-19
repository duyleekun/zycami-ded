/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.device.data.local.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.device.data.local.entity.DeviceInfo$Model$1;

public class DeviceInfo$Model
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String name;
    private int serial;
    private float version;

    static {
        DeviceInfo$Model$1 deviceInfo$Model$1 = new DeviceInfo$Model$1();
        CREATOR = deviceInfo$Model$1;
    }

    public DeviceInfo$Model() {
    }

    public DeviceInfo$Model(Parcel object) {
        float f10;
        int n10;
        this.serial = n10 = object.readInt();
        this.version = f10 = object.readFloat();
        object = object.readString();
        this.name = object;
    }

    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public int getSerial() {
        return this.serial;
    }

    public float getVersion() {
        return this.version;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setSerial(int n10) {
        this.serial = n10;
    }

    public void setVersion(float f10) {
        this.version = f10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.serial;
        parcel.writeInt(n10);
        float f10 = this.version;
        parcel.writeFloat(f10);
        String string2 = this.name;
        parcel.writeString(string2);
    }
}

