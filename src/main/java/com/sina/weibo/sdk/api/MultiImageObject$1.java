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
import com.sina.weibo.sdk.api.MultiImageObject;

public final class MultiImageObject$1
implements Parcelable.Creator {
    public final MultiImageObject createFromParcel(Parcel parcel) {
        MultiImageObject multiImageObject = new MultiImageObject(parcel);
        return multiImageObject;
    }

    public final MultiImageObject[] newArray(int n10) {
        return new MultiImageObject[n10];
    }
}

