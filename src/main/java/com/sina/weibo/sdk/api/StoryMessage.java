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
import com.sina.weibo.sdk.api.StoryMessage$1;

public class StoryMessage
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private Uri imageUri;
    private Uri videoUri;

    static {
        StoryMessage$1 storyMessage$1 = new StoryMessage$1();
        CREATOR = storyMessage$1;
    }

    public StoryMessage() {
    }

    public StoryMessage(Parcel parcel) {
        ClassLoader classLoader = Uri.class.getClassLoader();
        classLoader = (Uri)parcel.readParcelable(classLoader);
        this.imageUri = classLoader;
        classLoader = Uri.class.getClassLoader();
        parcel = (Uri)parcel.readParcelable(classLoader);
        this.videoUri = parcel;
    }

    public boolean checkResource() {
        Uri uri;
        Uri uri2 = this.imageUri;
        if (uri2 != null && (uri = this.videoUri) != null) {
            return false;
        }
        return uri2 != null || (uri2 = this.videoUri) != null;
        {
        }
    }

    public int describeContents() {
        return 0;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setImageUri(Uri uri) {
        this.imageUri = uri;
    }

    public void setVideoUri(Uri uri) {
        this.videoUri = uri;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Uri uri = this.imageUri;
        parcel.writeParcelable((Parcelable)uri, n10);
        uri = this.videoUri;
        parcel.writeParcelable((Parcelable)uri, n10);
    }
}

