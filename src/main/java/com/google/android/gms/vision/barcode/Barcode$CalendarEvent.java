/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.vision.barcode.Barcode$CalendarDateTime;
import com.google.android.gms.vision.barcode.zzf;

public class Barcode$CalendarEvent
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public String description;
    public Barcode$CalendarDateTime end;
    public String location;
    public String organizer;
    public Barcode$CalendarDateTime start;
    public String status;
    public String summary;

    static {
        zzf zzf2 = new zzf();
        CREATOR = zzf2;
    }

    public Barcode$CalendarEvent() {
    }

    public Barcode$CalendarEvent(String string2, String string3, String string4, String string5, String string6, Barcode$CalendarDateTime barcode$CalendarDateTime, Barcode$CalendarDateTime barcode$CalendarDateTime2) {
        this.summary = string2;
        this.description = string3;
        this.location = string4;
        this.organizer = string5;
        this.status = string6;
        this.start = barcode$CalendarDateTime;
        this.end = barcode$CalendarDateTime2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.summary;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.description;
        SafeParcelWriter.writeString(parcel, 3, (String)object, false);
        object = this.location;
        SafeParcelWriter.writeString(parcel, 4, (String)object, false);
        object = this.organizer;
        SafeParcelWriter.writeString(parcel, 5, (String)object, false);
        object = this.status;
        SafeParcelWriter.writeString(parcel, 6, (String)object, false);
        object = this.start;
        SafeParcelWriter.writeParcelable(parcel, 7, (Parcelable)object, n10, false);
        object = this.end;
        SafeParcelWriter.writeParcelable(parcel, 8, (Parcelable)object, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

