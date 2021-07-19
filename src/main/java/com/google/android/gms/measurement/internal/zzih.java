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
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;

public final class zzih
implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzs zzb;
    public final /* synthetic */ zzjb zzc;

    public zzih(zzjb zzjb2, zzp zzp2, zzs zzs2) {
        this.zzc = zzjb2;
        this.zza = zzp2;
        this.zzb = zzs2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        block10: {
            var1_1 = "Failed to get app instance id";
            var2_3 = null;
            zzlc.zzb();
            var3_4 = this.zzc;
            var3_4 = var3_4.zzx;
            var3_4 = var3_4.zzc();
            var4_6 = zzdw.zzaw;
            var5_7 = var3_4.zzn(null, (zzdv)var4_6);
            if (var5_7) {
                var3_4 = this.zzc;
                var3_4 = var3_4.zzx;
                var3_4 = var3_4.zzd();
                var5_7 = (var3_4 = var3_4.zzi()).zzh();
                if (!var5_7) {
                    var3_4 = this.zzc;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzat();
                    var3_4 = var3_4.zzh();
                    var4_6 = "Analytics storage consent denied; will not get app instance id";
                    var3_4.zza((String)var4_6);
                    var3_4 = this.zzc;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzk();
                    var3_4.zzE(null);
                    var3_4 = this.zzc;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzd();
                    var3_4 = var3_4.zzj;
                    var3_4.zzb(null);
                    var1_1 = this.zzc.zzx;
                }
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var1_2) {
                    break block10;
                }
                catch (RemoteException var3_5) {}
                {
                    var4_6 = this.zzc;
                    var4_6 = var4_6.zzx;
                    var4_6 = var4_6.zzat();
                    var4_6 = var4_6.zzb();
                    var4_6.zzb((String)var1_1, (Object)var3_5);
                    var1_1 = this.zzc.zzx;
                }
            }
lbl45:
            // 4 sources

            while (true) {
                var1_1 = var1_1.zzl();
                var3_4 = this.zzb;
                var1_1.zzad((zzs)var3_4, var2_3);
                return;
            }
lbl-1000:
            // 1 sources

            {
                var3_4 = this.zzc;
                if ((var3_4 = zzjb.zzM((zzjb)var3_4)) != null) ** GOTO lbl-1000
                var3_4 = this.zzc;
                var3_4 = var3_4.zzx;
                var3_4 = var3_4.zzat();
                var3_4 = var3_4.zzb();
                var3_4.zza((String)var1_1);
                var1_1 = this.zzc.zzx;
                ** GOTO lbl45
            }
lbl-1000:
            // 1 sources

            {
                var4_6 = this.zza;
                Preconditions.checkNotNull(var4_6);
                var4_6 = this.zza;
                var2_3 = var3_4.zzl((zzp)var4_6);
                if (var2_3 != null) {
                    var3_4 = this.zzc;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzk();
                    var3_4.zzE(var2_3);
                    var3_4 = this.zzc;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzd();
                    var3_4 = var3_4.zzj;
                    var3_4.zzb(var2_3);
                }
                var3_4 = this.zzc;
                zzjb.zzN((zzjb)var3_4);
                var1_1 = this.zzc.zzx;
                ** continue;
            }
        }
        var3_4 = this.zzc.zzx.zzl();
        var4_6 = this.zzb;
        var3_4.zzad((zzs)var4_6, var2_3);
        throw var1_2;
    }
}

