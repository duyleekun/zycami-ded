/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.GmsClientSupervisor$zza;
import com.google.android.gms.common.internal.zzf;

public abstract class GmsClientSupervisor {
    private static int zza = 129;
    private static final Object zzb;
    private static GmsClientSupervisor zzc;

    static {
        Object object;
        zzb = object = new Object();
    }

    public static int getDefaultBindFlags() {
        return zza;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GmsClientSupervisor getInstance(Context context) {
        Object object = zzb;
        synchronized (object) {
            GmsClientSupervisor gmsClientSupervisor = zzc;
            if (gmsClientSupervisor == null) {
                context = context.getApplicationContext();
                zzc = gmsClientSupervisor = new zzf(context);
            }
            return zzc;
        }
    }

    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String string2) {
        int n10 = GmsClientSupervisor.getDefaultBindFlags();
        GmsClientSupervisor$zza gmsClientSupervisor$zza = new GmsClientSupervisor$zza(componentName, n10);
        return this.zza(gmsClientSupervisor$zza, serviceConnection, string2);
    }

    public boolean bindService(String string2, ServiceConnection serviceConnection, String string3) {
        int n10 = GmsClientSupervisor.getDefaultBindFlags();
        GmsClientSupervisor$zza gmsClientSupervisor$zza = new GmsClientSupervisor$zza(string2, n10);
        return this.zza(gmsClientSupervisor$zza, serviceConnection, string3);
    }

    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String string2) {
        int n10 = GmsClientSupervisor.getDefaultBindFlags();
        GmsClientSupervisor$zza gmsClientSupervisor$zza = new GmsClientSupervisor$zza(componentName, n10);
        this.zzb(gmsClientSupervisor$zza, serviceConnection, string2);
    }

    public void unbindService(String string2, ServiceConnection serviceConnection, String string3) {
        int n10 = GmsClientSupervisor.getDefaultBindFlags();
        GmsClientSupervisor$zza gmsClientSupervisor$zza = new GmsClientSupervisor$zza(string2, n10);
        this.zzb(gmsClientSupervisor$zza, serviceConnection, string3);
    }

    public final void zza(String string2, String string3, int n10, ServiceConnection serviceConnection, String string4, boolean bl2) {
        GmsClientSupervisor$zza gmsClientSupervisor$zza = new GmsClientSupervisor$zza(string2, string3, n10, bl2);
        this.zzb(gmsClientSupervisor$zza, serviceConnection, string4);
    }

    public abstract boolean zza(GmsClientSupervisor$zza var1, ServiceConnection var2, String var3);

    public abstract void zzb(GmsClientSupervisor$zza var1, ServiceConnection var2, String var3);
}

