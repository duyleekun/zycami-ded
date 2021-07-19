/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.measurement.zzei;
import com.google.android.gms.internal.measurement.zzep;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzes;
import com.google.android.gms.internal.measurement.zzet;

public final class zzeu
implements zzer {
    private static zzeu zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzeu() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzeu(Context context) {
        this.zzb = context;
        zzet zzet2 = new zzet(this, null);
        this.zzc = zzet2;
        context = context.getContentResolver();
        Uri uri = zzei.zza;
        context.registerContentObserver(uri, true, (ContentObserver)zzet2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzeu zza(Context object) {
        Class<zzeu> clazz = zzeu.class;
        synchronized (clazz) {
            Object object2 = zza;
            if (object2 != null) return zza;
            object2 = "com.google.android.providers.gsf.permission.READ_GSERVICES";
            int n10 = PermissionChecker.checkSelfPermission(object, (String)object2);
            object2 = n10 == 0 ? new zzeu((Context)object) : new zzeu();
            zza = object2;
            return zza;
        }
    }

    public static void zzc() {
        Class<zzeu> clazz = zzeu.class;
        synchronized (clazz) {
            zzeu zzeu2;
            block10: {
                zzeu2 = zza;
                if (zzeu2 == null) break block10;
                Object object = zzeu2.zzb;
                if (object == null) break block10;
                zzeu2 = zzeu2.zzc;
                if (zzeu2 == null) break block10;
                zzeu2 = object.getContentResolver();
                object = zza;
                object = object.zzc;
                zzeu2.unregisterContentObserver((ContentObserver)object);
            }
            zzeu2 = null;
            zza = null;
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    public final String zzb(String string2) {
        void var2_5;
        Object object = this.zzb;
        if (object == null) {
            return null;
        }
        object = new zzes(this, string2);
        object = zzep.zza((zzeq)object);
        try {
            return (String)object;
        }
        catch (SecurityException securityException) {
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        string2 = String.valueOf(string2);
        String string3 = "Unable to read GServices for: ";
        int n10 = string2.length();
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        Log.e((String)"GservicesLoader", (String)string2, (Throwable)var2_5);
        return null;
    }

    public final /* synthetic */ String zzd(String string2) {
        return zzei.zza(this.zzb.getContentResolver(), string2, null);
    }
}

