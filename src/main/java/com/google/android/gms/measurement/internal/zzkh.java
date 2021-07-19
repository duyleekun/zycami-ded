/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.internal.zzkg;

public final class zzkh
implements Parcelable.Creator {
    public static void zza(zzkg object, Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int n11 = ((zzkg)object).zza;
        SafeParcelWriter.writeInt(parcel, 1, n11);
        Object object2 = ((zzkg)object).zzb;
        SafeParcelWriter.writeString(parcel, 2, (String)object2, false);
        long l10 = ((zzkg)object).zzc;
        SafeParcelWriter.writeLong(parcel, 3, l10);
        object2 = ((zzkg)object).zzd;
        SafeParcelWriter.writeLongObject(parcel, 4, (Long)object2, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        object2 = ((zzkg)object).zze;
        SafeParcelWriter.writeString(parcel, 6, (String)object2, false);
        object2 = ((zzkg)object).zzf;
        SafeParcelWriter.writeString(parcel, 7, (String)object2, false);
        object = ((zzkg)object).zzg;
        SafeParcelWriter.writeDoubleObject(parcel, 8, (Double)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

