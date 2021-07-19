/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;

public abstract class BaseGmsClient$zzc {
    private Object zza;
    private boolean zzb;
    private final /* synthetic */ BaseGmsClient zzc;

    public BaseGmsClient$zzc(BaseGmsClient baseGmsClient, Object object) {
        this.zzc = baseGmsClient;
        this.zza = object;
        this.zzb = false;
    }

    public abstract void zza(Object var1);

    public abstract void zzb();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void zzc() {
        boolean bl2;
        // MONITORENTER : this
        Object object = this.zza;
        boolean bl3 = this.zzb;
        if (bl3) {
            String string2 = "GmsClient";
            String string3 = String.valueOf(this);
            String string4 = String.valueOf(string3);
            int n10 = string4.length() + 47;
            StringBuilder stringBuilder = new StringBuilder(n10);
            string4 = "Callback proxy ";
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = " being reused. This is not safe.";
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            Log.w((String)string2, (String)string3);
        }
        // MONITOREXIT : this
        if (object != null) {
            try {
                this.zza(object);
            }
            catch (RuntimeException runtimeException) {
                this.zzb();
                throw runtimeException;
            }
        } else {
            this.zzb();
        }
        // MONITORENTER : this
        this.zzb = bl2 = true;
        // MONITOREXIT : this
        this.zzd();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzd() {
        this.zze();
        ArrayList arrayList = BaseGmsClient.zzf(this.zzc);
        synchronized (arrayList) {
            Object object = this.zzc;
            object = BaseGmsClient.zzf((BaseGmsClient)object);
            ((ArrayList)object).remove(this);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zze() {
        synchronized (this) {
            Object var1_1 = null;
            this.zza = null;
            return;
        }
    }
}

