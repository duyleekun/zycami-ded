/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData$1;
import java.io.Serializable;

public class WebData
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = -4038177938155795889L;
    public AuthInfo aA;
    public String aB;
    public int type;
    public String url;

    static {
        WebData$1 webData$1 = new WebData$1();
        CREATOR = webData$1;
    }

    public WebData(Parcel object) {
        int n10;
        Object object2 = AuthInfo.class.getClassLoader();
        this.aA = object2 = (AuthInfo)object.readParcelable((ClassLoader)object2);
        this.type = n10 = object.readInt();
        this.url = object2 = object.readString();
        object = object.readString();
        this.aB = object;
    }

    public WebData(AuthInfo authInfo, int n10, String string2, String string3) {
        this.aA = authInfo;
        this.type = n10;
        this.url = string2;
        this.aB = string3;
    }

    public final AuthInfo a() {
        return this.aA;
    }

    public int describeContents() {
        return 0;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String u() {
        return this.aB;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        AuthInfo authInfo = this.aA;
        parcel.writeParcelable((Parcelable)authInfo, n10);
        n10 = this.type;
        parcel.writeInt(n10);
        String string2 = this.url;
        parcel.writeString(string2);
        string2 = this.aB;
        parcel.writeString(string2);
    }
}

