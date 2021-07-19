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
import com.google.android.gms.vision.barcode.Barcode$Address;
import com.google.android.gms.vision.barcode.Barcode$Email;
import com.google.android.gms.vision.barcode.Barcode$PersonName;
import com.google.android.gms.vision.barcode.Barcode$Phone;
import com.google.android.gms.vision.barcode.zze;

public class Barcode$ContactInfo
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public Barcode$Address[] addresses;
    public Barcode$Email[] emails;
    public Barcode$PersonName name;
    public String organization;
    public Barcode$Phone[] phones;
    public String title;
    public String[] urls;

    static {
        zze zze2 = new zze();
        CREATOR = zze2;
    }

    public Barcode$ContactInfo() {
    }

    public Barcode$ContactInfo(Barcode$PersonName barcode$PersonName, String string2, String string3, Barcode$Phone[] barcode$PhoneArray, Barcode$Email[] barcode$EmailArray, String[] stringArray, Barcode$Address[] barcode$AddressArray) {
        this.name = barcode$PersonName;
        this.organization = string2;
        this.title = string3;
        this.phones = barcode$PhoneArray;
        this.emails = barcode$EmailArray;
        this.urls = stringArray;
        this.addresses = barcode$AddressArray;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object[] objectArray = this.name;
        SafeParcelWriter.writeParcelable(parcel, 2, (Parcelable)objectArray, n10, false);
        objectArray = this.organization;
        SafeParcelWriter.writeString(parcel, 3, (String)objectArray, false);
        objectArray = this.title;
        SafeParcelWriter.writeString(parcel, 4, (String)objectArray, false);
        objectArray = this.phones;
        SafeParcelWriter.writeTypedArray(parcel, 5, objectArray, n10, false);
        objectArray = this.emails;
        SafeParcelWriter.writeTypedArray(parcel, 6, objectArray, n10, false);
        objectArray = this.urls;
        SafeParcelWriter.writeStringArray(parcel, 7, (String[])objectArray, false);
        objectArray = this.addresses;
        SafeParcelWriter.writeTypedArray(parcel, 8, objectArray, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

