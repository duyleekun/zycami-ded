/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.Utils;
import java.util.concurrent.CountDownLatch;

public final class Utils$$Lambda$1
implements Continuation {
    private final CountDownLatch arg$1;

    private Utils$$Lambda$1(CountDownLatch countDownLatch) {
        this.arg$1 = countDownLatch;
    }

    public static Continuation lambdaFactory$(CountDownLatch countDownLatch) {
        Utils$$Lambda$1 utils$$Lambda$1 = new Utils$$Lambda$1(countDownLatch);
        return utils$$Lambda$1;
    }

    public Object then(Task task) {
        return Utils.lambda$awaitEvenIfOnMainThread$0(this.arg$1, task);
    }
}

