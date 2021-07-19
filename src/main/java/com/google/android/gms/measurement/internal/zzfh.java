/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzfg;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzge;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public final class zzfh
extends Thread {
    public final /* synthetic */ zzfi zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    private boolean zzd = false;

    public zzfh(zzfi object, String string2, BlockingQueue blockingQueue) {
        this.zza = object;
        Preconditions.checkNotNull(string2);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = object = new Object();
        this.zzc = blockingQueue;
        this.setName(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zzb() {
        Object object = zzfi.zzn(this.zza);
        synchronized (object) {
            boolean bl2 = this.zzd;
            if (!bl2) {
                Object object2 = this.zza;
                object2 = zzfi.zzl((zzfi)object2);
                ((Semaphore)object2).release();
                object2 = this.zza;
                object2 = zzfi.zzn((zzfi)object2);
                object2.notifyAll();
                object2 = this.zza;
                object2 = zzfi.zzo((zzfi)object2);
                String string2 = null;
                if (this == object2) {
                    object2 = this.zza;
                    zzfi.zzp((zzfi)object2, null);
                } else {
                    object2 = this.zza;
                    if (this == (object2 = zzfi.zzq((zzfi)object2))) {
                        object2 = this.zza;
                        zzfi.zzr((zzfi)object2, null);
                    } else {
                        object2 = this.zza;
                        object2 = ((zzge)object2).zzx;
                        object2 = ((zzfl)object2).zzat();
                        object2 = ((zzei)object2).zzb();
                        string2 = "Current scheduler thread is neither worker nor network";
                        ((zzeg)object2).zza(string2);
                    }
                }
                this.zzd = bl2 = true;
            }
            return;
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        zzeg zzeg2 = this.zza.zzx.zzat().zze();
        String string2 = String.valueOf(this.getName()).concat(" was interrupted");
        zzeg2.zzb(string2, interruptedException);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void run() {
        var1_1 = 1;
        var2_2 = 0;
        var3_3 = null;
        while (var2_2 == 0) {
            try {
                var4_4 = this.zza;
                var4_4 = zzfi.zzl((zzfi)var4_4);
                var4_4.acquire();
                var2_2 = var1_1;
            }
            catch (InterruptedException var4_5) {
                this.zzc(var4_5);
            }
        }
        try {
            var2_2 = Process.myTid();
            var2_2 = Process.getThreadPriority((int)var2_2);
            while (true) lbl-1000:
            // 3 sources

            {
                var4_4 = this.zzc;
                var4_4 = var4_4.poll();
                if ((var4_4 = (zzfg)var4_4) != null) {
                    var5_6 = var4_4.zza;
                    var5_6 = var1_1 != var5_6 ? 10 : var2_2;
                    Process.setThreadPriority((int)var5_6);
                    var4_4.run();
                    continue;
                }
                var4_4 = this.zzb;
                // MONITORENTER : var4_4
                var6_7 = this.zzc;
                break;
            }
        }
        catch (Throwable var9_11) {
            this.zzb();
            throw var9_11;
        }
        {
            var6_7 = var6_7.peek();
            if (var6_7 == null) {
                var6_7 = this.zza;
                zzfi.zzm((zzfi)var6_7);
                try {
                    var6_7 = this.zzb;
                    var7_9 = 30000L;
                    var6_7.wait(var7_9);
                }
                catch (InterruptedException var6_8) {
                    this.zzc(var6_8);
                }
            }
            // MONITOREXIT : var4_4
            var4_4 = this.zza;
            var4_4 = zzfi.zzn((zzfi)var4_4);
            // MONITORENTER : var4_4
            var6_7 = this.zzc;
            var6_7 = var6_7.peek();
            if (var6_7 == null) {
                var9_10 = this.zza;
                var9_10 = var9_10.zzx;
                var9_10 = var9_10.zzc();
                var3_3 = zzdw.zzap;
                var5_6 = 0;
                var6_7 = null;
                var1_1 = (int)var9_10.zzn(null, var3_3);
                if (var1_1 != 0) {
                    this.zzb();
                }
                // MONITOREXIT : var4_4
                this.zzb();
                return;
            }
            // MONITOREXIT : var4_4
            ** while (true)
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza() {
        Object object = this.zzb;
        synchronized (object) {
            Object object2 = this.zzb;
            object2.notifyAll();
            return;
        }
    }
}

