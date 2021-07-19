/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzel;
import com.google.android.gms.internal.measurement.zzem;
import com.google.android.gms.internal.measurement.zzeo;
import com.google.android.gms.internal.measurement.zzep;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzfg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class zzen
implements zzer {
    public static final String[] zza;
    private static final Map zzb;
    private final ContentResolver zzc;
    private final Uri zzd;
    private final ContentObserver zze;
    private final Object zzf;
    private volatile Map zzg;
    private final List zzh;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzb = arrayMap;
        zza = new String[]{"key", "value"};
    }

    private zzen(ContentResolver contentResolver, Uri uri) {
        zzem zzem2 = new zzem(this, null);
        this.zze = zzem2;
        ArrayList arrayList = new ArrayList();
        this.zzf = arrayList;
        this.zzh = arrayList = new ArrayList();
        Objects.requireNonNull(contentResolver);
        Objects.requireNonNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        contentResolver.registerContentObserver(uri, false, (ContentObserver)zzem2);
    }

    /*
     * WARNING - bad return control flow
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzen zza(ContentResolver contentResolver, Uri uri) {
        Class<zzen> clazz = zzen.class;
        synchronized (clazz) {
            zzen zzen2;
            Map map = zzb;
            Object object = map.get(uri);
            object = (zzen)object;
            if (object != null) return object;
            try {
                zzen2 = new zzen(contentResolver, uri);
            }
            catch (SecurityException securityException) {}
            try {
                map.put(uri, zzen2);
                return zzen2;
            }
            catch (SecurityException securityException) {}
            return zzen2;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzd() {
        Class<zzen> clazz = zzen.class;
        synchronized (clazz) {
            Object object = zzb;
            object = object.values();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = zzb;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (zzen)object2;
                ContentResolver contentResolver = ((zzen)object2).zzc;
                object2 = ((zzen)object2).zze;
                contentResolver.unregisterContentObserver(object2);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Map zzb() {
        Object object;
        block12: {
            object = this.zzg;
            if (object != null) break block12;
            Object object2 = this.zzf;
            synchronized (object2) {
                object = this.zzg;
                if (object == null) {
                    Throwable throwable2222222;
                    block10: {
                        Object object3;
                        block11: {
                            object = StrictMode.allowThreadDiskReads();
                            object3 = new zzel(this);
                            object3 = zzep.zza((zzeq)object3);
                            object3 = (Map)object3;
                            {
                                catch (Throwable throwable2222222) {
                                    break block10;
                                }
                                catch (SQLiteException | IllegalStateException | SecurityException throwable3) {}
                                object3 = "ConfigurationContentLoader";
                                String string2 = "PhenotypeFlag unable to load ContentProvider, using default values";
                                {
                                    Log.e((String)object3, (String)string2);
                                }
                                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)object);
                                object3 = null;
                                break block11;
                            }
                            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)object);
                        }
                        this.zzg = object3;
                        object = object3;
                        break block12;
                    }
                    StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)object);
                    throw throwable2222222;
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
    public final void zzc() {
        zzeo zzeo2;
        boolean bl2;
        Iterator iterator2 = this.zzf;
        synchronized (iterator2) {
            bl2 = false;
            zzeo2 = null;
            this.zzg = null;
            zzfg.zzc();
        }
        synchronized (this) {
            iterator2 = this.zzh;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                zzeo2 = (zzeo)iterator2.next();
                zzeo2 = zzeo2;
                zzeo2.zza();
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final /* synthetic */ Map zzf() {
        block13: {
            block12: {
                var1_1 = this.zzc;
                var2_2 /* !! */  = this.zzd;
                var3_4 = zzen.zza;
                var4_5 = 0;
                var5_6 = 0.0f;
                var6_7 = null;
                if ((var1_1 = var1_1.query(var2_2 /* !! */ , (String[])var3_4, null, null, null)) == null) {
                    return Collections.emptyMap();
                }
                var7_8 = var1_1.getCount();
                if (var7_8 != 0) break block12;
                var2_2 /* !! */  = Collections.emptyMap();
                return var2_2 /* !! */ ;
            }
            var8_9 = 256;
            if (var7_8 > var8_9) break block13;
            var3_4 = new ArrayMap(var7_8);
            ** GOTO lbl26
        }
        var4_5 = 1065353216;
        var5_6 = 1.0f;
        var3_4 = new HashMap(var7_8, var5_6);
lbl26:
        // 3 sources

        while ((var7_8 = (int)var1_1.moveToNext()) != 0) {
            var7_8 = 0;
            var2_2 /* !! */  = null;
        }
        {
            var2_2 /* !! */  = var1_1.getString(0);
            var4_5 = 1;
            var5_6 = 1.4E-45f;
            var6_7 = var1_1.getString(var4_5);
            var3_4.put(var2_2 /* !! */ , var6_7);
            continue;
        }
        var1_1.close();
        return var3_4;
        finally {
            var1_1.close();
        }
    }
}

