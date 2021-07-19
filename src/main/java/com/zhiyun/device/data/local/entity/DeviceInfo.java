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
import com.zhiyun.device.data.local.entity.DeviceInfo$1;
import com.zhiyun.device.data.local.entity.DeviceInfo$Model;
import d.v.y.d.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeviceInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private long createTimestamp;
    private String deviceName;
    private String deviceSn;
    private int serial;
    private List subModels;
    private long updateTimestamp;
    private String ver;

    static {
        DeviceInfo$1 deviceInfo$1 = new DeviceInfo$1();
        CREATOR = deviceInfo$1;
    }

    public DeviceInfo() {
        ArrayList arrayList;
        this.subModels = arrayList = new ArrayList();
    }

    public DeviceInfo(Parcel parcel) {
        long l10;
        int n10;
        ArrayList arrayList = new ArrayList();
        this.subModels = arrayList;
        this.serial = n10 = parcel.readInt();
        arrayList = parcel.readString();
        this.deviceName = arrayList;
        arrayList = parcel.readString();
        this.ver = arrayList;
        this.subModels = arrayList = new ArrayList();
        ClassLoader classLoader = DeviceInfo$Model.class.getClassLoader();
        parcel.readList(arrayList, classLoader);
        this.createTimestamp = l10 = parcel.readLong();
        this.updateTimestamp = l10 = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            object = (DeviceInfo)object;
            int n10 = this.serial;
            int n11 = ((DeviceInfo)object).serial;
            if (n10 != n11) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getCreateTimestamp() {
        return this.createTimestamp;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public int getSerial() {
        return this.serial;
    }

    public List getSubModels() {
        return this.subModels;
    }

    public long getUpdateTimestamp() {
        return this.updateTimestamp;
    }

    public String getVer() {
        return this.ver;
    }

    public float getVersion() {
        return f.a(this.ver);
    }

    public int hashCode() {
        Object[] objectArray = new Object[1];
        Integer n10 = this.serial;
        objectArray[0] = n10;
        return Objects.hash(objectArray);
    }

    public void setCreateTimestamp(long l10) {
        this.createTimestamp = l10;
    }

    public void setDeviceName(String string2) {
        this.deviceName = string2;
    }

    public void setDeviceSn(String string2) {
        this.deviceSn = string2;
    }

    public void setSerial(int n10) {
        this.serial = n10;
    }

    public void setSubModels(List list) {
        this.subModels = list;
    }

    public void setUpdateTimestamp(long l10) {
        this.updateTimestamp = l10;
    }

    public void setVer(String string2) {
        this.ver = string2;
    }

    public void setVersion(float f10) {
        String string2;
        this.ver = string2 = String.valueOf(f10);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.serial;
        parcel.writeInt(n10);
        Object object = this.deviceName;
        parcel.writeString((String)object);
        object = this.ver;
        parcel.writeString((String)object);
        object = this.subModels;
        parcel.writeList((List)object);
        long l10 = this.createTimestamp;
        parcel.writeLong(l10);
        l10 = this.updateTimestamp;
        parcel.writeLong(l10);
    }
}

