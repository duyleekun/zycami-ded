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
import com.sina.weibo.sdk.api.StoryObject;

public final class StoryObject$1
implements Parcelable.Creator {
    public final StoryObject createFromParcel(Parcel parcel) {
        StoryObject storyObject = new StoryObject(parcel);
        return storyObject;
    }

    public final StoryObject[] newArray(int n10) {
        return new StoryObject[n10];
    }
}

