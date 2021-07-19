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
import com.google.android.gms.vision.barcode.zzg;

public class Barcode$Email
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String address;
    public String body;
    public String subject;
    public int type;

    static {
        zzg zzg2 = new zzg();
        CREATOR = zzg2;
    }

    public Barcode$Email() {
    }

    public Barcode$Email(int n10, String string2, String string3, String string4) {
        this.type = n10;
        this.address = string2;
        this.subject = string3;
        this.body = string4;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.type;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        String string2 = this.address;
        SafeParcelWriter.writeString(parcel, 3, string2, false);
        string2 = this.subject;
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        string2 = this.body;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

