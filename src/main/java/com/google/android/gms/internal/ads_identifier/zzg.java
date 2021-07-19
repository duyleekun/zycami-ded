/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads_identifier.zza;
import com.google.android.gms.internal.ads_identifier.zzc;
import com.google.android.gms.internal.ads_identifier.zze;

public final class zzg
extends zza
implements zze {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() {
        Parcel parcel = this.obtainAndWriteInterfaceToken();
        parcel = this.transactAndReadException(1, parcel);
        String string2 = parcel.readString();
        parcel.recycle();
        return string2;
    }

    public final boolean zzb(boolean bl2) {
        Parcel parcel = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel, true);
        parcel = this.transactAndReadException(2, parcel);
        boolean bl3 = zzc.zza(parcel);
        parcel.recycle();
        return bl3;
    }

    public final boolean zzc() {
        Parcel parcel = this.obtainAndWriteInterfaceToken();
        parcel = this.transactAndReadException(6, parcel);
        boolean bl2 = zzc.zza(parcel);
        parcel.recycle();
        return bl2;
    }
}

