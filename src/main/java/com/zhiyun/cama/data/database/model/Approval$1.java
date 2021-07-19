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
import com.zhiyun.cama.data.database.model.Approval;

public final class Approval$1
implements Parcelable.Creator {
    public Approval createFromParcel(Parcel parcel) {
        Approval approval = new Approval(parcel);
        return approval;
    }

    public Approval[] newArray(int n10) {
        return new Approval[n10];
    }
}

