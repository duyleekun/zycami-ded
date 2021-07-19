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
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.vision.zzas;
import com.google.android.gms.internal.vision.zzay;
import com.google.android.gms.internal.vision.zzaz;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzbt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzbq
implements zzay {
    private static final Map zzhc;
    private final Object zzfs;
    private volatile Map zzft;
    private final List zzfu;
    private final SharedPreferences zzhd;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzhe;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzhc = arrayMap;
    }

    private zzbq(SharedPreferences sharedPreferences) {
        zzbt zzbt2 = new zzbt(this);
        this.zzhe = zzbt2;
        ArrayList arrayList = new ArrayList();
        this.zzfs = arrayList;
        this.zzfu = arrayList = new ArrayList();
        this.zzhd = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener)zzbt2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzbq zzb(Context context, String string2) {
        Object object;
        boolean bl2 = zzas.zzu();
        bl2 = bl2 && !(bl2 = string2.startsWith((String)(object = "direct_boot:"))) ? zzas.isUserUnlocked(context) : true;
        if (!bl2) {
            return null;
        }
        object = zzbq.class;
        synchronized (object) {
            Map map = zzhc;
            Object object2 = map.get(string2);
            object2 = (zzbq)object2;
            if (object2 == null) {
                context = zzbq.zzc(context, string2);
                object2 = new Object((SharedPreferences)context);
                map.put(string2, object2);
            }
            return object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SharedPreferences zzc(Context context, String string2) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        String string3 = "direct_boot:";
        try {
            int n10 = string2.startsWith(string3);
            if (n10 != 0) {
                n10 = zzas.zzu();
                if (n10 != 0) {
                    context = context.createDeviceProtectedStorageContext();
                }
                n10 = 12;
                string2 = string2.substring(n10);
                context = context.getSharedPreferences(string2, 0);
                return context;
            }
            context = context.getSharedPreferences(string2, 0);
            return context;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzy() {
        Class<zzbq> clazz = zzbq.class;
        synchronized (clazz) {
            Object object = zzhc;
            object = object.values();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = zzhc;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (zzbq)object2;
                SharedPreferences sharedPreferences = ((zzbq)object2).zzhd;
                object2 = ((zzbq)object2).zzhe;
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final /* synthetic */ void zza(SharedPreferences object, String object2) {
        boolean bl2;
        object = this.zzfs;
        synchronized (object) {
            bl2 = false;
            object2 = null;
            this.zzft = null;
            zzbi.zzaf();
        }
        synchronized (this) {
            object = this.zzfu;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = object.next();
                object2 = (zzaz)object2;
                object2.zzad();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzb(String string2) {
        Map map = this.zzft;
        if (map == null) {
            Object object = this.zzfs;
            synchronized (object) {
                map = this.zzft;
                if (map == null) {
                    map = StrictMode.allowThreadDiskReads();
                    try {
                        Object object2 = this.zzhd;
                        object2 = object2.getAll();
                        this.zzft = object2;
                        map = object2;
                    }
                    finally {
                        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)map);
                    }
                }
            }
        }
        if (map != null) {
            return map.get(string2);
        }
        return null;
    }
}

