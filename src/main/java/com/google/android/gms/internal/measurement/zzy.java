/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.measurement.zzz;

public final class zzy
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Bundle zzg;
    public final String zzh;

    static {
        zzz zzz2 = new zzz();
        CREATOR = zzz2;
    }

    public zzy(long l10, long l11, boolean bl2, String string2, String string3, String string4, Bundle bundle, String string5) {
        this.zza = l10;
        this.zzb = l11;
        this.zzc = bl2;
        this.zzd = string2;
        this.zze = string3;
        this.zzf = string4;
        this.zzg = bundle;
        this.zzh = string5;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        long l10 = this.zza;
        SafeParcelWriter.writeLong(parcel, 1, l10);
        l10 = this.zzb;
        SafeParcelWriter.writeLong(parcel, 2, l10);
        boolean bl2 = this.zzc;
        SafeParcelWriter.writeBoolean(parcel, 3, bl2);
        String string2 = this.zzd;
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        string2 = this.zze;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        string2 = this.zzf;
        SafeParcelWriter.writeString(parcel, 6, string2, false);
        string2 = this.zzg;
        SafeParcelWriter.writeBundle(parcel, 7, (Bundle)string2, false);
        string2 = this.zzh;
        SafeParcelWriter.writeString(parcel, 8, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

