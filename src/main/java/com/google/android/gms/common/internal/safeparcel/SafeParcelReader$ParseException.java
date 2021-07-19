/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class SafeParcelReader$ParseException
extends RuntimeException {
    public SafeParcelReader$ParseException(String string2, Parcel parcel) {
        int n10 = parcel.dataPosition();
        int n11 = parcel.dataSize();
        int n12 = String.valueOf(string2).length() + 41;
        StringBuilder stringBuilder = new StringBuilder(n12);
        stringBuilder.append(string2);
        stringBuilder.append(" Parcel: pos=");
        stringBuilder.append(n10);
        stringBuilder.append(" size=");
        stringBuilder.append(n11);
        string2 = stringBuilder.toString();
        super(string2);
    }
}

