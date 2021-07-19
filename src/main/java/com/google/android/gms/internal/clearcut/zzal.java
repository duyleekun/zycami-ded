/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.util.Base64
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.clearcut.zzae;
import com.google.android.gms.internal.clearcut.zzan;
import com.google.android.gms.internal.clearcut.zzao;
import java.io.IOException;

public final class zzal
extends zzae {
    private final Object lock;
    private String zzec;
    private Object zzed;
    private final /* synthetic */ zzan zzee;

    public zzal(zzao object, String string2, Object object2, zzan zzan2) {
        this.zzee = zzan2;
        super((zzao)object, string2, object2, null);
        this.lock = object = new Object();
    }

    public final Object zza(SharedPreferences object) {
        String string2;
        String string3;
        try {
            string3 = this.zzds;
            string2 = "";
        }
        catch (ClassCastException classCastException) {
            string3 = "Invalid byte[] value in SharedPreferences for ";
            string2 = String.valueOf(this.zzds);
            int n10 = string2.length();
            string3 = n10 != 0 ? string3.concat(string2) : (string2 = new String(string3));
            Log.e((String)"PhenotypeFlag", (String)string3, (Throwable)classCastException);
            return null;
        }
        object = object.getString(string3, string2);
        return ((zzae)this).zzb((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzb(String string2) {
        block5: {
            Object object;
            try {
                Object object2 = this.lock;
                synchronized (object2) {
                    object = this.zzec;
                }
            }
            catch (IOException | IllegalArgumentException exception) {
                break block5;
            }
            {
                boolean bl2 = string2.equals(object);
                if (bl2) return this.zzed;
                object = this.zzee;
                int n10 = 3;
                byte[] byArray = Base64.decode((String)string2, (int)n10);
                object = object.zzb(byArray);
                this.zzec = string2;
                this.zzed = object;
                return this.zzed;
            }
        }
        String string3 = this.zzds;
        int n11 = String.valueOf(string3).length() + 27;
        int n12 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append("Invalid byte[] value for ");
        stringBuilder.append(string3);
        stringBuilder.append(": ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        Log.e((String)"PhenotypeFlag", (String)string2);
        return null;
    }
}

