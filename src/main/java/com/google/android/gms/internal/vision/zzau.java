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
package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.vision.zzaw;
import com.google.android.gms.internal.vision.zzax;
import com.google.android.gms.internal.vision.zzay;
import com.google.android.gms.internal.vision.zzaz;
import com.google.android.gms.internal.vision.zzba;
import com.google.android.gms.internal.vision.zzbb;
import com.google.android.gms.internal.vision.zzbi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzau
implements zzay {
    private static final Map zzfp;
    private static final String[] zzfv;
    private final Uri uri;
    private final ContentResolver zzfq;
    private final ContentObserver zzfr;
    private final Object zzfs;
    private volatile Map zzft;
    private final List zzfu;

    static {
        ArrayMap arrayMap = new ArrayMap();
        zzfp = arrayMap;
        zzfv = new String[]{"key", "value"};
    }

    private zzau(ContentResolver contentResolver, Uri uri) {
        zzaw zzaw2 = new zzaw(this, null);
        this.zzfr = zzaw2;
        ArrayList arrayList = new ArrayList();
        this.zzfs = arrayList;
        this.zzfu = arrayList = new ArrayList();
        this.zzfq = contentResolver;
        this.uri = uri;
        contentResolver.registerContentObserver(uri, false, (ContentObserver)zzaw2);
    }

    /*
     * WARNING - bad return control flow
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzau zza(ContentResolver contentResolver, Uri uri) {
        Class<zzau> clazz = zzau.class;
        synchronized (clazz) {
            zzau zzau2;
            Map map = zzfp;
            Object object = map.get(uri);
            object = (zzau)object;
            if (object != null) return object;
            try {
                zzau2 = new zzau(contentResolver, uri);
            }
            catch (SecurityException securityException) {}
            try {
                map.put(uri, zzau2);
                return zzau2;
            }
            catch (SecurityException securityException) {}
            return zzau2;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Map zzv() {
        Map map = this.zzft;
        if (map == null) {
            Object object = this.zzfs;
            synchronized (object) {
                map = this.zzft;
                if (map == null) {
                    this.zzft = map = this.zzx();
                }
            }
        }
        if (map != null) {
            return map;
        }
        return Collections.emptyMap();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Map zzx() {
        Throwable throwable2222222;
        StrictMode.ThreadPolicy threadPolicy;
        block4: {
            threadPolicy = StrictMode.allowThreadDiskReads();
            Object object = new zzax(this);
            object = zzbb.zza((zzba)object);
            object = (Map)object;
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (SQLiteException | IllegalStateException | SecurityException throwable3) {}
                String string2 = "ConfigurationContentLoader";
                String string3 = "PhenotypeFlag unable to load ContentProvider, using default values";
                {
                    Log.e((String)string2, (String)string3);
                }
                StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                return null;
            }
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            return object;
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        throw throwable2222222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void zzy() {
        Class<zzau> clazz = zzau.class;
        synchronized (clazz) {
            Object object = zzfp;
            object = object.values();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = zzfp;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (zzau)object2;
                ContentResolver contentResolver = ((zzau)object2).zzfq;
                object2 = ((zzau)object2).zzfr;
                contentResolver.unregisterContentObserver(object2);
            }
        }
    }

    public final /* synthetic */ Object zzb(String string2) {
        return (String)this.zzv().get(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzw() {
        zzaz zzaz2;
        boolean bl2;
        Iterator iterator2 = this.zzfs;
        synchronized (iterator2) {
            bl2 = false;
            zzaz2 = null;
            this.zzft = null;
            zzbi.zzaf();
        }
        synchronized (this) {
            iterator2 = this.zzfu;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                zzaz2 = (zzaz)iterator2.next();
                zzaz2 = zzaz2;
                zzaz2.zzad();
            }
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final /* synthetic */ Map zzz() {
        block13: {
            block12: {
                var1_1 = this.zzfq;
                var2_2 /* !! */  = this.uri;
                var3_4 = zzau.zzfv;
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

