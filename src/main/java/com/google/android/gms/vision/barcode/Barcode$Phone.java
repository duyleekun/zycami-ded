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
import com.google.android.gms.vision.barcode.zzl;

public class Barcode$Phone
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int FAX = 3;
    public static final int HOME = 2;
    public static final int MOBILE = 4;
    public static final int UNKNOWN = 0;
    public static final int WORK = 1;
    public String number;
    public int type;

    static {
        zzl zzl2 = new zzl();
        CREATOR = zzl2;
    }

    public Barcode$Phone() {
    }

    public Barcode$Phone(int n10, String string2) {
        this.type = n10;
        this.number = string2;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.type;
        SafeParcelWriter.writeInt(parcel, 2, n11);
        String string2 = this.number;
        SafeParcelWriter.writeString(parcel, 3, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

