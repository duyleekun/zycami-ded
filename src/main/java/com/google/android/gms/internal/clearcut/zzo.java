/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.internal.clearcut;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.internal.clearcut.zza;
import com.google.android.gms.internal.clearcut.zzc;
import com.google.android.gms.internal.clearcut.zzl;
import com.google.android.gms.internal.clearcut.zzn;

public final class zzo
extends zza
implements zzn {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    public final void zza(zzl zzl2, zze zze2) {
        Parcel parcel = this.obtainAndWriteInterfaceToken();
        zzc.zza(parcel, zzl2);
        zzc.zza(parcel, zze2);
        this.transactOneway(1, parcel);
    }
}

