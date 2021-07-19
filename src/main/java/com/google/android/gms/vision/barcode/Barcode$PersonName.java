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
import com.google.android.gms.vision.barcode.zzi;

public class Barcode$PersonName
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public String first;
    public String formattedName;
    public String last;
    public String middle;
    public String prefix;
    public String pronunciation;
    public String suffix;

    static {
        zzi zzi2 = new zzi();
        CREATOR = zzi2;
    }

    public Barcode$PersonName() {
    }

    public Barcode$PersonName(String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.formattedName = string2;
        this.pronunciation = string3;
        this.prefix = string4;
        this.first = string5;
        this.middle = string6;
        this.last = string7;
        this.suffix = string8;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        String string2 = this.formattedName;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        string2 = this.pronunciation;
        SafeParcelWriter.writeString(parcel, 3, string2, false);
        string2 = this.prefix;
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        string2 = this.first;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        string2 = this.middle;
        SafeParcelWriter.writeString(parcel, 6, string2, false);
        string2 = this.last;
        SafeParcelWriter.writeString(parcel, 7, string2, false);
        string2 = this.suffix;
        SafeParcelWriter.writeString(parcel, 8, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

