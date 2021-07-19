/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils$2$1;
import java.util.concurrent.Callable;

public class Utils$2
implements Runnable {
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ TaskCompletionSource val$tcs;

    public Utils$2(Callable callable, TaskCompletionSource taskCompletionSource) {
        this.val$callable = callable;
        this.val$tcs = taskCompletionSource;
    }

    public void run() {
        Object object = this.val$callable;
        object = object.call();
        object = (Task)object;
        Object object2 = new Utils$2$1(this);
        try {
            ((Task)object).continueWith((Continuation)object2);
        }
        catch (Exception exception) {
            object2 = this.val$tcs;
            ((TaskCompletionSource)object2).setException(exception);
        }
    }
}

