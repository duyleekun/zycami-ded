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
import com.google.android.gms.flags.impl.zze;

public final class zzd
extends zza {
    public static Integer zza(SharedPreferences object, String string2, Integer n10) {
        try {
            zze zze2 = new zze((SharedPreferences)object, string2, n10);
            object = com.google.android.gms.internal.flags.zze.zza(zze2);
        }
        catch (Exception exception) {
            string2 = "Flag value not available, returning default: ";
            String string3 = String.valueOf(exception.getMessage());
            int n11 = string3.length();
            string3 = n11 != 0 ? string2.concat(string3) : new String(string2);
            Log.w((String)"FlagDataUtils", (String)string3);
            return n10;
        }
        return (Integer)object;
    }
}

