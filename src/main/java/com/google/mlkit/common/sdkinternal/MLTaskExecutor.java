/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.google.mlkit.common.sdkinternal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_common.zzao;
import com.google.android.gms.internal.mlkit_common.zzb;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor$zza;
import com.google.mlkit.common.sdkinternal.zzf;
import com.google.mlkit.common.sdkinternal.zzg;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class MLTaskExecutor {
    private static final Object zza;
    private static MLTaskExecutor zzb;
    private Handler zzc;

    static {
        Object object;
        zza = object = new Object();
    }

    private MLTaskExecutor(Looper looper) {
        zzb zzb2 = new zzb(looper);
        this.zzc = zzb2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MLTaskExecutor getInstance() {
        Object object = zza;
        synchronized (object) {
            MLTaskExecutor mLTaskExecutor = zzb;
            if (mLTaskExecutor != null) return zzb;
            Object object2 = "MLHandler";
            int n10 = 9;
            mLTaskExecutor = new HandlerThread((String)object2, n10);
            mLTaskExecutor.start();
            mLTaskExecutor = mLTaskExecutor.getLooper();
            zzb = object2 = new MLTaskExecutor((Looper)mLTaskExecutor);
            return zzb;
        }
    }

    public static Executor workerThreadExecutor() {
        return MLTaskExecutor$zza.zza;
    }

    public static /* synthetic */ Handler zza(MLTaskExecutor mLTaskExecutor) {
        return mLTaskExecutor.zzc;
    }

    public static final /* synthetic */ void zza(Callable callable, TaskCompletionSource taskCompletionSource) {
        try {
            callable = callable.call();
            taskCompletionSource.setResult(callable);
            return;
        }
        catch (Exception exception) {
            MlKitException mlKitException = new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, exception);
            taskCompletionSource.setException(mlKitException);
            return;
        }
        catch (MlKitException mlKitException) {
            taskCompletionSource.setException(mlKitException);
            return;
        }
    }

    public Handler getHandler() {
        return this.zzc;
    }

    public Task scheduleCallable(Callable callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzg zzg2 = new zzg(callable, taskCompletionSource);
        this.scheduleRunnable(zzg2);
        return taskCompletionSource.getTask();
    }

    public void scheduleRunnable(Runnable runnable) {
        MLTaskExecutor.workerThreadExecutor().execute(runnable);
    }

    public void scheduleRunnableDelayed(Runnable runnable, long l10) {
        this.zzc.postDelayed(runnable, l10);
    }

    public Task scheduleTaskCallable(Callable object) {
        object = this.scheduleCallable((Callable)object);
        Executor executor = zzao.zza();
        Continuation continuation = zzf.zza;
        return ((Task)object).continueWithTask(executor, continuation);
    }
}

