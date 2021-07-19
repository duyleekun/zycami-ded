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
import com.sina.weibo.sdk.api.MediaObject;

public final class MediaObject$1
implements Parcelable.Creator {
    public final MediaObject createFromParcel(Parcel parcel) {
        MediaObject mediaObject = new MediaObject(parcel);
        return mediaObject;
    }

    public final MediaObject[] newArray(int n10) {
        return new MediaObject[n10];
    }
}

