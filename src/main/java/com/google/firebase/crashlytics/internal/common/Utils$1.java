/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class Utils$1
implements Continuation {
    public final /* synthetic */ TaskCompletionSource val$result;

    public Utils$1(TaskCompletionSource taskCompletionSource) {
        this.val$result = taskCompletionSource;
    }

    public Void then(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            TaskCompletionSource taskCompletionSource = this.val$result;
            object = ((Task)object).getResult();
            taskCompletionSource.trySetResult(object);
        } else {
            TaskCompletionSource taskCompletionSource = this.val$result;
            object = ((Task)object).getException();
            taskCompletionSource.trySetException((Exception)object);
        }
        return null;
    }
}

