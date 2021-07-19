/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 */
package com.google.android.gms.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import com.google.android.gms.phenotype.PhenotypeFlag;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zza {
    private static final ConcurrentHashMap zzg;
    private static final String[] zzl;
    private final Uri uri;
    private final ContentResolver zzh;
    private final ContentObserver zzi;
    private final Object zzj;
    private volatile Map zzk;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzg = concurrentHashMap = new ConcurrentHashMap();
        zzl = new String[]{"key", "value"};
    }

    private zza(ContentResolver object, Uri uri) {
        Object object2;
        this.zzj = object2 = new Object();
        this.zzh = object;
        this.uri = uri;
        super(this, null);
        this.zzi = object;
    }

    public static zza zza(ContentResolver object, Uri uri) {
        ConcurrentHashMap concurrentHashMap = zzg;
        zza zza2 = (zza)concurrentHashMap.get(uri);
        if (zza2 == null) {
            zza2 = new zza((ContentResolver)object, uri);
            if ((object = concurrentHashMap.putIfAbsent(uri, zza2)) == null) {
                object = zza2.zzh;
                uri = zza2.uri;
                concurrentHashMap = null;
                ContentObserver contentObserver = zza2.zzi;
                object.registerContentObserver(uri, false, contentObserver);
            } else {
                zza2 = object;
            }
        }
        return zza2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Map zzc() {
        HashMap<Uri, String[]> hashMap = new HashMap<Uri, String[]>();
        ContentResolver contentResolver = this.zzh;
        Object object = this.uri;
        Object object2 = zzl;
        if ((contentResolver = contentResolver.query(object, object2, null, null, null)) == null) return hashMap;
        try {
            boolean bl2;
            while (bl2 = contentResolver.moveToNext()) {
                bl2 = false;
                object = null;
                object = contentResolver.getString(0);
                int n10 = 1;
                object2 = contentResolver.getString(n10);
                hashMap.put((Uri)object, (String[])object2);
            }
            return hashMap;
        }
        finally {
            contentResolver.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Map zza() {
        Object object = "gms:phenotype:phenotype_flag:debug_disable_caching";
        Object object2 = null;
        boolean bl2 = PhenotypeFlag.zza((String)object, false);
        object = bl2 ? this.zzc() : this.zzk;
        if (object != null) return object;
        object2 = this.zzj;
        synchronized (object2) {
            object = this.zzk;
            if (object != null) return object;
            this.zzk = object = this.zzc();
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzb() {
        Object object = this.zzj;
        synchronized (object) {
            Object var2_2 = null;
            this.zzk = null;
            return;
        }
    }
}

