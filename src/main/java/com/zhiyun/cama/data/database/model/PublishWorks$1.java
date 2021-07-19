/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.data.database.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.data.database.model.PublishWorks;

public final class PublishWorks$1
implements Parcelable.Creator {
    public PublishWorks createFromParcel(Parcel parcel) {
        PublishWorks publishWorks = new PublishWorks(parcel);
        return publishWorks;
    }

    public PublishWorks[] newArray(int n10) {
        return new PublishWorks[n10];
    }
}

