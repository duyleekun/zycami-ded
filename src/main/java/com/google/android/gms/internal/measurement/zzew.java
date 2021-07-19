/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.measurement.zzfm;

public final class zzew {
    public static volatile zzfm zza;
    private static final Object zzb;

    static {
        Object object;
        zza = zzfm.zzc();
        zzb = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean zza(Context object, Uri object2) {
        object2 = object2.getAuthority();
        Object object3 = "com.google.android.gms.phenotype";
        boolean bl2 = ((String)object3).equals(object2);
        boolean bl3 = false;
        if (!bl2) {
            int n10 = String.valueOf(object2).length();
            object3 = new StringBuilder(n10 += 91);
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            object2 = ((StringBuilder)object3).toString();
            Log.e((String)"PhenotypeClientHelper", (String)object2);
            return false;
        }
        object2 = zza;
        boolean bl4 = ((zzfm)object2).zza();
        if (bl4) {
            return (Boolean)zza.zzb();
        }
        object2 = zzb;
        synchronized (object2) {
            block10: {
                block11: {
                    object3 = zza;
                    bl2 = ((zzfm)object3).zza();
                    if (bl2) {
                        object = zza;
                        object = ((zzfm)object).zzb();
                        object = (Boolean)object;
                        return (Boolean)object;
                    }
                    object3 = "com.google.android.gms";
                    String string2 = object.getPackageName();
                    bl2 = ((String)object3).equals(string2);
                    if (bl2) break block11;
                    object3 = object.getPackageManager();
                    string2 = "com.google.android.gms.phenotype";
                    if ((object3 = object3.resolveContentProvider(string2, 0)) == null || !(bl2 = (string2 = "com.google.android.gms").equals(object3 = ((ProviderInfo)object3).packageName))) break block10;
                }
                object = object.getPackageManager();
                object3 = "com.google.android.gms";
                try {
                    object = object.getApplicationInfo((String)object3, 0);
                    int n11 = ((ApplicationInfo)object).flags & 0x81;
                    if (n11 != 0) {
                        bl3 = true;
                    }
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {}
            }
            object = bl3;
            zza = object = zzfm.zzd(object);
            return (Boolean)zza.zzb();
        }
    }
}

