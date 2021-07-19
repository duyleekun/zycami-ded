/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzds;
import com.google.android.gms.measurement.internal.zzdt;
import com.google.android.gms.measurement.internal.zzdu;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzz;

public final class zzdv {
    private static final Object zzf;
    private final String zza;
    private final zzdt zzb;
    private final Object zzc;
    private final Object zzd;
    private final Object zze;
    private volatile Object zzg;
    private volatile Object zzh;

    static {
        Object object;
        zzf = object = new Object();
    }

    public /* synthetic */ zzdv(String string2, Object object, Object object2, zzdt zzdt2, zzds object3) {
        this.zze = object3 = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zza = string2;
        this.zzc = object;
        this.zzd = object2;
        this.zzb = zzdt2;
    }

    public final String zza() {
        return this.zza;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzb(Object var1_1) {
        var2_2 = this.zze;
        ** synchronized (var2_2)
lbl3:
        // 1 sources

        if (var1_1 != null) {
            return var1_1;
        }
        var1_1 = zzdu.zza;
        if (var1_1 == null) {
            return this.zzc;
        }
        var1_1 = zzdv.zzf;
        synchronized (var1_1) {
            var3_3 = zzz.zza();
            if (var3_3) {
                var2_2 = this.zzh;
                if (var2_2 != null) return this.zzh;
                return this.zzc;
            }
        }
        try {
            var1_1 = zzdw.zzc();
            var1_1 = var1_1.iterator();
        }
        catch (SecurityException v0) {
            ** GOTO lbl37
        }
        while (true) {
            block24: {
                if (var3_3 = var1_1.hasNext()) {
                    var2_2 = var1_1.next();
                    var2_2 = (zzdv)var2_2;
                    var4_4 = zzz.zza();
                    if (!var4_4) {
                        var4_4 = false;
                        var5_5 = null;
                        var6_6 = var2_2.zzb;
                        if (var6_6 != null) {
                            var5_5 = var6_6.zza();
                        }
                        break block24;
                    }
                    var2_2 = "Refreshing flag cache must be done on a worker thread.";
                    var1_1 = new IllegalStateException((String)var2_2);
                    throw var1_1;
                }
lbl37:
                // 3 sources

                if ((var1_1 = this.zzb) == null) {
                    return this.zzc;
                }
                try {
                    return var1_1.zza();
                }
                catch (IllegalStateException v1) {
                    return this.zzc;
                }
                catch (SecurityException v2) {
                    return this.zzc;
                }
                catch (IllegalStateException v3) {}
            }
            var6_6 = zzdv.zzf;
            synchronized (var6_6) {
                var2_2.zzh = var5_5;
            }
        }
    }
}

