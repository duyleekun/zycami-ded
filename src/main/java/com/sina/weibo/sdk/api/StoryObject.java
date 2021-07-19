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
import com.sina.weibo.sdk.api.StoryObject$1;

public class StoryObject
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public String appId;
    public String appPackage;
    public String callbackAction;
    public String sourcePath;
    public int sourceType;

    static {
        StoryObject$1 storyObject$1 = new StoryObject$1();
        CREATOR = storyObject$1;
    }

    public StoryObject() {
    }

    public StoryObject(Parcel object) {
        int n10;
        String string2;
        this.sourcePath = string2 = object.readString();
        this.sourceType = n10 = object.readInt();
        this.appId = string2 = object.readString();
        this.appPackage = string2 = object.readString();
        object = object.readString();
        this.callbackAction = object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.sourcePath;
        parcel.writeString(string2);
        n10 = this.sourceType;
        parcel.writeInt(n10);
        string2 = this.appId;
        parcel.writeString(string2);
        string2 = this.appPackage;
        parcel.writeString(string2);
        string2 = this.callbackAction;
        parcel.writeString(string2);
    }
}

