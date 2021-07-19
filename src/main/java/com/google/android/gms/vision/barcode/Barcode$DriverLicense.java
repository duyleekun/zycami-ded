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
import com.google.android.gms.vision.barcode.zzh;

public class Barcode$DriverLicense
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public String addressCity;
    public String addressState;
    public String addressStreet;
    public String addressZip;
    public String birthDate;
    public String documentType;
    public String expiryDate;
    public String firstName;
    public String gender;
    public String issueDate;
    public String issuingCountry;
    public String lastName;
    public String licenseNumber;
    public String middleName;

    static {
        zzh zzh2 = new zzh();
        CREATOR = zzh2;
    }

    public Barcode$DriverLicense() {
    }

    public Barcode$DriverLicense(String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, String string14, String string15) {
        this.documentType = string2;
        this.firstName = string3;
        this.middleName = string4;
        this.lastName = string5;
        this.gender = string6;
        this.addressStreet = string7;
        this.addressCity = string8;
        this.addressState = string9;
        this.addressZip = string10;
        this.licenseNumber = string11;
        this.issueDate = string12;
        this.expiryDate = string13;
        this.birthDate = string14;
        this.issuingCountry = string15;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        String string2 = this.documentType;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        string2 = this.firstName;
        SafeParcelWriter.writeString(parcel, 3, string2, false);
        string2 = this.middleName;
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        string2 = this.lastName;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        string2 = this.gender;
        SafeParcelWriter.writeString(parcel, 6, string2, false);
        string2 = this.addressStreet;
        SafeParcelWriter.writeString(parcel, 7, string2, false);
        string2 = this.addressCity;
        SafeParcelWriter.writeString(parcel, 8, string2, false);
        string2 = this.addressState;
        SafeParcelWriter.writeString(parcel, 9, string2, false);
        string2 = this.addressZip;
        SafeParcelWriter.writeString(parcel, 10, string2, false);
        string2 = this.licenseNumber;
        SafeParcelWriter.writeString(parcel, 11, string2, false);
        string2 = this.issueDate;
        SafeParcelWriter.writeString(parcel, 12, string2, false);
        string2 = this.expiryDate;
        SafeParcelWriter.writeString(parcel, 13, string2, false);
        string2 = this.birthDate;
        SafeParcelWriter.writeString(parcel, 14, string2, false);
        string2 = this.issuingCountry;
        SafeParcelWriter.writeString(parcel, 15, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

