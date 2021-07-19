/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.Map;

public final class zzev {
    private final Map zza;

    public zzev(Map map) {
        this.zza = map;
    }

    public final String zza(Uri object, String string2, String object2, String string3) {
        string2 = null;
        if (object != null) {
            object = object.toString();
            object2 = this.zza;
            if ((object = (Map)object2.get(object)) == null) {
                return null;
            }
            string2 = String.valueOf(string3);
            object2 = "";
            int n10 = string2.length();
            string2 = n10 != 0 ? ((String)object2).concat(string2) : new String((String)object2);
            return (String)object.get(string2);
        }
        return null;
    }
}

