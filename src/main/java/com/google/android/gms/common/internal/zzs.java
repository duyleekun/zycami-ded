/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzs {
    private static Object zza;
    private static boolean zzb;
    private static String zzc;
    private static int zzd;

    static {
        Object object;
        zza = object = new Object();
    }

    public static String zza(Context context) {
        zzs.zzc(context);
        return zzc;
    }

    public static int zzb(Context context) {
        zzs.zzc(context);
        return zzd;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zzc(Context object) {
        Object object2 = zza;
        synchronized (object2) {
            block7: {
                String string2;
                block6: {
                    boolean bl2 = zzb;
                    if (bl2) {
                        return;
                    }
                    zzb = bl2 = true;
                    string2 = object.getPackageName();
                    object = Wrappers.packageManager((Context)object);
                    int n10 = 128;
                    try {
                        object = ((PackageManagerWrapper)object).getApplicationInfo(string2, n10);
                        object = ((ApplicationInfo)object).metaData;
                        if (object != null) break block6;
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        string2 = "MetadataValueReader";
                        String string3 = "This should never happen.";
                        Log.wtf((String)string2, (String)string3, (Throwable)nameNotFoundException);
                        break block7;
                    }
                    return;
                }
                string2 = "com.google.app.id";
                {
                    int n11;
                    zzc = string2 = object.getString(string2);
                    string2 = "com.google.android.gms.version";
                    zzd = n11 = object.getInt(string2);
                }
            }
            return;
        }
    }
}

