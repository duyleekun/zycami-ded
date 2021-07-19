/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$zza;
import com.google.android.gms.ads.identifier.zza;
import com.google.android.gms.ads.identifier.zzb;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private final Context mContext;
    private BlockingServiceConnection zze;
    private zze zzf;
    private boolean zzg;
    private final Object zzh;
    private AdvertisingIdClient$zza zzi;
    private final boolean zzj;
    private final long zzk;

    public AdvertisingIdClient(Context context) {
        this(context, 30000L, false, false);
    }

    private AdvertisingIdClient(Context context, long l10, boolean bl2, boolean bl3) {
        Context context2;
        Object object;
        this.zzh = object = new Object();
        Preconditions.checkNotNull(context);
        if (bl2 && (context2 = context.getApplicationContext()) != null) {
            context = context2;
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = l10;
        this.zzj = bl3;
    }

    public static AdvertisingIdClient$Info getAdvertisingIdInfo(Context object) {
        long l10;
        long l11;
        Object object2 = new zzb((Context)object);
        String string2 = "gads:ad_id_app_context:enabled";
        boolean bl2 = ((zzb)object2).getBoolean(string2, false);
        float f10 = ((zzb)object2).getFloat("gads:ad_id_app_context:ping_ratio", 0.0f);
        String string3 = ((zzb)object2).getString("gads:ad_id_use_shared_preference:experiment_id", "");
        boolean bl3 = ((zzb)object2).getBoolean("gads:ad_id_use_persistent_service:enabled", false);
        long l12 = -1;
        object2 = new AdvertisingIdClient((Context)object, l12, bl2, bl3);
        try {
            l11 = SystemClock.elapsedRealtime();
        }
        catch (Throwable throwable) {
            l10 = -1;
            try {
                super.zza(null, bl2, f10, l10, string3, throwable);
                throw throwable;
            }
            catch (Throwable throwable2) {
                ((AdvertisingIdClient)object2).finish();
                throw throwable2;
            }
        }
        super.zza(false);
        object = ((AdvertisingIdClient)object2).getInfo();
        l12 = SystemClock.elapsedRealtime();
        l10 = l12 - l11;
        super.zza((AdvertisingIdClient$Info)object, bl2, f10, l10, string3, null);
        ((AdvertisingIdClient)object2).finish();
        return object;
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        Object object = new zzb(context);
        boolean bl2 = ((zzb)object).getBoolean("gads:ad_id_app_context:enabled", false);
        String string2 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
        boolean bl3 = ((zzb)object).getBoolean(string2, false);
        long l10 = -1;
        object = new AdvertisingIdClient(context, l10, bl2, bl3);
        try {
            super.zza(false);
            boolean bl4 = super.zzb();
            return bl4;
        }
        finally {
            ((AdvertisingIdClient)object).finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean bl2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static BlockingServiceConnection zza(Context object, boolean bl2) {
        int n10;
        String string2;
        Object object2;
        try {
            object2 = object.getPackageManager();
            string2 = "com.android.vending";
            n10 = 0;
            object2.getPackageInfo(string2, 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = new GooglePlayServicesNotAvailableException(9);
            throw object;
        }
        object2 = GoogleApiAvailabilityLight.getInstance();
        int n11 = 12451000;
        int n12 = ((GoogleApiAvailabilityLight)object2).isGooglePlayServicesAvailable((Context)object, n11);
        if (n12 != 0 && n12 != (n11 = 2)) {
            object = new IOException("Google Play services not available");
            throw object;
        }
        Object object3 = bl2 ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
        object2 = new BlockingServiceConnection();
        string2 = new Intent((String)object3);
        object3 = "com.google.android.gms";
        string2.setPackage((String)object3);
        try {
            object3 = ConnectionTracker.getInstance();
            n10 = 1;
            boolean bl3 = ((ConnectionTracker)object3).bindService((Context)object, (Intent)string2, (ServiceConnection)object2, n10);
            if (bl3) {
                return object2;
            }
            object = new IOException("Connection failure");
            throw object;
        }
        catch (Throwable throwable) {
            object3 = new IOException(throwable);
            throw object3;
        }
    }

    private static zze zza(Context object, BlockingServiceConnection object2) {
        long l10 = 10000L;
        object = TimeUnit.MILLISECONDS;
        object = ((BlockingServiceConnection)object2).getServiceWithTimeout(l10, (TimeUnit)((Object)object));
        try {
            return com.google.android.gms.internal.ads_identifier.zzf.zza((IBinder)object);
        }
        catch (Throwable throwable) {
            object2 = new IOException(throwable);
            throw object2;
        }
        catch (InterruptedException interruptedException) {
            object = new IOException("Interrupted exception");
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zza() {
        Object object = this.zzh;
        synchronized (object) {
            long l10;
            long l11;
            long l12;
            long l13;
            Object object2 = this.zzi;
            if (object2 != null) {
                object2 = ((AdvertisingIdClient$zza)object2).zzo;
                ((CountDownLatch)object2).countDown();
                try {
                    object2 = this.zzi;
                    ((Thread)object2).join();
                }
                catch (InterruptedException interruptedException) {}
            }
            if ((l13 = (l12 = (l11 = this.zzk) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                long l14 = this.zzk;
                this.zzi = object2 = new AdvertisingIdClient$zza(this, l14);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zza(boolean bl2) {
        Object object = "Calling this from your main thread can lead to deadlock";
        Preconditions.checkNotMainThread((String)object);
        synchronized (this) {
            boolean bl3 = this.zzg;
            if (bl3) {
                this.finish();
            }
            object = this.mContext;
            boolean bl4 = this.zzj;
            this.zze = object = AdvertisingIdClient.zza((Context)object, bl4);
            Context context = this.mContext;
            this.zzf = object = AdvertisingIdClient.zza(context, (BlockingServiceConnection)object);
            this.zzg = bl3 = true;
            if (bl2) {
                this.zza();
            }
            return;
        }
    }

    private final boolean zza(AdvertisingIdClient$Info object, boolean bl2, float f10, long l10, String string2, Throwable throwable) {
        int n10;
        double d10;
        double d11 = Math.random();
        double d12 = d11 - (d10 = (double)f10);
        Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object2 > 0) {
            return false;
        }
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        String string3 = "1";
        String string4 = "0";
        String string5 = bl2 ? string3 : string4;
        String string6 = "app_context";
        hashMap.put(string6, string5);
        if (object != null) {
            bl2 = ((AdvertisingIdClient$Info)object).isLimitAdTrackingEnabled();
            if (!bl2) {
                string3 = string4;
            }
            string5 = "limit_ad_tracking";
            hashMap.put(string5, string3);
        }
        if (object != null && (string5 = ((AdvertisingIdClient$Info)object).getId()) != null) {
            n10 = ((AdvertisingIdClient$Info)object).getId().length();
            object = Integer.toString(n10);
            string5 = "ad_id_size";
            hashMap.put(string5, object);
        }
        if (throwable != null) {
            object = throwable.getClass().getName();
            string5 = "error";
            hashMap.put(string5, object);
        }
        if (string2 != null && (n10 = string2.isEmpty()) == 0) {
            object = "experiment_id";
            hashMap.put(object, string2);
        }
        hashMap.put("tag", "AdvertisingIdClient");
        object = Long.toString(l10);
        hashMap.put("time_spent", object);
        object = new zza(this, hashMap);
        ((Thread)object).start();
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean zzb() {
        boolean bl2;
        Object object = "Calling this from your main thread can lead to deadlock";
        Preconditions.checkNotMainThread((String)object);
        synchronized (this) {
            Object object2;
            block14: {
                bl2 = this.zzg;
                if (!bl2) {
                    object = this.zzh;
                    synchronized (object) {
                        boolean bl3;
                        object2 = this.zzi;
                        if (object2 != null && (bl3 = ((AdvertisingIdClient$zza)object2).zzp)) {
                            // MONITOREXIT @DISABLED, blocks:[8, 9, 12, 13] lbl10 : MonitorExitStatement: MONITOREXIT : var1_1
                            bl2 = false;
                            object = null;
                            try {
                                this.zza(false);
                                bl2 = this.zzg;
                                if (bl2) break block14;
                                object2 = "AdvertisingIdClient cannot reconnect.";
                                object = new IOException((String)object2);
                                throw object;
                            }
                            catch (Exception exception) {
                                String string2 = "AdvertisingIdClient cannot reconnect.";
                                object2 = new IOException(string2, exception);
                                throw object2;
                            }
                        }
                        String string3 = "AdvertisingIdClient is not connected.";
                        object2 = new IOException(string3);
                        throw object2;
                    }
                }
            }
            object = this.zze;
            Preconditions.checkNotNull(object);
            object = this.zzf;
            Preconditions.checkNotNull(object);
            try {
                object = this.zzf;
                bl2 = object.zzc();
            }
            catch (RemoteException remoteException) {
                object2 = "AdvertisingIdClient";
                String string4 = "GMS remote exception ";
                Log.i((String)object2, (String)string4, (Throwable)remoteException);
                object2 = "Remote exception";
                IOException iOException = new IOException((String)object2);
                throw iOException;
            }
        }
        this.zza();
        return bl2;
    }

    public void finalize() {
        this.finish();
        super.finalize();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void finish() {
        Object object = "Calling this from your main thread can lead to deadlock";
        Preconditions.checkNotMainThread((String)object);
        synchronized (this) {
            object = this.mContext;
            if (object != null && (object = this.zze) != null) {
                boolean bl2;
                try {
                    bl2 = this.zzg;
                    if (bl2) {
                        object = ConnectionTracker.getInstance();
                        Context context = this.mContext;
                        BlockingServiceConnection blockingServiceConnection = this.zze;
                        ((ConnectionTracker)object).unbindService(context, blockingServiceConnection);
                    }
                }
                catch (Throwable throwable) {
                    String string2 = "AdvertisingIdClient";
                    String string3 = "AdvertisingIdClient unbindService failed.";
                    Log.i((String)string2, (String)string3, (Throwable)throwable);
                }
                bl2 = false;
                object = null;
                this.zzg = false;
                bl2 = false;
                object = null;
                this.zzf = null;
                this.zze = null;
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AdvertisingIdClient$Info getInfo() {
        Object object = "Calling this from your main thread can lead to deadlock";
        Preconditions.checkNotMainThread((String)object);
        synchronized (this) {
            Object object2;
            block14: {
                boolean bl2 = this.zzg;
                if (!bl2) {
                    object = this.zzh;
                    synchronized (object) {
                        boolean bl3;
                        object2 = this.zzi;
                        if (object2 != null && (bl3 = ((AdvertisingIdClient$zza)object2).zzp)) {
                            // MONITOREXIT @DISABLED, blocks:[8, 9, 12, 13] lbl10 : MonitorExitStatement: MONITOREXIT : var1_1
                            bl2 = false;
                            object = null;
                            try {
                                this.zza(false);
                                bl2 = this.zzg;
                                if (bl2) break block14;
                                object2 = "AdvertisingIdClient cannot reconnect.";
                                object = new IOException((String)object2);
                                throw object;
                            }
                            catch (Exception exception) {
                                String string2 = "AdvertisingIdClient cannot reconnect.";
                                object2 = new IOException(string2, exception);
                                throw object2;
                            }
                        }
                        String string3 = "AdvertisingIdClient is not connected.";
                        object2 = new IOException(string3);
                        throw object2;
                    }
                }
            }
            object = this.zze;
            Preconditions.checkNotNull(object);
            object = this.zzf;
            Preconditions.checkNotNull(object);
            try {
                object2 = this.zzf;
                object2 = object2.getId();
                zze zze2 = this.zzf;
                boolean bl4 = true;
                boolean bl5 = zze2.zzb(bl4);
                object = new AdvertisingIdClient$Info((String)object2, bl5);
                // MONITOREXIT @DISABLED, blocks:[6, 8] lbl40 : MonitorExitStatement: MONITOREXIT : this
                this.zza();
                return object;
            }
            catch (RemoteException remoteException) {
                object2 = "AdvertisingIdClient";
                String string4 = "GMS remote exception ";
                Log.i((String)object2, (String)string4, (Throwable)remoteException);
                object2 = "Remote exception";
                IOException iOException = new IOException((String)object2);
                throw iOException;
            }
        }
    }

    public void start() {
        this.zza(true);
    }
}

