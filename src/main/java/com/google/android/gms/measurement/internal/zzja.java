/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.measurement.internal.zzdx;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzee;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zziv;
import com.google.android.gms.measurement.internal.zziw;
import com.google.android.gms.measurement.internal.zzix;
import com.google.android.gms.measurement.internal.zziy;
import com.google.android.gms.measurement.internal.zziz;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzja
implements ServiceConnection,
BaseGmsClient$BaseConnectionCallbacks,
BaseGmsClient$BaseOnConnectionFailedListener {
    public final /* synthetic */ zzjb zza;
    private volatile boolean zzb;
    private volatile zzee zzc;

    public zzja(zzjb zzjb2) {
        this.zza = zzjb2;
    }

    public static /* synthetic */ boolean zzd(zzja zzja2, boolean bl2) {
        zzja2.zzb = false;
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void onConnected(Bundle object) {
        object = "MeasurementServiceConnection.onConnected";
        Preconditions.checkMainThread((String)object);
        // MONITORENTER : this
        object = this.zzc;
        Preconditions.checkNotNull(object);
        object = this.zzc;
        object = ((BaseGmsClient)object).getService();
        object = (zzdz)object;
        zzgg zzgg2 = this.zza;
        zzgg2 = ((zzge)zzgg2).zzx;
        zzgg2 = ((zzfl)zzgg2).zzau();
        zzix zzix2 = new zzix(this, (zzdz)object);
        ((zzfi)zzgg2).zzh(zzix2);
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (DeadObjectException | IllegalStateException throwable) {}
            object = null;
            {
                this.zzc = null;
                object = null;
                this.zzb = false;
                // MONITOREXIT : this
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onConnectionFailed(ConnectionResult object) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        Object object2 = this.zza.zzx.zzf();
        if (object2 != null) {
            object2 = ((zzei)object2).zze();
            String string2 = "Service connection failed";
            ((zzeg)object2).zzb(string2, object);
        }
        synchronized (this) {
            object = null;
            this.zzb = false;
            object = null;
            this.zzc = null;
        }
        object = this.zza.zzx.zzau();
        object2 = new zziz(this);
        ((zzfi)object).zzh((Runnable)object2);
    }

    public final void onConnectionSuspended(int n10) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzx.zzat().zzj().zza("Service connection suspended");
        zzfi zzfi2 = this.zza.zzx.zzau();
        zziy zziy2 = new zziy(this);
        zzfi2.zzh(zziy2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName var1_1, IBinder var2_3) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            block12: {
                var1_1 = null;
                if (var2_3 != null) ** GOTO lbl14
                this.zzb = false;
                var1_1 = this.zza;
                var1_1 = var1_1.zzx;
                var1_1 = var1_1.zzat();
                var1_1 = var1_1.zzb();
                var2_3 = "Service connected with null binder";
                var1_1.zza((String)var2_3);
                return;
lbl14:
                // 1 sources

                var3_4 = null;
                var4_5 = var2_3.getInterfaceDescriptor();
                var5_6 = "com.google.android.gms.measurement.internal.IMeasurementService";
                var6_7 = var5_6.equals(var4_5);
                if (!var6_7) ** GOTO lbl59
                var4_5 = "com.google.android.gms.measurement.internal.IMeasurementService";
                ** GOTO lbl45
                {
                    catch (Throwable var1_2) {
                        break block12;
                    }
                    catch (RemoteException v0) {}
                    {
                        block11: {
                            block13: {
                                var2_3 = this.zza;
                                var2_3 = var2_3.zzx;
                                var2_3 = var2_3.zzat();
                                var2_3 = var2_3.zzb();
                                var4_5 = "Service connect failed to get IMeasurementService";
                                var2_3.zza((String)var4_5);
lbl31:
                                // 3 sources

                                while (var3_4 == null) {
                                    this.zzb = false;
                                    try {
                                        var1_1 = ConnectionTracker.getInstance();
                                        var2_3 = this.zza;
                                        var2_3 = var2_3.zzx;
                                        var2_3 = var2_3.zzaw();
                                        var3_4 = this.zza;
                                        var3_4 = zzjb.zzI((zzjb)var3_4);
                                        var1_1.unbindService((Context)var2_3, (ServiceConnection)var3_4);
                                    }
                                    catch (IllegalArgumentException v1) {}
                                    break block11;
                                }
                                break block13;
lbl45:
                                // 1 sources

                                var6_7 = (var4_5 = var2_3.queryLocalInterface((String)var4_5)) instanceof zzdz;
                                if (!var6_7) ** GOTO lbl57
                                {
                                    var4_5 = (zzdz)var4_5;
lbl48:
                                    // 2 sources

                                    while (true) {
                                        var3_4 = var4_5;
                                        var2_3 = this.zza;
                                        var2_3 = var2_3.zzx;
                                        var2_3 = var2_3.zzat();
                                        var2_3 = var2_3.zzk();
                                        var4_5 = "Bound to IMeasurementService interface";
                                        var2_3.zza((String)var4_5);
                                        ** GOTO lbl31
                                        break;
                                    }
lbl57:
                                    // 1 sources

                                    var4_5 = new zzdx((IBinder)var2_3);
                                    ** continue;
lbl59:
                                    // 1 sources

                                    var2_3 = this.zza;
                                    var2_3 = var2_3.zzx;
                                    var2_3 = var2_3.zzat();
                                    var2_3 = var2_3.zzb();
                                    var5_6 = "Got binder with a wrong descriptor";
                                    var2_3.zzb(var5_6, var4_5);
                                    ** GOTO lbl31
                                }
                            }
                            var1_1 = this.zza;
                            var1_1 = var1_1.zzx;
                            var1_1 = var1_1.zzau();
                            var2_3 = new zziv(this, (zzdz)var3_4);
                            var1_1.zzh((Runnable)var2_3);
                        }
                        return;
                    }
                }
            }
            throw var1_2;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzx.zzat().zzj().zza("Service disconnected");
        zzfi zzfi2 = this.zza.zzx.zzau();
        zziw zziw2 = new zziw(this, componentName);
        zzfi2.zzh(zziw2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Intent object) {
        ((zzge)this.zza).zzg();
        Object object2 = this.zza.zzx.zzaw();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            boolean bl2 = this.zzb;
            if (bl2) {
                object = this.zza;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzk();
                object2 = "Connection attempt already in progress";
                ((zzeg)object).zza((String)object2);
                return;
            }
            Object object3 = this.zza;
            object3 = ((zzge)object3).zzx;
            object3 = ((zzfl)object3).zzat();
            object3 = ((zzei)object3).zzk();
            String string2 = "Using local app measurement service";
            ((zzeg)object3).zza(string2);
            this.zzb = bl2 = true;
            object3 = this.zza;
            object3 = zzjb.zzI((zzjb)object3);
            int n10 = 129;
            connectionTracker.bindService((Context)object2, (Intent)object, (ServiceConnection)object3, n10);
            return;
        }
    }

    public final void zzb() {
        boolean bl2;
        zzee zzee2 = this.zzc;
        if (zzee2 != null && ((bl2 = (zzee2 = this.zzc).isConnected()) || (bl2 = (zzee2 = this.zzc).isConnecting()))) {
            zzee2 = this.zzc;
            zzee2.disconnect();
        }
        this.zzc = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzc() {
        ((zzge)this.zza).zzg();
        Object object = this.zza.zzx.zzaw();
        synchronized (this) {
            boolean bl2;
            boolean bl3 = this.zzb;
            if (bl3) {
                object = this.zza;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzk();
                String string2 = "Connection attempt already in progress";
                ((zzeg)object).zza(string2);
                return;
            }
            Object object2 = this.zzc;
            if (object2 != null && ((bl3 = ((BaseGmsClient)(object2 = this.zzc)).isConnecting()) || (bl3 = ((BaseGmsClient)(object2 = this.zzc)).isConnected()))) {
                object = this.zza;
                object = ((zzge)object).zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzk();
                object2 = "Already awaiting connection attempt";
                ((zzeg)object).zza((String)object2);
                return;
            }
            Looper looper = Looper.getMainLooper();
            object2 = new zzee((Context)object, looper, this, this);
            this.zzc = object2;
            object = this.zza;
            object = ((zzge)object).zzx;
            object = ((zzfl)object).zzat();
            object = ((zzei)object).zzk();
            object2 = "Connecting to remote service";
            ((zzeg)object).zza((String)object2);
            this.zzb = bl2 = true;
            object = this.zzc;
            Preconditions.checkNotNull(object);
            object = this.zzc;
            ((BaseGmsClient)object).checkAvailabilityAndConnect();
            return;
        }
    }
}

