/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.vision;

import android.net.Uri;
import androidx.collection.ArrayMap;

public final class zzbj {
    private static final ArrayMap zzgp;

    static {
        ArrayMap arrayMap;
        zzgp = arrayMap = new ArrayMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Uri getContentProviderUri(String string2) {
        Class<zzbj> clazz = zzbj.class;
        synchronized (clazz) {
            ArrayMap arrayMap = zzgp;
            Object object = arrayMap.get(string2);
            object = (Uri)object;
            if (object == null) {
                object = "content://com.google.android.gms.phenotype/";
                String string3 = Uri.encode((String)string2);
                int n10 = (string3 = String.valueOf(string3)).length();
                if (n10 != 0) {
                    object = ((String)object).concat(string3);
                } else {
                    string3 = new String((String)object);
                    object = string3;
                }
                object = Uri.parse((String)object);
                arrayMap.put(string2, object);
            }
            return object;
        }
    }
}

