/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo$1;
import com.sina.weibo.sdk.c.e;
import java.io.Serializable;

public final class AuthInfo
implements Parcelable,
Serializable {
    public static final Parcelable.Creator CREATOR;
    private static final long serialVersionUID = 6421253895937667193L;
    private String app_key;
    private String hash;
    private String package_name;
    private String redirect_url;
    private String scope;

    static {
        AuthInfo$1 authInfo$1 = new AuthInfo$1();
        CREATOR = authInfo$1;
    }

    public AuthInfo(Context object, String string2, String string3, String string4) {
        this.app_key = string2;
        this.redirect_url = string3;
        this.scope = string4;
        this.package_name = string2 = object.getPackageName();
        object = e.e(object, string2);
        this.hash = object;
    }

    public AuthInfo(Parcel object) {
        String string2;
        this.app_key = string2 = object.readString();
        this.redirect_url = string2 = object.readString();
        this.scope = string2 = object.readString();
        this.package_name = string2 = object.readString();
        object = object.readString();
        this.hash = object;
    }

    public final int describeContents() {
        return 0;
    }

    public final String getAppKey() {
        return this.app_key;
    }

    public final String getHash() {
        return this.hash;
    }

    public final String getPackageName() {
        return this.package_name;
    }

    public final String getRedirectUrl() {
        return this.redirect_url;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.app_key;
        parcel.writeString(string2);
        string2 = this.redirect_url;
        parcel.writeString(string2);
        string2 = this.scope;
        parcel.writeString(string2);
        string2 = this.package_name;
        parcel.writeString(string2);
        string2 = this.hash;
        parcel.writeString(string2);
    }
}

