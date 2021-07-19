/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zze;

public abstract class zzd
extends zze
implements zza {
    public static zza zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        boolean bl2 = iInterface instanceof zza;
        if (bl2) {
            return (zza)iInterface;
        }
        iInterface = new zzc(iBinder);
        return iInterface;
    }
}

