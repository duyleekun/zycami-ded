/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.PendingResultUtil$ResultConverter;
import com.google.android.gms.common.internal.PendingResultUtil$zaa;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

public final class zaj
implements PendingResult$StatusListener {
    private final /* synthetic */ PendingResult zaov;
    private final /* synthetic */ TaskCompletionSource zaow;
    private final /* synthetic */ PendingResultUtil$ResultConverter zaox;
    private final /* synthetic */ PendingResultUtil$zaa zaoy;

    public zaj(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil$ResultConverter pendingResultUtil$ResultConverter, PendingResultUtil$zaa pendingResultUtil$zaa) {
        this.zaov = pendingResult;
        this.zaow = taskCompletionSource;
        this.zaox = pendingResultUtil$ResultConverter;
        this.zaoy = pendingResultUtil$zaa;
    }

    public final void onComplete(Status object) {
        boolean bl2 = ((Status)object).isSuccess();
        if (bl2) {
            object = this.zaov;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            object = ((PendingResult)object).await(0L, timeUnit);
            TaskCompletionSource taskCompletionSource = this.zaow;
            object = this.zaox.convert((Result)object);
            taskCompletionSource.setResult(object);
            return;
        }
        TaskCompletionSource taskCompletionSource = this.zaow;
        object = this.zaoy.zaf((Status)object);
        taskCompletionSource.setException((Exception)object);
    }
}

