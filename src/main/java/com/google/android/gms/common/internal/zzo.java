/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzo
extends zzb
implements IGmsCallbacks {
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void onPostInitComplete(int n10, IBinder iBinder, Bundle bundle) {
        Parcel parcel = this.a_();
        parcel.writeInt(n10);
        parcel.writeStrongBinder(iBinder);
        zzd.zza(parcel, (Parcelable)bundle);
        this.zzb(1, parcel);
    }

    public final void zza(int n10, Bundle bundle) {
        Parcel parcel = this.a_();
        parcel.writeInt(n10);
        zzd.zza(parcel, (Parcelable)bundle);
        this.zzb(2, parcel);
    }

    public final void zza(int n10, IBinder iBinder, zzc zzc2) {
        Parcel parcel = this.a_();
        parcel.writeInt(n10);
        parcel.writeStrongBinder(iBinder);
        zzd.zza(parcel, zzc2);
        this.zzb(3, parcel);
    }
}

