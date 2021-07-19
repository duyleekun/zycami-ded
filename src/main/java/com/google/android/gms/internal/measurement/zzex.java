/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;

public final class zzex {
    private static final ArrayMap zza;

    static {
        ArrayMap arrayMap;
        zza = arrayMap = new ArrayMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Uri zza(String clazz) {
        clazz = zzex.class;
        synchronized (clazz) {
            String string2 = "com.google.android.gms.measurement";
            ArrayMap arrayMap = zza;
            Object object = arrayMap.get(string2);
            object = (Uri)object;
            if (object == null) {
                object = Uri.encode((String)string2);
                object = String.valueOf(object);
                String string3 = "content://com.google.android.gms.phenotype/";
                int n10 = ((String)object).length();
                object = n10 != 0 ? string3.concat((String)object) : new String(string3);
                object = Uri.parse((String)object);
                arrayMap.put(string2, object);
            }
            return object;
        }
    }
}

