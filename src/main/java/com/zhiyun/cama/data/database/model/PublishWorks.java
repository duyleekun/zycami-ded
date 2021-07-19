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
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.model.PublishWorks$1;
import java.util.List;
import java.util.Objects;

public class PublishWorks
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final String TAG = "PublishWorks";
    private int activeId;
    private String address;
    private String archive;
    private int circleId;
    private String config;
    private String coverObjectKey;
    private String coverPath;
    private List devices;
    private String fileDuration;
    private String fileObjectKey;
    private String filePath;
    private String fileUrl;
    private String kwaiToken;
    private boolean needToDelete;
    private int percent;
    private String postUrl;
    private int publishFromType;
    private int resolution;
    private int shareToKwai;
    private String smallImgUrl;
    private PublishState state;
    private List tags;
    private int themeId;
    private String title;
    private String transcodingPath;
    private int type;
    private String worksDes;
    private int worksId;

    static {
        PublishWorks$1 publishWorks$1 = new PublishWorks$1();
        CREATOR = publishWorks$1;
    }

    public PublishWorks(int n10, String string2, String string3, String string4, String string5, PublishState publishState, String string6, boolean bl2, String string7, int n11, List list, String string8) {
        String string9;
        this.smallImgUrl = string9 = "";
        this.fileUrl = string9;
        this.worksId = n10;
        this.filePath = string2;
        this.coverPath = string3;
        this.fileDuration = string4;
        this.worksDes = string5;
        this.state = publishState;
        this.address = string6;
        this.needToDelete = bl2;
        this.config = string7;
        this.publishFromType = n11;
        this.tags = list;
        this.archive = string8;
    }

    public PublishWorks(Parcel parcel) {
        int n10;
        Object object;
        this.smallImgUrl = object = "";
        this.fileUrl = object;
        this.filePath = object = parcel.readString();
        this.coverPath = object = parcel.readString();
        this.fileDuration = object = parcel.readString();
        this.worksDes = object = parcel.readString();
        int n11 = parcel.readInt();
        int n12 = -1;
        if (n11 == n12) {
            n11 = 0;
            object = null;
        } else {
            PublishState[] publishStateArray = PublishState.values();
            object = publishStateArray[n11];
        }
        this.state = object;
        this.percent = n11 = parcel.readInt();
        this.title = object = parcel.readString();
        object = parcel.createStringArrayList();
        this.tags = object;
        object = parcel.createStringArrayList();
        this.devices = object;
        this.address = object = parcel.readString();
        this.activeId = n11 = parcel.readInt();
        this.themeId = n11 = parcel.readInt();
        n11 = parcel.readByte();
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        this.needToDelete = n11;
        this.config = object = parcel.readString();
        this.publishFromType = n11 = parcel.readInt();
        this.worksId = n11 = parcel.readInt();
        this.postUrl = object = parcel.readString();
        this.smallImgUrl = object = parcel.readString();
        this.fileUrl = object = parcel.readString();
        this.circleId = n11 = parcel.readInt();
        this.type = n11 = parcel.readInt();
        this.archive = object = parcel.readString();
        this.shareToKwai = n11 = parcel.readInt();
        this.kwaiToken = object = parcel.readString();
        this.coverObjectKey = object = parcel.readString();
        this.fileObjectKey = object = parcel.readString();
        this.resolution = n10 = parcel.readInt();
    }

    public PublishWorks(String string2) {
        String string3;
        this.smallImgUrl = string3 = "";
        this.fileUrl = string3;
        this.filePath = string2;
    }

    public PublishWorks(String string2, String string3, String string4, String string5, PublishState publishState, int n10, String string6, List list, List list2, String string7, int n11, int n12, boolean bl2, String string8, int n13, String string9, String string10, String string11, int n14, int n15, int n16) {
        Object object;
        this.smallImgUrl = object = "";
        this.fileUrl = object;
        object = string2;
        this.filePath = string2;
        object = string3;
        this.coverPath = string3;
        object = string4;
        this.fileDuration = string4;
        object = string5;
        this.worksDes = string5;
        object = publishState;
        this.state = publishState;
        this.percent = n10;
        object = string6;
        this.title = string6;
        object = list;
        this.tags = list;
        object = list2;
        this.devices = list2;
        object = string7;
        this.address = string7;
        this.activeId = n11;
        this.themeId = n12;
        this.needToDelete = bl2;
        object = string8;
        this.config = string8;
        this.worksId = n13;
        object = string9;
        this.postUrl = string9;
        object = string10;
        this.smallImgUrl = string10;
        object = string11;
        this.fileUrl = string11;
        this.circleId = n14;
        this.type = n15;
        this.publishFromType = n16;
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
            object = (PublishWorks)object;
            int n10 = this.percent;
            int n11 = ((PublishWorks)object).percent;
            if (n10 != n11 || (n10 = this.activeId) != (n11 = ((PublishWorks)object).activeId) || (n10 = this.themeId) != (n11 = ((PublishWorks)object).themeId) || (n10 = (int)(this.needToDelete ? 1 : 0)) != (n11 = (int)(((PublishWorks)object).needToDelete ? 1 : 0)) || (n10 = this.publishFromType) != (n11 = ((PublishWorks)object).publishFromType) || (n10 = this.worksId) != (n11 = ((PublishWorks)object).worksId) || (n10 = this.circleId) != (n11 = ((PublishWorks)object).circleId) || (n10 = this.type) != (n11 = ((PublishWorks)object).type) || (n10 = (int)(((String)(object3 = this.filePath)).equals(object2 = ((PublishWorks)object).filePath) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.coverPath, object2 = ((PublishWorks)object).coverPath) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.fileDuration, object2 = ((PublishWorks)object).fileDuration) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.worksDes, object2 = ((PublishWorks)object).worksDes) ? 1 : 0)) == 0 || (object3 = this.state) != (object2 = ((PublishWorks)object).state) || (n10 = (int)(Objects.equals(object3 = this.title, object2 = ((PublishWorks)object).title) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.tags, object2 = ((PublishWorks)object).tags) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.devices, object2 = ((PublishWorks)object).devices) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.address, object2 = ((PublishWorks)object).address) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.config, object2 = ((PublishWorks)object).config) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.postUrl, object2 = ((PublishWorks)object).postUrl) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.smallImgUrl, object2 = ((PublishWorks)object).smallImgUrl) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.fileUrl, object2 = ((PublishWorks)object).fileUrl) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.archive, object2 = ((PublishWorks)object).archive) ? 1 : 0)) == 0 || (n10 = this.shareToKwai) != (n11 = ((PublishWorks)object).shareToKwai) || (n10 = this.resolution) != (n11 = ((PublishWorks)object).resolution) || (n10 = (int)(Objects.equals(object3 = this.kwaiToken, object2 = ((PublishWorks)object).kwaiToken) ? 1 : 0)) == 0 || (n10 = (int)(Objects.equals(object3 = this.coverObjectKey, object2 = ((PublishWorks)object).coverObjectKey) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.fileObjectKey, object = ((PublishWorks)object).fileObjectKey))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getActiveId() {
        return this.activeId;
    }

    public String getAddress() {
        return this.address;
    }

    public String getArchive() {
        return this.archive;
    }

    public int getCircleId() {
        return this.circleId;
    }

    public String getConfig() {
        return this.config;
    }

    public String getCoverObjectKey() {
        return this.coverObjectKey;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public List getDevices() {
        return this.devices;
    }

    public String getFileDuration() {
        return this.fileDuration;
    }

    public String getFileObjectKey() {
        return this.fileObjectKey;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getKwaiToken() {
        return this.kwaiToken;
    }

    public int getPercent() {
        return this.percent;
    }

    public String getPostUrl() {
        return this.postUrl;
    }

    public int getPublishFromType() {
        return this.publishFromType;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getShareToKwai() {
        return this.shareToKwai;
    }

    public String getSmallImgUrl() {
        return this.smallImgUrl;
    }

    public PublishState getState() {
        return this.state;
    }

    public List getTags() {
        return this.tags;
    }

    public int getThemeId() {
        return this.themeId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTranscodingPath() {
        return this.transcodingPath;
    }

    public int getType() {
        return this.type;
    }

    public String getWorksDes() {
        return this.worksDes;
    }

    public int getWorksId() {
        return this.worksId;
    }

    public int hashCode() {
        Object[] objectArray = new Object[27];
        Object object = this.filePath;
        objectArray[0] = object;
        object = this.coverPath;
        objectArray[1] = object;
        object = this.fileDuration;
        objectArray[2] = object;
        object = this.worksDes;
        objectArray[3] = object;
        object = this.state;
        objectArray[4] = object;
        object = this.percent;
        objectArray[5] = object;
        object = this.title;
        objectArray[6] = object;
        object = this.tags;
        objectArray[7] = object;
        object = this.devices;
        objectArray[8] = object;
        object = this.address;
        objectArray[9] = object;
        object = this.activeId;
        objectArray[10] = object;
        object = this.themeId;
        objectArray[11] = object;
        object = this.needToDelete;
        objectArray[12] = object;
        object = this.config;
        objectArray[13] = object;
        object = this.publishFromType;
        objectArray[14] = object;
        object = this.worksId;
        objectArray[15] = object;
        object = this.postUrl;
        objectArray[16] = object;
        object = this.smallImgUrl;
        objectArray[17] = object;
        object = this.fileUrl;
        objectArray[18] = object;
        object = this.circleId;
        objectArray[19] = object;
        object = this.type;
        objectArray[20] = object;
        object = this.archive;
        objectArray[21] = object;
        object = this.shareToKwai;
        objectArray[22] = object;
        object = this.kwaiToken;
        objectArray[23] = object;
        object = this.resolution;
        objectArray[24] = object;
        object = this.coverObjectKey;
        objectArray[25] = object;
        object = this.fileObjectKey;
        objectArray[26] = object;
        return Objects.hash(objectArray);
    }

    public boolean isNeedToDelete() {
        return this.needToDelete;
    }

    public void setActiveId(int n10) {
        this.activeId = n10;
    }

    public void setAddress(String string2) {
        this.address = string2;
    }

    public void setArchive(String string2) {
        this.archive = string2;
    }

    public void setCircleId(int n10) {
        this.circleId = n10;
    }

    public void setConfig(String string2) {
        this.config = string2;
    }

    public void setCoverObjectKey(String string2) {
        this.coverObjectKey = string2;
    }

    public void setCoverPath(String string2) {
        this.coverPath = string2;
    }

    public void setDevices(List list) {
        this.devices = list;
    }

    public void setFileDuration(String string2) {
        this.fileDuration = string2;
    }

    public void setFileObjectKey(String string2) {
        this.fileObjectKey = string2;
    }

    public void setFilePath(String string2) {
        this.filePath = string2;
    }

    public void setFileUrl(String string2) {
        this.fileUrl = string2;
    }

    public void setKwaiToken(String string2) {
        this.kwaiToken = string2;
    }

    public void setNeedToDelete(boolean bl2) {
        this.needToDelete = bl2;
    }

    public void setPercent(int n10) {
        this.percent = n10;
    }

    public void setPostUrl(String string2) {
        this.postUrl = string2;
    }

    public void setPublishFromType(int n10) {
        this.publishFromType = n10;
    }

    public void setResolution(int n10) {
        this.resolution = n10;
    }

    public void setShareToKwai(int n10) {
        this.shareToKwai = n10;
    }

    public void setSmallImgUrl(String string2) {
        this.smallImgUrl = string2;
    }

    public void setState(PublishState publishState) {
        this.state = publishState;
    }

    public void setTags(List list) {
        this.tags = list;
    }

    public void setThemeId(int n10) {
        this.themeId = n10;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public void setTranscodingPath(String string2) {
        this.transcodingPath = string2;
    }

    public void setType(int n10) {
        this.type = n10;
    }

    public void setWorksDes(String string2) {
        this.worksDes = string2;
    }

    public void setWorksId(int n10) {
        this.worksId = n10;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.filePath;
        parcel.writeString((String)object);
        object = this.coverPath;
        parcel.writeString((String)object);
        object = this.fileDuration;
        parcel.writeString((String)object);
        object = this.worksDes;
        parcel.writeString((String)object);
        object = this.state;
        n10 = object == null ? -1 : ((Enum)object).ordinal();
        parcel.writeInt(n10);
        n10 = this.percent;
        parcel.writeInt(n10);
        object = this.title;
        parcel.writeString((String)object);
        object = this.tags;
        parcel.writeStringList((List)object);
        object = this.devices;
        parcel.writeStringList((List)object);
        object = this.address;
        parcel.writeString((String)object);
        n10 = this.activeId;
        parcel.writeInt(n10);
        n10 = this.themeId;
        parcel.writeInt(n10);
        n10 = (int)(this.needToDelete ? 1 : 0);
        parcel.writeByte((byte)n10);
        object = this.config;
        parcel.writeString((String)object);
        n10 = this.publishFromType;
        parcel.writeInt(n10);
        n10 = this.worksId;
        parcel.writeInt(n10);
        object = this.postUrl;
        parcel.writeString((String)object);
        object = this.smallImgUrl;
        parcel.writeString((String)object);
        object = this.fileUrl;
        parcel.writeString((String)object);
        n10 = this.circleId;
        parcel.writeInt(n10);
        n10 = this.type;
        parcel.writeInt(n10);
        object = this.archive;
        parcel.writeString((String)object);
        n10 = this.shareToKwai;
        parcel.writeInt(n10);
        object = this.kwaiToken;
        parcel.writeString((String)object);
        object = this.coverObjectKey;
        parcel.writeString((String)object);
        object = this.fileObjectKey;
        parcel.writeString((String)object);
        n10 = this.resolution;
        parcel.writeInt(n10);
    }
}

