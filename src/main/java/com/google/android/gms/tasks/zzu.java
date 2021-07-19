/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.DuplicateTaskCompletionException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzc;
import com.google.android.gms.tasks.zzd;
import com.google.android.gms.tasks.zzh;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzl;
import com.google.android.gms.tasks.zzm;
import com.google.android.gms.tasks.zzp;
import com.google.android.gms.tasks.zzq;
import com.google.android.gms.tasks.zzu$zza;
import com.google.android.gms.tasks.zzv;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class zzu
extends Task {
    private final Object zza;
    private final zzq zzb;
    private boolean zzc;
    private volatile boolean zzd;
    private Object zze;
    private Exception zzf;

    public zzu() {
        Object object;
        this.zza = object = new Object();
        this.zzb = object = new zzq();
    }

    private final void zzb() {
        Preconditions.checkState(this.zzc, "Task is not yet complete");
    }

    private final void zzc() {
        boolean bl2 = this.zzc;
        if (!bl2) {
            return;
        }
        throw DuplicateTaskCompletionException.of(this);
    }

    private final void zzd() {
        boolean bl2 = this.zzd;
        if (!bl2) {
            return;
        }
        CancellationException cancellationException = new CancellationException("Task is already canceled.");
        throw cancellationException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zze() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl2 = this.zzc;
            if (!bl2) {
                return;
            }
        }
        this.zzb.zza(this);
    }

    public final Task addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        Executor executor = zzv.zza(TaskExecutors.MAIN_THREAD);
        zzh zzh2 = new zzh(executor, onCanceledListener);
        this.zzb.zza(zzh2);
        zzu$zza.zza(activity).zza(zzh2);
        this.zze();
        return this;
    }

    public final Task addOnCanceledListener(OnCanceledListener onCanceledListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).addOnCanceledListener(executor, onCanceledListener);
    }

    public final Task addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzh zzh2 = new zzh(executor, onCanceledListener);
        zzq2.zza(zzh2);
        this.zze();
        return this;
    }

    public final Task addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener) {
        Executor executor = zzv.zza(TaskExecutors.MAIN_THREAD);
        zzi zzi2 = new zzi(executor, onCompleteListener);
        this.zzb.zza(zzi2);
        zzu$zza.zza(activity).zza(zzi2);
        this.zze();
        return this;
    }

    public final Task addOnCompleteListener(OnCompleteListener onCompleteListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).addOnCompleteListener(executor, onCompleteListener);
    }

    public final Task addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzi zzi2 = new zzi(executor, onCompleteListener);
        zzq2.zza(zzi2);
        this.zze();
        return this;
    }

    public final Task addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        Executor executor = zzv.zza(TaskExecutors.MAIN_THREAD);
        zzl zzl2 = new zzl(executor, onFailureListener);
        this.zzb.zza(zzl2);
        zzu$zza.zza(activity).zza(zzl2);
        this.zze();
        return this;
    }

    public final Task addOnFailureListener(OnFailureListener onFailureListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).addOnFailureListener(executor, onFailureListener);
    }

    public final Task addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzl zzl2 = new zzl(executor, onFailureListener);
        zzq2.zza(zzl2);
        this.zze();
        return this;
    }

    public final Task addOnSuccessListener(Activity activity, OnSuccessListener onSuccessListener) {
        Executor executor = zzv.zza(TaskExecutors.MAIN_THREAD);
        zzm zzm2 = new zzm(executor, onSuccessListener);
        this.zzb.zza(zzm2);
        zzu$zza.zza(activity).zza(zzm2);
        this.zze();
        return this;
    }

    public final Task addOnSuccessListener(OnSuccessListener onSuccessListener) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).addOnSuccessListener(executor, onSuccessListener);
    }

    public final Task addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzm zzm2 = new zzm(executor, onSuccessListener);
        zzq2.zza(zzm2);
        this.zze();
        return this;
    }

    public final Task continueWith(Continuation continuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).continueWith(executor, continuation);
    }

    public final Task continueWith(Executor executor, Continuation continuation) {
        zzu zzu2 = new zzu();
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzc zzc2 = new zzc(executor, continuation, zzu2);
        zzq2.zza(zzc2);
        this.zze();
        return zzu2;
    }

    public final Task continueWithTask(Continuation continuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).continueWithTask(executor, continuation);
    }

    public final Task continueWithTask(Executor executor, Continuation continuation) {
        zzu zzu2 = new zzu();
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzd zzd2 = new zzd(executor, continuation, zzu2);
        zzq2.zza(zzd2);
        this.zze();
        return zzu2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Exception getException() {
        Object object = this.zza;
        synchronized (object) {
            return this.zzf;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object getResult() {
        Object object = this.zza;
        synchronized (object) {
            this.zzb();
            this.zzd();
            Object object2 = this.zzf;
            if (object2 == null) {
                return this.zze;
            }
            Exception exception = this.zzf;
            object2 = new RuntimeExecutionException(exception);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object getResult(Class object) {
        Object object2 = this.zza;
        synchronized (object2) {
            this.zzb();
            this.zzd();
            Exception exception = this.zzf;
            boolean bl2 = ((Class)object).isInstance(exception);
            if (bl2) {
                exception = this.zzf;
                object = ((Class)object).cast(exception);
                object = (Throwable)object;
                throw object;
            }
            object = this.zzf;
            if (object == null) {
                return this.zze;
            }
            exception = this.zzf;
            object = new RuntimeExecutionException(exception);
            throw object;
        }
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean isComplete() {
        Object object = this.zza;
        synchronized (object) {
            return this.zzc;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean isSuccessful() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl2 = this.zzc;
            if (!bl2) return false;
            bl2 = this.zzd;
            if (bl2) return false;
            Exception exception = this.zzf;
            if (exception != null) return false;
            return true;
        }
    }

    public final Task onSuccessTask(SuccessContinuation successContinuation) {
        Executor executor = TaskExecutors.MAIN_THREAD;
        return ((Task)this).onSuccessTask(executor, successContinuation);
    }

    public final Task onSuccessTask(Executor executor, SuccessContinuation successContinuation) {
        zzu zzu2 = new zzu();
        zzq zzq2 = this.zzb;
        executor = zzv.zza(executor);
        zzp zzp2 = new zzp(executor, successContinuation, zzu2);
        zzq2.zza(zzp2);
        this.zze();
        return zzu2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Exception exception) {
        Preconditions.checkNotNull(exception, "Exception must not be null");
        Object object = this.zza;
        synchronized (object) {
            boolean bl2;
            this.zzc();
            this.zzc = bl2 = true;
            this.zzf = exception;
        }
        this.zzb.zza(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(Object object) {
        Object object2 = this.zza;
        synchronized (object2) {
            boolean bl2;
            this.zzc();
            this.zzc = bl2 = true;
            this.zze = object;
        }
        this.zzb.zza(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zza() {
        boolean bl2;
        Object object = this.zza;
        synchronized (object) {
            bl2 = this.zzc;
            if (bl2) {
                return false;
            }
            this.zzc = bl2 = true;
            this.zzd = bl2;
        }
        this.zzb.zza(this);
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zzb(Exception exception) {
        boolean bl2;
        Preconditions.checkNotNull(exception, "Exception must not be null");
        Object object = this.zza;
        synchronized (object) {
            bl2 = this.zzc;
            if (bl2) {
                return false;
            }
            this.zzc = bl2 = true;
            this.zzf = exception;
        }
        this.zzb.zza(this);
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zzb(Object object) {
        boolean bl2;
        Object object2 = this.zza;
        synchronized (object2) {
            bl2 = this.zzc;
            if (bl2) {
                return false;
            }
            this.zzc = bl2 = true;
            this.zze = object;
        }
        this.zzb.zza(this);
        return bl2;
    }
}

