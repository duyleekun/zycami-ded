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
import com.zhiyun.cama.data.database.model.Appeal;

public final class Appeal$1
implements Parcelable.Creator {
    public Appeal createFromParcel(Parcel parcel) {
        Appeal appeal = new Appeal(parcel);
        return appeal;
    }

    public Appeal[] newArray(int n10) {
        return new Appeal[n10];
    }
}

