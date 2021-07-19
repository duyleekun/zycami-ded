/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.Utils$2;

public class Utils$2$1
implements Continuation {
    public final /* synthetic */ Utils$2 this$0;

    public Utils$2$1(Utils$2 utils$2) {
        this.this$0 = utils$2;
    }

    public Void then(Task object) {
        boolean bl2 = ((Task)object).isSuccessful();
        if (bl2) {
            TaskCompletionSource taskCompletionSource = this.this$0.val$tcs;
            object = ((Task)object).getResult();
            taskCompletionSource.setResult(object);
        } else {
            TaskCompletionSource taskCompletionSource = this.this$0.val$tcs;
            object = ((Task)object).getException();
            taskCompletionSource.setException((Exception)object);
        }
        return null;
    }
}

