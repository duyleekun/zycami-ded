/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfb$zza;
import com.google.android.gms.measurement.internal.zzfl;

public final class zzfb {
    private final zzfb$zza zza;

    public zzfb(zzfb$zza zzfb$zza) {
        Preconditions.checkNotNull(zzfb$zza);
        this.zza = zzfb$zza;
    }

    public static boolean zza(Context context) {
        block8: {
            String string2;
            PackageManager packageManager;
            Preconditions.checkNotNull(context);
            try {
                packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                string2 = "com.google.android.gms.measurement.AppMeasurementReceiver";
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            ComponentName componentName = new ComponentName(context, string2);
            context = packageManager.getReceiverInfo(componentName, 0);
            if (context == null) break block8;
            boolean bl2 = context.enabled;
            if (bl2) {
                return true;
            }
        }
        return false;
    }

    public final void zzb(Context object, Intent object2) {
        Object object3 = zzfl.zzC((Context)object, null, null);
        zzei zzei2 = ((zzfl)object3).zzat();
        if (object2 == null) {
            zzei2.zze().zza("Receiver called with null intent");
            return;
        }
        ((zzfl)object3).zzas();
        object2 = object2.getAction();
        object3 = zzei2.zzk();
        String string2 = "Local receiver got";
        ((zzeg)object3).zzb(string2, object2);
        object3 = "com.google.android.gms.measurement.UPLOAD";
        boolean bl2 = ((String)object3).equals(object2);
        if (bl2) {
            object2 = new Intent();
            object2 = object2.setClassName((Context)object, "com.google.android.gms.measurement.AppMeasurementService");
            object2.setAction((String)object3);
            zzei2.zzk().zza("Starting wakeful intent.");
            this.zza.doStartService((Context)object, (Intent)object2);
            return;
        }
        object = "com.android.vending.INSTALL_REFERRER";
        boolean bl3 = ((String)object).equals(object2);
        if (bl3) {
            object = zzei2.zze();
            object2 = "Install Referrer Broadcasts are deprecated";
            ((zzeg)object).zza((String)object2);
        }
    }
}

