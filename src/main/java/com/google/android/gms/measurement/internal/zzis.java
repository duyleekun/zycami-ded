/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjb;
import com.google.android.gms.measurement.internal.zzp;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

public final class zzis
implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzp zzd;
    public final /* synthetic */ zzjb zze;

    public zzis(zzjb zzjb2, AtomicReference atomicReference, String string2, String string3, String string4, zzp zzp2) {
        this.zze = zzjb2;
        this.zza = atomicReference;
        this.zzb = string3;
        this.zzc = string4;
        this.zzd = zzp2;
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
            block12: {
                var2_2 = null;
                var3_4 = this.zze;
                var3_4 = zzjb.zzM((zzjb)var3_4);
                if (var3_4 == null) {
                    var3_4 = this.zze;
                    var3_4 = var3_4.zzx;
                    var3_4 = var3_4.zzat();
                    var3_4 = var3_4.zzb();
                    var4_7 = "(legacy) Failed to get conditional properties; not connected to service";
                    var5_11 = this.zzb;
                    var6_15 = this.zzc;
                    var3_4.zzd((String)var4_7, null, var5_11, var6_15);
                    var3_4 = this.zza;
                    var4_7 = Collections.emptyList();
                    var3_4.set(var4_7);
                    var2_2 = this.zza;
                    var2_2.notify();
                }
                ** GOTO lbl-1000
                {
                    catch (Throwable var2_3) {
                        break block12;
                    }
                    catch (RemoteException var3_5) {}
                    {
                        var4_10 = this.zze;
                        var4_10 = var4_10.zzx;
                        var4_10 = var4_10.zzat();
                        var4_10 = var4_10.zzb();
                        var5_14 = "(legacy) Failed to get conditional properties; remote exception";
                        var6_18 = this.zzb;
                        var4_10.zzd(var5_14, null, var6_18, (Object)var3_5);
                        var2_2 = this.zza;
                        var3_6 = Collections.emptyList();
                        var2_2.set(var3_6);
                        var2_2 = this.zza;
                        ** GOTO lbl59
                    }
                }
                return;
lbl-1000:
                // 1 sources

                {
                    var7_19 = TextUtils.isEmpty(null);
                    if (var7_19) {
                        var4_8 = this.zzd;
                        Preconditions.checkNotNull(var4_8);
                        var4_8 = this.zza;
                        var5_12 = this.zzb;
                        var6_16 = this.zzc;
                        var8_20 = this.zzd;
                        var3_4 = var3_4.zzq(var5_12, var6_16, var8_20);
                        var4_8.set(var3_4);
                    } else {
                        var4_9 = this.zza;
                        var5_13 = this.zzb;
                        var6_17 = this.zzc;
                        var3_4 = var3_4.zzr(null, var5_13, var6_17);
                        var4_9.set(var3_4);
                    }
                    var3_4 = this.zze;
                    zzjb.zzN((zzjb)var3_4);
                    var2_2 = this.zza;
lbl59:
                    // 2 sources

                    var2_2.notify();
                }
                return;
            }
            var3_4 = this.zza;
            var3_4.notify();
            throw var2_3;
        }
    }
}

