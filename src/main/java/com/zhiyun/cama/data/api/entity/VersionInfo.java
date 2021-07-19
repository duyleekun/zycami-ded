/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.VersionInfo$1;
import d.v.e.l.w1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class VersionInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final String DEVELOP = "dev";
    public static final String TAG = "VersionInfo";
    private String fileURL;
    private boolean forceUpdate;
    private HashMap notice;
    private String size;
    private String version;
    public String versionType;

    static {
        VersionInfo$1 versionInfo$1 = new VersionInfo$1();
        CREATOR = versionInfo$1;
    }

    public VersionInfo() {
        String string2;
        this.version = string2 = "";
        this.size = string2;
        this.fileURL = string2;
    }

    public VersionInfo(Parcel object) {
        String string2;
        this.version = string2 = "";
        this.size = string2;
        this.fileURL = string2;
        byte by2 = object.readByte();
        if (by2 != 0) {
            by2 = 1;
        } else {
            by2 = 0;
            string2 = null;
        }
        this.forceUpdate = by2;
        this.versionType = string2 = object.readString();
        this.version = string2 = object.readString();
        this.size = string2 = object.readString();
        this.fileURL = string2 = object.readString();
        object = (HashMap)object.readSerializable();
        this.notice = object;
    }

    private String getLangKey() {
        String string2;
        String string3 = w1.a();
        boolean bl2 = string3.equals(string2 = "zh_CN".toLowerCase());
        if (!bl2 && !(bl2 = string3.equals(string2 = "zh_TW".toLowerCase()))) {
            string3 = "en";
        }
        return string3;
    }

    public int describeContents() {
        return 0;
    }

    public String getFileURL() {
        return this.fileURL;
    }

    public HashMap getNotice() {
        return this.notice;
    }

    public String getNoticeLine() {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        Cloneable cloneable = this.notice;
        if (cloneable != null && (n10 = ((HashMap)cloneable).size()) > 0) {
            int n11;
            cloneable = this.notice;
            Object object = this.getLangKey();
            if ((cloneable = (ArrayList)((HashMap)cloneable).get(object)) == null) {
                return "";
            }
            object = ((ArrayList)cloneable).iterator();
            while ((n11 = object.hasNext()) != 0) {
                int n12;
                String string2 = (String)object.next();
                stringBuilder.append(string2);
                n11 = ((ArrayList)cloneable).indexOf(string2);
                if (n11 == (n12 = ((ArrayList)cloneable).size() + -1)) continue;
                string2 = "\n\n";
                stringBuilder.append(string2);
            }
        }
        return stringBuilder.toString();
    }

    public String getSize() {
        return this.size;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVersionType() {
        return this.versionType;
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public boolean isValid() {
        return TextUtils.isEmpty((CharSequence)this.fileURL) ^ true;
    }

    public void setFileURL(String string2) {
        this.fileURL = string2;
    }

    public void setForceUpdate(boolean bl2) {
        this.forceUpdate = bl2;
    }

    public void setNotice(HashMap hashMap) {
        this.notice = hashMap;
    }

    public void setSize(String string2) {
        this.size = string2;
    }

    public void setVersion(String string2) {
        this.version = string2;
    }

    public void setVersionType(String string2) {
        this.versionType = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VersionInfo{versionType='");
        Object object = this.versionType;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", forceUpdate=");
        boolean bl2 = this.forceUpdate;
        stringBuilder.append(bl2);
        stringBuilder.append(", version='");
        String string2 = this.version;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", size='");
        string2 = this.size;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", fileURL='");
        string2 = this.fileURL;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", notice=");
        object = this.notice;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = (int)(this.forceUpdate ? 1 : 0);
        parcel.writeByte((byte)n10);
        Object object = this.versionType;
        parcel.writeString((String)object);
        object = this.version;
        parcel.writeString((String)object);
        object = this.size;
        parcel.writeString((String)object);
        object = this.fileURL;
        parcel.writeString((String)object);
        object = this.notice;
        parcel.writeSerializable((Serializable)object);
    }
}

