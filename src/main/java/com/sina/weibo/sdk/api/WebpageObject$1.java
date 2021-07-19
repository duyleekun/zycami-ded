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
import com.sina.weibo.sdk.api.WebpageObject;

public final class WebpageObject$1
implements Parcelable.Creator {
    public final WebpageObject createFromParcel(Parcel parcel) {
        WebpageObject webpageObject = new WebpageObject(parcel);
        return webpageObject;
    }

    public final WebpageObject[] newArray(int n10) {
        return new WebpageObject[n10];
    }
}

