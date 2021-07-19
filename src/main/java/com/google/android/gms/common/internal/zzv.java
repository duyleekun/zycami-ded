/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzu;

public final class zzv
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zza;

    static {
        zzu zzu2 = new zzu();
        CREATOR = zzu2;
    }

    public zzv(int n10) {
        this.zza = n10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = this.zza;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

