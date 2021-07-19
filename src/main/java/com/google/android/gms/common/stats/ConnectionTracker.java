/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.util.Log
 */
package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.stats.zza;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionTracker {
    private static final Object zza;
    private static volatile ConnectionTracker zzb;
    private static boolean zzc = false;
    private static zzo zzd;
    private ConcurrentHashMap zze;

    static {
        Object object;
        zza = object = new Object();
        zzd = zzn.zza(com.google.android.gms.common.stats.zza.zza);
    }

    private ConnectionTracker() {
        ConcurrentHashMap concurrentHashMap;
        this.zze = concurrentHashMap = new ConcurrentHashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ConnectionTracker getInstance() {
        Object object = zzb;
        if (object != null) return zzb;
        object = zza;
        synchronized (object) {
            ConnectionTracker connectionTracker = zzb;
            if (connectionTracker != null) return zzb;
            zzb = connectionTracker = new ConnectionTracker();
            return zzb;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void zza(Context context, ServiceConnection serviceConnection) {
        void var0_3;
        try {
            context.unbindService(serviceConnection);
            return;
        }
        catch (IllegalStateException illegalStateException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
            // empty catch block
        }
        Log.w((String)"ConnectionTracker", (String)"Exception thrown while unbinding", (Throwable)var0_3);
    }

    public static final /* synthetic */ boolean zza() {
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean zza(Context context, String object, Intent intent, ServiceConnection serviceConnection, int n10, boolean bl2) {
        boolean bl3;
        block6: {
            block7: {
                void var6_10;
                ServiceConnection serviceConnection2 = intent.getComponent();
                int n11 = 0;
                String string2 = null;
                if (serviceConnection2 == null) {
                    boolean bl4 = false;
                    serviceConnection2 = null;
                } else {
                    serviceConnection2 = serviceConnection2.getPackageName();
                    boolean bl5 = ClientLibraryUtils.zza(context, (String)serviceConnection2);
                }
                String string3 = "ConnectionTracker";
                if (var6_10 != false) {
                    Log.w((String)string3, (String)"Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
                boolean bl6 = ConnectionTracker.zza(serviceConnection);
                if (!bl6) break block7;
                serviceConnection2 = this.zze.putIfAbsent(serviceConnection, serviceConnection);
                if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
                    int n12 = 3;
                    serviceConnection2 = new Object[n12];
                    serviceConnection2[0] = serviceConnection;
                    n11 = 1;
                    serviceConnection2[n11] = object;
                    int n13 = 2;
                    string2 = intent.getAction();
                    serviceConnection2[n13] = string2;
                    object = String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", (Object[])serviceConnection2);
                    Log.w((String)string3, (String)object);
                }
                try {
                    bl3 = context.bindService(intent, serviceConnection, n10);
                    if (bl3) break block6;
                    object = this.zze;
                    ((ConcurrentHashMap)object).remove(serviceConnection, serviceConnection);
                }
                catch (Throwable throwable) {
                    this.zze.remove(serviceConnection, serviceConnection);
                    throw throwable;
                }
                break block6;
            }
            bl3 = context.bindService(intent, serviceConnection, n10);
        }
        return bl3;
    }

    private static boolean zza(ServiceConnection serviceConnection) {
        boolean bl2;
        Boolean bl3 = (Boolean)zzd.zza();
        boolean bl4 = bl3;
        return bl4 && !(bl2 = serviceConnection instanceof zzj);
    }

    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int n10) {
        String string2 = context.getClass().getName();
        return this.zza(context, string2, intent, serviceConnection, n10);
    }

    public void unbindService(Context context, ServiceConnection serviceConnection) {
        ConcurrentHashMap concurrentHashMap;
        boolean bl2 = ConnectionTracker.zza(serviceConnection);
        if (bl2 && (bl2 = (concurrentHashMap = this.zze).containsKey(serviceConnection))) {
            try {
                concurrentHashMap = this.zze;
                concurrentHashMap = concurrentHashMap.get(serviceConnection);
                concurrentHashMap = (ServiceConnection)concurrentHashMap;
                ConnectionTracker.zza(context, (ServiceConnection)concurrentHashMap);
                return;
            }
            finally {
                this.zze.remove(serviceConnection);
            }
        }
        ConnectionTracker.zza(context, serviceConnection);
    }

    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            this.unbindService(context, serviceConnection);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            Log.w((String)"ConnectionTracker", (String)"Exception thrown while unbinding", (Throwable)illegalArgumentException);
            return;
        }
    }

    public final boolean zza(Context context, String string2, Intent intent, ServiceConnection serviceConnection, int n10) {
        return this.zza(context, string2, intent, serviceConnection, n10, true);
    }
}

