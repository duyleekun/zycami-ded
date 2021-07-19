/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.util.Log
 */
package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.flags.impl.zzi;
import com.google.android.gms.internal.flags.zze;

public final class zzh
extends zza {
    public static String zza(SharedPreferences object, String string2, String string3) {
        try {
            zzi zzi2 = new zzi((SharedPreferences)object, string2, string3);
            object = zze.zza(zzi2);
        }
        catch (Exception exception) {
            string2 = "Flag value not available, returning default: ";
            String string4 = String.valueOf(exception.getMessage());
            int n10 = string4.length();
            string4 = n10 != 0 ? string2.concat(string4) : new String(string2);
            Log.w((String)"FlagDataUtils", (String)string4);
            return string3;
        }
        return (String)object;
    }
}

