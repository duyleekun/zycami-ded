/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzfl$zza;
import com.google.android.gms.internal.vision.zzfl$zza$zza;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.vision.L;

public class LogUtils {
    public static zzfl$zza zza(Context object) {
        zzfl$zza$zza zzfl$zza$zza = zzfl$zza.zzdd();
        String string2 = object.getPackageName();
        zzfl$zza$zza = zzfl$zza$zza.zzm(string2);
        if ((object = LogUtils.zzb(object)) != null) {
            zzfl$zza$zza.zzn((String)object);
        }
        return (zzfl$zza)((zzid)zzfl$zza$zza.zzgw());
    }

    private static String zzb(Context object) {
        Object[] objectArray;
        PackageManagerWrapper packageManagerWrapper;
        try {
            packageManagerWrapper = Wrappers.packageManager(object);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            objectArray = new Object[1];
            object = object.getPackageName();
            objectArray[0] = object;
            L.e(nameNotFoundException, "Unable to find calling package info for %s", objectArray);
            return null;
        }
        objectArray = object.getPackageName();
        packageManagerWrapper = packageManagerWrapper.getPackageInfo((String)objectArray, 0);
        return ((PackageInfo)packageManagerWrapper).versionName;
    }
}

