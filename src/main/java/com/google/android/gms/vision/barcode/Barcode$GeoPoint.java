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
import com.google.android.gms.vision.barcode.zzj;

public class Barcode$GeoPoint
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public double lat;
    public double lng;

    static {
        zzj zzj2 = new zzj();
        CREATOR = zzj2;
    }

    public Barcode$GeoPoint() {
    }

    public Barcode$GeoPoint(double d10, double d11) {
        this.lat = d10;
        this.lng = d11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        double d10 = this.lat;
        SafeParcelWriter.writeDouble(parcel, 2, d10);
        d10 = this.lng;
        SafeParcelWriter.writeDouble(parcel, 3, d10);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

