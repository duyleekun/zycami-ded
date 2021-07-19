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
import com.zhiyun.cama.data.database.model.Feedback;

public final class Feedback$1
implements Parcelable.Creator {
    public Feedback createFromParcel(Parcel parcel) {
        Feedback feedback = new Feedback(parcel);
        return feedback;
    }

    public Feedback[] newArray(int n10) {
        return new Feedback[n10];
    }
}

