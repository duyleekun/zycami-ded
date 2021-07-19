/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 */
package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$zzc;

public abstract class BaseGmsClient$zza
extends BaseGmsClient$zzc {
    private final int zza;
    private final Bundle zzb;
    private final /* synthetic */ BaseGmsClient zzc;

    public BaseGmsClient$zza(BaseGmsClient baseGmsClient, int n10, Bundle bundle) {
        this.zzc = baseGmsClient;
        Boolean bl2 = Boolean.TRUE;
        super(baseGmsClient, bl2);
        this.zza = n10;
        this.zzb = bundle;
    }

    public abstract void zza(ConnectionResult var1);

    /*
     * Enabled aggressive block sorting
     */
    public final /* synthetic */ void zza(Object object) {
        object = (Boolean)object;
        int n10 = 1;
        PendingIntent pendingIntent = null;
        if (object == null) {
            BaseGmsClient.zza(this.zzc, n10, null);
            return;
        }
        int n11 = this.zza;
        if (n11 == 0) {
            n11 = (int)(this.zza() ? 1 : 0);
            if (n11 != 0) return;
            BaseGmsClient.zza(this.zzc, n10, null);
            n10 = 8;
            object = new ConnectionResult(n10, null);
            this.zza((ConnectionResult)object);
            return;
        }
        int n12 = 10;
        if (n11 == n12) {
            BaseGmsClient.zza(this.zzc, n10, null);
            pendingIntent = new Object[3];
            String string2 = this.getClass().getSimpleName();
            pendingIntent[0] = string2;
            String string3 = this.zzc.getStartServiceAction();
            pendingIntent[n10] = string3;
            string3 = this.zzc.getServiceDescriptor();
            pendingIntent[2] = string3;
            String string4 = String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", (Object[])pendingIntent);
            object = new IllegalStateException(string4);
            throw object;
        }
        BaseGmsClient.zza(this.zzc, n10, null);
        object = this.zzb;
        if (object != null) {
            String string5 = "pendingIntent";
            object = object.getParcelable(string5);
            pendingIntent = object;
            pendingIntent = (PendingIntent)object;
        }
        n10 = this.zza;
        object = new ConnectionResult(n10, pendingIntent);
        this.zza((ConnectionResult)object);
    }

    public abstract boolean zza();

    public final void zzb() {
    }
}

