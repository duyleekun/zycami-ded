/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.entity.auth.Scope;

public final class Scope$a
implements Parcelable.Creator {
    public Scope createFromParcel(Parcel parcel) {
        Scope scope = new Scope(parcel);
        return scope;
    }

    public Scope[] newArray(int n10) {
        return new Scope[n10];
    }
}

