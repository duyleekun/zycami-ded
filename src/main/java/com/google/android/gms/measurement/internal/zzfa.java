/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzez;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;

public final class zzfa {
    public final zzfl zza;

    public zzfa(zzfl zzfl2) {
        this.zza = zzfl2;
    }

    public final void zza(String object) {
        boolean bl2;
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            boolean bl3;
            Object object2 = this.zza.zzau();
            ((zzge)object2).zzg();
            bl2 = this.zzb();
            if (!bl2) {
                this.zza.zzat().zzi().zza("Install Referrer Reporter is not available");
                return;
            }
            object2 = new zzez(this, (String)object);
            ((zzge)this.zza.zzau()).zzg();
            object = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            Object object3 = "com.android.vending";
            String string2 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
            Object object4 = new ComponentName((String)object3, string2);
            object.setComponent((ComponentName)object4);
            object4 = this.zza.zzaw().getPackageManager();
            if (object4 == null) {
                this.zza.zzat().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                return;
            }
            int n10 = 0;
            string2 = null;
            if ((object4 = object4.queryIntentServices((Intent)object, 0)) != null && !(bl3 = object4.isEmpty())) {
                object4 = ((ResolveInfo)object4.get((int)0)).serviceInfo;
                if (object4 != null) {
                    boolean bl4;
                    string2 = ((ServiceInfo)object4).packageName;
                    object4 = ((ServiceInfo)object4).name;
                    if (object4 != null && (bl4 = ((String)object3).equals(string2)) && (bl4 = this.zzb())) {
                        object4 = new Intent((Intent)object);
                        try {
                            object = ConnectionTracker.getInstance();
                        }
                        catch (Exception exception) {
                            object2 = this.zza.zzat().zzb();
                            String string3 = exception.getMessage();
                            ((zzeg)object2).zzb("Exception occurred while binding to Install Referrer Service", string3);
                            return;
                        }
                        object3 = this.zza;
                        object3 = ((zzfl)object3).zzaw();
                        n10 = 1;
                        int n11 = ((ConnectionTracker)object).bindService((Context)object3, (Intent)object4, (ServiceConnection)object2, n10);
                        object2 = this.zza;
                        object2 = ((zzfl)object2).zzat();
                        object2 = ((zzei)object2).zzk();
                        object4 = "Install Referrer Service is";
                        object = n10 != n11 ? "not available" : "available";
                        ((zzeg)object2).zzb((String)object4, object);
                        return;
                    }
                    object = this.zza.zzat().zze();
                    object2 = "Play Store version 8.3.73 or higher required for Install Referrer";
                    ((zzeg)object).zza((String)object2);
                }
                return;
            }
            this.zza.zzat().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        this.zza.zzat().zzf().zza("Install Referrer Reporter was called with invalid app package name");
    }

    public final boolean zzb() {
        Object object;
        boolean bl2;
        block11: {
            bl2 = false;
            try {
                object = this.zza;
            }
            catch (Exception exception) {
                this.zza.zzat().zzk().zzb("Failed to retrieve Play Store version for Install Referrer", exception);
                return false;
            }
            object = ((zzfl)object).zzaw();
            object = Wrappers.packageManager((Context)object);
            if (object != null) break block11;
            object = this.zza;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzk();
            String string2 = "Failed to get PackageManager for Install Referrer Play Store compatibility check";
            ((zzeg)object).zza(string2);
            return false;
        }
        String string3 = "com.android.vending";
        int n10 = 128;
        object = ((PackageManagerWrapper)object).getPackageInfo(string3, n10);
        int n11 = ((PackageInfo)object).versionCode;
        int n12 = 80837300;
        if (n11 >= n12) {
            bl2 = true;
        }
        return bl2;
    }
}

