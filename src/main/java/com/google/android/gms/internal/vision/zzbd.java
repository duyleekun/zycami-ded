/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.vision.zzaq;
import com.google.android.gms.internal.vision.zzay;
import com.google.android.gms.internal.vision.zzba;
import com.google.android.gms.internal.vision.zzbb;
import com.google.android.gms.internal.vision.zzbc;
import com.google.android.gms.internal.vision.zzbf;

public final class zzbd
implements zzay {
    private static zzbd zzgb;
    private final ContentObserver zzfr;
    private final Context zzg;

    private zzbd() {
        this.zzg = null;
        this.zzfr = null;
    }

    private zzbd(Context context) {
        this.zzg = context;
        zzbf zzbf2 = new zzbf(this, null);
        this.zzfr = zzbf2;
        context = context.getContentResolver();
        Uri uri = zzaq.CONTENT_URI;
        context.registerContentObserver(uri, true, (ContentObserver)zzbf2);
    }

    public static void zzae() {
        Class<zzbd> clazz = zzbd.class;
        synchronized (clazz) {
            zzbd zzbd2;
            block10: {
                zzbd2 = zzgb;
                if (zzbd2 == null) break block10;
                Object object = zzbd2.zzg;
                if (object == null) break block10;
                zzbd2 = zzbd2.zzfr;
                if (zzbd2 == null) break block10;
                zzbd2 = object.getContentResolver();
                object = zzgb;
                object = object.zzfr;
                zzbd2.unregisterContentObserver((ContentObserver)object);
            }
            zzbd2 = null;
            zzgb = null;
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    private final String zzc(String string2) {
        void var2_5;
        Object object = this.zzg;
        if (object == null) {
            return null;
        }
        object = new zzbc(this, string2);
        object = zzbb.zza((zzba)object);
        try {
            return (String)object;
        }
        catch (SecurityException securityException) {
        }
        catch (IllegalStateException illegalStateException) {
            // empty catch block
        }
        String string3 = "Unable to read GServices for: ";
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        Log.e((String)"GservicesLoader", (String)string2, (Throwable)var2_5);
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzbd zze(Context object) {
        Class<zzbd> clazz = zzbd.class;
        synchronized (clazz) {
            Object object2 = zzgb;
            if (object2 != null) return zzgb;
            object2 = "com.google.android.providers.gsf.permission.READ_GSERVICES";
            int n10 = PermissionChecker.checkSelfPermission(object, (String)object2);
            if (n10 == 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object2 = null;
            }
            object2 = n10 != 0 ? new zzbd((Context)object) : new zzbd();
            zzgb = object2;
            return zzgb;
        }
    }

    public final /* synthetic */ Object zzb(String string2) {
        return this.zzc(string2);
    }

    public final /* synthetic */ String zzd(String string2) {
        return zzaq.zza(this.zzg.getContentResolver(), string2, null);
    }
}

