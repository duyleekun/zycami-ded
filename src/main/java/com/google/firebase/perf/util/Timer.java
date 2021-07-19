/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.firebase.perf.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.perf.util.Timer$1;
import java.util.concurrent.TimeUnit;

public class Timer
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private long mHighResTime;
    private long mTime;

    static {
        Timer$1 timer$1 = new Timer$1();
        CREATOR = timer$1;
    }

    public Timer() {
        long l10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l11 = System.currentTimeMillis();
        this.mTime = l10 = timeUnit.toMicros(l11);
        this.mHighResTime = l10 = System.nanoTime();
    }

    public Timer(long l10) {
        this.mTime = l10;
        this.mHighResTime = l10 = TimeUnit.MICROSECONDS.toNanos(l10);
    }

    public Timer(long l10, long l11) {
        this.mTime = l10;
        this.mHighResTime = l11;
    }

    private Timer(Parcel parcel) {
        long l10;
        this.mTime = l10 = parcel.readLong();
        this.mHighResTime = l10 = parcel.readLong();
    }

    public /* synthetic */ Timer(Parcel parcel, Timer$1 timer$1) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public long getCurrentTimestampMicros() {
        long l10 = this.mTime;
        long l11 = this.getDurationMicros();
        return l10 + l11;
    }

    public long getDurationMicros() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long l10 = System.nanoTime();
        long l11 = this.mHighResTime;
        return timeUnit.toMicros(l10 -= l11);
    }

    public long getDurationMicros(Timer timer) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long l10 = timer.mHighResTime;
        long l11 = this.mHighResTime;
        return timeUnit.toMicros(l10 -= l11);
    }

    public long getHighResTime() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long l10 = this.mHighResTime;
        return timeUnit.toMicros(l10);
    }

    public long getMicros() {
        return this.mTime;
    }

    public void reset() {
        long l10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long l11 = System.currentTimeMillis();
        this.mTime = l10 = timeUnit.toMicros(l11);
        this.mHighResTime = l10 = System.nanoTime();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        long l10 = this.mTime;
        parcel.writeLong(l10);
        l10 = this.mHighResTime;
        parcel.writeLong(l10);
    }
}

