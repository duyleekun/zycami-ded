/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.net.Punish;

public class Punish$1
implements Parcelable.Creator {
    public Punish createFromParcel(Parcel parcel) {
        Punish punish = new Punish(parcel);
        return punish;
    }

    public Punish[] newArray(int n10) {
        return new Punish[n10];
    }
}

