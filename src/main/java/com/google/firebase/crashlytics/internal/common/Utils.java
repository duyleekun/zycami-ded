/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.Utils$$Lambda$1;
import com.google.firebase.crashlytics.internal.common.Utils$1;
import com.google.firebase.crashlytics.internal.common.Utils$2;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static Object awaitEvenIfOnMainThread(Task object) {
        int n10 = 1;
        Object object2 = new CountDownLatch(n10);
        ExecutorService executorService = TASK_CONTINUATION_EXECUTOR_SERVICE;
        Continuation continuation = Utils$$Lambda$1.lambdaFactory$((CountDownLatch)object2);
        ((Task)object).continueWith(executorService, continuation);
        executorService = Looper.getMainLooper();
        continuation = Looper.myLooper();
        if (executorService == continuation) {
            long l10 = 4;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            ((CountDownLatch)object2).await(l10, timeUnit);
        } else {
            ((CountDownLatch)object2).await();
        }
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            return ((Task)object).getResult();
        }
        bl2 = ((Task)object).isCanceled();
        if (!bl2) {
            bl2 = ((Task)object).isComplete();
            if (bl2) {
                object = ((Task)object).getException();
                object2 = new IllegalStateException((Throwable)object);
                throw object2;
            }
            object = new TimeoutException();
            throw object;
        }
        object = new CancellationException("Task is already canceled");
        throw object;
    }

    public static Task callTask(Executor executor, Callable callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Utils$2 utils$2 = new Utils$2(callable, taskCompletionSource);
        executor.execute(utils$2);
        return taskCompletionSource.getTask();
    }

    public static /* synthetic */ Object lambda$awaitEvenIfOnMainThread$0(CountDownLatch countDownLatch, Task task) {
        countDownLatch.countDown();
        return null;
    }

    public static Task race(Task task, Task task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Utils$1 utils$1 = new Utils$1(taskCompletionSource);
        task.continueWith(utils$1);
        task2.continueWith(utils$1);
        return taskCompletionSource.getTask();
    }
}

