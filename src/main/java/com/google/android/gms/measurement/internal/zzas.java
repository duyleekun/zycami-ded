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
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzat;

public final class zzas
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final String zza;
    public final zzaq zzb;
    public final String zzc;
    public final long zzd;

    static {
        zzat zzat2 = new zzat();
        CREATOR = zzat2;
    }

    public zzas(zzas object, long l10) {
        Preconditions.checkNotNull(object);
        Object object2 = ((zzas)object).zza;
        this.zza = object2;
        this.zzb = object2 = ((zzas)object).zzb;
        this.zzc = object = ((zzas)object).zzc;
        this.zzd = l10;
    }

    public zzas(String string2, zzaq zzaq2, String string3, long l10) {
        this.zza = string2;
        this.zzb = zzaq2;
        this.zzc = string3;
        this.zzd = l10;
    }

    public final String toString() {
        String string2 = this.zzc;
        String string3 = this.zza;
        String string4 = String.valueOf(this.zzb);
        int n10 = String.valueOf(string2).length();
        int n11 = String.valueOf(string3).length();
        int n12 = String.valueOf(string4).length();
        n10 = n10 + 21 + n11 + n12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("origin=");
        stringBuilder.append(string2);
        stringBuilder.append(",name=");
        stringBuilder.append(string3);
        stringBuilder.append(",params=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        zzat.zza(this, parcel, n10);
    }
}

