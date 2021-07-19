/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzff;
import com.google.android.gms.measurement.internal.zzfg;
import com.google.android.gms.measurement.internal.zzfh;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgg;
import java.util.AbstractCollection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfi
extends zzgf {
    private static final AtomicLong zzj;
    private zzfh zza;
    private zzfh zzb;
    private final PriorityBlockingQueue zzc;
    private final BlockingQueue zzd;
    private final Thread.UncaughtExceptionHandler zze;
    private final Thread.UncaughtExceptionHandler zzf;
    private final Object zzg;
    private final Semaphore zzh;
    private volatile boolean zzi;

    static {
        AtomicLong atomicLong;
        zzj = atomicLong = new AtomicLong(Long.MIN_VALUE);
    }

    public zzfi(zzfl object) {
        super((zzfl)object);
        this.zzg = object = new Object();
        this.zzh = object = new Semaphore(2);
        object = new PriorityBlockingQueue();
        this.zzc = object;
        super();
        this.zzd = object;
        this.zze = object = new zzff(this, "Thread death: Uncaught exception on worker thread");
        this.zzf = object = new zzff(this, "Thread death: Uncaught exception on network thread");
    }

    public static /* synthetic */ Semaphore zzl(zzfi zzfi2) {
        return zzfi2.zzh;
    }

    public static /* synthetic */ boolean zzm(zzfi zzfi2) {
        return false;
    }

    public static /* synthetic */ Object zzn(zzfi zzfi2) {
        return zzfi2.zzg;
    }

    public static /* synthetic */ zzfh zzo(zzfi zzfi2) {
        return zzfi2.zza;
    }

    public static /* synthetic */ zzfh zzp(zzfi zzfi2, zzfh zzfh2) {
        zzfi2.zza = null;
        return null;
    }

    public static /* synthetic */ zzfh zzq(zzfi zzfi2) {
        return zzfi2.zzb;
    }

    public static /* synthetic */ zzfh zzr(zzfi zzfi2, zzfh zzfh2) {
        zzfi2.zzb = null;
        return null;
    }

    public static /* synthetic */ AtomicLong zzs() {
        return zzj;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zzt(zzfg runnable) {
        Object object = this.zzg;
        synchronized (object) {
            Object object2 = this.zzc;
            ((PriorityBlockingQueue)object2).add(runnable);
            runnable = this.zza;
            if (runnable == null) {
                object2 = "Measurement Worker";
                PriorityBlockingQueue priorityBlockingQueue = this.zzc;
                runnable = new zzfh(this, (String)object2, priorityBlockingQueue);
                this.zza = runnable;
                object2 = this.zze;
                ((Thread)runnable).setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object2);
                runnable = this.zza;
                ((Thread)runnable).start();
            } else {
                ((zzfh)runnable).zza();
            }
            return;
        }
    }

    public final boolean zza() {
        return false;
    }

    public final void zzav() {
        zzfh zzfh2;
        Object object = Thread.currentThread();
        if (object == (zzfh2 = this.zzb)) {
            return;
        }
        object = new IllegalStateException("Call expected from network thread");
        throw object;
    }

    public final boolean zzd() {
        zzfh zzfh2;
        Thread thread = Thread.currentThread();
        return thread == (zzfh2 = this.zza);
    }

    public final Future zze(Callable object) {
        this.zzv();
        Preconditions.checkNotNull(object);
        String string2 = "Task exception on worker thread";
        zzfg zzfg2 = new zzfg(this, (Callable)object, false, string2);
        object = Thread.currentThread();
        Object object2 = this.zza;
        if (object == object2) {
            object = this.zzc;
            boolean bl2 = ((AbstractCollection)object).isEmpty();
            if (!bl2) {
                object = this.zzx.zzat().zze();
                object2 = "Callable skipped the worker queue.";
                ((zzeg)object).zza((String)object2);
            }
            zzfg2.run();
        } else {
            this.zzt(zzfg2);
        }
        return zzfg2;
    }

    public final Future zzf(Callable object) {
        this.zzv();
        Preconditions.checkNotNull(object);
        boolean bl2 = true;
        String string2 = "Task exception on worker thread";
        zzfg zzfg2 = new zzfg(this, (Callable)object, bl2, string2);
        object = Thread.currentThread();
        zzfh zzfh2 = this.zza;
        if (object == zzfh2) {
            zzfg2.run();
        } else {
            this.zzt(zzfg2);
        }
        return zzfg2;
    }

    public final void zzg() {
        zzfh zzfh2;
        Object object = Thread.currentThread();
        if (object == (zzfh2 = this.zza)) {
            return;
        }
        object = new IllegalStateException("Call expected from worker thread");
        throw object;
    }

    public final void zzh(Runnable runnable) {
        this.zzv();
        Preconditions.checkNotNull(runnable);
        zzfg zzfg2 = new zzfg(this, runnable, false, "Task exception on worker thread");
        this.zzt(zzfg2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object zzi(AtomicReference atomicReference, long l10, String string2, Runnable runnable) {
        synchronized (atomicReference) {
            zzgg zzgg2 = this.zzx;
            zzgg2 = ((zzfl)zzgg2).zzau();
            ((zzfi)zzgg2).zzh(runnable);
            try {
                atomicReference.wait(l10);
                // MONITOREXIT @DISABLED, blocks:[1, 3] lbl7 : MonitorExitStatement: MONITOREXIT : var1_1 /* !! */ 
                atomicReference = atomicReference.get();
                if (atomicReference == null) {
                    zzeg zzeg2 = this.zzx.zzat().zze();
                    String string3 = "Timed out waiting for ";
                    int n10 = string2.length();
                    string3 = n10 != 0 ? string3.concat(string2) : (string2 = new String(string3));
                    zzeg2.zza(string3);
                }
                return atomicReference;
            }
            catch (InterruptedException interruptedException) {
                Object object = this.zzx;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zze();
                String string4 = "Interrupted waiting for ";
                int n11 = string2.length();
                string4 = n11 != 0 ? string4.concat(string2) : (string2 = new String(string4));
                ((zzeg)object).zza(string4);
                return null;
            }
        }
    }

    public final void zzj(Runnable runnable) {
        this.zzv();
        Preconditions.checkNotNull(runnable);
        zzfg zzfg2 = new zzfg(this, runnable, true, "Task exception on worker thread");
        this.zzt(zzfg2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzk(Runnable object) {
        this.zzv();
        Preconditions.checkNotNull(object);
        Object object2 = "Task exception on network thread";
        BlockingQueue blockingQueue = null;
        Runnable runnable = new zzfg(this, (Runnable)object, false, (String)object2);
        object = this.zzg;
        synchronized (object) {
            object2 = this.zzd;
            object2.add(runnable);
            runnable = this.zzb;
            if (runnable == null) {
                object2 = "Measurement Network";
                blockingQueue = this.zzd;
                runnable = new zzfh(this, (String)object2, blockingQueue);
                this.zzb = runnable;
                object2 = this.zzf;
                ((Thread)runnable).setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object2);
                runnable = this.zzb;
                ((Thread)runnable).start();
            } else {
                ((zzfh)runnable).zza();
            }
            return;
        }
    }
}

