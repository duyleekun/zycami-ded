/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.api.MediaObject;
import com.sina.weibo.sdk.api.VideoSourceObject$1;

public class VideoSourceObject
extends MediaObject {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = 2745594466460840583L;
    public Uri coverPath;
    public long during;
    public Uri videoPath;

    static {
        VideoSourceObject$1 videoSourceObject$1 = new VideoSourceObject$1();
        CREATOR = videoSourceObject$1;
    }

    public VideoSourceObject() {
    }

    public VideoSourceObject(Parcel parcel) {
        super(parcel);
        long l10;
        ClassLoader classLoader = Uri.class.getClassLoader();
        classLoader = (Uri)parcel.readParcelable(classLoader);
        this.coverPath = classLoader;
        classLoader = Uri.class.getClassLoader();
        classLoader = (Uri)parcel.readParcelable(classLoader);
        this.videoPath = classLoader;
        this.during = l10 = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        Uri uri = this.coverPath;
        parcel.writeParcelable((Parcelable)uri, n10);
        uri = this.videoPath;
        parcel.writeParcelable((Parcelable)uri, n10);
        long l10 = this.during;
        parcel.writeLong(l10);
    }
}

