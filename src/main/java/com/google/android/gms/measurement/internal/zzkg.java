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
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.measurement.internal.zzkh;
import com.google.android.gms.measurement.internal.zzki;

public final class zzkg
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final int zza;
    public final String zzb;
    public final long zzc;
    public final Long zzd;
    public final String zze;
    public final String zzf;
    public final Double zzg;

    static {
        zzkh zzkh2 = new zzkh();
        CREATOR = zzkh2;
    }

    public zzkg(int n10, String string2, long l10, Long l11, Float f10, String string3, String string4, Double d10) {
        this.zza = n10;
        this.zzb = string2;
        this.zzc = l10;
        this.zzd = l11;
        int n11 = 1;
        if (n10 == n11) {
            Double d11;
            if (f10 != null) {
                double d12 = f10.doubleValue();
                d11 = d12;
            } else {
                n10 = 0;
                d11 = null;
            }
            this.zzg = d11;
        } else {
            this.zzg = d10;
        }
        this.zze = string3;
        this.zzf = string4;
    }

    public zzkg(zzki zzki2) {
        String string2 = zzki2.zzc;
        long l10 = zzki2.zzd;
        Object object = zzki2.zze;
        String string3 = zzki2.zzb;
        this(string2, l10, object, string3);
    }

    public zzkg(String object, long l10, Object object2, String string2) {
        int n10;
        Preconditions.checkNotEmpty((String)object);
        this.zza = n10 = 2;
        this.zzb = object;
        this.zzc = l10;
        this.zzf = string2;
        object = null;
        if (object2 == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
            return;
        }
        boolean bl2 = object2 instanceof Long;
        if (bl2) {
            this.zzd = object2 = (Long)object2;
            this.zzg = null;
            this.zze = null;
            return;
        }
        bl2 = object2 instanceof String;
        if (bl2) {
            this.zzd = null;
            this.zzg = null;
            this.zze = object2 = (String)object2;
            return;
        }
        bl2 = object2 instanceof Double;
        if (bl2) {
            this.zzd = null;
            this.zzg = object2 = (Double)object2;
            this.zze = null;
            return;
        }
        object = new IllegalArgumentException("User attribute given of un-supported type");
        throw object;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        zzkh.zza(this, parcel, n10);
    }

    public final Object zza() {
        Object object = this.zzd;
        if (object != null) {
            return object;
        }
        object = this.zzg;
        if (object != null) {
            return object;
        }
        object = this.zze;
        if (object != null) {
            return object;
        }
        return null;
    }
}

