/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Tasks$zza;
import com.google.android.gms.tasks.zzu;
import java.util.concurrent.ExecutionException;

public final class Tasks$zzc
implements Tasks$zza {
    private final Object zza;
    private final int zzb;
    private final zzu zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private Exception zzg;
    private boolean zzh;

    public Tasks$zzc(int n10, zzu zzu2) {
        Object object;
        this.zza = object = new Object();
        this.zzb = n10;
        this.zzc = zzu2;
    }

    private final void zza() {
        int n10 = this.zzd;
        int n11 = this.zze;
        n10 += n11;
        n11 = this.zzf;
        if ((n10 += n11) == (n11 = this.zzb)) {
            Object object = this.zzg;
            if (object != null) {
                object = this.zzc;
                int n12 = this.zze;
                int n13 = this.zzb;
                StringBuilder stringBuilder = new StringBuilder(54);
                stringBuilder.append(n12);
                stringBuilder.append(" out of ");
                stringBuilder.append(n13);
                stringBuilder.append(" underlying tasks failed");
                String string2 = stringBuilder.toString();
                Exception exception = this.zzg;
                ExecutionException executionException = new ExecutionException(string2, exception);
                ((zzu)object).zza(executionException);
                return;
            }
            n10 = (int)(this.zzh ? 1 : 0);
            if (n10 != 0) {
                this.zzc.zza();
                return;
            }
            object = this.zzc;
            n11 = 0;
            Object var4_5 = null;
            ((zzu)object).zza((Object)null);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onCanceled() {
        Object object = this.zza;
        synchronized (object) {
            int n10 = this.zzf;
            int n11 = 1;
            this.zzf = n10 += n11;
            this.zzh = n11;
            this.zza();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onFailure(Exception exception) {
        Object object = this.zza;
        synchronized (object) {
            int n10;
            this.zze = n10 = this.zze + 1;
            this.zzg = exception;
            this.zza();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onSuccess(Object object) {
        object = this.zza;
        synchronized (object) {
            int n10;
            this.zzd = n10 = this.zzd + 1;
            this.zza();
            return;
        }
    }
}

