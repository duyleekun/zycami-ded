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
import com.sina.weibo.sdk.api.VideoSourceObject;

public final class VideoSourceObject$1
implements Parcelable.Creator {
    public final VideoSourceObject createFromParcel(Parcel parcel) {
        VideoSourceObject videoSourceObject = new VideoSourceObject(parcel);
        return videoSourceObject;
    }

    public final VideoSourceObject[] newArray(int n10) {
        return new VideoSourceObject[n10];
    }
}

