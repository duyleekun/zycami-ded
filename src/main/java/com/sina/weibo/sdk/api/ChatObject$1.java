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
import com.sina.weibo.sdk.api.ChatObject;

public final class ChatObject$1
implements Parcelable.Creator {
    public final ChatObject createFromParcel(Parcel parcel) {
        ChatObject chatObject = new ChatObject(parcel);
        return chatObject;
    }

    public final ChatObject[] newArray(int n10) {
        return new ChatObject[n10];
    }
}

