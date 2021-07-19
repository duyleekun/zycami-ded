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
import com.google.firebase.perf.metrics.Trace;

public class Trace$1
implements Parcelable.Creator {
    public Trace createFromParcel(Parcel parcel) {
        Trace trace = new Trace(parcel, false, null);
        return trace;
    }

    public Trace[] newArray(int n10) {
        return new Trace[n10];
    }
}

