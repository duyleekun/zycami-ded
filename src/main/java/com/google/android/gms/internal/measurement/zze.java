/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzf;

public abstract class zze
extends zzb
implements zzf {
    public static zzf zzb(IBinder iBinder) {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        boolean bl2 = iInterface instanceof zzf;
        if (bl2) {
            return (zzf)iInterface;
        }
        iInterface = new zzd(iBinder);
        return iInterface;
    }
}

