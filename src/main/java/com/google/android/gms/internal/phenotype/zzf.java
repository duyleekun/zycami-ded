/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.phenotype;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.phenotype.zzg;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzf {
    private static final Uri CONTENT_URI;
    private static final Uri zzbe;
    private static final Pattern zzbf;
    private static final Pattern zzbg;
    private static final AtomicBoolean zzbh;
    private static HashMap zzbi;
    private static final HashMap zzbj;
    private static final HashMap zzbk;
    private static final HashMap zzbl;
    private static final HashMap zzbm;
    private static Object zzbn;
    private static boolean zzbo;
    private static String[] zzbp;

    static {
        Serializable serializable;
        CONTENT_URI = Uri.parse((String)"content://com.google.android.gsf.gservices");
        zzbe = Uri.parse((String)"content://com.google.android.gsf.gservices/prefix");
        int n10 = 2;
        zzbf = Pattern.compile("^(1|true|t|on|yes|y)$", n10);
        zzbg = Pattern.compile("^(0|false|f|off|no|n)$", n10);
        zzbh = serializable = new AtomicBoolean();
        serializable = new HashMap();
        zzbj = serializable;
        serializable = new HashMap();
        zzbk = serializable;
        serializable = new HashMap();
        zzbl = serializable;
        serializable = new HashMap();
        zzbm = serializable;
        zzbp = new String[0];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object zza(HashMap hashMap, String string2, Object object) {
        Class<zzf> clazz = zzf.class;
        synchronized (clazz) {
            boolean bl2 = hashMap.containsKey(string2);
            if (!bl2) {
                return null;
            }
            if ((hashMap = hashMap.get(string2)) == null) return object;
            return hashMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String zza(ContentResolver object, String string2, String object2) {
        Object object3;
        block15: {
            String string3;
            int n10;
            Object object4;
            boolean bl2;
            object2 = zzf.class;
            synchronized (object2) {
                zzf.zza(object);
                object3 = zzbn;
                Object object5 = zzbi;
                bl2 = ((HashMap)object5).containsKey(string2);
                object4 = null;
                if (bl2) {
                    object = zzbi;
                    object = object.get(string2);
                    if ((object = (String)object) == null) return object4;
                    return object;
                }
                object5 = zzbp;
                int n11 = ((String[])object5).length;
                int n12 = 0;
                while (true) {
                    n10 = 1;
                    if (n12 >= n11) break;
                    string3 = object5[n12];
                    boolean bl3 = string2.startsWith(string3);
                    if (bl3) {
                        boolean bl4 = zzbo;
                        if (bl4) {
                            object3 = zzbi;
                            bl4 = object3.isEmpty();
                            if (!bl4) return null;
                        }
                        object3 = zzbp;
                        object5 = zzbi;
                        object = zzf.zza(object, object3);
                        ((HashMap)object5).putAll(object);
                        zzbo = n10;
                        object = zzbi;
                        boolean bl5 = object.containsKey(string2);
                        if (!bl5) return null;
                        object = zzbi;
                        object = object.get(string2);
                        if ((object = (String)object) == null) return object4;
                        return object;
                    }
                    ++n12;
                }
            }
            Uri uri = CONTENT_URI;
            String[] stringArray = new String[n10];
            stringArray[0] = string2;
            string3 = object;
            object = object.query(uri, null, null, stringArray, null);
            if (object != null) {
                boolean bl6 = object.moveToFirst();
                if (!bl6) break block15;
                object2 = object.getString(n10);
                if (object2 != null && (bl2 = ((String)object2).equals(null))) {
                    bl6 = false;
                    object2 = null;
                }
                zzf.zza(object3, string2, (String)object2);
                if (object2 != null) {
                    object4 = object2;
                }
                if (object == null) return object4;
                object.close();
                return object4;
            }
        }
        try {
            zzf.zza(object3, string2, null);
            return null;
        }
        catch (Throwable throwable) {
            throw throwable;
        }
        finally {
            if (object != null) {
                object.close();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Map zza(ContentResolver contentResolver, String ... object) {
        Object object2 = zzbe;
        Object object3 = contentResolver;
        contentResolver = contentResolver.query(object2, null, null, (String[])object, null);
        object = new TreeMap();
        if (contentResolver == null) {
            return object;
        }
        try {
            boolean bl2;
            while (bl2 = contentResolver.moveToNext()) {
                bl2 = false;
                object3 = null;
                object3 = contentResolver.getString(0);
                int n10 = 1;
                object2 = contentResolver.getString(n10);
                ((TreeMap)object).put(object3, object2);
            }
            return object;
        }
        finally {
            contentResolver.close();
        }
    }

    private static void zza(ContentResolver object) {
        HashMap hashMap = zzbi;
        if (hashMap == null) {
            zzbh.set(false);
            hashMap = new HashMap();
            zzbi = hashMap;
            zzbn = hashMap = new Object();
            zzbo = false;
            hashMap = CONTENT_URI;
            zzg zzg2 = new zzg(null);
            object.registerContentObserver((Uri)hashMap, true, (ContentObserver)zzg2);
            return;
        }
        object = zzbh;
        boolean bl2 = ((AtomicBoolean)object).getAndSet(false);
        if (bl2) {
            zzbi.clear();
            zzbj.clear();
            zzbk.clear();
            zzbl.clear();
            zzbm.clear();
            zzbn = object = new Object();
            zzbo = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zza(Object object, String string2, String string3) {
        Class<zzf> clazz = zzf.class;
        synchronized (clazz) {
            Object object2 = zzbn;
            if (object == object2) {
                object = zzbi;
                ((HashMap)object).put(string2, string3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean zza(ContentResolver object, String string2, boolean bl2) {
        Object object2 = zzf.zzb((ContentResolver)object);
        HashMap hashMap = zzbj;
        Boolean bl3 = bl2;
        if ((bl3 = (Boolean)zzf.zza(hashMap, string2, bl3)) != null) {
            return bl3;
        }
        boolean bl4 = false;
        Object object3 = null;
        if ((object = zzf.zza((ContentResolver)object, string2, null)) != null && !(bl4 = ((String)object).equals(object3 = ""))) {
            object3 = zzbf.matcher((CharSequence)object);
            bl4 = ((Matcher)object3).matches();
            if (bl4) {
                bl2 = true;
                bl3 = Boolean.TRUE;
            } else {
                object3 = zzbg.matcher((CharSequence)object);
                bl4 = ((Matcher)object3).matches();
                if (bl4) {
                    bl2 = false;
                    bl3 = Boolean.FALSE;
                } else {
                    object3 = "Gservices";
                    StringBuilder stringBuilder = new StringBuilder("attempt to read gservices key ");
                    stringBuilder.append(string2);
                    String string3 = " (value \"";
                    stringBuilder.append(string3);
                    stringBuilder.append((String)object);
                    stringBuilder.append("\") as boolean");
                    object = stringBuilder.toString();
                    Log.w((String)object3, (String)object);
                }
            }
        }
        object = zzf.class;
        synchronized (object) {
            object3 = zzbn;
            if (object2 == object3) {
                hashMap.put(string2, bl3);
                object2 = zzbi;
                ((HashMap)object2).remove(string2);
            }
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object zzb(ContentResolver object) {
        Class<zzf> clazz = zzf.class;
        synchronized (clazz) {
            zzf.zza(object);
            return zzbn;
        }
    }

    public static /* synthetic */ AtomicBoolean zzi() {
        return zzbh;
    }
}

