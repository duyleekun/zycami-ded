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
import com.sina.weibo.sdk.api.StoryMessage;

public final class StoryMessage$1
implements Parcelable.Creator {
    public final StoryMessage createFromParcel(Parcel parcel) {
        StoryMessage storyMessage = new StoryMessage(parcel);
        return storyMessage;
    }

    public final StoryMessage[] newArray(int n10) {
        return new StoryMessage[n10];
    }
}

