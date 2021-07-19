/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.MediaObject$1;
import java.io.Serializable;

public class MediaObject
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = -5562495969515901397L;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    static {
        MediaObject$1 mediaObject$1 = new MediaObject$1();
        CREATOR = mediaObject$1;
    }

    public MediaObject() {
    }

    public MediaObject(Parcel object) {
        String string2;
        this.actionUrl = string2 = object.readString();
        this.schema = string2 = object.readString();
        this.identify = string2 = object.readString();
        this.title = string2 = object.readString();
        this.description = string2 = object.readString();
        object = object.createByteArray();
        this.thumbData = (byte[])object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.actionUrl;
        parcel.writeString((String)object);
        object = this.schema;
        parcel.writeString((String)object);
        object = this.identify;
        parcel.writeString((String)object);
        object = this.title;
        parcel.writeString((String)object);
        object = this.description;
        parcel.writeString((String)object);
        object = this.thumbData;
        parcel.writeByteArray((byte[])object);
    }
}

