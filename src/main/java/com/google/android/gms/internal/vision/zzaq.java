/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 */
package com.google.android.gms.internal.vision;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import com.google.android.gms.internal.vision.zzat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzaq {
    public static final Uri CONTENT_URI;
    private static final Uri zzfa;
    public static final Pattern zzfb;
    private static final Pattern zzfc;
    private static final AtomicBoolean zzfd;
    private static HashMap zzfe;
    private static final HashMap zzff;
    private static final HashMap zzfg;
    private static final HashMap zzfh;
    private static final HashMap zzfi;
    private static Object zzfj;
    private static boolean zzfk;
    private static String[] zzfl;

    static {
        Serializable serializable;
        CONTENT_URI = Uri.parse((String)"content://com.google.android.gsf.gservices");
        zzfa = Uri.parse((String)"content://com.google.android.gsf.gservices/prefix");
        int n10 = 2;
        zzfb = Pattern.compile("^(1|true|t|on|yes|y)$", n10);
        zzfc = Pattern.compile("^(0|false|f|off|no|n)$", n10);
        zzfd = serializable = new AtomicBoolean();
        serializable = new HashMap();
        zzff = serializable;
        serializable = new HashMap();
        zzfg = serializable;
        serializable = new HashMap();
        zzfh = serializable;
        serializable = new HashMap();
        zzfi = serializable;
        zzfl = new String[0];
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String zza(ContentResolver object, String string2, String object2) {
        boolean bl2;
        Object object3;
        int n10;
        Object object4;
        block15: {
            boolean bl3;
            String string32;
            Object object5;
            object2 = zzaq.class;
            synchronized (object2) {
                boolean bl4;
                object4 = zzfe;
                n10 = 1;
                HashMap hashMap = null;
                object3 = null;
                if (object4 == null) {
                    object4 = zzfd;
                    object4.set(false);
                    object4 = new HashMap();
                    zzfe = object4;
                    object4 = new Object();
                    zzfj = object4;
                    zzfk = false;
                    object4 = CONTENT_URI;
                    object5 = new zzat(null);
                    object.registerContentObserver((Uri)object4, n10 != 0, (ContentObserver)object5);
                } else {
                    object4 = zzfd;
                    bl4 = object4.getAndSet(false);
                    if (bl4) {
                        object4 = zzfe;
                        object4.clear();
                        object4 = zzff;
                        object4.clear();
                        object4 = zzfg;
                        object4.clear();
                        object4 = zzfh;
                        object4.clear();
                        object4 = zzfi;
                        object4.clear();
                        object4 = new Object();
                        zzfj = object4;
                        zzfk = false;
                    }
                }
                object4 = zzfj;
                object5 = zzfe;
                boolean bl5 = object5.containsKey(string2);
                if (bl5) {
                    object = zzfe;
                    object = object.get(string2);
                    if ((object = (String)object) == null) return object3;
                    return object;
                }
                for (String string32 : zzfl) {
                    bl3 = string2.startsWith(string32);
                    if (!bl3) continue;
                    bl4 = zzfk;
                    if (bl4) {
                        object4 = zzfe;
                        bl4 = object4.isEmpty();
                        if (!bl4) return null;
                    }
                    object4 = zzfl;
                    hashMap = zzfe;
                    object = zzaq.zza(object, object4);
                    hashMap.putAll(object);
                    zzfk = n10;
                    object = zzfe;
                    boolean bl6 = object.containsKey(string2);
                    if (!bl6) return null;
                    object = zzfe;
                    object = object.get(string2);
                    if ((object = (String)object) == null) return object3;
                    return object;
                }
            }
            Uri uri = CONTENT_URI;
            int n11 = 0;
            bl3 = false;
            string32 = null;
            String[] stringArray = new String[n10];
            stringArray[0] = string2;
            object5 = object;
            object = object.query(uri, null, null, stringArray, null);
            if (object == null) {
                if (object == null) return null;
                object.close();
                return null;
            }
            try {
                bl2 = object.moveToFirst();
                if (bl2) break block15;
                zzaq.zza(object4, string2, null);
                if (object == null) return null;
            }
            catch (Throwable throwable) {
                if (object == null) throw throwable;
                object.close();
                throw throwable;
            }
            object.close();
            return null;
        }
        object2 = object.getString(n10);
        if (object2 != null && (n10 = (int)(((String)object2).equals(null) ? 1 : 0)) != 0) {
            bl2 = false;
            object2 = null;
        }
        zzaq.zza(object4, string2, (String)object2);
        if (object2 != null) {
            object3 = object2;
        }
        if (object == null) return object3;
        object.close();
        return object3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Map zza(ContentResolver contentResolver, String ... object) {
        Object object2 = zzfa;
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void zza(Object object, String string2, String string3) {
        Class<zzaq> clazz = zzaq.class;
        synchronized (clazz) {
            Object object2 = zzfj;
            if (object == object2) {
                object = zzfe;
                ((HashMap)object).put(string2, string3);
            }
            return;
        }
    }

    public static /* synthetic */ AtomicBoolean zzt() {
        return zzfd;
    }
}

