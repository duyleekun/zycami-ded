/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.net.Punish$1;
import java.util.Objects;

public class Punish
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private String appeal_id;
    private String createAt;
    private String forever;
    private int id;
    private String path;
    private String punish;
    private String punish_endtime;
    private String userId;

    static {
        Punish$1 punish$1 = new Punish$1();
        CREATOR = punish$1;
    }

    public Punish() {
    }

    public Punish(int n10, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.id = n10;
        this.punish = string2;
        this.forever = string3;
        this.punish_endtime = string4;
        this.userId = string5;
        this.createAt = string6;
        this.appeal_id = string7;
        this.path = string8;
    }

    public Punish(Parcel object) {
        String string2;
        int n10;
        this.id = n10 = object.readInt();
        this.punish = string2 = object.readString();
        this.forever = string2 = object.readString();
        this.punish_endtime = string2 = object.readString();
        this.userId = string2 = object.readString();
        this.createAt = string2 = object.readString();
        this.appeal_id = string2 = object.readString();
        object = object.readString();
        this.path = object;
    }

    public int describeContents() {
        return 0;
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
            object = (Punish)object;
            int n10 = this.id;
            int n11 = ((Punish)object).id;
            if (n10 != n11 || (n10 = (int)(Objects.equals(object3 = this.punish, object2 = ((Punish)object).punish) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.forever, object2 = ((Punish)object).forever) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.punish_endtime, object2 = ((Punish)object).punish_endtime) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.userId, object2 = ((Punish)object).userId) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((Punish)object).createAt) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.appeal_id, object2 = ((Punish)object).appeal_id) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.path, object = ((Punish)object).path))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAppeal_id() {
        return this.appeal_id;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public String getForever() {
        return this.forever;
    }

    public int getId() {
        return this.id;
    }

    public String getPath() {
        return this.path;
    }

    public String getPunish() {
        return this.punish;
    }

    public String getPunish_endtime() {
        return this.punish_endtime;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = this.punish, object = this.forever, object = this.punish_endtime, object = this.userId, object = this.createAt, object = this.appeal_id, object = this.path};
        return Objects.hash(objectArray);
    }

    public void setAppeal_id(String string2) {
        this.appeal_id = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setForever(String string2) {
        this.forever = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public void setPunish(String string2) {
        this.punish = string2;
    }

    public void setPunish_endtime(String string2) {
        this.punish_endtime = string2;
    }

    public void setUserId(String string2) {
        this.userId = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Punish{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", punish='");
        String string2 = this.punish;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", forever='");
        String string3 = this.forever;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", punish_endtime='");
        string3 = this.punish_endtime;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", userId='");
        string3 = this.userId;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", appeal_id='");
        string3 = this.appeal_id;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", path='");
        string3 = this.path;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.id;
        parcel.writeInt(n10);
        String string2 = this.punish;
        parcel.writeString(string2);
        string2 = this.forever;
        parcel.writeString(string2);
        string2 = this.punish_endtime;
        parcel.writeString(string2);
        string2 = this.userId;
        parcel.writeString(string2);
        string2 = this.createAt;
        parcel.writeString(string2);
        string2 = this.appeal_id;
        parcel.writeString(string2);
        string2 = this.path;
        parcel.writeString(string2);
    }
}

