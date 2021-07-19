/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 */
package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.impl.zzb;
import com.google.android.gms.flags.impl.zzd;
import com.google.android.gms.flags.impl.zzf;
import com.google.android.gms.flags.impl.zzh;
import com.google.android.gms.flags.impl.zzj;

public class FlagProviderImpl
extends com.google.android.gms.flags.zzd {
    private boolean zzu = false;
    private SharedPreferences zzv;

    public boolean getBooleanFlagValue(String string2, boolean bl2, int n10) {
        n10 = (int)(this.zzu ? 1 : 0);
        if (n10 == 0) {
            return bl2;
        }
        SharedPreferences sharedPreferences = this.zzv;
        Boolean bl3 = bl2;
        return zzb.zza(sharedPreferences, string2, bl3);
    }

    public int getIntFlagValue(String string2, int n10, int n11) {
        n11 = (int)(this.zzu ? 1 : 0);
        if (n11 == 0) {
            return n10;
        }
        SharedPreferences sharedPreferences = this.zzv;
        Integer n12 = n10;
        return zzd.zza(sharedPreferences, string2, n12);
    }

    public long getLongFlagValue(String string2, long l10, int n10) {
        n10 = (int)(this.zzu ? 1 : 0);
        if (n10 == 0) {
            return l10;
        }
        SharedPreferences sharedPreferences = this.zzv;
        Long l11 = l10;
        return zzf.zza(sharedPreferences, string2, l11);
    }

    public String getStringFlagValue(String string2, String string3, int n10) {
        n10 = (int)(this.zzu ? 1 : 0);
        if (n10 == 0) {
            return string3;
        }
        return zzh.zza(this.zzv, string2, string3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void init(IObjectWrapper iObjectWrapper) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap(iObjectWrapper);
        boolean bl2 = this.zzu;
        if (bl2) {
            return;
        }
        String string2 = "com.google.android.gms";
        int n10 = 0;
        iObjectWrapper = iObjectWrapper.createPackageContext(string2, 0);
        iObjectWrapper = zzj.zza((Context)iObjectWrapper);
        this.zzv = iObjectWrapper;
        boolean bl3 = true;
        try {
            this.zzu = bl3;
            return;
        }
        catch (Exception exception) {
            string2 = "Could not retrieve sdk flags, continuing with defaults: ";
            String string3 = String.valueOf(exception.getMessage());
            n10 = string3.length();
            string3 = n10 != 0 ? string2.concat(string3) : new String(string2);
            string2 = "FlagProviderImpl";
            Log.w((String)string2, (String)string3);
            return;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return;
        }
    }
}

