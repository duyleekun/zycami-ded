/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzjb;

public final class zzim
implements Runnable {
    public final /* synthetic */ zzas zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzs zzc;
    public final /* synthetic */ zzjb zzd;

    public zzim(zzjb zzjb2, zzas zzas2, String string2, zzs zzs2) {
        this.zzd = zzjb2;
        this.zza = zzas2;
        this.zzb = string2;
        this.zzc = zzs2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        block7: {
            var1_1 = null;
            var2_2 = this.zzd;
            var2_2 = zzjb.zzM((zzjb)var2_2);
            if (var2_2 == null) {
                var2_2 = this.zzd;
                var2_2 = var2_2.zzx;
                var2_2 = var2_2.zzat();
                var2_2 = var2_2.zzb();
                var3_5 = "Discarding data. Failed to send event to service to bundle";
                var2_2.zza((String)var3_5);
                var2_2 = this.zzd.zzx;
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var2_3) {
                    break block7;
                }
                catch (RemoteException var2_4) {}
                {
                    var3_5 = this.zzd;
                    var3_5 = var3_5.zzx;
                    var3_5 = var3_5.zzat();
                    var3_5 = var3_5.zzb();
                    var4_8 = "Failed to send event to the service to bundle";
                    var3_5.zzb(var4_8, (Object)var2_4);
                    var2_2 = this.zzd.zzx;
                }
            }
lbl25:
            // 3 sources

            while (true) {
                var2_2 = var2_2.zzl();
                var3_5 = this.zzc;
                var2_2.zzag((zzs)var3_5, var1_1);
                return;
            }
lbl-1000:
            // 1 sources

            {
                var3_5 = this.zza;
                var4_7 = this.zzb;
                var1_1 = var2_2.zzj((zzas)var3_5, var4_7);
                var2_2 = this.zzd;
                zzjb.zzN((zzjb)var2_2);
                var2_2 = this.zzd.zzx;
                ** continue;
            }
        }
        var3_6 = this.zzd.zzx.zzl();
        var4_9 = this.zzc;
        var3_6.zzag(var4_9, var1_1);
        throw var2_3;
    }
}

