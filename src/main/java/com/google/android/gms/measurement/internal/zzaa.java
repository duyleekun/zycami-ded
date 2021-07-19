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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.internal.zzab;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzkg;

public final class zzaa
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public String zza;
    public String zzb;
    public zzkg zzc;
    public long zzd;
    public boolean zze;
    public String zzf;
    public final zzas zzg;
    public long zzh;
    public zzas zzi;
    public final long zzj;
    public final zzas zzk;

    static {
        zzab zzab2 = new zzab();
        CREATOR = zzab2;
    }

    public zzaa(zzaa abstractSafeParcelable) {
        boolean bl2;
        long l10;
        Preconditions.checkNotNull(abstractSafeParcelable);
        Object object = abstractSafeParcelable.zza;
        this.zza = object;
        object = abstractSafeParcelable.zzb;
        this.zzb = object;
        this.zzc = object = abstractSafeParcelable.zzc;
        this.zzd = l10 = abstractSafeParcelable.zzd;
        this.zze = bl2 = abstractSafeParcelable.zze;
        this.zzf = object = abstractSafeParcelable.zzf;
        this.zzg = object = abstractSafeParcelable.zzg;
        this.zzh = l10 = abstractSafeParcelable.zzh;
        this.zzi = object = abstractSafeParcelable.zzi;
        this.zzj = l10 = abstractSafeParcelable.zzj;
        abstractSafeParcelable = abstractSafeParcelable.zzk;
        this.zzk = abstractSafeParcelable;
    }

    public zzaa(String string2, String string3, zzkg zzkg2, long l10, boolean bl2, String string4, zzas zzas2, long l11, zzas zzas3, long l12, zzas zzas4) {
        this.zza = string2;
        this.zzb = string3;
        this.zzc = zzkg2;
        this.zzd = l10;
        this.zze = bl2;
        this.zzf = string4;
        this.zzg = zzas2;
        this.zzh = l11;
        this.zzi = zzas3;
        this.zzj = l12;
        this.zzk = zzas4;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zza;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.zzb;
        SafeParcelWriter.writeString(parcel, 3, (String)object, false);
        object = this.zzc;
        SafeParcelWriter.writeParcelable(parcel, 4, (Parcelable)object, n10, false);
        long l10 = this.zzd;
        SafeParcelWriter.writeLong(parcel, 5, l10);
        boolean bl2 = this.zze;
        SafeParcelWriter.writeBoolean(parcel, 6, bl2);
        object = this.zzf;
        SafeParcelWriter.writeString(parcel, 7, (String)object, false);
        object = this.zzg;
        SafeParcelWriter.writeParcelable(parcel, 8, (Parcelable)object, n10, false);
        l10 = this.zzh;
        SafeParcelWriter.writeLong(parcel, 9, l10);
        object = this.zzi;
        SafeParcelWriter.writeParcelable(parcel, 10, (Parcelable)object, n10, false);
        l10 = this.zzj;
        SafeParcelWriter.writeLong(parcel, 11, l10);
        object = this.zzk;
        SafeParcelWriter.writeParcelable(parcel, 12, (Parcelable)object, n10, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

