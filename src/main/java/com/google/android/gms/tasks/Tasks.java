/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.Tasks$zza;
import com.google.android.gms.tasks.Tasks$zzb;
import com.google.android.gms.tasks.Tasks$zzc;
import com.google.android.gms.tasks.zzaa;
import com.google.android.gms.tasks.zzu;
import com.google.android.gms.tasks.zzy;
import com.google.android.gms.tasks.zzz;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static Object await(Task task) {
        Preconditions.checkNotMainThread();
        Object object = "Task must not be null";
        Preconditions.checkNotNull(task, object);
        boolean bl2 = task.isComplete();
        if (bl2) {
            return Tasks.zza(task);
        }
        object = new Tasks$zzb(null);
        Tasks.zza(task, (Tasks$zza)object);
        ((Tasks$zzb)object).zza();
        return Tasks.zza(task);
    }

    public static Object await(Task object, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(object, "Task must not be null");
        Object object2 = "TimeUnit must not be null";
        Preconditions.checkNotNull((Object)timeUnit, object2);
        boolean bl2 = ((Task)object).isComplete();
        if (bl2) {
            return Tasks.zza((Task)object);
        }
        object2 = new Tasks$zzb(null);
        Tasks.zza((Task)object, (Tasks$zza)object2);
        boolean bl3 = ((Tasks$zzb)object2).zza(l10, timeUnit);
        if (bl3) {
            return Tasks.zza((Task)object);
        }
        object = new TimeoutException("Timed out waiting for Task");
        throw object;
    }

    public static Task call(Callable callable) {
        return Tasks.call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static Task call(Executor executor, Callable callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu2 = new zzu();
        zzy zzy2 = new zzy(zzu2, callable);
        executor.execute(zzy2);
        return zzu2;
    }

    public static Task forCanceled() {
        zzu zzu2 = new zzu();
        zzu2.zza();
        return zzu2;
    }

    public static Task forException(Exception exception) {
        zzu zzu2 = new zzu();
        zzu2.zza(exception);
        return zzu2;
    }

    public static Task forResult(Object object) {
        zzu zzu2 = new zzu();
        zzu2.zza(object);
        return zzu2;
    }

    public static Task whenAll(Collection object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            Object object2;
            Object object3;
            boolean bl3;
            Object object4 = object.iterator();
            while (bl3 = object4.hasNext()) {
                object3 = (Task)object4.next();
                object2 = "null tasks are not accepted";
                Objects.requireNonNull(object3, (String)object2);
            }
            object4 = new zzu();
            int n10 = object.size();
            object3 = new Tasks$zzc(n10, (zzu)object4);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (Task)object.next();
                Tasks.zza((Task)object2, (Tasks$zza)object3);
            }
            return object4;
        }
        return Tasks.forResult(null);
    }

    public static Task whenAll(Task ... taskArray) {
        int n10;
        if (taskArray != null && (n10 = taskArray.length) != 0) {
            return Tasks.whenAll(Arrays.asList(taskArray));
        }
        return Tasks.forResult(null);
    }

    public static Task whenAllComplete(Collection collection) {
        boolean bl2;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            Task task = Tasks.whenAll(collection);
            zzz zzz2 = new zzz(collection);
            return task.continueWithTask(zzz2);
        }
        return Tasks.forResult(Collections.emptyList());
    }

    public static Task whenAllComplete(Task ... taskArray) {
        int n10;
        if (taskArray != null && (n10 = taskArray.length) != 0) {
            return Tasks.whenAllComplete(Arrays.asList(taskArray));
        }
        return Tasks.forResult(Collections.emptyList());
    }

    public static Task whenAllSuccess(Collection collection) {
        boolean bl2;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            Task task = Tasks.whenAll(collection);
            zzaa zzaa2 = new zzaa(collection);
            return task.continueWith(zzaa2);
        }
        return Tasks.forResult(Collections.emptyList());
    }

    public static Task whenAllSuccess(Task ... taskArray) {
        int n10;
        if (taskArray != null && (n10 = taskArray.length) != 0) {
            return Tasks.whenAllSuccess(Arrays.asList(taskArray));
        }
        return Tasks.forResult(Collections.emptyList());
    }

    private static Object zza(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            return ((Task)object).getResult();
        }
        bl2 = ((Task)object).isCanceled();
        if (bl2) {
            object = new CancellationException("Task is already canceled");
            throw object;
        }
        object = ((Task)object).getException();
        ExecutionException executionException = new ExecutionException((Throwable)object);
        throw executionException;
    }

    private static void zza(Task task, Tasks$zza tasks$zza) {
        Executor executor = TaskExecutors.zza;
        task.addOnSuccessListener(executor, (OnSuccessListener)tasks$zza);
        task.addOnFailureListener(executor, (OnFailureListener)tasks$zza);
        task.addOnCanceledListener(executor, (OnCanceledListener)tasks$zza);
    }
}

