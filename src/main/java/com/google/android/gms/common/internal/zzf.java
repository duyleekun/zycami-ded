/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.GmsClientSupervisor$zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;

public final class zzf
extends GmsClientSupervisor {
    private final HashMap zza;
    private final Context zzb;
    private final Handler zzc;
    private final ConnectionTracker zzd;
    private final long zze;
    private final long zzf;

    public zzf(Context object) {
        Object object2;
        this.zza = object2 = new HashMap();
        this.zzb = object2 = object.getApplicationContext();
        object = object.getMainLooper();
        zzg zzg2 = new zzg(this, null);
        super((Looper)object, zzg2);
        this.zzc = object2;
        object = ConnectionTracker.getInstance();
        this.zzd = object;
        this.zze = 5000L;
        this.zzf = 300000L;
    }

    public static /* synthetic */ HashMap zza(zzf zzf2) {
        return zzf2.zza;
    }

    public static /* synthetic */ Handler zzb(zzf zzf2) {
        return zzf2.zzc;
    }

    public static /* synthetic */ Context zzc(zzf zzf2) {
        return zzf2.zzb;
    }

    public static /* synthetic */ ConnectionTracker zzd(zzf zzf2) {
        return zzf2.zzd;
    }

    public static /* synthetic */ long zze(zzf zzf2) {
        return zzf2.zzf;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zza(GmsClientSupervisor$zza object, ServiceConnection object2, String string2) {
        Preconditions.checkNotNull(object2, "ServiceConnection must not be null");
        HashMap hashMap = this.zza;
        synchronized (hashMap) {
            Object object3 = this.zza;
            object3 = ((HashMap)object3).get(object);
            object3 = (zzh)object3;
            if (object3 == null) {
                object3 = new zzh(this, (GmsClientSupervisor$zza)object);
                ((zzh)object3).zza((ServiceConnection)object2, (ServiceConnection)object2, string2);
                ((zzh)object3).zza(string2);
                object2 = this.zza;
                ((HashMap)object2).put(object, object3);
                return (int)(((zzh)object3).zza() ? 1 : 0) != 0;
            }
            Handler handler = this.zzc;
            handler.removeMessages(0, object);
            int n10 = ((zzh)object3).zza((ServiceConnection)object2);
            if (n10 != 0) {
                object = String.valueOf(object);
                string2 = String.valueOf(object);
                int n11 = string2.length() + 81;
                object3 = new StringBuilder(n11);
                string2 = "Trying to bind a GmsServiceConnection that was already connected before.  config=";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            ((zzh)object3).zza((ServiceConnection)object2, (ServiceConnection)object2, string2);
            int n12 = ((zzh)object3).zzb();
            n10 = 1;
            if (n12 != n10) {
                int n13 = 2;
                if (n12 != n13) return (int)(((zzh)object3).zza() ? 1 : 0) != 0;
                ((zzh)object3).zza(string2);
                return (int)(((zzh)object3).zza() ? 1 : 0) != 0;
            }
            object = ((zzh)object3).zze();
            string2 = ((zzh)object3).zzd();
            object2.onServiceConnected((ComponentName)object, (IBinder)string2);
            return (int)(((zzh)object3).zza() ? 1 : 0) != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzb(GmsClientSupervisor$zza object, ServiceConnection object2, String string2) {
        Preconditions.checkNotNull(object2, "ServiceConnection must not be null");
        HashMap hashMap = this.zza;
        synchronized (hashMap) {
            Object object3 = this.zza;
            object3 = ((HashMap)object3).get(object);
            object3 = (zzh)object3;
            if (object3 == null) {
                object = String.valueOf(object);
                string2 = String.valueOf(object);
                int n10 = string2.length() + 50;
                object3 = new StringBuilder(n10);
                string2 = "Nonexistent connection status for service config: ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            boolean bl2 = ((zzh)object3).zza((ServiceConnection)object2);
            if (!bl2) {
                object = String.valueOf(object);
                string2 = String.valueOf(object);
                int n11 = string2.length() + 76;
                object3 = new StringBuilder(n11);
                string2 = "Trying to unbind a GmsServiceConnection  that was not bound before.  config=";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            ((zzh)object3).zza((ServiceConnection)object2, string2);
            boolean bl3 = ((zzh)object3).zzc();
            if (bl3) {
                object2 = this.zzc;
                boolean bl4 = false;
                string2 = null;
                object = object2.obtainMessage(0, object);
                object2 = this.zzc;
                long l10 = this.zze;
                object2.sendMessageDelayed((Message)object, l10);
            }
            return;
        }
    }
}

