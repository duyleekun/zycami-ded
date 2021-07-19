/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zzn;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

public class zzl {
    private static final zzl zzb;
    public final boolean zza;
    private final String zzc;
    private final Throwable zzd;

    static {
        zzl zzl2;
        zzb = zzl2 = new zzl(true, null, null);
    }

    public zzl(boolean bl2, String string2, Throwable throwable) {
        this.zza = bl2;
        this.zzc = string2;
        this.zzd = throwable;
    }

    public static zzl zza() {
        return zzb;
    }

    public static zzl zza(String string2) {
        zzl zzl2 = new zzl(false, string2, null);
        return zzl2;
    }

    public static zzl zza(String string2, Throwable throwable) {
        zzl zzl2 = new zzl(false, string2, throwable);
        return zzl2;
    }

    public static zzl zza(Callable callable) {
        zzn zzn2 = new zzn(callable, null);
        return zzn2;
    }

    public static String zza(String string2, zzd object, boolean bl2, boolean bl3) {
        Object object2 = bl3 ? "debug cert rejected" : "not whitelisted";
        Object[] objectArray = new Object[5];
        objectArray[0] = object2;
        objectArray[1] = string2;
        object2 = AndroidUtilsLight.zza("SHA-1");
        object = ((zzd)object).zza();
        objectArray[2] = object = Hex.bytesToStringLowercase(((MessageDigest)object2).digest((byte[])object));
        objectArray[3] = object = Boolean.valueOf(bl2);
        objectArray[4] = "12451009.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objectArray);
    }

    public String zzb() {
        return this.zzc;
    }

    public final void zzc() {
        String string2;
        boolean bl2 = this.zza;
        if (!bl2 && (bl2 = Log.isLoggable((String)(string2 = "GoogleCertificatesRslt"), (int)3))) {
            Object object = this.zzd;
            if (object != null) {
                object = this.zzb();
                Throwable throwable = this.zzd;
                Log.d((String)string2, (String)object, (Throwable)throwable);
                return;
            }
            object = this.zzb();
            Log.d((String)string2, (String)object);
        }
    }
}

