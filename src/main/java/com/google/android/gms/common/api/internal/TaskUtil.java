/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zacl;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class TaskUtil {
    public static void setResultOrApiException(Status status, TaskCompletionSource taskCompletionSource) {
        TaskUtil.setResultOrApiException(status, null, taskCompletionSource);
    }

    public static void setResultOrApiException(Status status, Object object, TaskCompletionSource taskCompletionSource) {
        boolean bl2 = status.isSuccess();
        if (bl2) {
            taskCompletionSource.setResult(object);
            return;
        }
        object = new ApiException(status);
        taskCompletionSource.setException((Exception)object);
    }

    public static Task toVoidTaskThatFailsOnFalse(Task task) {
        zacl zacl2 = new zacl();
        return task.continueWith(zacl2);
    }
}

