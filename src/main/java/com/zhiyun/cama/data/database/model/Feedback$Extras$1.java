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
import com.zhiyun.cama.data.database.model.Feedback$Extras;

public final class Feedback$Extras$1
implements Parcelable.Creator {
    public Feedback$Extras createFromParcel(Parcel parcel) {
        Feedback$Extras feedback$Extras = new Feedback$Extras(parcel);
        return feedback$Extras;
    }

    public Feedback$Extras[] newArray(int n10) {
        return new Feedback$Extras[n10];
    }
}

