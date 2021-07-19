/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.clearcut.zzz;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zzy {
    private static final Uri CONTENT_URI;
    private static final Uri zzcq;
    public static final Pattern zzcr;
    public static final Pattern zzcs;
    private static final AtomicBoolean zzct;
    private static HashMap zzcu;
    private static final HashMap zzcv;
    private static final HashMap zzcw;
    private static final HashMap zzcx;
    private static final HashMap zzcy;
    private static Object zzcz;
    private static boolean zzda;
    private static String[] zzdb;

    static {
        Serializable serializable;
        CONTENT_URI = Uri.parse((String)"content://com.google.android.gsf.gservices");
        zzcq = Uri.parse((String)"content://com.google.android.gsf.gservices/prefix");
        int n10 = 2;
        zzcr = Pattern.compile("^(1|true|t|on|yes|y)$", n10);
        zzcs = Pattern.compile("^(0|false|f|off|no|n)$", n10);
        zzct = serializable = new AtomicBoolean();
        serializable = new HashMap();
        zzcv = serializable;
        serializable = new HashMap();
        zzcw = serializable;
        serializable = new HashMap();
        zzcx = serializable;
        serializable = new HashMap();
        zzcy = serializable;
        zzdb = new String[0];
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long getLong(ContentResolver object, String string2, long l10) {
        void var1_3;
        Object object2 = zzy.zzb(object);
        Serializable serializable = zzcx;
        long l11 = 0L;
        Long l12 = l11;
        if ((serializable = (Long)zzy.zza((HashMap)serializable, (String)var1_3, l12)) != null) {
            return (Long)serializable;
        }
        l12 = null;
        String string3 = zzy.zza(object, (String)var1_3, null);
        if (string3 != null) {
            try {
                long l13 = Long.parseLong(string3);
                serializable = Long.valueOf(l13);
                l11 = l13;
            }
            catch (NumberFormatException numberFormatException) {}
        }
        HashMap hashMap = zzcx;
        zzy.zza(object2, hashMap, (String)var1_3, serializable);
        return l11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object zza(HashMap hashMap, String string2, Object object) {
        Class<zzy> clazz = zzy.class;
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
            object2 = zzy.class;
            synchronized (object2) {
                zzy.zza(object);
                object3 = zzcz;
                Object object5 = zzcu;
                bl2 = ((HashMap)object5).containsKey(string2);
                object4 = null;
                if (bl2) {
                    object = zzcu;
                    object = object.get(string2);
                    if ((object = (String)object) == null) return object4;
                    return object;
                }
                object5 = zzdb;
                int n11 = ((String[])object5).length;
                int n12 = 0;
                while (true) {
                    n10 = 1;
                    if (n12 >= n11) break;
                    string3 = object5[n12];
                    boolean bl3 = string2.startsWith(string3);
                    if (bl3) {
                        boolean bl4 = zzda;
                        if (bl4) {
                            object3 = zzcu;
                            bl4 = object3.isEmpty();
                            if (!bl4) return null;
                        }
                        object3 = zzdb;
                        object5 = zzcu;
                        object = zzy.zza(object, object3);
                        ((HashMap)object5).putAll(object);
                        zzda = n10;
                        object = zzcu;
                        boolean bl5 = object.containsKey(string2);
                        if (!bl5) return null;
                        object = zzcu;
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
                zzy.zza(object3, string2, (String)object2);
                if (object2 != null) {
                    object4 = object2;
                }
                if (object == null) return object4;
                object.close();
                return object4;
            }
        }
        try {
            zzy.zza(object3, string2, null);
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
        Object object2 = zzcq;
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
        HashMap hashMap = zzcu;
        if (hashMap == null) {
            zzct.set(false);
            hashMap = new HashMap();
            zzcu = hashMap;
            zzcz = hashMap = new Object();
            zzda = false;
            hashMap = CONTENT_URI;
            zzz zzz2 = new zzz(null);
            object.registerContentObserver((Uri)hashMap, true, (ContentObserver)zzz2);
            return;
        }
        object = zzct;
        boolean bl2 = ((AtomicBoolean)object).getAndSet(false);
        if (bl2) {
            zzcu.clear();
            zzcv.clear();
            zzcw.clear();
            zzcx.clear();
            zzcy.clear();
            zzcz = object = new Object();
            zzda = false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zza(Object object, String string2, String string3) {
        Class<zzy> clazz = zzy.class;
        synchronized (clazz) {
            Object object2 = zzcz;
            if (object == object2) {
                object = zzcu;
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
    private static void zza(Object object, HashMap hashMap, String string2, Object object2) {
        Class<zzy> clazz = zzy.class;
        synchronized (clazz) {
            Object object3 = zzcz;
            if (object == object3) {
                hashMap.put(string2, object2);
                object = zzcu;
                ((HashMap)object).remove(string2);
            }
            return;
        }
    }

    public static boolean zza(ContentResolver object, String string2, boolean bl2) {
        Object object2 = zzy.zzb((ContentResolver)object);
        HashMap hashMap = zzcv;
        Boolean bl3 = bl2;
        if ((bl3 = (Boolean)zzy.zza(hashMap, string2, bl3)) != null) {
            return bl3;
        }
        boolean bl4 = false;
        Object object3 = null;
        if ((object = zzy.zza((ContentResolver)object, string2, null)) != null && !(bl4 = ((String)object).equals(object3 = ""))) {
            object3 = zzcr.matcher((CharSequence)object);
            bl4 = ((Matcher)object3).matches();
            if (bl4) {
                bl2 = true;
                bl3 = Boolean.TRUE;
            } else {
                object3 = zzcs.matcher((CharSequence)object);
                bl4 = ((Matcher)object3).matches();
                if (bl4) {
                    bl2 = false;
                    bl3 = Boolean.FALSE;
                } else {
                    object3 = new StringBuilder("attempt to read gservices key ");
                    ((StringBuilder)object3).append(string2);
                    String string3 = " (value \"";
                    ((StringBuilder)object3).append(string3);
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append("\") as boolean");
                    object = ((StringBuilder)object3).toString();
                    object3 = "Gservices";
                    Log.w((String)object3, (String)object);
                }
            }
        }
        zzy.zza(object2, hashMap, string2, bl3);
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object zzb(ContentResolver object) {
        Class<zzy> clazz = zzy.class;
        synchronized (clazz) {
            zzy.zza(object);
            return zzcz;
        }
    }

    public static /* synthetic */ AtomicBoolean zze() {
        return zzct;
    }
}

