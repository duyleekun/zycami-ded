/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.internal.zzas;

public final class zzat
implements Parcelable.Creator {
    public static void zza(zzas zzas2, Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = zzas2.zza;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = zzas2.zzb;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)object, n10, false);
        String string2 = zzas2.zzc;
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        long l10 = zzas2.zzd;
        SafeParcelWriter.writeLong(parcel, 5, l10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

