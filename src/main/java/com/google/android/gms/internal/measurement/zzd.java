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
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzf;

public final class zzd
extends zza
implements zzf {
    public zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle zzd(Bundle bundle) {
        Parcel parcel = this.zza();
        zzc.zzd(parcel, (Parcelable)bundle);
        bundle = this.zzz(1, parcel);
        parcel = Bundle.CREATOR;
        parcel = (Bundle)zzc.zzc((Parcel)bundle, (Parcelable.Creator)parcel);
        bundle.recycle();
        return parcel;
    }
}

