/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;
import java.util.concurrent.atomic.AtomicReference;

public final class zzig
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ zzjb zzc;

    public zzig(zzjb zzjb2, AtomicReference atomicReference, zzp zzp2) {
        this.zzc = zzjb2;
        this.zza = atomicReference;
        this.zzb = zzp2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        var1_1 = this.zza;
        synchronized (var1_1) {
            block14: {
                zzlc.zzb();
                var2_2 = this.zzc;
                var2_2 = var2_2.zzx;
                var2_2 = var2_2.zzc();
                var3_5 = zzdw.zzaw;
                var4_6 = null;
                var5_7 = var2_2.zzn(null, (zzdv)var3_5);
                if (var5_7) {
                    var2_2 = this.zzc;
                    var2_2 = var2_2.zzx;
                    var2_2 = var2_2.zzd();
                    var5_7 = (var2_2 = var2_2.zzi()).zzh();
                    if (!var5_7) {
                        var2_2 = this.zzc;
                        var2_2 = var2_2.zzx;
                        var2_2 = var2_2.zzat();
                        var2_2 = var2_2.zzh();
                        var3_5 = "Analytics storage consent denied; will not get app instance id";
                        var2_2.zza((String)var3_5);
                        var2_2 = this.zzc;
                        var2_2 = var2_2.zzx;
                        var2_2 = var2_2.zzk();
                        var2_2.zzE(null);
                        var2_2 = this.zzc;
                        var2_2 = var2_2.zzx;
                        var2_2 = var2_2.zzd();
                        var2_2 = var2_2.zzj;
                        var2_2.zzb(null);
                        var2_2 = this.zza;
                        var2_2.set(null);
                        var2_2 = this.zza;
                        var2_2.notify();
                    }
                }
                ** GOTO lbl-1000
                {
                    catch (Throwable var2_3) {
                        break block14;
                    }
                    catch (RemoteException var2_4) {}
                    {
                        var3_5 = this.zzc;
                        var3_5 = var3_5.zzx;
                        var3_5 = var3_5.zzat();
                        var3_5 = var3_5.zzb();
                        var4_6 = "Failed to get app instance id";
                        var3_5.zzb((String)var4_6, (Object)var2_4);
                        var2_2 = this.zza;
                        ** GOTO lbl86
                    }
                }
                return;
lbl-1000:
                // 1 sources

                {
                    var2_2 = this.zzc;
                    if ((var2_2 = zzjb.zzM((zzjb)var2_2)) != null) ** GOTO lbl-1000
                    var2_2 = this.zzc;
                    var2_2 = var2_2.zzx;
                    var2_2 = var2_2.zzat();
                    var2_2 = var2_2.zzb();
                    var3_5 = "Failed to get app instance id";
                    var2_2.zza((String)var3_5);
                    var2_2 = this.zza;
                    var2_2.notify();
                }
                return;
lbl-1000:
                // 1 sources

                {
                    var3_5 = this.zzb;
                    Preconditions.checkNotNull(var3_5);
                    var3_5 = this.zza;
                    var4_6 = this.zzb;
                    var2_2 = var2_2.zzl((zzp)var4_6);
                    var3_5.set(var2_2);
                    var2_2 = this.zza;
                    var2_2 = var2_2.get();
                    var2_2 = (String)var2_2;
                    if (var2_2 != null) {
                        var3_5 = this.zzc;
                        var3_5 = var3_5.zzx;
                        var3_5 = var3_5.zzk();
                        var3_5.zzE((String)var2_2);
                        var3_5 = this.zzc;
                        var3_5 = var3_5.zzx;
                        var3_5 = var3_5.zzd();
                        var3_5 = var3_5.zzj;
                        var3_5.zzb((String)var2_2);
                    }
                    var2_2 = this.zzc;
                    zzjb.zzN((zzjb)var2_2);
                    var2_2 = this.zza;
lbl86:
                    // 2 sources

                    var2_2.notify();
                }
                return;
            }
            var3_5 = this.zza;
            var3_5.notify();
            throw var2_3;
        }
    }
}

