/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.DropBoxManager
 *  android.util.Log
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class CrashUtils {
    private static final String[] zza = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzb;
    private static boolean zzc = false;
    private static int zzd = 255;
    private static int zze;
    private static int zzf;

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable throwable) {
        return CrashUtils.zza(context, throwable, 0x20000000);
    }

    private static boolean zza(Context context, Throwable throwable, int n10) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(throwable);
            return false;
        }
        catch (Exception exception) {
            Log.e((String)"CrashUtils", (String)"Error adding exception to DropBox!", (Throwable)exception);
            return false;
        }
    }
}

