/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zad;

public final class StringToIntConverter$zaa
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int versionCode;
    public final String zapp;
    public final int zapq;

    static {
        zad zad2 = new zad();
        CREATOR = zad2;
    }

    public StringToIntConverter$zaa(int n10, String string2, int n11) {
        this.versionCode = n10;
        this.zapp = string2;
        this.zapq = n11;
    }

    public StringToIntConverter$zaa(String string2, int n10) {
        this.versionCode = 1;
        this.zapp = string2;
        this.zapq = n10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        String string2 = this.zapp;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        n11 = this.zapq;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

