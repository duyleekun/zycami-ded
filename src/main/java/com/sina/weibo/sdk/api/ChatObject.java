/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.ChatObject$1;
import com.sina.weibo.sdk.api.MediaObject;

public class ChatObject
extends MediaObject {
    public static final Parcelable.Creator CREATOR;
    public String content;
    public String image_url;
    public String summary;
    public String url;

    static {
        ChatObject$1 chatObject$1 = new ChatObject$1();
        CREATOR = chatObject$1;
    }

    public ChatObject() {
    }

    public ChatObject(Parcel object) {
        super((Parcel)object);
        String string2;
        this.url = string2 = object.readString();
        this.content = string2 = object.readString();
        this.image_url = string2 = object.readString();
        object = object.readString();
        this.summary = object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        String string2 = this.url;
        parcel.writeString(string2);
        string2 = this.content;
        parcel.writeString(string2);
        string2 = this.image_url;
        parcel.writeString(string2);
        string2 = this.summary;
        parcel.writeString(string2);
    }
}

