/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.metrics.Counter$1;
import java.util.concurrent.atomic.AtomicLong;

public class Counter
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private AtomicLong mCount;
    private final String mName;

    static {
        Counter$1 counter$1 = new Counter$1();
        CREATOR = counter$1;
    }

    private Counter(Parcel parcel) {
        Object object = parcel.readString();
        this.mName = object;
        long l10 = parcel.readLong();
        this.mCount = object = new AtomicLong(l10);
    }

    public /* synthetic */ Counter(Parcel parcel, Counter$1 counter$1) {
        this(parcel);
    }

    public Counter(String object) {
        this.mName = object;
        this.mCount = object = new AtomicLong(0L);
    }

    public int describeContents() {
        return 0;
    }

    public long getCount() {
        return this.mCount.get();
    }

    public String getName() {
        return this.mName;
    }

    public void increment(long l10) {
        this.mCount.addAndGet(l10);
    }

    public void setCount(long l10) {
        this.mCount.set(l10);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mName;
        parcel.writeString(string2);
        long l10 = this.mCount.get();
        parcel.writeLong(l10);
    }
}

