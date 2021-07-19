/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.data.database.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.data.database.model.Feedback$1;
import com.zhiyun.cama.data.database.model.Feedback$Extras;
import com.zhiyun.net.BaseEntity;
import java.util.List;
import java.util.Objects;

public class Feedback
extends BaseEntity
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final String TAG = "Feedback";
    private String advice_target;
    private String appVersion;
    private boolean canActive;
    private String closedAt;
    private String contact;
    private String content;
    private String createAt;
    private int dealStatus;
    private String deviceModel;
    private List extras;
    private String firmwareVersion;
    private int frequency;
    private int id;
    private String images;
    private String mobileModel;
    private String mobileOSVersion;
    private String name;
    private String platform;
    private String title;
    private String type;
    private long userId;
    private String user_lang;

    static {
        Feedback$1 feedback$1 = new Feedback$1();
        CREATOR = feedback$1;
    }

    public Feedback() {
    }

    public Feedback(Parcel object) {
        String string2;
        long l10;
        int n10;
        this.id = n10 = object.readInt();
        this.userId = l10 = object.readLong();
        this.name = string2 = object.readString();
        this.contact = string2 = object.readString();
        this.title = string2 = object.readString();
        this.content = string2 = object.readString();
        this.type = string2 = object.readString();
        this.platform = string2 = object.readString();
        this.mobileModel = string2 = object.readString();
        this.mobileOSVersion = string2 = object.readString();
        this.appVersion = string2 = object.readString();
        this.deviceModel = string2 = object.readString();
        this.images = string2 = object.readString();
        this.user_lang = string2 = object.readString();
        this.firmwareVersion = string2 = object.readString();
        this.frequency = n10 = object.readInt();
        this.advice_target = string2 = object.readString();
        this.dealStatus = n10 = object.readInt();
        this.createAt = string2 = object.readString();
        this.closedAt = string2 = object.readString();
        n10 = object.readByte();
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        this.canActive = n10;
        string2 = Feedback$Extras.CREATOR;
        object = object.createTypedArrayList((Parcelable.Creator)string2);
        this.extras = object;
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
            long l10;
            long l11;
            long l12;
            object = (Feedback)object;
            int n10 = this.id;
            int n11 = ((Feedback)object).id;
            if (n10 != n11 || (n10 = (int)((l12 = (l11 = this.userId) - (l10 = ((Feedback)object).userId)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 || (n10 = this.frequency) != (n11 = ((Feedback)object).frequency) || (n10 = this.dealStatus) != (n11 = ((Feedback)object).dealStatus) || (n10 = (int)(this.canActive ? 1 : 0)) != (n11 = (int)(((Feedback)object).canActive ? 1 : 0)) || (n10 = (int)(Objects.equals(object3 = this.name, object2 = ((Feedback)object).name) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.contact, object2 = ((Feedback)object).contact) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.title, object2 = ((Feedback)object).title) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.content, object2 = ((Feedback)object).content) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.type, object2 = ((Feedback)object).type) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.platform, object2 = ((Feedback)object).platform) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.mobileModel, object2 = ((Feedback)object).mobileModel) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.mobileOSVersion, object2 = ((Feedback)object).mobileOSVersion) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.appVersion, object2 = ((Feedback)object).appVersion) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.deviceModel, object2 = ((Feedback)object).deviceModel) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.images, object2 = ((Feedback)object).images) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.user_lang, object2 = ((Feedback)object).user_lang) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.firmwareVersion, object2 = ((Feedback)object).firmwareVersion) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.advice_target, object2 = ((Feedback)object).advice_target) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.createAt, object2 = ((Feedback)object).createAt) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.closedAt, object = ((Feedback)object).closedAt))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getAdvice_target() {
        return this.advice_target;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getClosedAt() {
        return this.closedAt;
    }

    public String getContact() {
        return this.contact;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public int getDealStatus() {
        return this.dealStatus;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public List getExtras() {
        return this.extras;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getId() {
        return this.id;
    }

    public String getImages() {
        return this.images;
    }

    public String getMobileModel() {
        return this.mobileModel;
    }

    public String getMobileOSVersion() {
        return this.mobileOSVersion;
    }

    public String getName() {
        return this.name;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUser_lang() {
        return this.user_lang;
    }

    public int hashCode() {
        Object object = this.id;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.userId), object = this.name, object = this.contact, object = this.title, object = this.content, object = this.type, object = this.platform, object = this.mobileModel, object = this.mobileOSVersion, object = this.appVersion, object = this.deviceModel, object = this.images, object = this.user_lang, object = this.firmwareVersion, object = Integer.valueOf(this.frequency), object = this.advice_target, object = Integer.valueOf(this.dealStatus), object = this.createAt, object = this.closedAt, object = Boolean.valueOf(this.canActive)};
        return Objects.hash(objectArray);
    }

    public boolean isCanActive() {
        return this.canActive;
    }

    public void setAdvice_target(String string2) {
        this.advice_target = string2;
    }

    public void setAppVersion(String string2) {
        this.appVersion = string2;
    }

    public void setCanActive(boolean bl2) {
        this.canActive = bl2;
    }

    public void setClosedAt(String string2) {
        this.closedAt = string2;
    }

    public void setContact(String string2) {
        this.contact = string2;
    }

    public void setContent(String string2) {
        this.content = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setDealStatus(int n10) {
        this.dealStatus = n10;
    }

    public void setDeviceModel(String string2) {
        this.deviceModel = string2;
    }

    public void setExtras(List list) {
        this.extras = list;
    }

    public void setFirmwareVersion(String string2) {
        this.firmwareVersion = string2;
    }

    public void setFrequency(int n10) {
        this.frequency = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setImages(String string2) {
        this.images = string2;
    }

    public void setMobileModel(String string2) {
        this.mobileModel = string2;
    }

    public void setMobileOSVersion(String string2) {
        this.mobileOSVersion = string2;
    }

    public void setName(String string2) {
        this.name = string2;
    }

    public void setPlatform(String string2) {
        this.platform = string2;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public void setUserId(long l10) {
        this.userId = l10;
    }

    public void setUser_lang(String string2) {
        this.user_lang = string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.id;
        parcel.writeInt(n10);
        long l10 = this.userId;
        parcel.writeLong(l10);
        Object object = this.name;
        parcel.writeString((String)object);
        object = this.contact;
        parcel.writeString((String)object);
        object = this.title;
        parcel.writeString((String)object);
        object = this.content;
        parcel.writeString((String)object);
        object = this.type;
        parcel.writeString((String)object);
        object = this.platform;
        parcel.writeString((String)object);
        object = this.mobileModel;
        parcel.writeString((String)object);
        object = this.mobileOSVersion;
        parcel.writeString((String)object);
        object = this.appVersion;
        parcel.writeString((String)object);
        object = this.deviceModel;
        parcel.writeString((String)object);
        object = this.images;
        parcel.writeString((String)object);
        object = this.user_lang;
        parcel.writeString((String)object);
        object = this.firmwareVersion;
        parcel.writeString((String)object);
        n10 = this.frequency;
        parcel.writeInt(n10);
        object = this.advice_target;
        parcel.writeString((String)object);
        n10 = this.dealStatus;
        parcel.writeInt(n10);
        object = this.createAt;
        parcel.writeString((String)object);
        object = this.closedAt;
        parcel.writeString((String)object);
        n10 = (int)(this.canActive ? 1 : 0);
        parcel.writeByte((byte)n10);
        object = this.extras;
        parcel.writeTypedList((List)object);
    }
}

