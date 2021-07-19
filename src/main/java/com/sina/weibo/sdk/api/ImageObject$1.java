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
import com.sina.weibo.sdk.api.ImageObject;

public final class ImageObject$1
implements Parcelable.Creator {
    public final ImageObject createFromParcel(Parcel parcel) {
        ImageObject imageObject = new ImageObject(parcel);
        return imageObject;
    }

    public final ImageObject[] newArray(int n10) {
        return new ImageObject[n10];
    }
}

