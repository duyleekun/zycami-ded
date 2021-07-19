/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.metrics.Counter;

public class Counter$1
implements Parcelable.Creator {
    public Counter createFromParcel(Parcel parcel) {
        Counter counter = new Counter(parcel, null);
        return counter;
    }

    public Counter[] newArray(int n10) {
        return new Counter[n10];
    }
}

