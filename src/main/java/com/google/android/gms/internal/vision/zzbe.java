/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.gms.internal.vision;

import android.net.Uri;
import java.util.Map;

public final class zzbe {
    private final Map map;

    public zzbe(Map map) {
        this.map = map;
    }

    public final String zza(Uri object, String string2, String string3, String string4) {
        block7: {
            block6: {
                block5: {
                    if (object == null) break block5;
                    string2 = object.toString();
                    break block6;
                }
                if (string2 == null) break block7;
            }
            object = (Map)this.map.get(string2);
            if (object == null) {
                return null;
            }
            if (string3 != null) {
                string2 = String.valueOf(string3);
                string3 = String.valueOf(string4);
                int n10 = string3.length();
                string4 = n10 != 0 ? string2.concat(string3) : new String(string2);
            }
            return (String)object.get(string4);
        }
        return null;
    }
}

