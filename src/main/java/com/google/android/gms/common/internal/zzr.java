/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzr
extends zzb
implements zzq {
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean zza(zzj zzj2, IObjectWrapper iObjectWrapper) {
        Parcel parcel = this.a_();
        zzd.zza(parcel, zzj2);
        zzd.zza(parcel, iObjectWrapper);
        zzj2 = this.zza(5, parcel);
        boolean bl2 = zzd.zza((Parcel)zzj2);
        zzj2.recycle();
        return bl2;
    }
}

