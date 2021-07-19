/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.updatesdk.a.b.c.c.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo$a;
import java.io.Serializable;

public class ApkUpgradeInfo
extends b
implements Serializable,
Parcelable {
    public static final int APP_MUST_UPDATE = 1;
    public static final Parcelable.Creator CREATOR;
    public static final int HUAWEI_OFFICIAL_APP = 1;
    public static final int NOT_AUTOUPDATE = 0;
    private static final String TAG = "ApkUpgradeInfo";
    public static final int UPGRADE_SAME_SIGNATURE = 0;
    private static final long serialVersionUID = 136275377334431721L;
    private long bundleSize_;
    private String detailId_;
    private int devType_ = 0;
    private String diffDownUrl;
    private String diffSha2_;
    private int diffSize_;
    private String downurl_;
    private String fullDownUrl_;
    private String icon_;
    private String id_;
    private int isAutoUpdate_ = 0;
    private int isCompulsoryUpdate_ = 0;
    private int maple_;
    private String name_;
    private String newFeatures_;
    private String notRcmReason_;
    private long obbSize_;
    private int oldVersionCode_;
    private String oldVersionName_;
    private String package_;
    private int packingType_;
    private String releaseDateDesc_;
    private String releaseDate_;
    private int sameS_ = 0;
    private String sha256_;
    private long size_;
    private int state_ = 2;
    private int versionCode_;
    private String version_;

    static {
        ApkUpgradeInfo$a apkUpgradeInfo$a = new ApkUpgradeInfo$a();
        CREATOR = apkUpgradeInfo$a;
    }

    public ApkUpgradeInfo() {
    }

    public ApkUpgradeInfo(Parcel parcel) {
        long l10;
        int n10;
        String string2;
        this.id_ = string2 = parcel.readString();
        this.name_ = string2 = parcel.readString();
        this.package_ = string2 = parcel.readString();
        this.oldVersionName_ = string2 = parcel.readString();
        this.version_ = string2 = parcel.readString();
        this.diffSize_ = n10 = parcel.readInt();
        this.diffDownUrl = string2 = parcel.readString();
        this.diffSha2_ = string2 = parcel.readString();
        this.sameS_ = n10 = parcel.readInt();
        this.size_ = l10 = parcel.readLong();
        this.obbSize_ = l10 = parcel.readLong();
        this.releaseDate_ = string2 = parcel.readString();
        this.icon_ = string2 = parcel.readString();
        this.oldVersionCode_ = n10 = parcel.readInt();
        this.versionCode_ = n10 = parcel.readInt();
        this.downurl_ = string2 = parcel.readString();
        this.sha256_ = string2 = parcel.readString();
        this.newFeatures_ = string2 = parcel.readString();
        this.releaseDateDesc_ = string2 = parcel.readString();
        this.state_ = n10 = parcel.readInt();
        this.detailId_ = string2 = parcel.readString();
        this.isAutoUpdate_ = n10 = parcel.readInt();
        this.isCompulsoryUpdate_ = n10 = parcel.readInt();
        this.notRcmReason_ = string2 = parcel.readString();
        this.devType_ = n10 = parcel.readInt();
        this.fullDownUrl_ = string2 = parcel.readString();
        this.maple_ = n10 = parcel.readInt();
        this.packingType_ = n10 = parcel.readInt();
        this.bundleSize_ = l10 = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public long getBundleSize_() {
        return this.bundleSize_;
    }

    public String getDetailId_() {
        return this.detailId_;
    }

    public int getDevType_() {
        return this.devType_;
    }

    public String getDiffDownUrl_() {
        return this.diffDownUrl;
    }

    public String getDiffSha2_() {
        return this.diffSha2_;
    }

    public int getDiffSize_() {
        return this.diffSize_;
    }

    public String getDownurl_() {
        return this.downurl_;
    }

    public String getFullDownUrl_() {
        return this.fullDownUrl_;
    }

    public String getIcon_() {
        return this.icon_;
    }

    public String getId_() {
        return this.id_;
    }

    public int getIsAutoUpdate_() {
        return this.isAutoUpdate_;
    }

    public int getIsCompulsoryUpdate_() {
        return this.isCompulsoryUpdate_;
    }

    public long getLongSize_() {
        return this.size_;
    }

    public int getMaple_() {
        return this.maple_;
    }

    public String getName_() {
        return this.name_;
    }

    public String getNewFeatures_() {
        return this.newFeatures_;
    }

    public String getNotRcmReason_() {
        return this.notRcmReason_;
    }

    public long getObbSize_() {
        return this.obbSize_;
    }

    public int getOldVersionCode_() {
        return this.oldVersionCode_;
    }

    public String getOldVersionName_() {
        return this.oldVersionName_;
    }

    public String getPackage_() {
        return this.package_;
    }

    public int getPackingType_() {
        return this.packingType_;
    }

    public String getReleaseDateDesc_() {
        return this.releaseDateDesc_;
    }

    public String getReleaseDate_() {
        return this.releaseDate_;
    }

    public int getSameS_() {
        return this.sameS_;
    }

    public String getSha256_() {
        return this.sha256_;
    }

    public int getSize_() {
        return (int)this.size_;
    }

    public int getState_() {
        return this.state_;
    }

    public int getVersionCode_() {
        return this.versionCode_;
    }

    public String getVersion_() {
        return this.version_;
    }

    public void setBundleSize_(long l10) {
        this.bundleSize_ = l10;
    }

    public void setDetailId_(String string2) {
        this.detailId_ = string2;
    }

    public void setDevType_(int n10) {
        this.devType_ = n10;
    }

    public void setDiffDownUrl_(String string2) {
        this.diffDownUrl = string2;
    }

    public void setDiffSha2_(String string2) {
        this.diffSha2_ = string2;
    }

    public void setDiffSize_(int n10) {
        this.diffSize_ = n10;
    }

    public void setDownurl_(String string2) {
        this.downurl_ = string2;
    }

    public void setFullDownUrl_(String string2) {
        this.fullDownUrl_ = string2;
    }

    public void setIcon_(String string2) {
        this.icon_ = string2;
    }

    public void setId_(String string2) {
        this.id_ = string2;
    }

    public void setIsAutoUpdate_(int n10) {
        this.isAutoUpdate_ = n10;
    }

    public void setIsCompulsoryUpdate_(int n10) {
        this.isCompulsoryUpdate_ = n10;
    }

    public void setMaple_(int n10) {
        this.maple_ = n10;
    }

    public void setName_(String string2) {
        this.name_ = string2;
    }

    public void setNewFeatures_(String string2) {
        this.newFeatures_ = string2;
    }

    public void setNotRcmReason_(String string2) {
        this.notRcmReason_ = string2;
    }

    public void setObbSize_(long l10) {
        this.obbSize_ = l10;
    }

    public void setOldVersionCode_(int n10) {
        this.oldVersionCode_ = n10;
    }

    public void setOldVersionName_(String string2) {
        this.oldVersionName_ = string2;
    }

    public void setPackage_(String string2) {
        this.package_ = string2;
    }

    public void setPackingType_(int n10) {
        this.packingType_ = n10;
    }

    public void setReleaseDateDesc_(String string2) {
        this.releaseDateDesc_ = string2;
    }

    public void setReleaseDate_(String string2) {
        this.releaseDate_ = string2;
    }

    public void setSameS_(int n10) {
        this.sameS_ = n10;
    }

    public void setSha256_(String string2) {
        this.sha256_ = string2;
    }

    public void setSize_(long l10) {
        this.size_ = l10;
    }

    public void setState_(int n10) {
        this.state_ = n10;
    }

    public void setVersionCode_(int n10) {
        this.versionCode_ = n10;
    }

    public void setVersion_(String string2) {
        this.version_ = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" {\n\tid_: ");
        String string2 = this.getId_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tname_: ");
        string2 = this.getName_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tpackage_: ");
        string2 = this.getPackage_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tversion_: ");
        string2 = this.getVersion_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tdiffSize_: ");
        int n10 = this.getDiffSize_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tdiffDownUrl_: ");
        string2 = this.getDiffDownUrl_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tdiffSha2_: ");
        string2 = this.getDiffSha2_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tsameS_: ");
        n10 = this.getSameS_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tsize_: ");
        long l10 = this.getLongSize_();
        stringBuilder.append(l10);
        stringBuilder.append("\n\treleaseDate_: ");
        string2 = this.getReleaseDate_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\ticon_: ");
        string2 = this.getIcon_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\toldVersionCode_: ");
        n10 = this.getOldVersionCode_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tversionCode_: ");
        n10 = this.getVersionCode_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tdownurl_: ");
        string2 = this.getDownurl_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tnewFeatures_: ");
        string2 = this.getNewFeatures_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\treleaseDateDesc_: ");
        string2 = this.getReleaseDateDesc_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tstate_: ");
        n10 = this.getState_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tdetailId_: ");
        string2 = this.getDetailId_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tfullDownUrl_: ");
        string2 = this.getFullDownUrl_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tisCompulsoryUpdate_: ");
        n10 = this.getIsCompulsoryUpdate_();
        stringBuilder.append(n10);
        stringBuilder.append("\n\tnotRcmReason_: ");
        string2 = this.getNotRcmReason_();
        stringBuilder.append(string2);
        stringBuilder.append("\n\tdevType_: ");
        n10 = this.getDevType_();
        stringBuilder.append(n10);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.id_;
        parcel.writeString(string2);
        string2 = this.name_;
        parcel.writeString(string2);
        string2 = this.package_;
        parcel.writeString(string2);
        string2 = this.oldVersionName_;
        parcel.writeString(string2);
        string2 = this.version_;
        parcel.writeString(string2);
        n10 = this.diffSize_;
        parcel.writeInt(n10);
        string2 = this.diffDownUrl;
        parcel.writeString(string2);
        string2 = this.diffSha2_;
        parcel.writeString(string2);
        n10 = this.sameS_;
        parcel.writeInt(n10);
        long l10 = this.size_;
        parcel.writeLong(l10);
        l10 = this.obbSize_;
        parcel.writeLong(l10);
        string2 = this.releaseDate_;
        parcel.writeString(string2);
        string2 = this.icon_;
        parcel.writeString(string2);
        n10 = this.oldVersionCode_;
        parcel.writeInt(n10);
        n10 = this.versionCode_;
        parcel.writeInt(n10);
        string2 = this.downurl_;
        parcel.writeString(string2);
        string2 = this.sha256_;
        parcel.writeString(string2);
        string2 = this.newFeatures_;
        parcel.writeString(string2);
        string2 = this.releaseDateDesc_;
        parcel.writeString(string2);
        n10 = this.state_;
        parcel.writeInt(n10);
        string2 = this.detailId_;
        parcel.writeString(string2);
        n10 = this.isAutoUpdate_;
        parcel.writeInt(n10);
        n10 = this.isCompulsoryUpdate_;
        parcel.writeInt(n10);
        string2 = this.notRcmReason_;
        parcel.writeString(string2);
        n10 = this.devType_;
        parcel.writeInt(n10);
        string2 = this.fullDownUrl_;
        parcel.writeString(string2);
        n10 = this.maple_;
        parcel.writeInt(n10);
        n10 = this.packingType_;
        parcel.writeInt(n10);
        l10 = this.bundleSize_;
        parcel.writeLong(l10);
    }
}

