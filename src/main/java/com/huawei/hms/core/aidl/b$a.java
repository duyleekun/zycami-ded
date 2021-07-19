/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.core.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.b;

public final class b$a
implements Parcelable.Creator {
    public b createFromParcel(Parcel parcel) {
        b b10 = new b(parcel, null);
        return b10;
    }

    public b[] newArray(int n10) {
        return new b[n10];
    }
}

