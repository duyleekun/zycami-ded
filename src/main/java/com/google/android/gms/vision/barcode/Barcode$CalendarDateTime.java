/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.barcode.zzd;

public class Barcode$CalendarDateTime
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public int day;
    public int hours;
    public boolean isUtc;
    public int minutes;
    public int month;
    public String rawValue;
    public int seconds;
    public int year;

    static {
        zzd zzd2 = new zzd();
        CREATOR = zzd2;
    }

    public Barcode$CalendarDateTime() {
    }

    public Barcode$CalendarDateTime(int n10, int n11, int n12, int n13, int n14, int n15, boolean bl2, String string2) {
        this.year = n10;
        this.month = n11;
        this.day = n12;
        this.hours = n13;
        this.minutes = n14;
        this.seconds = n15;
        this.isUtc = bl2;
        this.rawValue = string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int bl2 = this.year;
        SafeParcelWriter.writeInt(parcel, 2, bl2);
        int n11 = this.month;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        int n12 = this.day;
        SafeParcelWriter.writeInt(parcel, 4, n12);
        int n13 = this.hours;
        SafeParcelWriter.writeInt(parcel, 5, n13);
        int n14 = this.minutes;
        SafeParcelWriter.writeInt(parcel, 6, n14);
        int n15 = this.seconds;
        SafeParcelWriter.writeInt(parcel, 7, n15);
        boolean bl3 = this.isUtc;
        SafeParcelWriter.writeBoolean(parcel, 8, bl3);
        String string2 = this.rawValue;
        SafeParcelWriter.writeString(parcel, 9, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

