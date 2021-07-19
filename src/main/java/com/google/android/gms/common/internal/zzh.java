/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Message
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor$zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Map;

public final class zzh
implements ServiceConnection,
zzj {
    private final Map zza;
    private int zzb;
    private boolean zzc;
    private IBinder zzd;
    private final GmsClientSupervisor$zza zze;
    private ComponentName zzf;
    private final /* synthetic */ zzf zzg;

    public zzh(zzf hashMap, GmsClientSupervisor$zza gmsClientSupervisor$zza) {
        this.zzg = hashMap;
        this.zze = gmsClientSupervisor$zza;
        this.zza = hashMap = new HashMap();
        this.zzb = 2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap = com.google.android.gms.common.internal.zzf.zza(this.zzg);
        synchronized (hashMap) {
            Object object = this.zzg;
            object = com.google.android.gms.common.internal.zzf.zzb((zzf)object);
            GmsClientSupervisor$zza gmsClientSupervisor$zza = this.zze;
            int n10 = 1;
            object.removeMessages(n10, (Object)gmsClientSupervisor$zza);
            this.zzd = iBinder;
            this.zzf = componentName;
            object = this.zza;
            object = object.values();
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    this.zzb = n10;
                    return;
                }
                gmsClientSupervisor$zza = object.next();
                gmsClientSupervisor$zza = (ServiceConnection)gmsClientSupervisor$zza;
                gmsClientSupervisor$zza.onServiceConnected(componentName, iBinder);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap = com.google.android.gms.common.internal.zzf.zza(this.zzg);
        synchronized (hashMap) {
            Object object = this.zzg;
            object = com.google.android.gms.common.internal.zzf.zzb((zzf)object);
            int n10 = 1;
            GmsClientSupervisor$zza gmsClientSupervisor$zza = this.zze;
            object.removeMessages(n10, (Object)gmsClientSupervisor$zza);
            object = null;
            this.zzd = null;
            this.zzf = componentName;
            object = this.zza;
            object = object.values();
            object = object.iterator();
            while (true) {
                if ((n10 = (int)(object.hasNext() ? 1 : 0)) == 0) {
                    int n11;
                    this.zzb = n11 = 2;
                    return;
                }
                Object object2 = object.next();
                object2 = (ServiceConnection)object2;
                object2.onServiceDisconnected(componentName);
            }
        }
    }

    public final void zza(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String string2) {
        this.zza.put(serviceConnection, serviceConnection2);
    }

    public final void zza(ServiceConnection serviceConnection, String string2) {
        this.zza.remove(serviceConnection);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void zza(String object) {
        int n10;
        int n11;
        this.zzb = n11 = 3;
        Object object2 = com.google.android.gms.common.internal.zzf.zzd(this.zzg);
        Context context = com.google.android.gms.common.internal.zzf.zzc(this.zzg);
        Object object3 = this.zze;
        Context context2 = com.google.android.gms.common.internal.zzf.zzc(this.zzg);
        Intent intent = ((GmsClientSupervisor$zza)object3).zza(context2);
        object3 = this.zze;
        int n12 = ((GmsClientSupervisor$zza)object3).zzc();
        Object object4 = object;
        this.zzc = n10 = ((ConnectionTracker)object2).zza(context, (String)object, intent, this, n12);
        if (n10 != 0) {
            object = com.google.android.gms.common.internal.zzf.zzb(this.zzg);
            object2 = this.zze;
            object = object.obtainMessage(1, object2);
            object3 = com.google.android.gms.common.internal.zzf.zzb(this.zzg);
            long l10 = com.google.android.gms.common.internal.zzf.zze(this.zzg);
            object3.sendMessageDelayed((Message)object, l10);
            return;
        }
        this.zzb = n10 = 2;
        try {
            object = this.zzg;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return;
        }
        object = com.google.android.gms.common.internal.zzf.zzd((zzf)object);
        object3 = this.zzg;
        object3 = com.google.android.gms.common.internal.zzf.zzc((zzf)object3);
        ((ConnectionTracker)object).unbindService((Context)object3, this);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final boolean zza(ServiceConnection serviceConnection) {
        return this.zza.containsKey(serviceConnection);
    }

    public final int zzb() {
        return this.zzb;
    }

    public final void zzb(String object) {
        object = com.google.android.gms.common.internal.zzf.zzb(this.zzg);
        GmsClientSupervisor$zza gmsClientSupervisor$zza = this.zze;
        object.removeMessages(1, (Object)gmsClientSupervisor$zza);
        object = com.google.android.gms.common.internal.zzf.zzd(this.zzg);
        gmsClientSupervisor$zza = com.google.android.gms.common.internal.zzf.zzc(this.zzg);
        ((ConnectionTracker)object).unbindService((Context)gmsClientSupervisor$zza, this);
        this.zzc = false;
        this.zzb = 2;
    }

    public final boolean zzc() {
        return this.zza.isEmpty();
    }

    public final IBinder zzd() {
        return this.zzd;
    }

    public final ComponentName zze() {
        return this.zzf;
    }
}

