/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$OnSharedPreferenceChangeListener
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 */
package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzej;
import com.google.android.gms.internal.measurement.zzer;
import java.util.Map;

public final class zzfh
implements zzer {
    private static final Map zza;
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zza = arrayMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzfh zza(Context object, String string2) {
        boolean bl2 = zzej.zza();
        string2 = null;
        if (bl2) {
            throw null;
        }
        object = zzfh.class;
        synchronized (object) {
            Object object2 = zza;
            object2 = object2.get(null);
            object2 = (zzfh)object2;
            if (object2 != null) {
                return object2;
            }
            object2 = StrictMode.allowThreadDiskReads();
            try {
                throw null;
            }
            catch (Throwable throwable) {
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)object2);
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzb() {
        Class<zzfh> clazz = zzfh.class;
        synchronized (clazz) {
            Object object = zza;
            Object object2 = object.values();
            object2 = object2.iterator();
            boolean bl2 = object2.hasNext();
            if (!bl2) {
                object.clear();
                return;
            }
            object = object2.next();
            object = (zzfh)object;
            object2 = ((zzfh)object).zzb;
            object = ((zzfh)object).zzc;
            object = null;
            throw null;
        }
    }

    public final Object zze(String string2) {
        throw null;
    }
}

