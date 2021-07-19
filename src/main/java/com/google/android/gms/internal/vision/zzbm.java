/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.vision.zzbi;
import com.google.android.gms.internal.vision.zzbo;
import com.google.android.gms.internal.vision.zzbp;
import java.io.IOException;

public final class zzbm
extends zzbi {
    private final /* synthetic */ zzbp zzgs;

    public zzbm(zzbo zzbo2, String string2, Object object, boolean bl2, zzbp zzbp2) {
        this.zzgs = zzbp2;
        super(zzbo2, string2, object, true, null);
    }

    public final Object zza(Object object) {
        int n10;
        Object object2;
        boolean bl2 = object instanceof String;
        if (bl2) {
            object2 = this.zzgs;
            Object object3 = object;
            object3 = (String)object;
            n10 = 3;
            object3 = Base64.decode((String)object3, (int)n10);
            try {
                return object2.zzb((byte[])object3);
            }
            catch (IOException | IllegalArgumentException exception) {}
        }
        object2 = super.zzag();
        object = String.valueOf(object);
        int n11 = String.valueOf(object2).length() + 27;
        n10 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n10);
        stringBuilder.append("Invalid byte[] value for ");
        stringBuilder.append((String)object2);
        stringBuilder.append(": ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Log.e((String)"PhenotypeFlag", (String)object);
        return null;
    }
}

