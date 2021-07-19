/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$1;

public final class SpliceScheduleCommand$ComponentSplice {
    public final int componentTag;
    public final long utcSpliceTime;

    private SpliceScheduleCommand$ComponentSplice(int n10, long l10) {
        this.componentTag = n10;
        this.utcSpliceTime = l10;
    }

    public /* synthetic */ SpliceScheduleCommand$ComponentSplice(int n10, long l10, SpliceScheduleCommand$1 spliceScheduleCommand$1) {
        this(n10, l10);
    }

    public static /* synthetic */ SpliceScheduleCommand$ComponentSplice access$000(Parcel parcel) {
        return SpliceScheduleCommand$ComponentSplice.createFromParcel(parcel);
    }

    public static /* synthetic */ void access$200(SpliceScheduleCommand$ComponentSplice spliceScheduleCommand$ComponentSplice, Parcel parcel) {
        spliceScheduleCommand$ComponentSplice.writeToParcel(parcel);
    }

    private static SpliceScheduleCommand$ComponentSplice createFromParcel(Parcel parcel) {
        int n10 = parcel.readInt();
        long l10 = parcel.readLong();
        SpliceScheduleCommand$ComponentSplice spliceScheduleCommand$ComponentSplice = new SpliceScheduleCommand$ComponentSplice(n10, l10);
        return spliceScheduleCommand$ComponentSplice;
    }

    private void writeToParcel(Parcel parcel) {
        int n10 = this.componentTag;
        parcel.writeInt(n10);
        long l10 = this.utcSpliceTime;
        parcel.writeLong(l10);
    }
}

