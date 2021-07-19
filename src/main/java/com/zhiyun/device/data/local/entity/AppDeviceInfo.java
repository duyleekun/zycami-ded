/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.local.entity;

import java.util.Objects;

public class AppDeviceInfo {
    private String bts;
    private String deviceid;
    private String ets;
    private Integer id;
    private String latitude;
    private String longitude;
    private String model;
    private String phoneid;
    private String serial_num;
    private String userid;

    public AppDeviceInfo() {
        String string2;
        this.phoneid = string2 = "";
        this.model = string2;
        this.deviceid = string2;
        this.bts = string2;
        this.longitude = string2;
        this.latitude = string2;
        this.serial_num = string2;
    }

    public AppDeviceInfo(Integer n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
        String string11;
        this.phoneid = string11 = "";
        this.model = string11;
        this.deviceid = string11;
        this.bts = string11;
        this.longitude = string11;
        this.latitude = string11;
        this.serial_num = string11;
        this.id = n10;
        this.userid = string2;
        this.phoneid = string3;
        this.model = string4;
        this.deviceid = string5;
        this.bts = string6;
        this.ets = string7;
        this.longitude = string8;
        this.latitude = string9;
        this.serial_num = string10;
    }

    public AppDeviceInfo(String string2, String string3, String string4, String string5, String string6, String string7) {
        String string8;
        this.phoneid = string8 = "";
        this.model = string8;
        this.deviceid = string8;
        this.bts = string8;
        this.longitude = string8;
        this.latitude = string8;
        this.serial_num = string8;
        this.userid = string2;
        this.phoneid = string3;
        this.model = string4;
        this.deviceid = string5;
        this.bts = string6;
        this.serial_num = string7;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (AppDeviceInfo)object;
            object3 = this.id;
            object2 = ((AppDeviceInfo)object).id;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.userid, object2 = ((AppDeviceInfo)object).userid)) && (bl4 = Objects.equals(object3 = this.phoneid, object2 = ((AppDeviceInfo)object).phoneid)) && (bl4 = Objects.equals(object3 = this.model, object2 = ((AppDeviceInfo)object).model)) && (bl4 = Objects.equals(object3 = this.deviceid, object2 = ((AppDeviceInfo)object).deviceid)) && (bl4 = Objects.equals(object3 = this.bts, object2 = ((AppDeviceInfo)object).bts)) && (bl4 = Objects.equals(object3 = this.ets, object2 = ((AppDeviceInfo)object).ets)) && (bl4 = Objects.equals(object3 = this.longitude, object2 = ((AppDeviceInfo)object).longitude)) && (bl4 = Objects.equals(object3 = this.latitude, object2 = ((AppDeviceInfo)object).latitude)) && (bl3 = Objects.equals(object3 = this.serial_num, object = ((AppDeviceInfo)object).serial_num)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getBts() {
        return this.bts;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public String getEts() {
        return this.ets;
    }

    public Integer getId() {
        return this.id;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getModel() {
        return this.model;
    }

    public String getPhoneid() {
        return this.phoneid;
    }

    public String getSerial_num() {
        return this.serial_num;
    }

    public String getUserid() {
        return this.userid;
    }

    public int hashCode() {
        Object object = this.id;
        object = this.userid;
        object = this.phoneid;
        object = this.model;
        object = this.deviceid;
        object = this.bts;
        object = this.ets;
        object = this.longitude;
        object = this.latitude;
        object = this.serial_num;
        Object[] objectArray = new Object[]{object, object, object, object, object, object, object, object, object, object};
        return Objects.hash(objectArray);
    }

    public void setBts(String string2) {
        this.bts = string2;
    }

    public void setDeviceid(String string2) {
        this.deviceid = string2;
    }

    public void setEts(String string2) {
        this.ets = string2;
    }

    public void setId(Integer n10) {
        this.id = n10;
    }

    public void setLatitude(String string2) {
        this.latitude = string2;
    }

    public void setLongitude(String string2) {
        this.longitude = string2;
    }

    public void setModel(String string2) {
        this.model = string2;
    }

    public void setPhoneid(String string2) {
        this.phoneid = string2;
    }

    public void setSerial_num(String string2) {
        this.serial_num = string2;
    }

    public void setUserid(String string2) {
        this.userid = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppDeviceInfo{id=");
        Object object = this.id;
        stringBuilder.append(object);
        stringBuilder.append(", userid='");
        object = this.userid;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", phoneid='");
        String string2 = this.phoneid;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", model='");
        string2 = this.model;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", deviceid='");
        string2 = this.deviceid;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", bts='");
        string2 = this.bts;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", ets='");
        string2 = this.ets;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", longitude='");
        string2 = this.longitude;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", latitude='");
        string2 = this.latitude;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", serial_num='");
        string2 = this.serial_num;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

