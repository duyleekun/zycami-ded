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
import com.sina.weibo.sdk.api.WebpageObject$1;

public class WebpageObject
extends MediaObject {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = 7142128794153927442L;
    public String defaultText;

    static {
        WebpageObject$1 webpageObject$1 = new WebpageObject$1();
        CREATOR = webpageObject$1;
    }

    public WebpageObject() {
    }

    public WebpageObject(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
    }
}

