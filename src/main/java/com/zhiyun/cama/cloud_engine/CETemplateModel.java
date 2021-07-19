/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.cloud_engine;

import android.os.Parcel;
import android.os.Parcelable;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse$Data$DataType;
import com.zhiyun.cama.cloud_engine.CETemplateModel$a;

public class CETemplateModel
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private TemplateResponse$Data$DataType dateType;
    private String duration;
    private int height;
    private String icon;
    private String intro;
    private int maxMediaCount;
    private int orderNo;
    private int previewtype;
    private String previewurl;
    private long templateId;
    private String title;
    private int width;

    static {
        CETemplateModel$a cETemplateModel$a = new CETemplateModel$a();
        CREATOR = cETemplateModel$a;
    }

    private CETemplateModel() {
    }

    public CETemplateModel(Parcel object) {
        String string2;
        int n10;
        long l10;
        this.templateId = l10 = object.readLong();
        this.maxMediaCount = n10 = object.readInt();
        this.icon = string2 = object.readString();
        this.intro = string2 = object.readString();
        this.orderNo = n10 = object.readInt();
        this.title = string2 = object.readString();
        this.height = n10 = object.readInt();
        this.width = n10 = object.readInt();
        this.previewtype = n10 = object.readInt();
        this.previewurl = string2 = object.readString();
        object = object.readString();
        this.duration = object;
    }

    public static CETemplateModel from(TemplateResponse$Data object) {
        String string2;
        int n10;
        long l10;
        CETemplateModel cETemplateModel = new CETemplateModel();
        cETemplateModel.templateId = l10 = object.getTemplateId();
        cETemplateModel.maxMediaCount = n10 = object.getMaxMediaCount();
        cETemplateModel.icon = string2 = object.getIcon();
        cETemplateModel.intro = string2 = object.getIntro();
        cETemplateModel.orderNo = n10 = object.getOrderNo();
        cETemplateModel.title = string2 = object.getTitle();
        cETemplateModel.height = n10 = object.getHeight();
        cETemplateModel.width = n10 = object.getWidth();
        cETemplateModel.previewtype = n10 = object.getPreviewtype();
        cETemplateModel.previewurl = string2 = object.getPreviewurl();
        cETemplateModel.duration = string2 = object.getDuration();
        object = object.getDataType();
        cETemplateModel.dateType = object;
        return cETemplateModel;
    }

    public int describeContents() {
        return 0;
    }

    public TemplateResponse$Data$DataType getDateType() {
        return this.dateType;
    }

    public String getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIntro() {
        return this.intro;
    }

    public int getMaxMediaCount() {
        return this.maxMediaCount;
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public int getPreviewtype() {
        return this.previewtype;
    }

    public String getPreviewurl() {
        return this.previewurl;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CETemplateModel{templateId=");
        long l10 = this.templateId;
        stringBuilder.append(l10);
        stringBuilder.append(", maxMediaCount=");
        int c10 = this.maxMediaCount;
        stringBuilder.append(c10);
        stringBuilder.append(", icon='");
        String string2 = this.icon;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", intro='");
        String string3 = this.intro;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", orderNo=");
        int n10 = this.orderNo;
        stringBuilder.append(n10);
        stringBuilder.append(", title='");
        string3 = this.title;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", height=");
        n10 = this.height;
        stringBuilder.append(n10);
        stringBuilder.append(", width=");
        n10 = this.width;
        stringBuilder.append(n10);
        stringBuilder.append(", previewtype=");
        n10 = this.previewtype;
        stringBuilder.append(n10);
        stringBuilder.append(", previewurl='");
        string3 = this.previewurl;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", duration='");
        string3 = this.duration;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.templateId;
        parcel.writeLong(l10);
        n10 = this.maxMediaCount;
        parcel.writeInt(n10);
        String string2 = this.icon;
        parcel.writeString(string2);
        string2 = this.intro;
        parcel.writeString(string2);
        n10 = this.orderNo;
        parcel.writeInt(n10);
        string2 = this.title;
        parcel.writeString(string2);
        n10 = this.height;
        parcel.writeInt(n10);
        n10 = this.width;
        parcel.writeInt(n10);
        n10 = this.previewtype;
        parcel.writeInt(n10);
        string2 = this.previewurl;
        parcel.writeString(string2);
        string2 = this.duration;
        parcel.writeString(string2);
    }
}

