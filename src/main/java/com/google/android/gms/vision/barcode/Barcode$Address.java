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
import com.google.android.gms.vision.barcode.zza;

public class Barcode$Address
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int HOME = 2;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String[] addressLines;
    public int type;

    static {
        zza zza2 = new zza();
        CREATOR = zza2;
    }

    public Barcode$Address() {
    }

    public Barcode$Address(int n10, String[] stringArray) {
        this.type = n10;
        this.addressLines = stringArray;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.type;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        String[] stringArray = this.addressLines;
        SafeParcelWriter.writeStringArray(parcel, 3, stringArray, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

