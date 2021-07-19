/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.util.Timer;

public class Timer$1
implements Parcelable.Creator {
    public Timer createFromParcel(Parcel parcel) {
        Timer timer = new Timer(parcel, null);
        return timer;
    }

    public Timer[] newArray(int n10) {
        return new Timer[n10];
    }
}

