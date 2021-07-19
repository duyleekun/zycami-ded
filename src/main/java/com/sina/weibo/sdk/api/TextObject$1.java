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
import com.sina.weibo.sdk.api.TextObject;

public final class TextObject$1
implements Parcelable.Creator {
    public final TextObject createFromParcel(Parcel parcel) {
        TextObject textObject = new TextObject(parcel);
        return textObject;
    }

    public final TextObject[] newArray(int n10) {
        return new TextObject[n10];
    }
}

