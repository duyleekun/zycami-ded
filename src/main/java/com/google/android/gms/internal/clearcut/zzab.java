/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.clearcut.zzad;
import com.google.android.gms.internal.clearcut.zzae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzab {
    private static final ConcurrentHashMap zzde;
    private static final String[] zzdl;
    private final Uri uri;
    private final ContentResolver zzdf;
    private final ContentObserver zzdg;
    private final Object zzdh;
    private volatile Map zzdi;
    private final Object zzdj;
    private final List zzdk;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzde = concurrentHashMap = new ConcurrentHashMap();
        zzdl = new String[]{"key", "value"};
    }

    private zzab(ContentResolver object, Uri uri) {
        ArrayList arrayList = new ArrayList();
        this.zzdh = arrayList;
        arrayList = new ArrayList();
        this.zzdj = arrayList;
        this.zzdk = arrayList = new ArrayList();
        this.zzdf = object;
        this.uri = uri;
        super(this, null);
        this.zzdg = object;
    }

    public static zzab zza(ContentResolver object, Uri uri) {
        ConcurrentHashMap concurrentHashMap = zzde;
        zzab zzab2 = (zzab)concurrentHashMap.get(uri);
        if (zzab2 == null) {
            zzab2 = new zzab((ContentResolver)object, uri);
            if ((object = concurrentHashMap.putIfAbsent(uri, zzab2)) == null) {
                object = zzab2.zzdf;
                uri = zzab2.uri;
                concurrentHashMap = null;
                ContentObserver contentObserver = zzab2.zzdg;
                object.registerContentObserver(uri, false, contentObserver);
            } else {
                zzab2 = object;
            }
        }
        return zzab2;
    }

    public static /* synthetic */ void zza(zzab zzab2) {
        zzab2.zzj();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Map zzi() {
        Object object2;
        Object object;
        ContentResolver contentResolver;
        HashMap<Uri, String[]> hashMap;
        try {
            hashMap = new HashMap<Uri, String[]>();
            contentResolver = this.zzdf;
            object = this.uri;
            object2 = zzdl;
            contentResolver = contentResolver.query(object, object2, null, null, null);
            if (contentResolver == null) return hashMap;
        }
        catch (SQLiteException | SecurityException throwable) {
            Log.e((String)"ConfigurationContentLoader", (String)"PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
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
    private final void zzj() {
        Object object = this.zzdj;
        synchronized (object) {
            Object object2 = this.zzdk;
            object2 = object2.iterator();
            boolean bl2;
            while (bl2 = object2.hasNext()) {
                Object object3 = object2.next();
                object3 = (zzad)object3;
                object3.zzk();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Map zzg() {
        Object object = "gms:phenotype:phenotype_flag:debug_disable_caching";
        Object object2 = null;
        boolean bl2 = zzae.zza((String)object, false);
        if ((object = bl2 ? this.zzi() : this.zzdi) == null) {
            object2 = this.zzdh;
            synchronized (object2) {
                object = this.zzdi;
                if (object == null) {
                    this.zzdi = object = this.zzi();
                }
            }
        }
        if (object != null) {
            return object;
        }
        return Collections.emptyMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzh() {
        Object object = this.zzdh;
        synchronized (object) {
            Object var2_2 = null;
            this.zzdi = null;
            return;
        }
    }
}

