/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import java.util.ArrayList;
import java.util.List;

public final class zzit
implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzp zzc;
    public final /* synthetic */ zzs zzd;
    public final /* synthetic */ zzjb zze;

    public zzit(zzjb zzjb2, String string2, String string3, zzp zzp2, zzs zzs2) {
        this.zze = zzjb2;
        this.zza = string2;
        this.zzb = string3;
        this.zzc = zzp2;
        this.zzd = zzs2;
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
            var1_1 = new ArrayList();
            var2_2 = this.zze;
            var2_2 = zzjb.zzM((zzjb)var2_2);
            if (var2_2 == null) {
                var2_2 = this.zze;
                var2_2 = var2_2.zzx;
                var2_2 = var2_2.zzat();
                var2_2 = var2_2.zzb();
                var3_5 = "Failed to get conditional properties; not connected to service";
                var4_7 = this.zza;
                var5_11 = this.zzb;
                var2_2.zzc((String)var3_5, var4_7, var5_11);
                var2_2 = this.zze.zzx;
            }
            ** GOTO lbl-1000
            {
                catch (Throwable var2_3) {
                    break block7;
                }
                catch (RemoteException var2_4) {}
                {
                    var3_5 = this.zze;
                    var3_5 = var3_5.zzx;
                    var3_5 = var3_5.zzat();
                    var3_5 = var3_5.zzb();
                    var4_9 = "Failed to get conditional properties; remote exception";
                    var5_13 = this.zza;
                    var6_14 = this.zzb;
                    var3_5.zzd(var4_9, var5_13, var6_14, (Object)var2_4);
                    var2_2 = this.zze.zzx;
                }
            }
lbl29:
            // 3 sources

            while (true) {
                var2_2 = var2_2.zzl();
                var3_5 = this.zzd;
                var2_2.zzaj((zzs)var3_5, var1_1);
                return;
            }
lbl-1000:
            // 1 sources

            {
                var3_5 = this.zzc;
                Preconditions.checkNotNull(var3_5);
                var3_5 = this.zza;
                var4_8 = this.zzb;
                var5_12 = this.zzc;
                var2_2 = var2_2.zzq((String)var3_5, var4_8, var5_12);
                var1_1 = zzkk.zzak((List)var2_2);
                var2_2 = this.zze;
                zzjb.zzN((zzjb)var2_2);
                var2_2 = this.zze.zzx;
                ** continue;
            }
        }
        var3_6 = this.zze.zzx.zzl();
        var4_10 = this.zzd;
        var3_6.zzaj(var4_10, var1_1);
        throw var2_3;
    }
}

