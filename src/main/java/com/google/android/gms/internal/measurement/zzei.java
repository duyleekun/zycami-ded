/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import com.google.android.gms.internal.measurement.zzeh;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public final class zzei {
    public static final Uri zza;
    public static final Uri zzb;
    public static final Pattern zzc;
    public static final Pattern zzd;
    public static HashMap zze;
    public static final HashMap zzf;
    public static final HashMap zzg;
    public static final HashMap zzh;
    public static final HashMap zzi;
    public static final String[] zzj;
    private static final AtomicBoolean zzk;
    private static Object zzl;
    private static boolean zzm;

    static {
        Serializable serializable;
        zza = Uri.parse((String)"content://com.google.android.gsf.gservices");
        zzb = Uri.parse((String)"content://com.google.android.gsf.gservices/prefix");
        int n10 = 2;
        zzc = Pattern.compile("^(1|true|t|on|yes|y)$", n10);
        zzd = Pattern.compile("^(0|false|f|off|no|n)$", n10);
        zzk = serializable = new AtomicBoolean();
        serializable = new HashMap();
        zzf = serializable;
        serializable = new HashMap();
        zzg = serializable;
        serializable = new HashMap();
        zzh = serializable;
        serializable = new HashMap();
        zzi = serializable;
        zzj = new String[0];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String zza(ContentResolver object, String string2, String object2) {
        Object object3;
        int n10;
        Object object4;
        object2 = zzei.class;
        synchronized (object2) {
            Object object5;
            object4 = zze;
            n10 = 1;
            object3 = null;
            if (object4 == null) {
                object4 = zzk;
                ((AtomicBoolean)object4).set(false);
                object4 = new HashMap();
                zze = object4;
                zzl = object4 = new Object();
                zzm = false;
                object4 = zza;
                object5 = new zzeh(null);
                object.registerContentObserver((Uri)object4, n10 != 0, (ContentObserver)object5);
            } else {
                object4 = zzk;
                boolean bl2 = ((AtomicBoolean)object4).getAndSet(false);
                if (bl2) {
                    object4 = zze;
                    ((HashMap)object4).clear();
                    object4 = zzf;
                    ((HashMap)object4).clear();
                    object4 = zzg;
                    ((HashMap)object4).clear();
                    object4 = zzh;
                    ((HashMap)object4).clear();
                    object4 = zzi;
                    ((HashMap)object4).clear();
                    zzl = object4 = new Object();
                    zzm = false;
                }
            }
            object4 = zzl;
            object5 = zze;
            int n11 = object5.containsKey(string2);
            if (n11 != 0) {
                object = zze;
                object = object.get(string2);
                if ((object = (String)object) != null) return object;
                return object3;
            }
            object5 = zzj;
            n11 = ((String[])object5).length;
        }
        Uri uri = zza;
        String[] stringArray = new String[n10];
        stringArray[0] = string2;
        object = object.query(uri, null, null, stringArray, null);
        if (object == null) {
            return null;
        }
        try {
            boolean bl3 = object.moveToFirst();
            if (!bl3) {
                zzei.zzc(object4, string2, null);
                return null;
            }
            object2 = object.getString(n10);
            if (object2 != null && (n10 = (int)(((String)object2).equals(null) ? 1 : 0)) != 0) {
                bl3 = false;
                object2 = null;
            }
            zzei.zzc(object4, string2, (String)object2);
            if (object2 == null) {
                return object3;
            } else {
                object3 = object2;
            }
            return object3;
        }
        finally {
            object.close();
        }
    }

    public static /* synthetic */ AtomicBoolean zzb() {
        return zzk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zzc(Object object, String string2, String string3) {
        Class<zzei> clazz = zzei.class;
        synchronized (clazz) {
            Object object2 = zzl;
            if (object == object2) {
                object = zze;
                ((HashMap)object).put(string2, string3);
            }
            return;
        }
    }
}

