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
import com.zhiyun.device.data.local.entity.FirmwareInfo$1;
import d.v.y.d.f;

public class FirmwareInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private int _id;
    private String afterUpgradeTip;
    private String beforeUpgradeTip;
    private long filesize;
    private boolean forceUpdate;
    private int hasPopup;
    private String md5;
    private boolean needUpdate;
    private String notice;
    private boolean otaUpdate;
    private String path;
    private String releaseDate;
    private String releaseNotes;
    private int serial;
    private String unionVer;
    private String url;
    private String ver;

    static {
        FirmwareInfo$1 firmwareInfo$1 = new FirmwareInfo$1();
        CREATOR = firmwareInfo$1;
    }

    public FirmwareInfo() {
        this.otaUpdate = true;
    }

    public FirmwareInfo(Parcel parcel) {
        int n10;
        String string2;
        String string3;
        int n11;
        boolean bl2;
        this.otaUpdate = bl2 = true;
        this._id = n11 = parcel.readInt();
        this.serial = n11 = parcel.readInt();
        this.unionVer = string3 = parcel.readString();
        this.ver = string3 = parcel.readString();
        this.releaseDate = string3 = parcel.readString();
        n11 = parcel.readByte();
        if (n11 != 0) {
            n11 = (int)(bl2 ? 1 : 0);
        } else {
            n11 = 0;
            string3 = null;
        }
        this.forceUpdate = n11;
        n11 = parcel.readByte();
        if (n11 != 0) {
            n11 = (int)(bl2 ? 1 : 0);
        } else {
            n11 = 0;
            string3 = null;
        }
        this.needUpdate = n11;
        n11 = parcel.readByte();
        if (n11 == 0) {
            bl2 = false;
            string2 = null;
        }
        this.otaUpdate = bl2;
        this.notice = string2 = parcel.readString();
        this.releaseNotes = string2 = parcel.readString();
        this.md5 = string2 = parcel.readString();
        this.url = string2 = parcel.readString();
        this.path = string2 = parcel.readString();
        this.beforeUpgradeTip = string2 = parcel.readString();
        this.afterUpgradeTip = string2 = parcel.readString();
        this.hasPopup = n10 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String getAfterUpgradeTip() {
        return this.afterUpgradeTip;
    }

    public String getBeforeUpgradeTip() {
        return this.beforeUpgradeTip;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public int getHasPopup() {
        return this.hasPopup;
    }

    public int getId() {
        return this._id;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPath() {
        return this.path;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getReleaseNotes() {
        return this.releaseNotes;
    }

    public int getSerial() {
        return this.serial;
    }

    public String getUnionVer() {
        return this.unionVer;
    }

    public float getUnionVersion() {
        return f.a(this.unionVer);
    }

    public String getUrl() {
        return this.url;
    }

    public String getVer() {
        return this.ver;
    }

    public float getVersion() {
        return f.a(this.ver);
    }

    public boolean isForceUpdate() {
        return this.forceUpdate;
    }

    public boolean isNeedUpdate() {
        return this.needUpdate;
    }

    public boolean isOtaUpdate() {
        return this.otaUpdate;
    }

    public boolean isShowPopup() {
        int n10 = this.hasPopup;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void setAfterUpgradeTip(String string2) {
        this.afterUpgradeTip = string2;
    }

    public void setBeforeUpgradeTip(String string2) {
        this.beforeUpgradeTip = string2;
    }

    public void setFilesize(long l10) {
        this.filesize = l10;
    }

    public void setForceUpdate(boolean bl2) {
        this.forceUpdate = bl2;
    }

    public void setHasPopup(int n10) {
        this.hasPopup = n10;
    }

    public void setId(int n10) {
        this._id = n10;
    }

    public void setMd5(String string2) {
        this.md5 = string2;
    }

    public void setNeedUpdate(boolean bl2) {
        this.needUpdate = bl2;
    }

    public void setNotice(String string2) {
        this.notice = string2;
    }

    public void setOtaUpdate(boolean bl2) {
        this.otaUpdate = bl2;
    }

    public void setPath(String string2) {
        this.path = string2;
    }

    public void setReleaseDate(String string2) {
        this.releaseDate = string2;
    }

    public void setReleaseNotes(String string2) {
        this.releaseNotes = string2;
    }

    public void setSerial(int n10) {
        this.serial = n10;
    }

    public void setUnionVer(String string2) {
        this.unionVer = string2;
    }

    public void setUnionVersion(float f10) {
        String string2;
        this.unionVer = string2 = String.valueOf(f10);
    }

    public void setUrl(String string2) {
        this.url = string2;
    }

    public void setVer(String string2) {
        this.ver = string2;
    }

    public void setVersion(float f10) {
        String string2;
        this.ver = string2 = String.valueOf(f10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FirmwareInfo{_id=");
        int n10 = this._id;
        stringBuilder.append(n10);
        stringBuilder.append(", serial=");
        n10 = this.serial;
        stringBuilder.append(n10);
        stringBuilder.append(", unionVer='");
        String string2 = this.unionVer;
        stringBuilder.append(string2);
        n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", ver='");
        String string3 = this.ver;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", releaseDate='");
        string3 = this.releaseDate;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", forceUpdate=");
        boolean bl2 = this.forceUpdate;
        stringBuilder.append(bl2);
        stringBuilder.append(", needUpdate=");
        bl2 = this.needUpdate;
        stringBuilder.append(bl2);
        stringBuilder.append(", otaUpdate=");
        bl2 = this.otaUpdate;
        stringBuilder.append(bl2);
        stringBuilder.append(", notice='");
        string3 = this.notice;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", releaseNotes='");
        string3 = this.releaseNotes;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", beforeUpgradeTip='");
        string3 = this.beforeUpgradeTip;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", afterUpgradeTip='");
        string3 = this.afterUpgradeTip;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", md5='");
        string3 = this.md5;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", url='");
        string3 = this.url;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", path='");
        string3 = this.path;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", filesize=");
        long l10 = this.filesize;
        stringBuilder.append(l10);
        stringBuilder.append(", hasPopup=");
        n10 = this.hasPopup;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this._id;
        parcel.writeInt(n10);
        n10 = this.serial;
        parcel.writeInt(n10);
        String string2 = this.unionVer;
        parcel.writeString(string2);
        string2 = this.ver;
        parcel.writeString(string2);
        string2 = this.releaseDate;
        parcel.writeString(string2);
        n10 = (int)(this.forceUpdate ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (int)(this.needUpdate ? 1 : 0);
        parcel.writeByte((byte)n10);
        n10 = (int)(this.otaUpdate ? 1 : 0);
        parcel.writeByte((byte)n10);
        string2 = this.notice;
        parcel.writeString(string2);
        string2 = this.releaseNotes;
        parcel.writeString(string2);
        string2 = this.md5;
        parcel.writeString(string2);
        string2 = this.url;
        parcel.writeString(string2);
        string2 = this.path;
        parcel.writeString(string2);
        string2 = this.beforeUpgradeTip;
        parcel.writeString(string2);
        string2 = this.afterUpgradeTip;
        parcel.writeString(string2);
        n10 = this.hasPopup;
        parcel.writeInt(n10);
    }
}

