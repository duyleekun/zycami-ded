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
import com.sina.weibo.sdk.api.TextObject$1;

public class TextObject
extends MediaObject {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = -5610314414793811821L;
    public String text;

    static {
        TextObject$1 textObject$1 = new TextObject$1();
        CREATOR = textObject$1;
    }

    public TextObject() {
    }

    public TextObject(Parcel object) {
        object = object.readString();
        this.text = object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.text;
        parcel.writeString(string2);
    }
}

