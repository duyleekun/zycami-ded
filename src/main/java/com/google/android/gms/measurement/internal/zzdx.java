/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzp;
import java.util.List;

public final class zzdx
extends zza
implements zzdz {
    public zzdx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zzd(zzas zzas2, zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzas2);
        zzc.zzd(parcel, zzp2);
        this.zzc(1, parcel);
    }

    public final void zze(zzkg zzkg2, zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzkg2);
        zzc.zzd(parcel, zzp2);
        this.zzc(2, parcel);
    }

    public final void zzf(zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzp2);
        this.zzc(4, parcel);
    }

    public final void zzg(zzas zzas2, String string2, String string3) {
        throw null;
    }

    public final void zzh(zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzp2);
        this.zzc(6, parcel);
    }

    public final List zzi(zzp zzp2, boolean bl2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzp2);
        zzc.zzb(parcel, bl2);
        zzp2 = this.zzz(7, parcel);
        Object object = zzkg.CREATOR;
        object = zzp2.createTypedArrayList((Parcelable.Creator)object);
        zzp2.recycle();
        return object;
    }

    public final byte[] zzj(zzas zzas2, String object) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzas2);
        parcel.writeString((String)object);
        zzas2 = this.zzz(9, parcel);
        object = zzas2.createByteArray();
        zzas2.recycle();
        return object;
    }

    public final void zzk(long l10, String string2, String string3, String string4) {
        Parcel parcel = this.zza();
        parcel.writeLong(l10);
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeString(string4);
        this.zzc(10, parcel);
    }

    public final String zzl(zzp zzp2) {
        Object object = this.zza();
        zzc.zzd(object, zzp2);
        zzp2 = this.zzz(11, (Parcel)object);
        object = zzp2.readString();
        zzp2.recycle();
        return object;
    }

    public final void zzm(zzaa zzaa2, zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzaa2);
        zzc.zzd(parcel, zzp2);
        this.zzc(12, parcel);
    }

    public final void zzn(zzaa zzaa2) {
        throw null;
    }

    public final List zzo(String string2, String object, boolean bl2, zzp zzp2) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString((String)object);
        zzc.zzb(parcel, bl2);
        zzc.zzd(parcel, zzp2);
        string2 = this.zzz(14, parcel);
        object = zzkg.CREATOR;
        object = string2.createTypedArrayList((Parcelable.Creator)object);
        string2.recycle();
        return object;
    }

    public final List zzp(String string2, String object, String string3, boolean bl2) {
        string2 = this.zza();
        string2.writeString(null);
        string2.writeString((String)object);
        string2.writeString(string3);
        zzc.zzb((Parcel)string2, bl2);
        string2 = this.zzz(15, (Parcel)string2);
        object = zzkg.CREATOR;
        object = string2.createTypedArrayList((Parcelable.Creator)object);
        string2.recycle();
        return object;
    }

    public final List zzq(String string2, String object, zzp zzp2) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString((String)object);
        zzc.zzd(parcel, zzp2);
        string2 = this.zzz(16, parcel);
        object = zzaa.CREATOR;
        object = string2.createTypedArrayList((Parcelable.Creator)object);
        string2.recycle();
        return object;
    }

    public final List zzr(String string2, String object, String string3) {
        string2 = this.zza();
        string2.writeString(null);
        string2.writeString((String)object);
        string2.writeString(string3);
        string2 = this.zzz(17, (Parcel)string2);
        object = zzaa.CREATOR;
        object = string2.createTypedArrayList((Parcelable.Creator)object);
        string2.recycle();
        return object;
    }

    public final void zzs(zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzp2);
        this.zzc(18, parcel);
    }

    public final void zzt(Bundle bundle, zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        zzc.zzd(parcel, zzp2);
        this.zzc(19, parcel);
    }

    public final void zzu(zzp zzp2) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, zzp2);
        this.zzc(20, parcel);
    }
}

