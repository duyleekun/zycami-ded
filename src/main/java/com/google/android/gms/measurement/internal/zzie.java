/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;
import java.util.concurrent.atomic.AtomicReference;

public final class zzie
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzp zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzjb zzd;

    public zzie(zzjb zzjb2, AtomicReference atomicReference, zzp zzp2, boolean bl2) {
        this.zzd = zzjb2;
        this.zza = atomicReference;
        this.zzb = zzp2;
        this.zzc = bl2;
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
            block10: {
                var2_2 = this.zzd;
                var2_2 = zzjb.zzM((zzjb)var2_2);
                if (var2_2 == null) {
                    var2_2 = this.zzd;
                    var2_2 = var2_2.zzx;
                    var2_2 = var2_2.zzat();
                    var2_2 = var2_2.zzb();
                    var3_5 = "Failed to get all user properties; not connected to service";
                    var2_2.zza(var3_5);
                    var2_2 = this.zza;
                    var2_2.notify();
                }
                ** GOTO lbl-1000
                {
                    catch (Throwable var2_3) {
                        break block10;
                    }
                    catch (RemoteException var2_4) {}
                    {
                        var3_7 = this.zzd;
                        var3_7 = var3_7.zzx;
                        var3_7 = var3_7.zzat();
                        var3_7 = var3_7.zzb();
                        var4_10 = "Failed to get all user properties; remote exception";
                        var3_7.zzb(var4_10, (Object)var2_4);
                        var2_2 = this.zza;
                        ** GOTO lbl40
                    }
                }
                return;
lbl-1000:
                // 1 sources

                {
                    var3_6 = this.zzb;
                    Preconditions.checkNotNull(var3_6);
                    var3_6 = this.zza;
                    var4_9 = this.zzb;
                    var5_11 = this.zzc;
                    var2_2 = var2_2.zzi(var4_9, var5_11);
                    var3_6.set(var2_2);
                    var2_2 = this.zzd;
                    zzjb.zzN((zzjb)var2_2);
                    var2_2 = this.zza;
lbl40:
                    // 2 sources

                    var2_2.notify();
                }
                return;
            }
            var3_8 = this.zza;
            var3_8.notify();
            throw var2_3;
        }
    }
}

